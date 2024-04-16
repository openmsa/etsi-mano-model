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
import com.ubiqube.etsi.mano.v451.model.nfvo.nslcm.CollectorDetails;
import com.ubiqube.etsi.mano.v451.model.nfvo.nslcm.DataFlowData;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents the runtime information that the NFVO holds about a Data Flow Mirroring.  NOTE: It is responsibility of the NFVO to map the mirroringIds exposed towards the API consumer on the Os-Ma-nfvo reference point with the corresponding identifiers of the data flow mirroring that are created towards the VIM. 
 */
@Schema(description = "This type represents the runtime information that the NFVO holds about a Data Flow Mirroring.  NOTE: It is responsibility of the NFVO to map the mirroringIds exposed towards the API consumer on the Os-Ma-nfvo reference point with the corresponding identifiers of the data flow mirroring that are created towards the VIM. ")
@Validated


public class MirroringInfo   {
  @JsonProperty("mirroringId")
  private String mirroringId = null;

  @JsonProperty("mirroringName")
  private String mirroringName = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("collectorDetails")
  private CollectorDetails collectorDetails = null;

  @JsonProperty("vnfInstanceId")
  @Valid
  private List<String> vnfInstanceId = new ArrayList<>();

  @JsonProperty("cpInstanceId")
  @Valid
  private List<String> cpInstanceId = new ArrayList<>();

  @JsonProperty("dataFlowData")
  @Valid
  private List<DataFlowData> dataFlowData = new ArrayList<>();

  public MirroringInfo mirroringId(String mirroringId) {
    this.mirroringId = mirroringId;
    return this;
  }

  /**
   * Get mirroringId
   * @return mirroringId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getMirroringId() {
    return mirroringId;
  }

  public void setMirroringId(String mirroringId) {
    this.mirroringId = mirroringId;
  }

  public MirroringInfo mirroringName(String mirroringName) {
    this.mirroringName = mirroringName;
    return this;
  }

  /**
   * Name of Data Flow Mirroring. 
   * @return mirroringName
   **/
  @Schema(required = true, description = "Name of Data Flow Mirroring. ")
      @NotNull

    public String getMirroringName() {
    return mirroringName;
  }

  public void setMirroringName(String mirroringName) {
    this.mirroringName = mirroringName;
  }

  public MirroringInfo description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Information description of Data Flow Mirroring 
   * @return description
   **/
  @Schema(required = true, description = "Information description of Data Flow Mirroring ")
      @NotNull

    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public MirroringInfo collectorDetails(CollectorDetails collectorDetails) {
    this.collectorDetails = collectorDetails;
    return this;
  }

  /**
   * Get collectorDetails
   * @return collectorDetails
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public CollectorDetails getCollectorDetails() {
    return collectorDetails;
  }

  public void setCollectorDetails(CollectorDetails collectorDetails) {
    this.collectorDetails = collectorDetails;
  }

  public MirroringInfo vnfInstanceId(List<String> vnfInstanceId) {
    this.vnfInstanceId = vnfInstanceId;
    return this;
  }

  public MirroringInfo addVnfInstanceIdItem(String vnfInstanceIdItem) {
    this.vnfInstanceId.add(vnfInstanceIdItem);
    return this;
  }

  /**
   * Identifier of the VNF instance from where the data flows are requested to be mirrored. 
   * @return vnfInstanceId
   **/
  @Schema(required = true, description = "Identifier of the VNF instance from where the data flows are requested to be mirrored. ")
      @NotNull

  @Size(min=1)   public List<String> getVnfInstanceId() {
    return vnfInstanceId;
  }

  public void setVnfInstanceId(List<String> vnfInstanceId) {
    this.vnfInstanceId = vnfInstanceId;
  }

  public MirroringInfo cpInstanceId(List<String> cpInstanceId) {
    this.cpInstanceId = cpInstanceId;
    return this;
  }

  public MirroringInfo addCpInstanceIdItem(String cpInstanceIdItem) {
    this.cpInstanceId.add(cpInstanceIdItem);
    return this;
  }

  /**
   * Identifier of the CP instance from where the data flows are mirrored. 
   * @return cpInstanceId
   **/
  @Schema(required = true, description = "Identifier of the CP instance from where the data flows are mirrored. ")
      @NotNull

  @Size(min=1)   public List<String> getCpInstanceId() {
    return cpInstanceId;
  }

  public void setCpInstanceId(List<String> cpInstanceId) {
    this.cpInstanceId = cpInstanceId;
  }

  public MirroringInfo dataFlowData(List<DataFlowData> dataFlowData) {
    this.dataFlowData = dataFlowData;
    return this;
  }

  public MirroringInfo addDataFlowDataItem(DataFlowData dataFlowDataItem) {
    this.dataFlowData.add(dataFlowDataItem);
    return this;
  }

  /**
   * Information about the data flows to be mirrored 
   * @return dataFlowData
   **/
  @Schema(required = true, description = "Information about the data flows to be mirrored ")
      @NotNull
    @Valid
  @Size(min=1)   public List<DataFlowData> getDataFlowData() {
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
    MirroringInfo mirroringInfo = (MirroringInfo) o;
    return Objects.equals(this.mirroringId, mirroringInfo.mirroringId) &&
        Objects.equals(this.mirroringName, mirroringInfo.mirroringName) &&
        Objects.equals(this.description, mirroringInfo.description) &&
        Objects.equals(this.collectorDetails, mirroringInfo.collectorDetails) &&
        Objects.equals(this.vnfInstanceId, mirroringInfo.vnfInstanceId) &&
        Objects.equals(this.cpInstanceId, mirroringInfo.cpInstanceId) &&
        Objects.equals(this.dataFlowData, mirroringInfo.dataFlowData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mirroringId, mirroringName, description, collectorDetails, vnfInstanceId, cpInstanceId, dataFlowData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MirroringInfo {\n");
    
    sb.append("    mirroringId: ").append(toIndentedString(mirroringId)).append("\n");
    sb.append("    mirroringName: ").append(toIndentedString(mirroringName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    collectorDetails: ").append(toIndentedString(collectorDetails)).append("\n");
    sb.append("    vnfInstanceId: ").append(toIndentedString(vnfInstanceId)).append("\n");
    sb.append("    cpInstanceId: ").append(toIndentedString(cpInstanceId)).append("\n");
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
