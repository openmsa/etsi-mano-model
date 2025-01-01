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
package com.ubiqube.etsi.mano.v271.service.mapping.nslcm;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;

import com.ubiqube.etsi.mano.dao.mano.NestedNsInstanceData;
import com.ubiqube.etsi.mano.dao.mano.NsCpProtocolData;
import com.ubiqube.etsi.mano.dao.mano.VnfInstanceData;
import com.ubiqube.etsi.mano.dao.mano.VnfScaleInfo;
import com.ubiqube.etsi.mano.dao.mano.alarm.ResourceHandle;
import com.ubiqube.etsi.mano.dao.mano.dto.CreateNsInstance;
import com.ubiqube.etsi.mano.dao.mano.dto.ParamsForNestedNsd;
import com.ubiqube.etsi.mano.dao.mano.dto.nsi.NsInstantiate;
import com.ubiqube.etsi.mano.dao.mano.nfvo.ParamsForVnf;
import com.ubiqube.etsi.mano.dao.mano.nsd.upd.InstantiateVnfData;
import com.ubiqube.etsi.mano.dao.mano.nsd.upd.NfpData;
import com.ubiqube.etsi.mano.dao.mano.nsd.upd.UpdateRequest;
import com.ubiqube.etsi.mano.dao.mano.nsd.upd.UpdateTypeEnum;
import com.ubiqube.etsi.mano.dao.mano.nslcm.scale.HealVnfData;
import com.ubiqube.etsi.mano.dao.mano.nslcm.scale.LocConstCivicAddrElmnt;
import com.ubiqube.etsi.mano.dao.mano.nslcm.scale.LocationConstraints;
import com.ubiqube.etsi.mano.dao.mano.nslcm.scale.NsHeal;
import com.ubiqube.etsi.mano.dao.mano.nslcm.scale.NsScale;
import com.ubiqube.etsi.mano.dao.mano.nslcm.scale.NsScaleInfo;
import com.ubiqube.etsi.mano.dao.mano.nslcm.scale.ScaleByStepData;
import com.ubiqube.etsi.mano.dao.mano.nslcm.scale.ScaleNsByStepsData;
import com.ubiqube.etsi.mano.dao.mano.nslcm.scale.ScaleNsData;
import com.ubiqube.etsi.mano.dao.mano.nslcm.scale.ScaleNsToLevelData;
import com.ubiqube.etsi.mano.dao.mano.nslcm.scale.ScaleToLevelData;
import com.ubiqube.etsi.mano.dao.mano.nslcm.scale.ScaleVnfData;
import com.ubiqube.etsi.mano.dao.mano.nslcm.scale.VnfLocationConstraint;
import com.ubiqube.etsi.mano.service.mapping.DateTimeMapping;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.CpProtocolData;
import com.ubiqube.etsi.mano.v271.model.sol005.nslcm.ChangeVnfFlavourData;
import com.ubiqube.etsi.mano.v271.model.sol005.nslcm.CreateNsRequest;
import com.ubiqube.etsi.mano.v271.model.sol005.nslcm.HealNsRequest;
import com.ubiqube.etsi.mano.v271.model.sol005.nslcm.InstantiateNsRequest;
import com.ubiqube.etsi.mano.v271.model.sol005.nslcm.LocationConstraintsCivicAddressElement;
import com.ubiqube.etsi.mano.v271.model.sol005.nslcm.ParamsForNestedNs;
import com.ubiqube.etsi.mano.v271.model.sol005.nslcm.ScaleNsRequest;
import com.ubiqube.etsi.mano.v271.model.sol005.nslcm.UpdateNsRequest;

