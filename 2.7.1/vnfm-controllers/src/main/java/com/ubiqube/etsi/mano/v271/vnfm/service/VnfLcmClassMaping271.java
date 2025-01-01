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
package com.ubiqube.etsi.mano.v271.vnfm.service;

import org.springframework.stereotype.Service;

import com.ubiqube.etsi.mano.dao.mano.v2.VnfBlueprint;
import com.ubiqube.etsi.mano.v271.service.mapping.lcm.VnfLcmOpOccMapper271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.vnflcm.VnfBlueprint271Mapping;
import com.ubiqube.etsi.mano.vnfm.fc.vnflcm.VnfLcmClassMaping;

/**
 *
 * @author Olivier Vignaud {@literal {@literal <ovi@ubiqube.com>}}
 *
 */
@Service
public class VnfLcmClassMaping271 implements VnfLcmClassMaping {
	private final VnfLcmOpOccMapper271Mapping vnfLcmOpOcc271Mapping;
	private final VnfBlueprint271Mapping mapper2;

	public VnfLcmClassMaping271(final VnfLcmOpOccMapper271Mapping vnfLcmOpOcc271Mapping, final VnfBlueprint271Mapping mapper2) {
		this.vnfLcmOpOcc271Mapping = vnfLcmOpOcc271Mapping;
		this.mapper2 = mapper2;
	}

	@Override
	public <R> R getInstantiateVnfRequest(final VnfBlueprint o) {
		return (R) vnfLcmOpOcc271Mapping.mapToInstantiateVnfRequest(o);
	}

	@Override
	public <R> R getScaleVnfRequest(final VnfBlueprint o) {
		return (R) vnfLcmOpOcc271Mapping.mapToScaleVnfRequest(o);
	}

	@Override
	public <R> R getScaleVnfToLevelRequest(final VnfBlueprint o) {
		return (R) vnfLcmOpOcc271Mapping.mapToScaleVnfToLevelRequest(o);
	}

	@Override
	public <R> R getChangeVnfFlavourRequest(final VnfBlueprint o) {
		return (R) vnfLcmOpOcc271Mapping.mapToChangeVnfFlavourRequest(o);
	}

	@Override
	public <R> R getOperateVnfRequest(final VnfBlueprint o) {
		return (R) vnfLcmOpOcc271Mapping.mapToOperateVnfRequest(o);
	}

	@Override
	public <R> R getHealVnfRequest(final VnfBlueprint o) {
		return (R) vnfLcmOpOcc271Mapping.mapToHealVnfRequest(o);
	}

	@Override
	public <R> R getChangeExtVnfConnectivityRequest(final VnfBlueprint o) {
		return (R) vnfLcmOpOcc271Mapping.mapToChangeExtVnfConnectivityRequest(o);
	}

	@Override
	public <R> R getTerminateVnfRequest(final VnfBlueprint o) {
		return (R) vnfLcmOpOcc271Mapping.mapToTerminateVnfRequest(o);
	}

	@Override
	public <R> R getVnfInfoModificationRequest(final VnfBlueprint o) {
		return (R) vnfLcmOpOcc271Mapping.mapToVnfInfoModificationRequest(o);
	}

	@Override
	public <R> R getCreateVnfSnapshotRequest(final VnfBlueprint o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <R> R getRevertToVnfSnapshotRequest(final VnfBlueprint o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <R> R getChangeCurrentVnfPkgRequest(final VnfBlueprint o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <R> R mapToVnfLcmOpOcc(final VnfBlueprint o) {
		return (R) mapper2.map(o);
	}

}
