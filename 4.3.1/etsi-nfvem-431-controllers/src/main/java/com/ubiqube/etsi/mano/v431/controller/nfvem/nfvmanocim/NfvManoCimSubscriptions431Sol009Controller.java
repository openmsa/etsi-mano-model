/**
 * Copyright (C) 2019-2025 Ubiqube.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */
package com.ubiqube.etsi.mano.v431.controller.nfvem.nfvmanocim;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanocim.CimSubscription;
import com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanocim.CimSubscriptionRequest;

@RestController
public class NfvManoCimSubscriptions431Sol009Controller implements NfvManoCimSubscriptions431Sol009Api {

	@Override
	public ResponseEntity<List<CimSubscription>> subscriptionsGet(@Valid final String filter, @Valid final String nextpageOpaqueMarker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CimSubscription> subscriptionsPost(@Valid final CimSubscriptionRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> subscriptionsSubscriptionIdDelete(final String subscriptionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CimSubscription> subscriptionsSubscriptionIdGet(final String subscriptionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
