package com.ubiqube.etsi.mano.v451.model.nfvmanocim;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * VimSpecificInfoImageDigestAlgorithms
 */
@Validated



public class VimSpecificInfoImageDigestAlgorithms   {
  @JsonProperty("algorithm")
  private String algorithm = null;

  @JsonProperty("keyLengths")
  @Valid
  private List<String> keyLengths = new ArrayList<>();

  public VimSpecificInfoImageDigestAlgorithms algorithm(String algorithm) {
    this.algorithm = algorithm;
    return this;
  }

  /**
   * The name of the algorithm. Permitted values are: “SHA2“,“SHA3“. 
   * @return algorithm
   **/
  @Schema(required = true, description = "The name of the algorithm. Permitted values are: “SHA2“,“SHA3“. ")
      @NotNull

    public String getAlgorithm() {
    return algorithm;
  }

  public void setAlgorithm(String algorithm) {
    this.algorithm = algorithm;
  }

  public VimSpecificInfoImageDigestAlgorithms keyLengths(List<String> keyLengths) {
    this.keyLengths = keyLengths;
    return this;
  }

  public VimSpecificInfoImageDigestAlgorithms addKeyLengthsItem(String keyLengthsItem) {
    this.keyLengths.add(keyLengthsItem);
    return this;
  }

  /**
   * List of supported key lengths of the algorithm. The key length indicates the number of bits, such as “256”, “512”, etc. See note. 
   * @return keyLengths
   **/
  @Schema(required = true, description = "List of supported key lengths of the algorithm. The key length indicates the number of bits, such as “256”, “512”, etc. See note. ")
      @NotNull

    public List<String> getKeyLengths() {
    return keyLengths;
  }

  public void setKeyLengths(List<String> keyLengths) {
    this.keyLengths = keyLengths;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VimSpecificInfoImageDigestAlgorithms vimSpecificInfoImageDigestAlgorithms = (VimSpecificInfoImageDigestAlgorithms) o;
    return Objects.equals(this.algorithm, vimSpecificInfoImageDigestAlgorithms.algorithm) &&
        Objects.equals(this.keyLengths, vimSpecificInfoImageDigestAlgorithms.keyLengths);
  }

  @Override
  public int hashCode() {
    return Objects.hash(algorithm, keyLengths);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VimSpecificInfoImageDigestAlgorithms {\n");
    
    sb.append("    algorithm: ").append(toIndentedString(algorithm)).append("\n");
    sb.append("    keyLengths: ").append(toIndentedString(keyLengths)).append("\n");
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
