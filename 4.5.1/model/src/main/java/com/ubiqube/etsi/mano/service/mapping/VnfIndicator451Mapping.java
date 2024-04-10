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

import com.ubiqube.etsi.mano.dao.mano.VnfIndicator;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VnfIndicator451Mapping {

	@Mapping(target = "value", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "indicators", ignore = true)
	@Mapping(target = "source", ignore = true)
	@Mapping(target = "state", ignore = true)
	@Mapping(target = "targets", ignore = true)
	@Mapping(target = "toscaId", ignore = true)
	@Mapping(target = "toscaName", source = "name")
	@Mapping(target = "triggers", ignore = true)
	VnfIndicator map(com.ubiqube.etsi.mano.em.v451.model.vnfind.VnfIndicator o);

	@Mapping(target = "links", ignore = true)
	@Mapping(target = "value", ignore = true)
	com.ubiqube.etsi.mano.em.v451.model.vnfind.VnfIndicator map(VnfIndicator o);
}
