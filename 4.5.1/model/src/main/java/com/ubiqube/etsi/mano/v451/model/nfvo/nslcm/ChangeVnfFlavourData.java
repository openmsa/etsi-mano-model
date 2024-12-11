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
package com.ubiqube.etsi.mano.v451.model.nfvo.nslcm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.CertificateConfigurationData;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.ExtManagedVirtualLinkData;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.ExtVirtualLinkData;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;

/**
 * The type represents the information that is requested to be changed
 * deployment flavor for an existing VNF instance. NOTE 1: The indication of
 * externally-managed internal VLs is needed in case networks have been
 * pre-configured for use with certain VNFs, for instance to ensure that these
 * networks have certain properties such as security or acceleration features,
 * or to address particular network topologies. The present document assumes
 * that externally-managed internal VLs are managed by the NFVO and created
 * towards the VIM. NOTE 2: It is possible to have several
 * ExtManagedVirtualLinkData for the same VNF internal VL in case of a
 * multi-site VNF spanning several VIMs. The set of ExtManagedVirtualLinkData
 * corresponding to the same VNF internal VL shall indicate so by referencing to
 * the same VnfVirtualLinkDesc and externally-managed multi-site VL instance
 * (refer to clause 6.5.3.27). NOTE 3: TThe target size for VNF instantiation
 * may be specified in either \&quot;instantiationLevelId\&quot; or
 * \&quot;targetScaleLevelInfo\&quot;, but not both. If none of the two
 * attributes (\&quot;instantiationLevelId\&quot; or
 * \&quot;targetScaleLevelInfo\&quot;) are present, the default instantiation
 * level as declared in the VNFD shall be used. NOTE 4: If
 * \&quot;targetScaleLevelInfo\&quot; is specified, information provided in
 * \&quot;targetScaleLevelInfo\&quot; shall be used for instantiating scalable
 * constituents of the VNF (e.g. VDUs/VLs). For scaling aspects not specified in
 * \&quot;targetScaleLevelInfo\&quot; or for the VNF constituents (e.g.
 * VDUs/VLs) that are not scalable, the default instantiation level as declared
 * in the VNFD shall be used for instantiation.
 */
@Schema(description = "The type represents the information that is requested to be changed deployment flavor for an existing VNF instance. NOTE 1: The indication of externally-managed internal VLs         is needed in case networks have been pre-configured for use with certain VNFs,         for instance to ensure that these networks have certain properties such as         security or acceleration features, or to address particular network topologies.         The present document assumes that externally-managed internal VLs are managed         by the NFVO and created towards the VIM. NOTE 2: It is possible to have several ExtManagedVirtualLinkData for the same         VNF internal VL in case of a multi-site VNF spanning several VIMs. The set         of ExtManagedVirtualLinkData corresponding to the same VNF internal VL shall         indicate so by referencing to the same VnfVirtualLinkDesc and externally-managed         multi-site VL instance (refer to clause 6.5.3.27). NOTE 3: TThe target size for VNF instantiation may be specified in either \"instantiationLevelId\" or \"targetScaleLevelInfo\",         but not both. If none of the two attributes (\"instantiationLevelId\" or \"targetScaleLevelInfo\") are present, the         default instantiation level as declared in the VNFD shall be used. NOTE 4: If \"targetScaleLevelInfo\" is specified, information provided in \"targetScaleLevelInfo\" shall be used for         instantiating scalable constituents of the VNF (e.g. VDUs/VLs). For scaling aspects not specified in         \"targetScaleLevelInfo\" or for the VNF constituents (e.g. VDUs/VLs) that are not scalable, the default         instantiation level as declared in the VNFD shall be used for instantiation. ")
@Validated

public class ChangeVnfFlavourData implements OneOfChangeVnfFlavourData {
	@JsonProperty("vnfInstanceId")
	private String vnfInstanceId = null;

	@JsonProperty("newFlavourId")
	private String newFlavourId = null;

	@JsonProperty("instantiationLevelId")
	private String instantiationLevelId = null;

	@JsonProperty("targetScaleLevelInfo")
	@Valid
	private List<VnfScaleInfo> targetScaleLevelInfo = null;

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

	public ChangeVnfFlavourData vnfInstanceId(final String vnfInstanceId) {
		this.vnfInstanceId = vnfInstanceId;
		return this;
	}

