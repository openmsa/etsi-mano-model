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
package com.ubiqube.etsi.mano.v261.service.mapping;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.dao.mano.pm.PerformanceReport;
import com.ubiqube.etsi.mano.dao.mano.pm.PmJob;
import com.ubiqube.etsi.mano.dao.mano.pm.PmReport;
import com.ubiqube.etsi.mano.service.mapping.DateTimeMapping;
import com.ubiqube.etsi.mano.v261.model.vnfm.nsperfo.CreatePmJobRequest;
import com.ubiqube.etsi.mano.v261.model.vnfm.nsperfo.PmJobReports;
import com.ubiqube.etsi.mano.v261.service.mapping.subscription.BaseSubscription261Mapping;

import jakarta.annotation.Nullable;
import jakarta.validation.Valid;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PmJob261Mapping extends BaseSubscription261Mapping, DateTimeMapping {

	@Mapping(target = "callbackUri", ignore = true)
	@Mapping(target = "objectType", ignore = true)
	@Mapping(target = "subObjectInstanceIds", ignore = true)
	@Mapping(target = "authentication", ignore = true)
	@Mapping(target = "remoteMonitoring", ignore = true)
	@Mapping(target = "resolvedSubObjectInstanceIds", ignore = true)
	@Mapping(target = "subscriptionRemoteId", ignore = true)
	@Mapping(target = "vimConnectionInformation", ignore = true)
	PmJob map(com.ubiqube.etsi.mano.v261.model.vnfm.nsperfo.PmJob o);

	@Mapping(target = "id", ignore = true)
	PmReport map(PmJobReports o);

	@Mapping(target = "links", ignore = true)
	com.ubiqube.etsi.mano.v261.model.vnfm.nsperfo.PmJob map(PmJob o);

	@Nullable
	default PmJobReports map(final @Nullable Set<PmReport> value) {
		if (null == value) {
			return null;
		}
		return map(value.iterator().next());
	}

	PmJobReports map(@Nullable PmReport next);

	@Nullable
	default Set<PmReport> mapToSet(final @Nullable PmJobReports value) {
		if (null == value) {
			return null;
		}
		return Set.of(map(value));
	}

	@Mapping(target = "authentication", ignore = true)
	@Mapping(target = "callbackUri", ignore = true)
	@Mapping(target = "objectType", ignore = true)
	@Mapping(target = "subObjectInstanceIds", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "remoteMonitoring", ignore = true)
	@Mapping(target = "reports", ignore = true)
	@Mapping(target = "resolvedSubObjectInstanceIds", ignore = true)
	@Mapping(target = "subscriptionRemoteId", ignore = true)
	@Mapping(target = "vimConnectionInformation", ignore = true)
	PmJob map(@Valid CreatePmJobRequest createPmJobRequest);

	@Mapping(target = "entries", ignore = true)
	com.ubiqube.etsi.mano.common.v261.model.nsperfo.PerformanceReport map(PerformanceReport x);

}
