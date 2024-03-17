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
 *     along with this program.  If not, see https://www.gnu.org/licenses/.
 */
package com.ubiqube.etsi.mano.em.v451.model.vnflcm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type represents request parameters for the \&quot;Change current VNF
 * package\&quot; operation to replace the VNF package on which a VNF instance
 * is based. * NOTE 1: The indication of externally-managed internal VLs is
 * needed in case networks have been pre-configured for use with certain VNFs,
 * for instance to ensure that these networks have certain properties such as
 * security or acceleration features, or to address particular network
 * topologies. The present document assumes that externally-managed internal VLs
 * are managed by the NFVO and created towards the VIM. * NOTE 2: Component
 * mappings are defined in the VNFD in the source or destination package for the
 * relevant change path. See clause 7.1.15.2 in ETSI GS NFV-IFA 011 [7].
 */
@Schema(description = "This type represents request parameters for the \"Change current VNF package\" operation to replace the VNF package on which a VNF instance is based. * NOTE 1: The indication of externally-managed internal VLs is needed in case networks have been           pre-configured for use with certain VNFs, for instance to ensure that these networks have certain           properties such as security or acceleration features, or to address particular network topologies.           The present document assumes that externally-managed internal VLs are managed by the NFVO and created           towards the VIM. * NOTE 2: Component mappings are defined in the VNFD in the source or destination package for the relevant change           path. See clause 7.1.15.2 in ETSI GS NFV-IFA 011 [7]. ")
@Validated

public class ChangeCurrentVnfPkgRequest {
	@JsonProperty("vnfdId")
	private String vnfdId = null;

	@JsonProperty("extVirtualLinks")
	@Valid
	private List<ExtVirtualLinkData> extVirtualLinks = null;

	@JsonProperty("extManagedVirtualLinks")
	@Valid
	private List<ExtManagedVirtualLinkData> extManagedVirtualLinks = null;

	@JsonProperty("additionalParams")
	private Map<String, String> additionalParams = null;

	@JsonProperty("extensions")
	private Map<String, String> extensions = null;

	@JsonProperty("vnfConfigurableProperties")
	private Map<String, String> vnfConfigurableProperties = null;

	@JsonProperty("selectedDeployableModule")
	@Valid
	private List<String> selectedDeployableModule = null;

	@JsonProperty("certificateConfigurationData")
	private CertificateConfigurationData certificateConfigurationData = null;

	public ChangeCurrentVnfPkgRequest vnfdId(final String vnfdId) {
		this.vnfdId = vnfdId;
		return this;
	}

	/**
	 * Get vnfdId
	 *
	 * @return vnfdId
	 **/
	@Schema(required = true, description = "")
	@NotNull

	public String getVnfdId() {
		return vnfdId;
	}

	public void setVnfdId(final String vnfdId) {
		this.vnfdId = vnfdId;
	}

	public ChangeCurrentVnfPkgRequest extVirtualLinks(final List<ExtVirtualLinkData> extVirtualLinks) {
		this.extVirtualLinks = extVirtualLinks;
		return this;
	}

	public ChangeCurrentVnfPkgRequest addExtVirtualLinksItem(final ExtVirtualLinkData extVirtualLinksItem) {
		if (this.extVirtualLinks == null) {
			this.extVirtualLinks = new ArrayList<>();
		}
		this.extVirtualLinks.add(extVirtualLinksItem);
		return this;
	}

