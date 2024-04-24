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
package com.ubiqube.etsi.mano.v261.vnfm.controller.vnflcm.sol002;

import static com.ubiqube.etsi.mano.Constants.getSafeUUID;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.net.URISyntaxException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.common.v261.model.Link;
import com.ubiqube.etsi.mano.common.v261.model.nslcm.VnfInstanceLinks;
import com.ubiqube.etsi.mano.dao.mano.CancelModeTypeEnum;
import com.ubiqube.etsi.mano.dao.mano.v2.VnfBlueprint;
import com.ubiqube.etsi.mano.dao.mano.vnfi.ChangeExtVnfConnRequest;
import com.ubiqube.etsi.mano.model.VnfInstantiate;
import com.ubiqube.etsi.mano.model.VnfOperateRequest;
import com.ubiqube.etsi.mano.model.VnfScaleRequest;
import com.ubiqube.etsi.mano.model.VnfScaleToLevelRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.ChangeExtVnfConnectivityRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.ChangeVnfFlavourRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.CreateVnfRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.HealVnfRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.InstantiateVnfRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.OperateVnfRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.ScaleVnfRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.ScaleVnfToLevelRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.TerminateVnfRequest;
import com.ubiqube.etsi.mano.v261.vnfm.controller.vnflcm.sol003.VnfLcmOpOccs261Sol003Controller;
import com.ubiqube.etsi.mano.vnfm.fc.vnflcm.VnfInstanceGenericFrontController;

import jakarta.validation.constraints.NotNull;
import ma.glasnost.orika.MapperFacade;

/**
 *
 * @author Olivier Vignaud {@literal {@literal <ovi@ubiqube.com>}}
 *
 */
@RestController
public class VnfLcm261Sol002Controller implements VnfLcm261Sol002Api {
	private static final Logger LOG = LoggerFactory.getLogger(VnfLcm261Sol002Controller.class);
	private static final OperateVnfRequest OPERATE_REQUEST = new OperateVnfRequest();
	private static final InstantiateVnfRequest INSTANTIATE_REQUEST = new InstantiateVnfRequest();
	private static final HealVnfRequest HEAL_REQUEST = new HealVnfRequest();

	private final VnfInstanceGenericFrontController frontController;
	private final MapperFacade mapper;

	public VnfLcm261Sol002Controller(final VnfInstanceGenericFrontController frontController, final MapperFacade mapper) {
		this.frontController = frontController;
		this.mapper = mapper;
		LOG.info("Starting VNF Lcm Instance SOL002 Controller.");
	}

	@Override
	public ResponseEntity<String> vnfInstancesGet(final MultiValueMap<String, String> requestParams) {
		return frontController.search(requestParams, x -> mapper.map(x, com.ubiqube.etsi.mano.common.v261.model.nslcm.VnfInstance.class), null, VnfLcm261Sol002Controller::makeLinks, com.ubiqube.etsi.mano.common.v261.model.nslcm.VnfInstance.class);
	}

