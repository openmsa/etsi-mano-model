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
package com.ubiqube.etsi.mano.v261.model.vnfm.nsperfo;

import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.annotation.Nonnull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;


/**
 * This type represents a threshold.
 */
@Schema(description = "This type represents a threshold. ")
@Validated


public class Threshold {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("objectInstanceId")
	private String objectInstanceId = null;

	@JsonProperty("criteria")
	private ThresholdCriteria criteria = null;

	@JsonProperty("_links")
	private ThresholdLinks links = null;

	public Threshold id(final String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identifier of this threshold resource.
	 * 
	 * @return id
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifier of this threshold resource. ")
	@Nonnull

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public Threshold objectInstanceId(final String objectInstanceId) {
		this.objectInstanceId = objectInstanceId;
		return this;
	}

	/**
	 * Identifier of the VNF instance associated with the threshold.
	 * 
	 * @return objectInstanceId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifier of the VNF instance associated with the threshold. ")
	@Nonnull

	public String getObjectInstanceId() {
		return objectInstanceId;
	}

	public void setObjectInstanceId(final String objectInstanceId) {
		this.objectInstanceId = objectInstanceId;
	}

	public Threshold criteria(final ThresholdCriteria criteria) {
		this.criteria = criteria;
		return this;
	}

	/**
	 * Criteria that define this threshold.
	 * 
	 * @return criteria
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Criteria that define this threshold. ")
	@Nonnull

	@Valid

	public ThresholdCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(final ThresholdCriteria criteria) {
		this.criteria = criteria;
	}

	public Threshold links(final ThresholdLinks links) {
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

	public ThresholdLinks getLinks() {
		return links;
	}

	public void setLinks(final ThresholdLinks links) {
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
		final Threshold threshold = (Threshold) o;
		return Objects.equals(this.id, threshold.id) &&
				Objects.equals(this.objectInstanceId, threshold.objectInstanceId) &&
				Objects.equals(this.criteria, threshold.criteria) &&
				Objects.equals(this.links, threshold.links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, objectInstanceId, criteria, links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class Threshold {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    objectInstanceId: ").append(toIndentedString(objectInstanceId)).append("\n");
		sb.append("    criteria: ").append(toIndentedString(criteria)).append("\n");
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
