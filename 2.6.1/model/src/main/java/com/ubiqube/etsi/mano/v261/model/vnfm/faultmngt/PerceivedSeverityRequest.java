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
package com.ubiqube.etsi.mano.v261.model.vnfm.faultmngt;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v261.model.nfvo.nsfm.PerceivedSeverityType;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.annotation.Nonnull;
import jakarta.validation.Valid;

/**
 * This type represents the escalated value of the perceived severity for an
 * alarm.
 */
@Schema(description = "This type represents the escalated value of the perceived severity for an alarm. ")
@Validated
public class PerceivedSeverityRequest {
	@JsonProperty("proposedPerceivedSeverity")
	private PerceivedSeverityType proposedPerceivedSeverity = null;

	public PerceivedSeverityRequest proposedPerceivedSeverity(final PerceivedSeverityType proposedPerceivedSeverity) {
		this.proposedPerceivedSeverity = proposedPerceivedSeverity;
		return this;
	}

	/**
	 * Indicates the proposed escalated perceived severity for an alarm.
	 *
	 * @return proposedPerceivedSeverity
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Indicates the proposed escalated perceived severity for an alarm. ")
	@Nonnull

	@Valid

	public PerceivedSeverityType getProposedPerceivedSeverity() {
		return proposedPerceivedSeverity;
	}

	public void setProposedPerceivedSeverity(final PerceivedSeverityType proposedPerceivedSeverity) {
		this.proposedPerceivedSeverity = proposedPerceivedSeverity;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final PerceivedSeverityRequest perceivedSeverityRequest = (PerceivedSeverityRequest) o;
		return Objects.equals(this.proposedPerceivedSeverity, perceivedSeverityRequest.proposedPerceivedSeverity);
	}

	@Override
	public int hashCode() {
		return Objects.hash(proposedPerceivedSeverity);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class PerceivedSeverityRequest {\n");

		sb.append("    proposedPerceivedSeverity: ").append(toIndentedString(proposedPerceivedSeverity)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(final java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
