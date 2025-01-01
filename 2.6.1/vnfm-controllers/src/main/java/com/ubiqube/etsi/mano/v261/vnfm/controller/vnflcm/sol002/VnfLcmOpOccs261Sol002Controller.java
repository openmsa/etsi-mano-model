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
package com.ubiqube.etsi.mano.v261.vnfm.controller.vnflcm.sol002;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.common.v261.model.Link;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.VnfLcmOpOcc;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.VnfLcmOpOccLinks;
import com.ubiqube.etsi.mano.v261.service.mapping.vnflcm.VnfBlueprint261Mapping;
import com.ubiqube.etsi.mano.v261.vnfm.service.VnfLcmClassMaping261;
import com.ubiqube.etsi.mano.vnfm.fc.vnflcm.VnfLcmOpOccGenericFrontController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author Olivier Vignaud {@literal {@literal <ovi@ubiqube.com>}}
 *
 */
@RestController
public class VnfLcmOpOccs261Sol002Controller implements VnfLcmOpOccs261Sol002Api {
	private final VnfLcmOpOccGenericFrontController frontController;
	private final VnfBlueprint261Mapping mapper;
	private final VnfLcmClassMaping261 vnfLcmClassMaping261;

	public VnfLcmOpOccs261Sol002Controller(final VnfLcmOpOccGenericFrontController frontController, final VnfBlueprint261Mapping mapper, final VnfLcmClassMaping261 vnfLcmClassMaping261) {
		this.frontController = frontController;
		this.mapper = mapper;
		this.vnfLcmClassMaping261 = vnfLcmClassMaping261;
	}

	@Override
	public ResponseEntity<String> vnfLcmOpOccsGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return frontController.search(requestParams, x -> mapper.map(x), VnfLcmOpOccs261Sol002Controller::makeLinks, VnfLcmOpOcc.class);
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
		return frontController.lcmOpOccFindById(vnfLcmClassMaping261, UUID.fromString(vnfLcmOpOccId),
				VnfLcmOpOccs261Sol002Controller::makeLinks, VnfLcmOpOccs261Sol002Controller::setOperationParams);
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

	private static void makeLinks(@NotNull final VnfLcmOpOcc vnfLcmOpOcc) {
		@NotNull
		final String id = vnfLcmOpOcc.getId();
		final VnfLcmOpOccLinks links = new VnfLcmOpOccLinks();
		final Link cancel = new Link();
		cancel.setHref(linkTo(methodOn(VnfLcmOpOccs261Sol002Api.class).vnfLcmOpOccsVnfLcmOpOccIdGet(id)).withSelfRel().getHref());
		links.setCancel(cancel);

		final Link fail = new Link();
		fail.setHref(linkTo(methodOn(VnfLcmOpOccs261Sol002Api.class).vnfLcmOpOccsVnfLcmOpOccIdFailPost(id)).withSelfRel().getHref());
		links.setFail(fail);

		// XXX We can't have this grant link directly.
		// grant.setHref(linkTo(methodOn(LcmGrants.class).grantsGrantIdGet(vnfLcmOpOcc.getGrantId(),
		// "")).withSelfRel().getHref());

		final Link retry = new Link();
		retry.setHref(linkTo(methodOn(VnfLcmOpOccs261Sol002Api.class).vnfLcmOpOccsVnfLcmOpOccIdRetryPost(id)).withSelfRel().getHref());
		links.setRetry(retry);

		final Link rollback = new Link();
		rollback.setHref(linkTo(methodOn(VnfLcmOpOccs261Sol002Api.class).vnfLcmOpOccsVnfLcmOpOccIdRollbackPost(id)).withSelfRel().getHref());
		links.setRollback(rollback);

		final Link self = new Link();
		self.setHref(linkTo(methodOn(VnfLcmOpOccs261Sol002Api.class).vnfLcmOpOccsVnfLcmOpOccIdGet(id)).withSelfRel().getHref());
		links.setSelf(self);

		final Link vnfInstance = new Link();
		vnfInstance.setHref(linkTo(methodOn(VnfLcm261Sol002Api.class).vnfInstancesVnfInstanceIdGet(vnfLcmOpOcc.getId())).withSelfRel().getHref());
		links.setVnfInstance(vnfInstance);

		vnfLcmOpOcc.setLinks(links);
	}

}
