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
package com.ubiqube.etsi.mano.v451.service.mapping.lcm;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.dao.mano.v2.VnfBlueprint;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.ChangeCurrentVnfPkgRequest;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.ChangeExtVnfConnectivityRequest;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.ChangeVnfFlavourRequest;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.CreateVnfSnapshotRequest;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.HealVnfRequest;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.InstantiateVnfRequest;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.OperateVnfRequest;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.RevertToVnfSnapshotRequest;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.ScaleVnfRequest;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.ScaleVnfToLevelRequest;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.TerminateVnfRequest;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VnfInfoModificationRequest;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VnfLcmOpOccMapper451Mapping {

	@Mapping(target = "certificateConfigurationData", ignore = true)
	@Mapping(target = "selectedDeployableModule", ignore = true)
	@Mapping(target = "extManagedVirtualLinks", ignore = true)
	@Mapping(target = "extVirtualLinks", ignore = true)
	@Mapping(target = "extensions", ignore = true)
	@Mapping(target = "vnfConfigurableProperties", ignore = true)
	@Mapping(target = "vnfdId", ignore = true)
	ChangeCurrentVnfPkgRequest mapToChangeCurrentVnfPkgRequest(VnfBlueprint o);

	@Mapping(target = "vnfcInstanceId", ignore = true)
	@Mapping(target = "vnfcSnapshotInfoId", ignore = true)
	RevertToVnfSnapshotRequest mapToRevertToVnfSnapshotRequest(VnfBlueprint o);

	@Mapping(target = "userDefinedData", ignore = true)
	@Mapping(target = "vnfcInstanceId", ignore = true)
	CreateVnfSnapshotRequest mapToCreateVnfSnapshotRequest(VnfBlueprint o);

	@Mapping(target = "extensions", ignore = true)
	@Mapping(target = "metadata", ignore = true)
	@Mapping(target = "vnfConfigurableProperties", ignore = true)
	@Mapping(target = "vnfInstanceDescription", ignore = true)
	@Mapping(target = "vnfInstanceName", ignore = true)
	@Mapping(target = "vnfcInfoModifications", ignore = true)
	@Mapping(target = "vnfdId", ignore = true)
	VnfInfoModificationRequest mapToVnfInfoModificationRequest(VnfBlueprint o);

	@Mapping(target = "gracefulTerminationTimeout", ignore = true)
	@Mapping(target = "terminationType", ignore = true)
	TerminateVnfRequest mapToTerminateVnfRequest(VnfBlueprint o);

	@Mapping(target = "certificateConfigurationData", ignore = true)
	@Mapping(target = "extVirtualLinks", ignore = true)
	ChangeExtVnfConnectivityRequest mapToChangeExtVnfConnectivityRequest(VnfBlueprint o);

	@Mapping(target = "cause", ignore = true)
	@Mapping(target = "healScript", ignore = true)
	@Mapping(target = "vnfcInstanceId", ignore = true)
	HealVnfRequest mapToHealVnfRequest(VnfBlueprint o);

	@Mapping(target = "changeStateTo", ignore = true)
	@Mapping(target = "gracefulStopTimeout", ignore = true)
	@Mapping(target = "stopType", ignore = true)
	@Mapping(target = "vnfcInstanceId", ignore = true)
	OperateVnfRequest mapToOperateVnfRequest(VnfBlueprint o);

	@Mapping(target = "certificateConfigurationData", ignore = true)
	@Mapping(target = "selectedDeployableModule", ignore = true)
	@Mapping(target = "extManagedVirtualLinks", ignore = true)
	@Mapping(target = "extVirtualLinks", ignore = true)
	@Mapping(target = "extensions", ignore = true)
	@Mapping(target = "instantiationLevelId", ignore = true)
	@Mapping(target = "newFlavourId", ignore = true)
	@Mapping(target = "targetScaleLevelInfo", ignore = true)
	@Mapping(target = "vnfConfigurableProperties", ignore = true)
	ChangeVnfFlavourRequest mapToChangeVnfFlavourRequest(VnfBlueprint o);

	@Mapping(target = "instantiationLevelId", source = "parameters.instantiationLevelId")
	@Mapping(target = "scaleInfo", source = "parameters.scaleStatus")
	ScaleVnfToLevelRequest mapToScaleVnfToLevelRequest(VnfBlueprint o);

	@Mapping(target = "aspectId", ignore = true)
	@Mapping(target = "numberOfSteps", ignore = true)
	@Mapping(target = "type", ignore = true)
	ScaleVnfRequest mapToScaleVnfRequest(VnfBlueprint o);

	@Mapping(target = "selectedDeployableModule", ignore = true)
	@Mapping(target = "vimConnectionInfo", ignore = true)
	@Mapping(target = "extManagedVirtualLinks", ignore = true)
	@Mapping(target = "extVirtualLinks", ignore = true)
	@Mapping(target = "extensions", ignore = true)
	@Mapping(target = "flavourId", ignore = true)
	@Mapping(target = "instantiationLevelId", ignore = true)
	@Mapping(target = "localizationLanguage", ignore = true)
	@Mapping(target = "targetScaleLevelInfo", ignore = true)
	@Mapping(target = "vnfConfigurableProperties", ignore = true)
	InstantiateVnfRequest mapToInstantiateVnfRequest(VnfBlueprint o);

}
