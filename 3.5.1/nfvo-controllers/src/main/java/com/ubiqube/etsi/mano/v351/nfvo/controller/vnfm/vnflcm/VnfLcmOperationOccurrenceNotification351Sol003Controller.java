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
package com.ubiqube.etsi.mano.v351.nfvo.controller.vnfm.vnflcm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.vnflcm.VnfLcmNotificationFrontController;
import com.ubiqube.etsi.mano.dao.mano.vnflcm.VnfLcmNotification;
import com.ubiqube.etsi.mano.v351.model.vnfm.vnflcm.VnfLcmOperationOccurrenceNotification;
import com.ubiqube.etsi.mano.v351.service.mapping.VnfLvmNotification351Mapping;

@RestController
public class VnfLcmOperationOccurrenceNotification351Sol003Controller implements VnfLcmOperationOccurrenceNotification351Sol003Api {
	private final VnfLcmNotificationFrontController fc;
	private final VnfLvmNotification351Mapping mapper;

	public VnfLcmOperationOccurrenceNotification351Sol003Controller(final VnfLcmNotificationFrontController fc, final VnfLvmNotification351Mapping mapper) {
		this.fc = fc;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<Void> vnflcmopoccCheck() {
		return fc.vnflcmopoccCheck();
	}

	@Override
	public ResponseEntity<Void> lcmOperationOccurrenceNotificationPost(final VnfLcmOperationOccurrenceNotification body) {
		final VnfLcmNotification req = mapper.map(body);
		return fc.vnflcmopoccNotification(req, "3.5.1");
	}

}
