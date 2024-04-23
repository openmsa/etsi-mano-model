package com.ubiqube.etsi.mano.v451.model.nfvmanocim;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.CirSpecificInfoImageDigestAlgorithms;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.CirSpecificInfoImageSignatureVerification;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents information attributes specific to a CIR entity, and that can be relevant to more than one NFV- MANO service offered by a CIR entity. It shall comply with the provisions defined in table 5.6.3.15-1. NOTE: Recommendations on appropriate algorithms and key lengths are given e.g. in NIST Special Publication 800-57        Part 3 Revision 1 or in documents related to local legislation. 
 */
@Schema(description = "This type represents information attributes specific to a CIR entity, and that can be relevant to more than one NFV- MANO service offered by a CIR entity. It shall comply with the provisions defined in table 5.6.3.15-1. NOTE: Recommendations on appropriate algorithms and key lengths are given e.g. in NIST Special Publication 800-57        Part 3 Revision 1 or in documents related to local legislation. ")
@Validated



public class CirSpecificInfo   {
  @JsonProperty("osContainerImageFormats")
  @Valid
  private List<String> osContainerImageFormats = new ArrayList<>();

  @JsonProperty("imageSignatureVerification")
  private CirSpecificInfoImageSignatureVerification imageSignatureVerification = null;

  @JsonProperty("imageDigestAlgorithms")
  @Valid
  private List<CirSpecificInfoImageDigestAlgorithms> imageDigestAlgorithms = new ArrayList<>();

  public CirSpecificInfo osContainerImageFormats(List<String> osContainerImageFormats) {
    this.osContainerImageFormats = osContainerImageFormats;
    return this;
  }

  public CirSpecificInfo addOsContainerImageFormatsItem(String osContainerImageFormatsItem) {
    this.osContainerImageFormats.add(osContainerImageFormatsItem);
    return this;
  }

  /**
   * List of supported OS container image formats. Valid values are all values for \"container_format\" as defined in ETSI GS NFV-SOL 001 and all values for \"container-format\" as defined in ETSI GS NFV-SOL 006. 
   * @return osContainerImageFormats
   **/
  @Schema(required = true, description = "List of supported OS container image formats. Valid values are all values for \"container_format\" as defined in ETSI GS NFV-SOL 001 and all values for \"container-format\" as defined in ETSI GS NFV-SOL 006. ")
      @NotNull

  @Size(min=1)   public List<String> getOsContainerImageFormats() {
    return osContainerImageFormats;
  }

  public void setOsContainerImageFormats(List<String> osContainerImageFormats) {
    this.osContainerImageFormats = osContainerImageFormats;
  }

  public CirSpecificInfo imageSignatureVerification(CirSpecificInfoImageSignatureVerification imageSignatureVerification) {
    this.imageSignatureVerification = imageSignatureVerification;
    return this;
  }

  /**
   * Get imageSignatureVerification
   * @return imageSignatureVerification
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public CirSpecificInfoImageSignatureVerification getImageSignatureVerification() {
    return imageSignatureVerification;
  }

  public void setImageSignatureVerification(CirSpecificInfoImageSignatureVerification imageSignatureVerification) {
    this.imageSignatureVerification = imageSignatureVerification;
  }

  public CirSpecificInfo imageDigestAlgorithms(List<CirSpecificInfoImageDigestAlgorithms> imageDigestAlgorithms) {
    this.imageDigestAlgorithms = imageDigestAlgorithms;
    return this;
  }

  public CirSpecificInfo addImageDigestAlgorithmsItem(CirSpecificInfoImageDigestAlgorithms imageDigestAlgorithmsItem) {
    this.imageDigestAlgorithms.add(imageDigestAlgorithmsItem);
    return this;
  }

  /**
   * Get imageDigestAlgorithms
   * @return imageDigestAlgorithms
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
    public List<CirSpecificInfoImageDigestAlgorithms> getImageDigestAlgorithms() {
    return imageDigestAlgorithms;
  }

  public void setImageDigestAlgorithms(List<CirSpecificInfoImageDigestAlgorithms> imageDigestAlgorithms) {
    this.imageDigestAlgorithms = imageDigestAlgorithms;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CirSpecificInfo cirSpecificInfo = (CirSpecificInfo) o;
    return Objects.equals(this.osContainerImageFormats, cirSpecificInfo.osContainerImageFormats) &&
        Objects.equals(this.imageSignatureVerification, cirSpecificInfo.imageSignatureVerification) &&
        Objects.equals(this.imageDigestAlgorithms, cirSpecificInfo.imageDigestAlgorithms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(osContainerImageFormats, imageSignatureVerification, imageDigestAlgorithms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CirSpecificInfo {\n");
    
    sb.append("    osContainerImageFormats: ").append(toIndentedString(osContainerImageFormats)).append("\n");
    sb.append("    imageSignatureVerification: ").append(toIndentedString(imageSignatureVerification)).append("\n");
    sb.append("    imageDigestAlgorithms: ").append(toIndentedString(imageDigestAlgorithms)).append("\n");
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
