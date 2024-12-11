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
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.ManoServiceLinks;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents information about an NFV-MANO service provided by the NFV-MANO functional entity. * NOTE: A cardinality greater than one supports having different interface versions or api Endpoints         to be used for accessing the same instance of an NFV-MANO service. 
 */
@Schema(description = "This type represents information about an NFV-MANO service provided by the NFV-MANO functional entity. * NOTE: A cardinality greater than one supports having different interface versions or api Endpoints         to be used for accessing the same instance of an NFV-MANO service. ")
@Validated



public class ManoService   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("manoServiceInterfaceIds")
  @Valid
  private List<String> manoServiceInterfaceIds = new ArrayList<>();

  @JsonProperty("_links")
  private ManoServiceLinks _links = null;

  public ManoService id(String id) {
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

  public ManoService name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Human-readable name of the NFV-MANO service. This attribute can be modified with the PATCH method. 
   * @return name
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Human-readable name of the NFV-MANO service. This attribute can be modified with the PATCH method. ")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ManoService description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Human-readable description of the NFV-MANO service. This attribute can be modified with the PATCH method. 
   * @return description
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Human-readable description of the NFV-MANO service. This attribute can be modified with the PATCH method. ")
      @NotNull

    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ManoService manoServiceInterfaceIds(List<String> manoServiceInterfaceIds) {
    this.manoServiceInterfaceIds = manoServiceInterfaceIds;
    return this;
  }

  public ManoService addManoServiceInterfaceIdsItem(String manoServiceInterfaceIdsItem) {
    this.manoServiceInterfaceIds.add(manoServiceInterfaceIdsItem);
    return this;
  }

  /**
   * Reference to the NFV-MANO interfaces associated to the NFV-MANO service. If cardinality is greater than one, the type of ManoServiceInterface (see clause 5.6.3.3) shall be the same. The identifier of the ManoServiceInterface is referred. See note 
   * @return manoServiceInterfaceIds
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Reference to the NFV-MANO interfaces associated to the NFV-MANO service. If cardinality is greater than one, the type of ManoServiceInterface (see clause 5.6.3.3) shall be the same. The identifier of the ManoServiceInterface is referred. See note ")
      @NotNull

  @Size(min=1)   public List<String> getManoServiceInterfaceIds() {
    return manoServiceInterfaceIds;
  }

  public void setManoServiceInterfaceIds(List<String> manoServiceInterfaceIds) {
    this.manoServiceInterfaceIds = manoServiceInterfaceIds;
  }

  public ManoService _links(ManoServiceLinks _links) {
    this._links = _links;
    return this;
  }

  /**
   * Get _links
   * @return _links
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    @Valid
    public ManoServiceLinks getLinks() {
    return _links;
  }

  public void setLinks(ManoServiceLinks _links) {
    this._links = _links;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ManoService manoService = (ManoService) o;
    return Objects.equals(this.id, manoService.id) &&
        Objects.equals(this.name, manoService.name) &&
        Objects.equals(this.description, manoService.description) &&
        Objects.equals(this.manoServiceInterfaceIds, manoService.manoServiceInterfaceIds) &&
        Objects.equals(this._links, manoService._links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, manoServiceInterfaceIds, _links);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ManoService {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    manoServiceInterfaceIds: ").append(toIndentedString(manoServiceInterfaceIds)).append("\n");
    sb.append("    _links: ").append(toIndentedString(_links)).append("\n");
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
