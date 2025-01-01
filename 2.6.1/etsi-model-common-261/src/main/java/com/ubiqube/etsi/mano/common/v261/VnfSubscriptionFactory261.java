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
package com.ubiqube.etsi.mano.common.v261;

import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.annotation.Nonnull;

import com.ubiqube.etsi.mano.common.v261.model.vnf.PackageChangeType;
import com.ubiqube.etsi.mano.common.v261.model.vnf.PackageOperationalStateType;
import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfIndicatorValueChangeNotification;
import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfIndicatorValueChangeNotification.NotificationTypeEnum;
import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfPackageChangeNotification;
import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfPackageOnboardingNotification;
import com.ubiqube.etsi.mano.common.v261.services.Linkable;

/**
 *
 * @author Olivier Vignaud {@literal {@literal <ovi@ubiqube.com>}}
 *
 */
public class VnfSubscriptionFactory261 {
	private VnfSubscriptionFactory261() {
		// Nothing.
	}

	@Nonnull
	public static VnfPackageChangeNotification createVnfPackageChangeNotification(final boolean deleted, final UUID subscriptionId, @Nonnull final UUID vnfPkgId, final UUID eventId, final String vnfdId, final PackageOperationalStateType state, final Linkable links) {
		final VnfPackageChangeNotification ret = new VnfPackageChangeNotification();
		if (deleted) {
			ret.setChangeType(PackageChangeType.PKG_DELETE);
		} else {
			ret.setChangeType(PackageChangeType.OP_STATE_CHANGE);
		}
		ret.setId(eventId.toString());
		ret.setVnfdId(vnfdId);
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
	public static VnfPackageOnboardingNotification createNotificationVnfPackageOnboardingNotification(final UUID id, final UUID subscriptionId, @Nonnull final UUID vnfPkgId, final String vnfdId, final Linkable links) {
		final VnfPackageOnboardingNotification ret = new VnfPackageOnboardingNotification();
		ret.setId(id.toString());
		ret.setTimeStamp(OffsetDateTime.now());
		ret.setNotificationType("VnfPackageOnboardingNotification");
		ret.setSubscriptionId(subscriptionId.toString());
		ret.setVnfPkgId(vnfPkgId.toString());
		ret.setVnfdId(vnfdId);
		ret.setLinks(links.createVnfPackageOnboardingNotificationLinks(vnfPkgId, vnfdId, subscriptionId));
		return ret;
	}
	
	@Nonnull
	public static VnfIndicatorValueChangeNotification createNotificationVnfIndicatorValueChangeNotification(final UUID id, final UUID subscriptionId, @Nonnull final String vnfIndicatorId, final String vnfInstanceId, String value, String vnfdId, final Linkable links) {
		final VnfIndicatorValueChangeNotification ret = new VnfIndicatorValueChangeNotification();
		ret.setId(id.toString());
		ret.setTimeStamp(OffsetDateTime.now());
		ret.setNotificationType(NotificationTypeEnum.VNFINDICATORVALUECHANGENOTIFICATION);
		ret.setSubscriptionId(subscriptionId.toString());
		ret.setVnfInstanceId(vnfInstanceId);
		ret.setVnfIndicatorId(vnfIndicatorId);
		ret.setValue(value);
		ret.setVnfdId(vnfdId);
		ret.setLinks(links.createVnfIndicatorValueChangeNotificationLinks(vnfIndicatorId, vnfInstanceId, subscriptionId));
		return ret;
	}
}
