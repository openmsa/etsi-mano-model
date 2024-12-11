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
package com.ubiqube.etsi.mano.v431.model.em.vnfpm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.Link;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

/**
 * Links for this resource.
 */
@Schema(description = "Links for this resource. ")
@Validated

public class PmJobLinks {
	@JsonProperty("self")
	private Link self = null;

	@JsonProperty("objects")
	@Valid
	private List<Link> objects = null;

	public PmJobLinks self(final Link self) {
		this.self = self;
		return this;
	}

	/**
	 * Get self
	 *
	 * @return self
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public Link getSelf() {
		return self;
	}

	public void setSelf(final Link self) {
		this.self = self;
	}

	public PmJobLinks objects(final List<Link> objects) {
		this.objects = objects;
		return this;
	}

	public PmJobLinks addObjectsItem(final Link objectsItem) {
		if (this.objects == null) {
			this.objects = new ArrayList<>();
		}
		this.objects.add(objectsItem);
		return this;
	}

	/**
	 * Links to resources representing the measure object instances for which
	 * performance information is collected. Shall be present if the measured object
	 * instance information is accessible as a resource.
	 *
	 * @return objects
	 **/
	@Schema(description = "Links to resources representing the measure object instances for which performance information is collected. Shall be present if the measured object instance information is accessible as a resource. ")
	@Valid
	public List<Link> getObjects() {
		return objects;
	}

	public void setObjects(final List<Link> objects) {
		this.objects = objects;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final PmJobLinks pmJobLinks = (PmJobLinks) o;
		return Objects.equals(this.self, pmJobLinks.self) &&
				Objects.equals(this.objects, pmJobLinks.objects);
	}

	@Override
	public int hashCode() {
		return Objects.hash(self, objects);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class PmJobLinks {\n");

		sb.append("    self: ").append(toIndentedString(self)).append("\n");
		sb.append("    objects: ").append(toIndentedString(objects)).append("\n");
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
