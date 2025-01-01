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
import com.ubiqube.etsi.mano.v281.model.em.vnflcm.CpProtocolData;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents an externally provided link port or network address information per instance of an external connection point. In case a link port is provided, the VNFM shall use that link port when connecting the external CP to the external VL. In a link port is not provided, the VNFM shall create a link port on the external VL, and use that link port to connect the external CP to the external VL. 
 */
@Schema (description= "This type represents an externally provided link port or network address information per instance of an external connection point. In case a link port is provided, the VNFM shall use that link port when connecting the external CP to the external VL. In a link port is not provided, the VNFM shall create a link port on the external VL, and use that link port to connect the external CP to the external VL. " )
@Validated

public class VnfExtCpConfig   {
  @JsonProperty("cpInstanceId")
  private String cpInstanceId = null;

  @JsonProperty("linkPortId")
  private String linkPortId = null;

  @JsonProperty("cpProtocolData")
  @Valid
  private List<CpProtocolData> cpProtocolData = null;

  public VnfExtCpConfig cpInstanceId(String cpInstanceId) {
    this.cpInstanceId = cpInstanceId;
    return this;
  }

  /**
   * Identifier of the external CP instance to which this set of configuration parameters is requested to be applied. Shall be present if this instance has already been created. 
   * @return cpInstanceId
  **/
  @Schema(description = "Identifier of the external CP instance to which this set of configuration parameters is requested to be applied. Shall be present if this instance has already been created. ")


  public String getCpInstanceId() {
    return cpInstanceId;
  }

  public void setCpInstanceId(String cpInstanceId) {
    this.cpInstanceId = cpInstanceId;
  }

  public VnfExtCpConfig linkPortId(String linkPortId) {
    this.linkPortId = linkPortId;
    return this;
  }

  /**
   * Identifier of a pre-configured link port to which the external CP will be associated. The following conditions apply to the attributes \"linkPortId\" and \"cpProtocolData\": 1) The \"linkPortId\" and \"cpProtocolData\" attributes shall both be    absent for the deletion of an existing external CP instance    addressed by cpInstanceId. 2) At least one of these attributes shall be present for a    to-be-created external CP instance or an existing external    CP instance. 3) If the \"linkPortId\" attribute is absent, the VNFM shall create a    link port. 4) If the \"cpProtocolData\" attribute is absent, the \"linkPortId\"    attribute shall be provided referencing a pre-created link port,    and the VNFM can use means outside the scope of the present    document to obtain the pre-configured address information for the    connection point from the resource representing the link port. 5) If both \"cpProtocolData\" and \"linkportId\" are provided, the API    consumer shall ensure that the cpProtocolData can be used with the    pre-created link port referenced by \"linkPortId\". 
   * @return linkPortId
  **/
  @Schema(description = "Identifier of a pre-configured link port to which the external CP will be associated. The following conditions apply to the attributes \"linkPortId\" and \"cpProtocolData\": 1) The \"linkPortId\" and \"cpProtocolData\" attributes shall both be    absent for the deletion of an existing external CP instance    addressed by cpInstanceId. 2) At least one of these attributes shall be present for a    to-be-created external CP instance or an existing external    CP instance. 3) If the \"linkPortId\" attribute is absent, the VNFM shall create a    link port. 4) If the \"cpProtocolData\" attribute is absent, the \"linkPortId\"    attribute shall be provided referencing a pre-created link port,    and the VNFM can use means outside the scope of the present    document to obtain the pre-configured address information for the    connection point from the resource representing the link port. 5) If both \"cpProtocolData\" and \"linkportId\" are provided, the API    consumer shall ensure that the cpProtocolData can be used with the    pre-created link port referenced by \"linkPortId\". ")


  public String getLinkPortId() {
    return linkPortId;
  }

  public void setLinkPortId(String linkPortId) {
    this.linkPortId = linkPortId;
  }

  public VnfExtCpConfig cpProtocolData(List<CpProtocolData> cpProtocolData) {
    this.cpProtocolData = cpProtocolData;
    return this;
  }

  public VnfExtCpConfig addCpProtocolDataItem(CpProtocolData cpProtocolDataItem) {
    if (this.cpProtocolData == null) {
      this.cpProtocolData = new ArrayList<>();
    }
    this.cpProtocolData.add(cpProtocolDataItem);
    return this;
  }

  /**
   * Parameters for configuring the network protocols on the link port that connects the CP to a VL. The following conditions apply to the attributes \"linkPortId\" and \"cpProtocolData\": 1) The \"linkPortId\" and \"cpProtocolData\" attributes shall both be    absent for the deletion of an existing external CP instance    addressed by cpInstanceId. 2) At least one of these attributes shall be present for a    to-be-created external CP instance or an existing external    CP instance. 3) If the \"linkPortId\" attribute is absent, the VNFM shall create a    link port. 4) If the \"cpProtocolData\" attribute is absent, the \"linkPortId\"    attribute shall be provided referencing a pre-created link port,    and the VNFM can use means outside the scope of the present    document to obtain the pre-configured address information for the    connection point from the resource representing the link port. 5) If both \"cpProtocolData\" and \"linkportId\" are provided, the API    consumer shall ensure that the cpProtocolData can be used with the    pre-created link port referenced by \"linkPortId\". 
   * @return cpProtocolData
  **/
  @Schema(description = "Parameters for configuring the network protocols on the link port that connects the CP to a VL. The following conditions apply to the attributes \"linkPortId\" and \"cpProtocolData\": 1) The \"linkPortId\" and \"cpProtocolData\" attributes shall both be    absent for the deletion of an existing external CP instance    addressed by cpInstanceId. 2) At least one of these attributes shall be present for a    to-be-created external CP instance or an existing external    CP instance. 3) If the \"linkPortId\" attribute is absent, the VNFM shall create a    link port. 4) If the \"cpProtocolData\" attribute is absent, the \"linkPortId\"    attribute shall be provided referencing a pre-created link port,    and the VNFM can use means outside the scope of the present    document to obtain the pre-configured address information for the    connection point from the resource representing the link port. 5) If both \"cpProtocolData\" and \"linkportId\" are provided, the API    consumer shall ensure that the cpProtocolData can be used with the    pre-created link port referenced by \"linkPortId\". ")

  @Valid

  public List<CpProtocolData> getCpProtocolData() {
    return cpProtocolData;
  }

  public void setCpProtocolData(List<CpProtocolData> cpProtocolData) {
    this.cpProtocolData = cpProtocolData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VnfExtCpConfig vnfExtCpConfig = (VnfExtCpConfig) o;
    return Objects.equals(this.cpInstanceId, vnfExtCpConfig.cpInstanceId) &&
    Objects.equals(this.linkPortId, vnfExtCpConfig.linkPortId) &&
    Objects.equals(this.cpProtocolData, vnfExtCpConfig.cpProtocolData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cpInstanceId, linkPortId, cpProtocolData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VnfExtCpConfig {\n");

    sb.append("    cpInstanceId: ").append(toIndentedString(cpInstanceId)).append("\n");
    sb.append("    linkPortId: ").append(toIndentedString(linkPortId)).append("\n");
    sb.append("    cpProtocolData: ").append(toIndentedString(cpProtocolData)).append("\n");
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

