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
package com.ubiqube.etsi.mano.em.v451.model.vnflcm;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type represents a subscription related to notifications about VNF
 * lifecycle changes.
 */
@Schema(description = "This type represents a subscription related to notifications about VNF lifecycle changes. ")
@Validated

public class LccnSubscription {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("filter")
	private LifecycleChangeNotificationsFilter filter = null;

	@JsonProperty("callbackUri")
	private String callbackUri = null;
	@JsonProperty("authentication")
	private SubscriptionAuthentication authentication = null;
	@JsonProperty("verbosity")
	private LcmOpOccNotificationVerbosityType verbosity = null;

	@JsonProperty("_links")
	private LccnSubscriptionLinks links = null;

	public LccnSubscription id(final String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 *
	 * @return id
	 **/
	@Schema(required = true, description = "")
	@NotNull

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public LccnSubscription filter(final LifecycleChangeNotificationsFilter filter) {
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
	public LifecycleChangeNotificationsFilter getFilter() {
		return filter;
	}

	public void setFilter(final LifecycleChangeNotificationsFilter filter) {
		this.filter = filter;
	}

	public LccnSubscription callbackUri(final String callbackUri) {
		this.callbackUri = callbackUri;
		return this;
	}

	/**
	 * Get callbackUri
	 *
	 * @return callbackUri
	 **/
	@Schema(required = true, description = "")
	@NotNull

	public String getCallbackUri() {
		return callbackUri;
	}

	public void setCallbackUri(final String callbackUri) {
		this.callbackUri = callbackUri;
	}

	public LccnSubscription authentication(final SubscriptionAuthentication authentication) {
		this.authentication = authentication;
		return this;
	}

	/**
	 * Get authentication
	 *
	 * @return authentication
	 **/
	@Schema(description = "")

	@Valid
	public SubscriptionAuthentication getAuthentication() {
		return authentication;
	}

	public void setAuthentication(final SubscriptionAuthentication authentication) {
		this.authentication = authentication;
	}

	public LccnSubscription verbosity(final LcmOpOccNotificationVerbosityType verbosity) {
		this.verbosity = verbosity;
		return this;
	}

	/**
	 * Get verbosity
	 *
	 * @return verbosity
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public LcmOpOccNotificationVerbosityType getVerbosity() {
		return verbosity;
	}

	public void setVerbosity(final LcmOpOccNotificationVerbosityType verbosity) {
		this.verbosity = verbosity;
	}

	public LccnSubscription links(final LccnSubscriptionLinks _links) {
		this.links = _links;
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
	public LccnSubscriptionLinks getLinks() {
		return links;
	}

	public void setLinks(final LccnSubscriptionLinks _links) {
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
		final LccnSubscription lccnSubscription = (LccnSubscription) o;
		return Objects.equals(this.id, lccnSubscription.id) &&
				Objects.equals(this.filter, lccnSubscription.filter) &&
				Objects.equals(this.callbackUri, lccnSubscription.callbackUri) &&
				Objects.equals(this.verbosity, lccnSubscription.verbosity) &&
				Objects.equals(this.links, lccnSubscription.links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, filter, callbackUri, verbosity, links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class LccnSubscription {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
		sb.append("    callbackUri: ").append(toIndentedString(callbackUri)).append("\n");
		sb.append("    verbosity: ").append(toIndentedString(verbosity)).append("\n");
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
