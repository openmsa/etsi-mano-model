package com.ubiqube.etsi.mano.v451.nfvem.controller.nfvmanopm;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.dao.mano.pm.PmJob;
import com.ubiqube.etsi.mano.v451.model.em.vnfpm.CreatePmJobRequest;
import com.ubiqube.etsi.mano.v451.model.em.vnfpm.PerformanceReport;
import com.ubiqube.etsi.mano.v451.model.em.vnfpm.PmJobModifications;

import jakarta.validation.Valid;

@RestController
public class PmJobsApiController implements PmJobsApi {

	@Override
	public ResponseEntity<List<PmJob>> pmJobsGet(@Valid final String filter, @Valid final String allFields, @Valid final String fields, @Valid final String excludeFields, @Valid final String excludeDefault, @Valid final String nextpageOpaqueMarker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> pmJobsPmJobIdDelete(final String pmJobId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<PmJob> pmJobsPmJobIdGet(final String pmJobId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<PmJobModifications> pmJobsPmJobIdPatch(final String pmJobId, @Valid final PmJobModifications body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<PerformanceReport> pmJobsPmJobIdReportsReportIdGet(final String pmJobId, final String reportId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<PmJob> pmJobsPost(@Valid final CreatePmJobRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

}
