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
package com.ubiqube.etsi.mano.v261.nfvo.controller.nspm;

import static com.ubiqube.etsi.mano.Constants.getSafeUUID;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.nspm.NfvoThresholdController;
import com.ubiqube.etsi.mano.dao.mano.pm.Threshold;
import com.ubiqube.etsi.mano.v261.model.nfvo.nsperfo.ThresholdsPostResponse;
import com.ubiqube.etsi.mano.v261.model.vnfm.nsperfo.CreateThresholdRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.nsperfo.ThresholdLinks;
import com.ubiqube.etsi.mano.v261.service.mapping.Threshold261Mapping;

import jakarta.validation.constraints.NotNull;

/**
 *
 * @author Olivier Vignaud {@literal {@literal <ovi@ubiqube.com>}}
 *
 */
@RestController
public class Thresholds261Sol005Controller implements Thresholds261Sol005Api {
	private static final Set<String> THR_SEARCH_MANDATORY_FIELDS = new HashSet<>(Arrays.asList("id"));
	private static final String THR_SEARCH_DEFAULT_EXCLUDE_FIELDS = "";
	private final NfvoThresholdController nfvoThresholdController;
	private final Threshold261Mapping mapper;

	public Thresholds261Sol005Controller(final NfvoThresholdController nfvoThresholdController, final Threshold261Mapping mapper) {
		this.nfvoThresholdController = nfvoThresholdController;
		this.mapper = mapper;
	}

	/**
	 * Query thresholds.
	 *
	 * The client can use this method to query information about thresholds.
	 *
	 */
	@Override
	public ResponseEntity<String> thresholdsGet(final String filter) {
		final Consumer<com.ubiqube.etsi.mano.v261.model.vnfm.nsperfo.Threshold> setLink = x -> x.setLinks(makeLinks(x.getId()));
		return nfvoThresholdController.search(new LinkedMultiValueMap<>(), x -> mapper.map(x), THR_SEARCH_DEFAULT_EXCLUDE_FIELDS, THR_SEARCH_MANDATORY_FIELDS, setLink, com.ubiqube.etsi.mano.v261.model.vnfm.nsperfo.Threshold.class);
	}

	private ThresholdLinks makeLinks(@NotNull final String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Create a threshold.
	 *
	 * The POST method can be used by the client to create a threshold. This method
	 * shall follow the provisions specified in the table 7.4.5.3.1-2 for URI query
	 * parameters, request and response data structures, and response codes.
	 *
	 */
	@Override
	public ResponseEntity<ThresholdsPostResponse> thresholdsPost(final CreateThresholdRequest createThresholdRequest) {
		final Threshold threshold = mapper.map(createThresholdRequest);
		final Threshold res = nfvoThresholdController.save(threshold);
		final ThresholdsPostResponse resp = new ThresholdsPostResponse();
//		resp.setThreshold(mapper.map(res));
		return ResponseEntity.ok(resp);
	}

	/**
	 * Delete a threshold.
	 *
	 * This method allows to delete a threshold.
	 *
	 */
	@Override
	public void thresholdsThresholdIdDelete(final String thresholdId) {
		nfvoThresholdController.delete(getSafeUUID(thresholdId));
	}

	/**
	 * Query a single threshold.
	 *
	 * The client can use this method for reading an individual threshold. This
	 * method shall follow the provisions specified in the Tables 7.4.6.3.2-1 and
	 * 7.4.6.3.2-2 for URI query parameters, request and response data structures,
	 * and response codes.
	 *
	 */
	@Override
	public ResponseEntity<ThresholdsPostResponse> thresholdsThresholdIdGet(final String thresholdId) {
		final Threshold threshold = nfvoThresholdController.findById(getSafeUUID(thresholdId));
		final ThresholdsPostResponse resp = new ThresholdsPostResponse();
//		resp.setThreshold(mapper.map(threshold));
		return ResponseEntity.ok(resp);
	}

}
