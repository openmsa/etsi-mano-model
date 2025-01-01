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
package com.ubiqube.etsi.mano.v281.model.nfvo.nslcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Map;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type defines the additional parameters for the VNF instance to be created associated with an NS instance. It shall comply with the provisions defined in Table 6.5.3.22-1. 
 */
@Schema (description= "This type defines the additional parameters for the VNF instance to be created associated with an NS instance. It shall comply with the provisions defined in Table 6.5.3.22-1. " )
@Validated

public class ParamsForVnf   {
  @JsonProperty("vnfProfileId")
  private String vnfProfileId = null;

  @JsonProperty("vnfInstanceName")
  private String vnfInstanceName = null;

  @JsonProperty("vnfInstanceDescription")
  private String vnfInstanceDescription = null;

  @JsonProperty("vnfConfigurableProperties")
  private Map<String, String> vnfConfigurableProperties = null;

  @JsonProperty("metadata")
  private Map<String, String> metadata = null;

  @JsonProperty("extensions")
  private Map<String, String> extensions = null;

  @JsonProperty("additionalParams")
  private Map<String, String> additionalParams = null;

  public ParamsForVnf vnfProfileId(String vnfProfileId) {
    this.vnfProfileId = vnfProfileId;
    return this;
  }

  /**
   * Identifier of (reference to) a vnfProfile to which the additional parameters apply. 
   * @return vnfProfileId
  **/
  @Schema(required = true , description = "Identifier of (reference to) a vnfProfile to which the additional parameters apply. ")
  @NotNull


  public String getVnfProfileId() {
    return vnfProfileId;
  }

  public void setVnfProfileId(String vnfProfileId) {
    this.vnfProfileId = vnfProfileId;
  }

  public ParamsForVnf vnfInstanceName(String vnfInstanceName) {
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

  public ParamsForVnf vnfInstanceDescription(String vnfInstanceDescription) {
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

  public ParamsForVnf vnfConfigurableProperties(Map<String, String> vnfConfigurableProperties) {
    this.vnfConfigurableProperties = vnfConfigurableProperties;
    return this;
  }

  /**
   * Values for the \"vnfConfigurableProperties\" input parameter of the Instantiate VNF operation defined in ETSI GS NFV-SOL 003 [4]. 
   * @return vnfConfigurableProperties
  **/
  @Schema(description = "Values for the \"vnfConfigurableProperties\" input parameter of the Instantiate VNF operation defined in ETSI GS NFV-SOL 003 [4]. ")

  @Valid

  public Map<String, String> getVnfConfigurableProperties() {
    return vnfConfigurableProperties;
  }

  public void setVnfConfigurableProperties(Map<String, String> vnfConfigurableProperties) {
    this.vnfConfigurableProperties = vnfConfigurableProperties;
  }

  public ParamsForVnf metadata(Map<String, String> metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Values for the \"metadata\" input parameter of the Create VNF Identifier operation defined in ETSI GS NFV-SOL 003 [4]. 
   * @return metadata
  **/
  @Schema(description = "Values for the \"metadata\" input parameter of the Create VNF Identifier operation defined in ETSI GS NFV-SOL 003 [4]. ")

  @Valid

  public Map<String, String> getMetadata() {
    return metadata;
  }

  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }

  public ParamsForVnf extensions(Map<String, String> extensions) {
    this.extensions = extensions;
    return this;
  }

  /**
   * Values for the \"extensions\" attribute of the Instantiate VNF operation defined in ETSI GS NFV-SOL 003 [4]. 
   * @return extensions
  **/
  @Schema(description = "Values for the \"extensions\" attribute of the Instantiate VNF operation defined in ETSI GS NFV-SOL 003 [4]. ")

  @Valid

  public Map<String, String> getExtensions() {
    return extensions;
  }

  public void setExtensions(Map<String, String> extensions) {
    this.extensions = extensions;
  }

  public ParamsForVnf additionalParams(Map<String, String> additionalParams) {
    this.additionalParams = additionalParams;
    return this;
  }

  /**
   * Additional input parameters for the instantiation process, specific to the VNF being instantiated, as declared in the VNFD as part of \"InstantiateVnfOpConfig\". 
   * @return additionalParams
  **/
  @Schema(description = "Additional input parameters for the instantiation process, specific to the VNF being instantiated, as declared in the VNFD as part of \"InstantiateVnfOpConfig\". ")

  @Valid

  public Map<String, String> getAdditionalParams() {
    return additionalParams;
  }

  public void setAdditionalParams(Map<String, String> additionalParams) {
    this.additionalParams = additionalParams;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParamsForVnf paramsForVnf = (ParamsForVnf) o;
    return Objects.equals(this.vnfProfileId, paramsForVnf.vnfProfileId) &&
    Objects.equals(this.vnfInstanceName, paramsForVnf.vnfInstanceName) &&
    Objects.equals(this.vnfInstanceDescription, paramsForVnf.vnfInstanceDescription) &&
    Objects.equals(this.vnfConfigurableProperties, paramsForVnf.vnfConfigurableProperties) &&
    Objects.equals(this.metadata, paramsForVnf.metadata) &&
    Objects.equals(this.extensions, paramsForVnf.extensions) &&
    Objects.equals(this.additionalParams, paramsForVnf.additionalParams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vnfProfileId, vnfInstanceName, vnfInstanceDescription, vnfConfigurableProperties, metadata, extensions, additionalParams);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParamsForVnf {\n");

    sb.append("    vnfProfileId: ").append(toIndentedString(vnfProfileId)).append("\n");
    sb.append("    vnfInstanceName: ").append(toIndentedString(vnfInstanceName)).append("\n");
    sb.append("    vnfInstanceDescription: ").append(toIndentedString(vnfInstanceDescription)).append("\n");
    sb.append("    vnfConfigurableProperties: ").append(toIndentedString(vnfConfigurableProperties)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
    sb.append("    additionalParams: ").append(toIndentedString(additionalParams)).append("\n");
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

