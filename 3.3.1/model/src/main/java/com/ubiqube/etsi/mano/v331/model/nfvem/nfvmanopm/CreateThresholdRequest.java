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
package com.ubiqube.etsi.mano.v331.model.nfvem.nfvmanopm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v331.model.nfvem.nfvmanopm.ThresholdCriteria;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents a request to create a threshold.  
 */
@Schema(description = "This type represents a request to create a threshold.  ")
@Validated


public class CreateThresholdRequest   {
  @JsonProperty("objectType")
  private String objectType = null;

  @JsonProperty("objectInstanceId")
  private String objectInstanceId = null;

  @JsonProperty("subjObjectInstanceIds")
  @Valid
  private List<String> subjObjectInstanceIds = null;

  @JsonProperty("criteria")
  private ThresholdCriteria criteria = null;

  public CreateThresholdRequest objectType(String objectType) {
    this.objectType = objectType;
    return this;
  }

  /**
   * Type of measured object. The applicable measured object type for a measurement  is defined in clause 8.2 of ETSI GS NFV-IFA 031. 
   * @return objectType
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Type of measured object. The applicable measured object type for a measurement  is defined in clause 8.2 of ETSI GS NFV-IFA 031. ")
      @NotNull

    public String getObjectType() {
    return objectType;
  }

  public void setObjectType(String objectType) {
    this.objectType = objectType;
  }

  public CreateThresholdRequest objectInstanceId(String objectInstanceId) {
    this.objectInstanceId = objectInstanceId;
    return this;
  }

  /**
   * Get objectInstanceId
   * @return objectInstanceId
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    public String getObjectInstanceId() {
    return objectInstanceId;
  }

  public void setObjectInstanceId(String objectInstanceId) {
    this.objectInstanceId = objectInstanceId;
  }

  public CreateThresholdRequest subjObjectInstanceIds(List<String> subjObjectInstanceIds) {
    this.subjObjectInstanceIds = subjObjectInstanceIds;
    return this;
  }

  public CreateThresholdRequest addSubjObjectInstanceIdsItem(String subjObjectInstanceIdsItem) {
    if (this.subjObjectInstanceIds == null) {
      this.subjObjectInstanceIds = new ArrayList<>();
    }
    this.subjObjectInstanceIds.add(subjObjectInstanceIdsItem);
    return this;
  }

  /**
   * Identifiers of the sub-object instances of the measured object instance  associated with this threshold.  May be present if a sub-object is defined in clause 8.2 of ETSI GS NFV-IFA 031 for the related measured object type. If this attribute is absent and a sub-object is defined in clause 8.2 of ETSI  GS NFV-IFA 031 for the related measured object type, thresholds will be set  for all sub-object instances of the measured object instance. 
   * @return subjObjectInstanceIds
   **/
  @Schema(description = "Identifiers of the sub-object instances of the measured object instance  associated with this threshold.  May be present if a sub-object is defined in clause 8.2 of ETSI GS NFV-IFA 031 for the related measured object type. If this attribute is absent and a sub-object is defined in clause 8.2 of ETSI  GS NFV-IFA 031 for the related measured object type, thresholds will be set  for all sub-object instances of the measured object instance. ")
  
    public List<String> getSubjObjectInstanceIds() {
    return subjObjectInstanceIds;
  }

  public void setSubjObjectInstanceIds(List<String> subjObjectInstanceIds) {
    this.subjObjectInstanceIds = subjObjectInstanceIds;
  }

  public CreateThresholdRequest criteria(ThresholdCriteria criteria) {
    this.criteria = criteria;
    return this;
  }

  /**
   * Get criteria
   * @return criteria
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    @Valid
    public ThresholdCriteria getCriteria() {
    return criteria;
  }

  public void setCriteria(ThresholdCriteria criteria) {
    this.criteria = criteria;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateThresholdRequest createThresholdRequest = (CreateThresholdRequest) o;
    return Objects.equals(this.objectType, createThresholdRequest.objectType) &&
        Objects.equals(this.objectInstanceId, createThresholdRequest.objectInstanceId) &&
        Objects.equals(this.subjObjectInstanceIds, createThresholdRequest.subjObjectInstanceIds) &&
        Objects.equals(this.criteria, createThresholdRequest.criteria);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objectType, objectInstanceId, subjObjectInstanceIds, criteria);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateThresholdRequest {\n");
    
    sb.append("    objectType: ").append(toIndentedString(objectType)).append("\n");
    sb.append("    objectInstanceId: ").append(toIndentedString(objectInstanceId)).append("\n");
    sb.append("    subjObjectInstanceIds: ").append(toIndentedString(subjObjectInstanceIds)).append("\n");
    sb.append("    criteria: ").append(toIndentedString(criteria)).append("\n");
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
