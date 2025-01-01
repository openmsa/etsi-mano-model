/**
 * Copyright (C) 2019-2025 Ubiqube.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */
package com.ubiqube.etsi.mano.v271.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.ubiqube.etsi.mano.controller.subscription.ApiAndType;
import com.ubiqube.etsi.mano.dao.mano.CancelModeTypeEnum;
import com.ubiqube.etsi.mano.dao.mano.GrantResponse;
import com.ubiqube.etsi.mano.dao.mano.NsdPackage;
import com.ubiqube.etsi.mano.dao.mano.ScaleTypeEnum;
import com.ubiqube.etsi.mano.dao.mano.VnfPackage;
import com.ubiqube.etsi.mano.dao.mano.nsd.upd.ChangeVnfFlavourData;
import com.ubiqube.etsi.mano.dao.mano.pm.PmJob;
import com.ubiqube.etsi.mano.dao.mano.pm.Threshold;
import com.ubiqube.etsi.mano.dao.mano.v2.VnfBlueprint;
import com.ubiqube.etsi.mano.dao.mano.vnfi.ChangeExtVnfConnRequest;
import com.ubiqube.etsi.mano.model.VnfHealRequest;
import com.ubiqube.etsi.mano.model.VnfInstantiate;
import com.ubiqube.etsi.mano.model.VnfOperateRequest;
import com.ubiqube.etsi.mano.model.VnfScaleToLevelRequest;
import com.ubiqube.etsi.mano.service.AbstractHttpGateway;
import com.ubiqube.etsi.mano.service.auth.model.ApiTypesEnum;
import com.ubiqube.etsi.mano.service.event.model.EventMessage;
import com.ubiqube.etsi.mano.service.event.model.Subscription;
import com.ubiqube.etsi.mano.utils.Version;
import com.ubiqube.etsi.mano.v271.model.em.vnffm.FmNotificationsFilter;
import com.ubiqube.etsi.mano.v271.model.em.vnffm.FmSubscription;
import com.ubiqube.etsi.mano.v271.model.em.vnfind.VnfIndicator;
import com.ubiqube.etsi.mano.v271.model.em.vnfind.VnfIndicatorNotificationsFilter;
import com.ubiqube.etsi.mano.v271.model.em.vnfind.VnfIndicatorSubscription;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.CreateVnfRequest;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.LifecycleChangeNotificationsFilter;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.ScaleVnfRequest;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.TerminateVnfRequest;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.TerminateVnfRequest.TerminationTypeEnum;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.VnfInstance;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.VnfLcmOpOcc;
import com.ubiqube.etsi.mano.v271.model.sol003.lcmgrant.Grant;
import com.ubiqube.etsi.mano.v271.model.sol003.lcmgrant.GrantRequest;
import com.ubiqube.etsi.mano.v271.model.sol003.lcmgrant.GrantRequestLinks;
import com.ubiqube.etsi.mano.v271.model.sol003.vnf.CreateVnfPkgInfoRequest;
import com.ubiqube.etsi.mano.v271.model.sol003.vnf.PkgmNotificationsFilter;
import com.ubiqube.etsi.mano.v271.model.sol003.vnf.PkgmSubscription;
import com.ubiqube.etsi.mano.v271.model.sol003.vnf.VnfPkgInfo;
import com.ubiqube.etsi.mano.v271.model.sol005.nsd.CreateNsdInfoRequest;
import com.ubiqube.etsi.mano.v271.model.sol005.nsd.NsdInfo;
import com.ubiqube.etsi.mano.v271.model.vnfm.vrqan.VrQuotaAvailNotificationsFilter;
import com.ubiqube.etsi.mano.v271.model.vnfm.vrqan.VrQuotaAvailSubscription;
import com.ubiqube.etsi.mano.v271.service.mapping.Grant271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.Nsd271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.PmJob271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.Threshold271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.VnfIndicator271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.VnfInstance271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.VnfLcmOpOcc271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.VnfPkgInfo271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.subscription.FmSubscription271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.subscription.LccnSubscription271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.subscription.PkgmSubscriptionRequest271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.subscription.VnfIndicatorSubscription271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.subscription.VrQuotaAvailSubscription271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.vnflcm.VnfInstanceRequest271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.vnflcm.VnfInstantiate271Mapping;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@Service
public class HttpGateway271 extends AbstractHttpGateway {
	private static final Logger LOG = LoggerFactory.getLogger(HttpGateway271.class);
	private final NfvoFactory nfvoFactory;
	private final VnfmFactory vnfmFactory;
	private final Grant271Mapping grantMapping;
	private final FmSubscription271Mapping fmSubscriptionMapping;
	private final LccnSubscription271Mapping lccnSubscriptionMapping;
	private final PkgmSubscriptionRequest271Mapping pkgmSubscriptionRequestMapping;
	private final PmJob271Mapping pmJobMapping;
	private final Threshold271Mapping thresholdMapping;
	private final VnfIndicator271Mapping vnfIndicatorMapping;
	private final VnfIndicatorSubscription271Mapping vnfIndicatorSubscriptionMapping;
	private final VnfInstanceRequest271Mapping vnfInstanceRequestMapping;
	private final VnfInstantiate271Mapping vnfInstantiateMapping;
	private final VnfInstance271Mapping vnfInstanceMapping;
	private final VrQuotaAvailSubscription271Mapping vrQuotaAvailSubscriptionMapping;
	private final Nsd271Mapping nsdMapping;
	private final VnfPkgInfo271Mapping vnfPkgInfoMapping;
	private final VnfLcmOpOcc271Mapping vnfLcmOpOccMapping;

