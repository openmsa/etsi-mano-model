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
package com.ubiqube.etsi.mano.v331.model.vnfm.grant;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Map;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents parameters to connect to a VIM for managing the resources of a VNF instance. This structure is used to convey VIM-related parameters over the Or-Vnfm interface. Additional parameters for a VIM may be configured into the VNFM by means outside the scope of the present document, and bound to the identifier of that VIM. 
 */
@Schema(description = "This type represents parameters to connect to a VIM for managing the resources of a VNF instance. This structure is used to convey VIM-related parameters over the Or-Vnfm interface. Additional parameters for a VIM may be configured into the VNFM by means outside the scope of the present document, and bound to the identifier of that VIM. ")
@Validated


public class VimConnectionInfo   {
  @JsonProperty("vimId")
  private String vimId = null;

  @JsonProperty("vimType")
  private String vimType = null;

  @JsonProperty("interfaceInfo")
  private Map<String, String> interfaceInfo = null;

  @JsonProperty("accessInfo")
  private Map<String, String> accessInfo = null;

  @JsonProperty("extra")
  private Map<String, String> extra = null;

  public VimConnectionInfo vimId(String vimId) {
    this.vimId = vimId;
    return this;
  }

  /**
   * Get vimId
   * @return vimId
   **/
  @Schema(description = "")
  
    public String getVimId() {
    return vimId;
  }

  public void setVimId(String vimId) {
    this.vimId = vimId;
  }

  public VimConnectionInfo vimType(String vimType) {
    this.vimType = vimType;
    return this;
  }

  /**
   * Discriminator for the different types of the VIM information. The value of this attribute determines the structure of the \"interfaceInfo\" and \"accessInfo\" attributes, based on the type of the VIM. The set of permitted values is expected to change over time as new types or versions of VIMs become available. The ETSI NFV registry of VIM-related information provides access to information about VimConnectionInfo definitions for various VIM types. The structure of the registry is defined in Annex C of SOL003. 
   * @return vimType
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Discriminator for the different types of the VIM information. The value of this attribute determines the structure of the \"interfaceInfo\" and \"accessInfo\" attributes, based on the type of the VIM. The set of permitted values is expected to change over time as new types or versions of VIMs become available. The ETSI NFV registry of VIM-related information provides access to information about VimConnectionInfo definitions for various VIM types. The structure of the registry is defined in Annex C of SOL003. ")
      @NotNull

    public String getVimType() {
    return vimType;
  }

  public void setVimType(String vimType) {
    this.vimType = vimType;
  }

  public VimConnectionInfo interfaceInfo(Map<String, String> interfaceInfo) {
    this.interfaceInfo = interfaceInfo;
    return this;
  }

  /**
   * Get interfaceInfo
   * @return interfaceInfo
   **/
  @Schema(description = "")
  
    @Valid
    public Map<String, String> getInterfaceInfo() {
    return interfaceInfo;
  }

  public void setInterfaceInfo(Map<String, String> interfaceInfo) {
    this.interfaceInfo = interfaceInfo;
  }

  public VimConnectionInfo accessInfo(Map<String, String> accessInfo) {
    this.accessInfo = accessInfo;
    return this;
  }

  /**
   * Get accessInfo
   * @return accessInfo
   **/
  @Schema(description = "")
  
    @Valid
    public Map<String, String> getAccessInfo() {
    return accessInfo;
  }

  public void setAccessInfo(Map<String, String> accessInfo) {
    this.accessInfo = accessInfo;
  }

  public VimConnectionInfo extra(Map<String, String> extra) {
    this.extra = extra;
    return this;
  }

  /**
   * Get extra
   * @return extra
   **/
  @Schema(description = "")
  
    @Valid
    public Map<String, String> getExtra() {
    return extra;
  }

  public void setExtra(Map<String, String> extra) {
    this.extra = extra;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VimConnectionInfo vimConnectionInfo = (VimConnectionInfo) o;
    return Objects.equals(this.vimId, vimConnectionInfo.vimId) &&
        Objects.equals(this.vimType, vimConnectionInfo.vimType) &&
        Objects.equals(this.interfaceInfo, vimConnectionInfo.interfaceInfo) &&
        Objects.equals(this.accessInfo, vimConnectionInfo.accessInfo) &&
        Objects.equals(this.extra, vimConnectionInfo.extra);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vimId, vimType, interfaceInfo, accessInfo, extra);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VimConnectionInfo {\n");
    
    sb.append("    vimId: ").append(toIndentedString(vimId)).append("\n");
    sb.append("    vimType: ").append(toIndentedString(vimType)).append("\n");
    sb.append("    interfaceInfo: ").append(toIndentedString(interfaceInfo)).append("\n");
    sb.append("    accessInfo: ").append(toIndentedString(accessInfo)).append("\n");
    sb.append("    extra: ").append(toIndentedString(extra)).append("\n");
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
