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
package com.ubiqube.etsi.mano.v451.service.mapping;

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
import com.ubiqube.etsi.mano.dao.mano.grant.SnapshotResourceDefinitionEntity;
import com.ubiqube.etsi.mano.dao.mano.grant.VimConstraint;
import com.ubiqube.etsi.mano.dao.mano.paas.PaasAsset;
import com.ubiqube.etsi.mano.dao.mano.vim.VimConnectionInformation;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.PaasServiceHandle;
import com.ubiqube.etsi.mano.v451.model.vnfm.grant.Grant;
import com.ubiqube.etsi.mano.v451.model.vnfm.grant.GrantInfo;
import com.ubiqube.etsi.mano.v451.model.vnfm.grant.GrantVimAssets;
import com.ubiqube.etsi.mano.v451.model.vnfm.grant.PaasAssets;
import com.ubiqube.etsi.mano.v451.model.vnfm.grant.ResourceDefinition;
import com.ubiqube.etsi.mano.v451.model.vnfm.grant.SnapshotResourceDefinition;
import com.ubiqube.etsi.mano.v451.model.vnfm.grant.ZoneGroupInfo;
import com.ubiqube.etsi.mano.v451.model.vnfm.grant.ZoneInfo;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface Grant451Mapping extends VimConnectionInfo451Mapping, Connectivity451Mapping {

	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "id", ignore = true)
	VimConstraint map(com.ubiqube.etsi.mano.v451.model.vnfm.grant.VimConstraint o);

	@Mapping(target = "id", ignore = true)
	ScaleInfo map(com.ubiqube.etsi.mano.v451.model.em.vnflcm.ScaleInfo o);

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

	@Mapping(target = "id", ignore = true)
	SnapshotResourceDefinitionEntity map(SnapshotResourceDefinition o);

	@Mapping(target = "id", ignore = true)
	ConstraintResourceRef map(com.ubiqube.etsi.mano.v451.model.vnfm.grant.ConstraintResourceRef o);

	@Mapping(target = "links", ignore = true)
	@Mapping(target = "vimConnectionInfo", source = "vimConnections")
	Grant map(GrantResponse grantResponse);

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

	@Mapping(target = "id", ignore = true)
	PaasAsset map(PaasAssets o);

	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "cnfInfo", ignore = true)
	@Mapping(target = "jujuInfo", ignore = true)
	@Mapping(target = "tenantId", ignore = true)
	@Mapping(target = "version", ignore = true)
	@Mapping(target = "vimCapabilities", ignore = true)
	@Mapping(target = "vimId", ignore = true)
	@Mapping(target = "vimType", constant = "PAAS")
	VimConnectionInformation map(PaasServiceHandle o);

	GrantVimAssetsEntity map(GrantVimAssets gva);

	@Mapping(target = "id", ignore = true)
	StorageAsset map(com.ubiqube.etsi.mano.v451.model.vnfm.grant.StorageAsset o);

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
}
