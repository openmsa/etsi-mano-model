package com.ubiqube.etsi.mano.em.v271.controller.vnflcm;

import static com.ubiqube.etsi.mano.Constants.getSafeUUID;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;

import com.ubiqube.etsi.mano.controller.nslcm.VnfInstanceGenericFrontController;
import com.ubiqube.etsi.mano.dao.mano.CancelModeTypeEnum;
import com.ubiqube.etsi.mano.dao.mano.v2.VnfBlueprint;
import com.ubiqube.etsi.mano.em.v271.model.vnflcm.ChangeExtVnfConnectivityRequest;
import com.ubiqube.etsi.mano.em.v271.model.vnflcm.ChangeVnfFlavourRequest;
import com.ubiqube.etsi.mano.em.v271.model.vnflcm.CreateVnfRequest;
import com.ubiqube.etsi.mano.em.v271.model.vnflcm.HealVnfRequest;
import com.ubiqube.etsi.mano.em.v271.model.vnflcm.InstantiateVnfRequest;
import com.ubiqube.etsi.mano.em.v271.model.vnflcm.Link;
import com.ubiqube.etsi.mano.em.v271.model.vnflcm.OperateVnfRequest;
import com.ubiqube.etsi.mano.em.v271.model.vnflcm.ScaleVnfRequest;
import com.ubiqube.etsi.mano.em.v271.model.vnflcm.ScaleVnfToLevelRequest;
import com.ubiqube.etsi.mano.em.v271.model.vnflcm.TerminateVnfRequest;
import com.ubiqube.etsi.mano.em.v271.model.vnflcm.VnfInstance;
import com.ubiqube.etsi.mano.em.v271.model.vnflcm.VnfInstanceLinks;

@Controller
public class VnfInstances271Sol002Controller implements VnfInstances271Sol002Api {
	private final VnfInstanceGenericFrontController frontController;

	public VnfInstances271Sol002Controller(final VnfInstanceGenericFrontController frontController) {
		super();
		this.frontController = frontController;
	}

	@Override
	public ResponseEntity<String> vnfInstancesGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return frontController.search(requestParams, VnfInstance.class, nextpageOpaqueMarker, VnfInstances271Sol002Controller::makeLinks);
	}

	@Override
	public ResponseEntity<VnfInstance> vnfInstancesPost(@Valid final CreateVnfRequest body) {
		return frontController.create(body.getVnfdId(), body.getVnfInstanceName(), body.getVnfInstanceDescription(), VnfInstance.class,
				VnfInstances271Sol002Controller::makeLinks, "");
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdChangeExtConnPost(final String vnfInstanceId, @Valid final ChangeExtVnfConnectivityRequest body) {
		return frontController.changeExtConn(getSafeUUID(vnfInstanceId), body);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdChangeFlavourPost(final String vnfInstanceId, @Valid final ChangeVnfFlavourRequest body) {
		return frontController.changeFlavour(getSafeUUID(vnfInstanceId), body);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdDelete(final String vnfInstanceId) {
		return frontController.deleteById(getSafeUUID(vnfInstanceId));
	}

	@Override
	public ResponseEntity<VnfInstance> vnfInstancesVnfInstanceIdGet(final String vnfInstanceId) {
		return frontController.findById(getSafeUUID(vnfInstanceId), VnfInstance.class, VnfInstances271Sol002Controller::makeLinks, "");
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdHealPost(final String vnfInstanceId, @Valid final HealVnfRequest body) {
		return frontController.heal(getSafeUUID(vnfInstanceId), body.getCause(), new HashMap<>());
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdInstantiatePost(final String vnfInstanceId, @Valid final InstantiateVnfRequest body) {
		return frontController.instantiate(getSafeUUID(vnfInstanceId), body, VnfInstances271Sol002Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdOperatePost(final String vnfInstanceId, @Valid final OperateVnfRequest body) {
		return frontController.operate(getSafeUUID(vnfInstanceId), body, VnfInstances271Sol002Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdPatch(final String vnfInstanceId, @Valid final String body, final String ifMatch) {
		return frontController.modify(getSafeUUID(vnfInstanceId), body, ifMatch, VnfInstances271Sol002Controller::getInstanceLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdScalePost(final String vnfInstanceId, @Valid final ScaleVnfRequest body) {
		return frontController.scale(getSafeUUID(vnfInstanceId), body, VnfInstances271Sol002Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdScaleToLevelPost(final String vnfInstanceId, @Valid final ScaleVnfToLevelRequest body) {
		return frontController.scaleToLevel(getSafeUUID(vnfInstanceId), body, VnfInstances271Sol002Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdTerminatePost(final String vnfInstanceId, @Valid final TerminateVnfRequest body) {
		return frontController.terminate(getSafeUUID(vnfInstanceId), CancelModeTypeEnum.valueOf(body.getTerminationType().toString()), 0, VnfInstances271Sol002Controller::getLcmLink);
	}

	private static String getLcmLink(final VnfBlueprint vnfblueprint) {
		return linkTo(methodOn(VnfLcmOpOccs271Sol002Api.class).vnfLcmOpOccsVnfLcmOpOccIdGet(vnfblueprint.getId().toString())).withSelfRel().getHref();
	}

	private static String getInstanceLink(final com.ubiqube.etsi.mano.dao.mano.VnfInstance vnfInstance) {
		return linkTo(methodOn(VnfInstances271Sol002Api.class).vnfInstancesVnfInstanceIdGet(vnfInstance.getId().toString())).withSelfRel().getHref();
	}

	private static void makeLinks(final VnfInstance vnfInstance) {
		final String id = vnfInstance.getId();
		final String hrefScaleToLevel = linkTo(methodOn(VnfInstances271Sol002Api.class).vnfInstancesVnfInstanceIdScaleToLevelPost(id, null)).withSelfRel().getHref();
		final String hrefScale = linkTo(methodOn(VnfInstances271Sol002Api.class).vnfInstancesVnfInstanceIdScalePost(id, null)).withSelfRel().getHref();
		final String hrefOperate = linkTo(methodOn(VnfInstances271Sol002Api.class).vnfInstancesVnfInstanceIdOperatePost(id, null)).withSelfRel().getHref();
		final String hrefInstanciate = linkTo(methodOn(VnfInstances271Sol002Api.class).vnfInstancesVnfInstanceIdInstantiatePost(id, null)).withSelfRel().getHref();
		final String hrefIndicators = "";
		final String hrefHeal = linkTo(methodOn(VnfInstances271Sol002Api.class).vnfInstancesVnfInstanceIdHealPost(id, null)).withSelfRel().getHref();
		final String hrefChangeFlavor = linkTo(methodOn(VnfInstances271Sol002Api.class).vnfInstancesVnfInstanceIdChangeFlavourPost(id, null)).withSelfRel().getHref();
		final String hrefChangeExtConn = linkTo(methodOn(VnfInstances271Sol002Api.class).vnfInstancesVnfInstanceIdChangeExtConnPost(id, null)).withSelfRel().getHref();
		final String hrefSelf = linkTo(methodOn(VnfInstances271Sol002Api.class).vnfInstancesVnfInstanceIdGet(id)).withSelfRel().getHref();
		final String hrefTerminate = linkTo(methodOn(VnfInstances271Sol002Api.class).vnfInstancesVnfInstanceIdTerminatePost(id, null)).withSelfRel().getHref();
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
