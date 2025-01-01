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
package com.ubiqube.etsi.mano.v361.model.nfvo.nsd;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v361.model.nfvo.nsd.NsdOperationalStateType;
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
 * This type represents attribute modifications for an individual NS descriptor resource based on the NsdInfo data type. The attributes of NsdInfo that can be modified are included in the NsdInfoModifications data type. NOTE: At least one of the attributes - nsdOperationalState and userDefinedData - shall be present. 
 */
@Schema(description = "This type represents attribute modifications for an individual NS descriptor resource based on the NsdInfo data type. The attributes of NsdInfo that can be modified are included in the NsdInfoModifications data type. NOTE: At least one of the attributes - nsdOperationalState and userDefinedData - shall be present. ")
@Validated


public class NsdInfoModifications  implements OneOfNsdInfoModifications {
  @JsonProperty("nsdOperationalState")
  private NsdOperationalStateType nsdOperationalState = null;

  @JsonProperty("userDefinedData")
  @Valid
  private List<Map<String, String>> userDefinedData = null;

  public NsdInfoModifications nsdOperationalState(NsdOperationalStateType nsdOperationalState) {
    this.nsdOperationalState = nsdOperationalState;
    return this;
  }

  /**
   * Get nsdOperationalState
   * @return nsdOperationalState
   **/
  @Schema(description = "")
  
    @Valid
    public NsdOperationalStateType getNsdOperationalState() {
    return nsdOperationalState;
  }

  public void setNsdOperationalState(NsdOperationalStateType nsdOperationalState) {
    this.nsdOperationalState = nsdOperationalState;
  }

  public NsdInfoModifications userDefinedData(List<Map<String, String>> userDefinedData) {
    this.userDefinedData = userDefinedData;
    return this;
  }

  public NsdInfoModifications addUserDefinedDataItem(Map<String, String> userDefinedDataItem) {
    if (this.userDefinedData == null) {
      this.userDefinedData = new ArrayList<>();
    }
    this.userDefinedData.add(userDefinedDataItem);
    return this;
  }

  /**
   * Modifications of the userDefinedData attribute in NsdInfo data type. See note. If present, these modifications shall be applied according to the rules of JSON Merge Patch (see IETF RFC 7396). 
   * @return userDefinedData
   **/
  @Schema(description = "Modifications of the userDefinedData attribute in NsdInfo data type. See note. If present, these modifications shall be applied according to the rules of JSON Merge Patch (see IETF RFC 7396). ")
      @Valid
    public List<Map<String, String>> getUserDefinedData() {
    return userDefinedData;
  }

  public void setUserDefinedData(List<Map<String, String>> userDefinedData) {
    this.userDefinedData = userDefinedData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NsdInfoModifications nsdInfoModifications = (NsdInfoModifications) o;
    return Objects.equals(this.nsdOperationalState, nsdInfoModifications.nsdOperationalState) &&
        Objects.equals(this.userDefinedData, nsdInfoModifications.userDefinedData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nsdOperationalState, userDefinedData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NsdInfoModifications {\n");
    
    sb.append("    nsdOperationalState: ").append(toIndentedString(nsdOperationalState)).append("\n");
    sb.append("    userDefinedData: ").append(toIndentedString(userDefinedData)).append("\n");
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
