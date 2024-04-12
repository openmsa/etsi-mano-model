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

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.dao.mano.AdditionalResourceInfo;
import com.ubiqube.etsi.mano.dao.mano.GrantInformationExt;
import com.ubiqube.etsi.mano.dao.mano.GrantResponse;
import com.ubiqube.etsi.mano.dao.mano.ScaleInfo;
import com.ubiqube.etsi.mano.dao.mano.grant.ConstraintResourceRef;
import com.ubiqube.etsi.mano.dao.mano.grant.PlacementConstraint;
import com.ubiqube.etsi.mano.dao.mano.grant.SnapshotResourceDefinitionEntity;
import com.ubiqube.etsi.mano.dao.mano.grant.VimConstraint;
import com.ubiqube.etsi.mano.vnfm.v431.model.grant.GrantInfo;
import com.ubiqube.etsi.mano.vnfm.v431.model.grant.GrantRequest;
import com.ubiqube.etsi.mano.vnfm.v431.model.grant.ResourceDefinition;
import com.ubiqube.etsi.mano.vnfm.v431.model.grant.SnapshotResourceDefinition;

import jakarta.annotation.Nullable;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GrantRequest431Mapping {

	@Mapping(target = "paasAssets", ignore = true)
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
	@Mapping(target = "storageReservationId", ignore = true)
	@Mapping(target = "vimAssets", ignore = true)
	@Mapping(target = "vimConnections", ignore = true)
	@Mapping(target = "zoneGroups", ignore = true)
	@Mapping(target = "zones", ignore = true)
	GrantResponse map(GrantRequest o);

	@Nullable
	default Set<String> map(final @Nullable String value) {
		if (null == value) {
			return null;
		}
		return Set.of(value);
	}

	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "id", ignore = true)
	PlacementConstraint map(com.ubiqube.etsi.mano.vnfm.v431.model.grant.PlacementConstraint o);

	@Mapping(target = "id", ignore = true)
	ConstraintResourceRef map(com.ubiqube.etsi.mano.vnfm.v431.model.grant.ConstraintResourceRef o);

	@Mapping(target = "containerNamespace", source = "resource.containerNamespace")
	@Mapping(target = "mcioConstraints", ignore = true)
	@Mapping(target = "reservationId", ignore = true)
	@Mapping(target = "resourceDefinitionId", ignore = true)
	@Mapping(target = "resourceGroupId", ignore = true)
	@Mapping(target = "resourceId", source = "resource.resourceId")
	@Mapping(target = "resourceProviderId", source = "resource.resourceProviderId")
	@Mapping(target = "vimConnectionId", source = "resource.vimConnectionId")
	@Mapping(target = "vimLevelAdditionalResourceInfo", source = "resource.vimLevelAdditionalResourceInfo")
	@Mapping(target = "vimLevelResourceType", source = "resource.vimLevelResourceType")
	@Mapping(target = "zoneId", ignore = true)
	GrantInformationExt map(ResourceDefinition o);

	@Mapping(target = "scaleLevel", source = "scaleToLevel")
	@Mapping(target = "id", ignore = true)
	ScaleInfo map(com.ubiqube.etsi.mano.em.v431.model.vnflcm.ScaleInfo o);

	@Mapping(target = "id", ignore = true)
	AdditionalResourceInfo map(com.ubiqube.etsi.mano.em.v431.model.vnflcm.AdditionalResourceInfo o);

	@Mapping(target = "id", ignore = true)
	SnapshotResourceDefinitionEntity map(SnapshotResourceDefinition o);

	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "id", ignore = true)
	VimConstraint map(com.ubiqube.etsi.mano.vnfm.v431.model.grant.VimConstraint o);

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
}
