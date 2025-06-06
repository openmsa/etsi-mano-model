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
package com.ubiqube.etsi.mano.v431.vnfm.controller.vnfm.vnfind;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.SubscriptionFrontController;
import com.ubiqube.etsi.mano.controller.subscription.ApiAndType;
import com.ubiqube.etsi.mano.dao.mano.version.ApiVersionType;
import com.ubiqube.etsi.mano.dao.subscription.SubscriptionType;
import com.ubiqube.etsi.mano.service.auth.model.ApiTypesEnum;
import com.ubiqube.etsi.mano.service.event.model.Subscription;
import com.ubiqube.etsi.mano.v431.model.em.vnfind.VnfIndicatorNotificationsFilter;
import com.ubiqube.etsi.mano.v431.model.em.vnfind.VnfIndicatorSubscription;
import com.ubiqube.etsi.mano.v431.model.em.vnfind.VnfIndicatorSubscriptionLinks;
import com.ubiqube.etsi.mano.v431.model.em.vnfind.VnfIndicatorSubscriptionRequest;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.v431.service.mapping.subscription.VnfIndicatorSubscription431Mapping;
import com.ubiqube.etsi.mano.v431.vnfm.service.SubscriptionLinkable431Vnfm;

import jakarta.validation.Valid;

@RestController
public class VnfIndSubscriptions431Sol003Controller implements VnfIndSubscriptions431Sol003Api, SubscriptionLinkable431Vnfm {
	private final SubscriptionFrontController subscriptionService;
	private final VnfIndicatorSubscription431Mapping mapper;

	public VnfIndSubscriptions431Sol003Controller(final SubscriptionFrontController subscriptionService, final VnfIndicatorSubscription431Mapping mapper) {
		this.subscriptionService = subscriptionService;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<List<VnfIndicatorSubscription>> subscriptionsGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return subscriptionService.search(requestParams, x -> mapper.map(x, VnfIndicatorNotificationsFilter.class), VnfIndSubscriptions431Sol003Controller::makeLinks, ApiVersionType.SOL003_VNFIND);
	}

	@Override
	public ResponseEntity<VnfIndicatorSubscription> subscriptionsPost(@Valid final VnfIndicatorSubscriptionRequest body) {
		final Subscription req = mapper.map(body);
		return subscriptionService.create(req, x -> mapper.map(x, VnfIndicatorNotificationsFilter.class), VnfIndSubscriptions431Sol003Api.class, VnfIndSubscriptions431Sol003Controller::makeLinks, VnfIndSubscriptions431Sol003Controller::makeSelf, ApiVersionType.SOL003_VNFIND);
	}

	@Override
	public ResponseEntity<Void> indicatorsSubscriptionsSubscriptionIdDelete(final String subscriptionId) {
		return subscriptionService.deleteById(subscriptionId, ApiVersionType.SOL003_VNFIND);
	}

	@Override
	public ResponseEntity<VnfIndicatorSubscription> indicatorsSubscriptionsSubscriptionIdGet(final String subscriptionId) {
		return subscriptionService.findById(subscriptionId, x -> mapper.map(x, VnfIndicatorNotificationsFilter.class), VnfIndSubscriptions431Sol003Controller::makeLinks, ApiVersionType.SOL003_VNFIND);
	}

	private static String makeSelf(final VnfIndicatorSubscription subscription) {
		linkTo(methodOn(VnfIndSubscriptions431Sol003Api.class).indicatorsSubscriptionsSubscriptionIdGet(subscription.getId())).withSelfRel().getHref();
		return "";
	}

	private static void makeLinks(final VnfIndicatorSubscription subscription) {
		final VnfIndicatorSubscriptionLinks links = new VnfIndicatorSubscriptionLinks();
		final Link link = new Link();
		link.setHref(linkTo(methodOn(VnfIndSubscriptions431Sol003Api.class).indicatorsSubscriptionsSubscriptionIdGet(subscription.getId())).withSelfRel().getHref());
		links.setSelf(link);
		subscription.setLinks(links);
	}

	@Override
	public String makeSelfLink(final String id) {
		return linkTo(methodOn(VnfIndSubscriptions431Sol003Api.class).indicatorsSubscriptionsSubscriptionIdGet(id)).withSelfRel().getHref();
	}

	@Override
	public ApiAndType getApiAndType() {
		return ApiAndType.of(ApiTypesEnum.SOL003, SubscriptionType.VNFIND);
	}

}
