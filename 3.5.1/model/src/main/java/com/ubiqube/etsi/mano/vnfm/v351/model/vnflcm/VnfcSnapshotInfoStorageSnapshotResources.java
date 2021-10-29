/**
 *     Copyright (C) 2019-2020 Ubiqube.
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
package com.ubiqube.etsi.mano.vnfm.v351.model.vnflcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ubiqube.etsi.mano.vnfm.v351.model.vnflcm.KeyValuePairs;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * VnfcSnapshotInfoStorageSnapshotResources
 */
@Validated


public class VnfcSnapshotInfoStorageSnapshotResources   {
  @JsonProperty("storageResourceId")
  private String storageResourceId = null;

  @JsonProperty("storageSnapshotResource")
  private KeyValuePairs storageSnapshotResource = null;

  public VnfcSnapshotInfoStorageSnapshotResources storageResourceId(String storageResourceId) {
    this.storageResourceId = storageResourceId;
    return this;
  }

  /**
   * Get storageResourceId
   * @return storageResourceId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getStorageResourceId() {
    return storageResourceId;
  }

  public void setStorageResourceId(String storageResourceId) {
    this.storageResourceId = storageResourceId;
  }

  public VnfcSnapshotInfoStorageSnapshotResources storageSnapshotResource(KeyValuePairs storageSnapshotResource) {
    this.storageSnapshotResource = storageSnapshotResource;
    return this;
  }

  /**
   * Get storageSnapshotResource
   * @return storageSnapshotResource
   **/
  @Schema(description = "")
  
    @Valid
    public KeyValuePairs getStorageSnapshotResource() {
    return storageSnapshotResource;
  }

  public void setStorageSnapshotResource(KeyValuePairs storageSnapshotResource) {
    this.storageSnapshotResource = storageSnapshotResource;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VnfcSnapshotInfoStorageSnapshotResources vnfcSnapshotInfoStorageSnapshotResources = (VnfcSnapshotInfoStorageSnapshotResources) o;
    return Objects.equals(this.storageResourceId, vnfcSnapshotInfoStorageSnapshotResources.storageResourceId) &&
        Objects.equals(this.storageSnapshotResource, vnfcSnapshotInfoStorageSnapshotResources.storageSnapshotResource);
  }

  @Override
  public int hashCode() {
    return Objects.hash(storageResourceId, storageSnapshotResource);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VnfcSnapshotInfoStorageSnapshotResources {\n");
    
    sb.append("    storageResourceId: ").append(toIndentedString(storageResourceId)).append("\n");
    sb.append("    storageSnapshotResource: ").append(toIndentedString(storageSnapshotResource)).append("\n");
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