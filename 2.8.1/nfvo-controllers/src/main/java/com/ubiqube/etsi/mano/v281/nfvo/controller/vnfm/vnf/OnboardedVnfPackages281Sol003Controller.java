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
package com.ubiqube.etsi.mano.v281.nfvo.controller.vnfm.vnf;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.vnf.OnboardedPackageFrontController;
import com.ubiqube.etsi.mano.v281.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.v281.model.nfvo.vnf.VnfPkgInfo;
import com.ubiqube.etsi.mano.v281.model.nfvo.vnf.VnfPkgInfoLinks;
import com.ubiqube.etsi.mano.v281.nfvo.controller.nfvo.vnf.VnfPackages281Sol005Api;
import com.ubiqube.etsi.mano.v281.service.mapping.VnfPkgInfo281Mapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
public class OnboardedVnfPackages281Sol003Controller implements OnboardedVnfPackages281Sol003Api {
	private final OnboardedPackageFrontController vnfPackageFrontController;
	private final VnfPkgInfo281Mapping mapper;

	public OnboardedVnfPackages281Sol003Controller(final OnboardedPackageFrontController vnfPackageFrontController, final VnfPkgInfo281Mapping mapper) {
		this.vnfPackageFrontController = vnfPackageFrontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<String> onboardedVnfPackagesGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return vnfPackageFrontController.onboardedSearch(requestParams, x -> mapper.map(x), OnboardedVnfPackages281Sol003Controller::makeLinks, VnfPkgInfo.class);
	}

	@Override
	public ResponseEntity<Resource> onboardedVnfPackagesVnfdIdArtifactsArtifactPathGet(final HttpServletRequest request, final String vnfdId, @Valid final String includeSignature) {
		return vnfPackageFrontController.onboardedGetArtifact(request, vnfdId, includeSignature);
	}

	@Override
	public ResponseEntity<Resource> onboardedVnfPackagesVnfdIdArtifactsGet(final String vnfdId, final String accept, final String excludeAllManoArtifacts, final String excludeAllNonManoArtifacts,
			final String includeExternalArtifacts, final String selectNonManoArtifactSets, final String includeSignatures) {
		return vnfPackageFrontController.onboardedGetVnfdByVnfdId(vnfdId, accept);
	}

	@Override
	public ResponseEntity<VnfPkgInfo> onboardedVnfPackagesVnfdIdGet(final String vnfdId, final String accept) {
		return vnfPackageFrontController.onboardedFindById(vnfdId, x -> mapper.map(x), OnboardedVnfPackages281Sol003Controller::makeLinks);
	}

	@Override
	public ResponseEntity<Resource> onboardedVnfPackagesVnfdIdManifestGet(final String vnfdId, final String accept, @Valid final String includeSignature) {
		return vnfPackageFrontController.onboardedGetManifestByVnfd(vnfdId, includeSignature);
	}

	@Override
	public ResponseEntity<Resource> onboardedVnfPackagesVnfdIdPackageContentGet(final String vnfdId, final String accept) {
		return vnfPackageFrontController.onboardedGetContentByVnfdId(vnfdId, accept, null);
	}

	@Override
	public ResponseEntity<Resource> onboardedVnfPackagesVnfdIdVnfdGet(final String vnfdId, @Valid final String accept, final String includeSignature) {
		return vnfPackageFrontController.onboardedGetVnfdByVnfdId(vnfdId, includeSignature);
	}

	private static void makeLinks(final VnfPkgInfo vnfPackage) {
		final String vnfPkgId = vnfPackage.getId();
		final VnfPkgInfoLinks links = new VnfPkgInfoLinks();

		final Link self = new Link();
		self.setHref(linkTo(methodOn(VnfPackages281Sol005Api.class).vnfPackagesVnfPkgIdGet(vnfPkgId)).withSelfRel().getHref());
		links.self(self);

		final Link vnfd = new Link();
		vnfd.setHref(linkTo(methodOn(VnfPackages281Sol005Api.class).vnfPackagesVnfPkgIdVnfdGet(vnfPkgId, null, null)).withSelfRel().getHref());
		links.setVnfd(vnfd);

		final Link packageContent = new Link();
		packageContent.setHref(linkTo(methodOn(VnfPackages281Sol005Api.class).vnfPackagesVnfPkgIdPackageContentGet(vnfPkgId, "")).withSelfRel().getHref());
		links.setPackageContent(packageContent);
		vnfPackage.setLinks(links);
	}

}
