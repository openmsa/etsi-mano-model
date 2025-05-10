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
package com.ubiqube.etsi.mano.v261.service.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;

import com.ubiqube.etsi.mano.dao.mano.alarm.AckState;
import com.ubiqube.etsi.mano.dao.mano.alarm.AlarmNotification;
import com.ubiqube.etsi.mano.dao.mano.alarm.Alarms;
import com.ubiqube.etsi.mano.dao.mano.alarm.ResourceHandle;
import com.ubiqube.etsi.mano.dao.mano.vim.ResourceTypeEnum;
import com.ubiqube.etsi.mano.service.mapping.DateTimeMapping;
import com.ubiqube.etsi.mano.v261.model.nfvo.nsfm.Alarm;
import com.ubiqube.etsi.mano.v261.model.nfvo.nsfm.AlarmModifications;
import com.ubiqube.etsi.mano.v261.model.nfvo.nsfm.FaultyResourceType;
import com.ubiqube.etsi.mano.v261.model.vnfm.vrqan.AlarmClearedNotification;
import com.ubiqube.etsi.mano.v261.model.vnfm.vrqan.AlarmListRebuiltNotification;

import jakarta.validation.Valid;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface Alarm261Mapping extends DateTimeMapping {

	@Mapping(target = "rootCauseFaultyComponent", ignore = true)
	@Mapping(target = "isRootCause", source = "rootCause")
	@Mapping(target = "links", ignore = true)
	Alarm map(Alarms o);

	@Mapping(target = "vnfcInstanceIds", ignore = true)
	@Mapping(target = "alarmAcknowledgedTime", source = "alarmClearedTime")
	@Mapping(target = "rootCause", source = "isRootCause")
	@Mapping(target = "version", ignore = true)
	Alarms map(Alarm o);

	@Mapping(target = "containerNamespace", ignore = true)
	@Mapping(target = "vimLevelAdditionalResourceInfo", ignore = true)
	ResourceHandle map(com.ubiqube.etsi.mano.common.v261.model.ResourceHandle o);

	@ValueMapping(source = MappingConstants.ANY_REMAINING, target = "NETWORK")
	FaultyResourceType map(ResourceTypeEnum o);

	ResourceTypeEnum map(FaultyResourceType o);

	AlarmModifications mapAlarmModifications(Alarms o);

	@ValueMapping(source = "UNACKNOWLEDGED", target = MappingConstants.THROW_EXCEPTION)
	AlarmModifications.AckStateEnum map(AckState o);

	@Mapping(target = "alarmClearedTime", ignore = true)
	@Mapping(target = "alarmId", ignore = true)
	@Mapping(target = "nfvoId", ignore = true)
	AlarmNotification map(AlarmNotification o);

	@Mapping(target = "alarm", ignore = true)
	@Mapping(target = "nfvoId", ignore = true)
	AlarmNotification map(AlarmClearedNotification body);

	@Mapping(target = "alarm", ignore = true)
	@Mapping(target = "alarmClearedTime", ignore = true)
	@Mapping(target = "alarmId", ignore = true)
	@Mapping(target = "nfvoId", ignore = true)
	AlarmNotification map(AlarmListRebuiltNotification body);

	@Mapping(target = "alarmClearedTime", ignore = true)
	@Mapping(target = "alarmId", ignore = true)
	@Mapping(target = "nfvoId", ignore = true)
	AlarmNotification map(com.ubiqube.etsi.mano.v261.model.vnfm.vnffm.@Valid AlarmNotification body);

}
