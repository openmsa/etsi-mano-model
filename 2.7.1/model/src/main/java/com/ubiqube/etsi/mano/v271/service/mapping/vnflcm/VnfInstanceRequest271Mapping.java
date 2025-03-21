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
package com.ubiqube.etsi.mano.v271.service.mapping.vnflcm;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;

import com.ubiqube.etsi.mano.dao.mano.nsd.upd.ChangeVnfFlavourData;
import com.ubiqube.etsi.mano.dao.mano.nsd.upd.StopType;
import com.ubiqube.etsi.mano.dao.mano.vnfi.ChangeExtVnfConnRequest;
import com.ubiqube.etsi.mano.model.CommScaleInfo;
import com.ubiqube.etsi.mano.model.VnfHealRequest;
import com.ubiqube.etsi.mano.model.VnfOperateRequest;
import com.ubiqube.etsi.mano.model.VnfScaleRequest;
import com.ubiqube.etsi.mano.model.VnfScaleToLevelRequest;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.ChangeExtVnfConnectivityRequest;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.HealVnfRequest;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.OperateVnfRequest;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.ScaleInfo;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.ScaleVnfRequest;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.ScaleVnfToLevelRequest;
import com.ubiqube.etsi.mano.v271.service.mapping.Connectivity271Mapping;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VnfInstanceRequest271Mapping extends Connectivity271Mapping {

	ChangeExtVnfConnRequest map(ChangeExtVnfConnRequest o);

	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "vimConnectionInfo", ignore = true)
	ChangeExtVnfConnRequest map(ChangeExtVnfConnectivityRequest o);

	@Mapping(target = "gracefulStopTimeout", ignore = true)
	VnfOperateRequest map(OperateVnfRequest o);

	@Mapping(target = "instantiationLevelId", ignore = true)
	@Mapping(target = "scaleInfo", ignore = true)
	VnfScaleRequest map(ScaleVnfRequest o);

	VnfScaleToLevelRequest map(ScaleVnfToLevelRequest o);

	ScaleVnfToLevelRequest map(VnfScaleToLevelRequest req);

	ScaleInfo map(CommScaleInfo o);

	@Mapping(target = "vnfcInstanceId", ignore = true)
	HealVnfRequest map(VnfHealRequest req);

	@Mapping(target = "vnfcInstanceId", ignore = true)
	OperateVnfRequest map(VnfOperateRequest req);

	@ValueMapping(source = "GRACEFUL", target = MappingConstants.THROW_EXCEPTION)
	OperateVnfRequest.StopTypeEnum map(StopType o);

	@Mapping(target = "extManagedVirtualLinks", ignore = true)
	@Mapping(target = "extVirtualLinks", ignore = true)
	com.ubiqube.etsi.mano.v271.model.sol005.nslcm.ChangeVnfFlavourData map(ChangeVnfFlavourData req);
}
