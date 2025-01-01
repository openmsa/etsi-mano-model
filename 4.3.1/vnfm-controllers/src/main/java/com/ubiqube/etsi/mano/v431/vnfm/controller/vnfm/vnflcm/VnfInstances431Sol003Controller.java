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
package com.ubiqube.etsi.mano.v431.vnfm.controller.vnfm.vnflcm;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;
import static com.ubiqube.etsi.mano.vnfm.fc.Constants.getSafeUUID;

import java.time.OffsetDateTime;
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
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.ChangeCurrentVnfPkgRequest;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.ChangeExtVnfConnectivityRequest;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.ChangeVnfFlavourRequest;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.CreateVnfRequest;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.CreateVnfSnapshotRequest;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.HealVnfRequest;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.InstantiateVnfRequest;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.OperateVnfRequest;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.RevertToVnfSnapshotRequest;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.ScaleVnfRequest;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.ScaleVnfToLevelRequest;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.TerminateVnfRequest;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.VnfInstance;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.VnfInstanceLinks;
import com.ubiqube.etsi.mano.v431.service.mapping.VnfInstance431Mapping;
import com.ubiqube.etsi.mano.v431.service.mapping.vnflcm.VnfInstanceRequest431Mapping;
import com.ubiqube.etsi.mano.v431.service.mapping.vnflcm.VnfInstantiate431Mapping;
import com.ubiqube.etsi.mano.v431.vnfm.controller.vnfm.vnfind.VnfInd431Sol003Api;
import com.ubiqube.etsi.mano.vnfm.fc.vnflcm.VnfInstanceGenericFrontController;

import jakarta.validation.Valid;

@RestController
public class VnfInstances431Sol003Controller implements VnfInstances431Sol003Api {
	private final VnfInstanceGenericFrontController frontController;
	private final VnfInstance431Mapping mapper;
	private final VnfInstanceRequest431Mapping vnfInstanceRequest431Mapping;
	private final VnfInstantiate431Mapping vnfInstantiate431Mapping;

	public VnfInstances431Sol003Controller(final VnfInstanceGenericFrontController frontController, final VnfInstance431Mapping mapper, final VnfInstantiate431Mapping vnfInstantiate431Mapping, final VnfInstanceRequest431Mapping vnfInstanceRequest431Mapping) {
		this.frontController = frontController;
		this.mapper = mapper;
		this.vnfInstanceRequest431Mapping = vnfInstanceRequest431Mapping;
		this.vnfInstantiate431Mapping = vnfInstantiate431Mapping;
	}

