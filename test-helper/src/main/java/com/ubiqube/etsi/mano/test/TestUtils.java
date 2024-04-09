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
package com.ubiqube.etsi.mano.test;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class TestUtils {
	private TestUtils() {
		// Nothing.
	}

	public static PodamFactory createPodam() {
		final PodamFactoryImpl podam = new PodamFactoryImpl();
		podam.getStrategy().addOrReplaceTypeManufacturer(String.class, new UUIDManufacturer());
		podam.getStrategy().setDefaultNumberOfCollectionElements(1);
		return podam;
	}

//	public static DefaultMapperFactory createOrika(final OrikaMapperFactoryConfigurer orikaMapperFactoryConfigurer) {
//		System.setProperty(OrikaSystemProperties.COMPILER_STRATEGY, EclipseJdtCompilerStrategy.class.getName());
//		System.setProperty(OrikaSystemProperties.WRITE_SOURCE_FILES, "true");
//		System.setProperty(OrikaSystemProperties.WRITE_SOURCE_FILES_TO_PATH, "/tmp/orika-test");
//		final DefaultMapperFactory mapperFactory = new DefaultMapperFactory.Builder().compilerStrategy(new EclipseJdtCompilerStrategy()).build();
//		orikaMapperFactoryConfigurer.configure(mapperFactory);
//		final ConverterFactory converterFactory = mapperFactory.getConverterFactory();
//		converterFactory.registerConverter("filterConverter", new OrikaFilterMapper());
//		converterFactory.registerConverter(new UuidConverter());
//		converterFactory.registerConverter(new OffsetDateTimeToDateConverter());
//		return mapperFactory;
//	}
}
