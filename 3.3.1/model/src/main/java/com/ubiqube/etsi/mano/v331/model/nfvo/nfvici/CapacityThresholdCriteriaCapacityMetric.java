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
package com.ubiqube.etsi.mano.v331.model.nfvo.nfvici;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ubiqube.etsi.mano.v331.model.nfvo.nfvici.NfviCapacityResourceTypeEnumeration;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Defines the capacity metric for which the threshold applies. 
 */
@Schema(description = "Defines the capacity metric for which the threshold applies. ")
@Validated


public class CapacityThresholdCriteriaCapacityMetric   {
  @JsonProperty("resourceType")
  private NfviCapacityResourceTypeEnumeration resourceType = null;

  @JsonProperty("capacityMeasurementName")
  private String capacityMeasurementName = null;

  /**
   * The type of capacity for the threshold. Permitted values: - TOTAL: for total capacity. - ALLOCATED: for allocated/used capacity. - RESERVED: for reserved capacity. - AVAILABLE: for available capacity. 
   */
  public enum CapacityTypeEnum {
    TOTAL("TOTAL"),
    
    ALLOCATED("ALLOCATED"),
    
    RESERVED("RESERVED"),
    
    AVAILABLE("AVAILABLE");

    private String value;

    CapacityTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CapacityTypeEnum fromValue(String text) {
      for (CapacityTypeEnum b : CapacityTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("capacityType")
  private CapacityTypeEnum capacityType = null;

  public CapacityThresholdCriteriaCapacityMetric resourceType(NfviCapacityResourceTypeEnumeration resourceType) {
    this.resourceType = resourceType;
    return this;
  }

  /**
   * Get resourceType
   * @return resourceType
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    @Valid
    public NfviCapacityResourceTypeEnumeration getResourceType() {
    return resourceType;
  }

  public void setResourceType(NfviCapacityResourceTypeEnumeration resourceType) {
    this.resourceType = resourceType;
  }

  public CapacityThresholdCriteriaCapacityMetric capacityMeasurementName(String capacityMeasurementName) {
    this.capacityMeasurementName = capacityMeasurementName;
    return this;
  }

  /**
   * Name of the capacity measurement. Different resource types can have different associated capacity measurements, typically associated to different sub-types of the resource type. 
   * @return capacityMeasurementName
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Name of the capacity measurement. Different resource types can have different associated capacity measurements, typically associated to different sub-types of the resource type. ")
      @NotNull

    public String getCapacityMeasurementName() {
    return capacityMeasurementName;
  }

  public void setCapacityMeasurementName(String capacityMeasurementName) {
    this.capacityMeasurementName = capacityMeasurementName;
  }

  public CapacityThresholdCriteriaCapacityMetric capacityType(CapacityTypeEnum capacityType) {
    this.capacityType = capacityType;
    return this;
  }

  /**
   * The type of capacity for the threshold. Permitted values: - TOTAL: for total capacity. - ALLOCATED: for allocated/used capacity. - RESERVED: for reserved capacity. - AVAILABLE: for available capacity. 
   * @return capacityType
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "The type of capacity for the threshold. Permitted values: - TOTAL: for total capacity. - ALLOCATED: for allocated/used capacity. - RESERVED: for reserved capacity. - AVAILABLE: for available capacity. ")
      @NotNull

    public CapacityTypeEnum getCapacityType() {
    return capacityType;
  }

  public void setCapacityType(CapacityTypeEnum capacityType) {
    this.capacityType = capacityType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CapacityThresholdCriteriaCapacityMetric capacityThresholdCriteriaCapacityMetric = (CapacityThresholdCriteriaCapacityMetric) o;
    return Objects.equals(this.resourceType, capacityThresholdCriteriaCapacityMetric.resourceType) &&
        Objects.equals(this.capacityMeasurementName, capacityThresholdCriteriaCapacityMetric.capacityMeasurementName) &&
        Objects.equals(this.capacityType, capacityThresholdCriteriaCapacityMetric.capacityType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resourceType, capacityMeasurementName, capacityType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CapacityThresholdCriteriaCapacityMetric {\n");
    
    sb.append("    resourceType: ").append(toIndentedString(resourceType)).append("\n");
    sb.append("    capacityMeasurementName: ").append(toIndentedString(capacityMeasurementName)).append("\n");
    sb.append("    capacityType: ").append(toIndentedString(capacityType)).append("\n");
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
