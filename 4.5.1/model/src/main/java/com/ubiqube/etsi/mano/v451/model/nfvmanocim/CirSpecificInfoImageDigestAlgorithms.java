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
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * List of supported digest algorithms that can be used for digital signatures. 
 */
@Schema(description = "List of supported digest algorithms that can be used for digital signatures. ")
@Validated



public class CirSpecificInfoImageDigestAlgorithms   {
  /**
   * The name of the algorithm. Permitted values are: \"SHA2\", \"SHA3\". 
   */
  public enum AlgorithmEnum {
    SHA2("SHA2"),
    
    SHA3("SHA3");

    private String value;

    AlgorithmEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AlgorithmEnum fromValue(String text) {
      for (AlgorithmEnum b : AlgorithmEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("algorithm")
  private AlgorithmEnum algorithm = null;

  @JsonProperty("keyLengths")
  @Valid
  private List<String> keyLengths = new ArrayList<>();

  public CirSpecificInfoImageDigestAlgorithms algorithm(AlgorithmEnum algorithm) {
    this.algorithm = algorithm;
    return this;
  }

  /**
   * The name of the algorithm. Permitted values are: \"SHA2\", \"SHA3\". 
   * @return algorithm
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "The name of the algorithm. Permitted values are: \"SHA2\", \"SHA3\". ")
      @NotNull

    public AlgorithmEnum getAlgorithm() {
    return algorithm;
  }

  public void setAlgorithm(AlgorithmEnum algorithm) {
    this.algorithm = algorithm;
  }

  public CirSpecificInfoImageDigestAlgorithms keyLengths(List<String> keyLengths) {
    this.keyLengths = keyLengths;
    return this;
  }

  public CirSpecificInfoImageDigestAlgorithms addKeyLengthsItem(String keyLengthsItem) {
    this.keyLengths.add(keyLengthsItem);
    return this;
  }

  /**
   * List of supported key lengths of the algorithm. The key length indicates the number of bits, such as \"256\", \"512\", etc. See note. 
   * @return keyLengths
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "List of supported key lengths of the algorithm. The key length indicates the number of bits, such as \"256\", \"512\", etc. See note. ")
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
    CirSpecificInfoImageDigestAlgorithms cirSpecificInfoImageDigestAlgorithms = (CirSpecificInfoImageDigestAlgorithms) o;
    return Objects.equals(this.algorithm, cirSpecificInfoImageDigestAlgorithms.algorithm) &&
        Objects.equals(this.keyLengths, cirSpecificInfoImageDigestAlgorithms.keyLengths);
  }

  @Override
  public int hashCode() {
    return Objects.hash(algorithm, keyLengths);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CirSpecificInfoImageDigestAlgorithms {\n");
    
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
