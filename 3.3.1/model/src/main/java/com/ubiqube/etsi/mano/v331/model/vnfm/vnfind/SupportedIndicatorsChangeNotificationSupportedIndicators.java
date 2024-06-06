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
package com.ubiqube.etsi.mano.v331.model.vnfm.vnfind;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

/**
 * SupportedIndicatorsChangeNotificationSupportedIndicators
 */
@Validated

public class SupportedIndicatorsChangeNotificationSupportedIndicators {
	@JsonProperty("vnfIndicatorId")
	private String vnfIndicatorId = null;

	@JsonProperty("name")
	private String name = null;

	public SupportedIndicatorsChangeNotificationSupportedIndicators vnfIndicatorId(final String vnfIndicatorId) {
		this.vnfIndicatorId = vnfIndicatorId;
		return this;
	}

	/**
	 * Get vnfIndicatorId
	 *
	 * @return vnfIndicatorId
	 **/
	@Schema(required = true, description = "")
	@NotNull

	public String getVnfIndicatorId() {
		return vnfIndicatorId;
	}

	public void setVnfIndicatorId(final String vnfIndicatorId) {
		this.vnfIndicatorId = vnfIndicatorId;
	}

	public SupportedIndicatorsChangeNotificationSupportedIndicators name(final String name) {
		this.name = name;
		return this;
	}

	/**
	 * Human readable name of the VNF indicator. Shall be present if defined in the
	 * VNFD. ETSI GS NFV-SOL 001 specifies the structure and format of the VNFD
	 * based on TOSCA specifications.
	 *
	 * @return name
	 **/
	@Schema(description = "Human readable name of the VNF indicator.  Shall be  present if defined in the VNFD.  ETSI GS NFV-SOL 001 specifies the structure and format of  the VNFD based on TOSCA specifications. ")

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final SupportedIndicatorsChangeNotificationSupportedIndicators supportedIndicatorsChangeNotificationSupportedIndicators = (SupportedIndicatorsChangeNotificationSupportedIndicators) o;
		return Objects.equals(this.vnfIndicatorId, supportedIndicatorsChangeNotificationSupportedIndicators.vnfIndicatorId) &&
				Objects.equals(this.name, supportedIndicatorsChangeNotificationSupportedIndicators.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(vnfIndicatorId, name);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class SupportedIndicatorsChangeNotificationSupportedIndicators {\n");

		sb.append("    vnfIndicatorId: ").append(toIndentedString(vnfIndicatorId)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
