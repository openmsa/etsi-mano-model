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
package com.ubiqube.etsi.mano.v281.nfvo.controller.nfvo.nslcm;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.nslcm.NsLcmGenericFrontController;
import com.ubiqube.etsi.mano.v281.model.em.vnflcm.CancelMode;
import com.ubiqube.etsi.mano.v281.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.v281.model.nfvo.nslcm.NsLcmOpOcc;
import com.ubiqube.etsi.mano.v281.model.nfvo.nslcm.NsLcmOpOccLinks;
import com.ubiqube.etsi.mano.v281.service.mapping.NsLcmOpOcc281Mapping;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
public class NsLcmOpOccs281Sol005Controller implements NsLcmOpOccs281Sol005Api {
	private final NsLcmGenericFrontController nsLcmGenericFrontController;
	private final NsLcmOpOcc281Mapping mapper;

	public NsLcmOpOccs281Sol005Controller(final NsLcmGenericFrontController nsLcmGenericFrontController, final NsLcmOpOcc281Mapping mapper) {
		this.nsLcmGenericFrontController = nsLcmGenericFrontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<String> nsLcmOpOccsGet(final MultiValueMap<String, String> requestParams, final String nextpageOpaqueMarker) {
		return nsLcmGenericFrontController.search(requestParams, x -> mapper.map(x), nextpageOpaqueMarker, NsLcmOpOccs281Sol005Controller::makeLinks, NsLcmOpOcc.class);
	}

	@Override
	public ResponseEntity<Void> nsLcmOpOccsNsLcmOpOccIdContinuePost(final String nsLcmOpOccId) {
		return nsLcmGenericFrontController.continu(nsLcmOpOccId);
	}

	@Override
	public ResponseEntity<NsLcmOpOcc> nsLcmOpOccsNsLcmOpOccIdGet(final String nsLcmOpOccId) {
		return nsLcmGenericFrontController.findById(nsLcmOpOccId, x -> mapper.map(x), NsLcmOpOccs281Sol005Controller::makeLinks);
	}

	@Override
	public ResponseEntity<Void> nsLcmOpOccsNsLcmOpOccIdRetryPost(final String nsLcmOpOccId) {
		return nsLcmGenericFrontController.retry(nsLcmOpOccId);
	}

	@Override
	public ResponseEntity<Void> nsLcmOpOccsNsLcmOpOccIdRollbackPost(final String nsLcmOpOccId) {
		return nsLcmGenericFrontController.rollback(nsLcmOpOccId);
	}

	@Override
	public ResponseEntity<Void> nslcmV1NsLcmOpOccsNsLcmOpOccIdCancelPost(final String nsLcmOpOccId, @Valid final CancelMode body) {
		return nsLcmGenericFrontController.cancel(nsLcmOpOccId, body.getCancelMode().toString());
	}

	@Override
	public ResponseEntity<NsLcmOpOcc> nslcmV1NsLcmOpOccsNsLcmOpOccIdFailPost(final String nsLcmOpOccId) {
		return nsLcmGenericFrontController.fail(nsLcmOpOccId, x -> mapper.map(x), NsLcmOpOccs281Sol005Controller::makeLinks);
	}

	public static void makeLinks(@NotNull final NsLcmOpOcc nsLcmOpOccs) {
		final String id = nsLcmOpOccs.getId();
		final NsLcmOpOccLinks nsLcmOpOccLinks = new NsLcmOpOccLinks();

		final Link _continue = new Link();
		_continue.setHref(linkTo(methodOn(NsLcmOpOccs281Sol005Api.class).nsLcmOpOccsNsLcmOpOccIdContinuePost(id)).withSelfRel().getHref());
		nsLcmOpOccLinks.setContinue(_continue);

		final Link nsInstance = new Link();
		nsInstance.setHref(linkTo(methodOn(NsInstances281Sol005Api.class).nsInstancesNsInstanceIdGet(nsLcmOpOccs.getNsInstanceId().toString())).withSelfRel().getHref());
		nsLcmOpOccLinks.setNsInstance(nsInstance);

		final Link retry = new Link();
		retry.setHref(linkTo(methodOn(NsLcmOpOccs281Sol005Api.class).nsLcmOpOccsNsLcmOpOccIdRetryPost(id)).withSelfRel().getHref());
		nsLcmOpOccLinks.setRetry(retry);

		final Link rollback = new Link();
		rollback.setHref(linkTo(methodOn(NsLcmOpOccs281Sol005Api.class).nsLcmOpOccsNsLcmOpOccIdRollbackPost(id)).withSelfRel().getHref());
		nsLcmOpOccLinks.setRollback(rollback);

		final Link self = new Link();
		self.setHref(linkTo(methodOn(NsLcmOpOccs281Sol005Api.class).nsLcmOpOccsNsLcmOpOccIdGet(id)).withSelfRel().getHref());
		nsLcmOpOccLinks.setSelf(self);
		nsLcmOpOccs.setLinks(nsLcmOpOccLinks);
	}

}