	/**
	 * Information about external VLs to connect the VNF to, including configuration
	 * information for the CPs via which the VNF instance can attach to this VL.
	 * Entries in the list that are unchanged need not be supplied as part of this
	 * request. The following applies to the \"ExtVirtualLinkData\" information
	 * provided in this request, together with the related \"ExtVirtualLinkInfo\"
	 * information known to the VNFM represented in the \"VnfInstance\" structure
	 * (see clause 5.5.2.2): Even if the VNF is not in fully scaled-out state after
	 * the change of the VNF package, the API consumer shall provide enough CP
	 * configuration records to allow connecting the VNF instance, fully scaled out
	 * in all scaling aspects, to the external VLs.
	 *
	 * @return extVirtualLinks
	 **/
	@Schema(description = "Information about external VLs to connect the VNF to,  including configuration information for the CPs via which the VNF instance can attach to this VL. Entries in the list that are unchanged need not be supplied as part of this request. The following applies to the \"ExtVirtualLinkData\" information provided in this request, together with the related \"ExtVirtualLinkInfo\" information known to the VNFM represented in the \"VnfInstance\" structure (see clause 5.5.2.2): Even if the VNF is not in fully scaled-out state after the change of the VNF package, the API consumer shall provide enough CP configuration records to allow connecting the VNF instance, fully scaled out in all scaling aspects, to the external VLs. ")
	@Valid
	public List<ExtVirtualLinkData> getExtVirtualLinks() {
		return extVirtualLinks;
	}

	public void setExtVirtualLinks(final List<ExtVirtualLinkData> extVirtualLinks) {
		this.extVirtualLinks = extVirtualLinks;
	}

	public ChangeCurrentVnfPkgRequest extManagedVirtualLinks(final List<ExtManagedVirtualLinkData> extManagedVirtualLinks) {
		this.extManagedVirtualLinks = extManagedVirtualLinks;
		return this;
	}

	public ChangeCurrentVnfPkgRequest addExtManagedVirtualLinksItem(final ExtManagedVirtualLinkData extManagedVirtualLinksItem) {
		if (this.extManagedVirtualLinks == null) {
			this.extManagedVirtualLinks = new ArrayList<>();
		}
		this.extManagedVirtualLinks.add(extManagedVirtualLinksItem);
		return this;
	}

	/**
	 * Information about internal VLs that are managed by other entities than the
	 * VNFM. See note.
	 *
	 * @return extManagedVirtualLinks
	 **/
	@Schema(description = "Information about internal VLs that are managed by other entities than the VNFM. See note. ")
	@Valid
	public List<ExtManagedVirtualLinkData> getExtManagedVirtualLinks() {
		return extManagedVirtualLinks;
	}

	public void setExtManagedVirtualLinks(final List<ExtManagedVirtualLinkData> extManagedVirtualLinks) {
		this.extManagedVirtualLinks = extManagedVirtualLinks;
	}

