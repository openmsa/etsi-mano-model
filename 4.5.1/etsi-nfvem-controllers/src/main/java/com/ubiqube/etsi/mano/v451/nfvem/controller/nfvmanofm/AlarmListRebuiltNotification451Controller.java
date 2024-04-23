package com.ubiqube.etsi.mano.v451.nfvem.controller.nfvmanofm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v451.model.em.vnffm.AlarmListRebuiltNotification;

import jakarta.validation.Valid;

@RestController
public class AlarmListRebuiltNotification451Controller implements AlarmListRebuiltNotification451Api {

	@Override
	public ResponseEntity<Void> uRIIsProvidedByTheClientWhenCreatingTheSubscriptionAlarmListRebuiltNotificationGet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> uRIIsProvidedByTheClientWhenCreatingTheSubscriptionAlarmListRebuiltNotificationPost(@Valid final AlarmListRebuiltNotification body) {
		// TODO Auto-generated method stub
		return null;
	}

}
