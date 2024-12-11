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
package com.ubiqube.etsi.mano.v261.model.nfvo.nsperfo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Min;

/**
 * This type represents collection criteria for PM jobs. It shall comply with
 * the provisions defined in Table 7.5.3.3-1.
 **/
@Schema(description = "This type represents collection criteria for PM jobs.  It shall comply with the provisions defined in Table 7.5.3.3-1. ")
public class PmJobsPmJobCriteria {

	@Schema(description = "This defines the types of performance metrics for the specified object instances. At least one of the two attributes (performance metric or group) shall be present. ")
	/**
	 * This defines the types of performance metrics for the specified object
	 * instances. At least one of the two attributes (performance metric or group)
	 * shall be present.
	 **/
	private List<String> performanceMetric = null;

	@Schema(description = "Group of performance metrics. A metric group is a pre-defined list of metrics, known to the producer that it can decompose to individual metrics. At least one of the two attributes (performance metric or group) shall be present. ")
	/**
	 * Group of performance metrics. A metric group is a pre-defined list of
	 * metrics, known to the producer that it can decompose to individual metrics.
	 * At least one of the two attributes (performance metric or group) shall be
	 * present.
	 **/
	private List<String> performanceMetricGroup = null;

	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Specifies the periodicity at which the producer will collect performance information. The unit shall be seconds. At the end of each reportingPeriod, the producer will inform the consumer about availability of the performance data collected for each completed collection period during this reportingPeriod. The reportingPeriod should be equal to or a multiple of the collectionPeriod. In the latter case, the performance data for the collection periods within one reporting period are reported together.     In particular when choosing short collection and reporting periods, the number of PM jobs that can be supported depends on the capability of the producing entity. ")
	/**
	 * Specifies the periodicity at which the producer will collect performance
	 * information. The unit shall be seconds. At the end of each reportingPeriod,
	 * the producer will inform the consumer about availability of the performance
	 * data collected for each completed collection period during this
	 * reportingPeriod. The reportingPeriod should be equal to or a multiple of the
	 * collectionPeriod. In the latter case, the performance data for the collection
	 * periods within one reporting period are reported together. In particular when
	 * choosing short collection and reporting periods, the number of PM jobs that
	 * can be supported depends on the capability of the producing entity.
	 **/
	private Integer collectionPeriod = null;

	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Specifies the periodicity at which the producer will report to the consumer. about performance information. The unit shall be seconds. At the end of each reportingPeriod, the producer will inform the consumer about availability of the performance data collected for each completed collection period during this reportingPeriod. The reportingPeriod should be equal to or a multiple of the collectionPeriod. In the latter case, the performance data for the collection periods within one reporting period are reported together.     In particular when choosing short collection and reporting periods, the number of PM jobs that can be supported depends on the capability of the producing entity.           ")
	/**
	 * Specifies the periodicity at which the producer will report to the consumer.
	 * about performance information. The unit shall be seconds. At the end of each
	 * reportingPeriod, the producer will inform the consumer about availability of
	 * the performance data collected for each completed collection period during
	 * this reportingPeriod. The reportingPeriod should be equal to or a multiple of
	 * the collectionPeriod. In the latter case, the performance data for the
	 * collection periods within one reporting period are reported together. In
	 * particular when choosing short collection and reporting periods, the number
	 * of PM jobs that can be supported depends on the capability of the producing
	 * entity.
	 **/
	private Integer reportingPeriod = null;

	@Schema(description = "Date-time stamp.  Representation: String formatted according to IETF RFC 3339. ")
	/**
	 * Date-time stamp. Representation: String formatted according to IETF RFC 3339.
	 **/
	private Date reportingBoundary = null;

	/**
	 * This defines the types of performance metrics for the specified object
	 * instances. At least one of the two attributes (performance metric or group)
	 * shall be present.
	 *
	 * @return performanceMetric
	 **/
	@JsonProperty("performanceMetric")
	public List<String> getPerformanceMetric() {
		return performanceMetric;
	}

	public void setPerformanceMetric(final List<String> performanceMetric) {
		this.performanceMetric = performanceMetric;
	}

