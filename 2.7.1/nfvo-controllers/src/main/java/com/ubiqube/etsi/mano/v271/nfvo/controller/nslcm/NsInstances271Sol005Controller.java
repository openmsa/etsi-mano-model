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
package com.ubiqube.etsi.mano.v271.nfvo.controller.nslcm;

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
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.v271.model.sol005.nslcm.CreateNsRequest;
import com.ubiqube.etsi.mano.v271.model.sol005.nslcm.HealNsRequest;
import com.ubiqube.etsi.mano.v271.model.sol005.nslcm.InstantiateNsRequest;
import com.ubiqube.etsi.mano.v271.model.sol005.nslcm.NsInstance;
import com.ubiqube.etsi.mano.v271.model.sol005.nslcm.NsInstanceLinks;
import com.ubiqube.etsi.mano.v271.model.sol005.nslcm.ScaleNsRequest;
import com.ubiqube.etsi.mano.v271.model.sol005.nslcm.TerminateNsRequest;
import com.ubiqube.etsi.mano.v271.model.sol005.nslcm.UpdateNsRequest;
import com.ubiqube.etsi.mano.v271.service.mapping.NsInstance271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.nslcm.NsRequest271Mapping;

import jakarta.annotation.Nonnull;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
public class NsInstances271Sol005Controller implements NsInstances271Sol005Api {
	private final NsInstanceGenericFrontController frontController;
	private final NsInstance271Mapping mapper;
	private final NsRequest271Mapping requestMapper;

	public NsInstances271Sol005Controller(final NsInstanceGenericFrontController frontController, final NsInstance271Mapping mapper, final NsRequest271Mapping requestMapper) {
		this.frontController = frontController;
		this.mapper = mapper;
		this.requestMapper = requestMapper;
	}

	/**
	 * Query multiple NS instances.
	 *
	 * Query NS Instances. The GET method queries information about multiple NS
	 * instances. This method shall support the URI query parameters, request and
	 * response data structures, and response codes, as specified in the Tables
	 * 6.4.2.3.2-1 and 6.4.2.3.2-2.
	 *
	 */
	@Override
	public ResponseEntity<String> nsInstancesGet(final MultiValueMap<String, String> requestParams) {
		return frontController.search(requestParams, x -> mapper.map(x), null, NsInstances271Sol005Controller::makeLinks, NsInstance.class);
	}

	/**
	 * Delete NS instance resource.
	 *
	 * Delete NS Identifier This method deletes an individual NS instance resource.
	 *
	 */
	@Override
	public ResponseEntity<Void> nsInstancesNsInstanceIdDelete(final String nsInstanceId) {
		return frontController.delete(nsInstanceId);
	}

	/**
	 * Read an individual NS instance resource.
	 *
	 * The GET method retrieves information about a NS instance by reading an
	 * individual NS instance resource.
	 *
	 */
	@Override
	public ResponseEntity<NsInstance> nsInstancesNsInstanceIdGet(final String nsInstanceId) {
		return frontController.findById(nsInstanceId, x -> mapper.map(x), NsInstances271Sol005Controller::makeLinks);
	}

	/**
	 * Heal a NS instance.
	 *
	 * The POST method requests to heal a NS instance resource. This method shall
	 * follow the provisions specified in the Tables 6.4.7.3.1-1 and 6.4.7.3.1-2 for
	 * URI query parameters, request and response data structures, and response
	 * codes.
	 *
	 */
	@Override
	public ResponseEntity<NsInstance> nsInstancesNsInstanceIdHealPost(final String nsInstanceId, final HealNsRequest body) {
		final NsHeal req = requestMapper.map(body);
		return frontController.heal(nsInstanceId, req, NsInstances271Sol005Controller::getSelfLink);
	}

	/**
	 * Instantiate a NS.
	 *
	 * The POST method requests to instantiate a NS instance resource.
	 *
	 */
	@Override
	public ResponseEntity<NsInstance> nsInstancesNsInstanceIdInstantiatePost(final String nsInstanceId, final InstantiateNsRequest body) {
		final NsInstantiate req = requestMapper.map(body);
		return frontController.instantiate(nsInstanceId, req, NsInstances271Sol005Controller::getSelfLink);
	}

