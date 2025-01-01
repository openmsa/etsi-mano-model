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
package com.ubiqube.etsi.mano.v451.nfvo.controller.nfvo.nsd;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.nsd.NsdSubscriptionFrontController;
import com.ubiqube.etsi.mano.controller.subscription.ApiAndType;
import com.ubiqube.etsi.mano.dao.subscription.SubscriptionType;
import com.ubiqube.etsi.mano.service.auth.model.ApiTypesEnum;
import com.ubiqube.etsi.mano.service.event.model.Subscription;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.v451.model.nfvo.nsd.NsdmNotificationsFilter;
import com.ubiqube.etsi.mano.v451.model.nfvo.nsd.NsdmSubscription;
import com.ubiqube.etsi.mano.v451.model.nfvo.nsd.NsdmSubscriptionLinks;
import com.ubiqube.etsi.mano.v451.model.nfvo.nsd.NsdmSubscriptionRequest;
import com.ubiqube.etsi.mano.v451.nfvo.service.SubscriptionLinkable451Nfvo;
import com.ubiqube.etsi.mano.v451.service.mapping.subscription.NsdmSubscription451Mapping;

import jakarta.validation.constraints.NotNull;

@RestController
public class NsdSubscriptions451Sol005Controller implements NsdSubscriptions451Sol005Api, SubscriptionLinkable451Nfvo {
	private final NsdSubscriptionFrontController nsdSubscriptionFrontController;
	private final NsdmSubscription451Mapping mapper;

	public NsdSubscriptions451Sol005Controller(final NsdSubscriptionFrontController nsdSubscriptionFrontController, final NsdmSubscription451Mapping mapper) {
		this.nsdSubscriptionFrontController = nsdSubscriptionFrontController;
		this.mapper = mapper;
	}

	/**
	 * Query multiple subscriptions.
	 *
	 * The GET method queries the list of active subscriptions of the functional
	 * block that invokes the method. It can be used e.g. for resynchronization
	 * after error situations. This method shall support the URI query parameters,
	 * request and response data structures, and response codes. This resource
	 * represents subscriptions. The client can use this resource to subscribe to
	 * notifications related to NSD management and to query its subscriptions.
	 *
	 */
	@Override
	public ResponseEntity<List<NsdmSubscription>> subscriptionsGet(final MultiValueMap<String, String> requestParams, final String nextpageOpaqueMarker) {
		return nsdSubscriptionFrontController.search(requestParams, x -> mapper.map(x, NsdmNotificationsFilter.class), NsdSubscriptions451Sol005Controller::makeLink);
	}

	/**
	 * Subscribe to NSD and PNFD change notifications.
	 *
	 * The POST method creates a new subscription. This method shall support the URI
	 * query parameters, request and response data structures, and response codes,
	 * as specified in the Tables 5.4.8.3.1-1 and 5.4.8.3.1-2 of GS-NFV SOL 005.
	 * Creation of two subscription resources with the same callbackURI and the same
	 * filter can result in performance degradation and will provide duplicates of
	 * notifications to the OSS, and might make sense only in very rare use cases.
	 * Consequently, the NFVO may either allow creating a subscription resource if
	 * another subscription resource with the same filter and callbackUri already
	 * exists (in which case it shall return the \&quot;201 Created\&quot; response
	 * code), or may decide to not create a duplicate subscription resource (in
	 * which case it shall return a \&quot;303 See Other\&quot; response code
	 * referencing the existing subscription resource with the same filter and
	 * callbackUri). This resource represents subscriptions. The client can use this
	 * resource to subscribe to notifications related to NSD management and to query
	 * its subscriptions.
	 *
	 */
	@Override
	public ResponseEntity<NsdmSubscription> subscriptionsPost(final NsdmSubscriptionRequest body) {
		final Subscription req = mapper.map(body);
		return nsdSubscriptionFrontController.create(req, x -> mapper.map(x, NsdmNotificationsFilter.class), NsdSubscriptions451Sol005Api.class, NsdSubscriptions451Sol005Controller::makeLink, NsdSubscriptions451Sol005Controller::getSelfLink);
	}

	/**
	 * Terminate Subscription
	 *
	 * This resource represents an individual subscription. It can be used by the
	 * client to read and to terminate a subscription to notifications related to
	 * NSD management. The DELETE method terminates an individual subscription. This
	 * method shall support the URI query parameters, request and response data
	 * structures, and response codes, as specified in the Table 5.4.9.3.3-2.
	 *
	 */
	@Override
	public ResponseEntity<Void> subscriptionsSubscriptionIdDelete(final String subscriptionId) {
		return nsdSubscriptionFrontController.delete(subscriptionId);
	}

	/**
	 * Read an individual subscription resource.
	 *
	 * This resource represents an individual subscription. It can be used by the
	 * client to read and to terminate a subscription to notifications related to
	 * NSD management. The GET method retrieves information about a subscription by
	 * reading an individual subscription resource. This resource represents an
	 * individual subscription. It can be used by the client to read and to
	 * terminate a subscription to notifications related to NSD management.
	 *
	 */
	@Override
	public ResponseEntity<NsdmSubscription> subscriptionsSubscriptionIdGet(final String subscriptionId) {
		return nsdSubscriptionFrontController.findById(subscriptionId, x -> mapper.map(x, NsdmNotificationsFilter.class), NsdSubscriptions451Sol005Controller::makeLink);
	}

	private static void makeLink(@NotNull final NsdmSubscription subs) {
		final NsdmSubscriptionLinks nsdmSubscriptionLinks = new NsdmSubscriptionLinks();
		final Link self = new Link();
		self.setHref(linkTo(methodOn(NsdSubscriptions451Sol005Api.class).subscriptionsSubscriptionIdGet(subs.getId())).withSelfRel().getHref());
		nsdmSubscriptionLinks.setSelf(self);
	}

	private static String getSelfLink(@NotNull final NsdmSubscription subs) {
		return linkTo(methodOn(NsdSubscriptions451Sol005Api.class).subscriptionsSubscriptionIdGet(subs.getId())).withSelfRel().getHref();
	}

	@Override
	public String makeSelfLink(final String id) {
		return linkTo(methodOn(NsdSubscriptions451Sol005Api.class).subscriptionsSubscriptionIdGet(id)).withSelfRel().getHref();
	}

	@Override
	public ApiAndType getApiAndType() {
		return ApiAndType.of(ApiTypesEnum.SOL005, SubscriptionType.NSD);
	}

}
