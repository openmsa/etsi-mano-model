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
package com.ubiqube.etsi.mano.v351.nfvo.controller.nfvo.nfvici;

import java.util.List;

import org.springframework.context.annotation.Conditional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.SingleControllerCondition;
import com.ubiqube.etsi.mano.v351.model.nfvo.nfvici.CapacityThreshold;
import com.ubiqube.etsi.mano.v351.model.nfvo.nfvici.CapacityThresholdModifications;
import com.ubiqube.etsi.mano.v351.model.nfvo.nfvici.CreateCapacityThresholdRequest;

import jakarta.validation.Valid;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
@Conditional(SingleControllerCondition.class)
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
