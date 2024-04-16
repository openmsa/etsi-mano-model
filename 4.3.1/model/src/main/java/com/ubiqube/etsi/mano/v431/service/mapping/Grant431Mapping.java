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
package com.ubiqube.etsi.mano.v431.service.mapping;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.dao.mano.GrantInformationExt;
import com.ubiqube.etsi.mano.dao.mano.GrantResponse;
import com.ubiqube.etsi.mano.dao.mano.GrantVimAssetsEntity;
import com.ubiqube.etsi.mano.dao.mano.ScaleInfo;
import com.ubiqube.etsi.mano.dao.mano.StorageAsset;
import com.ubiqube.etsi.mano.dao.mano.ZoneGroupInformation;
import com.ubiqube.etsi.mano.dao.mano.ZoneInfoEntity;
import com.ubiqube.etsi.mano.dao.mano.grant.ConstraintResourceRef;
import com.ubiqube.etsi.mano.dao.mano.grant.PlacementConstraint;
import com.ubiqube.etsi.mano.dao.mano.grant.SnapshotResourceDefinitionEntity;
import com.ubiqube.etsi.mano.dao.mano.grant.VimConstraint;
import com.ubiqube.etsi.mano.v431.model.vnfm.grant.Grant;
import com.ubiqube.etsi.mano.v431.model.vnfm.grant.GrantInfo;
import com.ubiqube.etsi.mano.v431.model.vnfm.grant.GrantRequest;
import com.ubiqube.etsi.mano.v431.model.vnfm.grant.GrantVimAssets;
import com.ubiqube.etsi.mano.v431.model.vnfm.grant.ResourceDefinition;
import com.ubiqube.etsi.mano.v431.model.vnfm.grant.SnapshotResourceDefinition;
import com.ubiqube.etsi.mano.v431.model.vnfm.grant.ZoneGroupInfo;
import com.ubiqube.etsi.mano.v431.model.vnfm.grant.ZoneInfo;

import jakarta.annotation.Nullable;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface Grant431Mapping extends VimConnectionInfo431Mapping, Connectivity431Mapping {

	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "id", ignore = true)
	VimConstraint map(com.ubiqube.etsi.mano.v431.model.vnfm.grant.VimConstraint o);

	@Mapping(target = "scaleLevel", source = "scaleToLevel")
	@Mapping(target = "id", ignore = true)
	ScaleInfo map(com.ubiqube.etsi.mano.v431.model.em.vnflcm.ScaleInfo o);

	@Mapping(target = "containerNamespace", ignore = true)
	@Mapping(target = "mcioConstraints", ignore = true)
	@Mapping(target = "reservationId", ignore = true)
	@Mapping(target = "resourceDefinitionId", ignore = true)
	@Mapping(target = "resourceGroupId", ignore = true)
	@Mapping(target = "resourceId", ignore = true)
	@Mapping(target = "resourceProviderId", ignore = true)
	@Mapping(target = "vimConnectionId", ignore = true)
	@Mapping(target = "vimLevelAdditionalResourceInfo", ignore = true)
	@Mapping(target = "vimLevelResourceType", ignore = true)
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
	SnapshotResourceDefinitionEntity map(SnapshotResourceDefinition o);

	@Mapping(target = "id", ignore = true)
	ConstraintResourceRef map(com.ubiqube.etsi.mano.v431.model.vnfm.grant.ConstraintResourceRef o);

	@Mapping(target = "links", ignore = true)
	@Mapping(target = "vimConnectionInfo", source = "vimConnections")
	Grant map(GrantResponse grantResponse);

	@Mapping(target = "paasAssets", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "automaticInvocation", ignore = true)
	@Mapping(target = "available", ignore = true)
	@Mapping(target = "computeReservationId", ignore = true)
	@Mapping(target = "dstVnfdId", ignore = true)
	@Mapping(target = "error", ignore = true)
	@Mapping(target = "flavourId", ignore = true)
	@Mapping(target = "instanceLink", ignore = true)
	@Mapping(target = "instantiationLevelId", ignore = true)
	@Mapping(target = "lcmLink", ignore = true)
	@Mapping(target = "networkReservationId", ignore = true)
	@Mapping(target = "operation", ignore = true)
	@Mapping(target = "placementConstraints", ignore = true)
	@Mapping(target = "storageReservationId", ignore = true)
	@Mapping(target = "targetScaleLevelInfo", ignore = true)
	@Mapping(target = "vimConnections", source = "vimConnectionInfo")
	@Mapping(target = "vimConstraints", ignore = true)
	@Mapping(target = "vnfdId", ignore = true)
	GrantResponse map(Grant grant);

	GrantVimAssetsEntity map(GrantVimAssets gva);

	@Mapping(target = "id", ignore = true)
	StorageAsset map(com.ubiqube.etsi.mano.v431.model.vnfm.grant.StorageAsset o);

	GrantVimAssets map(GrantVimAssetsEntity gvae);

	@Mapping(target = "grants", ignore = true)
	ZoneInfoEntity map(ZoneInfo zi);

	@Mapping(target = "id", ignore = true)
	ZoneGroupInformation map(ZoneGroupInfo zgi);

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
	PlacementConstraint map(com.ubiqube.etsi.mano.v431.model.vnfm.grant.PlacementConstraint o);
}
