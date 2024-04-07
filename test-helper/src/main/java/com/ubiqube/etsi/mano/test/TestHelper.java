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

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubiqube.orika.OrikaMapperFactoryConfigurer;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import uk.co.jemos.podam.api.PodamFactory;

public class TestHelper extends AssertNull {
	private static final Logger LOG = LoggerFactory.getLogger(TestHelper.class);

	private final DefaultMapperFactory mapperFactory;
	private final PodamFactory podam;

	public TestHelper(final OrikaMapperFactoryConfigurer orikaMapperFactoryConfigurer) {
		this.mapperFactory = TestUtils.createOrika(orikaMapperFactoryConfigurer);
		this.podam = TestUtils.createPodam();
	}

	protected void doTest(final Class<?> json, final Class<?> db, final Set<String> ignore) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final MapperFacade mapper = mapperFactory.getMapperFacade();
		final Object avc = podam.manufacturePojo(json);
		final Object avcDb = mapper.map(avc, db);
		final Object res = mapper.map(avcDb, json);
		final Deque<String> stack = new ArrayDeque<>();
		deepSort(avc, res);
		assertFullEqual(avc, res, ignore, stack);
	}

	private void deepSort(final Object orig, final Object tgt) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		final BeanInfo beanInfo = Introspector.getBeanInfo(orig.getClass());
		final MethodDescriptor[] m = beanInfo.getMethodDescriptors();
		for (final MethodDescriptor methodDescriptor : m) {
			final String methodName = methodDescriptor.getName();
			if (!methodName.startsWith("get") || "getClass".equals(methodName)) {
				continue;
			}
			LOG.debug(" + {} on {}", methodName, orig.getClass());
			final Object src = methodDescriptor.getMethod().invoke(orig);
			if (null == tgt) {
				continue;
			}
			final Object dst = methodDescriptor.getMethod().invoke(tgt);
			if (null == src) {
				LOG.warn("  - {} is null", methodName);
				continue;
			}
			if (src instanceof final List<?> sl) {
				final List<?> dl = (List<?>) dst;
				if (null == dl) {
					continue;
				}
				if (sl.size() != dl.size()) {
					LOG.warn("");
					continue;
				}
				for (int i = 0; i < sl.size(); i++) {
					final Object els = sl.get(i);
					final Object eld = dl.get(i);
					if (isComplex(els)) {
						deepSort(els, eld);
					}
				}
				Collections.sort(sl, Comparator.comparing(Object::toString));
				Collections.sort(dl, Comparator.comparing(Object::toString));
			} else if (src instanceof Map) {
				LOG.warn("Map not supported, skipping {}", methodName);
			} else if (src instanceof Set) {
				LOG.warn("Set not supported, skipping {}", methodName);
			} else if (isComplex(src)) {
				deepSort(src, dst);
			} else {
				// Nothing.
			}
		}
	}
}
