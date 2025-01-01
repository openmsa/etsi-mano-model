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
package com.ubiqube.etsi.mano.v451.model.em.vnflcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type provides input information related to security policy for certificate management. 
 */
@Schema(description = "This type provides input information related to security policy for certificate management. ")
@Validated


public class SecurityPolicy   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("maxValidityPeriod")
  private Integer maxValidityPeriod = null;

  @JsonProperty("allowedAlgorithm")
  private String allowedAlgorithm = null;

  @JsonProperty("minimumKeyLength")
  private Integer minimumKeyLength = null;

  public SecurityPolicy id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public SecurityPolicy maxValidityPeriod(Integer maxValidityPeriod) {
    this.maxValidityPeriod = maxValidityPeriod;
    return this;
  }

  /**
   * Allowed max validity period for certificates.
   * @return maxValidityPeriod
   **/
  @Schema(description = "Allowed max validity period for certificates.")
  
    public Integer getMaxValidityPeriod() {
    return maxValidityPeriod;
  }

  public void setMaxValidityPeriod(Integer maxValidityPeriod) {
    this.maxValidityPeriod = maxValidityPeriod;
  }

  public SecurityPolicy allowedAlgorithm(String allowedAlgorithm) {
    this.allowedAlgorithm = allowedAlgorithm;
    return this;
  }

  /**
   * Allowed signature algorithm.
   * @return allowedAlgorithm
   **/
  @Schema(description = "Allowed signature algorithm.")
  
    public String getAllowedAlgorithm() {
    return allowedAlgorithm;
  }

  public void setAllowedAlgorithm(String allowedAlgorithm) {
    this.allowedAlgorithm = allowedAlgorithm;
  }

  public SecurityPolicy minimumKeyLength(Integer minimumKeyLength) {
    this.minimumKeyLength = minimumKeyLength;
    return this;
  }

  /**
   * Minimum key length for certificates.
   * @return minimumKeyLength
   **/
  @Schema(description = "Minimum key length for certificates.")
  
    public Integer getMinimumKeyLength() {
    return minimumKeyLength;
  }

  public void setMinimumKeyLength(Integer minimumKeyLength) {
    this.minimumKeyLength = minimumKeyLength;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SecurityPolicy securityPolicy = (SecurityPolicy) o;
    return Objects.equals(this.id, securityPolicy.id) &&
        Objects.equals(this.maxValidityPeriod, securityPolicy.maxValidityPeriod) &&
        Objects.equals(this.allowedAlgorithm, securityPolicy.allowedAlgorithm) &&
        Objects.equals(this.minimumKeyLength, securityPolicy.minimumKeyLength);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, maxValidityPeriod, allowedAlgorithm, minimumKeyLength);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SecurityPolicy {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    maxValidityPeriod: ").append(toIndentedString(maxValidityPeriod)).append("\n");
    sb.append("    allowedAlgorithm: ").append(toIndentedString(allowedAlgorithm)).append("\n");
    sb.append("    minimumKeyLength: ").append(toIndentedString(minimumKeyLength)).append("\n");
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
