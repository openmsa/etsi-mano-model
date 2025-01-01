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
package com.ubiqube.etsi.mano.v261.service;

import java.util.Map;
import java.util.UUID;

import com.ubiqube.etsi.mano.controller.subscription.ApiAndType;
import com.ubiqube.etsi.mano.service.event.model.EventMessage;
import com.ubiqube.etsi.mano.v261.model.nfvo.lcmgrant.GrantRequest;

/**
 *
 * @author Olivier Vignaud {@literal {@literal <ovi@ubiqube.com>}}
 *
 */
public interface VnfmFactory {

	void makeGrantRequestLink(final GrantRequest manoGrant);

	Object createVnfIndicatorValueChangeNotification(UUID subscriptionId, EventMessage event);

	String createVnfIndicatorSubscriptionLink(Map<String, String> params);

	String createVnfLcmSubscriptionLink(Map<String, String> params);

	String createSubscriptionLink(ApiAndType at, String id);

	String createGrantVnfInstanceLink(String vnfInstanceId);

	String createGrantVnfLcmOpOccsLink(String vnfLcmOpOccId);

}
