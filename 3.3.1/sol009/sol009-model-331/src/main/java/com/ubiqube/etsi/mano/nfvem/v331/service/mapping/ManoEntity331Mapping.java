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
package com.ubiqube.etsi.mano.nfvem.v331.service.mapping;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;

import com.ubiqube.etsi.mano.dao.mano.sol009.entity.CismSpecificInfo;
import com.ubiqube.etsi.mano.dao.mano.sol009.entity.SupportedPackageFormats;
import com.ubiqube.etsi.mano.dao.mano.sol009.peers.PeerEntityEnum;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanocim.ManoConfigurableParams;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanocim.ManoEntity;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanocim.ManoEntityEnumType;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanocim.ManoService;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanocim.NfvoSpecificInfoSupportedNsdFormats;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanocim.NfvoSpecificInfoSupportedVnfdFormats;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanocim.VimSpecificInfo;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ManoEntity331Mapping {

	@Mapping(target = "links", ignore = true)
	ManoEntity map(com.ubiqube.etsi.mano.dao.mano.sol009.entity.ManoEntity o);

	VimSpecificInfo map(com.ubiqube.etsi.mano.dao.mano.sol009.entity.VimSpecificInfo value);

	CismSpecificInfo map(com.ubiqube.etsi.mano.dao.mano.sol009.entity.CismSpecificInfo o);

	default NfvoSpecificInfoSupportedNsdFormats map(final List<SupportedPackageFormats> value) {
		if ((null == value) || value.isEmpty()) {
			return null;
		}
		return mapToNfvoSpecificInfoSupportedNsdFormats(value.get(0));
	}

	@Mapping(target = "nsdFormat", source = "vnfdFormat")
	NfvoSpecificInfoSupportedNsdFormats mapToNfvoSpecificInfoSupportedNsdFormats(SupportedPackageFormats supportedPackageFormats);

	default NfvoSpecificInfoSupportedVnfdFormats map(final Set<SupportedPackageFormats> value) {
		if ((null == value) || value.isEmpty()) {
			return null;
		}
		return mapToNfvoSpecificInfoSupportedVnfdFormats(value.iterator().next());
	}

	NfvoSpecificInfoSupportedVnfdFormats mapToNfvoSpecificInfoSupportedVnfdFormats(SupportedPackageFormats next);

	@Mapping(target = "nsdFormat", source = "vnfdFormat")
	NfvoSpecificInfoSupportedNsdFormats map(SupportedPackageFormats o);

//	@Mapping(target = "criteriaNumMscs", ignore = true)
//	@Mapping(target = "numMscs", ignore = true)
//	WimSpecificInfoMaxMscsNums map(MscsNums o);

	@Mapping(target = "links", ignore = true)
	ManoService map(com.ubiqube.etsi.mano.dao.mano.sol009.entity.ManoService o);

	ManoConfigurableParams map(com.ubiqube.etsi.mano.dao.mano.sol009.entity.ManoConfigurableParams value);

	@ValueMapping(source = "EM", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "OSS", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "CISM", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "WIM", target = MappingConstants.THROW_EXCEPTION)
	ManoEntityEnumType map(PeerEntityEnum o);

}