	@Override
	public ResponseEntity<com.ubiqube.etsi.mano.common.v261.model.nslcm.VnfInstance> vnfInstancesPost(final CreateVnfRequest createVnfRequest) {
		return frontController.create(createVnfRequest.getVnfdId(), createVnfRequest.getVnfInstanceName(), createVnfRequest.getVnfInstanceDescription(),
				x -> mapper.map(x, com.ubiqube.etsi.mano.common.v261.model.nslcm.VnfInstance.class), VnfLcm261Sol002Controller::makeLinks, "");
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdChangeExtConnPost(final String vnfInstanceId, final ChangeExtVnfConnectivityRequest body) {
		final ChangeExtVnfConnRequest req = mapper.map(body, ChangeExtVnfConnRequest.class);
		return frontController.changeExtConn(getSafeUUID(vnfInstanceId), req, VnfLcm261Sol002Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdChangeFlavourPost(final String vnfInstanceId, final ChangeVnfFlavourRequest body) {
		return frontController.changeFlavour(getSafeUUID(vnfInstanceId), body, VnfLcm261Sol002Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdDelete(final String vnfInstanceId) {
		return frontController.deleteById(getSafeUUID(vnfInstanceId));
	}

	@Override
	public ResponseEntity<com.ubiqube.etsi.mano.common.v261.model.nslcm.VnfInstance> vnfInstancesVnfInstanceIdGet(final String vnfInstanceId) {
		return frontController.findById(getSafeUUID(vnfInstanceId), x -> mapper.map(x, com.ubiqube.etsi.mano.common.v261.model.nslcm.VnfInstance.class),
				VnfLcm261Sol002Controller::makeLinks, "");
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdHealPost(final String vnfInstanceId, final HealVnfRequest body) {
		return frontController.heal(getSafeUUID(vnfInstanceId), body.getCause(), new HashMap<>(), VnfLcm261Sol002Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdInstantiatePost(final String vnfInstanceId, final InstantiateVnfRequest body) {
		final VnfInstantiate req = mapper.map(body, VnfInstantiate.class);
		return frontController.instantiate(getSafeUUID(vnfInstanceId), req, VnfLcm261Sol002Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdOperatePost(final String vnfInstanceId, final OperateVnfRequest body) {
		final VnfOperateRequest req = mapper.map(body, VnfOperateRequest.class);
		return frontController.operate(getSafeUUID(vnfInstanceId), req, VnfLcm261Sol002Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdPatch(final String vnfInstanceId, final String body, final String ifMatch) throws URISyntaxException {
		return frontController.modify(getSafeUUID(vnfInstanceId), body, ifMatch, VnfLcm261Sol002Controller::getInstanceLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdScalePost(final String vnfInstanceId, final ScaleVnfRequest body) {
		final VnfScaleRequest req = mapper.map(body, VnfScaleRequest.class);
		return frontController.scale(getSafeUUID(vnfInstanceId), req, VnfLcm261Sol002Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdScaleToLevelPost(final String vnfInstanceId, final ScaleVnfToLevelRequest body) {
		final VnfScaleToLevelRequest req = mapper.map(body, VnfScaleToLevelRequest.class);
		return frontController.scaleToLevel(getSafeUUID(vnfInstanceId), req, VnfLcm261Sol002Controller::getLcmLink);
	}

	@Override
	public ResponseEntity<Void> vnfInstancesVnfInstanceIdTerminatePost(final String vnfInstanceId, final TerminateVnfRequest terminateVnfRequest) {
		return frontController.terminate(getSafeUUID(vnfInstanceId), CancelModeTypeEnum.valueOf(terminateVnfRequest.getTerminationType().toString()),
				terminateVnfRequest.getGracefulTerminationTimeout(), VnfLcm261Sol002Controller::getLcmLink);
	}

	public static String getSelfLink(final String id) {
		return linkTo(methodOn(VnfLcmOpOccs261Sol002Api.class).vnfLcmOpOccsVnfLcmOpOccIdGet(id)).withSelfRel().getHref();
	}

	private static String getLcmLink(final VnfBlueprint vnfblueprint) {
		return linkTo(methodOn(VnfLcmOpOccs261Sol003Controller.class).vnfLcmOpOccsVnfLcmOpOccIdGet(vnfblueprint.getId().toString())).withSelfRel().getHref();
	}

	private static String getInstanceLink(final com.ubiqube.etsi.mano.dao.mano.VnfInstance vnfInstance) {
		return linkTo(methodOn(VnfLcm261Sol002Api.class).vnfInstancesVnfInstanceIdGet(vnfInstance.getId().toString())).withSelfRel().getHref();
	}

	private static void makeLinks(@NotNull final com.ubiqube.etsi.mano.common.v261.model.nslcm.VnfInstance vnfInstance) {
		final String id = vnfInstance.getId();
		final String hrefScaleToLevel = linkTo(methodOn(VnfLcm261Sol002Api.class).vnfInstancesVnfInstanceIdScaleToLevelPost(id, null)).withSelfRel().getHref();
		final String hrefScale = linkTo(methodOn(VnfLcm261Sol002Api.class).vnfInstancesVnfInstanceIdScalePost(id, null)).withSelfRel().getHref();
		final String hrefOperate = linkTo(methodOn(VnfLcm261Sol002Api.class).vnfInstancesVnfInstanceIdOperatePost(id, OPERATE_REQUEST)).withSelfRel().getHref();
		final String hrefInstanciate = linkTo(methodOn(VnfLcm261Sol002Api.class).vnfInstancesVnfInstanceIdInstantiatePost(id, INSTANTIATE_REQUEST)).withSelfRel().getHref();
		final String hrefIndicators = "";
		final String hrefHeal = linkTo(methodOn(VnfLcm261Sol002Api.class).vnfInstancesVnfInstanceIdHealPost(id, HEAL_REQUEST)).withSelfRel().getHref();
		final String hrefChangeFlavor = linkTo(methodOn(VnfLcm261Sol002Api.class).vnfInstancesVnfInstanceIdChangeFlavourPost(id, null)).withSelfRel().getHref();
		final String hrefChangeExtConn = linkTo(methodOn(VnfLcm261Sol002Api.class).vnfInstancesVnfInstanceIdChangeExtConnPost(id, null)).withSelfRel().getHref();
		final String hrefSelf = linkTo(methodOn(VnfLcm261Sol002Api.class).vnfInstancesVnfInstanceIdGet(id)).withSelfRel().getHref();
		final String hrefTerminate = linkTo(methodOn(VnfLcm261Sol002Api.class).vnfInstancesVnfInstanceIdTerminatePost(id, null)).withSelfRel().getHref();
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
