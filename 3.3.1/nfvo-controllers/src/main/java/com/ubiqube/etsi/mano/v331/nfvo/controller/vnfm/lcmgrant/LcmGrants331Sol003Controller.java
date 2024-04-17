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
package com.ubiqube.etsi.mano.v331.nfvo.controller.vnfm.lcmgrant;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.lcmgrant.LcmGrantsFrontController;
import com.ubiqube.etsi.mano.dao.mano.GrantResponse;
import com.ubiqube.etsi.mano.v331.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.v331.model.vnfm.grant.Grant;
import com.ubiqube.etsi.mano.v331.model.vnfm.grant.GrantRequest;

import jakarta.validation.Valid;
import ma.glasnost.orika.MapperFacade;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
public class LcmGrants331Sol003Controller implements LcmGrants331Sol003Api {
	private final LcmGrantsFrontController lcmGrantsFrontController;
	private final MapperFacade mapper;

	public LcmGrants331Sol003Controller(final LcmGrantsFrontController lcmGrantsFrontController, final MapperFacade mapper) {
		this.lcmGrantsFrontController = lcmGrantsFrontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<Grant> grantsGrantIdGet(final String grantId) {
		return lcmGrantsFrontController.grantsGrantIdGet(grantId, x -> mapper.map(x, Grant.class), LcmGrants331Sol003Controller::makeSelfLinks);
	}

	@Override
	public ResponseEntity<Grant> grantsPost(@Valid final GrantRequest body) {
		final GrantResponse req = mapper.map(body, GrantResponse.class);
		return lcmGrantsFrontController.grantsPost(req, x -> mapper.map(x, Grant.class), LcmGrants331Sol003Controller::getSelfLink);
	}

	private static void makeSelfLinks(final Grant jsonGrant) {
		final Link link = new Link();
		link.setHref(linkTo(methodOn(LcmGrants331Sol003Api.class).grantsGrantIdGet(jsonGrant.getId())).withSelfRel().getHref());
		jsonGrant.getLinks().setSelf(link);
	}

	private static String getSelfLink(final Grant grant) {
		return linkTo(methodOn(LcmGrants331Sol003Api.class).grantsGrantIdGet(grant.getId())).withSelfRel().getHref();
	}

}