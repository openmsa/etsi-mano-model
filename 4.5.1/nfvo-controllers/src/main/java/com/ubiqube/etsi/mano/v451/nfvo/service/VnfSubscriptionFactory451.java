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

import java.time.OffsetDateTime;
import java.util.UUID;

import com.ubiqube.etsi.mano.v451.model.nfvo.vnf.PackageChangeType;
import com.ubiqube.etsi.mano.v451.model.nfvo.vnf.PackageOperationalStateType;
import com.ubiqube.etsi.mano.v451.model.nfvo.vnf.VnfPackageChangeNotification;
import com.ubiqube.etsi.mano.v451.model.nfvo.vnf.VnfPackageOnboardingNotification;
import com.ubiqube.etsi.mano.v451.service.Linkable;

import jakarta.annotation.Nonnull;

/**
 * @author olivier
 */
public class VnfSubscriptionFactory451 {

	@Nonnull
	public static VnfPackageChangeNotification createVnfPackageChangeNotification(final boolean deleted, final UUID subscriptionId, @Nonnull final UUID vnfPkgId, final String vnfdId, final UUID eventId, final PackageOperationalStateType state, final Linkable links) {
		final VnfPackageChangeNotification ret = new VnfPackageChangeNotification();
		ret.setId(eventId.toString());
		if (deleted) {
			ret.setChangeType(PackageChangeType.PKG_DELETE);
		} else {
			ret.setChangeType(PackageChangeType.OP_STATE_CHANGE);
		}
		ret.setId(eventId.toString());
		ret.setNotificationType("VnfPackageChangeNotification");
		ret.setOperationalState(state);
		ret.setSubscriptionId(subscriptionId.toString());
		ret.setTimeStamp(OffsetDateTime.now());
		ret.setVnfdId(vnfdId);
		ret.setVnfPkgId(vnfPkgId.toString());
		ret.setLinks(links.createVnfPackageOnboardingNotificationLinks(vnfPkgId, vnfdId, subscriptionId));
		return ret;
	}

	@Nonnull
	public static VnfPackageOnboardingNotification createNotificationVnfPackageOnboardingNotification(final UUID subscriptionId, @Nonnull final UUID vnfPkgId, final String vnfdId, final Linkable links) {
		final VnfPackageOnboardingNotification ret = new VnfPackageOnboardingNotification();
		ret.setId(subscriptionId.toString());
		ret.setTimeStamp(OffsetDateTime.now());
		ret.setNotificationType("VnfPackageOnboardingNotification");
		ret.setSubscriptionId(subscriptionId.toString());
		ret.setVnfPkgId(vnfPkgId.toString());
		ret.setVnfdId(vnfdId);
		ret.setLinks(links.createVnfPackageOnboardingNotificationLinks(vnfPkgId, vnfdId, subscriptionId));
		return ret;
	}

}
