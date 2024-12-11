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
package com.ubiqube.etsi.mano.v361.model.vnfm.vnflcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents information about VNF-specific state snapshot data. 
 */
@Schema(description = "This type represents information about VNF-specific state snapshot data. ")
@Validated


public class VnfStateSnapshotInfo   {
  @JsonProperty("checksum")
  private Object checksum = null;

  @JsonProperty("isEncrypted")
  private Object isEncrypted = null;

  @JsonProperty("metadata")
  private Object metadata = null;

  public VnfStateSnapshotInfo checksum(Object checksum) {
    this.checksum = checksum;
    return this;
  }

  /**
   * Checksum of the VNF state snapshot file. Hash algorithms applicable to VNF snapshot package artifacts are defined in ETSI GS NFV-SOL 010. $ref: \"../definitions/SOL002SOL003_def.yaml#/definitions/Checksum\" 
   * @return checksum
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Checksum of the VNF state snapshot file. Hash algorithms applicable to VNF snapshot package artifacts are defined in ETSI GS NFV-SOL 010. $ref: \"../definitions/SOL002SOL003_def.yaml#/definitions/Checksum\" ")
      @NotNull

    public Object getChecksum() {
    return checksum;
  }

  public void setChecksum(Object checksum) {
    this.checksum = checksum;
  }

  public VnfStateSnapshotInfo isEncrypted(Object isEncrypted) {
    this.isEncrypted = isEncrypted;
    return this;
  }

  /**
   * Reflects whether the VNF state snapshot content is encrypted (true) or not (false). $ref: \"../definitions/SOL002SOL003_def.yaml#/definitions/Boolean\" 
   * @return isEncrypted
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Reflects whether the VNF state snapshot content is encrypted (true) or not (false). $ref: \"../definitions/SOL002SOL003_def.yaml#/definitions/Boolean\" ")
      @NotNull

    public Object getIsEncrypted() {
    return isEncrypted;
  }

  public void setIsEncrypted(Object isEncrypted) {
    this.isEncrypted = isEncrypted;
  }

  public VnfStateSnapshotInfo metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * The metadata with additional information such as content type, size, creation date, etc. $ref: \"../definitions/SOL002SOL003_def.yaml#/definitions/Map&gt;String, String&lt;\" 
   * @return metadata
   **/
  @Schema(description = "The metadata with additional information such as content type, size, creation date, etc. $ref: \"../definitions/SOL002SOL003_def.yaml#/definitions/Map<String, String>\" ")
  
    public Object getMetadata() {
    return metadata;
  }

  public void setMetadata(Object metadata) {
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
    VnfStateSnapshotInfo vnfStateSnapshotInfo = (VnfStateSnapshotInfo) o;
    return Objects.equals(this.checksum, vnfStateSnapshotInfo.checksum) &&
        Objects.equals(this.isEncrypted, vnfStateSnapshotInfo.isEncrypted) &&
        Objects.equals(this.metadata, vnfStateSnapshotInfo.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(checksum, isEncrypted, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VnfStateSnapshotInfo {\n");
    
    sb.append("    checksum: ").append(toIndentedString(checksum)).append("\n");
    sb.append("    isEncrypted: ").append(toIndentedString(isEncrypted)).append("\n");
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
