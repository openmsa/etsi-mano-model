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
package com.ubiqube.etsi.mano.v451.model.nfvmanocim;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.CirSpecificInfoImageSignatureVerificationSignatureVerificationAlgorithms;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Information about the supported mechanisms, algorithms, and protocols for verifying the of software images. 
 */
@Schema(description = "Information about the supported mechanisms, algorithms, and protocols for verifying the of software images. ")
@Validated



public class CirSpecificInfoImageSignatureVerification   {
  @JsonProperty("signatureVerificationAlgorithms")
  @Valid
  private List<CirSpecificInfoImageSignatureVerificationSignatureVerificationAlgorithms> signatureVerificationAlgorithms = new ArrayList<>();

  public CirSpecificInfoImageSignatureVerification signatureVerificationAlgorithms(List<CirSpecificInfoImageSignatureVerificationSignatureVerificationAlgorithms> signatureVerificationAlgorithms) {
    this.signatureVerificationAlgorithms = signatureVerificationAlgorithms;
    return this;
  }

  public CirSpecificInfoImageSignatureVerification addSignatureVerificationAlgorithmsItem(CirSpecificInfoImageSignatureVerificationSignatureVerificationAlgorithms signatureVerificationAlgorithmsItem) {
    this.signatureVerificationAlgorithms.add(signatureVerificationAlgorithmsItem);
    return this;
  }

  /**
   * List of algorithms for verifying the signature of software images  that are supported by the CIR. 
   * @return signatureVerificationAlgorithms
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "List of algorithms for verifying the signature of software images  that are supported by the CIR. ")
      @NotNull
    @Valid
    public List<CirSpecificInfoImageSignatureVerificationSignatureVerificationAlgorithms> getSignatureVerificationAlgorithms() {
    return signatureVerificationAlgorithms;
  }

  public void setSignatureVerificationAlgorithms(List<CirSpecificInfoImageSignatureVerificationSignatureVerificationAlgorithms> signatureVerificationAlgorithms) {
    this.signatureVerificationAlgorithms = signatureVerificationAlgorithms;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CirSpecificInfoImageSignatureVerification cirSpecificInfoImageSignatureVerification = (CirSpecificInfoImageSignatureVerification) o;
    return Objects.equals(this.signatureVerificationAlgorithms, cirSpecificInfoImageSignatureVerification.signatureVerificationAlgorithms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(signatureVerificationAlgorithms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CirSpecificInfoImageSignatureVerification {\n");
    
    sb.append("    signatureVerificationAlgorithms: ").append(toIndentedString(signatureVerificationAlgorithms)).append("\n");
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
