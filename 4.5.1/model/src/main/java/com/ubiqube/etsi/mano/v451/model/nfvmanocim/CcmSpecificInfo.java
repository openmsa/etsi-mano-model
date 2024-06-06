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
package com.ubiqube.etsi.mano.v451.model.nfvmanocim;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * The supported cluster resource management modes. Available modes include: virtual and bare-metal resources, and for both types, on-demand (i.e., CCM requests to corresponding infrastructure managers to build  necessary pools of resources) or pooled (i.e., CCM manages resources from pre-allocated resource pools).  Multiple values can be specified. See note.  Permitted values: - VIRTUAL-ON-DEMAND: virtual resourceson demand. - VIRTUAL-POOLED: virtual resources from a pre-allocated resource pool. - BARE-METAL-ON-DEMAND: bare-metal resources on demand. - BARE-METAL-POOLED: bare-metal resources from a pre-allocated resource pool. NOTE: Hybrid CIS clusters include both physical and virtual CIS cluster nodes and can be supported by a       combination of relevant \&quot;clusterResourceMgmtModes\&quot;. 
 */
@Schema(description = "The supported cluster resource management modes. Available modes include: virtual and bare-metal resources, and for both types, on-demand (i.e., CCM requests to corresponding infrastructure managers to build  necessary pools of resources) or pooled (i.e., CCM manages resources from pre-allocated resource pools).  Multiple values can be specified. See note.  Permitted values: - VIRTUAL-ON-DEMAND: virtual resourceson demand. - VIRTUAL-POOLED: virtual resources from a pre-allocated resource pool. - BARE-METAL-ON-DEMAND: bare-metal resources on demand. - BARE-METAL-POOLED: bare-metal resources from a pre-allocated resource pool. NOTE: Hybrid CIS clusters include both physical and virtual CIS cluster nodes and can be supported by a       combination of relevant \"clusterResourceMgmtModes\". ")
@Validated



public class CcmSpecificInfo   {
  /**
   * Gets or Sets clusterResourceMgmtModes
   */
  public enum ClusterResourceMgmtModesEnum {
    VIRTUAL_ON_DEMAND("VIRTUAL-ON-DEMAND"),
    
    VIRTUAL_POOLED("VIRTUAL-POOLED"),
    
    BARE_METAL_ON_DEMAND("BARE-METAL-ON-DEMAND"),
    
    BARE_METAL_POOLED("BARE-METAL-POOLED");

    private String value;

    ClusterResourceMgmtModesEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ClusterResourceMgmtModesEnum fromValue(String text) {
      for (ClusterResourceMgmtModesEnum b : ClusterResourceMgmtModesEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("clusterResourceMgmtModes")
  @Valid
  private List<ClusterResourceMgmtModesEnum> clusterResourceMgmtModes = new ArrayList<>();

  public CcmSpecificInfo clusterResourceMgmtModes(List<ClusterResourceMgmtModesEnum> clusterResourceMgmtModes) {
    this.clusterResourceMgmtModes = clusterResourceMgmtModes;
    return this;
  }

  public CcmSpecificInfo addClusterResourceMgmtModesItem(ClusterResourceMgmtModesEnum clusterResourceMgmtModesItem) {
    this.clusterResourceMgmtModes.add(clusterResourceMgmtModesItem);
    return this;
  }

  /**
   * Get clusterResourceMgmtModes
   * @return clusterResourceMgmtModes
   **/
  @Schema(required = true, description = "")
      @NotNull

  @Size(min=1)   public List<ClusterResourceMgmtModesEnum> getClusterResourceMgmtModes() {
    return clusterResourceMgmtModes;
  }

  public void setClusterResourceMgmtModes(List<ClusterResourceMgmtModesEnum> clusterResourceMgmtModes) {
    this.clusterResourceMgmtModes = clusterResourceMgmtModes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CcmSpecificInfo ccmSpecificInfo = (CcmSpecificInfo) o;
    return Objects.equals(this.clusterResourceMgmtModes, ccmSpecificInfo.clusterResourceMgmtModes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clusterResourceMgmtModes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CcmSpecificInfo {\n");
    
    sb.append("    clusterResourceMgmtModes: ").append(toIndentedString(clusterResourceMgmtModes)).append("\n");
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
