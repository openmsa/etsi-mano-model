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
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.common.v261.model.VimConnectionInfo;
import com.ubiqube.etsi.mano.common.v261.model.nslcm.ExtLinkPortData;
import com.ubiqube.etsi.mano.common.v261.model.nslcm.ExtManagedVirtualLinkData;
import com.ubiqube.etsi.mano.dao.mano.ExtLinkPortDataEntity;
import com.ubiqube.etsi.mano.dao.mano.vim.VimConnectionInformation;
import com.ubiqube.etsi.mano.dao.mano.vim.VimConnectionInformation;
import com.ubiqube.etsi.mano.model.ExternalManagedVirtualLink;
import com.ubiqube.etsi.mano.model.VnfInstantiate;
import com.ubiqube.etsi.mano.v261.model.vnfm.nslcm.InstantiateVnfRequest;
import com.ubiqube.etsi.mano.v261.service.mapping.Connectivity261Mapping;
import com.ubiqube.etsi.mano.v261.service.mapping.VimConnectionInfo261Mapping;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VnfInstantiate261Mapping extends Connectivity261Mapping, VimConnectionInfo261Mapping {
 
 	@Mapping(target = "vimConnectionInfo", ignore = true)
	VnfInstantiate map(InstantiateVnfRequest o);

	@Mapping(target = "vnfVirtualLinkDescId", source ="vmfVirtualLinkDescId")
	@Mapping(target = "extManagedVirtualLinkId", ignore = true)
	ExternalManagedVirtualLink mapToExternalManagedVirtualLink(ExtManagedVirtualLinkData o);

	@Mapping(target = "trunkResourceId", ignore = true)
	@Override
	@Mapping(target = "aliasName", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "changeType", ignore = true)
	@Mapping(target = "containerNamespace", ignore = true)
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
	@Mapping(target = "vimLevelAdditionalResourceInfo", ignore = true)
	@Mapping(target = "vimLevelResourceType", source = "resourceHandle.vimLevelResourceType")
	@Mapping(target = "vnfLcmOpOccs", ignore = true)
	@Mapping(target = "vnfdId", ignore = true)
	@Mapping(target = "zoneId", ignore = true)
	@Mapping(target = "cpInstanceId", ignore = true)
	@Mapping(target = "secondaryCpInstanceId", ignore = true)
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
	ExtLinkPortDataEntity map(ExtLinkPortData o);

	default List<VimConnectionInformation> mapSetOfVimconn(final Map<String, VimConnectionInfo> value) {
		if (null == value) {
			return List.of();
		}
		return value.values().stream().map(this::map).toList();
	}

	@Mapping(target = "additionalParams", ignore = true)
	InstantiateVnfRequest map(VnfInstantiate req);

	@SuppressWarnings("null")
	default Map<String,VimConnectionInfo> mapToMapOfVimConnectionInfo(final List<VimConnectionInformation> value) {
		if (null == value) {
			return Map.of();
		}
		return value.stream().collect(Collectors.toMap(x -> x.getVimId(), x -> map(x)));
	}

	@Mapping(target = "vmfVirtualLinkDescId", source ="vnfVirtualLinkDescId")
	ExtManagedVirtualLinkData map(ExternalManagedVirtualLink o);
}
