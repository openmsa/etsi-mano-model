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
package com.ubiqube.etsi.mano.nfvo.v261.controller.vnf;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.common.v261.model.vnf.PkgmSubscription;
import com.ubiqube.etsi.mano.common.v261.model.vnf.PkgmSubscriptionRequest;
import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfPackageChangeNotification;
import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfPackageOnboardingNotification;
import com.ubiqube.etsi.mano.common.v261.services.Linkable;
import com.ubiqube.etsi.mano.controller.subscription.ApiAndType;
import com.ubiqube.etsi.mano.controller.vnf.VnfSubscriptionSol005FrontController;
import com.ubiqube.etsi.mano.dao.subscription.SubscriptionType;
import com.ubiqube.etsi.mano.nfvo.v261.services.Sol005Linkable;
import com.ubiqube.etsi.mano.nfvo.v261.services.SubscriptionLinkable261Nfvo;
import com.ubiqube.etsi.mano.service.auth.model.ApiTypesEnum;
import com.ubiqube.etsi.mano.service.event.model.Subscription;

import ma.glasnost.orika.MapperFacade;

/**
 *
 * @author Olivier Vignaud {@literal {@literal <ovi@ubiqube.com>}}
 *
 */
@RestController
public class VnfSubscription261Sol005Controller implements VnfSubscription261Sol005Api, SubscriptionLinkable261Nfvo {
	private final VnfSubscriptionSol005FrontController vnfSubscriptionSol005FrontController;
	private final MapperFacade mapper;
	private final Linkable links = new Sol005Linkable();

	public VnfSubscription261Sol005Controller(final VnfSubscriptionSol005FrontController vnfSubscriptionSol005FrontController, final MapperFacade mapper) {
		this.vnfSubscriptionSol005FrontController = vnfSubscriptionSol005FrontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<List<PkgmSubscription>> subscriptionsGet(final String filters) {
		return vnfSubscriptionSol005FrontController.search(filters, x -> mapper.map(x, PkgmSubscription.class), links::makeSubscriptionLink);
	}

	@Override
	public ResponseEntity<PkgmSubscription> subscriptionsPost(final PkgmSubscriptionRequest subscriptionsPostQuery) {
		final Subscription req = mapper.map(subscriptionsPostQuery, Subscription.class);
		return vnfSubscriptionSol005FrontController.create(req, VnfSubscription261Sol005Api.class, x -> mapper.map(x, PkgmSubscription.class), links::makeSubscriptionLink);
	}

	@Override
	public ResponseEntity<Void> subscriptionsSubscriptionIdDelete(final String subscriptionId) {
		return vnfSubscriptionSol005FrontController.delete(subscriptionId);
	}

	@Override
	public ResponseEntity<PkgmSubscription> subscriptionsSubscriptionIdGet(final String subscriptionId) {
		return vnfSubscriptionSol005FrontController.findById(subscriptionId, x -> mapper.map(x, PkgmSubscription.class), links::makeSubscriptionLink);

	}

	@Override
	public void vnfPackageChangeNotificationPost(final VnfPackageChangeNotification notificationsMessage) {
		final com.ubiqube.etsi.mano.dao.mano.VnfPackageChangeNotification req = mapper.map(notificationsMessage, com.ubiqube.etsi.mano.dao.mano.VnfPackageChangeNotification.class);
		vnfSubscriptionSol005FrontController.vnfPackageChangeNotificationPost(req);
	}

	@Override
	public void vnfPackageOnboardingNotificationPost(final VnfPackageOnboardingNotification notificationsMessage) {
		final com.ubiqube.etsi.mano.dao.mano.VnfPackageOnboardingNotification req = mapper.map(notificationsMessage, com.ubiqube.etsi.mano.dao.mano.VnfPackageOnboardingNotification.class);
		vnfSubscriptionSol005FrontController.vnfPackageOnboardingNotificationPost(req);
	}

	@Override
	public String makeSelfLink(final String id) {
		return links.makeSubscriptionLink(id);
	}

	@Override
	public ApiAndType getApiAndType() {
		return ApiAndType.of(ApiTypesEnum.SOL005, SubscriptionType.VNF);
	}

}
