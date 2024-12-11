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
package com.ubiqube.etsi.mano.v351.model.nfvo.vnf;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

/**
 * This type represents a VNF package management notification, which informs the
 * receiver that the on boarding process of a VNF package incomplete and the
 * package is ready for use. A change of the on-boarding state before the VNF
 * package is on-boarded is not reported. It shall comply with the provisions
 * defined in Table 9.5.2.8-1. The support of this notification is mandatory.
 * The notification shall be triggered by the NFVO when the value of the
 * \&quot;onboardingState\&quot; attribute of a new VNF package has changed to
 * \&quot;ONBOARDED\&quot;.
 */
@Schema(description = "This type represents a VNF package management notification, which informs the receiver that the on boarding process of a VNF package incomplete and the package is ready for use. A change of the on-boarding state before the VNF package is on-boarded is not reported. It shall comply with the provisions defined in Table 9.5.2.8-1. The support of this notification is mandatory. The notification shall be triggered by the NFVO when the value of the \"onboardingState\" attribute of a new VNF package has changed to \"ONBOARDED\". ")
@Validated

public class VnfPackageOnboardingNotification {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("notificationType")
	private String notificationType = null;

	@JsonProperty("subscriptionId")
	private String subscriptionId = null;

	@JsonProperty("timeStamp")
	private OffsetDateTime timeStamp = null;

	@JsonProperty("vnfPkgId")
	private String vnfPkgId = null;

	@JsonProperty("vnfdId")
	private String vnfdId = null;

	@JsonProperty("vnfmInfo")
	@Valid
	private List<String> vnfmInfo = new ArrayList<>();

	@JsonProperty("_links")
	private PkgmLinks _links = null;

	public VnfPackageOnboardingNotification id(final String id) {
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

	public VnfPackageOnboardingNotification notificationType(final String notificationType) {
		this.notificationType = notificationType;
		return this;
	}

	/**
	 * Discriminator for the different notification types. Shall be set to
	 * \"VnfPackageOnboardingNotification\" for this notification type.
	 *
	 * @return notificationType
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Discriminator for the different notification types. Shall be set to \"VnfPackageOnboardingNotification\" for this notification type. ")
	@NotNull

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(final String notificationType) {
		this.notificationType = notificationType;
	}

	public VnfPackageOnboardingNotification subscriptionId(final String subscriptionId) {
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

	public VnfPackageOnboardingNotification timeStamp(final OffsetDateTime timeStamp) {
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

	public VnfPackageOnboardingNotification vnfPkgId(final String vnfPkgId) {
		this.vnfPkgId = vnfPkgId;
		return this;
	}

	/**
	 * Get vnfPkgId
	 *
	 * @return vnfPkgId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getVnfPkgId() {
		return vnfPkgId;
	}

	public void setVnfPkgId(final String vnfPkgId) {
		this.vnfPkgId = vnfPkgId;
	}

	public VnfPackageOnboardingNotification vnfdId(final String vnfdId) {
		this.vnfdId = vnfdId;
		return this;
	}

	/**
	 * Get vnfdId
	 *
	 * @return vnfdId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getVnfdId() {
		return vnfdId;
	}

	public void setVnfdId(final String vnfdId) {
		this.vnfdId = vnfdId;
	}

	public VnfPackageOnboardingNotification vnfmInfo(final List<String> vnfmInfo) {
		this.vnfmInfo = vnfmInfo;
		return this;
	}

	public VnfPackageOnboardingNotification addVnfmInfoItem(final String vnfmInfoItem) {
		this.vnfmInfo.add(vnfmInfoItem);
		return this;
	}

	/**
	 * Specifies VNFMs compatible with the VNF. This information is copied from the
	 * VNFD. See Table 9.5.2.5-1.
	 *
	 * @return vnfmInfo
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Specifies VNFMs compatible with the VNF. This information is copied from the VNFD. See Table 9.5.2.5-1. ")
	@NotNull

	public List<String> getVnfmInfo() {
		return vnfmInfo;
	}

	public void setVnfmInfo(final List<String> vnfmInfo) {
		this.vnfmInfo = vnfmInfo;
	}

	public VnfPackageOnboardingNotification _links(final PkgmLinks _links) {
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
	public PkgmLinks getLinks() {
		return _links;
	}

	public void setLinks(final PkgmLinks _links) {
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
		final VnfPackageOnboardingNotification vnfPackageOnboardingNotification = (VnfPackageOnboardingNotification) o;
		return Objects.equals(this.id, vnfPackageOnboardingNotification.id) &&
				Objects.equals(this.notificationType, vnfPackageOnboardingNotification.notificationType) &&
				Objects.equals(this.subscriptionId, vnfPackageOnboardingNotification.subscriptionId) &&
				Objects.equals(this.timeStamp, vnfPackageOnboardingNotification.timeStamp) &&
				Objects.equals(this.vnfPkgId, vnfPackageOnboardingNotification.vnfPkgId) &&
				Objects.equals(this.vnfdId, vnfPackageOnboardingNotification.vnfdId) &&
				Objects.equals(this.vnfmInfo, vnfPackageOnboardingNotification.vnfmInfo) &&
				Objects.equals(this._links, vnfPackageOnboardingNotification._links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, notificationType, subscriptionId, timeStamp, vnfPkgId, vnfdId, vnfmInfo, _links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class VnfPackageOnboardingNotification {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    notificationType: ").append(toIndentedString(notificationType)).append("\n");
		sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
		sb.append("    timeStamp: ").append(toIndentedString(timeStamp)).append("\n");
		sb.append("    vnfPkgId: ").append(toIndentedString(vnfPkgId)).append("\n");
		sb.append("    vnfdId: ").append(toIndentedString(vnfdId)).append("\n");
		sb.append("    vnfmInfo: ").append(toIndentedString(vnfmInfo)).append("\n");
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
