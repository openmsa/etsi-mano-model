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

import com.ubiqube.etsi.mano.dao.mano.CpProtocolDataEntity;
import com.ubiqube.etsi.mano.dao.mano.CpProtocolInfoEntity;
import com.ubiqube.etsi.mano.dao.mano.ExtCpInfo;
import com.ubiqube.etsi.mano.dao.mano.ExtLinkPortDataEntity;
import com.ubiqube.etsi.mano.dao.mano.ExtManagedVirtualLinkDataEntity;
import com.ubiqube.etsi.mano.dao.mano.ExtVirtualLinkDataEntity;
import com.ubiqube.etsi.mano.dao.mano.IpOverEthernetAddressDataEntity;
import com.ubiqube.etsi.mano.dao.mano.IpOverEthernetAddressDataIpAddressesEntity;
import com.ubiqube.etsi.mano.dao.mano.IpOverEthernetAddressInfoEntity;
import com.ubiqube.etsi.mano.dao.mano.LayerProtocolType;
import com.ubiqube.etsi.mano.dao.mano.NetAttDefResourceInfo;
import com.ubiqube.etsi.mano.dao.mano.ScaleInfo;
import com.ubiqube.etsi.mano.dao.mano.VirtualCpAddressInfo;
import com.ubiqube.etsi.mano.dao.mano.VirtualStorageResourceInfo;
import com.ubiqube.etsi.mano.dao.mano.VnfInstance;
import com.ubiqube.etsi.mano.dao.mano.VnfcResourceInfoEntity;
import com.ubiqube.etsi.mano.dao.mano.VnfcResourceInfoVnfcCpInfoEntity;
import com.ubiqube.etsi.mano.dao.mano.v2.AdditionalServiceInfo;
import com.ubiqube.etsi.mano.dao.mano.v2.BlueprintParameters;
import com.ubiqube.etsi.mano.dao.mano.v2.McioInfo;
import com.ubiqube.etsi.mano.dao.mano.v2.ServicePortInfo;
import com.ubiqube.etsi.mano.dao.mano.v2.VipCpInfo;
import com.ubiqube.etsi.mano.em.v431.model.vnflcm.CpProtocolInfo;
import com.ubiqube.etsi.mano.em.v431.model.vnflcm.ExtLinkPortInfo;
import com.ubiqube.etsi.mano.em.v431.model.vnflcm.ExtManagedVirtualLinkInfo;
import com.ubiqube.etsi.mano.em.v431.model.vnflcm.ExtVirtualLinkInfo;
import com.ubiqube.etsi.mano.em.v431.model.vnflcm.IpOverEthernetAddressInfo;
import com.ubiqube.etsi.mano.em.v431.model.vnflcm.IpOverEthernetAddressInfoIpAddresses;
import com.ubiqube.etsi.mano.em.v431.model.vnflcm.VirtualCpInfo;
import com.ubiqube.etsi.mano.em.v431.model.vnflcm.VnfExtCpInfo;
import com.ubiqube.etsi.mano.em.v431.model.vnflcm.VnfInstanceInstantiatedVnfInfo;
import com.ubiqube.etsi.mano.em.v431.model.vnflcm.VnfcResourceInfo;
import com.ubiqube.etsi.mano.em.v431.model.vnflcm.VnfcResourceInfoVnfcCpInfo;

@Mapper
public interface VnfInstance431Mapping extends VimConnectionInfo431Mapping, Connectivity431Mapping {

	@Mapping(target = "links", ignore = true)
	com.ubiqube.etsi.mano.em.v431.model.vnflcm.VnfInstance map(VnfInstance vnfInst);

	@Mapping(target = "vimConnectionInfo", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "blueprints", ignore = true)
	@Mapping(target = "cirConnectionInfo", ignore = true)
	@Mapping(target = "extManagedVirtualLinks", ignore = true)
	@Mapping(target = "extVirtualLinks", ignore = true)
	@Mapping(target = "lockedBy", ignore = true)
	@Mapping(target = "mciopRepositoryInfo", ignore = true)
	@Mapping(target = "nsInstance", ignore = true)
	@Mapping(target = "pmJobs", ignore = true)
	@Mapping(target = "tenantId", ignore = true)
	@Mapping(target = "version", ignore = true)
	@Mapping(target = "extCpInfo", ignore = true)
	@Mapping(target = "versionDependency", ignore = true)
	@Mapping(target = "vnfPkg", ignore = true)
	@Mapping(target = "id", ignore = true)
	VnfInstance map(com.ubiqube.etsi.mano.em.v431.model.vnflcm.VnfInstance pkg);

	@Override
	@ValueMapping(source = MappingConstants.ANY_REMAINING, target = "IP_OVER_ETHERNET")
	CpProtocolInfo.LayerProtocolEnum mapLayerProtocolType(LayerProtocolType en);