	public ChangeCurrentVnfPkgRequest additionalParams(final Map<String, String> additionalParams) {
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

	public ChangeCurrentVnfPkgRequest extensions(final Map<String, String> extensions) {
		this.extensions = extensions;
		return this;
	}

	/**
	 * Get extensions
	 *
	 * @return extensions
	 **/
	@Schema(description = "")

	@Valid
	public Map<String, String> getExtensions() {
		return extensions;
	}

	public void setExtensions(final Map<String, String> extensions) {
		this.extensions = extensions;
	}

	public ChangeCurrentVnfPkgRequest vnfConfigurableProperties(final Map<String, String> vnfConfigurableProperties) {
		this.vnfConfigurableProperties = vnfConfigurableProperties;
		return this;
	}

	/**
	 * Get vnfConfigurableProperties
	 *
	 * @return vnfConfigurableProperties
	 **/
	@Schema(description = "")

	@Valid
	public Map<String, String> getVnfConfigurableProperties() {
		return vnfConfigurableProperties;
	}

	public void setVnfConfigurableProperties(final Map<String, String> vnfConfigurableProperties) {
		this.vnfConfigurableProperties = vnfConfigurableProperties;
	}

	public ChangeCurrentVnfPkgRequest selectedDeployableModule(final List<String> selectedDeployableModule) {
		this.selectedDeployableModule = selectedDeployableModule;
		return this;
	}

	public ChangeCurrentVnfPkgRequest addSelectedDeployableModuleItem(final String selectedDeployableModuleItem) {
		if (this.selectedDeployableModule == null) {
			this.selectedDeployableModule = new ArrayList<>();
		}
		this.selectedDeployableModule.add(selectedDeployableModuleItem);
		return this;
	}

	/**
	 * Identifier of a selected deployable module. If this attribute is present only
	 * VNFCs based on VDUs that belong to deployable modules listed in this
	 * attribute are requested to be instantiated or preserved if they were already
	 * instantiated. If this attribute is not present the deployable modules that
	 * were selected before the operation, and that still are defined in the VNFD in
	 * the destination package, or the corresponding ones according to the component
	 * mappings, remain valid. See note 2.
	 *
	 * @return selectedDeployableModule
	 **/
	@Schema(description = "Identifier of a selected deployable module. If this attribute is present only VNFCs based on VDUs that belong to deployable modules listed in this attribute are requested to be instantiated or preserved if they were already instantiated. If this attribute is not present the deployable modules that were selected before the operation, and that still are defined in the VNFD in the destination package, or the corresponding ones according to the component mappings, remain valid. See note 2. ")

	public List<String> getSelectedDeployableModule() {
		return selectedDeployableModule;
	}

	public void setSelectedDeployableModule(final List<String> selectedDeployableModule) {
		this.selectedDeployableModule = selectedDeployableModule;
	}

	public ChangeCurrentVnfPkgRequest certificateConfigurationData(final CertificateConfigurationData certificateConfigurationData) {
		this.certificateConfigurationData = certificateConfigurationData;
		return this;
	}

	/**
	 * Get certificateConfigurationData
	 *
	 * @return certificateConfigurationData
	 **/
	@Schema(description = "")

	@Valid
	public CertificateConfigurationData getCertificateConfigurationData() {
		return certificateConfigurationData;
	}

	public void setCertificateConfigurationData(final CertificateConfigurationData certificateConfigurationData) {
		this.certificateConfigurationData = certificateConfigurationData;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final ChangeCurrentVnfPkgRequest changeCurrentVnfPkgRequest = (ChangeCurrentVnfPkgRequest) o;
		return Objects.equals(this.vnfdId, changeCurrentVnfPkgRequest.vnfdId) &&
				Objects.equals(this.extVirtualLinks, changeCurrentVnfPkgRequest.extVirtualLinks) &&
				Objects.equals(this.extManagedVirtualLinks, changeCurrentVnfPkgRequest.extManagedVirtualLinks) &&
				Objects.equals(this.additionalParams, changeCurrentVnfPkgRequest.additionalParams) &&
				Objects.equals(this.extensions, changeCurrentVnfPkgRequest.extensions) &&
				Objects.equals(this.vnfConfigurableProperties, changeCurrentVnfPkgRequest.vnfConfigurableProperties) &&
				Objects.equals(this.selectedDeployableModule, changeCurrentVnfPkgRequest.selectedDeployableModule) &&
				Objects.equals(this.certificateConfigurationData, changeCurrentVnfPkgRequest.certificateConfigurationData);
	}

	@Override
	public int hashCode() {
		return Objects.hash(vnfdId, extVirtualLinks, extManagedVirtualLinks, additionalParams, extensions, vnfConfigurableProperties, selectedDeployableModule, certificateConfigurationData);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class ChangeCurrentVnfPkgRequest {\n");

		sb.append("    vnfdId: ").append(toIndentedString(vnfdId)).append("\n");
		sb.append("    extVirtualLinks: ").append(toIndentedString(extVirtualLinks)).append("\n");
		sb.append("    extManagedVirtualLinks: ").append(toIndentedString(extManagedVirtualLinks)).append("\n");
		sb.append("    additionalParams: ").append(toIndentedString(additionalParams)).append("\n");
		sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
		sb.append("    vnfConfigurableProperties: ").append(toIndentedString(vnfConfigurableProperties)).append("\n");
		sb.append("    selectedDeployableModule: ").append(toIndentedString(selectedDeployableModule)).append("\n");
		sb.append("    certificateConfigurationData: ").append(toIndentedString(certificateConfigurationData)).append("\n");
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
