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
package com.ubiqube.etsi.mano.v331.model.nfvem.nfvmanocim;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v331.model.nfvem.nfvmanocim.AdministrativeStateEnumType;
import com.ubiqube.etsi.mano.v331.model.nfvem.nfvmanocim.OperationalStateEnumType;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Current values of the state of the peer functional entity. 
 */
@Schema (description= "Current values of the state of the peer functional entity. " )
@Validated
public class CreatePeerEntityRequestPeerEntityState   {
  @JsonProperty("operationalState")
  private OperationalStateEnumType operationalState = null;

  @JsonProperty("administrativeState")
  private AdministrativeStateEnumType administrativeState = null;

  public CreatePeerEntityRequestPeerEntityState operationalState(OperationalStateEnumType operationalState) {
    this.operationalState = operationalState;
    return this;
  }

  /**
   * Get operationalState
   * @return operationalState
  **/
  @Schema(required= true ,description= "" )
      @NotNull

    @Valid
    public OperationalStateEnumType getOperationalState() {
    return operationalState;
  }

  public void setOperationalState(OperationalStateEnumType operationalState) {
    this.operationalState = operationalState;
  }

  public CreatePeerEntityRequestPeerEntityState administrativeState(AdministrativeStateEnumType administrativeState) {
    this.administrativeState = administrativeState;
    return this;
  }

  /**
   * Get administrativeState
   * @return administrativeState
  **/
  @Schema(required= true ,description= "" )
      @NotNull

    @Valid
    public AdministrativeStateEnumType getAdministrativeState() {
    return administrativeState;
  }

  public void setAdministrativeState(AdministrativeStateEnumType administrativeState) {
    this.administrativeState = administrativeState;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreatePeerEntityRequestPeerEntityState createPeerEntityRequestPeerEntityState = (CreatePeerEntityRequestPeerEntityState) o;
    return Objects.equals(this.operationalState, createPeerEntityRequestPeerEntityState.operationalState) &&
        Objects.equals(this.administrativeState, createPeerEntityRequestPeerEntityState.administrativeState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operationalState, administrativeState);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreatePeerEntityRequestPeerEntityState {\n");
    
    sb.append("    operationalState: ").append(toIndentedString(operationalState)).append("\n");
    sb.append("    administrativeState: ").append(toIndentedString(administrativeState)).append("\n");
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
