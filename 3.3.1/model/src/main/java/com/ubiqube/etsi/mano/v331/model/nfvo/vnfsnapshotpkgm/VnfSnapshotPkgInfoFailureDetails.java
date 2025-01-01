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
package com.ubiqube.etsi.mano.v331.model.nfvo.vnfsnapshotpkgm;

import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ubiqube.etsi.mano.v331.model.em.vnfconfig.ProblemDetails;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

/**
 * Failure details associated to current error state of the VNF snapshot package
 * state. If \&quot;state\&quot; is \&quot;ERROR\&quot; or
 * \&quot;ERROR_EXTRACTING\&quot;, this attribute shall be present unless it has
 * been requested to be excluded via an attribute selector.
 */
@Schema(description = "Failure details associated to current error state of the VNF snapshot package state.  If \"state\" is \"ERROR\" or \"ERROR_EXTRACTING\", this attribute shall be present unless it  has been requested to be excluded via an attribute selector. ")
@Validated

public class VnfSnapshotPkgInfoFailureDetails {
	/**
	 * Type of error, when the failure happened (building, upload, processing,
	 * extracting). Permitted values: - BUILD_ERROR - UPLOAD_ERROR - PROCESS_ERROR -
	 * CANCELLED - EXTRACTION_ERROR
	 */
	public enum ErrorTypeEnum {
		BUILD_ERROR("BUILD_ERROR"),

		UPLOAD_ERROR("UPLOAD_ERROR"),

		PROCESS_ERROR("PROCESS_ERROR"),

		CANCELLED("CANCELLED"),

		EXTRACTION_ERROR("EXTRACTION_ERROR");

		private final String value;

		ErrorTypeEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static ErrorTypeEnum fromValue(final String text) {
			for (final ErrorTypeEnum b : ErrorTypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("errorType")
	private ErrorTypeEnum errorType = null;

	@JsonProperty("details")
	private ProblemDetails details = null;

	public VnfSnapshotPkgInfoFailureDetails errorType(final ErrorTypeEnum errorType) {
		this.errorType = errorType;
		return this;
	}

	/**
	 * Type of error, when the failure happened (building, upload, processing,
	 * extracting). Permitted values: - BUILD_ERROR - UPLOAD_ERROR - PROCESS_ERROR -
	 * CANCELLED - EXTRACTION_ERROR
	 *
	 * @return errorType
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Type of error, when the failure happened (building, upload, processing, extracting). Permitted values:  - BUILD_ERROR - UPLOAD_ERROR - PROCESS_ERROR - CANCELLED - EXTRACTION_ERROR ")
	@NotNull

	public ErrorTypeEnum getErrorType() {
		return errorType;
	}

	public void setErrorType(final ErrorTypeEnum errorType) {
		this.errorType = errorType;
	}

	public VnfSnapshotPkgInfoFailureDetails details(final ProblemDetails details) {
		this.details = details;
		return this;
	}

	/**
	 * Get details
	 *
	 * @return details
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public ProblemDetails getDetails() {
		return details;
	}

	public void setDetails(final ProblemDetails details) {
		this.details = details;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final VnfSnapshotPkgInfoFailureDetails vnfSnapshotPkgInfoFailureDetails = (VnfSnapshotPkgInfoFailureDetails) o;
		return Objects.equals(this.errorType, vnfSnapshotPkgInfoFailureDetails.errorType) &&
				Objects.equals(this.details, vnfSnapshotPkgInfoFailureDetails.details);
	}

	@Override
	public int hashCode() {
		return Objects.hash(errorType, details);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class VnfSnapshotPkgInfoFailureDetails {\n");

		sb.append("    errorType: ").append(toIndentedString(errorType)).append("\n");
		sb.append("    details: ").append(toIndentedString(details)).append("\n");
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
