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

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ubiqube.etsi.mano.controller.subscription.AbstractSubscriptionFactory;
import com.ubiqube.etsi.mano.dao.mano.VnfPackage;
import com.ubiqube.etsi.mano.repository.VnfPackageRepository;
import com.ubiqube.etsi.mano.service.event.model.EventMessage;
import com.ubiqube.etsi.mano.v281.model.nfvo.vnfconfig.PackageOperationalStateType;
import com.ubiqube.etsi.mano.v281.service.NfvoFactory;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@Service
public class NfvoFactory281 extends AbstractSubscriptionFactory implements NfvoFactory {
	private final VnfPackageRepository vnfPackageRepository;

	public NfvoFactory281(final VnfPackageRepository vnfPackageRepository, final List<SubscriptionLinkable281Nfvo> subs) {
		super(subs);
		this.vnfPackageRepository = vnfPackageRepository;
	}

	@Override
	public Object createNotificationVnfPackageOnboardingNotification(final UUID subscriptionId, final EventMessage event) {
		final VnfPackage vnfPkg = vnfPackageRepository.get(event.getObjectId());
		return VnfSubscriptionFactory281.createNotificationVnfPackageOnboardingNotification(subscriptionId, event.getObjectId(), vnfPkg.getVnfdId(), new Sol003Linkable());
	}

	@Override
	public Object createVnfPackageChangeNotification(final UUID subscriptionId, final EventMessage event) {
		boolean deleted = false;
		try {
			vnfPackageRepository.get(event.getObjectId());
		} catch (final RuntimeException e) {
			deleted = true;
		}
		return VnfSubscriptionFactory281.createVnfPackageChangeNotification(deleted, subscriptionId, event.getObjectId(), event.getObjectId(), event.getAdditionalParameters().get("vnfdId"),
				PackageOperationalStateType.fromValue(event.getAdditionalParameters().get("state")), new Sol003Linkable());
	}
}
