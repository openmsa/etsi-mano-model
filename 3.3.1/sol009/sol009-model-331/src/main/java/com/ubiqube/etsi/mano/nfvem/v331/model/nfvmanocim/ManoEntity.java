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
package com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanocim;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type represents an NFV-MANO functional entity.
 */
@Schema(description = "This type represents an NFV-MANO functional entity. ")
@Validated
public class ManoEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("type")
	private ManoEntityEnumType type = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("provider")
	private String provider = null;

	@JsonProperty("softwareVersion")
	private Object softwareVersion = null;

	@JsonProperty("manoEntityComponents")
	@Valid
	private List<ManoEntityComponent> manoEntityComponents = null;

	@JsonProperty("manoServices")
	@Valid
	private List<ManoService> manoServices = null;

	@JsonProperty("manoConfigurableParams")
	private ManoConfigurableParams manoConfigurableParams = null;

	@JsonProperty("manoApplicationState")
	private ManoEntityManoApplicationState manoApplicationState = null;

	@JsonProperty("nfvoSpecificInfo")
	private NfvoSpecificInfo nfvoSpecificInfo = null;

	@JsonProperty("vnfmSpecificInfo")
	private VnfmSpecificInfo vnfmSpecificInfo = null;

	@JsonProperty("vimSpecificInfo")
	private VimSpecificInfo vimSpecificInfo = null;

	@JsonProperty("_links")
	private ManoEntityLinks links = null;

	public ManoEntity id(final String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 *
	 * @return id
	 **/
	@Schema(required = true, description = "")
	@NotNull

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public ManoEntity type(final ManoEntityEnumType type) {
		this.type = type;
		return this;
	}

	/**
	 * Get type
	 *
	 * @return type
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public ManoEntityEnumType getType() {
		return type;
	}

	public void setType(final ManoEntityEnumType type) {
		this.type = type;
	}

	public ManoEntity name(final String name) {
		this.name = name;
		return this;
	}

	/**
	 * Human-readable name of the NFV-MANO functional entity. This attribute can be
	 * modified with the PATCH method.
	 *
	 * @return name
	 **/
	@Schema(required = true, description = "Human-readable name of the NFV-MANO functional entity. This attribute can be modified with the PATCH method. ")
	@NotNull

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public ManoEntity description(final String description) {
		this.description = description;
		return this;
	}

	/**
	 * Human-readable description of the NFV-MANO functional entity. This attribute
	 * can be modified with the PATCH method.
	 *
	 * @return description
	 **/
	@Schema(required = true, description = "Human-readable description of the NFV-MANO functional entity. This attribute can be modified with the PATCH method. ")
	@NotNull

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public ManoEntity provider(final String provider) {
		this.provider = provider;
		return this;
	}

	/**
	 * Information about the provider of the NFV-MANO functional entity. It
	 * typically includes the name of the provider.
	 *
	 * @return provider
	 **/
	@Schema(required = true, description = "Information about the provider of the NFV-MANO functional entity.  It typically includes the name of the provider. ")
	@NotNull

	public String getProvider() {
		return provider;
	}

	public void setProvider(final String provider) {
		this.provider = provider;
	}

	public ManoEntity softwareVersion(final Object softwareVersion) {
		this.softwareVersion = softwareVersion;
		return this;
	}

	/**
	 * The version of the software of the NFV-MANO functional entity. $ref:
	 * \"../components/SOL009_schemas.yaml#/components/schemas/Version\"
	 *
	 * @return softwareVersion
	 **/
	@Schema(required = true, description = "The version of the software of the NFV-MANO functional entity. $ref: \"../components/SOL009_schemas.yaml#/components/schemas/Version\" ")
	@NotNull

	public Object getSoftwareVersion() {
		return softwareVersion;
	}

	public void setSoftwareVersion(final Object softwareVersion) {
		this.softwareVersion = softwareVersion;
	}

	public ManoEntity manoEntityComponents(final List<ManoEntityComponent> manoEntityComponents) {
		this.manoEntityComponents = manoEntityComponents;
		return this;
	}

	public ManoEntity addManoEntityComponentsItem(final ManoEntityComponent manoEntityComponentsItem) {
		if (this.manoEntityComponents == null) {
			this.manoEntityComponents = new ArrayList<>();
		}
		this.manoEntityComponents.add(manoEntityComponentsItem);
		return this;
	}

	/**
	 * The deployed NFV-MANO functional entity components which realize the NFV-MANO
	 * functional entity. NOTE: It is optional for the API producer to support the
	 * \"manoEntityComponents\" attribute.
	 *
	 * @return manoEntityComponents
	 **/
	@Schema(description = "The deployed NFV-MANO functional entity components which realize the  NFV-MANO functional entity.  NOTE: It is optional for the API producer to support the \"manoEntityComponents\"  attribute. ")
	@Valid
	public List<ManoEntityComponent> getManoEntityComponents() {
		return manoEntityComponents;
	}

	public void setManoEntityComponents(final List<ManoEntityComponent> manoEntityComponents) {
		this.manoEntityComponents = manoEntityComponents;
	}

	public ManoEntity manoServices(final List<ManoService> manoServices) {
		this.manoServices = manoServices;
		return this;
	}

	public ManoEntity addManoServicesItem(final ManoService manoServicesItem) {
		if (this.manoServices == null) {
			this.manoServices = new ArrayList<>();
		}
		this.manoServices.add(manoServicesItem);
		return this;
	}

	/**
	 * Information about the NFV-MANO services provided by the NFV-MANO functional
	 * entity.
	 *
	 * @return manoServices
	 **/
	@Schema(description = "Information about the NFV-MANO services provided by the NFV-MANO  functional entity. ")
	@Valid
	public List<ManoService> getManoServices() {
		return manoServices;
	}

	public void setManoServices(final List<ManoService> manoServices) {
		this.manoServices = manoServices;
	}

	public ManoEntity manoConfigurableParams(final ManoConfigurableParams manoConfigurableParams) {
		this.manoConfigurableParams = manoConfigurableParams;
		return this;
	}

	/**
	 * Get manoConfigurableParams
	 *
	 * @return manoConfigurableParams
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public ManoConfigurableParams getManoConfigurableParams() {
		return manoConfigurableParams;
	}

	public void setManoConfigurableParams(final ManoConfigurableParams manoConfigurableParams) {
		this.manoConfigurableParams = manoConfigurableParams;
	}

	public ManoEntity manoApplicationState(final ManoEntityManoApplicationState manoApplicationState) {
		this.manoApplicationState = manoApplicationState;
		return this;
	}

	/**
	 * Get manoApplicationState
	 *
	 * @return manoApplicationState
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public ManoEntityManoApplicationState getManoApplicationState() {
		return manoApplicationState;
	}

	public void setManoApplicationState(final ManoEntityManoApplicationState manoApplicationState) {
		this.manoApplicationState = manoApplicationState;
	}

	public ManoEntity nfvoSpecificInfo(final NfvoSpecificInfo nfvoSpecificInfo) {
		this.nfvoSpecificInfo = nfvoSpecificInfo;
		return this;
	}

	/**
	 * Get nfvoSpecificInfo
	 *
	 * @return nfvoSpecificInfo
	 **/
	@Schema(description = "")

	@Valid
	public NfvoSpecificInfo getNfvoSpecificInfo() {
		return nfvoSpecificInfo;
	}

	public void setNfvoSpecificInfo(final NfvoSpecificInfo nfvoSpecificInfo) {
		this.nfvoSpecificInfo = nfvoSpecificInfo;
	}

	public ManoEntity vnfmSpecificInfo(final VnfmSpecificInfo vnfmSpecificInfo) {
		this.vnfmSpecificInfo = vnfmSpecificInfo;
		return this;
	}

	/**
	 * Get vnfmSpecificInfo
	 *
	 * @return vnfmSpecificInfo
	 **/
	@Schema(description = "")

	@Valid
	public VnfmSpecificInfo getVnfmSpecificInfo() {
		return vnfmSpecificInfo;
	}

	public void setVnfmSpecificInfo(final VnfmSpecificInfo vnfmSpecificInfo) {
		this.vnfmSpecificInfo = vnfmSpecificInfo;
	}

	public ManoEntity vimSpecificInfo(final VimSpecificInfo vimSpecificInfo) {
		this.vimSpecificInfo = vimSpecificInfo;
		return this;
	}

	/**
	 * Get vimSpecificInfo
	 *
	 * @return vimSpecificInfo
	 **/
	@Schema(description = "")

	@Valid
	public VimSpecificInfo getVimSpecificInfo() {
		return vimSpecificInfo;
	}

	public void setVimSpecificInfo(final VimSpecificInfo vimSpecificInfo) {
		this.vimSpecificInfo = vimSpecificInfo;
	}

	public ManoEntity links(final ManoEntityLinks _links) {
		this.links = _links;
		return this;
	}

	/**
	 * Get _links
	 *
	 * @return _links
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public ManoEntityLinks getLinks() {
		return links;
	}

	public void setLinks(final ManoEntityLinks _links) {
		this.links = _links;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final ManoEntity manoEntity = (ManoEntity) o;
		return Objects.equals(this.id, manoEntity.id) &&
				Objects.equals(this.type, manoEntity.type) &&
				Objects.equals(this.name, manoEntity.name) &&
				Objects.equals(this.description, manoEntity.description) &&
				Objects.equals(this.provider, manoEntity.provider) &&
				Objects.equals(this.softwareVersion, manoEntity.softwareVersion) &&
				Objects.equals(this.manoEntityComponents, manoEntity.manoEntityComponents) &&
				Objects.equals(this.manoServices, manoEntity.manoServices) &&
				Objects.equals(this.manoConfigurableParams, manoEntity.manoConfigurableParams) &&
				Objects.equals(this.manoApplicationState, manoEntity.manoApplicationState) &&
				Objects.equals(this.nfvoSpecificInfo, manoEntity.nfvoSpecificInfo) &&
				Objects.equals(this.vnfmSpecificInfo, manoEntity.vnfmSpecificInfo) &&
				Objects.equals(this.vimSpecificInfo, manoEntity.vimSpecificInfo) &&
				Objects.equals(this.links, manoEntity.links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, type, name, description, provider, softwareVersion, manoEntityComponents, manoServices, manoConfigurableParams, manoApplicationState, nfvoSpecificInfo, vnfmSpecificInfo, vimSpecificInfo, links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class ManoEntity {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    provider: ").append(toIndentedString(provider)).append("\n");
		sb.append("    softwareVersion: ").append(toIndentedString(softwareVersion)).append("\n");
		sb.append("    manoEntityComponents: ").append(toIndentedString(manoEntityComponents)).append("\n");
		sb.append("    manoServices: ").append(toIndentedString(manoServices)).append("\n");
		sb.append("    manoConfigurableParams: ").append(toIndentedString(manoConfigurableParams)).append("\n");
		sb.append("    manoApplicationState: ").append(toIndentedString(manoApplicationState)).append("\n");
		sb.append("    nfvoSpecificInfo: ").append(toIndentedString(nfvoSpecificInfo)).append("\n");
		sb.append("    vnfmSpecificInfo: ").append(toIndentedString(vnfmSpecificInfo)).append("\n");
		sb.append("    vimSpecificInfo: ").append(toIndentedString(vimSpecificInfo)).append("\n");
		sb.append("    _links: ").append(toIndentedString(links)).append("\n");
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
