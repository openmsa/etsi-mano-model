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
package com.ubiqube.etsi.mano.v271.vnfm.controller.vnfind;

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
import com.ubiqube.etsi.mano.v271.model.em.vnfind.VnfIndicatorNotificationsFilter;
import com.ubiqube.etsi.mano.v271.model.em.vnfind.VnfIndicatorSubscription;
import com.ubiqube.etsi.mano.v271.model.em.vnfind.VnfIndicatorSubscriptionLinks;
import com.ubiqube.etsi.mano.v271.model.em.vnfind.VnfIndicatorSubscriptionRequest;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.v271.service.mapping.subscription.VnfIndicatorSubscription271Mapping;
import com.ubiqube.etsi.mano.v271.vnfm.service.SubscriptionLinkable271Vnfm;

import jakarta.validation.Valid;

@RestController
public class VnfIndSubscriptions271Sol003Controller implements VnfIndSubscriptions271Sol003Api, SubscriptionLinkable271Vnfm {
	private final SubscriptionFrontController subscriptionService;
	private final VnfIndicatorSubscription271Mapping mapper;

	public VnfIndSubscriptions271Sol003Controller(final SubscriptionFrontController subscriptionService, final VnfIndicatorSubscription271Mapping mapper) {
		this.subscriptionService = subscriptionService;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<List<VnfIndicatorSubscription>> subscriptionsGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return subscriptionService.search(requestParams, x -> mapper.map(x, VnfIndicatorNotificationsFilter.class), VnfIndSubscriptions271Sol003Controller::makeLinks, ApiVersionType.SOL003_VNFIND);
	}

	@Override
	public ResponseEntity<VnfIndicatorSubscription> subscriptionsPost(@Valid final VnfIndicatorSubscriptionRequest body) {
		final Subscription req = mapper.map(body);
		return subscriptionService.create(req, x -> mapper.map(x, VnfIndicatorNotificationsFilter.class), VnfIndSubscriptions271Sol003Api.class, VnfIndSubscriptions271Sol003Controller::makeLinks, VnfIndSubscriptions271Sol003Controller::makeSelf, ApiVersionType.SOL003_VNFIND);
	}

	@Override
	public ResponseEntity<Void> subscriptionsSubscriptionIdDelete(final String subscriptionId) {
		return subscriptionService.deleteById(subscriptionId, ApiVersionType.SOL003_VNFIND);
	}

	@Override
	public ResponseEntity<VnfIndicatorSubscription> subscriptionsSubscriptionIdGet(final String subscriptionId) {
		return subscriptionService.findById(subscriptionId, x -> mapper.map(x, VnfIndicatorNotificationsFilter.class), VnfIndSubscriptions271Sol003Controller::makeLinks, ApiVersionType.SOL003_VNFIND);
	}

	private static String makeSelf(final VnfIndicatorSubscription subscription) {
		return linkTo(methodOn(VnfIndSubscriptions271Sol003Api.class).subscriptionsSubscriptionIdGet(subscription.getId())).withSelfRel().getHref();
	}

	private static void makeLinks(final VnfIndicatorSubscription subscription) {
		final VnfIndicatorSubscriptionLinks links = new VnfIndicatorSubscriptionLinks();
		final Link link = new Link();
		link.setHref(linkTo(methodOn(VnfIndSubscriptions271Sol003Api.class).subscriptionsSubscriptionIdGet(subscription.getId())).withSelfRel().getHref());
		links.setSelf(link);
		subscription.setLinks(links);
	}

	@Override
	public String makeSelfLink(final String id) {
		return linkTo(methodOn(VnfIndSubscriptions271Sol003Api.class).subscriptionsSubscriptionIdGet(id)).withSelfRel().getHref();
	}

	@Override
	public ApiAndType getApiAndType() {
		return ApiAndType.of(ApiTypesEnum.SOL003, SubscriptionType.VNFIND);
	}

}
