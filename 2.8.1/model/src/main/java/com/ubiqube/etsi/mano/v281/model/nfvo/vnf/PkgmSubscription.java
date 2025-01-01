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
package com.ubiqube.etsi.mano.v281.model.nfvo.vnf;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v281.model.nfvo.vnf.PkgmNotificationsFilter;
import com.ubiqube.etsi.mano.v281.model.nfvo.vnf.PkgmSubscriptionLinks;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents a subscription related to notifications about VNF package management. 
 */
@Schema (description= "This type represents a subscription related to notifications about VNF package management. " )
@Validated

public class PkgmSubscription   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("filter")
  private PkgmNotificationsFilter filter = null;

  @JsonProperty("callbackUri")
  private String callbackUri = null;

  @JsonProperty("_links")
  private PkgmSubscriptionLinks links = null;

  public PkgmSubscription id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of this \"Individual subscription\" resource. 
   * @return id
  **/
  @Schema(required = true , description = "Identifier of this \"Individual subscription\" resource. ")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PkgmSubscription filter(PkgmNotificationsFilter filter) {
    this.filter = filter;
    return this;
  }

  /**
   * Filter settings for this subscription, to define the subset of all notifications this subscription relates to. A particular notification is sent to the subscriber if the filter matches, or if there is no filter. 
   * @return filter
  **/
  @Schema(description = "Filter settings for this subscription, to define the subset of all notifications this subscription relates to. A particular notification is sent to the subscriber if the filter matches, or if there is no filter. ")

  @Valid

  public PkgmNotificationsFilter getFilter() {
    return filter;
  }

  public void setFilter(PkgmNotificationsFilter filter) {
    this.filter = filter;
  }

  public PkgmSubscription callbackUri(String callbackUri) {
    this.callbackUri = callbackUri;
    return this;
  }

  /**
   * The URI of the endpoint to send the notification to 
   * @return callbackUri
  **/
  @Schema(required = true , description = "The URI of the endpoint to send the notification to ")
  @NotNull


  public String getCallbackUri() {
    return callbackUri;
  }

  public void setCallbackUri(String callbackUri) {
    this.callbackUri = callbackUri;
  }

  public PkgmSubscription links(PkgmSubscriptionLinks links) {
    this.links = links;
    return this;
  }

  /**
   * Get links
   * @return links
  **/
  @Schema(required = true , description = "")
  @NotNull

  @Valid

  public PkgmSubscriptionLinks getLinks() {
    return links;
  }

  public void setLinks(PkgmSubscriptionLinks links) {
    this.links = links;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PkgmSubscription pkgmSubscription = (PkgmSubscription) o;
    return Objects.equals(this.id, pkgmSubscription.id) &&
    Objects.equals(this.filter, pkgmSubscription.filter) &&
    Objects.equals(this.callbackUri, pkgmSubscription.callbackUri) &&
    Objects.equals(this.links, pkgmSubscription.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, filter, callbackUri, links);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PkgmSubscription {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
    sb.append("    callbackUri: ").append(toIndentedString(callbackUri)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
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

