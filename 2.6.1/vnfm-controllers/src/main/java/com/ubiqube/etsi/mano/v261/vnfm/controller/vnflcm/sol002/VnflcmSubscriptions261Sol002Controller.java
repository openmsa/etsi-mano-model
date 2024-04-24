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
package com.ubiqube.etsi.mano.v261.vnfm.controller.vnflcm.sol002;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.common.v261.model.Link;
import com.ubiqube.etsi.mano.controller.subscription.ApiAndType;
import com.ubiqube.etsi.mano.dao.subscription.SubscriptionType;
import com.ubiqube.etsi.mano.service.auth.model.ApiTypesEnum;
import com.ubiqube.etsi.mano.service.event.model.Subscription;
import com.ubiqube.etsi.mano.v261.model.nfvo.nslcm.LccnSubscription;
import com.ubiqube.etsi.mano.v261.model.nfvo.nslcm.LccnSubscriptionLinks;
import com.ubiqube.etsi.mano.v261.model.nfvo.nslcm.LccnSubscriptionRequest;
import com.ubiqube.etsi.mano.v261.model.nfvo.nslcm.LifecycleChangeNotificationsFilter;
import com.ubiqube.etsi.mano.v261.service.mapping.subscription.LccnSubscription261Mapping;
import com.ubiqube.etsi.mano.v261.vnfm.controller.vnflcm.sol003.VnfLcmSubscriptions261Sol003Api;
import com.ubiqube.etsi.mano.v261.vnfm.service.SubscriptionLinkable261Vnfm;
import com.ubiqube.etsi.mano.vnfm.fc.vnflcm.VnfLcmSubscriptionFrontController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
public class VnflcmSubscriptions261Sol002Controller implements VnflcmSubscriptions261Sol002Api, SubscriptionLinkable261Vnfm {
	private final VnfLcmSubscriptionFrontController frontController;
	private final LccnSubscription261Mapping mapper;

	public VnflcmSubscriptions261Sol002Controller(final VnfLcmSubscriptionFrontController frontController, final LccnSubscription261Mapping mapper) {
		this.frontController = frontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<List<LccnSubscription>> subscriptionsGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return frontController.search(requestParams, nextpageOpaqueMarker, x -> mapper.map(x, LifecycleChangeNotificationsFilter.class), VnflcmSubscriptions261Sol002Controller::makeLinks);
	}

	@Override
	public ResponseEntity<LccnSubscription> subscriptionsPost(@Valid final LccnSubscriptionRequest body) {
		final Subscription req = mapper.map(body);
		return frontController.create(req, x -> mapper.map(x, LifecycleChangeNotificationsFilter.class), VnflcmSubscriptions261Sol002Api.class, VnflcmSubscriptions261Sol002Controller::makeLinks, VnflcmSubscriptions261Sol002Controller::getSelfLink);
	}

	@Override
	public ResponseEntity<Void> subscriptionsSubscriptionIdDelete(final String subscriptionId) {
		return frontController.deleteById(subscriptionId);
	}

	@Override
	public ResponseEntity<LccnSubscription> subscriptionsSubscriptionIdGet(final String subscriptionId) {
		return frontController.findById(subscriptionId, x -> mapper.map(x, LifecycleChangeNotificationsFilter.class), VnflcmSubscriptions261Sol002Controller::makeLinks);
	}

	private static String getSelfLink(final LccnSubscription subscription) {
		return linkTo(methodOn(VnfLcmSubscriptions261Sol003Api.class).subscriptionsSubscriptionIdGet(subscription.getId())).withSelfRel().getHref();
	}

	private static void makeLinks(@NotNull final LccnSubscription subscription) {
		final String id = subscription.getId();
		final LccnSubscriptionLinks links = new LccnSubscriptionLinks();
		final Link self = new Link();
		self.setHref(linkTo(methodOn(VnflcmSubscriptions261Sol002Api.class).subscriptionsSubscriptionIdGet(id)).withSelfRel().getHref());
		links.setSelf(self);
		subscription.setLinks(links);
	}

	@Override
	public String makeSelfLink(final String id) {
		return linkTo(methodOn(VnfLcmSubscriptions261Sol003Api.class).subscriptionsSubscriptionIdGet(id)).withSelfRel().getHref();
	}

	@Override
	public ApiAndType getApiAndType() {
		return ApiAndType.of(ApiTypesEnum.SOL002, SubscriptionType.VNFLCM);
	}

}
