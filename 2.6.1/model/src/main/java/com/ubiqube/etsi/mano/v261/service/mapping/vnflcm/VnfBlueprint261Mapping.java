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
package com.ubiqube.etsi.mano.v261.service.mapping.vnflcm;

import java.util.List;
import java.util.Map;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;

import com.ubiqube.etsi.mano.common.v261.model.VimConnectionInfo;
import com.ubiqube.etsi.mano.common.v261.model.nslcm.ChangeTypeEnum;
import com.ubiqube.etsi.mano.common.v261.model.nslcm.LcmOperationStateType;
import com.ubiqube.etsi.mano.common.v261.model.nslcm.LcmOperationType;
import com.ubiqube.etsi.mano.dao.mano.ChangeType;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfInstantiatedCompute;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfInstantiatedStorage;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfInstantiatedVirtualLink;
import com.ubiqube.etsi.mano.dao.mano.v2.OperationStatusType;
import com.ubiqube.etsi.mano.dao.mano.v2.PlanOperationType;
import com.ubiqube.etsi.mano.dao.mano.v2.VnfBlueprint;
import com.ubiqube.etsi.mano.dao.mano.vim.VimConnectionInformation;
import com.ubiqube.etsi.mano.service.mapping.StringToUriMapping;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.AffectedVirtualLink;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.AffectedVirtualStorage;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.AffectedVnfc;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.VnfInfoModifications;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.VnfLcmOpOcc;
import com.ubiqube.etsi.mano.v261.service.mapping.Connectivity261Mapping;
import com.ubiqube.etsi.mano.v261.service.mapping.VimConnectionInfo261Mapping;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VnfBlueprint261Mapping extends StringToUriMapping, Connectivity261Mapping, VimConnectionInfo261Mapping {

	@Mapping(target = "operationState", source = "operationStatus")
	@Mapping(target = "links", ignore = true)
	@Mapping(target = "vnfInstanceId", source = "vnfInstance.id")
	VnfLcmOpOcc map(VnfBlueprint x);

	@Mapping(target = "vnfPkgId", ignore = true)
	VnfInfoModifications map(com.ubiqube.etsi.mano.dao.mano.v2.VnfInfoModifications o);

	default List<VimConnectionInfo> mapListOfVimConn(final Map<String, VimConnectionInformation> o) {
		if (null == o) {
			return List.of();
		}
		return o.values().stream().map(this::map).toList();
	}

	@ValueMapping(source = "STARTED", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "SUCCESS", target = MappingConstants.THROW_EXCEPTION)
	LcmOperationStateType map(OperationStatusType o);

	@Mapping(target = "networkResource.vimConnectionId", source = "vimConnectionInformation.vimId")
	@Mapping(target = "networkResource.resourceProviderId", source = "resourceProviderId")
	@Mapping(target = "networkResource.resourceId", source = "resourceId")
	@Mapping(target = "networkResource.vimLevelResourceType", source = "vimLevelResourceType")
	@Mapping(target = "virtualLinkDescId", source = "virtualLinkDescId")
	AffectedVirtualLink map(VnfInstantiatedVirtualLink o);

	@Mapping(target = "computeResource.vimConnectionId", source = "vimConnectionInformation.vimId")
	@Mapping(target = "computeResource.resourceProviderId", source = "resourceProviderId")
	@Mapping(target = "computeResource.resourceId", source = "resourceId")
	@Mapping(target = "computeResource.vimLevelResourceType", source = "vimLevelResourceType")
	AffectedVnfc map(VnfInstantiatedCompute o);

	@Mapping(target = "storageResource.vimConnectionId", source = "vimConnectionInformation.vimId")
	@Mapping(target = "storageResource.resourceProviderId", source = "resourceProviderId")
	@Mapping(target = "storageResource.resourceId", source = "resourceId")
	@Mapping(target = "storageResource.vimLevelResourceType", source = "vimLevelResourceType")
	AffectedVirtualStorage map(VnfInstantiatedStorage o);

	@ValueMapping(source = "LINK_PORT_ADDED", target = "ADDED")
	@ValueMapping(source = "LINK_PORT_REMOVED", target = "REMOVED")
	AffectedVnfc.ChangeTypeEnum mapToAffectedVnfc(ChangeType o);

	@ValueMapping(source = "LINK_PORT_ADDED", target = "ADDED")
	@ValueMapping(source = "LINK_PORT_REMOVED", target = "REMOVED")
	ChangeTypeEnum mapToAffectedVirtualStorage(ChangeType o);

	@ValueMapping(source = "CHANGE_VNFPKG", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "CREATE_SNAPSHOT", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "REVERT_TO_SNAPSHOT", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "CHANGE_EXTERNAL_VNF_CONNECTIVITY", target = "CHANGE_EXT_CONN")
	@ValueMapping(source = "MODIFY_INFORMATION", target = "MODIFY_INFO")
	@ValueMapping(source = "UPDATE", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "SELECT_DEPL_MODS", target = MappingConstants.THROW_EXCEPTION)
	LcmOperationType map(PlanOperationType o);

}
