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
package com.ubiqube.etsi.mano.nfvo.v361.controller.vnfpm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.vnf.VnfPerformanceNotificationFrontController;
import com.ubiqube.etsi.mano.vnfm.v361.model.vnfpm.ThresholdCrossedNotification;

import jakarta.validation.Valid;
import ma.glasnost.orika.MapperFacade;

/**
 *
 * @author olivier
 *
 */
@RestController
public class VnfpmCrossedNotification361Sol003Controller implements VnfpmCrossedNotification361Sol003Api {
	private final VnfPerformanceNotificationFrontController fc;
	private final MapperFacade mapper;

	public VnfpmCrossedNotification361Sol003Controller(final VnfPerformanceNotificationFrontController fc, final MapperFacade mapper) {
		this.fc = fc;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<Void> crossedCheck() {
		return fc.crossedCheck();
	}

	@Override
	public ResponseEntity<Void> crossedNotificationPost(@Valid final ThresholdCrossedNotification body) {
		final com.ubiqube.etsi.mano.dao.mano.pm.ThresholdCrossedNotification req = mapper.map(body, com.ubiqube.etsi.mano.dao.mano.pm.ThresholdCrossedNotification.class);
		return fc.crossedPost(req, "3.6.1");
	}

}
