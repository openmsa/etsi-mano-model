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
package com.ubiqube.etsi.mano.v331.model.nfvo.nfvici;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v331.model.nfvo.nfvici.NfviCapacityResourceTypeEnumeration;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type defines the format of the NFVI capacity information on a per resource type basis. The type shall comply with the provisions defined in table 10.5.2.6-1. 
 */
@Schema(description = "This type defines the format of the NFVI capacity information on a per resource type basis. The type shall comply with the provisions defined in table 10.5.2.6-1. ")
@Validated


public class NfviCapacityMeasurement   {
  @JsonProperty("resourceType")
  private NfviCapacityResourceTypeEnumeration resourceType = null;

  @JsonProperty("capacityMeasurementName")
  private String capacityMeasurementName = null;

  @JsonProperty("totalCapacity")
  private Object totalCapacity = null;

  @JsonProperty("allocatedCapacity")
  private Object allocatedCapacity = null;

  @JsonProperty("reservedCapacity")
  private Object reservedCapacity = null;

  @JsonProperty("availableCapacity")
  private Object availableCapacity = null;

  public NfviCapacityMeasurement resourceType(NfviCapacityResourceTypeEnumeration resourceType) {
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

  public NfviCapacityMeasurement capacityMeasurementName(String capacityMeasurementName) {
    this.capacityMeasurementName = capacityMeasurementName;
    return this;
  }

  /**
   * Name of the capacity measurement. Different resource types can have different associated capacity measurements, typically associated to different sub-types of the resource type. The present document and referred documents do not specify the capacity measurements, thus the capacity measurement names are not specified in the present document version. 
   * @return capacityMeasurementName
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Name of the capacity measurement. Different resource types can have different associated capacity measurements, typically associated to different sub-types of the resource type. The present document and referred documents do not specify the capacity measurements, thus the capacity measurement names are not specified in the present document version. ")
      @NotNull

    public String getCapacityMeasurementName() {
    return capacityMeasurementName;
  }

  public void setCapacityMeasurementName(String capacityMeasurementName) {
    this.capacityMeasurementName = capacityMeasurementName;
  }

  public NfviCapacityMeasurement totalCapacity(Object totalCapacity) {
    this.totalCapacity = totalCapacity;
    return this;
  }

  /**
   * The total capacity. 
   * @return totalCapacity
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "The total capacity. ")
      @NotNull

    public Object getTotalCapacity() {
    return totalCapacity;
  }

  public void setTotalCapacity(Object totalCapacity) {
    this.totalCapacity = totalCapacity;
  }

  public NfviCapacityMeasurement allocatedCapacity(Object allocatedCapacity) {
    this.allocatedCapacity = allocatedCapacity;
    return this;
  }

  /**
   * The allocated/used capacity. 
   * @return allocatedCapacity
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "The allocated/used capacity. ")
      @NotNull

    public Object getAllocatedCapacity() {
    return allocatedCapacity;
  }

  public void setAllocatedCapacity(Object allocatedCapacity) {
    this.allocatedCapacity = allocatedCapacity;
  }

  public NfviCapacityMeasurement reservedCapacity(Object reservedCapacity) {
    this.reservedCapacity = reservedCapacity;
    return this;
  }

  /**
   * The reserved capacity. Shall be present if the capacity measurement relates to a resource type and (and sub-type) that is reservable. 
   * @return reservedCapacity
   **/
  @Schema(description = "The reserved capacity. Shall be present if the capacity measurement relates to a resource type and (and sub-type) that is reservable. ")
  
    public Object getReservedCapacity() {
    return reservedCapacity;
  }

  public void setReservedCapacity(Object reservedCapacity) {
    this.reservedCapacity = reservedCapacity;
  }

  public NfviCapacityMeasurement availableCapacity(Object availableCapacity) {
    this.availableCapacity = availableCapacity;
    return this;
  }

  /**
   * The available capacity. 
   * @return availableCapacity
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "The available capacity. ")
      @NotNull

    public Object getAvailableCapacity() {
    return availableCapacity;
  }

  public void setAvailableCapacity(Object availableCapacity) {
    this.availableCapacity = availableCapacity;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NfviCapacityMeasurement nfviCapacityMeasurement = (NfviCapacityMeasurement) o;
    return Objects.equals(this.resourceType, nfviCapacityMeasurement.resourceType) &&
        Objects.equals(this.capacityMeasurementName, nfviCapacityMeasurement.capacityMeasurementName) &&
        Objects.equals(this.totalCapacity, nfviCapacityMeasurement.totalCapacity) &&
        Objects.equals(this.allocatedCapacity, nfviCapacityMeasurement.allocatedCapacity) &&
        Objects.equals(this.reservedCapacity, nfviCapacityMeasurement.reservedCapacity) &&
        Objects.equals(this.availableCapacity, nfviCapacityMeasurement.availableCapacity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resourceType, capacityMeasurementName, totalCapacity, allocatedCapacity, reservedCapacity, availableCapacity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NfviCapacityMeasurement {\n");
    
    sb.append("    resourceType: ").append(toIndentedString(resourceType)).append("\n");
    sb.append("    capacityMeasurementName: ").append(toIndentedString(capacityMeasurementName)).append("\n");
    sb.append("    totalCapacity: ").append(toIndentedString(totalCapacity)).append("\n");
    sb.append("    allocatedCapacity: ").append(toIndentedString(allocatedCapacity)).append("\n");
    sb.append("    reservedCapacity: ").append(toIndentedString(reservedCapacity)).append("\n");
    sb.append("    availableCapacity: ").append(toIndentedString(availableCapacity)).append("\n");
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
