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
package com.ubiqube.etsi.mano.nfvem.v331.controller.nfvmanocim;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.nfvmanocim.ManoEntityFrontController;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanocim.ChangeStateRequest;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanocim.ManoConfigModificationRequest;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanocim.ManoConfigModifications;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanocim.ManoEntity;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanocim.ManoServiceInterface;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanocim.ManoServiceInterfaceModificationRequest;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanocim.ManoServiceInterfaceModifications;
import com.ubiqube.etsi.mano.nfvem.v331.service.mapping.ManoEntity331Mapping;
import com.ubiqube.etsi.mano.nfvem.v331.service.mapping.ManoServiceInterface331Mapping;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
public class ManoEntity331Controller implements ManoEntity331Api {
	private final ManoEntityFrontController manoEntityFrontController;
	private final ManoEntity331Mapping manoEntityMapping;
	private final ManoServiceInterface331Mapping manoServiceInterface331Mapping;

	public ManoEntity331Controller(final ManoEntityFrontController manoEntityFrontController, final ManoEntity331Mapping manoEntityMapping, final ManoServiceInterface331Mapping manoServiceInterface331Mapping) {
		this.manoEntityFrontController = manoEntityFrontController;
		this.manoEntityMapping = manoEntityMapping;
		this.manoServiceInterface331Mapping = manoServiceInterface331Mapping;
	}

	@Override
	public ResponseEntity<Void> manoEntityChangeStatePost(final ChangeStateRequest body) {
		return manoEntityFrontController.changeStatus(body);
	}

	@Override
	public ResponseEntity<ManoEntity> manoEntityGet() {
		return manoEntityFrontController.find(manoEntityMapping::map);
	}

	@Override
	public ResponseEntity<List<ManoServiceInterface>> manoEntityManoInterfacesGet(final String filter, final String allFields, final String fields, final String excludeFields, final String excludeDefault, final String nextpageOpaqueMarker) {
		return manoEntityFrontController.interfaceSearch(filter, manoServiceInterface331Mapping::map);
	}

	@Override
	public ResponseEntity<Void> manoEntityManoInterfacesManoServiceInterfaceIdChangeStatePost(final String manoServiceInterfaceId, final ChangeStateRequest body) {
		return manoEntityFrontController.interfaceChangeState(manoServiceInterfaceId, body);
	}

	@Override
	public ResponseEntity<ManoServiceInterface> manoEntityManoInterfacesManoServiceInterfaceIdGet(final String manoServiceInterfaceId) {
		return manoEntityFrontController.interfaceFindById(manoServiceInterfaceId, manoServiceInterface331Mapping::map);
	}

	@Override
	public ResponseEntity<ManoServiceInterfaceModifications> manoEntityManoInterfacesManoServiceInterfaceIdPatch(final String manoServiceInterfaceId, final ManoServiceInterfaceModificationRequest body) {
		return manoEntityFrontController.interfacePatch(manoServiceInterfaceId, body, manoServiceInterface331Mapping::mapToManoServiceInterfaceModifications);
	}

	@Override
	public ResponseEntity<ManoConfigModifications> manoEntityPatch(final ManoConfigModificationRequest body) {
		return manoEntityFrontController.patch(body, manoServiceInterface331Mapping::mapToManoConfigModifications);
	}

}
