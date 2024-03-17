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
package com.ubiqube.etsi.mano.em.v451.model.vnflcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type provides input information about added, deleted and modified certificate contents. 
 */
@Schema(description = "This type provides input information about added, deleted and modified certificate contents. ")
@Validated


public class AffectedCertificate   {
  @JsonProperty("certificateInfoId")
  private String certificateInfoId = null;

  @JsonProperty("certificateBaseProfileId")
  private String certificateBaseProfileId = null;

  @JsonProperty("securityPolicyId")
  private String securityPolicyId = null;

  @JsonProperty("cmfInfoId")
  private String cmfInfoId = null;

  @JsonProperty("certificateContentId")
  private String certificateContentId = null;

  /**
   * Signals the type of change. 
   */
  public enum ChangeTypeEnum {
    ADD("ADD"),
    
    REMOVE("REMOVE"),
    
    MODIFY("MODIFY");

    private String value;

    ChangeTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ChangeTypeEnum fromValue(String text) {
      for (ChangeTypeEnum b : ChangeTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("changeType")
  private ChangeTypeEnum changeType = null;

  public AffectedCertificate certificateInfoId(String certificateInfoId) {
    this.certificateInfoId = certificateInfoId;
    return this;
  }

  /**
   * Get certificateInfoId
   * @return certificateInfoId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getCertificateInfoId() {
    return certificateInfoId;
  }

  public void setCertificateInfoId(String certificateInfoId) {
    this.certificateInfoId = certificateInfoId;
  }

  public AffectedCertificate certificateBaseProfileId(String certificateBaseProfileId) {
    this.certificateBaseProfileId = certificateBaseProfileId;
    return this;
  }

  /**
   * Get certificateBaseProfileId
   * @return certificateBaseProfileId
   **/
  @Schema(description = "")
  
    public String getCertificateBaseProfileId() {
    return certificateBaseProfileId;
  }

  public void setCertificateBaseProfileId(String certificateBaseProfileId) {
    this.certificateBaseProfileId = certificateBaseProfileId;
  }

  public AffectedCertificate securityPolicyId(String securityPolicyId) {
    this.securityPolicyId = securityPolicyId;
    return this;
  }

  /**
   * Get securityPolicyId
   * @return securityPolicyId
   **/
  @Schema(description = "")
  
    public String getSecurityPolicyId() {
    return securityPolicyId;
  }

  public void setSecurityPolicyId(String securityPolicyId) {
    this.securityPolicyId = securityPolicyId;
  }

  public AffectedCertificate cmfInfoId(String cmfInfoId) {
    this.cmfInfoId = cmfInfoId;
    return this;
  }

  /**
   * Get cmfInfoId
   * @return cmfInfoId
   **/
  @Schema(description = "")
  
    public String getCmfInfoId() {
    return cmfInfoId;
  }

  public void setCmfInfoId(String cmfInfoId) {
    this.cmfInfoId = cmfInfoId;
  }

  public AffectedCertificate certificateContentId(String certificateContentId) {
    this.certificateContentId = certificateContentId;
    return this;
  }

  /**
   * Get certificateContentId
   * @return certificateContentId
   **/
  @Schema(description = "")
  
    public String getCertificateContentId() {
    return certificateContentId;
  }

  public void setCertificateContentId(String certificateContentId) {
    this.certificateContentId = certificateContentId;
  }

  public AffectedCertificate changeType(ChangeTypeEnum changeType) {
    this.changeType = changeType;
    return this;
  }

  /**
   * Signals the type of change. 
   * @return changeType
   **/
  @Schema(required = true, description = "Signals the type of change. ")
      @NotNull

    public ChangeTypeEnum getChangeType() {
    return changeType;
  }

  public void setChangeType(ChangeTypeEnum changeType) {
    this.changeType = changeType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AffectedCertificate affectedCertificate = (AffectedCertificate) o;
    return Objects.equals(this.certificateInfoId, affectedCertificate.certificateInfoId) &&
        Objects.equals(this.certificateBaseProfileId, affectedCertificate.certificateBaseProfileId) &&
        Objects.equals(this.securityPolicyId, affectedCertificate.securityPolicyId) &&
        Objects.equals(this.cmfInfoId, affectedCertificate.cmfInfoId) &&
        Objects.equals(this.certificateContentId, affectedCertificate.certificateContentId) &&
        Objects.equals(this.changeType, affectedCertificate.changeType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(certificateInfoId, certificateBaseProfileId, securityPolicyId, cmfInfoId, certificateContentId, changeType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AffectedCertificate {\n");
    
    sb.append("    certificateInfoId: ").append(toIndentedString(certificateInfoId)).append("\n");
    sb.append("    certificateBaseProfileId: ").append(toIndentedString(certificateBaseProfileId)).append("\n");
    sb.append("    securityPolicyId: ").append(toIndentedString(securityPolicyId)).append("\n");
    sb.append("    cmfInfoId: ").append(toIndentedString(cmfInfoId)).append("\n");
    sb.append("    certificateContentId: ").append(toIndentedString(certificateContentId)).append("\n");
    sb.append("    changeType: ").append(toIndentedString(changeType)).append("\n");
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
