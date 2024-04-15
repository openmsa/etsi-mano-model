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

import static org.junit.jupiter.api.Assertions.fail;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayDeque;
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
		complex.add(LocalDateTime.class);
	}

	protected <T> void assertFullEqual(final T orig, final T tgt, final Set<String> ignore, final Deque<String> stack, final List<String> errors) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		final BeanInfo beanInfo = Introspector.getBeanInfo(orig.getClass());
		final MethodDescriptor[] m = beanInfo.getMethodDescriptors();
		for (final MethodDescriptor methodDescriptor : m) {
			final String methodName = methodDescriptor.getName();
			if (!canHandle(methodName, stack, ignore)) {
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
				assertNotNull(dl, "Target element is null for field: " + methodName + prettyStack(stack), errors);
				assertEquals(sl.size(), dl.size(), "List are not equals " + methodName + prettyStack(stack), errors);
				handleList(sl, dl, ignore, stack, methodName, errors);
			} else if (src instanceof final Map sm) {
				if (dst instanceof final Map dm) {
					handleMapToMap(dm, dm, stack, errors);
				}
				LOG.warn("Map not supported, skipping {}", methodName);
			} else if (src instanceof Set) {
				LOG.warn("Set not supported, skipping {}", methodName);
			} else if (isComplex(src)) {
				LOG.warn("  + Looping: {}", src.getClass());
				assertNotNull(dst, "Target element is null for field: " + methodName + prettyStack(stack), errors);
				assertFullEqual(src, dst, ignore, stack, errors);
			} else {
				if (methodName.equals("getVnfPkgId")) {
					LOG.debug("Hello");
				}
				assertEquals(src, dst, "Field " + methodName + ": must be equals." + prettyStack(stack), errors);
			}
			stack.pop();
		}
	}

	private static boolean canHandle(final String methodName, final Deque<String> stack, final Set<String> ignore) {
		final Deque<String> st = new ArrayDeque<>(stack);
		st.push(methodName);
		if ("getVnfVirtualLinkResourceInfo".equals(methodName)) {
			System.out.println("");
		}
		if (!methodName.startsWith("get") || "getClass".equals(methodName) || isInIgnoreList(ignore, st)) {
			return false;
		}
		return true;
	}

	private static boolean isInIgnoreList(final Set<String> ignore, final Deque<String> st) {
		return ignore.contains(String.join(".", st.reversed()));
	}

	private static void assertNotNull(final Object dl, final String string, final List<String> errors) {
		if (dl == null) {
			errors.add(string);
		}
	}

	private static void assertEquals(final Object src, final Object dst, final String string, final List<String> error) {
		if (src == null) {
			error.add(string);
			return;
		}
		if (!src.equals(dst)) {
			error.add(string);
		}
	}

	private static void assertEquals(final int size, final int size2, final String string, final List<String> error) {
		if (size != size2) {
			error.add(string);
			fail("" + error);
		}
	}

	private static void handleMapToMap(final Map sm, final Map dm, final Deque<String> stack, final List<String> errors) {
		assertEquals(sm.size(), sm.size(), "Map are not equals " + prettyStack(stack), errors);
	}

	private void handleList(final List<?> sl, final List<?> dl, final Set<String> ignore, final Deque<String> stack, final String methodName, final List<String> errors) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		for (int i = 0; i < sl.size(); i++) {
			final Object so = sl.get(i);
			final Object dobj = dl.get(i);
			stack.push("[" + i + "]");
			if (isComplex(so)) {
				assertFullEqual(so, dobj, ignore, stack, errors);
			} else {
				assertEquals(so, dobj, "List in " + methodName + ": is not equal at " + i + prettyStack(stack), errors);
			}
			stack.pop();
		}
	}

	private static String prettyStack(final Deque<String> stack) {
		final String str = String.join(".", stack.reversed());
		return "\n" + str;
	}

	protected boolean isComplex(final Object r) {
		if (r instanceof Enum) {
			return false;
		}
		return !complex.contains(r.getClass());
	}

}
