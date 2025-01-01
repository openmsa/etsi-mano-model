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
package com.ubiqube.etsi.mano.v451.model.nfvmanologm2;

import java.time.OffsetDateTime;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type represents a log report, which provides information about a
 * compiled log and how to obtain it. * NOTE: It is not specified in the present
 * document how the NFV-MANO functional entity&#x27;s private key is provided to
 * the NFV-MANO functional entity.
 */
@Schema(description = "This type represents a log report, which provides information about a compiled log and how to obtain it. * NOTE: It is not specified in the present document how the NFV-MANO functional entity's private         key is provided to the NFV-MANO functional entity. ")
@Validated

public class LogReport {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("objectInstanceId")
	private ManoManagedObjectReference objectInstanceId = null;

	/**
	 * The trigger for the compilation of the log file. Permitted values: -
	 * ON_DEMAND: created based on explicit request by a client. - AUTOMATIC:
	 * created according to the logging job compilation configuration.
	 */
	public enum CompilationTriggerEnum {
		ON_DEMAND("ON_DEMAND"),

		AUTOMATIC("AUTOMATIC");

		private final String value;

		CompilationTriggerEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static CompilationTriggerEnum fromValue(final String text) {
			for (final CompilationTriggerEnum b : CompilationTriggerEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("compilationTrigger")
	private CompilationTriggerEnum compilationTrigger = null;

	@JsonProperty("readyTime")
	private OffsetDateTime readyTime = null;

	@JsonProperty("expiryTime")
	private OffsetDateTime expiryTime = null;

	@JsonProperty("fileSize")
	private Integer fileSize = null;

	@JsonProperty("fileFormat")
	private String fileFormat = null;

	@JsonProperty("fileLocationInfo")
	private LogReportFileLocationInfo fileLocationInfo = null;

	@JsonProperty("securityAndIntegrityInfo")
	private LogReportSecurityAndIntegrityInfo securityAndIntegrityInfo = null;

	@JsonProperty("_links")
	private LoggingJobLinks _links = null;

	public LogReport id(final String id) {
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

	public LogReport objectInstanceId(final ManoManagedObjectReference objectInstanceId) {
		this.objectInstanceId = objectInstanceId;
		return this;
	}

	/**
	 * Get objectInstanceId
	 *
	 * @return objectInstanceId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public ManoManagedObjectReference getObjectInstanceId() {
		return objectInstanceId;
	}

	public void setObjectInstanceId(final ManoManagedObjectReference objectInstanceId) {
		this.objectInstanceId = objectInstanceId;
	}

	public LogReport compilationTrigger(final CompilationTriggerEnum compilationTrigger) {
		this.compilationTrigger = compilationTrigger;
		return this;
	}

	/**
	 * The trigger for the compilation of the log file. Permitted values: -
	 * ON_DEMAND: created based on explicit request by a client. - AUTOMATIC:
	 * created according to the logging job compilation configuration.
	 *
	 * @return compilationTrigger
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "The trigger for the compilation of the log file. Permitted values: - ON_DEMAND: created based on explicit request by a client. - AUTOMATIC: created according to the logging job compilation configuration.")
	@NotNull

	public CompilationTriggerEnum getCompilationTrigger() {
		return compilationTrigger;
	}

	public void setCompilationTrigger(final CompilationTriggerEnum compilationTrigger) {
		this.compilationTrigger = compilationTrigger;
	}

	public LogReport readyTime(final OffsetDateTime readyTime) {
		this.readyTime = readyTime;
		return this;
	}

	/**
	 * Date-time stamp. Representation: String formatted according to IETF RFC 3339.
	 *
	 * @return readyTime
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Date-time stamp. Representation: String formatted according to IETF RFC 3339. ")
	@NotNull

	@Valid
	public OffsetDateTime getReadyTime() {
		return readyTime;
	}

	public void setReadyTime(final OffsetDateTime readyTime) {
		this.readyTime = readyTime;
	}

	public LogReport expiryTime(final OffsetDateTime expiryTime) {
		this.expiryTime = expiryTime;
		return this;
	}

	/**
	 * Date-time stamp. Representation: String formatted according to IETF RFC 3339.
	 *
	 * @return expiryTime
	 **/
	@Schema(description = "Date-time stamp. Representation: String formatted according to IETF RFC 3339. ")

	@Valid
	public OffsetDateTime getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(final OffsetDateTime expiryTime) {
		this.expiryTime = expiryTime;
	}

	public LogReport fileSize(final Integer fileSize) {
		this.fileSize = fileSize;
		return this;
	}

	/**
	 * The size of the compiled log file in bytes, if known.
	 *
	 * @return fileSize
	 **/
	@Schema(description = "The size of the compiled log file in bytes, if known.")

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(final Integer fileSize) {
		this.fileSize = fileSize;
	}

	public LogReport fileFormat(final String fileFormat) {
		this.fileFormat = fileFormat;
		return this;
	}

	/**
	 * The encoding used by the file.
	 *
	 * @return fileFormat
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "The encoding used by the file.")
	@NotNull

	public String getFileFormat() {
		return fileFormat;
	}

	public void setFileFormat(final String fileFormat) {
		this.fileFormat = fileFormat;
	}

	public LogReport fileLocationInfo(final LogReportFileLocationInfo fileLocationInfo) {
		this.fileLocationInfo = fileLocationInfo;
		return this;
	}

	/**
	 * Get fileLocationInfo
	 *
	 * @return fileLocationInfo
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public LogReportFileLocationInfo getFileLocationInfo() {
		return fileLocationInfo;
	}

	public void setFileLocationInfo(final LogReportFileLocationInfo fileLocationInfo) {
		this.fileLocationInfo = fileLocationInfo;
	}

	public LogReport securityAndIntegrityInfo(final LogReportSecurityAndIntegrityInfo securityAndIntegrityInfo) {
		this.securityAndIntegrityInfo = securityAndIntegrityInfo;
		return this;
	}

	/**
	 * Get securityAndIntegrityInfo
	 *
	 * @return securityAndIntegrityInfo
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public LogReportSecurityAndIntegrityInfo getSecurityAndIntegrityInfo() {
		return securityAndIntegrityInfo;
	}

	public void setSecurityAndIntegrityInfo(final LogReportSecurityAndIntegrityInfo securityAndIntegrityInfo) {
		this.securityAndIntegrityInfo = securityAndIntegrityInfo;
	}

	public LogReport _links(final LoggingJobLinks _links) {
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
		final LogReport logReport = (LogReport) o;
		return Objects.equals(this.id, logReport.id) &&
				Objects.equals(this.objectInstanceId, logReport.objectInstanceId) &&
				Objects.equals(this.compilationTrigger, logReport.compilationTrigger) &&
				Objects.equals(this.readyTime, logReport.readyTime) &&
				Objects.equals(this.expiryTime, logReport.expiryTime) &&
				Objects.equals(this.fileSize, logReport.fileSize) &&
				Objects.equals(this.fileFormat, logReport.fileFormat) &&
				Objects.equals(this.fileLocationInfo, logReport.fileLocationInfo) &&
				Objects.equals(this.securityAndIntegrityInfo, logReport.securityAndIntegrityInfo) &&
				Objects.equals(this._links, logReport._links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, objectInstanceId, compilationTrigger, readyTime, expiryTime, fileSize, fileFormat, fileLocationInfo, securityAndIntegrityInfo, _links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class LogReport {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    objectInstanceId: ").append(toIndentedString(objectInstanceId)).append("\n");
		sb.append("    compilationTrigger: ").append(toIndentedString(compilationTrigger)).append("\n");
		sb.append("    readyTime: ").append(toIndentedString(readyTime)).append("\n");
		sb.append("    expiryTime: ").append(toIndentedString(expiryTime)).append("\n");
		sb.append("    fileSize: ").append(toIndentedString(fileSize)).append("\n");
		sb.append("    fileFormat: ").append(toIndentedString(fileFormat)).append("\n");
		sb.append("    fileLocationInfo: ").append(toIndentedString(fileLocationInfo)).append("\n");
		sb.append("    securityAndIntegrityInfo: ").append(toIndentedString(securityAndIntegrityInfo)).append("\n");
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
