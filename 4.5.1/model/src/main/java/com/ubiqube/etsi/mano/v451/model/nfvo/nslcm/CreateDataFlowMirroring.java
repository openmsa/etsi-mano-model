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
package com.ubiqube.etsi.mano.v451.model.nfvo.nslcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v451.model.nfvo.nslcm.DataFlowMirroringData;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents the information for the data flow mirroring to be associated to this NS instance. It shall comply with the provisions defined in table 6.5.3.104-1. 
 */
@Schema(description = "This type represents the information for the data flow mirroring to be associated to this NS instance. It shall comply with the provisions defined in table 6.5.3.104-1. ")
@Validated


public class CreateDataFlowMirroring   {
  @JsonProperty("dataFlowMirroringData")
  private DataFlowMirroringData dataFlowMirroringData = null;

  @JsonProperty("vnfInstanceId")
  private String vnfInstanceId = null;

  @JsonProperty("cpInstanceId")
  private String cpInstanceId = null;

  public CreateDataFlowMirroring dataFlowMirroringData(DataFlowMirroringData dataFlowMirroringData) {
    this.dataFlowMirroringData = dataFlowMirroringData;
    return this;
  }

  /**
   * Get dataFlowMirroringData
   * @return dataFlowMirroringData
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    @Valid
    public DataFlowMirroringData getDataFlowMirroringData() {
    return dataFlowMirroringData;
  }

  public void setDataFlowMirroringData(DataFlowMirroringData dataFlowMirroringData) {
    this.dataFlowMirroringData = dataFlowMirroringData;
  }

  public CreateDataFlowMirroring vnfInstanceId(String vnfInstanceId) {
    this.vnfInstanceId = vnfInstanceId;
    return this;
  }

  /**
   * Get vnfInstanceId
   * @return vnfInstanceId
   **/
  @Schema(description = "")
  
    public String getVnfInstanceId() {
    return vnfInstanceId;
  }

  public void setVnfInstanceId(String vnfInstanceId) {
    this.vnfInstanceId = vnfInstanceId;
  }

  public CreateDataFlowMirroring cpInstanceId(String cpInstanceId) {
    this.cpInstanceId = cpInstanceId;
    return this;
  }

  /**
   * Get cpInstanceId
   * @return cpInstanceId
   **/
  @Schema(description = "")
  
    public String getCpInstanceId() {
    return cpInstanceId;
  }

  public void setCpInstanceId(String cpInstanceId) {
    this.cpInstanceId = cpInstanceId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDataFlowMirroring createDataFlowMirroring = (CreateDataFlowMirroring) o;
    return Objects.equals(this.dataFlowMirroringData, createDataFlowMirroring.dataFlowMirroringData) &&
        Objects.equals(this.vnfInstanceId, createDataFlowMirroring.vnfInstanceId) &&
        Objects.equals(this.cpInstanceId, createDataFlowMirroring.cpInstanceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataFlowMirroringData, vnfInstanceId, cpInstanceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDataFlowMirroring {\n");
    
    sb.append("    dataFlowMirroringData: ").append(toIndentedString(dataFlowMirroringData)).append("\n");
    sb.append("    vnfInstanceId: ").append(toIndentedString(vnfInstanceId)).append("\n");
    sb.append("    cpInstanceId: ").append(toIndentedString(cpInstanceId)).append("\n");
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
