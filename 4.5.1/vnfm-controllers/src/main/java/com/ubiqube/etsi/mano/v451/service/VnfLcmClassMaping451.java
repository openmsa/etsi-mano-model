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
package com.ubiqube.etsi.mano.v451.service;

import org.springframework.stereotype.Service;

import com.ubiqube.etsi.mano.dao.mano.v2.VnfBlueprint;
import com.ubiqube.etsi.mano.v451.service.mapping.lcmopocc.LcmOpOcc451Mapping;
import com.ubiqube.etsi.mano.vnfm.fc.vnflcm.VnfLcmClassMaping;

@Service
public class VnfLcmClassMaping451 implements VnfLcmClassMaping {
	private final LcmOpOcc451Mapping lcmOpOcc451Mapping;

	public VnfLcmClassMaping451(final LcmOpOcc451Mapping lcmOpOcc451Mapping) {
		this.lcmOpOcc451Mapping = lcmOpOcc451Mapping;
	}

	@Override
	public <R> R getInstantiateVnfRequest(final VnfBlueprint o) {
		return (R) lcmOpOcc451Mapping.mapToInstantiateVnfRequest(o);
	}

	@Override
	public <R> R getScaleVnfRequest(final VnfBlueprint o) {
		return (R) lcmOpOcc451Mapping.mapToScaleVnfRequest(o);
	}

	@Override
	public <R> R getScaleVnfToLevelRequest(final VnfBlueprint o) {
		return (R) lcmOpOcc451Mapping.mapToScaleVnfToLevelRequest(o);
	}

	@Override
	public <R> R getChangeVnfFlavourRequest(final VnfBlueprint o) {
		return (R) lcmOpOcc451Mapping.mapToChangeVnfFlavourRequest(o);
	}

	@Override
	public <R> R getOperateVnfRequest(final VnfBlueprint o) {
		return (R) lcmOpOcc451Mapping.mapToOperateVnfRequest(o);
	}

	@Override
	public <R> R getHealVnfRequest(final VnfBlueprint o) {
		return (R) lcmOpOcc451Mapping.mapToHealVnfRequest(o);
	}

	@Override
	public <R> R getChangeExtVnfConnectivityRequest(final VnfBlueprint o) {
		return (R) lcmOpOcc451Mapping.mapToChangeExtVnfConnectivityRequest(o);
	}

	@Override
	public <R> R getTerminateVnfRequest(final VnfBlueprint o) {
		return (R) lcmOpOcc451Mapping.mapToTerminateVnfRequest(o);
	}

	@Override
	public <R> R getVnfInfoModificationRequest(final VnfBlueprint o) {
		return (R) lcmOpOcc451Mapping.mapToVnfInfoModificationRequest(o);
	}

	@Override
	public <R> R getCreateVnfSnapshotRequest(final VnfBlueprint o) {
		return (R) lcmOpOcc451Mapping.mapToCreateVnfSnapshotRequest(o);
	}

	@Override
	public <R> R getRevertToVnfSnapshotRequest(final VnfBlueprint o) {
		return (R) lcmOpOcc451Mapping.mapToRevertToVnfSnapshotRequest(o);
	}

	@Override
	public <R> R getChangeCurrentVnfPkgRequest(final VnfBlueprint o) {
		return (R) lcmOpOcc451Mapping.mapToChangeCurrentVnfPkgRequest(o);
	}

	@Override
	public <R> R mapToVnfLcmOpOcc(final VnfBlueprint o) {
		// TODO Auto-generated method stub
		return null;
	}

}
