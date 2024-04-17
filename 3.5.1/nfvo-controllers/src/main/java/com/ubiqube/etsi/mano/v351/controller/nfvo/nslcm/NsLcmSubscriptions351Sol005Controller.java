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
package com.ubiqube.etsi.mano.v351.controller.nfvo.nslcm;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.nslcm.NsLcmSubscriptionsGenericFrontController;
import com.ubiqube.etsi.mano.controller.subscription.ApiAndType;
import com.ubiqube.etsi.mano.dao.subscription.SubscriptionType;
import com.ubiqube.etsi.mano.service.auth.model.ApiTypesEnum;
import com.ubiqube.etsi.mano.service.event.model.Subscription;
import com.ubiqube.etsi.mano.v351.model.em.lcmcoord.Link;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.LccnSubscription;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.LccnSubscriptionLinks;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.LccnSubscriptionRequest;
import com.ubiqube.etsi.mano.v351.services.SubscriptionLinkable351Nfvo;

import jakarta.validation.Valid;
import ma.glasnost.orika.MapperFacade;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
public class NsLcmSubscriptions351Sol005Controller implements NsLcmSubscriptions351Sol005Api, SubscriptionLinkable351Nfvo {
	private final NsLcmSubscriptionsGenericFrontController nsLcmSubscriptionsGenericFrontController;
	private final MapperFacade mapper;

	public NsLcmSubscriptions351Sol005Controller(final NsLcmSubscriptionsGenericFrontController nsLcmSubscriptionsGenericFrontController, final MapperFacade mapper) {
		this.nsLcmSubscriptionsGenericFrontController = nsLcmSubscriptionsGenericFrontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<LccnSubscription> subscriptionsPost(@Valid final LccnSubscriptionRequest body) {
		final Subscription req = mapper.map(body, Subscription.class);
		return nsLcmSubscriptionsGenericFrontController.create(req, x -> mapper.map(x, LccnSubscription.class), NsLcmSubscriptions351Sol005Api.class, NsLcmSubscriptions351Sol005Controller::makeLink, NsLcmSubscriptions351Sol005Controller::getSelfLink);
	}

	@Override
	public ResponseEntity<Void> subscriptionsSubscriptionIdDelete(final String subscriptionId) {
		return nsLcmSubscriptionsGenericFrontController.delete(subscriptionId);
	}

	@Override
	public ResponseEntity<LccnSubscription> subscriptionsSubscriptionIdGet(final String subscriptionId) {
		return nsLcmSubscriptionsGenericFrontController.findById(subscriptionId, x -> mapper.map(x, LccnSubscription.class), NsLcmSubscriptions351Sol005Controller::makeLink);
	}

	@Override
	public ResponseEntity<List<LccnSubscription>> subscriptionsGet(final String filter, final String nextpageOpaqueMarker) {
		return nsLcmSubscriptionsGenericFrontController.search(filter, x -> mapper.map(x, LccnSubscription.class), NsLcmSubscriptions351Sol005Controller::makeLink);
	}

	private static void makeLink(final LccnSubscription lccnSubscription) {
		final LccnSubscriptionLinks links = new LccnSubscriptionLinks();
		final Link self = new Link();
		self.setHref(linkTo(methodOn(NsLcmSubscriptions351Sol005Api.class).subscriptionsSubscriptionIdGet(lccnSubscription.getId())).withSelfRel().getHref());
		links.setSelf(self);
		lccnSubscription.setLinks(links);
	}

	private static String getSelfLink(final LccnSubscription lccnSubscription) {
		return linkTo(methodOn(NsLcmSubscriptions351Sol005Api.class).subscriptionsSubscriptionIdGet(lccnSubscription.getId())).withSelfRel().getHref();
	}

	@Override
	public String makeSelfLink(final String id) {
		return linkTo(methodOn(NsLcmSubscriptions351Sol005Api.class).subscriptionsSubscriptionIdGet(id)).withSelfRel().getHref();
	}

	@Override
	public ApiAndType getApiAndType() {
		return ApiAndType.of(ApiTypesEnum.SOL005, SubscriptionType.NSLCM);
	}

}
