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
package com.ubiqube.etsi.mano.nfvo.v451.model.nslcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents the input information to indicate the selected deployable modules of a VNF instance. 
 */
@Schema(description = "This type represents the input information to indicate the selected deployable modules of a VNF instance. ")
@Validated


public class DeployableModulesInConstituentVnf   {
  @JsonProperty("profileId")
  private String profileId = null;

  @JsonProperty("selectedDeployableModule")
  @Valid
  private List<String> selectedDeployableModule = new ArrayList<>();

  public DeployableModulesInConstituentVnf profileId(String profileId) {
    this.profileId = profileId;
    return this;
  }

  /**
   * Get profileId
   * @return profileId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getProfileId() {
    return profileId;
  }

  public void setProfileId(String profileId) {
    this.profileId = profileId;
  }

  public DeployableModulesInConstituentVnf selectedDeployableModule(List<String> selectedDeployableModule) {
    this.selectedDeployableModule = selectedDeployableModule;
    return this;
  }

  public DeployableModulesInConstituentVnf addSelectedDeployableModuleItem(String selectedDeployableModuleItem) {
    this.selectedDeployableModule.add(selectedDeployableModuleItem);
    return this;
  }

  /**
   * References a selected deployable module, as defined in the VNFD, for the VNF instances created from the VNF profile indicated in profileId attribute. 
   * @return selectedDeployableModule
   **/
  @Schema(required = true, description = "References a selected deployable module, as defined in the VNFD, for the VNF instances created from the VNF profile indicated in profileId attribute. ")
      @NotNull

    public List<String> getSelectedDeployableModule() {
    return selectedDeployableModule;
  }

  public void setSelectedDeployableModule(List<String> selectedDeployableModule) {
    this.selectedDeployableModule = selectedDeployableModule;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeployableModulesInConstituentVnf deployableModulesInConstituentVnf = (DeployableModulesInConstituentVnf) o;
    return Objects.equals(this.profileId, deployableModulesInConstituentVnf.profileId) &&
        Objects.equals(this.selectedDeployableModule, deployableModulesInConstituentVnf.selectedDeployableModule);
  }

  @Override
  public int hashCode() {
    return Objects.hash(profileId, selectedDeployableModule);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeployableModulesInConstituentVnf {\n");
    
    sb.append("    profileId: ").append(toIndentedString(profileId)).append("\n");
    sb.append("    selectedDeployableModule: ").append(toIndentedString(selectedDeployableModule)).append("\n");
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
