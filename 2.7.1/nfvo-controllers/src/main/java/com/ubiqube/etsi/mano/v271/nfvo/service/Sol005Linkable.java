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
package com.ubiqube.etsi.mano.v271.nfvo.service;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.UUID;

import com.ubiqube.etsi.mano.v271.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.NotificationLink;
import com.ubiqube.etsi.mano.v271.model.sol003.vnf.PkgmSubscription;
import com.ubiqube.etsi.mano.v271.model.sol003.vnf.PkgmSubscriptionLinks;
import com.ubiqube.etsi.mano.v271.model.sol003.vnf.VnfPkgInfo;
import com.ubiqube.etsi.mano.v271.model.sol003.vnf.VnfPkgInfoLinks;
import com.ubiqube.etsi.mano.v271.model.vnf.PkgmLinks;
import com.ubiqube.etsi.mano.v271.nfvo.controller.vnf.VnfPackages271Sol005Api;
import com.ubiqube.etsi.mano.v271.nfvo.controller.vnf.VnfSubscriptions271Sol005Api;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
public class Sol005Linkable {

	public VnfPkgInfoLinks getVnfLinks(final String vnfPkgId) {
		final VnfPkgInfoLinks links = new VnfPkgInfoLinks();

		final Link self = new Link();
		self.setHref(linkTo(methodOn(VnfPackages271Sol005Api.class).vnfPackagesVnfPkgIdGet(vnfPkgId)).withSelfRel().getHref());
		links.self(self);

		final Link vnfd = new Link();
		vnfd.setHref(linkTo(methodOn(VnfPackages271Sol005Api.class).vnfPackagesVnfPkgIdVnfdGet(vnfPkgId,null,null)).withSelfRel().getHref());
		links.setVnfd(vnfd);

		final Link packageContent = new Link();
		packageContent.setHref(linkTo(methodOn(VnfPackages271Sol005Api.class).vnfPackagesVnfPkgIdPackageContentGet(vnfPkgId,"")).withSelfRel().getHref());
		links.setPackageContent(packageContent);
		return links;
	}

	public PkgmLinks createVnfPackageOnboardingNotificationLinks(final UUID vnfPkgId,final String vnfdId,final UUID subscriptionId) {
		final PkgmLinks ret = new PkgmLinks();
		final NotificationLink subscription = createVnfPackagesVnfPkgInfoLinksSelf(
		linkTo(methodOn(VnfSubscriptions271Sol005Api.class).subscriptionsSubscriptionIdGet(subscriptionId.toString())).withSelfRel().getHref());
		ret.setSubscription(subscription);

		final NotificationLink vnfPackage = createVnfPackagesVnfPkgInfoLinksSelf(
		linkTo(methodOn(VnfPackages271Sol005Api.class).vnfPackagesVnfPkgIdGet(vnfPkgId.toString())).withSelfRel().getHref());
		ret.setVnfPackage(vnfPackage);

		final NotificationLink vnfVnfdId = createVnfPackagesVnfPkgInfoLinksSelf(
		linkTo(methodOn(VnfPackages271Sol005Api.class).vnfPackagesVnfPkgIdVnfdGet(vnfdId,null,null)).withSelfRel().getHref());
		ret.setVnfPackageByVnfdId(vnfVnfdId);
		return ret;
	}

	private static NotificationLink createVnfPackagesVnfPkgInfoLinksSelf(final String _href) {
		final NotificationLink link = new NotificationLink();
		link.setHref(_href);
		return link;
	}

	public PkgmSubscriptionLinks createSubscriptionsPkgmSubscriptionLinks(final String _subscriptionId) {
		final PkgmSubscriptionLinks subscriptionsPkgmSubscriptionLinks = new PkgmSubscriptionLinks();
		final Link self = new Link();
		self.setHref(linkTo(methodOn(VnfSubscriptions271Sol005Api.class).subscriptionsSubscriptionIdGet(_subscriptionId)).withSelfRel().getHref());
		subscriptionsPkgmSubscriptionLinks.setSelf(self);
		return subscriptionsPkgmSubscriptionLinks;
	}

	public void makeSubscriptionLink(final PkgmSubscription pkgmSubscription) {
		pkgmSubscription.setLinks(createSubscriptionsPkgmSubscriptionLinks(pkgmSubscription.getId()));
	}

	public void makeLinks(final VnfPkgInfo vnfPkgInfo) {
		vnfPkgInfo.setLinks(getVnfLinks(vnfPkgInfo.getId()));
	}

	public String getSelfLink(final VnfPkgInfo vnfPkgInfo) {
		return linkTo(methodOn(VnfPackages271Sol005Api.class).vnfPackagesVnfPkgIdGet(vnfPkgInfo.getId())).withSelfRel().getHref();
	}

}
