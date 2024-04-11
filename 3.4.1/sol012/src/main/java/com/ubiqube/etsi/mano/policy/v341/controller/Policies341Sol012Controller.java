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
package com.ubiqube.etsi.mano.policy.v341.controller;

import static com.ubiqube.etsi.mano.Constants.getSafeUUID;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ubiqube.etsi.mano.controller.policy.PolicyFrontController;
import com.ubiqube.etsi.mano.controller.policy.PolicyPatchDto;
import com.ubiqube.etsi.mano.dao.mano.policy.Policies;
import com.ubiqube.etsi.mano.policy.v341.model.CreatePolicyRequest;
import com.ubiqube.etsi.mano.policy.v341.model.Link;
import com.ubiqube.etsi.mano.policy.v341.model.Policy;
import com.ubiqube.etsi.mano.policy.v341.model.PolicyLinks;
import com.ubiqube.etsi.mano.policy.v341.model.PolicyModifications;
import com.ubiqube.etsi.mano.policy.v341.service.mapping.CreatePolicyRequestMapping;
import com.ubiqube.etsi.mano.policy.v341.service.mapping.PolicyMapping;

import jakarta.validation.Valid;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
public class Policies341Sol012Controller implements Policies341Sol012Api {
	private final PolicyFrontController fc;
	private final PolicyMapping policyMapping;
	private final CreatePolicyRequestMapping createPolicyRequestMapping;

	public Policies341Sol012Controller(final PolicyFrontController fc, final PolicyMapping policyMapping, final CreatePolicyRequestMapping createPolicyRequestMapping) {
		this.fc = fc;
		this.policyMapping = policyMapping;
		this.createPolicyRequestMapping = createPolicyRequestMapping;
	}

	@Override
	public ResponseEntity<String> policiesGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return fc.search(requestParams, nextpageOpaqueMarker, policyMapping::map, Policies341Sol012Controller::makeLinks, Policy.class);
	}

	@Override
	public ResponseEntity<Void> policiesPolicyIdDelete(final String policyId) {
		return fc.deleteById(getSafeUUID(policyId));
	}

	@Override
	public ResponseEntity<Policy> policiesPolicyIdGet(final String policyId) {
		return fc.findById(policyId, policyMapping::map, Policies341Sol012Controller::makeLinks);
	}

	@Override
	public ResponseEntity<PolicyModifications> policiesPolicyIdPatch(final String policyId, @Valid final PolicyModifications body) {
		final PolicyPatchDto req = policyMapping.map(body);
		fc.modify(policyId, req, x -> policyMapping.map(x), Policies341Sol012Controller::makeLinks);
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<byte[]> policiesPolicyIdSelectedVersionsGet(final String policyId) {
		return fc.getContentBySelectedVersion(policyId);
	}

	@Override
	public ResponseEntity<Void> policiesPolicyIdVersionsVersionDelete(final String policyId, final String version) {
		return fc.deleteByVersion(policyId, version);
	}

	@Override
	public ResponseEntity<byte[]> policiesPolicyIdVersionsVersionGet(final String policyId, final String version) {
		return fc.getContentByPolicyIdAndVersion(policyId, version);
	}

	@Override
	public ResponseEntity<Void> policiesPolicyIdVersionsVersionPut(final String policyId, final String version, final MultipartFile file) {
		return fc.putContent(policyId, version, file);
	}

	@Override
	public ResponseEntity<Policy> policiesPost(@Valid final CreatePolicyRequest body) {
		final Policies req = createPolicyRequestMapping.map(body);
		return fc.create(req, policyMapping::map, Policies341Sol012Controller::makeLinks);
	}

	private static PolicyLinks makeLinks(final Policy pol) {
		final PolicyLinks pl = new PolicyLinks();
		final Link selected = new Link(linkTo(methodOn(Policies341Sol012Api.class).policiesPolicyIdGet(pol.getId())).withSelfRel().getHref());
		pl.setSelected(selected);

		final Link self = new Link(linkTo(methodOn(Policies341Sol012Api.class).policiesPolicyIdGet(pol.getId())).withSelfRel().getHref());
		pl.setSelf(self);

		if (null != pol.getVersions()) {
			final List<Link> versions = pol.getVersions().stream().map(x -> new Link(linkTo(methodOn(Policies341Sol012Api.class).policiesPolicyIdVersionsVersionGet(pol.getId(), x)).withSelfRel().getHref())).collect(Collectors.toList());
			pl.setVersions(versions);
		}
		return pl;
	}

}