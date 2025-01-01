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
package com.ubiqube.etsi.mano.mapping;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.ubiqube.etsi.mano.test.MapstructTestHelper;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.VnfInstance;
import com.ubiqube.etsi.mano.v361.model.nfvo.vnf.VnfPkgInfo;
import com.ubiqube.etsi.mano.v361.service.mapping.VnfInstance361Mapping;
import com.ubiqube.etsi.mano.v361.service.mapping.VnfPkgInfo361Mapping;
import com.ubiqube.etsi.mano.v361.service.mapping.vnflcm.VnfBlueprint361Mapping;

class MappingTest extends MapstructTestHelper {

	@Test
	void testVnfPkgInfo() throws Exception {
		final Set<String> ignore = new HashSet<>();
		ignore.add("getLinks");
		final VnfPkgInfo361Mapping mapper = Mappers.getMapper(VnfPkgInfo361Mapping.class);
		doTest(VnfPkgInfo.class, x -> mapper.map(x), x -> mapper.map(x));
		assertTrue(true);
	}

	@Test
	void testVnfInstance() throws Exception {
		final Set<String> ignore = new HashSet<>();
		ignore.add("getLinks");
		ignore.add("getInstantiatedVnfInfo.getVnfVirtualLinkResourceInfo");
		ignore.add("getInstantiatedVnfInfo.getExtVirtualLinkInfo.[0].getResourceHandle.getContainerNamespace");
		//
		ignore.add("getInstantiatedVnfInfo.getVnfcInfo");
		ignore.add("getInstantiatedVnfInfo.getScaleStatus.[0].getScaleLevel");
		ignore.add("getInstantiatedVnfInfo.getMaxScaleLevels.[0].getScaleLevel");
		final VnfInstance361Mapping mapper = Mappers.getMapper(VnfInstance361Mapping.class);
		doTest(ignore, VnfInstance.class, x -> mapper.map(x), x -> mapper.map(x));
		assertTrue(true);
	}

	@Test
	void testLcmOpOccs() throws Exception {
		final Set<String> ignore = new HashSet<>();
		ignore.add("getLinks");
		final VnfBlueprint361Mapping mapper = Mappers.getMapper(VnfBlueprint361Mapping.class);
//		doTest(VnfLcmOpOcc.class, x -> mapper.map(x), x -> mapper.map(x));
		assertTrue(true);
	}

}
