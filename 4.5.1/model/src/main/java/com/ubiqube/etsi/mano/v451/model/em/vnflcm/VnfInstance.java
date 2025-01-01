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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ubiqube.etsi.mano.v451.model.nfvo.vnflcm.VimConnectionInfo;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type represents a VNF instance. NOTE: Clause B.3.2 provides examples
 * illustrating the relationship among the different run-time information
 * elements (CP, VL and link ports) used to represent the connectivity of a VNF.
 * NOTE 1: Modifying the value of this attribute shall not be performed when
 * conflicts exist between the previous and the newly referred VNF package, i.e.
 * when the new VNFD is changed with respect to the previous VNFD in other
 * aspects than merely referencing to other VNF software images. In order to
 * avoid misalignment of the VnfInstance with the current VNF&#x27;s on-boarded
 * VNF Package, the values of attributes in the VnfInstance that have
 * corresponding attributes in the VNFD shall be kept in sync with the values in
 * the VNFD. NOTE 2: ETSI GS NFV-SOL 001 specifies the structure and format of
 * the VNFD based on TOSCA specifications. NOTE 3: VNF configurable properties
 * are sometimes also referred to as configuration parameters applicable to a
 * VNF. Some of these are set prior to instantiation and cannot be modified if
 * the VNF is instantiated, some are set prior to instantiation (are part of
 * initial configuration) and can be modified later, and others can be set only
 * after instantiation. The applicability of certain configuration may depend on
 * the VNF and the required operation of the VNF at a certain point in time.
 * NOTE 4: Upon creation of the VnfInstance structure, the VNFM shall create and
 * initialize all child attributes of \&quot;vnfConfigurableProperties\&quot;,
 * \&quot;metadata\&quot; and \&quot;extensions\&quot; that were declared in the
 * VNFD with a defined initial value. The defined initial values can be declared
 * in the VNFD, and/or, in case of \&quot;metadata\&quot;, obtained from the
 * \&quot;CreateVnfRequest\&quot; structure. Child attributes of
 * \&quot;vnfConfigurableProperties\&quot;, \&quot;metadata\&quot; and
 * \&quot;extensions\&quot; that have no defined initial value shall not be
 * created, in order to be consistent with the semantics of the JSON Merge Patch
 * method (see IETF RFC 7396) that interprets null values as deletion request.
 * NOTE 5: It is possible to have several ExtManagedVirtualLinkInfo for the same
 * VNF internal VL in case of a multi-site VNF spanning several VIMs. The set of
 * ExtManagedVirtualLinkInfo corresponding to the same VNF internal VL shall
 * indicate so by referencing to the same VnfVirtualLinkDesc and
 * externally-managed multi-site VL instance (refer to clause 5.5.3.3). NOTE 6:
 * Even though externally-managed internal VLs are also used for VNF-internal
 * connectivity, they shall not be listed in the
 * \&quot;vnfVirtualLinkResourceInfo\&quot; attribute as this would be
 * redundant. NOTE 7: Subports need not be used for containerized VNFCs. The
 * application container can send and receive IP packets with any VLAN tag as
 * long as the network interface to connect to the secondary container cluster
 * network has been configured appropriately. Thus, no individual vnfcCpInfo,
 * except the one representing the trunk, need be modelled to allow traffic
 * tagged with a particular VLAN through the connection point. NOTE 8: For a
 * scaling aspect whose related VNFCs have not been instantiated due to the
 * selection of deployable modules, the “scaleStatus” indicates the scale level
 * that would be applicable to the aspect if a VNF LCM operation changes the
 * selected deployable modules and the related VNFCs are instantiated, unless
 * the VNF LCM operation explicitly indicates the scale level for the aspect.
 */
