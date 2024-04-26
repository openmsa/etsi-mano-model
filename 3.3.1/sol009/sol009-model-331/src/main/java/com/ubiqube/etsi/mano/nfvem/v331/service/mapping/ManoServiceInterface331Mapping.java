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

import org.mapstruct.Mapping;

import com.ubiqube.etsi.mano.dao.mano.sol009.entity.ManoEntity;
import com.ubiqube.etsi.mano.dao.mano.sol009.iface.ManoServiceInterface;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanocim.ManoConfigModifications;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanocim.ManoServiceInterfaceModifications;

public interface ManoServiceInterface331Mapping {

	com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanocim.ManoServiceInterface map(ManoServiceInterface o);

	@Mapping(target = "apiEndpoint", ignore = true)
	@Mapping(target = "apiVersion", ignore = true)
	@Mapping(target = "interfaceState", ignore = true)
	@Mapping(target = "maxConcurrentIntOpNumber", ignore = true)
	@Mapping(target = "metadata", ignore = true)
	@Mapping(target = "providerSpecificApiVersion", ignore = true)
	@Mapping(target = "securityInfo", ignore = true)
	@Mapping(target = "standardVersion", ignore = true)
	@Mapping(target = "supportedOperations", ignore = true)
	com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanocim.ManoServiceInterface map(ManoEntity x);

	@Mapping(target = "apiRoot", ignore = true)
	@Mapping(target = "apiUri", ignore = true)
	@Mapping(target = "metadata", ignore = true)
	@Mapping(target = "securityInfo", ignore = true)
	ManoServiceInterfaceModifications mapToManoServiceInterfaceModifications(ManoEntity x);

	@Mapping(target = "clockSyncs", ignore = true)
	@Mapping(target = "defaultLogCompileBySizeValue", ignore = true)
	@Mapping(target = "defaultLogCompileByTimerValue", ignore = true)
	@Mapping(target = "manoServiceModifications", ignore = true)
	ManoConfigModifications mapToManoConfigModifications(ManoEntity x);

}
