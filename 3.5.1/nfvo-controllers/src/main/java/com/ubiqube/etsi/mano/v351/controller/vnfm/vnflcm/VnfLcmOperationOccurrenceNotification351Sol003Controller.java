package com.ubiqube.etsi.mano.v351.controller.vnfm.vnflcm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.vnflcm.VnfLcmNotificationFrontController;
import com.ubiqube.etsi.mano.dao.mano.vnflcm.VnfLcmNotification;
import com.ubiqube.etsi.mano.v351.model.vnfm.vnflcm.VnfLcmOperationOccurrenceNotification;
import com.ubiqube.etsi.mano.v351.service.mapping.VnfLvmNotification351Mapping;

import jakarta.validation.Valid;

@RestController
public class VnfLcmOperationOccurrenceNotification351Sol003Controller implements VnfLcmOperationOccurrenceNotification351Sol003Api {
	private final VnfLcmNotificationFrontController fc;
	private final VnfLvmNotification351Mapping mapper;

	public VnfLcmOperationOccurrenceNotification351Sol003Controller(final VnfLcmNotificationFrontController fc, final VnfLvmNotification351Mapping mapper) {
		this.fc = fc;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<Void> vnflcmopoccCheck() {
		return fc.vnflcmopoccCheck();
	}

	@Override
	public ResponseEntity<Void> lcmOperationOccurrenceNotificationPost(@Valid final VnfLcmOperationOccurrenceNotification body) {
		final VnfLcmNotification req = mapper.map(body);
		return fc.vnflcmopoccNotification(req, "3.5.1");
	}

}
