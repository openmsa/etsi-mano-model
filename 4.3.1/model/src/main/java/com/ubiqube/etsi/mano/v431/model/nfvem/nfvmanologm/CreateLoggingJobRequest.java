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
package com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanologm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanopm.ManoManagedObjectReference;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Information on application context created by the MEC system
 */
@Schema(description = "Information on application context created by the MEC system")
@Validated

public class CreateLoggingJobRequest {
	@JsonProperty("objectInstanceIds")
	@Valid
	private List<ManoManagedObjectReference> objectInstanceIds = new ArrayList<>();

	@JsonProperty("jobCriteria")
	private LoggingJobCriteria jobCriteria = null;

	@JsonProperty("jobConfig")
	private LoggingJobConfig jobConfig = null;

	public CreateLoggingJobRequest objectInstanceIds(final List<ManoManagedObjectReference> objectInstanceIds) {
		this.objectInstanceIds = objectInstanceIds;
		return this;
	}

	public CreateLoggingJobRequest addObjectInstanceIdsItem(final ManoManagedObjectReference objectInstanceIdsItem) {
		this.objectInstanceIds.add(objectInstanceIdsItem);
		return this;
	}

	/**
	 * Identifiers of the object instance for which logging information is requested
	 * to be collected. This attribute shall contain the identifier of the instance
	 * of the object to be logged according to their type. If more than one
	 * identifier is provided, values shall all refer to object instances of the
	 * same type, for which the same criteria is then applicable.
	 *
	 * @return objectInstanceIds
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifiers of the object instance for which logging information is requested to be collected. This attribute shall contain the identifier of the instance of the object to be logged according to their type. If more than one identifier is provided, values shall all refer to object instances of the same type, for which the same criteria is then applicable.")
	@NotNull
	@Valid
	@Size(min = 1)
	public List<ManoManagedObjectReference> getObjectInstanceIds() {
		return objectInstanceIds;
	}

	public void setObjectInstanceIds(final List<ManoManagedObjectReference> objectInstanceIds) {
		this.objectInstanceIds = objectInstanceIds;
	}

	public CreateLoggingJobRequest jobCriteria(final LoggingJobCriteria jobCriteria) {
		this.jobCriteria = jobCriteria;
		return this;
	}

	/**
	 * Get jobCriteria
	 *
	 * @return jobCriteria
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public LoggingJobCriteria getJobCriteria() {
		return jobCriteria;
	}

	public void setJobCriteria(final LoggingJobCriteria jobCriteria) {
		this.jobCriteria = jobCriteria;
	}

	public CreateLoggingJobRequest jobConfig(final LoggingJobConfig jobConfig) {
		this.jobConfig = jobConfig;
		return this;
	}

	/**
	 * Get jobConfig
	 *
	 * @return jobConfig
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public LoggingJobConfig getJobConfig() {
		return jobConfig;
	}

	public void setJobConfig(final LoggingJobConfig jobConfig) {
		this.jobConfig = jobConfig;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final CreateLoggingJobRequest createLoggingJobRequest = (CreateLoggingJobRequest) o;
		return Objects.equals(this.objectInstanceIds, createLoggingJobRequest.objectInstanceIds) &&
				Objects.equals(this.jobCriteria, createLoggingJobRequest.jobCriteria) &&
				Objects.equals(this.jobConfig, createLoggingJobRequest.jobConfig);
	}

	@Override
	public int hashCode() {
		return Objects.hash(objectInstanceIds, jobCriteria, jobConfig);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class CreateLoggingJobRequest {\n");

		sb.append("    objectInstanceIds: ").append(toIndentedString(objectInstanceIds)).append("\n");
		sb.append("    jobCriteria: ").append(toIndentedString(jobCriteria)).append("\n");
		sb.append("    jobConfig: ").append(toIndentedString(jobConfig)).append("\n");
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
