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
package com.ubiqube.etsi.mano.v351.vnfm.controller.vnfm.vnflcm;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v351.model.em.lcmcoord.Link;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.VnfLcmOpOcc;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.VnfLcmOpOccLinks;
import com.ubiqube.etsi.mano.v351.service.mapping.vnflcm.VnfBlueprint351Mapping;
import com.ubiqube.etsi.mano.v351.vnfm.service.VnfLcmClassMaping351;
import com.ubiqube.etsi.mano.vnfm.fc.vnflcm.VnfLcmOpOccGenericFrontController;

import jakarta.validation.Valid;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
public class VnfLcmOpOccs351Sol003Controller implements VnfLcmOpOccs351Sol003Api {
	private final VnfLcmOpOccGenericFrontController frontController;
	private final VnfBlueprint351Mapping mapper;
	private final VnfLcmClassMaping351 vnfLcmClassMaping351;

	public VnfLcmOpOccs351Sol003Controller(final VnfLcmOpOccGenericFrontController frontController, final VnfBlueprint351Mapping mapper, final VnfLcmClassMaping351 vnfLcmClassMaping351) {
		this.frontController = frontController;
		this.mapper = mapper;
		this.vnfLcmClassMaping351 = vnfLcmClassMaping351;
	}

	@Override
	public ResponseEntity<String> vnfLcmOpOccsGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return frontController.search(requestParams, x -> mapper.map(x), VnfLcmOpOccs351Sol003Controller::makeLinks, VnfLcmOpOcc.class);
	}

	@Override
	public ResponseEntity<Void> vnfLcmOpOccsVnfLcmOpOccIdCancelPost(final String vnfLcmOpOccId) {
		return frontController.lcmOpOccCancel(UUID.fromString(vnfLcmOpOccId));
	}

	@Override
	public ResponseEntity<VnfLcmOpOcc> vnfLcmOpOccsVnfLcmOpOccIdFailPost(final String vnfLcmOpOccId) {
		return frontController.lcmOpOccFail(UUID.fromString(vnfLcmOpOccId));
	}

	@Override
	public ResponseEntity<VnfLcmOpOcc> vnfLcmOpOccsVnfLcmOpOccIdGet(final String vnfLcmOpOccId) {
		return frontController.lcmOpOccFindById(vnfLcmClassMaping351, UUID.fromString(vnfLcmOpOccId), VnfLcmOpOccs351Sol003Controller::makeLinks, VnfLcmOpOccs351Sol003Controller::setOperationParams);
	}

	private static void setOperationParams(final VnfLcmOpOcc lcmOpOcc, final Object obj) {
		lcmOpOcc.setOperationParams(obj);
	}

	@Override
	public ResponseEntity<Void> vnfLcmOpOccsVnfLcmOpOccIdRetryPost(final String vnfLcmOpOccId) {
		return frontController.lcmOpOccRetry(UUID.fromString(vnfLcmOpOccId));
	}

	@Override
	public ResponseEntity<Void> vnfLcmOpOccsVnfLcmOpOccIdRollbackPost(final String vnfLcmOpOccId) {
		return frontController.lcmOpOccRollback(UUID.fromString(vnfLcmOpOccId));
	}

	private static void makeLinks(final VnfLcmOpOcc vnfLcmOpOcc) {
		final String id = vnfLcmOpOcc.getId();
		final VnfLcmOpOccLinks links = new VnfLcmOpOccLinks();
		final Link cancel = new Link();
		cancel.setHref(linkTo(methodOn(VnfLcmOpOccs351Sol003Api.class).vnfLcmOpOccsVnfLcmOpOccIdCancelPost(id)).withSelfRel().getHref());
		links.setCancel(cancel);

		final Link fail = new Link();
		fail.setHref(linkTo(methodOn(VnfLcmOpOccs351Sol003Api.class).vnfLcmOpOccsVnfLcmOpOccIdFailPost(id)).withSelfRel().getHref());
		links.setFail(fail);

		// XXX We can't have this grant link directly, because of classpath on
		// interface.
		// grant.setHref(linkTo(methodOn(LcmGrants.class).grantsGrantIdGet(vnfLcmOpOcc.getGrantId(),"")).withSelfRel().getHref());

		final Link retry = new Link();
		retry.setHref(linkTo(methodOn(VnfLcmOpOccs351Sol003Api.class).vnfLcmOpOccsVnfLcmOpOccIdRetryPost(id)).withSelfRel().getHref());
		links.setRetry(retry);

		final Link rollback = new Link();
		rollback.setHref(linkTo(methodOn(VnfLcmOpOccs351Sol003Api.class).vnfLcmOpOccsVnfLcmOpOccIdRollbackPost(id)).withSelfRel().getHref());
		links.setRollback(rollback);

		final Link self = new Link();
		self.setHref(linkTo(methodOn(VnfLcmOpOccs351Sol003Api.class).vnfLcmOpOccsVnfLcmOpOccIdGet(id)).withSelfRel().getHref());
		links.setSelf(self);

		final Link vnfInstance = new Link();
		vnfInstance.setHref(linkTo(methodOn(VnfInstances351Sol003Api.class).vnfInstancesVnfInstanceIdGet(vnfLcmOpOcc.getId())).withSelfRel().getHref());
		links.setVnfInstance(vnfInstance);

		vnfLcmOpOcc.setLinks(links);
	}

}
