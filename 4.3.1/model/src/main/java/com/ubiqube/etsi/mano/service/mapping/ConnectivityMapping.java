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

import com.ubiqube.etsi.mano.dao.mano.AdditionalResourceInfo;
import com.ubiqube.etsi.mano.dao.mano.CpProtocolDataEntity;
import com.ubiqube.etsi.mano.dao.mano.ExtLinkPortDataEntity;
import com.ubiqube.etsi.mano.dao.mano.ExtManagedVirtualLinkDataEntity;
import com.ubiqube.etsi.mano.dao.mano.ExtVirtualLinkDataEntity;
import com.ubiqube.etsi.mano.dao.mano.IpOverEthernetAddressDataEntity;
import com.ubiqube.etsi.mano.dao.mano.IpOverEthernetAddressDataIpAddressesEntity;
import com.ubiqube.etsi.mano.dao.mano.LayerProtocolType;
import com.ubiqube.etsi.mano.dao.mano.NetAttDefResourceInfo;
import com.ubiqube.etsi.mano.dao.mano.VirtualCpAddressInfo;
import com.ubiqube.etsi.mano.dao.mano.VnfExtCpConfiguration;
import com.ubiqube.etsi.mano.dao.mano.VnfExtCpDataEntity;
import com.ubiqube.etsi.mano.dao.mano.nsd.upd.ExtVirtualLinkData;
import com.ubiqube.etsi.mano.em.v431.model.vnflcm.CpProtocolData;
import com.ubiqube.etsi.mano.em.v431.model.vnflcm.CpProtocolInfo;
import com.ubiqube.etsi.mano.em.v431.model.vnflcm.ExtLinkPortData;
import com.ubiqube.etsi.mano.em.v431.model.vnflcm.ExtManagedVirtualLinkData;
import com.ubiqube.etsi.mano.em.v431.model.vnflcm.IpOverEthernetAddressData;
import com.ubiqube.etsi.mano.em.v431.model.vnflcm.IpOverEthernetAddressDataIpAddresses;
import com.ubiqube.etsi.mano.em.v431.model.vnflcm.NetAttDefResourceData;
import com.ubiqube.etsi.mano.em.v431.model.vnflcm.VirtualCpAddressData;
import com.ubiqube.etsi.mano.em.v431.model.vnflcm.VnfExtCpConfig;
import com.ubiqube.etsi.mano.em.v431.model.vnflcm.VnfExtCpData;

@Mapper
public interface ConnectivityMapping {

	@ValueMapping(source = "ETHERNET", target = MappingConstants.THROW_EXCEPTION)
	CpProtocolInfo.LayerProtocolEnum mapLayerProtocolType(LayerProtocolType en);

	@ValueMapping(source = MappingConstants.ANY_REMAINING, target = "IP_OVER_ETHERNET")
	LayerProtocolType mapLayerProtocolType2(CpProtocolInfo.LayerProtocolEnum en);

	@ValueMapping(source = MappingConstants.ANY_REMAINING, target = "IP_OVER_ETHERNET")
	LayerProtocolType map(CpProtocolData.LayerProtocolEnum lpe);

	@ValueMapping(source = MappingConstants.ANY_REMAINING, target = "IP_OVER_ETHERNET")
	CpProtocolData.LayerProtocolEnum map(LayerProtocolType lpt);

	@Mapping(target = "extCps", ignore = true)
	@Mapping(target = "extLinkPorts", ignore = true)
	@Mapping(target = "extNetAttDefResource", ignore = true)
	@Mapping(target = "containerNamespace", ignore = true)
	@Mapping(target = "currentVnfExtCpData", ignore = true)
	@Mapping(target = "vimLevelAdditionalResourceInfo", ignore = true)
	@Mapping(target = "vimLevelResourceType", ignore = true)
	@Mapping(target = "vnfInstance", ignore = true)
	ExtVirtualLinkDataEntity map(ExtVirtualLinkData evld);

	@Mapping(target = "associatedExtCpId", ignore = true)
	@Mapping(target = "associatedVnfcCpId", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "netAttDefResource", source = "resourceHandle")
	@Mapping(target = "netAttDefResourceInfoId", source = "netAttDefResourceId")
	NetAttDefResourceInfo map(NetAttDefResourceData o);

	@Mapping(target = "netAttDefResourceId", source = "netAttDefResourceInfoId")
	@Mapping(target = "resourceHandle", source = "netAttDefResource")
	NetAttDefResourceData map(NetAttDefResourceInfo o);

	VirtualCpAddressData map(VirtualCpAddressInfo vcai);

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

	@Mapping(target = "id", ignore = true)
	VnfExtCpDataEntity map(VnfExtCpData extCps);

	@Mapping(target = "cpInstanceId", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "vnfExtCpDataEntity", ignore = true)
	VnfExtCpConfiguration map(VnfExtCpConfig cpConfig);

	@Mapping(target = "createExtLinkPort", ignore = true)
	VnfExtCpConfig map(VnfExtCpConfiguration vecc);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "vnfExtCpConfiguration", ignore = true)
	CpProtocolDataEntity map(CpProtocolData cpProtocolData);

	@Mapping(target = "addressPoolName", ignore = true)
	VirtualCpAddressInfo map(VirtualCpAddressData o);

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

	@Mapping(target = "id", ignore = true)
	AdditionalResourceInfo map(com.ubiqube.etsi.mano.em.v431.model.vnflcm.AdditionalResourceInfo ari);

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
