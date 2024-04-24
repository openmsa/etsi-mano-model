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
package com.ubiqube.etsi.mano.v261.service.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfIndicatorValueChangeNotification;
import com.ubiqube.etsi.mano.dao.mano.ind.VnfIndiValueChangeNotification;
import com.ubiqube.etsi.mano.dao.mano.pm.PerformanceInformationAvailableNotification;
import com.ubiqube.etsi.mano.dao.mano.pm.ThresholdCrossedNotification;
import com.ubiqube.etsi.mano.service.mapping.DateTimeMapping;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PmJobNotification261Mapping extends DateTimeMapping {

	@Mapping(target = "nfvoId", ignore = true)
	@Mapping(target = "vnfdId", ignore = true)
	@Mapping(target = "value", ignore = true)
	VnfIndiValueChangeNotification map(VnfIndicatorValueChangeNotification body);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "notificationType", ignore = true)
	@Mapping(target = "objectInstanceId", ignore = true)
	@Mapping(target = "objectType", ignore = true)
	@Mapping(target = "subObjectInstanceIds", ignore = true)
	@Mapping(target = "timeStamp", ignore = true)
	@Mapping(target = "pmJobId", ignore = true)
	@Mapping(target = "nfvoId", ignore = true)
	@Mapping(target = "subscriptionId", ignore = true)
	PerformanceInformationAvailableNotification map(com.ubiqube.etsi.mano.v261.model.nfvo.nsperfo.PerformanceInformationAvailableNotification body);

	@Mapping(target = "context", ignore = true)
	@Mapping(target = "crossingDirection", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "notificationType", ignore = true)
	@Mapping(target = "objectInstanceId", ignore = true)
	@Mapping(target = "objectType", ignore = true)
	@Mapping(target = "performanceMetric", ignore = true)
	@Mapping(target = "subObjectInstanceId", ignore = true)
	@Mapping(target = "thresholdId", ignore = true)
	@Mapping(target = "timeStamp", ignore = true)
	@Mapping(target = "nfvoId", ignore = true)
	@Mapping(target = "subscriptionId", ignore = true)
	@Mapping(target = "performanceValue", ignore = true)
	ThresholdCrossedNotification map(com.ubiqube.etsi.mano.v261.model.nfvo.nsperfo.ThresholdCrossedNotification body);

}
