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

import com.ubiqube.etsi.mano.v281.model.em.vnflcm.NotificationLink;
import com.ubiqube.etsi.mano.v281.model.nfvo.vnfconfig.PkgmLinks;
import com.ubiqube.etsi.mano.v281.nfvo.controller.nfvo.vnf.VnfPackages281Sol005Api;
import com.ubiqube.etsi.mano.v281.nfvo.controller.nfvo.vnf.VnfSubscriptions281Sol005Api;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
public class Sol005Linkable {

	public PkgmLinks createVnfPackageOnboardingNotificationLinks(final UUID vnfPkgId,final String vnfdId,final UUID subscriptionId) {
		final PkgmLinks ret = new PkgmLinks();
		final NotificationLink subscription = createVnfPackagesVnfPkgInfoLinksSelf(
		linkTo(methodOn(VnfSubscriptions281Sol005Api.class).subscriptionsSubscriptionIdGet(subscriptionId.toString())).withSelfRel().getHref());
		ret.setSubscription(subscription);

		final NotificationLink vnfPackage = createVnfPackagesVnfPkgInfoLinksSelf(
		linkTo(methodOn(VnfPackages281Sol005Api.class).vnfPackagesVnfPkgIdGet(vnfPkgId.toString())).withSelfRel().getHref());
		ret.setVnfPackage(vnfPackage);

		final NotificationLink vnfVnfdId = createVnfPackagesVnfPkgInfoLinksSelf(
		linkTo(methodOn(VnfPackages281Sol005Api.class).vnfPackagesVnfPkgIdVnfdGet(vnfdId,null,null)).withSelfRel().getHref());
		ret.setVnfPackageByVnfdId(vnfVnfdId);
		return ret;
	}

	private static NotificationLink createVnfPackagesVnfPkgInfoLinksSelf(final String _href) {
		final NotificationLink link = new NotificationLink();
		link.setHref(_href);
		return link;
	}

}
