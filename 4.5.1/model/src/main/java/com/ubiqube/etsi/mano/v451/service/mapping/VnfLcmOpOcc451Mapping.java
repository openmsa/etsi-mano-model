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
package com.ubiqube.etsi.mano.v451.service.mapping;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;

import com.ubiqube.etsi.mano.dao.mano.ChangeType;
import com.ubiqube.etsi.mano.dao.mano.ExtLinkPortInfoEntity;
import com.ubiqube.etsi.mano.dao.mano.ExtVirtualLinkInfoEntity;
import com.ubiqube.etsi.mano.dao.mano.NetAttDefResourceInfo;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfInstantiatedCompute;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfInstantiatedExtLinkPort;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfInstantiatedStorage;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfInstantiatedVirtualLink;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfLcmResourceChanges;
import com.ubiqube.etsi.mano.dao.mano.v2.AffectedVipCp;
import com.ubiqube.etsi.mano.dao.mano.v2.PlanOperationType;
import com.ubiqube.etsi.mano.dao.mano.v2.VnfBlueprint;
import com.ubiqube.etsi.mano.dao.mano.vim.VimConnectionInformation;
import com.ubiqube.etsi.mano.dao.mano.vnfm.RejectedLcmCoordination;
import com.ubiqube.etsi.mano.dao.mano.vnfm.VnfLcmCoordination;
import com.ubiqube.etsi.mano.service.mapping.StringToUriMapping;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.AffectedExtLinkPort;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.AffectedVirtualLink;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.AffectedVirtualStorage;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.AffectedVnfc;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.ExtLinkPortInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.ExtVirtualLinkInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.LcmOperationType;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VnfInfoModifications;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VnfLcmOpOcc;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VnfLcmOpOccLcmCoordinations;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VnfLcmOpOccRejectedLcmCoordinations;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VnfLcmOpOccResourceChanges;
import com.ubiqube.etsi.mano.v451.model.nfvo.vnflcm.VimConnectionInfo;

