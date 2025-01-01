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
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ubiqube.etsi.mano.v281.model.em.vnflcm.ResourceHandle;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * VnfLinkPortInfo
 */
@Validated

public class VnfLinkPortInfo   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("resourceHandle")
  private ResourceHandle resourceHandle = null;

  @JsonProperty("cpInstanceId")
  private String cpInstanceId = null;

  /**
   * Type of the CP instance that is identified by cpInstanceId. Shall be present if \"cpInstanceId\" is present, and shall be absent otherwise. Permitted values: VNFC_CP: The link port is connected to a VNFC CP EXT_CP: The link port is associated to an external CP. 
   */
  public enum CpInstanceTypeEnum {
    VNFC_CP("VNFC_CP"),
    
    EXT_CP("EXT_CP");

    private String value;

    CpInstanceTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CpInstanceTypeEnum fromValue(String text) {
      for (CpInstanceTypeEnum b : CpInstanceTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("cpInstanceType")
  private CpInstanceTypeEnum cpInstanceType = null;

  public VnfLinkPortInfo id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of this link port as provided by the entity that has created the link port. 
   * @return id
  **/
  @Schema(required = true , description = "Identifier of this link port as provided by the entity that has created the link port. ")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public VnfLinkPortInfo resourceHandle(ResourceHandle resourceHandle) {
    this.resourceHandle = resourceHandle;
    return this;
  }

  /**
   * Reference to the virtualised resource realizing this link port. 
   * @return resourceHandle
  **/
  @Schema(required = true , description = "Reference to the virtualised resource realizing this link port. ")
  @NotNull

  @Valid

  public ResourceHandle getResourceHandle() {
    return resourceHandle;
  }

  public void setResourceHandle(ResourceHandle resourceHandle) {
    this.resourceHandle = resourceHandle;
  }

  public VnfLinkPortInfo cpInstanceId(String cpInstanceId) {
    this.cpInstanceId = cpInstanceId;
    return this;
  }

  /**
   * When the link port is used for external connectivity by the VNF, this attribute represents the identifier of the external CP of the VNF to be connected to this link port. When the link port is used for internal connectivity in the VNF, this attribute represents the identifier of the VNFC CP to be connected to this link port. Shall be present when the link port is used for external connectivity by the VNF. May be present if used to reference a VNFC CP instance. There shall be at most one link port associated with any external connection point instance or internal connection point (i.e. VNFC CP) instance. The value refers to an \"extCpInfo\" item in the VnfInstance or a \"vnfcCpInfo\" item of a \"vnfcResouceInfo\" item in the VnfInstance. 
   * @return cpInstanceId
  **/
  @Schema(description = "When the link port is used for external connectivity by the VNF, this attribute represents the identifier of the external CP of the VNF to be connected to this link port. When the link port is used for internal connectivity in the VNF, this attribute represents the identifier of the VNFC CP to be connected to this link port. Shall be present when the link port is used for external connectivity by the VNF. May be present if used to reference a VNFC CP instance. There shall be at most one link port associated with any external connection point instance or internal connection point (i.e. VNFC CP) instance. The value refers to an \"extCpInfo\" item in the VnfInstance or a \"vnfcCpInfo\" item of a \"vnfcResouceInfo\" item in the VnfInstance. ")


  public String getCpInstanceId() {
    return cpInstanceId;
  }

  public void setCpInstanceId(String cpInstanceId) {
    this.cpInstanceId = cpInstanceId;
  }

  public VnfLinkPortInfo cpInstanceType(CpInstanceTypeEnum cpInstanceType) {
    this.cpInstanceType = cpInstanceType;
    return this;
  }

  /**
   * Type of the CP instance that is identified by cpInstanceId. Shall be present if \"cpInstanceId\" is present, and shall be absent otherwise. Permitted values: VNFC_CP: The link port is connected to a VNFC CP EXT_CP: The link port is associated to an external CP. 
   * @return cpInstanceType
  **/
  @Schema(description = "Type of the CP instance that is identified by cpInstanceId. Shall be present if \"cpInstanceId\" is present, and shall be absent otherwise. Permitted values: VNFC_CP: The link port is connected to a VNFC CP EXT_CP: The link port is associated to an external CP. ")


  public CpInstanceTypeEnum getCpInstanceType() {
    return cpInstanceType;
  }

  public void setCpInstanceType(CpInstanceTypeEnum cpInstanceType) {
    this.cpInstanceType = cpInstanceType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VnfLinkPortInfo vnfLinkPortInfo = (VnfLinkPortInfo) o;
    return Objects.equals(this.id, vnfLinkPortInfo.id) &&
    Objects.equals(this.resourceHandle, vnfLinkPortInfo.resourceHandle) &&
    Objects.equals(this.cpInstanceId, vnfLinkPortInfo.cpInstanceId) &&
    Objects.equals(this.cpInstanceType, vnfLinkPortInfo.cpInstanceType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, resourceHandle, cpInstanceId, cpInstanceType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VnfLinkPortInfo {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    resourceHandle: ").append(toIndentedString(resourceHandle)).append("\n");
    sb.append("    cpInstanceId: ").append(toIndentedString(cpInstanceId)).append("\n");
    sb.append("    cpInstanceType: ").append(toIndentedString(cpInstanceType)).append("\n");
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

