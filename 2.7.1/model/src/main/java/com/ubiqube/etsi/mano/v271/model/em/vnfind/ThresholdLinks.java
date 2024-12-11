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
package com.ubiqube.etsi.mano.v271.model.em.vnfind;

import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.Link;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

/**
 * Links for this resource.
 */
@Schema (description= "Links for this resource. " )
@Validated

public class ThresholdLinks {
	@JsonProperty("self")
	private Link self = null;

	@JsonProperty("object")
	private Link object = null;

	public ThresholdLinks self(final Link self) {
		this.self = self;
		return this;
	}

	/**
	 * URI of this resource.
	 *
	 * @return self
	 **/
	@Schema(required = true , description = "URI of this resource. ")
	@NotNull

	@Valid

	public Link getSelf() {
		return self;
	}

	public void setSelf(final Link self) {
		this.self = self;
	}

	public ThresholdLinks object(final Link object) {
		this.object = object;
		return this;
	}

	/**
	 * Link to a resource representing the measured object instance for which
	 * performance information is collected. Shall be present if the measured object
	 * instance information is accessible as a resource.
	 *
	 * @return object
	 **/
	@Schema(description = "Link to a resource representing the measured object instance for which performance information is collected. Shall be present if the measured object instance information is accessible as a resource. ")

	@Valid

	public Link getObject() {
		return object;
	}

	public void setObject(final Link object) {
		this.object = object;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final ThresholdLinks thresholdLinks = (ThresholdLinks) o;
		return Objects.equals(this.self, thresholdLinks.self) &&
		Objects.equals(this.object, thresholdLinks.object);
	}

	@Override
	public int hashCode() {
		return Objects.hash(self, object);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class ThresholdLinks {\n");

		sb.append("    self: ").append(toIndentedString(self)).append("\n");
		sb.append("    object: ").append(toIndentedString(object)).append("\n");
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
