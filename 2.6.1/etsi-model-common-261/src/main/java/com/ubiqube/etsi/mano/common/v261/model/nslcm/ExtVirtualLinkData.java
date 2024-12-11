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
package com.ubiqube.etsi.mano.common.v261.model.nslcm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.common.v261.model.VnfExtCpData;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type represents an external VL. It shall comply with the provisions
 * defined in Table 6.5.3.26-1.
 */
@Schema(description = "This type represents an external VL. It shall comply with the provisions defined in Table 6.5.3.26-1. ")
@Validated
public class ExtVirtualLinkData {
	@JsonProperty("extVirtualLinkId")
	private String extVirtualLinkId = null;

	@JsonProperty("vimConnectionId")
	private String vimConnectionId = null;

	@JsonProperty("resourceProviderId")
	private String resourceProviderId = null;

	@JsonProperty("resourceId")
	private String resourceId = null;

	@JsonProperty("extCps")
	@Valid
	private List<VnfExtCpData> extCps = new ArrayList<>();

	@JsonProperty("extLinkPorts")
	@Valid
	private List<ExtLinkPortData> extLinkPorts = null;

	public ExtVirtualLinkData extVirtualLinkId(final String extVirtualLinkId) {
		this.extVirtualLinkId = extVirtualLinkId;
		return this;
	}

	/**
	 * The identifier of the external VL instance, if provided.
	 *
	 * @return extVirtualLinkId
	 **/
	@Schema(description = "The identifier of the external VL instance, if provided. ")

	public String getExtVirtualLinkId() {
		return extVirtualLinkId;
	}

	public void setExtVirtualLinkId(final String extVirtualLinkId) {
		this.extVirtualLinkId = extVirtualLinkId;
	}

	public ExtVirtualLinkData vimConnectionId(final String vimId) {
		this.vimConnectionId = vimId;
		return this;
	}

	/**
	 * Identifier of the VIM that manages this resource. This attribute shall only
	 * be supported and present if VNFrelated resource management in direct mode is
	 * applicable.
	 *
	 * @return vimId
	 **/
	@Schema(description = "Identifier of the VIM that manages this resource. This attribute shall only be supported and present if VNFrelated resource management in direct mode is applicable. ")

	public String getVimConnectionId() {
		return vimConnectionId;
	}

	public void setVimConnectionId(final String vimId) {
		this.vimConnectionId = vimId;
	}

	public ExtVirtualLinkData resourceProviderId(final String resourceProviderId) {
		this.resourceProviderId = resourceProviderId;
		return this;
	}

	/**
	 * Identifies the entity responsible for the management of this resource. This
	 * attribute shall only be supported and present if VNF-related resource
	 * management in indirect mode is applicable. The identification scheme is
	 * outside the scope of the present document.
	 *
	 * @return resourceProviderId
	 **/
	@Schema(description = "Identifies the entity responsible for the management of this resource. This attribute shall only be supported and present if VNF-related resource management in indirect mode is applicable. The identification scheme is outside the scope of the present document. ")

	public String getResourceProviderId() {
		return resourceProviderId;
	}

	public void setResourceProviderId(final String resourceProviderId) {
		this.resourceProviderId = resourceProviderId;
	}

	public ExtVirtualLinkData resourceId(final String resourceId) {
		this.resourceId = resourceId;
		return this;
	}

	/**
	 * The identifier of the resource in the scope of the VIM or the resource
	 * provider.
	 *
	 * @return resourceId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "The identifier of the resource in the scope of the VIM or the resource provider. ")
	@NotNull

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(final String resourceId) {
		this.resourceId = resourceId;
	}

	public ExtVirtualLinkData extCps(final List<VnfExtCpData> extCps) {
		this.extCps = extCps;
		return this;
	}

	public ExtVirtualLinkData addExtCpsItem(final VnfExtCpData extCpsItem) {
		this.extCps.add(extCpsItem);
		return this;
	}

	/**
	 * External CPs of the VNF to be connected to this external VL.
	 *
	 * @return extCps
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "External CPs of the VNF to be connected to this external VL. ")
	@NotNull

	@Valid

	public List<VnfExtCpData> getExtCps() {
		return extCps;
	}

	public void setExtCps(final List<VnfExtCpData> extCps) {
		this.extCps = extCps;
	}

	public ExtVirtualLinkData extLinkPorts(final List<ExtLinkPortData> extLinkPorts) {
		this.extLinkPorts = extLinkPorts;
		return this;
	}

	public ExtVirtualLinkData addExtLinkPortsItem(final ExtLinkPortData extLinkPortsItem) {
		if (this.extLinkPorts == null) {
			this.extLinkPorts = new ArrayList<>();
		}
		this.extLinkPorts.add(extLinkPortsItem);
		return this;
	}

	/**
	 * Externally provided link ports to be used to connect external connection
	 * points to this external VL.
	 *
	 * @return extLinkPorts
	 **/
	@Schema(description = "Externally provided link ports to be used to connect external connection points to this external VL. ")

	@Valid

	public List<ExtLinkPortData> getExtLinkPorts() {
		return extLinkPorts;
	}

	public void setExtLinkPorts(final List<ExtLinkPortData> extLinkPorts) {
		this.extLinkPorts = extLinkPorts;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final ExtVirtualLinkData extVirtualLinkData = (ExtVirtualLinkData) o;
		return Objects.equals(this.extVirtualLinkId, extVirtualLinkData.extVirtualLinkId) &&
				Objects.equals(this.vimConnectionId, extVirtualLinkData.vimConnectionId) &&
				Objects.equals(this.resourceProviderId, extVirtualLinkData.resourceProviderId) &&
				Objects.equals(this.resourceId, extVirtualLinkData.resourceId) &&
				Objects.equals(this.extCps, extVirtualLinkData.extCps) &&
				Objects.equals(this.extLinkPorts, extVirtualLinkData.extLinkPorts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(extVirtualLinkId, vimConnectionId, resourceProviderId, resourceId, extCps, extLinkPorts);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class ExtVirtualLinkData {\n");

		sb.append("    extVirtualLinkId: ").append(toIndentedString(extVirtualLinkId)).append("\n");
		sb.append("    vimId: ").append(toIndentedString(vimConnectionId)).append("\n");
		sb.append("    resourceProviderId: ").append(toIndentedString(resourceProviderId)).append("\n");
		sb.append("    resourceId: ").append(toIndentedString(resourceId)).append("\n");
		sb.append("    extCps: ").append(toIndentedString(extCps)).append("\n");
		sb.append("    extLinkPorts: ").append(toIndentedString(extLinkPorts)).append("\n");
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
