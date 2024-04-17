package com.ubiqube.etsi.mano.v351.model.vnfm.vnfm;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v351.model.em.vnflcm.NotificationLink;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Links to resources related to this notification.
 */
@Schema(description = "Links to resources related to this notification. ")
@Validated

public class AlarmClearedNotificationLinks {
	@JsonProperty("subscription")
	private NotificationLink subscription = null;

	@JsonProperty("alarm")
	private NotificationLink alarm = null;

	public AlarmClearedNotificationLinks subscription(final NotificationLink subscription) {
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

	public AlarmClearedNotificationLinks alarm(final NotificationLink alarm) {
		this.alarm = alarm;
		return this;
	}

	/**
	 * Get alarm
	 *
	 * @return alarm
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public NotificationLink getAlarm() {
		return alarm;
	}

	public void setAlarm(final NotificationLink alarm) {
		this.alarm = alarm;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final AlarmClearedNotificationLinks alarmClearedNotificationLinks = (AlarmClearedNotificationLinks) o;
		return Objects.equals(this.subscription, alarmClearedNotificationLinks.subscription) &&
				Objects.equals(this.alarm, alarmClearedNotificationLinks.alarm);
	}

	@Override
	public int hashCode() {
		return Objects.hash(subscription, alarm);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class AlarmClearedNotificationLinks {\n");

		sb.append("    subscription: ").append(toIndentedString(subscription)).append("\n");
		sb.append("    alarm: ").append(toIndentedString(alarm)).append("\n");
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
