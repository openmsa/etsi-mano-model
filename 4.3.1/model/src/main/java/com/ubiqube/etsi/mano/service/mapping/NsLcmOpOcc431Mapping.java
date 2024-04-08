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
package com.ubiqube.etsi.mano.service.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;

import com.ubiqube.etsi.mano.dao.mano.v2.nfvo.NsBlueprint;
import com.ubiqube.etsi.mano.dao.mano.vnfm.EndpointType;
import com.ubiqube.etsi.mano.dao.mano.vnfm.RejectedLcmCoordination;
import com.ubiqube.etsi.mano.nfvo.v431.model.nslcm.NsLcmOpOcc;
import com.ubiqube.etsi.mano.nfvo.v431.model.nslcm.NsLcmOpOccLcmCoordinations;
import com.ubiqube.etsi.mano.nfvo.v431.model.nslcm.NsLcmOpOccRejectedLcmCoordinations;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface NsLcmOpOcc431Mapping extends StringToUri431Mapping {
	@Mapping(target = "isAutomaticInvocation", ignore = true)
	@Mapping(target = "isCancelPending", ignore = true)
	@Mapping(target = "lcmOperationType", ignore = true)
	@Mapping(target = "nsInstanceId", source = "nsInstance.id")
	@Mapping(target = "operationState", ignore = true)
	@Mapping(target = "resourceChanges", ignore = true)
	@Mapping(target = "links", ignore = true)
	@Mapping(target = "operationParams", ignore = true)
	NsLcmOpOcc map(NsBlueprint o);

	@ValueMapping(source = "VNF", target = MappingConstants.THROW_EXCEPTION)
	NsLcmOpOccRejectedLcmCoordinations.EndpointTypeEnum map(EndpointType o);

	@ValueMapping(source = "VNF", target = MappingConstants.THROW_EXCEPTION)
	NsLcmOpOccLcmCoordinations.EndpointTypeEnum mapToNsLcmOpOccLcmCoordinations(EndpointType o);

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

	@Mapping(target = "id", ignore = true)
	RejectedLcmCoordination map(NsLcmOpOccRejectedLcmCoordinations o);
}
