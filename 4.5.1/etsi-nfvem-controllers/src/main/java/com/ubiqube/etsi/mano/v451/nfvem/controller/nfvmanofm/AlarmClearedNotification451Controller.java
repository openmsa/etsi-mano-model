package com.ubiqube.etsi.mano.v451.nfvem.controller.nfvmanofm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v451.model.em.vnffm.AlarmClearedNotification;

import jakarta.validation.Valid;

@RestController
public class AlarmClearedNotification451Controller implements AlarmClearedNotification451Api {

	@Override
	public ResponseEntity<Void> uRIIsProvidedByTheClientWhenCreatingTheSubscriptionAlarmClearedNotificationGet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> uRIIsProvidedByTheClientWhenCreatingTheSubscriptionAlarmClearedNotificationPost(@Valid final AlarmClearedNotification body) {
		// TODO Auto-generated method stub
		return null;
	}

}
