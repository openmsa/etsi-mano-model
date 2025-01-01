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
package com.ubiqube.etsi.mano.v331.model.nfvo.vnfsnapshotpkgm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v331.model.nfvo.vnfsnapshotpkgm.Checksum;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents the VNFD which is contained in a VNF snapshot package. It shall comply  with provisions defined in Table 11.5.3.4-1. 
 */
@Schema(description = "This type represents the VNFD which is contained in a VNF snapshot package. It shall comply  with provisions defined in Table 11.5.3.4-1. ")
@Validated


public class VnfdInfo   {
  @JsonProperty("vnfdId")
  private String vnfdId = null;

  @JsonProperty("vnfdPath")
  private String vnfdPath = null;

  @JsonProperty("checksum")
  private Checksum checksum = null;

  @JsonProperty("isEncrypted")
  private Boolean isEncrypted = null;

  public VnfdInfo vnfdId(String vnfdId) {
    this.vnfdId = vnfdId;
    return this;
  }

  /**
   * Get vnfdId
   * @return vnfdId
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    public String getVnfdId() {
    return vnfdId;
  }

  public void setVnfdId(String vnfdId) {
    this.vnfdId = vnfdId;
  }

  public VnfdInfo vnfdPath(String vnfdPath) {
    this.vnfdPath = vnfdPath;
    return this;
  }

  /**
   * Path which allows to access a copy of the VNFD. The VNFD is implemented as a collection  of one or more files, and the path refers to the ZIP archive file embedding these files. The VNF snapshot package format is defined in the ETSI GS NFV-SOL 010. The value of this attribute shall start with the name of the first segment of the path  in the package, i.e. it shall not be prefixed by path separator characters such  as \".\" and \"/\". EXAMPLE: foo/bar/m@ster 
   * @return vnfdPath
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Path which allows to access a copy of the VNFD. The VNFD is implemented as a collection  of one or more files, and the path refers to the ZIP archive file embedding these files. The VNF snapshot package format is defined in the ETSI GS NFV-SOL 010. The value of this attribute shall start with the name of the first segment of the path  in the package, i.e. it shall not be prefixed by path separator characters such  as \".\" and \"/\". EXAMPLE: foo/bar/m@ster ")
      @NotNull

    public String getVnfdPath() {
    return vnfdPath;
  }

  public void setVnfdPath(String vnfdPath) {
    this.vnfdPath = vnfdPath;
  }

  public VnfdInfo checksum(Checksum checksum) {
    this.checksum = checksum;
    return this;
  }

  /**
   * Get checksum
   * @return checksum
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    @Valid
    public Checksum getChecksum() {
    return checksum;
  }

  public void setChecksum(Checksum checksum) {
    this.checksum = checksum;
  }

  public VnfdInfo isEncrypted(Boolean isEncrypted) {
    this.isEncrypted = isEncrypted;
    return this;
  }

  /**
   * Get isEncrypted
   * @return isEncrypted
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    public Boolean getIsEncrypted() {
    return isEncrypted;
  }

  public void setIsEncrypted(Boolean isEncrypted) {
    this.isEncrypted = isEncrypted;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VnfdInfo vnfdInfo = (VnfdInfo) o;
    return Objects.equals(this.vnfdId, vnfdInfo.vnfdId) &&
        Objects.equals(this.vnfdPath, vnfdInfo.vnfdPath) &&
        Objects.equals(this.checksum, vnfdInfo.checksum) &&
        Objects.equals(this.isEncrypted, vnfdInfo.isEncrypted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vnfdId, vnfdPath, checksum, isEncrypted);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VnfdInfo {\n");
    
    sb.append("    vnfdId: ").append(toIndentedString(vnfdId)).append("\n");
    sb.append("    vnfdPath: ").append(toIndentedString(vnfdPath)).append("\n");
    sb.append("    checksum: ").append(toIndentedString(checksum)).append("\n");
    sb.append("    isEncrypted: ").append(toIndentedString(isEncrypted)).append("\n");
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
