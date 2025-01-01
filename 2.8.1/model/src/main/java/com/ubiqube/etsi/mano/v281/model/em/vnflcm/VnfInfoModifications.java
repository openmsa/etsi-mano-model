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
import com.ubiqube.etsi.mano.v281.model.em.vnflcm.VnfcInfoModifications;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents attribute modifications that were performed on an \&quot;Individual VNF instance\&quot; resource. The attributes that can be included consist of those requested to be modified explicitly in the \&quot;VnfInfoModificationRequest\&quot; data structure, and additional attributes of the \&quot;VnfInstance\&quot; data structure that were modified implicitly e.g. when modifying the referenced VNF package. 
 */
@Schema (description= "This type represents attribute modifications that were performed on an \"Individual VNF instance\" resource. The attributes that can be included consist of those requested to be modified explicitly in the \"VnfInfoModificationRequest\" data structure, and additional attributes of the \"VnfInstance\" data structure that were modified implicitly e.g. when modifying the referenced VNF package. " )
@Validated

public class VnfInfoModifications   {
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

  @JsonProperty("vnfdId")
  private String vnfdId = null;

  @JsonProperty("vnfProvider")
  private String vnfProvider = null;

  @JsonProperty("vnfProductName")
  private String vnfProductName = null;

  @JsonProperty("vnfSoftwareVersion")
  private String vnfSoftwareVersion = null;

  @JsonProperty("vnfdVersion")
  private String vnfdVersion = null;

  @JsonProperty("vnfcInfoModifications")
  @Valid
  private List<VnfcInfoModifications> vnfcInfoModifications = null;

  @JsonProperty("vnfcInfoModificationsDeleteIds")
  @Valid
  private List<String> vnfcInfoModificationsDeleteIds = null;

  public VnfInfoModifications vnfInstanceName(String vnfInstanceName) {
    this.vnfInstanceName = vnfInstanceName;
    return this;
  }

  /**
   * If present, this attribute signals modifications of the \"vnfInstanceName\" attribute in \"VnfInstance\". 
   * @return vnfInstanceName
  **/
  @Schema(description = "If present, this attribute signals modifications of the \"vnfInstanceName\" attribute in \"VnfInstance\". ")


  public String getVnfInstanceName() {
    return vnfInstanceName;
  }

  public void setVnfInstanceName(String vnfInstanceName) {
    this.vnfInstanceName = vnfInstanceName;
  }

  public VnfInfoModifications vnfInstanceDescription(String vnfInstanceDescription) {
    this.vnfInstanceDescription = vnfInstanceDescription;
    return this;
  }

  /**
   * If present, this attribute signals modifications of the \"vnfInstanceDescription\" attribute in \"VnfInstance\". 
   * @return vnfInstanceDescription
  **/
  @Schema(description = "If present, this attribute signals modifications of the \"vnfInstanceDescription\" attribute in \"VnfInstance\". ")


  public String getVnfInstanceDescription() {
    return vnfInstanceDescription;
  }

  public void setVnfInstanceDescription(String vnfInstanceDescription) {
    this.vnfInstanceDescription = vnfInstanceDescription;
  }

  public VnfInfoModifications vnfConfigurableProperties(Map<String, String> vnfConfigurableProperties) {
    this.vnfConfigurableProperties = vnfConfigurableProperties;
    return this;
  }

  /**
   * If present, this attribute signals modifications of the \"vnfConfigurableProperties\" attribute in \"VnfInstance\". 
   * @return vnfConfigurableProperties
  **/
  @Schema(description = "If present, this attribute signals modifications of the \"vnfConfigurableProperties\" attribute in \"VnfInstance\". ")

  @Valid

  public Map<String, String> getVnfConfigurableProperties() {
    return vnfConfigurableProperties;
  }

  public void setVnfConfigurableProperties(Map<String, String> vnfConfigurableProperties) {
    this.vnfConfigurableProperties = vnfConfigurableProperties;
  }

  public VnfInfoModifications metadata(Map<String, String> metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * If present, this attribute signals modifications of the \"metadata\" attribute in \"VnfInstance\". 
   * @return metadata
  **/
  @Schema(description = "If present, this attribute signals modifications of the \"metadata\" attribute in \"VnfInstance\". ")

  @Valid

  public Map<String, String> getMetadata() {
    return metadata;
  }

  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }

  public VnfInfoModifications extensions(Map<String, String> extensions) {
    this.extensions = extensions;
    return this;
  }

  /**
   * If present, this attribute signals modifications of the \"extensions\" attribute in \"VnfInstance\". 
   * @return extensions
  **/
  @Schema(description = "If present, this attribute signals modifications of the \"extensions\" attribute in \"VnfInstance\". ")

  @Valid

  public Map<String, String> getExtensions() {
    return extensions;
  }

  public void setExtensions(Map<String, String> extensions) {
    this.extensions = extensions;
  }

  public VnfInfoModifications vnfdId(String vnfdId) {
    this.vnfdId = vnfdId;
    return this;
  }

