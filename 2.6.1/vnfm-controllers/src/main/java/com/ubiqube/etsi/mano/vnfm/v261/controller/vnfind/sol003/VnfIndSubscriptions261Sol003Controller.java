/**
 *     Copyright (C) 2019-2023 Ubiqube.
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
package com.ubiqube.etsi.mano.vnfm.v261.controller.vnfind.sol003;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.common.v261.model.Link;
import com.ubiqube.etsi.mano.controller.SubscriptionFrontController;
import com.ubiqube.etsi.mano.service.event.model.SubscriptionType;
import com.ubiqube.etsi.mano.vnfm.v261.model.vnfind.VnfIndicatorSubscription;
import com.ubiqube.etsi.mano.vnfm.v261.model.vnfind.VnfIndicatorSubscriptionLinks;
import com.ubiqube.etsi.mano.vnfm.v261.model.vnfind.VnfIndicatorSubscriptionRequest;

/**
 *
 * @author Olivier Vignaud {@literal {@literal <ovi@ubiqube.com>}}
 *
 */
@RestController
public class VnfIndSubscriptions261Sol003Controller implements VnfIndSubscriptions261Sol003Api {
	private final SubscriptionFrontController subscriptionService;

	public VnfIndSubscriptions261Sol003Controller(final SubscriptionFrontController subscriptionService) {
		this.subscriptionService = subscriptionService;
	}

	@Override
	public ResponseEntity<List<VnfIndicatorSubscription>> subscriptionsGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return subscriptionService.search(requestParams, VnfIndicatorSubscription.class, VnfIndSubscriptions261Sol003Controller::makeLinks, SubscriptionType.VNFIND);
	}

	@Override
	public ResponseEntity<VnfIndicatorSubscription> subscriptionsPost(@Valid final VnfIndicatorSubscriptionRequest vnfIndicatorSubscriptionRequest) {
		return subscriptionService.create(vnfIndicatorSubscriptionRequest, VnfIndicatorSubscription.class, VnfIndSubscriptions261Sol003Api.class, VnfIndSubscriptions261Sol003Controller::makeLinks, VnfIndSubscriptions261Sol003Controller::makeSelf, SubscriptionType.VNFIND);
	}

	@Override
	public ResponseEntity<Void> subscriptionsSubscriptionIdDelete(final String subscriptionId) {
		return subscriptionService.deleteById(subscriptionId, SubscriptionType.VNFIND);
	}

	@Override
	public ResponseEntity<VnfIndicatorSubscription> subscriptionsSubscriptionIdGet(final String subscriptionId) {
		return subscriptionService.findById(subscriptionId, VnfIndicatorSubscription.class, VnfIndSubscriptions261Sol003Controller::makeLinks, SubscriptionType.ALARM);
	}

	private static String makeSelf(final VnfIndicatorSubscription subscription) {
		return linkTo(methodOn(VnfIndSubscriptions261Sol003Api.class).subscriptionsSubscriptionIdGet(subscription.getId())).withSelfRel().getHref();
	}

	private static void makeLinks(final VnfIndicatorSubscription subscription) {
		final VnfIndicatorSubscriptionLinks links = new VnfIndicatorSubscriptionLinks();
		final Link link = new Link();
		link.setHref(linkTo(methodOn(VnfIndSubscriptions261Sol003Api.class).subscriptionsSubscriptionIdGet(subscription.getId())).withSelfRel().getHref());
		links.setSelf(link);
		subscription.setLinks(links);
	}
}