	/**
	 * Scale a NS instance.
	 *
	 * The POST method requests to scale a NS instance resource.
	 *
	 */
	@Override
	public ResponseEntity<NsInstance> nsInstancesNsInstanceIdScalePost(final String nsInstanceId, final ScaleNsRequest body) {
		final NsScale req = requestMapper.map(body);
		return frontController.scale(nsInstanceId, req, NsInstances271Sol005Controller::getSelfLink);
	}

	/**
	 * Terminate a NS instance.
	 *
	 * Terminate NS task. The POST method terminates a NS instance. This method can
	 * only be used with a NS instance in the INSTANTIATED state. Terminating a NS
	 * instance does not delete the NS instance identifier, but rather transitions
	 * the NS into the NOT_INSTANTIATED state. This method shall support the URI
	 * query parameters, request and response data structures, and response codes,
	 * as specified in the Tables 6.4.8.3.1-1 and 6.8.8.3.1-2.
	 *
	 */
	@Override
	public ResponseEntity<NsInstance> nsInstancesNsInstanceIdTerminatePost(final String nsInstanceId, final TerminateNsRequest body) {
		return frontController.terminate(nsInstanceId, body, NsInstances271Sol005Controller::getSelfLink);
	}

	/**
	 * Updates a NS instance.
	 *
	 * Scale NS instance. The POST method requests to scale a NS instance resource.
	 *
	 */
	@Override
	public ResponseEntity<NsInstance> nsInstancesNsInstanceIdUpdatePost(final String nsInstanceId, final UpdateNsRequest body) {
		final UpdateRequest req = requestMapper.map(body);
		return frontController.update(nsInstanceId, req, NsInstances271Sol005Controller::getSelfLink);
	}

	/**
	 * Create a NS instance resource.
	 *
	 * The POST method creates a new NS instance resource.
	 *
	 */
	@Override
	public ResponseEntity<NsInstance> nsInstancesPost(final CreateNsRequest request) {
		final CreateNsInstance req = requestMapper.map(request);
		return frontController.create(req, x -> mapper.map(x), NsInstances271Sol005Controller::makeLinks, NsInstances271Sol005Controller::getSelfLink);
	}

	private static void makeLinks(@Nonnull final NsInstance nsdInfo) {
		final String id = nsdInfo.getId().toString();
		final NsInstanceLinks nsInstanceLinks = new NsInstanceLinks();
		final Link heal = new Link();
		heal.setHref(linkTo(methodOn(NsInstances271Sol005Api.class).nsInstancesNsInstanceIdHealPost(id, null)).withSelfRel().getHref());
		nsInstanceLinks.setHeal(heal);

		final Link instantiate = new Link();
		instantiate.setHref(linkTo(methodOn(NsInstances271Sol005Api.class).nsInstancesNsInstanceIdInstantiatePost(id, null)).withSelfRel().getHref());
		nsInstanceLinks.setInstantiate(instantiate);
		// nsInstanceLinks.setNestedNsInstances(nestedNsInstances);
		final Link scale = new Link();
		scale.setHref(linkTo(methodOn(NsInstances271Sol005Api.class).nsInstancesNsInstanceIdScalePost(id, null)).withSelfRel().getHref());
		nsInstanceLinks.setScale(scale);

		final Link self = new Link();
		self.setHref(linkTo(methodOn(NsInstances271Sol005Api.class).nsInstancesNsInstanceIdGet(id)).withSelfRel().getHref());
		nsInstanceLinks.setSelf(self);

		final Link terminate = new Link();
		terminate.setHref(linkTo(methodOn(NsInstances271Sol005Api.class).nsInstancesNsInstanceIdTerminatePost(id, null)).withSelfRel().getHref());
		nsInstanceLinks.setTerminate(terminate);

		final Link update = new Link();
		update.setHref(linkTo(methodOn(NsInstances271Sol005Api.class).nsInstancesNsInstanceIdUpdatePost(id, null)).withSelfRel().getHref());
		nsInstanceLinks.setUpdate(update);
		nsdInfo.setLinks(nsInstanceLinks);
	}

	private static String getSelfLink(final NsBlueprint nsInstance) {
		return linkTo(methodOn(NsInstances271Sol005Api.class).nsInstancesNsInstanceIdGet(nsInstance.getId().toString())).withSelfRel().getHref();
	}

	private static String getSelfLink(final NsInstance nsdInfo) {
		return linkTo(methodOn(NsInstances271Sol005Api.class).nsInstancesNsInstanceIdHealPost(nsdInfo.getId().toString(), null)).withSelfRel().getHref();
	}

}
