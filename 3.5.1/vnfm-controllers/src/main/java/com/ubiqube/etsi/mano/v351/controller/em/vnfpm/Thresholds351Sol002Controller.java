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
package com.ubiqube.etsi.mano.v351.controller.em.vnfpm;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import org.springframework.context.annotation.Conditional;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.SingleControllerCondition;
import com.ubiqube.etsi.mano.v351.model.em.lcmcoord.Link;
import com.ubiqube.etsi.mano.v351.model.em.vnfpm.CreateThresholdRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnfpm.Threshold;
import com.ubiqube.etsi.mano.v351.model.em.vnfpm.ThresholdLinks;
import com.ubiqube.etsi.mano.v351.model.em.vnfpm.ThresholdModifications;
import com.ubiqube.etsi.mano.vnfm.fc.vnfpm.VnfmThresholdFrontController;

import jakarta.validation.Valid;
import ma.glasnost.orika.MapperFacade;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
@Conditional(SingleControllerCondition.class)
public class Thresholds351Sol002Controller implements Thresholds351Sol002Api {
	private final VnfmThresholdFrontController vnfmThresholdFrontController;
	private final MapperFacade mapper;

	public Thresholds351Sol002Controller(final VnfmThresholdFrontController vnfmThresholdFrontController, final MapperFacade mapper) {
		this.vnfmThresholdFrontController = vnfmThresholdFrontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<Threshold> thresholdsPost(@Valid final CreateThresholdRequest createThresholdRequest) {
		final com.ubiqube.etsi.mano.dao.mano.pm.Threshold req = mapper.map(createThresholdRequest, com.ubiqube.etsi.mano.dao.mano.pm.Threshold.class);
		return vnfmThresholdFrontController.thresholdsCreate(req, x -> mapper.map(x, Threshold.class), Thresholds351Sol002Controller::makeLinks, Thresholds351Sol002Controller::getSelfLink);
	}

	@Override
	public ResponseEntity<Void> thresholdsThresholdIdDelete(final String thresholdId) {
		return vnfmThresholdFrontController.deleteById(thresholdId);
	}

	@Override
	public ResponseEntity<Threshold> thresholdsThresholdIdGet(final String thresholdId) {
		return vnfmThresholdFrontController.findById(thresholdId, x -> mapper.map(x, Threshold.class), Thresholds351Sol002Controller::makeLinks);
	}

	@Override
	public ResponseEntity<String> thresholdsGet(final MultiValueMap<String, String> requestParams, final String nextpageOpaqueMarker) {
		return vnfmThresholdFrontController.search(requestParams, nextpageOpaqueMarker, x -> mapper.map(x, Threshold.class), Thresholds351Sol002Controller::makeLinks, Threshold.class);
	}

	@Override
	public ResponseEntity<ThresholdModifications> thresholdsThresholdIdPatch(final String thresholdId, final ThresholdModifications body) {
		return vnfmThresholdFrontController.patch(thresholdId, body, x -> mapper.map(x, ThresholdModifications.class));
	}

	private static void makeLinks(final Threshold x) {
		final ThresholdLinks links = new ThresholdLinks();
		Link link = new Link();
		link.setHref(linkTo(methodOn(Thresholds351Sol002Api.class).thresholdsThresholdIdGet(x.getId())).withSelfRel().getHref());
		links.setSelf(link);

		link = new Link();
		link.setHref("");
		// links.setObjects(link);

		x.setLinks(links);
	}

	private static String getSelfLink(final Threshold threshold) {
		return linkTo(methodOn(Thresholds351Sol002Api.class).thresholdsThresholdIdGet(threshold.getId().toString())).withSelfRel().getHref();
	}

}
