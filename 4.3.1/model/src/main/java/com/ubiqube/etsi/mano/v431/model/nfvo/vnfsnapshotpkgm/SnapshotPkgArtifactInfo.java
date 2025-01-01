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
package com.ubiqube.etsi.mano.v431.model.nfvo.vnfsnapshotpkgm;

import java.util.Map;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

/**
 * This type represents an artifact other than a software image which is
 * contained in a VNF snapshot package. It shall comply with provisions defined
 * in table 11.5.3.3-1.
 */
@Schema(description = "This type represents an artifact other than a software image which is contained in a VNF  snapshot package. It shall comply with provisions defined in table 11.5.3.3-1. ")
@Validated

public class SnapshotPkgArtifactInfo {
	@JsonProperty("artifactPath")
	private String artifactPath = null;

	@JsonProperty("artifactUri")
	private String artifactUri = null;

	@JsonProperty("checksum")
	private Checksum checksum = null;

	@JsonProperty("isEncrypted")
	private Boolean isEncrypted = null;

	@JsonProperty("metadata")
	private Map<String, String> metadata = null;

	public SnapshotPkgArtifactInfo artifactPath(final String artifactPath) {
		this.artifactPath = artifactPath;
		return this;
	}

	/**
	 * Path which identifies the artifact and also allows to access a copy of the
	 * artifact. For an artifact contained as a file in the VNF snapshot package,
	 * this attribute shall be present, and the value of this attribute shall start
	 * with the name of the first segment in the path in the package, i.e. it shall
	 * not be prefixed by path separator characters such as \".\" and \"/\".
	 * EXAMPLE: foo/bar/m%40ster.sh For an external artifact represented as a URI in
	 * the manifest file, this attribute shall be present if the artifact has been
	 * downloaded by the NFVO or the artifact has been processed after building the
	 * VNF snapshot package and shall be absent otherwise. If present, it shall
	 * contain the artifactPath under which the artifact can be obtained using the
	 * \"Individual artifact in a VNF snapshot package\" resource defined in clause
	 * 11.4.10. It is the responsibility of the NFVO to synthesize this path in a
	 * manner that avoids any collision of the synthesized artifact path with the
	 * paths and names of artifacts included in the snapshot package.
	 *
	 * @return artifactPath
	 **/
	@Schema(description = "Path which identifies the artifact and also allows to access a copy of the artifact. For an artifact contained as a file in the VNF snapshot package, this attribute shall be  present, and the value of this attribute shall start with the name of the first segment in  the path in the package, i.e. it shall not be prefixed by path separator characters such  as \".\" and \"/\". EXAMPLE: foo/bar/m%40ster.sh For an external artifact represented as a URI in the manifest file, this attribute shall  be present if the artifact has been downloaded by the NFVO or the artifact has been  processed after building the VNF snapshot package and shall be absent otherwise. If present,  it shall contain the artifactPath under which the artifact can be obtained using the  \"Individual artifact in a VNF snapshot package\" resource defined in clause 11.4.10. It is  the responsibility of the NFVO to synthesize this path in a manner that avoids any  collision of the synthesized artifact path with the paths and names of artifacts included  in the snapshot package. ")

	public String getArtifactPath() {
		return artifactPath;
	}

	public void setArtifactPath(final String artifactPath) {
		this.artifactPath = artifactPath;
	}

	public SnapshotPkgArtifactInfo artifactUri(final String artifactUri) {
		this.artifactUri = artifactUri;
		return this;
	}

	/**
	 * Get artifactUri
	 *
	 * @return artifactUri
	 **/
	@Schema(description = "")

	public String getArtifactUri() {
		return artifactUri;
	}

	public void setArtifactUri(final String artifactUri) {
		this.artifactUri = artifactUri;
	}

	public SnapshotPkgArtifactInfo checksum(final Checksum checksum) {
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

	public SnapshotPkgArtifactInfo isEncrypted(final Boolean isEncrypted) {
		this.isEncrypted = isEncrypted;
		return this;
	}

	/**
	 * Get isEncrypted
	 *
	 * @return isEncrypted
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public Boolean getIsEncrypted() {
		return isEncrypted;
	}

	public void setIsEncrypted(final Boolean isEncrypted) {
		this.isEncrypted = isEncrypted;
	}

	public SnapshotPkgArtifactInfo metadata(final Map<String, String> metadata) {
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
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final SnapshotPkgArtifactInfo snapshotPkgArtifactInfo = (SnapshotPkgArtifactInfo) o;
		return Objects.equals(this.artifactPath, snapshotPkgArtifactInfo.artifactPath) &&
				Objects.equals(this.artifactUri, snapshotPkgArtifactInfo.artifactUri) &&
				Objects.equals(this.checksum, snapshotPkgArtifactInfo.checksum) &&
				Objects.equals(this.isEncrypted, snapshotPkgArtifactInfo.isEncrypted) &&
				Objects.equals(this.metadata, snapshotPkgArtifactInfo.metadata);
	}

	@Override
	public int hashCode() {
		return Objects.hash(artifactPath, artifactUri, checksum, isEncrypted, metadata);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class SnapshotPkgArtifactInfo {\n");

		sb.append("    artifactPath: ").append(toIndentedString(artifactPath)).append("\n");
		sb.append("    artifactUri: ").append(toIndentedString(artifactUri)).append("\n");
		sb.append("    checksum: ").append(toIndentedString(checksum)).append("\n");
		sb.append("    isEncrypted: ").append(toIndentedString(isEncrypted)).append("\n");
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
