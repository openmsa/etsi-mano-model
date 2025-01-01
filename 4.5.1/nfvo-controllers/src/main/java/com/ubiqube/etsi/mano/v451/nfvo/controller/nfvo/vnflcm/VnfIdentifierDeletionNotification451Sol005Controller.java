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
package com.ubiqube.etsi.mano.v451.nfvo.controller.nfvo.vnflcm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.vnflcm.VnfLcmNotificationFrontController;
import com.ubiqube.etsi.mano.dao.mano.vnflcm.VnfLcmNotification;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VnfIdentifierDeletionNotification;
import com.ubiqube.etsi.mano.v451.service.mapping.VnfLvmNotification451Mapping;

import jakarta.validation.Valid;

@RestController
public class VnfIdentifierDeletionNotification451Sol005Controller implements VnfIdentifierDeletionNotification451Sol005Api {
	private final VnfLcmNotificationFrontController fc;
	private final VnfLvmNotification451Mapping mapper;

	public VnfIdentifierDeletionNotification451Sol005Controller(final VnfLcmNotificationFrontController fc, final VnfLvmNotification451Mapping mapper) {
		this.fc = fc;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<Void> deletionCheck() {
		return fc.deletionCheck();
	}

	@Override
	public ResponseEntity<Void> deletionNotificationPost(@Valid final VnfIdentifierDeletionNotification body) {
		final VnfLcmNotification req = mapper.map(body);
		return fc.deletionNotification(req, "4.5.1");
	}

}
