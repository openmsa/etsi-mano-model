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
package com.ubiqube.etsi.mano.v261.nfvo.controller.lcmgrant;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.common.v261.model.Link;
import com.ubiqube.etsi.mano.common.v261.model.lcmgrant.Grant;
import com.ubiqube.etsi.mano.common.v261.model.lcmgrant.GrantLinks;
import com.ubiqube.etsi.mano.controller.lcmgrant.LcmGrantsFrontController;
import com.ubiqube.etsi.mano.dao.mano.GrantResponse;
import com.ubiqube.etsi.mano.v261.model.nfvo.lcmgrant.GrantRequest;
import com.ubiqube.etsi.mano.v261.service.mapping.Grant261Mapping;

import jakarta.validation.Valid;

/**
 *
 * @author Olivier Vignaud {@literal {@literal <ovi@ubiqube.com>}}
 *
 */
@RestController
public class LcmGrants261Sol003Controller implements LcmGrants261Sol003Api {
	private final LcmGrantsFrontController lcmGrantsFrontController;
	private final Grant261Mapping mapper;

	public LcmGrants261Sol003Controller(final LcmGrantsFrontController lcmGrantsFrontController, final Grant261Mapping mapper) {
		this.lcmGrantsFrontController = lcmGrantsFrontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<Grant> grantsGrantIdGet(final String grantId) {
		return lcmGrantsFrontController.grantsGrantIdGet(grantId, x -> mapper.map(x), LcmGrants261Sol003Controller::makeSelfLinks);
	}

	@Override
	public ResponseEntity<Grant> grantsPost(@Valid final GrantRequest grantRequest) {
		final GrantResponse req = mapper.map(grantRequest);
		return lcmGrantsFrontController.grantsPost(req, x -> mapper.map(x), LcmGrants261Sol003Controller::getSelfLink);
	}

	private static void makeSelfLinks(final Grant jsonGrant) {
		final GrantLinks grantLinks = Optional.ofNullable(jsonGrant.getLinks()).orElseGet(GrantLinks::new);
		final Link link = new Link();
		link.setHref(linkTo(methodOn(LcmGrants261Sol003Api.class).grantsGrantIdGet(jsonGrant.getId())).withSelfRel().getHref());
		grantLinks.setSelf(link);
		jsonGrant.setLinks(grantLinks);
	}

	private static String getSelfLink(final Grant grant) {
		return linkTo(methodOn(LcmGrants261Sol003Api.class).grantsGrantIdGet(grant.getId())).withSelfRel().getHref();
	}

}
