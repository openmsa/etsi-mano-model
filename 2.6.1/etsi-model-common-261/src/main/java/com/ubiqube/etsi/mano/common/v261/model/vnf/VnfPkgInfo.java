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
package com.ubiqube.etsi.mano.common.v261.model.vnf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

/**
 * VnfPkgInfo
 */
@Validated
public class VnfPkgInfo {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("vnfdId")
	private String vnfdId = null;

	@JsonProperty("vnfProvider")
	private String vnfProvider = null;

	@JsonProperty("vnfProductName")
	private String vnfProductName = null;

	@JsonProperty("vnfSoftwareVersion")
	private String vnfSoftwareVersion = null;

	@JsonProperty("vnfdVersion")
	private String vnfdVersion = null;

	@JsonProperty("checksum")
	private Checksum checksum = null;

	@JsonProperty("softwareImages")
	@Valid
	private List<VnfPackageSoftwareImageInfo> softwareImages = null;

	@JsonProperty("additionalArtifacts")
	@Valid
	private List<VnfPackageArtifactInfo> additionalArtifacts = null;

	@JsonProperty("onboardingState")
	private PackageOnboardingStateType onboardingState = null;

	@JsonProperty("operationalState")
	private PackageOperationalStateType operationalState = null;

	@JsonProperty("usageState")
	private PackageUsageStateType usageState = null;

	@JsonProperty("userDefinedData")
	private Map<String, String> userDefinedData = null;

	@JsonProperty("_links")
	private VnfPkgInfoLinks links = null;

