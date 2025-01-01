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
package com.ubiqube.etsi.mano.v361.model.nfvo.nslcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Map;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents the information used to heal a NS. It shall comply with the provisions defined in Table 6.5.3.43-1. NOTE: Either the actionsHealing or healScript attribute shall be present, not both attributes. 
 */
@Schema(description = "This type represents the information used to heal a NS. It shall comply with the provisions defined in Table 6.5.3.43-1. NOTE: Either the actionsHealing or healScript attribute shall be present, not both attributes. ")
@Validated


public class HealNsData  implements OneOfHealNsData {
  /**
   * Indicates the degree of healing. Possible values include: - HEAL_RESTORE: Complete the healing of the NS restoring the state of the NS before the failure occurred - HEAL_QOS: Complete the healing of the NS based on the newest QoS values - HEAL_RESET: Complete the healing of the NS resetting to the original instantiation state of the NS - PARTIAL_HEALING 
   */
  public enum DegreeHealingEnum {
    HEAL_RESTORE("HEAL_RESTORE"),
    
    HEAL_QOS("HEAL_QOS"),
    
    HEAL_RESET("HEAL_RESET"),
    
    PARTIAL_HEALING("PARTIAL_HEALING");

    private String value;

    DegreeHealingEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static DegreeHealingEnum fromValue(String text) {
      for (DegreeHealingEnum b : DegreeHealingEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("degreeHealing")
  private DegreeHealingEnum degreeHealing = null;

  @JsonProperty("actionsHealing")
  @Valid
  private List<String> actionsHealing = null;

  @JsonProperty("healScript")
  private String healScript = null;

  @JsonProperty("additionalParamsforNs")
  private Map<String, String> additionalParamsforNs = null;

  public HealNsData degreeHealing(DegreeHealingEnum degreeHealing) {
    this.degreeHealing = degreeHealing;
    return this;
  }

  /**
   * Indicates the degree of healing. Possible values include: - HEAL_RESTORE: Complete the healing of the NS restoring the state of the NS before the failure occurred - HEAL_QOS: Complete the healing of the NS based on the newest QoS values - HEAL_RESET: Complete the healing of the NS resetting to the original instantiation state of the NS - PARTIAL_HEALING 
   * @return degreeHealing
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Indicates the degree of healing. Possible values include: - HEAL_RESTORE: Complete the healing of the NS restoring the state of the NS before the failure occurred - HEAL_QOS: Complete the healing of the NS based on the newest QoS values - HEAL_RESET: Complete the healing of the NS resetting to the original instantiation state of the NS - PARTIAL_HEALING ")
      @NotNull

    public DegreeHealingEnum getDegreeHealing() {
    return degreeHealing;
  }

  public void setDegreeHealing(DegreeHealingEnum degreeHealing) {
    this.degreeHealing = degreeHealing;
  }

  public HealNsData actionsHealing(List<String> actionsHealing) {
    this.actionsHealing = actionsHealing;
    return this;
  }

  public HealNsData addActionsHealingItem(String actionsHealingItem) {
    if (this.actionsHealing == null) {
      this.actionsHealing = new ArrayList<>();
    }
    this.actionsHealing.add(actionsHealingItem);
    return this;
  }

  /**
   * Used to specify dedicated healing actions in a particular order (e.g. as a script). The actionsHealing attribute can be used to provide a specific script whose content and actions might only be possible to be derived during runtime. See note. 
   * @return actionsHealing
   **/
  @Schema(description = "Used to specify dedicated healing actions in a particular order (e.g. as a script). The actionsHealing attribute can be used to provide a specific script whose content and actions might only be possible to be derived during runtime. See note. ")
  
    public List<String> getActionsHealing() {
    return actionsHealing;
  }

  public void setActionsHealing(List<String> actionsHealing) {
    this.actionsHealing = actionsHealing;
  }

  public HealNsData healScript(String healScript) {
    this.healScript = healScript;
    return this;
  }

  /**
   * Get healScript
   * @return healScript
   **/
  @Schema(description = "")
  
    public String getHealScript() {
    return healScript;
  }

  public void setHealScript(String healScript) {
    this.healScript = healScript;
  }

  public HealNsData additionalParamsforNs(Map<String, String> additionalParamsforNs) {
    this.additionalParamsforNs = additionalParamsforNs;
    return this;
  }

  /**
   * Get additionalParamsforNs
   * @return additionalParamsforNs
   **/
  @Schema(description = "")
  
    @Valid
    public Map<String, String> getAdditionalParamsforNs() {
    return additionalParamsforNs;
  }

  public void setAdditionalParamsforNs(Map<String, String> additionalParamsforNs) {
    this.additionalParamsforNs = additionalParamsforNs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HealNsData healNsData = (HealNsData) o;
    return Objects.equals(this.degreeHealing, healNsData.degreeHealing) &&
        Objects.equals(this.actionsHealing, healNsData.actionsHealing) &&
        Objects.equals(this.healScript, healNsData.healScript) &&
        Objects.equals(this.additionalParamsforNs, healNsData.additionalParamsforNs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(degreeHealing, actionsHealing, healScript, additionalParamsforNs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HealNsData {\n");
    
    sb.append("    degreeHealing: ").append(toIndentedString(degreeHealing)).append("\n");
    sb.append("    actionsHealing: ").append(toIndentedString(actionsHealing)).append("\n");
    sb.append("    healScript: ").append(toIndentedString(healScript)).append("\n");
    sb.append("    additionalParamsforNs: ").append(toIndentedString(additionalParamsforNs)).append("\n");
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
