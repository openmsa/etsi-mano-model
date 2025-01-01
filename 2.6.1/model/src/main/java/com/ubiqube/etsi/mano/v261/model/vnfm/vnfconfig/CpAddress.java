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
package com.ubiqube.etsi.mano.v261.model.vnfm.vnfconfig;

import java.util.Objects;

import jakarta.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;


/**
 * This type represents configuration parameters of a CP instance address. *
 * NOTE 1: Either \&quot;address\&quot; or \&quot;useDynamicAddress\&quot; shall
 * be present. * NOTE 2: At least one of \&quot;macAddress\&quot; and
 * \&quot;ipAddress\&quot; shall be present.
 */
@Schema(description = "This type represents configuration parameters of a CP instance address.    *  NOTE 1: Either \"address\" or \"useDynamicAddress\" shall be present.    *  NOTE 2: At least one of \"macAddress\" and \"ipAddress\" shall be present. ")
@Validated
public class CpAddress {
	@JsonProperty("address")
	private CpAddressAddress address = null;

	@JsonProperty("useDynamicAddress")
	private Boolean useDynamicAddress = null;

	@JsonProperty("port")
	private Integer port = null;

	public CpAddress address(final CpAddressAddress address) {
		this.address = address;
		return this;
	}

	/**
	 * Get address
	 *
	 * @return address
	 **/
	@Schema(description = "")

	@Valid

	public CpAddressAddress getAddress() {
		return address;
	}

	public void setAddress(final CpAddressAddress address) {
		this.address = address;
	}

	public CpAddress useDynamicAddress(final Boolean useDynamicAddress) {
		this.useDynamicAddress = useDynamicAddress;
		return this;
	}

	/**
	 * Set to true if an address shall be assigned dynamically. Otherwise set to
	 * false. The default value shall be false. See NOTE 1.
	 *
	 * @return useDynamicAddress
	 **/
	@Schema(description = "Set to true if an address shall be assigned dynamically. Otherwise set to false. The default value shall be false. See NOTE 1. ")

	public Boolean isUseDynamicAddress() {
		return useDynamicAddress;
	}

	public void setUseDynamicAddress(final Boolean useDynamicAddress) {
		this.useDynamicAddress = useDynamicAddress;
	}

	public CpAddress port(final Integer port) {
		this.port = port;
		return this;
	}

	/**
	 * The port assigned to the CP instance (e.g. IP port number, Ethernet port
	 * number, etc.).
	 *
	 * @return port
	 **/
	@Schema(description = "The port assigned to the CP instance (e.g. IP port number, Ethernet port number, etc.). ")

	public Integer getPort() {
		return port;
	}

	public void setPort(final Integer port) {
		this.port = port;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final CpAddress cpAddress = (CpAddress) o;
		return Objects.equals(this.address, cpAddress.address) &&
				Objects.equals(this.useDynamicAddress, cpAddress.useDynamicAddress) &&
				Objects.equals(this.port, cpAddress.port);
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, useDynamicAddress, port);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class CpAddress {\n");

		sb.append("    address: ").append(toIndentedString(address)).append("\n");
		sb.append("    useDynamicAddress: ").append(toIndentedString(useDynamicAddress)).append("\n");
		sb.append("    port: ").append(toIndentedString(port)).append("\n");
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
