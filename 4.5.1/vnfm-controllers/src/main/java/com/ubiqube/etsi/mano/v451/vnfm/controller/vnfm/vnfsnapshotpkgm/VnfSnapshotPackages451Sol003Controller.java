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
package com.ubiqube.etsi.mano.v451.vnfm.controller.vnfm.vnfsnapshotpkgm;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v451.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.v451.model.nfvo.vnfsnapshotpkgm.VnfSnapshotPkgInfo;
import com.ubiqube.etsi.mano.v451.model.nfvo.vnfsnapshotpkgm.VnfSnapshotPkgInfoLinks;
import com.ubiqube.etsi.mano.vnfm.fc.vnflcm.VnfSnapshotsFrontController;

import jakarta.validation.Valid;

@RestController
public class VnfSnapshotPackages451Sol003Controller implements VnfSnapshotPackages451Sol003Api {
	private final VnfSnapshotsFrontController vnfSnapshotsFrontController;

	public VnfSnapshotPackages451Sol003Controller(final VnfSnapshotsFrontController vnfSnapshotsFrontController) {
		this.vnfSnapshotsFrontController = vnfSnapshotsFrontController;
	}

	@Override
	public ResponseEntity<List<VnfSnapshotPkgInfo>> vnfSnapshotPackagesGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return vnfSnapshotsFrontController.search(requestParams, nextpageOpaqueMarker, VnfSnapshotPkgInfo.class, VnfSnapshotPackages451Sol003Controller::makeLinks);
	}

	@Override
	public ResponseEntity<VnfSnapshotPkgInfo> vnfSnapshotPackagesVnfSnapshotPkgIdGet(final String vnfSnapshotInfoId) {
		return vnfSnapshotsFrontController.findById(vnfSnapshotInfoId, VnfSnapshotPkgInfo.class, VnfSnapshotPackages451Sol003Controller::makeLinks);
	}

	@Override
	public ResponseEntity<Resource> vnfSnapshotPackagesVnfSnapshotPkgIdPackageContentGet(final String vnfSnapshotInfoId) {
		return vnfSnapshotsFrontController.fetch(vnfSnapshotInfoId, null);
	}

	@Override
	public ResponseEntity<Resource> vnfSnapshotPackagesVnfSnapshotPkgIdArtifactsArtifactPathGet(final String vnfSnapshotPkgId, final String artifactPath) {
		return vnfSnapshotsFrontController.fetchArtifact(vnfSnapshotPkgId, artifactPath);
	}

	private static void makeLinks(final VnfSnapshotPkgInfo subscription) {
		final VnfSnapshotPkgInfoLinks links = new VnfSnapshotPkgInfoLinks();
		final Link link = new Link();
		link.setHref(linkTo(methodOn(VnfSnapshotPackages451Sol003Api.class).vnfSnapshotPackagesVnfSnapshotPkgIdGet(subscription.getId())).withSelfRel().getHref());
		links.setSelf(link);
		subscription.setLinks(links);
	}

}
