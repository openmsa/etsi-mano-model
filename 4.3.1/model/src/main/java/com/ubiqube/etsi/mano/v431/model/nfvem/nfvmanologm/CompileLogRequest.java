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
package com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanologm;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanopm.ManoManagedObjectReference;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;

/**
 * This type represents a request to compile the logged data associated to an
 * object instance. It shall comply with the provisions defined in table
 * 8.6.2.8-1.
 */
@Schema(description = "This type represents a request to compile the logged data associated to an object instance. It shall comply with the provisions defined in table 8.6.2.8-1. ")
@Validated

public class CompileLogRequest {
	@JsonProperty("objectInstanceId")
	private ManoManagedObjectReference objectInstanceId = null;

	public CompileLogRequest objectInstanceId(final ManoManagedObjectReference objectInstanceId) {
		this.objectInstanceId = objectInstanceId;
		return this;
	}

	/**
	 * Get objectInstanceId
	 *
	 * @return objectInstanceId
	 **/
	@Schema(description = "")

	@Valid
	public ManoManagedObjectReference getObjectInstanceId() {
		return objectInstanceId;
	}

	public void setObjectInstanceId(final ManoManagedObjectReference objectInstanceId) {
		this.objectInstanceId = objectInstanceId;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final CompileLogRequest compileLogRequest = (CompileLogRequest) o;
		return Objects.equals(this.objectInstanceId, compileLogRequest.objectInstanceId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(objectInstanceId);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class CompileLogRequest {\n");

		sb.append("    objectInstanceId: ").append(toIndentedString(objectInstanceId)).append("\n");
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
