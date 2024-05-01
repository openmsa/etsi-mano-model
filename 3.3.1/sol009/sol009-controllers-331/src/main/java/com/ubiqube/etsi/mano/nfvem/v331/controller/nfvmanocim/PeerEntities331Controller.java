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
package com.ubiqube.etsi.mano.nfvem.v331.controller.nfvmanocim;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.nfvmanocim.PeerEntityFrontController;
import com.ubiqube.etsi.mano.v331.model.nfvem.nfvmanocim.CreatePeerEntityRequest;
import com.ubiqube.etsi.mano.v331.model.nfvem.nfvmanocim.PeerEntity;
import com.ubiqube.etsi.mano.v331.model.nfvem.nfvmanocim.PeerEntityConfigModificationRequest;
import com.ubiqube.etsi.mano.v331.model.nfvem.nfvmanocim.PeerEntityConfigModifications;

import jakarta.validation.Valid;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
public class PeerEntities331Controller implements PeerEntities331Api {
	private final PeerEntityFrontController peerEntityFrontController;

	public PeerEntities331Controller(final PeerEntityFrontController peerEntityFrontController) {
		this.peerEntityFrontController = peerEntityFrontController;
	}

	@Override
	public ResponseEntity<List<PeerEntity>> peerEntitiesGet(@Valid final String filter, @Valid final String allFields, @Valid final String fields, @Valid final String excludeFields, @Valid final String excludeDefault, @Valid final String nextpageOpaqueMarker) {
		return peerEntityFrontController.search(filter, PeerEntity.class);
	}

	@Override
	public ResponseEntity<Void> peerEntitiesPeerEntityIdDelete(final String peerEntityId) {
		return peerEntityFrontController.delete(peerEntityId);
	}

	@Override
	public ResponseEntity<PeerEntity> peerEntitiesPeerEntityIdGet(final String peerEntityId) {
		return peerEntityFrontController.findById(peerEntityId, PeerEntity.class);
	}

	@Override
	public ResponseEntity<PeerEntityConfigModifications> peerEntitiesPeerEntityIdPatch(final String peerEntityId, @Valid final PeerEntityConfigModificationRequest body) {
		return peerEntityFrontController.patch(peerEntityId, body, PeerEntityConfigModifications.class);
	}

	@Override
	public ResponseEntity<PeerEntity> peerEntitiesPost(@Valid final CreatePeerEntityRequest body) {
		return peerEntityFrontController.create(body, PeerEntity.class);
	}

}
