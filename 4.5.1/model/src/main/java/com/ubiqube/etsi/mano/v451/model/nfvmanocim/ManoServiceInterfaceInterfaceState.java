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
package com.ubiqube.etsi.mano.v451.model.nfvmanocim;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.AdministrativeStateEnumType;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.InterfaceOperationalStateEnumType;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.UsageStateEnumType;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * State of the NFV-MANO service interface. 
 */
@Schema(description = "State of the NFV-MANO service interface. ")
@Validated



public class ManoServiceInterfaceInterfaceState   {
  @JsonProperty("operationalState")
  private InterfaceOperationalStateEnumType operationalState = null;

  @JsonProperty("administrativeState")
  private AdministrativeStateEnumType administrativeState = null;

  @JsonProperty("usageState")
  private UsageStateEnumType usageState = null;

  public ManoServiceInterfaceInterfaceState operationalState(InterfaceOperationalStateEnumType operationalState) {
    this.operationalState = operationalState;
    return this;
  }

  /**
   * Get operationalState
   * @return operationalState
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public InterfaceOperationalStateEnumType getOperationalState() {
    return operationalState;
  }

  public void setOperationalState(InterfaceOperationalStateEnumType operationalState) {
    this.operationalState = operationalState;
  }

  public ManoServiceInterfaceInterfaceState administrativeState(AdministrativeStateEnumType administrativeState) {
    this.administrativeState = administrativeState;
    return this;
  }

  /**
   * Get administrativeState
   * @return administrativeState
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public AdministrativeStateEnumType getAdministrativeState() {
    return administrativeState;
  }

  public void setAdministrativeState(AdministrativeStateEnumType administrativeState) {
    this.administrativeState = administrativeState;
  }

  public ManoServiceInterfaceInterfaceState usageState(UsageStateEnumType usageState) {
    this.usageState = usageState;
    return this;
  }

  /**
   * Get usageState
   * @return usageState
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public UsageStateEnumType getUsageState() {
    return usageState;
  }

  public void setUsageState(UsageStateEnumType usageState) {
    this.usageState = usageState;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ManoServiceInterfaceInterfaceState manoServiceInterfaceInterfaceState = (ManoServiceInterfaceInterfaceState) o;
    return Objects.equals(this.operationalState, manoServiceInterfaceInterfaceState.operationalState) &&
        Objects.equals(this.administrativeState, manoServiceInterfaceInterfaceState.administrativeState) &&
        Objects.equals(this.usageState, manoServiceInterfaceInterfaceState.usageState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operationalState, administrativeState, usageState);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ManoServiceInterfaceInterfaceState {\n");
    
    sb.append("    operationalState: ").append(toIndentedString(operationalState)).append("\n");
    sb.append("    administrativeState: ").append(toIndentedString(administrativeState)).append("\n");
    sb.append("    usageState: ").append(toIndentedString(usageState)).append("\n");
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
