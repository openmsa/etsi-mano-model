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
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.Link;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Links to resources related to this request.
 */
@Schema(description = "Links to resources related to this request. ")
@Validated

public class LcmCoordRequestLinks {
	@JsonProperty("nsLcmOpOcc")
	private Link nsLcmOpOcc = null;

	@JsonProperty("nsInstance")
	private Link nsInstance = null;

	public LcmCoordRequestLinks nsLcmOpOcc(final Link nsLcmOpOcc) {
		this.nsLcmOpOcc = nsLcmOpOcc;
		return this;
	}

	/**
	 * Get nsLcmOpOcc
	 *
	 * @return nsLcmOpOcc
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public Link getNsLcmOpOcc() {
		return nsLcmOpOcc;
	}

	public void setNsLcmOpOcc(final Link nsLcmOpOcc) {
		this.nsLcmOpOcc = nsLcmOpOcc;
	}

	public LcmCoordRequestLinks nsInstance(final Link nsInstance) {
		this.nsInstance = nsInstance;
		return this;
	}

	/**
	 * Get nsInstance
	 *
	 * @return nsInstance
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public Link getNsInstance() {
		return nsInstance;
	}

	public void setNsInstance(final Link nsInstance) {
		this.nsInstance = nsInstance;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final LcmCoordRequestLinks lcmCoordRequestLinks = (LcmCoordRequestLinks) o;
		return Objects.equals(this.nsLcmOpOcc, lcmCoordRequestLinks.nsLcmOpOcc) &&
				Objects.equals(this.nsInstance, lcmCoordRequestLinks.nsInstance);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nsLcmOpOcc, nsInstance);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class LcmCoordRequestLinks {\n");

		sb.append("    nsLcmOpOcc: ").append(toIndentedString(nsLcmOpOcc)).append("\n");
		sb.append("    nsInstance: ").append(toIndentedString(nsInstance)).append("\n");
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
