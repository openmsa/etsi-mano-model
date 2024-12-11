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
 *     along with this program.  If not, see https://www.gnu.org/licenses/.
 */
package com.ubiqube.etsi.mano.v451.model.nfvmanocim;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents information of a deployed component realizing part of an NFV-MANO functional entity. It is optional for the API producer to support this type. 
 */
@Schema(description = "This type represents information of a deployed component realizing part of an NFV-MANO functional entity. It is optional for the API producer to support this type. ")
@Validated



public class ManoEntityComponent   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("manoServiceIds")
  @Valid
  private List<String> manoServiceIds = null;

  public ManoEntityComponent id(String id) {
    this.id = id;
    return this;
  }

  /**
   * An identifier that is unique for the respective type within a NFV-MANO functional entity, but that need not be globally unique. Representation: string of variable length.. 
   * @return id
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "An identifier that is unique for the respective type within a NFV-MANO functional entity, but that need not be globally unique. Representation: string of variable length.. ")
      @NotNull

    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ManoEntityComponent manoServiceIds(List<String> manoServiceIds) {
    this.manoServiceIds = manoServiceIds;
    return this;
  }

  public ManoEntityComponent addManoServiceIdsItem(String manoServiceIdsItem) {
    if (this.manoServiceIds == null) {
      this.manoServiceIds = new ArrayList<>();
    }
    this.manoServiceIds.add(manoServiceIdsItem);
    return this;
  }

  /**
   * References to the NFV-MANO services that depend on the NFV-MANO functional entity component. The identifier of the ManoService is referred. A service may depend on multiple components. Multiple services may depend on the same component. 
   * @return manoServiceIds
   **/
  @Schema(description = "References to the NFV-MANO services that depend on the NFV-MANO functional entity component. The identifier of the ManoService is referred. A service may depend on multiple components. Multiple services may depend on the same component. ")
  
    public List<String> getManoServiceIds() {
    return manoServiceIds;
  }

  public void setManoServiceIds(List<String> manoServiceIds) {
    this.manoServiceIds = manoServiceIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ManoEntityComponent manoEntityComponent = (ManoEntityComponent) o;
    return Objects.equals(this.id, manoEntityComponent.id) &&
        Objects.equals(this.manoServiceIds, manoEntityComponent.manoServiceIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, manoServiceIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ManoEntityComponent {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    manoServiceIds: ").append(toIndentedString(manoServiceIds)).append("\n");
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
