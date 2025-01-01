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
package com.ubiqube.etsi.mano.v331.model.nfvo.nslcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ubiqube.etsi.mano.v331.model.nfvo.nslcm.MscsConfigDataSiteAccessProtectionSchemes;
import com.ubiqube.etsi.mano.v331.model.nfvo.nslcm.WanLayer2ProtocolData;
import com.ubiqube.etsi.mano.v331.model.nfvo.nslcm.WanLayer3ProtocolData;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type provides configuration data for the creation of an MSCS. It shall comply with the provisions defined in Table 6.5.3.87-1. 
 */
@Schema(description = "This type provides configuration data for the creation of an MSCS. It shall comply with the provisions defined in Table 6.5.3.87-1. ")
@Validated


public class MscsConfigData   {
  /**
   * The type of connectivity that is requested to be provided to the virtualized networks in the NFVI-PoP and characterizes the connectivity service across the WAN. Permitted values: - L2 - L3 
   */
  public enum MscsTypeEnum {
    L2("L2"),
    
    L3("L3");

    private String value;

    MscsTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MscsTypeEnum fromValue(String text) {
      for (MscsTypeEnum b : MscsTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("mscsType")
  private MscsTypeEnum mscsType = null;

  @JsonProperty("siteAccessProtectionSchemes")
  @Valid
  private List<MscsConfigDataSiteAccessProtectionSchemes> siteAccessProtectionSchemes = null;

  @JsonProperty("mtuMscs")
  private BigDecimal mtuMscs = null;

  @JsonProperty("wanLayer2ProtocolData")
  private WanLayer2ProtocolData wanLayer2ProtocolData = null;

  @JsonProperty("wanLayer3ProtocolData")
  private WanLayer3ProtocolData wanLayer3ProtocolData = null;

  public MscsConfigData mscsType(MscsTypeEnum mscsType) {
    this.mscsType = mscsType;
    return this;
  }

  /**
   * The type of connectivity that is requested to be provided to the virtualized networks in the NFVI-PoP and characterizes the connectivity service across the WAN. Permitted values: - L2 - L3 
   * @return mscsType
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "The type of connectivity that is requested to be provided to the virtualized networks in the NFVI-PoP and characterizes the connectivity service across the WAN. Permitted values: - L2 - L3 ")
      @NotNull

    public MscsTypeEnum getMscsType() {
    return mscsType;
  }

  public void setMscsType(MscsTypeEnum mscsType) {
    this.mscsType = mscsType;
  }

  public MscsConfigData siteAccessProtectionSchemes(List<MscsConfigDataSiteAccessProtectionSchemes> siteAccessProtectionSchemes) {
    this.siteAccessProtectionSchemes = siteAccessProtectionSchemes;
    return this;
  }

  public MscsConfigData addSiteAccessProtectionSchemesItem(MscsConfigDataSiteAccessProtectionSchemes siteAccessProtectionSchemesItem) {
    if (this.siteAccessProtectionSchemes == null) {
      this.siteAccessProtectionSchemes = new ArrayList<>();
    }
    this.siteAccessProtectionSchemes.add(siteAccessProtectionSchemesItem);
    return this;
  }

  /**
   * Information to determine the proper MSCS endpoints configuration to fulfil certain resiliency/protection requirements, e.g., by considering certain availability and redundancy of connectivity service endpoints in between NFVI-PoP and WAN. 
   * @return siteAccessProtectionSchemes
   **/
  @Schema(description = "Information to determine the proper MSCS endpoints configuration to fulfil certain resiliency/protection requirements, e.g., by considering certain availability and redundancy of connectivity service endpoints in between NFVI-PoP and WAN. ")
      @Valid
    public List<MscsConfigDataSiteAccessProtectionSchemes> getSiteAccessProtectionSchemes() {
    return siteAccessProtectionSchemes;
  }

  public void setSiteAccessProtectionSchemes(List<MscsConfigDataSiteAccessProtectionSchemes> siteAccessProtectionSchemes) {
    this.siteAccessProtectionSchemes = siteAccessProtectionSchemes;
  }

  public MscsConfigData mtuMscs(BigDecimal mtuMscs) {
    this.mtuMscs = mtuMscs;
    return this;
  }

  /**
   * Maximum Transmission Unit (MTU) that can be forwarded over the MSCS (in bytes). Default value is \"1500\" (bytes). 
   * @return mtuMscs
   **/
  @Schema(description = "Maximum Transmission Unit (MTU) that can be forwarded over the MSCS (in bytes). Default value is \"1500\" (bytes). ")
  
    @Valid
    public BigDecimal getMtuMscs() {
    return mtuMscs;
  }

  public void setMtuMscs(BigDecimal mtuMscs) {
    this.mtuMscs = mtuMscs;
  }

  public MscsConfigData wanLayer2ProtocolData(WanLayer2ProtocolData wanLayer2ProtocolData) {
    this.wanLayer2ProtocolData = wanLayer2ProtocolData;
    return this;
  }

  /**
   * Get wanLayer2ProtocolData
   * @return wanLayer2ProtocolData
   **/
  @Schema(description = "")
  
    @Valid
    public WanLayer2ProtocolData getWanLayer2ProtocolData() {
    return wanLayer2ProtocolData;
  }

  public void setWanLayer2ProtocolData(WanLayer2ProtocolData wanLayer2ProtocolData) {
    this.wanLayer2ProtocolData = wanLayer2ProtocolData;
  }

  public MscsConfigData wanLayer3ProtocolData(WanLayer3ProtocolData wanLayer3ProtocolData) {
    this.wanLayer3ProtocolData = wanLayer3ProtocolData;
    return this;
  }

  /**
   * Get wanLayer3ProtocolData
   * @return wanLayer3ProtocolData
   **/
  @Schema(description = "")
  
    @Valid
    public WanLayer3ProtocolData getWanLayer3ProtocolData() {
    return wanLayer3ProtocolData;
  }

  public void setWanLayer3ProtocolData(WanLayer3ProtocolData wanLayer3ProtocolData) {
    this.wanLayer3ProtocolData = wanLayer3ProtocolData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MscsConfigData mscsConfigData = (MscsConfigData) o;
    return Objects.equals(this.mscsType, mscsConfigData.mscsType) &&
        Objects.equals(this.siteAccessProtectionSchemes, mscsConfigData.siteAccessProtectionSchemes) &&
        Objects.equals(this.mtuMscs, mscsConfigData.mtuMscs) &&
        Objects.equals(this.wanLayer2ProtocolData, mscsConfigData.wanLayer2ProtocolData) &&
        Objects.equals(this.wanLayer3ProtocolData, mscsConfigData.wanLayer3ProtocolData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mscsType, siteAccessProtectionSchemes, mtuMscs, wanLayer2ProtocolData, wanLayer3ProtocolData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MscsConfigData {\n");
    
    sb.append("    mscsType: ").append(toIndentedString(mscsType)).append("\n");
    sb.append("    siteAccessProtectionSchemes: ").append(toIndentedString(siteAccessProtectionSchemes)).append("\n");
    sb.append("    mtuMscs: ").append(toIndentedString(mtuMscs)).append("\n");
    sb.append("    wanLayer2ProtocolData: ").append(toIndentedString(wanLayer2ProtocolData)).append("\n");
    sb.append("    wanLayer3ProtocolData: ").append(toIndentedString(wanLayer3ProtocolData)).append("\n");
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
