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
package com.ubiqube.etsi.mano.nfvo.v451.controller.nslcm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.nfvo.v451.model.nslcm.NsChangeNotification;
import com.ubiqube.etsi.mano.nfvo.v451.model.nslcm.NsIdentifierCreationNotification;
import com.ubiqube.etsi.mano.nfvo.v451.model.nslcm.NsIdentifierDeletionNotification;
import com.ubiqube.etsi.mano.nfvo.v451.model.nslcm.NsLcmCapacityShortageNotification;
import com.ubiqube.etsi.mano.nfvo.v451.model.nslcm.NsLcmOperationOccurrenceNotification;

import jakarta.validation.Valid;

@RestController
public class NsLcmNotification451Sol005Controller implements NsLcmNotification451Sol005Api {

	@Override
	public ResponseEntity<Void> nsLcmOperationOccurrenceCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> nsLcmOperationOccurrencePost(@Valid final NsLcmOperationOccurrenceNotification body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> nsLcmCapacityShortageCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> nsLcmCapacityShortagePost(@Valid final NsLcmCapacityShortageNotification body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> nsIdentifierDeletionCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> nsIdentifierDeletionPost(@Valid final NsIdentifierDeletionNotification body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> nsIdentifierCreationCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> nsIdentifierCreationPost(@Valid final NsIdentifierCreationNotification body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> nsChangeCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> nsChangePost(@Valid final NsChangeNotification body) {
		// TODO Auto-generated method stub
		return null;
	}
}
