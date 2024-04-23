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
package com.ubiqube.etsi.mano.v271.nfvo.controller.vnf;

import static com.ubiqube.etsi.mano.Constants.getSafeUUID;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.vnf.VnfPackageFrontController;
import com.ubiqube.etsi.mano.v271.model.sol003.vnf.VnfPkgInfo;
import com.ubiqube.etsi.mano.v271.nfvo.service.Linkable;
import com.ubiqube.etsi.mano.v271.nfvo.service.Sol003Linkable;

import jakarta.annotation.Nonnull;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import ma.glasnost.orika.MapperFacade;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
public class VnfPackages271Sol003Controller implements VnfPackages271Sol003Api {
	private final MapperFacade mapper;
	private final VnfPackageFrontController frontController;
	@Nonnull
	private final Linkable links = new Sol003Linkable();

	public VnfPackages271Sol003Controller(final VnfPackageFrontController frontController, final MapperFacade mapper) {
		this.mapper = mapper;
		this.frontController = frontController;
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdArtifactsArtifactPathGet(final HttpServletRequest request, final String vnfPkgId, final String range, @Valid final String includeSignature) {
		return frontController.getArtifactPath(request, getSafeUUID(vnfPkgId), includeSignature);
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdArtifactsGet(final HttpServletRequest request, final String vnfPkgId, final String range) {
		return frontController.getSelectArtifacts(request, getSafeUUID(vnfPkgId));
	}

	@Override
	public ResponseEntity<VnfPkgInfo> vnfPackagesVnfPkgIdGet(final String vnfPkgId, @Valid final String includeSignature) {
		return frontController.findByIdReadOnly(getSafeUUID(vnfPkgId), x -> mapper.map(x, VnfPkgInfo.class), links::makeLinks);
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdManifestGet(final String vnfPkgId, @Valid final String includeSignature) {
		return frontController.getManifest(getSafeUUID(vnfPkgId), includeSignature);
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdPackageContentGet(final String vnfPkgId, final String range) {
		return frontController.getContent(getSafeUUID(vnfPkgId));
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdVnfdGet(final String vnfPkgId, final String accept, @Valid final String includeSignature) {
		return frontController.getVfnd(getSafeUUID(vnfPkgId), accept, includeSignature);
	}

}
