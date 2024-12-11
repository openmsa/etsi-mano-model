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
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.ubiqube.etsi.mano.v281.model.nfvo.vnf;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ubiqube.etsi.mano.v281.model.nfvo.vnf.Checksum;

import java.util.Map;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents an artifact other than a software image which is contained in or external to a VNF package.  It shall comply with provisions defined in Table 9.5.3.3-1. 
 */
@Schema (description= "This type represents an artifact other than a software image which is contained in or external to a VNF package.  It shall comply with provisions defined in Table 9.5.3.3-1. " )
@Validated

public class VnfPackageArtifactInfo   {
  @JsonProperty("artifactPath")
  private String artifactPath = null;

  @JsonProperty("artifactURI")
  private String artifactURI = null;

  @JsonProperty("checksum")
  private Checksum checksum = null;

  @JsonProperty("isEncrypted")
  private Boolean isEncrypted = null;

  @JsonProperty("nonManoArtifactSetId")
  private String nonManoArtifactSetId = null;

  /**
   * Marks specific types of artifacts as defined in the VNF package. If none of the specific classes listed below applies, the attribute shall not be present. Valid values: - HISTORY: a history artifact as per clause 4.3.3 in ETSI GS NFV-SOL 004 [5] - TESTING: a testing artifact as per clause 4.3.4 in ETSI GS NFV-SOL 004 [5] - LICENSE: a license artifact as per clause 4.3.5 in ETSI GS NFV-SOL 004 [5] 
   */
  public enum ArtifactClassificationEnum {
    HISTORY("HISTORY"),
    
    TESTING("TESTING"),
    
    LICENSE("LICENSE");

    private String value;

    ArtifactClassificationEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ArtifactClassificationEnum fromValue(String text) {
      for (ArtifactClassificationEnum b : ArtifactClassificationEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("artifactClassification")
  private ArtifactClassificationEnum artifactClassification = null;

  @JsonProperty("metadata")
  private Map<String, String> metadata = null;

  public VnfPackageArtifactInfo artifactPath(String artifactPath) {
    this.artifactPath = artifactPath;
    return this;
  }

  /**
   * Path which identifies the artifact and also allows to access a copy of the artifact. For an artifact contained as a file in the VNF package, this attribute shall be present, and the value of this attribute shall start with the name of the first segment in the path in the package, i.e. it shall not be prefixed by path separator characters such as \".\" and \"/\". EXAMPLE: foo/bar/m@ster.sh For an external artifact represented as a URI in the VNF descriptor, this attribute shall be present if the artifact has been downloaded by the NFVO and shall be absent otherwise. If present, it shall contain the artifactPath under which the artifact can be obtained using the \"Individual artifact in a VNF package\" resource defined in clause 9.4.7. It is the responsibility of the NFVO to synthesize this path in a manner that avoids any collision of the synthesized artifact path with the paths and names of artifacts included in the package. 
   * @return artifactPath
  **/
  @Schema(description = "Path which identifies the artifact and also allows to access a copy of the artifact. For an artifact contained as a file in the VNF package, this attribute shall be present, and the value of this attribute shall start with the name of the first segment in the path in the package, i.e. it shall not be prefixed by path separator characters such as \".\" and \"/\". EXAMPLE: foo/bar/m@ster.sh For an external artifact represented as a URI in the VNF descriptor, this attribute shall be present if the artifact has been downloaded by the NFVO and shall be absent otherwise. If present, it shall contain the artifactPath under which the artifact can be obtained using the \"Individual artifact in a VNF package\" resource defined in clause 9.4.7. It is the responsibility of the NFVO to synthesize this path in a manner that avoids any collision of the synthesized artifact path with the paths and names of artifacts included in the package. ")


  public String getArtifactPath() {
    return artifactPath;
  }

  public void setArtifactPath(String artifactPath) {
    this.artifactPath = artifactPath;
  }

  public VnfPackageArtifactInfo artifactURI(String artifactURI) {
    this.artifactURI = artifactURI;
    return this;
  }

  /**
   * URI of the artifact as defined in the VNF package manifest. Shall be present if the artifact is external to the package and shall be absent otherwise. EXAMPLE: https://example.com/m%40ster.sh 
   * @return artifactURI
  **/
  @Schema(description = "URI of the artifact as defined in the VNF package manifest. Shall be present if the artifact is external to the package and shall be absent otherwise. EXAMPLE: https://example.com/m%40ster.sh ")


  public String getArtifactURI() {
    return artifactURI;
  }

  public void setArtifactURI(String artifactURI) {
    this.artifactURI = artifactURI;
  }

  public VnfPackageArtifactInfo checksum(Checksum checksum) {
    this.checksum = checksum;
    return this;
  }

  /**
   * Checksum of the artifact file. 
   * @return checksum
  **/
  @Schema(required = true , description = "Checksum of the artifact file. ")
  @NotNull

  @Valid

  public Checksum getChecksum() {
    return checksum;
  }

  public void setChecksum(Checksum checksum) {
    this.checksum = checksum;
  }

  public VnfPackageArtifactInfo isEncrypted(Boolean isEncrypted) {
    this.isEncrypted = isEncrypted;
    return this;
  }

  /**
   * Reflects whether the artifact is encrypted (true) or not (false). 
   * @return isEncrypted
  **/
  @Schema(required = true , description = "Reflects whether the artifact is encrypted (true) or not (false). ")
  @NotNull


  public Boolean isIsEncrypted() {
    return isEncrypted;
  }

  public void setIsEncrypted(Boolean isEncrypted) {
    this.isEncrypted = isEncrypted;
  }

  public VnfPackageArtifactInfo nonManoArtifactSetId(String nonManoArtifactSetId) {
    this.nonManoArtifactSetId = nonManoArtifactSetId;
    return this;
  }

  /**
   * Non-MANO artifact set identifier of the non-MANO artifact set to which the artifact belongs, as defined in clause 4.3.7 of ETSI GS NFV-SOL 004 [5]. Shall be provided if the artifact is a non-MANO artifact, and shall be omitted otherwise. 
   * @return nonManoArtifactSetId
  **/
  @Schema(description = "Non-MANO artifact set identifier of the non-MANO artifact set to which the artifact belongs, as defined in clause 4.3.7 of ETSI GS NFV-SOL 004 [5]. Shall be provided if the artifact is a non-MANO artifact, and shall be omitted otherwise. ")


  public String getNonManoArtifactSetId() {
    return nonManoArtifactSetId;
  }

  public void setNonManoArtifactSetId(String nonManoArtifactSetId) {
    this.nonManoArtifactSetId = nonManoArtifactSetId;
  }

  public VnfPackageArtifactInfo artifactClassification(ArtifactClassificationEnum artifactClassification) {
    this.artifactClassification = artifactClassification;
    return this;
  }

  /**
   * Marks specific types of artifacts as defined in the VNF package. If none of the specific classes listed below applies, the attribute shall not be present. Valid values: - HISTORY: a history artifact as per clause 4.3.3 in ETSI GS NFV-SOL 004 [5] - TESTING: a testing artifact as per clause 4.3.4 in ETSI GS NFV-SOL 004 [5] - LICENSE: a license artifact as per clause 4.3.5 in ETSI GS NFV-SOL 004 [5] 
   * @return artifactClassification
  **/
  @Schema(description = "Marks specific types of artifacts as defined in the VNF package. If none of the specific classes listed below applies, the attribute shall not be present. Valid values: - HISTORY: a history artifact as per clause 4.3.3 in ETSI GS NFV-SOL 004 [5] - TESTING: a testing artifact as per clause 4.3.4 in ETSI GS NFV-SOL 004 [5] - LICENSE: a license artifact as per clause 4.3.5 in ETSI GS NFV-SOL 004 [5] ")


  public ArtifactClassificationEnum getArtifactClassification() {
    return artifactClassification;
  }

  public void setArtifactClassification(ArtifactClassificationEnum artifactClassification) {
    this.artifactClassification = artifactClassification;
  }

  public VnfPackageArtifactInfo metadata(Map<String, String> metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * The metadata of the artifact that are available in the VNF package, such as Content type, size, creation date, etc. 
   * @return metadata
  **/
  @Schema(description = "The metadata of the artifact that are available in the VNF package, such as Content type, size, creation date, etc. ")

  @Valid

  public Map<String, String> getMetadata() {
    return metadata;
  }

  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VnfPackageArtifactInfo vnfPackageArtifactInfo = (VnfPackageArtifactInfo) o;
    return Objects.equals(this.artifactPath, vnfPackageArtifactInfo.artifactPath) &&
    Objects.equals(this.artifactURI, vnfPackageArtifactInfo.artifactURI) &&
    Objects.equals(this.checksum, vnfPackageArtifactInfo.checksum) &&
    Objects.equals(this.isEncrypted, vnfPackageArtifactInfo.isEncrypted) &&
    Objects.equals(this.nonManoArtifactSetId, vnfPackageArtifactInfo.nonManoArtifactSetId) &&
    Objects.equals(this.artifactClassification, vnfPackageArtifactInfo.artifactClassification) &&
    Objects.equals(this.metadata, vnfPackageArtifactInfo.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(artifactPath, artifactURI, checksum, isEncrypted, nonManoArtifactSetId, artifactClassification, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VnfPackageArtifactInfo {\n");

    sb.append("    artifactPath: ").append(toIndentedString(artifactPath)).append("\n");
    sb.append("    artifactURI: ").append(toIndentedString(artifactURI)).append("\n");
    sb.append("    checksum: ").append(toIndentedString(checksum)).append("\n");
    sb.append("    isEncrypted: ").append(toIndentedString(isEncrypted)).append("\n");
    sb.append("    nonManoArtifactSetId: ").append(toIndentedString(nonManoArtifactSetId)).append("\n");
    sb.append("    artifactClassification: ").append(toIndentedString(artifactClassification)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

