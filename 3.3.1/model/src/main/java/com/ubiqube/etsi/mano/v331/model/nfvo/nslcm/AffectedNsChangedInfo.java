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
package com.ubiqube.etsi.mano.v331.model.nfvo.nslcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v331.model.nfvo.nslcm.WanConnectionInfoModification;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Information about the changed NS instance information, if applicable. 
 */
@Schema(description = "Information about the changed NS instance information, if applicable. ")
@Validated


public class AffectedNsChangedInfo   {
  @JsonProperty("wanConnectionInfoModifications")
  @Valid
  private List<WanConnectionInfoModification> wanConnectionInfoModifications = null;

  public AffectedNsChangedInfo wanConnectionInfoModifications(List<WanConnectionInfoModification> wanConnectionInfoModifications) {
    this.wanConnectionInfoModifications = wanConnectionInfoModifications;
    return this;
  }

  public AffectedNsChangedInfo addWanConnectionInfoModificationsItem(WanConnectionInfoModification wanConnectionInfoModificationsItem) {
    if (this.wanConnectionInfoModifications == null) {
      this.wanConnectionInfoModifications = new ArrayList<>();
    }
    this.wanConnectionInfoModifications.add(wanConnectionInfoModificationsItem);
    return this;
  }

  /**
   * Information about the modified WAN related connectivity information, if applicable. 
   * @return wanConnectionInfoModifications
   **/
  @Schema(description = "Information about the modified WAN related connectivity information, if applicable. ")
      @Valid
    public List<WanConnectionInfoModification> getWanConnectionInfoModifications() {
    return wanConnectionInfoModifications;
  }

  public void setWanConnectionInfoModifications(List<WanConnectionInfoModification> wanConnectionInfoModifications) {
    this.wanConnectionInfoModifications = wanConnectionInfoModifications;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AffectedNsChangedInfo affectedNsChangedInfo = (AffectedNsChangedInfo) o;
    return Objects.equals(this.wanConnectionInfoModifications, affectedNsChangedInfo.wanConnectionInfoModifications);
  }

  @Override
  public int hashCode() {
    return Objects.hash(wanConnectionInfoModifications);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AffectedNsChangedInfo {\n");
    
    sb.append("    wanConnectionInfoModifications: ").append(toIndentedString(wanConnectionInfoModifications)).append("\n");
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
