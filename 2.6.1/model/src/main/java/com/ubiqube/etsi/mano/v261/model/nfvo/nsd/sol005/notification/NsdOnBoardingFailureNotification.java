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
package com.ubiqube.etsi.mano.v261.model.nfvo.nsd.sol005.notification;

import java.time.OffsetDateTime;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.annotation.Nonnull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.model.ProblemDetails;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;


/**
 * This type represents an NSD management notification, which informs the
 * receiver of the failure of on-boarding an NSD. It shall comply with the
 * provisions defined in Table 5.5.2.10-1. The support of this notification is
 * mandatory. The notification shall be triggered by the NFVO when the
 * on-boarding of an NSD has failed.
 */
@Schema(description = "This type represents an NSD management notification, which informs the receiver of the failure of on-boarding an NSD. It shall comply with the provisions defined in Table 5.5.2.10-1. The support of this notification is mandatory. The notification shall be triggered by the NFVO when the on-boarding of an NSD has failed. ")
@Validated


public class NsdOnBoardingFailureNotification {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("notificationType")
	private String notificationType = null;

	@JsonProperty("subscriptionId")
	private String subscriptionId = null;

	@JsonProperty("timeStamp")
	private OffsetDateTime timeStamp = null;

	@JsonProperty("nsdInfoId")
	private String nsdInfoId = null;

	@JsonProperty("nsdId")
	private String nsdId = null;

	@JsonProperty("onboardingFailureDetails")
	private ProblemDetails onboardingFailureDetails = null;

	@JsonProperty("_links")
	private NsdmLinks links = null;

	public NsdOnBoardingFailureNotification id(final String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 *
	 * @return id
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@Nonnull

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public NsdOnBoardingFailureNotification notificationType(final String notificationType) {
		this.notificationType = notificationType;
		return this;
	}

	/**
	 * Discriminator for the different notification types. Shall be set to
	 * \"NsdOnboardingFailureNotification\" for this notification type.
	 *
	 * @return notificationType
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Discriminator for the different notification types. Shall be set to \"NsdOnboardingFailureNotification\" for this notification type. ")
	@Nonnull

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(final String notificationType) {
		this.notificationType = notificationType;
	}

	public NsdOnBoardingFailureNotification subscriptionId(final String subscriptionId) {
		this.subscriptionId = subscriptionId;
		return this;
	}

	/**
	 * Get subscriptionId
	 *
	 * @return subscriptionId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@Nonnull

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(final String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public NsdOnBoardingFailureNotification timeStamp(final OffsetDateTime timeStamp) {
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

	@Valid

	public OffsetDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(final OffsetDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public NsdOnBoardingFailureNotification nsdInfoId(final String nsdInfoId) {
		this.nsdInfoId = nsdInfoId;
		return this;
	}

	/**
	 * Get nsdInfoId
	 *
	 * @return nsdInfoId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@Nonnull

	public String getNsdInfoId() {
		return nsdInfoId;
	}

	public void setNsdInfoId(final String nsdInfoId) {
		this.nsdInfoId = nsdInfoId;
	}

	public NsdOnBoardingFailureNotification nsdId(final String nsdId) {
		this.nsdId = nsdId;
		return this;
	}

	/**
	 * Get nsdId
	 *
	 * @return nsdId
	 **/
	@Schema(description = "")

	public String getNsdId() {
		return nsdId;
	}

	public void setNsdId(final String nsdId) {
		this.nsdId = nsdId;
	}

	public NsdOnBoardingFailureNotification onboardingFailureDetails(final ProblemDetails onboardingFailureDetails) {
		this.onboardingFailureDetails = onboardingFailureDetails;
		return this;
	}

	/**
	 * Failure details of current onboarding procedure. See clause 6.3 of ETSI GS
	 * NFV-SOL 013 for the details of \"ProblemDetails\" structure.
	 *
	 * @return onboardingFailureDetails
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Failure details of current onboarding procedure. See clause 6.3 of ETSI GS NFV-SOL 013 for the details of \"ProblemDetails\" structure. ")
	@Nonnull

	@Valid

	public ProblemDetails getOnboardingFailureDetails() {
		return onboardingFailureDetails;
	}

	public void setOnboardingFailureDetails(final ProblemDetails onboardingFailureDetails) {
		this.onboardingFailureDetails = onboardingFailureDetails;
	}

	public NsdOnBoardingFailureNotification links(final NsdmLinks links) {
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

	public NsdmLinks getLinks() {
		return links;
	}

	public void setLinks(final NsdmLinks links) {
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
		final NsdOnBoardingFailureNotification nsdOnBoardingFailureNotification = (NsdOnBoardingFailureNotification) o;
		return Objects.equals(this.id, nsdOnBoardingFailureNotification.id) &&
				Objects.equals(this.notificationType, nsdOnBoardingFailureNotification.notificationType) &&
				Objects.equals(this.subscriptionId, nsdOnBoardingFailureNotification.subscriptionId) &&
				Objects.equals(this.timeStamp, nsdOnBoardingFailureNotification.timeStamp) &&
				Objects.equals(this.nsdInfoId, nsdOnBoardingFailureNotification.nsdInfoId) &&
				Objects.equals(this.nsdId, nsdOnBoardingFailureNotification.nsdId) &&
				Objects.equals(this.onboardingFailureDetails, nsdOnBoardingFailureNotification.onboardingFailureDetails) &&
				Objects.equals(this.links, nsdOnBoardingFailureNotification.links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, notificationType, subscriptionId, timeStamp, nsdInfoId, nsdId, onboardingFailureDetails, links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class NsdOnBoardingFailureNotification {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    notificationType: ").append(toIndentedString(notificationType)).append("\n");
		sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
		sb.append("    timeStamp: ").append(toIndentedString(timeStamp)).append("\n");
		sb.append("    nsdInfoId: ").append(toIndentedString(nsdInfoId)).append("\n");
		sb.append("    nsdId: ").append(toIndentedString(nsdId)).append("\n");
		sb.append("    onboardingFailureDetails: ").append(toIndentedString(onboardingFailureDetails)).append("\n");
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
