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
package com.ubiqube.etsi.mano.v281.service.mapping;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ubiqube.etsi.mano.dao.mano.cnf.ConnectionInformation;
import com.ubiqube.etsi.mano.dao.mano.vim.VimConnectionInformation;
import com.ubiqube.etsi.mano.service.mapping.ConnectionMapping;
import com.ubiqube.etsi.mano.v281.model.vnfm.grant.VimConnectionInfo;

import jakarta.annotation.Nullable;

@Mapper
public interface VimConnectionInfo281Mapping extends ConnectionMapping {
	default VimConnectionInformation map(final VimConnectionInfo vci) {
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

	@Nullable
	default Map<String, VimConnectionInfo> map(final @Nullable Set<VimConnectionInformation> in) {
		if (null == in) {
			return null;
		}
		return in.stream()
				.map(this::map)
				.collect(Collectors.toMap(x -> x.getVimId(), x -> x));
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

	@Mapping(target = "accessInfo", ignore = true)
	@Mapping(target = "interfaceInfo", ignore = true)
	@Mapping(target = "vimId", ignore = true)
	@Mapping(target = "vimType", ignore = true)
	VimConnectionInfo map(ConnectionInformation ci);

}
