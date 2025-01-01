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
package com.ubiqube.etsi.mano.v271.model.vnfm.vrqan;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v271.model.vnfm.vnflcm.VimConnectionInfo;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class VrQuotaAvailNotification {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("notificationType")
	private String notificationType = null;

	@JsonProperty("subscriptionId")
	private String subscriptionId = null;

	@JsonProperty("timeStamp")
	private OffsetDateTime timeStamp = null;

	@JsonProperty("resourceGroupId")
	private String resourceGroupId = null;

	@JsonProperty("vimConnectionInfo")
	private VimConnectionInfo vimConnectionInfo = null;

	@JsonProperty("resourceProviderId")
	private String resourceProviderId = null;

	@JsonProperty("_links")
	private QuotaAvailLinks links = null;

	public VrQuotaAvailNotification id(final String id) {
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

	public VrQuotaAvailNotification notificationType(final String notificationType) {
		this.notificationType = notificationType;
		return this;
	}

	/**
	 * Get notificationType
	 *
	 * @return notificationType
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(final String notificationType) {
		this.notificationType = notificationType;
	}

	public VrQuotaAvailNotification subscriptionId(final String subscriptionId) {
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

	public VrQuotaAvailNotification timeStamp(final OffsetDateTime timeStamp) {
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

	public VrQuotaAvailNotification resourceGroupId(final String resourceGroupId) {
		this.resourceGroupId = resourceGroupId;
		return this;
	}

	/**
	 * Get resourceGroupId
	 *
	 * @return resourceGroupId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getResourceGroupId() {
		return resourceGroupId;
	}

	public void setResourceGroupId(final String resourceGroupId) {
		this.resourceGroupId = resourceGroupId;
	}

	public VrQuotaAvailNotification vimConnectionInfo(final VimConnectionInfo vimConnectionInfo) {
		this.vimConnectionInfo = vimConnectionInfo;
		return this;
	}

	/**
	 * Get vimConnectionInfo
	 *
	 * @return vimConnectionInfo
	 **/
	@Schema(description = "")

	@Valid
	public VimConnectionInfo getVimConnectionInfo() {
		return vimConnectionInfo;
	}

	public void setVimConnectionInfo(final VimConnectionInfo vimConnectionInfo) {
		this.vimConnectionInfo = vimConnectionInfo;
	}

	public VrQuotaAvailNotification resourceProviderId(final String resourceProviderId) {
		this.resourceProviderId = resourceProviderId;
		return this;
	}

	/**
	 * Get resourceProviderId
	 *
	 * @return resourceProviderId
	 **/
	@Schema(description = "")

	public String getResourceProviderId() {
		return resourceProviderId;
	}

	public void setResourceProviderId(final String resourceProviderId) {
		this.resourceProviderId = resourceProviderId;
	}

	public VrQuotaAvailNotification links(final QuotaAvailLinks _links) {
		this.links = _links;
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
	public QuotaAvailLinks getLinks() {
		return links;
	}

	public void setLinks(final QuotaAvailLinks _links) {
		this.links = _links;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final VrQuotaAvailNotification vrQuotaAvailNotification = (VrQuotaAvailNotification) o;
		return Objects.equals(this.id, vrQuotaAvailNotification.id) &&
				Objects.equals(this.notificationType, vrQuotaAvailNotification.notificationType) &&
				Objects.equals(this.subscriptionId, vrQuotaAvailNotification.subscriptionId) &&
				Objects.equals(this.timeStamp, vrQuotaAvailNotification.timeStamp) &&
				Objects.equals(this.resourceGroupId, vrQuotaAvailNotification.resourceGroupId) &&
				Objects.equals(this.vimConnectionInfo, vrQuotaAvailNotification.vimConnectionInfo) &&
				Objects.equals(this.resourceProviderId, vrQuotaAvailNotification.resourceProviderId) &&
				Objects.equals(this.links, vrQuotaAvailNotification.links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, notificationType, subscriptionId, timeStamp, resourceGroupId, vimConnectionInfo, resourceProviderId, links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class VrQuotaAvailNotification {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    notificationType: ").append(toIndentedString(notificationType)).append("\n");
		sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
		sb.append("    timeStamp: ").append(toIndentedString(timeStamp)).append("\n");
		sb.append("    resourceGroupId: ").append(toIndentedString(resourceGroupId)).append("\n");
		sb.append("    vimConnectionInfo: ").append(toIndentedString(vimConnectionInfo)).append("\n");
		sb.append("    resourceProviderId: ").append(toIndentedString(resourceProviderId)).append("\n");
		sb.append("    _links: ").append(toIndentedString(links)).append("\n");
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