	@Override
	@ValueMapping(source = MappingConstants.ANY_REMAINING, target = "IP_OVER_ETHERNET")
	LayerProtocolType mapLayerProtocolType2(CpProtocolInfo.LayerProtocolEnum en);

	@ValueMapping(source = "ETHERNET", target = MappingConstants.THROW_EXCEPTION)
	CpProtocolInfo.LayerProtocolEnum map(CpProtocolInfoEntity.LayerProtocolEnum en);

	@Mapping(target = "extManagedVirtualLinkInfo", source = "extManagedVirtualLinks")
	@Mapping(target = "monitoringParameters", source = "vnfMonitoringParameter")
	@Mapping(target = "vnfState", source = "state")
	@Mapping(target = "vnfVirtualLinkResourceInfo", source = "virtualLinkResourceInfo")
	VnfInstanceInstantiatedVnfInfo map(BlueprintParameters bp);

	@Mapping(target = "scaleToLevel", source = "scaleLevel")
	com.ubiqube.etsi.mano.em.v431.model.vnflcm.ScaleInfo map(ScaleInfo o);

	@Mapping(target = "networkResource.vimLevelAdditionalResourceInfo", source = "vimLevelAdditionalResourceInfo")
	@Mapping(target = "networkResource.vimLevelResourceType", source = "vimLevelResourceType")
	@Mapping(target = "networkResource.resourceId", source = "resourceId")
	@Mapping(target = "networkResource.resourceProviderId", source = "resourceProviderId")
	@Mapping(target = "networkResource.vimConnectionId", source = "vimConnectionId")
	@Mapping(target = "networkResource.containerNamespace", source = "containerNamespace")
	ExtManagedVirtualLinkInfo map(ExtManagedVirtualLinkDataEntity o);

	VnfExtCpInfo map(ExtCpInfo ext);

	@Mapping(target = "resourceHandle.vimConnectionId", source = "vimConnectionId")
	@Mapping(target = "resourceHandle.resourceProviderId", source = "resourceProviderId")
	@Mapping(target = "resourceHandle.resourceId", source = "resourceId")
	@Mapping(target = "resourceHandle.vimLevelResourceType", source = "vimLevelResourceType")
	@Mapping(target = "resourceHandle.vimLevelAdditionalResourceInfo", source = "vimLevelAdditionalResourceInfo")
	ExtVirtualLinkInfo mapExtVirtualLinkInfo(ExtVirtualLinkDataEntity ext);

	VnfcResourceInfo map(VnfcResourceInfoEntity vnfcResourceInfo);

	@Mapping(target = "certificateContentId", ignore = true)
	@Mapping(target = "zoneId", ignore = true)
	VnfcResourceInfoEntity map(VnfcResourceInfo vnfcResourceInfo);

	@Mapping(target = "certificateContentId", ignore = true)
	VnfcResourceInfoVnfcCpInfoEntity map(VnfcResourceInfoVnfcCpInfo o);

	VnfcResourceInfoVnfcCpInfo map(VnfcResourceInfoVnfcCpInfoEntity vnfcCpInfo);

	@Mapping(target = "id", ignore = true)
	CpProtocolInfoEntity map(CpProtocolInfo cpi);

	@Mapping(target = "aspectId", ignore = true)
	@Mapping(target = "extManagedVirtualLinks", ignore = true)
	@Mapping(target = "instantiationLevelId", ignore = true)
	@Mapping(target = "nsHeal", ignore = true)
	@Mapping(target = "nsScale", ignore = true)
	@Mapping(target = "nsScaleStatus", ignore = true)
	@Mapping(target = "nsStepStatus", ignore = true)
	@Mapping(target = "numberOfSteps", ignore = true)
	@Mapping(target = "scaleType", ignore = true)
	@Mapping(target = "state", ignore = true)
	@Mapping(target = "updData", ignore = true)
	@Mapping(target = "virtualLinkResourceInfo", ignore = true)
	@Mapping(target = "vnfMonitoringParameter", ignore = true)
	BlueprintParameters map(VnfInstanceInstantiatedVnfInfo viivi);

	@Mapping(target = "certificateContentId", ignore = true)
	ExtCpInfo map(VnfExtCpInfo o);

	@Mapping(target = "containerNamespace", ignore = true)
	@Mapping(target = "extCps", ignore = true)
	@Mapping(target = "resourceId", source = "resourceHandle.resourceId")
	@Mapping(target = "resourceProviderId", source = "resourceHandle.resourceProviderId")
	@Mapping(target = "vimConnectionId", source = "resourceHandle.vimConnectionId")
	@Mapping(target = "vimLevelAdditionalResourceInfo", source = "resourceHandle.vimLevelAdditionalResourceInfo")
	@Mapping(target = "vimLevelResourceType", source = "resourceHandle.vimLevelResourceType")
	@Mapping(target = "vnfInstance", ignore = true)
	ExtVirtualLinkDataEntity map(ExtVirtualLinkInfo ext);

