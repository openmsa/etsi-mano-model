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
package com.ubiqube.etsi.mano.v361.vnfm.service;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ubiqube.etsi.mano.controller.subscription.AbstractSubscriptionFactory;
import com.ubiqube.etsi.mano.service.event.model.EventMessage;
import com.ubiqube.etsi.mano.v361.service.VnfmFactory;
import com.ubiqube.etsi.mano.v361.vnfm.controller.vnflcm.VnfInstances361Sol003Api;
import com.ubiqube.etsi.mano.v361.vnfm.controller.vnflcm.VnfLcmOpOccs361Sol003Api;

@Service
public class VnfmFactory361 extends AbstractSubscriptionFactory implements VnfmFactory {

	public VnfmFactory361(final List<SubscriptionLinkable361Vnfm> subs) {
		super(subs);
	}

	@Override
	public Object createVnfIndicatorValueChangeNotification(final UUID subscriptionId, final EventMessage event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createGrantVnfInstanceLink(final String vnfInstanceId) {
		return linkTo(methodOn(VnfInstances361Sol003Api.class).vnfInstancesVnfInstanceIdGet(vnfInstanceId)).withSelfRel().getHref();
	}

	@Override
	public String createGrantVnfLcmOpOccsLink(final String vnfLcmOpOccId) {
		return linkTo(methodOn(VnfLcmOpOccs361Sol003Api.class).vnfLcmOpOccsVnfLcmOpOccIdGet(vnfLcmOpOccId)).withSelfRel().getHref();
	}

}
