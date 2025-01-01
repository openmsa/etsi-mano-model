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
package com.ubiqube.etsi.mano.v451.model.nfvo.nslcm;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.Link;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Links to resources related to this notification.
 */
@Schema(description = "Links to resources related to this notification. ")
@Validated

public class NsLcmCapacityShortageNotificationLinks1 {
	@JsonProperty("preemptingNsLcmOpOcc")
	private Link preemptingNsLcmOpOcc = null;

	@JsonProperty("highPrioNsInstance")
	private Link highPrioNsInstance = null;

	@JsonProperty("subscription")
	private Link subscription = null;

	public NsLcmCapacityShortageNotificationLinks1 preemptingNsLcmOpOcc(final Link preemptingNsLcmOpOcc) {
		this.preemptingNsLcmOpOcc = preemptingNsLcmOpOcc;
		return this;
	}

	/**
	 * Get preemptingNsLcmOpOcc
	 *
	 * @return preemptingNsLcmOpOcc
	 **/
	@Schema(description = "")

	@Valid
	public Link getPreemptingNsLcmOpOcc() {
		return preemptingNsLcmOpOcc;
	}

	public void setPreemptingNsLcmOpOcc(final Link preemptingNsLcmOpOcc) {
		this.preemptingNsLcmOpOcc = preemptingNsLcmOpOcc;
	}

	public NsLcmCapacityShortageNotificationLinks1 highPrioNsInstance(final Link highPrioNsInstance) {
		this.highPrioNsInstance = highPrioNsInstance;
		return this;
	}

	/**
	 * Get highPrioNsInstance
	 *
	 * @return highPrioNsInstance
	 **/
	@Schema(description = "")

	@Valid
	public Link getHighPrioNsInstance() {
		return highPrioNsInstance;
	}

	public void setHighPrioNsInstance(final Link highPrioNsInstance) {
		this.highPrioNsInstance = highPrioNsInstance;
	}

	public NsLcmCapacityShortageNotificationLinks1 subscription(final Link subscription) {
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
	public Link getSubscription() {
		return subscription;
	}

	public void setSubscription(final Link subscription) {
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
		final NsLcmCapacityShortageNotificationLinks1 nsLcmCapacityShortageNotificationLinks1 = (NsLcmCapacityShortageNotificationLinks1) o;
		return Objects.equals(this.preemptingNsLcmOpOcc, nsLcmCapacityShortageNotificationLinks1.preemptingNsLcmOpOcc) &&
				Objects.equals(this.highPrioNsInstance, nsLcmCapacityShortageNotificationLinks1.highPrioNsInstance) &&
				Objects.equals(this.subscription, nsLcmCapacityShortageNotificationLinks1.subscription);
	}

	@Override
	public int hashCode() {
		return Objects.hash(preemptingNsLcmOpOcc, highPrioNsInstance, subscription);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class NsLcmCapacityShortageNotificationLinks1 {\n");

		sb.append("    preemptingNsLcmOpOcc: ").append(toIndentedString(preemptingNsLcmOpOcc)).append("\n");
		sb.append("    highPrioNsInstance: ").append(toIndentedString(highPrioNsInstance)).append("\n");
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
