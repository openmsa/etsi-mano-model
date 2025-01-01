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
package com.ubiqube.etsi.mano.v261.service;

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

import com.ubiqube.etsi.mano.common.v261.model.Link;
import com.ubiqube.etsi.mano.common.v261.model.lcmgrant.Grant;
import com.ubiqube.etsi.mano.common.v261.model.nslcm.VnfInstance;
import com.ubiqube.etsi.mano.common.v261.model.vnf.PkgmNotificationsFilter;
import com.ubiqube.etsi.mano.common.v261.model.vnf.PkgmSubscription;
import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfPkgInfo;
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
import com.ubiqube.etsi.mano.v261.model.nfvo.lcmgrant.GrantRequest;
import com.ubiqube.etsi.mano.v261.model.nfvo.lcmgrant.GrantRequestLinks;
import com.ubiqube.etsi.mano.v261.model.nfvo.nsd.sol005.CreateNsdInfoRequest;
import com.ubiqube.etsi.mano.v261.model.nfvo.nsd.sol005.NsdInfo;
import com.ubiqube.etsi.mano.v261.model.nfvo.nsfm.FmNsSubscription;
import com.ubiqube.etsi.mano.v261.model.nfvo.nslcm.LifecycleChangeNotificationsFilter;
import com.ubiqube.etsi.mano.v261.model.nfvo.vnf.CreateVnfPkgInfoRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.faultmngt.FmNotificationsVnfFilter;
import com.ubiqube.etsi.mano.v261.model.vnfm.faultmngt.FmSubscription;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.CreateVnfRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.ScaleVnfRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.TerminateVnfRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.TerminateVnfRequest.TerminationTypeEnum;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.VnfLcmOpOcc;
import com.ubiqube.etsi.mano.v261.model.vnfm.vnfind.VnfIndicator;
import com.ubiqube.etsi.mano.v261.model.vnfm.vnfind.VnfIndicatorNotificationsFilter;
import com.ubiqube.etsi.mano.v261.model.vnfm.vnfind.VnfIndicatorSubscription;
import com.ubiqube.etsi.mano.v261.model.vnfm.vrqan.VrQuotaAvailNotificationsFilter;
import com.ubiqube.etsi.mano.v261.model.vnfm.vrqan.VrQuotaAvailSubscription;
import com.ubiqube.etsi.mano.v261.service.mapping.Grant261Mapping;
import com.ubiqube.etsi.mano.v261.service.mapping.Nsd261Mapping;
import com.ubiqube.etsi.mano.v261.service.mapping.PmJob261Mapping;
import com.ubiqube.etsi.mano.v261.service.mapping.Threshold261Mapping;
import com.ubiqube.etsi.mano.v261.service.mapping.VnfIndicator261Mapping;
import com.ubiqube.etsi.mano.v261.service.mapping.VnfInstance261Mapping;
import com.ubiqube.etsi.mano.v261.service.mapping.VnfLcmOpOcc261Mapping;
import com.ubiqube.etsi.mano.v261.service.mapping.VnfPkgInfo261Mapping;
import com.ubiqube.etsi.mano.v261.service.mapping.subscription.FmSubscription261Mapping;
import com.ubiqube.etsi.mano.v261.service.mapping.subscription.LccnSubscription261Mapping;
import com.ubiqube.etsi.mano.v261.service.mapping.subscription.PkgmSubscriptionRequest261Mapping;
import com.ubiqube.etsi.mano.v261.service.mapping.subscription.VnfIndicatorSubscription261Mapping;
import com.ubiqube.etsi.mano.v261.service.mapping.subscription.VrQuotaAvailSubscription261Mapping;
import com.ubiqube.etsi.mano.v261.service.mapping.vnflcm.VnfInstanceRequest261Mapping;
import com.ubiqube.etsi.mano.v261.service.mapping.vnflcm.VnfInstantiate261Mapping;

/**
 *
 * @author Olivier Vignaud {@literal {@literal <ovi@ubiqube.com>}}
 *
 */
@Service
public class HttpGateway261 extends AbstractHttpGateway {

	private static final Logger LOG = LoggerFactory.getLogger(HttpGateway261.class);

	private final NfvoFactory nfvoFactory;
	private final VnfmFactory vnfmFactory;
	private final Grant261Mapping grantMapping;
	private final FmSubscription261Mapping fmSubscriptionMapping;
	private final LccnSubscription261Mapping lccnSubscriptionMapping;
	private final PkgmSubscriptionRequest261Mapping pkgmSubscriptionRequestMapping;
	private final PmJob261Mapping pmJobMapping;
	private final Threshold261Mapping thresholdMapping;
	private final VnfIndicator261Mapping vnfIndicatorMapping;
	private final VnfIndicatorSubscription261Mapping vnfIndicatorSubscriptionMapping;
	private final VnfInstanceRequest261Mapping vnfInstanceRequestMapping;
	private final VnfInstantiate261Mapping vnfInstantiateMapping;
	private final VnfInstance261Mapping vnfInstanceMapping;
	private final VrQuotaAvailSubscription261Mapping vrQuotaAvailSubscriptionMapping;
	private final Nsd261Mapping nsdMapping;
	private final VnfPkgInfo261Mapping vnfPkgInfoMapping;
	private final VnfLcmOpOcc261Mapping vnfLcmOpOccMapping;

	public HttpGateway261(final ObjectProvider<VnfmFactory> vnfmFactory, final ObjectProvider<NfvoFactory> nfvoFactory, final Grant261Mapping grantMapping, final FmSubscription261Mapping fmSubscriptionMapping, final LccnSubscription261Mapping lccnSubscriptionMapping, final PkgmSubscriptionRequest261Mapping pkgmSubscriptionRequestMapping, final PmJob261Mapping pmJobMapping, final Threshold261Mapping thresholdMapping, final VnfIndicator261Mapping vnfIndicatorMapping, final VnfIndicatorSubscription261Mapping vnfIndicatorSubscriptionMapping, final VnfInstanceRequest261Mapping vnfInstanceRequestMapping, final VnfInstantiate261Mapping vnfInstantiateMapping, final VnfInstance261Mapping vnfInstanceMapping, final VrQuotaAvailSubscription261Mapping vrQuotaAvailSubscriptionMapping, final Nsd261Mapping nsdMapping, final VnfPkgInfo261Mapping vnfPkgInfoMapping, final VnfLcmOpOcc261Mapping vnfLcmOpOccMapping) {
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
		return new Version("2.6.1");
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
		return fmSubscriptionMapping.map(subscription, FmNotificationsVnfFilter.class);
	}

	@Override
	public Class<?> getVnfFmSubscriptionClass() {
		return FmNsSubscription.class;
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
		return com.ubiqube.etsi.mano.v261.model.vnfm.nsperfo.Threshold.class;
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
		return vnfInstanceMapping.map((VnfInstance) o);
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
		return thresholdMapping.map((com.ubiqube.etsi.mano.v261.model.vnfm.nsperfo.Threshold) o);
	}

	@Override
	public PmJob mapToPmJob(final Object o) {
		return pmJobMapping.map((com.ubiqube.etsi.mano.v261.model.vnfm.nsperfo.PmJob) o);
	}

}
