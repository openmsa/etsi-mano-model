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
package com.ubiqube.etsi.mano.mapping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.time.OffsetDateTime;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AssertNull {
	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(AssertNull.class);
	private final Set<Class<?>> complex = new HashSet<>();

	public AssertNull() {
		complex.add(String.class);
		complex.add(UUID.class);
		complex.add(Long.class);
		complex.add(Integer.class);
		complex.add(Boolean.class);
		complex.add(OffsetDateTime.class);
	}

	protected void assertFullEqual(final Object orig, final Object tgt, final Set<String> ignore, final Deque<String> stack) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		final BeanInfo beanInfo = Introspector.getBeanInfo(orig.getClass());
		final MethodDescriptor[] m = beanInfo.getMethodDescriptors();
		for (final MethodDescriptor methodDescriptor : m) {
			final String methodName = methodDescriptor.getName();
			if (!methodName.startsWith("get") || "getClass".equals(methodName) || ignore.contains(methodName)) {
				continue;
			}
			LOG.debug(" + {}", methodName);
			stack.push(methodName);
			final Object src = methodDescriptor.getMethod().invoke(orig);
			final Object dst = methodDescriptor.getMethod().invoke(tgt);
			if (null == src) {
				LOG.warn("  - {} is null", methodName);
				continue;
			}
			if (src instanceof final List<?> sl) {
				final List<?> dl = (List<?>) dst;
				assertNotNull(dl, "Target element is null for field: " + methodName + prettyStack(stack));
				assertEquals(sl.size(), dl.size(), "List are not equals " + methodName + prettyStack(stack));
				handleList(sl, dl, ignore, stack, methodName);
			} else if (src instanceof Map) {
				LOG.warn("Map not supported, skipping {}", methodName);
			} else if (src instanceof Set) {
				LOG.warn("Set not supported, skipping {}", methodName);
			} else if (isComplex(src)) {
				LOG.warn("  + Looping: {}", src.getClass());
				assertNotNull(dst, "Target element is null for field: " + methodName + prettyStack(stack));
				assertFullEqual(src, dst, ignore, stack);
			} else {
				if (methodName.equals("getVnfPkgId")) {
					LOG.debug("Hello");
				}
				assertEquals(src, dst, "Field " + methodName + ": must be equals." + prettyStack(stack));
			}
			stack.pop();
		}
	}

	private void handleList(final List<?> sl, final List<?> dl, final Set<String> ignore, final Deque<String> stack, final String methodName) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		for (int i = 0; i < sl.size(); i++) {
			final Object so = sl.get(i);
			final Object dobj = dl.get(i);
			stack.push("[" + i + "]");
			if (isComplex(so)) {
				assertFullEqual(so, dobj, ignore, stack);
			} else {
				assertEquals(so, dobj, "List in " + methodName + ": is not equal at " + i + prettyStack(stack));
			}
			stack.pop();
		}
	}

	private static String prettyStack(final Deque<String> stack) {
		return "\n" + stack.toString();
	}

	protected boolean isComplex(final Object r) {
		if (r instanceof Enum) {
			return false;
		}
		return !complex.contains(r.getClass());
	}

}
