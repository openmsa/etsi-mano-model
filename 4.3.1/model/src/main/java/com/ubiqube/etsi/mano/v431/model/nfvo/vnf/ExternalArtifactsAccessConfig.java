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
package com.ubiqube.etsi.mano.v431.model.nfvo.vnf;

import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;

/**
 * This type represents the access configuration information for downloading
 * external VNF package artifacts. The NFVO can obtain the external VNF package
 * artifact file through the information provided in this structure, together
 * with information provided in the manifest / VNFD. The data structure shall
 * comply with the provisions defined in Table 9.5.2.10-1. If the data structure
 * is part of a response body, security-sensitive attributes shall be excluded
 * as specified in Table 9.5.2.10-1.
 */
@Schema(description = "This type represents the access configuration information for downloading external VNF package artifacts. The NFVO can obtain the external VNF package artifact file through the information provided in this structure, together with information provided in the manifest / VNFD. The data structure shall comply with the provisions defined in Table 9.5.2.10-1. If the data structure is part of a response body, security-sensitive attributes shall be excluded as specified in Table 9.5.2.10-1. ")
@Validated

public class ExternalArtifactsAccessConfig {
	@JsonProperty("artifact")
	private List<ExternalArtifactsAccessConfigArtifact> artifact = null;

	public ExternalArtifactsAccessConfig artifact(final List<ExternalArtifactsAccessConfigArtifact> artifact) {
		this.artifact = artifact;
		return this;
	}

	/**
	 * Get artifact
	 *
	 * @return artifact
	 **/
	@Schema(description = "")

	@Valid
	public List<ExternalArtifactsAccessConfigArtifact> getArtifact() {
		return artifact;
	}

	public void setArtifact(final List<ExternalArtifactsAccessConfigArtifact> artifact) {
		this.artifact = artifact;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final ExternalArtifactsAccessConfig externalArtifactsAccessConfig = (ExternalArtifactsAccessConfig) o;
		return Objects.equals(this.artifact, externalArtifactsAccessConfig.artifact);
	}

	@Override
	public int hashCode() {
		return Objects.hash(artifact);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class ExternalArtifactsAccessConfig {\n");

		sb.append("    artifact: ").append(toIndentedString(artifact)).append("\n");
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
