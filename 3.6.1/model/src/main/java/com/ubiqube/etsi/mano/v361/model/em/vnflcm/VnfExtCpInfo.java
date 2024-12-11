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
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.ubiqube.etsi.mano.v361.model.em.vnflcm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

/**
 * This type represents information about an external CP of a VNF. It shall
 * comply with the provisions defined in table 5.5.3.17 1. NOTE 1: The
 * attributes \&quot;associatedVnfcCpId\&quot;, \&quot;associatedVipCpId\&quot;
 * and \&quot;associatedVnfVirtualLinkId\&quot; are mutually exclusive. Exactly
 * one shall be present. NOTE 2: An external CP instance is not associated to a
 * link port in the cases indicated for the “extLinkPorts” attribute in clause
 * 4.4.1.11.
 */
@Schema(description = "This type represents information about an external CP of a VNF.  It shall comply with the provisions defined in table 5.5.3.17 1. NOTE 1: The attributes \"associatedVnfcCpId\", \"associatedVipCpId\" and \"associatedVnfVirtualLinkId\"          are mutually exclusive. Exactly one shall be present. NOTE 2: An external CP instance is not associated to a link port in the cases indicated for the          “extLinkPorts” attribute in clause 4.4.1.11. ")
@Validated

public class VnfExtCpInfo implements OneOfVnfExtCpInfo {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("cpdId")
	private String cpdId = null;

	@JsonProperty("cpConfigId")
	private String cpConfigId = null;

	@JsonProperty("vnfdId")
	private String vnfdId = null;

	@JsonProperty("cpProtocolInfo")
	@Valid
	private List<CpProtocolInfo> cpProtocolInfo = new ArrayList<>();

	@JsonProperty("extLinkPortId")
	private String extLinkPortId = null;

	@JsonProperty("metadata")
	private Map<String, String> metadata = null;

	@JsonProperty("associatedVnfcCpId")
	private String associatedVnfcCpId = null;

	@JsonProperty("associatedVipCpId")
	private String associatedVipCpId = null;

	@JsonProperty("associatedVnfVirtualLinkId")
	private String associatedVnfVirtualLinkId = null;

