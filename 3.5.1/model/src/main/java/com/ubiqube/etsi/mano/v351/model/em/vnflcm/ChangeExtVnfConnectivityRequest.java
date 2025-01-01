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
package com.ubiqube.etsi.mano.v351.model.em.vnflcm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

/**
 * This type represents request parameters for the \&quot;Change external VNF
 * connectivity\&quot; operation to modify the external connectivity of a VNF
 * instance.
 */
@Schema(description = "This type represents request parameters for the \"Change external VNF connectivity\" operation to modify the external connectivity of a VNF instance. ")
@Validated

public class ChangeExtVnfConnectivityRequest {
	@JsonProperty("extVirtualLinks")
	@Valid
	private List<ExtVirtualLinkData> extVirtualLinks = new ArrayList<>();

	@JsonProperty("additionalParams")
	private Map<String, String> additionalParams = null;

	public ChangeExtVnfConnectivityRequest extVirtualLinks(final List<ExtVirtualLinkData> extVirtualLinks) {
		this.extVirtualLinks = extVirtualLinks;
		return this;
	}

	public ChangeExtVnfConnectivityRequest addExtVirtualLinksItem(final ExtVirtualLinkData extVirtualLinksItem) {
		this.extVirtualLinks.add(extVirtualLinksItem);
		return this;
	}

	/**
	 * Information about external VLs to change (e.g. connect the VNF to).
	 *
	 * @return extVirtualLinks
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Information about external VLs to change (e.g. connect the VNF to). ")
	@NotNull
	@Valid
	public List<ExtVirtualLinkData> getExtVirtualLinks() {
		return extVirtualLinks;
	}

	public void setExtVirtualLinks(final List<ExtVirtualLinkData> extVirtualLinks) {
		this.extVirtualLinks = extVirtualLinks;
	}

	public ChangeExtVnfConnectivityRequest additionalParams(final Map<String, String> additionalParams) {
		this.additionalParams = additionalParams;
		return this;
	}

	/**
	 * Get additionalParams
	 *
	 * @return additionalParams
	 **/
	@Schema(description = "")

	@Valid
	public Map<String, String> getAdditionalParams() {
		return additionalParams;
	}

	public void setAdditionalParams(final Map<String, String> additionalParams) {
		this.additionalParams = additionalParams;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final ChangeExtVnfConnectivityRequest changeExtVnfConnectivityRequest = (ChangeExtVnfConnectivityRequest) o;
		return Objects.equals(this.extVirtualLinks, changeExtVnfConnectivityRequest.extVirtualLinks) &&
				Objects.equals(this.additionalParams, changeExtVnfConnectivityRequest.additionalParams);
	}

	@Override
	public int hashCode() {
		return Objects.hash(extVirtualLinks, additionalParams);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class ChangeExtVnfConnectivityRequest {\n");

		sb.append("    extVirtualLinks: ").append(toIndentedString(extVirtualLinks)).append("\n");
		sb.append("    additionalParams: ").append(toIndentedString(additionalParams)).append("\n");
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
