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
package com.ubiqube.etsi.mano.v261.nfvo.controller.vnfpm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.vnf.VnfPerformanceNotificationFrontController;
import com.ubiqube.etsi.mano.v261.model.nfvo.nsperfo.PerformanceInformationAvailableNotification;
import com.ubiqube.etsi.mano.v261.model.nfvo.nsperfo.ThresholdCrossedNotification;
import com.ubiqube.etsi.mano.v261.service.mapping.PmJobNotification261Mapping;

import jakarta.validation.Valid;

/**
 *
 * @author olivier
 *
 */
@RestController
public class PerformanceInformationAvailableNotification261Sol003Controller implements PerformanceInformationAvailableNotification261Sol003Api {
	private final VnfPerformanceNotificationFrontController fc;
	private final PmJobNotification261Mapping mapper;

	public PerformanceInformationAvailableNotification261Sol003Controller(final VnfPerformanceNotificationFrontController fc, final PmJobNotification261Mapping mapper) {
		this.fc = fc;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<Void> availableCheck() {
		return fc.availableCheck();
	}

	@Override
	public ResponseEntity<Void> availabePost(@Valid final PerformanceInformationAvailableNotification body) {
		final com.ubiqube.etsi.mano.dao.mano.pm.PerformanceInformationAvailableNotification req = mapper.map(body);
		return fc.availablePost(req, "2.6.1");
	}

	@Override
	public ResponseEntity<Void> crossedCheck() {
		return fc.crossedCheck();
	}

	@Override
	public ResponseEntity<Void> crossedPost(@Valid final ThresholdCrossedNotification body) {
		final com.ubiqube.etsi.mano.dao.mano.pm.ThresholdCrossedNotification req = mapper.map(body);
		return fc.crossedPost(req, "2.6.1");
	}

}
