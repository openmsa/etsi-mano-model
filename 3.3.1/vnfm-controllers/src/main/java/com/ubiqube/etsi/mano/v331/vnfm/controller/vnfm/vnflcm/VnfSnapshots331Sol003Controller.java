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
package com.ubiqube.etsi.mano.v331.vnfm.controller.vnfm.vnflcm;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.List;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v331.model.em.vnflcm.CreateVnfSnapshotInfoRequest;
import com.ubiqube.etsi.mano.v331.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.v331.model.em.vnflcm.VnfSnapshotInfo;
import com.ubiqube.etsi.mano.v331.model.em.vnflcm.VnfSnapshotInfoLinks;
import com.ubiqube.etsi.mano.v331.model.vnfm.vnflcm.VnfSnapshotInfoModificationRequest;
import com.ubiqube.etsi.mano.v331.model.vnfm.vnflcm.VnfSnapshotInfoModifications;
import com.ubiqube.etsi.mano.vnfm.fc.vnflcm.VnfSnapshotsFrontController;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RolesAllowed({ "ROLE_NFVO" })
@RestController
public class VnfSnapshots331Sol003Controller implements VnfSnapshots331Sol003Api {
	private final VnfSnapshotsFrontController vnfSnapshotsFrontController;

	public VnfSnapshots331Sol003Controller(final VnfSnapshotsFrontController vnfSnapshotsFrontController) {
		super();
		this.vnfSnapshotsFrontController = vnfSnapshotsFrontController;
	}

	@Override
	public ResponseEntity<List<VnfSnapshotInfo>> vnfSnapshotsGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return vnfSnapshotsFrontController.search(requestParams, nextpageOpaqueMarker, VnfSnapshotInfo.class, VnfSnapshots331Sol003Controller::makeLinks);
	}

	@Override
	public ResponseEntity<VnfSnapshotInfo> vnfSnapshotsPost(@Valid final CreateVnfSnapshotInfoRequest body) {
		return vnfSnapshotsFrontController.create(body, VnfSnapshotInfo.class, VnfSnapshots331Sol003Controller::makeLinks);
	}

	@Override
	public ResponseEntity<Void> vnfSnapshotsVnfSnapshotInfoIdDelete(final String vnfSnapshotInfoId) {
		return vnfSnapshotsFrontController.delete(vnfSnapshotInfoId);
	}

	@Override
	public ResponseEntity<VnfSnapshotInfo> vnfSnapshotsVnfSnapshotInfoIdGet(final String vnfSnapshotInfoId) {
		return vnfSnapshotsFrontController.findById(vnfSnapshotInfoId, VnfSnapshotInfo.class, VnfSnapshots331Sol003Controller::makeLinks);
	}

	@Override
	public ResponseEntity<VnfSnapshotInfoModifications> vnfSnapshotsVnfSnapshotInfoIdPatch(final String vnfSnapshotInfoId, @Valid final VnfSnapshotInfoModificationRequest body) {
		return vnfSnapshotsFrontController.patch(vnfSnapshotInfoId, body, VnfSnapshotInfoModifications.class);
	}

	@Override
	public ResponseEntity<Resource> vnfSnapshotsVnfSnapshotInfoIdVnfStateSnapshotGet(final String vnfSnapshotInfoId, final String range) {
		return vnfSnapshotsFrontController.fetch(vnfSnapshotInfoId, range);
	}

	private static void makeLinks(final VnfSnapshotInfo subscription) {
		final VnfSnapshotInfoLinks links = new VnfSnapshotInfoLinks();
		final Link link = new Link();
		link.setHref(linkTo(methodOn(VnfSnapshots331Sol003Api.class).vnfSnapshotsVnfSnapshotInfoIdGet(subscription.getId())).withSelfRel().getHref());
		links.setSelf(link);
		subscription.setLinks(links);
	}

}
