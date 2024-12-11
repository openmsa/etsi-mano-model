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
package com.ubiqube.etsi.mano.v431.model.nfvo.nslcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v431.model.nfvo.nslcm.WanConnectionProtocolInfo;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type provides information about the connectivity to the WAN of network resources realizing a VL, e.g., when the VL is deployed on several sites across a WAN. It shall comply with the provisions defined in table 6.5.3.90-1. NOTE: Either a \&quot;nsVirtualLinkInfoId\&quot; or a \&quot;vnfVirtualLinkResourceInfoId\&quot; shall be provided, but not both. 
 */
@Schema(description = "This type provides information about the connectivity to the WAN of network resources realizing a VL, e.g., when the VL is deployed on several sites across a WAN. It shall comply with the provisions defined in table 6.5.3.90-1. NOTE: Either a \"nsVirtualLinkInfoId\" or a \"vnfVirtualLinkResourceInfoId\" shall be provided, but not both. ")
@Validated


public class WanConnectionInfo  implements OneOfWanConnectionInfo {
  @JsonProperty("wanConnectionInfoId")
  private String wanConnectionInfoId = null;

  @JsonProperty("nsVirtualLinkInfoId")
  private String nsVirtualLinkInfoId = null;

  @JsonProperty("vnfVirtualLinkResourceInfoId")
  private String vnfVirtualLinkResourceInfoId = null;

  @JsonProperty("protocolInfo")
  private WanConnectionProtocolInfo protocolInfo = null;

  public WanConnectionInfo wanConnectionInfoId(String wanConnectionInfoId) {
    this.wanConnectionInfoId = wanConnectionInfoId;
    return this;
  }

  /**
   * Get wanConnectionInfoId
   * @return wanConnectionInfoId
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    public String getWanConnectionInfoId() {
    return wanConnectionInfoId;
  }

  public void setWanConnectionInfoId(String wanConnectionInfoId) {
    this.wanConnectionInfoId = wanConnectionInfoId;
  }

  public WanConnectionInfo nsVirtualLinkInfoId(String nsVirtualLinkInfoId) {
    this.nsVirtualLinkInfoId = nsVirtualLinkInfoId;
    return this;
  }

  /**
   * Get nsVirtualLinkInfoId
   * @return nsVirtualLinkInfoId
   **/
  @Schema(description = "")
  
    public String getNsVirtualLinkInfoId() {
    return nsVirtualLinkInfoId;
  }

  public void setNsVirtualLinkInfoId(String nsVirtualLinkInfoId) {
    this.nsVirtualLinkInfoId = nsVirtualLinkInfoId;
  }

  public WanConnectionInfo vnfVirtualLinkResourceInfoId(String vnfVirtualLinkResourceInfoId) {
    this.vnfVirtualLinkResourceInfoId = vnfVirtualLinkResourceInfoId;
    return this;
  }

  /**
   * Get vnfVirtualLinkResourceInfoId
   * @return vnfVirtualLinkResourceInfoId
   **/
  @Schema(description = "")
  
    public String getVnfVirtualLinkResourceInfoId() {
    return vnfVirtualLinkResourceInfoId;
  }

  public void setVnfVirtualLinkResourceInfoId(String vnfVirtualLinkResourceInfoId) {
    this.vnfVirtualLinkResourceInfoId = vnfVirtualLinkResourceInfoId;
  }

  public WanConnectionInfo protocolInfo(WanConnectionProtocolInfo protocolInfo) {
    this.protocolInfo = protocolInfo;
    return this;
  }

  /**
   * Get protocolInfo
   * @return protocolInfo
   **/
  @Schema(description = "")
  
    @Valid
    public WanConnectionProtocolInfo getProtocolInfo() {
    return protocolInfo;
  }

  public void setProtocolInfo(WanConnectionProtocolInfo protocolInfo) {
    this.protocolInfo = protocolInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WanConnectionInfo wanConnectionInfo = (WanConnectionInfo) o;
    return Objects.equals(this.wanConnectionInfoId, wanConnectionInfo.wanConnectionInfoId) &&
        Objects.equals(this.nsVirtualLinkInfoId, wanConnectionInfo.nsVirtualLinkInfoId) &&
        Objects.equals(this.vnfVirtualLinkResourceInfoId, wanConnectionInfo.vnfVirtualLinkResourceInfoId) &&
        Objects.equals(this.protocolInfo, wanConnectionInfo.protocolInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(wanConnectionInfoId, nsVirtualLinkInfoId, vnfVirtualLinkResourceInfoId, protocolInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WanConnectionInfo {\n");
    
    sb.append("    wanConnectionInfoId: ").append(toIndentedString(wanConnectionInfoId)).append("\n");
    sb.append("    nsVirtualLinkInfoId: ").append(toIndentedString(nsVirtualLinkInfoId)).append("\n");
    sb.append("    vnfVirtualLinkResourceInfoId: ").append(toIndentedString(vnfVirtualLinkResourceInfoId)).append("\n");
    sb.append("    protocolInfo: ").append(toIndentedString(protocolInfo)).append("\n");
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
