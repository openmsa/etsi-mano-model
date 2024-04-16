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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type provides input information related to CMF for certificate
 * management.
 */
@Schema(description = "This type provides input information related to CMF for certificate management. ")
@Validated

public class CmfInfo {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("endPoint")
	private CmfInfoEndPoint endPoint = null;

	/**
	 * Gets or Sets supportedProtocols
	 */
	public enum SupportedProtocolsEnum {
		CMP("CMP"),

		CMPV2("CMPv2"),

		EST("EST"),

		SCEP("SCEP");

		private final String value;

		SupportedProtocolsEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static SupportedProtocolsEnum fromValue(final String text) {
			for (final SupportedProtocolsEnum b : SupportedProtocolsEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("supportedProtocols")
	@Valid
	private List<SupportedProtocolsEnum> supportedProtocols = null;

	@JsonProperty("certificateChain")
	@Valid
	private List<Map<String, String>> certificateChain = null;

	public CmfInfo id(final String id) {
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

	public CmfInfo endPoint(final CmfInfoEndPoint endPoint) {
		this.endPoint = endPoint;
		return this;
	}

	/**
	 * Get endPoint
	 *
	 * @return endPoint
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public CmfInfoEndPoint getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(final CmfInfoEndPoint endPoint) {
		this.endPoint = endPoint;
	}

	public CmfInfo supportedProtocols(final List<SupportedProtocolsEnum> supportedProtocols) {
		this.supportedProtocols = supportedProtocols;
		return this;
	}

	public CmfInfo addSupportedProtocolsItem(final SupportedProtocolsEnum supportedProtocolsItem) {
		if (this.supportedProtocols == null) {
			this.supportedProtocols = new ArrayList<>();
		}
		this.supportedProtocols.add(supportedProtocolsItem);
		return this;
	}

	/**
	 * Supported protocol by CMF instance.
	 *
	 * @return supportedProtocols
	 **/
	@Schema(description = "Supported protocol by CMF instance.")

	public List<SupportedProtocolsEnum> getSupportedProtocols() {
		return supportedProtocols;
	}

	public void setSupportedProtocols(final List<SupportedProtocolsEnum> supportedProtocols) {
		this.supportedProtocols = supportedProtocols;
	}

	public CmfInfo certificateChain(final List<Map<String, String>> certificateChain) {
		this.certificateChain = certificateChain;
		return this;
	}

	public CmfInfo addCertificateChainItem(final Map<String, String> certificateChainItem) {
		if (this.certificateChain == null) {
			this.certificateChain = new ArrayList<>();
		}
		this.certificateChain.add(certificateChainItem);
		return this;
	}

	/**
	 * Certificate chain that this CMF provides.
	 *
	 * @return certificateChain
	 **/
	@Schema(description = "Certificate chain that this CMF provides.")
	@Valid
	public List<Map<String, String>> getCertificateChain() {
		return certificateChain;
	}

	public void setCertificateChain(final List<Map<String, String>> certificateChain) {
		this.certificateChain = certificateChain;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final CmfInfo cmfInfo = (CmfInfo) o;
		return Objects.equals(this.id, cmfInfo.id) &&
				Objects.equals(this.endPoint, cmfInfo.endPoint) &&
				Objects.equals(this.supportedProtocols, cmfInfo.supportedProtocols) &&
				Objects.equals(this.certificateChain, cmfInfo.certificateChain);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, endPoint, supportedProtocols, certificateChain);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class CmfInfo {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    endPoint: ").append(toIndentedString(endPoint)).append("\n");
		sb.append("    supportedProtocols: ").append(toIndentedString(supportedProtocols)).append("\n");
		sb.append("    certificateChain: ").append(toIndentedString(certificateChain)).append("\n");
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
