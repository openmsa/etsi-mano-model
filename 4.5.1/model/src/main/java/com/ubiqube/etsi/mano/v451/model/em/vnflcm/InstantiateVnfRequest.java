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
package com.ubiqube.etsi.mano.v451.model.em.vnflcm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v451.model.nfvo.vnflcm.VimConnectionInfo;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type represents request parameters for the \&quot;Instantiate VNF\&quot;
 * operation. * NOTE 1: The indication of externally-managed internal VLs is
 * needed in case networks have been pre-configured for use with certain VNFs,
 * for instance to ensure that these networks have certain properties such as
 * security or acceleration features, or to address particular network
 * topologies. The present document assumes that externally-managed internal VLs
 * are managed by the NFVO and created towards the VIM. NOTE 2: The target size
 * for VNF instantiation may be specified in either instantiationLevelId or
 * targetScaleLevelInfo, but not both. If none of the two attributes
 * (instantiationLevelId or targetScaleLevelInfo) are present, the default
 * instantiation level as declared in the VNFD shall be used. NOTE 3: If
 * targetScaleLevelInfo is specified, information provided in
 * targetScaleLevelInfo shall be used for instantiating scalable constituents of
 * the VNF (e.g, VDUs/VLs). For scaling aspects not specified in
 * targetScaleLevelInfo or for the VNF constituents (e.g., VDUs/VLs) that are
 * not scalable, the default instantiation level as declared in the VNFD shall
 * be used for instantiation. NOTE 4: If the referenced instantiationLevel or
 * the targetScaleLevelInfo contain information related to VNFCs that are not
 * going to be instantiated due to the selection of deployable modules, the
 * information is stored in the VNFM for later use and included in the
 * instantiatedVnfInfo. If none of the attributes is present, the information
 * from the defaultInstantiationLevel related to those VNFCs is stored and
 * included in the instantiatedVnfInfo. If, during the lifecycle of the VNF, as
 * a result of a change of the selected deployable modules any of those VNFCs is
 * going to be instantiated, the stored information determines the number of
 * instances, unless the request that triggered the change also contains
 * information about the number of instances.
 */
@Schema(description = "This type represents request parameters for the \"Instantiate VNF\" operation. * NOTE 1: The indication of externally-managed internal VLs is needed in case networks have been           pre-configured for use with certain VNFs, for instance to ensure that these networks have certain           properties such as security or acceleration features, or to address particular network topologies.           The present document assumes that externally-managed internal VLs are managed by the NFVO and           created towards the VIM.   NOTE 2: The target size for VNF instantiation may be specified in either instantiationLevelId or targetScaleLevelInfo,            but not both. If none of the two attributes (instantiationLevelId or targetScaleLevelInfo) are            present, the default instantiation level as declared in the VNFD shall be used.   NOTE 3: If targetScaleLevelInfo is specified, information provided in targetScaleLevelInfo shall be used for            instantiating scalable constituents of the VNF (e.g, VDUs/VLs). For scaling aspects not specified in            targetScaleLevelInfo or for the VNF constituents (e.g., VDUs/VLs) that are not scalable, the default            instantiation level as declared in the VNFD shall be used for instantiation.           NOTE 4: If the referenced instantiationLevel or the targetScaleLevelInfo contain information related to VNFCs that are           not going to be instantiated due to the selection of deployable modules, the information is stored in the VNFM           for later use and included in the instantiatedVnfInfo. If none of the attributes is present, the information from the           defaultInstantiationLevel related to those VNFCs is stored and included in the instantiatedVnfInfo. If, during the           lifecycle of the VNF, as a result of a change of the selected deployable modules any of those VNFCs is going to           be instantiated, the stored information determines the number of instances, unless the request that triggered           the change also contains information about the number of instances. ")
@Validated

public class InstantiateVnfRequest implements AnyOfInstantiateVnfRequest {
	@JsonProperty("flavourId")
	private String flavourId = null;

	@JsonProperty("instantiationLevelId")
	private String instantiationLevelId = null;

	@JsonProperty("targetScaleLevelInfo")
	@Valid
	private List<ScaleInfo> targetScaleLevelInfo = null;