	public VnfPkgInfo id(final String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identifier of the VNF package. This identifier is allocated by the NFVO.
	 *
	 * @return id
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifier of the VNF package. This identifier is allocated by the NFVO. ")
	@NotNull

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public VnfPkgInfo vnfdId(final String vnfdId) {
		this.vnfdId = vnfdId;
		return this;
	}

	/**
	 * This identifier, which is managed by the VNF provider, identifies the VNF package and the VNFD in a globally unique way. It is copied from the VNFD of the on boarded VNF package. It shall be present after the VNF package content has been on-boarded and absent otherwise.
	 *
	 * @return vnfdId
	 **/
	@Schema(description = "This identifier, which is managed by the VNF provider, identifies the VNF package and the VNFD in a globally unique way. It is copied from the VNFD of the on boarded VNF package. It shall be present after the VNF package content has been on-boarded and absent otherwise. ")

	public String getVnfdId() {
		return vnfdId;
	}

	public void setVnfdId(final String vnfdId) {
		this.vnfdId = vnfdId;
	}

	public VnfPkgInfo vnfProvider(final String vnfProvider) {
		this.vnfProvider = vnfProvider;
		return this;
	}

	/**
	 * Provider of the VNF package and the VNFD. This information is copied from the VNFD. It shall be present after the VNF package content has been on-boarded and absent otherwise.
	 *
	 * @return vnfProvider
	 **/
	@Schema(description = "Provider of the VNF package and the VNFD. This information is copied from the VNFD.  It shall be present after the VNF package content has been on-boarded and absent otherwise. ")

	public String getVnfProvider() {
		return vnfProvider;
	}

	public void setVnfProvider(final String vnfProvider) {
		this.vnfProvider = vnfProvider;
	}

	public VnfPkgInfo vnfProductName(final String vnfProductName) {
		this.vnfProductName = vnfProductName;
		return this;
	}

	/**
	 * Name to identify the VNF product.Invariant for the VNF product lifetime. This information is copied from the VNFD. It shall be present after the VNF package content has been on-boarded and absent otherwise.
	 *
	 * @return vnfProductName
	 **/
	@Schema(description = "Name to identify the VNF product.Invariant for the VNF product lifetime.  This information is copied from the VNFD. It shall be present after the VNF package content has been on-boarded and absent otherwise. ")

	public String getVnfProductName() {
		return vnfProductName;
	}

	public void setVnfProductName(final String vnfProductName) {
		this.vnfProductName = vnfProductName;
	}

	public VnfPkgInfo vnfSoftwareVersion(final String vnfSoftwareVersion) {
		this.vnfSoftwareVersion = vnfSoftwareVersion;
		return this;
	}

	/**
	 * Software version of the VNF. This is changed when there is any change to the software included in the VNF package. This information is copied from the VNFD. It shall be present after the VNF package content has been on-boarded and absent otherwise.
	 *
	 * @return vnfSoftwareVersion
	 **/
	@Schema(description = "Software version of the VNF. This is changed when there is any change to the software included in the VNF package. This information is copied from the VNFD. It shall be present after the VNF package content has been on-boarded and absent otherwise. ")

	public String getVnfSoftwareVersion() {
		return vnfSoftwareVersion;
	}

	public void setVnfSoftwareVersion(final String vnfSoftwareVersion) {
		this.vnfSoftwareVersion = vnfSoftwareVersion;
	}

	public VnfPkgInfo vnfdVersion(final String vnfdVersion) {
		this.vnfdVersion = vnfdVersion;
		return this;
	}

	/**
	 * The version of the VNFD. This information is copied from the VNFD. It shall be present after the VNF package content has been on-boarded and absent otherwise.
	 *
	 * @return vnfdVersion
	 **/
	@Schema(description = "The version of the VNFD. This information is copied from the VNFD. It shall be present after the VNF package content has been on-boarded and absent otherwise. ")

	public String getVnfdVersion() {
		return vnfdVersion;
	}

	public void setVnfdVersion(final String vnfdVersion) {
		this.vnfdVersion = vnfdVersion;
	}

	public VnfPkgInfo checksum(final Checksum checksum) {
		this.checksum = checksum;
		return this;
	}

	/**
	 * Checksum of the on-boarded VNF package. It shall be present after the VNF package content has been on-boarded and absent otherwise.
	 *
	 * @return checksum
	 **/
	@Schema(description = "Checksum of the on-boarded VNF package. It shall be present after the VNF package content has been on-boarded and absent otherwise. ")

	@Valid

	public Checksum getChecksum() {
		return checksum;
	}

	public void setChecksum(final Checksum checksum) {
		this.checksum = checksum;
	}

	public VnfPkgInfo softwareImages(final List<VnfPackageSoftwareImageInfo> softwareImages) {
		this.softwareImages = softwareImages;
		return this;
	}

	public VnfPkgInfo addSoftwareImagesItem(final VnfPackageSoftwareImageInfo softwareImagesItem) {
		if (this.softwareImages == null) {
			this.softwareImages = new ArrayList<>();
		}
		this.softwareImages.add(softwareImagesItem);
		return this;
	}

	/**
	 * Information about VNF package artifacts that are software images. This attribute shall not be present before the VNF package content is on-boarded. Otherwise, this attribute shall be present unless it has been requested to be excluded per attribute selector.
	 *
	 * @return softwareImages
	 **/
	@Schema(description = "Information about VNF package artifacts that are software images. This attribute shall not be present before the VNF package content is on-boarded. Otherwise, this attribute shall be present unless it has been requested to be excluded per attribute selector. ")

	@Valid

	public List<VnfPackageSoftwareImageInfo> getSoftwareImages() {
		return softwareImages;
	}

	public void setSoftwareImages(final List<VnfPackageSoftwareImageInfo> softwareImages) {
		this.softwareImages = softwareImages;
	}

	public VnfPkgInfo additionalArtifacts(final List<VnfPackageArtifactInfo> additionalArtifacts) {
		this.additionalArtifacts = additionalArtifacts;
		return this;
	}

	public VnfPkgInfo addAdditionalArtifactsItem(final VnfPackageArtifactInfo additionalArtifactsItem) {
		if (this.additionalArtifacts == null) {
			this.additionalArtifacts = new ArrayList<>();
		}
		this.additionalArtifacts.add(additionalArtifactsItem);
		return this;
	}

	/**
	 * Information about VNF package artifacts contained in the VNF package that are not software images. This attribute shall not be present before the VNF package content is on-boarded. Otherwise, this attribute shall be present if the VNF package contains additional artifacts.
	 *
	 * @return additionalArtifacts
	 **/
	@Schema(description = "Information about VNF package artifacts contained in the VNF package that are not software images. This attribute shall not be present before the VNF package content is on-boarded. Otherwise, this attribute shall be present if the VNF package contains additional artifacts. ")

	@Valid

	public List<VnfPackageArtifactInfo> getAdditionalArtifacts() {
		return additionalArtifacts;
	}

	public void setAdditionalArtifacts(final List<VnfPackageArtifactInfo> additionalArtifacts) {
		this.additionalArtifacts = additionalArtifacts;
	}

	public VnfPkgInfo onboardingState(final PackageOnboardingStateType onboardingState) {
		this.onboardingState = onboardingState;
		return this;
	}

	/**
	 * On-boarding state of the VNF package.
	 *
	 * @return onboardingState
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "On-boarding state of the VNF package. ")
	@NotNull

	@Valid

	public PackageOnboardingStateType getOnboardingState() {
		return onboardingState;
	}

	public void setOnboardingState(final PackageOnboardingStateType onboardingState) {
		this.onboardingState = onboardingState;
	}

	public VnfPkgInfo operationalState(final PackageOperationalStateType operationalState) {
		this.operationalState = operationalState;
		return this;
	}

	/**
	 * Operational state of the VNF package.
	 *
	 * @return operationalState
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Operational state of the VNF package. ")
	@NotNull

	@Valid

	public PackageOperationalStateType getOperationalState() {
		return operationalState;
	}

	public void setOperationalState(final PackageOperationalStateType operationalState) {
		this.operationalState = operationalState;
	}

	public VnfPkgInfo usageState(final PackageUsageStateType usageState) {
		this.usageState = usageState;
		return this;
	}

	/**
	 * Usage state of the VNF package.
	 *
	 * @return usageState
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Usage state of the VNF package. ")
	@NotNull

	@Valid

	public PackageUsageStateType getUsageState() {
		return usageState;
	}

	public void setUsageState(final PackageUsageStateType usageState) {
		this.usageState = usageState;
	}

	public VnfPkgInfo userDefinedData(final Map<String, String> userDefinedData) {
		this.userDefinedData = userDefinedData;
		return this;
	}

	/**
	 * Usage state of the VNF package.
	 *
	 * @return userDefinedData
	 **/
	@Schema(description = "Usage state of the VNF package. ")

	@Valid

	public Map<String, String> getUserDefinedData() {
		return userDefinedData;
	}

	public void setUserDefinedData(final Map<String, String> userDefinedData) {
		this.userDefinedData = userDefinedData;
	}

	public VnfPkgInfo links(final VnfPkgInfoLinks links) {
		this.links = links;
		return this;
	}

	/**
	 * Get links
	 *
	 * @return links
	 **/
	@Schema(description = "")

	@Valid

	public VnfPkgInfoLinks getLinks() {
		return links;
	}

	public void setLinks(final VnfPkgInfoLinks links) {
		this.links = links;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final VnfPkgInfo vnfPkgInfo = (VnfPkgInfo) o;
		return Objects.equals(this.id, vnfPkgInfo.id) &&
				Objects.equals(this.vnfdId, vnfPkgInfo.vnfdId) &&
				Objects.equals(this.vnfProvider, vnfPkgInfo.vnfProvider) &&
				Objects.equals(this.vnfProductName, vnfPkgInfo.vnfProductName) &&
				Objects.equals(this.vnfSoftwareVersion, vnfPkgInfo.vnfSoftwareVersion) &&
				Objects.equals(this.vnfdVersion, vnfPkgInfo.vnfdVersion) &&
				Objects.equals(this.checksum, vnfPkgInfo.checksum) &&
				Objects.equals(this.softwareImages, vnfPkgInfo.softwareImages) &&
				Objects.equals(this.additionalArtifacts, vnfPkgInfo.additionalArtifacts) &&
				Objects.equals(this.onboardingState, vnfPkgInfo.onboardingState) &&
				Objects.equals(this.operationalState, vnfPkgInfo.operationalState) &&
				Objects.equals(this.usageState, vnfPkgInfo.usageState) &&
				Objects.equals(this.userDefinedData, vnfPkgInfo.userDefinedData) &&
				Objects.equals(this.links, vnfPkgInfo.links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, vnfdId, vnfProvider, vnfProductName, vnfSoftwareVersion, vnfdVersion, checksum, softwareImages, additionalArtifacts, onboardingState, operationalState, usageState, userDefinedData, links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class VnfPkgInfo {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    vnfdId: ").append(toIndentedString(vnfdId)).append("\n");
		sb.append("    vnfProvider: ").append(toIndentedString(vnfProvider)).append("\n");
		sb.append("    vnfProductName: ").append(toIndentedString(vnfProductName)).append("\n");
		sb.append("    vnfSoftwareVersion: ").append(toIndentedString(vnfSoftwareVersion)).append("\n");
		sb.append("    vnfdVersion: ").append(toIndentedString(vnfdVersion)).append("\n");
		sb.append("    checksum: ").append(toIndentedString(checksum)).append("\n");
		sb.append("    softwareImages: ").append(toIndentedString(softwareImages)).append("\n");
		sb.append("    additionalArtifacts: ").append(toIndentedString(additionalArtifacts)).append("\n");
		sb.append("    onboardingState: ").append(toIndentedString(onboardingState)).append("\n");
		sb.append("    operationalState: ").append(toIndentedString(operationalState)).append("\n");
		sb.append("    usageState: ").append(toIndentedString(usageState)).append("\n");
		sb.append("    userDefinedData: ").append(toIndentedString(userDefinedData)).append("\n");
		sb.append("    links: ").append(toIndentedString(links)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces (except the first line).
	 */
	private String toIndentedString(final java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
