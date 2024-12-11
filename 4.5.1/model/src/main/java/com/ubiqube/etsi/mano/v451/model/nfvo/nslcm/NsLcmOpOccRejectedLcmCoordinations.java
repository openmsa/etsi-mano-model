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
package com.ubiqube.etsi.mano.v451.model.nfvo.nslcm;

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
 * NsLcmOpOccRejectedLcmCoordinations
 */
@Validated

public class NsLcmOpOccRejectedLcmCoordinations {
	@JsonProperty("coordinationActionName")
	private String coordinationActionName = null;

	@JsonProperty("rejectionTime")
	private OffsetDateTime rejectionTime = null;

	/**
	 * The endpoint type used by this coordination action. Valid values: - MGMT:
	 * coordination with other operation supporting management systems (e.g.
	 * OSS/BSS)
	 */
	public enum EndpointTypeEnum {
		MGMT("MGMT"),
		VNF("VNF");

		private final String value;

		EndpointTypeEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static EndpointTypeEnum fromValue(final String text) {
			for (final EndpointTypeEnum b : EndpointTypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("endpointType")
	private EndpointTypeEnum endpointType = null;

	@JsonProperty("delay")
	private OffsetDateTime delay = null;

	public NsLcmOpOccRejectedLcmCoordinations coordinationActionName(final String coordinationActionName) {
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

	public NsLcmOpOccRejectedLcmCoordinations rejectionTime(final OffsetDateTime rejectionTime) {
		this.rejectionTime = rejectionTime;
		return this;
	}

	/**
	 * Get rejectionTime
	 *
	 * @return rejectionTime
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public OffsetDateTime getRejectionTime() {
		return rejectionTime;
	}

	public void setRejectionTime(final OffsetDateTime rejectionTime) {
		this.rejectionTime = rejectionTime;
	}

	public NsLcmOpOccRejectedLcmCoordinations endpointType(final EndpointTypeEnum endpointType) {
		this.endpointType = endpointType;
		return this;
	}

	/**
	 * The endpoint type used by this coordination action. Valid values: - MGMT:
	 * coordination with other operation supporting management systems (e.g.
	 * OSS/BSS)
	 *
	 * @return endpointType
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "The endpoint type used by this coordination action. Valid values: - MGMT: coordination with other operation supporting management systems (e.g. OSS/BSS) ")
	@NotNull

	public EndpointTypeEnum getEndpointType() {
		return endpointType;
	}

	public void setEndpointType(final EndpointTypeEnum endpointType) {
		this.endpointType = endpointType;
	}

	public NsLcmOpOccRejectedLcmCoordinations delay(final OffsetDateTime delay) {
		this.delay = delay;
		return this;
	}

	/**
	 * Get delay
	 *
	 * @return delay
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public OffsetDateTime getDelay() {
		return delay;
	}

	public void setDelay(final OffsetDateTime delay) {
		this.delay = delay;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final NsLcmOpOccRejectedLcmCoordinations nsLcmOpOccRejectedLcmCoordinations = (NsLcmOpOccRejectedLcmCoordinations) o;
		return Objects.equals(this.coordinationActionName, nsLcmOpOccRejectedLcmCoordinations.coordinationActionName) &&
				Objects.equals(this.rejectionTime, nsLcmOpOccRejectedLcmCoordinations.rejectionTime) &&
				Objects.equals(this.endpointType, nsLcmOpOccRejectedLcmCoordinations.endpointType) &&
				Objects.equals(this.delay, nsLcmOpOccRejectedLcmCoordinations.delay);
	}

	@Override
	public int hashCode() {
		return Objects.hash(coordinationActionName, rejectionTime, endpointType, delay);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class NsLcmOpOccRejectedLcmCoordinations {\n");

		sb.append("    coordinationActionName: ").append(toIndentedString(coordinationActionName)).append("\n");
		sb.append("    rejectionTime: ").append(toIndentedString(rejectionTime)).append("\n");
		sb.append("    endpointType: ").append(toIndentedString(endpointType)).append("\n");
		sb.append("    delay: ").append(toIndentedString(delay)).append("\n");
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
