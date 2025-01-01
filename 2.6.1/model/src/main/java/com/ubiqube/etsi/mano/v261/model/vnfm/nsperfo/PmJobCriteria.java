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
 * Criteria of the collection of performance information.
 */
@Schema(description = "Criteria of the collection of performance information. ")
@Validated


public class PmJobCriteria {
	@JsonProperty("performanceMetric")
	@Valid
	private List<String> performanceMetric = null;

	@JsonProperty("performanceMetricGroup")
	@Valid
	private List<String> performanceMetricGroup = null;

	@JsonProperty("collectionPeriod")
	private Integer collectionPeriod = null;

	@JsonProperty("reportingPeriod")
	private Integer reportingPeriod = null;

	@JsonProperty("reportingBoundary")
	private String reportingBoundary = null;

	public PmJobCriteria performanceMetric(final List<String> performanceMetric) {
		this.performanceMetric = performanceMetric;
		return this;
	}

	public PmJobCriteria addPerformanceMetricItem(final String performanceMetricItem) {
		if (this.performanceMetric == null) {
			this.performanceMetric = new ArrayList<>();
		}
		this.performanceMetric.add(performanceMetricItem);
		return this;
	}

	/**
	 * This defines the types of performance metrics for the specified object
	 * instances. Valid values are specified as \"Measurement Name\" values in
	 * clause 7.2 of ETSI GS NFV-IFA 027. At least one of the two attributes
	 * (performance metric or group) shall be present.
	 * 
	 * @return performanceMetric
	 **/
	@Schema(description = "This defines the types of performance metrics for the specified object instances. Valid values are specified as \"Measurement Name\" values in clause 7.2 of ETSI GS NFV-IFA 027. At least one of the two attributes (performance metric or group) shall be present. ")

	public List<String> getPerformanceMetric() {
		return performanceMetric;
	}

	public void setPerformanceMetric(final List<String> performanceMetric) {
		this.performanceMetric = performanceMetric;
	}

	public PmJobCriteria performanceMetricGroup(final List<String> performanceMetricGroup) {
		this.performanceMetricGroup = performanceMetricGroup;
		return this;
	}

	public PmJobCriteria addPerformanceMetricGroupItem(final String performanceMetricGroupItem) {
		if (this.performanceMetricGroup == null) {
			this.performanceMetricGroup = new ArrayList<>();
		}
		this.performanceMetricGroup.add(performanceMetricGroupItem);
		return this;
	}

	/**
	 * Group of performance metrics. A metric group is a pre-defined list of
	 * metrics, known to the producer that it can decompose to individual metrics.
	 * Valid values are specified as \"Measurement Group\" values in clause 7.2 of
	 * ETSI GS NFV-IFA 027. At least one of the two attributes (performance metric
	 * or group) shall be present.
	 * 
	 * @return performanceMetricGroup
	 **/
	@Schema(description = "Group of performance metrics. A metric group is a pre-defined list of metrics, known to the producer that it can decompose to individual metrics. Valid values are specified as \"Measurement Group\" values in clause 7.2 of ETSI GS NFV-IFA 027. At least one of the two attributes (performance metric or group) shall be present. ")

	public List<String> getPerformanceMetricGroup() {
		return performanceMetricGroup;
	}

	public void setPerformanceMetricGroup(final List<String> performanceMetricGroup) {
		this.performanceMetricGroup = performanceMetricGroup;
	}

	public PmJobCriteria collectionPeriod(final Integer collectionPeriod) {
		this.collectionPeriod = collectionPeriod;
		return this;
	}

