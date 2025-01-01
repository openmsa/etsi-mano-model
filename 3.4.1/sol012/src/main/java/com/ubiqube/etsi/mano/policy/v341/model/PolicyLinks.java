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
package com.ubiqube.etsi.mano.policy.v341.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ubiqube.etsi.mano.policy.v341.model.Link;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Links for this resource 
 */
@Schema(description = "Links for this resource ")
@Validated


public class PolicyLinks   {
  @JsonProperty("self")
  private Link self = null;

  @JsonProperty("selected")
  private Link selected = null;

  @JsonProperty("versions")
  @Valid
  private List<Link> versions = null;

  public PolicyLinks self(Link self) {
    this.self = self;
    return this;
  }

  /**
   * Get self
   * @return self
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    @Valid
    public Link getSelf() {
    return self;
  }

  public void setSelf(Link self) {
    this.self = self;
  }

  public PolicyLinks selected(Link selected) {
    this.selected = selected;
    return this;
  }

  /**
   * Get selected
   * @return selected
   **/
  @Schema(description = "")
  
    @Valid
    public Link getSelected() {
    return selected;
  }

  public void setSelected(Link selected) {
    this.selected = selected;
  }

  public PolicyLinks versions(List<Link> versions) {
    this.versions = versions;
    return this;
  }

  public PolicyLinks addVersionsItem(Link versionsItem) {
    if (this.versions == null) {
      this.versions = new ArrayList<>();
    }
    this.versions.add(versionsItem);
    return this;
  }

  /**
   * URIs of all the transferred versions of this policy, if exists. 
   * @return versions
   **/
  @Schema(description = "URIs of all the transferred versions of this policy, if exists. ")
      @Valid
    public List<Link> getVersions() {
    return versions;
  }

  public void setVersions(List<Link> versions) {
    this.versions = versions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyLinks policyLinks = (PolicyLinks) o;
    return Objects.equals(this.self, policyLinks.self) &&
        Objects.equals(this.selected, policyLinks.selected) &&
        Objects.equals(this.versions, policyLinks.versions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, selected, versions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyLinks {\n");
    
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    selected: ").append(toIndentedString(selected)).append("\n");
    sb.append("    versions: ").append(toIndentedString(versions)).append("\n");
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
