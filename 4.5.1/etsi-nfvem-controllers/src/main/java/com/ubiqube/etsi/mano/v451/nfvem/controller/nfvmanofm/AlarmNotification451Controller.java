package com.ubiqube.etsi.mano.v451.nfvem.controller.nfvmanofm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v451.model.em.vnffm.AlarmNotification;

import jakarta.validation.Valid;

@RestController
public class AlarmNotification451Controller implements AlarmNotification451Api {

	@Override
	public ResponseEntity<Void> uRIIsProvidedByTheClientWhenCreatingTheSubscriptionAlarmNotificationGet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> uRIIsProvidedByTheClientWhenCreatingTheSubscriptionAlarmNotificationPost(@Valid final AlarmNotification body) {
		// TODO Auto-generated method stub
		return null;
	}

}
