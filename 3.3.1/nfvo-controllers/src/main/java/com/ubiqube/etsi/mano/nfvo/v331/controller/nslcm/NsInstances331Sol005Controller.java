/**
 *     Copyright (C) 2019-2020 Ubiqube.
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
package com.ubiqube.etsi.mano.nfvo.v331.controller.nslcm;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.nfvo.v331.model.nslcm.CreateNsRequest;
import com.ubiqube.etsi.mano.nfvo.v331.model.nslcm.HealNsRequest;
import com.ubiqube.etsi.mano.nfvo.v331.model.nslcm.InstantiateNsRequest;
import com.ubiqube.etsi.mano.nfvo.v331.model.nslcm.NsInstance;
import com.ubiqube.etsi.mano.nfvo.v331.model.nslcm.ScaleNsRequest;
import com.ubiqube.etsi.mano.nfvo.v331.model.nslcm.TerminateNsRequest;
import com.ubiqube.etsi.mano.nfvo.v331.model.nslcm.UpdateNsRequest;

/**
 *
 * @author Olivier Vignaud <ovi@ubiqube.com>
 *
 */
@RestController
public class NsInstances331Sol005Controller implements NsInstances331Sol005Api {

	@Override
	public ResponseEntity<List<NsInstance>> nsInstancesGet(@Valid final String filter, @Valid final String allFields, @Valid final String fields, @Valid final String excludeFields, @Valid final String excludeDefault, @Valid final String nextpageOpaqueMarker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> nsInstancesNsInstanceIdDelete(final String nsInstanceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<NsInstance> nsInstancesNsInstanceIdGet(final String nsInstanceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> nsInstancesNsInstanceIdHealPost(final String nsInstanceId, @Valid final HealNsRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> nsInstancesNsInstanceIdInstantiatePost(final String nsInstanceId, @Valid final InstantiateNsRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> nsInstancesNsInstanceIdScalePost(final String nsInstanceId, @Valid final ScaleNsRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> nsInstancesNsInstanceIdTerminatePost(final String nsInstanceId, @Valid final TerminateNsRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> nsInstancesNsInstanceIdUpdatePost(final String nsInstanceId, @Valid final UpdateNsRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<NsInstance> nsInstancesPost(@Valid final CreateNsRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

}