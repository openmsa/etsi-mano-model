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
package com.ubiqube.etsi.mano.v451.model.nfvo.lcmcoord;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v451.model.em.vnfconfig.ProblemDetails;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.LcmCoordResultType;

import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type represents an LCM coordination result. It shall comply with the
 * provisions defined in table 12.5.2.3-1. NOTE: How to determine the supported
 * coordination actions is outside the scope of the present version of this
 * document.
 */
@Schema(description = "This type represents an LCM coordination result. It shall comply with the provisions  defined in table 12.5.2.3-1.  NOTE: How to determine the supported coordination actions is outside the scope of the        present version of this document. ")
@Validated

public class LcmCoord {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("coordinationResult")
	private LcmCoordResultType coordinationResult = null;

	@JsonProperty("nsInstanceId")
	private String nsInstanceId = null;

	@JsonProperty("nsLcmOpOccId")
	private String nsLcmOpOccId = null;

	@JsonProperty("lcmOperationType")
	private LcmOperationForCoordType lcmOperationType = null;

	@JsonProperty("coordinationActionName")
	private String coordinationActionName = null;

	@JsonProperty("outputParams")
	private Map<String, String> outputParams = null;

	@JsonProperty("warnings")
	private String warnings = null;

	@JsonProperty("error")
	private ProblemDetails error = null;

	@JsonProperty("_links")
	private LcmCoordLinks _links = null;

	public LcmCoord id(final String id) {
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

	public LcmCoord coordinationResult(final LcmCoordResultType coordinationResult) {
		this.coordinationResult = coordinationResult;
		return this;
	}

	/**
	 * Get coordinationResult
	 *
	 * @return coordinationResult
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public LcmCoordResultType getCoordinationResult() {
		return coordinationResult;
	}

	public void setCoordinationResult(final LcmCoordResultType coordinationResult) {
		this.coordinationResult = coordinationResult;
	}

	public LcmCoord nsInstanceId(final String nsInstanceId) {
		this.nsInstanceId = nsInstanceId;
		return this;
	}

	/**
	 * Get nsInstanceId
	 *
	 * @return nsInstanceId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getNsInstanceId() {
		return nsInstanceId;
	}

	public void setNsInstanceId(final String nsInstanceId) {
		this.nsInstanceId = nsInstanceId;
	}

	public LcmCoord nsLcmOpOccId(final String nsLcmOpOccId) {
		this.nsLcmOpOccId = nsLcmOpOccId;
		return this;
	}

	/**
	 * Get nsLcmOpOccId
	 *
	 * @return nsLcmOpOccId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getNsLcmOpOccId() {
		return nsLcmOpOccId;
	}

	public void setNsLcmOpOccId(final String nsLcmOpOccId) {
		this.nsLcmOpOccId = nsLcmOpOccId;
	}

	public LcmCoord lcmOperationType(final LcmOperationForCoordType lcmOperationType) {
		this.lcmOperationType = lcmOperationType;
		return this;
	}

	/**
	 * Get lcmOperationType
	 *
	 * @return lcmOperationType
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public LcmOperationForCoordType getLcmOperationType() {
		return lcmOperationType;
	}

	public void setLcmOperationType(final LcmOperationForCoordType lcmOperationType) {
		this.lcmOperationType = lcmOperationType;
	}

	public LcmCoord coordinationActionName(final String coordinationActionName) {
		this.coordinationActionName = coordinationActionName;
		return this;
	}

	/**
	 * Get coordinationActionName
	 *
	 * @return coordinationActionName
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getCoordinationActionName() {
		return coordinationActionName;
	}

	public void setCoordinationActionName(final String coordinationActionName) {
		this.coordinationActionName = coordinationActionName;
	}

	public LcmCoord outputParams(final Map<String, String> outputParams) {
		this.outputParams = outputParams;
		return this;
	}

	/**
	 * Get outputParams
	 *
	 * @return outputParams
	 **/
	@Schema(description = "")

	@Valid
	public Map<String, String> getOutputParams() {
		return outputParams;
	}

	public void setOutputParams(final Map<String, String> outputParams) {
		this.outputParams = outputParams;
	}

	public LcmCoord warnings(final String warnings) {
		this.warnings = warnings;
		return this;
	}

	/**
	 * Get warnings
	 *
	 * @return warnings
	 **/
	@Schema(description = "")

	public String getWarnings() {
		return warnings;
	}

	public void setWarnings(final String warnings) {
		this.warnings = warnings;
	}

	public LcmCoord error(final ProblemDetails error) {
		this.error = error;
		return this;
	}

	/**
	 * Get error
	 *
	 * @return error
	 **/
	@Schema(description = "")

	@Valid
	public ProblemDetails getError() {
		return error;
	}

	public void setError(final ProblemDetails error) {
		this.error = error;
	}

	public LcmCoord _links(final LcmCoordLinks _links) {
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
	public LcmCoordLinks getLinks() {
		return _links;
	}

	public void setLinks(final LcmCoordLinks _links) {
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
		final LcmCoord lcmCoord = (LcmCoord) o;
		return Objects.equals(this.id, lcmCoord.id) &&
				Objects.equals(this.coordinationResult, lcmCoord.coordinationResult) &&
				Objects.equals(this.nsInstanceId, lcmCoord.nsInstanceId) &&
				Objects.equals(this.nsLcmOpOccId, lcmCoord.nsLcmOpOccId) &&
				Objects.equals(this.lcmOperationType, lcmCoord.lcmOperationType) &&
				Objects.equals(this.coordinationActionName, lcmCoord.coordinationActionName) &&
				Objects.equals(this.outputParams, lcmCoord.outputParams) &&
				Objects.equals(this.warnings, lcmCoord.warnings) &&
				Objects.equals(this.error, lcmCoord.error) &&
				Objects.equals(this._links, lcmCoord._links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, coordinationResult, nsInstanceId, nsLcmOpOccId, lcmOperationType, coordinationActionName, outputParams, warnings, error, _links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class LcmCoord {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    coordinationResult: ").append(toIndentedString(coordinationResult)).append("\n");
		sb.append("    nsInstanceId: ").append(toIndentedString(nsInstanceId)).append("\n");
		sb.append("    nsLcmOpOccId: ").append(toIndentedString(nsLcmOpOccId)).append("\n");
		sb.append("    lcmOperationType: ").append(toIndentedString(lcmOperationType)).append("\n");
		sb.append("    coordinationActionName: ").append(toIndentedString(coordinationActionName)).append("\n");
		sb.append("    outputParams: ").append(toIndentedString(outputParams)).append("\n");
		sb.append("    warnings: ").append(toIndentedString(warnings)).append("\n");
		sb.append("    error: ").append(toIndentedString(error)).append("\n");
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
