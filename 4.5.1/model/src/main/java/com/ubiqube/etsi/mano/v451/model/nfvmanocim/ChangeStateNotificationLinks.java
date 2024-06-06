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

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.NotificationLink;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Links to resources related to this notification.
 */
@Schema(description = "Links to resources related to this notification. ")
@Validated

public class ChangeStateNotificationLinks {
	@JsonProperty("subscription")
	private NotificationLink subscription = null;

	@JsonProperty("objectInstance")
	private NotificationLink objectInstance = null;

	@JsonProperty("changeStateOpOcc")
	private NotificationLink changeStateOpOcc = null;

	public ChangeStateNotificationLinks subscription(final NotificationLink subscription) {
		this.subscription = subscription;
		return this;
	}

	/**
	 * Get subscription
	 *
	 * @return subscription
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public NotificationLink getSubscription() {
		return subscription;
	}

	public void setSubscription(final NotificationLink subscription) {
		this.subscription = subscription;
	}

	public ChangeStateNotificationLinks objectInstance(final NotificationLink objectInstance) {
		this.objectInstance = objectInstance;
		return this;
	}

	/**
	 * Get objectInstance
	 *
	 * @return objectInstance
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public NotificationLink getObjectInstance() {
		return objectInstance;
	}

	public void setObjectInstance(final NotificationLink objectInstance) {
		this.objectInstance = objectInstance;
	}

	public ChangeStateNotificationLinks changeStateOpOcc(final NotificationLink changeStateOpOcc) {
		this.changeStateOpOcc = changeStateOpOcc;
		return this;
	}

	/**
	 * Get changeStateOpOcc
	 *
	 * @return changeStateOpOcc
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public NotificationLink getChangeStateOpOcc() {
		return changeStateOpOcc;
	}

	public void setChangeStateOpOcc(final NotificationLink changeStateOpOcc) {
		this.changeStateOpOcc = changeStateOpOcc;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final ChangeStateNotificationLinks changeStateNotificationLinks = (ChangeStateNotificationLinks) o;
		return Objects.equals(this.subscription, changeStateNotificationLinks.subscription) &&
				Objects.equals(this.objectInstance, changeStateNotificationLinks.objectInstance) &&
				Objects.equals(this.changeStateOpOcc, changeStateNotificationLinks.changeStateOpOcc);
	}

	@Override
	public int hashCode() {
		return Objects.hash(subscription, objectInstance, changeStateOpOcc);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class ChangeStateNotificationLinks {\n");

		sb.append("    subscription: ").append(toIndentedString(subscription)).append("\n");
		sb.append("    objectInstance: ").append(toIndentedString(objectInstance)).append("\n");
		sb.append("    changeStateOpOcc: ").append(toIndentedString(changeStateOpOcc)).append("\n");
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
