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

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import uk.co.jemos.podam.api.PodamFactory;

public class MapstructTestHelper extends AssertNull {

	private final PodamFactory podam;

	public MapstructTestHelper() {
		this.podam = TestPodam.createPodam();
	}

	protected <T, R> void doTest(final Class<T> clazz, final Function<T, R> in, final Function<R, T> out) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final T obj = podam.manufacturePojo(clazz);
		final R tmp = in.apply(obj);
		final T r2 = out.apply(tmp);
		final Deque<String> stack = new ArrayDeque<>();
		final List<String> errors = new ArrayList<>();
		assertFullEqual(obj, r2, Set.of("getLinks"), stack, errors);
		assertTrue(errors.isEmpty(), errors + "");
	}

	protected <T, R> void doTest(final Set<String> ignore, final Class<T> clazz, final Function<T, R> in, final Function<R, T> out) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final T obj = podam.manufacturePojo(clazz);
		final R tmp = in.apply(obj);
		final T r2 = out.apply(tmp);
		final Deque<String> stack = new ArrayDeque<>();
		final List<String> errors = new ArrayList<>();
		assertFullEqual(obj, r2, ignore, stack, errors);
		assertTrue(errors.isEmpty(), errors + "");
	}

}
