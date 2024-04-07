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

import com.ubiqube.etsi.mano.dao.mano.AdditionalResourceInfo;
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
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.ScaleInfo;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.VnfInstance;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.VnfInstanceInstantiatedVnfInfo;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.VnfcResourceInfo;
import com.ubiqube.etsi.mano.nfvo.v451.model.nslcm.NsInstance;
import com.ubiqube.etsi.mano.nfvo.v451.model.nslcm.NsVirtualLinkInfo;
import com.ubiqube.etsi.mano.nfvo.v451.model.nslcm.VnffgInfo;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface NsInstanceMapping {
	@Mapping(target = "additionalAffinityOrAntiAffinityRule", ignore = true)
	@Mapping(target = "dataFlowMirroringInfo", ignore = true)
	@Mapping(target = "monitoringParameter", ignore = true)
	@Mapping(target = "nestedNsInstanceId", ignore = true)
	@Mapping(target = "nsPaasServiceInfo", ignore = true)
	@Mapping(target = "pnfInfo", ignore = true)
	@Mapping(target = "priority", ignore = true)
	@Mapping(target = "sapInfo", ignore = true)
	@Mapping(target = "links", ignore = true)
	@Mapping(target = "versionDependency", ignore = true)
	@Mapping(target = "vnfSnapshotInfoIds", ignore = true)
	@Mapping(target = "wanConnectionInfo", ignore = true)
	NsInstance map(NsInstanceDto o);

	@Mapping(target = "nsScaleLevelId", source = "scaleLevel")
	@Mapping(target = "nsScalingAspectId", source = "aspectId")
	com.ubiqube.etsi.mano.nfvo.v451.model.nslcm.NsScaleInfo map(com.ubiqube.etsi.mano.dao.mano.ScaleInfo o);

	@Mapping(target = "nsScaleLevelId", source = "scaleLevel")
	@Mapping(target = "nsScalingAspectId", source = "aspectId")
	NsScaleInfo mapScaleInfo(com.ubiqube.etsi.mano.dao.mano.ScaleInfo o);

	@Mapping(target = "nsScaleLevelId", source = "scaleLevel")
	@Mapping(target = "nsScalingAspectId", source = "aspectId")
	NsScaleInfo mapNsScaleInfo(com.ubiqube.etsi.mano.dao.mano.ScaleInfo o);

	@Mapping(target = "certificateInfo", ignore = true)
	@Mapping(target = "links", ignore = true)
	@Mapping(target = "vimConnectionInfo", ignore = true)
	VnfInstance map(VnfInstanceDto o);

	@Mapping(target = "aspectId", source = "nsScalingAspectId")
	@Mapping(target = "scaleLevel", source = "nsScaleLevelId")
	ScaleInfo map(NsScaleInfo o);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "nsScaleLevelId", ignore = true)
	@Mapping(target = "nsScalingAspectId", ignore = true)
	NsScaleInfo map(ScaleInfo o);

	@Mapping(target = "linkPort", ignore = true)
	NsVirtualLinkInfo map(NsVirtualLinkInfoDto o);

	@Mapping(target = "nsVirtualLinkInfoId", ignore = true)
	@Mapping(target = "pnfdInfoId", ignore = true)
	@Mapping(target = "vnfInstanceId", ignore = true)
	VnffgInfo map(VnffgDescriptor o);

	@Mapping(target = "extCpInfo", ignore = true)
	@Mapping(target = "extManagedVirtualLinkInfo", ignore = true)
	@Mapping(target = "extVirtualLinkInfo", ignore = true)
	@Mapping(target = "mcioInfo", ignore = true)
	@Mapping(target = "selectedDeployableModule", ignore = true)
	@Mapping(target = "vipCpInfo", ignore = true)
	@Mapping(target = "virtualCpInfo", ignore = true)
	@Mapping(target = "vnfPaasServiceInfo", ignore = true)
	@Mapping(target = "vnfVirtualLinkResourceInfo", ignore = true)
	@Mapping(target = "vnfcInfo", ignore = true)
	VnfInstanceInstantiatedVnfInfo map(VnfInstanceInstantiatedVnfInfoDto o);

	@Mapping(target = "scaleLevel", ignore = true)
	@Mapping(target = "vnfdId", ignore = true)
	ScaleInfo map(VnfScaleInfo o);

	@Mapping(target = "certificateContentId", ignore = true)
	@Mapping(target = "vnfcCpInfo", ignore = true)
	VnfcResourceInfo map(VnfcResourceInfoDto vnfcResourceInfo);

	NsInstanceDto map(NsInstance o);

	@Mapping(target = "aspectId", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "scaleLevel", ignore = true)
	@Mapping(target = "vnfdId", ignore = true)
	com.ubiqube.etsi.mano.dao.mano.ScaleInfo map(com.ubiqube.etsi.mano.nfvo.v451.model.nslcm.NsScaleInfo o);

	@Mapping(target = "vimId", ignore = true)
	@Mapping(target = "vnfPkgId", ignore = true)
	VnfInstanceDto map(VnfInstance o);

	@Mapping(target = "audit", ignore = true)
	com.ubiqube.etsi.mano.dao.mano.VnfMonitoringParameter map(com.ubiqube.etsi.mano.em.v451.model.vnflcm.MonitoringParameter o);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "numberOfSteps", ignore = true)
	@Mapping(target = "scaleType", ignore = true)
	VnfScaleInfo mapToVnfScaleInfo(ScaleInfo o);

	@Mapping(target = "audit", ignore = true)
	VnfMonitoringParameter map(com.ubiqube.etsi.mano.nfvo.v451.model.nslcm.VnfMonitoringParameter o);

	@Mapping(target = "classifier", ignore = true)
	@Mapping(target = "description", ignore = true)
	@Mapping(target = "name", ignore = true)
	@Mapping(target = "nestedNsProfileId", ignore = true)
	@Mapping(target = "nfpd", ignore = true)
	@Mapping(target = "pnfProfileId", ignore = true)
	@Mapping(target = "virtualLinkProfileId", ignore = true)
	@Mapping(target = "vnfProfileId", ignore = true)
	VnffgDescriptor map(VnffgInfo o);

	@Mapping(target = "id", ignore = true)
	NsCpHandle map(com.ubiqube.etsi.mano.nfvo.v451.model.nslcm.NsCpHandle o);

	@Mapping(target = "id", ignore = true)
	AdditionalResourceInfo map(com.ubiqube.etsi.mano.em.v451.model.vnflcm.AdditionalResourceInfo o);

	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "zoneId", ignore = true)
	VirtualStorageResourceInfo map(com.ubiqube.etsi.mano.em.v451.model.vnflcm.VirtualStorageResourceInfo p);

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
}
