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
package com.ubiqube.etsi.mano.v451.service.mapping;

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
import com.ubiqube.etsi.mano.dao.mano.LinkPortInfo;
import com.ubiqube.etsi.mano.dao.mano.NetAttDefResourceInfo;
import com.ubiqube.etsi.mano.dao.mano.ScaleInfo;
import com.ubiqube.etsi.mano.dao.mano.VirtualCpAddressInfo;
import com.ubiqube.etsi.mano.dao.mano.VirtualLinkInfo;
import com.ubiqube.etsi.mano.dao.mano.VirtualStorageResourceInfo;
import com.ubiqube.etsi.mano.dao.mano.VnfInstance;
import com.ubiqube.etsi.mano.dao.mano.VnfMonitoringParameter;
import com.ubiqube.etsi.mano.dao.mano.VnfcResourceInfoEntity;
import com.ubiqube.etsi.mano.dao.mano.VnfcResourceInfoVnfcCpInfoEntity;
import com.ubiqube.etsi.mano.dao.mano.v2.AdditionalServiceInfo;
import com.ubiqube.etsi.mano.dao.mano.v2.BlueprintParameters;
import com.ubiqube.etsi.mano.dao.mano.v2.McioInfo;
import com.ubiqube.etsi.mano.dao.mano.v2.ServicePortInfo;
import com.ubiqube.etsi.mano.dao.mano.v2.VipCpInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.CpProtocolInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.ExtLinkPortInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.ExtManagedVirtualLinkInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.ExtVirtualLinkInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.IpOverEthernetAddressInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.IpOverEthernetAddressInfoIpAddresses;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.MonitoringParameter;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VirtualCpInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VnfExtCpInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VnfInstanceInstantiatedVnfInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VnfLinkPortInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VnfVirtualLinkResourceInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VnfcResourceInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VnfcResourceInfoVnfcCpInfo;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VnfInstance451Mapping extends VimConnectionInfo451Mapping, Connectivity451Mapping {

	@Mapping(target = "certificateInfo", ignore = true)
	@Mapping(target = "links", ignore = true)
	com.ubiqube.etsi.mano.v451.model.em.vnflcm.VnfInstance map(VnfInstance vnfInst);

	@Mapping(target = "vnfPkg", ignore = true)
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
	VnfInstance map(com.ubiqube.etsi.mano.v451.model.em.vnflcm.VnfInstance pkg);

	CpProtocolInfoEntity.LayerProtocolEnum map(CpProtocolInfo.LayerProtocolEnum en);

	@ValueMapping(source = "ETHERNET", target = MappingConstants.THROW_EXCEPTION)
	CpProtocolInfo.LayerProtocolEnum map(CpProtocolInfoEntity.LayerProtocolEnum en);

	@Mapping(target = "selectedDeployableModule", ignore = true)
	@Mapping(target = "vnfPaasServiceInfo", ignore = true)
	@Mapping(target = "extManagedVirtualLinkInfo", source = "extManagedVirtualLinks")
	@Mapping(target = "monitoringParameters", source = "vnfMonitoringParameter")
	@Mapping(target = "vnfState", source = "state")
	@Mapping(target = "vnfVirtualLinkResourceInfo", source = "virtualLinkResourceInfo")
	VnfInstanceInstantiatedVnfInfo map(BlueprintParameters bp);

	com.ubiqube.etsi.mano.v451.model.em.vnflcm.ScaleInfo map(ScaleInfo o);

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

	@Mapping(target = "virtualStorageResourceInfo", source = "virtualStorageResourceInfo")
	@Mapping(target = "vnfcInfo", ignore = true)
	@Mapping(target = "aspectId", ignore = true)
	@Mapping(target = "extManagedVirtualLinks", source = "extManagedVirtualLinkInfo")
	@Mapping(target = "instantiationLevelId", ignore = true)
	@Mapping(target = "nsHeal", ignore = true)
	@Mapping(target = "nsScale", ignore = true)
	@Mapping(target = "nsScaleStatus", ignore = true)
	@Mapping(target = "nsStepStatus", ignore = true)
	@Mapping(target = "numberOfSteps", ignore = true)
	@Mapping(target = "scaleType", ignore = true)
	@Mapping(target = "state", source = "vnfState")
	@Mapping(target = "updData", ignore = true)
	@Mapping(target = "virtualLinkResourceInfo", source = "vnfVirtualLinkResourceInfo")
	@Mapping(target = "vnfMonitoringParameter", source = "monitoringParameters")
	BlueprintParameters map(VnfInstanceInstantiatedVnfInfo viivi);

	@Mapping(target = "aliasName", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "changeType", ignore = true)
	@Mapping(target = "endTime", ignore = true)
	@Mapping(target = "instantiationLevel", ignore = true)
	@Mapping(target = "manoResourceId", ignore = true)
	@Mapping(target = "removedInstantiated", ignore = true)
	@Mapping(target = "resourceDefinitionId", ignore = true)
	@Mapping(target = "resourceGroupId", ignore = true)
	@Mapping(target = "startTime", ignore = true)
	@Mapping(target = "status", ignore = true)
	@Mapping(target = "toscaName", ignore = true)
	@Mapping(target = "vduId", ignore = true)
	@Mapping(target = "vimConnectionInformation", ignore = true)
	@Mapping(target = "vnfLcmOpOccs", ignore = true)
	@Mapping(target = "zoneId", ignore = true)
	@Mapping(target = "vfndId", ignore = true)
	@Mapping(target = ".", source = "networkResource")
	VirtualLinkInfo map(VnfVirtualLinkResourceInfo o);

	@Mapping(target = "trunkResourceId", ignore = true)
	@Mapping(target = "vipCpInstanceId", ignore = true)
	LinkPortInfo map(VnfLinkPortInfo o);

	@Mapping(target = "extManagedMultisiteVirtualLinkId", ignore = true)
	@Mapping(target = "grants", ignore = true)
	@Mapping(target = ".", source = "networkResource")
	@Mapping(target = "vnfInstance", ignore = true)
	ExtManagedVirtualLinkDataEntity map(ExtManagedVirtualLinkInfo o);

	@Mapping(target = "audit", ignore = true)
	VnfMonitoringParameter map(MonitoringParameter o);

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
	McioInfo map(com.ubiqube.etsi.mano.v451.model.em.vnflcm.McioInfo mi);

	com.ubiqube.etsi.mano.v451.model.em.vnflcm.McioInfo map(McioInfo mi);

	@Mapping(target = "id", ignore = true)
	NetAttDefResourceInfo map(com.ubiqube.etsi.mano.v451.model.em.vnflcm.NetAttDefResourceInfo nadr);

	@Mapping(target = "id", ignore = true)
	ScaleInfo map(com.ubiqube.etsi.mano.v451.model.em.vnflcm.ScaleInfo si);

	@Mapping(target = "id", ignore = true)
	VipCpInfo map(com.ubiqube.etsi.mano.v451.model.em.vnflcm.VipCpInfo vc);

	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "zoneId", ignore = true)
	VirtualStorageResourceInfo map(com.ubiqube.etsi.mano.v451.model.em.vnflcm.VirtualStorageResourceInfo virtualStorageResourceInfo);

	com.ubiqube.etsi.mano.v451.model.em.vnflcm.VirtualStorageResourceInfo map(VirtualStorageResourceInfo vsri);

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
	AdditionalServiceInfo map(com.ubiqube.etsi.mano.v451.model.em.vnflcm.AdditionalServiceInfo asi);

	@Mapping(target = "id", ignore = true)
	ServicePortInfo map(com.ubiqube.etsi.mano.v451.model.em.vnflcm.ServicePortInfo spi);

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
	VirtualCpAddressInfo map(com.ubiqube.etsi.mano.v451.model.em.vnflcm.VirtualCpAddressInfo vcp);

	@Mapping(target = "isDynamic", ignore = true)
	IpOverEthernetAddressInfoIpAddresses mapToIpOverEthernetAddressInfoIpAddresses(IpOverEthernetAddressDataIpAddressesEntity o);
}
