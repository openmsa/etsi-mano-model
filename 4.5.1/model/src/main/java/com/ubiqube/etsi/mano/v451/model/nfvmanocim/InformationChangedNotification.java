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
 *     along with this program.  If not, see https://www.gnu.org/licenses/.
 */
package com.ubiqube.etsi.mano.v451.model.nfvmanocim;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type represents a notification that is sent when data about
 * configuration and information of the NFV-MANO functional entity have been
 * changed.
 */
@Schema(description = "This type represents a notification that is sent when data about configuration and information of the NFV-MANO functional entity have been changed. ")
@Validated

public class InformationChangedNotification {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("notificationType")
	private String notificationType = null;

	@JsonProperty("subscriptionId")
	private String subscriptionId = null;

	@JsonProperty("timeStamp")
	private OffsetDateTime timeStamp = null;

	@JsonProperty("informationChangedTime")
	private OffsetDateTime informationChangedTime = null;

	@JsonProperty("manoEntityId")
	private String manoEntityId = null;

	@JsonProperty("changedInfo")
	private Map<String, String> changedInfo = null;

	@JsonProperty("_links")
	private InformationChangedNotificationLinks _links = null;

	public InformationChangedNotification id(final String id) {
		this.id = id;
		return this;
	}

	/**
	 * An identifier with the intention of being globally unique.
	 *
	 * @return id
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "An identifier with the intention of being globally unique. ")
	@NotNull

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public InformationChangedNotification notificationType(final String notificationType) {
		this.notificationType = notificationType;
		return this;
	}

	/**
	 * Discriminator for the different notification types. Shall be set to
	 * \"InformationChangedNotification\" for this notification type.
	 *
	 * @return notificationType
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Discriminator for the different notification types. Shall be set to \"InformationChangedNotification\" for this notification type. ")
	@NotNull

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(final String notificationType) {
		this.notificationType = notificationType;
	}

	public InformationChangedNotification subscriptionId(final String subscriptionId) {
		this.subscriptionId = subscriptionId;
		return this;
	}

	/**
	 * An identifier with the intention of being globally unique.
	 *
	 * @return subscriptionId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "An identifier with the intention of being globally unique. ")
	@NotNull

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(final String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public InformationChangedNotification timeStamp(final OffsetDateTime timeStamp) {
		this.timeStamp = timeStamp;
		return this;
	}

	/**
	 * Date-time stamp. Representation: String formatted according to IETF RFC 3339.
	 *
	 * @return timeStamp
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Date-time stamp. Representation: String formatted according to IETF RFC 3339. ")
	@NotNull

	@Valid
	public OffsetDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(final OffsetDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public InformationChangedNotification informationChangedTime(final OffsetDateTime informationChangedTime) {
		this.informationChangedTime = informationChangedTime;
		return this;
	}

	/**
	 * Date-time stamp. Representation: String formatted according to IETF RFC 3339.
	 *
	 * @return informationChangedTime
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Date-time stamp. Representation: String formatted according to IETF RFC 3339. ")
	@NotNull

	@Valid
	public OffsetDateTime getInformationChangedTime() {
		return informationChangedTime;
	}

	public void setInformationChangedTime(final OffsetDateTime informationChangedTime) {
		this.informationChangedTime = informationChangedTime;
	}

	public InformationChangedNotification manoEntityId(final String manoEntityId) {
		this.manoEntityId = manoEntityId;
		return this;
	}

	/**
	 * An identifier with the intention of being globally unique.
	 *
	 * @return manoEntityId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "An identifier with the intention of being globally unique. ")
	@NotNull

	public String getManoEntityId() {
		return manoEntityId;
	}

	public void setManoEntityId(final String manoEntityId) {
		this.manoEntityId = manoEntityId;
	}

	public InformationChangedNotification changedInfo(final Map<String, String> changedInfo) {
		this.changedInfo = changedInfo;
		return this;
	}

	/**
	 * Get changedInfo
	 *
	 * @return changedInfo
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public Map<String, String> getChangedInfo() {
		return changedInfo;
	}

	public void setChangedInfo(final Map<String, String> changedInfo) {
		this.changedInfo = changedInfo;
	}

	public InformationChangedNotification _links(final InformationChangedNotificationLinks _links) {
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
	public InformationChangedNotificationLinks getLinks() {
		return _links;
	}

	public void setLinks(final InformationChangedNotificationLinks _links) {
		this._links = _links;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final InformationChangedNotification informationChangedNotification = (InformationChangedNotification) o;
		return Objects.equals(this.id, informationChangedNotification.id) &&
				Objects.equals(this.notificationType, informationChangedNotification.notificationType) &&
				Objects.equals(this.subscriptionId, informationChangedNotification.subscriptionId) &&
				Objects.equals(this.timeStamp, informationChangedNotification.timeStamp) &&
				Objects.equals(this.informationChangedTime, informationChangedNotification.informationChangedTime) &&
				Objects.equals(this.manoEntityId, informationChangedNotification.manoEntityId) &&
				Objects.equals(this.changedInfo, informationChangedNotification.changedInfo) &&
				Objects.equals(this._links, informationChangedNotification._links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, notificationType, subscriptionId, timeStamp, informationChangedTime, manoEntityId, changedInfo, _links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class InformationChangedNotification {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    notificationType: ").append(toIndentedString(notificationType)).append("\n");
		sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
		sb.append("    timeStamp: ").append(toIndentedString(timeStamp)).append("\n");
		sb.append("    informationChangedTime: ").append(toIndentedString(informationChangedTime)).append("\n");
		sb.append("    manoEntityId: ").append(toIndentedString(manoEntityId)).append("\n");
		sb.append("    changedInfo: ").append(toIndentedString(changedInfo)).append("\n");
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
