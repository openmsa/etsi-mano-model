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
package com.ubiqube.etsi.mano.v281.model.nfvo.vnfconfig;

import java.time.OffsetDateTime;
import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This type represents an NSD management notification, which informs the receiver of the successful on-boarding of an NSD. It shall comply with the provisions defined in Table 5.5.2.9-1. The support of this notification is mandatory. The notification shall be triggered by the NFVO when the \&quot; nsdOnboardingState\&quot; attribute of a new NSD has changed to \&quot;ONBOARDED\&quot;.
 */
@Schema (description= "This type represents an NSD management notification, which informs the receiver of the successful on-boarding of an NSD. It shall comply with the provisions defined in Table 5.5.2.9-1. The support of this notification is mandatory. The notification shall be triggered by the NFVO when the \" nsdOnboardingState\" attribute of a new NSD has changed to \"ONBOARDED\". " )
@Validated

public class NsdOnBoardingNotification {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("notificationType")
	private String notificationType = null;

	@JsonProperty("subscriptionId")
	private String subscriptionId = null;

	@JsonProperty("timeStamp")
	private OffsetDateTime timeStamp = null;

	@JsonProperty("nsdInfoId")
	private String nsdInfoId = null;

	@JsonProperty("nsdId")
	private String nsdId = null;

	@JsonProperty("_links")
	private NsdmLinks links = null;

  public NsdOnBoardingNotification id(final String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   *
   * @return id
   **/
  @Schema(required = true , description = "")
  @NotNull

  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public NsdOnBoardingNotification notificationType(final String notificationType) {
    this.notificationType = notificationType;
    return this;
  }

  /**
   * Discriminator for the different notification types. Shall be set to \"NsdOnboardingNotification\" for this notification type.
   *
   * @return notificationType
   **/
  @Schema(required = true , description = "Discriminator for the different notification types. Shall be set to \"NsdOnboardingNotification\" for this notification type. ")
  @NotNull

  public String getNotificationType() {
    return notificationType;
  }

  public void setNotificationType(final String notificationType) {
    this.notificationType = notificationType;
  }

  public NsdOnBoardingNotification subscriptionId(final String subscriptionId) {
    this.subscriptionId = subscriptionId;
    return this;
  }

  /**
   * Get subscriptionId
   *
   * @return subscriptionId
   **/
  @Schema(required = true , description = "")
  @NotNull

  public String getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(final String subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public NsdOnBoardingNotification timeStamp(final OffsetDateTime timeStamp) {
    this.timeStamp = timeStamp;
    return this;
  }

  /**
   * Date-time of the generation of the notification.
   *
   * @return timeStamp
   **/
  @Schema(required = true , description = "Date-time of the generation of the notification. ")
  @NotNull

  @Valid

  public OffsetDateTime getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(final OffsetDateTime timeStamp) {
    this.timeStamp = timeStamp;
  }

  public NsdOnBoardingNotification nsdInfoId(final String nsdInfoId) {
    this.nsdInfoId = nsdInfoId;
    return this;
  }

  /**
   * Get nsdInfoId
   *
   * @return nsdInfoId
   **/
  @Schema(required = true , description = "")
  @NotNull

  public String getNsdInfoId() {
    return nsdInfoId;
  }

  public void setNsdInfoId(final String nsdInfoId) {
    this.nsdInfoId = nsdInfoId;
  }

  public NsdOnBoardingNotification nsdId(final String nsdId) {
    this.nsdId = nsdId;
    return this;
  }

  /**
   * Get nsdId
   *
   * @return nsdId
   **/
  @Schema(required = true , description = "")
  @NotNull

  public String getNsdId() {
    return nsdId;
  }

  public void setNsdId(final String nsdId) {
    this.nsdId = nsdId;
  }

  public NsdOnBoardingNotification links(final NsdmLinks links) {
    this.links = links;
    return this;
  }

  /**
   * Get links
   *
   * @return links
   **/
  @Schema(required = true , description = "")
  @NotNull

  @Valid

  public NsdmLinks getLinks() {
    return links;
  }

  public void setLinks(final NsdmLinks links) {
    this.links = links;
  }

  @Override
  public boolean equals(final java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final NsdOnBoardingNotification nsdOnBoardingNotification = (NsdOnBoardingNotification) o;
    return Objects.equals(this.id, nsdOnBoardingNotification.id) &&
    Objects.equals(this.notificationType, nsdOnBoardingNotification.notificationType) &&
    Objects.equals(this.subscriptionId, nsdOnBoardingNotification.subscriptionId) &&
    Objects.equals(this.timeStamp, nsdOnBoardingNotification.timeStamp) &&
    Objects.equals(this.nsdInfoId, nsdOnBoardingNotification.nsdInfoId) &&
    Objects.equals(this.nsdId, nsdOnBoardingNotification.nsdId) &&
    Objects.equals(this.links, nsdOnBoardingNotification.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, notificationType, subscriptionId, timeStamp, nsdInfoId, nsdId, links);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("class NsdOnBoardingNotification {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    notificationType: ").append(toIndentedString(notificationType)).append("\n");
    sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
    sb.append("    timeStamp: ").append(toIndentedString(timeStamp)).append("\n");
    sb.append("    nsdInfoId: ").append(toIndentedString(nsdInfoId)).append("\n");
    sb.append("    nsdId: ").append(toIndentedString(nsdId)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(final java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
