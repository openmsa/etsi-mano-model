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
package com.ubiqube.etsi.mano.v451.model.nfvo.nslcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v451.model.nfvo.nslcm.PnfExtCpInfo;
import com.ubiqube.etsi.mano.v451.model.nfvo.nslcm.VersionDependency;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents the information about a PNF that is part of an NS instance.  It shall comply with the provisions defined in Table 6.5.3.13-1. 
 */
@Schema(description = "This type represents the information about a PNF that is part of an NS instance.  It shall comply with the provisions defined in Table 6.5.3.13-1. ")
@Validated


public class PnfInfo   {
  @JsonProperty("pnfId")
  private String pnfId = null;

  @JsonProperty("pnfName")
  private String pnfName = null;

  @JsonProperty("pnfdId")
  private String pnfdId = null;

  @JsonProperty("versionDependency")
  @Valid
  private List<VersionDependency> versionDependency = null;

  @JsonProperty("pnfdInfoId")
  private String pnfdInfoId = null;

  @JsonProperty("pnfProfileId")
  private String pnfProfileId = null;

  @JsonProperty("cpInfo")
  private PnfExtCpInfo cpInfo = null;

  public PnfInfo pnfId(String pnfId) {
    this.pnfId = pnfId;
    return this;
  }

  /**
   * Get pnfId
   * @return pnfId
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    public String getPnfId() {
    return pnfId;
  }

  public void setPnfId(String pnfId) {
    this.pnfId = pnfId;
  }

  public PnfInfo pnfName(String pnfName) {
    this.pnfName = pnfName;
    return this;
  }

  /**
   * Name of the PNF. 
   * @return pnfName
   **/
  @Schema(description = "Name of the PNF. ")
  
    public String getPnfName() {
    return pnfName;
  }

  public void setPnfName(String pnfName) {
    this.pnfName = pnfName;
  }

  public PnfInfo pnfdId(String pnfdId) {
    this.pnfdId = pnfdId;
    return this;
  }

  /**
   * Get pnfdId
   * @return pnfdId
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    public String getPnfdId() {
    return pnfdId;
  }

  public void setPnfdId(String pnfdId) {
    this.pnfdId = pnfdId;
  }

  public PnfInfo versionDependency(List<VersionDependency> versionDependency) {
    this.versionDependency = versionDependency;
    return this;
  }

  public PnfInfo addVersionDependencyItem(VersionDependency versionDependencyItem) {
    if (this.versionDependency == null) {
      this.versionDependency = new ArrayList<>();
    }
    this.versionDependency.add(versionDependencyItem);
    return this;
  }

  /**
   * Describes version dependencies currently valid for the PNF.  Identifies versions of descriptors of other constituents in the NSD upon which the PNF depends. The dependencies may be described for the PNFD referenced in this PnfInfo with pnfdId and for PNFDs with the same \"pnfdExtInvariantId\". There shall not be more than one versionDependency present with the same dependentConstituentId. 
   * @return versionDependency
   **/
  @Schema(description = "Describes version dependencies currently valid for the PNF.  Identifies versions of descriptors of other constituents in the NSD upon which the PNF depends. The dependencies may be described for the PNFD referenced in this PnfInfo with pnfdId and for PNFDs with the same \"pnfdExtInvariantId\". There shall not be more than one versionDependency present with the same dependentConstituentId. ")
      @Valid
    public List<VersionDependency> getVersionDependency() {
    return versionDependency;
  }

  public void setVersionDependency(List<VersionDependency> versionDependency) {
    this.versionDependency = versionDependency;
  }

  public PnfInfo pnfdInfoId(String pnfdInfoId) {
    this.pnfdInfoId = pnfdInfoId;
    return this;
  }

  /**
   * Get pnfdInfoId
   * @return pnfdInfoId
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    public String getPnfdInfoId() {
    return pnfdInfoId;
  }

  public void setPnfdInfoId(String pnfdInfoId) {
    this.pnfdInfoId = pnfdInfoId;
  }

  public PnfInfo pnfProfileId(String pnfProfileId) {
    this.pnfProfileId = pnfProfileId;
    return this;
  }

  /**
   * Get pnfProfileId
   * @return pnfProfileId
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    public String getPnfProfileId() {
    return pnfProfileId;
  }

  public void setPnfProfileId(String pnfProfileId) {
    this.pnfProfileId = pnfProfileId;
  }

  public PnfInfo cpInfo(PnfExtCpInfo cpInfo) {
    this.cpInfo = cpInfo;
    return this;
  }

  /**
   * Get cpInfo
   * @return cpInfo
   **/
  @Schema(description = "")
  
    @Valid
    public PnfExtCpInfo getCpInfo() {
    return cpInfo;
  }

  public void setCpInfo(PnfExtCpInfo cpInfo) {
    this.cpInfo = cpInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PnfInfo pnfInfo = (PnfInfo) o;
    return Objects.equals(this.pnfId, pnfInfo.pnfId) &&
        Objects.equals(this.pnfName, pnfInfo.pnfName) &&
        Objects.equals(this.pnfdId, pnfInfo.pnfdId) &&
        Objects.equals(this.versionDependency, pnfInfo.versionDependency) &&
        Objects.equals(this.pnfdInfoId, pnfInfo.pnfdInfoId) &&
        Objects.equals(this.pnfProfileId, pnfInfo.pnfProfileId) &&
        Objects.equals(this.cpInfo, pnfInfo.cpInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pnfId, pnfName, pnfdId, versionDependency, pnfdInfoId, pnfProfileId, cpInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PnfInfo {\n");
    
    sb.append("    pnfId: ").append(toIndentedString(pnfId)).append("\n");
    sb.append("    pnfName: ").append(toIndentedString(pnfName)).append("\n");
    sb.append("    pnfdId: ").append(toIndentedString(pnfdId)).append("\n");
    sb.append("    versionDependency: ").append(toIndentedString(versionDependency)).append("\n");
    sb.append("    pnfdInfoId: ").append(toIndentedString(pnfdInfoId)).append("\n");
    sb.append("    pnfProfileId: ").append(toIndentedString(pnfProfileId)).append("\n");
    sb.append("    cpInfo: ").append(toIndentedString(cpInfo)).append("\n");
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
