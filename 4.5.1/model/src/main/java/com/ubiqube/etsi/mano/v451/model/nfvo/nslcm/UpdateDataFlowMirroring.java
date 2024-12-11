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
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents the information on the data flow mirroring associated to the NS instance that is being modified. It shall comply with the provisions defined in table 6.5.3.105-1. NOTE: Updating Data Flow Mirroring can involve one or more following cases: 1) updating the name of data flow mirroring, related to “mirroringName”. 2) updating information description of data flow mirroring, related to “description”. 3) updating the definition about where the mirrored data flow is requested  to be delivered, related to “collectorDetails”. 
 */
@Schema(description = "This type represents the information on the data flow mirroring associated to the NS instance that is being modified. It shall comply with the provisions defined in table 6.5.3.105-1. NOTE: Updating Data Flow Mirroring can involve one or more following cases: 1) updating the name of data flow mirroring, related to “mirroringName”. 2) updating information description of data flow mirroring, related to “description”. 3) updating the definition about where the mirrored data flow is requested  to be delivered, related to “collectorDetails”. ")
@Validated


public class UpdateDataFlowMirroring   {
  @JsonProperty("mirroringId")
  private String mirroringId = null;

  @JsonProperty("mirroringName")
  private String mirroringName = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("collectorDetails")
  private CollectorDetails collectorDetails = null;

  public UpdateDataFlowMirroring mirroringId(String mirroringId) {
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

  public UpdateDataFlowMirroring mirroringName(String mirroringName) {
    this.mirroringName = mirroringName;
    return this;
  }

  /**
   * Name of Data Flow Mirroring. See note. 
   * @return mirroringName
   **/
  @Schema(description = "Name of Data Flow Mirroring. See note. ")
  
    public String getMirroringName() {
    return mirroringName;
  }

  public void setMirroringName(String mirroringName) {
    this.mirroringName = mirroringName;
  }

  public UpdateDataFlowMirroring description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Information description of Data Flow Mirroring. See note.  
   * @return description
   **/
  @Schema(description = "Information description of Data Flow Mirroring. See note.  ")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public UpdateDataFlowMirroring collectorDetails(CollectorDetails collectorDetails) {
    this.collectorDetails = collectorDetails;
    return this;
  }

  /**
   * Get collectorDetails
   * @return collectorDetails
   **/
  @Schema(description = "")
  
    @Valid
    public CollectorDetails getCollectorDetails() {
    return collectorDetails;
  }

  public void setCollectorDetails(CollectorDetails collectorDetails) {
    this.collectorDetails = collectorDetails;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateDataFlowMirroring updateDataFlowMirroring = (UpdateDataFlowMirroring) o;
    return Objects.equals(this.mirroringId, updateDataFlowMirroring.mirroringId) &&
        Objects.equals(this.mirroringName, updateDataFlowMirroring.mirroringName) &&
        Objects.equals(this.description, updateDataFlowMirroring.description) &&
        Objects.equals(this.collectorDetails, updateDataFlowMirroring.collectorDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mirroringId, mirroringName, description, collectorDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateDataFlowMirroring {\n");
    
    sb.append("    mirroringId: ").append(toIndentedString(mirroringId)).append("\n");
    sb.append("    mirroringName: ").append(toIndentedString(mirroringName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    collectorDetails: ").append(toIndentedString(collectorDetails)).append("\n");
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
