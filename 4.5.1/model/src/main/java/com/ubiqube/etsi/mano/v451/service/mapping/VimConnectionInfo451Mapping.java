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

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ubiqube.etsi.mano.dao.mano.AccessInfo;
import com.ubiqube.etsi.mano.dao.mano.InterfaceInfo;
import com.ubiqube.etsi.mano.dao.mano.cnf.ConnectionInformation;
import com.ubiqube.etsi.mano.dao.mano.vim.VimConnectionInformation;
import com.ubiqube.etsi.mano.service.mapping.ConnectionMapping;
import com.ubiqube.etsi.mano.v451.model.nfvo.vnflcm.VimConnectionInfo;

import jakarta.annotation.Nullable;

@Mapper
public interface VimConnectionInfo451Mapping extends ConnectionMapping {
	@Nullable
	default VimConnectionInformation<? extends InterfaceInfo, ? extends AccessInfo> map(final @Nullable VimConnectionInfo vci) {
		if (null == vci) {
			return null;
		}
		final VimConnectionInformation ret = new VimConnectionInformation<>();
		ret.setVimId(vci.getVimId());
		ret.setVimType(vci.getVimType());
		ret.setAccessInfo(mapToAccessInfo(vci.getVimType(), vci.getAccessInfo()));
		ret.setInterfaceInfo(mapToInterfaceInfo(vci.getVimType(), vci.getInterfaceInfo()));
		ret.setExtra(vci.getExtra());
		return ret;
	}

	@Nullable
	default Set<VimConnectionInformation<? extends com.ubiqube.etsi.mano.dao.mano.InterfaceInfo, ? extends com.ubiqube.etsi.mano.dao.mano.AccessInfo>> mapNoGeneric(final @Nullable Map<String, VimConnectionInfo> in) {
		if (null == in) {
			return null;
		}
		return in.values().stream()
				.map(this::map)
				.collect(Collectors.toSet());
	}

	@Nullable
	default Map<String, VimConnectionInfo> mapWithNGeneric(final @Nullable Set<VimConnectionInformation<? extends InterfaceInfo, ? extends AccessInfo>> in) {
		if (null == in) {
			return null;
		}
		return in.stream()
				.map(this::map)
				.collect(Collectors.toMap(x -> x.getVimId(), x -> x));
	}

	@Nullable
	default Map<String, VimConnectionInfo> mapWithNGenericAndList(final @Nullable List<VimConnectionInformation<? extends InterfaceInfo, ? extends AccessInfo>> in) {
		if (null == in) {
			return null;
		}
		return in.stream()
				.map(this::map)
				.collect(Collectors.toMap(x -> x.getVimId(), x -> x));
	}

	VimConnectionInfo map(VimConnectionInformation vci);

	@Nullable
	default Set<VimConnectionInformation> map(final @Nullable Map<String, VimConnectionInfo> in) {
		if (null == in) {
			return null;
		}
		return in.values().stream()
				.map(this::map)
				.collect(Collectors.toSet());
	}

	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "authentification", ignore = true)
	@Mapping(target = "capabilities", ignore = true)
	@Mapping(target = "connType", ignore = true)
	@Mapping(target = "failureDetails", ignore = true)
	@Mapping(target = "geoloc", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "ignoreSsl", ignore = true)
	@Mapping(target = "name", ignore = true)
	@Mapping(target = "serverStatus", ignore = true)
	@Mapping(target = "url", ignore = true)
	@Mapping(target = "version", ignore = true)
	ConnectionInformation mapConnectionInformation(VimConnectionInfo vci);

	@Mapping(target = "accessInfo", source = "authentification")
	@Mapping(target = "interfaceInfo", source = ".")
	@Mapping(target = "vimId", source = "id")
	@Mapping(target = "vimType", source = ".")
	VimConnectionInfo map(ConnectionInformation ci);

}
