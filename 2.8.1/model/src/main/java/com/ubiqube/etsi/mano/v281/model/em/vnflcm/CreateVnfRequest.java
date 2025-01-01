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
package com.ubiqube.etsi.mano.v281.model.em.vnflcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * CreateVnfRequest
 */
@Validated

public class CreateVnfRequest   {
  @JsonProperty("vnfdId")
  private String vnfdId = null;

  @JsonProperty("vnfInstanceName")
  private String vnfInstanceName = null;

  @JsonProperty("vnfInstanceDescription")
  private String vnfInstanceDescription = null;

  @JsonProperty("metadata")
  private Map<String, String> metadata = null;

  public CreateVnfRequest vnfdId(String vnfdId) {
    this.vnfdId = vnfdId;
    return this;
  }

  /**
   * Identifier that identifies the VNFD which defines the VNF instance to be created. 
   * @return vnfdId
  **/
  @Schema(required = true , description = "Identifier that identifies the VNFD which defines the VNF instance to be created. ")
  @NotNull


  public String getVnfdId() {
    return vnfdId;
  }

  public void setVnfdId(String vnfdId) {
    this.vnfdId = vnfdId;
  }

  public CreateVnfRequest vnfInstanceName(String vnfInstanceName) {
    this.vnfInstanceName = vnfInstanceName;
    return this;
  }

  /**
   * Human-readable name of the VNF instance to be created. 
   * @return vnfInstanceName
  **/
  @Schema(description = "Human-readable name of the VNF instance to be created. ")


  public String getVnfInstanceName() {
    return vnfInstanceName;
  }

  public void setVnfInstanceName(String vnfInstanceName) {
    this.vnfInstanceName = vnfInstanceName;
  }

  public CreateVnfRequest vnfInstanceDescription(String vnfInstanceDescription) {
    this.vnfInstanceDescription = vnfInstanceDescription;
    return this;
  }

  /**
   * Human-readable description of the VNF instance to be created. 
   * @return vnfInstanceDescription
  **/
  @Schema(description = "Human-readable description of the VNF instance to be created. ")


  public String getVnfInstanceDescription() {
    return vnfInstanceDescription;
  }

  public void setVnfInstanceDescription(String vnfInstanceDescription) {
    this.vnfInstanceDescription = vnfInstanceDescription;
  }

  public CreateVnfRequest metadata(Map<String, String> metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * If present, this attribute provides additional initial values, overriding those  obtained from the VNFD, for the \"metadata\" attribute in \"VnfInstance\", as defined  in clause 5.5.2.2. Provisions for handling metadata during the operation are defined  in clause 5.4.2.3.1. 
   * @return metadata
  **/
  @Schema(description = "If present, this attribute provides additional initial values, overriding those  obtained from the VNFD, for the \"metadata\" attribute in \"VnfInstance\", as defined  in clause 5.5.2.2. Provisions for handling metadata during the operation are defined  in clause 5.4.2.3.1. ")

  @Valid

  public Map<String, String> getMetadata() {
    return metadata;
  }

  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateVnfRequest createVnfRequest = (CreateVnfRequest) o;
    return Objects.equals(this.vnfdId, createVnfRequest.vnfdId) &&
    Objects.equals(this.vnfInstanceName, createVnfRequest.vnfInstanceName) &&
    Objects.equals(this.vnfInstanceDescription, createVnfRequest.vnfInstanceDescription) &&
    Objects.equals(this.metadata, createVnfRequest.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vnfdId, vnfInstanceName, vnfInstanceDescription, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateVnfRequest {\n");

    sb.append("    vnfdId: ").append(toIndentedString(vnfdId)).append("\n");
    sb.append("    vnfInstanceName: ").append(toIndentedString(vnfInstanceName)).append("\n");
    sb.append("    vnfInstanceDescription: ").append(toIndentedString(vnfInstanceDescription)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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

