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
package com.ubiqube.etsi.mano.v281.model.em.vnflcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v281.model.em.vnflcm.ResourceHandle;
import com.ubiqube.etsi.mano.v281.model.em.vnflcm.VnfLinkPortInfo;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents the information that allows addressing a virtualised resource that is used by an internal VL instance in a VNF instance. 
 */
@Schema (description= "This type represents the information that allows addressing a virtualised resource that is used by an internal VL instance in a VNF instance. " )
@Validated

public class VnfVirtualLinkResourceInfo   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("vnfVirtualLinkDescId")
  private String vnfVirtualLinkDescId = null;

  @JsonProperty("networkResource")
  private ResourceHandle networkResource = null;

  @JsonProperty("zoneId")
  private String zoneId = null;

  @JsonProperty("reservationId")
  private String reservationId = null;

  @JsonProperty("vnfLinkPorts")
  @Valid
  private List<VnfLinkPortInfo> vnfLinkPorts = null;

  @JsonProperty("metadata")
  private Map<String, String> metadata = null;

  public VnfVirtualLinkResourceInfo id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of this VnfVirtualLinkResourceInfo instance. 
   * @return id
  **/
  @Schema(required = true , description = "Identifier of this VnfVirtualLinkResourceInfo instance. ")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public VnfVirtualLinkResourceInfo vnfVirtualLinkDescId(String vnfVirtualLinkDescId) {
    this.vnfVirtualLinkDescId = vnfVirtualLinkDescId;
    return this;
  }

  /**
   * Identifier of the VNF Virtual Link Descriptor (VLD) in the VNFD. 
   * @return vnfVirtualLinkDescId
  **/
  @Schema(required = true , description = "Identifier of the VNF Virtual Link Descriptor (VLD) in the VNFD. ")
  @NotNull


  public String getVnfVirtualLinkDescId() {
    return vnfVirtualLinkDescId;
  }

  public void setVnfVirtualLinkDescId(String vnfVirtualLinkDescId) {
    this.vnfVirtualLinkDescId = vnfVirtualLinkDescId;
  }

  public VnfVirtualLinkResourceInfo networkResource(ResourceHandle networkResource) {
    this.networkResource = networkResource;
    return this;
  }

  /**
   * Reference to the VirtualNetwork resource. 
   * @return networkResource
  **/
  @Schema(required = true , description = "Reference to the VirtualNetwork resource. ")
  @NotNull

  @Valid

  public ResourceHandle getNetworkResource() {
    return networkResource;
  }

  public void setNetworkResource(ResourceHandle networkResource) {
    this.networkResource = networkResource;
  }

  public VnfVirtualLinkResourceInfo zoneId(String zoneId) {
    this.zoneId = zoneId;
    return this;
  }

  /**
   * The identifier of the resource zone, as managed by the resource management layer (typically, the VIM), where the referenced VirtualNetwork resource is placed. Shall be provided if this information is available from the VIM. 
   * @return zoneId
  **/
  @Schema(description = "The identifier of the resource zone, as managed by the resource management layer (typically, the VIM), where the referenced VirtualNetwork resource is placed. Shall be provided if this information is available from the VIM. ")


  public String getZoneId() {
    return zoneId;
  }

  public void setZoneId(String zoneId) {
    this.zoneId = zoneId;
  }

  public VnfVirtualLinkResourceInfo reservationId(String reservationId) {
    this.reservationId = reservationId;
    return this;
  }

  /**
   * The reservation identifier applicable to the resource. It shall be present when an applicable reservation exists. 
   * @return reservationId
  **/
  @Schema(description = "The reservation identifier applicable to the resource. It shall be present when an applicable reservation exists. ")


  public String getReservationId() {
    return reservationId;
  }

  public void setReservationId(String reservationId) {
    this.reservationId = reservationId;
  }

  public VnfVirtualLinkResourceInfo vnfLinkPorts(List<VnfLinkPortInfo> vnfLinkPorts) {
    this.vnfLinkPorts = vnfLinkPorts;
    return this;
  }

  public VnfVirtualLinkResourceInfo addVnfLinkPortsItem(VnfLinkPortInfo vnfLinkPortsItem) {
    if (this.vnfLinkPorts == null) {
      this.vnfLinkPorts = new ArrayList<>();
    }
    this.vnfLinkPorts.add(vnfLinkPortsItem);
    return this;
  }

  /**
   * Links ports of this VL. Shall be present when the linkPort is used for external connectivity by the VNF (refer to VnfLinkPortInfo). May be present otherwise. 
   * @return vnfLinkPorts
  **/
  @Schema(description = "Links ports of this VL. Shall be present when the linkPort is used for external connectivity by the VNF (refer to VnfLinkPortInfo). May be present otherwise. ")

  @Valid

  public List<VnfLinkPortInfo> getVnfLinkPorts() {
    return vnfLinkPorts;
  }

  public void setVnfLinkPorts(List<VnfLinkPortInfo> vnfLinkPorts) {
    this.vnfLinkPorts = vnfLinkPorts;
  }

  public VnfVirtualLinkResourceInfo metadata(Map<String, String> metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Metadata about this resource. 
   * @return metadata
  **/
  @Schema(description = "Metadata about this resource. ")

  @Valid

  public Map<String, String> getMetadata() {
    return metadata;
  }

  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VnfVirtualLinkResourceInfo vnfVirtualLinkResourceInfo = (VnfVirtualLinkResourceInfo) o;
    return Objects.equals(this.id, vnfVirtualLinkResourceInfo.id) &&
    Objects.equals(this.vnfVirtualLinkDescId, vnfVirtualLinkResourceInfo.vnfVirtualLinkDescId) &&
    Objects.equals(this.networkResource, vnfVirtualLinkResourceInfo.networkResource) &&
    Objects.equals(this.zoneId, vnfVirtualLinkResourceInfo.zoneId) &&
    Objects.equals(this.reservationId, vnfVirtualLinkResourceInfo.reservationId) &&
    Objects.equals(this.vnfLinkPorts, vnfVirtualLinkResourceInfo.vnfLinkPorts) &&
    Objects.equals(this.metadata, vnfVirtualLinkResourceInfo.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, vnfVirtualLinkDescId, networkResource, zoneId, reservationId, vnfLinkPorts, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VnfVirtualLinkResourceInfo {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    vnfVirtualLinkDescId: ").append(toIndentedString(vnfVirtualLinkDescId)).append("\n");
    sb.append("    networkResource: ").append(toIndentedString(networkResource)).append("\n");
    sb.append("    zoneId: ").append(toIndentedString(zoneId)).append("\n");
    sb.append("    reservationId: ").append(toIndentedString(reservationId)).append("\n");
    sb.append("    vnfLinkPorts: ").append(toIndentedString(vnfLinkPorts)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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

