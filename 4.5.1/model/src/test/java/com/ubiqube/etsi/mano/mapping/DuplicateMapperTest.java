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

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;

class DuplicateMapperTest {
	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DuplicateMapperTest.class);

	private final MultiValueMap<Key, Method> cache = new LinkedMultiValueMap<>();

	private ClassInfoList allClasses;

	public DuplicateMapperTest() {
		try (ScanResult scanResult = new ClassGraph()
				.enableAllInfo()
				.acceptPackages("com.ubiqube.etsi.mano.v451")
				.scan()) {
			allClasses = scanResult.getAllClasses();
		}
	}

	@Test
	void test() {
		final Set<String> set = allClasses.stream().map(ClassInfo::getName).collect(Collectors.toSet());
		set.forEach(x -> {
			handle(x);
		});
		renderResult();
	}

	private void renderResult() {
		cache.entrySet().forEach(x -> {
			if (x.getValue().size() <= 1) {
				return;
			}
			renderError(x);
		});
	}

	private void renderError(final Entry<Key, List<Method>> x) {
		LOG.error("- " + x.getKey());
		x.getValue().forEach(y -> {
			LOG.error("    - {}", y);
		});
		LOG.error("---------------------------------------");
	}

	private void handle(final String x) {
		if (x.startsWith("java.lang")) {
			return;
		}
		try {
			realHandle(x);
		} catch (final Exception e) {
			throw new RuntimeException(x, e);
		}

	}

	private void realHandle(final String x) throws ClassNotFoundException {
		final Class<?> clazz = Class.forName(x);
		final Method[] meths = clazz.getDeclaredMethods();
		for (final Method method : meths) {
			LOG.info(method.toString());
			if (method.getParameters().length > 0) {
				final Key k = new Key(method.getReturnType().getCanonicalName(), method.getParameters()[0].getType().getCanonicalName());
				cache.add(k, method);
			}
		}
	}

}

record Key(String returnType, String param) {
	//
}