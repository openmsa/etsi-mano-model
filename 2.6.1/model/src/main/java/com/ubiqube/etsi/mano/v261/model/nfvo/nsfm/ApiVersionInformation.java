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
package com.ubiqube.etsi.mano.v261.model.nfvo.nsfm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.annotation.Nonnull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;


/**
 * This type represents API version information.
 */
@Schema(description = "This type represents API version information. ")
@Validated
public class ApiVersionInformation {
	@JsonProperty("uriPrefix")
	private String uriPrefix = null;

	@JsonProperty("apiVersions")
	@Valid
	private List<ApiVersionInformationApiVersions> apiVersions = new ArrayList<>();

	public ApiVersionInformation uriPrefix(final String uriPrefix) {
		this.uriPrefix = uriPrefix;
		return this;
	}

	/**
	 * Specifies the URI prefix for the API, in the following form
	 * {apiRoot}/{apiName}/{apiMajorVersion}/.
	 *
	 * @return uriPrefix
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Specifies the URI prefix for the API, in the following form {apiRoot}/{apiName}/{apiMajorVersion}/. ")
	@Nonnull

	public String getUriPrefix() {
		return uriPrefix;
	}

	public void setUriPrefix(final String uriPrefix) {
		this.uriPrefix = uriPrefix;
	}

	public ApiVersionInformation apiVersions(final List<ApiVersionInformationApiVersions> apiVersions) {
		this.apiVersions = apiVersions;
		return this;
	}

	public ApiVersionInformation addApiVersionsItem(final ApiVersionInformationApiVersions apiVersionsItem) {
		this.apiVersions.add(apiVersionsItem);
		return this;
	}

	/**
	 * Version(s) supported for the API signalled by the uriPrefix attribute.
	 *
	 * @return apiVersions
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Version(s) supported for the API signalled by the uriPrefix attribute. ")
	@Nonnull
	@Valid
	public List<ApiVersionInformationApiVersions> getApiVersions() {
		return apiVersions;
	}

	public void setApiVersions(final List<ApiVersionInformationApiVersions> apiVersions) {
		this.apiVersions = apiVersions;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final ApiVersionInformation apiVersionInformation = (ApiVersionInformation) o;
		return Objects.equals(this.uriPrefix, apiVersionInformation.uriPrefix) &&
				Objects.equals(this.apiVersions, apiVersionInformation.apiVersions);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uriPrefix, apiVersions);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class ApiVersionInformation {\n");

		sb.append("    uriPrefix: ").append(toIndentedString(uriPrefix)).append("\n");
		sb.append("    apiVersions: ").append(toIndentedString(apiVersions)).append("\n");
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
