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
package com.ubiqube.etsi.mano.v331.service;

import java.util.UUID;

import com.ubiqube.etsi.mano.controller.FrontApiTypesEnum;
import com.ubiqube.etsi.mano.v331.model.nfvo.vnf.PkgmLinks;
import com.ubiqube.etsi.mano.v331.model.nfvo.vnf.PkgmSubscriptionLinks;
import com.ubiqube.etsi.mano.v331.model.nfvo.vnf.VnfPkgInfo;
import com.ubiqube.etsi.mano.v331.model.nfvo.vnf.VnfPkgInfoLinks;

import jakarta.annotation.Nonnull;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
public interface Linkable {
	VnfPkgInfoLinks getVnfLinks(@Nonnull String vnfPkgId);

	PkgmSubscriptionLinks createSubscriptionsPkgmSubscriptionLinks(@Nonnull String subscriptionId);

	FrontApiTypesEnum getApi();

	void makeLinks(final VnfPkgInfo vnfPkgInfo);

	String getSelfLink(final VnfPkgInfo vnfPkgInfo);

	PkgmLinks createVnfPackageOnboardingNotificationLinks(UUID vnfPkgId, String vnfdId, UUID subscriptionId);

}
