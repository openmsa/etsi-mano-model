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
package com.ubiqube.etsi.mano.v361.service.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;

import com.ubiqube.etsi.mano.dao.mano.ResourceTypeEnum;
import com.ubiqube.etsi.mano.dao.mano.alarm.Alarms;
import com.ubiqube.etsi.mano.dao.mano.alarm.ResourceHandle;
import com.ubiqube.etsi.mano.service.mapping.DateTimeMapping;
import com.ubiqube.etsi.mano.v361.model.em.vnffm.Alarm;
import com.ubiqube.etsi.mano.v361.model.em.vnffm.AlarmModifications;
import com.ubiqube.etsi.mano.v361.model.em.vnffm.FaultyResourceType;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface Alarm361Mapping extends DateTimeMapping {

	@Mapping(target = "isRootCause", source = "rootCause")
	@Mapping(target = "links", ignore = true)
	Alarm map(Alarms o);

	@Mapping(target = "rootCause", source = "isRootCause")
	@Mapping(target = "version", ignore = true)
	Alarms map(Alarm o);

	@Mapping(target = "containerNamespace", ignore = true)
	@Mapping(target = "vimLevelAdditionalResourceInfo", ignore = true)
	ResourceHandle map(com.ubiqube.etsi.mano.v361.model.em.vnflcm.ResourceHandle o);

	@ValueMapping(source = MappingConstants.ANY_REMAINING, target = "NETWORK")
	FaultyResourceType map(ResourceTypeEnum o);

	ResourceTypeEnum map(FaultyResourceType o);

	AlarmModifications mapAlarmModifications(Alarms o);
}
