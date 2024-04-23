package com.ubiqube.etsi.mano.v451.nfvem.controller.nfvmanocim;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v451.model.nfvmanocim.ChangeStateRequest;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.ManoConfigModificationRequest;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.ManoConfigModifications;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.ManoEntity;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.ManoServiceInterface;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.ManoServiceInterfaceModificationRequest;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.ManoServiceInterfaceModifications;

import jakarta.validation.Valid;

@RestController
public class ManoEntityApiController implements ManoEntityApi {

	@Override
	public ResponseEntity<Void> manoEntityChangeStatePost(@Valid final ChangeStateRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ManoEntity> manoEntityGet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<ManoServiceInterface>> manoEntityManoInterfacesGet(@Valid final String filter, @Valid final String allFields, @Valid final String fields, @Valid final String excludeFields, @Valid final String excludeDefault, @Valid final String nextpageOpaqueMarker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> manoEntityManoInterfacesManoServiceInterfaceIdChangeStatePost(final String manoServiceInterfaceId, @Valid final ChangeStateRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ManoServiceInterface> manoEntityManoInterfacesManoServiceInterfaceIdGet(final String manoServiceInterfaceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ManoServiceInterfaceModifications> manoEntityManoInterfacesManoServiceInterfaceIdPatch(final String manoServiceInterfaceId, @Valid final ManoServiceInterfaceModificationRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ManoConfigModifications> manoEntityPatch(@Valid final ManoConfigModificationRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

}
