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
package com.ubiqube.etsi.mano.v431.service.mapping.vnflcm;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.dao.mano.ExtLinkPortDataEntity;
import com.ubiqube.etsi.mano.model.ExternalManagedVirtualLink;
import com.ubiqube.etsi.mano.model.VnfInstantiate;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.ExtLinkPortData;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.ExtManagedVirtualLinkData;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.InstantiateVnfRequest;
import com.ubiqube.etsi.mano.v431.service.mapping.Connectivity431Mapping;
import com.ubiqube.etsi.mano.v431.service.mapping.VimConnectionInfo431Mapping;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VnfInstantiate431Mapping extends Connectivity431Mapping, VimConnectionInfo431Mapping {

	@Mapping(target = "vimConnectionInfo", ignore = true)
	VnfInstantiate map(InstantiateVnfRequest o);

	@Mapping(target = "extManagedVirtualLinkId", ignore = true)
	@Mapping(target = "vimId", source = "vimConnectionId")
	ExternalManagedVirtualLink mapToExternalManagedVirtualLink(ExtManagedVirtualLinkData o);

	@Override
	@Mapping(target = "aliasName", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "changeType", ignore = true)
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

	@Mapping(target = "targetScaleLevelInfo", ignore = true)
	@Mapping(target = "additionalParams", ignore = true)
	@Mapping(target = "extensions", ignore = true)
	@Mapping(target = "vnfConfigurableProperties", ignore = true)
	InstantiateVnfRequest map(VnfInstantiate req);

	@Mapping(target = "vimConnectionId", ignore = true)
	ExtManagedVirtualLinkData map(ExternalManagedVirtualLink o);
}
