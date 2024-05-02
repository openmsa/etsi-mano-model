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
package com.ubiqube.etsi.mano.v351.vnfm.service;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ubiqube.etsi.mano.controller.subscription.AbstractSubscriptionFactory;
import com.ubiqube.etsi.mano.service.event.model.EventMessage;
import com.ubiqube.etsi.mano.v351.service.VnfmFactory;
import com.ubiqube.etsi.mano.v351.vnfm.controller.vnfm.vnflcm.VnfInstances351Sol003Api;
import com.ubiqube.etsi.mano.v351.vnfm.controller.vnfm.vnflcm.VnfLcmOpOccs351Sol003Api;

@Service
public class VnfmFactory351 extends AbstractSubscriptionFactory implements VnfmFactory {

	public VnfmFactory351(final List<SubscriptionLinkable351Vnfm> subs) {
		super(subs);
	}

	@Override
	public Object createVnfIndicatorValueChangeNotification(final UUID subscriptionId, final EventMessage event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createGrantVnfInstanceLink(final String vnfInstanceId) {
		return linkTo(methodOn(VnfInstances351Sol003Api.class).vnfInstancesVnfInstanceIdGet(vnfInstanceId)).withSelfRel().getHref();
	}

	@Override
	public String createGrantVnfLcmOpOccsLink(final String vnfLcmOpOccId) {
		return linkTo(methodOn(VnfLcmOpOccs351Sol003Api.class).vnfLcmOpOccsVnfLcmOpOccIdGet(vnfLcmOpOccId)).withSelfRel().getHref();
	}

}
