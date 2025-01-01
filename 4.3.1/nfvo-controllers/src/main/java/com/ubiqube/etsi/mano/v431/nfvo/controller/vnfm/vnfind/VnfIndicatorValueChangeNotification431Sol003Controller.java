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
package com.ubiqube.etsi.mano.v431.nfvo.controller.vnfm.vnfind;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.vnfind.VnfIndicatorNotificationFrontController;
import com.ubiqube.etsi.mano.dao.mano.ind.VnfIndiValueChangeNotification;
import com.ubiqube.etsi.mano.v431.model.em.vnfind.VnfIndicatorValueChangeNotification;
import com.ubiqube.etsi.mano.v431.service.mapping.PmJobNotification431Mapping;

import jakarta.annotation.Nonnull;
import jakarta.validation.Valid;

@RestController
public class VnfIndicatorValueChangeNotification431Sol003Controller implements VnfIndicatorValueChangeNotification431Sol003Api {
	private final VnfIndicatorNotificationFrontController fc;
	private final PmJobNotification431Mapping mapper;

	public VnfIndicatorValueChangeNotification431Sol003Controller(final VnfIndicatorNotificationFrontController fc, final PmJobNotification431Mapping mapper) {
		this.fc = fc;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<Void> valueChangeCheck() {
		return fc.valueChangeCheck();
	}

	@Override
	public ResponseEntity<Void> valueChangePost(@Valid final @Nonnull VnfIndicatorValueChangeNotification body) {
		final VnfIndiValueChangeNotification req = mapper.map(body);
		return fc.valueChangeNotification(req, "3.6.1");
	}

	@Override
	public ResponseEntity<Void> supportedCheck() {
		return fc.supportedChangeCheck();
	}

	@Override
	public ResponseEntity<Void> supportedChangePost(@Valid final @Nonnull VnfIndicatorValueChangeNotification body) {
		final VnfIndiValueChangeNotification req = mapper.map(body);
		return fc.supportedChangeNotification(req, "3.6.1");
	}

}
