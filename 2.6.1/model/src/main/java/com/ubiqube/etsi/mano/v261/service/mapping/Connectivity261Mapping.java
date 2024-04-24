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
package com.ubiqube.etsi.mano.v261.service.mapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;

import com.ubiqube.etsi.mano.common.v261.model.IpOverEthernetAddressDataIpAddresses;
import com.ubiqube.etsi.mano.common.v261.model.VnfExtCpData;
import com.ubiqube.etsi.mano.common.v261.model.nslcm.CpProtocolData;
import com.ubiqube.etsi.mano.common.v261.model.nslcm.CpProtocolInfo;
import com.ubiqube.etsi.mano.common.v261.model.nslcm.ExtLinkPortData;
import com.ubiqube.etsi.mano.common.v261.model.nslcm.ExtManagedVirtualLinkData;
import com.ubiqube.etsi.mano.common.v261.model.nslcm.ExtVirtualLinkData;
import com.ubiqube.etsi.mano.common.v261.model.nslcm.IpOverEthernetAddressData;
import com.ubiqube.etsi.mano.common.v261.model.nslcm.VnfExtCpConfig;
import com.ubiqube.etsi.mano.dao.mano.CpProtocolDataEntity;
import com.ubiqube.etsi.mano.dao.mano.ExtLinkPortDataEntity;
import com.ubiqube.etsi.mano.dao.mano.ExtManagedVirtualLinkDataEntity;
import com.ubiqube.etsi.mano.dao.mano.ExtVirtualLinkDataEntity;
import com.ubiqube.etsi.mano.dao.mano.IpOverEthernetAddressDataEntity;
import com.ubiqube.etsi.mano.dao.mano.IpOverEthernetAddressDataIpAddressesEntity;
import com.ubiqube.etsi.mano.dao.mano.LayerProtocolType;
import com.ubiqube.etsi.mano.dao.mano.VnfExtCpConfiguration;
import com.ubiqube.etsi.mano.dao.mano.VnfExtCpDataEntity;
import com.ubiqube.etsi.mano.dao.mano.alarm.ResourceHandle;

import jakarta.annotation.Nullable;

@Mapper
public interface Connectivity261Mapping {
	@ValueMapping(source = "IP_FOR_VIRTUAL_CP", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "ETHERNET", target = MappingConstants.THROW_EXCEPTION)
	CpProtocolInfo.LayerProtocolEnum mapLayerProtocolType(LayerProtocolType en);

	@ValueMapping(source = MappingConstants.ANY_REMAINING, target = "IP_OVER_ETHERNET")
	LayerProtocolType mapLayerProtocolType2(CpProtocolInfo.LayerProtocolEnum en);

	@ValueMapping(source = MappingConstants.ANY_REMAINING, target = "IP_OVER_ETHERNET")
	LayerProtocolType map(CpProtocolData.LayerProtocolEnum lpe);

