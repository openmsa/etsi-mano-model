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
package com.ubiqube.etsi.mano.v261.nfvo.controller.vnf;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfPkgInfo;
import com.ubiqube.etsi.mano.common.v261.services.Linkable;
import com.ubiqube.etsi.mano.controller.vnf.OnboardedPackageFrontController;
import com.ubiqube.etsi.mano.v261.nfvo.service.Sol003Linkable;
import com.ubiqube.etsi.mano.v261.service.mapping.VnfPkgInfo261Mapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

/**
 *
 * @author Olivier Vignaud {@literal {@literal <ovi@ubiqube.com>}}
 *
 */
@RestController
public class VnfPackagesOnboarded261Sol003Controller implements VnfPackagesOnboarded261Sol003Api {
	private final Linkable links = new Sol003Linkable();
	private final OnboardedPackageFrontController vnfPackageFrontController;
	private final VnfPkgInfo261Mapping mapper;

	public VnfPackagesOnboarded261Sol003Controller(final OnboardedPackageFrontController vnfPackageFrontController, final VnfPkgInfo261Mapping mapper) {
		this.vnfPackageFrontController = vnfPackageFrontController;
		this.mapper = mapper;
	}

	@Override
	public final ResponseEntity<String> onboardedVnfPackagesGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return vnfPackageFrontController.onboardedSearch(requestParams, x -> mapper.map(x), links::makeLinks, VnfPkgInfo.class);
	}

	@Override
	public final ResponseEntity<Resource> onboardedVnfPackagesVnfdIdArtifactsArtifactPathGet(final HttpServletRequest request, final String vnfdId, @Valid final String includeSignatures) {
		return vnfPackageFrontController.onboardedGetArtifact(request, vnfdId, includeSignatures);
	}

	@Override
	public final ResponseEntity<VnfPkgInfo> onboardedVnfPackagesVnfdIdGet(final String vnfdId) {
		return vnfPackageFrontController.onboardedFindById(vnfdId, x -> mapper.map(x), links::makeLinks);
	}

	@Override
	public final ResponseEntity<Resource> onboardedVnfPackagesVnfdIdPackageContentGet(final String vnfdId, final String accept, final String includeSignature) {
		return vnfPackageFrontController.onboardedGetContentByVnfdId(vnfdId, accept, includeSignature);
	}

	@Override
	public final ResponseEntity<Resource> onboardedVnfPackagesVnfdIdVnfdGet(final String vnfdId, @Valid final String includeSignatures) {
		return vnfPackageFrontController.onboardedGetVnfdByVnfdId(vnfdId, includeSignatures);
	}

}
