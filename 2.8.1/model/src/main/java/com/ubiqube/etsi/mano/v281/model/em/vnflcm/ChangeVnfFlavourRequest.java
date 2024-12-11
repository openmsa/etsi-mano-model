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
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.ubiqube.etsi.mano.v281.model.em.vnflcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v281.model.em.vnflcm.ExtManagedVirtualLinkData;
import com.ubiqube.etsi.mano.v281.model.em.vnflcm.ExtVirtualLinkData;
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
 * This type represents request parameters for the \&quot;Change VNF flavour\&quot; operation. 
 */
@Schema (description= "This type represents request parameters for the \"Change VNF flavour\" operation. " )
@Validated

public class ChangeVnfFlavourRequest   {
  @JsonProperty("newFlavourId")
  private String newFlavourId = null;

  @JsonProperty("instantiationLevelId")
  private String instantiationLevelId = null;

  @JsonProperty("extVirtualLinks")
  @Valid
  private List<ExtVirtualLinkData> extVirtualLinks = null;

  @JsonProperty("extManagedVirtualLinks")
  @Valid
  private List<ExtManagedVirtualLinkData> extManagedVirtualLinks = null;

  @JsonProperty("additionalParams")
  private Map<String, String> additionalParams = null;

  @JsonProperty("extensions")
  private Map<String, String> extensions = null;

  @JsonProperty("vnfConfigurableProperties")
  private Map<String, String> vnfConfigurableProperties = null;

  public ChangeVnfFlavourRequest newFlavourId(String newFlavourId) {
    this.newFlavourId = newFlavourId;
    return this;
  }

  /**
   * Identifier of the VNF deployment flavour to be instantiated. 
   * @return newFlavourId
  **/
  @Schema(required = true , description = "Identifier of the VNF deployment flavour to be instantiated. ")
  @NotNull


  public String getNewFlavourId() {
    return newFlavourId;
  }

  public void setNewFlavourId(String newFlavourId) {
    this.newFlavourId = newFlavourId;
  }

  public ChangeVnfFlavourRequest instantiationLevelId(String instantiationLevelId) {
    this.instantiationLevelId = instantiationLevelId;
    return this;
  }

  /**
   * Identifier of the instantiation level of the deployment flavour to be instantiated. If not present, the default instantiation level as declared in the VNFD is instantiated. 
   * @return instantiationLevelId
  **/
  @Schema(description = "Identifier of the instantiation level of the deployment flavour to be instantiated. If not present, the default instantiation level as declared in the VNFD is instantiated. ")


  public String getInstantiationLevelId() {
    return instantiationLevelId;
  }

  public void setInstantiationLevelId(String instantiationLevelId) {
    this.instantiationLevelId = instantiationLevelId;
  }

  public ChangeVnfFlavourRequest extVirtualLinks(List<ExtVirtualLinkData> extVirtualLinks) {
    this.extVirtualLinks = extVirtualLinks;
    return this;
  }

  public ChangeVnfFlavourRequest addExtVirtualLinksItem(ExtVirtualLinkData extVirtualLinksItem) {
    if (this.extVirtualLinks == null) {
      this.extVirtualLinks = new ArrayList<>();
    }
    this.extVirtualLinks.add(extVirtualLinksItem);
    return this;
  }

  /**
   * Information about external VLs to connect the VNF to. 
   * @return extVirtualLinks
  **/
  @Schema(description = "Information about external VLs to connect the VNF to. ")

  @Valid

  public List<ExtVirtualLinkData> getExtVirtualLinks() {
    return extVirtualLinks;
  }

  public void setExtVirtualLinks(List<ExtVirtualLinkData> extVirtualLinks) {
    this.extVirtualLinks = extVirtualLinks;
  }

  public ChangeVnfFlavourRequest extManagedVirtualLinks(List<ExtManagedVirtualLinkData> extManagedVirtualLinks) {
    this.extManagedVirtualLinks = extManagedVirtualLinks;
    return this;
  }

  public ChangeVnfFlavourRequest addExtManagedVirtualLinksItem(ExtManagedVirtualLinkData extManagedVirtualLinksItem) {
    if (this.extManagedVirtualLinks == null) {
      this.extManagedVirtualLinks = new ArrayList<>();
    }
    this.extManagedVirtualLinks.add(extManagedVirtualLinksItem);
    return this;
  }