	public VnfExtCpInfo id(final String id) {
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

	public VnfExtCpInfo cpdId(final String cpdId) {
		this.cpdId = cpdId;
		return this;
	}

	/**
	 * Get cpdId
	 *
	 * @return cpdId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getCpdId() {
		return cpdId;
	}

	public void setCpdId(final String cpdId) {
		this.cpdId = cpdId;
	}

	public VnfExtCpInfo cpConfigId(final String cpConfigId) {
		this.cpConfigId = cpConfigId;
		return this;
	}

	/**
	 * Get cpConfigId
	 *
	 * @return cpConfigId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getCpConfigId() {
		return cpConfigId;
	}

	public void setCpConfigId(final String cpConfigId) {
		this.cpConfigId = cpConfigId;
	}

	public VnfExtCpInfo vnfdId(final String vnfdId) {
		this.vnfdId = vnfdId;
		return this;
	}

	/**
	 * Get vnfdId
	 *
	 * @return vnfdId
	 **/
	@Schema(description = "")

	public String getVnfdId() {
		return vnfdId;
	}

	public void setVnfdId(final String vnfdId) {
		this.vnfdId = vnfdId;
	}

	public VnfExtCpInfo cpProtocolInfo(final List<CpProtocolInfo> cpProtocolInfo) {
		this.cpProtocolInfo = cpProtocolInfo;
		return this;
	}

	public VnfExtCpInfo addCpProtocolInfoItem(final CpProtocolInfo cpProtocolInfoItem) {
		this.cpProtocolInfo.add(cpProtocolInfoItem);
		return this;
	}

	/**
	 * Network protocol information for this CP.
	 *
	 * @return cpProtocolInfo
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Network protocol information for this CP. ")
	@NotNull
	@Valid
	public List<CpProtocolInfo> getCpProtocolInfo() {
		return cpProtocolInfo;
	}

	public void setCpProtocolInfo(final List<CpProtocolInfo> cpProtocolInfo) {
		this.cpProtocolInfo = cpProtocolInfo;
	}

	public VnfExtCpInfo extLinkPortId(final String extLinkPortId) {
		this.extLinkPortId = extLinkPortId;
		return this;
	}

	/**
	 * Get extLinkPortId
	 *
	 * @return extLinkPortId
	 **/
	@Schema(description = "")

	public String getExtLinkPortId() {
		return extLinkPortId;
	}

	public void setExtLinkPortId(final String extLinkPortId) {
		this.extLinkPortId = extLinkPortId;
	}

	public VnfExtCpInfo metadata(final Map<String, String> metadata) {
		this.metadata = metadata;
		return this;
	}

	/**
	 * Get metadata
	 *
	 * @return metadata
	 **/
	@Schema(description = "")

	@Valid
	public Map<String, String> getMetadata() {
		return metadata;
	}

	public void setMetadata(final Map<String, String> metadata) {
		this.metadata = metadata;
	}

	public VnfExtCpInfo associatedVnfcCpId(final String associatedVnfcCpId) {
		this.associatedVnfcCpId = associatedVnfcCpId;
		return this;
	}

	/**
	 * Get associatedVnfcCpId
	 *
	 * @return associatedVnfcCpId
	 **/
	@Schema(description = "")

	public String getAssociatedVnfcCpId() {
		return associatedVnfcCpId;
	}

	public void setAssociatedVnfcCpId(final String associatedVnfcCpId) {
		this.associatedVnfcCpId = associatedVnfcCpId;
	}

	public VnfExtCpInfo associatedVipCpId(final String associatedVipCpId) {
		this.associatedVipCpId = associatedVipCpId;
		return this;
	}

	/**
	 * Get associatedVipCpId
	 *
	 * @return associatedVipCpId
	 **/
	@Schema(description = "")

	public String getAssociatedVipCpId() {
		return associatedVipCpId;
	}

	public void setAssociatedVipCpId(final String associatedVipCpId) {
		this.associatedVipCpId = associatedVipCpId;
	}

	public VnfExtCpInfo associatedVnfVirtualLinkId(final String associatedVnfVirtualLinkId) {
		this.associatedVnfVirtualLinkId = associatedVnfVirtualLinkId;
		return this;
	}

	/**
	 * Get associatedVnfVirtualLinkId
	 *
	 * @return associatedVnfVirtualLinkId
	 **/
	@Schema(description = "")

	public String getAssociatedVnfVirtualLinkId() {
		return associatedVnfVirtualLinkId;
	}

	public void setAssociatedVnfVirtualLinkId(final String associatedVnfVirtualLinkId) {
		this.associatedVnfVirtualLinkId = associatedVnfVirtualLinkId;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final VnfExtCpInfo vnfExtCpInfo = (VnfExtCpInfo) o;
		return Objects.equals(this.id, vnfExtCpInfo.id) &&
				Objects.equals(this.cpdId, vnfExtCpInfo.cpdId) &&
				Objects.equals(this.cpConfigId, vnfExtCpInfo.cpConfigId) &&
				Objects.equals(this.vnfdId, vnfExtCpInfo.vnfdId) &&
				Objects.equals(this.cpProtocolInfo, vnfExtCpInfo.cpProtocolInfo) &&
				Objects.equals(this.extLinkPortId, vnfExtCpInfo.extLinkPortId) &&
				Objects.equals(this.metadata, vnfExtCpInfo.metadata) &&
				Objects.equals(this.associatedVnfcCpId, vnfExtCpInfo.associatedVnfcCpId) &&
				Objects.equals(this.associatedVipCpId, vnfExtCpInfo.associatedVipCpId) &&
				Objects.equals(this.associatedVnfVirtualLinkId, vnfExtCpInfo.associatedVnfVirtualLinkId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, cpdId, cpConfigId, vnfdId, cpProtocolInfo, extLinkPortId, metadata, associatedVnfcCpId, associatedVipCpId, associatedVnfVirtualLinkId);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class VnfExtCpInfo {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    cpdId: ").append(toIndentedString(cpdId)).append("\n");
		sb.append("    cpConfigId: ").append(toIndentedString(cpConfigId)).append("\n");
		sb.append("    vnfdId: ").append(toIndentedString(vnfdId)).append("\n");
		sb.append("    cpProtocolInfo: ").append(toIndentedString(cpProtocolInfo)).append("\n");
		sb.append("    extLinkPortId: ").append(toIndentedString(extLinkPortId)).append("\n");
		sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
		sb.append("    associatedVnfcCpId: ").append(toIndentedString(associatedVnfcCpId)).append("\n");
		sb.append("    associatedVipCpId: ").append(toIndentedString(associatedVipCpId)).append("\n");
		sb.append("    associatedVnfVirtualLinkId: ").append(toIndentedString(associatedVnfVirtualLinkId)).append("\n");
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
