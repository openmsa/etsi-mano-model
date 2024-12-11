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
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.CertificateConfigurationInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.CertificateContent;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type provides input information related to certificate and certificate management. 
 */
@Schema(description = "This type provides input information related to certificate and certificate management. ")
@Validated


public class CertificateInfo   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("certificateConfigurationInfo")
  private CertificateConfigurationInfo certificateConfigurationInfo = null;

  @JsonProperty("certificateContents")
  @Valid
  private List<CertificateContent> certificateContents = null;

  public CertificateInfo id(String id) {
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

  public CertificateInfo certificateConfigurationInfo(CertificateConfigurationInfo certificateConfigurationInfo) {
    this.certificateConfigurationInfo = certificateConfigurationInfo;
    return this;
  }

  /**
   * Get certificateConfigurationInfo
   * @return certificateConfigurationInfo
   **/
  @Schema(description = "")
  
    @Valid
    public CertificateConfigurationInfo getCertificateConfigurationInfo() {
    return certificateConfigurationInfo;
  }

  public void setCertificateConfigurationInfo(CertificateConfigurationInfo certificateConfigurationInfo) {
    this.certificateConfigurationInfo = certificateConfigurationInfo;
  }

  public CertificateInfo certificateContents(List<CertificateContent> certificateContents) {
    this.certificateContents = certificateContents;
    return this;
  }

  public CertificateInfo addCertificateContentsItem(CertificateContent certificateContentsItem) {
    if (this.certificateContents == null) {
      this.certificateContents = new ArrayList<>();
    }
    this.certificateContents.add(certificateContentsItem);
    return this;
  }

  /**
   * Information for contents of issued certificates. The information contained in this attribute may be updated over time during the VNF LCM, e.g. certificate(s) renewal. 
   * @return certificateContents
   **/
  @Schema(description = "Information for contents of issued certificates. The information contained in this attribute may be updated over time during the VNF LCM, e.g. certificate(s) renewal. ")
      @Valid
    public List<CertificateContent> getCertificateContents() {
    return certificateContents;
  }

  public void setCertificateContents(List<CertificateContent> certificateContents) {
    this.certificateContents = certificateContents;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CertificateInfo certificateInfo = (CertificateInfo) o;
    return Objects.equals(this.id, certificateInfo.id) &&
        Objects.equals(this.certificateConfigurationInfo, certificateInfo.certificateConfigurationInfo) &&
        Objects.equals(this.certificateContents, certificateInfo.certificateContents);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, certificateConfigurationInfo, certificateContents);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CertificateInfo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    certificateConfigurationInfo: ").append(toIndentedString(certificateConfigurationInfo)).append("\n");
    sb.append("    certificateContents: ").append(toIndentedString(certificateContents)).append("\n");
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
