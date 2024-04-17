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
package com.ubiqube.etsi.mano.v351.services;

import org.springframework.stereotype.Service;

import com.ubiqube.etsi.mano.dao.mano.v2.VnfBlueprint;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.ChangeCurrentVnfPkgRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.ChangeExtVnfConnectivityRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.ChangeVnfFlavourRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.CreateVnfSnapshotRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.HealVnfRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.InstantiateVnfRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.OperateVnfRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.RevertToVnfSnapshotRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.ScaleVnfRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.ScaleVnfToLevelRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.TerminateVnfRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.VnfInfoModificationRequest;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.VnfLcmOpOcc;
import com.ubiqube.etsi.mano.vnfm.fc.vnflcm.VnfLcmClassMaping;

import ma.glasnost.orika.MapperFacade;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@Service
public class VnfLcmClassMaping351 implements VnfLcmClassMaping {
	private final MapperFacade mapper;

	public VnfLcmClassMaping351(final MapperFacade mapper) {
		this.mapper = mapper;
	}

	@Override
	public <R> R getInstantiateVnfRequest(final VnfBlueprint o) {
		return (R) mapper.map(o, InstantiateVnfRequest.class);
	}

	@Override
	public <R> R getScaleVnfRequest(final VnfBlueprint o) {
		return (R) mapper.map(o, ScaleVnfRequest.class);
	}

	@Override
	public <R> R getScaleVnfToLevelRequest(final VnfBlueprint o) {
		return (R) mapper.map(o, ScaleVnfToLevelRequest.class);
	}

	@Override
	public <R> R getChangeVnfFlavourRequest(final VnfBlueprint o) {
		return (R) mapper.map(o, ChangeVnfFlavourRequest.class);
	}

	@Override
	public <R> R getOperateVnfRequest(final VnfBlueprint o) {
		return (R) mapper.map(o, OperateVnfRequest.class);
	}

	@Override
	public <R> R getHealVnfRequest(final VnfBlueprint o) {
		return (R) mapper.map(o, HealVnfRequest.class);
	}

	@Override
	public <R> R getChangeExtVnfConnectivityRequest(final VnfBlueprint o) {
		return (R) mapper.map(o, ChangeExtVnfConnectivityRequest.class);
	}

	@Override
	public <R> R getTerminateVnfRequest(final VnfBlueprint o) {
		return (R) mapper.map(o, TerminateVnfRequest.class);
	}

	@Override
	public <R> R getVnfInfoModificationRequest(final VnfBlueprint o) {
		return (R) mapper.map(o, VnfInfoModificationRequest.class);
	}

	@Override
	public <R> R getCreateVnfSnapshotRequest(final VnfBlueprint o) {
		return (R) mapper.map(o, CreateVnfSnapshotRequest.class);
	}

	@Override
	public <R> R getRevertToVnfSnapshotRequest(final VnfBlueprint o) {
		return (R) mapper.map(o, RevertToVnfSnapshotRequest.class);
	}

	@Override
	public <R> R getChangeCurrentVnfPkgRequest(final VnfBlueprint o) {
		return (R) mapper.map(o, ChangeCurrentVnfPkgRequest.class);
	}

	@Override
	public <R> R mapToVnfLcmOpOcc(final VnfBlueprint o) {
		return (R) mapper.map(o, VnfLcmOpOcc.class);
	}

}
