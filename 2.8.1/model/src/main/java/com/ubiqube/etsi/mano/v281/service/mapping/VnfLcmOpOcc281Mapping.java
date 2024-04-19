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
package com.ubiqube.etsi.mano.v281.service.mapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.dao.mano.ChangeType;
import com.ubiqube.etsi.mano.dao.mano.ExtLinkPortInfoEntity;
import com.ubiqube.etsi.mano.dao.mano.ExtVirtualLinkInfoEntity;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfInstantiatedCompute;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfInstantiatedExtLinkPort;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfInstantiatedStorage;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfInstantiatedVirtualLink;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfLcmResourceChanges;
import com.ubiqube.etsi.mano.dao.mano.v2.PlanOperationType;
import com.ubiqube.etsi.mano.dao.mano.v2.VnfBlueprint;
import com.ubiqube.etsi.mano.dao.mano.vim.VimConnectionInformation;
import com.ubiqube.etsi.mano.service.mapping.StringToUriMapping;
import com.ubiqube.etsi.mano.v281.model.em.vnflcm.AffectedExtLinkPort;
import com.ubiqube.etsi.mano.v281.model.em.vnflcm.AffectedVirtualLink;
import com.ubiqube.etsi.mano.v281.model.em.vnflcm.AffectedVirtualStorage;
import com.ubiqube.etsi.mano.v281.model.em.vnflcm.AffectedVnfc;
import com.ubiqube.etsi.mano.v281.model.em.vnflcm.ExtLinkPortInfo;
import com.ubiqube.etsi.mano.v281.model.em.vnflcm.ExtVirtualLinkInfo;
import com.ubiqube.etsi.mano.v281.model.em.vnflcm.LcmOperationType;
import com.ubiqube.etsi.mano.v281.model.em.vnflcm.VnfInfoModifications;
import com.ubiqube.etsi.mano.v281.model.em.vnflcm.VnfLcmOpOcc;
import com.ubiqube.etsi.mano.v281.model.em.vnflcm.VnfLcmOpOccResourceChanges;
import com.ubiqube.etsi.mano.v281.model.vnfm.grant.VimConnectionInfo;

