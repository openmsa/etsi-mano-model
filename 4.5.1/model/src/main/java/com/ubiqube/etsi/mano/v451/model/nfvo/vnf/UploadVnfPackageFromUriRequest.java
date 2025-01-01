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
package com.ubiqube.etsi.mano.v451.model.nfvo.vnf;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ubiqube.etsi.mano.v451.model.nfvo.vnf.UploadVnfPackageFromUriRequestParamsOauth2ClientCredentials;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents the request parameters for uploading the content of a VNF package. The NFVO can obtain the VNF package content through the information provided in the request parameters. It shall comply with the provisions defined in Table 9.5.2.4-1. 
 */
@Schema(description = "This type represents the request parameters for uploading the content of a VNF package. The NFVO can obtain the VNF package content through the information provided in the request parameters. It shall comply with the provisions defined in Table 9.5.2.4-1. ")
@Validated


public class UploadVnfPackageFromUriRequest   {
  @JsonProperty("addressInformation")
  private String addressInformation = null;

  /**
   * Defines the type of authentication / authorization for downloading the VNF package. Permitted values: - OAUTH2_CLIENT_CREDENTIALS:  Only the \"paramsOauth2ClientCredentials\" attribute shall be present. This attribute shall not be present if the credentials were provisioned out of band. 
   */
  public enum AuthTypeEnum {
    OAUTH2_CLIENT_CREDENTIALS("OAUTH2_CLIENT_CREDENTIALS");

    private String value;

    AuthTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AuthTypeEnum fromValue(String text) {
      for (AuthTypeEnum b : AuthTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("authType")
  private AuthTypeEnum authType = null;

  @JsonProperty("paramsOauth2ClientCredentials")
  private UploadVnfPackageFromUriRequestParamsOauth2ClientCredentials paramsOauth2ClientCredentials = null;

  public UploadVnfPackageFromUriRequest addressInformation(String addressInformation) {
    this.addressInformation = addressInformation;
    return this;
  }

  /**
   * Get addressInformation
   * @return addressInformation
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    public String getAddressInformation() {
    return addressInformation;
  }

  public void setAddressInformation(String addressInformation) {
    this.addressInformation = addressInformation;
  }

  public UploadVnfPackageFromUriRequest authType(AuthTypeEnum authType) {
    this.authType = authType;
    return this;
  }

  /**
   * Defines the type of authentication / authorization for downloading the VNF package. Permitted values: - OAUTH2_CLIENT_CREDENTIALS:  Only the \"paramsOauth2ClientCredentials\" attribute shall be present. This attribute shall not be present if the credentials were provisioned out of band. 
   * @return authType
   **/
  @Schema(description = "Defines the type of authentication / authorization for downloading the VNF package. Permitted values: - OAUTH2_CLIENT_CREDENTIALS:  Only the \"paramsOauth2ClientCredentials\" attribute shall be present. This attribute shall not be present if the credentials were provisioned out of band. ")
  
    public AuthTypeEnum getAuthType() {
    return authType;
  }

  public void setAuthType(AuthTypeEnum authType) {
    this.authType = authType;
  }

  public UploadVnfPackageFromUriRequest paramsOauth2ClientCredentials(UploadVnfPackageFromUriRequestParamsOauth2ClientCredentials paramsOauth2ClientCredentials) {
    this.paramsOauth2ClientCredentials = paramsOauth2ClientCredentials;
    return this;
  }

  /**
   * Get paramsOauth2ClientCredentials
   * @return paramsOauth2ClientCredentials
   **/
  @Schema(description = "")
  
    @Valid
    public UploadVnfPackageFromUriRequestParamsOauth2ClientCredentials getParamsOauth2ClientCredentials() {
    return paramsOauth2ClientCredentials;
  }

  public void setParamsOauth2ClientCredentials(UploadVnfPackageFromUriRequestParamsOauth2ClientCredentials paramsOauth2ClientCredentials) {
    this.paramsOauth2ClientCredentials = paramsOauth2ClientCredentials;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UploadVnfPackageFromUriRequest uploadVnfPackageFromUriRequest = (UploadVnfPackageFromUriRequest) o;
    return Objects.equals(this.addressInformation, uploadVnfPackageFromUriRequest.addressInformation) &&
        Objects.equals(this.authType, uploadVnfPackageFromUriRequest.authType) &&
        Objects.equals(this.paramsOauth2ClientCredentials, uploadVnfPackageFromUriRequest.paramsOauth2ClientCredentials);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addressInformation, authType, paramsOauth2ClientCredentials);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UploadVnfPackageFromUriRequest {\n");
    
    sb.append("    addressInformation: ").append(toIndentedString(addressInformation)).append("\n");
    sb.append("    authType: ").append(toIndentedString(authType)).append("\n");
    sb.append("    paramsOauth2ClientCredentials: ").append(toIndentedString(paramsOauth2ClientCredentials)).append("\n");
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
