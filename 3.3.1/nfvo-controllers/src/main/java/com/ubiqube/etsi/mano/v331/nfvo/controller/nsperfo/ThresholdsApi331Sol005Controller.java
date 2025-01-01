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
package com.ubiqube.etsi.mano.v331.nfvo.controller.nsperfo;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.context.annotation.Conditional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.SingleControllerCondition;
import com.ubiqube.etsi.mano.v331.model.em.vnfind.CreateThresholdRequest;
import com.ubiqube.etsi.mano.v331.model.em.vnfind.Threshold;
import com.ubiqube.etsi.mano.v331.model.em.vnfind.ThresholdModifications;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
@Conditional(SingleControllerCondition.class)
public class ThresholdsApi331Sol005Controller implements Thresholds331Sol005Api {

	@Override
	public ResponseEntity<List<Threshold>> thresholdsGet(@Valid final String filter, @Valid final String nextpageOpaqueMarker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Threshold> thresholdsPost(@Valid final CreateThresholdRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> thresholdsThresholdIdDelete(final String thresholdId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Threshold> thresholdsThresholdIdGet(final String thresholdId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ThresholdModifications> thresholdsThresholdIdPatch(final String thresholdId, @Valid final ThresholdModifications body) {
		// TODO Auto-generated method stub
		return null;
	}

}
