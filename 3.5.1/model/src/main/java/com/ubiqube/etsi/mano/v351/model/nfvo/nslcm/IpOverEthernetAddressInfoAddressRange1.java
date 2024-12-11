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
package com.ubiqube.etsi.mano.v351.model.nfvo.nslcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * An IP address range used, e.g. in case of egress connections. See note. 
 */
@Schema(description = "An IP address range used, e.g. in case of egress connections. See note. ")
@Validated


public class IpOverEthernetAddressInfoAddressRange1   {
  @JsonProperty("minAddress")
  private String minAddress = null;

  @JsonProperty("maxAddress")
  private String maxAddress = null;

  public IpOverEthernetAddressInfoAddressRange1 minAddress(String minAddress) {
    this.minAddress = minAddress;
    return this;
  }

  /**
   * Get minAddress
   * @return minAddress
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    public String getMinAddress() {
    return minAddress;
  }

  public void setMinAddress(String minAddress) {
    this.minAddress = minAddress;
  }

  public IpOverEthernetAddressInfoAddressRange1 maxAddress(String maxAddress) {
    this.maxAddress = maxAddress;
    return this;
  }

  /**
   * Get maxAddress
   * @return maxAddress
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    public String getMaxAddress() {
    return maxAddress;
  }

  public void setMaxAddress(String maxAddress) {
    this.maxAddress = maxAddress;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IpOverEthernetAddressInfoAddressRange1 ipOverEthernetAddressInfoAddressRange1 = (IpOverEthernetAddressInfoAddressRange1) o;
    return Objects.equals(this.minAddress, ipOverEthernetAddressInfoAddressRange1.minAddress) &&
        Objects.equals(this.maxAddress, ipOverEthernetAddressInfoAddressRange1.maxAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(minAddress, maxAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IpOverEthernetAddressInfoAddressRange1 {\n");
    
    sb.append("    minAddress: ").append(toIndentedString(minAddress)).append("\n");
    sb.append("    maxAddress: ").append(toIndentedString(maxAddress)).append("\n");
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
