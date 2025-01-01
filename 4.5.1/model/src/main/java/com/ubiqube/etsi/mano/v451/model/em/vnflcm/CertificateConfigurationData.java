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
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.CertificateBaseProfile;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.CmfData;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.SecurityPolicy;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type provides input information related to certificate management. 
 */
@Schema(description = "This type provides input information related to certificate management. ")
@Validated


public class CertificateConfigurationData   {
  @JsonProperty("overridingCertificateProfile")
  @Valid
  private List<CertificateBaseProfile> overridingCertificateProfile = null;

  @JsonProperty("securityPolicy")
  @Valid
  private List<SecurityPolicy> securityPolicy = new ArrayList<>();

  @JsonProperty("cmfData")
  private CmfData cmfData = null;

  public CertificateConfigurationData overridingCertificateProfile(List<CertificateBaseProfile> overridingCertificateProfile) {
    this.overridingCertificateProfile = overridingCertificateProfile;
    return this;
  }

  public CertificateConfigurationData addOverridingCertificateProfileItem(CertificateBaseProfile overridingCertificateProfileItem) {
    if (this.overridingCertificateProfile == null) {
      this.overridingCertificateProfile = new ArrayList<>();
    }
    this.overridingCertificateProfile.add(overridingCertificateProfileItem);
    return this;
  }

  /**
   * Overriding certificate profile. This overrides the certificateBaseProfile provided in the VNFD, and the CA and CMF can additionally override aspects of this certificateBaseProfile at later point in the VNF lifecycle if necessary to meet operator security policy. 
   * @return overridingCertificateProfile
   **/
  @Schema(description = "Overriding certificate profile. This overrides the certificateBaseProfile provided in the VNFD, and the CA and CMF can additionally override aspects of this certificateBaseProfile at later point in the VNF lifecycle if necessary to meet operator security policy. ")
      @Valid
    public List<CertificateBaseProfile> getOverridingCertificateProfile() {
    return overridingCertificateProfile;
  }

  public void setOverridingCertificateProfile(List<CertificateBaseProfile> overridingCertificateProfile) {
    this.overridingCertificateProfile = overridingCertificateProfile;
  }

  public CertificateConfigurationData securityPolicy(List<SecurityPolicy> securityPolicy) {
    this.securityPolicy = securityPolicy;
    return this;
  }

  public CertificateConfigurationData addSecurityPolicyItem(SecurityPolicy securityPolicyItem) {
    this.securityPolicy.add(securityPolicyItem);
    return this;
  }

  /**
   * Security policy to be satisfied for certificate. 
   * @return securityPolicy
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Security policy to be satisfied for certificate. ")
      @NotNull
    @Valid
    public List<SecurityPolicy> getSecurityPolicy() {
    return securityPolicy;
  }

  public void setSecurityPolicy(List<SecurityPolicy> securityPolicy) {
    this.securityPolicy = securityPolicy;
  }

  public CertificateConfigurationData cmfData(CmfData cmfData) {
    this.cmfData = cmfData;
    return this;
  }

  /**
   * Get cmfData
   * @return cmfData
   **/
  @Schema(description = "")
  
    @Valid
    public CmfData getCmfData() {
    return cmfData;
  }

  public void setCmfData(CmfData cmfData) {
    this.cmfData = cmfData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CertificateConfigurationData certificateConfigurationData = (CertificateConfigurationData) o;
    return Objects.equals(this.overridingCertificateProfile, certificateConfigurationData.overridingCertificateProfile) &&
        Objects.equals(this.securityPolicy, certificateConfigurationData.securityPolicy) &&
        Objects.equals(this.cmfData, certificateConfigurationData.cmfData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(overridingCertificateProfile, securityPolicy, cmfData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CertificateConfigurationData {\n");
    
    sb.append("    overridingCertificateProfile: ").append(toIndentedString(overridingCertificateProfile)).append("\n");
    sb.append("    securityPolicy: ").append(toIndentedString(securityPolicy)).append("\n");
    sb.append("    cmfData: ").append(toIndentedString(cmfData)).append("\n");
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
