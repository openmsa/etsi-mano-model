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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.ResourceHandle;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;

/**
 * Information related to the forwarding of the VN in the NFVI-PoP to the
 * connectivity service endpoint, if information about the VN to
 * \&quot;stitch\&quot; is already known. . by the OSS/BSS. Shall not be
 * provided otherwise, in which case the NFVO will infer the forwarding
 * configuration based on the NS VL, or external VL, or externally-managed VL
 * provisioning.
 */
@Schema(description = "Information related to the forwarding of the VN in the NFVI-PoP to the connectivity service endpoint, if information about the VN to \"stitch\" is already known. . by the OSS/BSS. Shall not be provided otherwise, in which case the NFVO will infer the forwarding configuration based on the NS VL, or external VL, or externally-managed VL provisioning. ")
@Validated

public class SiteToWanLayer2ProtocolDataForwardingConfig {
	@JsonProperty("networkResources")
	@Valid
	private List<ResourceHandle> networkResources = null;

	@JsonProperty("vnSegmentIds")
	private SiteToWanLayer2ProtocolDataForwardingConfigVnSegmentIds vnSegmentIds = null;

	public SiteToWanLayer2ProtocolDataForwardingConfig networkResources(final List<ResourceHandle> networkResources) {
		this.networkResources = networkResources;
		return this;
	}

	public SiteToWanLayer2ProtocolDataForwardingConfig addNetworkResourcesItem(final ResourceHandle networkResourcesItem) {
		if (this.networkResources == null) {
			this.networkResources = new ArrayList<>();
		}
		this.networkResources.add(networkResourcesItem);
		return this;
	}

	/**
	 * Reference to the VN resource to be forwarded into/from the MSCS. See note.
	 *
	 * @return networkResources
	 **/
	@Schema(description = "Reference to the VN resource to be forwarded into/from the MSCS. See note. ")
	@Valid
	public List<ResourceHandle> getNetworkResources() {
		return networkResources;
	}

	public void setNetworkResources(final List<ResourceHandle> networkResources) {
		this.networkResources = networkResources;
	}

	public SiteToWanLayer2ProtocolDataForwardingConfig vnSegmentIds(final SiteToWanLayer2ProtocolDataForwardingConfigVnSegmentIds vnSegmentIds) {
		this.vnSegmentIds = vnSegmentIds;
		return this;
	}

	/**
	 * Get vnSegmentIds
	 *
	 * @return vnSegmentIds
	 **/
	@Schema(description = "")

	@Valid
	public SiteToWanLayer2ProtocolDataForwardingConfigVnSegmentIds getVnSegmentIds() {
		return vnSegmentIds;
	}

	public void setVnSegmentIds(final SiteToWanLayer2ProtocolDataForwardingConfigVnSegmentIds vnSegmentIds) {
		this.vnSegmentIds = vnSegmentIds;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final SiteToWanLayer2ProtocolDataForwardingConfig siteToWanLayer2ProtocolDataForwardingConfig = (SiteToWanLayer2ProtocolDataForwardingConfig) o;
		return Objects.equals(this.networkResources, siteToWanLayer2ProtocolDataForwardingConfig.networkResources) &&
				Objects.equals(this.vnSegmentIds, siteToWanLayer2ProtocolDataForwardingConfig.vnSegmentIds);
	}

	@Override
	public int hashCode() {
		return Objects.hash(networkResources, vnSegmentIds);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class SiteToWanLayer2ProtocolDataForwardingConfig {\n");

		sb.append("    networkResources: ").append(toIndentedString(networkResources)).append("\n");
		sb.append("    vnSegmentIds: ").append(toIndentedString(vnSegmentIds)).append("\n");
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
