/**
 *     Copyright (C) 2019-2023 Ubiqube.
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
package com.ubiqube.etsi.mano.vnfm.v431.model.vnflcm;

import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.vnfm.v431.model.grant.ResourceHandle;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * This type represents information about a link port of an external VL, i.e. a
 * port providing connectivity for the VNF to an NS VL. NOTE 1: The use cases
 * UC#4 and UC#5 in clause A.4 of ETSI GS NFV-IFA 007 provide examples for such
 * a configuration. NOTE 2: The value of \&quot;trunkResourceId\&quot; is scoped
 * by the value of \&quot;vimConnectionId\&quot; in the
 * \&quot;resourceHandle\&quot; attribute.
 */
@Schema(description = "This type represents information about a link port of an external VL, i.e. a port providing connectivity for the VNF to  an NS VL. NOTE 1: The use cases UC#4 and UC#5 in clause A.4 of ETSI GS NFV-IFA 007 provide examples for such a configuration. NOTE 2: The value of \"trunkResourceId\" is scoped by the value of \"vimConnectionId\" in the \"resourceHandle\" attribute. ")
@Validated

public class ExtLinkPortInfo {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("resourceHandle")
	private ResourceHandle resourceHandle = null;

	@JsonProperty("cpInstanceId")
	private String cpInstanceId = null;

	@JsonProperty("secondaryCpInstanceId")
	private String secondaryCpInstanceId = null;

	@JsonProperty("trunkResourceId")
	private String trunkResourceId = null;

	public ExtLinkPortInfo id(final String id) {
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

	public ExtLinkPortInfo resourceHandle(final ResourceHandle resourceHandle) {
		this.resourceHandle = resourceHandle;
		return this;
	}

	/**
	 * Get resourceHandle
	 *
	 * @return resourceHandle
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public ResourceHandle getResourceHandle() {
		return resourceHandle;
	}

	public void setResourceHandle(final ResourceHandle resourceHandle) {
		this.resourceHandle = resourceHandle;
	}

	public ExtLinkPortInfo cpInstanceId(final String cpInstanceId) {
		this.cpInstanceId = cpInstanceId;
		return this;
	}

	/**
	 * Get cpInstanceId
	 *
	 * @return cpInstanceId
	 **/
	@Schema(description = "")

	public String getCpInstanceId() {
		return cpInstanceId;
	}

	public void setCpInstanceId(final String cpInstanceId) {
		this.cpInstanceId = cpInstanceId;
	}

	public ExtLinkPortInfo secondaryCpInstanceId(final String secondaryCpInstanceId) {
		this.secondaryCpInstanceId = secondaryCpInstanceId;
		return this;
	}

	/**
	 * Get secondaryCpInstanceId
	 *
	 * @return secondaryCpInstanceId
	 **/
	@Schema(description = "")

	public String getSecondaryCpInstanceId() {
		return secondaryCpInstanceId;
	}

	public void setSecondaryCpInstanceId(final String secondaryCpInstanceId) {
		this.secondaryCpInstanceId = secondaryCpInstanceId;
	}

	public ExtLinkPortInfo trunkResourceId(final String trunkResourceId) {
		this.trunkResourceId = trunkResourceId;
		return this;
	}

	/**
	 * Get trunkResourceId
	 *
	 * @return trunkResourceId
	 **/
	@Schema(description = "")

	public String getTrunkResourceId() {
		return trunkResourceId;
	}

	public void setTrunkResourceId(final String trunkResourceId) {
		this.trunkResourceId = trunkResourceId;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final ExtLinkPortInfo extLinkPortInfo = (ExtLinkPortInfo) o;
		return Objects.equals(this.id, extLinkPortInfo.id) &&
				Objects.equals(this.resourceHandle, extLinkPortInfo.resourceHandle) &&
				Objects.equals(this.cpInstanceId, extLinkPortInfo.cpInstanceId) &&
				Objects.equals(this.secondaryCpInstanceId, extLinkPortInfo.secondaryCpInstanceId) &&
				Objects.equals(this.trunkResourceId, extLinkPortInfo.trunkResourceId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, resourceHandle, cpInstanceId, secondaryCpInstanceId, trunkResourceId);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class ExtLinkPortInfo {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    resourceHandle: ").append(toIndentedString(resourceHandle)).append("\n");
		sb.append("    cpInstanceId: ").append(toIndentedString(cpInstanceId)).append("\n");
		sb.append("    secondaryCpInstanceId: ").append(toIndentedString(secondaryCpInstanceId)).append("\n");
		sb.append("    trunkResourceId: ").append(toIndentedString(trunkResourceId)).append("\n");
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
