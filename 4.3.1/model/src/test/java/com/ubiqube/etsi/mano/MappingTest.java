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
package com.ubiqube.etsi.mano;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.ubiqube.etsi.mano.test.MapstructTestHelper;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.VnfInstance;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.VnfLcmOpOcc;
import com.ubiqube.etsi.mano.v431.model.nfvo.vnf.VnfPkgInfo;
import com.ubiqube.etsi.mano.v431.service.mapping.VnfInstance431Mapping;
import com.ubiqube.etsi.mano.v431.service.mapping.VnfLcmOpOcc431Mapping;
import com.ubiqube.etsi.mano.v431.service.mapping.VnfPkgInfo431Mapping;
import com.ubiqube.etsi.mano.v431.service.mapping.vnflcm.VnfBlueprint431Mapping;

class MappingTest extends MapstructTestHelper {
	public MappingTest() {
		//
	}

	@Test
	void testVnfPkgInfo() throws Exception {
		final Set<String> ignore = new HashSet<>();
		ignore.add("getLinks");
		final VnfPkgInfo431Mapping mapper = Mappers.getMapper(VnfPkgInfo431Mapping.class);
		doTest(VnfPkgInfo.class, x -> mapper.map(x), x -> mapper.map(x));
		assertTrue(true);
	}

	@Test
	void testVnfInstance() throws Exception {
		final Set<String> ignore = new HashSet<>();
		ignore.add("getLinks");
		ignore.add("getInstantiatedVnfInfo.getVnfVirtualLinkResourceInfo");
		ignore.add("getInstantiatedVnfInfo.getExtVirtualLinkInfo.[0].getResourceHandle.getContainerNamespace");
		ignore.add("getInstantiatedVnfInfo.getExtManagedVirtualLinkInfo.[0].getVnfLinkPorts.[0].getVipCpInstanceId");
		ignore.add("getInstantiatedVnfInfo.getExtManagedVirtualLinkInfo.[0].getVnfLinkPorts.[0].getTrunkResourceId");
		final VnfInstance431Mapping mapper = Mappers.getMapper(VnfInstance431Mapping.class);
		doTest(ignore, VnfInstance.class, x -> mapper.map(x), x -> mapper.map(x));
		assertTrue(true);
	}

	@Test
	void testLcmOpOccs() throws Exception {
		final Set<String> ignore = new HashSet<>();
		ignore.add("getLinks");
		final VnfBlueprint431Mapping mapper = Mappers.getMapper(VnfBlueprint431Mapping.class);
		final VnfLcmOpOcc431Mapping mapper2 = Mappers.getMapper(VnfLcmOpOcc431Mapping.class);
		doTest(VnfLcmOpOcc.class, x -> mapper2.map(x), x -> mapper.map(x));
		assertTrue(true);
	}

}