	/**
	 * Get vnfInstanceId
	 *
	 * @return vnfInstanceId
	 **/
	@Schema(description = "")

	public String getVnfInstanceId() {
		return vnfInstanceId;
	}

	public void setVnfInstanceId(final String vnfInstanceId) {
		this.vnfInstanceId = vnfInstanceId;
	}

	public ChangeVnfFlavourData newFlavourId(final String newFlavourId) {
		this.newFlavourId = newFlavourId;
		return this;
	}

	/**
	 * Get newFlavourId
	 *
	 * @return newFlavourId
	 **/
	@Schema(description = "")

	public String getNewFlavourId() {
		return newFlavourId;
	}

	public void setNewFlavourId(final String newFlavourId) {
		this.newFlavourId = newFlavourId;
	}

	public ChangeVnfFlavourData instantiationLevelId(final String instantiationLevelId) {
		this.instantiationLevelId = instantiationLevelId;
		return this;
	}

	/**
	 * Identifier of the instantiation level of the deployment flavour to be
	 * instantiated. See note 3.
	 *
	 * @return instantiationLevelId
	 **/
	@Schema(description = "Identifier of the instantiation level of the deployment flavour to be instantiated. See note 3. ")

	public String getInstantiationLevelId() {
		return instantiationLevelId;
	}

	public void setInstantiationLevelId(final String instantiationLevelId) {
		this.instantiationLevelId = instantiationLevelId;
	}

	public ChangeVnfFlavourData targetScaleLevelInfo(final List<VnfScaleInfo> targetScaleLevelInfo) {
		this.targetScaleLevelInfo = targetScaleLevelInfo;
		return this;
	}

