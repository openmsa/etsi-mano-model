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
package com.ubiqube.etsi.mano.v261.model.nfvo.lcmgrant;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.common.v261.model.Link;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.annotation.Nonnull;
import jakarta.validation.Valid;

/**
 * Links to resources related to this request.
 */
@Schema(description = "Links to resources related to this request. ")
@Validated

public class GrantRequestLinks {
	@JsonProperty("vnfLcmOpOcc")
	private Link vnfLcmOpOcc = null;

	@JsonProperty("vnfInstance")
	private Link vnfInstance = null;

	public GrantRequestLinks vnfLcmOpOcc(final Link vnfLcmOpOcc) {
		this.vnfLcmOpOcc = vnfLcmOpOcc;
		return this;
	}

	/**
	 * Related lifecycle management operation occurrence.
	 *
	 * @return vnfLcmOpOcc
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Related lifecycle management operation occurrence. ")
	@Nonnull

	@Valid

	public Link getVnfLcmOpOcc() {
		return vnfLcmOpOcc;
	}

	public void setVnfLcmOpOcc(final Link vnfLcmOpOcc) {
		this.vnfLcmOpOcc = vnfLcmOpOcc;
	}

	public GrantRequestLinks vnfInstance(final Link vnfInstance) {
		this.vnfInstance = vnfInstance;
		return this;
	}

	/**
	 * Related VNF instance.
	 *
	 * @return vnfInstance
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Related VNF instance. ")
	@Nonnull

	@Valid

	public Link getVnfInstance() {
		return vnfInstance;
	}

	public void setVnfInstance(final Link vnfInstance) {
		this.vnfInstance = vnfInstance;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final GrantRequestLinks grantRequestLinks = (GrantRequestLinks) o;
		return Objects.equals(this.vnfLcmOpOcc, grantRequestLinks.vnfLcmOpOcc) &&
				Objects.equals(this.vnfInstance, grantRequestLinks.vnfInstance);
	}

	@Override
	public int hashCode() {
		return Objects.hash(vnfLcmOpOcc, vnfInstance);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class GrantRequestLinks {\n");

		sb.append("    vnfLcmOpOcc: ").append(toIndentedString(vnfLcmOpOcc)).append("\n");
		sb.append("    vnfInstance: ").append(toIndentedString(vnfInstance)).append("\n");
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
