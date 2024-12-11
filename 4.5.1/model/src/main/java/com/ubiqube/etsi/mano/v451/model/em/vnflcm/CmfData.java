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
package com.ubiqube.etsi.mano.v451.model.em.vnflcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.CmfInfoEndPoint;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type provides input information related to CMF for certificate management. 
 */
@Schema(description = "This type provides input information related to CMF for certificate management. ")
@Validated


public class CmfData   {
  @JsonProperty("endPoint")
  private CmfInfoEndPoint endPoint = null;

  /**
   * Gets or Sets supportedProtocol
   */
  public enum SupportedProtocolEnum {
    CMP("CMP"),
    
    CMPV2("CMPv2"),
    
    EST("EST"),
    
    SCEP("SCEP");

    private String value;

    SupportedProtocolEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SupportedProtocolEnum fromValue(String text) {
      for (SupportedProtocolEnum b : SupportedProtocolEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("supportedProtocol")
  @Valid
  private List<SupportedProtocolEnum> supportedProtocol = new ArrayList<>();

  public CmfData endPoint(CmfInfoEndPoint endPoint) {
    this.endPoint = endPoint;
    return this;
  }

  /**
   * Get endPoint
   * @return endPoint
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    @Valid
    public CmfInfoEndPoint getEndPoint() {
    return endPoint;
  }

  public void setEndPoint(CmfInfoEndPoint endPoint) {
    this.endPoint = endPoint;
  }

  public CmfData supportedProtocol(List<SupportedProtocolEnum> supportedProtocol) {
    this.supportedProtocol = supportedProtocol;
    return this;
  }

  public CmfData addSupportedProtocolItem(SupportedProtocolEnum supportedProtocolItem) {
    this.supportedProtocol.add(supportedProtocolItem);
    return this;
  }

  /**
   * Supported protocols by CMF instance.
   * @return supportedProtocol
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Supported protocols by CMF instance.")
      @NotNull

    public List<SupportedProtocolEnum> getSupportedProtocol() {
    return supportedProtocol;
  }

  public void setSupportedProtocol(List<SupportedProtocolEnum> supportedProtocol) {
    this.supportedProtocol = supportedProtocol;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CmfData cmfData = (CmfData) o;
    return Objects.equals(this.endPoint, cmfData.endPoint) &&
        Objects.equals(this.supportedProtocol, cmfData.supportedProtocol);
  }

  @Override
  public int hashCode() {
    return Objects.hash(endPoint, supportedProtocol);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CmfData {\n");
    
    sb.append("    endPoint: ").append(toIndentedString(endPoint)).append("\n");
    sb.append("    supportedProtocol: ").append(toIndentedString(supportedProtocol)).append("\n");
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
