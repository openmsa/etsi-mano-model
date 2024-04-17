package com.ubiqube.etsi.mano.v351.nfvo.controller.vnfm.vnflcm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.vnflcm.VnfLcmNotificationFrontController;
import com.ubiqube.etsi.mano.dao.mano.vnflcm.VnfLcmNotification;
import com.ubiqube.etsi.mano.v351.model.vnfm.vnflcm.VnfIdentifierDeletionNotification;
import com.ubiqube.etsi.mano.v351.service.mapping.VnfLvmNotification351Mapping;

@RestController
public class VnfIdentifierDeletionNotification351Sol003Controller implements VnfIdentifierDeletionNotification351Sol003Api {
	private final VnfLcmNotificationFrontController fc;
	private final VnfLvmNotification351Mapping mapper;

	public VnfIdentifierDeletionNotification351Sol003Controller(final VnfLcmNotificationFrontController fc, final VnfLvmNotification351Mapping mapper) {
		this.fc = fc;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<Void> deletionCheck() {
		return fc.deletionCheck();
	}

	@Override
	public ResponseEntity<Void> deletionNotificationPost(final VnfIdentifierDeletionNotification body) {
		final VnfLcmNotification req = mapper.map(body);
		return fc.deletionNotification(req, "3.5.1");
	}

}
