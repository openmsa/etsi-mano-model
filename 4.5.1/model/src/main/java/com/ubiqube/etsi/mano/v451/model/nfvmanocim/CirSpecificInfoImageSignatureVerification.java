package com.ubiqube.etsi.mano.v451.model.nfvmanocim;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.CirSpecificInfoImageSignatureVerificationSignatureVerificationAlgorithms;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
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
  @Schema(required = true, description = "List of algorithms for verifying the signature of software images  that are supported by the CIR. ")
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
