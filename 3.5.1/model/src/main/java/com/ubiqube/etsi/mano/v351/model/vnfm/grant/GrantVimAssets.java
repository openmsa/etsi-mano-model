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
package com.ubiqube.etsi.mano.v351.model.vnfm.grant;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v351.model.vnfm.grant.VimComputeResourceFlavour;
import com.ubiqube.etsi.mano.v351.model.vnfm.grant.VimSnapshotResource;
import com.ubiqube.etsi.mano.v351.model.vnfm.grant.VimSoftwareImage;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Information about assets for the VNF that are managed by the NFVO in the VIM,  such as software images and virtualised compute resource flavours. See note 3. 
 */
@Schema(description = "Information about assets for the VNF that are managed by the NFVO in the VIM,  such as software images and virtualised compute resource flavours. See note 3. ")
@Validated


public class GrantVimAssets   {
  @JsonProperty("computeResourceFlavours")
  @Valid
  private List<VimComputeResourceFlavour> computeResourceFlavours = null;

  @JsonProperty("softwareImages")
  @Valid
  private List<VimSoftwareImage> softwareImages = null;

  @JsonProperty("snapshotResources")
  @Valid
  private List<VimSnapshotResource> snapshotResources = null;

  public GrantVimAssets computeResourceFlavours(List<VimComputeResourceFlavour> computeResourceFlavours) {
    this.computeResourceFlavours = computeResourceFlavours;
    return this;
  }

  public GrantVimAssets addComputeResourceFlavoursItem(VimComputeResourceFlavour computeResourceFlavoursItem) {
    if (this.computeResourceFlavours == null) {
      this.computeResourceFlavours = new ArrayList<>();
    }
    this.computeResourceFlavours.add(computeResourceFlavoursItem);
    return this;
  }

  /**
   * Mappings between virtual compute descriptors defined in the VNFD and compute resource flavours managed in the VIM. 
   * @return computeResourceFlavours
   **/
  @Schema(description = "Mappings between virtual compute descriptors defined in the VNFD and compute resource flavours managed in the VIM. ")
      @Valid
    public List<VimComputeResourceFlavour> getComputeResourceFlavours() {
    return computeResourceFlavours;
  }

  public void setComputeResourceFlavours(List<VimComputeResourceFlavour> computeResourceFlavours) {
    this.computeResourceFlavours = computeResourceFlavours;
  }

  public GrantVimAssets softwareImages(List<VimSoftwareImage> softwareImages) {
    this.softwareImages = softwareImages;
    return this;
  }

  public GrantVimAssets addSoftwareImagesItem(VimSoftwareImage softwareImagesItem) {
    if (this.softwareImages == null) {
      this.softwareImages = new ArrayList<>();
    }
    this.softwareImages.add(softwareImagesItem);
    return this;
  }

  /**
   * Mappings between software images defined in the VNFD and software images managed in the VIM. 
   * @return softwareImages
   **/
  @Schema(description = "Mappings between software images defined in the VNFD and software images managed in the VIM. ")
      @Valid
    public List<VimSoftwareImage> getSoftwareImages() {
    return softwareImages;
  }

  public void setSoftwareImages(List<VimSoftwareImage> softwareImages) {
    this.softwareImages = softwareImages;
  }

  public GrantVimAssets snapshotResources(List<VimSnapshotResource> snapshotResources) {
    this.snapshotResources = snapshotResources;
    return this;
  }

  public GrantVimAssets addSnapshotResourcesItem(VimSnapshotResource snapshotResourcesItem) {
    if (this.snapshotResources == null) {
      this.snapshotResources = new ArrayList<>();
    }
    this.snapshotResources.add(snapshotResourcesItem);
    return this;
  }

  /**
   * Mappings between snapshot resources defined in the VNF snapshot package and resources managed in the VIM. 
   * @return snapshotResources
   **/
  @Schema(description = "Mappings between snapshot resources defined in the VNF snapshot package and resources managed in the VIM. ")
      @Valid
    public List<VimSnapshotResource> getSnapshotResources() {
    return snapshotResources;
  }

  public void setSnapshotResources(List<VimSnapshotResource> snapshotResources) {
    this.snapshotResources = snapshotResources;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GrantVimAssets grantVimAssets = (GrantVimAssets) o;
    return Objects.equals(this.computeResourceFlavours, grantVimAssets.computeResourceFlavours) &&
        Objects.equals(this.softwareImages, grantVimAssets.softwareImages) &&
        Objects.equals(this.snapshotResources, grantVimAssets.snapshotResources);
  }

  @Override
  public int hashCode() {
    return Objects.hash(computeResourceFlavours, softwareImages, snapshotResources);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GrantVimAssets {\n");
    
    sb.append("    computeResourceFlavours: ").append(toIndentedString(computeResourceFlavours)).append("\n");
    sb.append("    softwareImages: ").append(toIndentedString(softwareImages)).append("\n");
    sb.append("    snapshotResources: ").append(toIndentedString(snapshotResources)).append("\n");
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
