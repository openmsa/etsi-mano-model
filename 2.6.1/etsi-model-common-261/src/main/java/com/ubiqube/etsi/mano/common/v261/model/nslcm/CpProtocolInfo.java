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
package com.ubiqube.etsi.mano.common.v261.model.nslcm;

import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;


/**
 * This type describes the protocol layer(s) that a CP or SAP uses together with
 * protocol-related information, like addresses. It shall comply with the
 * provisions defined in Table 6.5.3.58-1.
 */
@Schema(description = "This type describes the protocol layer(s) that a CP or SAP uses together with protocol-related information, like addresses. It shall comply with the provisions defined in Table 6.5.3.58-1. ")
@Validated
public class CpProtocolInfo {
	/**
	 * The identifier of layer(s) and protocol(s) associated to the network address
	 * information. Permitted values: IP_OVER_ETHERNET See note.
	 */
	public enum LayerProtocolEnum {
		IP_OVER_ETHERNET("IP_OVER_ETHERNET");

		private final String value;

		LayerProtocolEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static LayerProtocolEnum fromValue(final String text) {
			for (final LayerProtocolEnum b : LayerProtocolEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("layerProtocol")
	private LayerProtocolEnum layerProtocol = null;

	@JsonProperty("ipOverEthernet")
	private IpOverEthernetAddressInfo ipOverEthernet = null;

	public CpProtocolInfo layerProtocol(final LayerProtocolEnum layerProtocol) {
		this.layerProtocol = layerProtocol;
		return this;
	}

	/**
	 * The identifier of layer(s) and protocol(s) associated to the network address
	 * information. Permitted values: IP_OVER_ETHERNET See note.
	 *
	 * @return layerProtocol
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "The identifier of layer(s) and protocol(s) associated to the network address information. Permitted values: IP_OVER_ETHERNET See note. ")
	@NotNull

	public LayerProtocolEnum getLayerProtocol() {
		return layerProtocol;
	}

	public void setLayerProtocol(final LayerProtocolEnum layerProtocol) {
		this.layerProtocol = layerProtocol;
	}

	public CpProtocolInfo ipOverEthernet(final IpOverEthernetAddressInfo ipOverEthernet) {
		this.ipOverEthernet = ipOverEthernet;
		return this;
	}

	/**
	 * IP addresses over Ethernet to assign to the CP or SAP instance. Shall be
	 * present if layerProtocol is equal to \" IP_OVER_ETHERNET\", and shall be
	 * absent otherwise.
	 *
	 * @return ipOverEthernet
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "IP addresses over Ethernet to assign to the CP or SAP instance. Shall be present if layerProtocol is equal to \" IP_OVER_ETHERNET\", and shall be absent otherwise. ")
	@NotNull

	@Valid

	public IpOverEthernetAddressInfo getIpOverEthernet() {
		return ipOverEthernet;
	}

	public void setIpOverEthernet(final IpOverEthernetAddressInfo ipOverEthernet) {
		this.ipOverEthernet = ipOverEthernet;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final CpProtocolInfo cpProtocolInfo = (CpProtocolInfo) o;
		return Objects.equals(this.layerProtocol, cpProtocolInfo.layerProtocol) &&
				Objects.equals(this.ipOverEthernet, cpProtocolInfo.ipOverEthernet);
	}

	@Override
	public int hashCode() {
		return Objects.hash(layerProtocol, ipOverEthernet);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class CpProtocolInfo {\n");

		sb.append("    layerProtocol: ").append(toIndentedString(layerProtocol)).append("\n");
		sb.append("    ipOverEthernet: ").append(toIndentedString(ipOverEthernet)).append("\n");
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
