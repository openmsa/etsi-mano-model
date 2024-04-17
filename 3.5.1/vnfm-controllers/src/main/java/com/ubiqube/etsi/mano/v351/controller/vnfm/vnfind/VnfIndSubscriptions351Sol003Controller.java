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
package com.ubiqube.etsi.mano.v351.controller.vnfm.vnfind;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.SubscriptionFrontController;
import com.ubiqube.etsi.mano.controller.subscription.ApiAndType;
import com.ubiqube.etsi.mano.dao.mano.version.ApiVersionType;
import com.ubiqube.etsi.mano.dao.subscription.SubscriptionType;
import com.ubiqube.etsi.mano.service.auth.model.ApiTypesEnum;
import com.ubiqube.etsi.mano.service.event.model.Subscription;
import com.ubiqube.etsi.mano.v351.model.em.lcmcoord.Link;
import com.ubiqube.etsi.mano.v351.model.em.vnfind.VnfIndicatorNotificationsFilter;
import com.ubiqube.etsi.mano.v351.model.em.vnfind.VnfIndicatorSubscription;
import com.ubiqube.etsi.mano.v351.model.em.vnfind.VnfIndicatorSubscriptionLinks;
import com.ubiqube.etsi.mano.v351.model.em.vnfind.VnfIndicatorSubscriptionRequest;
import com.ubiqube.etsi.mano.v351.service.mapping.subscription.VnfIndicatorSubscription351Mapping;
import com.ubiqube.etsi.mano.v351.services.SubscriptionLinkable351Vnfm;

import jakarta.validation.Valid;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
@ConditionalOnMissingClass("com.ubiqube.etsi.mano.vnfm.v331.controller.vnfind.VnfIndSubscriptions331Sol003Api")
public class VnfIndSubscriptions351Sol003Controller implements VnfIndSubscriptions351Sol003Api, SubscriptionLinkable351Vnfm {
	private final SubscriptionFrontController subscriptionService;
	private final VnfIndicatorSubscription351Mapping mapper;

	public VnfIndSubscriptions351Sol003Controller(final SubscriptionFrontController subscriptionService, final VnfIndicatorSubscription351Mapping mapper) {
		this.subscriptionService = subscriptionService;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<List<VnfIndicatorSubscription>> subscriptionsGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return subscriptionService.search(requestParams, x -> mapper.map(x, VnfIndicatorNotificationsFilter.class), VnfIndSubscriptions351Sol003Controller::makeLinks, ApiVersionType.SOL003_VNFIND);
	}

	@Override
	public ResponseEntity<VnfIndicatorSubscription> subscriptionsPost(@Valid final VnfIndicatorSubscriptionRequest body) {
		final Subscription req = mapper.map(body);
		return subscriptionService.create(req, x -> mapper.map(x, VnfIndicatorNotificationsFilter.class), VnfIndSubscriptions351Sol003Api.class, VnfIndSubscriptions351Sol003Controller::makeLinks, VnfIndSubscriptions351Sol003Controller::makeSelf, ApiVersionType.SOL003_VNFIND);
	}

	@Override
	public ResponseEntity<Void> indicatorsSubscriptionsSubscriptionIdDelete(final String subscriptionId) {
		return subscriptionService.deleteById(subscriptionId, ApiVersionType.SOL003_VNFIND);
	}

	@Override
	public ResponseEntity<VnfIndicatorSubscription> indicatorsSubscriptionsSubscriptionIdGet(final String subscriptionId) {
		return subscriptionService.findById(subscriptionId, x -> mapper.map(x, VnfIndicatorNotificationsFilter.class), VnfIndSubscriptions351Sol003Controller::makeLinks, ApiVersionType.SOL003_VNFIND);
	}

	private static String makeSelf(final VnfIndicatorSubscription subscription) {
		return linkTo(methodOn(VnfIndSubscriptions351Sol003Api.class).indicatorsSubscriptionsSubscriptionIdGet(subscription.getId())).withSelfRel().getHref();
	}

	private static void makeLinks(final VnfIndicatorSubscription subscription) {
		final VnfIndicatorSubscriptionLinks links = new VnfIndicatorSubscriptionLinks();
		final Link link = new Link();
		link.setHref(linkTo(methodOn(VnfIndSubscriptions351Sol003Api.class).indicatorsSubscriptionsSubscriptionIdGet(subscription.getId())).withSelfRel().getHref());
		links.setSelf(link);
		subscription.setLinks(links);
	}

	@Override
	public String makeSelfLink(final String id) {
		return linkTo(methodOn(VnfIndSubscriptions351Sol003Api.class).indicatorsSubscriptionsSubscriptionIdGet(id)).withSelfRel().getHref();
	}

	@Override
	public ApiAndType getApiAndType() {
		return ApiAndType.of(ApiTypesEnum.SOL003, SubscriptionType.VNFIND);
	}

}
