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
 * This type represents a PNFD management notification, which informs the receiver of the successful on-boarding of aPNFD. It shall comply with the provisions defined in Table 5.5.2.13-1. The support of this notification is mandatory. The notification is triggered when a new PNFD is on-boarded.
 */
@Schema (description= "This type represents a PNFD management notification, which informs the receiver of the successful on-boarding of aPNFD. It shall comply with the provisions defined in Table 5.5.2.13-1. The support of this notification is mandatory. The notification is triggered when a new PNFD is on-boarded. " )
@Validated

public class PnfdOnBoardingNotification {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("notificationType")
	private String notificationType = null;

	@JsonProperty("subscriptionId")
	private String subscriptionId = null;

	@JsonProperty("timeStamp")
	private OffsetDateTime timeStamp = null;

	@JsonProperty("pnfdInfoId")
	private String pnfdInfoId = null;

	@JsonProperty("pnfdId")
	private String pnfdId = null;

	@JsonProperty("_links")
	private PnfdmLinks links = null;

  public PnfdOnBoardingNotification id(final String id) {
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

  public PnfdOnBoardingNotification notificationType(final String notificationType) {
    this.notificationType = notificationType;
    return this;
  }

  /**
   * Discriminator for the different notification types. Shall be set to \"PnfdOnboardingNotification\" for this notification type.
   *
   * @return notificationType
   **/
  @Schema(required = true , description = "Discriminator for the different notification types. Shall be set to \"PnfdOnboardingNotification\" for this notification type. ")
  @NotNull

  public String getNotificationType() {
    return notificationType;
  }

  public void setNotificationType(final String notificationType) {
    this.notificationType = notificationType;
  }

  public PnfdOnBoardingNotification subscriptionId(final String subscriptionId) {
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

  public PnfdOnBoardingNotification timeStamp(final OffsetDateTime timeStamp) {
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

  public PnfdOnBoardingNotification pnfdInfoId(final String pnfdInfoId) {
    this.pnfdInfoId = pnfdInfoId;
    return this;
  }

  /**
   * Get pnfdInfoId
   *
   * @return pnfdInfoId
   **/
  @Schema(required = true , description = "")
  @NotNull

  public String getPnfdInfoId() {
    return pnfdInfoId;
  }

  public void setPnfdInfoId(final String pnfdInfoId) {
    this.pnfdInfoId = pnfdInfoId;
  }

  public PnfdOnBoardingNotification pnfdId(final String pnfdId) {
    this.pnfdId = pnfdId;
    return this;
  }

  /**
   * Get pnfdId
   *
   * @return pnfdId
   **/
  @Schema(required = true , description = "")
  @NotNull

  public String getPnfdId() {
    return pnfdId;
  }

  public void setPnfdId(final String pnfdId) {
    this.pnfdId = pnfdId;
  }

  public PnfdOnBoardingNotification links(final PnfdmLinks links) {
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

  public PnfdmLinks getLinks() {
    return links;
  }

  public void setLinks(final PnfdmLinks links) {
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
    final PnfdOnBoardingNotification pnfdOnBoardingNotification = (PnfdOnBoardingNotification) o;
    return Objects.equals(this.id, pnfdOnBoardingNotification.id) &&
    Objects.equals(this.notificationType, pnfdOnBoardingNotification.notificationType) &&
    Objects.equals(this.subscriptionId, pnfdOnBoardingNotification.subscriptionId) &&
    Objects.equals(this.timeStamp, pnfdOnBoardingNotification.timeStamp) &&
    Objects.equals(this.pnfdInfoId, pnfdOnBoardingNotification.pnfdInfoId) &&
    Objects.equals(this.pnfdId, pnfdOnBoardingNotification.pnfdId) &&
    Objects.equals(this.links, pnfdOnBoardingNotification.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, notificationType, subscriptionId, timeStamp, pnfdInfoId, pnfdId, links);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("class PnfdOnBoardingNotification {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    notificationType: ").append(toIndentedString(notificationType)).append("\n");
    sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
    sb.append("    timeStamp: ").append(toIndentedString(timeStamp)).append("\n");
    sb.append("    pnfdInfoId: ").append(toIndentedString(pnfdInfoId)).append("\n");
    sb.append("    pnfdId: ").append(toIndentedString(pnfdId)).append("\n");
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