	public HttpGateway271(final ObjectProvider<VnfmFactory> vnfmFactory, final ObjectProvider<NfvoFactory> nfvoFactory, final Grant271Mapping grantMapping, final FmSubscription271Mapping fmSubscriptionMapping, final LccnSubscription271Mapping lccnSubscriptionMapping, final PkgmSubscriptionRequest271Mapping pkgmSubscriptionRequestMapping, final PmJob271Mapping pmJobMapping, final Threshold271Mapping thresholdMapping, final VnfIndicator271Mapping vnfIndicatorMapping, final VnfIndicatorSubscription271Mapping vnfIndicatorSubscriptionMapping, final VnfInstanceRequest271Mapping vnfInstanceRequestMapping, final VnfInstantiate271Mapping vnfInstantiateMapping, final VnfInstance271Mapping vnfInstanceMapping, final VrQuotaAvailSubscription271Mapping vrQuotaAvailSubscriptionMapping, final Nsd271Mapping nsdMapping, final VnfPkgInfo271Mapping vnfPkgInfoMapping, final VnfLcmOpOcc271Mapping vnfLcmOpOccMapping) {
		this.nfvoFactory = nfvoFactory.getIfAvailable();
		this.vnfmFactory = vnfmFactory.getIfAvailable();
		this.grantMapping = grantMapping;
		this.fmSubscriptionMapping = fmSubscriptionMapping;
		this.lccnSubscriptionMapping = lccnSubscriptionMapping;
		this.pkgmSubscriptionRequestMapping = pkgmSubscriptionRequestMapping;
		this.pmJobMapping = pmJobMapping;
		this.thresholdMapping = thresholdMapping;
		this.vnfIndicatorMapping = vnfIndicatorMapping;
		this.vnfIndicatorSubscriptionMapping = vnfIndicatorSubscriptionMapping;
		this.vnfInstanceRequestMapping = vnfInstanceRequestMapping;
		this.vnfInstantiateMapping = vnfInstantiateMapping;
		this.vnfInstanceMapping = vnfInstanceMapping;
		this.vrQuotaAvailSubscriptionMapping = vrQuotaAvailSubscriptionMapping;
		this.nsdMapping = nsdMapping;
		this.vnfPkgInfoMapping = vnfPkgInfoMapping;
		this.vnfLcmOpOccMapping = vnfLcmOpOccMapping;
	}

