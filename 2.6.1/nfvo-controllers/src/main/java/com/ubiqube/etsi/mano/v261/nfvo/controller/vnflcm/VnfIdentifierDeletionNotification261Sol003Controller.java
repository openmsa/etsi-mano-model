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
package com.ubiqube.etsi.mano.v261.nfvo.controller.vnflcm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.vnflcm.VnfLcmNotificationFrontController;
import com.ubiqube.etsi.mano.dao.mano.vnflcm.VnfLcmNotification;
import com.ubiqube.etsi.mano.v261.model.vnfm.vnflcm.VnfIdentifierDeletionNotification;

import jakarta.validation.Valid;
import ma.glasnost.orika.MapperFacade;

/**
 *
 * @author Olivier Vignaud {@literal {@literal <ovi@ubiqube.com>}}
 *
 */
@RestController
public class VnfIdentifierDeletionNotification261Sol003Controller implements VnfIdentifierDeletionNotification261Sol003Api {
	private final VnfLcmNotificationFrontController fc;
	private final MapperFacade mapper;

	public VnfIdentifierDeletionNotification261Sol003Controller(final VnfLcmNotificationFrontController fc, final MapperFacade mapper) {
		this.fc = fc;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<Void> vnfIdentifierDeletionNotificationGet() {
		return fc.deletionCheck();
	}

	@Override
	public ResponseEntity<Void> vnfIdentifierDeletionNotificationPost(@Valid final VnfIdentifierDeletionNotification body) {
		final VnfLcmNotification req = mapper.map(body, VnfLcmNotification.class);
		return fc.deletionNotification(req, "2.6.1");
	}

}
