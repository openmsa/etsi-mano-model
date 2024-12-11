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
package com.ubiqube.etsi.mano.v451.model.em.vnflcm;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type provides information enabling the access and use of the PaaS
 * Service by the VNF instance. The type and format of the handle depends on the
 * form that the PaaS Service is formed.
 */
@Schema(description = "This type provides information enabling the access and use of the PaaS Service by the  VNF instance. The type and format of the handle depends on the form that the PaaS Service is formed. ")
@Validated

public class PaasServiceHandle {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("interfaceInfo")
	private Map<String, String> interfaceInfo = null;

	@JsonProperty("accessInfo")
	private Map<String, String> accessInfo = null;

	@JsonProperty("extra")
	private Map<String, String> extra = null;

	public PaasServiceHandle id(final String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 *
	 * @return id
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public PaasServiceHandle interfaceInfo(final Map<String, String> interfaceInfo) {
		this.interfaceInfo = interfaceInfo;
		return this;
	}

	/**
	 * Get interfaceInfo
	 *
	 * @return interfaceInfo
	 **/
	@Schema(description = "")

	@Valid
	public Map<String, String> getInterfaceInfo() {
		return interfaceInfo;
	}

	public void setInterfaceInfo(final Map<String, String> interfaceInfo) {
		this.interfaceInfo = interfaceInfo;
	}

	public PaasServiceHandle accessInfo(final Map<String, String> accessInfo) {
		this.accessInfo = accessInfo;
		return this;
	}

	/**
	 * Get accessInfo
	 *
	 * @return accessInfo
	 **/
	@Schema(description = "")

	@Valid
	public Map<String, String> getAccessInfo() {
		return accessInfo;
	}

	public void setAccessInfo(final Map<String, String> accessInfo) {
		this.accessInfo = accessInfo;
	}

	public PaasServiceHandle extra(final Map<String, String> extra) {
		this.extra = extra;
		return this;
	}

	/**
	 * Get extra
	 *
	 * @return extra
	 **/
	@Schema(description = "")

	@Valid
	public Map<String, String> getExtra() {
		return extra;
	}

	public void setExtra(final Map<String, String> extra) {
		this.extra = extra;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final PaasServiceHandle paasServiceHandle = (PaasServiceHandle) o;
		return Objects.equals(this.id, paasServiceHandle.id) &&
				Objects.equals(this.interfaceInfo, paasServiceHandle.interfaceInfo) &&
				Objects.equals(this.accessInfo, paasServiceHandle.accessInfo) &&
				Objects.equals(this.extra, paasServiceHandle.extra);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, interfaceInfo, accessInfo, extra);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class PaasServiceHandle {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    interfaceInfo: ").append(toIndentedString(interfaceInfo)).append("\n");
		sb.append("    accessInfo: ").append(toIndentedString(accessInfo)).append("\n");
		sb.append("    extra: ").append(toIndentedString(extra)).append("\n");
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
