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
package com.ubiqube.etsi.mano.v361.em.controller.vnfind;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.context.annotation.Conditional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.SingleControllerCondition;
import com.ubiqube.etsi.mano.v361.model.em.vnfind.VnfIndicator;
import com.ubiqube.etsi.mano.v361.model.em.vnfind.VnfIndicatorLinks;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.vnfm.fc.vnfind.Sol002IndicatorsFrontController;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RequestMapping(value = "/sol002/vnfind/v1", headers = { "Version=1.3.1" })
@RolesAllowed({ "ROLE_EM" })
@RestController
@Conditional(SingleControllerCondition.class)
public class Indicators361Sol002Controller implements Indicators361Sol002Api {
	private final Sol002IndicatorsFrontController indicatorsFrontController;

	public Indicators361Sol002Controller(final Sol002IndicatorsFrontController indicatorsFrontController) {
		this.indicatorsFrontController = indicatorsFrontController;
	}

	@Override
	public ResponseEntity<List<VnfIndicator>> indicatorsGet(@Valid final String filter, @Valid final String nextpageOpaqueMarker) {
		return indicatorsFrontController.search(filter, nextpageOpaqueMarker, VnfIndicator.class, Indicators361Sol002Controller::makeLink);
	}

	@Override
	public ResponseEntity<List<VnfIndicator>> indicatorsVnfInstanceIdGet(final String vnfInstanceId, @Valid final String filter, @Valid final String nextpageOpaqueMarker) {
		return indicatorsFrontController.findByVnfInstanceId(vnfInstanceId, filter, nextpageOpaqueMarker, VnfIndicator.class, Indicators361Sol002Controller::makeLink);
	}

	@Override
	public ResponseEntity<VnfIndicator> indicatorsVnfInstanceIdIndicatorIdGet(final String vnfInstanceId, final String indicatorId) {
		return indicatorsFrontController.findByVnfInstanceIdAndIndicatorId(vnfInstanceId, indicatorId, VnfIndicator.class, Indicators361Sol002Controller::makeLink);
	}

	private static void makeLink(final VnfIndicator x) {
		final VnfIndicatorLinks links = new VnfIndicatorLinks();
		Link link = new Link();
		link.setHref(linkTo(methodOn(Indicators361Sol002Api.class).indicatorsVnfInstanceIdIndicatorIdGet(x.getVnfInstanceId(), x.getId())).withSelfRel().getHref());
		links.setSelf(link);

		link = new Link();

//		link.setHref(linkTo(methodOn(VnfInstances361Sol003Api.class).vnfInstancesVnfInstanceIdGet(x.getVnfInstanceId())).withSelfRel().getHref())
//		links.setVnfInstance(link)

		x.setLinks(links);
	}

}
