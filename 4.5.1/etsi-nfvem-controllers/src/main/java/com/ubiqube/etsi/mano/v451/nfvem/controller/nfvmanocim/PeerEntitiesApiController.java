package com.ubiqube.etsi.mano.v451.nfvem.controller.nfvmanocim;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v451.model.nfvmanocim.CreatePeerEntityRequest;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.PeerEntity;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.PeerEntityConfigModificationRequest;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.PeerEntityConfigModifications;

import jakarta.validation.Valid;

@RestController
public class PeerEntitiesApiController implements PeerEntitiesApi {

	@Override
	public ResponseEntity<List<PeerEntity>> peerEntitiesGet(@Valid final String filter, @Valid final String allFields, @Valid final String fields, @Valid final String excludeFields, @Valid final String excludeDefault, @Valid final String nextpageOpaqueMarker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> peerEntitiesPeerEntityIdDelete(final String peerEntityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<PeerEntity> peerEntitiesPeerEntityIdGet(final String peerEntityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<PeerEntityConfigModifications> peerEntitiesPeerEntityIdPatch(final String peerEntityId, @Valid final PeerEntityConfigModificationRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<PeerEntity> peerEntitiesPost(@Valid final CreatePeerEntityRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

}
