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
package com.ubiqube.etsi.mano.v281.nfvo.controller.nfvo.nsd;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import org.springframework.context.annotation.Conditional;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ubiqube.etsi.mano.SingleControllerCondition;
import com.ubiqube.etsi.mano.controller.nsd.NsDescriptorGenericFrontController;
import com.ubiqube.etsi.mano.v281.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.v281.model.nfvo.nsd.CreateNsdInfoRequest;
import com.ubiqube.etsi.mano.v281.model.nfvo.nsd.NsdInfo;
import com.ubiqube.etsi.mano.v281.model.nfvo.nsd.NsdInfoLinks;
import com.ubiqube.etsi.mano.v281.model.nfvo.nsd.NsdInfoModifications;
import com.ubiqube.etsi.mano.v281.service.mapping.Nsd281Mapping;

import jakarta.annotation.Nonnull;
import jakarta.validation.Valid;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
@Conditional(SingleControllerCondition.class)
public class NsDescriptors281Sol005Controller implements NsDescriptors281Sol005Api {
	private final NsDescriptorGenericFrontController nsDescriptorGenericFrontController;
	private final Nsd281Mapping mapper;

	public NsDescriptors281Sol005Controller(final NsDescriptorGenericFrontController nsDescriptorGenericFrontController, final Nsd281Mapping mapper) {
		this.nsDescriptorGenericFrontController = nsDescriptorGenericFrontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<String> nsDescriptorsGet(final MultiValueMap<String, String> requestParams, final String nextpageOpaqueMarker) {
		return nsDescriptorGenericFrontController.search(requestParams, x -> mapper.map(x), NsDescriptors281Sol005Controller::makeLinks, NsdInfo.class);
	}

	@Override
	public ResponseEntity<Void> nsDescriptorsNsdInfoIdDelete(final String nsdInfoId) {
		return nsDescriptorGenericFrontController.delete(nsdInfoId);
	}

	@Override
	public ResponseEntity<NsdInfo> nsDescriptorsNsdInfoIdGet(final String nsdInfoId) {
		return nsDescriptorGenericFrontController.finsById(nsdInfoId, x -> mapper.map(x), NsDescriptors281Sol005Controller::makeLinks);
	}

	@Override
	public ResponseEntity<Resource> nsDescriptorsNsdInfoIdNsdContentGet(final String nsdInfoId, final String accept, final String range) {
		return nsDescriptorGenericFrontController.getNsdContent(nsdInfoId, accept);
	}

	@Override
	public ResponseEntity<Void> nsDescriptorsNsdInfoIdNsdContentPut(final String nsdInfoId, final String accept, final MultipartFile file) {
		return nsDescriptorGenericFrontController.putNsdContent(nsdInfoId, accept, file);
	}

	@Override
	public ResponseEntity<NsdInfoModifications> nsDescriptorsNsdInfoIdPatch(final String nsdInfoId, @Valid final String body, final String ifMatch) {
		nsDescriptorGenericFrontController.modify(nsdInfoId, body, ifMatch, x -> mapper.map(x), NsDescriptors281Sol005Controller::makeLinks);
		final NsdInfoModifications modif = new NsdInfoModifications();
		return ResponseEntity.ok(modif);
	}

	@Override
	public ResponseEntity<NsdInfo> nsDescriptorsPost(@Valid final CreateNsdInfoRequest body) {
		return nsDescriptorGenericFrontController.create("", body.getUserDefinedData(), x -> mapper.map(x), NsDescriptors281Sol005Controller::makeLinks, NsDescriptors281Sol005Controller::makeSelfLink);
	}

	@Override
	public ResponseEntity<Resource> nsDescriptorsNsdInfoIdManifestGet(final String nsdInfoId, @Valid final String includeSignatures) {
		return nsDescriptorGenericFrontController.getManifest(nsdInfoId, includeSignatures);
	}

	@Override
	public ResponseEntity<Resource> nsDescriptorsNsdInfoIdNsdGet(final String nsdInfoId, @Valid final String includeSignatures) {
		return nsDescriptorGenericFrontController.getNsd(nsdInfoId, includeSignatures);
	}

	private static void makeLinks(@Nonnull final NsdInfo nsdInfo) {
		final String id = nsdInfo.getId().toString();
		final NsdInfoLinks ret = new NsdInfoLinks();
		final Link nsdSelf = new Link();
		final String _self = makeSelfLink(nsdInfo);
		nsdSelf.setHref(_self);
		ret.setSelf(nsdSelf);

		final String _nsdContent = linkTo(methodOn(NsDescriptors281Sol005Api.class).nsDescriptorsNsdInfoIdNsdContentGet(id, "", "")).withSelfRel().getHref();
		final Link nsdContent = new Link();
		nsdContent.setHref(_nsdContent);
		ret.setNsdContent(nsdContent);

		nsdInfo.setLinks(ret);
	}

	private static String makeSelfLink(final NsdInfo nsdInfo) {
		return linkTo(methodOn(NsDescriptors281Sol005Api.class).nsDescriptorsNsdInfoIdGet(nsdInfo.getId().toString())).withSelfRel().getHref();
	}

}
