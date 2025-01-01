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
package com.ubiqube.etsi.mano.v431.controller.nfvem.nfvmanologm;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.nfvmanologm.LogJobsFrontController;
import com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanologm.CompileLogRequest;
import com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanologm.CreateLoggingJobRequest;
import com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanologm.LogReport;
import com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanologm.LoggingJob;
import com.ubiqube.etsi.mano.v431.service.mapping.sol009.Logm451Mapping;

import jakarta.validation.Valid;

@RestController
public class LogJobs431Sol009Controller implements LogJobs431Sol009Api {
	private final LogJobsFrontController logJobsFrontController;
	private final Logm451Mapping logm451Mapping;

	public LogJobs431Sol009Controller(final LogJobsFrontController logJobsFrontController, final Logm451Mapping logm451Mapping) {
		this.logJobsFrontController = logJobsFrontController;
		this.logm451Mapping = logm451Mapping;
	}

	@Override
	public ResponseEntity<String> logJobsGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return logJobsFrontController.search(requestParams, logm451Mapping::map, nextpageOpaqueMarker);
	}

	@Override
	public ResponseEntity<LogReport> logJobsLogJobIdCompileLogPost(final String logJobId, @Valid final CompileLogRequest body) {
		final com.ubiqube.etsi.mano.dao.mano.sol009.logm.CompileLogRequest req = logm451Mapping.map(body);
		return logJobsFrontController.compile(logJobId, req, logm451Mapping::map);
	}

	@Override
	public ResponseEntity<Void> logJobsLogJobIdDelete(final String logJobId) {
		return logJobsFrontController.delete(logJobId);
	}

	@Override
	public ResponseEntity<LoggingJob> logJobsLogJobIdGet(final String logJobId) {
		return logJobsFrontController.findById(logJobId, logm451Mapping::map);
	}

	@Override
	public ResponseEntity<LogReport> logJobsLogJobIdLogReportsLogReportIdGet(final String logJobId, final String logReportId) {
		return logJobsFrontController.findLogReport(logJobId, logReportId, logm451Mapping::map);
	}

	@Override
	public ResponseEntity<LoggingJob> logJobsPost(@Valid final CreateLoggingJobRequest body) {
		final com.ubiqube.etsi.mano.dao.mano.sol009.logm.CreateLoggingJobRequest req = logm451Mapping.map(body);
		return logJobsFrontController.create(req, logm451Mapping::map);
	}
}
