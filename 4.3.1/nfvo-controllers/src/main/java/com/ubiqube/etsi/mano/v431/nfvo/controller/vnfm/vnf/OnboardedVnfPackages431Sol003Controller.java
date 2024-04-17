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
package com.ubiqube.etsi.mano.v431.nfvo.controller.vnfm.vnf;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.vnf.OnboardedPackageFrontController;
import com.ubiqube.etsi.mano.v431.model.nfvo.vnf.VnfPkgInfo;
import com.ubiqube.etsi.mano.v431.nfvo.service.LinksSol003;
import com.ubiqube.etsi.mano.v431.service.mapping.VnfPkgInfo431Mapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
public class OnboardedVnfPackages431Sol003Controller implements OnboardedVnfPackages431Sol003Api {
	private final OnboardedPackageFrontController onboardedVnfPackageFrontController;
	private final VnfPkgInfo431Mapping mapper;

	public OnboardedVnfPackages431Sol003Controller(final OnboardedPackageFrontController vnfPackageFrontController, final VnfPkgInfo431Mapping mapper) {
		this.onboardedVnfPackageFrontController = vnfPackageFrontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<String> onboardedVnfPackagesGet(final MultiValueMap<String, String> requestParams, final String nextpageOpaqueMarker) {
		return onboardedVnfPackageFrontController.onboardedSearch(requestParams, x -> mapper.map(x), LinksSol003::makeLinks, VnfPkgInfo.class);
	}

	@Override
	public ResponseEntity<Resource> onboardedVnfPackagesVnfdIdArtifactsArtifactPathGet(final HttpServletRequest request, final String vnfdId, @Valid final String includeSignature) {
		return onboardedVnfPackageFrontController.onboardedGetArtifact(request, vnfdId, includeSignature);
	}

	@Override
	public ResponseEntity<Resource> onboardedVnfPackagesVnfdIdArtifactsGet(final String vnfdId, final String excludeAllManoArtifacts, final String excludeAllNonManoArtifacts, final String includeExternalArtifacts, final String selectNonManoArtifactSets, final String includeSignatures) {
		return onboardedVnfPackageFrontController.onboardedGetArtifactByVnfdId(vnfdId);
	}

	@Override
	public ResponseEntity<VnfPkgInfo> onboardedVnfPackagesVnfdIdGet(final String vnfdId) {
		return onboardedVnfPackageFrontController.onboardedFindById(vnfdId, x -> mapper.map(x), LinksSol003::makeLinks);
	}

	@Override
	public ResponseEntity<Resource> onboardedVnfPackagesVnfdIdManifestGet(final String vnfdId, @Valid final String includeSignature) {
		return onboardedVnfPackageFrontController.onboardedGetManifestByVnfd(vnfdId, includeSignature);
	}

	@Override
	public ResponseEntity<Resource> onboardedVnfPackagesVnfdIdPackageContentGet(final String vnfdId, final String accept, final String includeSignature) {
		return onboardedVnfPackageFrontController.onboardedGetContentByVnfdId(vnfdId, accept, includeSignature);
	}

	@Override
	public ResponseEntity<Resource> onboardedVnfPackagesVnfdIdVnfdGet(final String vnfdId, @Valid final String includeSignature) {
		return onboardedVnfPackageFrontController.onboardedGetVnfdByVnfdId(vnfdId, includeSignature);
	}

}
