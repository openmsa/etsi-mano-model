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
package com.ubiqube.etsi.mano.v261.service.mapping.lcm;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.dao.mano.v2.VnfBlueprint;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.ChangeExtVnfConnectivityRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.ChangeVnfFlavourRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.HealVnfRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.InstantiateVnfRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.OperateVnfRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.ScaleVnfRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.ScaleVnfToLevelRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.TerminateVnfRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.VnfInfoModificationRequest;
import com.ubiqube.etsi.mano.v261.service.mapping.VimConnectionInfo261Mapping;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VnfLcmOpOccMapper261Mapping extends VimConnectionInfo261Mapping {

	@Mapping(target = "vimConnectionInfo", source = "vimConnections")
	@Mapping(target = "vnfPkgId", source = "vnfInstance.vnfPkg.id")
	@Mapping(target = "extensions", ignore = true)
	@Mapping(target = "metadata", ignore = true)
	@Mapping(target = "vnfConfigurableProperties", ignore = true)
	@Mapping(target = "vnfInstanceDescription", ignore = true)
	@Mapping(target = "vnfInstanceName", ignore = true)
	VnfInfoModificationRequest mapToVnfInfoModificationRequest(VnfBlueprint o);

	@Mapping(target = "gracefulTerminationTimeout", ignore = true)
	@Mapping(target = "terminationType", ignore = true)
	TerminateVnfRequest mapToTerminateVnfRequest(VnfBlueprint o);

	@Mapping(target = "vimConnectionInfo", ignore = true)
	@Mapping(target = "extVirtualLinks", ignore = true)
	ChangeExtVnfConnectivityRequest mapToChangeExtVnfConnectivityRequest(VnfBlueprint o);

	@Mapping(target = "cause", ignore = true)
	HealVnfRequest mapToHealVnfRequest(VnfBlueprint o);

	@Mapping(target = "gracefulStopTimeout", ignore = true)
	@Mapping(target = "changeStateTo", ignore = true)
	@Mapping(target = "stopType", ignore = true)
	OperateVnfRequest mapToOperateVnfRequest(VnfBlueprint o);

	@Mapping(target = "vimConnectionInfo", source = "vimConnections")
	@Mapping(target = "extManagedVirtualLinks", ignore = true)
	@Mapping(target = "extVirtualLinks", ignore = true)
	@Mapping(target = "instantiationLevelId", ignore = true)
	@Mapping(target = "newFlavourId", ignore = true)
	ChangeVnfFlavourRequest mapToChangeVnfFlavourRequest(VnfBlueprint o);

	@Mapping(target = "instantiationLevelId", source = "parameters.instantiationLevelId")
	@Mapping(target = "scaleInfo", source = "parameters.scaleStatus")
	ScaleVnfToLevelRequest mapToScaleVnfToLevelRequest(VnfBlueprint o);

	@Mapping(target = "aspectId", ignore = true)
	@Mapping(target = "numberOfSteps", ignore = true)
	@Mapping(target = "type", ignore = true)
	ScaleVnfRequest mapToScaleVnfRequest(VnfBlueprint o);

	@Mapping(target = "vimConnectionInfo", source = "vimConnections")
	@Mapping(target = "extManagedVirtualLinks", ignore = true)
	@Mapping(target = "extVirtualLinks", ignore = true)
	@Mapping(target = "flavourId", ignore = true)
	@Mapping(target = "instantiationLevelId", ignore = true)
	@Mapping(target = "localizationLanguage", ignore = true)
	InstantiateVnfRequest mapToInstantiateVnfRequest(VnfBlueprint o);

}
