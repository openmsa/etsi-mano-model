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
package com.ubiqube.etsi.mano.v431.service.mapping.vnflcm;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;

import com.ubiqube.etsi.mano.dao.mano.ChangeType;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfInstantiatedCompute;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfInstantiatedExtLinkPort;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfInstantiatedStorage;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfInstantiatedVirtualLink;
import com.ubiqube.etsi.mano.dao.mano.v2.OperationStatusType;
import com.ubiqube.etsi.mano.dao.mano.v2.PlanOperationType;
import com.ubiqube.etsi.mano.dao.mano.v2.VnfBlueprint;
import com.ubiqube.etsi.mano.dao.mano.vim.VimConnectionInformation;
import com.ubiqube.etsi.mano.dao.mano.vnfm.RejectedLcmCoordination;
import com.ubiqube.etsi.mano.dao.mano.vnfm.VnfLcmCoordination;
import com.ubiqube.etsi.mano.dao.mano.vnfm.VnfPkgChange;
import com.ubiqube.etsi.mano.service.mapping.StringToUriMapping;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.AffectedExtLinkPort;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.AffectedVirtualLink;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.AffectedVirtualStorage;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.AffectedVnfc;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.LcmOperationStateType;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.LcmOperationType;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.ModificationsTriggeredByVnfPkgChange;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.VimConnectionInfo;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.VnfLcmOpOcc;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.VnfLcmOpOccLcmCoordinations;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.VnfLcmOpOccRejectedLcmCoordinations;
import com.ubiqube.etsi.mano.v431.service.mapping.Connectivity431Mapping;
import com.ubiqube.etsi.mano.v431.service.mapping.VimConnectionInfo431Mapping;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VnfBlueprint431Mapping extends StringToUriMapping, Connectivity431Mapping, VimConnectionInfo431Mapping {

	@Mapping(target = "operationState", source = "operationStatus")
	@Mapping(target = "links", ignore = true)
	@Mapping(target = "vnfInstanceId", source = "vnfInstance.id")
	VnfLcmOpOcc map(VnfBlueprint x);

	default List<VimConnectionInfo> mapListOfVimConn(final Map<String, VimConnectionInformation> o) {
		if (null == o) {
			return List.of();
		}
		return o.values().stream().map(this::map).toList();
	}

	@Mapping(target = "vimConnectionInfo", ignore = true)
	ModificationsTriggeredByVnfPkgChange map(VnfPkgChange o);

	default VnfLcmOpOccLcmCoordinations mapToVnfLcmOpOccLcmCoordinations(final Set<VnfLcmCoordination> value) {
		if ((null == value) || value.isEmpty()) {
			return null;
		}
		return map(value.iterator().next());
	}

	VnfLcmOpOccLcmCoordinations map(VnfLcmCoordination next);

	default VnfLcmOpOccRejectedLcmCoordinations mapToVnfLcmOpOccRejectedLcmCoordinations(final Set<RejectedLcmCoordination> value) {
		if ((null == value) || value.isEmpty()) {
			return null;
		}
		return map(value.iterator().next());
	}

	VnfLcmOpOccRejectedLcmCoordinations map(RejectedLcmCoordination next);

	@ValueMapping(source = "PARTIALLY_COMPLETED", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "STARTED", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "SUCCESS", target = MappingConstants.THROW_EXCEPTION)
	LcmOperationStateType map(OperationStatusType o);

	@Mapping(target = "resourceHandle.vimConnectionId", source = "vimConnectionInformation.vimId")
	@Mapping(target = "resourceHandle.resourceProviderId", source = "resourceProviderId")
	@Mapping(target = "resourceHandle.resourceId", source = "resourceId")
	@Mapping(target = "resourceHandle.vimLevelResourceType", source = "vimLevelResourceType")
	@Mapping(target = "resourceHandle.vimLevelAdditionalResourceInfo", source = "vimLevelAdditionalResourceInfo")
	@Mapping(target = "resourceHandle.containerNamespace", source = "containerNamespace")
	AffectedExtLinkPort map(VnfInstantiatedExtLinkPort o);

	@Mapping(target = "networkResource.vimConnectionId", source = "vimConnectionInformation.vimId")
	@Mapping(target = "networkResource.resourceProviderId", source = "resourceProviderId")
	@Mapping(target = "networkResource.resourceId", source = "resourceId")
	@Mapping(target = "networkResource.vimLevelResourceType", source = "vimLevelResourceType")
	@Mapping(target = "networkResource.vimLevelAdditionalResourceInfo", source = "vimLevelAdditionalResourceInfo")
	@Mapping(target = "networkResource.containerNamespace", source = "containerNamespace")
	@Mapping(target = "vnfVirtualLinkDescId", source = "virtualLinkDescId")
	AffectedVirtualLink map(VnfInstantiatedVirtualLink o);

	@Mapping(target = "computeResource.vimConnectionId", source = "vimConnectionInformation.vimId")
	@Mapping(target = "computeResource.resourceProviderId", source = "resourceProviderId")
	@Mapping(target = "computeResource.resourceId", source = "resourceId")
	@Mapping(target = "computeResource.vimLevelAdditionalResourceInfo", source = "vimLevelAdditionalResourceInfo")
	@Mapping(target = "computeResource.containerNamespace", source = "containerNamespace")
	@Mapping(target = "computeResource.vimLevelResourceType", source = "vimLevelResourceType")
	AffectedVnfc map(VnfInstantiatedCompute o);

	@Mapping(target = "storageResource.vimConnectionId", source = "vimConnectionInformation.vimId")
	@Mapping(target = "storageResource.resourceProviderId", source = "resourceProviderId")
	@Mapping(target = "storageResource.resourceId", source = "resourceId")
	@Mapping(target = "storageResource.vimLevelResourceType", source = "vimLevelResourceType")
	@Mapping(target = "storageResource.vimLevelAdditionalResourceInfo", source = "vimLevelAdditionalResourceInfo")
	@Mapping(target = "storageResource.containerNamespace", source = "containerNamespace")
	AffectedVirtualStorage map(VnfInstantiatedStorage o);

	@ValueMapping(source = "LINK_PORT_ADDED", target = "ADDED")
	@ValueMapping(source = "LINK_PORT_REMOVED", target = "REMOVED")
	AffectedVnfc.ChangeTypeEnum mapToAffectedVnfc(ChangeType o);

	@ValueMapping(source = "LINK_PORT_ADDED", target = "ADDED")
	@ValueMapping(source = "LINK_PORT_REMOVED", target = "REMOVED")
	@ValueMapping(source = "TEMPORARY", target = MappingConstants.THROW_EXCEPTION)
	AffectedExtLinkPort.ChangeTypeEnum mapAffectedExtLinkPort(ChangeType o);

	@ValueMapping(source = "LINK_PORT_ADDED", target = "ADDED")
	@ValueMapping(source = "LINK_PORT_REMOVED", target = "REMOVED")
	AffectedVirtualStorage.ChangeTypeEnum mapToAffectedVirtualStorage(ChangeType o);

	@ValueMapping(source = "CHANGE_EXTERNAL_VNF_CONNECTIVITY", target = "CHANGE_EXT_CONN")
	@ValueMapping(source = "MODIFY_INFORMATION", target = "MODIFY_INFO")
	@ValueMapping(source = "UPDATE", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "SELECT_DEPL_MODS", target = MappingConstants.THROW_EXCEPTION)
	LcmOperationType map(PlanOperationType o);

}
