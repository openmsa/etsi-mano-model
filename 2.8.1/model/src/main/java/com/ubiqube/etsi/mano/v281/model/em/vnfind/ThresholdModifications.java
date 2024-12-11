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
package com.ubiqube.etsi.mano.v281.model.em.vnfind;

import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v281.model.em.SubscriptionAuthentication;

/**
 * This type represents modifications to a threshold. It shall comply with the
 * provisions defined in table 6.5.2.11-1.
 */
@Schema (description= "This type represents modifications to a threshold. It shall comply with the provisions defined in table 6.5.2.11-1. " )
@Validated

public class ThresholdModifications {
	@JsonProperty("callbackUri")
	private String callbackUri = null;

	@JsonProperty("authentication")
	private SubscriptionAuthentication authentication = null;

  public ThresholdModifications callbackUri(final String callbackUri) {
    this.callbackUri = callbackUri;
    return this;
  }

  /**
   * New value of the \"callbackUri\" attribute. The value \"null\" is not
   * permitted. See note.
   *
   * @return callbackUri
   **/
  @Schema(description = "New value of the \"callbackUri\" attribute. The value \"null\" is not permitted. See note. ")

  public String getCallbackUri() {
    return callbackUri;
  }

  public void setCallbackUri(final String callbackUri) {
    this.callbackUri = callbackUri;
  }

  public ThresholdModifications authentication(final SubscriptionAuthentication authentication) {
    this.authentication = authentication;
    return this;
  }

  /**
   * New value of the \"authentication\" attribute, or \"null\" to remove the
   * attribute. If present in a request body, these modifications shall be applied
   * according to the rules of JSON Merge Patch. This attribute shall not be
   * present in response bodies. At least one of the attributes defined in this
   * type shall be present in request bodies.
   *
   * @return authentication
   **/
  @Schema(description = "New value of the \"authentication\" attribute, or \"null\" to remove the attribute. If present in a request body, these modifications shall be applied according to the rules of JSON Merge Patch. This attribute shall not be present in response bodies. At least one of the attributes defined in this type shall be present in request bodies. ")

  @Valid

  public SubscriptionAuthentication getAuthentication() {
    return authentication;
  }

  public void setAuthentication(final SubscriptionAuthentication authentication) {
    this.authentication = authentication;
  }

  @Override
  public boolean equals(final java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final ThresholdModifications thresholdModifications = (ThresholdModifications) o;
    return Objects.equals(this.callbackUri, thresholdModifications.callbackUri) &&
    Objects.equals(this.authentication, thresholdModifications.authentication);
  }

  @Override
  public int hashCode() {
    return Objects.hash(callbackUri, authentication);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("class ThresholdModifications {\n");

    sb.append("    callbackUri: ").append(toIndentedString(callbackUri)).append("\n");
    sb.append("    authentication: ").append(toIndentedString(authentication)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(final java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
