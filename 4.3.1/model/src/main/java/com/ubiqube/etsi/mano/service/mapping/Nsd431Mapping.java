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
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.dao.mano.NsdPackage;
import com.ubiqube.etsi.mano.dao.mano.NsdPackageNsdPackage;
import com.ubiqube.etsi.mano.dao.mano.NsdPackageVnfPackage;
import com.ubiqube.etsi.mano.dao.mano.PkgChecksum;
import com.ubiqube.etsi.mano.dao.mano.nfvo.NsArchiveArtifactInfo;
import com.ubiqube.etsi.mano.nfvo.v431.model.nsd.NsdArchiveArtifactInfo;
import com.ubiqube.etsi.mano.nfvo.v431.model.nsd.NsdInfo;
import com.ubiqube.etsi.mano.nfvo.v431.model.vnfsnapshotpkgm.Checksum;

import jakarta.annotation.Nullable;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface Nsd431Mapping extends StringToUriMapping {

	@Mapping(target = "links", ignore = true)
	@Mapping(target = "pnfdInfoIds", ignore = true)
	NsdInfo map(NsdPackage o);

	List<String> map(Set<NsdPackageVnfPackage> value);

	@Nullable
	default String map(final @Nullable NsdPackageNsdPackage value) {
		if (value == null) {
			return null;
		}
		return value.getToscaName();
	}

	List<String> mapNsd(Set<NsdPackageNsdPackage> value);

	@Nullable
	default String map(final @Nullable NsdPackageVnfPackage value) {
		if (value == null) {
			return null;
		}
		return value.getVnfPackage().getId().toString();
	}

	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "autoHealEnabled", ignore = true)
	@Mapping(target = "flavorId", ignore = true)
	@Mapping(target = "instantiationLevel", ignore = true)
	@Mapping(target = "maxNumberOfInstance", ignore = true)
	@Mapping(target = "minNumberOfInstance", ignore = true)
	@Mapping(target = "nsInstance", ignore = true)
	@Mapping(target = "nsSaps", ignore = true)
	@Mapping(target = "nsVirtualLinks", ignore = true)
	@Mapping(target = "nsVnfIndicator", ignore = true)
	@Mapping(target = "overwriteDescId", ignore = true)
	@Mapping(target = "serviceAvailabilityLevel", ignore = true)
	@Mapping(target = "version", ignore = true)
	@Mapping(target = "vnffgs", ignore = true)
	@Mapping(target = "pnfdInfoIds", ignore = true)
	NsdPackage map(NsdInfo o);

	@Mapping(target = "id", ignore = true)
	NsArchiveArtifactInfo map(NsdArchiveArtifactInfo artifacts);

	@Mapping(target = "md5", ignore = true)
	@Mapping(target = "sha256", ignore = true)
	@Mapping(target = "sha512", ignore = true)
	PkgChecksum map(Checksum o);

	Set<NsdPackageVnfPackage> map(List<String> value);

	@Nullable
	default NsdPackageVnfPackage mapNsdPackageVnfPackage(final @Nullable String value) {
		if (value == null) {
			return null;
		}
		final NsdPackageVnfPackage p = new NsdPackageVnfPackage();
		p.setId(UUID.fromString(value));
		return p;
	}

	@Nullable
	default NsdPackageNsdPackage mapNsdPackageNsdPackage(final @Nullable String value) {
		if (value == null) {
			return null;
		}
		final NsdPackageNsdPackage p = new NsdPackageNsdPackage();
		p.setId(UUID.fromString(value));
		return p;
	}

	Set<NsdPackageNsdPackage> mapNsdPackageNsdPackage(final List<String> value);
}
