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
package com.ubiqube.etsi.mano.v261.vnfm.service;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ubiqube.etsi.mano.common.v261.VnfSubscriptionFactory261;
import com.ubiqube.etsi.mano.common.v261.model.Link;
import com.ubiqube.etsi.mano.controller.subscription.AbstractSubscriptionFactory;
import com.ubiqube.etsi.mano.service.event.model.EventMessage;
import com.ubiqube.etsi.mano.v261.model.nfvo.lcmgrant.GrantRequest;
import com.ubiqube.etsi.mano.v261.model.nfvo.lcmgrant.GrantRequestLinks;
import com.ubiqube.etsi.mano.v261.service.VnfmFactory;
import com.ubiqube.etsi.mano.v261.vnfm.controller.vnfind.sol003.VnfIndSubscriptions261Sol003Controller;
import com.ubiqube.etsi.mano.v261.vnfm.controller.vnflcm.sol003.VnfLcm261Sol003Api;
import com.ubiqube.etsi.mano.v261.vnfm.controller.vnflcm.sol003.VnfLcm261Sol003Controller;
import com.ubiqube.etsi.mano.v261.vnfm.controller.vnflcm.sol003.VnfLcmOpOccs261Sol003Api;
import com.ubiqube.etsi.mano.v261.vnfm.controller.vnflcm.sol003.VnfLcmSubscriptions261Sol003Controller;

/**
 *
 * @author Olivier Vignaud {@literal {@literal <ovi@ubiqube.com>}}
 *
 */
@Service
public class VnfmFactory261Sol003 extends AbstractSubscriptionFactory implements VnfmFactory {

	public VnfmFactory261Sol003(final List<SubscriptionLinkable261Vnfm> subs) {
		super(subs);
	}

	@Override
	public void makeGrantRequestLink(final GrantRequest manoGrant) {
		final GrantRequestLinks links = new GrantRequestLinks();
		Link link = new Link();
		link.setHref(VnfLcm261Sol003Controller.getSelfLink(manoGrant.getVnfInstanceId()));
		links.setVnfInstance(link);

		link = new Link();
		link.setHref(linkTo(methodOn(VnfLcm261Sol003Api.class).vnfInstancesVnfInstanceIdGet(manoGrant.getVnfLcmOpOccId())).withSelfRel().getHref());
		links.setVnfLcmOpOcc(link);
	}

	@Override
	public Object createVnfIndicatorValueChangeNotification(final UUID subscriptionId, final EventMessage event) {
		return VnfSubscriptionFactory261.createNotificationVnfIndicatorValueChangeNotification(event.getId(), subscriptionId, event.getAdditionalParameters().get("vnfIndicatorId"), event.getAdditionalParameters().get("vnfInstanceId"), event.getAdditionalParameters().get("value"), event.getAdditionalParameters().get("vnfdId"), new Sol003Linkable());
	}

	@Override
	public String createVnfIndicatorSubscriptionLink(final Map<String, String> params) {
		return VnfIndSubscriptions261Sol003Controller.makeSelf(params.get("id"));
	}

	@Override
	public String createVnfLcmSubscriptionLink(final Map<String, String> params) {
		return VnfLcmSubscriptions261Sol003Controller.getSelfLink(params.get("id"));
	}

	@Override
	public String createGrantVnfInstanceLink(final String vnfInstanceId) {
		return VnfLcm261Sol003Controller.getSelfLink(vnfInstanceId);
	}

	@Override
	public String createGrantVnfLcmOpOccsLink(final String vnfLcmOpOccId) {
		return linkTo(methodOn(VnfLcmOpOccs261Sol003Api.class).vnfLcmOpOccsVnfLcmOpOccIdGet(vnfLcmOpOccId)).withSelfRel().getHref();
	}

}