	@Override
	public Class<?> getVnfPackageClass() {
		return VnfPkgInfo.class;
	}

	@Override
	public Class<?> getVnfPackageSubscriptionClass() {
		return PkgmSubscription.class;
	}

	@Override
	public Class<?> getVnfIndicatorValueChangeSubscriptionClass() {
		return VnfIndicatorSubscription.class;
	}

	@Override
	public Object getVnfIndicatorValueChangeSubscriptionRequest(final Subscription req) {
		return vnfIndicatorSubscriptionMapping.mapToRequest(req, VnfIndicatorNotificationsFilter.class);
	}

	@Override
	public Class<?> getGrantResponse() {
		return Grant.class;
	}

	@Override
	public void makeGrantLinks(final Object manoGrant) {
		if (manoGrant instanceof final GrantRequest grant) {
			vnfmFactory.makeGrantRequestLink(grant);
		}
	}

	@Override
	public Class<?> getVnfInstanceClass() {
		return VnfInstance.class;
	}

	@Override
	public ParameterizedTypeReference<List<Class<?>>> getVnfInstanceListParam() {
		final ParameterizedTypeReference<List<VnfInstance>> res = new ParameterizedTypeReference<>() {
			// Nothing.
		};
		return (ParameterizedTypeReference<List<Class<?>>>) (Object) res;
	}

	@Override
	public ParameterizedTypeReference<List<Class<?>>> getListVnfLcmOpOccs() {
		final ParameterizedTypeReference<List<VnfLcmOpOcc>> res = new ParameterizedTypeReference<>() {
			// Nothing.
		};
		return (ParameterizedTypeReference<List<Class<?>>>) (Object) res;
	}

	@Override
	public Object createVnfInstanceRequest(final String vnfdId, final String vnfInstanceName, final String vnfInstanceDescription) {
		final var req = new CreateVnfRequest();
		req.setVnfdId(vnfdId);
		req.setVnfInstanceDescription(vnfInstanceDescription);
		req.setVnfInstanceName(vnfInstanceName);
		return req;
	}

	@Override
	public Class<?> getVnfLcmOpOccsClass() {
		return VnfLcmOpOcc.class;
	}

	@Override
	public Object createVnfInstanceTerminate(final CancelModeTypeEnum terminationType, final Integer gracefulTerminationTimeout) {
		final TerminateVnfRequest ret = new TerminateVnfRequest();
		ret.setTerminationType(TerminationTypeEnum.fromValue(terminationType.toString()));
		ret.setGracefulTerminationTimeout(gracefulTerminationTimeout);
		return ret;
	}

	@Override
	public Object createVnfInstanceScaleRequest(final ScaleTypeEnum scaleType, final String aspectId, final Integer numberOfSteps) {
		final var req = new ScaleVnfRequest();
		req.setAspectId(aspectId);
		req.setNumberOfSteps(numberOfSteps);
		if (ScaleTypeEnum.IN.equals(scaleType)) {
			req.setType(ScaleVnfRequest.TypeEnum.IN);
		}
		if (ScaleTypeEnum.OUT.equals(scaleType)) {
			req.setType(ScaleVnfRequest.TypeEnum.OUT);
		}
		return req;
	}

	@Override
	public Object createEvent(final UUID subscriptionId, final EventMessage event) {
		return switch (event.getNotificationEvent()) {
		case VNF_PKG_ONCHANGE, VNF_PKG_ONDELETION -> nfvoFactory.createVnfPackageChangeNotification(subscriptionId, event);
		case VNF_PKG_ONBOARDING -> nfvoFactory.createNotificationVnfPackageOnboardingNotification(subscriptionId, event);
		case VNF_INDICATOR_VALUE_CHANGED -> vnfmFactory.createVnfIndicatorValueChangeNotification(subscriptionId, event);
		default -> {
			LOG.warn("Could not find event.");
			yield null;
		}
		};
	}

