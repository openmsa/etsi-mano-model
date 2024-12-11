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
package com.ubiqube.etsi.mano.v271.model.em.vnflcm;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v271.model.vnfm.vnflcm.VimConnectionInfo;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;

/**
 * This type represents attribute modifications that were performed on an
 * \&quot;Individual VNF instance\&quot; resource. The attributes that can be
 * included consist of those requested to be modified explicitly in the
 * \&quot;VnfInfoModificationRequest\&quot; data structure, and additional
 * attributes of the \&quot;VnfInstance\&quot; data structure that were modified
 * implicitly e.g. when modifying the referenced VNF package.
 */
@Schema(description = "This type represents attribute modifications that were performed on an \"Individual VNF instance\" resource. The attributes that can be included consist of those requested to be modified explicitly in the \"VnfInfoModificationRequest\" data structure, and additional attributes of the \"VnfInstance\" data structure that were modified implicitly e.g. when modifying the referenced VNF package. ")
@Validated

public class VnfInfoModifications {
	@JsonProperty("vnfInstanceName")
	private String vnfInstanceName = null;

	@JsonProperty("vnfInstanceDescription")
	private String vnfInstanceDescription = null;

	@JsonProperty("vnfConfigurableProperties")
	private Map<String, String> vnfConfigurableProperties = null;

	@JsonProperty("metadata")
	private Map<String, String> metadata = null;

	@JsonProperty("extensions")
	private Map<String, String> extensions = null;

	@JsonProperty("vimConnectionInfo")
	private List<VimConnectionInfo> vimConnectionInfo = null;

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

	public VnfInfoModifications vnfInstanceName(final String vnfInstanceName) {
		this.vnfInstanceName = vnfInstanceName;
		return this;
	}

	/**
	 * If present, this attribute signals modifications of the \"vnfInstanceName\"
	 * attribute in \"VnfInstance\".
	 *
	 * @return vnfInstanceName
	 **/
	@Schema(description = "If present, this attribute signals modifications of the \"vnfInstanceName\" attribute in \"VnfInstance\". ")

	public String getVnfInstanceName() {
		return vnfInstanceName;
	}

	public void setVnfInstanceName(final String vnfInstanceName) {
		this.vnfInstanceName = vnfInstanceName;
	}

	public VnfInfoModifications vnfInstanceDescription(final String vnfInstanceDescription) {
		this.vnfInstanceDescription = vnfInstanceDescription;
		return this;
	}

	/**
	 * If present, this attribute signals modifications of the
	 * \"vnfInstanceDescription\" attribute in \"VnfInstance\".
	 *
	 * @return vnfInstanceDescription
	 **/
	@Schema(description = "If present, this attribute signals modifications of the \"vnfInstanceDescription\" attribute in \"VnfInstance\". ")

	public String getVnfInstanceDescription() {
		return vnfInstanceDescription;
	}

	public void setVnfInstanceDescription(final String vnfInstanceDescription) {
		this.vnfInstanceDescription = vnfInstanceDescription;
	}

	public VnfInfoModifications vnfConfigurableProperties(final Map<String, String> vnfConfigurableProperties) {
		this.vnfConfigurableProperties = vnfConfigurableProperties;
		return this;
	}

	/**
	 * If present, this attribute signals modifications of the
	 * \"vnfConfigurableProperties\" attribute in \"VnfInstance\".
	 *
	 * @return vnfConfigurableProperties
	 **/
	@Schema(description = "If present, this attribute signals modifications of the \"vnfConfigurableProperties\" attribute in \"VnfInstance\". ")

	@Valid

	public Map<String, String> getVnfConfigurableProperties() {
		return vnfConfigurableProperties;
	}

	public void setVnfConfigurableProperties(final Map<String, String> vnfConfigurableProperties) {
		this.vnfConfigurableProperties = vnfConfigurableProperties;
	}

	public VnfInfoModifications metadata(final Map<String, String> metadata) {
		this.metadata = metadata;
		return this;
	}

	/**
	 * If present, this attribute signals modifications of the \"metadata\"
	 * attribute in \"VnfInstance\".
	 *
	 * @return metadata
	 **/
	@Schema(description = "If present, this attribute signals modifications of the \"metadata\" attribute in \"VnfInstance\". ")

