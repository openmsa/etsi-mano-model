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
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v451.model.nfvmanologm2.ManoManagedObjectReference;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type represents a Change state operation occurrence.
 */
@Schema(description = "This type represents a Change state operation occurrence. ")
@Validated

public class ChangeStateNotification {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("notificationType")
	private String notificationType = null;

	@JsonProperty("subscriptionId")
	private String subscriptionId = null;

	@JsonProperty("timestamp")
	private OffsetDateTime timestamp = null;

	@JsonProperty("changeStateOpOccId")
	private String changeStateOpOccId = null;

	@JsonProperty("stateChangedTime")
	private OffsetDateTime stateChangedTime = null;

	@JsonProperty("changeStateOperationState")
	private ChangeStateOpOccStateEnumType changeStateOperationState = null;

	@JsonProperty("managedObjectRef")
	private ManoManagedObjectReference managedObjectRef = null;

	@JsonProperty("operationalState")
	private OperationalStateEnumType operationalState = null;

	@JsonProperty("administrativeState")
	private AdministrativeStateEnumType administrativeState = null;

	@JsonProperty("_links")
	private ChangeStateNotificationLinks _links = null;

	public ChangeStateNotification id(final String id) {
		this.id = id;
		return this;
	}

	/**
	 * An identifier with the intention of being globally unique.
	 *
	 * @return id
	 **/
	@Schema(required = true, description = "An identifier with the intention of being globally unique. ")
	@NotNull

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public ChangeStateNotification notificationType(final String notificationType) {
		this.notificationType = notificationType;
		return this;
	}

	/**
	 * Discriminator for the different notification types. Shall be set to
	 * \"ChangeStateNotification\" for this notification type.
	 *
	 * @return notificationType
	 **/
	@Schema(required = true, description = "Discriminator for the different notification types. Shall be set to \"ChangeStateNotification\" for this notification type. ")
	@NotNull

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(final String notificationType) {
		this.notificationType = notificationType;
	}

	public ChangeStateNotification subscriptionId(final String subscriptionId) {
		this.subscriptionId = subscriptionId;
		return this;
	}

