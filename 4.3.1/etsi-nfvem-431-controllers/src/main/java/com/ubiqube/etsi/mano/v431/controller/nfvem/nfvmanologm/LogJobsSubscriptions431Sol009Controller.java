/**
 *     Copyright (C) 2019-2024 Ubiqube.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.ubiqube.etsi.mano.v431.controller.nfvem.nfvmanologm;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.nfvmanologm.LogJobsSubscriptionFrontController;
import com.ubiqube.etsi.mano.service.event.model.Subscription;
import com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanologm.LogmNotificationsFilter;
import com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanologm.LogmSubscription;
import com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanologm.LogmSubscriptionRequest;
import com.ubiqube.etsi.mano.v431.service.mapping.subscription.LogmSubscription451Mapping;

import jakarta.validation.Valid;

@RestController
public class LogJobsSubscriptions431Sol009Controller implements LogJobsSubscriptions431Sol009Api {
	private final LogJobsSubscriptionFrontController logJobsFrontController;
	private final LogmSubscription451Mapping logmSubscriptionMapping;

	public LogJobsSubscriptions431Sol009Controller(final LogJobsSubscriptionFrontController logJobsFrontController, final LogmSubscription451Mapping logmSubscriptionMapping) {
		this.logJobsFrontController = logJobsFrontController;
		this.logmSubscriptionMapping = logmSubscriptionMapping;
	}

	@Override
	public ResponseEntity<List<LogmSubscription>> subscriptionsGet(@Valid final String filter, @Valid final String nextpageOpaqueMarker) {
		return logJobsFrontController.search(filter, x -> logmSubscriptionMapping.map(x, LogmNotificationsFilter.class));
	}

	@Override
	public ResponseEntity<LogmSubscription> subscriptionsPost(@Valid final LogmSubscriptionRequest body) {
		final Subscription req = logmSubscriptionMapping.map(body);
		return logJobsFrontController.create(req, x -> logmSubscriptionMapping.map(x, LogmNotificationsFilter.class));
	}

	@Override
	public ResponseEntity<Void> subscriptionsSubscriptionIdDelete(final String subscriptionId) {
		return logJobsFrontController.delete(subscriptionId);
	}

	@Override
	public ResponseEntity<LogmSubscription> subscriptionsSubscriptionIdGet(final String subscriptionId) {
		return logJobsFrontController.findById(subscriptionId, x -> logmSubscriptionMapping.map(x, LogmNotificationsFilter.class));
	}

}
