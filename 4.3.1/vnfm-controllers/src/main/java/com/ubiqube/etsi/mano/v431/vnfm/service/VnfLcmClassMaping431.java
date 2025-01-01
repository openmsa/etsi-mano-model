/**
 * Copyright (C) 2019-2025 Ubiqube.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */
package com.ubiqube.etsi.mano.v431.vnfm.service;

import org.springframework.stereotype.Service;

import com.ubiqube.etsi.mano.dao.mano.v2.VnfBlueprint;
import com.ubiqube.etsi.mano.v431.service.mapping.lcm.VnfLcmOpOccMapper431Mapping;
import com.ubiqube.etsi.mano.v431.service.mapping.vnflcm.VnfBlueprint431Mapping;
import com.ubiqube.etsi.mano.vnfm.fc.vnflcm.VnfLcmClassMaping;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@Service
public class VnfLcmClassMaping431 implements VnfLcmClassMaping {
	private final VnfLcmOpOccMapper431Mapping vnfLcmOpOcc431Mapping;
	private final VnfBlueprint431Mapping mapper2;

	public VnfLcmClassMaping431(final VnfLcmOpOccMapper431Mapping vnfLcmOpOcc431Mapping, final VnfBlueprint431Mapping mapper2) {
		this.vnfLcmOpOcc431Mapping = vnfLcmOpOcc431Mapping;
		this.mapper2 = mapper2;
	}

	@Override
	public <R> R getInstantiateVnfRequest(final VnfBlueprint o) {
		return (R) vnfLcmOpOcc431Mapping.mapToInstantiateVnfRequest(o);
	}

	@Override
	public <R> R getScaleVnfRequest(final VnfBlueprint o) {
		return (R) vnfLcmOpOcc431Mapping.mapToScaleVnfRequest(o);
	}

	@Override
	public <R> R getScaleVnfToLevelRequest(final VnfBlueprint o) {
		return (R) vnfLcmOpOcc431Mapping.mapToScaleVnfToLevelRequest(o);
	}

	@Override
	public <R> R getChangeVnfFlavourRequest(final VnfBlueprint o) {
		return (R) vnfLcmOpOcc431Mapping.mapToChangeVnfFlavourRequest(o);
	}

	@Override
	public <R> R getOperateVnfRequest(final VnfBlueprint o) {
		return (R) vnfLcmOpOcc431Mapping.mapToOperateVnfRequest(o);
	}

	@Override
	public <R> R getHealVnfRequest(final VnfBlueprint o) {
		return (R) vnfLcmOpOcc431Mapping.mapToHealVnfRequest(o);
	}

	@Override
	public <R> R getChangeExtVnfConnectivityRequest(final VnfBlueprint o) {
		return (R) vnfLcmOpOcc431Mapping.mapToChangeExtVnfConnectivityRequest(o);
	}

	@Override
	public <R> R getTerminateVnfRequest(final VnfBlueprint o) {
		return (R) vnfLcmOpOcc431Mapping.mapToTerminateVnfRequest(o);
	}

	@Override
	public <R> R getVnfInfoModificationRequest(final VnfBlueprint o) {
		return (R) vnfLcmOpOcc431Mapping.mapToVnfInfoModificationRequest(o);
	}

	@Override
	public <R> R getCreateVnfSnapshotRequest(final VnfBlueprint o) {
		return (R) vnfLcmOpOcc431Mapping.mapToCreateVnfSnapshotRequest(o);
	}

	@Override
	public <R> R getRevertToVnfSnapshotRequest(final VnfBlueprint o) {
		return (R) vnfLcmOpOcc431Mapping.mapToRevertToVnfSnapshotRequest(o);
	}

	@Override
	public <R> R getChangeCurrentVnfPkgRequest(final VnfBlueprint o) {
		return (R) vnfLcmOpOcc431Mapping.mapToChangeCurrentVnfPkgRequest(o);
	}

	@Override
	public <R> R mapToVnfLcmOpOcc(final VnfBlueprint o) {
		return (R) mapper2.map(o);
	}

}
