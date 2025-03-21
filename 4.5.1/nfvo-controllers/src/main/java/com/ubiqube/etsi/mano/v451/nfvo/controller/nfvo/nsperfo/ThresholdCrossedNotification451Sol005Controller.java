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
package com.ubiqube.etsi.mano.v451.nfvo.controller.nfvo.nsperfo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v451.model.em.vnfpm.ThresholdCrossedNotification;

import jakarta.validation.Valid;

@RestController
public class ThresholdCrossedNotification451Sol005Controller implements ThresholdCrossedNotification451Sol005Api {

	@Override
	public ResponseEntity<Void> uRIIsProvidedByTheClientWhenCreatingTheSubscriptionThresholdCrossedNotificationGet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> uRIIsProvidedByTheClientWhenCreatingTheSubscriptionThresholdCrossedNotificationPost(@Valid final ThresholdCrossedNotification body) {
		// TODO Auto-generated method stub
		return null;
	}

}
