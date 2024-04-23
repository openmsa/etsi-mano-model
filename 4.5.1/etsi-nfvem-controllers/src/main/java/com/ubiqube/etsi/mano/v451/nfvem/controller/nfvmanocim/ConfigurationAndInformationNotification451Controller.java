package com.ubiqube.etsi.mano.v451.nfvem.controller.nfvmanocim;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class ConfigurationAndInformationNotification451Controller implements ConfigurationAndInformationNotification451Api {

	@Override
	public ResponseEntity<Void> configurationAndInformationNotificationGet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> configurationAndInformationNotificationPost(@Valid final Object body) {
		// TODO Auto-generated method stub
		return null;
	}

}
