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
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.ubiqube.etsi.mano.v351.service.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.dao.mano.alarm.AlarmNotification;
import com.ubiqube.etsi.mano.v351.model.vnfm.vnfm.AlarmClearedNotification;
import com.ubiqube.etsi.mano.v351.model.vnfm.vnfm.AlarmListRebuiltNotification;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AlarmsNotification351Mapping extends Alarm351Mapping {

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

}
