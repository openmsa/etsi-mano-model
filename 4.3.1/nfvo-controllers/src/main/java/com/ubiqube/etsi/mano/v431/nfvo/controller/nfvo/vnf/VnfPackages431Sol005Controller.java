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
package com.ubiqube.etsi.mano.v431.nfvo.controller.nfvo.vnf;

import static com.ubiqube.etsi.mano.nfvo.fc.controller.NfvoConstants.getSafeUUID;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ubiqube.etsi.mano.controller.vnf.VnfPackageFrontController;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.v431.model.nfvo.vnf.CreateVnfPkgInfoRequest;
import com.ubiqube.etsi.mano.v431.model.nfvo.vnf.ExternalArtifactsAccessConfig;
import com.ubiqube.etsi.mano.v431.model.nfvo.vnf.UploadVnfPkgFromUriRequest;
import com.ubiqube.etsi.mano.v431.model.nfvo.vnf.VnfPkgInfo;
import com.ubiqube.etsi.mano.v431.model.nfvo.vnf.VnfPkgInfoLinks;
import com.ubiqube.etsi.mano.v431.service.mapping.VnfPkgInfo431Mapping;
import com.ubiqube.etsi.mano.v431.service.mapping.pkg.ExternalArtifactsAccessConfig431Mapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
public class VnfPackages431Sol005Controller implements VnfPackages431Sol005Api {
	private final VnfPackageFrontController frontController;
	private final VnfPkgInfo431Mapping mapper;
	private final ExternalArtifactsAccessConfig431Mapping externalMapping;

	public VnfPackages431Sol005Controller(final VnfPackageFrontController frontController, final VnfPkgInfo431Mapping mapper, final ExternalArtifactsAccessConfig431Mapping externalMapping) {
		this.frontController = frontController;
		this.mapper = mapper;
		this.externalMapping = externalMapping;
	}

	@Override
	public ResponseEntity<String> vnfPackagesGet(final MultiValueMap<String, String> requestParams, final String nextpageOpaqueMarker) {
		return frontController.search(requestParams, x -> mapper.map(x), VnfPackages431Sol005Controller::makeLinks, VnfPkgInfo.class);
	}

	@Override
	public ResponseEntity<VnfPkgInfo> vnfPackagesPost(@Valid final CreateVnfPkgInfoRequest body) {
		return frontController.create(body.getUserDefinedData(), x -> mapper.map(x), VnfPackages431Sol005Controller::makeLinks, VnfPackages431Sol005Controller::getSelfLink);
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdArtifactsArtifactPathGet(final String vnfPkgId, final HttpServletRequest requestParams, @Valid final String includeSignatures) {
		return frontController.getArtifactPath(requestParams, getSafeUUID(vnfPkgId), includeSignatures);
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdArtifactsGet(final String vnfPkgId, final String includeSignatures, final String excludeAllManoArtifacts, final String excludeAllNonManoArtifacts, final String selectNonManoArtifactSets, final String includeExternalArtifacts) {
		return frontController.searchArtifact(getSafeUUID(vnfPkgId), includeSignatures, excludeAllManoArtifacts, excludeAllNonManoArtifacts, selectNonManoArtifactSets);
	}

	@Override
	public ResponseEntity<Void> vnfPackagesVnfPkgIdDelete(final String vnfPkgId) {
		return frontController.deleteById(getSafeUUID(vnfPkgId));
	}

	@Override
	public ResponseEntity<ExternalArtifactsAccessConfig> vnfPackagesVnfPkgIdExtArtifactsAccessGet(final String vnfPkgId) {
		return frontController.getExternalArtifacts(getSafeUUID(vnfPkgId));
	}

	@Override
	public ResponseEntity<ExternalArtifactsAccessConfig> vnfPackagesVnfPkgIdExtArtifactsAccessPut(@Valid final ExternalArtifactsAccessConfig body, final String vnfPkgId) {
		final com.ubiqube.etsi.mano.dao.mano.pkg.ExternalArtifactsAccessConfig req = externalMapping.map(body);
		return frontController.putExternalArtifactAccessConfig(req, getSafeUUID(vnfPkgId), externalMapping::map);
	}

	@Override
	public ResponseEntity<VnfPkgInfo> vnfPackagesVnfPkgIdGet(final String vnfPkgId) {
		return frontController.findById(getSafeUUID(vnfPkgId), x -> mapper.map(x), VnfPackages431Sol005Controller::makeLinks);
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdManifestGet(final String vnfPkgId, @Valid final String includeSignatures) {
		return frontController.getManifest(getSafeUUID(vnfPkgId), includeSignatures);
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdPackageContentGet(final String vnfPkgId) {
		return frontController.getContent(getSafeUUID(vnfPkgId));
	}

	@Override
	public ResponseEntity<Void> vnfPackagesVnfPkgIdPackageContentPut(final MultipartFile file, final String accept, final String vnfPkgId) {
		return frontController.putContent(getSafeUUID(vnfPkgId), accept, file);
	}

	@Override
	public ResponseEntity<Void> vnfPackagesVnfPkgIdPackageContentUploadFromUriPost(final UploadVnfPkgFromUriRequest body, final String vnfPkgId, final String accept) {
		return frontController.uploadFromUri(mapper.map(body), getSafeUUID(vnfPkgId), accept);
	}

	@Override
	public ResponseEntity<VnfPkgInfo> vnfPackagesVnfPkgIdPatch(final String body, final String vnfPkgId, final String ifMatch) {
		return frontController.modify(body, getSafeUUID(vnfPkgId), ifMatch, x -> mapper.map(x), VnfPackages431Sol005Controller::makeLinks);
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdVnfdGet(final String vnfPkgId, final String accept, @Valid final String includeSignatures) {
		return frontController.getVfnd(getSafeUUID(vnfPkgId), null, includeSignatures);
	}

	private static void makeLinks(final VnfPkgInfo vnfPackage) {
		final String vnfPkgId = vnfPackage.getId();
		final VnfPkgInfoLinks links = new VnfPkgInfoLinks();

		final Link self = new Link();
		self.setHref(linkTo(methodOn(VnfPackages431Sol005Api.class).vnfPackagesVnfPkgIdGet(vnfPkgId)).withSelfRel().getHref());
		links.self(self);

		final Link vnfd = new Link();
		vnfd.setHref(linkTo(methodOn(VnfPackages431Sol005Api.class).vnfPackagesVnfPkgIdVnfdGet(vnfPkgId, null, null)).withSelfRel().getHref());
		links.setVnfd(vnfd);

		final Link packageContent = new Link();
		packageContent.setHref(linkTo(methodOn(VnfPackages431Sol005Api.class).vnfPackagesVnfPkgIdPackageContentGet(vnfPkgId)).withSelfRel().getHref());
		links.setPackageContent(packageContent);
		vnfPackage.setLinks(links);
	}

	public static String getSelfLink(final VnfPkgInfo vnfPkgInfo) {
		return linkTo(methodOn(VnfPackages431Sol005Api.class).vnfPackagesVnfPkgIdGet(vnfPkgInfo.getId())).withSelfRel().getHref();
	}

}