@Schema(description = "This type represents a VNF instance. NOTE: Clause B.3.2 provides examples illustrating the relationship among the different run-time        information elements (CP, VL and link ports) used to represent the connectivity of a VNF.  NOTE 1: Modifying the value of this attribute shall not be performed when conflicts exist between          the previous and the newly referred VNF package, i.e. when the new VNFD is changed with          respect to the previous VNFD in other aspects than merely referencing to other VNF software          images. In order to avoid misalignment of the VnfInstance with the current VNF's on-boarded          VNF Package, the values of attributes in the VnfInstance that have corresponding attributes          in the VNFD shall be kept in sync with the values in the VNFD. NOTE 2: ETSI GS NFV-SOL 001 specifies the structure and format of the VNFD based on TOSCA specifications. NOTE 3: VNF configurable properties are sometimes also referred to as configuration parameters applicable          to a VNF. Some of these are set prior to instantiation and cannot be modified if the VNF is instantiated,          some are set prior to instantiation (are part of initial configuration) and can be modified later,          and others can be set only after instantiation. The applicability of certain configuration may          depend on the VNF and the required operation of the VNF at a certain point in time. NOTE 4: Upon creation of the VnfInstance structure, the VNFM shall create and initialize all child attributes          of \"vnfConfigurableProperties\", \"metadata\" and \"extensions\" that were declared in the VNFD with a defined          initial value. The defined initial values can be declared in the VNFD, and/or, in case of \"metadata\",          obtained from the \"CreateVnfRequest\" structure. Child attributes of \"vnfConfigurableProperties\",          \"metadata\" and \"extensions\" that have no defined initial value shall not be created, in order to be          consistent with the semantics of the JSON Merge Patch method (see IETF RFC 7396) that interprets null          values as deletion request. NOTE 5: It is possible to have several ExtManagedVirtualLinkInfo for the same VNF internal VL in case of a          multi-site VNF spanning several VIMs. The set of ExtManagedVirtualLinkInfo corresponding to the same          VNF internal VL shall indicate so by referencing to the same VnfVirtualLinkDesc and externally-managed          multi-site VL instance (refer to clause 5.5.3.3). NOTE 6: Even though externally-managed internal VLs are also used for VNF-internal connectivity, they shall          not be listed in the \"vnfVirtualLinkResourceInfo\" attribute as this would be redundant. NOTE 7: Subports need not be used for containerized VNFCs. The application container can send and receive IP          packets with any VLAN tag as long as the network interface to connect to the secondary container cluster          network has been configured appropriately. Thus, no individual vnfcCpInfo, except the one representing          the trunk, need be modelled to allow traffic tagged with a particular VLAN through the connection point. NOTE 8: For a scaling aspect whose related VNFCs have not been instantiated due to the selection of deployable          modules, the “scaleStatus” indicates the scale level that would be applicable to the aspect if a VNF LCM          operation changes the selected deployable modules and the related VNFCs are instantiated, unless the          VNF LCM operation explicitly indicates the scale level for the aspect. ")
@Validated

public class VnfInstance {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("vnfInstanceName")
	private String vnfInstanceName = null;

	@JsonProperty("vnfInstanceDescription")
	private String vnfInstanceDescription = null;

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

	@JsonProperty("vnfConfigurableProperties")
	private Map<String, String> vnfConfigurableProperties = null;

	@JsonProperty("vimConnectionInfo")
	@Valid
	private Map<String, VimConnectionInfo> vimConnectionInfo = null;

	@JsonProperty("cirConnectionInfo")
	@Valid
	private Map<String, VimConnectionInfo> cirConnectionInfo = null;

	@JsonProperty("mciopRepositoryInfo")
	@Valid
	private Map<String, VimConnectionInfo> mciopRepositoryInfo = null;

	@JsonProperty("certificateInfo")
	private CertificateInfo certificateInfo = null;

	/**
	 * The instantiation state of the VNF. Permitted values: - NOT_INSTANTIATED: The
	 * VNF instance is terminated or not instantiated. - INSTANTIATED: The VNF
	 * instance is instantiated.
	 */
	public enum InstantiationStateEnum {
		NOT_INSTANTIATED("NOT_INSTANTIATED"),

		INSTANTIATED("INSTANTIATED");

		private final String value;

		InstantiationStateEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static InstantiationStateEnum fromValue(final String text) {
			for (final InstantiationStateEnum b : InstantiationStateEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("instantiationState")
	private InstantiationStateEnum instantiationState = null;

	@JsonProperty("instantiatedVnfInfo")
	private VnfInstanceInstantiatedVnfInfo instantiatedVnfInfo = null;

	@JsonProperty("metadata")
	private Map<String, String> metadata = null;

	@JsonProperty("extensions")
	private Map<String, String> extensions = null;

	@JsonProperty("_links")
	private VnfInstanceLinks links = null;

	public VnfInstance id(final String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 *
	 * @return id
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public VnfInstance vnfInstanceName(final String vnfInstanceName) {
		this.vnfInstanceName = vnfInstanceName;
		return this;
	}

	/**
	 * Name of the VNF instance. This attribute can be modified with the PATCH
	 * method.
	 *
	 * @return vnfInstanceName
	 **/
	@Schema(description = "Name of the VNF instance. This attribute can be modified with the PATCH method. ")

	public String getVnfInstanceName() {
		return vnfInstanceName;
	}

	public void setVnfInstanceName(final String vnfInstanceName) {
		this.vnfInstanceName = vnfInstanceName;
	}

	public VnfInstance vnfInstanceDescription(final String vnfInstanceDescription) {
		this.vnfInstanceDescription = vnfInstanceDescription;
		return this;
	}

	/**
	 * Human-readable description of the VNF instance. This attribute can be
	 * modified with the PATCH method.
	 *
	 * @return vnfInstanceDescription
	 **/
	@Schema(description = "Human-readable description of the VNF instance. This attribute can be modified with the PATCH method. ")

	public String getVnfInstanceDescription() {
		return vnfInstanceDescription;
	}

	public void setVnfInstanceDescription(final String vnfInstanceDescription) {
		this.vnfInstanceDescription = vnfInstanceDescription;
	}

	public VnfInstance vnfdId(final String vnfdId) {
		this.vnfdId = vnfdId;
		return this;
	}

	/**
	 * Get vnfdId
	 *
	 * @return vnfdId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getVnfdId() {
		return vnfdId;
	}

	public void setVnfdId(final String vnfdId) {
		this.vnfdId = vnfdId;
	}

	public VnfInstance vnfProvider(final String vnfProvider) {
		this.vnfProvider = vnfProvider;
		return this;
	}

	/**
	 * Provider of the VNF and the VNFD. The value is copied from the VNFD.
	 *
	 * @return vnfProvider
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Provider of the VNF and the VNFD. The value is copied from the VNFD. ")
	@NotNull

	public String getVnfProvider() {
		return vnfProvider;
	}

	public void setVnfProvider(final String vnfProvider) {
		this.vnfProvider = vnfProvider;
	}

	public VnfInstance vnfProductName(final String vnfProductName) {
		this.vnfProductName = vnfProductName;
		return this;
	}

	/**
	 * Name to identify the VNF Product. The value is copied from the VNFD.
	 *
	 * @return vnfProductName
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Name to identify the VNF Product. The value is copied from the VNFD. ")
	@NotNull

	public String getVnfProductName() {
		return vnfProductName;
	}

	public void setVnfProductName(final String vnfProductName) {
		this.vnfProductName = vnfProductName;
	}

	public VnfInstance vnfSoftwareVersion(final String vnfSoftwareVersion) {
		this.vnfSoftwareVersion = vnfSoftwareVersion;
		return this;
	}

	/**
	 * Get vnfSoftwareVersion
	 *
	 * @return vnfSoftwareVersion
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getVnfSoftwareVersion() {
		return vnfSoftwareVersion;
	}

	public void setVnfSoftwareVersion(final String vnfSoftwareVersion) {
		this.vnfSoftwareVersion = vnfSoftwareVersion;
	}

	public VnfInstance vnfdVersion(final String vnfdVersion) {
		this.vnfdVersion = vnfdVersion;
		return this;
	}

	/**
	 * Get vnfdVersion
	 *
	 * @return vnfdVersion
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getVnfdVersion() {
		return vnfdVersion;
	}

	public void setVnfdVersion(final String vnfdVersion) {
		this.vnfdVersion = vnfdVersion;
	}

	public VnfInstance vnfConfigurableProperties(final Map<String, String> vnfConfigurableProperties) {
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

	public VnfInstance vimConnectionInfo(final Map<String, VimConnectionInfo> vimConnectionInfo) {
		this.vimConnectionInfo = vimConnectionInfo;
		return this;
	}

	public VnfInstance putVimConnectionInfoItem(final String key, final VimConnectionInfo vimConnectionInfoItem) {
		if (this.vimConnectionInfo == null) {
			this.vimConnectionInfo = new HashMap<>();
		}
		this.vimConnectionInfo.put(key, vimConnectionInfoItem);
		return this;
	}

	/**
	 * Information about VIM or CISM connections to be used for managing the
	 * resources for the VNF instance. The keys of the map, each of which identifies
	 * information about a particular VIM connection, are managed by the NFVO and
	 * referenced from other data structures via the \"vimConnectionId\" attribute.
	 * This attribute shall only be supported and present if - the resources of at
	 * least of the VNFCs are managed by a VIM and VNF-related resource management
	 * in direct mode is applicable. - the resources of at least of the VNFCs are
	 * managed by a CISM. This attribute can be modified with the PATCH method. If
	 * VIM connection information is provisioned to the VNFM by means outside the
	 * scope of the present document, the information in the \"vimConnectionInfo\"
	 * attribute provides necessary information for binding the VnfInstance
	 * representing the \"Individual VNF instance\" to the applicable VIM connection
	 * information used to perform resource management for the VNF instance. See
	 * also the definition of the \"VimConnectionInfo\" in clause 4.4.1.6.
	 *
	 * @return vimConnectionInfo
	 **/
	@Schema(description = "Information about VIM or CISM connections to be used for managing the resources for the VNF instance. The keys of the map, each of which identifies information about a particular VIM connection, are managed by the NFVO and referenced from other data structures via the \"vimConnectionId\" attribute. This attribute shall only be supported and present if - the resources of at least of the VNFCs are managed by a VIM and VNF-related resource management in direct mode is applicable. - the resources of at least of the VNFCs are managed by a CISM. This attribute can be modified with the PATCH method. If VIM connection information is provisioned to the VNFM by means outside the scope of the present document, the information in the \"vimConnectionInfo\" attribute provides necessary information for binding the VnfInstance representing the \"Individual VNF instance\" to the applicable VIM connection information used to perform resource management for the VNF instance. See also the definition of the \"VimConnectionInfo\" in clause 4.4.1.6. ")
	@Valid
	public Map<String, VimConnectionInfo> getVimConnectionInfo() {
		return vimConnectionInfo;
	}

	public void setVimConnectionInfo(final Map<String, VimConnectionInfo> vimConnectionInfo) {
		this.vimConnectionInfo = vimConnectionInfo;
	}

	public VnfInstance cirConnectionInfo(final Map<String, VimConnectionInfo> cirConnectionInfo) {
		this.cirConnectionInfo = cirConnectionInfo;
		return this;
	}

	public VnfInstance putCirConnectionInfoItem(final String key, final VimConnectionInfo cirConnectionInfoItem) {
		if (this.cirConnectionInfo == null) {
			this.cirConnectionInfo = new HashMap<>();
		}
		this.cirConnectionInfo.put(key, cirConnectionInfoItem);
		return this;
	}

	/**
	 * Information about the CIR connection for managing OS container images for the
	 * VNF instance. Shall be present when all or part of the VNF is realized by a
	 * set of OS containers and shall be absent otherwise.
	 *
	 * @return cirConnectionInfo
	 **/
	@Schema(description = "Information about the CIR connection for managing OS container images for the VNF instance. Shall be present when all or part of the VNF is realized by a set of OS containers and shall be absent otherwise. ")
	@Valid
	public Map<String, VimConnectionInfo> getCirConnectionInfo() {
		return cirConnectionInfo;
	}

	public void setCirConnectionInfo(final Map<String, VimConnectionInfo> cirConnectionInfo) {
		this.cirConnectionInfo = cirConnectionInfo;
	}

	public VnfInstance mciopRepositoryInfo(final Map<String, VimConnectionInfo> mciopRepositoryInfo) {
		this.mciopRepositoryInfo = mciopRepositoryInfo;
		return this;
	}

	public VnfInstance putMciopRepositoryInfoItem(final String key, final VimConnectionInfo mciopRepositoryInfoItem) {
		if (this.mciopRepositoryInfo == null) {
			this.mciopRepositoryInfo = new HashMap<>();
		}
		this.mciopRepositoryInfo.put(key, mciopRepositoryInfoItem);
		return this;
	}

	/**
	 * Information about the MCIOP repository for the VNF instance. Shall be present
	 * when all or part of the VNF is realized by a set of OS containers and shall
	 * be absent otherwise. See note 1.
	 *
	 * @return mciopRepositoryInfo
	 **/
	@Schema(description = "Information about the MCIOP repository for the VNF instance. Shall be present when all or part of the VNF is realized by a set of OS containers and shall be absent otherwise. See note 1. ")
	@Valid
	public Map<String, VimConnectionInfo> getMciopRepositoryInfo() {
		return mciopRepositoryInfo;
	}

	public void setMciopRepositoryInfo(final Map<String, VimConnectionInfo> mciopRepositoryInfo) {
		this.mciopRepositoryInfo = mciopRepositoryInfo;
	}

	public VnfInstance certificateInfo(final CertificateInfo certificateInfo) {
		this.certificateInfo = certificateInfo;
		return this;
	}

	/**
	 * Get certificateInfo
	 *
	 * @return certificateInfo
	 **/
	@Schema(description = "")

	@Valid
	public CertificateInfo getCertificateInfo() {
		return certificateInfo;
	}

	public void setCertificateInfo(final CertificateInfo certificateInfo) {
		this.certificateInfo = certificateInfo;
	}

	public VnfInstance instantiationState(final InstantiationStateEnum instantiationState) {
		this.instantiationState = instantiationState;
		return this;
	}

	/**
	 * The instantiation state of the VNF. Permitted values: - NOT_INSTANTIATED: The
	 * VNF instance is terminated or not instantiated. - INSTANTIATED: The VNF
	 * instance is instantiated.
	 *
	 * @return instantiationState
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "The instantiation state of the VNF. Permitted values: - NOT_INSTANTIATED: The VNF instance is terminated or not instantiated. - INSTANTIATED: The VNF instance is instantiated. ")
	@NotNull

	public InstantiationStateEnum getInstantiationState() {
		return instantiationState;
	}

	public void setInstantiationState(final InstantiationStateEnum instantiationState) {
		this.instantiationState = instantiationState;
	}

	public VnfInstance instantiatedVnfInfo(final VnfInstanceInstantiatedVnfInfo instantiatedVnfInfo) {
		this.instantiatedVnfInfo = instantiatedVnfInfo;
		return this;
	}

	/**
	 * Get instantiatedVnfInfo
	 *
	 * @return instantiatedVnfInfo
	 **/
	@Schema(description = "")

	@Valid
	public VnfInstanceInstantiatedVnfInfo getInstantiatedVnfInfo() {
		return instantiatedVnfInfo;
	}

	public void setInstantiatedVnfInfo(final VnfInstanceInstantiatedVnfInfo instantiatedVnfInfo) {
		this.instantiatedVnfInfo = instantiatedVnfInfo;
	}

	public VnfInstance metadata(final Map<String, String> metadata) {
		this.metadata = metadata;
		return this;
	}

	/**
	 * Get metadata
	 *
	 * @return metadata
	 **/
	@Schema(description = "")

	@Valid
	public Map<String, String> getMetadata() {
		return metadata;
	}

	public void setMetadata(final Map<String, String> metadata) {
		this.metadata = metadata;
	}

	public VnfInstance extensions(final Map<String, String> extensions) {
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

	public VnfInstance links(final VnfInstanceLinks _links) {
		this.links = _links;
		return this;
	}

	/**
	 * Get _links
	 *
	 * @return _links
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public VnfInstanceLinks getLinks() {
		return links;
	}

	public void setLinks(final VnfInstanceLinks _links) {
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
		final VnfInstance vnfInstance = (VnfInstance) o;
		return Objects.equals(this.id, vnfInstance.id) &&
				Objects.equals(this.vnfInstanceName, vnfInstance.vnfInstanceName) &&
				Objects.equals(this.vnfInstanceDescription, vnfInstance.vnfInstanceDescription) &&
				Objects.equals(this.vnfdId, vnfInstance.vnfdId) &&
				Objects.equals(this.vnfProvider, vnfInstance.vnfProvider) &&
				Objects.equals(this.vnfProductName, vnfInstance.vnfProductName) &&
				Objects.equals(this.vnfSoftwareVersion, vnfInstance.vnfSoftwareVersion) &&
				Objects.equals(this.vnfdVersion, vnfInstance.vnfdVersion) &&
				Objects.equals(this.vnfConfigurableProperties, vnfInstance.vnfConfigurableProperties) &&
				Objects.equals(this.vimConnectionInfo, vnfInstance.vimConnectionInfo) &&
				Objects.equals(this.cirConnectionInfo, vnfInstance.cirConnectionInfo) &&
				Objects.equals(this.mciopRepositoryInfo, vnfInstance.mciopRepositoryInfo) &&
				Objects.equals(this.certificateInfo, vnfInstance.certificateInfo) &&
				Objects.equals(this.instantiationState, vnfInstance.instantiationState) &&
				Objects.equals(this.instantiatedVnfInfo, vnfInstance.instantiatedVnfInfo) &&
				Objects.equals(this.metadata, vnfInstance.metadata) &&
				Objects.equals(this.extensions, vnfInstance.extensions) &&
				Objects.equals(this.links, vnfInstance.links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, vnfInstanceName, vnfInstanceDescription, vnfdId, vnfProvider, vnfProductName, vnfSoftwareVersion, vnfdVersion, vnfConfigurableProperties, vimConnectionInfo, cirConnectionInfo, mciopRepositoryInfo, certificateInfo, instantiationState, instantiatedVnfInfo, metadata, extensions, links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class VnfInstance {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    vnfInstanceName: ").append(toIndentedString(vnfInstanceName)).append("\n");
		sb.append("    vnfInstanceDescription: ").append(toIndentedString(vnfInstanceDescription)).append("\n");
		sb.append("    vnfdId: ").append(toIndentedString(vnfdId)).append("\n");
		sb.append("    vnfProvider: ").append(toIndentedString(vnfProvider)).append("\n");
		sb.append("    vnfProductName: ").append(toIndentedString(vnfProductName)).append("\n");
		sb.append("    vnfSoftwareVersion: ").append(toIndentedString(vnfSoftwareVersion)).append("\n");
		sb.append("    vnfdVersion: ").append(toIndentedString(vnfdVersion)).append("\n");
		sb.append("    vnfConfigurableProperties: ").append(toIndentedString(vnfConfigurableProperties)).append("\n");
		sb.append("    vimConnectionInfo: ").append(toIndentedString(vimConnectionInfo)).append("\n");
		sb.append("    cirConnectionInfo: ").append(toIndentedString(cirConnectionInfo)).append("\n");
		sb.append("    mciopRepositoryInfo: ").append(toIndentedString(mciopRepositoryInfo)).append("\n");
		sb.append("    certificateInfo: ").append(toIndentedString(certificateInfo)).append("\n");
		sb.append("    instantiationState: ").append(toIndentedString(instantiationState)).append("\n");
		sb.append("    instantiatedVnfInfo: ").append(toIndentedString(instantiatedVnfInfo)).append("\n");
		sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
		sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
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
