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
package com.ubiqube.etsi.mano.v351.model.nfvo.nsd;

import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v351.model.nfvo.vnfsnapshotpkgm.Checksum;

import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

/**
 * This type represents an artifact contained in an NSD archive. It shall comply
 * with provisions defined in Table 5.5.3.5-1.
 */
@Schema(description = "This type represents an artifact contained in an NSD archive. It shall comply with provisions defined in Table 5.5.3.5-1. ")
@Validated

public class NsdArchiveArtifactInfo {
	@JsonProperty("artifactPath")
	private String artifactPath = null;

	@JsonProperty("checksum")
	private Checksum checksum = null;

	@JsonProperty("metadata")
	private Map<String, String> metadata = null;

	public NsdArchiveArtifactInfo artifactPath(final String artifactPath) {
		this.artifactPath = artifactPath;
		return this;
	}

	/**
	 * Get artifactPath
	 *
	 * @return artifactPath
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getArtifactPath() {
		return artifactPath;
	}

	public void setArtifactPath(final String artifactPath) {
		this.artifactPath = artifactPath;
	}

	public NsdArchiveArtifactInfo checksum(final Checksum checksum) {
		this.checksum = checksum;
		return this;
	}

	/**
	 * Get checksum
	 *
	 * @return checksum
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public Checksum getChecksum() {
		return checksum;
	}

	public void setChecksum(final Checksum checksum) {
		this.checksum = checksum;
	}

	public NsdArchiveArtifactInfo metadata(final Map<String, String> metadata) {
		this.metadata = metadata;
		return this;
	}

	/**
	 * Get metadata
	 *
	 * @return metadata
	 **/
	@Schema(description = "")

	@Valid
	public Map<String, String> getMetadata() {
		return metadata;
	}

	public void setMetadata(final Map<String, String> metadata) {
		this.metadata = metadata;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final NsdArchiveArtifactInfo nsdArchiveArtifactInfo = (NsdArchiveArtifactInfo) o;
		return Objects.equals(this.artifactPath, nsdArchiveArtifactInfo.artifactPath) &&
				Objects.equals(this.checksum, nsdArchiveArtifactInfo.checksum) &&
				Objects.equals(this.metadata, nsdArchiveArtifactInfo.metadata);
	}

	@Override
	public int hashCode() {
		return Objects.hash(artifactPath, checksum, metadata);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class NsdArchiveArtifactInfo {\n");

		sb.append("    artifactPath: ").append(toIndentedString(artifactPath)).append("\n");
		sb.append("    checksum: ").append(toIndentedString(checksum)).append("\n");
		sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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
