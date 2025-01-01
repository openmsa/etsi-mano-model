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
package com.ubiqube.etsi.mano.v261.model.vnfm.vrqan;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.annotation.Nonnull;
import jakarta.validation.Valid;

/**
 * This type represents a subscription related to notifications related to the
 * availability of the virtualised resources quotas.
 */
@Schema(description = "This type represents a subscription related to notifications related to the availability of the virtualised resources quotas. ")
@Validated

public class VrQuotaAvailSubscription {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("filter")
	private VrQuotaAvailNotificationsFilter filter = null;

	@JsonProperty("callbackUri")
	private String callbackUri = null;

	@JsonProperty("_links")
	private VrQuotaAvailSubscriptionLinks links = null;

	public VrQuotaAvailSubscription id(final String id) {
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

	public VrQuotaAvailSubscription filter(final VrQuotaAvailNotificationsFilter filter) {
		this.filter = filter;
		return this;
	}

	/**
	 * Get filter
	 *
	 * @return filter
	 **/
	@Schema(description = "")

	@Valid
	public VrQuotaAvailNotificationsFilter getFilter() {
		return filter;
	}

	public void setFilter(final VrQuotaAvailNotificationsFilter filter) {
		this.filter = filter;
	}

	public VrQuotaAvailSubscription callbackUri(final String callbackUri) {
		this.callbackUri = callbackUri;
		return this;
	}

	/**
	 * Get callbackUri
	 *
	 * @return callbackUri
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@Nonnull

	public String getCallbackUri() {
		return callbackUri;
	}

	public void setCallbackUri(final String callbackUri) {
		this.callbackUri = callbackUri;
	}

	public VrQuotaAvailSubscription links(final VrQuotaAvailSubscriptionLinks _links) {
		this.links = _links;
		return this;
	}

	/**
	 * Get _links
	 *
	 * @return _links
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@Nonnull

	@Valid
	public VrQuotaAvailSubscriptionLinks getLinks() {
		return links;
	}

	public void setLinks(final VrQuotaAvailSubscriptionLinks _links) {
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
		final VrQuotaAvailSubscription vrQuotaAvailSubscription = (VrQuotaAvailSubscription) o;
		return Objects.equals(this.id, vrQuotaAvailSubscription.id) &&
				Objects.equals(this.filter, vrQuotaAvailSubscription.filter) &&
				Objects.equals(this.callbackUri, vrQuotaAvailSubscription.callbackUri) &&
				Objects.equals(this.links, vrQuotaAvailSubscription.links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, filter, callbackUri, links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class VrQuotaAvailSubscription {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
		sb.append("    callbackUri: ").append(toIndentedString(callbackUri)).append("\n");
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