  /**
   * If present, this attribute signals modifications of the \"vnfdId\" attribute in \"VnfInstance\". 
   * @return vnfdId
  **/
  @Schema(description = "If present, this attribute signals modifications of the \"vnfdId\" attribute in \"VnfInstance\". ")


  public String getVnfdId() {
    return vnfdId;
  }

  public void setVnfdId(String vnfdId) {
    this.vnfdId = vnfdId;
  }

  public VnfInfoModifications vnfProvider(String vnfProvider) {
    this.vnfProvider = vnfProvider;
    return this;
  }

  /**
   * If present, this attribute signals modifications of the \"vnfProvider\" attribute in \"VnfInstance\". If present, this attribute (which depends on the value of the \"vnfPkgId\" attribute) was modified implicitly following a request to modify the \"vnfPkgId\" attribute, by copying the value of this attribute from the VNFD in the VNF Package identified by the \"vnfPkgId” attribute. 
   * @return vnfProvider
  **/
  @Schema(description = "If present, this attribute signals modifications of the \"vnfProvider\" attribute in \"VnfInstance\". If present, this attribute (which depends on the value of the \"vnfPkgId\" attribute) was modified implicitly following a request to modify the \"vnfPkgId\" attribute, by copying the value of this attribute from the VNFD in the VNF Package identified by the \"vnfPkgId” attribute. ")


  public String getVnfProvider() {
    return vnfProvider;
  }

  public void setVnfProvider(String vnfProvider) {
    this.vnfProvider = vnfProvider;
  }

  public VnfInfoModifications vnfProductName(String vnfProductName) {
    this.vnfProductName = vnfProductName;
    return this;
  }

  /**
   * If present, this attribute signals modifications of the \"vnfProductName\" attribute in \"VnfInstance\". If present, this attribute (which depends on the value of the \"vnfPkgId\" attribute) was modified implicitly following a request to modify the \"vnfPkgId\" attribute, by copying the value of this attribute from the VNFD in the VNF Package identified by the \"vnfPkgId” attribute. 
   * @return vnfProductName
  **/
  @Schema(description = "If present, this attribute signals modifications of the \"vnfProductName\" attribute in \"VnfInstance\". If present, this attribute (which depends on the value of the \"vnfPkgId\" attribute) was modified implicitly following a request to modify the \"vnfPkgId\" attribute, by copying the value of this attribute from the VNFD in the VNF Package identified by the \"vnfPkgId” attribute. ")


  public String getVnfProductName() {
    return vnfProductName;
  }

  public void setVnfProductName(String vnfProductName) {
    this.vnfProductName = vnfProductName;
  }

  public VnfInfoModifications vnfSoftwareVersion(String vnfSoftwareVersion) {
    this.vnfSoftwareVersion = vnfSoftwareVersion;
    return this;
  }

  /**
   * If present, this attribute signals modifications of the \"vnfSoftwareVersion\" attribute in \"VnfInstance\". 
   * @return vnfSoftwareVersion
  **/
  @Schema(description = "If present, this attribute signals modifications of the \"vnfSoftwareVersion\" attribute in \"VnfInstance\". ")


  public String getVnfSoftwareVersion() {
    return vnfSoftwareVersion;
  }

  public void setVnfSoftwareVersion(String vnfSoftwareVersion) {
    this.vnfSoftwareVersion = vnfSoftwareVersion;
  }

  public VnfInfoModifications vnfdVersion(String vnfdVersion) {
    this.vnfdVersion = vnfdVersion;
    return this;
  }

  /**
   * If present, this attribute signals modifications of the \"vnfdVersion\" attribute in \"VnfInstance\". If present, this attribute (which depends on the value of the \"vnfdId\" attribute) was modified implicitly following a request to modify the \"vnfdId\" attribute, by copying the value of this attribute from the VNFD in the VNF Package identified by the \"vnfdId” attribute. 
   * @return vnfdVersion
  **/
  @Schema(description = "If present, this attribute signals modifications of the \"vnfdVersion\" attribute in \"VnfInstance\". If present, this attribute (which depends on the value of the \"vnfdId\" attribute) was modified implicitly following a request to modify the \"vnfdId\" attribute, by copying the value of this attribute from the VNFD in the VNF Package identified by the \"vnfdId” attribute. ")


  public String getVnfdVersion() {
    return vnfdVersion;
  }

  public void setVnfdVersion(String vnfdVersion) {
    this.vnfdVersion = vnfdVersion;
  }

  public VnfInfoModifications vnfcInfoModifications(List<VnfcInfoModifications> vnfcInfoModifications) {
    this.vnfcInfoModifications = vnfcInfoModifications;
    return this;
  }

  public VnfInfoModifications addVnfcInfoModificationsItem(VnfcInfoModifications vnfcInfoModificationsItem) {
    if (this.vnfcInfoModifications == null) {
      this.vnfcInfoModifications = new ArrayList<>();
    }
    this.vnfcInfoModifications.add(vnfcInfoModificationsItem);
    return this;
  }