	@ValueMapping(source = MappingConstants.ANY_REMAINING, target = "IP_OVER_ETHERNET")
	CpProtocolData.LayerProtocolEnum map(LayerProtocolType lpt);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "extNetAttDefResource", ignore = true)
	@Mapping(target = "containerNamespace", ignore = true)
	@Mapping(target = "currentVnfExtCpData", ignore = true)
	@Mapping(target = "vimLevelAdditionalResourceInfo", ignore = true)
	@Mapping(target = "vimLevelResourceType", ignore = true)
	@Mapping(target = "vnfInstance", ignore = true)
	ExtVirtualLinkDataEntity map(ExtVirtualLinkData evld);

	@Mapping(target = "extVirtualLinkId", ignore = true)
	ExtVirtualLinkData mapToExtVirtualLinkData(ExtVirtualLinkDataEntity evld);

	@Nullable
	default List<VnfExtCpConfig> mapToListOfVnfExtCpConfig(final @Nullable Map<String, VnfExtCpConfiguration> o) {
		if (null == o) {
			return List.of();
		}
		return o.values().stream().map(this::map).toList();
	}

	VnfExtCpConfig map(VnfExtCpConfiguration o);

	@Mapping(target = "trunkResourceId", ignore = true)
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
	@Mapping(target = "resourceId", ignore = true)
	@Mapping(target = "resourceProviderId", ignore = true)
	@Mapping(target = "startTime", ignore = true)
	@Mapping(target = "status", ignore = true)
	@Mapping(target = "toscaName", ignore = true)
	@Mapping(target = "vduId", ignore = true)
	@Mapping(target = "vimConnectionInformation", ignore = true)
	@Mapping(target = "vimLevelAdditionalResourceInfo", ignore = true)
	@Mapping(target = "vimLevelResourceType", ignore = true)
	@Mapping(target = "vnfLcmOpOccs", ignore = true)
	@Mapping(target = "vnfdId", ignore = true)
	@Mapping(target = "zoneId", ignore = true)
	@Mapping(target = "cpInstanceId", ignore = true)
	@Mapping(target = "secondaryCpInstanceId", ignore = true)
	ExtLinkPortDataEntity map(ExtLinkPortData elpt);

	@Mapping(target = "containerNamespace", ignore = true)
	@Mapping(target = "vimLevelAdditionalResourceInfo", ignore = true)
	ResourceHandle map(com.ubiqube.etsi.mano.common.v261.model.ResourceHandle o);

	@Mapping(target = "id", ignore = true)
	VnfExtCpDataEntity map(VnfExtCpData extCps);

	@Nullable
	default Map<String, VnfExtCpConfiguration> map(final @Nullable List<VnfExtCpConfig> o) {
		if (o == null) {
			return Map.of();
		}
		return o.stream().collect(Collectors.toMap(VnfExtCpConfig::getCpInstanceId, this::map));
	}

	@Mapping(target = "parentCpConfigId", ignore = true)
	@Mapping(target = "netAttDefResourceId", ignore = true)
	@Mapping(target = "cpInstanceId", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "vnfExtCpDataEntity", ignore = true)
	VnfExtCpConfiguration map(VnfExtCpConfig cpConfig);

	@Mapping(target = "virtualCpAddress", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "vnfExtCpConfiguration", ignore = true)
	CpProtocolDataEntity map(CpProtocolData cpProtocolData);

	@Mapping(target = "segmentationId", ignore = true)
	@Mapping(target = "segmentationType", ignore = true)
	@Mapping(target = "addressRange", ignore = true)
	@Mapping(target = "addresses", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "isDynamic", ignore = true)
	@Mapping(target = "subnetId", ignore = true)
	@Mapping(target = "type", ignore = true)
	IpOverEthernetAddressDataEntity map(IpOverEthernetAddressData ioead);

	IpOverEthernetAddressData map(IpOverEthernetAddressDataEntity ioeade);

	@Mapping(target = "addresses", ignore = true)
	@Mapping(target = "id", ignore = true)
	IpOverEthernetAddressDataIpAddressesEntity map(IpOverEthernetAddressDataIpAddresses ipAddresses);

	IpOverEthernetAddressDataIpAddresses map(IpOverEthernetAddressDataIpAddressesEntity ipAddresses);

	@Mapping(target = "vimConnectionId", source = "vimId")
	@Mapping(target = "vnfVirtualLinkDescId", source = "vmfVirtualLinkDescId")
	@Mapping(target = "containerNamespace", ignore = true)
	@Mapping(target = "extManagedMultisiteVirtualLinkId", ignore = true)
	@Mapping(target = "grants", ignore = true)
	@Mapping(target = "vimLevelAdditionalResourceInfo", ignore = true)
	@Mapping(target = "vimLevelResourceType", ignore = true)
	@Mapping(target = "vnfInstance", ignore = true)
	@Mapping(target = "vnfLinkPorts", ignore = true)
	@Mapping(target = "vnfNetAttDefResource", ignore = true)
	@Mapping(target = "vnfdId", ignore = true)
	ExtManagedVirtualLinkDataEntity map(ExtManagedVirtualLinkData extManagedVirtualLinks);

}
