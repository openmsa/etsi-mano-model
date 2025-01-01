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
package com.ubiqube.etsi.mano.v331.model.em.vnfind;

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
 * This type represents a PM job.
 */
@Schema(description = "This type represents a PM job. ")
@Validated

public class PmJob {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("objectType")
	private String objectType = null;

	@JsonProperty("objectInstanceIds")
	@Valid
	private List<String> objectInstanceIds = new ArrayList<>();

	@JsonProperty("subObjectInstanceIds")
	@Valid
	private List<String> subObjectInstanceIds = null;

	@JsonProperty("criteria")
	private PmJobCriteria criteria = null;

	@JsonProperty("callbackUri")
	private String callbackUri = null;

	@JsonProperty("reports")
	private PmJobReports reports = null;

	@JsonProperty("_links")
	private PmJobLinks links = null;

	public PmJob id(final String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 *
	 * @return id
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public PmJob objectType(final String objectType) {
		this.objectType = objectType;
		return this;
	}

	/**
	 * Type of the measured object. The applicable measured object type for a
	 * measurement is defined in clause 7.2 of ETSI GS NFV-IFA 027.
	 *
	 * @return objectType
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Type of the measured object. The applicable measured object type for a measurement is defined in clause 7.2 of ETSI GS NFV-IFA 027. ")
	@NotNull

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(final String objectType) {
		this.objectType = objectType;
	}

	public PmJob objectInstanceIds(final List<String> objectInstanceIds) {
		this.objectInstanceIds = objectInstanceIds;
		return this;
	}

	public PmJob addObjectInstanceIdsItem(final String objectInstanceIdsItem) {
		this.objectInstanceIds.add(objectInstanceIdsItem);
		return this;
	}

	/**
	 * Identifiers of the VNF instances for which performance information is
	 * collected.
	 *
	 * @return objectInstanceIds
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifiers of the VNF instances for which performance information is collected. ")
	@NotNull

	public List<String> getObjectInstanceIds() {
		return objectInstanceIds;
	}

	public void setObjectInstanceIds(final List<String> objectInstanceIds) {
		this.objectInstanceIds = objectInstanceIds;
	}

	public PmJob subObjectInstanceIds(final List<String> subObjectInstanceIds) {
		this.subObjectInstanceIds = subObjectInstanceIds;
		return this;
	}

	public PmJob addSubObjectInstanceIdsItem(final String subObjectInstanceIdsItem) {
		if (this.subObjectInstanceIds == null) {
			this.subObjectInstanceIds = new ArrayList<>();
		}
		this.subObjectInstanceIds.add(subObjectInstanceIdsItem);
		return this;
	}

	/**
	 * Identifiers of the sub-object instances of the measured object instance for
	 * which performance information is requested to be collected. May be present if
	 * a sub-object is defined in clause 6.2 of ETSI GS NFV-IFA 027 for the related
	 * measured object type. If this attribute is present, the cardinality of the
	 * \"objectInstanceIds\" attribute shall be 1. If this attribute is absent and a
	 * sub-object is defined in clause 6.2 of ETSI GS NFV IFA 027 for the related
	 * measured object type, measurements will be taken for all sub-object instances
	 * of the measured object instance.
	 *
	 * @return subObjectInstanceIds
	 **/
	@Schema(description = "Identifiers of the sub-object instances of the measured object instance for which performance information is requested to be collected. May be present if a sub-object is defined in clause 6.2 of ETSI GS NFV-IFA 027 for the related measured object type. If this attribute is present, the cardinality of the \"objectInstanceIds\" attribute shall be 1. If this attribute is absent and a sub-object is defined in clause 6.2 of ETSI GS NFV IFA 027 for the related measured object type, measurements will be taken for all sub-object instances of the measured object instance. ")

	public List<String> getSubObjectInstanceIds() {
		return subObjectInstanceIds;
	}

	public void setSubObjectInstanceIds(final List<String> subObjectInstanceIds) {
		this.subObjectInstanceIds = subObjectInstanceIds;
	}

	public PmJob criteria(final PmJobCriteria criteria) {
		this.criteria = criteria;
		return this;
	}

	/**
	 * Get criteria
	 *
	 * @return criteria
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public PmJobCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(final PmJobCriteria criteria) {
		this.criteria = criteria;
	}

	public PmJob callbackUri(final String callbackUri) {
		this.callbackUri = callbackUri;
		return this;
	}

	/**
	 * Get callbackUri
	 *
	 * @return callbackUri
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getCallbackUri() {
		return callbackUri;
	}

	public void setCallbackUri(final String callbackUri) {
		this.callbackUri = callbackUri;
	}

	public PmJob reports(final PmJobReports reports) {
		this.reports = reports;
		return this;
	}

	/**
	 * Get reports
	 *
	 * @return reports
	 **/
	@Schema(description = "")

	@Valid
	public PmJobReports getReports() {
		return reports;
	}

	public void setReports(final PmJobReports reports) {
		this.reports = reports;
	}

	public PmJob links(final PmJobLinks _links) {
		this.links = _links;
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
	public PmJobLinks getLinks() {
		return links;
	}

	public void setLinks(final PmJobLinks _links) {
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
		final PmJob pmJob = (PmJob) o;
		return Objects.equals(this.id, pmJob.id) &&
				Objects.equals(this.objectType, pmJob.objectType) &&
				Objects.equals(this.objectInstanceIds, pmJob.objectInstanceIds) &&
				Objects.equals(this.subObjectInstanceIds, pmJob.subObjectInstanceIds) &&
				Objects.equals(this.criteria, pmJob.criteria) &&
				Objects.equals(this.callbackUri, pmJob.callbackUri) &&
				Objects.equals(this.reports, pmJob.reports) &&
				Objects.equals(this.links, pmJob.links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, objectType, objectInstanceIds, subObjectInstanceIds, criteria, callbackUri, reports, links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class PmJob {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    objectType: ").append(toIndentedString(objectType)).append("\n");
		sb.append("    objectInstanceIds: ").append(toIndentedString(objectInstanceIds)).append("\n");
		sb.append("    subObjectInstanceIds: ").append(toIndentedString(subObjectInstanceIds)).append("\n");
		sb.append("    criteria: ").append(toIndentedString(criteria)).append("\n");
		sb.append("    callbackUri: ").append(toIndentedString(callbackUri)).append("\n");
		sb.append("    reports: ").append(toIndentedString(reports)).append("\n");
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
