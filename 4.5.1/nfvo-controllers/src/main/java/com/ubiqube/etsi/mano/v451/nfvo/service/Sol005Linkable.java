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
package com.ubiqube.etsi.mano.v451.nfvo.service;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.UUID;

import com.ubiqube.etsi.mano.v451.model.em.vnflcm.NotificationLink;
import com.ubiqube.etsi.mano.v451.model.nfvo.vnf.PkgmLinks;
import com.ubiqube.etsi.mano.v451.nfvo.controller.vnfm.vnf.VnfPackages451Sol005Api;
import com.ubiqube.etsi.mano.v451.nfvo.controller.vnfm.vnf.VnfSubscriptions451Sol005Api;
import com.ubiqube.etsi.mano.v451.service.Linkable;

public class Sol005Linkable implements Linkable {

	@Override
	public PkgmLinks createVnfPackageOnboardingNotificationLinks(final UUID vnfPkgId, final String vnfdId, final UUID subscriptionId) {
		final PkgmLinks ret = new PkgmLinks();
		final NotificationLink subscription = createVnfPackagesVnfPkgInfoLinksSelf(
				linkTo(methodOn(VnfSubscriptions451Sol005Api.class).subscriptionsSubscriptionIdGet(subscriptionId.toString())).withSelfRel().getHref());
		ret.setSubscription(subscription);

		final NotificationLink vnfPackage = createVnfPackagesVnfPkgInfoLinksSelf(
				linkTo(methodOn(VnfPackages451Sol005Api.class).vnfPackagesVnfPkgIdGet(vnfPkgId.toString())).withSelfRel().getHref());
		ret.setVnfPackage(vnfPackage);

		return ret;
	}

	private static NotificationLink createVnfPackagesVnfPkgInfoLinksSelf(final String _href) {
		final NotificationLink link = new NotificationLink();
		link.setHref(_href);
		return link;
	}

}
