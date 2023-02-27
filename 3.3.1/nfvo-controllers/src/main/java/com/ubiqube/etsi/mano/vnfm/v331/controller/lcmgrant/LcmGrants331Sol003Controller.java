/**
 *     Copyright (C) 2019-2023 Ubiqube.
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
package com.ubiqube.etsi.mano.vnfm.v331.controller.lcmgrant;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.lcmgrant.LcmGrantsFrontController;
import com.ubiqube.etsi.mano.em.v331.model.vnflcm.Link;
import com.ubiqube.etsi.mano.or.v331.model.grants.GrantNsLifecycleOperationRequest;
import com.ubiqube.etsi.mano.vnfm.v331.model.grant.Grant;

/**
 *
 * @author Olivier Vignaud <ovi@ubiqube.com>
 *
 */
@RestController
public class LcmGrants331Sol003Controller implements LcmGrants331Sol003Api {
	private final LcmGrantsFrontController lcmGrantsFrontController;

	public LcmGrants331Sol003Controller(final LcmGrantsFrontController lcmGrantsFrontController) {
		super();
		this.lcmGrantsFrontController = lcmGrantsFrontController;
	}

	@Override
	public ResponseEntity<Grant> grantsGrantIdGet(final String grantId) {
		return lcmGrantsFrontController.grantsGrantIdGet(grantId, Grant.class, LcmGrants331Sol003Controller::makeSelfLinks);
	}

	@Override
	public ResponseEntity<Grant> grantsPost(@Valid final GrantNsLifecycleOperationRequest grantRequest) {
		return lcmGrantsFrontController.grantsPost(grantRequest, Grant.class, LcmGrants331Sol003Controller::getSelfLink);
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
