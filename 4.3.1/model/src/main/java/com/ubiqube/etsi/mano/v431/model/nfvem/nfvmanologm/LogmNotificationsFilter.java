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
package com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanologm;

import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanocim.ManoEntitySubscriptionFilter;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;

/**
 * This type represents a filter that can be used to subscribe for notifications
 * related to log management events. * NOTE: The permitted values of the
 * \&quot;notificationTypes\&quot; attribute are spelled exactly as the names of
 * the notification types to facilitate automated code generation systems.
 */
@Schema(description = "This type represents a filter that can be used to subscribe for notifications related to log management events. * NOTE: The permitted values of the \"notificationTypes\" attribute are spelled exactly as the names         of the notification types to facilitate automated code generation systems.")
@Validated

public class LogmNotificationsFilter {
	@JsonProperty("objectInstanceFilter")
	private ManoEntitySubscriptionFilter objectInstanceFilter = null;

	/**
	 * Match particular notification types. Permitted values: -
	 * LogReportAvailableNotification See note.
	 */
	public enum NotificationTypesEnum {
		LOGREPORTAVAILABLENOTIFICATION("LogReportAvailableNotification");

		private final String value;

		NotificationTypesEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static NotificationTypesEnum fromValue(final String text) {
			for (final NotificationTypesEnum b : NotificationTypesEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("notificationTypes")
	private List<NotificationTypesEnum> notificationTypes = null;

	public LogmNotificationsFilter objectInstanceFilter(final ManoEntitySubscriptionFilter objectInstanceFilter) {
		this.objectInstanceFilter = objectInstanceFilter;
		return this;
	}

	/**
	 * Get objectInstanceFilter
	 *
	 * @return objectInstanceFilter
	 **/
	@Schema(description = "")

	@Valid
	public ManoEntitySubscriptionFilter getObjectInstanceFilter() {
		return objectInstanceFilter;
	}

	public void setObjectInstanceFilter(final ManoEntitySubscriptionFilter objectInstanceFilter) {
		this.objectInstanceFilter = objectInstanceFilter;
	}

	public LogmNotificationsFilter notificationTypes(final List<NotificationTypesEnum> notificationTypes) {
		this.notificationTypes = notificationTypes;
		return this;
	}

	/**
	 * Match particular notification types. Permitted values: -
	 * LogReportAvailableNotification See note.
	 *
	 * @return notificationTypes
	 **/
	@Schema(description = "Match particular notification types. Permitted values: - LogReportAvailableNotification See note.")

	public List<NotificationTypesEnum> getNotificationTypes() {
		return notificationTypes;
	}

	public void setNotificationTypes(final List<NotificationTypesEnum> notificationTypes) {
		this.notificationTypes = notificationTypes;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final LogmNotificationsFilter logmNotificationsFilter = (LogmNotificationsFilter) o;
		return Objects.equals(this.objectInstanceFilter, logmNotificationsFilter.objectInstanceFilter) &&
				Objects.equals(this.notificationTypes, logmNotificationsFilter.notificationTypes);
	}

	@Override
	public int hashCode() {
		return Objects.hash(objectInstanceFilter, notificationTypes);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class LogmNotificationsFilter {\n");

		sb.append("    objectInstanceFilter: ").append(toIndentedString(objectInstanceFilter)).append("\n");
		sb.append("    notificationTypes: ").append(toIndentedString(notificationTypes)).append("\n");
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
