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
package com.ubiqube.etsi.mano.v451.model.nfvmanocim;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.PeerEntityEnumType;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.PeerEntityPeerEntityState;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents an individual peer entity. * NOTE 1: The value of the \&quot;peerEntityId\&quot; attribute is the same as the value of the \&quot;id\&quot; attribute in the           \&quot;ManoEntity\&quot; of the corresponding NFV-MANO functional entity that acts as peer entity, and shall           follow the uniqueness requirements set out in clause 5.6.2.2 for the \&quot;id\&quot; attribute. * NOTE 2: With this information, the NFVO has available information about the set of VIMs and associated VIM           connection information that have been configured into the VNFM. 
 */
@Schema(description = "This type represents an individual peer entity. * NOTE 1: The value of the \"peerEntityId\" attribute is the same as the value of the \"id\" attribute in the           \"ManoEntity\" of the corresponding NFV-MANO functional entity that acts as peer entity, and shall           follow the uniqueness requirements set out in clause 5.6.2.2 for the \"id\" attribute. * NOTE 2: With this information, the NFVO has available information about the set of VIMs and associated VIM           connection information that have been configured into the VNFM. ")
@Validated



public class PeerEntity   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("peerEntityId")
  private String peerEntityId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("type")
  private PeerEntityEnumType type = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("consumedManoInterfaces")
  private Object consumedManoInterfaces = null;

  @JsonProperty("vimConnectionInfos")
  @Valid
  private List<Object> vimConnectionInfos = null;

  @JsonProperty("vnfmConfiguredVimConnectionInfoIds")
  @Valid
  private List<String> vnfmConfiguredVimConnectionInfoIds = null;

  @JsonProperty("peerEntityState")
  private PeerEntityPeerEntityState peerEntityState = null;

  public PeerEntity id(String id) {
    this.id = id;
    return this;
  }

  /**
   * An identifier with the intention of being globally unique. 
   * @return id
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "An identifier with the intention of being globally unique. ")
      @NotNull

    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PeerEntity peerEntityId(String peerEntityId) {
    this.peerEntityId = peerEntityId;
    return this;
  }

  /**
   * An identifier with the intention of being globally unique. 
   * @return peerEntityId
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "An identifier with the intention of being globally unique. ")
      @NotNull

    public String getPeerEntityId() {
    return peerEntityId;
  }

  public void setPeerEntityId(String peerEntityId) {
    this.peerEntityId = peerEntityId;
  }

  public PeerEntity name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Human-readable name of the peer functional entity. This attribute can be modified with the PATCH method. 
   * @return name
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Human-readable name of the peer functional entity. This attribute can be modified with the PATCH method. ")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PeerEntity type(PeerEntityEnumType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    @Valid
    public PeerEntityEnumType getType() {
    return type;
  }

  public void setType(PeerEntityEnumType type) {
    this.type = type;
  }

  public PeerEntity description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Human-readable description of the peer functional entity. This attribute can be modified with the PATCH method. 
   * @return description
   **/
  @Schema(description = "Human-readable description of the peer functional entity. This attribute can be modified with the PATCH method. ")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PeerEntity consumedManoInterfaces(Object consumedManoInterfaces) {
    this.consumedManoInterfaces = consumedManoInterfaces;
    return this;
  }

  /**
   * Information of the interface consumed by the NFV-MANO functional entity from the peer functional entity. This attribute can be modified with the PATCH method. The keys of the map, each of which identifies information about a particular consumed NFV-MANO interface, are managed by the API consumer and referenced from other data structures via the \"consumedManoInterfaceIds\" attribute. 
   * @return consumedManoInterfaces
   **/
  @Schema(description = "Information of the interface consumed by the NFV-MANO functional entity from the peer functional entity. This attribute can be modified with the PATCH method. The keys of the map, each of which identifies information about a particular consumed NFV-MANO interface, are managed by the API consumer and referenced from other data structures via the \"consumedManoInterfaceIds\" attribute. ")
  
    public Object getConsumedManoInterfaces() {
    return consumedManoInterfaces;
  }

  public void setConsumedManoInterfaces(Object consumedManoInterfaces) {
    this.consumedManoInterfaces = consumedManoInterfaces;
  }

  public PeerEntity vimConnectionInfos(List<Object> vimConnectionInfos) {
    this.vimConnectionInfos = vimConnectionInfos;
    return this;
  }

  public PeerEntity addVimConnectionInfosItem(Object vimConnectionInfosItem) {
    if (this.vimConnectionInfos == null) {
      this.vimConnectionInfos = new ArrayList<>();
    }
    this.vimConnectionInfos.add(vimConnectionInfosItem);
    return this;
  }

  /**
   * Map of VIM connection information. The VimConnectionInfo is specified in clause 4.4.1.6 of ETSI GS NFV-SOL 003. This attribute can be modified with the PATCH method. May be present only if the \"type\" attribute in the \"PeerEntity” is either a \"VIM\", a \"CISM\" or a \"CIR\", and the NFV-MANO entity being configured is a \"VNFM\" or \"NFVO\" as indicated by the \"type\" attribute in the \"ManoEntity\". In case it is present, the value of the \"vimId\" in the \"VimConnectionInfo\" shall be equal to the value of \"peerEntityId\". In addition, the content of \"interfaceInfo\", \"accessInfo” and \"extra\" (if applicable) of the “VimConnectionInfo\" shall be provided by means in scope of the present document. 
   * @return vimConnectionInfos
   **/
  @Schema(description = "Map of VIM connection information. The VimConnectionInfo is specified in clause 4.4.1.6 of ETSI GS NFV-SOL 003. This attribute can be modified with the PATCH method. May be present only if the \"type\" attribute in the \"PeerEntity” is either a \"VIM\", a \"CISM\" or a \"CIR\", and the NFV-MANO entity being configured is a \"VNFM\" or \"NFVO\" as indicated by the \"type\" attribute in the \"ManoEntity\". In case it is present, the value of the \"vimId\" in the \"VimConnectionInfo\" shall be equal to the value of \"peerEntityId\". In addition, the content of \"interfaceInfo\", \"accessInfo” and \"extra\" (if applicable) of the “VimConnectionInfo\" shall be provided by means in scope of the present document. ")
  
    public List<Object> getVimConnectionInfos() {
    return vimConnectionInfos;
  }

  public void setVimConnectionInfos(List<Object> vimConnectionInfos) {
    this.vimConnectionInfos = vimConnectionInfos;
  }

  public PeerEntity vnfmConfiguredVimConnectionInfoIds(List<String> vnfmConfiguredVimConnectionInfoIds) {
    this.vnfmConfiguredVimConnectionInfoIds = vnfmConfiguredVimConnectionInfoIds;
    return this;
  }

  public PeerEntity addVnfmConfiguredVimConnectionInfoIdsItem(String vnfmConfiguredVimConnectionInfoIdsItem) {
    if (this.vnfmConfiguredVimConnectionInfoIds == null) {
      this.vnfmConfiguredVimConnectionInfoIds = new ArrayList<>();
    }
    this.vnfmConfiguredVimConnectionInfoIds.add(vnfmConfiguredVimConnectionInfoIdsItem);
    return this;
  }

  /**
   * List of VIM connection information identifiers that identify the set of VIMs and associated VIM connection information that have been configured into the VNFM whose identifier is equal to the “peerEntityId“. See note 2. Only applicable if the \"type” attribute in the \"ManoEntity\" is \"NFVO\" and the \"type” attribute in the \"PeerEntity\" is a \"VNFM\". 
   * @return vnfmConfiguredVimConnectionInfoIds
   **/
  @Schema(description = "List of VIM connection information identifiers that identify the set of VIMs and associated VIM connection information that have been configured into the VNFM whose identifier is equal to the “peerEntityId“. See note 2. Only applicable if the \"type” attribute in the \"ManoEntity\" is \"NFVO\" and the \"type” attribute in the \"PeerEntity\" is a \"VNFM\". ")
  
    public List<String> getVnfmConfiguredVimConnectionInfoIds() {
    return vnfmConfiguredVimConnectionInfoIds;
  }

  public void setVnfmConfiguredVimConnectionInfoIds(List<String> vnfmConfiguredVimConnectionInfoIds) {
    this.vnfmConfiguredVimConnectionInfoIds = vnfmConfiguredVimConnectionInfoIds;
  }

  public PeerEntity peerEntityState(PeerEntityPeerEntityState peerEntityState) {
    this.peerEntityState = peerEntityState;
    return this;
  }

  /**
   * Get peerEntityState
   * @return peerEntityState
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    @Valid
    public PeerEntityPeerEntityState getPeerEntityState() {
    return peerEntityState;
  }

  public void setPeerEntityState(PeerEntityPeerEntityState peerEntityState) {
    this.peerEntityState = peerEntityState;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PeerEntity peerEntity = (PeerEntity) o;
    return Objects.equals(this.id, peerEntity.id) &&
        Objects.equals(this.peerEntityId, peerEntity.peerEntityId) &&
        Objects.equals(this.name, peerEntity.name) &&
        Objects.equals(this.type, peerEntity.type) &&
        Objects.equals(this.description, peerEntity.description) &&
        Objects.equals(this.consumedManoInterfaces, peerEntity.consumedManoInterfaces) &&
        Objects.equals(this.vimConnectionInfos, peerEntity.vimConnectionInfos) &&
        Objects.equals(this.vnfmConfiguredVimConnectionInfoIds, peerEntity.vnfmConfiguredVimConnectionInfoIds) &&
        Objects.equals(this.peerEntityState, peerEntity.peerEntityState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, peerEntityId, name, type, description, consumedManoInterfaces, vimConnectionInfos, vnfmConfiguredVimConnectionInfoIds, peerEntityState);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PeerEntity {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    peerEntityId: ").append(toIndentedString(peerEntityId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    consumedManoInterfaces: ").append(toIndentedString(consumedManoInterfaces)).append("\n");
    sb.append("    vimConnectionInfos: ").append(toIndentedString(vimConnectionInfos)).append("\n");
    sb.append("    vnfmConfiguredVimConnectionInfoIds: ").append(toIndentedString(vnfmConfiguredVimConnectionInfoIds)).append("\n");
    sb.append("    peerEntityState: ").append(toIndentedString(peerEntityState)).append("\n");
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
