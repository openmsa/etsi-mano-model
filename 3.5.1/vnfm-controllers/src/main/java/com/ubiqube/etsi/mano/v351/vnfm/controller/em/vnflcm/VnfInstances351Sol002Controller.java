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
package com.ubiqube.etsi.mano.v351.vnfm.controller.em.vnflcm;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;
import static com.ubiqube.etsi.mano.vnfm.fc.Constants.getSafeUUID;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.dao.mano.CancelModeTypeEnum;
import com.ubiqube.etsi.mano.dao.mano.v2.VnfBlueprint;
import com.ubiqube.etsi.mano.dao.mano.vnfi.ChangeExtVnfConnRequest;
import com.ubiqube.etsi.mano.model.VnfInstantiate;
import com.ubiqube.etsi.mano.model.VnfOperateRequest;
import com.ubiqube.etsi.mano.model.VnfScaleRequest;
import com.ubiqube.etsi.mano.model.VnfScaleToLevelRequest;
import com.ubiqube.etsi.mano.v351.model.em.lcmcoord.Link;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.ChangeCurrentVnfPkgRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.ChangeExtVnfConnectivityRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.ChangeVnfFlavourRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.CreateVnfRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.CreateVnfSnapshotRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.HealVnfRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.InstantiateVnfRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.OperateVnfRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.RevertToVnfSnapshotRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.ScaleVnfRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.ScaleVnfToLevelRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.TerminateVnfRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.VnfInstance;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.VnfInstanceLinks;
import com.ubiqube.etsi.mano.v351.service.mapping.VnfInstance351Mapping;
import com.ubiqube.etsi.mano.v351.service.mapping.vnflcm.VnfInstanceRequest351Mapping;
import com.ubiqube.etsi.mano.v351.service.mapping.vnflcm.VnfInstantiate351Mapping;
import com.ubiqube.etsi.mano.v351.vnfm.controller.vnfm.vnflcm.VnfInstances351Sol003Api;
import com.ubiqube.etsi.mano.v351.vnfm.controller.vnfm.vnflcm.VnfLcmOpOccs351Sol003Api;
import com.ubiqube.etsi.mano.vnfm.fc.vnflcm.VnfInstanceGenericFrontController;

import jakarta.validation.Valid;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
public class VnfInstances351Sol002Controller implements VnfInstances351Sol002Api {
	private final VnfInstanceGenericFrontController frontController;
	private final VnfInstance351Mapping mapper;
	private final VnfInstantiate351Mapping vnfInstantiate361Mapping;
	private final VnfInstanceRequest351Mapping vnfInstanceRequest361Mapping;

	public VnfInstances351Sol002Controller(final VnfInstanceGenericFrontController frontController, final VnfInstance351Mapping mapper, final VnfInstantiate351Mapping vnfInstantiate361Mapping, final VnfInstanceRequest351Mapping vnfInstanceRequest361Mapping) {
		this.frontController = frontController;
		this.mapper = mapper;
		this.vnfInstantiate361Mapping = vnfInstantiate361Mapping;
		this.vnfInstanceRequest361Mapping = vnfInstanceRequest361Mapping;
	}

