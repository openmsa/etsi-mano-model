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
package com.ubiqube.etsi.mano.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.ubiqube.etsi.mano.dao.mano.GrantInformationExt;
import com.ubiqube.etsi.mano.v261.model.nfvo.lcmgrant.ResourceDefinition;
import com.ubiqube.etsi.mano.v261.vnfm.service.OrikaMapperVnfm261;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.impl.generator.EclipseJdtCompilerStrategy;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author olivier
 *
 */
class GrantInformationTest {
	private final DefaultMapperFactory mapperFactory;
	private final PodamFactoryImpl podam;

	public GrantInformationTest() {
		final OrikaMapperVnfm261 orikaConfiguration = new OrikaMapperVnfm261();
		mapperFactory = new DefaultMapperFactory.Builder().compilerStrategy(new EclipseJdtCompilerStrategy()).build();
		orikaConfiguration.configure(mapperFactory);

		podam = new PodamFactoryImpl();
		podam.getStrategy().addOrReplaceTypeManufacturer(String.class, new UUIDManufacturer());
	}

	@Test
	void testName() throws Exception {
		final MapperFacade mapper = mapperFactory.getMapperFacade();
		final ResourceDefinition avc = podam.manufacturePojo(ResourceDefinition.class);
		final GrantInformationExt avcDb = mapper.map(avc, GrantInformationExt.class);
		assertNotNull(avcDb.getId());
		assertEquals(avc.getResource().getVimConnectionId(), avcDb.getVimConnectionId());
	}
}
