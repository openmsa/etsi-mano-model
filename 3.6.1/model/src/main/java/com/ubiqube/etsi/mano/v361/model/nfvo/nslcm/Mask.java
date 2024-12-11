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
package com.ubiqube.etsi.mano.v361.model.nfvo.nslcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * The Mask data type identifies the value to be matched for a sequence of bits at a particular location in a frame. It shall comply with the provisions defined in Table 6.5.3.41-1. 
 */
@Schema(description = "The Mask data type identifies the value to be matched for a sequence of bits at a particular location in a frame. It shall comply with the provisions defined in Table 6.5.3.41-1. ")
@Validated


public class Mask   {
  @JsonProperty("startingPoint")
  private Integer startingPoint = null;

  @JsonProperty("length")
  private Integer length = null;

  @JsonProperty("value")
  private String value = null;

  public Mask startingPoint(Integer startingPoint) {
    this.startingPoint = startingPoint;
    return this;
  }

  /**
   * Indicates the offset between the last bit of the source mac address and the first bit of the sequence of bits to be matched. 
   * @return startingPoint
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Indicates the offset between the last bit of the source mac address and the first bit of the sequence of bits to be matched. ")
      @NotNull

    public Integer getStartingPoint() {
    return startingPoint;
  }

  public void setStartingPoint(Integer startingPoint) {
    this.startingPoint = startingPoint;
  }

  public Mask length(Integer length) {
    this.length = length;
    return this;
  }

  /**
   * Indicates the number of bits to be matched. 
   * @return length
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Indicates the number of bits to be matched. ")
      @NotNull

    public Integer getLength() {
    return length;
  }

  public void setLength(Integer length) {
    this.length = length;
  }

  public Mask value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Provide the sequence of bit values to be matched. 
   * @return value
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Provide the sequence of bit values to be matched. ")
      @NotNull

    public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Mask mask = (Mask) o;
    return Objects.equals(this.startingPoint, mask.startingPoint) &&
        Objects.equals(this.length, mask.length) &&
        Objects.equals(this.value, mask.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startingPoint, length, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Mask {\n");
    
    sb.append("    startingPoint: ").append(toIndentedString(startingPoint)).append("\n");
    sb.append("    length: ").append(toIndentedString(length)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
