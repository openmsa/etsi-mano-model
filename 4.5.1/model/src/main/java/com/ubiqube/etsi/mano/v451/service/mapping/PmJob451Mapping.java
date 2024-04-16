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

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.dao.mano.pm.PmJob;
import com.ubiqube.etsi.mano.dao.mano.pm.PmReport;
import com.ubiqube.etsi.mano.service.mapping.StringToUriMapping;
import com.ubiqube.etsi.mano.v451.model.em.vnfpm.PmJobReports;

import jakarta.annotation.Nullable;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PmJob451Mapping extends StringToUriMapping {

	@Mapping(target = "authentication", ignore = true)
	@Mapping(target = "remoteMonitoring", ignore = true)
	@Mapping(target = "resolvedSubObjectInstanceIds", ignore = true)
	@Mapping(target = "subscriptionRemoteId", ignore = true)
	@Mapping(target = "vimConnectionInformation", ignore = true)
	PmJob map(com.ubiqube.etsi.mano.v451.model.em.vnfpm.PmJob o);

	@Mapping(target = "id", ignore = true)
	PmReport map(PmJobReports o);

	@Mapping(target = "links", ignore = true)
	com.ubiqube.etsi.mano.v451.model.em.vnfpm.PmJob map(PmJob o);

	@Nullable
	default OffsetDateTime toOffsetDateTime(final @Nullable LocalDateTime localDateTime) {
		if (null == localDateTime) {
			return null;
		}
		return localDateTime.atOffset(ZoneOffset.UTC);
	}

	@Nullable
	default LocalDateTime toLocalDateTime(final @Nullable OffsetDateTime offsetDateTime) {
		if (null == offsetDateTime) {
			return null;
		}
		return offsetDateTime.toLocalDateTime();
	}

}
