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
package com.ubiqube.etsi.mano.v361.nfvo.controller.vnfpm;

import org.springframework.context.annotation.Conditional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.SingleControllerCondition;
import com.ubiqube.etsi.mano.controller.vnf.VnfPerformanceNotificationFrontController;
import com.ubiqube.etsi.mano.v361.model.vnfm.vnfpm.PerformanceInformationAvailableNotification;
import com.ubiqube.etsi.mano.v361.service.mapping.PmJobNotification361Mapping;

import jakarta.validation.Valid;

/**
 *
 * @author olivier
 *
 */
@RestController
@Conditional(SingleControllerCondition.class)
public class VnfpmAvailableNotification361Sol003Controller implements VnfpmAvailableNotification361Sol003Api {
	private final VnfPerformanceNotificationFrontController fc;
	private final PmJobNotification361Mapping mapper;

	public VnfpmAvailableNotification361Sol003Controller(final VnfPerformanceNotificationFrontController fc, final PmJobNotification361Mapping mapper) {
		this.fc = fc;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<Void> availableCheck() {
		return fc.availableCheck();
	}

	@Override
	public ResponseEntity<Void> availableNotificationPost(@Valid final PerformanceInformationAvailableNotification body) {
		final com.ubiqube.etsi.mano.dao.mano.pm.PerformanceInformationAvailableNotification req = mapper.map(body);
		return fc.availablePost(req, "3.6.1");
	}

}
