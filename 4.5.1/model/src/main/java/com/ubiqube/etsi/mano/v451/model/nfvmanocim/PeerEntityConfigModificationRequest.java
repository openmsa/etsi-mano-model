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
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.AdministrativeStateEnumType;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.OperationalStateEnumType;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents attribute modifications for configuration parameters of a peer entity. * NOTE: Due to the security sensitive information contained within the attribute (refer to \&quot;securityInfo\&quot;         within the \&quot;ConsumedManoInterfaceInfo\&quot; \&quot; and \&quot;accessInfo\&quot; within the \&quot;VimConnectionInfo\&quot;),          based on access control policies, the API consumer might have read only, write only, read/write,         or no access at all to the attribute&#x27;s value. In case the API consumer is not allowed to modify          the value of the security sensitive attribute, and the modification request includes new attribute         values, the whole modification request shall be rejected, and proper error information returned. 
 */
@Schema(description = "This type represents attribute modifications for configuration parameters of a peer entity. * NOTE: Due to the security sensitive information contained within the attribute (refer to \"securityInfo\"         within the \"ConsumedManoInterfaceInfo\" \" and \"accessInfo\" within the \"VimConnectionInfo\"),          based on access control policies, the API consumer might have read only, write only, read/write,         or no access at all to the attribute's value. In case the API consumer is not allowed to modify          the value of the security sensitive attribute, and the modification request includes new attribute         values, the whole modification request shall be rejected, and proper error information returned. ")
@Validated



public class PeerEntityConfigModificationRequest   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("consumedManoInterfaces")
  private Object consumedManoInterfaces = null;

  @JsonProperty("vimConnectionInfos")
  @Valid
  private List<Object> vimConnectionInfos = null;

  @JsonProperty("operationalState")
  private OperationalStateEnumType operationalState = null;

  @JsonProperty("administrativeState")
  private AdministrativeStateEnumType administrativeState = null;

  public PeerEntityConfigModificationRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * New value of the \"name\" attribute in \"PeerEntity\". 
   * @return name
   **/
  @Schema(description = "New value of the \"name\" attribute in \"PeerEntity\". ")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PeerEntityConfigModificationRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * New value of the \"description\" attribute in \"PeerEntity\", or \"null\" to remove the attribute. 
   * @return description
   **/
  @Schema(description = "New value of the \"description\" attribute in \"PeerEntity\", or \"null\" to remove the attribute. ")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PeerEntityConfigModificationRequest consumedManoInterfaces(Object consumedManoInterfaces) {
    this.consumedManoInterfaces = consumedManoInterfaces;
    return this;
  }

  /**
   * Modification of the \"consumedManoInterfaces\" attribute in the \"PeerEntity\", as defined below this table. If present, these modifications shall be applied according to the rules of JSON Merge PATCH (see IETF RFC 7396). See note. 
   * @return consumedManoInterfaces
   **/
  @Schema(description = "Modification of the \"consumedManoInterfaces\" attribute in the \"PeerEntity\", as defined below this table. If present, these modifications shall be applied according to the rules of JSON Merge PATCH (see IETF RFC 7396). See note. ")
  
    public Object getConsumedManoInterfaces() {
    return consumedManoInterfaces;
  }

  public void setConsumedManoInterfaces(Object consumedManoInterfaces) {
    this.consumedManoInterfaces = consumedManoInterfaces;
  }

  public PeerEntityConfigModificationRequest vimConnectionInfos(List<Object> vimConnectionInfos) {
    this.vimConnectionInfos = vimConnectionInfos;
    return this;
  }

  public PeerEntityConfigModificationRequest addVimConnectionInfosItem(Object vimConnectionInfosItem) {
    if (this.vimConnectionInfos == null) {
      this.vimConnectionInfos = new ArrayList<>();
    }
    this.vimConnectionInfos.add(vimConnectionInfosItem);
    return this;
  }

  /**
   * Modification of the \"vimConnectionInfos” attribute in the \"PeerEntity\". If present, these modifications shall be applied according to the rules of JSON Merge PATCH (see IETF RFC  7396). See note. 
   * @return vimConnectionInfos
   **/
  @Schema(description = "Modification of the \"vimConnectionInfos” attribute in the \"PeerEntity\". If present, these modifications shall be applied according to the rules of JSON Merge PATCH (see IETF RFC  7396). See note. ")
  
    public List<Object> getVimConnectionInfos() {
    return vimConnectionInfos;
  }

  public void setVimConnectionInfos(List<Object> vimConnectionInfos) {
    this.vimConnectionInfos = vimConnectionInfos;
  }

  public PeerEntityConfigModificationRequest operationalState(OperationalStateEnumType operationalState) {
    this.operationalState = operationalState;
    return this;
  }

  /**
   * Get operationalState
   * @return operationalState
   **/
  @Schema(description = "")
  
    @Valid
    public OperationalStateEnumType getOperationalState() {
    return operationalState;
  }

  public void setOperationalState(OperationalStateEnumType operationalState) {
    this.operationalState = operationalState;
  }

  public PeerEntityConfigModificationRequest administrativeState(AdministrativeStateEnumType administrativeState) {
    this.administrativeState = administrativeState;
    return this;
  }

  /**
   * Get administrativeState
   * @return administrativeState
   **/
  @Schema(description = "")
  
    @Valid
    public AdministrativeStateEnumType getAdministrativeState() {
    return administrativeState;
  }

  public void setAdministrativeState(AdministrativeStateEnumType administrativeState) {
    this.administrativeState = administrativeState;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PeerEntityConfigModificationRequest peerEntityConfigModificationRequest = (PeerEntityConfigModificationRequest) o;
    return Objects.equals(this.name, peerEntityConfigModificationRequest.name) &&
        Objects.equals(this.description, peerEntityConfigModificationRequest.description) &&
        Objects.equals(this.consumedManoInterfaces, peerEntityConfigModificationRequest.consumedManoInterfaces) &&
        Objects.equals(this.vimConnectionInfos, peerEntityConfigModificationRequest.vimConnectionInfos) &&
        Objects.equals(this.operationalState, peerEntityConfigModificationRequest.operationalState) &&
        Objects.equals(this.administrativeState, peerEntityConfigModificationRequest.administrativeState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, consumedManoInterfaces, vimConnectionInfos, operationalState, administrativeState);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PeerEntityConfigModificationRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    consumedManoInterfaces: ").append(toIndentedString(consumedManoInterfaces)).append("\n");
    sb.append("    vimConnectionInfos: ").append(toIndentedString(vimConnectionInfos)).append("\n");
    sb.append("    operationalState: ").append(toIndentedString(operationalState)).append("\n");
    sb.append("    administrativeState: ").append(toIndentedString(administrativeState)).append("\n");
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
