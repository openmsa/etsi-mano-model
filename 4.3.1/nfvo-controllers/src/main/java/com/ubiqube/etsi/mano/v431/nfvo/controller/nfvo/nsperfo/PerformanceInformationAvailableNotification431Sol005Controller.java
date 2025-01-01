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
package com.ubiqube.etsi.mano.v431.nfvo.controller.nfvo.nsperfo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v431.model.em.vnfpm.PerformanceInformationAvailableNotification;
import com.ubiqube.etsi.mano.v431.model.em.vnfpm.ThresholdCrossedNotification;

import jakarta.validation.Valid;

@RestController
public class PerformanceInformationAvailableNotification431Sol005Controller implements PerformanceInformationAvailableNotification431Sol005Api {

	@Override
	public ResponseEntity<Void> performanceInformationAvailableCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> performanceInformationAvailablePost(@Valid final PerformanceInformationAvailableNotification body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> thresholdCrossedCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> thresholdCrossedPost(@Valid final ThresholdCrossedNotification body) {
		// TODO Auto-generated method stub
		return null;
	}

}
