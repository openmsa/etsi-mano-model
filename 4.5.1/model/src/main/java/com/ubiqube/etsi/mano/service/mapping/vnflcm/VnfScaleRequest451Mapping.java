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
package com.ubiqube.etsi.mano.service.mapping.vnflcm;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.em.v451.model.vnflcm.ScaleVnfRequest;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.ScaleVnfToLevelRequest;
import com.ubiqube.etsi.mano.model.VnfScaleRequest;
import com.ubiqube.etsi.mano.model.VnfScaleToLevelRequest;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VnfScaleRequest451Mapping {
	@Mapping(target = "instantiationLevelId", ignore = true)
	@Mapping(target = "scaleInfo", ignore = true)
	VnfScaleRequest map(ScaleVnfRequest o);

	VnfScaleToLevelRequest map(ScaleVnfToLevelRequest o);
}
