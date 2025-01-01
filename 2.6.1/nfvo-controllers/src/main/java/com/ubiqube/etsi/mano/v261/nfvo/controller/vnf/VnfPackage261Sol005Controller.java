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

import static com.ubiqube.etsi.mano.Constants.getSafeUUID;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfPkgInfo;
import com.ubiqube.etsi.mano.common.v261.services.Linkable;
import com.ubiqube.etsi.mano.controller.vnf.VnfPackageFrontController;
import com.ubiqube.etsi.mano.dao.mano.pkg.UploadUriParameters;
import com.ubiqube.etsi.mano.v261.model.nfvo.vnf.CreateVnfPkgInfoRequest;
import com.ubiqube.etsi.mano.v261.model.nfvo.vnf.UploadVnfPkgFromUriRequest;
import com.ubiqube.etsi.mano.v261.nfvo.service.Sol005Linkable;
import com.ubiqube.etsi.mano.v261.service.mapping.VnfPkgInfo261Mapping;

import jakarta.annotation.Nonnull;
import jakarta.servlet.http.HttpServletRequest;

/**
 * SOL005 - VNF Package Management Interface
 *
 * <p>
 * SOL005 - VNF Package Management Interface IMPORTANT: Please note that this
 * file might be not aligned to the current version of the ETSI Group
 * Specification it refers to and has not been approved by the ETSI NFV ISG. In
 * case of discrepancies the published ETSI Group Specification takes
 * precedence. Please report bugs to
 * https://forge.etsi.org/bugzilla/buglist.cgi?component=Nfv-Openapis
 *
 * NOTE: Normaly we should receive object in methods but Genson seems to be on
 * the classpath and is unable to unserialize objects. So we use a string2Object
 * to do So. Note same problems occurred when returning object some times genson
 * could be here and not Jackson, in this case you can use object2String.
 *
 */
@RestController
public class VnfPackage261Sol005Controller implements VnfPackage261Sol005Api {
	private final VnfPackageFrontController vnfPackageFrontController;
	@Nonnull
	private final Linkable links = new Sol005Linkable();
	private final VnfPkgInfo261Mapping mapper;

	public VnfPackage261Sol005Controller(final VnfPackageFrontController vnfPackageFrontController, final VnfPkgInfo261Mapping mapper) {
		this.vnfPackageFrontController = vnfPackageFrontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<String> vnfPackagesGet(final MultiValueMap<String, String> requestParams) {
		return vnfPackageFrontController.search(requestParams, x -> mapper.map(x), links::makeLinks, VnfPkgInfo.class);
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdArtifactsArtifactPathGet(final String vnfdId, final HttpServletRequest request, final String accept) {
		return vnfPackageFrontController.getArtifactPath(request, getSafeUUID(vnfdId), null);
	}

	@Override
	public ResponseEntity<VnfPkgInfo> vnfPackagesVnfPkgIdGet(final String vnfPkgId, final String accept) {
		return vnfPackageFrontController.findById(getSafeUUID(vnfPkgId), x -> mapper.map(x), links::makeLinks);
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdPackageContentGet(final String vnfPkgId, final String accept) {
		return vnfPackageFrontController.getContent(getSafeUUID(vnfPkgId));
	}

	@Override
	public ResponseEntity<Resource> vnfPackagesVnfPkgIdVnfdGet(final String vnfPkgId, final String accept) {
		return vnfPackageFrontController.getVfnd(getSafeUUID(vnfPkgId), accept, null);
	}

	/**
	 * Create a new individual VNF package resource. 9.5.2.4
	 *
	 * The POST method creates a new individual VNF package resource.
	 *
	 */
	@Override
	public ResponseEntity<VnfPkgInfo> vnfPackagesPost(final String accept, final String contentType, final CreateVnfPkgInfoRequest vnfPackagePostQuery) {
		return vnfPackageFrontController.create(vnfPackagePostQuery.getUserDefinedData(), x -> mapper.map(x), links::makeLinks, links::getSelfLink);
	}

	/**
	 * Delete an individual VNF package.
	 *
	 * The DELETE method deletes an individual VNF Package resource.
	 *
	 */
	@Override
	public ResponseEntity<Void> vnfPackagesVnfPkgIdDelete(final String vnfPkgId) {
		return vnfPackageFrontController.deleteById(getSafeUUID(vnfPkgId));
	}

	/**
	 * Update information about an individual VNF package.
	 *
	 * \&quot;The PATCH method updates the information of a VNF package.\&quot;
	 * \&quot;This method shall follow the provisions specified in the Tables
	 * 9.4.3.3.4-1 and 9.4.3.3.4-2 for URI query parameters, request and response
	 * data structures, and response codes.\&quot;
	 *
	 */
	@Override
	public ResponseEntity<VnfPkgInfo> vnfPackagesVnfPkgIdPatch(final String vnfPkgId, final String body, final String ifMatch, final String contentType) {
		return vnfPackageFrontController.modify(body, getSafeUUID(vnfPkgId), ifMatch, x -> mapper.map(x), links::makeLinks);
	}

	/**
	 * Upload a VNF package by providing the content of the VNF package.
	 *
	 * The PUT method uploads the content of a VNF package. This method shall follow
	 * the provisions specified in the Tables 9.4.5.3.3-1 and 9.4.5.3.3-2 for URI
	 * query parameters, request and response data structures, and response codes.
	 *
	 */
	@Override
	public ResponseEntity<Void> vnfPackagesVnfPkgIdPackageContentPut(final String vnfPkgId, final String accept, final MultipartFile file) {
		return vnfPackageFrontController.putContent(getSafeUUID(vnfPkgId), accept, file);
	}

	/**
	 * Upload a VNF package by providing the address information of the VNF package.
	 *
	 * The POST method provides the information for the NFVO to get the content of a
	 * VNF package. This method shall follow the provisions specified in the Tables
	 * 9.4.6.3.1-1 and 9.4.6.3.1-2 for URI query parameters, request and response
	 * data structures, and response codes.
	 *
	 */
	@Override
	public ResponseEntity<Void> vnfPackagesVnfPkgIdPackageContentUploadFromUriPost(final String accept, final String contentType, final String vnfPkgId, final UploadVnfPkgFromUriRequest contentUploadFromUriPostRequest) {
		final UploadUriParameters req = mapper.map(contentUploadFromUriPostRequest);
		return vnfPackageFrontController.uploadFromUri(req, getSafeUUID(vnfPkgId), contentType);
	}

}