	@JsonProperty("extVirtualLinks")
	@Valid
	private List<ExtVirtualLinkData> extVirtualLinks = null;

	@JsonProperty("extManagedVirtualLinks")
	@Valid
	private List<ExtManagedVirtualLinkData> extManagedVirtualLinks = null;

	@JsonProperty("localizationLanguage")
	private String localizationLanguage = null;

	@JsonProperty("additionalParams")
	private Map<String, String> additionalParams = null;

	@JsonProperty("extensions")
	private Map<String, String> extensions = null;

	@JsonProperty("vnfConfigurableProperties")
	private Map<String, String> vnfConfigurableProperties = null;

	@JsonProperty("selectedDeployableModule")
	@Valid
	private List<String> selectedDeployableModule = null;

	@JsonProperty("vimConnectionInfo")
	@Valid
	private Map<String, VimConnectionInfo> vimConnectionInfo;

	public InstantiateVnfRequest flavourId(final String flavourId) {
		this.flavourId = flavourId;
		return this;
	}

	/**
	 * Get flavourId
	 *
	 * @return flavourId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getFlavourId() {
		return flavourId;
	}

	public void setFlavourId(final String flavourId) {
		this.flavourId = flavourId;
	}

	public InstantiateVnfRequest instantiationLevelId(final String instantiationLevelId) {
		this.instantiationLevelId = instantiationLevelId;
		return this;
	}

	/**
	 * Get instantiationLevelId
	 *
	 * @return instantiationLevelId
	 **/
	@Schema(description = "")

	public String getInstantiationLevelId() {
		return instantiationLevelId;
	}

	public void setInstantiationLevelId(final String instantiationLevelId) {
		this.instantiationLevelId = instantiationLevelId;
	}

	public InstantiateVnfRequest targetScaleLevelInfo(final List<ScaleInfo> targetScaleLevelInfo) {
		this.targetScaleLevelInfo = targetScaleLevelInfo;
		return this;
	}

	public InstantiateVnfRequest addTargetScaleLevelInfoItem(final ScaleInfo targetScaleLevelInfoItem) {
		if (this.targetScaleLevelInfo == null) {
			this.targetScaleLevelInfo = new ArrayList<>();
		}
		this.targetScaleLevelInfo.add(targetScaleLevelInfoItem);
		return this;
	}

	/**
	 * This attribute is applicable if VNF supports target scale level
	 * instantiation. For each scaling aspect of the current deployment flavour, the
	 * attribute specifies the scale level of VNF constituents (e.g., VDU level) to
	 * be instantiated. See notes 2 3, and 4.
	 *
	 * @return targetScaleLevelInfo
	 **/
	@Schema(description = "This attribute is applicable if VNF supports target scale level instantiation. For each scaling aspect of the current deployment flavour, the attribute specifies  the scale level of VNF constituents (e.g., VDU level) to be instantiated. See notes 2  3, and 4. ")
	@Valid
	public List<ScaleInfo> getTargetScaleLevelInfo() {
		return targetScaleLevelInfo;
	}

	public void setTargetScaleLevelInfo(final List<ScaleInfo> targetScaleLevelInfo) {
		this.targetScaleLevelInfo = targetScaleLevelInfo;
	}

	public InstantiateVnfRequest extVirtualLinks(final List<ExtVirtualLinkData> extVirtualLinks) {
		this.extVirtualLinks = extVirtualLinks;
		return this;
	}

	public InstantiateVnfRequest addExtVirtualLinksItem(final ExtVirtualLinkData extVirtualLinksItem) {
		if (this.extVirtualLinks == null) {
			this.extVirtualLinks = new ArrayList<>();
		}
		this.extVirtualLinks.add(extVirtualLinksItem);
		return this;
	}

