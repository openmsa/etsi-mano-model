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
 *     along with this program.  If not, see https://www.gnu.org/licenses/.
 */
package com.ubiqube.etsi.mano.v431.model.em.vnflcm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import jakarta.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

/**
 * HealVnfRequest
 */
@Validated

public class HealVnfRequest {
	@JsonProperty("vnfcInstanceId")
	@Valid
	private List<String> vnfcInstanceId = null;

	@JsonProperty("cause")
	private String cause = null;

	@JsonProperty("additionalParams")
	private Map<String, String> additionalParams = null;

	@JsonProperty("healScript")
	private String healScript = null;

	public HealVnfRequest vnfcInstanceId(final List<String> vnfcInstanceId) {
		this.vnfcInstanceId = vnfcInstanceId;
		return this;
	}

	public HealVnfRequest addVnfcInstanceIdItem(final String vnfcInstanceIdItem) {
		if (this.vnfcInstanceId == null) {
			this.vnfcInstanceId = new ArrayList<>();
		}
		this.vnfcInstanceId.add(vnfcInstanceIdItem);
		return this;
	}

	/**
	 * List of identifiers of VNFC instances for which a healing action is
	 * requested. Each identifier references the \"id\" attribute in a \"VnfcInfo\"
	 * structure. Cardinality can be \"0\" to denote that the request applies to the
	 * whole VNF and not a specific VNFC instance.
	 *
	 * @return vnfcInstanceId
	 **/
	@Schema(description = "List of identifiers of VNFC instances for which a healing action is requested. Each identifier references the \"id\" attribute in a \"VnfcInfo\" structure. Cardinality can be \"0\" to denote that the request applies to the whole VNF and not a specific VNFC instance. ")

	public List<String> getVnfcInstanceId() {
		return vnfcInstanceId;
	}

	public void setVnfcInstanceId(final List<String> vnfcInstanceId) {
		this.vnfcInstanceId = vnfcInstanceId;
	}

	public HealVnfRequest cause(final String cause) {
		this.cause = cause;
		return this;
	}

	/**
	 * Indicates the reason why a healing procedure is required.
	 *
	 * @return cause
	 **/
	@Schema(description = "Indicates the reason why a healing procedure is required. ")

	public String getCause() {
		return cause;
	}

	public void setCause(final String cause) {
		this.cause = cause;
	}

	public HealVnfRequest additionalParams(final Map<String, String> additionalParams) {
		this.additionalParams = additionalParams;
		return this;
	}

	/**
	 * Get additionalParams
	 *
	 * @return additionalParams
	 **/
	@Schema(description = "")

	@Valid
	public Map<String, String> getAdditionalParams() {
		return additionalParams;
	}

	public void setAdditionalParams(final Map<String, String> additionalParams) {
		this.additionalParams = additionalParams;
	}

	public HealVnfRequest healScript(final String healScript) {
		this.healScript = healScript;
		return this;
	}

	/**
	 * Provides link to a script that should be executed as part of the healing
	 * action or a set of rules for healing procedure.
	 *
	 * @return healScript
	 **/
	@Schema(description = "Provides link to a script that should be executed as part of the healing action or a set of rules for healing procedure. ")

	public String getHealScript() {
		return healScript;
	}

	public void setHealScript(final String healScript) {
		this.healScript = healScript;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final HealVnfRequest healVnfRequest = (HealVnfRequest) o;
		return Objects.equals(this.vnfcInstanceId, healVnfRequest.vnfcInstanceId) &&
				Objects.equals(this.cause, healVnfRequest.cause) &&
				Objects.equals(this.additionalParams, healVnfRequest.additionalParams) &&
				Objects.equals(this.healScript, healVnfRequest.healScript);
	}

	@Override
	public int hashCode() {
		return Objects.hash(vnfcInstanceId, cause, additionalParams, healScript);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class HealVnfRequest {\n");

		sb.append("    vnfcInstanceId: ").append(toIndentedString(vnfcInstanceId)).append("\n");
		sb.append("    cause: ").append(toIndentedString(cause)).append("\n");
		sb.append("    additionalParams: ").append(toIndentedString(additionalParams)).append("\n");
		sb.append("    healScript: ").append(toIndentedString(healScript)).append("\n");
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
