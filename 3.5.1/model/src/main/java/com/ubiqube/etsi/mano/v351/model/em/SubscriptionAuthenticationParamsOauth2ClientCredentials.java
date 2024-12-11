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
package com.ubiqube.etsi.mano.v351.model.em;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Parameters for authentication/authorization using OAUTH2_CLIENT_CREDENTIALS. Shall be present if authType is \&quot;OAUTH2_CLIENT_CREDENTIALS\&quot; and the contained information has not been provisioned out of band. Shall be absent otherwise. 
 */
@Schema(description = "Parameters for authentication/authorization using OAUTH2_CLIENT_CREDENTIALS. Shall be present if authType is \"OAUTH2_CLIENT_CREDENTIALS\" and the contained information has not been provisioned out of band. Shall be absent otherwise. ")
@Validated


public class SubscriptionAuthenticationParamsOauth2ClientCredentials   {
  @JsonProperty("clientId")
  private String clientId = null;

  @JsonProperty("clientPassword")
  private String clientPassword = null;

  @JsonProperty("tokenEndpoint")
  private String tokenEndpoint = null;

  public SubscriptionAuthenticationParamsOauth2ClientCredentials clientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

  /**
   * Client identifier to be used in the access token request of the OAuth 2.0 client credentials grant type.  Shall be present if it has not been provisioned out of band. See note. 
   * @return clientId
   **/
  @Schema(description = "Client identifier to be used in the access token request of the OAuth 2.0 client credentials grant type.  Shall be present if it has not been provisioned out of band. See note. ")
  
    public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public SubscriptionAuthenticationParamsOauth2ClientCredentials clientPassword(String clientPassword) {
    this.clientPassword = clientPassword;
    return this;
  }

  /**
   * Client password to be used in the access token request of the OAuth 2.0 client credentials grant type.  Shall be present if it has not been provisioned out of band. See note. 
   * @return clientPassword
   **/
  @Schema(description = "Client password to be used in the access token request of the OAuth 2.0 client credentials grant type.  Shall be present if it has not been provisioned out of band. See note. ")
  
    public String getClientPassword() {
    return clientPassword;
  }

  public void setClientPassword(String clientPassword) {
    this.clientPassword = clientPassword;
  }

  public SubscriptionAuthenticationParamsOauth2ClientCredentials tokenEndpoint(String tokenEndpoint) {
    this.tokenEndpoint = tokenEndpoint;
    return this;
  }

  /**
   * Get tokenEndpoint
   * @return tokenEndpoint
   **/
  @Schema(description = "")
  
    public String getTokenEndpoint() {
    return tokenEndpoint;
  }

  public void setTokenEndpoint(String tokenEndpoint) {
    this.tokenEndpoint = tokenEndpoint;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscriptionAuthenticationParamsOauth2ClientCredentials subscriptionAuthenticationParamsOauth2ClientCredentials = (SubscriptionAuthenticationParamsOauth2ClientCredentials) o;
    return Objects.equals(this.clientId, subscriptionAuthenticationParamsOauth2ClientCredentials.clientId) &&
        Objects.equals(this.clientPassword, subscriptionAuthenticationParamsOauth2ClientCredentials.clientPassword) &&
        Objects.equals(this.tokenEndpoint, subscriptionAuthenticationParamsOauth2ClientCredentials.tokenEndpoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, clientPassword, tokenEndpoint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscriptionAuthenticationParamsOauth2ClientCredentials {\n");
    
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    clientPassword: ").append(toIndentedString(clientPassword)).append("\n");
    sb.append("    tokenEndpoint: ").append(toIndentedString(tokenEndpoint)).append("\n");
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
