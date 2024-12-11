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
package com.ubiqube.etsi.mano.v331.model.em.vnffm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v331.model.em.vnffm.PerceivedSeverityType;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents the escalated value of the perceived severity for an alarm. 
 */
@Schema(description = "This type represents the escalated value of the perceived severity for an alarm. ")
@Validated


public class PerceivedSeverityRequest   {
  @JsonProperty("proposedPerceivedSeverity")
  private PerceivedSeverityType proposedPerceivedSeverity = null;

  public PerceivedSeverityRequest proposedPerceivedSeverity(PerceivedSeverityType proposedPerceivedSeverity) {
    this.proposedPerceivedSeverity = proposedPerceivedSeverity;
    return this;
  }

  /**
   * Get proposedPerceivedSeverity
   * @return proposedPerceivedSeverity
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    @Valid
    public PerceivedSeverityType getProposedPerceivedSeverity() {
    return proposedPerceivedSeverity;
  }

  public void setProposedPerceivedSeverity(PerceivedSeverityType proposedPerceivedSeverity) {
    this.proposedPerceivedSeverity = proposedPerceivedSeverity;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PerceivedSeverityRequest perceivedSeverityRequest = (PerceivedSeverityRequest) o;
    return Objects.equals(this.proposedPerceivedSeverity, perceivedSeverityRequest.proposedPerceivedSeverity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(proposedPerceivedSeverity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PerceivedSeverityRequest {\n");
    
    sb.append("    proposedPerceivedSeverity: ").append(toIndentedString(proposedPerceivedSeverity)).append("\n");
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
