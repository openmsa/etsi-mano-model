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
package com.ubiqube.etsi.mano.v451.nfvo.controller.nfvo.vnfsnapshotpkgm;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v451.model.nfvo.vnfsnapshotpkgm.BuildVnfSnapshotPkgRequest;
import com.ubiqube.etsi.mano.v451.model.nfvo.vnfsnapshotpkgm.CancelVnfSnapshotPkgOperationRequest;
import com.ubiqube.etsi.mano.v451.model.nfvo.vnfsnapshotpkgm.CreateVnfSnapshotPkgInfoRequest;
import com.ubiqube.etsi.mano.v451.model.nfvo.vnfsnapshotpkgm.ExtractVnfSnapshotPkgRequest;
import com.ubiqube.etsi.mano.v451.model.nfvo.vnfsnapshotpkgm.UploadVnfSnapshotPkgFromUriRequest;
import com.ubiqube.etsi.mano.v451.model.nfvo.vnfsnapshotpkgm.VnfSnapshotPkgExtArtifactsAccessConfig;
import com.ubiqube.etsi.mano.v451.model.nfvo.vnfsnapshotpkgm.VnfSnapshotPkgInfo;
import com.ubiqube.etsi.mano.v451.model.nfvo.vnfsnapshotpkgm.VnfSnapshotPkgInfoModifications;

import jakarta.validation.Valid;

@RestController
public class VnfSnapshotPackages451Sol005Controller implements VnfSnapshotPackages451Sol005Api {

	@Override
	public ResponseEntity<List<VnfSnapshotPkgInfo>> vnfSnapshotPackagesGet(@Valid final String filter, @Valid final String allFields, @Valid final String fields, @Valid final String excludeFields, @Valid final String excludeDefault, @Valid final String nextpageOpaqueMarker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<VnfSnapshotPkgInfo> vnfSnapshotPackagesPost(@Valid final CreateVnfSnapshotPkgInfoRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Resource> vnfSnapshotPackagesVnfSnapshotPkgIdArtifactsArtifactPathGet(final String vnfSnapshotPkgId, final String artifactPath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> vnfSnapshotPackagesVnfSnapshotPkgIdDelete(final String vnfSnapshotPkgId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<VnfSnapshotPkgExtArtifactsAccessConfig> vnfSnapshotPackagesVnfSnapshotPkgIdExtArtifactsAccessGet(final String vnfSnapshotPkgId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<VnfSnapshotPkgExtArtifactsAccessConfig> vnfSnapshotPackagesVnfSnapshotPkgIdExtArtifactsAccessPut(final String vnfSnapshotPkgId, @Valid final VnfSnapshotPkgExtArtifactsAccessConfig body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<VnfSnapshotPkgInfo> vnfSnapshotPackagesVnfSnapshotPkgIdGet(final String vnfSnapshotPkgId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> vnfSnapshotPackagesVnfSnapshotPkgIdPackageContentBuildPost(final String vnfSnapshotPkgId, @Valid final BuildVnfSnapshotPkgRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> vnfSnapshotPackagesVnfSnapshotPkgIdPackageContentCancelPost(final String vnfSnapshotPkgId, @Valid final CancelVnfSnapshotPkgOperationRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> vnfSnapshotPackagesVnfSnapshotPkgIdPackageContentExtractPost(final String vnfSnapshotPkgId, @Valid final ExtractVnfSnapshotPkgRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Resource> vnfSnapshotPackagesVnfSnapshotPkgIdPackageContentGet(final String vnfSnapshotPkgId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> vnfSnapshotPackagesVnfSnapshotPkgIdPackageContentPut(final String vnfSnapshotPkgId, final String contentType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> vnfSnapshotPackagesVnfSnapshotPkgIdPackageContentUploadFromUriPost(final String vnfSnapshotPkgId, @Valid final UploadVnfSnapshotPkgFromUriRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<VnfSnapshotPkgInfoModifications> vnfSnapshotPackagesVnfSnapshotPkgIdPatch(final String vnfSnapshotPkgId, @Valid final VnfSnapshotPkgInfoModifications body) {
		// TODO Auto-generated method stub
		return null;
	}

}
