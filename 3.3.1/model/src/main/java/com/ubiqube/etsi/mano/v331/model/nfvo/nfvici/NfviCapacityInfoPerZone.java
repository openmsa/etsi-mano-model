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
import com.ubiqube.etsi.mano.v331.model.nfvo.nfvici.NfviCapacityMeasurement;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type defines the format of the NFVI capacity information on a per resource zone basis. The type shall comply with the provisions defined in table 10.5.2.5-1. 
 */
@Schema(description = "This type defines the format of the NFVI capacity information on a per resource zone basis. The type shall comply with the provisions defined in table 10.5.2.5-1. ")
@Validated


public class NfviCapacityInfoPerZone   {
  @JsonProperty("resourceZoneId")
  private String resourceZoneId = null;

  @JsonProperty("capacityMeasurements")
  @Valid
  private List<NfviCapacityMeasurement> capacityMeasurements = new ArrayList<>();

  public NfviCapacityInfoPerZone resourceZoneId(String resourceZoneId) {
    this.resourceZoneId = resourceZoneId;
    return this;
  }

  /**
   * Get resourceZoneId
   * @return resourceZoneId
   **/
  @Schema(description = "")
  
    public String getResourceZoneId() {
    return resourceZoneId;
  }

  public void setResourceZoneId(String resourceZoneId) {
    this.resourceZoneId = resourceZoneId;
  }

  public NfviCapacityInfoPerZone capacityMeasurements(List<NfviCapacityMeasurement> capacityMeasurements) {
    this.capacityMeasurements = capacityMeasurements;
    return this;
  }

  public NfviCapacityInfoPerZone addCapacityMeasurementsItem(NfviCapacityMeasurement capacityMeasurementsItem) {
    this.capacityMeasurements.add(capacityMeasurementsItem);
    return this;
  }

  /**
   * Capacity measurement on a per resource type basis. 
   * @return capacityMeasurements
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Capacity measurement on a per resource type basis. ")
      @NotNull
    @Valid
    public List<NfviCapacityMeasurement> getCapacityMeasurements() {
    return capacityMeasurements;
  }

  public void setCapacityMeasurements(List<NfviCapacityMeasurement> capacityMeasurements) {
    this.capacityMeasurements = capacityMeasurements;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NfviCapacityInfoPerZone nfviCapacityInfoPerZone = (NfviCapacityInfoPerZone) o;
    return Objects.equals(this.resourceZoneId, nfviCapacityInfoPerZone.resourceZoneId) &&
        Objects.equals(this.capacityMeasurements, nfviCapacityInfoPerZone.capacityMeasurements);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resourceZoneId, capacityMeasurements);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NfviCapacityInfoPerZone {\n");
    
    sb.append("    resourceZoneId: ").append(toIndentedString(resourceZoneId)).append("\n");
    sb.append("    capacityMeasurements: ").append(toIndentedString(capacityMeasurements)).append("\n");
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
