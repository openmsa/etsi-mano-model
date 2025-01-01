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
package com.ubiqube.etsi.mano.v451.model.vnfm.grant;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.PaasServiceHandle;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * PaasAssets
 */
@Validated

public class PaasAssets {
	@JsonProperty("paasServiceType")
	private String paasServiceType = null;

	@JsonProperty("paasServiceId")
	private String paasServiceId = null;

	@JsonProperty("paasServiceVersion")
	private String paasServiceVersion = null;

	@JsonProperty("paasServiceRequestId")
	private String paasServiceRequestId = null;

	@JsonProperty("PaasServiceHandle")
	private PaasServiceHandle paasServiceHandle = null;

	public PaasAssets paasServiceType(final String paasServiceType) {
		this.paasServiceType = paasServiceType;
		return this;
	}

	/**
	 * Get paasServiceType
	 *
	 * @return paasServiceType
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getPaasServiceType() {
		return paasServiceType;
	}

	public void setPaasServiceType(final String paasServiceType) {
		this.paasServiceType = paasServiceType;
	}

	public PaasAssets paasServiceId(final String paasServiceId) {
		this.paasServiceId = paasServiceId;
		return this;
	}

	/**
	 * Get paasServiceId
	 *
	 * @return paasServiceId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getPaasServiceId() {
		return paasServiceId;
	}

	public void setPaasServiceId(final String paasServiceId) {
		this.paasServiceId = paasServiceId;
	}

	public PaasAssets paasServiceVersion(final String paasServiceVersion) {
		this.paasServiceVersion = paasServiceVersion;
		return this;
	}

	/**
	 * Get paasServiceVersion
	 *
	 * @return paasServiceVersion
	 **/
	@Schema(description = "")

	public String getPaasServiceVersion() {
		return paasServiceVersion;
	}

	public void setPaasServiceVersion(final String paasServiceVersion) {
		this.paasServiceVersion = paasServiceVersion;
	}

	public PaasAssets paasServiceRequestId(final String paasServiceRequestId) {
		this.paasServiceRequestId = paasServiceRequestId;
		return this;
	}

	/**
	 * Get paasServiceRequestId
	 *
	 * @return paasServiceRequestId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getPaasServiceRequestId() {
		return paasServiceRequestId;
	}

	public void setPaasServiceRequestId(final String paasServiceRequestId) {
		this.paasServiceRequestId = paasServiceRequestId;
	}

	public PaasAssets paasServiceHandle(final PaasServiceHandle paasServiceHandle) {
		this.paasServiceHandle = paasServiceHandle;
		return this;
	}

	/**
	 * Get paasServiceHandle
	 *
	 * @return paasServiceHandle
	 **/
	@Schema(description = "")

	@Valid
	public PaasServiceHandle getPaasServiceHandle() {
		return paasServiceHandle;
	}

	public void setPaasServiceHandle(final PaasServiceHandle paasServiceHandle) {
		this.paasServiceHandle = paasServiceHandle;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final PaasAssets paasAssets = (PaasAssets) o;
		return Objects.equals(this.paasServiceType, paasAssets.paasServiceType) &&
				Objects.equals(this.paasServiceId, paasAssets.paasServiceId) &&
				Objects.equals(this.paasServiceVersion, paasAssets.paasServiceVersion) &&
				Objects.equals(this.paasServiceRequestId, paasAssets.paasServiceRequestId) &&
				Objects.equals(this.paasServiceHandle, paasAssets.paasServiceHandle);
	}

	@Override
	public int hashCode() {
		return Objects.hash(paasServiceType, paasServiceId, paasServiceVersion, paasServiceRequestId, paasServiceHandle);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class PaasAssets {\n");

		sb.append("    paasServiceType: ").append(toIndentedString(paasServiceType)).append("\n");
		sb.append("    paasServiceId: ").append(toIndentedString(paasServiceId)).append("\n");
		sb.append("    paasServiceVersion: ").append(toIndentedString(paasServiceVersion)).append("\n");
		sb.append("    paasServiceRequestId: ").append(toIndentedString(paasServiceRequestId)).append("\n");
		sb.append("    paasServiceHandle: ").append(toIndentedString(paasServiceHandle)).append("\n");
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
