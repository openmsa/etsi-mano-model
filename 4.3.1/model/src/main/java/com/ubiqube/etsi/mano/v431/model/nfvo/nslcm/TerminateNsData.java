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
package com.ubiqube.etsi.mano.v431.model.nfvo.nslcm;

import java.util.Map;
import java.util.Objects;

import jakarta.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

/**
 * TerminateNsData
 */
@Validated

public class TerminateNsData {
	@JsonProperty("additionalParamsforNs")
	private Map<String, String> additionalParamsforNs = null;

	public TerminateNsData additionalParamsforNs(final Map<String, String> additionalParamsforNs) {
		this.additionalParamsforNs = additionalParamsforNs;
		return this;
	}

	/**
	 * Get additionalParamsforNs
	 *
	 * @return additionalParamsforNs
	 **/
	@Schema(description = "")

	@Valid
	public Map<String, String> getAdditionalParamsforNs() {
		return additionalParamsforNs;
	}

	public void setAdditionalParamsforNs(final Map<String, String> additionalParamsforNs) {
		this.additionalParamsforNs = additionalParamsforNs;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final TerminateNsData terminateNsData = (TerminateNsData) o;
		return Objects.equals(this.additionalParamsforNs, terminateNsData.additionalParamsforNs);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalParamsforNs);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class TerminateNsData {\n");

		sb.append("    additionalParamsforNs: ").append(toIndentedString(additionalParamsforNs)).append("\n");
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