	@Override
	public ResponseEntity<String> vnfInstancesGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return frontController.search(requestParams, x -> mapper.map(x), nextpageOpaqueMarker, VnfInstances431Sol003Controller::makeLinks, VnfInstance.class);
	}

	@Override
	public ResponseEntity<VnfInstance> vnfInstancesPost(@Valid final CreateVnfRequest createVnfRequest) {
		return frontController.create(createVnfRequest.getVnfdId(), createVnfRequest.getVnfInstanceName(), createVnfRequest.getVnfInstanceDescription(), x -> mapper.map(x),
				VnfInstances431Sol003Controller::makeLinks, "");
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdChangeExtConnPost(final String vnfInstanceId, @Valid final ChangeExtVnfConnectivityRequest body) {
		final ChangeExtVnfConnRequest req = vnfInstanceRequest431Mapping.map(body);
		return frontController.changeExtConn(getSafeUUID(vnfInstanceId), req, VnfInstances431Sol003Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdChangeFlavourPost(final String vnfInstanceId, @Valid final ChangeVnfFlavourRequest body) {
		return frontController.changeFlavour(getSafeUUID(vnfInstanceId), body, VnfInstances431Sol003Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdChangeVnfpkgPost(final String vnfInstanceId, @Valid final ChangeCurrentVnfPkgRequest body) {
		return frontController.changeVnfPkg(getSafeUUID(vnfInstanceId), body, VnfInstances431Sol003Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdCreateSnapshotPost(final String vnfInstanceId, @Valid final CreateVnfSnapshotRequest body) {
		return frontController.createSnapshot(getSafeUUID(vnfInstanceId), body, VnfInstances431Sol003Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdDelete(final String vnfInstanceId) {
		return frontController.deleteById(getSafeUUID(vnfInstanceId));
	}

	@Override
	public ResponseEntity<VnfInstance> vnfInstancesVnfInstanceIdGet(final String vnfInstanceId) {
		return frontController.findById(getSafeUUID(vnfInstanceId), x -> mapper.map(x), VnfInstances431Sol003Controller::makeLinks, "");
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdHealPost(final String vnfInstanceId, @Valid final HealVnfRequest body) {
		return frontController.heal(getSafeUUID(vnfInstanceId), body.getCause(), new HashMap<>(), VnfInstances431Sol003Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdInstantiatePost(final String vnfInstanceId, @Valid final InstantiateVnfRequest body) {
		final VnfInstantiate req = vnfInstantiate431Mapping.map(body);
		return frontController.instantiate(getSafeUUID(vnfInstanceId), req, VnfInstances431Sol003Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdOperatePost(final String vnfInstanceId, @Valid final OperateVnfRequest body) {
		final VnfOperateRequest req = vnfInstanceRequest431Mapping.map(body);
		return frontController.operate(getSafeUUID(vnfInstanceId), req, VnfInstances431Sol003Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<VnfInstance> vnfInstancesVnfInstanceIdPatch(final String vnfInstanceId, @Valid final String body, final OffsetDateTime ifUnmodifiedSince, final String ifMatch) {
		return frontController.modify(getSafeUUID(vnfInstanceId), body, ifMatch, VnfInstances431Sol003Controller::getInstanceLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdRevertToSnapshotPost(final String vnfInstanceId, @Valid final RevertToVnfSnapshotRequest body) {
		return frontController.snapshot(getSafeUUID(vnfInstanceId), body);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdScalePost(final String vnfInstanceId, @Valid final ScaleVnfRequest body) {
		final VnfScaleRequest req = vnfInstanceRequest431Mapping.map(body);
		return frontController.scale(getSafeUUID(vnfInstanceId), req, VnfInstances431Sol003Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdScaleToLevelPost(final String vnfInstanceId, @Valid final ScaleVnfToLevelRequest body) {
		final VnfScaleToLevelRequest req = vnfInstanceRequest431Mapping.map(body);
		return frontController.scaleToLevel(getSafeUUID(vnfInstanceId), req, VnfInstances431Sol003Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdTerminatePost(final String vnfInstanceId, @Valid final TerminateVnfRequest body) {
		return frontController.terminate(getSafeUUID(vnfInstanceId), CancelModeTypeEnum.valueOf(body.getTerminationType().toString()), body.getGracefulTerminationTimeout(), VnfInstances431Sol003Controller::getLcmLink);
	}

	private static String getLcmLink(final VnfBlueprint vnfblueprint) {
		return linkTo(methodOn(VnfLcmOpOccs431Sol003Api.class).vnfLcmOpOccsVnfLcmOpOccIdGet(vnfblueprint.getId().toString())).withSelfRel().getHref();
	}

	private static String getInstanceLink(final com.ubiqube.etsi.mano.dao.mano.VnfInstance vnfInstance) {
		return linkTo(methodOn(VnfInstances431Sol003Api.class).vnfInstancesVnfInstanceIdGet(vnfInstance.getId().toString())).withSelfRel().getHref();
	}

	private static void makeLinks(final VnfInstance vnfInstance) {
		final String id = vnfInstance.getId();
		final String hrefScaleToLevel = linkTo(methodOn(VnfInstances431Sol003Api.class).vnfInstancesVnfInstanceIdScaleToLevelPost(id, null)).withSelfRel().getHref();
		final String hrefScale = linkTo(methodOn(VnfInstances431Sol003Api.class).vnfInstancesVnfInstanceIdScalePost(id, null)).withSelfRel().getHref();
		final String hrefOperate = linkTo(methodOn(VnfInstances431Sol003Api.class).vnfInstancesVnfInstanceIdOperatePost(id, null)).withSelfRel().getHref();
		final String hrefInstanciate = linkTo(methodOn(VnfInstances431Sol003Api.class).vnfInstancesVnfInstanceIdInstantiatePost(id, null)).withSelfRel().getHref();
		final String hrefIndicators = linkTo(methodOn(VnfInd431Sol003Api.class).indicatorsVnfInstanceIdGet(id, null, null)).withSelfRel().getHref();
		final String hrefHeal = linkTo(methodOn(VnfInstances431Sol003Api.class).vnfInstancesVnfInstanceIdHealPost(id, null)).withSelfRel().getHref();
		final String hrefChangeFlavor = linkTo(methodOn(VnfInstances431Sol003Api.class).vnfInstancesVnfInstanceIdChangeFlavourPost(id, null)).withSelfRel().getHref();
		final String hrefChangeExtConn = linkTo(methodOn(VnfInstances431Sol003Api.class).vnfInstancesVnfInstanceIdChangeExtConnPost(id, null)).withSelfRel().getHref();
		final String hrefSelf = linkTo(methodOn(VnfInstances431Sol003Api.class).vnfInstancesVnfInstanceIdGet(id)).withSelfRel().getHref();
		final String hrefTerminate = linkTo(methodOn(VnfInstances431Sol003Api.class).vnfInstancesVnfInstanceIdTerminatePost(id, null)).withSelfRel().getHref();
		final String hrefChangeVnfPkg = linkTo(methodOn(VnfInstances431Sol003Api.class).vnfInstancesVnfInstanceIdChangeVnfpkgPost(id, null)).withSelfRel().getHref();
		final String hrefCreateSnap = linkTo(methodOn(VnfSnapshots431Sol003Api.class).vnfSnapshotsPost(null)).withSelfRel().getHref();
		final String hrefRevertSnap = linkTo(methodOn(VnfSnapshots431Sol003Api.class).vnfSnapshotsPost(null)).withSelfRel().getHref();
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

		final Link createSnap = new Link();
		createSnap.setHref(hrefCreateSnap);
		vnfInstanceLinks.setCreateSnapshot(createSnap);

		final Link revertSnap = new Link();
		revertSnap.setHref(hrefRevertSnap);
		vnfInstanceLinks.setRevertToSnapshot(revertSnap);

		final Link changeVnfPkg = new Link();
		changeVnfPkg.setHref(hrefChangeVnfPkg);
		vnfInstanceLinks.setChangeCurrentVnfPkg(changeVnfPkg);

		final Link scaleToLevel = new Link();
		scaleToLevel.setHref(hrefScaleToLevel);
		vnfInstanceLinks.setScaleToLevel(scaleToLevel);

		vnfInstance.setLinks(vnfInstanceLinks);
	}

}
