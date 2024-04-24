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
package com.ubiqube.etsi.mano.v261.vnfm.controller.vnffm.sol002;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

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
import com.ubiqube.etsi.mano.v261.model.nfvo.nsfm.FmSubscriptionRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.faultmngt.FmNotificationsVnfFilter;
import com.ubiqube.etsi.mano.v261.model.vnfm.faultmngt.FmSubscription;
import com.ubiqube.etsi.mano.v261.model.vnfm.faultmngt.FmSubscriptionLinks;
import com.ubiqube.etsi.mano.v261.service.mapping.subscription.FmSubscription261Mapping;
import com.ubiqube.etsi.mano.v261.vnfm.service.SubscriptionLinkable261Vnfm;

import jakarta.validation.Valid;

/**
 *
 * @author Olivier Vignaud {@literal {@literal <ovi@ubiqube.com>}}
 *
 */
@RestController
public class FaultMngtSubscriptions261Sol002Controller implements FaultmngtSubscriptions261Sol002Api, SubscriptionLinkable261Vnfm {
	private final SubscriptionFrontController faultMngtSubscriptionsFrontController;
	private final FmSubscription261Mapping mapper;

	public FaultMngtSubscriptions261Sol002Controller(final SubscriptionFrontController faultMngtSubscriptionsFrontController, final FmSubscription261Mapping mapper) {
		this.faultMngtSubscriptionsFrontController = faultMngtSubscriptionsFrontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<List<FmSubscription>> subscriptionsGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return faultMngtSubscriptionsFrontController.search(requestParams, x -> mapper.map(x, FmNotificationsVnfFilter.class), FaultMngtSubscriptions261Sol002Controller::makeLinks, ApiVersionType.SOL003_VNFFM);
	}

	@Override
	public ResponseEntity<FmSubscription> subscriptionsPost(@Valid final FmSubscriptionRequest body) {
		final Subscription req = mapper.map(body);
		return faultMngtSubscriptionsFrontController.create(req, x -> mapper.map(x, FmNotificationsVnfFilter.class), FaultmngtSubscriptions261Sol002Api.class, FaultMngtSubscriptions261Sol002Controller::makeLinks, FaultMngtSubscriptions261Sol002Controller::makeSelf, ApiVersionType.SOL003_VNFFM);
	}

	@Override
	public ResponseEntity<Void> subscriptionsSubscriptionIdDelete(final String subscriptionId) {
		return faultMngtSubscriptionsFrontController.deleteById(subscriptionId, ApiVersionType.SOL003_VNFFM);
	}

	@Override
	public ResponseEntity<FmSubscription> subscriptionsSubscriptionIdGet(final String subscriptionId) {
		return faultMngtSubscriptionsFrontController.findById(subscriptionId, x -> mapper.map(x, FmNotificationsVnfFilter.class), FaultMngtSubscriptions261Sol002Controller::makeLinks, ApiVersionType.SOL003_VNFFM);
	}

	private static void makeLinks(final FmSubscription subscription) {
		final FmSubscriptionLinks links = new FmSubscriptionLinks();
		final Link link = new Link();
		link.setHref(linkTo(methodOn(FaultmngtSubscriptions261Sol002Api.class).subscriptionsSubscriptionIdGet(subscription.getId())).withSelfRel().getHref());
		links.setSelf(link);
		subscription.setLinks(links);
	}

	private static String makeSelf(final FmSubscription subscription) {
		return linkTo(methodOn(FaultmngtSubscriptions261Sol002Api.class).subscriptionsSubscriptionIdGet(subscription.getId())).withSelfRel().getHref();
	}

	@Override
	public String makeSelfLink(final String id) {
		return linkTo(methodOn(FaultmngtSubscriptions261Sol002Api.class).subscriptionsSubscriptionIdGet(id)).withSelfRel().getHref();
	}

	@Override
	public ApiAndType getApiAndType() {
		return ApiAndType.of(ApiTypesEnum.SOL002, SubscriptionType.VNFFM);
	}
}
