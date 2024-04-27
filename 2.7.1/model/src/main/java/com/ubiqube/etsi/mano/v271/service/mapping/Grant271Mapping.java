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
package com.ubiqube.etsi.mano.v271.service.mapping;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;

import com.ubiqube.etsi.mano.dao.mano.GrantInformationExt;
import com.ubiqube.etsi.mano.dao.mano.GrantResponse;
import com.ubiqube.etsi.mano.dao.mano.GrantVimAssetsEntity;
import com.ubiqube.etsi.mano.dao.mano.ResourceTypeEnum;
import com.ubiqube.etsi.mano.dao.mano.ScaleInfo;
import com.ubiqube.etsi.mano.dao.mano.ZoneGroupInformation;
import com.ubiqube.etsi.mano.dao.mano.ZoneInfoEntity;
import com.ubiqube.etsi.mano.dao.mano.grant.ConstraintResourceRef;
import com.ubiqube.etsi.mano.dao.mano.grant.PlacementConstraint;
import com.ubiqube.etsi.mano.dao.mano.grant.VimConstraint;
import com.ubiqube.etsi.mano.v271.model.sol003.lcmgrant.Grant;
import com.ubiqube.etsi.mano.v271.model.sol003.lcmgrant.GrantInfo;
import com.ubiqube.etsi.mano.v271.model.sol003.lcmgrant.GrantRequest;
import com.ubiqube.etsi.mano.v271.model.sol003.lcmgrant.GrantVimAssets;
import com.ubiqube.etsi.mano.v271.model.sol003.lcmgrant.ResourceDefinition;
import com.ubiqube.etsi.mano.v271.model.sol003.lcmgrant.ZoneGroupInfo;
import com.ubiqube.etsi.mano.v271.model.sol003.lcmgrant.ZoneInfo;

