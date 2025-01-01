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
package com.ubiqube.etsi.mano.v361.vnfm.controller.vnflcm;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.subscription.ApiAndType;
import com.ubiqube.etsi.mano.dao.subscription.SubscriptionType;
import com.ubiqube.etsi.mano.service.auth.model.ApiTypesEnum;
import com.ubiqube.etsi.mano.service.event.model.Subscription;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.LccnSubscription;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.LccnSubscriptionLinks;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.LccnSubscriptionRequest;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.LifecycleChangeNotificationsFilter;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.v361.service.mapping.subscription.LccnSubscription361Mapping;
import com.ubiqube.etsi.mano.v361.vnfm.service.SubscriptionLinkable361Vnfm;
import com.ubiqube.etsi.mano.vnfm.fc.vnflcm.VnfLcmSubscriptionFrontController;

import jakarta.validation.Valid;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
public class VnfLcmSubscriptions361Sol002Controller implements VnfLcmSubscriptions361Sol002Api, SubscriptionLinkable361Vnfm {
	private final VnfLcmSubscriptionFrontController frontController;
	private final LccnSubscription361Mapping mapper;

	public VnfLcmSubscriptions361Sol002Controller(final VnfLcmSubscriptionFrontController frontController, final LccnSubscription361Mapping mapper) {
		this.frontController = frontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<List<LccnSubscription>> subscriptionsGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return frontController.search(requestParams, nextpageOpaqueMarker, x -> mapper.map(x, LifecycleChangeNotificationsFilter.class), VnfLcmSubscriptions361Sol002Controller::makeLinks);
	}

	@Override
	public ResponseEntity<LccnSubscription> subscriptionsPost(@Valid final LccnSubscriptionRequest body) {
		final Subscription req = mapper.map(body);
		return frontController.create(req, x -> mapper.map(x, LifecycleChangeNotificationsFilter.class), VnfLcmSubscriptions361Sol002Api.class, VnfLcmSubscriptions361Sol002Controller::makeLinks, VnfLcmSubscriptions361Sol002Controller::getSelfLink);
	}

	@Override
	public ResponseEntity<Void> subscriptionsSubscriptionIdDelete(final String subscriptionId) {
		return frontController.deleteById(subscriptionId);
	}

	@Override
	public ResponseEntity<LccnSubscription> subscriptionsSubscriptionIdGet(final String subscriptionId) {
		return frontController.findById(subscriptionId, x -> mapper.map(x, LifecycleChangeNotificationsFilter.class), VnfLcmSubscriptions361Sol002Controller::makeLinks);
	}

	private static void makeLinks(final LccnSubscription subscription) {
		final LccnSubscriptionLinks links = new LccnSubscriptionLinks();
		final Link link = new Link();
		link.setHref(linkTo(methodOn(VnfLcmSubscriptions361Sol002Api.class).subscriptionsSubscriptionIdGet(subscription.getId())).withSelfRel().getHref());
		links.setSelf(link);
		subscription.setLinks(links);
	}

	private static String getSelfLink(final LccnSubscription subscription) {
		return linkTo(methodOn(VnfLcmSubscriptions361Sol002Api.class).subscriptionsSubscriptionIdGet(subscription.getId())).withSelfRel().getHref();
	}

	@Override
	public String makeSelfLink(final String id) {
		return linkTo(methodOn(VnfLcmSubscriptions361Sol002Api.class).subscriptionsSubscriptionIdGet(id)).withSelfRel().getHref();
	}

	@Override
	public ApiAndType getApiAndType() {
		return ApiAndType.of(ApiTypesEnum.SOL002, SubscriptionType.VNFLCM);
	}

}
