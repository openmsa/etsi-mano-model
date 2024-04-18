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
package com.ubiqube.etsi.mano.v281.nfvo.controller.vnfm.vnf;

import static com.ubiqube.etsi.mano.Constants.getSafeUUID;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.vnf.VnfPackageFrontController;
import com.ubiqube.etsi.mano.v281.model.nfvo.vnf.VnfPkgInfo;
import com.ubiqube.etsi.mano.v281.nfvo.service.Linkable;
import com.ubiqube.etsi.mano.v281.nfvo.service.Sol003Linkable;
import com.ubiqube.etsi.mano.v281.service.mapping.VnfPkgInfo281Mapping;

import jakarta.annotation.Nonnull;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
public class VnfPackages281Sol003Controller implements VnfPackages281Sol003Api {
	private final VnfPkgInfo281Mapping mapper;
	private final VnfPackageFrontController frontController;
	@Nonnull
	private final Linkable links = new Sol003Linkable();

	public VnfPackages281Sol003Controller(final VnfPackageFrontController frontController, final VnfPkgInfo281Mapping mapper) {
		this.mapper = mapper;
		this.frontController = frontController;
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdArtifactsArtifactPathGet(final HttpServletRequest request, final String vnfPkgId, @Valid final String includeSignature) {
		return frontController.getArtifactPath(request, getSafeUUID(vnfPkgId), includeSignature);
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdArtifactsGet(final HttpServletRequest request, final String vnfPkgId, final String excludeAllManoArtifacts,
			final String excludeAllNonManoArtifacts, final String includeExternalArtifacts, final String selectNonManoArtifactSets, final String includeSignatures) {
		return frontController.getSelectArtifacts(request, getSafeUUID(vnfPkgId));
	}

	@Override
	public ResponseEntity<VnfPkgInfo> vnfPackagesVnfPkgIdGet(final String vnfPkgId, @Valid final String includeSignature) {
		return frontController.findByIdReadOnly(getSafeUUID(vnfPkgId), x -> mapper.map(x), links::makeLinks);
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
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdVnfdGet(final String vnfPkgId, @Valid final String includeSignature) {
		return frontController.getVfnd(getSafeUUID(vnfPkgId), null, includeSignature);
	}

}
