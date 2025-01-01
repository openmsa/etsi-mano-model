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
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.NfvoSpecificInfoSupportedNsdFormats;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.NfvoSpecificInfoSupportedVnfdFormats;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents information attributes specific to an NFVO entity, and that can be relevant to more than one NFV-MANO service offered by an NFVO entity. * NOTE 1: The information to be provided in this attribute shall relate to the specification and version             of the specification. For instance, \&quot;ETSI GS NFV-SOL 001 (V2.5.1)\&quot;.   NOTE 2: If this attribute is not present, the value of this parameter is undefined. 
 */
@Schema(description = "This type represents information attributes specific to an NFVO entity, and that can be relevant to more than one NFV-MANO service offered by an NFVO entity. * NOTE 1: The information to be provided in this attribute shall relate to the specification and version             of the specification. For instance, \"ETSI GS NFV-SOL 001 (V2.5.1)\".   NOTE 2: If this attribute is not present, the value of this parameter is undefined. ")
@Validated



public class NfvoSpecificInfo   {
  @JsonProperty("maxOnboardedNsdNum")
  private Integer maxOnboardedNsdNum = null;

  @JsonProperty("maxOnboardedVnfPkgNum")
  private Integer maxOnboardedVnfPkgNum = null;

  @JsonProperty("supportedVnfdFormats")
  private NfvoSpecificInfoSupportedVnfdFormats supportedVnfdFormats = null;

  @JsonProperty("supportedNsdFormats")
  private NfvoSpecificInfoSupportedNsdFormats supportedNsdFormats = null;

  /**
   * Gets or Sets certificateManagementMode
   */
  public enum CertificateManagementModeEnum {
    DELEGATION_MODE("DELEGATION-MODE"),
    
    DIRECT_MODE("DIRECT-MODE");

    private String value;

    CertificateManagementModeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CertificateManagementModeEnum fromValue(String text) {
      for (CertificateManagementModeEnum b : CertificateManagementModeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("certificateManagementMode")
  @Valid
  private List<CertificateManagementModeEnum> certificateManagementMode = new ArrayList<>();

  public NfvoSpecificInfo maxOnboardedNsdNum(Integer maxOnboardedNsdNum) {
    this.maxOnboardedNsdNum = maxOnboardedNsdNum;
    return this;
  }

  /**
   * Maximum number of NSDs that can be on-boarded on the NFVO. See note 2. 
   * @return maxOnboardedNsdNum
   **/
  @Schema(description = "Maximum number of NSDs that can be on-boarded on the NFVO. See note 2. ")
  
    public Integer getMaxOnboardedNsdNum() {
    return maxOnboardedNsdNum;
  }

  public void setMaxOnboardedNsdNum(Integer maxOnboardedNsdNum) {
    this.maxOnboardedNsdNum = maxOnboardedNsdNum;
  }

  public NfvoSpecificInfo maxOnboardedVnfPkgNum(Integer maxOnboardedVnfPkgNum) {
    this.maxOnboardedVnfPkgNum = maxOnboardedVnfPkgNum;
    return this;
  }

  /**
   * Maximum number of VNF Packages that can be on-boarded on the NFVO. See note 2. 
   * @return maxOnboardedVnfPkgNum
   **/
  @Schema(description = "Maximum number of VNF Packages that can be on-boarded on the NFVO. See note 2. ")
  
    public Integer getMaxOnboardedVnfPkgNum() {
    return maxOnboardedVnfPkgNum;
  }

  public void setMaxOnboardedVnfPkgNum(Integer maxOnboardedVnfPkgNum) {
    this.maxOnboardedVnfPkgNum = maxOnboardedVnfPkgNum;
  }

  public NfvoSpecificInfo supportedVnfdFormats(NfvoSpecificInfoSupportedVnfdFormats supportedVnfdFormats) {
    this.supportedVnfdFormats = supportedVnfdFormats;
    return this;
  }

  /**
   * Get supportedVnfdFormats
   * @return supportedVnfdFormats
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    @Valid
    public NfvoSpecificInfoSupportedVnfdFormats getSupportedVnfdFormats() {
    return supportedVnfdFormats;
  }

  public void setSupportedVnfdFormats(NfvoSpecificInfoSupportedVnfdFormats supportedVnfdFormats) {
    this.supportedVnfdFormats = supportedVnfdFormats;
  }

  public NfvoSpecificInfo supportedNsdFormats(NfvoSpecificInfoSupportedNsdFormats supportedNsdFormats) {
    this.supportedNsdFormats = supportedNsdFormats;
    return this;
  }

  /**
   * Get supportedNsdFormats
   * @return supportedNsdFormats
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    @Valid
    public NfvoSpecificInfoSupportedNsdFormats getSupportedNsdFormats() {
    return supportedNsdFormats;
  }

  public void setSupportedNsdFormats(NfvoSpecificInfoSupportedNsdFormats supportedNsdFormats) {
    this.supportedNsdFormats = supportedNsdFormats;
  }

  public NfvoSpecificInfo certificateManagementMode(List<CertificateManagementModeEnum> certificateManagementMode) {
    this.certificateManagementMode = certificateManagementMode;
    return this;
  }

  public NfvoSpecificInfo addCertificateManagementModeItem(CertificateManagementModeEnum certificateManagementModeItem) {
    this.certificateManagementMode.add(certificateManagementModeItem);
    return this;
  }

  /**
   * The supported list of VNF certificate management mode. Permitted Values: - DELEGATION-MODE: the CMF supports delegation-mode. - DIRECT-MODE: the CMF supports direct-mode. 
   * @return certificateManagementMode
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "The supported list of VNF certificate management mode. Permitted Values: - DELEGATION-MODE: the CMF supports delegation-mode. - DIRECT-MODE: the CMF supports direct-mode. ")
      @NotNull

    public List<CertificateManagementModeEnum> getCertificateManagementMode() {
    return certificateManagementMode;
  }

  public void setCertificateManagementMode(List<CertificateManagementModeEnum> certificateManagementMode) {
    this.certificateManagementMode = certificateManagementMode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NfvoSpecificInfo nfvoSpecificInfo = (NfvoSpecificInfo) o;
    return Objects.equals(this.maxOnboardedNsdNum, nfvoSpecificInfo.maxOnboardedNsdNum) &&
        Objects.equals(this.maxOnboardedVnfPkgNum, nfvoSpecificInfo.maxOnboardedVnfPkgNum) &&
        Objects.equals(this.supportedVnfdFormats, nfvoSpecificInfo.supportedVnfdFormats) &&
        Objects.equals(this.supportedNsdFormats, nfvoSpecificInfo.supportedNsdFormats) &&
        Objects.equals(this.certificateManagementMode, nfvoSpecificInfo.certificateManagementMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxOnboardedNsdNum, maxOnboardedVnfPkgNum, supportedVnfdFormats, supportedNsdFormats, certificateManagementMode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NfvoSpecificInfo {\n");
    
    sb.append("    maxOnboardedNsdNum: ").append(toIndentedString(maxOnboardedNsdNum)).append("\n");
    sb.append("    maxOnboardedVnfPkgNum: ").append(toIndentedString(maxOnboardedVnfPkgNum)).append("\n");
    sb.append("    supportedVnfdFormats: ").append(toIndentedString(supportedVnfdFormats)).append("\n");
    sb.append("    supportedNsdFormats: ").append(toIndentedString(supportedNsdFormats)).append("\n");
    sb.append("    certificateManagementMode: ").append(toIndentedString(certificateManagementMode)).append("\n");
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
