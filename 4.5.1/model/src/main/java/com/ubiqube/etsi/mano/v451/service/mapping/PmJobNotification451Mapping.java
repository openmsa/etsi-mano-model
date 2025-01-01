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
package com.ubiqube.etsi.mano.v451.service.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.dao.mano.ind.VnfIndiValueChangeNotification;
import com.ubiqube.etsi.mano.dao.mano.pm.PerformanceInformationAvailableNotification;
import com.ubiqube.etsi.mano.dao.mano.pm.ThresholdCrossedNotification;
import com.ubiqube.etsi.mano.service.mapping.DateTimeMapping;
import com.ubiqube.etsi.mano.v451.model.em.vnfind.VnfIndicatorValueChangeNotification;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PmJobNotification451Mapping extends DateTimeMapping {

	@Mapping(target = "nfvoId", ignore = true)
	@Mapping(target = "vnfdId", ignore = true)
	@Mapping(target = "value", ignore = true)
	VnfIndiValueChangeNotification map(VnfIndicatorValueChangeNotification body);

	@Mapping(target = "nfvoId", ignore = true)
	@Mapping(target = "subscriptionId", source = "id")
	PerformanceInformationAvailableNotification map(com.ubiqube.etsi.mano.v451.model.em.vnfpm.PerformanceInformationAvailableNotification body);

	@Mapping(target = "nfvoId", ignore = true)
	@Mapping(target = "subscriptionId", source = "id")
	@Mapping(target = "performanceValue", ignore = true)
	ThresholdCrossedNotification map(com.ubiqube.etsi.mano.v451.model.em.vnfpm.ThresholdCrossedNotification body);

}
