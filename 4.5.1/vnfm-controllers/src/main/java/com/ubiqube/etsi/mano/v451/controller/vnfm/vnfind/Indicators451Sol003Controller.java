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
package com.ubiqube.etsi.mano.v451.controller.vnfm.vnfind;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v451.controller.vnfm.vnflcm.VnfInstances451Sol003Api;
import com.ubiqube.etsi.mano.v451.model.em.vnfind.VnfIndicator;
import com.ubiqube.etsi.mano.v451.model.em.vnfind.VnfIndicatorLinks;
import com.ubiqube.etsi.mano.v451.model.em.vnfind.VnfIndicatorSubscription;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.v451.service.mapping.VnfIndicator451Mapping;
import com.ubiqube.etsi.mano.vnfm.fc.vnfind.IndicatorsFrontController;

import jakarta.validation.Valid;

@RestController
public class Indicators451Sol003Controller implements Indicators451Sol003Api {
	private final IndicatorsFrontController indicatorsFrontController;
	private final VnfIndicator451Mapping vnfIndicator451Mapping;

	public Indicators451Sol003Controller(final IndicatorsFrontController indicatorsFrontController, final VnfIndicator451Mapping vnfIndicator451Mapping) {
		this.indicatorsFrontController = indicatorsFrontController;
		this.vnfIndicator451Mapping = vnfIndicator451Mapping;
	}

	@Override
	public ResponseEntity<List<VnfIndicator>> indicatorsGet(@Valid final String filter, @Valid final String nextpageOpaqueMarker) {
		return indicatorsFrontController.search(filter, nextpageOpaqueMarker, vnfIndicator451Mapping::map, Indicators451Sol003Controller::makeLink);
	}

	@Override
	public ResponseEntity<List<VnfIndicator>> indicatorsVnfInstanceIdGet(final String vnfInstanceId, @Valid final String filter, @Valid final String nextpageOpaqueMarker) {
		return indicatorsFrontController.findByVnfInstanceId(vnfInstanceId, filter, nextpageOpaqueMarker, vnfIndicator451Mapping::map, Indicators451Sol003Controller::makeLink);
	}

	@Override
	public ResponseEntity<VnfIndicator> indicatorsVnfInstanceIdIndicatorIdGet(final String vnfInstanceId, final String indicatorId) {
		return indicatorsFrontController.findByVnfInstanceIdAndIndicatorId(vnfInstanceId, indicatorId, vnfIndicator451Mapping::map, Indicators451Sol003Controller::makeLink);
	}

	private static void makeLink(final VnfIndicator x) {
		final VnfIndicatorLinks links = new VnfIndicatorLinks();
		Link link = new Link();
		link.setHref(linkTo(methodOn(Indicators451Sol003Api.class).indicatorsVnfInstanceIdIndicatorIdGet(x.getVnfInstanceId(), x.getId())).withSelfRel().getHref());
		links.setSelf(link);

		link = new Link();

		link.setHref(linkTo(methodOn(VnfInstances451Sol003Api.class).vnfInstancesVnfInstanceIdGet(x.getVnfInstanceId())).withSelfRel().getHref());
		links.setVnfInstance(link);

		x.setLinks(links);
	}

	@Override
	public ResponseEntity<Void> indicatorsSubscriptionsSubscriptionIdDelete(final String subscriptionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<VnfIndicatorSubscription> indicatorsSubscriptionsSubscriptionIdGet(final String subscriptionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