  /**
   * If present, this attribute signals modifications of certain entries in the \"vnfcInfo\" attribute array in the \"instantiatedVnfInfo\" attribute of \"VnfInstance\", as defined in clause 5.5.2.12 
   * @return vnfcInfoModifications
  **/
  @Schema(description = "If present, this attribute signals modifications of certain entries in the \"vnfcInfo\" attribute array in the \"instantiatedVnfInfo\" attribute of \"VnfInstance\", as defined in clause 5.5.2.12 ")

  @Valid

  public List<VnfcInfoModifications> getVnfcInfoModifications() {
    return vnfcInfoModifications;
  }

  public void setVnfcInfoModifications(List<VnfcInfoModifications> vnfcInfoModifications) {
    this.vnfcInfoModifications = vnfcInfoModifications;
  }

  public VnfInfoModifications vnfcInfoModificationsDeleteIds(List<String> vnfcInfoModificationsDeleteIds) {
    this.vnfcInfoModificationsDeleteIds = vnfcInfoModificationsDeleteIds;
    return this;
  }

  public VnfInfoModifications addVnfcInfoModificationsDeleteIdsItem(String vnfcInfoModificationsDeleteIdsItem) {
    if (this.vnfcInfoModificationsDeleteIds == null) {
      this.vnfcInfoModificationsDeleteIds = new ArrayList<>();
    }
    this.vnfcInfoModificationsDeleteIds.add(vnfcInfoModificationsDeleteIdsItem);
    return this;
  }

  /**
   * If present, this attribute signals the deletion of certain entries in the \"vnfcInfo\" attribute array in the \"instantiatedVnfInfo\" attribute of \"VnfInstance\", as defined in clause 5.5.2.12 
   * @return vnfcInfoModificationsDeleteIds
  **/
  @Schema(description = "If present, this attribute signals the deletion of certain entries in the \"vnfcInfo\" attribute array in the \"instantiatedVnfInfo\" attribute of \"VnfInstance\", as defined in clause 5.5.2.12 ")


  public List<String> getVnfcInfoModificationsDeleteIds() {
    return vnfcInfoModificationsDeleteIds;
  }

  public void setVnfcInfoModificationsDeleteIds(List<String> vnfcInfoModificationsDeleteIds) {
    this.vnfcInfoModificationsDeleteIds = vnfcInfoModificationsDeleteIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VnfInfoModifications vnfInfoModifications = (VnfInfoModifications) o;
    return Objects.equals(this.vnfInstanceName, vnfInfoModifications.vnfInstanceName) &&
    Objects.equals(this.vnfInstanceDescription, vnfInfoModifications.vnfInstanceDescription) &&
    Objects.equals(this.vnfConfigurableProperties, vnfInfoModifications.vnfConfigurableProperties) &&
    Objects.equals(this.metadata, vnfInfoModifications.metadata) &&
    Objects.equals(this.extensions, vnfInfoModifications.extensions) &&
    Objects.equals(this.vnfdId, vnfInfoModifications.vnfdId) &&
    Objects.equals(this.vnfProvider, vnfInfoModifications.vnfProvider) &&
    Objects.equals(this.vnfProductName, vnfInfoModifications.vnfProductName) &&
    Objects.equals(this.vnfSoftwareVersion, vnfInfoModifications.vnfSoftwareVersion) &&
    Objects.equals(this.vnfdVersion, vnfInfoModifications.vnfdVersion) &&
    Objects.equals(this.vnfcInfoModifications, vnfInfoModifications.vnfcInfoModifications) &&
    Objects.equals(this.vnfcInfoModificationsDeleteIds, vnfInfoModifications.vnfcInfoModificationsDeleteIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vnfInstanceName, vnfInstanceDescription, vnfConfigurableProperties, metadata, extensions, vnfdId, vnfProvider, vnfProductName, vnfSoftwareVersion, vnfdVersion, vnfcInfoModifications, vnfcInfoModificationsDeleteIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VnfInfoModifications {\n");

    sb.append("    vnfInstanceName: ").append(toIndentedString(vnfInstanceName)).append("\n");
    sb.append("    vnfInstanceDescription: ").append(toIndentedString(vnfInstanceDescription)).append("\n");
    sb.append("    vnfConfigurableProperties: ").append(toIndentedString(vnfConfigurableProperties)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
    sb.append("    vnfdId: ").append(toIndentedString(vnfdId)).append("\n");
    sb.append("    vnfProvider: ").append(toIndentedString(vnfProvider)).append("\n");
    sb.append("    vnfProductName: ").append(toIndentedString(vnfProductName)).append("\n");
    sb.append("    vnfSoftwareVersion: ").append(toIndentedString(vnfSoftwareVersion)).append("\n");
    sb.append("    vnfdVersion: ").append(toIndentedString(vnfdVersion)).append("\n");
    sb.append("    vnfcInfoModifications: ").append(toIndentedString(vnfcInfoModifications)).append("\n");
    sb.append("    vnfcInfoModificationsDeleteIds: ").append(toIndentedString(vnfcInfoModificationsDeleteIds)).append("\n");
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

