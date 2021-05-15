package com.ubiqube.etsi.mano.em.v271.model.vnflcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ExtManagedVirtualLinkData
 */
@Validated

public class ExtManagedVirtualLinkData   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("vnfVirtualLinkDescId")
  private String vnfVirtualLinkDescId = null;

  @JsonProperty("vimConnectionId")
  private String vimConnectionId = null;

  @JsonProperty("resourceProviderId")
  private String resourceProviderId = null;

  @JsonProperty("resourceId")
  private String resourceId = null;

  public ExtManagedVirtualLinkData id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The identifier of the externally-managed internal VL instance. The identifier is assigned by the NFV-MANO entity that manages this VL instance. 
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The identifier of the externally-managed internal VL instance. The identifier is assigned by the NFV-MANO entity that manages this VL instance. ")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ExtManagedVirtualLinkData vnfVirtualLinkDescId(String vnfVirtualLinkDescId) {
    this.vnfVirtualLinkDescId = vnfVirtualLinkDescId;
    return this;
  }

  /**
   * The identifier of the VLD in the VNFD for this VL. 
   * @return vnfVirtualLinkDescId
  **/
  @ApiModelProperty(value = "The identifier of the VLD in the VNFD for this VL. ")


  public String getVnfVirtualLinkDescId() {
    return vnfVirtualLinkDescId;
  }

  public void setVnfVirtualLinkDescId(String vnfVirtualLinkDescId) {
    this.vnfVirtualLinkDescId = vnfVirtualLinkDescId;
  }

  public ExtManagedVirtualLinkData vimConnectionId(String vimConnectionId) {
    this.vimConnectionId = vimConnectionId;
    return this;
  }

  /**
   * Identifier of the VIM connection to manage this resource. This attribute shall only be supported and present if VNF-related resource management in direct mode is applicable. 
   * @return vimConnectionId
  **/
  @ApiModelProperty(value = "Identifier of the VIM connection to manage this resource. This attribute shall only be supported and present if VNF-related resource management in direct mode is applicable. ")


  public String getVimConnectionId() {
    return vimConnectionId;
  }

  public void setVimConnectionId(String vimConnectionId) {
    this.vimConnectionId = vimConnectionId;
  }

  public ExtManagedVirtualLinkData resourceProviderId(String resourceProviderId) {
    this.resourceProviderId = resourceProviderId;
    return this;
  }

  /**
   * Identifies the entity responsible for the management of this resource. This attribute shall only be supported and present if VNF-related resource management in indirect mode is applicable. The identification scheme is outside the scope of the present document. 
   * @return resourceProviderId
  **/
  @ApiModelProperty(value = "Identifies the entity responsible for the management of this resource. This attribute shall only be supported and present if VNF-related resource management in indirect mode is applicable. The identification scheme is outside the scope of the present document. ")


  public String getResourceProviderId() {
    return resourceProviderId;
  }

  public void setResourceProviderId(String resourceProviderId) {
    this.resourceProviderId = resourceProviderId;
  }

  public ExtManagedVirtualLinkData resourceId(String resourceId) {
    this.resourceId = resourceId;
    return this;
  }

  /**
   * The identifier of the resource in the scope of the VIM or the resource provider. 
   * @return resourceId
  **/
  @ApiModelProperty(required = true, value = "The identifier of the resource in the scope of the VIM or the resource provider. ")
  @NotNull


  public String getResourceId() {
    return resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExtManagedVirtualLinkData extManagedVirtualLinkData = (ExtManagedVirtualLinkData) o;
    return Objects.equals(this.id, extManagedVirtualLinkData.id) &&
        Objects.equals(this.vnfVirtualLinkDescId, extManagedVirtualLinkData.vnfVirtualLinkDescId) &&
        Objects.equals(this.vimConnectionId, extManagedVirtualLinkData.vimConnectionId) &&
        Objects.equals(this.resourceProviderId, extManagedVirtualLinkData.resourceProviderId) &&
        Objects.equals(this.resourceId, extManagedVirtualLinkData.resourceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, vnfVirtualLinkDescId, vimConnectionId, resourceProviderId, resourceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExtManagedVirtualLinkData {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    vnfVirtualLinkDescId: ").append(toIndentedString(vnfVirtualLinkDescId)).append("\n");
    sb.append("    vimConnectionId: ").append(toIndentedString(vimConnectionId)).append("\n");
    sb.append("    resourceProviderId: ").append(toIndentedString(resourceProviderId)).append("\n");
    sb.append("    resourceId: ").append(toIndentedString(resourceId)).append("\n");
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

