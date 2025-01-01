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
package com.ubiqube.etsi.mano.v331.service.mapping.pkg;

import java.net.URI;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.dao.mano.pkg.UploadUriParameters;
import com.ubiqube.etsi.mano.v331.model.nfvo.vnf.UploadVnfPkgFromUriRequest;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UploadVnfPackageFromUriRequest331Mapping {

	@Mapping(target = "id", ignore = true)
	UploadUriParameters map(UploadVnfPkgFromUriRequest o);

	default URI toURI(final String string) {
		return URI.create(string);
	}
}
