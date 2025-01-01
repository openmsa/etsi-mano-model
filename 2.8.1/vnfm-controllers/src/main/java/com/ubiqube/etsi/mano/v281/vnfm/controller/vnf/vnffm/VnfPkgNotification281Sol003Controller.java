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
package com.ubiqube.etsi.mano.v281.vnfm.controller.vnf.vnffm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v281.model.nfvo.vnf.VnfPackageChangeNotification;
import com.ubiqube.etsi.mano.v281.model.nfvo.vnf.VnfPackageOnboardingNotification;
import com.ubiqube.etsi.mano.v281.service.mapping.pkg.VnfPackageOnboardingNotification281Mapping;
import com.ubiqube.etsi.mano.vnfm.fc.vnf.VnfNotificationFrontController;

import jakarta.validation.Valid;

@RestController
public class VnfPkgNotification281Sol003Controller implements VnfPkgNotification281Sol003Api {
	private final VnfNotificationFrontController fc;
	private final VnfPackageOnboardingNotification281Mapping mapper;

	public VnfPkgNotification281Sol003Controller(final VnfNotificationFrontController fc, final VnfPackageOnboardingNotification281Mapping mapper) {
		this.fc = fc;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<Void> onboardingCheck() {
		return fc.check();
	}

	@Override
	public ResponseEntity<Void> onboardingAction(final VnfPackageOnboardingNotification body) {
		final com.ubiqube.etsi.mano.dao.mano.VnfPackageOnboardingNotification req = mapper.map(body);
		return fc.onNotification(req, "2.8.1");
	}

	@Override
	public ResponseEntity<Void> changeCheck() {
		return fc.check();
	}

	@Override
	public ResponseEntity<Void> changeAction(@Valid final VnfPackageChangeNotification body) {
		final com.ubiqube.etsi.mano.dao.mano.VnfPackageChangeNotification req = mapper.map(body);
		return fc.onChange(req, "2.8.1");
	}

}
