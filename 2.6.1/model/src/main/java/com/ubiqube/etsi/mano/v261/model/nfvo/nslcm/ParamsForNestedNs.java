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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.annotation.Nonnull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;


/**
 * This type specifies additional parameters on a per-nested NS instance basis.
 * It shall comply with the provisions defined in Table 6.5.3.21a-1.
 */
@Schema(description = "This type specifies additional parameters on a per-nested NS instance basis.  It shall comply with the provisions defined in Table 6.5.3.21a-1. ")
@Validated


public class ParamsForNestedNs {
	@JsonProperty("nsProfileId")
	private String nsProfileId = null;

	@JsonProperty("additionalParam")
	@Valid
	private List<Map<String, String>> additionalParam = null;

	public ParamsForNestedNs nsProfileId(final String nsProfileId) {
		this.nsProfileId = nsProfileId;
		return this;
	}

	/**
	 * Identifier of a NsProfile to which the additional parameters apply.
	 *
	 * @return nsProfileId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifier of a NsProfile to which the additional parameters apply. ")
	@Nonnull

	public String getNsProfileId() {
		return nsProfileId;
	}

	public void setNsProfileId(final String nsProfileId) {
		this.nsProfileId = nsProfileId;
	}

	public ParamsForNestedNs additionalParam(final List<Map<String, String>> additionalParam) {
		this.additionalParam = additionalParam;
		return this;
	}

	public ParamsForNestedNs addAdditionalParamItem(final Map<String, String> additionalParamItem) {
		if (this.additionalParam == null) {
			this.additionalParam = new ArrayList<>();
		}
		this.additionalParam.add(additionalParamItem);
		return this;
	}

	/**
	 * Additional parameters that are to be applied on a per nested NS instance.
	 *
	 * @return additionalParam
	 **/
	@Schema(description = "Additional parameters that are to be applied on a per nested NS instance. ")

	@Valid

	public List<Map<String, String>> getAdditionalParam() {
		return additionalParam;
	}

	public void setAdditionalParam(final List<Map<String, String>> additionalParam) {
		this.additionalParam = additionalParam;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final ParamsForNestedNs paramsForNestedNs = (ParamsForNestedNs) o;
		return Objects.equals(this.nsProfileId, paramsForNestedNs.nsProfileId) &&
				Objects.equals(this.additionalParam, paramsForNestedNs.additionalParam);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nsProfileId, additionalParam);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class ParamsForNestedNs {\n");

		sb.append("    nsProfileId: ").append(toIndentedString(nsProfileId)).append("\n");
		sb.append("    additionalParam: ").append(toIndentedString(additionalParam)).append("\n");
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
