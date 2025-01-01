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
package com.ubiqube.etsi.mano.v331.nfvo.controller.nfvici;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.subscription.ApiAndType;
import com.ubiqube.etsi.mano.dao.subscription.SubscriptionType;
import com.ubiqube.etsi.mano.service.auth.model.ApiTypesEnum;
import com.ubiqube.etsi.mano.v331.model.nfvo.nfvici.NfviCapacityInfoSubscription;
import com.ubiqube.etsi.mano.v331.model.nfvo.nfvici.NfviCapacityInfoSubscriptionRequest;
import com.ubiqube.etsi.mano.v331.nfvo.service.SubscriptionLinkable331Nfvo;

import jakarta.validation.Valid;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
public class NfvIciSubscriptions331Sol005Controller implements NfvIciSubscriptions331Sol005Api, SubscriptionLinkable331Nfvo {

	@Override
	public ResponseEntity<List<NfviCapacityInfoSubscription>> subscriptionsGet(@Valid final String nextpageOpaqueMarker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<NfviCapacityInfoSubscription> subscriptionsPost(@Valid final NfviCapacityInfoSubscriptionRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> subscriptionsSubscriptionIdDelete(final String subscriptionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<NfviCapacityInfoSubscription> subscriptionsSubscriptionIdGet(final String subscriptionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String makeSelfLink(final String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiAndType getApiAndType() {
		return ApiAndType.of(ApiTypesEnum.SOL005, SubscriptionType.NSNFVI);
	}

}
