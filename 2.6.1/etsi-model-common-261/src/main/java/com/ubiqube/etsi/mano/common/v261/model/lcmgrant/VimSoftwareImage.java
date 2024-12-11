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
package com.ubiqube.etsi.mano.common.v261.model.lcmgrant;

import java.util.Objects;

import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;


/**
 * This type contains a mapping between a software image definition the VNFD and
 * the corresponding software image managed by the NFVO in the VIM which is
 * needed during compute resource instantiation.
 */
@Schema(description = "This type contains a mapping between a software image definition the VNFD and the corresponding software image managed by the NFVO in the VIM which is needed during compute resource instantiation. ")
@Validated
public class VimSoftwareImage {
	@JsonProperty("vimConnectionId")
	private String vimConnectionId = null;

	@JsonProperty("resourceProviderId")
	private String resourceProviderId = null;

	@JsonProperty("vnfdSoftwareImageId")
	private String vnfdSoftwareImageId = null;

	@JsonProperty("vimSoftwareImageId")
	private String vimSoftwareImageId = null;

	public VimSoftwareImage vimConnectionId(final String vimConnectionId) {
		this.vimConnectionId = vimConnectionId;
		return this;
	}

	/**
	 * Identifier of the VIM connection to access the software image referenced in
	 * this structure. The applicable \"VimConnectionInfo\" structure, which is
	 * referenced by vimConnectionId, can be obtained from the \"vimConnectionInfo\"
	 * attribute of the \"VnfInstance\" structure. This attribute shall only be
	 * supported and present if VNF-related resource management in direct mode is
	 * applicable.
	 *
	 * @return vimConnectionId
	 **/
	@Schema(description = "Identifier of the VIM connection to access the software image referenced in this structure. The applicable \"VimConnectionInfo\" structure, which is referenced by vimConnectionId, can be obtained from the \"vimConnectionInfo\" attribute of the \"VnfInstance\" structure. This attribute shall only be supported and present if VNF-related resource management in direct mode is applicable. ")

	public String getVimConnectionId() {
		return vimConnectionId;
	}

	public void setVimConnectionId(final String vimConnectionId) {
		this.vimConnectionId = vimConnectionId;
	}

	public VimSoftwareImage resourceProviderId(final String resourceProviderId) {
		this.resourceProviderId = resourceProviderId;
		return this;
	}

	/**
	 * Identifies the entity responsible for the management of the virtualised
	 * resource. This attribute shall only be supported and present if VNF-related
	 * resource management in indirect mode is applicable. The identification scheme
	 * is outside the scope of the present document.
	 *
	 * @return resourceProviderId
	 **/
	@Schema(description = "Identifies the entity responsible for the management of the virtualised resource. This attribute shall only be supported and present if VNF-related resource management in indirect mode is applicable. The identification scheme is outside the scope of the present document. ")

	public String getResourceProviderId() {
		return resourceProviderId;
	}

	public void setResourceProviderId(final String resourceProviderId) {
		this.resourceProviderId = resourceProviderId;
	}

	public VimSoftwareImage vnfdSoftwareImageId(final String vnfdSoftwareImageId) {
		this.vnfdSoftwareImageId = vnfdSoftwareImageId;
		return this;
	}

	/**
	 * Identifier which references the software image descriptor in the VNFD.
	 *
	 * @return vnfdSoftwareImageId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifier which references the software image descriptor in the VNFD. ")
	@NotNull

	public String getVnfdSoftwareImageId() {
		return vnfdSoftwareImageId;
	}

	public void setVnfdSoftwareImageId(final String vnfdSoftwareImageId) {
		this.vnfdSoftwareImageId = vnfdSoftwareImageId;
	}

	public VimSoftwareImage vimSoftwareImageId(final String vimSoftwareImageId) {
		this.vimSoftwareImageId = vimSoftwareImageId;
		return this;
	}

	/**
	 * Identifier of the software image in the resource management layer (i.e. VIM).
	 *
	 * @return vimSoftwareImageId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifier of the software image in the resource management layer (i.e. VIM). ")
	@NotNull

	public String getVimSoftwareImageId() {
		return vimSoftwareImageId;
	}

	public void setVimSoftwareImageId(final String vimSoftwareImageId) {
		this.vimSoftwareImageId = vimSoftwareImageId;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final VimSoftwareImage vimSoftwareImage = (VimSoftwareImage) o;
		return Objects.equals(this.vimConnectionId, vimSoftwareImage.vimConnectionId) &&
				Objects.equals(this.resourceProviderId, vimSoftwareImage.resourceProviderId) &&
				Objects.equals(this.vnfdSoftwareImageId, vimSoftwareImage.vnfdSoftwareImageId) &&
				Objects.equals(this.vimSoftwareImageId, vimSoftwareImage.vimSoftwareImageId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(vimConnectionId, resourceProviderId, vnfdSoftwareImageId, vimSoftwareImageId);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class VimSoftwareImage {\n");

		sb.append("    vimConnectionId: ").append(toIndentedString(vimConnectionId)).append("\n");
		sb.append("    resourceProviderId: ").append(toIndentedString(resourceProviderId)).append("\n");
		sb.append("    vnfdSoftwareImageId: ").append(toIndentedString(vnfdSoftwareImageId)).append("\n");
		sb.append("    vimSoftwareImageId: ").append(toIndentedString(vimSoftwareImageId)).append("\n");
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