	@Mapping(target = "reservationId", ignore = true)
	@Mapping(target = "aliasName", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "changeType", ignore = true)
	@Mapping(target = "containerNamespace", ignore = true)
	@Mapping(target = "endTime", ignore = true)
	@Mapping(target = "instantiationLevel", ignore = true)
	@Mapping(target = "manoResourceId", ignore = true)
	@Mapping(target = "metadata", ignore = true)
	@Mapping(target = "removedInstantiated", ignore = true)
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
	ExtLinkPortDataEntity map(ExtLinkPortInfo ext);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "vnfExtCpConfiguration", ignore = true)
	CpProtocolDataEntity mapToCpProtocolDataEntity(CpProtocolInfo cpi);

	@Mapping(target = "certificateContentId", ignore = true)
	@Mapping(target = "id", ignore = true)
	McioInfo map(com.ubiqube.etsi.mano.em.v431.model.vnflcm.McioInfo mi);

	com.ubiqube.etsi.mano.em.v431.model.vnflcm.McioInfo map(McioInfo mi);

	@Mapping(target = "id", ignore = true)
	NetAttDefResourceInfo map(com.ubiqube.etsi.mano.em.v431.model.vnflcm.NetAttDefResourceInfo nadr);

	@Mapping(target = "scaleLevel", source = "scaleToLevel")
	@Mapping(target = "id", ignore = true)
	ScaleInfo map(com.ubiqube.etsi.mano.em.v431.model.vnflcm.ScaleInfo si);

	@Mapping(target = "id", ignore = true)
	VipCpInfo map(com.ubiqube.etsi.mano.em.v431.model.vnflcm.VipCpInfo vc);

	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "zoneId", ignore = true)
	VirtualStorageResourceInfo map(com.ubiqube.etsi.mano.em.v431.model.vnflcm.VirtualStorageResourceInfo virtualStorageResourceInfo);

	com.ubiqube.etsi.mano.em.v431.model.vnflcm.VirtualStorageResourceInfo map(VirtualStorageResourceInfo vsri);

	@Mapping(target = "addressRange", ignore = true)
	@Mapping(target = "addresses", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "isDynamic", ignore = true)
	@Mapping(target = "subnetId", ignore = true)
	@Mapping(target = "type", ignore = true)
	IpOverEthernetAddressInfoEntity map(IpOverEthernetAddressInfo ipOverEthernet);

	@Mapping(target = "fixedAddresses", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "numDynamicAddresses", ignore = true)
	IpOverEthernetAddressDataIpAddressesEntity map(IpOverEthernetAddressInfoIpAddresses ipAddresses);

	VirtualCpInfo map(com.ubiqube.etsi.mano.dao.mano.v2.VirtualCpInfo vcp);

	@Mapping(target = "id", ignore = true)
	com.ubiqube.etsi.mano.dao.mano.v2.VirtualCpInfo map(VirtualCpInfo vcp);

	@Mapping(target = "id", ignore = true)
	AdditionalServiceInfo map(com.ubiqube.etsi.mano.em.v431.model.vnflcm.AdditionalServiceInfo asi);

	@Mapping(target = "id", ignore = true)
	ServicePortInfo map(com.ubiqube.etsi.mano.em.v431.model.vnflcm.ServicePortInfo spi);

	@Mapping(target = "id", ignore = true)
	com.ubiqube.etsi.mano.dao.mano.v2.CpProtocolInfo mapCpProtocolInfo(CpProtocolInfo cpi);

	@Mapping(target = "segmentationType", ignore = true)
	@Mapping(target = "addressRange", ignore = true)
	@Mapping(target = "addresses", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "isDynamic", ignore = true)
	@Mapping(target = "subnetId", ignore = true)
	@Mapping(target = "type", ignore = true)
	IpOverEthernetAddressDataEntity mapToIpOverEthernetAddressDataEntity(IpOverEthernetAddressInfo ipo);

	@Mapping(target = "addressPoolName", ignore = true)
	VirtualCpAddressInfo map(com.ubiqube.etsi.mano.em.v431.model.vnflcm.VirtualCpAddressInfo vcp);

//	com.ubiqube.etsi.mano.em.v431.model.vnflcm.VirtualCpAddressInfo mapToVirtualCpAddressInfo(VirtualCpAddressInfo vcp);

	@Mapping(target = "isDynamic", ignore = true)
	IpOverEthernetAddressInfoIpAddresses mapToIpOverEthernetAddressInfoIpAddresses(IpOverEthernetAddressDataIpAddressesEntity o);
}
