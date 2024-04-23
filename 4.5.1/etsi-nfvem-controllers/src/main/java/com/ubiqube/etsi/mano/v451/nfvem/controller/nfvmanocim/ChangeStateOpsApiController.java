package com.ubiqube.etsi.mano.v451.nfvem.controller.nfvmanocim;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v451.model.nfvmanocim.ChangeStateOpOcc;

import jakarta.validation.Valid;

@RestController
public class ChangeStateOpsApiController implements ChangeStateOpsApi {

	@Override
	public ResponseEntity<ChangeStateOpOcc> changeStateOpsChangeStateOpOccIdGet(final String changeStateOpOccId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<ChangeStateOpOcc>> changeStateOpsGet(@Valid final String filter, @Valid final String allFields, @Valid final String fields, @Valid final String excludeFields, @Valid final String excludeDefault, @Valid final String nextpageOpaqueMarker) {
		// TODO Auto-generated method stub
		return null;
	}

}