	@Override
	public ParameterizedTypeReference<List<Class<?>>> getVnfPackageClassList() {
		final ParameterizedTypeReference<List<VnfPkgInfo>> res = new ParameterizedTypeReference<>() {
			// Nothing.
		};
		return (ParameterizedTypeReference<List<Class<?>>>) (Object) res;
	}

	@Override
	public Version getVersion() {
		return new Version("2.7.1");
	}

	@Override
	public Object createVnfPackageRequest(final Map<String, String> userDefinedData) {
		final CreateVnfPkgInfoRequest req = new CreateVnfPkgInfoRequest();
		req.setUserDefinedData(userDefinedData);
		return req;
	}

	@Override
	public ParameterizedTypeReference<List<Class<?>>> getNsdPackageClassList() {
		final ParameterizedTypeReference<List<NsdInfo>> res = new ParameterizedTypeReference<>() {
			// Nothing.
		};
		return (ParameterizedTypeReference<List<Class<?>>>) (Object) res;
	}

	@Override
	public Class<?> getNsdPackageClass() {
		return NsdInfo.class;
	}

	@Override
	public Object createNsdPackageRequest(final Map<String, Object> userDefinedData) {
		final CreateNsdInfoRequest req = new CreateNsdInfoRequest();
		req.setUserDefinedData(userDefinedData.entrySet().stream().map(x -> Map.entry(x.getKey(), x.getValue().toString())).collect(Collectors.toMap(Entry::getKey, Entry::getValue)));
		return req;
	}

	@Override
	public Object createGrantRequest(final GrantResponse grant) {
		final GrantRequest g = grantMapping.mapToRequest(grant);
		final GrantRequestLinks links = new GrantRequestLinks();
		final Link link = new Link();
		link.setHref(vnfmFactory.createGrantVnfInstanceLink(grant.getVnfInstanceId()));
		links.setVnfInstance(link);
		final Link linkLcm = new Link();
		linkLcm.setHref(vnfmFactory.createGrantVnfLcmOpOccsLink(grant.getVnfLcmOpOccId()));
		links.setVnfLcmOpOcc(linkLcm);
		g.setLinks(links);
		return g;
	}

	@Override
	public Class<?> getVnfPmJobClass() {
		return PmJob.class;
	}

	@Override
	public Object createVnfPmJobRequest(final PmJob pmJob) {
		return pmJobMapping.map(pmJob);
	}

	@Override
	public Object createVnfThresholdRequest(final Threshold reqIn) {
		return thresholdMapping.map(reqIn);
	}

	@Override
	public String getSubscriptionUriFor(final ApiAndType at, final String id) {
		if (at.api() == ApiTypesEnum.SOL003) {
			return vnfmFactory.createSubscriptionLink(at, id);
		}
		return nfvoFactory.createSubscriptionLink(at, id);
	}

	@Override
	public Class<?> getVnfIndicatorSubscriptionClass() {
		return VnfIndicatorSubscription.class;
	}

	@Override
	public Object createVnfInstanceSubscriptionRequest(final Subscription subscription) {
		return lccnSubscriptionMapping.mapToLccnSubscriptionRequest(subscription, LifecycleChangeNotificationsFilter.class);
	}

	@Override
	public Object createVnfIndicatorSubscriptionRequest(final Subscription subscription) {
		return vnfIndicatorSubscriptionMapping.mapToRequest(subscription, VnfIndicatorNotificationsFilter.class);
	}

	@Override
	public Class<?> getVnfIndicatorClass() {
		return VnfIndicator.class;
	}

	@Override
	public ParameterizedTypeReference<List<Class<?>>> getVnfIndicatorClassList() {
		final ParameterizedTypeReference<List<VnfIndicator>> res = new ParameterizedTypeReference<>() {
			// Nothing.
		};
		return (ParameterizedTypeReference<List<Class<?>>>) (Object) res;
	}

	@Override
	public Object createVnfFmSubscriptionRequest(final Subscription subscription) {
		return fmSubscriptionMapping.map(subscription, FmNotificationsFilter.class);
	}

	@Override
	public Class<?> getVnfFmSubscriptionClass() {
		return FmSubscription.class;
	}

