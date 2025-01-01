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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type represents information about a network address that has been
 * assigned. It shall comply with the provisions defined in Table 6.5.3.18-1.
 */
@Schema(description = "This type represents information about a network address that has been assigned. It shall comply with the provisions defined in Table 6.5.3.18-1. ")
@Validated
public class IpOverEthernetAddressInfo {
	@JsonProperty("macAddress")
	private String macAddress = null;

	@JsonProperty("ipAddresses")
	@Valid
	private List<IpOverEthernetAddressInfoIpAddresses> ipAddresses = new ArrayList<>();

	public IpOverEthernetAddressInfo macAddress(final String macAddress) {
		this.macAddress = macAddress;
		return this;
	}

	/**
	 * Assigned MAC address.
	 *
	 * @return macAddress
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Assigned MAC address. ")
	@NotNull

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(final String macAddress) {
		this.macAddress = macAddress;
	}

	public IpOverEthernetAddressInfo ipAddresses(final List<IpOverEthernetAddressInfoIpAddresses> ipAddresses) {
		this.ipAddresses = ipAddresses;
		return this;
	}

	public IpOverEthernetAddressInfo addIpAddressesItem(final IpOverEthernetAddressInfoIpAddresses ipAddressesItem) {
		this.ipAddresses.add(ipAddressesItem);
		return this;
	}

	/**
	 * Addresses assigned to the CP instance. Each entry represents IP addresses
	 * assigned by fixed or dynamic IP address assignment per subnet.
	 *
	 * @return ipAddresses
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Addresses assigned to the CP instance. Each entry represents IP addresses assigned by fixed or dynamic IP address assignment per subnet. ")
	@NotNull

	@Valid

	public List<IpOverEthernetAddressInfoIpAddresses> getIpAddresses() {
		return ipAddresses;
	}

	public void setIpAddresses(final List<IpOverEthernetAddressInfoIpAddresses> ipAddresses) {
		this.ipAddresses = ipAddresses;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final IpOverEthernetAddressInfo ipOverEthernetAddressInfo = (IpOverEthernetAddressInfo) o;
		return Objects.equals(this.macAddress, ipOverEthernetAddressInfo.macAddress) &&
				Objects.equals(this.ipAddresses, ipOverEthernetAddressInfo.ipAddresses);
	}

	@Override
	public int hashCode() {
		return Objects.hash(macAddress, ipAddresses);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class IpOverEthernetAddressInfo {\n");

		sb.append("    macAddress: ").append(toIndentedString(macAddress)).append("\n");
		sb.append("    ipAddresses: ").append(toIndentedString(ipAddresses)).append("\n");
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
