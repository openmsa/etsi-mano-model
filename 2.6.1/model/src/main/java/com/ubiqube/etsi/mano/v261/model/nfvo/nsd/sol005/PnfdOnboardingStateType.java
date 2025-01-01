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
package com.ubiqube.etsi.mano.v261.model.nfvo.nsd.sol005;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The enumeration PnfdOnboardingStateType shall comply with the provisions
 * defined in Table 5.5.4.6-1 of GS-NFV SOL005. It indicates the on-boarding
 * state of the individual PNF descriptor resource. CREATED = The PNF descriptor
 * resource is created. UPLOADING = The associated PNFD content is being
 * uploaded. PROCESSING = The associated PNFD content is being processed, e.g.
 * validation. ONBOARDED = The associated PNFD content is on-boarded.
 */
public enum PnfdOnboardingStateType {

	CREATED("CREATED"),

	UPLOADING("UPLOADING"),

	PROCESSING("PROCESSING"),

	ONBOARDING("ONBOARDING");

	private String value;

	PnfdOnboardingStateType(final String value) {
		this.value = value;
	}

	@Override
	@JsonValue
	public String toString() {
		return String.valueOf(value);
	}

	@JsonCreator
	public static PnfdOnboardingStateType fromValue(final String text) {
		for (final PnfdOnboardingStateType b : PnfdOnboardingStateType.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}
