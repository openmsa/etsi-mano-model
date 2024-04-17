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
package com.ubiqube.etsi.mano.v451.vnfm.controller.em.vnfpm;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v451.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.v451.model.em.vnfpm.CreatePmJobRequest;
import com.ubiqube.etsi.mano.v451.model.em.vnfpm.PerformanceReport;
import com.ubiqube.etsi.mano.v451.model.em.vnfpm.PmJob;
import com.ubiqube.etsi.mano.v451.model.em.vnfpm.PmJobLinks;
import com.ubiqube.etsi.mano.v451.model.em.vnfpm.PmJobModifications;
import com.ubiqube.etsi.mano.v451.service.mapping.PmJob451Mapping;
import com.ubiqube.etsi.mano.vnfm.fc.vnfpm.VnfmPmGenericFrontController;

import jakarta.validation.Valid;

@RestController
public class PmJobs451Sol002Controller implements PmJobs451Sol002Api {
	private final VnfmPmGenericFrontController vnfmPmGenericFrontController;
	private final PmJob451Mapping mapper;

	public PmJobs451Sol002Controller(final VnfmPmGenericFrontController vnfmPmGenericFrontController, final PmJob451Mapping mapper) {
		this.vnfmPmGenericFrontController = vnfmPmGenericFrontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<String> pmJobsGet(final MultiValueMap<String, String> requestParams, final String nextpageOpaqueMarker) {
		return vnfmPmGenericFrontController.search(requestParams, x -> mapper.map(x), PmJobs451Sol002Controller::makeLinks, PmJob.class);
	}

	private static void makeLinks(final PmJob x) {
		final PmJobLinks links = new PmJobLinks();
		Link link = new Link();
		link.setHref(linkTo(methodOn(PmJobs451Sol002Api.class).pmJobsPmJobIdGet(x.getId())).withSelfRel().getHref());
		links.setSelf(link);

		link = new Link();
		link.setHref("");
		// links.setObjects(link);

		x.setLinks(links);
	}

	private static String makeSelf(final PmJob pmjob) {
		return linkTo(methodOn(PmJobs451Sol002Api.class).pmJobsPmJobIdGet(pmjob.getId())).withSelfRel().getHref();
	}

	@Override
	public ResponseEntity<Void> pmJobsPmJobIdDelete(final String pmJobId) {
		return vnfmPmGenericFrontController.deleteById(UUID.fromString(pmJobId));
	}

	@Override
	public ResponseEntity<PmJob> pmJobsPmJobIdGet(final String pmJobId) {
		return vnfmPmGenericFrontController.findById(UUID.fromString(pmJobId), x -> mapper.map(x), PmJobs451Sol002Controller::makeLinks);
	}

	@Override
	public ResponseEntity<PerformanceReport> pmJobsPmJobIdReportsReportIdGet(final String pmJobId, final String reportId) {
		return vnfmPmGenericFrontController.findReportById(pmJobId, reportId, x -> mapper.map(x));
	}

	@Override
	public ResponseEntity<PmJob> pmJobsPost(@Valid final CreatePmJobRequest createPmJobRequest) {
		final com.ubiqube.etsi.mano.dao.mano.pm.PmJob req = mapper.map(createPmJobRequest);
		return vnfmPmGenericFrontController.pmJobsPost(req, x -> mapper.map(x), PmJobs451Sol002Controller::makeLinks, PmJobs451Sol002Controller::makeSelf);
	}

	@Override
	public ResponseEntity<PmJobModifications> pmJobsPmJobIdPatch(final String pmJobId, final PmJobModifications pmJobModifications, final OffsetDateTime ifUnmodifiedSince, final String ifMatch) {
		return vnfmPmGenericFrontController.pmJobsPmJobIdPatch(UUID.fromString(pmJobId), pmJobModifications);
	}

}