	public PmJobsPmJobCriteria performanceMetric(final List<String> performanceMetric) {
		this.performanceMetric = performanceMetric;
		return this;
	}

	public PmJobsPmJobCriteria addPerformanceMetricItem(final String performanceMetricItem) {
		this.performanceMetric.add(performanceMetricItem);
		return this;
	}

	/**
	 * Group of performance metrics. A metric group is a pre-defined list of
	 * metrics, known to the producer that it can decompose to individual metrics.
	 * At least one of the two attributes (performance metric or group) shall be
	 * present.
	 *
	 * @return performanceMetricGroup
	 **/
	@JsonProperty("performanceMetricGroup")
	public List<String> getPerformanceMetricGroup() {
		return performanceMetricGroup;
	}

	public void setPerformanceMetricGroup(final List<String> performanceMetricGroup) {
		this.performanceMetricGroup = performanceMetricGroup;
	}

	public PmJobsPmJobCriteria performanceMetricGroup(final List<String> performanceMetricGroup) {
		this.performanceMetricGroup = performanceMetricGroup;
		return this;
	}

	public PmJobsPmJobCriteria addPerformanceMetricGroupItem(final String performanceMetricGroupItem) {
		this.performanceMetricGroup.add(performanceMetricGroupItem);
		return this;
	}

	/**
	 * Specifies the periodicity at which the producer will collect performance
	 * information. The unit shall be seconds. At the end of each reportingPeriod,
	 * the producer will inform the consumer about availability of the performance
	 * data collected for each completed collection period during this
	 * reportingPeriod. The reportingPeriod should be equal to or a multiple of the
	 * collectionPeriod. In the latter case, the performance data for the collection
	 * periods within one reporting period are reported together. In particular when
	 * choosing short collection and reporting periods, the number of PM jobs that
	 * can be supported depends on the capability of the producing entity. minimum:
	 * 0
	 *
	 * @return collectionPeriod
	 **/
	@JsonProperty("collectionPeriod")
	@Nonnull
	@Min(0)
	public Integer getCollectionPeriod() {
		return collectionPeriod;
	}

	public void setCollectionPeriod(final Integer collectionPeriod) {
		this.collectionPeriod = collectionPeriod;
	}

	public PmJobsPmJobCriteria collectionPeriod(final Integer collectionPeriod) {
		this.collectionPeriod = collectionPeriod;
		return this;
	}

	/**
	 * Specifies the periodicity at which the producer will report to the consumer.
	 * about performance information. The unit shall be seconds. At the end of each
	 * reportingPeriod, the producer will inform the consumer about availability of
	 * the performance data collected for each completed collection period during
	 * this reportingPeriod. The reportingPeriod should be equal to or a multiple of
	 * the collectionPeriod. In the latter case, the performance data for the
	 * collection periods within one reporting period are reported together. In
	 * particular when choosing short collection and reporting periods, the number
	 * of PM jobs that can be supported depends on the capability of the producing
	 * entity. minimum: 0
	 *
	 * @return reportingPeriod
	 **/
	@JsonProperty("reportingPeriod")
	@Nonnull
	@Min(0)
	public Integer getReportingPeriod() {
		return reportingPeriod;
	}

	public void setReportingPeriod(final Integer reportingPeriod) {
		this.reportingPeriod = reportingPeriod;
	}

	public PmJobsPmJobCriteria reportingPeriod(final Integer reportingPeriod) {
		this.reportingPeriod = reportingPeriod;
		return this;
	}

	/**
	 * Date-time stamp. Representation: String formatted according to IETF RFC 3339.
	 *
	 * @return reportingBoundary
	 **/
	@JsonProperty("reportingBoundary")
	public Date getReportingBoundary() {
		return reportingBoundary;
	}

	public void setReportingBoundary(final Date reportingBoundary) {
		this.reportingBoundary = reportingBoundary;
	}

	public PmJobsPmJobCriteria reportingBoundary(final Date reportingBoundary) {
		this.reportingBoundary = reportingBoundary;
		return this;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class PmJobsPmJobCriteria {\n");

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
	private static String toIndentedString(final Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
