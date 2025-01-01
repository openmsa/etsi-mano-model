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
package com.ubiqube.etsi.mano.v261.nfvo.controller.nslcm;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.common.v261.model.Link;
import com.ubiqube.etsi.mano.controller.nslcm.NsLcmSubscriptionsGenericFrontController;
import com.ubiqube.etsi.mano.controller.subscription.ApiAndType;
import com.ubiqube.etsi.mano.dao.subscription.SubscriptionType;
import com.ubiqube.etsi.mano.service.auth.model.ApiTypesEnum;
import com.ubiqube.etsi.mano.service.event.model.Subscription;
import com.ubiqube.etsi.mano.v261.model.nfvo.nslcm.LccnSubscription;
import com.ubiqube.etsi.mano.v261.model.nfvo.nslcm.LccnSubscriptionLinks;
import com.ubiqube.etsi.mano.v261.model.nfvo.nslcm.LccnSubscriptionRequest;
import com.ubiqube.etsi.mano.v261.model.nfvo.nslcm.LifecycleChangeNotificationsFilter;
import com.ubiqube.etsi.mano.v261.nfvo.service.SubscriptionLinkable261Nfvo;
import com.ubiqube.etsi.mano.v261.service.mapping.subscription.LccnSubscription261Mapping;

/**
 *
 * @author Olivier Vignaud {@literal {@literal <ovi@ubiqube.com>}}
 *
 */
@RestController
public class NsLcmSubscriptions261Sol005Controller implements NsLcmSubscriptions261Sol005Api, SubscriptionLinkable261Nfvo {
	private final NsLcmSubscriptionsGenericFrontController nsLcmSubscriptionsGenericFrontController;
	private final LccnSubscription261Mapping mapper;

	public NsLcmSubscriptions261Sol005Controller(final NsLcmSubscriptionsGenericFrontController nsLcmSubscriptionsGenericFrontController, final LccnSubscription261Mapping mapper) {
		this.nsLcmSubscriptionsGenericFrontController = nsLcmSubscriptionsGenericFrontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<List<LccnSubscription>> subscriptionsGet(final String filter) {
		return nsLcmSubscriptionsGenericFrontController.search(filter, x -> mapper.map(x, LifecycleChangeNotificationsFilter.class), NsLcmSubscriptions261Sol005Controller::makeLink);
	}

	@Override
	public ResponseEntity<LccnSubscription> subscriptionsPost(final LccnSubscriptionRequest body) {
		final Subscription req = mapper.map(body);
		return nsLcmSubscriptionsGenericFrontController.create(req, x -> mapper.map(x, LifecycleChangeNotificationsFilter.class), NsLcmSubscriptions261Sol005Api.class, NsLcmSubscriptions261Sol005Controller::makeLink, NsLcmSubscriptions261Sol005Controller::getSelfLink);
	}

	@Override
	public ResponseEntity<Void> subscriptionsSubscriptionIdDelete(final String subscriptionId) {
		return nsLcmSubscriptionsGenericFrontController.delete(subscriptionId);
	}

	@Override
	public ResponseEntity<LccnSubscription> subscriptionsSubscriptionIdGet(final String subscriptionId) {
		return nsLcmSubscriptionsGenericFrontController.findById(subscriptionId, x -> mapper.map(x, LifecycleChangeNotificationsFilter.class), NsLcmSubscriptions261Sol005Controller::makeLink);
	}

	private static void makeLink(final LccnSubscription lccnSubscription) {
		final LccnSubscriptionLinks links = new LccnSubscriptionLinks();
		final Link self = new Link();
		self.setHref(linkTo(methodOn(NsLcmSubscriptions261Sol005Api.class).subscriptionsSubscriptionIdGet(lccnSubscription.getId())).withSelfRel().getHref());
		links.setSelf(self);
		lccnSubscription.setLinks(links);
	}

	private static String getSelfLink(final LccnSubscription lccnSubscription) {
		return linkTo(methodOn(NsLcmSubscriptions261Sol005Api.class).subscriptionsSubscriptionIdGet(lccnSubscription.getId())).withSelfRel().getHref();
	}

	@Override
	public String makeSelfLink(final String id) {
		return linkTo(methodOn(NsLcmSubscriptions261Sol005Api.class).subscriptionsSubscriptionIdGet(id)).withSelfRel().getHref();
	}

	@Override
	public ApiAndType getApiAndType() {
		return ApiAndType.of(ApiTypesEnum.SOL005, SubscriptionType.NSLCM);
	}
}