import jakarta.annotation.Nullable;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VnfLcmOpOcc451Mapping extends StringToUriMapping, Connectivity451Mapping, VimConnectionInfo451Mapping {

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

	@Nullable
	default Set<RejectedLcmCoordination> mapToRejectedLcmCoordination(final @Nullable VnfLcmOpOccRejectedLcmCoordinations value) {
		if (null == value) {
			return null;
		}
		return Set.of(map(value));
	}

	@Nullable
	default Set<VnfLcmCoordination> mapToVnfLcmCoordination(final @Nullable VnfLcmOpOccLcmCoordinations value) {
		if (null == value) {
			return null;
		}
		return Set.of(map(value));
	}

	VnfLcmCoordination map(VnfLcmOpOccLcmCoordinations value);

	@Mapping(target = "id", ignore = true)
	AffectedVipCp map(com.ubiqube.etsi.mano.v451.model.em.vnflcm.AffectedVipCp o);

	@Mapping(target = "audit", ignore = true)
	ExtVirtualLinkInfoEntity map(ExtVirtualLinkInfo o);

	@Mapping(target = "audit", ignore = true)
	ExtLinkPortInfoEntity map(ExtLinkPortInfo o);

	@Mapping(target = "vimConnectionInfo", ignore = true)
	@Mapping(target = "id", ignore = true)
	com.ubiqube.etsi.mano.dao.mano.v2.VnfInfoModifications map(VnfInfoModifications o);

	@Nullable
	default Map<String, VimConnectionInformation> mapToMapVimConnectionInformation(final @Nullable List<VimConnectionInfo> value) {
		if (null == value) {
			return Map.of();
		}
		return value.stream().map(this::map).collect(Collectors.toMap(x -> x.getVimId(), x -> x));
	}

	@Mapping(target = "id", ignore = true)
	NetAttDefResourceInfo map(com.ubiqube.etsi.mano.v451.model.em.vnflcm.NetAttDefResourceInfo o);

	@Mapping(target = "id", ignore = true)
	RejectedLcmCoordination map(VnfLcmOpOccRejectedLcmCoordinations o);

	@Mapping(target = "affectedExtCp", ignore = true)
	@Mapping(target = "dnsZones", ignore = true)
	@Mapping(target = "instanceMonitors", ignore = true)
	VnfLcmResourceChanges map(VnfLcmOpOccResourceChanges o);

	PlanOperationType map(LcmOperationType operation);

	@Mapping(target = "resourceHandle.vimConnectionId", source = "vimConnectionInformation.vimId")
	@Mapping(target = "resourceHandle.resourceProviderId", source = "resourceProviderId")
	@Mapping(target = "resourceHandle.resourceId", source = "resourceId")
	@Mapping(target = "resourceHandle.vimLevelResourceType", source = "vimLevelResourceType")
	@Mapping(target = "resourceHandle.vimLevelAdditionalResourceInfo", source = "vimLevelAdditionalResourceInfo")
	@Mapping(target = "resourceHandle.containerNamespace", source = "containerNamespace")
	AffectedExtLinkPort map(VnfInstantiatedExtLinkPort o);

	@Mapping(target = "aliasName", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "containerNamespace", source = "resourceHandle.containerNamespace")
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
	@Mapping(target = "vimLevelAdditionalResourceInfo", source = "resourceHandle.vimLevelAdditionalResourceInfo")
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

	@Mapping(target = "computeResource.resourceId", source = "resourceId")
	@Mapping(target = "computeResource.resourceProviderId", source = "resourceProviderId")
	@Mapping(target = "computeResource.vimLevelResourceType", source = "vimLevelResourceType")
	@Mapping(target = "computeResource.vimConnectionId", source = "vimConnectionInformation.vimId")
	@Mapping(target = "computeResource.vimLevelAdditionalResourceInfo", source = "vimLevelAdditionalResourceInfo")
	@Mapping(target = "computeResource.containerNamespace", source = "containerNamespace")
	AffectedVnfc map(VnfInstantiatedCompute o);

	@Mapping(target = "aliasName", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "containerNamespace", source = "computeResource.containerNamespace")
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
	@Mapping(target = "vimLevelAdditionalResourceInfo", source = "computeResource.vimLevelAdditionalResourceInfo")
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

	@Mapping(target = "storageResource.vimConnectionId", source = "vimConnectionInformation.vimId")
	@Mapping(target = "storageResource.resourceProviderId", source = "resourceProviderId")
	@Mapping(target = "storageResource.resourceId", source = "resourceId")
	@Mapping(target = "storageResource.vimLevelAdditionalResourceInfo", source = "vimLevelAdditionalResourceInfo")
	@Mapping(target = "storageResource.containerNamespace", source = "containerNamespace")
	@Mapping(target = "storageResource.vimLevelResourceType", source = "vimLevelResourceType")
	AffectedVirtualStorage map(VnfInstantiatedStorage o);

	@Mapping(target = "aliasName", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "containerNamespace", source = "storageResource.containerNamespace")
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
	@Mapping(target = "vimLevelAdditionalResourceInfo", source = "storageResource.vimLevelAdditionalResourceInfo")
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

	@Mapping(target = "vnfVirtualLinkDescId", source = "manoResourceId")
	@Mapping(target = "networkResource.resourceId", source = "resourceId")
	@Mapping(target = "networkResource.resourceProviderId", source = "resourceProviderId")
	@Mapping(target = "networkResource.vimLevelResourceType", source = "vimLevelResourceType")
	@Mapping(target = "networkResource.vimConnectionId", source = "vimConnectionInformation.id")
	@Mapping(target = "networkResource.vimLevelAdditionalResourceInfo", source = "vimLevelAdditionalResourceInfo")
	@Mapping(target = "networkResource.containerNamespace", source = "containerNamespace")
	AffectedVirtualLink map(VnfInstantiatedVirtualLink o);

	@Mapping(target = "virtualLinkDescId", source = "vnfVirtualLinkDescId")
	@Mapping(target = "aliasName", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "containerNamespace", source = "networkResource.containerNamespace")
	@Mapping(target = "endTime", ignore = true)
	@Mapping(target = "manoResourceId", source = "vnfVirtualLinkDescId")
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
	@Mapping(target = "vimLevelAdditionalResourceInfo", source = "networkResource.vimLevelAdditionalResourceInfo")
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

	@ValueMapping(source = "LINK_PORT_ADDED", target = "ADDED")
	@ValueMapping(source = "LINK_PORT_REMOVED", target = "REMOVED")
	AffectedVnfc.ChangeTypeEnum mapAffectedVnfc(ChangeType o);

	@ValueMapping(source = "LINK_PORT_ADDED", target = "ADDED")
	@ValueMapping(source = "LINK_PORT_REMOVED", target = "REMOVED")
	@ValueMapping(source = "TEMPORARY", target = MappingConstants.THROW_EXCEPTION)
	AffectedExtLinkPort.ChangeTypeEnum mapAffectedExtLinkPort(ChangeType o);

	@ValueMapping(source = "LINK_PORT_ADDED", target = "ADDED")
	@ValueMapping(source = "LINK_PORT_REMOVED", target = "REMOVED")
	AffectedVirtualStorage.ChangeTypeEnum mapAffectedVirtualStorage(ChangeType o);

	@ValueMapping(source = "CHANGE_EXTERNAL_VNF_CONNECTIVITY", target = "CHANGE_EXT_CONN")
	@ValueMapping(source = "MODIFY_INFORMATION", target = "MODIFY_INFO")
	@ValueMapping(source = "UPDATE", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "SELECT_DEPL_MODS", target = MappingConstants.THROW_EXCEPTION)
	LcmOperationType map(PlanOperationType o);

}