	@Valid

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public void setMetadata(final Map<String, String> metadata) {
		this.metadata = metadata;
	}

	public VnfInfoModifications extensions(final Map<String, String> extensions) {
		this.extensions = extensions;
		return this;
	}

	/**
	 * If present, this attribute signals modifications of the \"extensions\"
	 * attribute in \"VnfInstance\".
	 *
	 * @return extensions
	 **/
	@Schema(description = "If present, this attribute signals modifications of the \"extensions\" attribute in \"VnfInstance\". ")

	@Valid

	public Map<String, String> getExtensions() {
		return extensions;
	}

	public void setExtensions(final Map<String, String> extensions) {
		this.extensions = extensions;
	}

	public List<VimConnectionInfo> getVimConnectionInfo() {
		return vimConnectionInfo;
	}

	public void setVimConnectionInfo(final List<VimConnectionInfo> vimConnectionInfo) {
		this.vimConnectionInfo = vimConnectionInfo;
	}

	public VnfInfoModifications vnfdId(final String vnfdId) {
		this.vnfdId = vnfdId;
		return this;
	}

	/**
	 * If present, this attribute signals modifications of the \"vnfdId\" attribute
	 * in \"VnfInstance\".
	 *
	 * @return vnfdId
	 **/
	@Schema(description = "If present, this attribute signals modifications of the \"vnfdId\" attribute in \"VnfInstance\". ")

	public String getVnfdId() {
		return vnfdId;
	}

	public void setVnfdId(final String vnfdId) {
		this.vnfdId = vnfdId;
	}

	public VnfInfoModifications vnfProvider(final String vnfProvider) {
		this.vnfProvider = vnfProvider;
		return this;
	}

	/**
	 * If present, this attribute signals modifications of the \"vnfProvider\"
	 * attribute in \"VnfInstance\". If present, this attribute (which depends on
	 * the value of the \"vnfPkgId\" attribute) was modified implicitly following a
	 * request to modify the \"vnfPkgId\" attribute, by copying the value of this
	 * attribute from the VNFD in the VNF Package identified by the \"vnfPkgId”
	 * attribute.
	 *
	 * @return vnfProvider
	 **/
	@Schema(description = "If present, this attribute signals modifications of the \"vnfProvider\" attribute in \"VnfInstance\". If present, this attribute (which depends on the value of the \"vnfPkgId\" attribute) was modified implicitly following a request to modify the \"vnfPkgId\" attribute, by copying the value of this attribute from the VNFD in the VNF Package identified by the \"vnfPkgId” attribute. ")

	public String getVnfProvider() {
		return vnfProvider;
	}

	public void setVnfProvider(final String vnfProvider) {
		this.vnfProvider = vnfProvider;
	}

	public VnfInfoModifications vnfProductName(final String vnfProductName) {
		this.vnfProductName = vnfProductName;
		return this;
	}

	/**
	 * If present, this attribute signals modifications of the \"vnfProductName\"
	 * attribute in \"VnfInstance\". If present, this attribute (which depends on
	 * the value of the \"vnfPkgId\" attribute) was modified implicitly following a
	 * request to modify the \"vnfPkgId\" attribute, by copying the value of this
	 * attribute from the VNFD in the VNF Package identified by the \"vnfPkgId”
	 * attribute.
	 *
	 * @return vnfProductName
	 **/
	@Schema(description = "If present, this attribute signals modifications of the \"vnfProductName\" attribute in \"VnfInstance\". If present, this attribute (which depends on the value of the \"vnfPkgId\" attribute) was modified implicitly following a request to modify the \"vnfPkgId\" attribute, by copying the value of this attribute from the VNFD in the VNF Package identified by the \"vnfPkgId” attribute. ")

	public String getVnfProductName() {
		return vnfProductName;
	}

	public void setVnfProductName(final String vnfProductName) {
		this.vnfProductName = vnfProductName;
	}

