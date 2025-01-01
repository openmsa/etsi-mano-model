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
package com.ubiqube.etsi.mano.v351.service.mapping.pkg;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.dao.mano.VnfPackageChangeNotification;
import com.ubiqube.etsi.mano.dao.mano.VnfPackageOnboardingNotification;

import jakarta.validation.Valid;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VnfPackageOnboardingNotification351Mapping {

	VnfPackageChangeNotification map(com.ubiqube.etsi.mano.v351.model.nfvo.vnf.@Valid VnfPackageChangeNotification body);

	@Mapping(target = "nfvoId", ignore = true)
	@Mapping(target = "version", ignore = true)
	@Mapping(target = "id", ignore = true)
	VnfPackageOnboardingNotification map(com.ubiqube.etsi.mano.v351.model.nfvo.vnf.@Valid VnfPackageOnboardingNotification body);

}
