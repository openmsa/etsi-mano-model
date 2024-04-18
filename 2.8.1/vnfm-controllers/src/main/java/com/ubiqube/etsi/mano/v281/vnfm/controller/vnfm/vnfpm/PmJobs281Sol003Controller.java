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
package com.ubiqube.etsi.mano.v281.vnfm.controller.vnfm.vnfpm;

import static com.ubiqube.etsi.mano.Constants.getSafeUUID;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v281.model.em.vnfind.CreatePmJobRequest;
import com.ubiqube.etsi.mano.v281.model.em.vnfind.PerformanceReport;
import com.ubiqube.etsi.mano.v281.model.em.vnfind.PmJob;
import com.ubiqube.etsi.mano.v281.model.em.vnfind.PmJobLinks;
import com.ubiqube.etsi.mano.v281.model.em.vnfind.PmJobModifications;
import com.ubiqube.etsi.mano.v281.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.vnfm.fc.vnfpm.VnfmPmGenericFrontController;

import jakarta.validation.Valid;
import ma.glasnost.orika.MapperFacade;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
public class PmJobs281Sol003Controller implements PmJobs281Sol003Api {
	private final VnfmPmGenericFrontController vnfmPmGenericFrontController;
	private final MapperFacade mapper;

	public PmJobs281Sol003Controller(final VnfmPmGenericFrontController vnfmPmGenericFrontController, final MapperFacade mapper) {
		this.vnfmPmGenericFrontController = vnfmPmGenericFrontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<String> pmJobsGet(final MultiValueMap<String, String> requestParams, final String nextpageOpaqueMarker) {
		return vnfmPmGenericFrontController.search(requestParams, x -> mapper.map(x, PmJob.class), PmJobs281Sol003Controller::makeLinks, PmJob.class);
	}

	private static void makeLinks(final PmJob x) {
		final PmJobLinks links = new PmJobLinks();
		Link link = new Link();
		link.setHref(linkTo(methodOn(PmJobs281Sol003Api.class).pmJobsPmJobIdGet(x.getId())).withSelfRel().getHref());
		links.setSelf(link);

		link = new Link();
		link.setHref("");
		// links.setObjects(link);

		x.setLinks(links);
	}

	private static String makeSelf(final PmJob pmjob) {
		return linkTo(methodOn(PmJobs281Sol003Api.class).pmJobsPmJobIdGet(pmjob.getId())).withSelfRel().getHref();
	}

	@Override
	public ResponseEntity<Void> pmJobsPmJobIdDelete(final String pmJobId) {
		return vnfmPmGenericFrontController.deleteById(UUID.fromString(pmJobId));
	}

	@Override
	public ResponseEntity<PmJob> pmJobsPmJobIdGet(final String pmJobIdn) {
		return vnfmPmGenericFrontController.findById(UUID.fromString(pmJobIdn), x -> mapper.map(x, PmJob.class), PmJobs281Sol003Controller::makeLinks);
	}

	@Override
	public ResponseEntity<PerformanceReport> pmJobsPmJobIdReportsReportIdGet(final String pmJobId, final String reportId) {
		return vnfmPmGenericFrontController.findReportById(pmJobId, reportId, x -> mapper.map(x, PerformanceReport.class));
	}

	@Override
	public ResponseEntity<PmJob> pmJobsPost(@Valid final CreatePmJobRequest createPmJobRequest) {
		final com.ubiqube.etsi.mano.dao.mano.pm.PmJob req = mapper.map(createPmJobRequest, com.ubiqube.etsi.mano.dao.mano.pm.PmJob.class);
		return vnfmPmGenericFrontController.pmJobsPost(req, x -> mapper.map(x, PmJob.class), PmJobs281Sol003Controller::makeLinks, PmJobs281Sol003Controller::makeSelf);
	}

	@Override
	public ResponseEntity<PmJobModifications> pmJobsPmJobIdPatch(final String pmJobId, final PmJobModifications pmJobModifications, final String ifMatch) {
		return vnfmPmGenericFrontController.pmJobsPmJobIdPatch(getSafeUUID(pmJobId), pmJobModifications);
	}

}
