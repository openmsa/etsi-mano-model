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

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.Link;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * LoggingJobLogReports
 */
@Validated

public class LoggingJobLogReports {
	@JsonProperty("logReportId")
	private String logReportId = null;

	@JsonProperty("logReportLoc")
	private Link logReportLoc = null;

	public LoggingJobLogReports logReportId(final String logReportId) {
		this.logReportId = logReportId;
		return this;
	}

	/**
	 * An identifier with the intention of being globally unique.
	 *
	 * @return logReportId
	 **/
	@Schema(required = true, description = "An identifier with the intention of being globally unique. ")
	@NotNull

	public String getLogReportId() {
		return logReportId;
	}

	public void setLogReportId(final String logReportId) {
		this.logReportId = logReportId;
	}

	public LoggingJobLogReports logReportLoc(final Link logReportLoc) {
		this.logReportLoc = logReportLoc;
		return this;
	}

	/**
	 * Get logReportLoc
	 *
	 * @return logReportLoc
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public Link getLogReportLoc() {
		return logReportLoc;
	}

	public void setLogReportLoc(final Link logReportLoc) {
		this.logReportLoc = logReportLoc;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final LoggingJobLogReports loggingJobLogReports = (LoggingJobLogReports) o;
		return Objects.equals(this.logReportId, loggingJobLogReports.logReportId) &&
				Objects.equals(this.logReportLoc, loggingJobLogReports.logReportLoc);
	}

	@Override
	public int hashCode() {
		return Objects.hash(logReportId, logReportLoc);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class LoggingJobLogReports {\n");

		sb.append("    logReportId: ").append(toIndentedString(logReportId)).append("\n");
		sb.append("    logReportLoc: ").append(toIndentedString(logReportLoc)).append("\n");
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
