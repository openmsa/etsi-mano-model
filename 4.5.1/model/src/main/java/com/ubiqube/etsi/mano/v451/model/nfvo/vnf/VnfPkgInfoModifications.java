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
package com.ubiqube.etsi.mano.v451.model.nfvo.vnf;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;

/**
 * This type represents modifications to the information of a VNF package. It
 * shall comply with the provisions defined in Table 9.5.2.3-1. NOTE: At least
 * one of the two parameters shall be present. If the VNF package is not
 * on-boarded, the operation is used only to update existing or add additional
 * user defined data using the userDefinedData attribute.
 */
@Schema(description = "This type represents modifications to the information of a VNF package.  It shall comply with the provisions defined in Table 9.5.2.3-1. NOTE: At least one of the two parameters shall be present. If the VNF package is not on-boarded, the operation is used only to update existing or add additional user defined data using the userDefinedData attribute. ")
@Validated

public class VnfPkgInfoModifications implements AnyOfVnfPkgInfoModifications {
	@JsonProperty("operationalState")
	private PackageOperationalStateType operationalState = null;

	@JsonProperty("userDefinedData")
	private Map<String, String> userDefinedData = null;

	public VnfPkgInfoModifications operationalState(final PackageOperationalStateType operationalState) {
		this.operationalState = operationalState;
		return this;
	}

	/**
	 * Get operationalState
	 *
	 * @return operationalState
	 **/
	@Schema(description = "")

	@Valid
	public PackageOperationalStateType getOperationalState() {
		return operationalState;
	}

	public void setOperationalState(final PackageOperationalStateType operationalState) {
		this.operationalState = operationalState;
	}

	public VnfPkgInfoModifications userDefinedData(final Map<String, String> userDefinedData) {
		this.userDefinedData = userDefinedData;
		return this;
	}

	/**
	 * Get userDefinedData
	 *
	 * @return userDefinedData
	 **/
	@Schema(description = "")

	@Valid
	public Map<String, String> getUserDefinedData() {
		return userDefinedData;
	}

	public void setUserDefinedData(final Map<String, String> userDefinedData) {
		this.userDefinedData = userDefinedData;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final VnfPkgInfoModifications vnfPkgInfoModifications = (VnfPkgInfoModifications) o;
		return Objects.equals(this.operationalState, vnfPkgInfoModifications.operationalState) &&
				Objects.equals(this.userDefinedData, vnfPkgInfoModifications.userDefinedData);
	}

	@Override
	public int hashCode() {
		return Objects.hash(operationalState, userDefinedData);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class VnfPkgInfoModifications {\n");

		sb.append("    operationalState: ").append(toIndentedString(operationalState)).append("\n");
		sb.append("    userDefinedData: ").append(toIndentedString(userDefinedData)).append("\n");
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
