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
package com.ubiqube.etsi.mano.v331.model.em.vnflcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v331.model.em.vnflcm.ResourceHandle;
import com.ubiqube.etsi.mano.v331.model.em.vnflcm.VnfcInfo;
import com.ubiqube.etsi.mano.v331.model.em.vnflcm.VnfcSnapshotInfoStorageSnapshotResources;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents a VNFC snapshot. 
 */
@Schema(description = "This type represents a VNFC snapshot. ")
@Validated


public class VnfcSnapshotInfo   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("vnfcInstanceId")
  private String vnfcInstanceId = null;

  @JsonProperty("creationStartedAt")
  private OffsetDateTime creationStartedAt = null;

  @JsonProperty("creationFinishedAt")
  private OffsetDateTime creationFinishedAt = null;

  @JsonProperty("vnfcResourceInfoId")
  private VnfcInfo vnfcResourceInfoId = null;

  @JsonProperty("computeSnapshotResource")
  private ResourceHandle computeSnapshotResource = null;

  @JsonProperty("storageSnapshotResources")
  private VnfcSnapshotInfoStorageSnapshotResources storageSnapshotResources = null;

  @JsonProperty("userDefinedData")
  private Map<String, String> userDefinedData = null;

  public VnfcSnapshotInfo id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public VnfcSnapshotInfo vnfcInstanceId(String vnfcInstanceId) {
    this.vnfcInstanceId = vnfcInstanceId;
    return this;
  }

  /**
   * Get vnfcInstanceId
   * @return vnfcInstanceId
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    public String getVnfcInstanceId() {
    return vnfcInstanceId;
  }

  public void setVnfcInstanceId(String vnfcInstanceId) {
    this.vnfcInstanceId = vnfcInstanceId;
  }

  public VnfcSnapshotInfo creationStartedAt(OffsetDateTime creationStartedAt) {
    this.creationStartedAt = creationStartedAt;
    return this;
  }

  /**
   * Get creationStartedAt
   * @return creationStartedAt
   **/
  @Schema(description = "")
  
    @Valid
    public OffsetDateTime getCreationStartedAt() {
    return creationStartedAt;
  }

  public void setCreationStartedAt(OffsetDateTime creationStartedAt) {
    this.creationStartedAt = creationStartedAt;
  }

  public VnfcSnapshotInfo creationFinishedAt(OffsetDateTime creationFinishedAt) {
    this.creationFinishedAt = creationFinishedAt;
    return this;
  }

  /**
   * Get creationFinishedAt
   * @return creationFinishedAt
   **/
  @Schema(description = "")
  
    @Valid
    public OffsetDateTime getCreationFinishedAt() {
    return creationFinishedAt;
  }

  public void setCreationFinishedAt(OffsetDateTime creationFinishedAt) {
    this.creationFinishedAt = creationFinishedAt;
  }

  public VnfcSnapshotInfo vnfcResourceInfoId(VnfcInfo vnfcResourceInfoId) {
    this.vnfcResourceInfoId = vnfcResourceInfoId;
    return this;
  }

  /**
   * Get vnfcResourceInfoId
   * @return vnfcResourceInfoId
   **/
  @Schema(description = "")
  
    @Valid
    public VnfcInfo getVnfcResourceInfoId() {
    return vnfcResourceInfoId;
  }

  public void setVnfcResourceInfoId(VnfcInfo vnfcResourceInfoId) {
    this.vnfcResourceInfoId = vnfcResourceInfoId;
  }

  public VnfcSnapshotInfo computeSnapshotResource(ResourceHandle computeSnapshotResource) {
    this.computeSnapshotResource = computeSnapshotResource;
    return this;
  }

  /**
   * Get computeSnapshotResource
   * @return computeSnapshotResource
   **/
  @Schema(description = "")
  
    @Valid
    public ResourceHandle getComputeSnapshotResource() {
    return computeSnapshotResource;
  }

  public void setComputeSnapshotResource(ResourceHandle computeSnapshotResource) {
    this.computeSnapshotResource = computeSnapshotResource;
  }

  public VnfcSnapshotInfo storageSnapshotResources(VnfcSnapshotInfoStorageSnapshotResources storageSnapshotResources) {
    this.storageSnapshotResources = storageSnapshotResources;
    return this;
  }

  /**
   * Get storageSnapshotResources
   * @return storageSnapshotResources
   **/
  @Schema(description = "")
  
    @Valid
    public VnfcSnapshotInfoStorageSnapshotResources getStorageSnapshotResources() {
    return storageSnapshotResources;
  }

  public void setStorageSnapshotResources(VnfcSnapshotInfoStorageSnapshotResources storageSnapshotResources) {
    this.storageSnapshotResources = storageSnapshotResources;
  }

  public VnfcSnapshotInfo userDefinedData(Map<String, String> userDefinedData) {
    this.userDefinedData = userDefinedData;
    return this;
  }

  /**
   * Get userDefinedData
   * @return userDefinedData
   **/
  @Schema(description = "")
  
    @Valid
    public Map<String, String> getUserDefinedData() {
    return userDefinedData;
  }

  public void setUserDefinedData(Map<String, String> userDefinedData) {
    this.userDefinedData = userDefinedData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VnfcSnapshotInfo vnfcSnapshotInfo = (VnfcSnapshotInfo) o;
    return Objects.equals(this.id, vnfcSnapshotInfo.id) &&
        Objects.equals(this.vnfcInstanceId, vnfcSnapshotInfo.vnfcInstanceId) &&
        Objects.equals(this.creationStartedAt, vnfcSnapshotInfo.creationStartedAt) &&
        Objects.equals(this.creationFinishedAt, vnfcSnapshotInfo.creationFinishedAt) &&
        Objects.equals(this.vnfcResourceInfoId, vnfcSnapshotInfo.vnfcResourceInfoId) &&
        Objects.equals(this.computeSnapshotResource, vnfcSnapshotInfo.computeSnapshotResource) &&
        Objects.equals(this.storageSnapshotResources, vnfcSnapshotInfo.storageSnapshotResources) &&
        Objects.equals(this.userDefinedData, vnfcSnapshotInfo.userDefinedData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, vnfcInstanceId, creationStartedAt, creationFinishedAt, vnfcResourceInfoId, computeSnapshotResource, storageSnapshotResources, userDefinedData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VnfcSnapshotInfo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    vnfcInstanceId: ").append(toIndentedString(vnfcInstanceId)).append("\n");
    sb.append("    creationStartedAt: ").append(toIndentedString(creationStartedAt)).append("\n");
    sb.append("    creationFinishedAt: ").append(toIndentedString(creationFinishedAt)).append("\n");
    sb.append("    vnfcResourceInfoId: ").append(toIndentedString(vnfcResourceInfoId)).append("\n");
    sb.append("    computeSnapshotResource: ").append(toIndentedString(computeSnapshotResource)).append("\n");
    sb.append("    storageSnapshotResources: ").append(toIndentedString(storageSnapshotResources)).append("\n");
    sb.append("    userDefinedData: ").append(toIndentedString(userDefinedData)).append("\n");
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
