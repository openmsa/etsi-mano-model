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
package com.ubiqube.etsi.mano.common.v261.model.nslcm;

import java.util.Objects;

import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

/**
 * VnfScaleInfo
 */
@Validated
public class VnfScaleInfo {
	@JsonProperty("aspectId")
	private String aspectId = null;

	@JsonProperty("scaleLevel")
	private Integer scaleLevel = null;

	public VnfScaleInfo aspectId(final String aspectId) {
		this.aspectId = aspectId;
		return this;
	}

	/**
	 * Identifier of the scaling aspect.
	 *
	 * @return aspectId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifier of the scaling aspect. ")
	@NotNull

	public String getAspectId() {
		return aspectId;
	}

	public void setAspectId(final String aspectId) {
		this.aspectId = aspectId;
	}

	public VnfScaleInfo scaleLevel(final Integer scaleLevel) {
		this.scaleLevel = scaleLevel;
		return this;
	}

	/**
	 * Indicates the scale level. The minimum value shall be 0 and the maximum value shall be {@literal <}= maxScaleLevel as described in the VNFD.
	 *
	 * @return scaleLevel
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Indicates the scale level. The minimum value shall be 0 and the maximum value shall be <= maxScaleLevel as described in the VNFD. ")
	@NotNull

	public Integer getScaleLevel() {
		return scaleLevel;
	}

	public void setScaleLevel(final Integer scaleLevel) {
		this.scaleLevel = scaleLevel;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final VnfScaleInfo vnfScaleInfo = (VnfScaleInfo) o;
		return Objects.equals(this.aspectId, vnfScaleInfo.aspectId) &&
				Objects.equals(this.scaleLevel, vnfScaleInfo.scaleLevel);
	}

	@Override
	public int hashCode() {
		return Objects.hash(aspectId, scaleLevel);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class VnfScaleInfo {\n");

		sb.append("    aspectId: ").append(toIndentedString(aspectId)).append("\n");
		sb.append("    scaleLevel: ").append(toIndentedString(scaleLevel)).append("\n");
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
