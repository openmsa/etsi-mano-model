package com.ubiqube.etsi.mano.v451.model.nfvmanocim;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.ChangeAdministrativeStateEnumType;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * A change of administrative state. Shall be present if the state change request refers to the administrative state. See note 1. but not both. 
 */
@Schema(description = "A change of administrative state. Shall be present if the state change request refers to the administrative state. See note 1. but not both. ")
@Validated



public class ChangeStateRequestAdministrativeStateChange   {
  @JsonProperty("administrativeStateAction")
  private ChangeAdministrativeStateEnumType administrativeStateAction = null;

  public ChangeStateRequestAdministrativeStateChange administrativeStateAction(ChangeAdministrativeStateEnumType administrativeStateAction) {
    this.administrativeStateAction = administrativeStateAction;
    return this;
  }

  /**
   * Get administrativeStateAction
   * @return administrativeStateAction
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public ChangeAdministrativeStateEnumType getAdministrativeStateAction() {
    return administrativeStateAction;
  }

  public void setAdministrativeStateAction(ChangeAdministrativeStateEnumType administrativeStateAction) {
    this.administrativeStateAction = administrativeStateAction;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChangeStateRequestAdministrativeStateChange changeStateRequestAdministrativeStateChange = (ChangeStateRequestAdministrativeStateChange) o;
    return Objects.equals(this.administrativeStateAction, changeStateRequestAdministrativeStateChange.administrativeStateAction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(administrativeStateAction);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChangeStateRequestAdministrativeStateChange {\n");
    
    sb.append("    administrativeStateAction: ").append(toIndentedString(administrativeStateAction)).append("\n");
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
