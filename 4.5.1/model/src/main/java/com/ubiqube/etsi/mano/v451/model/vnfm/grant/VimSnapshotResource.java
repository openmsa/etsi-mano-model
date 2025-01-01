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
package com.ubiqube.etsi.mano.v451.model.vnfm.grant;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type contains a mapping between a snapshot resource definition related to a VNF snapshot  and the corresponding resource managed by the NFVO in the VIM which is needed during the revert  to VNF snapshot operation. 
 */
@Schema(description = "This type contains a mapping between a snapshot resource definition related to a VNF snapshot  and the corresponding resource managed by the NFVO in the VIM which is needed during the revert  to VNF snapshot operation. ")
@Validated


public class VimSnapshotResource   {
  @JsonProperty("vimConnectionId")
  private String vimConnectionId = null;

  @JsonProperty("resourceProviderId")
  private String resourceProviderId = null;

  @JsonProperty("vnfSnapshotId")
  private String vnfSnapshotId = null;

  @JsonProperty("vnfcSnapshotId")
  private String vnfcSnapshotId = null;

  @JsonProperty("storageSnapshotId")
  private String storageSnapshotId = null;

  @JsonProperty("vimSnapshotResourceId")
  private String vimSnapshotResourceId = null;

  public VimSnapshotResource vimConnectionId(String vimConnectionId) {
    this.vimConnectionId = vimConnectionId;
    return this;
  }

  /**
   * Get vimConnectionId
   * @return vimConnectionId
   **/
  @Schema(description = "")
  
    public String getVimConnectionId() {
    return vimConnectionId;
  }

  public void setVimConnectionId(String vimConnectionId) {
    this.vimConnectionId = vimConnectionId;
  }

  public VimSnapshotResource resourceProviderId(String resourceProviderId) {
    this.resourceProviderId = resourceProviderId;
    return this;
  }

  /**
   * Get resourceProviderId
   * @return resourceProviderId
   **/
  @Schema(description = "")
  
    public String getResourceProviderId() {
    return resourceProviderId;
  }

  public void setResourceProviderId(String resourceProviderId) {
    this.resourceProviderId = resourceProviderId;
  }

  public VimSnapshotResource vnfSnapshotId(String vnfSnapshotId) {
    this.vnfSnapshotId = vnfSnapshotId;
    return this;
  }

  /**
   * Get vnfSnapshotId
   * @return vnfSnapshotId
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    public String getVnfSnapshotId() {
    return vnfSnapshotId;
  }

  public void setVnfSnapshotId(String vnfSnapshotId) {
    this.vnfSnapshotId = vnfSnapshotId;
  }

  public VimSnapshotResource vnfcSnapshotId(String vnfcSnapshotId) {
    this.vnfcSnapshotId = vnfcSnapshotId;
    return this;
  }

  /**
   * Get vnfcSnapshotId
   * @return vnfcSnapshotId
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    public String getVnfcSnapshotId() {
    return vnfcSnapshotId;
  }

  public void setVnfcSnapshotId(String vnfcSnapshotId) {
    this.vnfcSnapshotId = vnfcSnapshotId;
  }

  public VimSnapshotResource storageSnapshotId(String storageSnapshotId) {
    this.storageSnapshotId = storageSnapshotId;
    return this;
  }

  /**
   * Get storageSnapshotId
   * @return storageSnapshotId
   **/
  @Schema(description = "")
  
    public String getStorageSnapshotId() {
    return storageSnapshotId;
  }

  public void setStorageSnapshotId(String storageSnapshotId) {
    this.storageSnapshotId = storageSnapshotId;
  }

  public VimSnapshotResource vimSnapshotResourceId(String vimSnapshotResourceId) {
    this.vimSnapshotResourceId = vimSnapshotResourceId;
    return this;
  }

  /**
   * Get vimSnapshotResourceId
   * @return vimSnapshotResourceId
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    public String getVimSnapshotResourceId() {
    return vimSnapshotResourceId;
  }

  public void setVimSnapshotResourceId(String vimSnapshotResourceId) {
    this.vimSnapshotResourceId = vimSnapshotResourceId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VimSnapshotResource vimSnapshotResource = (VimSnapshotResource) o;
    return Objects.equals(this.vimConnectionId, vimSnapshotResource.vimConnectionId) &&
        Objects.equals(this.resourceProviderId, vimSnapshotResource.resourceProviderId) &&
        Objects.equals(this.vnfSnapshotId, vimSnapshotResource.vnfSnapshotId) &&
        Objects.equals(this.vnfcSnapshotId, vimSnapshotResource.vnfcSnapshotId) &&
        Objects.equals(this.storageSnapshotId, vimSnapshotResource.storageSnapshotId) &&
        Objects.equals(this.vimSnapshotResourceId, vimSnapshotResource.vimSnapshotResourceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vimConnectionId, resourceProviderId, vnfSnapshotId, vnfcSnapshotId, storageSnapshotId, vimSnapshotResourceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VimSnapshotResource {\n");
    
    sb.append("    vimConnectionId: ").append(toIndentedString(vimConnectionId)).append("\n");
    sb.append("    resourceProviderId: ").append(toIndentedString(resourceProviderId)).append("\n");
    sb.append("    vnfSnapshotId: ").append(toIndentedString(vnfSnapshotId)).append("\n");
    sb.append("    vnfcSnapshotId: ").append(toIndentedString(vnfcSnapshotId)).append("\n");
    sb.append("    storageSnapshotId: ").append(toIndentedString(storageSnapshotId)).append("\n");
    sb.append("    vimSnapshotResourceId: ").append(toIndentedString(vimSnapshotResourceId)).append("\n");
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
