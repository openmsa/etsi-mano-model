package com.ubiqube.etsi.mano.v451.model.nfvmanologm2;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type represents a subscription. It shall comply with the provisions
 * defined in table 8.6.2.3-1.
 */
@Schema(description = "This type represents a subscription. It shall comply with the provisions defined in table 8.6.2.3-1.")
@Validated

public class LogmSubscription {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("filter")
	private LogmNotificationsFilter filter = null;

	@JsonProperty("callbackUri")
	private String callbackUri = null;

	@JsonProperty("_links")
	private LogmSubscriptionLinks _links = null;

	public LogmSubscription id(final String id) {
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

	public LogmSubscription filter(final LogmNotificationsFilter filter) {
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
	public LogmNotificationsFilter getFilter() {
		return filter;
	}

	public void setFilter(final LogmNotificationsFilter filter) {
		this.filter = filter;
	}

	public LogmSubscription callbackUri(final String callbackUri) {
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

	public LogmSubscription _links(final LogmSubscriptionLinks _links) {
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
	public LogmSubscriptionLinks getLinks() {
		return _links;
	}

	public void setLinks(final LogmSubscriptionLinks _links) {
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
		final LogmSubscription logmSubscription = (LogmSubscription) o;
		return Objects.equals(this.id, logmSubscription.id) &&
				Objects.equals(this.filter, logmSubscription.filter) &&
				Objects.equals(this.callbackUri, logmSubscription.callbackUri) &&
				Objects.equals(this._links, logmSubscription._links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, filter, callbackUri, _links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class LogmSubscription {\n");

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
