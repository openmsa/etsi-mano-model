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
package com.ubiqube.etsi.mano.v261.nfvo.controller.vnfind;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfIndicatorValueChangeNotification;
import com.ubiqube.etsi.mano.controller.vnfind.VnfIndicatorNotificationFrontController;
import com.ubiqube.etsi.mano.dao.mano.ind.VnfIndiValueChangeNotification;
import com.ubiqube.etsi.mano.v261.service.mapping.PmJobNotification261Mapping;

import jakarta.annotation.Nonnull;
import jakarta.validation.Valid;

/**
 *
 * @author olivier
 *
 */
@RestController
public class VnfIndNotification261Sol003Controller implements VnfIndNotification261Sol003Api {
	private final VnfIndicatorNotificationFrontController fc;
	private final PmJobNotification261Mapping mapper;

	public VnfIndNotification261Sol003Controller(final VnfIndicatorNotificationFrontController fc, final PmJobNotification261Mapping mapper) {
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
		return fc.valueChangeNotification(req, "2.6.1");
	}

	@Override
	public ResponseEntity<Void> supportedCheck() {
		return fc.supportedChangeCheck();
	}

	@Override
	public ResponseEntity<Void> supportedChangePost(@Valid final @Nonnull VnfIndicatorValueChangeNotification body) {
		final VnfIndiValueChangeNotification req = mapper.map(body);
		return fc.supportedChangeNotification(req, "2.6.1");
	}

}
