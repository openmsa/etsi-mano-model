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
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ubiqube.etsi.mano.v281.model.em.vnffm.Alarm;

/**
 * This type represents an alarm notification about VNF faults. This
 * notification shall be triggered by the VNFM when: * An alarm has been
 * created. * An alarm has been updated, e.g. if the severity of the alarm has
 * changed.
 */
@Schema (description= "This type represents an alarm notification about VNF faults. This notification shall be triggered by the VNFM when: * An alarm has been created. * An alarm has been updated, e.g. if the severity of the alarm has   changed. " )
@Validated

public class AlarmNotification {
	@JsonProperty("id")
	private String id = null;

	/**
	 * Discriminator for the different notification types. Shall be set to
	 * \"AlarmNotification\" for this notification type.
	 */
	public enum NotificationTypeEnum {
		ALARMNOTIFICATION("AlarmNotification");

		private final String value;

    NotificationTypeEnum(final String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static NotificationTypeEnum fromValue(final String text) {
      for (final NotificationTypeEnum b : NotificationTypeEnum.values()) {
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

	@JsonProperty("alarm")
	private Alarm alarm = null;

	@JsonProperty("_links")
	private AlarmNotificationLinks links = null;

  public AlarmNotification id(final String id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of this notification. If a notification is sent multiple times due
   * to multiple subscriptions, the \"id\" attribute of all these notifications
   * shall have the same value.
   *
   * @return id
   **/
  @Schema(required = true , description = "Identifier of this notification. If a notification is sent multiple times due to multiple subscriptions, the \"id\" attribute of all these notifications shall have the same value. ")
  @NotNull

  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public AlarmNotification notificationType(final NotificationTypeEnum notificationType) {
    this.notificationType = notificationType;
    return this;
  }

  /**
   * Discriminator for the different notification types. Shall be set to
   * \"AlarmNotification\" for this notification type.
   *
   * @return notificationType
   **/
  @Schema(required = true , description = "Discriminator for the different notification types. Shall be set to \"AlarmNotification\" for this notification type. ")
  @NotNull

  public NotificationTypeEnum getNotificationType() {
    return notificationType;
  }

  public void setNotificationType(final NotificationTypeEnum notificationType) {
    this.notificationType = notificationType;
  }

  public AlarmNotification subscriptionId(final String subscriptionId) {
    this.subscriptionId = subscriptionId;
    return this;
  }

  /**
   * Identifier of the subscription that this notification relates to.
   *
   * @return subscriptionId
   **/
  @Schema(required = true , description = "Identifier of the subscription that this notification relates to. ")
  @NotNull

  public String getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(final String subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public AlarmNotification timeStamp(final String timeStamp) {
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

  public String getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(final String timeStamp) {
    this.timeStamp = timeStamp;
  }

  public AlarmNotification alarm(final Alarm alarm) {
    this.alarm = alarm;
    return this;
  }

  /**
   * Information about an alarm including AlarmId, affected VNF identifier, and
   * FaultDetails.
   *
   * @return alarm
   **/
  @Schema(required = true , description = "Information about an alarm including AlarmId, affected VNF identifier, and FaultDetails. ")
  @NotNull

  @Valid

  public Alarm getAlarm() {
    return alarm;
  }

  public void setAlarm(final Alarm alarm) {
    this.alarm = alarm;
  }

  public AlarmNotification links(final AlarmNotificationLinks links) {
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

  public AlarmNotificationLinks getLinks() {
    return links;
  }

  public void setLinks(final AlarmNotificationLinks links) {
    this.links = links;
  }

  @Override
  public boolean equals(final java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final AlarmNotification alarmNotification = (AlarmNotification) o;
    return Objects.equals(this.id, alarmNotification.id) &&
    Objects.equals(this.notificationType, alarmNotification.notificationType) &&
    Objects.equals(this.subscriptionId, alarmNotification.subscriptionId) &&
    Objects.equals(this.timeStamp, alarmNotification.timeStamp) &&
    Objects.equals(this.alarm, alarmNotification.alarm) &&
    Objects.equals(this.links, alarmNotification.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, notificationType, subscriptionId, timeStamp, alarm, links);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("class AlarmNotification {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    notificationType: ").append(toIndentedString(notificationType)).append("\n");
    sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
    sb.append("    timeStamp: ").append(toIndentedString(timeStamp)).append("\n");
    sb.append("    alarm: ").append(toIndentedString(alarm)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
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
