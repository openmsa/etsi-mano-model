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

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.vnf.OnboardedPackageFrontController;
import com.ubiqube.etsi.mano.v271.model.sol003.vnf.VnfPkgInfo;
import com.ubiqube.etsi.mano.v271.nfvo.service.Linkable;
import com.ubiqube.etsi.mano.v271.nfvo.service.Sol003Linkable;
import com.ubiqube.etsi.mano.v271.service.mapping.VnfPkgInfo271Mapping;

import jakarta.annotation.Nonnull;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
public class OnboardedVnfPackages271Sol003Controller implements OnboardedVnfPackages271Sol003Api {
	private final OnboardedPackageFrontController vnfPackageFrontController;
	private final VnfPkgInfo271Mapping mapper;
	@Nonnull
	private final Linkable links = new Sol003Linkable();

	public OnboardedVnfPackages271Sol003Controller(final OnboardedPackageFrontController vnfPackageFrontController, final VnfPkgInfo271Mapping mapper) {
		this.vnfPackageFrontController = vnfPackageFrontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<String> onboardedVnfPackagesGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return vnfPackageFrontController.onboardedSearch(requestParams, x -> mapper.map(x), links::makeLinks, VnfPkgInfo.class);
	}

	@Override
	public ResponseEntity<Resource> onboardedVnfPackagesVnfdIdArtifactsArtifactPathGet(final HttpServletRequest request, final String vnfdId, @Valid final String includeSignature) {
		return vnfPackageFrontController.onboardedGetArtifact(request, vnfdId, includeSignature);
	}

	@Override
	public ResponseEntity<VnfPkgInfo> onboardedVnfPackagesVnfdIdGet(final String vnfdId) {
		return vnfPackageFrontController.onboardedFindById(vnfdId, x -> mapper.map(x), links::makeLinks);
	}

	@Override
	public ResponseEntity<Resource> onboardedVnfPackagesVnfdIdManifestGet(final String vnfdId, @Valid final String includeSignature) {
		return vnfPackageFrontController.onboardedGetManifestByVnfd(vnfdId, includeSignature);
	}

	@Override
	public ResponseEntity<Resource> onboardedVnfPackagesVnfdIdPackageContentGet(final String vnfdId, final String accept, final String include) {
		return vnfPackageFrontController.onboardedGetContentByVnfdId(vnfdId, accept, include);
	}

	@Override
	public ResponseEntity<Resource> onboardedVnfPackagesVnfdIdVnfdGet(final String vnfdId, @Valid final String includeSignature) {
		return vnfPackageFrontController.onboardedGetVnfdByVnfdId(vnfdId, includeSignature);
	}

}
