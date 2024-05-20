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
package com.ubiqube.etsi.mano.v281.service.mapping.pkg;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;

import com.ubiqube.etsi.mano.dao.mano.pkg.ExternalArtifactsAccessConfig;
import com.ubiqube.etsi.mano.service.auth.model.AuthType;
import com.ubiqube.etsi.mano.service.mapping.StringToUriMapping;
import com.ubiqube.etsi.mano.v281.model.nfvo.vnf.ExternalArtifactsAccessConfigArtifact;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExternalArtifactsAccessConfig281Mapping extends StringToUriMapping {

	ExternalArtifactsAccessConfig map(com.ubiqube.etsi.mano.v281.model.nfvo.vnf.ExternalArtifactsAccessConfig o);

	@Mapping(target = "id", ignore = true)
	com.ubiqube.etsi.mano.dao.mano.pkg.ExternalArtifactsAccessConfigArtifact map(ExternalArtifactsAccessConfigArtifact o);

	com.ubiqube.etsi.mano.v281.model.nfvo.vnf.ExternalArtifactsAccessConfig map(ExternalArtifactsAccessConfig o);

	@Mapping(target = "password", ignore = true)
	@Mapping(target = "username", ignore = true)
	ExternalArtifactsAccessConfigArtifact map(com.ubiqube.etsi.mano.dao.mano.pkg.ExternalArtifactsAccessConfigArtifact o);

	@ValueMapping(source = "BASIC", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "TLS_CERT", target = MappingConstants.THROW_EXCEPTION)
	ExternalArtifactsAccessConfigArtifact.AuthTypeEnum map(AuthType o);

}
