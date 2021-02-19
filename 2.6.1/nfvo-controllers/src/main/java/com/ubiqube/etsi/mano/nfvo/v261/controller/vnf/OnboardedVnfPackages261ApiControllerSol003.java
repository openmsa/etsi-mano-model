/**
 *     Copyright (C) 2019-2020 Ubiqube.
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
package com.ubiqube.etsi.mano.nfvo.v261.controller.vnf;

import static com.ubiqube.etsi.mano.Constants.VNF_SEARCH_DEFAULT_EXCLUDE_FIELDS;
import static com.ubiqube.etsi.mano.Constants.VNF_SEARCH_MANDATORY_FIELDS;
import static com.ubiqube.etsi.mano.Constants.getSingleField;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;

import com.ubiqube.etsi.mano.common.v261.controller.vnf.Linkable;
import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfPkgInfo;
import com.ubiqube.etsi.mano.controller.vnf.VnfPackageManagement;
import com.ubiqube.etsi.mano.dao.mano.VnfPackage;
import com.ubiqube.etsi.mano.service.ManoSearchResponseService;
import com.ubiqube.etsi.mano.utils.SpringUtils;

/**
 *
 * @author Olivier Vignaud <ovi@ubiqube.com>
 *
 */
@Controller
public class OnboardedVnfPackages261ApiControllerSol003 implements OnboardedVnfPackages261ApiSol003 {
	private final Linkable links = new Sol003Linkable();
	private final VnfPackageManagement vnfManagement;
	private final ManoSearchResponseService searchService;

	public OnboardedVnfPackages261ApiControllerSol003(final VnfPackageManagement _vnfManagement, final ManoSearchResponseService _searchService) {
		vnfManagement = _vnfManagement;
		searchService = _searchService;
	}

	@Override
	public final ResponseEntity<String> onboardedVnfPackagesGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		String filter = Optional.ofNullable(getSingleField(requestParams, "filter"))
				.filter(x -> !x.isEmpty())
				.map(x -> x + "&")
				.orElse("");
		filter += "onboardingState.eq=ONBOARDED";
		final List<VnfPackage> result = vnfManagement.vnfPackagesGet(filter);
		requestParams.containsKey("exclude_default");
		return searchService.search(requestParams, VnfPkgInfo.class, VNF_SEARCH_DEFAULT_EXCLUDE_FIELDS, VNF_SEARCH_MANDATORY_FIELDS, result, VnfPkgInfo.class, links::makeLinks);
	}

	@Override
	public final ResponseEntity<List<ResourceRegion>> onboardedVnfPackagesVnfdIdArtifactsArtifactPathGet(final HttpServletRequest request, final String vnfdId, final String range, @Valid final String includeSignatures) {
		final String artifactPath = SpringUtils.extractParams(request);
		return vnfManagement.vnfPackagesVnfdIdArtifactsArtifactPathGet(UUID.fromString(vnfdId), artifactPath, range);
	}

	@Override
	public final ResponseEntity<VnfPkgInfo> onboardedVnfPackagesVnfdIdGet(final String vnfdId) {
		final VnfPkgInfo vnfPkgInfo = vnfManagement.onboardedVnfPackagesVnfdIdGet(UUID.fromString(vnfdId), VnfPkgInfo.class);
		links.makeLinks(vnfPkgInfo);
		return ResponseEntity.ok(vnfPkgInfo);
	}

	@Override
	public final ResponseEntity<List<ResourceRegion>> onboardedVnfPackagesVnfdIdPackageContentGet(final String vnfdId, final String range) {
		return vnfManagement.onboardedVnfPackagesVnfdIdPackageContentGet(UUID.fromString(vnfdId), range);
	}

	@Override
	public final ResponseEntity<Resource> onboardedVnfPackagesVnfdIdVnfdGet(final String vnfdId, @Valid final String includeSignatures) {
		return vnfManagement.onboardedVnfPackagesVnfdIdVnfdGet(UUID.fromString(vnfdId), includeSignatures);
	}

}