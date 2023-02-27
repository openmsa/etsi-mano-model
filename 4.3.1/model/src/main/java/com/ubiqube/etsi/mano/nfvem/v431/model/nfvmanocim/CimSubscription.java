/**
 *     Copyright (C) 2019-2023 Ubiqube.
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
package com.ubiqube.etsi.mano.nfvem.v431.model.nfvmanocim;

import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * This type represents a subscription related to notifications about NFV-MANO
 * configuration and information management changes
 */
@Schema(description = "This type represents a subscription related to notifications about NFV-MANO configuration and information management changes ")
@Validated

public class CimSubscription {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("filter")
	private CimNotificationsFilter filter = null;

	@JsonProperty("callbackUri")
	private String callbackUri = null;

	@JsonProperty("_links")
	private CimSubscriptionLinks _links = null;

	public CimSubscription id(final String id) {
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

	public CimSubscription filter(final CimNotificationsFilter filter) {
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
	public CimNotificationsFilter getFilter() {
		return filter;
	}

	public void setFilter(final CimNotificationsFilter filter) {
		this.filter = filter;
	}

	public CimSubscription callbackUri(final String callbackUri) {
		this.callbackUri = callbackUri;
		return this;
	}

	/**
	 * String formatted according to IETF RFC 3986.
	 *
	 * @return callbackUri
	 **/
	@Schema(required = true, description = "String formatted according to IETF RFC 3986. ")
	@NotNull

	public String getCallbackUri() {
		return callbackUri;
	}

	public void setCallbackUri(final String callbackUri) {
		this.callbackUri = callbackUri;
	}

	public CimSubscription _links(final CimSubscriptionLinks _links) {
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
	public CimSubscriptionLinks getLinks() {
		return _links;
	}

	public void setLinks(final CimSubscriptionLinks _links) {
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
		final CimSubscription cimSubscription = (CimSubscription) o;
		return Objects.equals(this.id, cimSubscription.id) &&
				Objects.equals(this.filter, cimSubscription.filter) &&
				Objects.equals(this.callbackUri, cimSubscription.callbackUri) &&
				Objects.equals(this._links, cimSubscription._links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, filter, callbackUri, _links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class CimSubscription {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
		sb.append("    callbackUri: ").append(toIndentedString(callbackUri)).append("\n");
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
