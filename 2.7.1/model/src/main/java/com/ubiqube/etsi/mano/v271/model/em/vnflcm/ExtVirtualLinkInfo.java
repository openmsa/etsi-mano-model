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
package com.ubiqube.etsi.mano.v271.model.em.vnflcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.ExtLinkPortInfo;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.ResourceHandle;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.ArrayList;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * ExtVirtualLinkInfo
 */
@Validated

public class ExtVirtualLinkInfo   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("resourceHandle")
  private ResourceHandle resourceHandle = null;

  @JsonProperty("extLinkPorts")
  @Valid
  private List<ExtLinkPortInfo> extLinkPorts = null;

	public ExtVirtualLinkInfo id(String id) {
		this.id = id;
		return this;
	}

	/**
	* Identifier of the external VL and the related external VL information instance. The identifier is assigned by the NFV-MANO entity that manages this VL instance. 
	* @return id
	*/
	@Schema(required = true , description = "Identifier of the external VL and the related external VL information instance. The identifier is assigned by the NFV-MANO entity that manages this VL instance. ")
	@NotNull


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ExtVirtualLinkInfo resourceHandle(ResourceHandle resourceHandle) {
		this.resourceHandle = resourceHandle;
		return this;
	}

	/**
	* Reference to the resource realizing this VL. 
	* @return resourceHandle
	*/
	@Schema(required = true , description = "Reference to the resource realizing this VL. ")
	@NotNull

	@Valid

	public ResourceHandle getResourceHandle() {
		return resourceHandle;
	}

	public void setResourceHandle(ResourceHandle resourceHandle) {
		this.resourceHandle = resourceHandle;
	}

	public ExtVirtualLinkInfo extLinkPorts(List<ExtLinkPortInfo> extLinkPorts) {
		this.extLinkPorts = extLinkPorts;
		return this;
	}

	public ExtVirtualLinkInfo addExtLinkPortsItem(ExtLinkPortInfo extLinkPortsItem) {
		if (this.extLinkPorts == null) {
			this.extLinkPorts = new ArrayList<>();
		}
		this.extLinkPorts.add(extLinkPortsItem);
		return this;
	}

	/**
	* Link ports of this VL. 
	* @return extLinkPorts
	*/
	@Schema(description = "Link ports of this VL. ")

	@Valid

	public List<ExtLinkPortInfo> getExtLinkPorts() {
		return extLinkPorts;
	}

	public void setExtLinkPorts(List<ExtLinkPortInfo> extLinkPorts) {
		this.extLinkPorts = extLinkPorts;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ExtVirtualLinkInfo extVirtualLinkInfo = (ExtVirtualLinkInfo) o;
		return Objects.equals(this.id, extVirtualLinkInfo.id) &&
		Objects.equals(this.resourceHandle, extVirtualLinkInfo.resourceHandle) &&
		Objects.equals(this.extLinkPorts, extVirtualLinkInfo.extLinkPorts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, resourceHandle, extLinkPorts);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ExtVirtualLinkInfo {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    resourceHandle: ").append(toIndentedString(resourceHandle)).append("\n");
		sb.append("    extLinkPorts: ").append(toIndentedString(extLinkPorts)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	* Convert the given object to string with each line indented by 4 spaces
	* (except the first line).
	*/
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}

