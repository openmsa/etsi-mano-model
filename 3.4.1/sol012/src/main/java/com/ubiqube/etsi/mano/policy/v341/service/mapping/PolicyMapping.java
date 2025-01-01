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
package com.ubiqube.etsi.mano.policy.v341.service.mapping;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.controller.policy.PolicyPatchDto;
import com.ubiqube.etsi.mano.dao.mano.policy.Policies;
import com.ubiqube.etsi.mano.dao.mano.policy.PolicyVersion;
import com.ubiqube.etsi.mano.policy.v341.model.Policy;
import com.ubiqube.etsi.mano.policy.v341.model.PolicyModifications;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PolicyMapping {

	@Mapping(target = "version", ignore = true)
	Policies map(Policy o);

	List<PolicyVersion> map(List<String> value);

	default PolicyVersion map(final String value) {
		if (null == value) {
			return null;
		}
		return new PolicyVersion(value, null);
	}

	default String map(final PolicyVersion o) {
		if (o == null) {
			return null;
		}
		return o.getVersion();
	}

	@Mapping(target = "links", ignore = true)
	Policy map(Policies o);

	PolicyPatchDto map(PolicyModifications body);

}
