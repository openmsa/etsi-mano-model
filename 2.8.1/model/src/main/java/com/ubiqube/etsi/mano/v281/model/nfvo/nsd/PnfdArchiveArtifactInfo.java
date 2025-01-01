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
package com.ubiqube.etsi.mano.v281.model.nfvo.nsd;

import java.util.Map;
import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v281.model.nfvo.vnf.Checksum;

/**
 * This type represents an artifact contained in a PNFD archive. It shall comply
 * with provisions defined in Table 5.5.3.6-1.
 */
@Schema (description= "This type represents an artifact contained in a PNFD archive. It shall comply with provisions defined in Table 5.5.3.6-1. " )
@Validated

public class PnfdArchiveArtifactInfo {
	@JsonProperty("artifactPath")
	private String artifactPath = null;

	@JsonProperty("checksum")
	private Checksum checksum = null;

	@JsonProperty("nonManoArtifactSetId")
	private String nonManoArtifactSetId = null;

	@JsonProperty("metadata")
	private Map<String, String> metadata = null;

  public PnfdArchiveArtifactInfo artifactPath(final String artifactPath) {
    this.artifactPath = artifactPath;
    return this;
  }

  /**
   * Path in the PNFD archive, which identifies the artifact and also allows to
   * access a copy of the artifact.
   *
   * @return artifactPath
   **/
  @Schema(required = true , description = "Path in the PNFD archive, which identifies the artifact and also allows to access a copy of the artifact. ")
  @NotNull

  public String getArtifactPath() {
    return artifactPath;
  }

  public void setArtifactPath(final String artifactPath) {
    this.artifactPath = artifactPath;
  }

  public PnfdArchiveArtifactInfo checksum(final Checksum checksum) {
    this.checksum = checksum;
    return this;
  }

  /**
   * Checksum of the artifact file.
   *
   * @return checksum
   **/
  @Schema(required = true , description = "Checksum of the artifact file. ")
  @NotNull

  @Valid

  public Checksum getChecksum() {
    return checksum;
  }

  public void setChecksum(final Checksum checksum) {
    this.checksum = checksum;
  }

  public PnfdArchiveArtifactInfo nonManoArtifactSetId(final String nonManoArtifactSetId) {
    this.nonManoArtifactSetId = nonManoArtifactSetId;
    return this;
  }

  /**
   * Non-MANO artifact set identifier of the non-MANO artifact set to which the
   * artifact belongs, as defined in clause 4.3.7 of ETSI GS NFV-SOL 004. Shall be
   * provided if the artifact is a non-MANO artifact, and shall be omitted
   * otherwise.
   *
   * @return nonManoArtifactSetId
   **/
  @Schema(description = "Non-MANO artifact set identifier of the non-MANO artifact set to which the artifact belongs, as defined in clause 4.3.7 of ETSI GS NFV-SOL 004. Shall be provided if the artifact is a non-MANO artifact, and shall be omitted otherwise. ")

  public String getNonManoArtifactSetId() {
    return nonManoArtifactSetId;
  }

  public void setNonManoArtifactSetId(final String nonManoArtifactSetId) {
    this.nonManoArtifactSetId = nonManoArtifactSetId;
  }

  public PnfdArchiveArtifactInfo metadata(final Map<String, String> metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * The metadata of the artifact that are available in the PNFD Archive, such as
   * Content type, size, creation date, etc.
   *
   * @return metadata
   **/
  @Schema(description = "The metadata of the artifact that are available in the PNFD Archive, such as Content type, size, creation date, etc. ")

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
    final PnfdArchiveArtifactInfo pnfdArchiveArtifactInfo = (PnfdArchiveArtifactInfo) o;
    return Objects.equals(this.artifactPath, pnfdArchiveArtifactInfo.artifactPath) &&
    Objects.equals(this.checksum, pnfdArchiveArtifactInfo.checksum) &&
    Objects.equals(this.nonManoArtifactSetId, pnfdArchiveArtifactInfo.nonManoArtifactSetId) &&
    Objects.equals(this.metadata, pnfdArchiveArtifactInfo.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(artifactPath, checksum, nonManoArtifactSetId, metadata);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("class PnfdArchiveArtifactInfo {\n");

    sb.append("    artifactPath: ").append(toIndentedString(artifactPath)).append("\n");
    sb.append("    checksum: ").append(toIndentedString(checksum)).append("\n");
    sb.append("    nonManoArtifactSetId: ").append(toIndentedString(nonManoArtifactSetId)).append("\n");
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
