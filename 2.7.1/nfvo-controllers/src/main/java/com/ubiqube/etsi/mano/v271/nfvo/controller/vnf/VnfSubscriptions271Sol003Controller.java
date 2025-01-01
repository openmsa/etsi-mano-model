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
package com.ubiqube.etsi.mano.v271.nfvo.controller.vnf;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.subscription.ApiAndType;
import com.ubiqube.etsi.mano.controller.vnf.VnfSubscriptionSol003FrontController;
import com.ubiqube.etsi.mano.dao.subscription.SubscriptionType;
import com.ubiqube.etsi.mano.service.auth.model.ApiTypesEnum;
import com.ubiqube.etsi.mano.service.event.model.Subscription;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.v271.model.sol003.vnf.PkgmNotificationsFilter;
import com.ubiqube.etsi.mano.v271.model.sol003.vnf.PkgmSubscription;
import com.ubiqube.etsi.mano.v271.model.sol003.vnf.PkgmSubscriptionLinks;
import com.ubiqube.etsi.mano.v271.model.sol003.vnf.PkgmSubscriptionRequest;
import com.ubiqube.etsi.mano.v271.nfvo.service.SubscriptionLinkable271Nfvo;
import com.ubiqube.etsi.mano.v271.service.mapping.subscription.PkgmSubscriptionRequest271Mapping;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
public class VnfSubscriptions271Sol003Controller implements VnfSubscriptions271Sol003Api, SubscriptionLinkable271Nfvo {
	private final VnfSubscriptionSol003FrontController vnfSubscriptionSol003FrontController;
	private final PkgmSubscriptionRequest271Mapping mapper;

	public VnfSubscriptions271Sol003Controller(final VnfSubscriptionSol003FrontController vnfSubscriptionSol03FrontController, final PkgmSubscriptionRequest271Mapping mapper) {
		this.vnfSubscriptionSol003FrontController = vnfSubscriptionSol03FrontController;
		this.mapper = mapper;
	}

	/**
	 * Query multiple subscriptions.
	 *
	 * The GET method queries the list of active subscriptions of the functional
	 * block that invokes the method. It can be used e.g. for resynchronization
	 * after error situations. This method shall follow the provisions specified in
	 * the Tables 9.4.7.8.2-1 and 9.4.8.3.2-2 for URI query parameters, request and
	 * response data structures, and response codes. ²
	 */
	@Override
	public ResponseEntity<List<PkgmSubscription>> subscriptionsGet(final String filter) {
		return vnfSubscriptionSol003FrontController.search(filter, x -> mapper.map(x, PkgmNotificationsFilter.class), VnfSubscriptions271Sol003Controller::makeLinks);
	}

	/**
	 * Subscribe to notifications related to on-boarding and/or changes of VNF
	 * packages.
	 *
	 * The POST method creates a new subscription. This method shall follow the
	 * provisions specified in the Tables 9.4.8.3.1-1 and 9.4.8.3.1-2 for URI query
	 * parameters, request and response data structures, and response codes.
	 * Creation of two subscription resources with the same callbackURI and the same
	 * filter can result in performance degradation and will provide duplicates of
	 * notifications to the OSS, and might make sense only in very rare use cases.
	 * Consequently, the NFVO may either allow creating a subscription resource if
	 * another subscription resource with the same filter and callbackUri already
	 * exists (in which case it shall return the \&quot;201 Created\&quot; response
	 * code), or may decide to not create a duplicate subscription resource (in
	 * which case it shall return a \&quot;303 See Other\&quot; response code
	 * referencing the existing subscription resource with the same filter and
	 * callbackUri).
	 *
	 */
	@Override
	public ResponseEntity<PkgmSubscription> subscriptionsPost(final PkgmSubscriptionRequest body) {
		final Subscription req = mapper.map(body);
		return vnfSubscriptionSol003FrontController.create(req, x -> mapper.map(x, PkgmNotificationsFilter.class), VnfSubscriptions271Sol003Api.class, VnfSubscriptions271Sol003Controller::makeLinks);
	}

	/**
	 * Terminate a subscription.
	 *
	 * The DELETE method terminates an individual subscription.
	 *
	 */
	@Override
	public ResponseEntity<Void> subscriptionsSubscriptionIdDelete(final String subscriptionId) {
		return vnfSubscriptionSol003FrontController.delete(subscriptionId);
	}

	/**
	 * Read an individual subscription resource.
	 *
	 * Query Subscription Information The GET method reads an individual
	 * subscription.
	 *
	 */
	@Override
	public ResponseEntity<PkgmSubscription> subscriptionsSubscriptionIdGet(final String subscriptionId) {
		return vnfSubscriptionSol003FrontController.findById(subscriptionId, x -> mapper.map(x, PkgmNotificationsFilter.class), VnfSubscriptions271Sol003Controller::makeLinks);
	}

	public static void makeLinks(final PkgmSubscription pkgmSubscription) {
		final PkgmSubscriptionLinks subscriptionsPkgmSubscriptionLinks = new PkgmSubscriptionLinks();
		final Link self = new Link();
		self.setHref(linkTo(methodOn(VnfSubscriptions271Sol003Api.class).subscriptionsSubscriptionIdGet(pkgmSubscription.getId())).withSelfRel().getHref());
		subscriptionsPkgmSubscriptionLinks.setSelf(self);
		pkgmSubscription.setLinks(subscriptionsPkgmSubscriptionLinks);
	}

	@Override
	public String makeSelfLink(final String id) {
		return linkTo(methodOn(VnfSubscriptions271Sol003Api.class).subscriptionsSubscriptionIdGet(id)).withSelfRel().getHref();
	}

	@Override
	public ApiAndType getApiAndType() {
		return ApiAndType.of(ApiTypesEnum.SOL003, SubscriptionType.VNF);
	}
}
