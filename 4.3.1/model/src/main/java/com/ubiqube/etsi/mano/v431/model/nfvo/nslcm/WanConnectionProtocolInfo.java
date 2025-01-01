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
package com.ubiqube.etsi.mano.v431.model.nfvo.nslcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v431.model.nfvo.nslcm.ConnectivityServiceEndpointInfo;
import com.ubiqube.etsi.mano.v431.model.nfvo.nslcm.MscsInfo;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type provides protocol specific information about the connectivity to the WAN of network resources realizing a VL, e.g., when the VL is deployed on several sites and across a WAN, and the related multi-site connectivity service (MSCS) enabling the connectivity through the WAN. This type supports providing information about both pre-provisioned WAN connectivity realized by external entities to NFV-MANO but parts of such connectivity is known to the NFVO, as well as information about MSCS created under NFV-MANO responsibility (i.e., connectivity is realized when NFVO communicates with the WIM).  It shall comply with the provisions defined in table 6.5.3.91-1. 
 */
@Schema(description = "This type provides protocol specific information about the connectivity to the WAN of network resources realizing a VL, e.g., when the VL is deployed on several sites and across a WAN, and the related multi-site connectivity service (MSCS) enabling the connectivity through the WAN. This type supports providing information about both pre-provisioned WAN connectivity realized by external entities to NFV-MANO but parts of such connectivity is known to the NFVO, as well as information about MSCS created under NFV-MANO responsibility (i.e., connectivity is realized when NFVO communicates with the WIM).  It shall comply with the provisions defined in table 6.5.3.91-1. ")
@Validated


public class WanConnectionProtocolInfo   {
  @JsonProperty("mscsInfo")
  private MscsInfo mscsInfo = null;

  @JsonProperty("connectivityServiceEndpoints")
  @Valid
  private List<ConnectivityServiceEndpointInfo> connectivityServiceEndpoints = null;

  public WanConnectionProtocolInfo mscsInfo(MscsInfo mscsInfo) {
    this.mscsInfo = mscsInfo;
    return this;
  }

  /**
   * Get mscsInfo
   * @return mscsInfo
   **/
  @Schema(description = "")
  
    @Valid
    public MscsInfo getMscsInfo() {
    return mscsInfo;
  }

  public void setMscsInfo(MscsInfo mscsInfo) {
    this.mscsInfo = mscsInfo;
  }

  public WanConnectionProtocolInfo connectivityServiceEndpoints(List<ConnectivityServiceEndpointInfo> connectivityServiceEndpoints) {
    this.connectivityServiceEndpoints = connectivityServiceEndpoints;
    return this;
  }

  public WanConnectionProtocolInfo addConnectivityServiceEndpointsItem(ConnectivityServiceEndpointInfo connectivityServiceEndpointsItem) {
    if (this.connectivityServiceEndpoints == null) {
      this.connectivityServiceEndpoints = new ArrayList<>();
    }
    this.connectivityServiceEndpoints.add(connectivityServiceEndpointsItem);
    return this;
  }

  /**
   * Configuration information about the network resources in the NFVI-PoP and their connectivity to the WAN. 
   * @return connectivityServiceEndpoints
   **/
  @Schema(description = "Configuration information about the network resources in the NFVI-PoP and their connectivity to the WAN. ")
      @Valid
    public List<ConnectivityServiceEndpointInfo> getConnectivityServiceEndpoints() {
    return connectivityServiceEndpoints;
  }

  public void setConnectivityServiceEndpoints(List<ConnectivityServiceEndpointInfo> connectivityServiceEndpoints) {
    this.connectivityServiceEndpoints = connectivityServiceEndpoints;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WanConnectionProtocolInfo wanConnectionProtocolInfo = (WanConnectionProtocolInfo) o;
    return Objects.equals(this.mscsInfo, wanConnectionProtocolInfo.mscsInfo) &&
        Objects.equals(this.connectivityServiceEndpoints, wanConnectionProtocolInfo.connectivityServiceEndpoints);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mscsInfo, connectivityServiceEndpoints);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WanConnectionProtocolInfo {\n");
    
    sb.append("    mscsInfo: ").append(toIndentedString(mscsInfo)).append("\n");
    sb.append("    connectivityServiceEndpoints: ").append(toIndentedString(connectivityServiceEndpoints)).append("\n");
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
