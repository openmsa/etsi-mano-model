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
package com.ubiqube.etsi.mano.v451.model.nfvo.nslcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ubiqube.etsi.mano.v451.model.nfvo.nslcm.LocationConstraints;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * MscsConfigDataSiteAccessProtectionSchemes
 */
@Validated


public class MscsConfigDataSiteAccessProtectionSchemes   {
  @JsonProperty("locationConstraints")
  private LocationConstraints locationConstraints = null;

  /**
   * Defines the protection scheme. Permitted values: - UNPROTECTED - ONE_TO_ONE - ONE_PLUS_ONE - ONE_TO_N 
   */
  public enum ProtectionSchemeEnum {
    UNPROTECTED("UNPROTECTED"),
    
    ONE_TO_ONE("ONE_TO_ONE"),
    
    ONE_PLUS_ONE("ONE_PLUS_ONE"),
    
    ONE_TO_N("ONE_TO_N");

    private String value;

    ProtectionSchemeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ProtectionSchemeEnum fromValue(String text) {
      for (ProtectionSchemeEnum b : ProtectionSchemeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("protectionScheme")
  private ProtectionSchemeEnum protectionScheme = null;

  public MscsConfigDataSiteAccessProtectionSchemes locationConstraints(LocationConstraints locationConstraints) {
    this.locationConstraints = locationConstraints;
    return this;
  }

  /**
   * Get locationConstraints
   * @return locationConstraints
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    @Valid
    public LocationConstraints getLocationConstraints() {
    return locationConstraints;
  }

  public void setLocationConstraints(LocationConstraints locationConstraints) {
    this.locationConstraints = locationConstraints;
  }

  public MscsConfigDataSiteAccessProtectionSchemes protectionScheme(ProtectionSchemeEnum protectionScheme) {
    this.protectionScheme = protectionScheme;
    return this;
  }

  /**
   * Defines the protection scheme. Permitted values: - UNPROTECTED - ONE_TO_ONE - ONE_PLUS_ONE - ONE_TO_N 
   * @return protectionScheme
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Defines the protection scheme. Permitted values: - UNPROTECTED - ONE_TO_ONE - ONE_PLUS_ONE - ONE_TO_N ")
      @NotNull

    public ProtectionSchemeEnum getProtectionScheme() {
    return protectionScheme;
  }

  public void setProtectionScheme(ProtectionSchemeEnum protectionScheme) {
    this.protectionScheme = protectionScheme;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MscsConfigDataSiteAccessProtectionSchemes mscsConfigDataSiteAccessProtectionSchemes = (MscsConfigDataSiteAccessProtectionSchemes) o;
    return Objects.equals(this.locationConstraints, mscsConfigDataSiteAccessProtectionSchemes.locationConstraints) &&
        Objects.equals(this.protectionScheme, mscsConfigDataSiteAccessProtectionSchemes.protectionScheme);
  }

  @Override
  public int hashCode() {
    return Objects.hash(locationConstraints, protectionScheme);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MscsConfigDataSiteAccessProtectionSchemes {\n");
    
    sb.append("    locationConstraints: ").append(toIndentedString(locationConstraints)).append("\n");
    sb.append("    protectionScheme: ").append(toIndentedString(protectionScheme)).append("\n");
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
