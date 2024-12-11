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
package com.ubiqube.etsi.mano.v431.model.nfvo.nslcm;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

/**
 * This type provides information about Layer 3 protocol specific information
 * for the stitching of the intra-site VN to the multi-site connectivity service
 * over the WAN. It shall comply with the provisions defined in Table
 * 6.5.3.86-1.
 */
@Schema(description = "This type provides information about Layer 3 protocol specific information for the stitching of the intra-site VN to the multi-site connectivity service over the WAN. It shall comply with the provisions defined in Table 6.5.3.86-1. ")
@Validated

public class SiteToWanLayer3ProtocolData {
	@JsonProperty("logicalInterfaceIpAddress")
	private SiteToWanLayer3ProtocolDataLogicalInterfaceIpAddress logicalInterfaceIpAddress = null;

	@JsonProperty("routingInfo")
	private SiteToWanLayer3ProtocolDataRoutingInfo routingInfo = null;

	@JsonProperty("mtuL3")
	private BigDecimal mtuL3 = null;

	@JsonProperty("virtualRoutingAndForwarding")
	private SiteToWanLayer3ProtocolDataVirtualRoutingAndForwarding virtualRoutingAndForwarding = null;

	@JsonProperty("bfdConfig")
	private Map<String, String> bfdConfig = null;

	public SiteToWanLayer3ProtocolData logicalInterfaceIpAddress(final SiteToWanLayer3ProtocolDataLogicalInterfaceIpAddress logicalInterfaceIpAddress) {
		this.logicalInterfaceIpAddress = logicalInterfaceIpAddress;
		return this;
	}

	/**
	 * Get logicalInterfaceIpAddress
	 *
	 * @return logicalInterfaceIpAddress
	 **/
	@Schema(description = "")

	@Valid
	public SiteToWanLayer3ProtocolDataLogicalInterfaceIpAddress getLogicalInterfaceIpAddress() {
		return logicalInterfaceIpAddress;
	}

	public void setLogicalInterfaceIpAddress(final SiteToWanLayer3ProtocolDataLogicalInterfaceIpAddress logicalInterfaceIpAddress) {
		this.logicalInterfaceIpAddress = logicalInterfaceIpAddress;
	}

	public SiteToWanLayer3ProtocolData routingInfo(final SiteToWanLayer3ProtocolDataRoutingInfo routingInfo) {
		this.routingInfo = routingInfo;
		return this;
	}

	/**
	 * Get routingInfo
	 *
	 * @return routingInfo
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public SiteToWanLayer3ProtocolDataRoutingInfo getRoutingInfo() {
		return routingInfo;
	}

	public void setRoutingInfo(final SiteToWanLayer3ProtocolDataRoutingInfo routingInfo) {
		this.routingInfo = routingInfo;
	}

	public SiteToWanLayer3ProtocolData mtuL3(final BigDecimal mtuL3) {
		this.mtuL3 = mtuL3;
		return this;
	}

	/**
	 * Maximum Transmission Unit (MTU) that can be forwarded at layer 3 (in bytes).
	 * Default value is \"1500\" (bytes).
	 *
	 * @return mtuL3
	 **/
	@Schema(description = "Maximum Transmission Unit (MTU) that can be forwarded at layer 3 (in bytes). Default value is \"1500\" (bytes). ")

	@Valid
	public BigDecimal getMtuL3() {
		return mtuL3;
	}

	public void setMtuL3(final BigDecimal mtuL3) {
		this.mtuL3 = mtuL3;
	}

	public SiteToWanLayer3ProtocolData virtualRoutingAndForwarding(final SiteToWanLayer3ProtocolDataVirtualRoutingAndForwarding virtualRoutingAndForwarding) {
		this.virtualRoutingAndForwarding = virtualRoutingAndForwarding;
		return this;
	}

	/**
	 * Get virtualRoutingAndForwarding
	 *
	 * @return virtualRoutingAndForwarding
	 **/
	@Schema(description = "")

	@Valid
	public SiteToWanLayer3ProtocolDataVirtualRoutingAndForwarding getVirtualRoutingAndForwarding() {
		return virtualRoutingAndForwarding;
	}

	public void setVirtualRoutingAndForwarding(final SiteToWanLayer3ProtocolDataVirtualRoutingAndForwarding virtualRoutingAndForwarding) {
		this.virtualRoutingAndForwarding = virtualRoutingAndForwarding;
	}

	public SiteToWanLayer3ProtocolData bfdConfig(final Map<String, String> bfdConfig) {
		this.bfdConfig = bfdConfig;
		return this;
	}

	/**
	 * Get bfdConfig
	 *
	 * @return bfdConfig
	 **/
	@Schema(description = "")

	@Valid
	public Map<String, String> getBfdConfig() {
		return bfdConfig;
	}

	public void setBfdConfig(final Map<String, String> bfdConfig) {
		this.bfdConfig = bfdConfig;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final SiteToWanLayer3ProtocolData siteToWanLayer3ProtocolData = (SiteToWanLayer3ProtocolData) o;
		return Objects.equals(this.logicalInterfaceIpAddress, siteToWanLayer3ProtocolData.logicalInterfaceIpAddress) &&
				Objects.equals(this.routingInfo, siteToWanLayer3ProtocolData.routingInfo) &&
				Objects.equals(this.mtuL3, siteToWanLayer3ProtocolData.mtuL3) &&
				Objects.equals(this.virtualRoutingAndForwarding, siteToWanLayer3ProtocolData.virtualRoutingAndForwarding) &&
				Objects.equals(this.bfdConfig, siteToWanLayer3ProtocolData.bfdConfig);
	}

	@Override
	public int hashCode() {
		return Objects.hash(logicalInterfaceIpAddress, routingInfo, mtuL3, virtualRoutingAndForwarding, bfdConfig);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class SiteToWanLayer3ProtocolData {\n");

		sb.append("    logicalInterfaceIpAddress: ").append(toIndentedString(logicalInterfaceIpAddress)).append("\n");
		sb.append("    routingInfo: ").append(toIndentedString(routingInfo)).append("\n");
		sb.append("    mtuL3: ").append(toIndentedString(mtuL3)).append("\n");
		sb.append("    virtualRoutingAndForwarding: ").append(toIndentedString(virtualRoutingAndForwarding)).append("\n");
		sb.append("    bfdConfig: ").append(toIndentedString(bfdConfig)).append("\n");
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