	public ChangeVnfFlavourData addTargetScaleLevelInfoItem(final VnfScaleInfo targetScaleLevelInfoItem) {
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
	 * be instantiated. See notes 3 and 4.
	 *
	 * @return targetScaleLevelInfo
	 **/
	@Schema(description = "This attribute is applicable if VNF supports target scale level instantiation. For each scaling aspect of the current deployment flavour, the attribute  specifies the scale level of VNF constituents (e.g., VDU level) to be instantiated. See notes 3 and 4. ")
	@Valid
	public List<VnfScaleInfo> getTargetScaleLevelInfo() {
		return targetScaleLevelInfo;
	}

	public void setTargetScaleLevelInfo(final List<VnfScaleInfo> targetScaleLevelInfo) {
		this.targetScaleLevelInfo = targetScaleLevelInfo;
	}

	public ChangeVnfFlavourData extVirtualLinks(final List<ExtVirtualLinkData> extVirtualLinks) {
		this.extVirtualLinks = extVirtualLinks;
		return this;
	}

	public ChangeVnfFlavourData addExtVirtualLinksItem(final ExtVirtualLinkData extVirtualLinksItem) {
		if (this.extVirtualLinks == null) {
			this.extVirtualLinks = new ArrayList<>();
		}
		this.extVirtualLinks.add(extVirtualLinksItem);
		return this;
	}

	/**
	 * Information about external VLs to connect the VNF to.
	 *
	 * @return extVirtualLinks
	 **/
	@Schema(description = "Information about external VLs to connect the VNF to. ")
	@Valid
	public List<ExtVirtualLinkData> getExtVirtualLinks() {
		return extVirtualLinks;
	}

	public void setExtVirtualLinks(final List<ExtVirtualLinkData> extVirtualLinks) {
		this.extVirtualLinks = extVirtualLinks;
	}

	public ChangeVnfFlavourData extManagedVirtualLinks(final List<ExtManagedVirtualLinkData> extManagedVirtualLinks) {
		this.extManagedVirtualLinks = extManagedVirtualLinks;
		return this;
	}

	public ChangeVnfFlavourData addExtManagedVirtualLinksItem(final ExtManagedVirtualLinkData extManagedVirtualLinksItem) {
		if (this.extManagedVirtualLinks == null) {
			this.extManagedVirtualLinks = new ArrayList<>();
		}
		this.extManagedVirtualLinks.add(extManagedVirtualLinksItem);
		return this;
	}

	/**
	 * information about internal VLs that are managed by NFVO. See note 1 and note
	 * 2.
	 *
	 * @return extManagedVirtualLinks
	 **/
	@Schema(description = "information about internal VLs that are managed by NFVO. See note 1 and note 2. ")
	@Valid
	public List<ExtManagedVirtualLinkData> getExtManagedVirtualLinks() {
		return extManagedVirtualLinks;
	}

	public void setExtManagedVirtualLinks(final List<ExtManagedVirtualLinkData> extManagedVirtualLinks) {
		this.extManagedVirtualLinks = extManagedVirtualLinks;
	}

	public ChangeVnfFlavourData additionalParams(final Map<String, String> additionalParams) {
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

	public ChangeVnfFlavourData extensions(final Map<String, String> extensions) {
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

	public ChangeVnfFlavourData vnfConfigurableProperties(final Map<String, String> vnfConfigurableProperties) {
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

	public ChangeVnfFlavourData selectedDeployableModule(final List<String> selectedDeployableModule) {
		this.selectedDeployableModule = selectedDeployableModule;
		return this;
	}

	public ChangeVnfFlavourData addSelectedDeployableModuleItem(final String selectedDeployableModuleItem) {
		if (this.selectedDeployableModule == null) {
			this.selectedDeployableModule = new ArrayList<>();
		}
		this.selectedDeployableModule.add(selectedDeployableModuleItem);
		return this;
	}

	/**
	 * References a selected deployable module, as defined in the VNFD. Only VNFCs
	 * based on VDUs that belong to deployable modules listed in this attribute are
	 * requested to be instantiated or preserved if they were already instantiated.
	 *
	 * @return selectedDeployableModule
	 **/
	@Schema(description = "References a selected deployable module, as defined in the VNFD. Only VNFCs based on VDUs that belong to deployable modules listed in this attribute are requested to be instantiated or preserved if they were already instantiated. ")

	public List<String> getSelectedDeployableModule() {
		return selectedDeployableModule;
	}

	public void setSelectedDeployableModule(final List<String> selectedDeployableModule) {
		this.selectedDeployableModule = selectedDeployableModule;
	}

	public ChangeVnfFlavourData certificateConfigurationData(final CertificateConfigurationData certificateConfigurationData) {
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
		final ChangeVnfFlavourData changeVnfFlavourData = (ChangeVnfFlavourData) o;
		return Objects.equals(this.vnfInstanceId, changeVnfFlavourData.vnfInstanceId) &&
				Objects.equals(this.newFlavourId, changeVnfFlavourData.newFlavourId) &&
				Objects.equals(this.instantiationLevelId, changeVnfFlavourData.instantiationLevelId) &&
				Objects.equals(this.targetScaleLevelInfo, changeVnfFlavourData.targetScaleLevelInfo) &&
				Objects.equals(this.extVirtualLinks, changeVnfFlavourData.extVirtualLinks) &&
				Objects.equals(this.extManagedVirtualLinks, changeVnfFlavourData.extManagedVirtualLinks) &&
				Objects.equals(this.additionalParams, changeVnfFlavourData.additionalParams) &&
				Objects.equals(this.extensions, changeVnfFlavourData.extensions) &&
				Objects.equals(this.vnfConfigurableProperties, changeVnfFlavourData.vnfConfigurableProperties) &&
				Objects.equals(this.selectedDeployableModule, changeVnfFlavourData.selectedDeployableModule) &&
				Objects.equals(this.certificateConfigurationData, changeVnfFlavourData.certificateConfigurationData);
	}

	@Override
	public int hashCode() {
		return Objects.hash(vnfInstanceId, newFlavourId, instantiationLevelId, targetScaleLevelInfo, extVirtualLinks, extManagedVirtualLinks, additionalParams, extensions, vnfConfigurableProperties, selectedDeployableModule, certificateConfigurationData);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class ChangeVnfFlavourData {\n");

		sb.append("    vnfInstanceId: ").append(toIndentedString(vnfInstanceId)).append("\n");
		sb.append("    newFlavourId: ").append(toIndentedString(newFlavourId)).append("\n");
		sb.append("    instantiationLevelId: ").append(toIndentedString(instantiationLevelId)).append("\n");
		sb.append("    targetScaleLevelInfo: ").append(toIndentedString(targetScaleLevelInfo)).append("\n");
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
