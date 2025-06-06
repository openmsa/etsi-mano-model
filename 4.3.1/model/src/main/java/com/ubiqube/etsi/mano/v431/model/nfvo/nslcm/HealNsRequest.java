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
package com.ubiqube.etsi.mano.v431.model.nfvo.nslcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v431.model.nfvo.nslcm.HealNsData;
import com.ubiqube.etsi.mano.v431.model.nfvo.nslcm.HealVnfData;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents request parameters for the \&quot;Heal NS\&quot; operation. This operation supports the healing of an NS instance, either by healing the complete NS instance or by healing one of more of the VNF instances that are part of this NS. It shall comply with the provisions defined in Table 6.5.2.13-1. Either the parameter healNsData or the parameter healVnfData, but not both shall be provided. 
 */
@Schema(description = "This type represents request parameters for the \"Heal NS\" operation. This operation supports the healing of an NS instance, either by healing the complete NS instance or by healing one of more of the VNF instances that are part of this NS. It shall comply with the provisions defined in Table 6.5.2.13-1. Either the parameter healNsData or the parameter healVnfData, but not both shall be provided. ")
@Validated


public class HealNsRequest  implements OneOfHealNsRequest {
  @JsonProperty("healNsData")
  private HealNsData healNsData = null;

  @JsonProperty("healVnfData")
  @Valid
  private List<HealVnfData> healVnfData = null;

  public HealNsRequest healNsData(HealNsData healNsData) {
    this.healNsData = healNsData;
    return this;
  }

  /**
   * Get healNsData
   * @return healNsData
   **/
  @Schema(description = "")
  
    @Valid
    public HealNsData getHealNsData() {
    return healNsData;
  }

  public void setHealNsData(HealNsData healNsData) {
    this.healNsData = healNsData;
  }

  public HealNsRequest healVnfData(List<HealVnfData> healVnfData) {
    this.healVnfData = healVnfData;
    return this;
  }

  public HealNsRequest addHealVnfDataItem(HealVnfData healVnfDataItem) {
    if (this.healVnfData == null) {
      this.healVnfData = new ArrayList<>();
    }
    this.healVnfData.add(healVnfDataItem);
    return this;
  }

  /**
   * Provides the information needed to heal a VNF. See note. 
   * @return healVnfData
   **/
  @Schema(description = "Provides the information needed to heal a VNF. See note. ")
      @Valid
    public List<HealVnfData> getHealVnfData() {
    return healVnfData;
  }

  public void setHealVnfData(List<HealVnfData> healVnfData) {
    this.healVnfData = healVnfData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HealNsRequest healNsRequest = (HealNsRequest) o;
    return Objects.equals(this.healNsData, healNsRequest.healNsData) &&
        Objects.equals(this.healVnfData, healNsRequest.healVnfData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(healNsData, healVnfData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HealNsRequest {\n");
    
    sb.append("    healNsData: ").append(toIndentedString(healNsData)).append("\n");
    sb.append("    healVnfData: ").append(toIndentedString(healVnfData)).append("\n");
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
