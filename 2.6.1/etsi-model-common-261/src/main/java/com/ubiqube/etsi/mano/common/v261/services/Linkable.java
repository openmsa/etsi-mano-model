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
package com.ubiqube.etsi.mano.common.v261.services;

import java.util.UUID;

import com.ubiqube.etsi.mano.common.v261.model.vnf.PkgmLinks;
import com.ubiqube.etsi.mano.common.v261.model.vnf.PkgmSubscription;
import com.ubiqube.etsi.mano.common.v261.model.vnf.PkgmSubscriptionLinks;
import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfIndicatorValueChangeNotificationLinks;
import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfPkgInfo;

import jakarta.annotation.Nonnull;

/**
 * This is a technical interface for creating live links from VNF common
 * package.
 *
 * @author Olivier Vignaud {@literal {@literal <ovi@ubiqube.com>}}
 *
 */
public interface Linkable {
	/**
	 * Create link for a VNF Package.
	 *
	 * @param vnfPkgInfo A Vnf ID.
	 */
	void makeLinks(VnfPkgInfo vnfPkgInfo);

	String getSelfLink(VnfPkgInfo vnfPkgInfo);

	PkgmLinks createVnfPackageOnboardingNotificationLinks(@Nonnull UUID vnfPkgId, String vnfdId, UUID subscriptionId);

	VnfIndicatorValueChangeNotificationLinks createVnfIndicatorValueChangeNotificationLinks(@Nonnull String vnfIndicatorId, String vnfInstanceId, UUID subscriptionId);

	PkgmSubscriptionLinks createSubscriptionsPkgmSubscriptionLinks(@Nonnull String subscriptionId);

	void makeSubscriptionLink(PkgmSubscription pkgmSubscription);

	String makeSubscriptionLink(String id);
}
