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
package com.ubiqube.etsi.mano.common.v261.model.vnf;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * \"The enumeration PackageOperationalStateType shall comply with the
 * provisions defined in Table 9.5.4.4-1.\" Acceptable values are: - ENABLED -
 * The VNF package is enabled, i.e. it can be used for instantiation of new VNF
 * instances. - DISABLED - The VNF package is disabled, i.e. it cannot be used
 * for further VNF instantiation requests (unless and until the VNF package is
 * re-enabled).
 */
public enum PackageOperationalStateType {

	ENABLED("ENABLED"),

	DISABLED("DISABLED");

	private String value;

	PackageOperationalStateType(final String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

	@JsonCreator
	public static PackageOperationalStateType fromValue(final String text) {
		for (final PackageOperationalStateType b : PackageOperationalStateType.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}
