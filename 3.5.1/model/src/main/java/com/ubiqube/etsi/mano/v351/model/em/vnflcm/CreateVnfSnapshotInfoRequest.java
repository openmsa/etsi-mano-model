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
package com.ubiqube.etsi.mano.v351.model.em.vnflcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents request parameters for the creation of an \&quot;Individual VNF snapshot\&quot; resource which can be populated with content obtained by invoking the \&quot;Create VNF snapshot\&quot; LCM operation or extracted from a VNF snapshot package. * NOTE: The present attribute shall be provided if the \&quot;Individual VNF snapshot\&quot; resource         is requested to be created and be filled from a VNF snapshot package extraction. 
 */
@Schema(description = "This type represents request parameters for the creation of an \"Individual VNF snapshot\" resource which can be populated with content obtained by invoking the \"Create VNF snapshot\" LCM operation or extracted from a VNF snapshot package. * NOTE: The present attribute shall be provided if the \"Individual VNF snapshot\" resource         is requested to be created and be filled from a VNF snapshot package extraction. ")
@Validated


public class CreateVnfSnapshotInfoRequest   {
  @JsonProperty("vnfSnapshotPkgId")
  private String vnfSnapshotPkgId = null;

  public CreateVnfSnapshotInfoRequest vnfSnapshotPkgId(String vnfSnapshotPkgId) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateVnfSnapshotInfoRequest createVnfSnapshotInfoRequest = (CreateVnfSnapshotInfoRequest) o;
    return Objects.equals(this.vnfSnapshotPkgId, createVnfSnapshotInfoRequest.vnfSnapshotPkgId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vnfSnapshotPkgId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateVnfSnapshotInfoRequest {\n");
    
    sb.append("    vnfSnapshotPkgId: ").append(toIndentedString(vnfSnapshotPkgId)).append("\n");
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
