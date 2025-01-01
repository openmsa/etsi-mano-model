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
package com.ubiqube.etsi.mano.v281.nfvo.service;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.UUID;

import com.ubiqube.etsi.mano.controller.FrontApiTypesEnum;
import com.ubiqube.etsi.mano.v281.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.v281.model.em.vnflcm.NotificationLink;
import com.ubiqube.etsi.mano.v281.model.nfvo.vnf.PkgmSubscriptionLinks;
import com.ubiqube.etsi.mano.v281.model.nfvo.vnf.VnfPkgInfo;
import com.ubiqube.etsi.mano.v281.model.nfvo.vnf.VnfPkgInfoLinks;
import com.ubiqube.etsi.mano.v281.model.nfvo.vnfconfig.PkgmLinks;
import com.ubiqube.etsi.mano.v281.nfvo.controller.vnfm.vnf.VnfPackages281Sol003Api;
import com.ubiqube.etsi.mano.v281.nfvo.controller.vnfm.vnf.VnfSubscriptions281Sol003Api;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
public class Sol003Linkable implements Linkable {

	@Override
	public VnfPkgInfoLinks getVnfLinks(final String vnfPkgId) {
		final VnfPkgInfoLinks links = new VnfPkgInfoLinks();

		final Link self = new Link();
		self.setHref(linkTo(methodOn(VnfPackages281Sol003Api.class).vnfPackagesVnfPkgIdGet(vnfPkgId,null)).withSelfRel().getHref());
		links.self(self);

		final Link vnfd = new Link();
		vnfd.setHref(linkTo(methodOn(VnfPackages281Sol003Api.class).vnfPackagesVnfPkgIdVnfdGet(vnfPkgId,null)).withSelfRel().getHref());
		links.setVnfd(vnfd);

		final Link packageContent = new Link();
		packageContent.setHref(linkTo(methodOn(VnfPackages281Sol003Api.class).vnfPackagesVnfPkgIdPackageContentGet(vnfPkgId)).withSelfRel().getHref());
		links.setPackageContent(packageContent);
		return links;
	}

	@Override
	public PkgmSubscriptionLinks createSubscriptionsPkgmSubscriptionLinks(final String _subscriptionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FrontApiTypesEnum getApi() {
		return FrontApiTypesEnum.SOL003;
	}

	@Override
	public void makeLinks(final VnfPkgInfo _vnfPkgInfo) {
		_vnfPkgInfo.setLinks(getVnfLinks(_vnfPkgInfo.getId()));
	}

	@Override
	public String getSelfLink(final VnfPkgInfo _vnfPkgInfo) {
		return linkTo(methodOn(VnfPackages281Sol003Api.class).vnfPackagesVnfPkgIdGet(_vnfPkgInfo.getId(),null)).withSelfRel().getHref();
	}

	@Override
	public PkgmLinks createVnfPackageOnboardingNotificationLinks(final UUID vnfPkgId,final String vnfdId,final UUID subscriptionId) {
		final PkgmLinks ret = new PkgmLinks();
		final NotificationLink subscription = createVnfPackagesVnfPkgInfoLinksSelf(
		linkTo(methodOn(VnfSubscriptions281Sol003Api.class).subscriptionsSubscriptionIdGet(subscriptionId.toString())).withSelfRel().getHref());
		ret.setSubscription(subscription);

		final NotificationLink vnfPackage = createVnfPackagesVnfPkgInfoLinksSelf(
		linkTo(methodOn(VnfPackages281Sol003Api.class).vnfPackagesVnfPkgIdGet(vnfPkgId.toString(),null)).withSelfRel().getHref());
		ret.setVnfPackage(vnfPackage);

		final NotificationLink vnfVnfdId = createVnfPackagesVnfPkgInfoLinksSelf(
		linkTo(methodOn(VnfPackages281Sol003Api.class).vnfPackagesVnfPkgIdVnfdGet(vnfdId,null)).withSelfRel().getHref());
		ret.setVnfPackageByVnfdId(vnfVnfdId);
		return ret;
	}

	private static NotificationLink createVnfPackagesVnfPkgInfoLinksSelf(final String _href) {
		final NotificationLink link = new NotificationLink();
		link.setHref(_href);
		return link;
	}

}
