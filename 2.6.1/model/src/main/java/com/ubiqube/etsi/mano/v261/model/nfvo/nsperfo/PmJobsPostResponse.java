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
package com.ubiqube.etsi.mano.v261.model.nfvo.nsperfo;

import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

public class PmJobsPostResponse {

	@Schema(description = "")
	@Valid
	private PmJobsPmJob pmJob = null;

	/**
	 * Get pmJob
	 *
	 * @return pmJob
	 **/
	@JsonProperty("PmJob")
	public PmJobsPmJob getPmJob() {
		return pmJob;
	}

	public void setPmJob(final PmJobsPmJob pmJob) {
		this.pmJob = pmJob;
	}

	public PmJobsPostResponse pmJob(final PmJobsPmJob pmJob) {
		this.pmJob = pmJob;
		return this;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class PmJobsPostResponse {\n");

		sb.append("    pmJob: ").append(toIndentedString(pmJob)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces (except the first line).
	 */
	private static String toIndentedString(final Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
