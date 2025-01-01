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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.annotation.Nonnull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;


/**
 * This type represents a request to create a PM job.
 */
@Schema(description = "This type represents a request to create a PM job. ")
@Validated


public class CreatePmJobRequest {
	@JsonProperty("objectInstanceIds")
	@Valid
	private List<String> objectInstanceIds = null;

	@JsonProperty("criteria")
	private PmJobCriteria criteria = null;

	public CreatePmJobRequest objectInstanceIds(final List<String> objectInstanceIds) {
		this.objectInstanceIds = objectInstanceIds;
		return this;
	}

	public CreatePmJobRequest addObjectInstanceIdsItem(final String objectInstanceIdsItem) {
		if (this.objectInstanceIds == null) {
			this.objectInstanceIds = new ArrayList<>();
		}
		this.objectInstanceIds.add(objectInstanceIdsItem);
		return this;
	}

	/**
	 * Identifiers of the VNF instances for which performance information is
	 * requested to be collected.
	 * 
	 * @return objectInstanceIds
	 **/
	@Schema(description = "Identifiers of the VNF instances for which performance information is requested to be collected. ")

	public List<String> getObjectInstanceIds() {
		return objectInstanceIds;
	}

	public void setObjectInstanceIds(final List<String> objectInstanceIds) {
		this.objectInstanceIds = objectInstanceIds;
	}

	public CreatePmJobRequest criteria(final PmJobCriteria criteria) {
		this.criteria = criteria;
		return this;
	}

	/**
	 * Criteria of the collection of performance information.
	 * 
	 * @return criteria
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Criteria of the collection of performance information. ")
	@Nonnull

	@Valid

	public PmJobCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(final PmJobCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final CreatePmJobRequest createPmJobRequest = (CreatePmJobRequest) o;
		return Objects.equals(this.objectInstanceIds, createPmJobRequest.objectInstanceIds) &&
				Objects.equals(this.criteria, createPmJobRequest.criteria);
	}

	@Override
	public int hashCode() {
		return Objects.hash(objectInstanceIds, criteria);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class CreatePmJobRequest {\n");

		sb.append("    objectInstanceIds: ").append(toIndentedString(objectInstanceIds)).append("\n");
		sb.append("    criteria: ").append(toIndentedString(criteria)).append("\n");
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
