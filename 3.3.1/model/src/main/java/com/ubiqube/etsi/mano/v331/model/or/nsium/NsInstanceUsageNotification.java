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
package com.ubiqube.etsi.mano.v331.model.or.nsium;

import java.time.OffsetDateTime;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v331.model.em.vnflcm.NotificationLink;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

/**
 * This type represents an NS instance usage notification, which indicates the
 * start or end of usage of an NS instance as a part of a composite NS managed
 * by the NFVO-C. It shall comply with the provisions defined in table
 * 8.6.2.4-1.
 */
@Schema(description = "This type represents an NS instance usage notification, which indicates the start  or end of usage of an NS instance as a part of a composite NS managed by the NFVO-C.  It shall comply with the provisions defined in table 8.6.2.4-1.")
@Validated

public class NsInstanceUsageNotification {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("notificationType")
	private String notificationType = null;

	@JsonProperty("subscriptionId")
	private String subscriptionId = null;

	@JsonProperty("timeStamp")
	private OffsetDateTime timeStamp = null;

	@JsonProperty("nsInstanceId")
	private String nsInstanceId = null;

	@JsonProperty("status")
	private NsInstanceUsageStatusType status = null;

	@JsonProperty("_links")
	private NotificationLink _links = null;

	public NsInstanceUsageNotification id(final String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 *
	 * @return id
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public NsInstanceUsageNotification notificationType(final String notificationType) {
		this.notificationType = notificationType;
		return this;
	}

	/**
	 * Discriminator for the different notification types. Shall be set to
	 * \"NsInstanceUsageNotification\" for this notification type.
	 *
	 * @return notificationType
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Discriminator for the different notification types. Shall be set to  \"NsInstanceUsageNotification\" for this notification type.")
	@NotNull

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(final String notificationType) {
		this.notificationType = notificationType;
	}

	public NsInstanceUsageNotification subscriptionId(final String subscriptionId) {
		this.subscriptionId = subscriptionId;
		return this;
	}

	/**
	 * Get subscriptionId
	 *
	 * @return subscriptionId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(final String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public NsInstanceUsageNotification timeStamp(final OffsetDateTime timeStamp) {
		this.timeStamp = timeStamp;
		return this;
	}

	/**
	 * Get timeStamp
	 *
	 * @return timeStamp
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public OffsetDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(final OffsetDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public NsInstanceUsageNotification nsInstanceId(final String nsInstanceId) {
		this.nsInstanceId = nsInstanceId;
		return this;
	}

	/**
	 * Get nsInstanceId
	 *
	 * @return nsInstanceId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getNsInstanceId() {
		return nsInstanceId;
	}

	public void setNsInstanceId(final String nsInstanceId) {
		this.nsInstanceId = nsInstanceId;
	}

	public NsInstanceUsageNotification status(final NsInstanceUsageStatusType status) {
		this.status = status;
		return this;
	}

	/**
	 * Get status
	 *
	 * @return status
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public NsInstanceUsageStatusType getStatus() {
		return status;
	}

	public void setStatus(final NsInstanceUsageStatusType status) {
		this.status = status;
	}

	public NsInstanceUsageNotification _links(final NotificationLink _links) {
		this._links = _links;
		return this;
	}

	/**
	 * Get _links
	 *
	 * @return _links
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public NotificationLink getLinks() {
		return _links;
	}

	public void setLinks(final NotificationLink _links) {
		this._links = _links;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final NsInstanceUsageNotification nsInstanceUsageNotification = (NsInstanceUsageNotification) o;
		return Objects.equals(this.id, nsInstanceUsageNotification.id) &&
				Objects.equals(this.notificationType, nsInstanceUsageNotification.notificationType) &&
				Objects.equals(this.subscriptionId, nsInstanceUsageNotification.subscriptionId) &&
				Objects.equals(this.timeStamp, nsInstanceUsageNotification.timeStamp) &&
				Objects.equals(this.nsInstanceId, nsInstanceUsageNotification.nsInstanceId) &&
				Objects.equals(this.status, nsInstanceUsageNotification.status) &&
				Objects.equals(this._links, nsInstanceUsageNotification._links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, notificationType, subscriptionId, timeStamp, nsInstanceId, status, _links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class NsInstanceUsageNotification {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    notificationType: ").append(toIndentedString(notificationType)).append("\n");
		sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
		sb.append("    timeStamp: ").append(toIndentedString(timeStamp)).append("\n");
		sb.append("    nsInstanceId: ").append(toIndentedString(nsInstanceId)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    _links: ").append(toIndentedString(_links)).append("\n");
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
