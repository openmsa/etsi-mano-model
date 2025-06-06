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
package com.ubiqube.etsi.mano.v351.vnfm.controller.em.vnfpm;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.UUID;

import org.springframework.context.annotation.Conditional;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.SingleControllerCondition;
import com.ubiqube.etsi.mano.v351.model.em.lcmcoord.Link;
import com.ubiqube.etsi.mano.v351.model.em.vnfpm.CreatePmJobRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnfpm.PerformanceReport;
import com.ubiqube.etsi.mano.v351.model.em.vnfpm.PmJob;
import com.ubiqube.etsi.mano.v351.model.em.vnfpm.PmJobLinks;
import com.ubiqube.etsi.mano.v351.model.em.vnfpm.PmJobModifications;
import com.ubiqube.etsi.mano.v351.service.mapping.PmJob351Mapping;
import com.ubiqube.etsi.mano.vnfm.fc.vnfpm.VnfmPmGenericFrontController;

import jakarta.validation.Valid;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
@Conditional(SingleControllerCondition.class)
public class PmJobs351Sol002Controller implements PmJobs351Sol002Api {
	private final VnfmPmGenericFrontController vnfmPmGenericFrontController;
	private final PmJob351Mapping mapper;

	public PmJobs351Sol002Controller(final VnfmPmGenericFrontController vnfmPmGenericFrontController, final PmJob351Mapping mapper) {
		this.vnfmPmGenericFrontController = vnfmPmGenericFrontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<String> pmJobsGet(final MultiValueMap<String, String> requestParams, final String nextpageOpaqueMarker) {
		return vnfmPmGenericFrontController.search(requestParams, x -> mapper.map(x), PmJobs351Sol002Controller::makeLinks, PmJob.class);
	}

	private static void makeLinks(final PmJob x) {
		final PmJobLinks links = new PmJobLinks();
		Link link = new Link();
		link.setHref(linkTo(methodOn(PmJobs351Sol002Api.class).pmJobsPmJobIdGet(x.getId())).withSelfRel().getHref());
		links.setSelf(link);

		link = new Link();
		link.setHref("");
		// links.setObjects(link);

		x.setLinks(links);
	}

	private static String makeSelf(final PmJob pmjob) {
		return linkTo(methodOn(PmJobs351Sol002Api.class).pmJobsPmJobIdGet(pmjob.getId())).withSelfRel().getHref();
	}

	@Override
	public ResponseEntity<Void> pmJobsPmJobIdDelete(final String pmJobId) {
		return vnfmPmGenericFrontController.deleteById(UUID.fromString(pmJobId));
	}

	@Override
	public ResponseEntity<PmJob> pmJobsPmJobIdGet(final String pmJobIdn) {
		return vnfmPmGenericFrontController.findById(UUID.fromString(pmJobIdn), x -> mapper.map(x), PmJobs351Sol002Controller::makeLinks);
	}

	@Override
	public ResponseEntity<PerformanceReport> pmJobsPmJobIdReportsReportIdGet(final String pmJobId, final String reportId) {
		return vnfmPmGenericFrontController.findReportById(pmJobId, reportId, x -> mapper.map(x));
	}

	@Override
	public ResponseEntity<PmJob> pmJobsPost(@Valid final CreatePmJobRequest createPmJobRequest) {
		final com.ubiqube.etsi.mano.dao.mano.pm.PmJob req = mapper.map(createPmJobRequest);
		return vnfmPmGenericFrontController.pmJobsPost(req, x -> mapper.map(x), PmJobs351Sol002Controller::makeLinks, PmJobs351Sol002Controller::makeSelf);
	}

	@Override
	public ResponseEntity<PmJobModifications> pmJobsPmJobIdPatch(final String pmJobId, final PmJobModifications pmJobModifications, final String ifMatch) {
		return vnfmPmGenericFrontController.pmJobsPmJobIdPatch(UUID.fromString(pmJobId), pmJobModifications);
	}

}