	/**
	 * Specifies the periodicity at which the producer will collect performance
	 * information. The unit shall be seconds. At the end of each reportingPeriod,
	 * the producer will inform the consumer about availability of the performance
	 * data collected for each completed collection period during this
	 * reportingPeriod. The reportingPeriod should be equal to or a multiple of the
	 * collectionPeriod. In the latter case, the performance data for the collection
	 * periods within one reporting period are reported together.
	 * 
	 * @return collectionPeriod
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Specifies the periodicity at which the producer will collect performance information. The unit shall be seconds. At the end of each reportingPeriod, the producer will inform the consumer about availability of the performance data collected for each completed collection period during this reportingPeriod. The reportingPeriod should be equal to or a multiple of the collectionPeriod. In the latter case, the performance data for the collection periods within one reporting period are reported together. ")
	@Nonnull

	public Integer getCollectionPeriod() {
		return collectionPeriod;
	}

	public void setCollectionPeriod(final Integer collectionPeriod) {
		this.collectionPeriod = collectionPeriod;
	}

	public PmJobCriteria reportingPeriod(final Integer reportingPeriod) {
		this.reportingPeriod = reportingPeriod;
		return this;
	}

	/**
	 * Specifies the periodicity at which the producer will report to the consumer.
	 * about performance information. The unit shall be seconds. At the end of each
	 * reportingPeriod, the producer will inform the consumer about availability of
	 * the performance data collected for each completed collection period during
	 * this reportingPeriod. The reportingPeriod should be equal to or a multiple of
	 * the collectionPeriod. In the latter case, the performance data for the
	 * collection periods within one reporting period are reported together.
	 * 
	 * @return reportingPeriod
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Specifies the periodicity at which the producer will report to the consumer. about performance information. The unit shall be seconds. At the end of each reportingPeriod, the producer will inform the consumer about availability of the performance data collected for each completed collection period during this reportingPeriod. The reportingPeriod should be equal to or a multiple of the collectionPeriod. In the latter case, the performance data for the collection periods within one reporting period are reported together. ")
	@Nonnull

	public Integer getReportingPeriod() {
		return reportingPeriod;
	}

	public void setReportingPeriod(final Integer reportingPeriod) {
		this.reportingPeriod = reportingPeriod;
	}

	public PmJobCriteria reportingBoundary(final String reportingBoundary) {
		this.reportingBoundary = reportingBoundary;
		return this;
	}

	/**
	 * Identifies a time boundary after which the reporting will stop. The boundary
	 * shall allow a single reporting as well as periodic reporting up to the
	 * boundary.
	 * 
	 * @return reportingBoundary
	 **/
	@Schema(description = "Identifies a time boundary after which the reporting will stop. The boundary shall allow a single reporting as well as periodic reporting up to the boundary. ")

	public String getReportingBoundary() {
		return reportingBoundary;
	}

	public void setReportingBoundary(final String reportingBoundary) {
		this.reportingBoundary = reportingBoundary;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final PmJobCriteria pmJobCriteria = (PmJobCriteria) o;
		return Objects.equals(this.performanceMetric, pmJobCriteria.performanceMetric) &&
				Objects.equals(this.performanceMetricGroup, pmJobCriteria.performanceMetricGroup) &&
				Objects.equals(this.collectionPeriod, pmJobCriteria.collectionPeriod) &&
				Objects.equals(this.reportingPeriod, pmJobCriteria.reportingPeriod) &&
				Objects.equals(this.reportingBoundary, pmJobCriteria.reportingBoundary);
	}

	@Override
	public int hashCode() {
		return Objects.hash(performanceMetric, performanceMetricGroup, collectionPeriod, reportingPeriod, reportingBoundary);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class PmJobCriteria {\n");

		sb.append("    performanceMetric: ").append(toIndentedString(performanceMetric)).append("\n");
		sb.append("    performanceMetricGroup: ").append(toIndentedString(performanceMetricGroup)).append("\n");
		sb.append("    collectionPeriod: ").append(toIndentedString(collectionPeriod)).append("\n");
		sb.append("    reportingPeriod: ").append(toIndentedString(reportingPeriod)).append("\n");
		sb.append("    reportingBoundary: ").append(toIndentedString(reportingBoundary)).append("\n");
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
