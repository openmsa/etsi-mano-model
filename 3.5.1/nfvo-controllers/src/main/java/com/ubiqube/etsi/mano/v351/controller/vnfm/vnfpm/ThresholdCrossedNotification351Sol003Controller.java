package com.ubiqube.etsi.mano.v351.controller.vnfm.vnfpm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.vnf.VnfPerformanceNotificationFrontController;
import com.ubiqube.etsi.mano.v351.model.vnfm.vnfpm.ThresholdCrossedNotification;
import com.ubiqube.etsi.mano.v351.services.mapping.PmJobNotification351Mapping;

import jakarta.validation.Valid;

@RestController
public class ThresholdCrossedNotification351Sol003Controller implements ThresholdCrossedNotification351Sol003Api {

	private final VnfPerformanceNotificationFrontController fc;
	private final PmJobNotification351Mapping mapper;

	public ThresholdCrossedNotification351Sol003Controller(final VnfPerformanceNotificationFrontController fc, final PmJobNotification351Mapping mapper) {
		this.fc = fc;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<Void> crossedCheck() {
		return fc.crossedCheck();
	}

	@Override
	public ResponseEntity<Void> crossedNotificationPost(@Valid final ThresholdCrossedNotification body) {
		final com.ubiqube.etsi.mano.dao.mano.pm.ThresholdCrossedNotification req = mapper.map(body);
		return fc.crossedPost(req, "3.6.1");
	}

}
