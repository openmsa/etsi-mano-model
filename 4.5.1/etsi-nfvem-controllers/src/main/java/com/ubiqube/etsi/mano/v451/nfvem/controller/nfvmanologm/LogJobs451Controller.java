package com.ubiqube.etsi.mano.v451.nfvem.controller.nfvmanologm;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v451.model.nfvmanologm2.CompileLogRequest;
import com.ubiqube.etsi.mano.v451.model.nfvmanologm2.CreateLoggingJobRequest;
import com.ubiqube.etsi.mano.v451.model.nfvmanologm2.LogReport;
import com.ubiqube.etsi.mano.v451.model.nfvmanologm2.LoggingJob;

import jakarta.validation.Valid;

@RestController
public class LogJobs451Controller implements LogJobs451Api {

	@Override
	public ResponseEntity<List<LoggingJob>> logJobsGet(@Valid final String filter, @Valid final String allFields, @Valid final String fields, @Valid final String excludeFields, @Valid final String excludeDefault, @Valid final String nextpageOpaqueMarker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<LogReport> logJobsLogJobIdCompileLogPost(final String logJobId, @Valid final CompileLogRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> logJobsLogJobIdDelete(final String logJobId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<LoggingJob> logJobsLogJobIdGet(final String logJobId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<LogReport> logJobsLogJobIdLogReportsLogReportIdGet(final String logJobId, final String logReportId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<LoggingJob> logJobsPost(@Valid final CreateLoggingJobRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

}