	@Override
	public ResponseEntity<String> vnfInstancesGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return frontController.search(requestParams, x -> mapper.map(x), nextpageOpaqueMarker, VnfInstances351Sol002Controller::makeLinks, VnfInstance.class);
	}

	@Override
	public ResponseEntity<VnfInstance> vnfInstancesPost(@Valid final CreateVnfRequest body) {
		return frontController.create(body.getVnfdId(), body.getVnfInstanceName(), body.getVnfInstanceDescription(), x -> mapper.map(x),
				VnfInstances351Sol002Controller::makeLinks, "");
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdChangeExtConnPost(final String vnfInstanceId, @Valid final ChangeExtVnfConnectivityRequest body) {
		final ChangeExtVnfConnRequest req = vnfInstanceRequest361Mapping.map(body);
		return frontController.changeExtConn(getSafeUUID(vnfInstanceId), req, VnfInstances351Sol002Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdChangeFlavourPost(final String vnfInstanceId, @Valid final ChangeVnfFlavourRequest body) {
		return frontController.changeFlavour(getSafeUUID(vnfInstanceId), body, VnfInstances351Sol002Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdChangeVnfpkgPost(final String vnfInstanceId, @Valid final ChangeCurrentVnfPkgRequest body) {
		return frontController.changeVnfPkg(getSafeUUID(vnfInstanceId), body, VnfInstances351Sol002Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdCreateSnapshotPost(final String vnfInstanceId, @Valid final CreateVnfSnapshotRequest body) {
		return frontController.createSnapshot(getSafeUUID(vnfInstanceId), body, VnfInstances351Sol002Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdDelete(final String vnfInstanceId) {
		return frontController.deleteById(getSafeUUID(vnfInstanceId));
	}

	@Override
	public ResponseEntity<VnfInstance> vnfInstancesVnfInstanceIdGet(final String vnfInstanceId) {
		return frontController.findById(getSafeUUID(vnfInstanceId), x -> mapper.map(x), VnfInstances351Sol002Controller::makeLinks, "");
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdHealPost(final String vnfInstanceId, @Valid final HealVnfRequest body) {
		return frontController.heal(getSafeUUID(vnfInstanceId), body.getCause(), new HashMap<>(), VnfInstances351Sol002Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdInstantiatePost(final String vnfInstanceId, @Valid final InstantiateVnfRequest body) {
		final VnfInstantiate req = vnfInstantiate361Mapping.map(body);
		return frontController.instantiate(getSafeUUID(vnfInstanceId), req, VnfInstances351Sol002Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdOperatePost(final String vnfInstanceId, @Valid final OperateVnfRequest body) {
		final VnfOperateRequest req = vnfInstanceRequest361Mapping.map(body);
		return frontController.operate(getSafeUUID(vnfInstanceId), req, VnfInstances351Sol002Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdPatch(final String vnfInstanceId, @Valid final String body, final String ifMatch) {
		return frontController.modify(getSafeUUID(vnfInstanceId), body, ifMatch, VnfInstances351Sol002Controller::getInstanceLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdRevertToSnapshotPost(final String vnfInstanceId, @Valid final RevertToVnfSnapshotRequest body) {
		return frontController.snapshot(getSafeUUID(vnfInstanceId), body);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdScalePost(final String vnfInstanceId, @Valid final ScaleVnfRequest body) {
		final VnfScaleRequest req = vnfInstanceRequest361Mapping.map(body);
		return frontController.scale(getSafeUUID(vnfInstanceId), req, VnfInstances351Sol002Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdScaleToLevelPost(final String vnfInstanceId, @Valid final ScaleVnfToLevelRequest body) {
		final VnfScaleToLevelRequest req = vnfInstanceRequest361Mapping.map(body);
		return frontController.scaleToLevel(getSafeUUID(vnfInstanceId), req, VnfInstances351Sol002Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdTerminatePost(final String vnfInstanceId, @Valid final TerminateVnfRequest body) {
		return frontController.terminate(getSafeUUID(vnfInstanceId), CancelModeTypeEnum.valueOf(body.getTerminationType().toString()), body.getGracefulTerminationTimeout(), VnfInstances351Sol002Controller::getLcmLink);
	}

	private static String getLcmLink(final VnfBlueprint vnfblueprint) {
		return linkTo(methodOn(VnfLcmOpOccs351Sol003Api.class).vnfLcmOpOccsVnfLcmOpOccIdGet(vnfblueprint.getId().toString())).withSelfRel().getHref();
	}

	private static String getInstanceLink(final com.ubiqube.etsi.mano.dao.mano.VnfInstance vnfInstance) {
		return linkTo(methodOn(VnfInstances351Sol003Api.class).vnfInstancesVnfInstanceIdGet(vnfInstance.getId().toString())).withSelfRel().getHref();
	}

	private static void makeLinks(final VnfInstance vnfInstance) {
		final String id = vnfInstance.getId();
		final String hrefScaleToLevel = linkTo(methodOn(VnfInstances351Sol002Api.class).vnfInstancesVnfInstanceIdScaleToLevelPost(id, null)).withSelfRel().getHref();
		final String hrefScale = linkTo(methodOn(VnfInstances351Sol002Api.class).vnfInstancesVnfInstanceIdScalePost(id, null)).withSelfRel().getHref();
		final String hrefOperate = linkTo(methodOn(VnfInstances351Sol002Api.class).vnfInstancesVnfInstanceIdOperatePost(id, null)).withSelfRel().getHref();
		final String hrefInstanciate = linkTo(methodOn(VnfInstances351Sol002Api.class).vnfInstancesVnfInstanceIdInstantiatePost(id, null)).withSelfRel().getHref();
		final String hrefIndicators = "";
		final String hrefHeal = linkTo(methodOn(VnfInstances351Sol002Api.class).vnfInstancesVnfInstanceIdHealPost(id, null)).withSelfRel().getHref();
		final String hrefChangeFlavor = linkTo(methodOn(VnfInstances351Sol002Api.class).vnfInstancesVnfInstanceIdChangeFlavourPost(id, null)).withSelfRel().getHref();
		final String hrefChangeExtConn = linkTo(methodOn(VnfInstances351Sol002Api.class).vnfInstancesVnfInstanceIdChangeExtConnPost(id, null)).withSelfRel().getHref();
		final String hrefSelf = linkTo(methodOn(VnfInstances351Sol002Api.class).vnfInstancesVnfInstanceIdGet(id)).withSelfRel().getHref();
		final String hrefTerminate = linkTo(methodOn(VnfInstances351Sol002Api.class).vnfInstancesVnfInstanceIdTerminatePost(id, null)).withSelfRel().getHref();
		final VnfInstanceLinks vnfInstanceLinks = new VnfInstanceLinks();
		final Link self = new Link();
		self.setHref(hrefSelf);
		vnfInstanceLinks.self(self);

		final Link changeExtConn = new Link();
		changeExtConn.setHref(hrefChangeExtConn);
		vnfInstanceLinks.setChangeExtConn(changeExtConn);

		final Link changeFlavour = new Link();
		changeFlavour.setHref(hrefChangeFlavor);
		vnfInstanceLinks.setChangeFlavour(changeFlavour);

		final Link heal = new Link();
		heal.setHref(hrefHeal);
		vnfInstanceLinks.setHeal(heal);

		final Link indicators = new Link();
		indicators.setHref(hrefIndicators);
		vnfInstanceLinks.setIndicators(indicators);

		final Link instantiate = new Link();
		instantiate.setHref(hrefInstanciate);
		vnfInstanceLinks.setInstantiate(instantiate);

		final Link operate = new Link();
		operate.setHref(hrefOperate);
		vnfInstanceLinks.setOperate(operate);

		final Link scale = new Link();
		scale.setHref(hrefScale);
		vnfInstanceLinks.setScale(scale);

		final Link terminate = new Link();
		terminate.setHref(hrefTerminate);
		vnfInstanceLinks.setTerminate(terminate);

		final Link scaleToLevel = new Link();
		scaleToLevel.setHref(hrefScaleToLevel);
		vnfInstanceLinks.setScaleToLevel(scaleToLevel);
		vnfInstance.setLinks(vnfInstanceLinks);
	}

}
