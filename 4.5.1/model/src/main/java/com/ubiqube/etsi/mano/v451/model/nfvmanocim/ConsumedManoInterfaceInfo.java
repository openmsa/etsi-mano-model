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
package com.ubiqube.etsi.mano.v451.model.nfvmanocim;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.ClientInterfaceSecurityInfo;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.ConsumedManoInterfaceInfoApiEndpoint;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents an interface consumed by the producer NFV MANO functional entity from another peer functional entity. * NOTE 1: The information to be provided in this attribute shall relate to the specification and its version.             For instance, \&quot;ETSI GS NFV-SOL 003 (V2.4.1)\&quot;. * NOTE 2: Due to the security sensitive information associated to the attribute, based on access control             policies, the API consumer might have read only, write only, read/write, or no access at all to             the attribute&#x27;s value. In case the API consumer is not allowed to read the value of the security             sensitive attribute, the attribute shall be omitted when the information is to be provided in a             response message, and shall be provided otherwise. In case the API consumer is not allowed to             modify the value of the security sensitive attribute, and the modification request includes new             attribute values, the whole modification request shall be rejected, and proper error information returned. 
 */
@Schema(description = "This type represents an interface consumed by the producer NFV MANO functional entity from another peer functional entity. * NOTE 1: The information to be provided in this attribute shall relate to the specification and its version.             For instance, \"ETSI GS NFV-SOL 003 (V2.4.1)\". * NOTE 2: Due to the security sensitive information associated to the attribute, based on access control             policies, the API consumer might have read only, write only, read/write, or no access at all to             the attribute's value. In case the API consumer is not allowed to read the value of the security             sensitive attribute, the attribute shall be omitted when the information is to be provided in a             response message, and shall be provided otherwise. In case the API consumer is not allowed to             modify the value of the security sensitive attribute, and the modification request includes new             attribute values, the whole modification request shall be rejected, and proper error information returned. ")
@Validated



public class ConsumedManoInterfaceInfo   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("standardVersion")
  private String standardVersion = null;

  @JsonProperty("apiVersion")
  private String apiVersion = null;

  @JsonProperty("apiEndpoint")
  private ConsumedManoInterfaceInfoApiEndpoint apiEndpoint = null;

  @JsonProperty("securityInfo")
  private ClientInterfaceSecurityInfo securityInfo = null;

  public ConsumedManoInterfaceInfo name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Human-readable name of the NFV-MANO interface. 
   * @return name
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Human-readable name of the NFV-MANO interface. ")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ConsumedManoInterfaceInfo type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Type of the NFV-MANO service interface consumed by the NFV-MANO functional entity. Valid values are defined in clause 5.6.4.3. 
   * @return type
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Type of the NFV-MANO service interface consumed by the NFV-MANO functional entity. Valid values are defined in clause 5.6.4.3. ")
      @NotNull

    public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ConsumedManoInterfaceInfo standardVersion(String standardVersion) {
    this.standardVersion = standardVersion;
    return this;
  }

  /**
   * A version. 
   * @return standardVersion
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "A version. ")
      @NotNull

    public String getStandardVersion() {
    return standardVersion;
  }

  public void setStandardVersion(String standardVersion) {
    this.standardVersion = standardVersion;
  }

  public ConsumedManoInterfaceInfo apiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return this;
  }

  /**
   * A version. 
   * @return apiVersion
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "A version. ")
      @NotNull

    public String getApiVersion() {
    return apiVersion;
  }

  public void setApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
  }

  public ConsumedManoInterfaceInfo apiEndpoint(ConsumedManoInterfaceInfoApiEndpoint apiEndpoint) {
    this.apiEndpoint = apiEndpoint;
    return this;
  }

  /**
   * Get apiEndpoint
   * @return apiEndpoint
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    @Valid
    public ConsumedManoInterfaceInfoApiEndpoint getApiEndpoint() {
    return apiEndpoint;
  }

  public void setApiEndpoint(ConsumedManoInterfaceInfoApiEndpoint apiEndpoint) {
    this.apiEndpoint = apiEndpoint;
  }

  public ConsumedManoInterfaceInfo securityInfo(ClientInterfaceSecurityInfo securityInfo) {
    this.securityInfo = securityInfo;
    return this;
  }

  /**
   * Get securityInfo
   * @return securityInfo
   **/
  @Schema(description = "")
  
    @Valid
    public ClientInterfaceSecurityInfo getSecurityInfo() {
    return securityInfo;
  }

  public void setSecurityInfo(ClientInterfaceSecurityInfo securityInfo) {
    this.securityInfo = securityInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsumedManoInterfaceInfo consumedManoInterfaceInfo = (ConsumedManoInterfaceInfo) o;
    return Objects.equals(this.name, consumedManoInterfaceInfo.name) &&
        Objects.equals(this.type, consumedManoInterfaceInfo.type) &&
        Objects.equals(this.standardVersion, consumedManoInterfaceInfo.standardVersion) &&
        Objects.equals(this.apiVersion, consumedManoInterfaceInfo.apiVersion) &&
        Objects.equals(this.apiEndpoint, consumedManoInterfaceInfo.apiEndpoint) &&
        Objects.equals(this.securityInfo, consumedManoInterfaceInfo.securityInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type, standardVersion, apiVersion, apiEndpoint, securityInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsumedManoInterfaceInfo {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    standardVersion: ").append(toIndentedString(standardVersion)).append("\n");
    sb.append("    apiVersion: ").append(toIndentedString(apiVersion)).append("\n");
    sb.append("    apiEndpoint: ").append(toIndentedString(apiEndpoint)).append("\n");
    sb.append("    securityInfo: ").append(toIndentedString(securityInfo)).append("\n");
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