	public VnfInfoModifications vnfSoftwareVersion(final String vnfSoftwareVersion) {
		this.vnfSoftwareVersion = vnfSoftwareVersion;
		return this;
	}

	/**
	 * If present, this attribute signals modifications of the
	 * \"vnfSoftwareVersion\" attribute in \"VnfInstance\".
	 *
	 * @return vnfSoftwareVersion
	 **/
	@Schema(description = "If present, this attribute signals modifications of the \"vnfSoftwareVersion\" attribute in \"VnfInstance\". ")

	public String getVnfSoftwareVersion() {
		return vnfSoftwareVersion;
	}

	public void setVnfSoftwareVersion(final String vnfSoftwareVersion) {
		this.vnfSoftwareVersion = vnfSoftwareVersion;
	}

	public VnfInfoModifications vnfdVersion(final String vnfdVersion) {
		this.vnfdVersion = vnfdVersion;
		return this;
	}

	/**
	 * If present, this attribute signals modifications of the \"vnfdVersion\"
	 * attribute in \"VnfInstance\". If present, this attribute (which depends on
	 * the value of the \"vnfdId\" attribute) was modified implicitly following a
	 * request to modify the \"vnfdId\" attribute, by copying the value of this
	 * attribute from the VNFD in the VNF Package identified by the \"vnfdId”
	 * attribute.
	 *
	 * @return vnfdVersion
	 **/
	@Schema(description = "If present, this attribute signals modifications of the \"vnfdVersion\" attribute in \"VnfInstance\". If present, this attribute (which depends on the value of the \"vnfdId\" attribute) was modified implicitly following a request to modify the \"vnfdId\" attribute, by copying the value of this attribute from the VNFD in the VNF Package identified by the \"vnfdId” attribute. ")

	public String getVnfdVersion() {
		return vnfdVersion;
	}

	public void setVnfdVersion(final String vnfdVersion) {
		this.vnfdVersion = vnfdVersion;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final VnfInfoModifications vnfInfoModifications = (VnfInfoModifications) o;
		return Objects.equals(this.vnfInstanceName, vnfInfoModifications.vnfInstanceName) &&
				Objects.equals(this.vnfInstanceDescription, vnfInfoModifications.vnfInstanceDescription) &&
				Objects.equals(this.vnfConfigurableProperties, vnfInfoModifications.vnfConfigurableProperties) &&
				Objects.equals(this.metadata, vnfInfoModifications.metadata) &&
				Objects.equals(this.extensions, vnfInfoModifications.extensions) &&
				Objects.equals(this.vnfdId, vnfInfoModifications.vnfdId) &&
				Objects.equals(this.vnfProvider, vnfInfoModifications.vnfProvider) &&
				Objects.equals(this.vnfProductName, vnfInfoModifications.vnfProductName) &&
				Objects.equals(this.vnfSoftwareVersion, vnfInfoModifications.vnfSoftwareVersion) &&
				Objects.equals(this.vnfdVersion, vnfInfoModifications.vnfdVersion);
	}

	@Override
	public int hashCode() {
		return Objects.hash(vnfInstanceName, vnfInstanceDescription, vnfConfigurableProperties, metadata, extensions, vnfdId, vnfProvider, vnfProductName, vnfSoftwareVersion, vnfdVersion);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class VnfInfoModifications {\n");

		sb.append("    vnfInstanceName: ").append(toIndentedString(vnfInstanceName)).append("\n");
		sb.append("    vnfInstanceDescription: ").append(toIndentedString(vnfInstanceDescription)).append("\n");
		sb.append("    vnfConfigurableProperties: ").append(toIndentedString(vnfConfigurableProperties)).append("\n");
		sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
		sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
		sb.append("    vnfdId: ").append(toIndentedString(vnfdId)).append("\n");
		sb.append("    vnfProvider: ").append(toIndentedString(vnfProvider)).append("\n");
		sb.append("    vnfProductName: ").append(toIndentedString(vnfProductName)).append("\n");
		sb.append("    vnfSoftwareVersion: ").append(toIndentedString(vnfSoftwareVersion)).append("\n");
		sb.append("    vnfdVersion: ").append(toIndentedString(vnfdVersion)).append("\n");
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