import jakarta.annotation.Nullable;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface Grant271Mapping extends VimConnectionInfo271Mapping, Connectivity271Mapping, VimResource271Mapping {

	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "id", ignore = true)
	VimConstraint map(com.ubiqube.etsi.mano.v271.model.sol003.lcmgrant.VimConstraint o);

	@Mapping(target = "vnfdId", ignore = true)
	@Mapping(target = "scaleToLevel", ignore = true)
	@Mapping(target = "id", ignore = true)
	ScaleInfo map(com.ubiqube.etsi.mano.v271.model.em.vnflcm.ScaleInfo o);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "snapshotResDef", ignore = true)
	@Mapping(target = "vnfdId", ignore = true)
	@Mapping(target = "secondaryResourceTemplateId", ignore = true)
	@Mapping(target = "reservationId", ignore = true)
	@Mapping(target = "resourceDefinitionId", source = "id")
	@Mapping(target = "resourceGroupId", ignore = true)
	@Mapping(target = "vimLevelAdditionalResourceInfo", ignore = true)
	@Mapping(target = "containerNamespace", ignore = true)
	@Mapping(target = "mcioConstraints", ignore = true)
	@Mapping(target = ".", source = "resource")
	@Mapping(target = "zoneId", ignore = true)
	GrantInformationExt map(ResourceDefinition o);

	@Nullable
	default Set<String> map(final @Nullable String value) {
		if (null == value) {
			return null;
		}
		return Set.of(value);
	}

	@Mapping(target = "id", ignore = true)
	ConstraintResourceRef map(com.ubiqube.etsi.mano.v271.model.sol003.lcmgrant.ConstraintResourceRef o);

	@Mapping(target = "links", ignore = true)
	Grant map(GrantResponse grantResponse);

	@Mapping(target = "cirConnectionInfo", ignore = true)
	@Mapping(target = "mciopRepositoryInfo", ignore = true)
	@Mapping(target = "paasAssets", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "automaticInvocation", ignore = true)
	@Mapping(target = "available", ignore = true)
	@Mapping(target = "dstVnfdId", ignore = true)
	@Mapping(target = "error", ignore = true)
	@Mapping(target = "flavourId", ignore = true)
	@Mapping(target = "instanceLink", source = "links.vnfInstance.href")
	@Mapping(target = "instantiationLevelId", ignore = true)
	@Mapping(target = "lcmLink", source = "links.vnfLcmOpOcc.href")
	@Mapping(target = "operation", ignore = true)
	@Mapping(target = "placementConstraints", ignore = true)
	@Mapping(target = "targetScaleLevelInfo", ignore = true)
	@Mapping(target = "vimConstraints", ignore = true)
	@Mapping(target = "vnfdId", ignore = true)
	GrantResponse map(Grant grant);

	@Mapping(target = "snapshotResources", ignore = true)
	@Mapping(target = "storageAssets", ignore = true)
	GrantVimAssetsEntity map(GrantVimAssets gva);

	GrantVimAssets map(GrantVimAssetsEntity gvae);

	@Mapping(target = "grants", ignore = true)
	ZoneInfoEntity map(ZoneInfo zi);

	@Mapping(target = "id", ignore = true)
	ZoneGroupInformation map(ZoneGroupInfo zgi);

	@Mapping(target = "containerNamespace", ignore = true)
	@Mapping(target = "mcioConstraints", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "resourceId", ignore = true)
	@Mapping(target = "resourceTemplateId", ignore = true)
	@Mapping(target = "secondaryResourceTemplateId", ignore = true)
	@Mapping(target = "snapshotResDef", ignore = true)
	@Mapping(target = "type", ignore = true)
	@Mapping(target = "vduId", ignore = true)
	@Mapping(target = "vimLevelAdditionalResourceInfo", ignore = true)
	@Mapping(target = "vimLevelResourceType", ignore = true)
	@Mapping(target = "vnfdId", ignore = true)
	GrantInformationExt map(GrantInfo gi);

	GrantInfo map(GrantInformationExt gie);

	@Mapping(target = "dstVnfdId", ignore = true)
	@Mapping(target = "targetScaleLevelInfo", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "automaticInvocation", ignore = true)
	@Mapping(target = "available", ignore = true)
	@Mapping(target = "cirConnectionInfo", ignore = true)
	@Mapping(target = "computeReservationId", ignore = true)
	@Mapping(target = "error", ignore = true)
	@Mapping(target = "extManagedVirtualLinks", ignore = true)
	@Mapping(target = "extVirtualLinks", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "instanceLink", source = "links.vnfInstance.href")
	@Mapping(target = "lcmLink", source = "links.vnfLcmOpOcc.href")
	@Mapping(target = "mciopRepositoryInfo", ignore = true)
	@Mapping(target = "networkReservationId", ignore = true)
	@Mapping(target = "paasAssets", ignore = true)
	@Mapping(target = "storageReservationId", ignore = true)
	@Mapping(target = "vimAssets", ignore = true)
	@Mapping(target = "vimConnections", ignore = true)
	@Mapping(target = "zoneGroups", ignore = true)
	@Mapping(target = "zones", ignore = true)
	GrantResponse map(GrantRequest body);

	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "id", ignore = true)
	PlacementConstraint map(com.ubiqube.etsi.mano.v271.model.sol003.lcmgrant.PlacementConstraint o);

	@Mapping(target = "id", source = "resourceDefinitionId")
	@Mapping(target = "resource", source = ".", conditionExpression = "java(isNotEmptyResource(o))")
	ResourceDefinition mapToResourceDefinition(GrantInformationExt o);

	default boolean isNotEmptyResource(final GrantInformationExt o) {
		return o.getResourceId() != null;
	}

	@Nullable
	default String mapString(final @Nullable Set<String> value) {
		if ((null == value) || value.isEmpty()) {
			return null;
		}
		return value.iterator().next();
	}

	@ValueMapping(source = "OSCONTAINER", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "VIRTUALCP", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "AFFINITY_RULE", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "DNSHOST", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "DNSZONE", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "HELM", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "MCIOP_USER", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "MONITORING", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "NETWORK", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "NSD_CREATE", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "NSD_EXTRACTOR", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "NSD_INSTANTIATE", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "OS_CONTAINER", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "OS_CONTAINER_DEPLOYABLE", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "OS_CONTAINER_INFO", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "PAASSERVICE", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "SECURITY_GROUP", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "SUBNETWORK", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "TF_NETWORK_POLICY", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "TF_PORT_TUPLE", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "TF_PT_LINK", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "TF_SERVICE_INSTANCE", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "TF_SERVICE_TEMPLATE", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "VNFFG", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "VNFFG_LOADBALANCER", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "VNFFG_PORT_PAIR", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "VNFFG_POST", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "VNF_CREATE", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "VNF_EXTCP", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "VNF_EXTRACTOR", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "VNF_INDICATOR", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "VNF_INSTANTIATE", target = MappingConstants.THROW_EXCEPTION)
	ResourceDefinition.TypeEnum map(ResourceTypeEnum o);

	@Mapping(target = "isAutomaticInvocation", source = "automaticInvocation")
	@Mapping(target = "links.vnfInstance.href", source = "instanceLink")
	@Mapping(target = "links.vnfLcmOpOcc.href", source = "lcmLink")
	GrantRequest mapToRequest(GrantResponse grantResponse);

	@ValueMapping(source = "CIS_NODE", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "CONTAINER_NAMESPACE", target = MappingConstants.THROW_EXCEPTION)
	com.ubiqube.etsi.mano.v271.model.sol003.lcmgrant.PlacementConstraint.ScopeEnum map(PlacementConstraint.ScopeEnum o);

}
