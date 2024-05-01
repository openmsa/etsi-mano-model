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
package com.ubiqube.etsi.mano.nfvem.v331.controller.nfvmanologm;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.nfvmanologm.LogJobsFrontController;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanologm.CompileLogRequest;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanologm.CreateLoggingJobRequest;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanologm.LogReport;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanologm.LoggingJob;
import com.ubiqube.etsi.mano.nfvem.v331.service.mapping.Logm331Mapping;

import jakarta.validation.Valid;

@RestController
public class LogJobs331Controller implements LogJobs331Api {
	private final LogJobsFrontController logJobsFrontController;
	private final Logm331Mapping logm331Mapping;

	public LogJobs331Controller(final LogJobsFrontController logJobsFrontController, final Logm331Mapping logm331Mapping) {
		this.logJobsFrontController = logJobsFrontController;
		this.logm331Mapping = logm331Mapping;
	}

	@Override
	public ResponseEntity<String> logJobsGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return logJobsFrontController.search(requestParams, logm331Mapping::map, nextpageOpaqueMarker);
	}

	@Override
	public ResponseEntity<LogReport> logJobsLogJobIdCompileLogPost(final String logJobId, @Valid final CompileLogRequest body) {
		final com.ubiqube.etsi.mano.dao.mano.sol009.logm.CompileLogRequest req = logm331Mapping.map(body);
		return logJobsFrontController.compile(logJobId, req, logm331Mapping::map);
	}

	@Override
	public ResponseEntity<Void> logJobsLogJobIdDelete(final String logJobId) {
		return logJobsFrontController.delete(logJobId);
	}

	@Override
	public ResponseEntity<LoggingJob> logJobsLogJobIdGet(final String logJobId) {
		return logJobsFrontController.findById(logJobId, logm331Mapping::map);
	}

	@Override
	public ResponseEntity<LogReport> logJobsLogJobIdLogReportsLogReportIdGet(final String logJobId, final String logReportId) {
		return logJobsFrontController.findLogReport(logJobId, logReportId, logm331Mapping::map);
	}

	@Override
	public ResponseEntity<LoggingJob> logJobsPost(@Valid final CreateLoggingJobRequest body) {
		final com.ubiqube.etsi.mano.dao.mano.sol009.logm.CreateLoggingJobRequest req = logm331Mapping.map(body);
		return logJobsFrontController.create(req, logm331Mapping::map);
	}

}
