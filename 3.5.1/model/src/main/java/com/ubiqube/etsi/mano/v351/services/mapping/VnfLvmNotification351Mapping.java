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
package com.ubiqube.etsi.mano.v351.services.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.dao.mano.ExtLinkPortInfoEntity;
import com.ubiqube.etsi.mano.dao.mano.ExtVirtualLinkInfoEntity;
import com.ubiqube.etsi.mano.dao.mano.vnflcm.VnfLcmNotification;
import com.ubiqube.etsi.mano.service.mapping.StringToUriMapping;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.ExtLinkPortInfo;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.ExtVirtualLinkInfo;
import com.ubiqube.etsi.mano.v351.model.vnfm.vnflcm.VnfIdentifierCreationNotification;
import com.ubiqube.etsi.mano.v351.model.vnfm.vnflcm.VnfIdentifierDeletionNotification;
import com.ubiqube.etsi.mano.v351.model.vnfm.vnflcm.VnfLcmOperationOccurrenceNotification;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VnfLvmNotification351Mapping extends StringToUriMapping, Connectivity351Mapping, VimResourceMapping {

	@Mapping(target = "affectedVnfcs", ignore = true)
	@Mapping(target = "changedExtConnectivity", ignore = true)
	@Mapping(target = "error", ignore = true)
	@Mapping(target = "isAutomaticInvocation", ignore = true)
	@Mapping(target = "nfvoId", ignore = true)
	@Mapping(target = "operation", ignore = true)
	@Mapping(target = "operationState", ignore = true)
	@Mapping(target = "vnfLcmOpOccId", ignore = true)
	VnfLcmNotification map(VnfIdentifierCreationNotification body);

	@Mapping(target = "affectedVnfcs", ignore = true)
	@Mapping(target = "changedExtConnectivity", ignore = true)
	@Mapping(target = "error", ignore = true)
	@Mapping(target = "isAutomaticInvocation", ignore = true)
	@Mapping(target = "nfvoId", ignore = true)
	@Mapping(target = "operation", ignore = true)
	@Mapping(target = "operationState", ignore = true)
	@Mapping(target = "vnfLcmOpOccId", ignore = true)
	VnfLcmNotification map(VnfIdentifierDeletionNotification body);

	@Mapping(target = "nfvoId", ignore = true)
	VnfLcmNotification map(VnfLcmOperationOccurrenceNotification body);

	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "extNetAttDefResource", ignore = true)
	ExtVirtualLinkInfoEntity map(ExtVirtualLinkInfo o);

	@Mapping(target = "audit", ignore = true)
	ExtLinkPortInfoEntity map(ExtLinkPortInfo o);

}
