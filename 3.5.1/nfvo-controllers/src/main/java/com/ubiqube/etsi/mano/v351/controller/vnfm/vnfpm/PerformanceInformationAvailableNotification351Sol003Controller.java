package com.ubiqube.etsi.mano.v351.controller.vnfm.vnfpm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.vnf.VnfPerformanceNotificationFrontController;
import com.ubiqube.etsi.mano.v351.model.vnfm.vnfpm.PerformanceInformationAvailableNotification;
import com.ubiqube.etsi.mano.v351.service.mapping.PmJobNotification351Mapping;

import jakarta.validation.Valid;

@RestController
public class PerformanceInformationAvailableNotification351Sol003Controller implements PerformanceInformationAvailableNotification351Sol003Api {

	private final VnfPerformanceNotificationFrontController fc;
	private final PmJobNotification351Mapping mapper;

	public PerformanceInformationAvailableNotification351Sol003Controller(final VnfPerformanceNotificationFrontController fc, final PmJobNotification351Mapping mapper) {
		this.fc = fc;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<Void> availableCheck() {
		return fc.availableCheck();
	}

	@Override
	public ResponseEntity<Void> availableNotificationPost(@Valid final PerformanceInformationAvailableNotification body) {
		final com.ubiqube.etsi.mano.dao.mano.pm.PerformanceInformationAvailableNotification req = mapper.map(body);
		return fc.availablePost(req, "3.5.1");
	}

}
