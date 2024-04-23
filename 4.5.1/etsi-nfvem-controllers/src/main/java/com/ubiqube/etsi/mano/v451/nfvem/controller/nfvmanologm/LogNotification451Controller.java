package com.ubiqube.etsi.mano.v451.nfvem.controller.nfvmanologm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v451.model.nfvmanologm2.LogReportAvailableNotification;

import jakarta.validation.Valid;

@RestController
public class LogNotification451Controller implements LogNotification451Api {

	@Override
	public ResponseEntity<Void> logNotificationGet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> logNotificationPost(@Valid final LogReportAvailableNotification body) {
		// TODO Auto-generated method stub
		return null;
	}

}
