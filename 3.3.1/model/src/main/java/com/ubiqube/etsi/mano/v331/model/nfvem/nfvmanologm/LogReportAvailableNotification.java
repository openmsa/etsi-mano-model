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
package com.ubiqube.etsi.mano.v331.model.nfvem.nfvmanologm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v331.model.nfvem.nfvmanologm.LogReportAvailableNotificationLinks;
import com.ubiqube.etsi.mano.v331.model.nfvem.nfvmanologm.ManoManagedObjectReference;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This notification informs the receiver that the log report of the NFV-MANO functional entity is available. It shall comply with the provisions defined in table 8.6.2.4-1. The notification shall be triggered by the NFV-MANO functional entity when log information has been collected by the logging job and the log report is available.
 */
@Schema(description = "This notification informs the receiver that the log report of the NFV-MANO functional entity is available. It shall comply with the provisions defined in table 8.6.2.4-1. The notification shall be triggered by the NFV-MANO functional entity when log information has been collected by the logging job and the log report is available.")
@Validated


public class LogReportAvailableNotification   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("notificationType")
  private String notificationType = null;

  @JsonProperty("subscriptionId")
  private String subscriptionId = null;

  @JsonProperty("timeStamp")
  private OffsetDateTime timeStamp = null;

  @JsonProperty("objectInstanceId")
  private ManoManagedObjectReference objectInstanceId = null;

  @JsonProperty("_links")
  private LogReportAvailableNotificationLinks _links = null;

  public LogReportAvailableNotification id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public LogReportAvailableNotification notificationType(String notificationType) {
    this.notificationType = notificationType;
    return this;
  }

  /**
   * Discriminator for the different notification types. Shall be set to \"LogReportAvailableNotification\" for this notification type.
   * @return notificationType
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Discriminator for the different notification types. Shall be set to \"LogReportAvailableNotification\" for this notification type.")
      @NotNull

    public String getNotificationType() {
    return notificationType;
  }

  public void setNotificationType(String notificationType) {
    this.notificationType = notificationType;
  }

  public LogReportAvailableNotification subscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
    return this;
  }

  /**
   * Get subscriptionId
   * @return subscriptionId
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    public String getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public LogReportAvailableNotification timeStamp(OffsetDateTime timeStamp) {
    this.timeStamp = timeStamp;
    return this;
  }

  /**
   * Get timeStamp
   * @return timeStamp
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    @Valid
    public OffsetDateTime getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(OffsetDateTime timeStamp) {
    this.timeStamp = timeStamp;
  }

  public LogReportAvailableNotification objectInstanceId(ManoManagedObjectReference objectInstanceId) {
    this.objectInstanceId = objectInstanceId;
    return this;
  }

  /**
   * Get objectInstanceId
   * @return objectInstanceId
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    @Valid
    public ManoManagedObjectReference getObjectInstanceId() {
    return objectInstanceId;
  }

  public void setObjectInstanceId(ManoManagedObjectReference objectInstanceId) {
    this.objectInstanceId = objectInstanceId;
  }

  public LogReportAvailableNotification _links(LogReportAvailableNotificationLinks _links) {
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
    public LogReportAvailableNotificationLinks getLinks() {
    return _links;
  }

  public void setLinks(LogReportAvailableNotificationLinks _links) {
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
    LogReportAvailableNotification logReportAvailableNotification = (LogReportAvailableNotification) o;
    return Objects.equals(this.id, logReportAvailableNotification.id) &&
        Objects.equals(this.notificationType, logReportAvailableNotification.notificationType) &&
        Objects.equals(this.subscriptionId, logReportAvailableNotification.subscriptionId) &&
        Objects.equals(this.timeStamp, logReportAvailableNotification.timeStamp) &&
        Objects.equals(this.objectInstanceId, logReportAvailableNotification.objectInstanceId) &&
        Objects.equals(this._links, logReportAvailableNotification._links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, notificationType, subscriptionId, timeStamp, objectInstanceId, _links);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LogReportAvailableNotification {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    notificationType: ").append(toIndentedString(notificationType)).append("\n");
    sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
    sb.append("    timeStamp: ").append(toIndentedString(timeStamp)).append("\n");
    sb.append("    objectInstanceId: ").append(toIndentedString(objectInstanceId)).append("\n");
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
