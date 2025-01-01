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
package com.ubiqube.etsi.mano.common.v261.model.nsperfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

/**
 * PerformanceReportEntries
 */
@Validated
public class PerformanceReportEntries {
	@JsonProperty("objectType")
	private String objectType = null;

	@JsonProperty("objectInstanceId")
	private String objectInstanceId = null;

	@JsonProperty("subObjectInstanceId")
	private String subObjectInstanceId = null;

	@JsonProperty("performanceMetric")
	private String performanceMetric = null;

	@JsonProperty("performanceValues")
	@Valid
	private List<PerformanceReportPerformanceValues> performanceValues = null;

	public PerformanceReportEntries objectType(final String objectType) {
		this.objectType = objectType;
		return this;
	}

	/**
	 * Defines the object type for which performance information is reported (i.e. VNF type). The string value shall be set to the vnfdId of the VNF instance to which the performance information relates.
	 *
	 * @return objectType
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Defines the object type for which performance information is reported (i.e. VNF type). The string value shall be set to the vnfdId of the VNF instance to which the performance information relates. ")
	@NotNull

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(final String objectType) {
		this.objectType = objectType;
	}

	public PerformanceReportEntries objectInstanceId(final String objectInstanceId) {
		this.objectInstanceId = objectInstanceId;
		return this;
	}

	/**
	 * The object instance (i.e. VNF instance) for which the performance metric is reported.
	 *
	 * @return objectInstanceId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "The object instance (i.e. VNF instance) for which the performance metric is reported. ")
	@NotNull

	public String getObjectInstanceId() {
		return objectInstanceId;
	}

	public void setObjectInstanceId(final String objectInstanceId) {
		this.objectInstanceId = objectInstanceId;
	}

	public PerformanceReportEntries subObjectInstanceId(final String subObjectInstanceId) {
		this.subObjectInstanceId = subObjectInstanceId;
		return this;
	}

	/**
	 * Identifier of the sub-object of the measured object (i.e. a VNFC instance) for which the performance metric is reported. Shall be present if this is required in the measurement specification. The sub-object allows to structure the measured object, but is not to be confused with sub-counters which allow to structure the measurement. EXAMPLE: Measured object: VnfInstanceXYZ Sub-object: VnfcInstance1 Measurement: vCPU_utilization Sub-counters: vCPU utilization of each of the vCPUs of
	 * VnfcInstance1 (vCPU_utilization.vCPU1, vCPU_utilization.vCPU2, etc.).
	 *
	 * @return subObjectInstanceId
	 **/
	@Schema(description = "Identifier of the sub-object of the measured object (i.e. a VNFC instance) for which the performance metric is reported. Shall be present if this is required in the measurement specification. The sub-object allows to structure the measured object, but is not to be confused with sub-counters which allow to structure the measurement. EXAMPLE:   Measured object:  VnfInstanceXYZ   Sub-object:       VnfcInstance1   Measurement:      vCPU_utilization   Sub-counters:     vCPU utilization of each of the vCPUs of VnfcInstance1                     (vCPU_utilization.vCPU1, vCPU_utilization.vCPU2, etc.). ")

	public String getSubObjectInstanceId() {
		return subObjectInstanceId;
	}

	public void setSubObjectInstanceId(final String subObjectInstanceId) {
		this.subObjectInstanceId = subObjectInstanceId;
	}

	public PerformanceReportEntries performanceMetric(final String performanceMetric) {
		this.performanceMetric = performanceMetric;
		return this;
	}

	/**
	 * Name of the metric collected. This attribute shall contain the related \"Measurement Name\" value as defined in clause 7.2 of ETSI GS NFV-IFA 027.
	 *
	 * @return performanceMetric
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Name of the metric collected. This attribute shall contain the related \"Measurement Name\" value as defined in clause 7.2 of ETSI GS NFV-IFA 027. ")
	@NotNull

	public String getPerformanceMetric() {
		return performanceMetric;
	}

	public void setPerformanceMetric(final String performanceMetric) {
		this.performanceMetric = performanceMetric;
	}

	public PerformanceReportEntries performanceValues(final List<PerformanceReportPerformanceValues> performanceValues) {
		this.performanceValues = performanceValues;
		return this;
	}

	public PerformanceReportEntries addPerformanceValuesItem(final PerformanceReportPerformanceValues performanceValuesItem) {
		if (this.performanceValues == null) {
			this.performanceValues = new ArrayList<>();
		}
		this.performanceValues.add(performanceValuesItem);
		return this;
	}

	/**
	 * List of performance values with associated timestamp.
	 *
	 * @return performanceValues
	 **/
	@Schema(description = "List of performance values with associated timestamp. ")

	@Valid

	public List<PerformanceReportPerformanceValues> getPerformanceValues() {
		return performanceValues;
	}

	public void setPerformanceValues(final List<PerformanceReportPerformanceValues> performanceValues) {
		this.performanceValues = performanceValues;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final PerformanceReportEntries performanceReportEntries = (PerformanceReportEntries) o;
		return Objects.equals(this.objectType, performanceReportEntries.objectType) &&
				Objects.equals(this.objectInstanceId, performanceReportEntries.objectInstanceId) &&
				Objects.equals(this.subObjectInstanceId, performanceReportEntries.subObjectInstanceId) &&
				Objects.equals(this.performanceMetric, performanceReportEntries.performanceMetric) &&
				Objects.equals(this.performanceValues, performanceReportEntries.performanceValues);
	}

	@Override
	public int hashCode() {
		return Objects.hash(objectType, objectInstanceId, subObjectInstanceId, performanceMetric, performanceValues);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class PerformanceReportEntries {\n");

		sb.append("    objectType: ").append(toIndentedString(objectType)).append("\n");
		sb.append("    objectInstanceId: ").append(toIndentedString(objectInstanceId)).append("\n");
		sb.append("    subObjectInstanceId: ").append(toIndentedString(subObjectInstanceId)).append("\n");
		sb.append("    performanceMetric: ").append(toIndentedString(performanceMetric)).append("\n");
		sb.append("    performanceValues: ").append(toIndentedString(performanceValues)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces (except the first line).
	 */
	private String toIndentedString(final java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
