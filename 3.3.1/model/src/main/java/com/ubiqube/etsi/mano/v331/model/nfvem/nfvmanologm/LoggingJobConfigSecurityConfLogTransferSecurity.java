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
package com.ubiqube.etsi.mano.v331.model.nfvem.nfvmanologm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Information about the security measures for retrieving/accessing the compiled log files.
 */
@Schema(description = "Information about the security measures for retrieving/accessing the compiled log files.")
@Validated


public class LoggingJobConfigSecurityConfLogTransferSecurity   {
  @JsonProperty("publicKey")
  private String publicKey = null;

  public LoggingJobConfigSecurityConfLogTransferSecurity publicKey(String publicKey) {
    this.publicKey = publicKey;
    return this;
  }

  /**
   * The public key of the API consumer used for the client authentication with the file server. Shall be provided if required by the type of transfer protocol. May be omitted if the key has been provided to the API producer by other means, or if it has already been provided in some previous CreateLoggingJobRequest issued by the same API consumer, whose public key has not changed.
   * @return publicKey
   **/
  @Schema(description = "The public key of the API consumer used for the client authentication with the file server. Shall be provided if required by the type of transfer protocol. May be omitted if the key has been provided to the API producer by other means, or if it has already been provided in some previous CreateLoggingJobRequest issued by the same API consumer, whose public key has not changed.")
  
    public String getPublicKey() {
    return publicKey;
  }

  public void setPublicKey(String publicKey) {
    this.publicKey = publicKey;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoggingJobConfigSecurityConfLogTransferSecurity loggingJobConfigSecurityConfLogTransferSecurity = (LoggingJobConfigSecurityConfLogTransferSecurity) o;
    return Objects.equals(this.publicKey, loggingJobConfigSecurityConfLogTransferSecurity.publicKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(publicKey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoggingJobConfigSecurityConfLogTransferSecurity {\n");
    
    sb.append("    publicKey: ").append(toIndentedString(publicKey)).append("\n");
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
