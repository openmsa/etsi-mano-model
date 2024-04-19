/**
 *     Copyright (C) 2019-2024 Ubiqube.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.ubiqube.etsi.mano.v431.nfvo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ubiqube.etsi.mano.controller.subscription.AbstractSubscriptionFactory;
import com.ubiqube.etsi.mano.dao.mano.VnfPackage;
import com.ubiqube.etsi.mano.repository.VnfPackageRepository;
import com.ubiqube.etsi.mano.service.event.model.EventMessage;
import com.ubiqube.etsi.mano.v431.model.nfvo.vnf.PackageOperationalStateType;
import com.ubiqube.etsi.mano.v431.service.NfvoFactory;

/**
 * @author olivier
 */
@Service
public class NfvoFactory443 extends AbstractSubscriptionFactory implements NfvoFactory {
	private final VnfPackageRepository vnfPackageRepository;

	public NfvoFactory443(final VnfPackageRepository vnfPackageRepository, final List<SubscriptionLinkable431Nfvo> subs) {
		super(subs);
		this.vnfPackageRepository = vnfPackageRepository;
	}

	@Override
	public Object createNotificationVnfPackageOnboardingNotification(final UUID subscriptionId, final EventMessage event) {
		final VnfPackage vnfPkg = vnfPackageRepository.get(event.getObjectId());
		return VnfSubscriptionFactory431.createNotificationVnfPackageOnboardingNotification(subscriptionId, event.getObjectId(), vnfPkg.getVnfdId(), new Sol005Linkable());
	}

	@Override
	public Object createVnfPackageChangeNotification(final UUID subscriptionId, final EventMessage event) {
		boolean deleted = false;
		try {
			vnfPackageRepository.get(event.getObjectId());
		} catch (final RuntimeException e) {
			deleted = true;
		}
		return VnfSubscriptionFactory431.createVnfPackageChangeNotification(deleted, subscriptionId, event.getId(), event.getAdditionalParameters().get("vnfdId"), event.getObjectId(),
				PackageOperationalStateType.fromValue(event.getAdditionalParameters().get("state")), new Sol005Linkable());
	}

}
