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
package com.ubiqube.etsi.mano.policy.v341.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type represents an individual policy. It shall comply with the
 * provisions defined in table 5.6.2.3-1.
 */
@Schema(description = "This type represents an individual policy. It shall comply with the provisions defined in table 5.6.2.3-1.")
@Validated

public class Policy {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("designer")
	private String designer = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("pfId")
	private String pfId = null;

	@JsonProperty("versions")
	@Valid
	private List<String> versions = null;

	@JsonProperty("selectedVersion")
	private String selectedVersion = null;

	@JsonProperty("activationStatus")
	private ActivationStatus activationStatus = null;

	@JsonProperty("transferStatus")
	private TransferStatus transferStatus = null;

	@JsonProperty("associations")
	@Valid
	private List<String> associations = null;

	@JsonProperty("_links")
	private PolicyLinks links = null;

	public Policy id(final String id) {
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

	public Policy designer(final String designer) {
		this.designer = designer;
		return this;
	}

	/**
	 * Human readable name of the designer of the policy.
	 *
	 * @return designer
	 **/
	@Schema(required = true, description = "Human readable name of the designer of the policy. ")
	@NotNull

	public String getDesigner() {
		return designer;
	}

	public void setDesigner(final String designer) {
		this.designer = designer;
	}

	public Policy name(final String name) {
		this.name = name;
		return this;
	}

	/**
	 * Human readable name of the policy.
	 *
	 * @return name
	 **/
	@Schema(required = true, description = "Human readable name of the policy. ")
	@NotNull

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Policy pfId(final String pfId) {
		this.pfId = pfId;
		return this;
	}

	/**
	 * Get pfId
	 *
	 * @return pfId
	 **/
	@Schema(description = "")

	public String getPfId() {
		return pfId;
	}

	public void setPfId(final String pfId) {
		this.pfId = pfId;
	}

	public Policy versions(final List<String> versions) {
		this.versions = versions;
		return this;
	}

	public Policy addVersionsItem(final String versionsItem) {
		if (this.versions == null) {
			this.versions = new ArrayList<>();
		}
		this.versions.add(versionsItem);
		return this;
	}

	/**
	 * Versions of the policy. Shall be present if at least one version of the
	 * policy has been transferred.
	 *
	 * @return versions
	 **/
	@Schema(description = "Versions of the policy. Shall be present if at least one version of the policy has been transferred. ")

	public List<String> getVersions() {
		return versions;
	}

	public void setVersions(final List<String> versions) {
		this.versions = versions;
	}

	public Policy selectedVersion(final String selectedVersion) {
		this.selectedVersion = selectedVersion;
		return this;
	}

	/**
	 * Get selectedVersion
	 *
	 * @return selectedVersion
	 **/
	@Schema(description = "")

	public String getSelectedVersion() {
		return selectedVersion;
	}

	public void setSelectedVersion(final String selectedVersion) {
		this.selectedVersion = selectedVersion;
	}

	public Policy activationStatus(final ActivationStatus activationStatus) {
		this.activationStatus = activationStatus;
		return this;
	}

	/**
	 * Get activationStatus
	 *
	 * @return activationStatus
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public ActivationStatus getActivationStatus() {
		return activationStatus;
	}

	public void setActivationStatus(final ActivationStatus activationStatus) {
		this.activationStatus = activationStatus;
	}

	public Policy transferStatus(final TransferStatus transferStatus) {
		this.transferStatus = transferStatus;
		return this;
	}

	/**
	 * Get transferStatus
	 *
	 * @return transferStatus
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public TransferStatus getTransferStatus() {
		return transferStatus;
	}

	public void setTransferStatus(final TransferStatus transferStatus) {
		this.transferStatus = transferStatus;
	}

	public Policy associations(final List<String> associations) {
		this.associations = associations;
		return this;
	}

	public Policy addAssociationsItem(final String associationsItem) {
		if (this.associations == null) {
			this.associations = new ArrayList<>();
		}
		this.associations.add(associationsItem);
		return this;
	}

	/**
	 * Identifiers of the entities that the PF manages and to which the policy
	 * associates to. Shall be absent when the association feature is not applicable
	 * for the PF. The associations refer to identifiers of entities that the PF
	 * manages. E.g., if the PF is a VNFM, the policy can associate to VNF
	 * instances; if the PF is NFVO, the policy can associate to an NS instances.
	 * How the PF determines the scope of applicability of the policy when this
	 * attribute is absent is outside the scope of the present document.
	 *
	 * @return associations
	 **/
	@Schema(description = "Identifiers of the entities that the PF manages and to which the policy associates to. Shall be absent when the association feature is not applicable for the PF. The associations refer to identifiers of entities that the PF manages. E.g., if the PF is a VNFM, the policy can associate to VNF instances; if the PF is NFVO, the policy can associate to an NS instances. How the PF determines the scope of applicability of the policy when this attribute is absent is outside the scope of the present document. ")

	public List<String> getAssociations() {
		return associations;
	}

	public void setAssociations(final List<String> associations) {
		this.associations = associations;
	}

	public Policy links(final PolicyLinks _links) {
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
	public PolicyLinks getLinks() {
		return links;
	}

	public void setLinks(final PolicyLinks _links) {
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
		final Policy policy = (Policy) o;
		return Objects.equals(this.id, policy.id) &&
				Objects.equals(this.designer, policy.designer) &&
				Objects.equals(this.name, policy.name) &&
				Objects.equals(this.pfId, policy.pfId) &&
				Objects.equals(this.versions, policy.versions) &&
				Objects.equals(this.selectedVersion, policy.selectedVersion) &&
				Objects.equals(this.activationStatus, policy.activationStatus) &&
				Objects.equals(this.transferStatus, policy.transferStatus) &&
				Objects.equals(this.associations, policy.associations) &&
				Objects.equals(this.links, policy.links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, designer, name, pfId, versions, selectedVersion, activationStatus, transferStatus, associations, links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class Policy {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    designer: ").append(toIndentedString(designer)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    pfId: ").append(toIndentedString(pfId)).append("\n");
		sb.append("    versions: ").append(toIndentedString(versions)).append("\n");
		sb.append("    selectedVersion: ").append(toIndentedString(selectedVersion)).append("\n");
		sb.append("    activationStatus: ").append(toIndentedString(activationStatus)).append("\n");
		sb.append("    transferStatus: ").append(toIndentedString(transferStatus)).append("\n");
		sb.append("    associations: ").append(toIndentedString(associations)).append("\n");
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
