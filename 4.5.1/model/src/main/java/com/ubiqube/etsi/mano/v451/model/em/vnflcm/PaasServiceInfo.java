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
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type provides information about a PaaS Service that is used by a VNF
 * instance. The PaasServiceInfo is comprised of various sets of information.
 * Some information comes from the VNFD, other information comes from the PaaS
 * Service assets provided by the NFVO to the VNFM, and other information is
 * provided at runtime information about the usage of the PaaS Service.
 */
@Schema(description = "This type provides information about a PaaS Service that is used by a VNF instance. The PaasServiceInfo is comprised of various sets of information. Some information comes from the VNFD, other information comes from the PaaS Service assets provided by the NFVO to the VNFM, and other information is provided at runtime information about the usage of the PaaS Service. ")
@Validated

public class PaasServiceInfo {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("paasServiceId")
	private String paasServiceId = null;

	@JsonProperty("paasServiceType")
	private String paasServiceType = null;

	@JsonProperty("paasServiceVersion")
	private String paasServiceVersion = null;

	@JsonProperty("paasServiceRequestId")
	private String paasServiceRequestId = null;

	@JsonProperty("paasServiceHandle")
	private PaasServiceHandle paasServiceHandle = null;

	@JsonProperty("additionalInfo")
	private Map<String, String> additionalInfo = null;

	public PaasServiceInfo id(final String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 *
	 * @return id
	 **/
	@Schema(required = true, description = "")
	@NotNull

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public PaasServiceInfo paasServiceId(final String paasServiceId) {
		this.paasServiceId = paasServiceId;
		return this;
	}

	/**
	 * Get paasServiceId
	 *
	 * @return paasServiceId
	 **/
	@Schema(required = true, description = "")
	@NotNull

	public String getPaasServiceId() {
		return paasServiceId;
	}

	public void setPaasServiceId(final String paasServiceId) {
		this.paasServiceId = paasServiceId;
	}

	public PaasServiceInfo paasServiceType(final String paasServiceType) {
		this.paasServiceType = paasServiceType;
		return this;
	}

	/**
	 * The type of PaaS Service. The value of this attribute is expected to be
	 * matched against values of the registered PaaS Services in the PSR.
	 *
	 * @return paasServiceType
	 **/
	@Schema(required = true, description = "The type of PaaS Service. The value of this attribute is expected to be matched against values of the registered PaaS Services in the PSR. ")
	@NotNull

	public String getPaasServiceType() {
		return paasServiceType;
	}

	public void setPaasServiceType(final String paasServiceType) {
		this.paasServiceType = paasServiceType;
	}

	public PaasServiceInfo paasServiceVersion(final String paasServiceVersion) {
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

	public PaasServiceInfo paasServiceRequestId(final String paasServiceRequestId) {
		this.paasServiceRequestId = paasServiceRequestId;
		return this;
	}

	/**
	 * Get paasServiceRequestId
	 *
	 * @return paasServiceRequestId
	 **/
	@Schema(required = true, description = "")
	@NotNull

	public String getPaasServiceRequestId() {
		return paasServiceRequestId;
	}

	public void setPaasServiceRequestId(final String paasServiceRequestId) {
		this.paasServiceRequestId = paasServiceRequestId;
	}

	public PaasServiceInfo paasServiceHandle(final PaasServiceHandle paasServiceHandle) {
		this.paasServiceHandle = paasServiceHandle;
		return this;
	}

	/**
	 * Get paasServiceHandle
	 *
	 * @return paasServiceHandle
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public PaasServiceHandle getPaasServiceHandle() {
		return paasServiceHandle;
	}

	public void setPaasServiceHandle(final PaasServiceHandle paasServiceHandle) {
		this.paasServiceHandle = paasServiceHandle;
	}

	public PaasServiceInfo additionalInfo(final Map<String, String> additionalInfo) {
		this.additionalInfo = additionalInfo;
		return this;
	}

	/**
	 * Get additionalInfo
	 *
	 * @return additionalInfo
	 **/
	@Schema(description = "")

	@Valid
	public Map<String, String> getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(final Map<String, String> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final PaasServiceInfo paasServiceInfo = (PaasServiceInfo) o;
		return Objects.equals(this.id, paasServiceInfo.id) &&
				Objects.equals(this.paasServiceId, paasServiceInfo.paasServiceId) &&
				Objects.equals(this.paasServiceType, paasServiceInfo.paasServiceType) &&
				Objects.equals(this.paasServiceVersion, paasServiceInfo.paasServiceVersion) &&
				Objects.equals(this.paasServiceRequestId, paasServiceInfo.paasServiceRequestId) &&
				Objects.equals(this.paasServiceHandle, paasServiceInfo.paasServiceHandle) &&
				Objects.equals(this.additionalInfo, paasServiceInfo.additionalInfo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, paasServiceId, paasServiceType, paasServiceVersion, paasServiceRequestId, paasServiceHandle, additionalInfo);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class PaasServiceInfo {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    paasServiceId: ").append(toIndentedString(paasServiceId)).append("\n");
		sb.append("    paasServiceType: ").append(toIndentedString(paasServiceType)).append("\n");
		sb.append("    paasServiceVersion: ").append(toIndentedString(paasServiceVersion)).append("\n");
		sb.append("    paasServiceRequestId: ").append(toIndentedString(paasServiceRequestId)).append("\n");
		sb.append("    paasServiceHandle: ").append(toIndentedString(paasServiceHandle)).append("\n");
		sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
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
