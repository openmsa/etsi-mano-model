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
package com.ubiqube.etsi.mano.v451.model.nfvo.nslcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v451.model.nfvo.nslcm.CollectorDetails;
import com.ubiqube.etsi.mano.v451.model.nfvo.nslcm.DataFlowData;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents the information for the data flow mirroring to be associated to this NS instance.  It shall comply with the provisions defined in table 6.5.3.100-1. 
 */
@Schema(description = "This type represents the information for the data flow mirroring to be associated to this NS instance.  It shall comply with the provisions defined in table 6.5.3.100-1. ")
@Validated


public class DataFlowMirroringData   {
  @JsonProperty("mirroringId")
  private String mirroringId = null;

  @JsonProperty("mirroringName")
  private String mirroringName = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("collectorDetails")
  private CollectorDetails collectorDetails = null;

  @JsonProperty("dataFlowData")
  @Valid
  private List<DataFlowData> dataFlowData = new ArrayList<>();

  public DataFlowMirroringData mirroringId(String mirroringId) {
    this.mirroringId = mirroringId;
    return this;
  }

  /**
   * Get mirroringId
   * @return mirroringId
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    public String getMirroringId() {
    return mirroringId;
  }

  public void setMirroringId(String mirroringId) {
    this.mirroringId = mirroringId;
  }

  public DataFlowMirroringData mirroringName(String mirroringName) {
    this.mirroringName = mirroringName;
    return this;
  }

  /**
   * Name of Data Flow Mirroring. 
   * @return mirroringName
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Name of Data Flow Mirroring. ")
      @NotNull

    public String getMirroringName() {
    return mirroringName;
  }

  public void setMirroringName(String mirroringName) {
    this.mirroringName = mirroringName;
  }

  public DataFlowMirroringData description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Information description of Data Flow Mirroring. 
   * @return description
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Information description of Data Flow Mirroring. ")
      @NotNull

    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public DataFlowMirroringData collectorDetails(CollectorDetails collectorDetails) {
    this.collectorDetails = collectorDetails;
    return this;
  }

  /**
   * Get collectorDetails
   * @return collectorDetails
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    @Valid
    public CollectorDetails getCollectorDetails() {
    return collectorDetails;
  }

  public void setCollectorDetails(CollectorDetails collectorDetails) {
    this.collectorDetails = collectorDetails;
  }

  public DataFlowMirroringData dataFlowData(List<DataFlowData> dataFlowData) {
    this.dataFlowData = dataFlowData;
    return this;
  }

  public DataFlowMirroringData addDataFlowDataItem(DataFlowData dataFlowDataItem) {
    this.dataFlowData.add(dataFlowDataItem);
    return this;
  }

  /**
   * Information about the data flows to be mirrored. 
   * @return dataFlowData
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Information about the data flows to be mirrored. ")
      @NotNull
    @Valid
    public List<DataFlowData> getDataFlowData() {
    return dataFlowData;
  }

  public void setDataFlowData(List<DataFlowData> dataFlowData) {
    this.dataFlowData = dataFlowData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataFlowMirroringData dataFlowMirroringData = (DataFlowMirroringData) o;
    return Objects.equals(this.mirroringId, dataFlowMirroringData.mirroringId) &&
        Objects.equals(this.mirroringName, dataFlowMirroringData.mirroringName) &&
        Objects.equals(this.description, dataFlowMirroringData.description) &&
        Objects.equals(this.collectorDetails, dataFlowMirroringData.collectorDetails) &&
        Objects.equals(this.dataFlowData, dataFlowMirroringData.dataFlowData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mirroringId, mirroringName, description, collectorDetails, dataFlowData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataFlowMirroringData {\n");
    
    sb.append("    mirroringId: ").append(toIndentedString(mirroringId)).append("\n");
    sb.append("    mirroringName: ").append(toIndentedString(mirroringName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    collectorDetails: ").append(toIndentedString(collectorDetails)).append("\n");
    sb.append("    dataFlowData: ").append(toIndentedString(dataFlowData)).append("\n");
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
