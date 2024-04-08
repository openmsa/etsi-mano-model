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
package com.ubiqube.etsi.mano.nfvo.v351.controller.nslcm;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.nslcm.NsInstanceGenericFrontController;
import com.ubiqube.etsi.mano.dao.mano.dto.CreateNsInstance;
import com.ubiqube.etsi.mano.dao.mano.dto.nsi.NsInstantiate;
import com.ubiqube.etsi.mano.dao.mano.nsd.upd.UpdateRequest;
import com.ubiqube.etsi.mano.dao.mano.nslcm.scale.NsHeal;
import com.ubiqube.etsi.mano.dao.mano.nslcm.scale.NsScale;
import com.ubiqube.etsi.mano.dao.mano.v2.nfvo.NsBlueprint;
import com.ubiqube.etsi.mano.em.v351.model.lcmcoord.Link;
import com.ubiqube.etsi.mano.nfvo.v351.model.nslcm.CreateNsRequest;
import com.ubiqube.etsi.mano.nfvo.v351.model.nslcm.HealNsRequest;
import com.ubiqube.etsi.mano.nfvo.v351.model.nslcm.InstantiateNsRequest;
import com.ubiqube.etsi.mano.nfvo.v351.model.nslcm.NsInstance;
import com.ubiqube.etsi.mano.nfvo.v351.model.nslcm.NsInstanceLinks;
import com.ubiqube.etsi.mano.nfvo.v351.model.nslcm.ScaleNsRequest;
import com.ubiqube.etsi.mano.nfvo.v351.model.nslcm.TerminateNsRequest;
import com.ubiqube.etsi.mano.nfvo.v351.model.nslcm.UpdateNsRequest;

import jakarta.annotation.Nonnull;
import jakarta.validation.Valid;
import ma.glasnost.orika.MapperFacade;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
public class NsInstances351Sol005Controller implements NsInstances351Sol005Api {
	private final NsInstanceGenericFrontController nsInstanceGenericFrontController;
	private final MapperFacade mapper;

	public NsInstances351Sol005Controller(final NsInstanceGenericFrontController nsInstanceGenericFrontController, final MapperFacade mapper) {
		this.nsInstanceGenericFrontController = nsInstanceGenericFrontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<String> nsInstancesGet(final MultiValueMap<String, String> requestParams, final String nextpageOpaqueMarker) {
		return nsInstanceGenericFrontController.search(requestParams, NsInstance.class, nextpageOpaqueMarker, NsInstances351Sol005Controller::makeLinks);
	}

	@Override
	public ResponseEntity<Void> nsInstancesNsInstanceIdDelete(final String nsInstanceId) {
		return nsInstanceGenericFrontController.delete(nsInstanceId);
	}

	@Override
	public ResponseEntity<NsInstance> nsInstancesNsInstanceIdGet(final String nsInstanceId) {
		return nsInstanceGenericFrontController.findById(nsInstanceId, x -> mapper.map(x, NsInstance.class), NsInstances351Sol005Controller::makeLinks);
	}

	@Override
	public ResponseEntity<Void> nsInstancesNsInstanceIdHealPost(final String nsInstanceId, @Valid final HealNsRequest body) {
		final NsHeal req = mapper.map(body, NsHeal.class);
		return nsInstanceGenericFrontController.heal(nsInstanceId, req, NsInstances351Sol005Controller::getNsbLink);
	}

	@Override
	public ResponseEntity<Void> nsInstancesNsInstanceIdInstantiatePost(final String nsInstanceId, @Valid final InstantiateNsRequest body) {
		final NsInstantiate req = mapper.map(body, NsInstantiate.class);
		return nsInstanceGenericFrontController.instantiate(nsInstanceId, req, NsInstances351Sol005Controller::getNsbLink);
	}

	@Override
	public ResponseEntity<Void> nsInstancesNsInstanceIdScalePost(final String nsInstanceId, @Valid final ScaleNsRequest body) {
		final NsScale req = mapper.map(body, NsScale.class);
		return nsInstanceGenericFrontController.scale(nsInstanceId, req, NsInstances351Sol005Controller::getNsbLink);
	}

	@Override
	public ResponseEntity<Void> nsInstancesNsInstanceIdTerminatePost(final String nsInstanceId, @Valid final TerminateNsRequest body) {
		return nsInstanceGenericFrontController.terminate(nsInstanceId, body, NsInstances351Sol005Controller::getNsbLink);
	}

	@Override
	public ResponseEntity<Void> nsInstancesNsInstanceIdUpdatePost(final String nsInstanceId, @Valid final UpdateNsRequest body) {
		final UpdateRequest req = mapper.map(body, UpdateRequest.class);
		return nsInstanceGenericFrontController.update(nsInstanceId, req, NsInstances351Sol005Controller::getNsbLink);
	}

	@Override
	public ResponseEntity<NsInstance> nsInstancesPost(@Valid final CreateNsRequest body) {
		final CreateNsInstance req = mapper.map(body, CreateNsInstance.class);
		return nsInstanceGenericFrontController.create(req, x -> mapper.map(x, NsInstance.class), NsInstances351Sol005Controller::makeLinks, NsInstances351Sol005Controller::getLink);
	}

	private static String getLink(final NsInstance nsBlueprint) {
		return linkTo(methodOn(NsInstances351Sol005Api.class).nsInstancesNsInstanceIdHealPost(nsBlueprint.getId(), null)).withSelfRel().getHref();
	}

	private static String getNsbLink(final NsBlueprint nsBlueprint) {
		return linkTo(methodOn(NsInstances351Sol005Api.class).nsInstancesNsInstanceIdHealPost(nsBlueprint.getId().toString(), null)).withSelfRel().getHref();
	}

	private static void makeLinks(@Nonnull final NsInstance nsdInfo) {
		final String id = nsdInfo.getId();
		final NsInstanceLinks nsInstanceLinks = new NsInstanceLinks();
		final Link heal = new Link();
		heal.setHref(linkTo(methodOn(NsInstances351Sol005Api.class).nsInstancesNsInstanceIdHealPost(id, null)).withSelfRel().getHref());
		nsInstanceLinks.setHeal(heal);

		final Link instantiate = new Link();
		instantiate.setHref(linkTo(methodOn(NsInstances351Sol005Api.class).nsInstancesNsInstanceIdInstantiatePost(id, null)).withSelfRel().getHref());
		nsInstanceLinks.setInstantiate(instantiate);
		// nsInstanceLinks.setNestedNsInstances(nestedNsInstances);
		final Link scale = new Link();
		scale.setHref(linkTo(methodOn(NsInstances351Sol005Api.class).nsInstancesNsInstanceIdScalePost(id, null)).withSelfRel().getHref());
		nsInstanceLinks.setScale(scale);

		final Link self = new Link();
		self.setHref(linkTo(methodOn(NsInstances351Sol005Api.class).nsInstancesNsInstanceIdGet(id)).withSelfRel().getHref());
		nsInstanceLinks.setSelf(self);

		final Link terminate = new Link();
		terminate.setHref(linkTo(methodOn(NsInstances351Sol005Api.class).nsInstancesNsInstanceIdTerminatePost(id, null)).withSelfRel().getHref());
		nsInstanceLinks.setTerminate(terminate);

		final Link update = new Link();
		update.setHref(linkTo(methodOn(NsInstances351Sol005Api.class).nsInstancesNsInstanceIdUpdatePost(id, null)).withSelfRel().getHref());
		nsInstanceLinks.setUpdate(update);
		nsdInfo.setLinks(nsInstanceLinks);
	}

}
