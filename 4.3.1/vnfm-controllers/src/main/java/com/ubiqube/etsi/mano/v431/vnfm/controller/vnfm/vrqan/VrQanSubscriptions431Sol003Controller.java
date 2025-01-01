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
package com.ubiqube.etsi.mano.v431.vnfm.controller.vnfm.vrqan;

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
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.v431.model.vnfm.vrqan.VrQuotaAvailNotificationsFilter;
import com.ubiqube.etsi.mano.v431.model.vnfm.vrqan.VrQuotaAvailSubscription;
import com.ubiqube.etsi.mano.v431.model.vnfm.vrqan.VrQuotaAvailSubscriptionLinks;
import com.ubiqube.etsi.mano.v431.model.vnfm.vrqan.VrQuotaAvailSubscriptionRequest;
import com.ubiqube.etsi.mano.v431.service.mapping.subscription.VrQuotaAvailSubscription431Mapping;
import com.ubiqube.etsi.mano.v431.vnfm.service.SubscriptionLinkable431Vnfm;

import jakarta.validation.Valid;

@RestController
public class VrQanSubscriptions431Sol003Controller implements VrQanSubscriptions431Sol003Api, SubscriptionLinkable431Vnfm {
	private final SubscriptionFrontController subscriptionService;
	private final VrQuotaAvailSubscription431Mapping mapper;

	public VrQanSubscriptions431Sol003Controller(final SubscriptionFrontController subscriptionService, final VrQuotaAvailSubscription431Mapping mapper) {
		this.subscriptionService = subscriptionService;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<List<VrQuotaAvailSubscription>> subscriptionsGet(final MultiValueMap<String, String> requestParams, final String nextpageOpaqueMarker) {
		return subscriptionService.search(requestParams, x -> mapper.map(x, VrQuotaAvailNotificationsFilter.class), VrQanSubscriptions431Sol003Controller::makeLinks, ApiVersionType.SOL003_VRQAN);
	}

	@Override
	public ResponseEntity<VrQuotaAvailSubscription> subscriptionsPost(@Valid final VrQuotaAvailSubscriptionRequest body) {
		final Subscription req = mapper.map(body);
		return subscriptionService.create(req, x -> mapper.map(x, VrQuotaAvailNotificationsFilter.class), VrQanSubscriptions431Sol003Api.class, VrQanSubscriptions431Sol003Controller::makeLinks, VrQanSubscriptions431Sol003Controller::makeSelf, ApiVersionType.SOL003_VRQAN);
	}

	@Override
	public ResponseEntity<Void> subscriptionsSubscriptionIdDelete(final String subscriptionId) {
		return subscriptionService.deleteById(subscriptionId, ApiVersionType.SOL003_VRQAN);
	}

	@Override
	public ResponseEntity<VrQuotaAvailSubscription> subscriptionsSubscriptionIdGet(final String subscriptionId) {
		return subscriptionService.findById(subscriptionId, x -> mapper.map(x, VrQuotaAvailNotificationsFilter.class), VrQanSubscriptions431Sol003Controller::makeLinks, ApiVersionType.SOL003_VRQAN);
	}

	private static String makeSelf(final VrQuotaAvailSubscription subscription) {
		return linkTo(methodOn(VrQanSubscriptions431Sol003Api.class).subscriptionsSubscriptionIdGet(subscription.getId())).withSelfRel().getHref();
	}

	private static void makeLinks(final VrQuotaAvailSubscription subscription) {
		final VrQuotaAvailSubscriptionLinks links = new VrQuotaAvailSubscriptionLinks();
		final Link link = new Link();
		link.setHref(linkTo(methodOn(VrQanSubscriptions431Sol003Api.class).subscriptionsSubscriptionIdGet(subscription.getId())).withSelfRel().getHref());
		links.setSelf(link);
		subscription.setLinks(links);
	}

	@Override
	public String makeSelfLink(final String id) {
		return linkTo(methodOn(VrQanSubscriptions431Sol003Api.class).subscriptionsSubscriptionIdGet(id)).withSelfRel().getHref();
	}

	@Override
	public ApiAndType getApiAndType() {
		return ApiAndType.of(ApiTypesEnum.SOL003, SubscriptionType.VRQAN);
	}
}
