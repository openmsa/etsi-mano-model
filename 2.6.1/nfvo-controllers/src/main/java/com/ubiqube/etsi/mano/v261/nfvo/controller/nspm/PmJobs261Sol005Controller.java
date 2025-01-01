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
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.common.v261.model.Link;
import com.ubiqube.etsi.mano.common.v261.model.nsperfo.PerformanceReport;
import com.ubiqube.etsi.mano.controller.nspm.NfvoPmController;
import com.ubiqube.etsi.mano.dao.mano.pm.PmJob;
import com.ubiqube.etsi.mano.v261.model.vnfm.nsperfo.CreatePmJobRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.nsperfo.PmJobLinks;
import com.ubiqube.etsi.mano.v261.service.mapping.PmJob261Mapping;

import jakarta.annotation.Nonnull;

/**
 *
 * @author Olivier Vignaud {@literal {@literal <ovi@ubiqube.com>}}
 *
 */
@RestController
public class PmJobs261Sol005Controller implements PmJobs261Sol005Api {
	private static final String PMJ_SEARCH_DEFAULT_EXCLUDE_FIELDS = "";
	@Nonnull
	private static final Set<String> PMJ_SEARCH_MANDATORY_FIELDS = Set.of("id");
	private final NfvoPmController nfvoPmController;
	private final PmJob261Mapping mapper;

	public PmJobs261Sol005Controller(final NfvoPmController nfvoPmController, final PmJob261Mapping mapper) {
		this.nfvoPmController = nfvoPmController;
		this.mapper = mapper;
	}

	/**
	 * Query PM jobs.
	 *
	 * \&quot;The client can use this method to retrieve information about PM
	 * jobs\&quot;
	 *
	 */
	@Override
	public ResponseEntity<String> pmJobsGet(final MultiValueMap<String, String> requestParams) {
		return nfvoPmController.search(requestParams, x -> mapper.map(x), PMJ_SEARCH_DEFAULT_EXCLUDE_FIELDS, PMJ_SEARCH_MANDATORY_FIELDS, PmJobs261Sol005Controller::makeLinks, com.ubiqube.etsi.mano.v261.model.vnfm.nsperfo.PmJob.class);
	}

	/**
	 * Delete a PM job.
	 *
	 * This method terminates an individual PM job.
	 *
	 * @return Void response.
	 *
	 */
	@Override
	public ResponseEntity<Void> pmJobsPmJobIdDelete(final String pmJobId) {
		nfvoPmController.deleteById(getSafeUUID(pmJobId));
		return ResponseEntity.noContent().build();
	}

	/**
	 * Read a single PM job.
	 *
	 * The client can use this method for reading an individual PM job.
	 *
	 */
	@Override
	public ResponseEntity<com.ubiqube.etsi.mano.v261.model.vnfm.nsperfo.PmJob> pmJobsPmJobIdGet(final String pmJobId) {
		final PmJob entity = nfvoPmController.getById(getSafeUUID(pmJobId));
		final com.ubiqube.etsi.mano.v261.model.vnfm.nsperfo.PmJob res = mapper.map(entity);
		return ResponseEntity.ok(res);
	}

	/**
	 * Read an individual performance report.
	 *
	 * The client can use this method for reading an individual performance report.
	 *
	 */
	@Override
	public ResponseEntity<PerformanceReport> pmJobsPmJobIdReportsReportIdGet(final String pmJobId, final String reportId) {
		final com.ubiqube.etsi.mano.dao.mano.pm.PerformanceReport report = nfvoPmController.getReportById(pmJobId, reportId);
		final PerformanceReport mapped = mapper.map(report);
		return ResponseEntity.ok(mapped);
	}

	/**
	 * Create a PM job.
	 *
	 * The POST method creates a PM job. This method shall follow the provisions
	 * specified in the Tables 7.4.2.3.1-1 and 7.4.2.3.1-2 for URI query parameters,
	 * request and response data structures, and response codes.
	 *
	 */
	@Override
	public ResponseEntity<com.ubiqube.etsi.mano.v261.model.vnfm.nsperfo.PmJob> pmJobsPost(final CreatePmJobRequest createPmJobRequest) {
		final PmJob req = mapper.map(createPmJobRequest);
		final PmJob res = nfvoPmController.save(req);
		final com.ubiqube.etsi.mano.v261.model.vnfm.nsperfo.PmJob ret = mapper.map(res);
		makeLinks(ret);
		return ResponseEntity.ok(ret);
	}

	private static void makeLinks(final com.ubiqube.etsi.mano.v261.model.vnfm.nsperfo.PmJob x) {
		final PmJobLinks links = new PmJobLinks();
		Link link = new Link();
		link.setHref(linkTo(methodOn(PmJobs261Sol005Api.class).pmJobsPmJobIdGet(x.getId())).withSelfRel().getHref());
		links.setSelf(link);

		link = new Link();
		link.setHref("");
		// links.setObjects(link)
		x.setLinks(links);
	}

}
