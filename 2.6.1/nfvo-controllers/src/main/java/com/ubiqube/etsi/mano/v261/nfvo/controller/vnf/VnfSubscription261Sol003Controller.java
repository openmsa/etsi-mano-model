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
package com.ubiqube.etsi.mano.v261.nfvo.controller.vnf;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.common.v261.model.vnf.PkgmNotificationsFilter;
import com.ubiqube.etsi.mano.common.v261.model.vnf.PkgmSubscription;
import com.ubiqube.etsi.mano.common.v261.model.vnf.PkgmSubscriptionRequest;
import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfPackageChangeNotification;
import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfPackageOnboardingNotification;
import com.ubiqube.etsi.mano.common.v261.services.Linkable;
import com.ubiqube.etsi.mano.controller.subscription.ApiAndType;
import com.ubiqube.etsi.mano.controller.vnf.VnfSubscriptionSol003FrontController;
import com.ubiqube.etsi.mano.dao.subscription.SubscriptionType;
import com.ubiqube.etsi.mano.service.auth.model.ApiTypesEnum;
import com.ubiqube.etsi.mano.service.event.model.Subscription;
import com.ubiqube.etsi.mano.v261.nfvo.service.Sol003Linkable;
import com.ubiqube.etsi.mano.v261.nfvo.service.SubscriptionLinkable261Nfvo;
import com.ubiqube.etsi.mano.v261.service.mapping.pkg.VnfPackageOnboardingNotification261Mapping;
import com.ubiqube.etsi.mano.v261.service.mapping.subscription.PkgmSubscriptionRequest261Mapping;

/**
 *
 * @author Olivier Vignaud {@literal {@literal <ovi@ubiqube.com>}}
 *
 */
@RestController
public class VnfSubscription261Sol003Controller implements VnfSubscription261Sol003Api, SubscriptionLinkable261Nfvo {
	private final VnfSubscriptionSol003FrontController vnfSubscriptionSol03FrontController;
	private final PkgmSubscriptionRequest261Mapping mapper;
	private final VnfPackageOnboardingNotification261Mapping notificationMapper;
	private final Linkable links = new Sol003Linkable();

	public VnfSubscription261Sol003Controller(final VnfSubscriptionSol003FrontController vnfSubscriptionSol03FrontController, final PkgmSubscriptionRequest261Mapping mapper, final VnfPackageOnboardingNotification261Mapping notificationMapper) {
		this.vnfSubscriptionSol03FrontController = vnfSubscriptionSol03FrontController;
		this.mapper = mapper;
		this.notificationMapper = notificationMapper;
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
		return vnfSubscriptionSol03FrontController.search(filter, x -> mapper.map(x, PkgmNotificationsFilter.class), links::makeSubscriptionLink);
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
		return vnfSubscriptionSol03FrontController.create(req, x -> mapper.map(x, PkgmNotificationsFilter.class), VnfSubscription261Sol003Api.class, links::makeSubscriptionLink);
	}

	/**
	 * Terminate a subscription.
	 *
	 * The DELETE method terminates an individual subscription.
	 *
	 */
	@Override
	public ResponseEntity<Void> subscriptionsSubscriptionIdDelete(final String subscriptionId) {
		return vnfSubscriptionSol03FrontController.delete(subscriptionId);
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
		return vnfSubscriptionSol03FrontController.findById(subscriptionId, x -> mapper.map(x, PkgmNotificationsFilter.class), links::makeSubscriptionLink);
	}

	/**
	 * Test the notification endpoint
	 *
	 * The GET method allows the server to test the notification endpoint that is
	 * provided by the client, e.g. during subscription. This method shall follow
	 * the provisions specified in the Tables 9.4.10.3.2-1 and 9.4.10.3.2-2 for URI
	 * query parameters, request and response data structures, and response codes.
	 *
	 */
	@Override
	public void uRIIsProvidedByTheClientWhenCreatingTheSubscriptionVnfPackageChangeNotificationGet() {
		// Nothing.
	}

	/**
	 * Notify about VNF package onboarding or change
	 *
	 * The POST method delivers a notification from the server to the client. This
	 * method shall follow the provisions specified in the Tables 9.4.10.3.1-1 and
	 * 9.4.10.3.1-2 for URI query parameters, request and response data structures,
	 * and response codes.
	 *
	 */
	@Override
	public void vnfPackageChangeNotificationPost(final VnfPackageChangeNotification notificationsMessage) {
		final com.ubiqube.etsi.mano.dao.mano.VnfPackageChangeNotification req = notificationMapper.map(notificationsMessage);
		vnfSubscriptionSol03FrontController.vnfPackageChangeNotificationPost(req);
	}

	/**
	 * Notify about VNF package onboarding or change
	 *
	 * The POST method delivers a notification from the server to the client. This
	 * method shall follow the provisions specified in the Tables 9.4.10.3.1-1 and
	 * 9.4.10.3.1-2 for URI query parameters, request and response data structures,
	 * and response codes.
	 *
	 */
	@Override
	public void vnfPackageOnboardingNotificationPost(final VnfPackageOnboardingNotification notificationsMessage) {
		final com.ubiqube.etsi.mano.dao.mano.VnfPackageOnboardingNotification req = notificationMapper.map(notificationsMessage);
		vnfSubscriptionSol03FrontController.vnfPackageOnboardingNotificationPost(req);
	}

	@Override
	public String makeSelfLink(final String id) {
		return links.makeSubscriptionLink(id);
	}

	@Override
	public ApiAndType getApiAndType() {
		return ApiAndType.of(ApiTypesEnum.SOL003, SubscriptionType.VNF);
	}

}