	/**
	 * Information about external VLs to connect the VNF to, including configuration
	 * information for the CPs via which the VNF instance can attach to this VL. The
	 * following applies to the \"ExtVirtualLinkData\" information provided in this
	 * request: Even if the VNF is not instantiated in fully scaled-out state, the
	 * API consumer shall provide enough CP configuration records to allow
	 * connecting the VNF instance, fully scaled out in all scaling aspects, to the
	 * external VLs.
	 *
	 * @return extVirtualLinks
	 **/
	@Schema(description = "Information about external VLs to connect the VNF to, including configuration information  for the CPs via which the VNF instance can attach to this VL. The following applies to the \"ExtVirtualLinkData\" information provided in this request: Even  if the VNF is not instantiated in fully scaled-out state, the API consumer shall provide enough  CP configuration records to allow connecting the VNF instance, fully scaled out in all scaling  aspects, to the external VLs. ")
	@Valid
	public List<ExtVirtualLinkData> getExtVirtualLinks() {
		return extVirtualLinks;
	}

	public void setExtVirtualLinks(final List<ExtVirtualLinkData> extVirtualLinks) {
		this.extVirtualLinks = extVirtualLinks;
	}

	public InstantiateVnfRequest extManagedVirtualLinks(final List<ExtManagedVirtualLinkData> extManagedVirtualLinks) {
		this.extManagedVirtualLinks = extManagedVirtualLinks;
		return this;
	}

	public InstantiateVnfRequest addExtManagedVirtualLinksItem(final ExtManagedVirtualLinkData extManagedVirtualLinksItem) {
		if (this.extManagedVirtualLinks == null) {
			this.extManagedVirtualLinks = new ArrayList<>();
		}
		this.extManagedVirtualLinks.add(extManagedVirtualLinksItem);
		return this;
	}

	/**
	 * Information about external VLs to connect the VNF to. See note 1.
	 *
	 * @return extManagedVirtualLinks
	 **/
	@Schema(description = "Information about external VLs to connect the VNF to. See note 1. ")
	@Valid
	public List<ExtManagedVirtualLinkData> getExtManagedVirtualLinks() {
		return extManagedVirtualLinks;
	}

	public void setExtManagedVirtualLinks(final List<ExtManagedVirtualLinkData> extManagedVirtualLinks) {
		this.extManagedVirtualLinks = extManagedVirtualLinks;
	}

	public InstantiateVnfRequest localizationLanguage(final String localizationLanguage) {
		this.localizationLanguage = localizationLanguage;
		return this;
	}

	/**
	 * Localization language of the VNF to be instantiated. The value shall comply
	 * with the format defined in IETF RFC 5646.
	 *
	 * @return localizationLanguage
	 **/
	@Schema(description = "Localization language of the VNF to be instantiated. The value shall comply with the format defined in IETF RFC 5646. ")

	public String getLocalizationLanguage() {
		return localizationLanguage;
	}

	public void setLocalizationLanguage(final String localizationLanguage) {
		this.localizationLanguage = localizationLanguage;
	}

