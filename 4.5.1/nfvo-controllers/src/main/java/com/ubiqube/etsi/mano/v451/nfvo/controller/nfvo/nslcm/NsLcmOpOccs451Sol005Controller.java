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
package com.ubiqube.etsi.mano.v451.nfvo.controller.nfvo.nslcm;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v451.model.nfvo.nslcm.NsLcmInfoModificationRequest;
import com.ubiqube.etsi.mano.v451.model.nfvo.nslcm.NsLcmOpOcc;

import jakarta.validation.Valid;

@RestController
public class NsLcmOpOccs451Sol005Controller implements NsLcmOpOccs451Sol005Api {

	@Override
	public ResponseEntity<List<NsLcmOpOcc>> nsLcmOpOccsGet(@Valid final String filter, @Valid final String fields, @Valid final String excludeFields, @Valid final String excludeDefault, @Valid final String nextpageOpaqueMarker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> nsLcmOpOccsNsLcmOpOccIdContinuePost(final String nsLcmOpOccId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<NsLcmOpOcc> nsLcmOpOccsNsLcmOpOccIdGet(final String nsLcmOpOccId, final String contentType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> nsLcmOpOccsNsLcmOpOccIdPatch(final String nsLcmOpOccId, @Valid final NsLcmInfoModificationRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> nsLcmOpOccsNsLcmOpOccIdRetryPost(final String nsLcmOpOccId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> nsLcmOpOccsNsLcmOpOccIdRollbackPost(final String nsLcmOpOccId) {
		// TODO Auto-generated method stub
		return null;
	}

}
