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
package com.ubiqube.etsi.mano.v361.model.em.vnflcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.VnfExtCpConfig;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents configuration information for external CPs created. * NOTE 1:  In case this identifier refers to a CPD with trunking enabled, the external CP instances created               from this CPD will represent ports in a trunk. * NOTE 2:  Within one VNF instance, all VNFC instances created from a particular VDU have the same external               connectivity. Thus, given a particular value of the \&quot;cpdId\&quot; attribute, there shall be one               \&quot;cpConfig\&quot; entry for each VNFC instance that has been or can be created from a VDU which includes               a CPD identified by the \&quot;cpdId\&quot; attribute. If the cpConfig represents a subport in a trunk,               all \&quot;cpConfig\&quot; entries in this list shall have the same segmentationId, which means they are               connected to the same set of external VLs via the trunk. * NOTE 3:  The map entry value shall be set to \&quot;null\&quot; in order to delete a \&quot;VnfExtCpConfig\&quot; entry identified               by a particular key value from the map, i.e. for the disconnection of an existing external               CP instance addressed by cpInstanceId in the deleted map entry from a particular external               virtual link, and deletion of that instance in case it represents a subport. Deleting the               last key from the map removes the affected instance of the \&quot;VnfExtCpData\&quot; structure from               its parent data structure. * NOTE 4:   If, as defined by the input parameters of a \&quot;ChangeVnfFlavour\&quot;, \&quot;ChangeExtVnfConnectivity\&quot; or                \&quot;ChangeCurrentVnfPkg\&quot; operation or as part of the Grant response for any of these operations, a                cpConfig map entry identified by a particular map key value is moved into another \&quot;ExtVirtualLinkData\&quot;               or \&quot;VnfExtCpData\&quot; structure, this particular cpConfig map entry may be used by an external CP instance               different than the one that has used it before the operation, or by no external CP instance at all.               Renaming a CPD identifier during the \&quot;changeCurrentVnfPkg\&quot; operation does not count as moving the               related \&quot;cpConfig\&quot; map entries to a new \&quot;extCpData\&quot; structure. 
 */
@Schema(description = "This type represents configuration information for external CPs created. * NOTE 1:  In case this identifier refers to a CPD with trunking enabled, the external CP instances created               from this CPD will represent ports in a trunk. * NOTE 2:  Within one VNF instance, all VNFC instances created from a particular VDU have the same external               connectivity. Thus, given a particular value of the \"cpdId\" attribute, there shall be one               \"cpConfig\" entry for each VNFC instance that has been or can be created from a VDU which includes               a CPD identified by the \"cpdId\" attribute. If the cpConfig represents a subport in a trunk,               all \"cpConfig\" entries in this list shall have the same segmentationId, which means they are               connected to the same set of external VLs via the trunk. * NOTE 3:  The map entry value shall be set to \"null\" in order to delete a \"VnfExtCpConfig\" entry identified               by a particular key value from the map, i.e. for the disconnection of an existing external               CP instance addressed by cpInstanceId in the deleted map entry from a particular external               virtual link, and deletion of that instance in case it represents a subport. Deleting the               last key from the map removes the affected instance of the \"VnfExtCpData\" structure from               its parent data structure. * NOTE 4:   If, as defined by the input parameters of a \"ChangeVnfFlavour\", \"ChangeExtVnfConnectivity\" or                \"ChangeCurrentVnfPkg\" operation or as part of the Grant response for any of these operations, a                cpConfig map entry identified by a particular map key value is moved into another \"ExtVirtualLinkData\"               or \"VnfExtCpData\" structure, this particular cpConfig map entry may be used by an external CP instance               different than the one that has used it before the operation, or by no external CP instance at all.               Renaming a CPD identifier during the \"changeCurrentVnfPkg\" operation does not count as moving the               related \"cpConfig\" map entries to a new \"extCpData\" structure. ")
@Validated


public class VnfExtCpData   {
  @JsonProperty("cpdId")
  private String cpdId = null;

  @JsonProperty("cpConfig")
  @Valid
  private Map<String, VnfExtCpConfig> cpConfig = null;

  public VnfExtCpData cpdId(String cpdId) {
    this.cpdId = cpdId;
    return this;
  }

  /**
   * Get cpdId
   * @return cpdId
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    public String getCpdId() {
    return cpdId;
  }

  public void setCpdId(String cpdId) {
    this.cpdId = cpdId;
  }

  public VnfExtCpData cpConfig(Map<String, VnfExtCpConfig> cpConfig) {
    this.cpConfig = cpConfig;
    return this;
  }

  public VnfExtCpData putCpConfigItem(String key, VnfExtCpConfig cpConfigItem) {
    if (this.cpConfig == null) {
      this.cpConfig = new HashMap<>();
    }
    this.cpConfig.put(key, cpConfigItem);
    return this;
  }

  /**
   * Map of instance data that need to be configured on the CP instances created from the respective CPD. The key of the map which identifies the individual VnfExtCpConfig entries is of type \"IdentifierInVnf\" and is managed by the API consumer. The entries shall be applied by the VNFM according to the rules of JSON Merge Patch (see IETF RFC 7396). See notes 2, 3 and 4. 
   * @return cpConfig
   **/
  @Schema(description = "Map of instance data that need to be configured on the CP instances created from the respective CPD. The key of the map which identifies the individual VnfExtCpConfig entries is of type \"IdentifierInVnf\" and is managed by the API consumer. The entries shall be applied by the VNFM according to the rules of JSON Merge Patch (see IETF RFC 7396). See notes 2, 3 and 4. ")
      @Valid
    public Map<String, VnfExtCpConfig> getCpConfig() {
    return cpConfig;
  }

  public void setCpConfig(Map<String, VnfExtCpConfig> cpConfig) {
    this.cpConfig = cpConfig;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VnfExtCpData vnfExtCpData = (VnfExtCpData) o;
    return Objects.equals(this.cpdId, vnfExtCpData.cpdId) &&
        Objects.equals(this.cpConfig, vnfExtCpData.cpConfig);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cpdId, cpConfig);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VnfExtCpData {\n");
    
    sb.append("    cpdId: ").append(toIndentedString(cpdId)).append("\n");
    sb.append("    cpConfig: ").append(toIndentedString(cpConfig)).append("\n");
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
