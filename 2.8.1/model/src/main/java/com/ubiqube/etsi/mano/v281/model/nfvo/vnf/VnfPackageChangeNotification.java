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
package com.ubiqube.etsi.mano.v281.model.nfvo.vnf;

import java.time.OffsetDateTime;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ubiqube.etsi.mano.v281.model.nfvo.vnfconfig.PkgmLinks;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type represents a VNF package management notification, which informs the
 * receiver of a change of the status in an on-boarded VNF package. Only changes
 * in the \&quot;operationalState\&quot; attribute of an on-boarded VNF package
 * and the deletion NF package will be reported. Changes in the
 * \&quot;usageState\&quot; and \&quot;onboardingState\&quot; attributes are not
 * reported. The notification shall be triggered by the NFVO when there is a
 * change in the status of an onboarded VNF package, as follows: * The
 * \&quot;operationalState\&quot; attribute of a VNF package has changed, and
 * the \&quot;onboardingState\&quot; attribute of the package has the value
 * \&quot;ONBOARDED\&quot; (i.e. the package has been onboarded previously). *
 * The on-boarded VNF package has been deleted, and the
 * \&quot;onboardingState\&quot; attribute of the deleted package had the value
 * \&quot;ONBOARDED\&quot;.
 */
@Schema(description = "This type represents a VNF package management notification, which informs the receiver of a change of the status in an on-boarded VNF package. Only changes in the \"operationalState\" attribute of an on-boarded VNF package and the deletion NF package will be reported. Changes in the \"usageState\" and \"onboardingState\" attributes are not reported. The notification shall be triggered by the NFVO when there is a change in the status of an onboarded VNF package, as follows: * The \"operationalState\" attribute of a VNF package has changed, and the   \"onboardingState\" attribute of the package has the value \"ONBOARDED\"   (i.e. the package has been onboarded previously). * The on-boarded VNF package has been deleted, and the \"onboardingState\"   attribute of the deleted package had the value \"ONBOARDED\". ")
@Validated

public class VnfPackageChangeNotification {
	@JsonProperty("id")
	private String id = null;

	/**
	 * Discriminator for the different notification types. Shall be set to
	 * \"VnfPackageChangeNotification\" for this notification type.
	 */
	public enum NotificationTypeEnum {
		VNFPACKAGECHANGENOTIFICATION("VnfPackageChangeNotification");

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
	private OffsetDateTime timeStamp = null;

	@JsonProperty("vnfPkgId")
	private String vnfPkgId = null;

	@JsonProperty("vnfdId")
	private String vnfdId = null;

	@JsonProperty("changeType")
	private PackageChangeType changeType = null;

	@JsonProperty("operationalState")
	private PackageOperationalStateType operationalState = null;

	@JsonProperty("_links")
	private PkgmLinks _links = null;

	public VnfPackageChangeNotification id(final String id) {
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

	public VnfPackageChangeNotification notificationType(final NotificationTypeEnum notificationType) {
		this.notificationType = notificationType;
		return this;
	}

	/**
	 * Discriminator for the different notification types. Shall be set to
	 * \"VnfPackageChangeNotification\" for this notification type.
	 *
	 * @return notificationType
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Discriminator for the different notification types. Shall be set to \"VnfPackageChangeNotification\" for this notification type. ")
	@NotNull

	public NotificationTypeEnum getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(final NotificationTypeEnum notificationType) {
		this.notificationType = notificationType;
	}

	public VnfPackageChangeNotification subscriptionId(final String subscriptionId) {
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

	public VnfPackageChangeNotification timeStamp(final OffsetDateTime timeStamp) {
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

	public VnfPackageChangeNotification vnfPkgId(final String vnfPkgId) {
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

	public VnfPackageChangeNotification vnfdId(final String vnfdId) {
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

	public VnfPackageChangeNotification changeType(final PackageChangeType changeType) {
		this.changeType = changeType;
		return this;
	}

	/**
	 * Get changeType
	 *
	 * @return changeType
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public PackageChangeType getChangeType() {
		return changeType;
	}

	public void setChangeType(final PackageChangeType changeType) {
		this.changeType = changeType;
	}

	public VnfPackageChangeNotification operationalState(final PackageOperationalStateType operationalState) {
		this.operationalState = operationalState;
		return this;
	}

	/**
	 * Get operationalState
	 *
	 * @return operationalState
	 **/
	@Schema(description = "")

	@Valid
	public PackageOperationalStateType getOperationalState() {
		return operationalState;
	}

	public void setOperationalState(final PackageOperationalStateType operationalState) {
		this.operationalState = operationalState;
	}

	public VnfPackageChangeNotification _links(final PkgmLinks _links) {
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
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final VnfPackageChangeNotification vnfPackageChangeNotification = (VnfPackageChangeNotification) o;
		return Objects.equals(this.id, vnfPackageChangeNotification.id) &&
				Objects.equals(this.notificationType, vnfPackageChangeNotification.notificationType) &&
				Objects.equals(this.subscriptionId, vnfPackageChangeNotification.subscriptionId) &&
				Objects.equals(this.timeStamp, vnfPackageChangeNotification.timeStamp) &&
				Objects.equals(this.vnfPkgId, vnfPackageChangeNotification.vnfPkgId) &&
				Objects.equals(this.vnfdId, vnfPackageChangeNotification.vnfdId) &&
				Objects.equals(this.changeType, vnfPackageChangeNotification.changeType) &&
				Objects.equals(this.operationalState, vnfPackageChangeNotification.operationalState) &&
				Objects.equals(this._links, vnfPackageChangeNotification._links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, notificationType, subscriptionId, timeStamp, vnfPkgId, vnfdId, changeType, operationalState, _links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class VnfPackageChangeNotification {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    notificationType: ").append(toIndentedString(notificationType)).append("\n");
		sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
		sb.append("    timeStamp: ").append(toIndentedString(timeStamp)).append("\n");
		sb.append("    vnfPkgId: ").append(toIndentedString(vnfPkgId)).append("\n");
		sb.append("    vnfdId: ").append(toIndentedString(vnfdId)).append("\n");
		sb.append("    changeType: ").append(toIndentedString(changeType)).append("\n");
		sb.append("    operationalState: ").append(toIndentedString(operationalState)).append("\n");
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
