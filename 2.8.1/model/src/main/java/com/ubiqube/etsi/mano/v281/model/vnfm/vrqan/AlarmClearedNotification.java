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
package com.ubiqube.etsi.mano.v281.model.vnfm.vrqan;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ubiqube.etsi.mano.v281.model.vnfm.vrqan.AlarmClearedNotificationLinks;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents an alarm cleared notification about VNF faults. The notification shall be triggered by the VNFM when an alarm has been cleared. 
 */
@Schema (description= "This type represents an alarm cleared notification about VNF faults. The notification shall be triggered by the VNFM when an alarm has been cleared. " )
@Validated

public class AlarmClearedNotification   {
  @JsonProperty("id")
  private String id = null;

  /**
   * Discriminator for the different notification types. Shall be set to \"AlarmClearedNotification\" for this notification type. 
   */
  public enum NotificationTypeEnum {
    ALARMCLEAREDNOTIFICATION("AlarmClearedNotification");

    private String value;

    NotificationTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static NotificationTypeEnum fromValue(String text) {
      for (NotificationTypeEnum b : NotificationTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("notificationType")
  private NotificationTypeEnum notificationType = null;

  @JsonProperty("subscriptionId")
  private String subscriptionId = null;

  @JsonProperty("timeStamp")
  private String timeStamp = null;

  @JsonProperty("alarmId")
  private String alarmId = null;

  @JsonProperty("alarmClearedTime")
  private String alarmClearedTime = null;

  @JsonProperty("_links")
  private AlarmClearedNotificationLinks links = null;

  public AlarmClearedNotification id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of this notification. If a notification is sent multiple times due to multiple subscriptions, the \"id\" attribute of all these notifications shall have the same value. 
   * @return id
  **/
  @Schema(required = true , description = "Identifier of this notification. If a notification is sent multiple times due to multiple subscriptions, the \"id\" attribute of all these notifications shall have the same value. ")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AlarmClearedNotification notificationType(NotificationTypeEnum notificationType) {
    this.notificationType = notificationType;
    return this;
  }

  /**
   * Discriminator for the different notification types. Shall be set to \"AlarmClearedNotification\" for this notification type. 
   * @return notificationType
  **/
  @Schema(required = true , description = "Discriminator for the different notification types. Shall be set to \"AlarmClearedNotification\" for this notification type. ")
  @NotNull


  public NotificationTypeEnum getNotificationType() {
    return notificationType;
  }

  public void setNotificationType(NotificationTypeEnum notificationType) {
    this.notificationType = notificationType;
  }

  public AlarmClearedNotification subscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
    return this;
  }

  /**
   * Identifier of the subscription that this notification relates to. 
   * @return subscriptionId
  **/
  @Schema(required = true , description = "Identifier of the subscription that this notification relates to. ")
  @NotNull


  public String getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public AlarmClearedNotification timeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
    return this;
  }

  /**
   * Date-time of the generation of the notification. 
   * @return timeStamp
  **/
  @Schema(required = true , description = "Date-time of the generation of the notification. ")
  @NotNull


  public String getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
  }

  public AlarmClearedNotification alarmId(String alarmId) {
    this.alarmId = alarmId;
    return this;
  }

  /**
   * Alarm identifier. 
   * @return alarmId
  **/
  @Schema(required = true , description = "Alarm identifier. ")
  @NotNull


  public String getAlarmId() {
    return alarmId;
  }

  public void setAlarmId(String alarmId) {
    this.alarmId = alarmId;
  }

  public AlarmClearedNotification alarmClearedTime(String alarmClearedTime) {
    this.alarmClearedTime = alarmClearedTime;
    return this;
  }

  /**
   * The time stamp indicating when the alarm was cleared. 
   * @return alarmClearedTime
  **/
  @Schema(required = true , description = "The time stamp indicating when the alarm was cleared. ")
  @NotNull


  public String getAlarmClearedTime() {
    return alarmClearedTime;
  }

  public void setAlarmClearedTime(String alarmClearedTime) {
    this.alarmClearedTime = alarmClearedTime;
  }

  public AlarmClearedNotification links(AlarmClearedNotificationLinks links) {
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

  public AlarmClearedNotificationLinks getLinks() {
    return links;
  }

  public void setLinks(AlarmClearedNotificationLinks links) {
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
    AlarmClearedNotification alarmClearedNotification = (AlarmClearedNotification) o;
    return Objects.equals(this.id, alarmClearedNotification.id) &&
    Objects.equals(this.notificationType, alarmClearedNotification.notificationType) &&
    Objects.equals(this.subscriptionId, alarmClearedNotification.subscriptionId) &&
    Objects.equals(this.timeStamp, alarmClearedNotification.timeStamp) &&
    Objects.equals(this.alarmId, alarmClearedNotification.alarmId) &&
    Objects.equals(this.alarmClearedTime, alarmClearedNotification.alarmClearedTime) &&
    Objects.equals(this.links, alarmClearedNotification.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, notificationType, subscriptionId, timeStamp, alarmId, alarmClearedTime, links);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlarmClearedNotification {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    notificationType: ").append(toIndentedString(notificationType)).append("\n");
    sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
    sb.append("    timeStamp: ").append(toIndentedString(timeStamp)).append("\n");
    sb.append("    alarmId: ").append(toIndentedString(alarmId)).append("\n");
    sb.append("    alarmClearedTime: ").append(toIndentedString(alarmClearedTime)).append("\n");
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