import jakarta.validation.Valid;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface NsRequest271Mapping extends DateTimeMapping {

	@Mapping(target = "id", ignore = true)
	NsHeal map(HealNsRequest o);

	@Mapping(target = "id", ignore = true)
	HealVnfData map(com.ubiqube.etsi.mano.v271.model.sol005.nslcm.HealVnfData o);

	@Mapping(target = "additionalParamForNestedNs", ignore = true)
	NsInstantiate map(InstantiateNsRequest body);

	@Mapping(target = "id", ignore = true)
	ParamsForNestedNsd mapToParamsForNestedNsd(ParamsForNestedNs o);

	@Mapping(target = "id", ignore = true)
	ParamsForVnf map(com.ubiqube.etsi.mano.v271.model.sol005.nslcm.ParamsForVnf o);

	@Mapping(target = "id", ignore = true)
	NestedNsInstanceData map(com.ubiqube.etsi.mano.v271.model.sol005.nslcm.NestedNsInstanceData o);

	@Mapping(target = "id", ignore = true)
	VnfInstanceData map(com.ubiqube.etsi.mano.v271.model.sol005.nslcm.VnfInstanceData o);

	@Mapping(target = "id", ignore = true)
	NsScale map(@Valid ScaleNsRequest body);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "nestedNslocationConstraints", ignore = true)
	@Mapping(target = "scaleVnfData", ignore = true)
	ScaleNsData map(com.ubiqube.etsi.mano.v271.model.sol005.nslcm.ScaleNsData o);

	@Mapping(target = "id", ignore = true)
	ScaleNsByStepsData map(com.ubiqube.etsi.mano.v271.model.sol005.nslcm.ScaleNsByStepsData o);

	@Mapping(target = "id", ignore = true)
	ScaleNsToLevelData map(com.ubiqube.etsi.mano.v271.model.sol005.nslcm.ScaleNsToLevelData o);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "scaleToLevel", ignore = true)
	@Mapping(target = "vnfdId", ignore = true)
	NsScaleInfo map(com.ubiqube.etsi.mano.v271.model.sol005.nslcm.NsScaleInfo o);

	@Mapping(target = "vnfInstanceId", ignore = true)
	@Mapping(target = "id", ignore = true)
	ScaleVnfData map(com.ubiqube.etsi.mano.v271.model.sol005.nslcm.ScaleVnfData o);

	@Mapping(target = "id", ignore = true)
	ScaleByStepData map(com.ubiqube.etsi.mano.v271.model.sol005.nslcm.ScaleByStepData o);

	@Mapping(target = "id", ignore = true)
	ScaleToLevelData map(com.ubiqube.etsi.mano.v271.model.sol005.nslcm.ScaleToLevelData o);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "numberOfSteps", ignore = true)
	@Mapping(target = "scaleType", ignore = true)
	VnfScaleInfo map(com.ubiqube.etsi.mano.v271.model.sol005.nslcm.VnfScaleInfo o);

	@Mapping(target = "id", ignore = true)
	VnfLocationConstraint map(com.ubiqube.etsi.mano.v271.model.sol005.nslcm.VnfLocationConstraint o);

	// Look at RFC 7946 for geo json encoding.
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "area", ignore = true)
	LocationConstraints map(com.ubiqube.etsi.mano.v271.model.sol005.nslcm.LocationConstraints o);

	@Mapping(target = "id", ignore = true)
	LocConstCivicAddrElmnt map(LocationConstraintsCivicAddressElement o);

	@Mapping(target = "addNsVirtualLinkData", ignore = true)
	@Mapping(target = "changeVnfPackageData", ignore = true)
	@Mapping(target = "createSnapshotData", ignore = true)
	@Mapping(target = "deleteNsVirtualLinkId", ignore = true)
	@Mapping(target = "deleteVnfSnapshotData", ignore = true)
	@Mapping(target = "modifyWanConnectionInfoData", ignore = true)
	@Mapping(target = "revertVnfToSnapshotData", ignore = true)
	@Mapping(target = "terminateVnfData", ignore = true)
	@Mapping(target = "realVnfInstanceToRemove", ignore = true)
	UpdateRequest map(UpdateNsRequest body);

	@Mapping(target = "extensions", ignore = true)
	@Mapping(target = "vnfConfigurableProperties", ignore = true)
	com.ubiqube.etsi.mano.dao.mano.nsd.upd.ChangeVnfFlavourData map(ChangeVnfFlavourData o);

	@Mapping(target = "vnfProfileId", ignore = true)
	InstantiateVnfData map(com.ubiqube.etsi.mano.v271.model.sol005.nslcm.InstantiateVnfData o);

	@Mapping(target = "addressData", ignore = true)
	@Mapping(target = "associatedLayerProtocol", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "id", ignore = true)
	NsCpProtocolData map(CpProtocolData o);

	@Mapping(target = "containerNamespace", ignore = true)
	@Mapping(target = "vimLevelAdditionalResourceInfo", ignore = true)
	ResourceHandle map(com.ubiqube.etsi.mano.v271.model.em.vnflcm.ResourceHandle o);

	@ValueMapping(source = "ADD_NESTED_NS", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "ADD_PNF", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "ADD_SAP", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "ASSOC_NEW_NSD_VERSION", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "CHANGE_NS_DF", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "MODIFY_PNF", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "REMOVE_NESTED_NS", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "REMOVE_PNF", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "REMOVE_SAP", target = MappingConstants.THROW_EXCEPTION)
	UpdateTypeEnum map(com.ubiqube.etsi.mano.v271.model.sol005.nslcm.UpdateNsRequest.UpdateTypeEnum o);

	NfpData map(com.ubiqube.etsi.mano.v271.model.sol005.nslcm.NfpData value);

	CreateNsInstance map(@Valid CreateNsRequest body);
}
