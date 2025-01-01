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
package com.ubiqube.etsi.mano.v261.nfvo.controller.nspm;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.common.v261.model.Link;
import com.ubiqube.etsi.mano.controller.SubscriptionFrontController;
import com.ubiqube.etsi.mano.controller.subscription.ApiAndType;
import com.ubiqube.etsi.mano.dao.mano.version.ApiVersionType;
import com.ubiqube.etsi.mano.dao.subscription.SubscriptionType;
import com.ubiqube.etsi.mano.service.auth.model.ApiTypesEnum;
import com.ubiqube.etsi.mano.service.event.model.Subscription;
import com.ubiqube.etsi.mano.v261.model.nfvo.nsperfo.SubscriptionsPmSubscriptionRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.nsperfo.PmNotificationsFilter;
import com.ubiqube.etsi.mano.v261.model.vnfm.nsperfo.PmSubscription;
import com.ubiqube.etsi.mano.v261.model.vnfm.nsperfo.PmSubscriptionLinks;
import com.ubiqube.etsi.mano.v261.nfvo.service.SubscriptionLinkable261Nfvo;
import com.ubiqube.etsi.mano.v261.service.mapping.subscription.PmSubscription261Mapping;

import jakarta.validation.Valid;

/**
 *
 * @author Olivier Vignaud {@literal {@literal <ovi@ubiqube.com>}}
 *
 */
@RestController
public class NsPerfoSubscription261Sol005Controller implements NsPerfoSubscription261Sol005Api, SubscriptionLinkable261Nfvo {
	private final SubscriptionFrontController subscriptionService;
	private final PmSubscription261Mapping mapper;

	public NsPerfoSubscription261Sol005Controller(final SubscriptionFrontController subscriptionService, final PmSubscription261Mapping mapper) {
		this.subscriptionService = subscriptionService;
		this.mapper = mapper;
	}

	/**
	 * Query PM related subscriptions.
	 *
	 * The client can use this method to query the list of active subscriptions to
	 * Performance management notifications subscribed by the client. This method
	 * shall follow the provisions specified in the Tables 7.4.7.3.2-1 and
	 * 7.4.7.3.2-2 for URI query parameters, request and response data structures,
	 * and response codes.
	 *
	 */
	@Override
	public ResponseEntity<List<PmSubscription>> subscriptionsGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return subscriptionService.search(requestParams, x -> mapper.map(x, PmNotificationsFilter.class), NsPerfoSubscription261Sol005Controller::makeLinks, ApiVersionType.SOL005_NSPM);
	}

	/**
	 * Subscribe to PM notifications.
	 *
	 * The POST method creates a new subscription. This method shall follow the
	 * provisions specified in the Tables 7.4.7.3.1-1 and 7.4.7.3.1-2 for URI query
	 * parameters, request and response data structures, and response codes.
	 * Creation of two subscription resources with the same callbackURI and the same
	 * filter can result in performance degradation and will provide duplicates of
	 * notifications to the OSS, and might make sense only in very rare use cases.
	 * Consequently, the NFVO may either allow creating a subscription resource if
	 * another subscription resource with the same filter and callbackUri already
	 * exists (in which case it shall return the \&quot;201 Created\&quot; response
	 * code), or may decide to not create a duplicate subscription resource (in
	 * which case it shall return a \&quot;303 See Other\&quot; response code
	 * referencing the existing subscription resource with the same filter and
	 * callbackUri)
	 *
	 * @throws URISyntaxException
	 *
	 */
	@Override
	public ResponseEntity<PmSubscription> subscriptionsPost(final SubscriptionsPmSubscriptionRequest pmSubscriptionRequest) throws URISyntaxException {
		final Subscription req = mapper.map(pmSubscriptionRequest);
		return subscriptionService.create(req, x -> mapper.map(x, PmNotificationsFilter.class), NsPerfoSubscription261Sol005Api.class, NsPerfoSubscription261Sol005Controller::makeLinks, NsPerfoSubscription261Sol005Controller::makeSelf, ApiVersionType.SOL005_NSPM);
	}

	/**
	 * Terminate a subscription.
	 *
	 * This method terminates an individual subscription. This method shall follow
	 * the provisions specified in the Tables 7.4.8.3.5-1 and 7.4.8.3.5-2 for URI
	 * query parameters, request and response data structures, and response codes
	 *
	 */
	@Override
	public ResponseEntity<Void> subscriptionsSubscriptionIdDelete(final String subscriptionId) {
		return subscriptionService.deleteById(subscriptionId, ApiVersionType.SOL005_NSPM);
	}

	/**
	 * Query a single PM related subscription.
	 *
	 * The client can use this method for reading an individual subscription about
	 * Performance management notifications subscribed by the client. This method
	 * shall follow the provisions specified in the Tables 7.4.8.3.2-1 and
	 * 7.4.8.3.2-2 for URI query parameters, request and response data structures,
	 * and response codes.
	 *
	 */
	@Override
	public ResponseEntity<PmSubscription> subscriptionsSubscriptionIdGet(final String subscriptionId) {
		return subscriptionService.findById(subscriptionId, x -> mapper.map(x, PmNotificationsFilter.class), NsPerfoSubscription261Sol005Controller::makeLinks, ApiVersionType.SOL005_NSPM);
	}

	private static void makeLinks(final PmSubscription subscription) {
		final PmSubscriptionLinks links = new PmSubscriptionLinks();
		final Link link = new Link();
		link.setHref(linkTo(methodOn(NsPerfoSubscription261Sol005Api.class).subscriptionsSubscriptionIdGet(subscription.getId())).withSelfRel().getHref());
		links.setSelf(link);
		subscription.setLinks(links);
	}

	private static String makeSelf(final PmSubscription subscription) {
		return linkTo(methodOn(NsPerfoSubscription261Sol005Api.class).subscriptionsSubscriptionIdGet(subscription.getId())).withSelfRel().getHref();
	}

	@Override
	public String makeSelfLink(final String id) {
		return linkTo(methodOn(NsPerfoSubscription261Sol005Api.class).subscriptionsSubscriptionIdGet(id)).withSelfRel().getHref();
	}

	@Override
	public ApiAndType getApiAndType() {
		return ApiAndType.of(ApiTypesEnum.SOL005, SubscriptionType.NSPM);
	}
}
