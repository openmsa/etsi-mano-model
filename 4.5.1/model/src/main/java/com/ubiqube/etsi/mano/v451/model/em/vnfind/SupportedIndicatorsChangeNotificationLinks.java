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
package com.ubiqube.etsi.mano.v451.model.em.vnfind;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.NotificationLink;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Links for this resource.
 */
@Schema(description = "Links for this resource. ")
@Validated

public class SupportedIndicatorsChangeNotificationLinks {
	@JsonProperty("vnfInstance")
	private NotificationLink vnfInstance = null;

	@JsonProperty("subscription")
	private NotificationLink subscription = null;

	public SupportedIndicatorsChangeNotificationLinks vnfInstance(final NotificationLink vnfInstance) {
		this.vnfInstance = vnfInstance;
		return this;
	}

	/**
	 * Get vnfInstance
	 *
	 * @return vnfInstance
	 **/
	@Schema(description = "")

	@Valid
	public NotificationLink getVnfInstance() {
		return vnfInstance;
	}

	public void setVnfInstance(final NotificationLink vnfInstance) {
		this.vnfInstance = vnfInstance;
	}

	public SupportedIndicatorsChangeNotificationLinks subscription(final NotificationLink subscription) {
		this.subscription = subscription;
		return this;
	}

	/**
	 * Get subscription
	 *
	 * @return subscription
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public NotificationLink getSubscription() {
		return subscription;
	}

	public void setSubscription(final NotificationLink subscription) {
		this.subscription = subscription;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final SupportedIndicatorsChangeNotificationLinks supportedIndicatorsChangeNotificationLinks = (SupportedIndicatorsChangeNotificationLinks) o;
		return Objects.equals(this.vnfInstance, supportedIndicatorsChangeNotificationLinks.vnfInstance) &&
				Objects.equals(this.subscription, supportedIndicatorsChangeNotificationLinks.subscription);
	}

	@Override
	public int hashCode() {
		return Objects.hash(vnfInstance, subscription);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class SupportedIndicatorsChangeNotificationLinks {\n");

		sb.append("    vnfInstance: ").append(toIndentedString(vnfInstance)).append("\n");
		sb.append("    subscription: ").append(toIndentedString(subscription)).append("\n");
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
