package com.ubiqube.etsi.mano.nfvo.v351.controller.nfvici;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.nfvo.v351.model.nfvici.CapacityThreshold;
import com.ubiqube.etsi.mano.nfvo.v351.model.nfvici.CapacityThresholdModifications;
import com.ubiqube.etsi.mano.nfvo.v351.model.nfvici.CreateCapacityThresholdRequest;

/**
 *
 * @author Olivier Vignaud <ovi@ubiqube.com>
 *
 */
@RestController
public class CapacityThresholds351Sol005Controller implements CapacityThresholds351Sol005Api {

	@Override
	public ResponseEntity<Void> capacityThresholdsCapacityThresholdIdDelete(final String capacityThresholdId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CapacityThreshold> capacityThresholdsCapacityThresholdIdGet(final String capacityThresholdId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CapacityThresholdModifications> capacityThresholdsCapacityThresholdIdPatch(final String capacityThresholdId, @Valid final CapacityThresholdModifications body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<CapacityThreshold>> capacityThresholdsGet(@Valid final String filter, @Valid final String nextpageOpaqueMarker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CapacityThreshold> capacityThresholdsPost(final String contentType, @Valid final CreateCapacityThresholdRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

}