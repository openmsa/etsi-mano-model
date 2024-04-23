package com.ubiqube.etsi.mano.v451.nfvem.controller.nfvmanologm;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v451.model.nfvmanologm2.LogmSubscription;
import com.ubiqube.etsi.mano.v451.model.nfvmanologm2.LogmSubscriptionRequest;

import jakarta.validation.Valid;

@RestController
public class LogJobsSubscriptions451Controller implements LogJobsSubscriptions451Api {

	@Override
	public ResponseEntity<List<LogmSubscription>> subscriptionsGet(@Valid final String filter, @Valid final String nextpageOpaqueMarker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<LogmSubscription> subscriptionsPost(@Valid final LogmSubscriptionRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> subscriptionsSubscriptionIdDelete(final String subscriptionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<LogmSubscription> subscriptionsSubscriptionIdGet(final String subscriptionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
