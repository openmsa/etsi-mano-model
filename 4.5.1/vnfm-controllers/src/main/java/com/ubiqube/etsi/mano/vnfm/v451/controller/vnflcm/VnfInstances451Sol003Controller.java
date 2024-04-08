package com.ubiqube.etsi.mano.vnfm.v451.controller.vnflcm;

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
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.ChangeCurrentVnfPkgRequest;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.ChangeExtVnfConnectivityRequest;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.ChangeVnfFlavourRequest;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.CreateVnfRequest;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.CreateVnfSnapshotRequest;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.HealVnfRequest;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.InstantiateVnfRequest;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.Link;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.OperateVnfRequest;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.RevertToVnfSnapshotRequest;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.ScaleVnfRequest;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.ScaleVnfToLevelRequest;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.SelectVnfDeployableModulesRequest;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.TerminateVnfRequest;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.VnfInstance;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.VnfInstanceLinks;
import com.ubiqube.etsi.mano.model.VnfInstantiate;
import com.ubiqube.etsi.mano.model.VnfOperateRequest;
import com.ubiqube.etsi.mano.model.VnfScaleRequest;
import com.ubiqube.etsi.mano.model.VnfScaleToLevelRequest;
import com.ubiqube.etsi.mano.vnfm.fc.vnflcm.VnfInstanceGenericFrontController;
import com.ubiqube.etsi.mano.vnfm.v451.controller.vnfind.Indicators451Sol003Api;

import jakarta.validation.Valid;
import ma.glasnost.orika.MapperFacade;

@RestController
public class VnfInstances451Sol003Controller implements VnfInstances451Sol003Api {
	private final VnfInstanceGenericFrontController frontController;
	private final MapperFacade mapper;

	public VnfInstances451Sol003Controller(final VnfInstanceGenericFrontController frontController, final MapperFacade mapper) {
		this.frontController = frontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<String> vnfInstancesGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return frontController.search(requestParams, VnfInstance.class, nextpageOpaqueMarker, VnfInstances451Sol003Controller::makeLinks);
	}

