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
package com.ubiqube.etsi.mano.v261.model.nfvo.nsperfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;


import jakarta.validation.Valid;
import jakarta.annotation.Nonnull;

/**
  * This type represents a threshold. 
 **/
@Schema(description="This type represents a threshold. ")
public class ThresholdsThreshold  {
  
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "An identifier with the intention of being globally unique. ")
 /**
   * An identifier with the intention of being globally unique. 
  **/
  private String id = null;

  @Schema(requiredMode = RequiredMode.REQUIRED, description = "An identifier with the intention of being globally unique. ")
 /**
   * An identifier with the intention of being globally unique. 
  **/
  private String objectInstanceId = null;

  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
  @Valid
  private ThresholdsThresholdCriteria criteria = null;

  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
  @Valid
  private ThresholdsThresholdLinks links = null;
 /**
   * An identifier with the intention of being globally unique. 
   * @return id
  **/
  @JsonProperty("id")
  @Nonnull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ThresholdsThreshold id(String id) {
    this.id = id;
    return this;
  }

 /**
   * An identifier with the intention of being globally unique. 
   * @return objectInstanceId
  **/
  @JsonProperty("objectInstanceId")
  @Nonnull
  public String getObjectInstanceId() {
    return objectInstanceId;
  }

  public void setObjectInstanceId(String objectInstanceId) {
    this.objectInstanceId = objectInstanceId;
  }

  public ThresholdsThreshold objectInstanceId(String objectInstanceId) {
    this.objectInstanceId = objectInstanceId;
    return this;
  }

 /**
   * Get criteria
   * @return criteria
  **/
  @JsonProperty("criteria")
  @Nonnull
  public ThresholdsThresholdCriteria getCriteria() {
    return criteria;
  }

  public void setCriteria(ThresholdsThresholdCriteria criteria) {
    this.criteria = criteria;
  }

  public ThresholdsThreshold criteria(ThresholdsThresholdCriteria criteria) {
    this.criteria = criteria;
    return this;
  }

 /**
   * Get links
   * @return links
  **/
  @JsonProperty("_links")
  @Nonnull
  public ThresholdsThresholdLinks getLinks() {
    return links;
  }

  public void setLinks(ThresholdsThresholdLinks links) {
    this.links = links;
  }

  public ThresholdsThreshold links(ThresholdsThresholdLinks links) {
    this.links = links;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ThresholdsThreshold {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    objectInstanceId: ").append(toIndentedString(objectInstanceId)).append("\n");
    sb.append("    criteria: ").append(toIndentedString(criteria)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private static String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

