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
package com.ubiqube.etsi.mano.v261.model.vnfm.vrqan;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.annotation.Nonnull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;


/**
 * This type represents an alarm cleared notification about VNF faults. The notification shall be triggered by the VNFM when an alarm has been cleared.
 */
@Schema(description = "This type represents an alarm cleared notification about VNF faults. The notification shall be triggered by the VNFM when an alarm has been cleared. ")
@Validated

public class AlarmClearedNotification {
	@JsonProperty("id")
	private String id = null;

	/**
	 * Discriminator for the different notification types. Shall be set to \"AlarmClearedNotification\" for this notification type.
	 */
	public enum NotificationTypeEnum {
		ALARMCLEAREDNOTIFICATION("AlarmClearedNotification");

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

	@JsonProperty("alarmId")
	private String alarmId = null;

	@JsonProperty("alarmClearedTime")
	private LocalDateTime alarmClearedTime = null;

	@JsonProperty("_links")
	private AlarmClearedNotificationLinks links = null;

	public AlarmClearedNotification id(final String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identifier of this notification. If a notification is sent multiple times due to multiple subscriptions, the \"id\" attribute of all these notifications shall have the same value.
	 *
	 * @return id
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifier of this notification. If a notification is sent multiple times due to multiple subscriptions, the \"id\" attribute of all these notifications shall have the same value. ")
	@Nonnull

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public AlarmClearedNotification notificationType(final NotificationTypeEnum notificationType) {
		this.notificationType = notificationType;
		return this;
	}

	/**
	 * Discriminator for the different notification types. Shall be set to \"AlarmClearedNotification\" for this notification type.
	 *
	 * @return notificationType
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Discriminator for the different notification types. Shall be set to \"AlarmClearedNotification\" for this notification type. ")
	@Nonnull

	public NotificationTypeEnum getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(final NotificationTypeEnum notificationType) {
		this.notificationType = notificationType;
	}

	public AlarmClearedNotification subscriptionId(final String subscriptionId) {
		this.subscriptionId = subscriptionId;
		return this;
	}

	/**
	 * Identifier of the subscription that this notification relates to.
	 *
	 * @return subscriptionId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifier of the subscription that this notification relates to. ")
	@Nonnull

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(final String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public AlarmClearedNotification timeStamp(final String timeStamp) {
		this.timeStamp = timeStamp;
		return this;
	}

	/**
	 * Date-time of the generation of the notification.
	 *
	 * @return timeStamp
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Date-time of the generation of the notification. ")
	@Nonnull

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(final String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public AlarmClearedNotification alarmId(final String alarmId) {
		this.alarmId = alarmId;
		return this;
	}

	/**
	 * Alarm identifier.
	 *
	 * @return alarmId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Alarm identifier. ")
	@Nonnull

	public String getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(final String alarmId) {
		this.alarmId = alarmId;
	}

	public AlarmClearedNotification alarmClearedTime(final LocalDateTime alarmClearedTime) {
		this.alarmClearedTime = alarmClearedTime;
		return this;
	}

	/**
	 * The time stamp indicating when the alarm was cleared.
	 *
	 * @return alarmClearedTime
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "The time stamp indicating when the alarm was cleared. ")
	@Nonnull

	@Valid

	public LocalDateTime getAlarmClearedTime() {
		return alarmClearedTime;
	}

	public void setAlarmClearedTime(final LocalDateTime alarmClearedTime) {
		this.alarmClearedTime = alarmClearedTime;
	}

	public AlarmClearedNotification links(final AlarmClearedNotificationLinks links) {
		this.links = links;
		return this;
	}

	/**
	 * Get links
	 *
	 * @return links
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@Nonnull

	@Valid

	public AlarmClearedNotificationLinks getLinks() {
		return links;
	}

	public void setLinks(final AlarmClearedNotificationLinks links) {
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
		final AlarmClearedNotification alarmClearedNotification = (AlarmClearedNotification) o;
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
		final StringBuilder sb = new StringBuilder();
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
	 * Convert the given object to string with each line indented by 4 spaces (except the first line).
	 */
	private String toIndentedString(final java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
