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
package com.ubiqube.etsi.mano.v271.model.sol005.nslcm;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

/**
 * This type represents a NS termination request. It shall comply with the
 * provisions defined in Table 6.5.2.15-1.
 */
@Schema (description= "This type represents a NS termination request.  It shall comply with the provisions defined in Table 6.5.2.15-1. " )
@Validated
public class TerminateNsRequest {
	@JsonProperty("terminationTime")
	private LocalDateTime terminationTime = null;

	public TerminateNsRequest terminationTime(final LocalDateTime terminationTime) {
		this.terminationTime = terminationTime;
		return this;
	}

	/**
	 * Get terminationTime
	 *
	 * @return terminationTime
	 **/
	@Schema(description = "")

	@Valid
	public LocalDateTime getTerminationTime() {
		return terminationTime;
	}

	public void setTerminationTime(final LocalDateTime terminationTime) {
		this.terminationTime = terminationTime;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final TerminateNsRequest terminateNsRequest = (TerminateNsRequest) o;
		return Objects.equals(this.terminationTime, terminateNsRequest.terminationTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(terminationTime);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class TerminateNsRequest {\n");

		sb.append("    terminationTime: ").append(toIndentedString(terminationTime)).append("\n");
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