	@Override
	public ResponseEntity<VnfInstance> vnfInstancesPost(@Valid final CreateVnfRequest createVnfRequest) {
		return frontController.create(createVnfRequest.getVnfdId(), createVnfRequest.getVnfInstanceName(), createVnfRequest.getVnfInstanceDescription(), x -> mapper.map(x, VnfInstance.class),
				VnfInstances451Sol003Controller::makeLinks, "");
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdChangeExtConnPost(final String vnfInstanceId, @Valid final ChangeExtVnfConnectivityRequest body) {
		final ChangeExtVnfConnRequest req = mapper.map(body, ChangeExtVnfConnRequest.class);
		return frontController.changeExtConn(getSafeUUID(vnfInstanceId), req, VnfInstances451Sol003Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdChangeFlavourPost(final String vnfInstanceId, @Valid final ChangeVnfFlavourRequest body) {
		return frontController.changeFlavour(getSafeUUID(vnfInstanceId), body, VnfInstances451Sol003Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdChangeVnfpkgPost(final String vnfInstanceId, @Valid final ChangeCurrentVnfPkgRequest body) {
		return frontController.changeVnfPkg(getSafeUUID(vnfInstanceId), body, VnfInstances451Sol003Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdCreateSnapshotPost(final String vnfInstanceId, @Valid final CreateVnfSnapshotRequest body) {
		return frontController.createSnapshot(getSafeUUID(vnfInstanceId), body, VnfInstances451Sol003Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdDelete(final String vnfInstanceId) {
		return frontController.deleteById(getSafeUUID(vnfInstanceId));
	}

	@Override
	public ResponseEntity<VnfInstance> vnfInstancesVnfInstanceIdGet(final String vnfInstanceId) {
		return frontController.findById(getSafeUUID(vnfInstanceId), x -> mapper.map(x, VnfInstance.class), VnfInstances451Sol003Controller::makeLinks, "");
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdHealPost(final String vnfInstanceId, @Valid final HealVnfRequest body) {
		return frontController.heal(getSafeUUID(vnfInstanceId), body.getCause(), new HashMap<>(), VnfInstances451Sol003Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdInstantiatePost(final String vnfInstanceId, @Valid final InstantiateVnfRequest body) {
		final VnfInstantiate req = mapper.map(body, VnfInstantiate.class);
		return frontController.instantiate(getSafeUUID(vnfInstanceId), req, VnfInstances451Sol003Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdOperatePost(final String vnfInstanceId, @Valid final OperateVnfRequest body) {
		final VnfOperateRequest req = mapper.map(body, VnfOperateRequest.class);
		return frontController.operate(getSafeUUID(vnfInstanceId), req, VnfInstances451Sol003Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<VnfInstance> vnfInstancesVnfInstanceIdPatch(final String vnfInstanceId, @Valid final String body, final OffsetDateTime ifUnmodifiedSince, final String ifMatch) {
		return frontController.modify(getSafeUUID(vnfInstanceId), body, ifMatch, VnfInstances451Sol003Controller::getInstanceLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdRevertToSnapshotPost(final String vnfInstanceId, @Valid final RevertToVnfSnapshotRequest body) {
		return frontController.snapshot(getSafeUUID(vnfInstanceId), body);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdScalePost(final String vnfInstanceId, @Valid final ScaleVnfRequest body) {
		final VnfScaleRequest req = mapper.map(body, VnfScaleRequest.class);
		return frontController.scale(getSafeUUID(vnfInstanceId), req, VnfInstances451Sol003Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdScaleToLevelPost(final String vnfInstanceId, @Valid final ScaleVnfToLevelRequest body) {
		final VnfScaleToLevelRequest req = mapper.map(body, VnfScaleToLevelRequest.class);
		return frontController.scaleToLevel(getSafeUUID(vnfInstanceId), req, VnfInstances451Sol003Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdTerminatePost(final String vnfInstanceId, @Valid final TerminateVnfRequest body) {
		return frontController.terminate(getSafeUUID(vnfInstanceId), CancelModeTypeEnum.valueOf(body.getTerminationType().toString()), body.getGracefulTerminationTimeout(), VnfInstances451Sol003Controller::getLcmLink);
	}

	private static String getLcmLink(final VnfBlueprint vnfblueprint) {
		return linkTo(methodOn(VnfLcmOpOccs451Sol003Api.class).vnfLcmOpOccsVnfLcmOpOccIdGet(vnfblueprint.getId().toString())).withSelfRel().getHref();
	}

	private static String getInstanceLink(final com.ubiqube.etsi.mano.dao.mano.VnfInstance vnfInstance) {
		return linkTo(methodOn(VnfInstances451Sol003Api.class).vnfInstancesVnfInstanceIdGet(vnfInstance.getId().toString())).withSelfRel().getHref();
	}

	private static void makeLinks(final VnfInstance vnfInstance) {
		final String id = vnfInstance.getId();
		final String hrefScaleToLevel = linkTo(methodOn(VnfInstances451Sol003Api.class).vnfInstancesVnfInstanceIdScaleToLevelPost(id, null)).withSelfRel().getHref();
		final String hrefScale = linkTo(methodOn(VnfInstances451Sol003Api.class).vnfInstancesVnfInstanceIdScalePost(id, null)).withSelfRel().getHref();
		final String hrefOperate = linkTo(methodOn(VnfInstances451Sol003Api.class).vnfInstancesVnfInstanceIdOperatePost(id, null)).withSelfRel().getHref();
		final String hrefInstanciate = linkTo(methodOn(VnfInstances451Sol003Api.class).vnfInstancesVnfInstanceIdInstantiatePost(id, null)).withSelfRel().getHref();
		final String hrefIndicators = linkTo(methodOn(Indicators451Sol003Api.class).indicatorsVnfInstanceIdGet(id, null, null)).withSelfRel().getHref();
		final String hrefHeal = linkTo(methodOn(VnfInstances451Sol003Api.class).vnfInstancesVnfInstanceIdHealPost(id, null)).withSelfRel().getHref();
		final String hrefChangeFlavor = linkTo(methodOn(VnfInstances451Sol003Api.class).vnfInstancesVnfInstanceIdChangeFlavourPost(id, null)).withSelfRel().getHref();
		final String hrefChangeExtConn = linkTo(methodOn(VnfInstances451Sol003Api.class).vnfInstancesVnfInstanceIdChangeExtConnPost(id, null)).withSelfRel().getHref();
		final String hrefSelf = linkTo(methodOn(VnfInstances451Sol003Api.class).vnfInstancesVnfInstanceIdGet(id)).withSelfRel().getHref();
		final String hrefTerminate = linkTo(methodOn(VnfInstances451Sol003Api.class).vnfInstancesVnfInstanceIdTerminatePost(id, null)).withSelfRel().getHref();
		final String hrefChangeVnfPkg = linkTo(methodOn(VnfInstances451Sol003Api.class).vnfInstancesVnfInstanceIdChangeVnfpkgPost(id, null)).withSelfRel().getHref();
		final String hrefCreateSnap = linkTo(methodOn(VnfSnapshots451Sol003Api.class).vnfSnapshotsPost(null)).withSelfRel().getHref();
		final String hrefRevertSnap = linkTo(methodOn(VnfSnapshots451Sol003Api.class).vnfSnapshotsPost(null)).withSelfRel().getHref();
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

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdSelectDeplModsPost(final String vnfInstanceId, @Valid final SelectVnfDeployableModulesRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

}