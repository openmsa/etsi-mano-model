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
package com.ubiqube.etsi.mano.v261.model.nfvo.nslcm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The enumeration NsLcmOpType represents those lifecycle operations that
 * trigger a NS lifecycle management operation occurrence notification. Value |
 * Description ------|------------ INSTANTIATE | Represents the \"Instantiate
 * NS\" LCM operation. SCALE | Represents the \"Scale NS\" LCM operation. UPDATE
 * | Represents the \"Update NS\" LCM operation. TERMINATE | Represents the
 * \"Terminate NS\" LCM operation. HEAL | Represents the \"Heal NS\" LCM
 * operation.
 */
public enum NsLcmOpType {

	INSTANTIATE("INSTANTIATE"),

	SCALE("SCALE"),

	UPDATE("UPDATE"),

	TERMINATE("TERMINATE"),

	HEAL("HEAL");

	private String value;

	NsLcmOpType(final String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

	@JsonCreator
	public static NsLcmOpType fromValue(final String text) {
		for (final NsLcmOpType b : NsLcmOpType.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}
