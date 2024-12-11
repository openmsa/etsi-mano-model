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
package com.ubiqube.etsi.mano.v451.model.em.vnfconfig;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v451.model.em.vnfconfig.CertSubjectData;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type provides input information related to subject of certificate. NOTE : Either set of “privatekey” and “certificateFile” or “keystoreFile” but not both shall be present. 
 */
@Schema(description = "This type provides input information related to subject of certificate. NOTE : Either set of “privatekey” and “certificateFile” or “keystoreFile” but not both shall be present. ")
@Validated


public class CertificateData   {
  @JsonProperty("privateKey")
  private String privateKey = null;

  @JsonProperty("certificateFile")
  private String certificateFile = null;

  @JsonProperty("keystoreFile")
  private String keystoreFile = null;

  @JsonProperty("certSubjectData")
  private CertSubjectData certSubjectData = null;

  @JsonProperty("certifiateProfileName")
  private String certifiateProfileName = null;

  public CertificateData privateKey(String privateKey) {
    this.privateKey = privateKey;
    return this;
  }

  /**
   * Private key paired with the signed public key. VNFM shall generate both the private key and public key and set this attribute. See note. 
   * @return privateKey
   **/
  @Schema(description = "Private key paired with the signed public key. VNFM shall generate both the private key and public key and set this attribute. See note. ")
  
    public String getPrivateKey() {
    return privateKey;
  }

  public void setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
  }

  public CertificateData certificateFile(String certificateFile) {
    this.certificateFile = certificateFile;
    return this;
  }

  /**
   * Signed certificate including the public key and certificate chain. See note. 
   * @return certificateFile
   **/
  @Schema(description = "Signed certificate including the public key and certificate chain. See note. ")
  
    public String getCertificateFile() {
    return certificateFile;
  }

  public void setCertificateFile(String certificateFile) {
    this.certificateFile = certificateFile;
  }

  public CertificateData keystoreFile(String keystoreFile) {
    this.keystoreFile = keystoreFile;
    return this;
  }

  /**
   * Keystore which includes the private key, signed certificate, and certificate chain (e.g., pkcs#12, pfx). Credentials to read this file shall be provided to the VNF instance by outbound. See note. 
   * @return keystoreFile
   **/
  @Schema(description = "Keystore which includes the private key, signed certificate, and certificate chain (e.g., pkcs#12, pfx). Credentials to read this file shall be provided to the VNF instance by outbound. See note. ")
  
    public String getKeystoreFile() {
    return keystoreFile;
  }

  public void setKeystoreFile(String keystoreFile) {
    this.keystoreFile = keystoreFile;
  }

  public CertificateData certSubjectData(CertSubjectData certSubjectData) {
    this.certSubjectData = certSubjectData;
    return this;
  }

  /**
   * Get certSubjectData
   * @return certSubjectData
   **/
  @Schema(description = "")
  
    @Valid
    public CertSubjectData getCertSubjectData() {
    return certSubjectData;
  }

  public void setCertSubjectData(CertSubjectData certSubjectData) {
    this.certSubjectData = certSubjectData;
  }

  public CertificateData certifiateProfileName(String certifiateProfileName) {
    this.certifiateProfileName = certifiateProfileName;
    return this;
  }

  /**
   * Name of the certificate profile to be signed. 
   * @return certifiateProfileName
   **/
  @Schema(description = "Name of the certificate profile to be signed. ")
  
    public String getCertifiateProfileName() {
    return certifiateProfileName;
  }

  public void setCertifiateProfileName(String certifiateProfileName) {
    this.certifiateProfileName = certifiateProfileName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CertificateData certificateData = (CertificateData) o;
    return Objects.equals(this.privateKey, certificateData.privateKey) &&
        Objects.equals(this.certificateFile, certificateData.certificateFile) &&
        Objects.equals(this.keystoreFile, certificateData.keystoreFile) &&
        Objects.equals(this.certSubjectData, certificateData.certSubjectData) &&
        Objects.equals(this.certifiateProfileName, certificateData.certifiateProfileName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(privateKey, certificateFile, keystoreFile, certSubjectData, certifiateProfileName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CertificateData {\n");
    
    sb.append("    privateKey: ").append(toIndentedString(privateKey)).append("\n");
    sb.append("    certificateFile: ").append(toIndentedString(certificateFile)).append("\n");
    sb.append("    keystoreFile: ").append(toIndentedString(keystoreFile)).append("\n");
    sb.append("    certSubjectData: ").append(toIndentedString(certSubjectData)).append("\n");
    sb.append("    certifiateProfileName: ").append(toIndentedString(certifiateProfileName)).append("\n");
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