	/**
	 * An identifier with the intention of being globally unique.
	 *
	 * @return subscriptionId
	 **/
	@Schema(required = true, description = "An identifier with the intention of being globally unique. ")
	@NotNull

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(final String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public ChangeStateNotification timestamp(final OffsetDateTime timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	/**
	 * Date-time stamp. Representation: String formatted according to IETF RFC 3339.
	 *
	 * @return timestamp
	 **/
	@Schema(required = true, description = "Date-time stamp. Representation: String formatted according to IETF RFC 3339. ")
	@NotNull

	@Valid
	public OffsetDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(final OffsetDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public ChangeStateNotification changeStateOpOccId(final String changeStateOpOccId) {
		this.changeStateOpOccId = changeStateOpOccId;
		return this;
	}

	/**
	 * An identifier with the intention of being globally unique.
	 *
	 * @return changeStateOpOccId
	 **/
	@Schema(required = true, description = "An identifier with the intention of being globally unique. ")
	@NotNull

	public String getChangeStateOpOccId() {
		return changeStateOpOccId;
	}

	public void setChangeStateOpOccId(final String changeStateOpOccId) {
		this.changeStateOpOccId = changeStateOpOccId;
	}

	public ChangeStateNotification stateChangedTime(final OffsetDateTime stateChangedTime) {
		this.stateChangedTime = stateChangedTime;
		return this;
	}

	/**
	 * Date-time stamp. Representation: String formatted according to IETF RFC 3339.
	 *
	 * @return stateChangedTime
	 **/
	@Schema(required = true, description = "Date-time stamp. Representation: String formatted according to IETF RFC 3339. ")
	@NotNull

	@Valid
	public OffsetDateTime getStateChangedTime() {
		return stateChangedTime;
	}

	public void setStateChangedTime(final OffsetDateTime stateChangedTime) {
		this.stateChangedTime = stateChangedTime;
	}

	public ChangeStateNotification changeStateOperationState(final ChangeStateOpOccStateEnumType changeStateOperationState) {
		this.changeStateOperationState = changeStateOperationState;
		return this;
	}

	/**
	 * Get changeStateOperationState
	 *
	 * @return changeStateOperationState
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public ChangeStateOpOccStateEnumType getChangeStateOperationState() {
		return changeStateOperationState;
	}

	public void setChangeStateOperationState(final ChangeStateOpOccStateEnumType changeStateOperationState) {
		this.changeStateOperationState = changeStateOperationState;
	}

	public ChangeStateNotification managedObjectRef(final ManoManagedObjectReference managedObjectRef) {
		this.managedObjectRef = managedObjectRef;
		return this;
	}

	/**
	 * Get managedObjectRef
	 *
	 * @return managedObjectRef
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public ManoManagedObjectReference getManagedObjectRef() {
		return managedObjectRef;
	}

	public void setManagedObjectRef(final ManoManagedObjectReference managedObjectRef) {
		this.managedObjectRef = managedObjectRef;
	}

	public ChangeStateNotification operationalState(final OperationalStateEnumType operationalState) {
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
	public OperationalStateEnumType getOperationalState() {
		return operationalState;
	}

	public void setOperationalState(final OperationalStateEnumType operationalState) {
		this.operationalState = operationalState;
	}

	public ChangeStateNotification administrativeState(final AdministrativeStateEnumType administrativeState) {
		this.administrativeState = administrativeState;
		return this;
	}

	/**
	 * Get administrativeState
	 *
	 * @return administrativeState
	 **/
	@Schema(description = "")

	@Valid
	public AdministrativeStateEnumType getAdministrativeState() {
		return administrativeState;
	}

	public void setAdministrativeState(final AdministrativeStateEnumType administrativeState) {
		this.administrativeState = administrativeState;
	}

	public ChangeStateNotification _links(final ChangeStateNotificationLinks _links) {
		this._links = _links;
		return this;
	}

	/**
	 * Get _links
	 *
	 * @return _links
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public ChangeStateNotificationLinks getLinks() {
		return _links;
	}

	public void setLinks(final ChangeStateNotificationLinks _links) {
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
		final ChangeStateNotification changeStateNotification = (ChangeStateNotification) o;
		return Objects.equals(this.id, changeStateNotification.id) &&
				Objects.equals(this.notificationType, changeStateNotification.notificationType) &&
				Objects.equals(this.subscriptionId, changeStateNotification.subscriptionId) &&
				Objects.equals(this.timestamp, changeStateNotification.timestamp) &&
				Objects.equals(this.changeStateOpOccId, changeStateNotification.changeStateOpOccId) &&
				Objects.equals(this.stateChangedTime, changeStateNotification.stateChangedTime) &&
				Objects.equals(this.changeStateOperationState, changeStateNotification.changeStateOperationState) &&
				Objects.equals(this.managedObjectRef, changeStateNotification.managedObjectRef) &&
				Objects.equals(this.operationalState, changeStateNotification.operationalState) &&
				Objects.equals(this.administrativeState, changeStateNotification.administrativeState) &&
				Objects.equals(this._links, changeStateNotification._links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, notificationType, subscriptionId, timestamp, changeStateOpOccId, stateChangedTime, changeStateOperationState, managedObjectRef, operationalState, administrativeState, _links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class ChangeStateNotification {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    notificationType: ").append(toIndentedString(notificationType)).append("\n");
		sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
		sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
		sb.append("    changeStateOpOccId: ").append(toIndentedString(changeStateOpOccId)).append("\n");
		sb.append("    stateChangedTime: ").append(toIndentedString(stateChangedTime)).append("\n");
		sb.append("    changeStateOperationState: ").append(toIndentedString(changeStateOperationState)).append("\n");
		sb.append("    managedObjectRef: ").append(toIndentedString(managedObjectRef)).append("\n");
		sb.append("    operationalState: ").append(toIndentedString(operationalState)).append("\n");
		sb.append("    administrativeState: ").append(toIndentedString(administrativeState)).append("\n");
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
