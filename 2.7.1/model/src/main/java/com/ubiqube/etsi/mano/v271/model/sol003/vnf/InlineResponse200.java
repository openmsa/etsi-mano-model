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
package com.ubiqube.etsi.mano.v271.model.sol003.vnf;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v271.model.sol003.vnf.VnfPkgInfo;
import com.fasterxml.jackson.annotation.JsonCreator;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * InlineResponse200
 */
@Validated
public class InlineResponse200   {
  @JsonProperty("VnfPkgInfo")
  private VnfPkgInfo vnfPkgInfo = null;

	public InlineResponse200 vnfPkgInfo(VnfPkgInfo vnfPkgInfo) {
		this.vnfPkgInfo = vnfPkgInfo;
		return this;
	}

	/**
	* Get vnfPkgInfo
	* @return vnfPkgInfo
	*/
	@Schema(description = "")
	@Valid
	public VnfPkgInfo getVnfPkgInfo() {
		return vnfPkgInfo;
	}

	public void setVnfPkgInfo(VnfPkgInfo vnfPkgInfo) {
		this.vnfPkgInfo = vnfPkgInfo;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		InlineResponse200 inlineResponse200 = (InlineResponse200) o;
		return Objects.equals(this.vnfPkgInfo, inlineResponse200.vnfPkgInfo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(vnfPkgInfo);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class InlineResponse200 {\n");

		sb.append("    vnfPkgInfo: ").append(toIndentedString(vnfPkgInfo)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	* Convert the given object to string with each line indented by 4 spaces
	* (except the first line).
	*/
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
