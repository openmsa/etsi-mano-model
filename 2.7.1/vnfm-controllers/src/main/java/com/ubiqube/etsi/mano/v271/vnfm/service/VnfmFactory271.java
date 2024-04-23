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
package com.ubiqube.etsi.mano.v271.vnfm.service;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ubiqube.etsi.mano.controller.subscription.AbstractSubscriptionFactory;
import com.ubiqube.etsi.mano.service.event.model.EventMessage;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.v271.model.sol003.lcmgrant.GrantRequest;
import com.ubiqube.etsi.mano.v271.model.sol003.lcmgrant.GrantRequestLinks;
import com.ubiqube.etsi.mano.v271.service.VnfmFactory;
import com.ubiqube.etsi.mano.v271.vnfm.controller.em.vnflcm.VnfInstances271Sol002Api;
import com.ubiqube.etsi.mano.v271.vnfm.controller.em.vnflcm.VnfInstances271Sol002Controller;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@Service
public class VnfmFactory271 extends AbstractSubscriptionFactory implements VnfmFactory {

	public VnfmFactory271(final List<SubscriptionLinkable271Vnfm> subs) {
		super(subs);
	}

	@Override
	public void makeGrantRequestLink(final GrantRequest manoGrant) {
		final GrantRequestLinks links = new GrantRequestLinks();
		Link link = new Link();
		link.setHref(VnfInstances271Sol002Controller.getSelfLink(manoGrant.getVnfInstanceId()));
		links.setVnfInstance(link);

		link = new Link();
		link.setHref(linkTo(methodOn(VnfInstances271Sol002Api.class).vnfInstancesVnfInstanceIdGet(manoGrant.getVnfLcmOpOccId())).withSelfRel().getHref());
		links.setVnfLcmOpOcc(link);
	}

	@Override
	public Object createVnfIndicatorValueChangeNotification(final UUID subscriptionId, final EventMessage event) {
		return null;
	}

}