  /**
   * Information about internal VLs that are managed by other entities than the VNFM. NOTE: The indication of externally-managed internal VLs is needed in case networks have been pre-configured for use with certain VNFs, for instance to ensure that these networks have certain properties such as security or acceleration features, or to address particular network topologies. The present document assumes that externally-managed internal VLs are managed by the NFVO and created towards the VIM. 
   * @return extManagedVirtualLinks
  **/
  @Schema(description = "Information about internal VLs that are managed by other entities than the VNFM. NOTE: The indication of externally-managed internal VLs is needed in case networks have been pre-configured for use with certain VNFs, for instance to ensure that these networks have certain properties such as security or acceleration features, or to address particular network topologies. The present document assumes that externally-managed internal VLs are managed by the NFVO and created towards the VIM. ")

  @Valid

  public List<ExtManagedVirtualLinkData> getExtManagedVirtualLinks() {
    return extManagedVirtualLinks;
  }

  public void setExtManagedVirtualLinks(List<ExtManagedVirtualLinkData> extManagedVirtualLinks) {
    this.extManagedVirtualLinks = extManagedVirtualLinks;
  }

  public ChangeVnfFlavourRequest additionalParams(Map<String, String> additionalParams) {
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

  public ChangeVnfFlavourRequest extensions(Map<String, String> extensions) {
    this.extensions = extensions;
    return this;
  }

  /**
   * If present, this attribute provides modifications to the values of the \"extensions\" attribute in \"VnfInstance\", as defined in clause 5.5.2.2. Provisions for handling extensions during the operation, are defined in clause 5.4.7.3.1. 
   * @return extensions
  **/
  @Schema(description = "If present, this attribute provides modifications to the values of the \"extensions\" attribute in \"VnfInstance\", as defined in clause 5.5.2.2. Provisions for handling extensions during the operation, are defined in clause 5.4.7.3.1. ")

  @Valid

  public Map<String, String> getExtensions() {
    return extensions;
  }

  public void setExtensions(Map<String, String> extensions) {
    this.extensions = extensions;
  }

  public ChangeVnfFlavourRequest vnfConfigurableProperties(Map<String, String> vnfConfigurableProperties) {
    this.vnfConfigurableProperties = vnfConfigurableProperties;
    return this;
  }

  /**
   * If present, this attribute provides modifications to the values of the vnfConfigurableProperties\" attribute in \"VnfInstance\", as defined in clause 5.5.2.2. Provisions for handling VNF configurable properties during the operation, are defined in clause 5.4.7.3.1. 
   * @return vnfConfigurableProperties
  **/
  @Schema(description = "If present, this attribute provides modifications to the values of the vnfConfigurableProperties\" attribute in \"VnfInstance\", as defined in clause 5.5.2.2. Provisions for handling VNF configurable properties during the operation, are defined in clause 5.4.7.3.1. ")

  @Valid

  public Map<String, String> getVnfConfigurableProperties() {
    return vnfConfigurableProperties;
  }

  public void setVnfConfigurableProperties(Map<String, String> vnfConfigurableProperties) {
    this.vnfConfigurableProperties = vnfConfigurableProperties;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChangeVnfFlavourRequest changeVnfFlavourRequest = (ChangeVnfFlavourRequest) o;
    return Objects.equals(this.newFlavourId, changeVnfFlavourRequest.newFlavourId) &&
    Objects.equals(this.instantiationLevelId, changeVnfFlavourRequest.instantiationLevelId) &&
    Objects.equals(this.extVirtualLinks, changeVnfFlavourRequest.extVirtualLinks) &&
    Objects.equals(this.extManagedVirtualLinks, changeVnfFlavourRequest.extManagedVirtualLinks) &&
    Objects.equals(this.additionalParams, changeVnfFlavourRequest.additionalParams) &&
    Objects.equals(this.extensions, changeVnfFlavourRequest.extensions) &&
    Objects.equals(this.vnfConfigurableProperties, changeVnfFlavourRequest.vnfConfigurableProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newFlavourId, instantiationLevelId, extVirtualLinks, extManagedVirtualLinks, additionalParams, extensions, vnfConfigurableProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChangeVnfFlavourRequest {\n");

    sb.append("    newFlavourId: ").append(toIndentedString(newFlavourId)).append("\n");
    sb.append("    instantiationLevelId: ").append(toIndentedString(instantiationLevelId)).append("\n");
    sb.append("    extVirtualLinks: ").append(toIndentedString(extVirtualLinks)).append("\n");
    sb.append("    extManagedVirtualLinks: ").append(toIndentedString(extManagedVirtualLinks)).append("\n");
    sb.append("    additionalParams: ").append(toIndentedString(additionalParams)).append("\n");
    sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
    sb.append("    vnfConfigurableProperties: ").append(toIndentedString(vnfConfigurableProperties)).append("\n");
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

