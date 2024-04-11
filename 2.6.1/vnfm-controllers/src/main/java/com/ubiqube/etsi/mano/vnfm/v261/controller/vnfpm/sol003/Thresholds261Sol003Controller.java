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
package com.ubiqube.etsi.mano.vnfm.v261.controller.vnfpm.sol003;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.common.v261.model.Link;
import com.ubiqube.etsi.mano.vnfm.fc.vnfpm.VnfmThresholdFrontController;
import com.ubiqube.etsi.mano.vnfm.v261.model.nsperfo.CreateThresholdRequest;
import com.ubiqube.etsi.mano.vnfm.v261.model.nsperfo.Threshold;
import com.ubiqube.etsi.mano.vnfm.v261.model.nsperfo.ThresholdLinks;

import jakarta.validation.Valid;
import ma.glasnost.orika.MapperFacade;

@RestController
public class Thresholds261Sol003Controller implements Thresholds261Sol003Api {
	private final VnfmThresholdFrontController vnfmThresholdFrontController;
	private final MapperFacade mapper;

	public Thresholds261Sol003Controller(final VnfmThresholdFrontController vnfmThresholdFrontController, final MapperFacade mapper) {
		this.vnfmThresholdFrontController = vnfmThresholdFrontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<Threshold> thresholdsPost(@Valid final CreateThresholdRequest createThresholdRequest) {
		final com.ubiqube.etsi.mano.dao.mano.pm.Threshold req = mapper.map(createThresholdRequest, com.ubiqube.etsi.mano.dao.mano.pm.Threshold.class);
		return vnfmThresholdFrontController.thresholdsCreate(req, x -> mapper.map(x, Threshold.class), Thresholds261Sol003Controller::makeLinks, Thresholds261Sol003Controller::getSelfLink);
	}

	@Override
	public ResponseEntity<Void> thresholdsThresholdIdDelete(final String thresholdId) {
		return vnfmThresholdFrontController.deleteById(thresholdId);
	}

	@Override
	public ResponseEntity<Threshold> thresholdsThresholdIdGet(final String thresholdId) {
		return vnfmThresholdFrontController.findById(thresholdId, x -> mapper.map(x, Threshold.class), Thresholds261Sol003Controller::makeLinks);
	}

	@Override
	public ResponseEntity<String> thresholdsGet(final MultiValueMap<String, String> requestParams, final String nextpageOpaqueMarker) {
		return vnfmThresholdFrontController.search(requestParams, nextpageOpaqueMarker, x -> mapper.map(x, Threshold.class), Thresholds261Sol003Controller::makeLinks, Threshold.class);
	}

	private static void makeLinks(final Threshold threshold) {
		final ThresholdLinks thresholdLinks = new ThresholdLinks();
		final Link self = new Link();
		self.setHref(linkTo(methodOn(Thresholds261Sol003Api.class).thresholdsThresholdIdGet(threshold.getId().toString())).withSelfRel().getHref());
		thresholdLinks.setSelf(self);
		threshold.setLinks(thresholdLinks);
	}

	private static String getSelfLink(final Threshold threshold) {
		return linkTo(methodOn(Thresholds261Sol003Api.class).thresholdsThresholdIdGet(threshold.getId().toString())).withSelfRel().getHref();
	}

}
