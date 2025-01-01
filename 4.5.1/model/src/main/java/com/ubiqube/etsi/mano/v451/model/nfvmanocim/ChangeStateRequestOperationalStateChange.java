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
package com.ubiqube.etsi.mano.v451.model.nfvmanocim;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.ChangeOperationalStateEnumType;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.StopEnumType;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * A change of operational state. Shall be present if the state change request refers to the operational state. See note 1. but not both. 
 */
@Schema(description = "A change of operational state. Shall be present if the state change request refers to the operational state. See note 1. but not both. ")
@Validated



public class ChangeStateRequestOperationalStateChange   {
  @JsonProperty("operationalStateAction")
  private ChangeOperationalStateEnumType operationalStateAction = null;

  @JsonProperty("stopType")
  private StopEnumType stopType = null;

  @JsonProperty("gracefulStopTimeout")
  private Integer gracefulStopTimeout = null;

  public ChangeStateRequestOperationalStateChange operationalStateAction(ChangeOperationalStateEnumType operationalStateAction) {
    this.operationalStateAction = operationalStateAction;
    return this;
  }

  /**
   * Get operationalStateAction
   * @return operationalStateAction
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    @Valid
    public ChangeOperationalStateEnumType getOperationalStateAction() {
    return operationalStateAction;
  }

  public void setOperationalStateAction(ChangeOperationalStateEnumType operationalStateAction) {
    this.operationalStateAction = operationalStateAction;
  }

  public ChangeStateRequestOperationalStateChange stopType(StopEnumType stopType) {
    this.stopType = stopType;
    return this;
  }

  /**
   * Get stopType
   * @return stopType
   **/
  @Schema(description = "")
  
    @Valid
    public StopEnumType getStopType() {
    return stopType;
  }

  public void setStopType(StopEnumType stopType) {
    this.stopType = stopType;
  }

  public ChangeStateRequestOperationalStateChange gracefulStopTimeout(Integer gracefulStopTimeout) {
    this.gracefulStopTimeout = gracefulStopTimeout;
    return this;
  }

  /**
   * The time internal (in seconds) to wait for the entity to be taken out of service during graceful stop. See note 2. 
   * @return gracefulStopTimeout
   **/
  @Schema(description = "The time internal (in seconds) to wait for the entity to be taken out of service during graceful stop. See note 2. ")
  
    public Integer getGracefulStopTimeout() {
    return gracefulStopTimeout;
  }

  public void setGracefulStopTimeout(Integer gracefulStopTimeout) {
    this.gracefulStopTimeout = gracefulStopTimeout;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChangeStateRequestOperationalStateChange changeStateRequestOperationalStateChange = (ChangeStateRequestOperationalStateChange) o;
    return Objects.equals(this.operationalStateAction, changeStateRequestOperationalStateChange.operationalStateAction) &&
        Objects.equals(this.stopType, changeStateRequestOperationalStateChange.stopType) &&
        Objects.equals(this.gracefulStopTimeout, changeStateRequestOperationalStateChange.gracefulStopTimeout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operationalStateAction, stopType, gracefulStopTimeout);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChangeStateRequestOperationalStateChange {\n");
    
    sb.append("    operationalStateAction: ").append(toIndentedString(operationalStateAction)).append("\n");
    sb.append("    stopType: ").append(toIndentedString(stopType)).append("\n");
    sb.append("    gracefulStopTimeout: ").append(toIndentedString(gracefulStopTimeout)).append("\n");
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
