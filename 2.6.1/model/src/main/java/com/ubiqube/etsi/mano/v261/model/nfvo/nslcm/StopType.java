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
 * * FORCEFUL: The VNFM will stop the VNF immediately after accepting the
 * request. * GRACEFUL: The VNFM will first arrange to take the VNF out of
 * service after accepting the request. Once that operation is successful or
 * once the timer value specified in the \"gracefulStopTimeout\" attribute
 * expires, the VNFM will stop the VNF.
 */
public enum StopType {

	FORCEFUL("FORCEFUL"),

	GRACEFUL("GRACEFUL");

	private String value;

	StopType(final String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

	@JsonCreator
	public static StopType fromValue(final String text) {
		for (final StopType b : StopType.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}
