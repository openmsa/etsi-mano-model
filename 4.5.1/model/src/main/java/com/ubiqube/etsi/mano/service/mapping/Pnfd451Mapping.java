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

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;

import com.ubiqube.etsi.mano.dao.mano.AdditionalArtifact;
import com.ubiqube.etsi.mano.dao.mano.OnboardingStateType;
import com.ubiqube.etsi.mano.dao.mano.PnfDescriptor;
import com.ubiqube.etsi.mano.nfvo.v451.model.nsd.PnfdArchiveArtifactInfo;
import com.ubiqube.etsi.mano.nfvo.v451.model.nsd.PnfdInfo;
import com.ubiqube.etsi.mano.nfvo.v451.model.nsd.PnfdOnboardingStateType;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface Pnfd451Mapping extends StringToUriMapping {

	@Mapping(target = "links", ignore = true)
	PnfdInfo map(PnfDescriptor o);

	@ValueMapping(source = "ONBOARDED", target = "ONBOARDING")
	PnfdOnboardingStateType map(OnboardingStateType o);

	@ValueMapping(source = "ONBOARDING", target = "ONBOARDED")
	OnboardingStateType map(PnfdOnboardingStateType o);

	@Mapping(target = "virtualLink", ignore = true)
	PnfDescriptor map(PnfdInfo o);

	@Mapping(target = "artifactClassification", ignore = true)
	@Mapping(target = "artifactURI", ignore = true)
	@Mapping(target = "certificate", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "isEncrypted", ignore = true)
	@Mapping(target = "nonManoSetIndentifier", source = "nonManoArtifactSetId")
	@Mapping(target = "repository", ignore = true)
	@Mapping(target = "signature", ignore = true)
	AdditionalArtifact map(PnfdArchiveArtifactInfo o);
}