	@Override
	public Class<?> getVrQanSubscriptionClass() {
		return VrQuotaAvailSubscription.class;
	}

	// =====
	@Override
	public Object getPkgmSubscriptionRequest(final Subscription req) {
		return pkgmSubscriptionRequestMapping.mapToRequest(req, PkgmNotificationsFilter.class);
	}

	@Override
	public Object mapGrantRequest(final GrantResponse o) {
		return grantMapping.map(o);
	}

	@Override
	public Class<?> getVnfThresholdClass() {
		return com.ubiqube.etsi.mano.v271.model.em.vnfind.Threshold.class;
	}

	@Override
	public Object getVnfInstanceInstantiateRequest(final VnfInstantiate req) {
		return vnfInstantiateMapping.map(req);
	}

	@Override
	public Object getVnfInstanceScaleToLevelRequest(final VnfScaleToLevelRequest req) {
		return vnfInstanceRequestMapping.map(req);
	}

	@Override
	public Object createVnfInstanceHealRequest(final VnfHealRequest req) {
		return vnfInstanceRequestMapping.map(req);
	}

	@Override
	public Object getVnfInstanceOperateRequest(final VnfOperateRequest req) {
		return vnfInstanceRequestMapping.map(req);
	}

	@Override
	public Object getVnfInstanceChangeFalvourRequest(final ChangeVnfFlavourData req) {
		return vnfInstanceRequestMapping.map(req);
	}

	@Override
	public Object getVnfInstanceChangeExtConnRequest(final ChangeExtVnfConnRequest req) {
		return vnfInstanceRequestMapping.map(req);
	}

	@Override
	public Object mapVrQanSubscriptionRequest(final Subscription o) {
		return vrQuotaAvailSubscriptionMapping.mapToRequest(o, VrQuotaAvailNotificationsFilter.class);
	}

	@Override
	public Subscription mapVnfFmSubscription(final Object o) {
		return fmSubscriptionMapping.map((FmSubscription) o);
	}

	@Override
	public Subscription mapVrQanSubscriptionSubscription(final Object o) {
		return vrQuotaAvailSubscriptionMapping.map((VrQuotaAvailSubscription) o);
	}

	@Override
	public Subscription mapToPkgmSubscription(final Object o) {
		return pkgmSubscriptionRequestMapping.map((PkgmSubscription) o);
	}

	@Override
	public Subscription mapToVnfIndicatorSubscription(final Object o) {
		return vnfIndicatorSubscriptionMapping.map((VnfIndicatorSubscription) o);
	}

	@Override
	public GrantResponse mapToGrantResponse(final Object o) {
		return grantMapping.map((Grant) o);
	}

	@Override
	public NsdPackage mapToNsdPackage(final Object o) {
		return nsdMapping.map((NsdInfo) o);
	}

	@Override
	public com.ubiqube.etsi.mano.dao.mano.VnfIndicator mapToVnfIndicator(final Object o) {
		return vnfIndicatorMapping.map((VnfIndicator) o);
	}

	@Override
	public com.ubiqube.etsi.mano.dao.mano.VnfInstance mapToVnfInstance(final Object o) {
		return vnfInstanceMapping.map((com.ubiqube.etsi.mano.v271.model.em.vnflcm.VnfInstance) o);
	}

	@Override
	public VnfBlueprint mapToVnfBlueprint(final Object o) {
		return vnfLcmOpOccMapping.map((VnfLcmOpOcc) o);
	}

	@Override
	public VnfPackage mapToVnfPackage(final Object o) {
		return vnfPkgInfoMapping.map((VnfPkgInfo) o);
	}

	@Override
	public Threshold mapToThreshold(final Object o) {
		return thresholdMapping.map((com.ubiqube.etsi.mano.v271.model.em.vnfind.Threshold) o);
	}

	@Override
	public PmJob mapToPmJob(final Object o) {
		return pmJobMapping.map((com.ubiqube.etsi.mano.v271.model.em.vnfind.PmJob) o);
	}

}
