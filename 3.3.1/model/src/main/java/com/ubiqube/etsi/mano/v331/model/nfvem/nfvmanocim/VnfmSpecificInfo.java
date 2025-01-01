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
package com.ubiqube.etsi.mano.v331.model.nfvem.nfvmanocim;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ubiqube.etsi.mano.v331.model.nfvem.nfvmanocim.VnfmSpecificInfoSupportedVnfdFormats;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents information attributes specific to a VNFM entity,  and that can be relevant to more than one NFV-MANO service offered by  a VNFM entity. 
 */
@Schema (description= "This type represents information attributes specific to a VNFM entity,  and that can be relevant to more than one NFV-MANO service offered by  a VNFM entity. " )
@Validated
public class VnfmSpecificInfo   {
  /**
   * The supported resource management modes of the VNFM. Permitted values:   - DIRECT: The VNFM supports direct mode only.   - INDIRECT: The VNFM supports indirect mode only.   - BOTH: The VNFM supports both direct and indirect mode. 
   */
  public enum ResoruceMgmtModeSupportEnum {
    DIRECT("DIRECT"),
    
    INDIRECT("INDIRECT"),
    
    BOTH("BOTH");

    private String value;

    ResoruceMgmtModeSupportEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ResoruceMgmtModeSupportEnum fromValue(String text) {
      for (ResoruceMgmtModeSupportEnum b : ResoruceMgmtModeSupportEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("resoruceMgmtModeSupport")
  private ResoruceMgmtModeSupportEnum resoruceMgmtModeSupport = null;

  @JsonProperty("managedVnfInstanceInfos")
  @Valid
  private List<String> managedVnfInstanceInfos = new ArrayList<>();

  @JsonProperty("supportedVnfdFormats")
  @Valid
  private List<VnfmSpecificInfoSupportedVnfdFormats> supportedVnfdFormats = new ArrayList<>();

  public VnfmSpecificInfo resoruceMgmtModeSupport(ResoruceMgmtModeSupportEnum resoruceMgmtModeSupport) {
    this.resoruceMgmtModeSupport = resoruceMgmtModeSupport;
    return this;
  }

  /**
   * The supported resource management modes of the VNFM. Permitted values:   - DIRECT: The VNFM supports direct mode only.   - INDIRECT: The VNFM supports indirect mode only.   - BOTH: The VNFM supports both direct and indirect mode. 
   * @return resoruceMgmtModeSupport
  **/
  @Schema(required= true ,description= "The supported resource management modes of the VNFM. Permitted values:   - DIRECT: The VNFM supports direct mode only.   - INDIRECT: The VNFM supports indirect mode only.   - BOTH: The VNFM supports both direct and indirect mode. " )
      @NotNull

    public ResoruceMgmtModeSupportEnum getResoruceMgmtModeSupport() {
    return resoruceMgmtModeSupport;
  }

  public void setResoruceMgmtModeSupport(ResoruceMgmtModeSupportEnum resoruceMgmtModeSupport) {
    this.resoruceMgmtModeSupport = resoruceMgmtModeSupport;
  }

  public VnfmSpecificInfo managedVnfInstanceInfos(List<String> managedVnfInstanceInfos) {
    this.managedVnfInstanceInfos = managedVnfInstanceInfos;
    return this;
  }

  public VnfmSpecificInfo addManagedVnfInstanceInfosItem(String managedVnfInstanceInfosItem) {
    this.managedVnfInstanceInfos.add(managedVnfInstanceInfosItem);
    return this;
  }

  /**
   * The kinds of VNF instances that can be managed, e.g. to determine the  compatibility of a VNF with certain VNFM according to the vnfmInfo  attribute in the VNFD (see table 7.1.2.2-1 in ETSI GS NFV-IFA 011). 
   * @return managedVnfInstanceInfos
  **/
  @Schema(required= true ,description= "The kinds of VNF instances that can be managed, e.g. to determine the  compatibility of a VNF with certain VNFM according to the vnfmInfo  attribute in the VNFD (see table 7.1.2.2-1 in ETSI GS NFV-IFA 011). " )
      @NotNull

  @Size(min=1)   public List<String> getManagedVnfInstanceInfos() {
    return managedVnfInstanceInfos;
  }

  public void setManagedVnfInstanceInfos(List<String> managedVnfInstanceInfos) {
    this.managedVnfInstanceInfos = managedVnfInstanceInfos;
  }

  public VnfmSpecificInfo supportedVnfdFormats(List<VnfmSpecificInfoSupportedVnfdFormats> supportedVnfdFormats) {
    this.supportedVnfdFormats = supportedVnfdFormats;
    return this;
  }

  public VnfmSpecificInfo addSupportedVnfdFormatsItem(VnfmSpecificInfoSupportedVnfdFormats supportedVnfdFormatsItem) {
    this.supportedVnfdFormats.add(supportedVnfdFormatsItem);
    return this;
  }

  /**
   * Supported VNFD data formats. 
   * @return supportedVnfdFormats
  **/
  @Schema(required= true ,description= "Supported VNFD data formats. " )
      @NotNull
    @Valid
  @Size(min=1)   public List<VnfmSpecificInfoSupportedVnfdFormats> getSupportedVnfdFormats() {
    return supportedVnfdFormats;
  }

  public void setSupportedVnfdFormats(List<VnfmSpecificInfoSupportedVnfdFormats> supportedVnfdFormats) {
    this.supportedVnfdFormats = supportedVnfdFormats;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VnfmSpecificInfo vnfmSpecificInfo = (VnfmSpecificInfo) o;
    return Objects.equals(this.resoruceMgmtModeSupport, vnfmSpecificInfo.resoruceMgmtModeSupport) &&
        Objects.equals(this.managedVnfInstanceInfos, vnfmSpecificInfo.managedVnfInstanceInfos) &&
        Objects.equals(this.supportedVnfdFormats, vnfmSpecificInfo.supportedVnfdFormats);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resoruceMgmtModeSupport, managedVnfInstanceInfos, supportedVnfdFormats);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VnfmSpecificInfo {\n");
    
    sb.append("    resoruceMgmtModeSupport: ").append(toIndentedString(resoruceMgmtModeSupport)).append("\n");
    sb.append("    managedVnfInstanceInfos: ").append(toIndentedString(managedVnfInstanceInfos)).append("\n");
    sb.append("    supportedVnfdFormats: ").append(toIndentedString(supportedVnfdFormats)).append("\n");
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
