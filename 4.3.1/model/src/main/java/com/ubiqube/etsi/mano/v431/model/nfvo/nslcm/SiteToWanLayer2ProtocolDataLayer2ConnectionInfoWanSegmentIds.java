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
 *     along with this program.  If not, see https://www.gnu.org/licenses/.
 */
package com.ubiqube.etsi.mano.v431.model.nfvo.nslcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Segment identifiers to pass on the tagged interface. Shall be present if encapsulationType&#x3D;\&quot;VLAN\&quot; or “VXLAN\&quot;. 
 */
@Schema(description = "Segment identifiers to pass on the tagged interface. Shall be present if encapsulationType=\"VLAN\" or “VXLAN\". ")
@Validated


public class SiteToWanLayer2ProtocolDataLayer2ConnectionInfoWanSegmentIds   {
  @JsonProperty("wanSegmentIdValue")
  private String wanSegmentIdValue = null;

  @JsonProperty("wanSegmentIdUpperRange")
  private String wanSegmentIdUpperRange = null;

  public SiteToWanLayer2ProtocolDataLayer2ConnectionInfoWanSegmentIds wanSegmentIdValue(String wanSegmentIdValue) {
    this.wanSegmentIdValue = wanSegmentIdValue;
    return this;
  }

  /**
   * Identifier of the network segment (e.g., VLAN id or VNI). 
   * @return wanSegmentIdValue
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifier of the network segment (e.g., VLAN id or VNI). ")
      @NotNull

    public String getWanSegmentIdValue() {
    return wanSegmentIdValue;
  }

  public void setWanSegmentIdValue(String wanSegmentIdValue) {
    this.wanSegmentIdValue = wanSegmentIdValue;
  }

  public SiteToWanLayer2ProtocolDataLayer2ConnectionInfoWanSegmentIds wanSegmentIdUpperRange(String wanSegmentIdUpperRange) {
    this.wanSegmentIdUpperRange = wanSegmentIdUpperRange;
    return this;
  }

  /**
   * Identifier of the upper range network segment, in case the \"wanSegmentIds\" is used to define a range. 
   * @return wanSegmentIdUpperRange
   **/
  @Schema(description = "Identifier of the upper range network segment, in case the \"wanSegmentIds\" is used to define a range. ")
  
    public String getWanSegmentIdUpperRange() {
    return wanSegmentIdUpperRange;
  }

  public void setWanSegmentIdUpperRange(String wanSegmentIdUpperRange) {
    this.wanSegmentIdUpperRange = wanSegmentIdUpperRange;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SiteToWanLayer2ProtocolDataLayer2ConnectionInfoWanSegmentIds siteToWanLayer2ProtocolDataLayer2ConnectionInfoWanSegmentIds = (SiteToWanLayer2ProtocolDataLayer2ConnectionInfoWanSegmentIds) o;
    return Objects.equals(this.wanSegmentIdValue, siteToWanLayer2ProtocolDataLayer2ConnectionInfoWanSegmentIds.wanSegmentIdValue) &&
        Objects.equals(this.wanSegmentIdUpperRange, siteToWanLayer2ProtocolDataLayer2ConnectionInfoWanSegmentIds.wanSegmentIdUpperRange);
  }

  @Override
  public int hashCode() {
    return Objects.hash(wanSegmentIdValue, wanSegmentIdUpperRange);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SiteToWanLayer2ProtocolDataLayer2ConnectionInfoWanSegmentIds {\n");
    
    sb.append("    wanSegmentIdValue: ").append(toIndentedString(wanSegmentIdValue)).append("\n");
    sb.append("    wanSegmentIdUpperRange: ").append(toIndentedString(wanSegmentIdUpperRange)).append("\n");
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