	public InstantiateVnfRequest additionalParams(final Map<String, String> additionalParams) {
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

	public InstantiateVnfRequest extensions(final Map<String, String> extensions) {
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

	public InstantiateVnfRequest vnfConfigurableProperties(final Map<String, String> vnfConfigurableProperties) {
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

	public InstantiateVnfRequest selectedDeployableModule(final List<String> selectedDeployableModule) {
		this.selectedDeployableModule = selectedDeployableModule;
		return this;
	}

	public InstantiateVnfRequest addSelectedDeployableModuleItem(final String selectedDeployableModuleItem) {
		if (this.selectedDeployableModule == null) {
			this.selectedDeployableModule = new ArrayList<>();
		}
		this.selectedDeployableModule.add(selectedDeployableModuleItem);
		return this;
	}

	/**
	 * Identifier of a selected deployable module. Only VNFCs based on VDUs that
	 * belong to deployable modules listed in this attribute are requested to be
	 * instantiated.
	 *
	 * @return selectedDeployableModule
	 **/
	@Schema(description = "Identifier of a selected deployable module. Only VNFCs based on VDUs that belong to deployable modules listed in this attribute are requested to be instantiated. ")

	public List<String> getSelectedDeployableModule() {
		return selectedDeployableModule;
	}

	public void setSelectedDeployableModule(final List<String> selectedDeployableModule) {
		this.selectedDeployableModule = selectedDeployableModule;
	}

	/**
	 * Information about VIM or CISM connections to be used for managing the
	 * resources for the VNF instance, or refer to external/externally-managed
	 * virtual links. This attribute shall only be supported and may be present if -
	 * the resources for at least one of the VNFCs shall be managed by a VIM and
	 * VNF-related resource management in direct mode is applicable. - the resources
	 * for at least one of the VNFCs shall be managed by a CISM. The VNFM shall
	 * apply the content of this attribute to the \"vimConnectionInfo\" attribute of
	 * \"VnfInstance\" according to the rules of JSON Merge Patch (see IETF RFC 7396
	 * [5]).
	 *
	 * @return vimConnectionInfo
	 **/
	@Schema(description = "Information about VIM or CISM connections to be used for managing the resources for the VNF instance, or refer to external/externally-managed virtual links. This attribute shall only be supported and may be present if - the resources for at least one of the VNFCs shall be managed by a VIM and VNF-related resource management in direct mode is applicable. - the resources for at least one of the VNFCs shall be managed by a CISM. The VNFM shall apply the content of this attribute to the \"vimConnectionInfo\" attribute of \"VnfInstance\" according to the rules of JSON Merge Patch (see IETF RFC 7396 [5]). ")
	@Valid
	public Map<String, VimConnectionInfo> getVimConnectionInfo() {
		return vimConnectionInfo;
	}

	public void setVimConnectionInfo(final Map<String, VimConnectionInfo> vimConnectionInfo) {
		this.vimConnectionInfo = vimConnectionInfo;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final InstantiateVnfRequest instantiateVnfRequest = (InstantiateVnfRequest) o;
		return Objects.equals(this.flavourId, instantiateVnfRequest.flavourId) &&
				Objects.equals(this.instantiationLevelId, instantiateVnfRequest.instantiationLevelId) &&
				Objects.equals(this.targetScaleLevelInfo, instantiateVnfRequest.targetScaleLevelInfo) &&
				Objects.equals(this.extVirtualLinks, instantiateVnfRequest.extVirtualLinks) &&
				Objects.equals(this.extManagedVirtualLinks, instantiateVnfRequest.extManagedVirtualLinks) &&
				Objects.equals(this.localizationLanguage, instantiateVnfRequest.localizationLanguage) &&
				Objects.equals(this.additionalParams, instantiateVnfRequest.additionalParams) &&
				Objects.equals(this.extensions, instantiateVnfRequest.extensions) &&
				Objects.equals(this.vnfConfigurableProperties, instantiateVnfRequest.vnfConfigurableProperties) &&
				Objects.equals(this.selectedDeployableModule, instantiateVnfRequest.selectedDeployableModule);
	}

	@Override
	public int hashCode() {
		return Objects.hash(flavourId, instantiationLevelId, targetScaleLevelInfo, extVirtualLinks, extManagedVirtualLinks, localizationLanguage, additionalParams, extensions, vnfConfigurableProperties, selectedDeployableModule);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class InstantiateVnfRequest {\n");

		sb.append("    flavourId: ").append(toIndentedString(flavourId)).append("\n");
		sb.append("    instantiationLevelId: ").append(toIndentedString(instantiationLevelId)).append("\n");
		sb.append("    targetScaleLevelInfo: ").append(toIndentedString(targetScaleLevelInfo)).append("\n");
		sb.append("    extVirtualLinks: ").append(toIndentedString(extVirtualLinks)).append("\n");
		sb.append("    extManagedVirtualLinks: ").append(toIndentedString(extManagedVirtualLinks)).append("\n");
		sb.append("    localizationLanguage: ").append(toIndentedString(localizationLanguage)).append("\n");
		sb.append("    additionalParams: ").append(toIndentedString(additionalParams)).append("\n");
		sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
		sb.append("    vnfConfigurableProperties: ").append(toIndentedString(vnfConfigurableProperties)).append("\n");
		sb.append("    selectedDeployableModule: ").append(toIndentedString(selectedDeployableModule)).append("\n");
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
