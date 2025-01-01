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
package com.ubiqube.etsi.mano.v361.service.mapping;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;

import com.ubiqube.etsi.mano.dao.mano.CpProtocolInfoEntity;
import com.ubiqube.etsi.mano.dao.mano.IpOverEthernetAddressDataIpAddressesEntity;
import com.ubiqube.etsi.mano.dao.mano.NsdInstance;
import com.ubiqube.etsi.mano.dao.mano.VirtualStorageResourceInfo;
import com.ubiqube.etsi.mano.dao.mano.VnfMonitoringParameter;
import com.ubiqube.etsi.mano.dao.mano.VnfScaleInfo;
import com.ubiqube.etsi.mano.dao.mano.dto.nsi.NsInstanceDto;
import com.ubiqube.etsi.mano.dao.mano.dto.nsi.NsVirtualLinkInfoDto;
import com.ubiqube.etsi.mano.dao.mano.dto.nsi.VnfInstanceDto;
import com.ubiqube.etsi.mano.dao.mano.dto.nsi.VnfInstanceInstantiatedVnfInfoDto;
import com.ubiqube.etsi.mano.dao.mano.dto.nsi.VnfcResourceInfoDto;
import com.ubiqube.etsi.mano.dao.mano.nfvo.NsVnfInstance;
import com.ubiqube.etsi.mano.dao.mano.nsd.NsCpHandle;
import com.ubiqube.etsi.mano.dao.mano.nsd.VnffgDescriptor;
import com.ubiqube.etsi.mano.dao.mano.nslcm.scale.NsScaleInfo;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.CpProtocolInfo;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.IpOverEthernetAddressInfoIpAddresses;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.ResourceHandle;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.ScaleInfo;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.VnfInstance;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.VnfInstanceInstantiatedVnfInfo;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.VnfcResourceInfo;
import com.ubiqube.etsi.mano.v361.model.nfvo.nslcm.NsInstance;
import com.ubiqube.etsi.mano.v361.model.nfvo.nslcm.NsVirtualLinkInfo;
import com.ubiqube.etsi.mano.v361.model.nfvo.nslcm.VnffgInfo;

