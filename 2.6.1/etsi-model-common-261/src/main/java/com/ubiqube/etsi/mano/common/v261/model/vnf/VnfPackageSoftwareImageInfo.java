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

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

/**
 * This type represents an artifact contained in a VNF package which represents
 * a software image.
 */
@Schema(description = "This type represents an artifact contained in a VNF package which represents a software image.   ")
@Validated
public class VnfPackageSoftwareImageInfo {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("provider")
	private String provider = null;

	@JsonProperty("version")
	private String version = null;

	@JsonProperty("checksum")
	private Checksum checksum = null;

	/**
	 * Container format indicates whether the software image is in a file format
	 * that also contains meta-data about the actual software. Permitted values: -
	 * AKI: a kernel image format - AMI: a machine image format - ARI: a ram disk
	 * image format - BARE: the image does not have a container or meta-data
	 * envelope - DOCKER: docker container format - OVA: OVF package in a tar file -
	 * OVF: OVF container format
	 */
	public enum ContainerFormatEnum {
		AKI("AKI"),

		AMI("AMI"),

		ARI("ARI"),

		BARE("BARE"),

		DOCKER("DOCKER"),
		HELM("DOCKER"),

		OVA("OVA"),

		OVF("OVF");

		private final String value;

		ContainerFormatEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static ContainerFormatEnum fromValue(final String text) {
			for (final ContainerFormatEnum b : ContainerFormatEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("containerFormat")
	private ContainerFormatEnum containerFormat = null;

	/**
	 * Disk format of a software image is the format of the underlying disk image.
	 * Permitted values: - AKI: a kernel image format - AMI: a machine image format
	 * - ARI: a ramdisk image format - ISO: an archive format for the data contents
	 * of an optical disc, such as CD-ROM - QCOW2: a common disk image format, which
	 * can expand dynamically and supports copy on write - RAW: an unstructured disk
	 * image format - VDI: a common disk image format - VHD: a common disk image
	 * format - VHDX: enhanced version of VHD format - VMDK: a common disk image
	 * format
	 */
	public enum DiskFormatEnum {
		AKI("AKI"),

		AMI("AMI"),

		ARI("ARI"),

		ISO("ISO"),

		QCOW2("QCOW2"),

		RAW("RAW"),

		VDI("VDI"),

		VHD("VHD"),

		VHDX("VHDX"),

		VMDK("VMDK");

		private final String value;

		DiskFormatEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static DiskFormatEnum fromValue(final String text) {
			for (final DiskFormatEnum b : DiskFormatEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("diskFormat")
	private DiskFormatEnum diskFormat = null;

	@JsonProperty("createdAt")
	private OffsetDateTime createdAt = null;

	@JsonProperty("minDisk")
	private Long minDisk = null;

	@JsonProperty("minRam")
	private Long minRam = null;

	@JsonProperty("size")
	private Long size = null;

	@JsonProperty("userMetadata")
	private Map<String, String> userMetadata = null;

	@JsonProperty("imagePath")
	private String imagePath = null;

	public VnfPackageSoftwareImageInfo id(final String id) {
		this.id = id;
		return this;
	}

	/**
	 * Name of the algorithm used to generate the checksum, as defined in ETSI GS
	 * NFV-SOL 004 [5]. For example, SHA-256, SHA-512.
	 *
	 * @return id
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Name of the algorithm used to generate the checksum, as defined in ETSI GS NFV-SOL 004 [5]. For example, SHA-256, SHA-512. ")
	@NotNull

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public VnfPackageSoftwareImageInfo name(final String name) {
		this.name = name;
		return this;
	}

	/**
	 * Name of the software image.
	 *
	 * @return name
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Name of the software image. ")
	@NotNull

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public VnfPackageSoftwareImageInfo provider(final String provider) {
		this.provider = provider;
		return this;
	}

	/**
	 * Provider of the software image.
	 *
	 * @return provider
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Provider of the software image. ")
	@NotNull

	public String getProvider() {
		return provider;
	}

	public void setProvider(final String provider) {
		this.provider = provider;
	}

	public VnfPackageSoftwareImageInfo version(final String version) {
		this.version = version;
		return this;
	}

	/**
	 * Version of the software image.
	 *
	 * @return version
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Version of the software image. ")
	@NotNull

	public String getVersion() {
		return version;
	}

	public void setVersion(final String version) {
		this.version = version;
	}

	public VnfPackageSoftwareImageInfo checksum(final Checksum checksum) {
		this.checksum = checksum;
		return this;
	}

	/**
	 * Checksum of the software image file.
	 *
	 * @return checksum
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Checksum of the software image file. ")
	@NotNull

	@Valid

	public Checksum getChecksum() {
		return checksum;
	}

	public void setChecksum(final Checksum checksum) {
		this.checksum = checksum;
	}

	public VnfPackageSoftwareImageInfo containerFormat(final ContainerFormatEnum containerFormat) {
		this.containerFormat = containerFormat;
		return this;
	}

	/**
	 * Container format indicates whether the software image is in a file format
	 * that also contains meta-data about the actual software. Permitted values: -
	 * AKI: a kernel image format - AMI: a machine image format - ARI: a ram disk
	 * image format - BARE: the image does not have a container or meta-data
	 * envelope - DOCKER: docker container format - OVA: OVF package in a tar file -
	 * OVF: OVF container format
	 *
	 * @return containerFormat
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Container format indicates whether the software image is in a file format that also contains meta-data about the actual software. Permitted values: - AKI: a kernel image format - AMI: a machine image format - ARI: a ram disk image format - BARE: the image does not have a container or meta-data envelope - DOCKER: docker container format - OVA: OVF package in a tar file - OVF: OVF container format ")
	@NotNull

	public ContainerFormatEnum getContainerFormat() {
		return containerFormat;
	}

	public void setContainerFormat(final ContainerFormatEnum containerFormat) {
		this.containerFormat = containerFormat;
	}

	public VnfPackageSoftwareImageInfo diskFormat(final DiskFormatEnum diskFormat) {
		this.diskFormat = diskFormat;
		return this;
	}

	/**
	 * Disk format of a software image is the format of the underlying disk image.
	 * Permitted values: - AKI: a kernel image format - AMI: a machine image format
	 * - ARI: a ramdisk image format - ISO: an archive format for the data contents
	 * of an optical disc, such as CD-ROM - QCOW2: a common disk image format, which
	 * can expand dynamically and supports copy on write - RAW: an unstructured disk
	 * image format - VDI: a common disk image format - VHD: a common disk image
	 * format - VHDX: enhanced version of VHD format - VMDK: a common disk image
	 * format
	 *
	 * @return diskFormat
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Disk format of a software image is the format of the underlying disk image. Permitted values: - AKI: a kernel image format - AMI: a machine image format - ARI: a ramdisk image format - ISO: an archive format for the data contents of an optical disc, such as CD-ROM - QCOW2: a common disk image format, which can expand dynamically and supports copy on write - RAW: an unstructured disk image format - VDI: a common disk image format - VHD: a common disk image format - VHDX: enhanced version of VHD format - VMDK: a common disk image format ")
	@NotNull

	public DiskFormatEnum getDiskFormat() {
		return diskFormat;
	}

	public void setDiskFormat(final DiskFormatEnum diskFormat) {
		this.diskFormat = diskFormat;
	}

	public VnfPackageSoftwareImageInfo createdAt(final OffsetDateTime createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	/**
	 * Time when this software image was created.
	 *
	 * @return createdAt
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Time when this software image was created. ")
	@NotNull

	@Valid

	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(final OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public VnfPackageSoftwareImageInfo minDisk(final Long minDisk) {
		this.minDisk = minDisk;
		return this;
	}

	/**
	 * The minimal disk for this software image in bytes. minimum: 0
	 *
	 * @return minDisk
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "The minimal disk for this software image in bytes. ")
	@NotNull

	@Min(0)
	public Long getMinDisk() {
		return minDisk;
	}

	public void setMinDisk(final Long minDisk) {
		this.minDisk = minDisk;
	}

	public VnfPackageSoftwareImageInfo minRam(final Long minRam) {
		this.minRam = minRam;
		return this;
	}

	/**
	 * The minimal RAM for this software image in bytes. minimum: 0
	 *
	 * @return minRam
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "The minimal RAM for this software image in bytes. ")
	@NotNull

	@Min(0)
	public Long getMinRam() {
		return minRam;
	}

	public void setMinRam(final Long minRam) {
		this.minRam = minRam;
	}

	public VnfPackageSoftwareImageInfo size(final Long size) {
		this.size = size;
		return this;
	}

	/**
	 * Size of this software image in bytes. minimum: 0
	 *
	 * @return size
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Size of this software image in bytes. ")
	@NotNull

	@Min(0)
	public Long getSize() {
		return size;
	}

	public void setSize(final Long size) {
		this.size = size;
	}

	public VnfPackageSoftwareImageInfo userMetadata(final Map<String, String> userMetadata) {
		this.userMetadata = userMetadata;
		return this;
	}

	/**
	 * User-defined data.
	 *
	 * @return userMetadata
	 **/
	@Schema(description = "User-defined data. ")

	@Valid

	public Map<String, String> getUserMetadata() {
		return userMetadata;
	}

	public void setUserMetadata(final Map<String, String> userMetadata) {
		this.userMetadata = userMetadata;
	}

	public VnfPackageSoftwareImageInfo imagePath(final String imagePath) {
		this.imagePath = imagePath;
		return this;
	}

	/**
	 * Path in the VNF package, which identifies the image artifact and also allows
	 * to access a copy of the image artifact.
	 *
	 * @return imagePath
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Path in the VNF package, which identifies the image artifact and also allows to access a copy of the image artifact. ")
	@NotNull

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(final String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final VnfPackageSoftwareImageInfo vnfPackageSoftwareImageInfo = (VnfPackageSoftwareImageInfo) o;
		return Objects.equals(this.id, vnfPackageSoftwareImageInfo.id) &&
				Objects.equals(this.name, vnfPackageSoftwareImageInfo.name) &&
				Objects.equals(this.provider, vnfPackageSoftwareImageInfo.provider) &&
				Objects.equals(this.version, vnfPackageSoftwareImageInfo.version) &&
				Objects.equals(this.checksum, vnfPackageSoftwareImageInfo.checksum) &&
				Objects.equals(this.containerFormat, vnfPackageSoftwareImageInfo.containerFormat) &&
				Objects.equals(this.diskFormat, vnfPackageSoftwareImageInfo.diskFormat) &&
				Objects.equals(this.createdAt, vnfPackageSoftwareImageInfo.createdAt) &&
				Objects.equals(this.minDisk, vnfPackageSoftwareImageInfo.minDisk) &&
				Objects.equals(this.minRam, vnfPackageSoftwareImageInfo.minRam) &&
				Objects.equals(this.size, vnfPackageSoftwareImageInfo.size) &&
				Objects.equals(this.userMetadata, vnfPackageSoftwareImageInfo.userMetadata) &&
				Objects.equals(this.imagePath, vnfPackageSoftwareImageInfo.imagePath);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, provider, version, checksum, containerFormat, diskFormat, createdAt, minDisk, minRam, size, userMetadata, imagePath);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class VnfPackageSoftwareImageInfo {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    provider: ").append(toIndentedString(provider)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    checksum: ").append(toIndentedString(checksum)).append("\n");
		sb.append("    containerFormat: ").append(toIndentedString(containerFormat)).append("\n");
		sb.append("    diskFormat: ").append(toIndentedString(diskFormat)).append("\n");
		sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
		sb.append("    minDisk: ").append(toIndentedString(minDisk)).append("\n");
		sb.append("    minRam: ").append(toIndentedString(minRam)).append("\n");
		sb.append("    size: ").append(toIndentedString(size)).append("\n");
		sb.append("    userMetadata: ").append(toIndentedString(userMetadata)).append("\n");
		sb.append("    imagePath: ").append(toIndentedString(imagePath)).append("\n");
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
