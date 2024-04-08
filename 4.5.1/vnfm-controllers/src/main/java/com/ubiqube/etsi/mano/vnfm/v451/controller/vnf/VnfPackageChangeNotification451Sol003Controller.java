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
package com.ubiqube.etsi.mano.vnfm.v451.controller.vnf;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.nfvo.v451.model.vnf.VnfPackageChangeNotification;
import com.ubiqube.etsi.mano.vnfm.fc.vnf.VnfNotificationFrontController;

import jakarta.validation.Valid;

@RestController
public class VnfPackageChangeNotification451Sol003Controller implements VnfPackageChangeNotification451Sol003Api {
	private final VnfNotificationFrontController fc;

	public VnfPackageChangeNotification451Sol003Controller(final VnfNotificationFrontController fc) {
		this.fc = fc;
	}

	@Override
	public ResponseEntity<Void> vnfPackageChangeNotificationCheck() {
		return fc.check();
	}

	@Override
	public ResponseEntity<Void> vnfPackageChangeNotificationPost(@Valid final VnfPackageChangeNotification body) {
		return fc.onNotification(body, "4.5.1");
	}

}
