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
package com.ubiqube.etsi.mano.v431.controller.nfvem.nfvmanocim;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.nfvmanocim.ManoEntityFrontController;
import com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanocim.ChangeStateRequest;
import com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanocim.ManoConfigModificationRequest;
import com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanocim.ManoConfigModifications;
import com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanocim.ManoEntity;
import com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanocim.ManoServiceInterface;
import com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanocim.ManoServiceInterfaceModificationRequest;
import com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanocim.ManoServiceInterfaceModifications;
import com.ubiqube.etsi.mano.v431.service.mapping.ManoEntity431Mapping;
import com.ubiqube.etsi.mano.v431.service.mapping.ManoServiceInterface431Mapping;

@RestController
public class ManoEntity431Sol009Controller implements ManoEntity431Sol009Api {
	private final ManoEntityFrontController manoEntityFrontController;
	private final ManoEntity431Mapping manoEntityMapping;
	private final ManoServiceInterface431Mapping manoServiceInterface431Mapping;

	public ManoEntity431Sol009Controller(final ManoEntityFrontController manoEntityFrontController, final ManoEntity431Mapping manoEntityMapping, final ManoServiceInterface431Mapping manoServiceInterface431Mapping) {
		this.manoEntityFrontController = manoEntityFrontController;
		this.manoEntityMapping = manoEntityMapping;
		this.manoServiceInterface431Mapping = manoServiceInterface431Mapping;
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
		return manoEntityFrontController.interfaceSearch(filter, manoServiceInterface431Mapping::map);
	}

	@Override
	public ResponseEntity<Void> manoEntityManoInterfacesManoServiceInterfaceIdChangeStatePost(final String manoServiceInterfaceId, final ChangeStateRequest body) {
		return manoEntityFrontController.interfaceChangeState(manoServiceInterfaceId, body);
	}

	@Override
	public ResponseEntity<ManoServiceInterface> manoEntityManoInterfacesManoServiceInterfaceIdGet(final String manoServiceInterfaceId) {
		return manoEntityFrontController.interfaceFindById(manoServiceInterfaceId, manoServiceInterface431Mapping::map);
	}

	@Override
	public ResponseEntity<ManoServiceInterfaceModifications> manoEntityManoInterfacesManoServiceInterfaceIdPatch(final String manoServiceInterfaceId, final ManoServiceInterfaceModificationRequest body) {
		return manoEntityFrontController.interfacePatch(manoServiceInterfaceId, body, manoServiceInterface431Mapping::mapToManoServiceInterfaceModifications);
	}

	@Override
	public ResponseEntity<ManoConfigModifications> manoEntityPatch(final ManoConfigModificationRequest body) {
		return manoEntityFrontController.patch(body, manoServiceInterface431Mapping::mapToManoConfigModifications);
	}

}