import jakarta.annotation.Nullable;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface NsInstance361Mapping extends VimResource361Mapping {
	@Mapping(target = "additionalAffinityOrAntiAffinityRule", ignore = true)
	@Mapping(target = "monitoringParameter", ignore = true)
	@Mapping(target = "nestedNsInstanceId", ignore = true)
	@Mapping(target = "pnfInfo", ignore = true)
	@Mapping(target = "priority", ignore = true)
	@Mapping(target = "sapInfo", ignore = true)
	@Mapping(target = "links", ignore = true)
	@Mapping(target = "vnfSnapshotInfoIds", ignore = true)
	@Mapping(target = "wanConnectionInfo", ignore = true)
	NsInstance map(NsInstanceDto o);

	@Mapping(target = "nsScaleLevelId", source = "scaleLevel")
	@Mapping(target = "nsScalingAspectId", source = "aspectId")
	com.ubiqube.etsi.mano.v361.model.nfvo.nslcm.NsScaleInfo map(com.ubiqube.etsi.mano.dao.mano.ScaleInfo o);

	@Mapping(target = "scaleToLevel", ignore = true)
	@Mapping(target = "nsScaleLevelId", source = "scaleLevel")
	@Mapping(target = "nsScalingAspectId", source = "aspectId")
	NsScaleInfo mapScaleInfo(com.ubiqube.etsi.mano.dao.mano.ScaleInfo o);

	@Mapping(target = "scaleToLevel", ignore = true)
	@Mapping(target = "nsScaleLevelId", source = "scaleLevel")
	@Mapping(target = "nsScalingAspectId", source = "aspectId")
	NsScaleInfo mapNsScaleInfo(com.ubiqube.etsi.mano.dao.mano.ScaleInfo o);

	@Mapping(target = "vimConnectionInfo", ignore = true)
	@Mapping(target = "links", ignore = true)
	VnfInstance map(VnfInstanceDto o);

	@Mapping(target = "scaleLevel", ignore = true)
	@Mapping(target = "aspectId", source = "nsScalingAspectId")
	ScaleInfo map(NsScaleInfo o);

	@Mapping(target = "scaleToLevel", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "nsScaleLevelId", ignore = true)
	@Mapping(target = "nsScalingAspectId", source = "aspectId")
	NsScaleInfo map(ScaleInfo o);

	@Mapping(target = "linkPort", ignore = true)
	NsVirtualLinkInfo map(NsVirtualLinkInfoDto o);

	@Mapping(target = "nsVirtualLinkInfoId", ignore = true)
	@Mapping(target = "pnfdInfoId", ignore = true)
	@Mapping(target = "vnfInstanceId", ignore = true)
	VnffgInfo map(VnffgDescriptor o);

	@Nullable
	default com.ubiqube.etsi.mano.v361.model.nfvo.nslcm.NsCpHandle mapSetDb(final @Nullable Set<NsCpHandle> value) {
		if ((null == value) || value.isEmpty()) {
			return null;
		}
		return map(value.iterator().next());
	}

	com.ubiqube.etsi.mano.v361.model.nfvo.nslcm.NsCpHandle map(@Nullable NsCpHandle value);

	@Mapping(target = "vnfVirtualStorageResourceInfo", ignore = true)
	@Mapping(target = "vnfcInfo", ignore = true)
	@Mapping(target = "extCpInfo", ignore = true)
	@Mapping(target = "extManagedVirtualLinkInfo", ignore = true)
	@Mapping(target = "extVirtualLinkInfo", ignore = true)
	@Mapping(target = "vipCpInfo", ignore = true)
	@Mapping(target = "vnfVirtualLinkResourceInfo", ignore = true)
	VnfInstanceInstantiatedVnfInfo map(VnfInstanceInstantiatedVnfInfoDto o);

	@Mapping(target = "scaleLevel", ignore = true)
	@Mapping(target = "vnfdId", ignore = true)
	ScaleInfo map(VnfScaleInfo o);

	@Mapping(target = "vnfcCpInfo", ignore = true)
	VnfcResourceInfo map(VnfcResourceInfoDto vnfcResourceInfo);

	NsInstanceDto map(NsInstance o);

	@Mapping(target = "scaleLevel", ignore = true)
	@Mapping(target = "aspectId", source = "nsScalingAspectId")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "vnfdId", ignore = true)
	com.ubiqube.etsi.mano.dao.mano.ScaleInfo map(com.ubiqube.etsi.mano.v361.model.nfvo.nslcm.NsScaleInfo o);

	@Mapping(target = "vimId", ignore = true)
	@Mapping(target = "vnfPkgId", ignore = true)
	VnfInstanceDto map(VnfInstance o);

	@Mapping(target = "virtualStorageResourceInfo", source = "vnfVirtualStorageResourceInfo")
	VnfInstanceInstantiatedVnfInfoDto map(VnfInstanceInstantiatedVnfInfo o);

	@Mapping(target = "containerNamespace", ignore = true)
	@Mapping(target = "vimLevelAdditionalResourceInfo", ignore = true)
	com.ubiqube.etsi.mano.dao.mano.alarm.ResourceHandle mapResourceHandleToResourceHandle(ResourceHandle o);

	@Mapping(target = "audit", ignore = true)
	com.ubiqube.etsi.mano.dao.mano.VnfMonitoringParameter map(com.ubiqube.etsi.mano.v361.model.em.vnflcm.MonitoringParameter o);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "numberOfSteps", ignore = true)
	@Mapping(target = "scaleType", ignore = true)
	VnfScaleInfo mapToVnfScaleInfo(ScaleInfo o);

	@Mapping(target = "audit", ignore = true)
	VnfMonitoringParameter map(com.ubiqube.etsi.mano.v361.model.nfvo.nslcm.VnfMonitoringParameter o);

	@Mapping(target = "classifier", ignore = true)
	@Mapping(target = "description", ignore = true)
	@Mapping(target = "name", ignore = true)
	@Mapping(target = "nestedNsProfileId", ignore = true)
	@Mapping(target = "nfpd", ignore = true)
	@Mapping(target = "pnfProfileId", ignore = true)
	@Mapping(target = "virtualLinkProfileId", ignore = true)
	@Mapping(target = "vnfProfileId", ignore = true)
	VnffgDescriptor map(VnffgInfo o);

	@Nullable
	default Set<NsCpHandle> mapSet(final @Nullable com.ubiqube.etsi.mano.v361.model.nfvo.nslcm.NsCpHandle value) {
		if (null == value) {
			return Set.of();
		}
		return Set.of(map(value));
	}

	@Mapping(target = "id", ignore = true)
	NsCpHandle map(com.ubiqube.etsi.mano.v361.model.nfvo.nslcm.NsCpHandle o);

	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "zoneId", ignore = true)
	VirtualStorageResourceInfo map(com.ubiqube.etsi.mano.v361.model.em.vnflcm.VirtualStorageResourceInfo p);

	@Mapping(target = "aspectId", source = "nsScalingAspectId")
	@Mapping(target = "scaleLevel", source = "nsScaleLevelId")
	com.ubiqube.etsi.mano.dao.mano.ScaleInfo mapDbScaleInfo(NsScaleInfo o);

	@Mapping(target = "extensions", ignore = true)
	@Mapping(target = "instantiatedVnfInfo", ignore = true)
	@Mapping(target = "instantiationState", ignore = true)
	@Mapping(target = "metadata", ignore = true)
	@Mapping(target = "vimId", ignore = true)
	@Mapping(target = "vnfConfigurableProperties", ignore = true)
	@Mapping(target = "vnfInstanceDescription", ignore = true)
	@Mapping(target = "vnfInstanceName", ignore = true)
	@Mapping(target = "vnfPkgId", ignore = true)
	@Mapping(target = "vnfProductName", ignore = true)
	@Mapping(target = "vnfProvider", ignore = true)
	@Mapping(target = "vnfSoftwareVersion", ignore = true)
	@Mapping(target = "vnfdId", ignore = true)
	@Mapping(target = "vnfdVersion", ignore = true)
	VnfInstanceDto map(NsVnfInstance o);

	@Mapping(target = "flavourId", ignore = true)
	@Mapping(target = "links", ignore = true)
	@Mapping(target = "nestedNsInstanceId", ignore = true)
	@Mapping(target = "nsState", ignore = true)
	@Mapping(target = "nsdId", ignore = true)
	@Mapping(target = "nsdInfoId", ignore = true)
	@Mapping(target = "pnfInfo", ignore = true)
	@Mapping(target = "virtualLinkInfo", ignore = true)
	NsInstance map(NsdInstance o);

	@Mapping(target = "isDynamic", ignore = true)
	IpOverEthernetAddressInfoIpAddresses map(IpOverEthernetAddressDataIpAddressesEntity o);

	@ValueMapping(source = "IP_FOR_VIRTUAL_CP", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "ETHERNET", target = MappingConstants.THROW_EXCEPTION)
	CpProtocolInfo.LayerProtocolEnum map(CpProtocolInfoEntity.LayerProtocolEnum o);
}
