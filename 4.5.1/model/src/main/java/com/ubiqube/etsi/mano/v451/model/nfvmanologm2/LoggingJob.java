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
package com.ubiqube.etsi.mano.v451.model.nfvmanologm2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type represents a logging job. It shall comply with the provisions
 * defined in table 8.6.2.6-1.
 */
@Schema(description = "This type represents a logging job. It shall comply with the provisions defined in table 8.6.2.6-1.")
@Validated

public class LoggingJob {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("objectInstanceIds")
	@Valid
	private List<ManoManagedObjectReference> objectInstanceIds = new ArrayList<>();

	@JsonProperty("jobCriteria")
	private LoggingJobCriteria jobCriteria = null;

	@JsonProperty("jobConfig")
	private LoggingJobConfig jobConfig = null;

	@JsonProperty("logReports")
	@Valid
	private List<LoggingJobLogReports> logReports = null;

	@JsonProperty("_links")
	private LoggingJobLinks _links = null;

	public LoggingJob id(final String id) {
		this.id = id;
		return this;
	}

	/**
	 * An identifier with the intention of being globally unique.
	 *
	 * @return id
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "An identifier with the intention of being globally unique. ")
	@NotNull

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public LoggingJob objectInstanceIds(final List<ManoManagedObjectReference> objectInstanceIds) {
		this.objectInstanceIds = objectInstanceIds;
		return this;
	}

	public LoggingJob addObjectInstanceIdsItem(final ManoManagedObjectReference objectInstanceIdsItem) {
		this.objectInstanceIds.add(objectInstanceIdsItem);
		return this;
	}

	/**
	 * Identifiers of the object instance for which logging information is
	 * collected. This attribute shall contain the identifier of the instance of the
	 * object that is logged according to their type.
	 *
	 * @return objectInstanceIds
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifiers of the object instance for which logging information is collected. This attribute shall contain the identifier of the instance of the object that is logged according to their type.")
	@NotNull
	@Valid
	public List<ManoManagedObjectReference> getObjectInstanceIds() {
		return objectInstanceIds;
	}

	public void setObjectInstanceIds(final List<ManoManagedObjectReference> objectInstanceIds) {
		this.objectInstanceIds = objectInstanceIds;
	}

	public LoggingJob jobCriteria(final LoggingJobCriteria jobCriteria) {
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

	public LoggingJob jobConfig(final LoggingJobConfig jobConfig) {
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

	public LoggingJob logReports(final List<LoggingJobLogReports> logReports) {
		this.logReports = logReports;
		return this;
	}

	public LoggingJob addLogReportsItem(final LoggingJobLogReports logReportsItem) {
		if (this.logReports == null) {
			this.logReports = new ArrayList<>();
		}
		this.logReports.add(logReportsItem);
		return this;
	}

	/**
	 * Information about available log reports created by the logging job.
	 *
	 * @return logReports
	 **/
	@Schema(description = "Information about available log reports created by the logging job.")
	@Valid
	public List<LoggingJobLogReports> getLogReports() {
		return logReports;
	}

	public void setLogReports(final List<LoggingJobLogReports> logReports) {
		this.logReports = logReports;
	}

	public LoggingJob _links(final LoggingJobLinks _links) {
		this._links = _links;
		return this;
	}

	/**
	 * Get _links
	 *
	 * @return _links
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public LoggingJobLinks getLinks() {
		return _links;
	}

	public void setLinks(final LoggingJobLinks _links) {
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
		final LoggingJob loggingJob = (LoggingJob) o;
		return Objects.equals(this.id, loggingJob.id) &&
				Objects.equals(this.objectInstanceIds, loggingJob.objectInstanceIds) &&
				Objects.equals(this.jobCriteria, loggingJob.jobCriteria) &&
				Objects.equals(this.jobConfig, loggingJob.jobConfig) &&
				Objects.equals(this.logReports, loggingJob.logReports) &&
				Objects.equals(this._links, loggingJob._links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, objectInstanceIds, jobCriteria, jobConfig, logReports, _links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class LoggingJob {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    objectInstanceIds: ").append(toIndentedString(objectInstanceIds)).append("\n");
		sb.append("    jobCriteria: ").append(toIndentedString(jobCriteria)).append("\n");
		sb.append("    jobConfig: ").append(toIndentedString(jobConfig)).append("\n");
		sb.append("    logReports: ").append(toIndentedString(logReports)).append("\n");
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
