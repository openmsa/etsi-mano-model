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
package com.ubiqube.etsi.mano.v351.nfvo.controller.vnfm.vnf;

import static com.ubiqube.etsi.mano.nfvo.fc.controller.NfvoConstants.getSafeUUID;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.vnf.VnfPackageFrontController;
import com.ubiqube.etsi.mano.v351.model.nfvo.vnf.VnfPkgInfo;
import com.ubiqube.etsi.mano.v351.nfvo.service.LinksSol003;
import com.ubiqube.etsi.mano.v351.service.mapping.VnfPkgInfo351Mapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
public class VnfPackages351Sol003Controller implements VnfPackages351Sol003Api {
	private final VnfPackageFrontController frontController;
	private final VnfPkgInfo351Mapping mapper;

	public VnfPackages351Sol003Controller(final VnfPackageFrontController frontController, final VnfPkgInfo351Mapping mapper) {
		this.frontController = frontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdArtifactsArtifactPathGet(final HttpServletRequest request, final String vnfPkgId, @Valid final String includeSignature) {
		return frontController.getArtifactPath(request, getSafeUUID(vnfPkgId), includeSignature);
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdArtifactsGet(final HttpServletRequest request, final String vnfPkgId) {
		return frontController.getSelectArtifacts(request, getSafeUUID(vnfPkgId));
	}

	@Override
	public ResponseEntity<VnfPkgInfo> vnfPackagesVnfPkgIdGet(final String vnfPkgId, @Valid final String includeSignature) {
		return frontController.findByIdReadOnly(getSafeUUID(vnfPkgId), x -> mapper.map(x), LinksSol003::makeLinks);
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdManifestGet(final String vnfPkgId, @Valid final String includeSignature) {
		return frontController.getManifest(getSafeUUID(vnfPkgId), includeSignature);
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdPackageContentGet(final String vnfPkgId) {
		return frontController.getContent(getSafeUUID(vnfPkgId));
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdVnfdGet(final String vnfPkgId, final String accept, @Valid final String includeSignature) {
		return frontController.getVfnd(getSafeUUID(vnfPkgId), accept, includeSignature);
	}

	@Override
	public ResponseEntity<String> vnfPackagesGet(final MultiValueMap<String, String> requestParams, final String nextpageOpaqueMarker) {
		return frontController.search(requestParams, x -> mapper.map(x), LinksSol003::makeLinks, VnfPkgInfo.class);
	}

}
