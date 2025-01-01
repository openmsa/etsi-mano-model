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
package com.ubiqube.etsi.mano.v331.model.em.vnflcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v331.model.em.vnflcm.VnfSnapshot;
import com.ubiqube.etsi.mano.v331.model.em.vnflcm.VnfSnapshotInfoLinks;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents an individual VNF snapshot resource. 
 */
@Schema(description = "This type represents an individual VNF snapshot resource. ")
@Validated


public class VnfSnapshotInfo   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("vnfSnapshotPkgId")
  private String vnfSnapshotPkgId = null;

  @JsonProperty("vnfSnapshot")
  private VnfSnapshot vnfSnapshot = null;

  @JsonProperty("_links")
  private VnfSnapshotInfoLinks _links = null;

  public VnfSnapshotInfo id(String id) {
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

  public VnfSnapshotInfo vnfSnapshotPkgId(String vnfSnapshotPkgId) {
    this.vnfSnapshotPkgId = vnfSnapshotPkgId;
    return this;
  }

  /**
   * Get vnfSnapshotPkgId
   * @return vnfSnapshotPkgId
   **/
  @Schema(description = "")
  
    public String getVnfSnapshotPkgId() {
    return vnfSnapshotPkgId;
  }

  public void setVnfSnapshotPkgId(String vnfSnapshotPkgId) {
    this.vnfSnapshotPkgId = vnfSnapshotPkgId;
  }

  public VnfSnapshotInfo vnfSnapshot(VnfSnapshot vnfSnapshot) {
    this.vnfSnapshot = vnfSnapshot;
    return this;
  }

  /**
   * Get vnfSnapshot
   * @return vnfSnapshot
   **/
  @Schema(description = "")
  
    @Valid
    public VnfSnapshot getVnfSnapshot() {
    return vnfSnapshot;
  }

  public void setVnfSnapshot(VnfSnapshot vnfSnapshot) {
    this.vnfSnapshot = vnfSnapshot;
  }

  public VnfSnapshotInfo _links(VnfSnapshotInfoLinks _links) {
    this._links = _links;
    return this;
  }

  /**
   * Get _links
   * @return _links
   **/
  @Schema(description = "")
  
    @Valid
    public VnfSnapshotInfoLinks getLinks() {
    return _links;
  }

  public void setLinks(VnfSnapshotInfoLinks _links) {
    this._links = _links;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VnfSnapshotInfo vnfSnapshotInfo = (VnfSnapshotInfo) o;
    return Objects.equals(this.id, vnfSnapshotInfo.id) &&
        Objects.equals(this.vnfSnapshotPkgId, vnfSnapshotInfo.vnfSnapshotPkgId) &&
        Objects.equals(this.vnfSnapshot, vnfSnapshotInfo.vnfSnapshot) &&
        Objects.equals(this._links, vnfSnapshotInfo._links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, vnfSnapshotPkgId, vnfSnapshot, _links);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VnfSnapshotInfo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    vnfSnapshotPkgId: ").append(toIndentedString(vnfSnapshotPkgId)).append("\n");
    sb.append("    vnfSnapshot: ").append(toIndentedString(vnfSnapshot)).append("\n");
    sb.append("    _links: ").append(toIndentedString(_links)).append("\n");
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
