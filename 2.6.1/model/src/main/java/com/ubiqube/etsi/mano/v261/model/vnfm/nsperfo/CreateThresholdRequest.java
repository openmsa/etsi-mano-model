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
 * This type represents a request to create a threshold.
 */
@Schema(description = "This type represents a request to create a threshold. ")
@Validated


public class CreateThresholdRequest {
	@JsonProperty("objectInstanceId")
	private String objectInstanceId = null;

	@JsonProperty("criteria")
	private ThresholdCriteria criteria = null;

	public CreateThresholdRequest objectInstanceId(final String objectInstanceId) {
		this.objectInstanceId = objectInstanceId;
		return this;
	}

	/**
	 * Identifier of the VNF instance associated with this threshold.
	 * 
	 * @return objectInstanceId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifier of the VNF instance associated with this threshold. ")
	@Nonnull

	public String getObjectInstanceId() {
		return objectInstanceId;
	}

	public void setObjectInstanceId(final String objectInstanceId) {
		this.objectInstanceId = objectInstanceId;
	}

	public CreateThresholdRequest criteria(final ThresholdCriteria criteria) {
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

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final CreateThresholdRequest createThresholdRequest = (CreateThresholdRequest) o;
		return Objects.equals(this.objectInstanceId, createThresholdRequest.objectInstanceId) &&
				Objects.equals(this.criteria, createThresholdRequest.criteria);
	}

	@Override
	public int hashCode() {
		return Objects.hash(objectInstanceId, criteria);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class CreateThresholdRequest {\n");

		sb.append("    objectInstanceId: ").append(toIndentedString(objectInstanceId)).append("\n");
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