import jakarta.annotation.Nullable;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VnfLcmOpOcc281Mapping extends StringToUriMapping, Connectivity281Mapping, VimConnectionInfo281Mapping, VimResource281Mapping {

	@Mapping(target = "modificationsTriggeredByVnfPkgChange", ignore = true)
	@Mapping(target = "vnfSnapshotInfoId", ignore = true)
	@Mapping(target = "affectedVipCps", ignore = true)
	@Mapping(target = "lcmCoordinations", ignore = true)
	@Mapping(target = "rejectedLcmCoordinations", ignore = true)
	@Mapping(target = "warnings", ignore = true)
	@Mapping(target = "additionalParams", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "automaticInvocation", source = "isAutomaticInvocation")
	@Mapping(target = "cancelPending", source = "isCancelPending")
	@Mapping(target = "cirConnectionInfo", ignore = true)
	@Mapping(target = "mciopConnectionInfo", ignore = true)
	@Mapping(target = "operationStatus", source = "operationState")
	@Mapping(target = "tenantId", ignore = true)
	@Mapping(target = "changeExtVnfConnRequest", ignore = true)
	@Mapping(target = "grantsRequestId", source = "grantId")
	@Mapping(target = "healCause", ignore = true)
	@Mapping(target = "operateChanges", ignore = true)
	@Mapping(target = "parameters", ignore = true)
//	@Mapping(target = "parameters", source = "operationParams")
	@Mapping(target = "tasks", ignore = true)
	@Mapping(target = "vimConnections", ignore = true)
	@Mapping(target = "vnfInstance.id", source = "vnfInstanceId")
	@Mapping(target = "zoneGroups", ignore = true)
	@Mapping(target = "zones", ignore = true)
	VnfBlueprint map(VnfLcmOpOcc lcm);

	@Mapping(target = "currentVnfExtCpData", ignore = true)
	@Mapping(target = "extNetAttDefResource", ignore = true)
	@Mapping(target = "audit", ignore = true)
	ExtVirtualLinkInfoEntity map(ExtVirtualLinkInfo o);

	@Mapping(target = "secondaryCpInstanceId", ignore = true)
	@Mapping(target = "trunkResourceId", ignore = true)
	@Mapping(target = "audit", ignore = true)
	ExtLinkPortInfoEntity map(ExtLinkPortInfo o);

	@Mapping(target = "vimConnectionInfo", ignore = true)
	@Mapping(target = "vnfcInfoModifications", ignore = true)
	@Mapping(target = "id", ignore = true)
	com.ubiqube.etsi.mano.dao.mano.v2.VnfInfoModifications map(VnfInfoModifications o);

	@Nullable
	default Map<String, VimConnectionInformation> mapToMapVimConnectionInformation(final @Nullable List<VimConnectionInfo> value) {
		if (null == value) {
			return Map.of();
		}
		return value.stream().map(this::map).collect(Collectors.toMap(x -> x.getVimId(), x -> x));
	}

	@Mapping(target = "affectedExtCp", ignore = true)
	@Mapping(target = "dnsZones", ignore = true)
	@Mapping(target = "instanceMonitors", ignore = true)
	VnfLcmResourceChanges map(VnfLcmOpOccResourceChanges o);

	PlanOperationType map(LcmOperationType operation);

	@Mapping(target = "containerNamespace", ignore = true)
	@Mapping(target = "vimLevelAdditionalResourceInfo", ignore = true)
	@Mapping(target = "aliasName", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "endTime", ignore = true)
	@Mapping(target = "instantiationLevel", ignore = true)
	@Mapping(target = "manoResourceId", ignore = true)
	@Mapping(target = "metadata", ignore = true)
	@Mapping(target = "removedInstantiated", ignore = true)
	@Mapping(target = "reservationId", ignore = true)
	@Mapping(target = "resourceDefinitionId", ignore = true)
	@Mapping(target = "resourceGroupId", ignore = true)
	@Mapping(target = "resourceId", source = "resourceHandle.resourceId")
	@Mapping(target = "resourceProviderId", source = "resourceHandle.resourceProviderId")
	@Mapping(target = "startTime", ignore = true)
	@Mapping(target = "status", ignore = true)
	@Mapping(target = "toscaName", ignore = true)
	@Mapping(target = "vduId", ignore = true)
	@Mapping(target = "vimConnectionInformation.vimId", source = "resourceHandle.vimConnectionId")
	@Mapping(target = "vimLevelResourceType", source = "resourceHandle.vimLevelResourceType")
	@Mapping(target = "vnfLcmOpOccs", ignore = true)
	@Mapping(target = "vnfdId", ignore = true)
	@Mapping(target = "zoneId", ignore = true)
	@Mapping(target = "vimConnectionInformation.accessInfo", ignore = true)
	@Mapping(target = "vimConnectionInformation.audit", ignore = true)
	@Mapping(target = "vimConnectionInformation.cnfInfo", ignore = true)
	@Mapping(target = "vimConnectionInformation.extra", ignore = true)
	@Mapping(target = "vimConnectionInformation.interfaceInfo", ignore = true)
	@Mapping(target = "vimConnectionInformation.jujuInfo", ignore = true)
	@Mapping(target = "vimConnectionInformation.tenantId", ignore = true)
	@Mapping(target = "vimConnectionInformation.version", ignore = true)
	@Mapping(target = "vimConnectionInformation.vimCapabilities", ignore = true)
	@Mapping(target = "vimConnectionInformation.vimType", ignore = true)
	@Mapping(target = "vimConnectionInformation.id", ignore = true)
	VnfInstantiatedExtLinkPort map(AffectedExtLinkPort o);

	@Mapping(target = "vnfdId", ignore = true)
	@Mapping(target = "containerNamespace", ignore = true)
	@Mapping(target = "aliasName", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "endTime", ignore = true)
	@Mapping(target = "instantiationLevel", ignore = true)
	@Mapping(target = "manoResourceId", ignore = true)
	@Mapping(target = "removedInstantiated", ignore = true)
	@Mapping(target = "reservationId", ignore = true)
	@Mapping(target = "resourceDefinitionId", ignore = true)
	@Mapping(target = "resourceGroupId", ignore = true)
	@Mapping(target = "resourceId", source = "computeResource.resourceId")
	@Mapping(target = "resourceProviderId", source = "computeResource.resourceProviderId")
	@Mapping(target = "startTime", ignore = true)
	@Mapping(target = "status", ignore = true)
	@Mapping(target = "toscaName", ignore = true)
	@Mapping(target = "vimConnectionInformation.vimId", source = "computeResource.vimConnectionId")
	@Mapping(target = "vimLevelAdditionalResourceInfo", ignore = true)
	@Mapping(target = "vimLevelResourceType", source = "computeResource.vimLevelResourceType")
	@Mapping(target = "vnfLcmOpOccs", ignore = true)
	@Mapping(target = "zoneId", ignore = true)
	@Mapping(target = "flavorId", ignore = true)
	@Mapping(target = "imageId", ignore = true)
	@Mapping(target = "storageResourceIds", ignore = true)
	@Mapping(target = "vnfcCpInfo", ignore = true)
	@Mapping(target = "vimConnectionInformation.accessInfo", ignore = true)
	@Mapping(target = "vimConnectionInformation.audit", ignore = true)
	@Mapping(target = "vimConnectionInformation.cnfInfo", ignore = true)
	@Mapping(target = "vimConnectionInformation.extra", ignore = true)
	@Mapping(target = "vimConnectionInformation.interfaceInfo", ignore = true)
	@Mapping(target = "vimConnectionInformation.jujuInfo", ignore = true)
	@Mapping(target = "vimConnectionInformation.tenantId", ignore = true)
	@Mapping(target = "vimConnectionInformation.version", ignore = true)
	@Mapping(target = "vimConnectionInformation.vimCapabilities", ignore = true)
	@Mapping(target = "vimConnectionInformation.vimType", ignore = true)
	@Mapping(target = "vimConnectionInformation.id", ignore = true)
	VnfInstantiatedCompute map(AffectedVnfc o);

	@Mapping(target = "vnfdId", ignore = true)
	@Mapping(target = "aliasName", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "containerNamespace", ignore = true)
	@Mapping(target = "endTime", ignore = true)
	@Mapping(target = "instantiationLevel", ignore = true)
	@Mapping(target = "manoResourceId", ignore = true)
	@Mapping(target = "removedInstantiated", ignore = true)
	@Mapping(target = "reservationId", ignore = true)
	@Mapping(target = "resourceDefinitionId", ignore = true)
	@Mapping(target = "resourceGroupId", ignore = true)
	@Mapping(target = "resourceId", source = "storageResource.resourceId")
	@Mapping(target = "resourceProviderId", source = "storageResource.resourceProviderId")
	@Mapping(target = "startTime", ignore = true)
	@Mapping(target = "status", ignore = true)
	@Mapping(target = "toscaName", source = "id")
	@Mapping(target = "vduId", ignore = true)
	@Mapping(target = "vimConnectionInformation.vimId", source = "storageResource.vimConnectionId")
	@Mapping(target = "vimLevelAdditionalResourceInfo", ignore = true)
	@Mapping(target = "vimLevelResourceType", source = "storageResource.vimLevelResourceType")
	@Mapping(target = "vnfLcmOpOccs", ignore = true)
	@Mapping(target = "zoneId", ignore = true)
	@Mapping(target = "vimConnectionInformation.accessInfo", ignore = true)
	@Mapping(target = "vimConnectionInformation.audit", ignore = true)
	@Mapping(target = "vimConnectionInformation.cnfInfo", ignore = true)
	@Mapping(target = "vimConnectionInformation.extra", ignore = true)
	@Mapping(target = "vimConnectionInformation.interfaceInfo", ignore = true)
	@Mapping(target = "vimConnectionInformation.jujuInfo", ignore = true)
	@Mapping(target = "vimConnectionInformation.tenantId", ignore = true)
	@Mapping(target = "vimConnectionInformation.version", ignore = true)
	@Mapping(target = "vimConnectionInformation.vimCapabilities", ignore = true)
	@Mapping(target = "vimConnectionInformation.vimType", ignore = true)
	@Mapping(target = "vimConnectionInformation.id", ignore = true)
	VnfInstantiatedStorage map(AffectedVirtualStorage o);

	@Mapping(target = "vnfdId", ignore = true)
	@Mapping(target = "vnfLinkPortIds", ignore = true)
	@Mapping(target = "virtualLinkDescId", source = "vnfVirtualLinkDescId")
	@Mapping(target = "aliasName", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "containerNamespace", ignore = true)
	@Mapping(target = "endTime", ignore = true)
	@Mapping(target = "manoResourceId", ignore = true)
	@Mapping(target = "removedInstantiated", ignore = true)
	@Mapping(target = "reservationId", ignore = true)
	@Mapping(target = "resourceDefinitionId", ignore = true)
	@Mapping(target = "resourceGroupId", ignore = true)
	@Mapping(target = "resourceId", source = "networkResource.resourceId")
	@Mapping(target = "resourceProviderId", source = "networkResource.resourceProviderId")
	@Mapping(target = "startTime", ignore = true)
	@Mapping(target = "status", ignore = true)
	@Mapping(target = "toscaName", ignore = true)
	@Mapping(target = "vduId", ignore = true)
	@Mapping(target = "vimConnectionInformation.id", source = "networkResource.vimConnectionId")
	@Mapping(target = "vimLevelAdditionalResourceInfo", ignore = true)
	@Mapping(target = "vimLevelResourceType", source = "networkResource.vimLevelResourceType")
	@Mapping(target = "vnfLcmOpOccs", ignore = true)
	@Mapping(target = "zoneId", ignore = true)
	@Mapping(target = "instantiationLevel", ignore = true)
	@Mapping(target = "vimConnectionInformation.accessInfo", ignore = true)
	@Mapping(target = "vimConnectionInformation.audit", ignore = true)
	@Mapping(target = "vimConnectionInformation.cnfInfo", ignore = true)
	@Mapping(target = "vimConnectionInformation.extra", ignore = true)
	@Mapping(target = "vimConnectionInformation.interfaceInfo", ignore = true)
	@Mapping(target = "vimConnectionInformation.jujuInfo", ignore = true)
	@Mapping(target = "vimConnectionInformation.tenantId", ignore = true)
	@Mapping(target = "vimConnectionInformation.version", ignore = true)
	@Mapping(target = "vimConnectionInformation.vimCapabilities", ignore = true)
	@Mapping(target = "vimConnectionInformation.vimType", ignore = true)
	@Mapping(target = "vimConnectionInformation.vimId", source = "networkResource.vimConnectionId")
	VnfInstantiatedVirtualLink map(AffectedVirtualLink o);

	ChangeType map(AffectedVnfc.ChangeTypeEnum en);

}
