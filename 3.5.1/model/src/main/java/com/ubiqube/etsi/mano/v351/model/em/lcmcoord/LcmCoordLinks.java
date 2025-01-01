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
package com.ubiqube.etsi.mano.v351.model.em.lcmcoord;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v351.model.em.lcmcoord.Link;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Links to resources related to this resource. 
 */
@Schema(description = "Links to resources related to this resource. ")
@Validated


public class LcmCoordLinks   {
  @JsonProperty("self")
  private Link self = null;

  @JsonProperty("vnfLcmOpOcc")
  private Link vnfLcmOpOcc = null;

  @JsonProperty("vnfInstance")
  private Link vnfInstance = null;

  public LcmCoordLinks self(Link self) {
    this.self = self;
    return this;
  }

  /**
   * Get self
   * @return self
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    @Valid
    public Link getSelf() {
    return self;
  }

  public void setSelf(Link self) {
    this.self = self;
  }

  public LcmCoordLinks vnfLcmOpOcc(Link vnfLcmOpOcc) {
    this.vnfLcmOpOcc = vnfLcmOpOcc;
    return this;
  }

  /**
   * Get vnfLcmOpOcc
   * @return vnfLcmOpOcc
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    @Valid
    public Link getVnfLcmOpOcc() {
    return vnfLcmOpOcc;
  }

  public void setVnfLcmOpOcc(Link vnfLcmOpOcc) {
    this.vnfLcmOpOcc = vnfLcmOpOcc;
  }

  public LcmCoordLinks vnfInstance(Link vnfInstance) {
    this.vnfInstance = vnfInstance;
    return this;
  }

  /**
   * Get vnfInstance
   * @return vnfInstance
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    @Valid
    public Link getVnfInstance() {
    return vnfInstance;
  }

  public void setVnfInstance(Link vnfInstance) {
    this.vnfInstance = vnfInstance;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LcmCoordLinks lcmCoordLinks = (LcmCoordLinks) o;
    return Objects.equals(this.self, lcmCoordLinks.self) &&
        Objects.equals(this.vnfLcmOpOcc, lcmCoordLinks.vnfLcmOpOcc) &&
        Objects.equals(this.vnfInstance, lcmCoordLinks.vnfInstance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, vnfLcmOpOcc, vnfInstance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LcmCoordLinks {\n");
    
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    vnfLcmOpOcc: ").append(toIndentedString(vnfLcmOpOcc)).append("\n");
    sb.append("    vnfInstance: ").append(toIndentedString(vnfInstance)).append("\n");
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
