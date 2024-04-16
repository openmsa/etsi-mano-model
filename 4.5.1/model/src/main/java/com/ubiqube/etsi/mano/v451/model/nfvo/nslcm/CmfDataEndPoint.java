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
package com.ubiqube.etsi.mano.v451.model.nfvo.nslcm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.Link;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * End point of CMF instance.
 */
@Schema(description = "End point of CMF instance. ")
@Validated

public class CmfDataEndPoint {
	@JsonProperty("ipAddress")
	private String ipAddress = null;

	@JsonProperty("link")
	private Link link = null;

	/**
	 * Gets or Sets supportedProtocol
	 */
	public enum SupportedProtocolEnum {
		CMP("CMP"),

		CMPV2("CMPv2"),

		EST("EST"),

		SCEP("SCEP");

		private final String value;

		SupportedProtocolEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static SupportedProtocolEnum fromValue(final String text) {
			for (final SupportedProtocolEnum b : SupportedProtocolEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("supportedProtocol")
	@Valid
	private List<SupportedProtocolEnum> supportedProtocol = null;

	public CmfDataEndPoint ipAddress(final String ipAddress) {
		this.ipAddress = ipAddress;
		return this;
	}

	/**
	 * Get ipAddress
	 *
	 * @return ipAddress
	 **/
	@Schema(required = true, description = "")
	@NotNull

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(final String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public CmfDataEndPoint link(final Link link) {
		this.link = link;
		return this;
	}

	/**
	 * Get link
	 *
	 * @return link
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public Link getLink() {
		return link;
	}

	public void setLink(final Link link) {
		this.link = link;
	}

	public CmfDataEndPoint supportedProtocol(final List<SupportedProtocolEnum> supportedProtocol) {
		this.supportedProtocol = supportedProtocol;
		return this;
	}

	public CmfDataEndPoint addSupportedProtocolItem(final SupportedProtocolEnum supportedProtocolItem) {
		if (this.supportedProtocol == null) {
			this.supportedProtocol = new ArrayList<>();
		}
		this.supportedProtocol.add(supportedProtocolItem);
		return this;
	}

	/**
	 * Supported protocol by CMF instance. Permitted values: * CMP * CMPv2 * EST *
	 * SCEP
	 *
	 * @return supportedProtocol
	 **/
	@Schema(description = "Supported protocol by CMF instance. Permitted values:   * CMP   * CMPv2   * EST   * SCEP ")

	@Size(min = 1)
	public List<SupportedProtocolEnum> getSupportedProtocol() {
		return supportedProtocol;
	}

	public void setSupportedProtocol(final List<SupportedProtocolEnum> supportedProtocol) {
		this.supportedProtocol = supportedProtocol;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final CmfDataEndPoint cmfDataEndPoint = (CmfDataEndPoint) o;
		return Objects.equals(this.ipAddress, cmfDataEndPoint.ipAddress) &&
				Objects.equals(this.link, cmfDataEndPoint.link) &&
				Objects.equals(this.supportedProtocol, cmfDataEndPoint.supportedProtocol);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ipAddress, link, supportedProtocol);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class CmfDataEndPoint {\n");

		sb.append("    ipAddress: ").append(toIndentedString(ipAddress)).append("\n");
		sb.append("    link: ").append(toIndentedString(link)).append("\n");
		sb.append("    supportedProtocol: ").append(toIndentedString(supportedProtocol)).append("\n");
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
