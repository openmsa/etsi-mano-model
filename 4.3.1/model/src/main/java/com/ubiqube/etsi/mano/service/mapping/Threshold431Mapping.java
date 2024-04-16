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

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.dao.mano.pm.MonResource;
import com.ubiqube.etsi.mano.dao.mano.pm.Threshold;
import com.ubiqube.etsi.mano.em.v431.model.vnfpm.CreateThresholdRequest;
import com.ubiqube.etsi.mano.em.v431.model.vnfpm.ThresholdModifications;

import jakarta.annotation.Nullable;
import jakarta.validation.Valid;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface Threshold431Mapping extends StringToUriMapping {
	@Mapping(target = "remoteResource", ignore = true)
	@Mapping(target = "subscription", ignore = true)
	Threshold map(com.ubiqube.etsi.mano.em.v431.model.vnfpm.Threshold o);

	@Nullable
	default MonResource mapMonResource(final @Nullable String value) {
		if (null == value) {
			return null;
		}
		final MonResource mr = new MonResource();
		mr.setResource(value);
		return mr;
	}

	Set<MonResource> map(List<String> subObjectInstanceIds);

	@Mapping(target = "links", ignore = true)
	com.ubiqube.etsi.mano.em.v431.model.vnfpm.Threshold map(Threshold o);

	List<String> map(Set<MonResource> value);

	@Nullable
	default String map(final @Nullable MonResource value) {
		if (null == value) {
			return null;
		}
		return value.getResource();
	}

	@Mapping(target = "authentication", ignore = true)
	ThresholdModifications mapToThresholdModifications(Threshold o);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "remoteResource", ignore = true)
	@Mapping(target = "subscription", ignore = true)
	Threshold map(@Valid CreateThresholdRequest createThresholdRequest);
}
