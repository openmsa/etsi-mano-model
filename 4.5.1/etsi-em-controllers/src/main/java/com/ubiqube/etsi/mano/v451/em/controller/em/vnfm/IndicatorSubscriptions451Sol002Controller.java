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
package com.ubiqube.etsi.mano.v451.em.controller.em.vnfm;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v451.model.em.vnfind.VnfIndicatorSubscription;
import com.ubiqube.etsi.mano.v451.model.em.vnfind.VnfIndicatorSubscriptionLinks;
import com.ubiqube.etsi.mano.v451.model.em.vnfind.VnfIndicatorSubscriptionRequest;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.vnfm.fc.vnfind.Sol002VnfIndSubscriptionsFrontController;

import jakarta.validation.Valid;

@RestController
public class IndicatorSubscriptions451Sol002Controller implements IndicatorSubscriptions451Sol002Api {
	private final Sol002VnfIndSubscriptionsFrontController vnfIndSubscriptionsFrontController;

	public IndicatorSubscriptions451Sol002Controller(final Sol002VnfIndSubscriptionsFrontController vnfIndSubscriptionsFrontController) {
		this.vnfIndSubscriptionsFrontController = vnfIndSubscriptionsFrontController;
	}

	@Override
	public ResponseEntity<List<VnfIndicatorSubscription>> subscriptionsGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return vnfIndSubscriptionsFrontController.search(requestParams, VnfIndicatorSubscription.class, IndicatorSubscriptions451Sol002Controller::makeLinks);
	}

	@Override
	public ResponseEntity<VnfIndicatorSubscription> subscriptionsPost(@Valid final VnfIndicatorSubscriptionRequest vnfIndicatorSubscriptionRequest) {
		return vnfIndSubscriptionsFrontController.create(vnfIndicatorSubscriptionRequest, VnfIndicatorSubscription.class, IndicatorSubscriptions451Sol002Api.class, IndicatorSubscriptions451Sol002Controller::makeLinks, IndicatorSubscriptions451Sol002Controller::getSelfLink);
	}

	@Override
	public ResponseEntity<Void> subscriptionsSubscriptionIdDelete(final String subscriptionId) {
		return vnfIndSubscriptionsFrontController.delete(subscriptionId);
	}

	@Override
	public ResponseEntity<VnfIndicatorSubscription> subscriptionsSubscriptionIdGet(final String subscriptionId) {
		return vnfIndSubscriptionsFrontController.findById(subscriptionId, VnfIndicatorSubscription.class, IndicatorSubscriptions451Sol002Controller::makeLinks);
	}

	private static void makeLinks(final VnfIndicatorSubscription subscription) {
		final VnfIndicatorSubscriptionLinks links = new VnfIndicatorSubscriptionLinks();
		final Link link = new Link();
		link.setHref(linkTo(methodOn(IndicatorSubscriptions451Sol002Api.class).subscriptionsSubscriptionIdGet(subscription.getId())).withSelfRel().getHref());
		links.setSelf(link);
		subscription.setLinks(links);
	}

	private static String getSelfLink(final VnfIndicatorSubscription subscription) {
		return linkTo(methodOn(IndicatorSubscriptions451Sol002Api.class).subscriptionsSubscriptionIdGet(subscription.getId())).withSelfRel().getHref();
	}

}
