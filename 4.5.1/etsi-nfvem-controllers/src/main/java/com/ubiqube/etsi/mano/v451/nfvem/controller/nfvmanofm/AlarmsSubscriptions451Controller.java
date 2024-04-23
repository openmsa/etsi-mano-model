package com.ubiqube.etsi.mano.v451.nfvem.controller.nfvmanofm;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v451.model.em.vnffm.FmSubscription;
import com.ubiqube.etsi.mano.v451.model.em.vnffm.FmSubscriptionRequest;

import jakarta.validation.Valid;

@RestController
public class AlarmsSubscriptions451Controller implements AlarmsSubscriptions451Api {

	@Override
	public ResponseEntity<List<FmSubscription>> subscriptionsGet(@Valid final String filter, @Valid final String nextpageOpaqueMarker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<FmSubscription> subscriptionsPost(@Valid final FmSubscriptionRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> subscriptionsSubscriptionIdDelete(final String subscriptionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<FmSubscription> subscriptionsSubscriptionIdGet(final String subscriptionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
