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
 *     along with this program.  If not, see https://www.gnu.org/licenses/.
 */
package com.ubiqube.etsi.mano.v361.services.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;

import com.ubiqube.etsi.mano.dao.mano.v2.OperationStatusType;
import com.ubiqube.etsi.mano.dao.mano.v2.PlanOperationType;
import com.ubiqube.etsi.mano.dao.mano.v2.nfvo.NsBlueprint;
import com.ubiqube.etsi.mano.service.mapping.StringToUriMapping;
import com.ubiqube.etsi.mano.v331.model.nfvo.nslcm.NsLcmOpOcc;
import com.ubiqube.etsi.mano.v331.model.nfvo.nslcm.NsLcmOpType;
import com.ubiqube.etsi.mano.v331.model.nfvo.nslcm.NsLcmOperationStateType;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface NsLcmOpOcc331Mapping extends StringToUriMapping {
	@Mapping(target = "statusEnteredTime", ignore = true)
	@Mapping(target = "isAutomaticInvocation", ignore = true)
	@Mapping(target = "isCancelPending", ignore = true)
	@Mapping(target = "lcmOperationType", source = "operation")
	@Mapping(target = "nsInstanceId", source = "nsInstance.id")
	@Mapping(target = "operationState", source = "operationStatus")
	@Mapping(target = "resourceChanges", ignore = true)
	@Mapping(target = "links", ignore = true)
	@Mapping(target = "operationParams", ignore = true)
	NsLcmOpOcc map(NsBlueprint o);

	@ValueMapping(source = "CHANGE_EXTERNAL_VNF_CONNECTIVITY", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "CHANGE_EXT_CONN", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "CHANGE_FLAVOUR", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "CHANGE_VNFPKG", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "CREATE_SNAPSHOT", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "MODIFY_INFO", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "MODIFY_INFORMATION", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "OPERATE", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "REVERT_TO_SNAPSHOT", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "SCALE_TO_LEVEL", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "SELECT_DEPL_MODS", target = MappingConstants.THROW_EXCEPTION)
	NsLcmOpType map(PlanOperationType o);

	@ValueMapping(source = "STARTED", target = "PROCESSING")
	@ValueMapping(source = "STARTING", target = "PROCESSING")
	@ValueMapping(source = "SUCCESS", target = "COMPLETED")
	@ValueMapping(source = "PARTIALLY_COMPLETED", target = "FAILED_TEMP")
	NsLcmOperationStateType map(OperationStatusType o);

	@Mapping(target = "stateEnteredTime", ignore = true)
	@Mapping(target = "lcmCoordinations", ignore = true)
	@Mapping(target = "rejectedLcmCoordinations", ignore = true)
	@Mapping(target = "warnings", ignore = true)
	@Mapping(target = "additionalParams", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "automaticInvocation", ignore = true)
	@Mapping(target = "cancelPending", ignore = true)
	@Mapping(target = "cirConnectionInfo", ignore = true)
	@Mapping(target = "mciopConnectionInfo", ignore = true)
	@Mapping(target = "operation", ignore = true)
	@Mapping(target = "operationStatus", ignore = true)
	@Mapping(target = "tenantId", ignore = true)
	@Mapping(target = "extManagedVirtualLinks", ignore = true)
	@Mapping(target = "grantsRequestId", ignore = true)
	@Mapping(target = "nsFlavourId", ignore = true)
	@Mapping(target = "nsInstance.id", source = "nsInstanceId")
	@Mapping(target = "nsInstantiationLevelId", ignore = true)
	@Mapping(target = "parameters", ignore = true)
	@Mapping(target = "tasks", ignore = true)
	@Mapping(target = "vimConnections", ignore = true)
	@Mapping(target = "zoneGroups", ignore = true)
	@Mapping(target = "zones", ignore = true)
	NsBlueprint map(NsLcmOpOcc o);

}
