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
import com.ubiqube.etsi.mano.v451.model.nfvo.nslcm.DeployableModulesInConstituentVnf;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type specifies an existing NS instance for which the DF needs to be changed. This specifies the new DF, the instantiationLevel of the new DF that may be used and the additional parameters as input for the flavour change. It shall comply with the provisions defined in Table 6.5.3.39-1. 
 */
@Schema(description = "This type specifies an existing NS instance for which the DF needs to be changed. This specifies the new DF, the instantiationLevel of the new DF that may be used and the additional parameters as input for the flavour change. It shall comply with the provisions defined in Table 6.5.3.39-1. ")
@Validated


public class ChangeNsFlavourData   {
  @JsonProperty("newNsFlavourId")
  private String newNsFlavourId = null;

  @JsonProperty("instantiationLevelId")
  private String instantiationLevelId = null;

  @JsonProperty("deployableModulesInConstituentVnf")
  @Valid
  private List<DeployableModulesInConstituentVnf> deployableModulesInConstituentVnf = null;

  public ChangeNsFlavourData newNsFlavourId(String newNsFlavourId) {
    this.newNsFlavourId = newNsFlavourId;
    return this;
  }

  /**
   * Get newNsFlavourId
   * @return newNsFlavourId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getNewNsFlavourId() {
    return newNsFlavourId;
  }

  public void setNewNsFlavourId(String newNsFlavourId) {
    this.newNsFlavourId = newNsFlavourId;
  }

  public ChangeNsFlavourData instantiationLevelId(String instantiationLevelId) {
    this.instantiationLevelId = instantiationLevelId;
    return this;
  }

  /**
   * Get instantiationLevelId
   * @return instantiationLevelId
   **/
  @Schema(description = "")
  
    public String getInstantiationLevelId() {
    return instantiationLevelId;
  }

  public void setInstantiationLevelId(String instantiationLevelId) {
    this.instantiationLevelId = instantiationLevelId;
  }

  public ChangeNsFlavourData deployableModulesInConstituentVnf(List<DeployableModulesInConstituentVnf> deployableModulesInConstituentVnf) {
    this.deployableModulesInConstituentVnf = deployableModulesInConstituentVnf;
    return this;
  }

  public ChangeNsFlavourData addDeployableModulesInConstituentVnfItem(DeployableModulesInConstituentVnf deployableModulesInConstituentVnfItem) {
    if (this.deployableModulesInConstituentVnf == null) {
      this.deployableModulesInConstituentVnf = new ArrayList<>();
    }
    this.deployableModulesInConstituentVnf.add(deployableModulesInConstituentVnfItem);
    return this;
  }

  /**
   * Indicates the selected deployable modules of a VNF instance which is a constituent of the NS instance. If this attribute is not present, the deployable modules that were selected in the VNF instance prior to the NS LCM operation remain valid. 
   * @return deployableModulesInConstituentVnf
   **/
  @Schema(description = "Indicates the selected deployable modules of a VNF instance which is a constituent of the NS instance. If this attribute is not present, the deployable modules that were selected in the VNF instance prior to the NS LCM operation remain valid. ")
      @Valid
    public List<DeployableModulesInConstituentVnf> getDeployableModulesInConstituentVnf() {
    return deployableModulesInConstituentVnf;
  }

  public void setDeployableModulesInConstituentVnf(List<DeployableModulesInConstituentVnf> deployableModulesInConstituentVnf) {
    this.deployableModulesInConstituentVnf = deployableModulesInConstituentVnf;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChangeNsFlavourData changeNsFlavourData = (ChangeNsFlavourData) o;
    return Objects.equals(this.newNsFlavourId, changeNsFlavourData.newNsFlavourId) &&
        Objects.equals(this.instantiationLevelId, changeNsFlavourData.instantiationLevelId) &&
        Objects.equals(this.deployableModulesInConstituentVnf, changeNsFlavourData.deployableModulesInConstituentVnf);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newNsFlavourId, instantiationLevelId, deployableModulesInConstituentVnf);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChangeNsFlavourData {\n");
    
    sb.append("    newNsFlavourId: ").append(toIndentedString(newNsFlavourId)).append("\n");
    sb.append("    instantiationLevelId: ").append(toIndentedString(instantiationLevelId)).append("\n");
    sb.append("    deployableModulesInConstituentVnf: ").append(toIndentedString(deployableModulesInConstituentVnf)).append("\n");
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
