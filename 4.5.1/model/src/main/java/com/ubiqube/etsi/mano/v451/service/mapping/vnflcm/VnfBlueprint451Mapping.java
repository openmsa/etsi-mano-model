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
package com.ubiqube.etsi.mano.v451.service.mapping.vnflcm;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;

import com.ubiqube.etsi.mano.dao.mano.ChangeType;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfInstantiatedCompute;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfInstantiatedExtLinkPort;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfInstantiatedStorage;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfInstantiatedVirtualLink;
import com.ubiqube.etsi.mano.dao.mano.v2.PlanOperationType;
import com.ubiqube.etsi.mano.dao.mano.v2.VnfBlueprint;
import com.ubiqube.etsi.mano.service.mapping.StringToUriMapping;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.AffectedExtLinkPort;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.AffectedVirtualLink;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.AffectedVirtualStorage;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.AffectedVnfc;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.LcmOperationType;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VnfLcmOpOcc;
import com.ubiqube.etsi.mano.v451.service.mapping.Connectivity451Mapping;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VnfBlueprint451Mapping extends StringToUriMapping, Connectivity451Mapping {

	@Mapping(target = "links", ignore = true)
	@Mapping(target = "operationState", ignore = true)
	@Mapping(target = "vnfInstanceId", ignore = true)
	VnfLcmOpOcc map(VnfBlueprint x);

	@Mapping(target = "resourceHandle.vimConnectionId", source = "vimConnectionInformation.id")
	@Mapping(target = "resourceHandle.resourceProviderId", source = "resourceProviderId")
	@Mapping(target = "resourceHandle.resourceId", source = "resourceId")
	@Mapping(target = "resourceHandle.vimLevelResourceType", source = "vimLevelResourceType")
	@Mapping(target = "resourceHandle.vimLevelAdditionalResourceInfo", source = "vimLevelAdditionalResourceInfo")
	@Mapping(target = "resourceHandle.containerNamespace", source = "containerNamespace")
	AffectedExtLinkPort map(VnfInstantiatedExtLinkPort o);

	@Mapping(target = "networkResource.vimConnectionId", source = "vimConnectionInformation.id")
	@Mapping(target = "networkResource.resourceProviderId", source = "resourceProviderId")
	@Mapping(target = "networkResource.resourceId", source = "resourceId")
	@Mapping(target = "networkResource.vimLevelResourceType", source = "vimLevelResourceType")
	@Mapping(target = "networkResource.vimLevelAdditionalResourceInfo", source = "vimLevelAdditionalResourceInfo")
	@Mapping(target = "networkResource.containerNamespace", source = "containerNamespace")
	@Mapping(target = "vnfVirtualLinkDescId", ignore = true)
	AffectedVirtualLink map(VnfInstantiatedVirtualLink o);

	@Mapping(target = "computeResource.vimConnectionId", source = "vimConnectionInformation.id")
	@Mapping(target = "computeResource.resourceProviderId", source = "resourceProviderId")
	@Mapping(target = "computeResource.resourceId", source = "resourceId")
	@Mapping(target = "computeResource.vimLevelResourceType", source = "vimLevelResourceType")
	@Mapping(target = "computeResource.vimLevelAdditionalResourceInfo", source = "vimLevelAdditionalResourceInfo")
	@Mapping(target = "computeResource.containerNamespace", source = "containerNamespace")
	AffectedVnfc map(VnfInstantiatedCompute o);

	@Mapping(target = "storageResource.vimConnectionId", source = "vimConnectionInformation.id")
	@Mapping(target = "storageResource.resourceProviderId", source = "resourceProviderId")
	@Mapping(target = "storageResource.resourceId", source = "resourceId")
	@Mapping(target = "storageResource.vimLevelResourceType", source = "vimLevelResourceType")
	@Mapping(target = "storageResource.vimLevelAdditionalResourceInfo", source = "vimLevelAdditionalResourceInfo")
	@Mapping(target = "storageResource.containerNamespace", source = "containerNamespace")
	AffectedVirtualStorage map(VnfInstantiatedStorage o);

	@ValueMapping(source = "LINK_PORT_ADDED", target = "ADDED")
	@ValueMapping(source = "LINK_PORT_REMOVED", target = "REMOVED")
	@ValueMapping(source = "TEMPORARY", target = MappingConstants.THROW_EXCEPTION)
	AffectedExtLinkPort.ChangeTypeEnum mapAffectedExtLinkPort(ChangeType o);

	@ValueMapping(source = "LINK_PORT_ADDED", target = "ADDED")
	@ValueMapping(source = "LINK_PORT_REMOVED", target = "REMOVED")
	AffectedVirtualStorage.ChangeTypeEnum mapToAffectedVirtualStorage(ChangeType o);

	@ValueMapping(source = "LINK_PORT_ADDED", target = "ADDED")
	@ValueMapping(source = "LINK_PORT_REMOVED", target = "REMOVED")
	AffectedVnfc.ChangeTypeEnum mapToAffectedVnfc(ChangeType o);

	@ValueMapping(source = "CHANGE_EXTERNAL_VNF_CONNECTIVITY", target = "CHANGE_EXT_CONN")
	@ValueMapping(source = "MODIFY_INFORMATION", target = "MODIFY_INFO")
	@ValueMapping(source = "UPDATE", target = MappingConstants.THROW_EXCEPTION)
	LcmOperationType map(PlanOperationType o);
}
