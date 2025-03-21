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
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type represents the information on virtualised compute and storage
 * resources used by a VNFC in a VNF instance. Depending on the form of
 * virtualisation container of the VNFC: - For a VNFC based on VM, a reference
 * to the corresponding VirtualCompute shall be provided, and - For a VNFC based
 * on OS container(s), a reference to the Compute MCIO shall be provided. Hence,
 * exposure of information by the VNFM to the NFVO is at the MCIO level. In
 * addition, the references to the storage resources depend on the form of the
 * VNFC: - For a VNFC based on VM, storage resource identifiers shall refer to
 * VirtualStorage resources, and - For a VNFC based on OS container(s), storage
 * resource identifiers shall refer to Storage MCIOs. * NOTE 1: ETSI GS NFV-SOL
 * 001 specifies the structure and format of the VNFD based on TOSCA
 * specifications. * NOTE 2: A VNFC CP is \&quot;connected to\&quot; an external
 * CP if the VNFC CP is connected to an internal VL that exposes an external CP.
 * A VNFC CP is \&quot;exposed as\&quot; an external CP if it is connected
 * directly to an external VL. * NOTE 3: The information can be omitted because
 * it is already available as part of the external CP information. * NOTE 4: If
 * only the value or the presence of this attribute is changed in the
 * \&quot;VnfcResourceInfo\&quot; structure by an LCM operation occurrence, this
 * does not represent a change that requires including a related
 * \&quot;AffectedVnfc\&quot; structure in the VNF LCM operation occurrence
 * notifications or the \&quot;VnfLcmOpOcc\&quot; structure related to this LCM
 * operation occurrence. * NOTE 5: Cardinality greater than 1 is only applicable
 * for specific cases where more than one network attachment definition resource
 * is needed to fulfil the connectivity requirements of the internal CP, e.g. to
 * build a link redundant mated pair in SR-IOV cases. * NOTE 6: When more than
 * one netAttDefResourceId is indicated, all shall belong to the same namespace.
 * * NOTE 7: Subports need not be used for containerized VNFCs. The application
 * container can send and receive IP packets with any VLAN tag as long as the
 * network interface to connect to the secondary container cluster network has
 * been configured appropriately. Thus, no individual vnfcCpInfo, except the one
 * representing the trunk, need be modelled to allow traffic tagged with a
 * particular VLAN through the connection point.
 */
@Schema(description = "This type represents the information on virtualised compute and storage resources used by a VNFC in a VNF instance. Depending on the form of virtualisation container of the VNFC:   - For a VNFC based on VM, a reference to the corresponding VirtualCompute shall be provided, and   - For a VNFC based on OS container(s), a reference to the Compute MCIO shall be provided. Hence, exposure      of information by the VNFM to the NFVO is at the MCIO level. In addition, the references to the storage resources depend on the form of the VNFC:   - For a VNFC based on VM, storage resource identifiers shall refer to VirtualStorage resources, and   - For a VNFC based on OS container(s), storage resource identifiers shall refer to Storage MCIOs.   * NOTE 1: ETSI GS NFV-SOL 001 specifies the structure and format of the VNFD based on TOSCA specifications. * NOTE 2: A VNFC CP is \"connected to\" an external CP if the VNFC CP is connected to an internal VL that           exposes an external CP. A VNFC CP is \"exposed as\" an external CP if it is connected directly           to an external VL. * NOTE 3: The information can be omitted because it is already available as part of the external CP information. * NOTE 4: If only the value or the presence of this attribute is changed in the \"VnfcResourceInfo\" structure by            an LCM operation occurrence, this does not represent a change that requires including a related \"AffectedVnfc\"           structure in the VNF LCM operation occurrence notifications or the \"VnfLcmOpOcc\" structure related to            this LCM operation occurrence. * NOTE 5: Cardinality greater than 1 is only applicable for specific cases where more than one network attachment            definition resource is needed to fulfil the connectivity requirements of the internal CP, e.g. to build            a link redundant mated pair in SR-IOV cases. * NOTE 6: When more than one netAttDefResourceId is indicated, all shall belong to the same namespace. * NOTE 7: Subports need not be used for containerized VNFCs. The application container can send and receive IP           packets with any VLAN tag as long as the network interface to connect to the secondary container cluster           network has been configured appropriately. Thus, no individual vnfcCpInfo, except the one representing the           trunk, need be modelled to allow traffic tagged with a particular VLAN through the connection point. ")
@Validated

public class VnfcResourceInfo {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("vduId")
	private String vduId = null;

	@JsonProperty("vnfdId")
	private String vnfdId = null;

	@JsonProperty("computeResource")
	private ResourceHandle computeResource = null;

	@JsonProperty("storageResourceIds")
	@Valid
	private List<String> storageResourceIds = null;

	@JsonProperty("reservationId")
	private String reservationId = null;

	@JsonProperty("vnfcCpInfo")
	@Valid
	private List<VnfcResourceInfoVnfcCpInfo> vnfcCpInfo = null;

	@JsonProperty("metadata")
	private Map<String, String> metadata = null;

	@JsonProperty("certificateContentId")
	private String certificateContentId = null;

	public VnfcResourceInfo id(final String id) {
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

	public VnfcResourceInfo vduId(final String vduId) {
		this.vduId = vduId;
		return this;
	}

	/**
	 * Get vduId
	 *
	 * @return vduId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getVduId() {
		return vduId;
	}

	public void setVduId(final String vduId) {
		this.vduId = vduId;
	}

	public VnfcResourceInfo vnfdId(final String vnfdId) {
		this.vnfdId = vnfdId;
		return this;
	}

	/**
	 * Get vnfdId
	 *
	 * @return vnfdId
	 **/
	@Schema(description = "")

	public String getVnfdId() {
		return vnfdId;
	}

	public void setVnfdId(final String vnfdId) {
		this.vnfdId = vnfdId;
	}

	public VnfcResourceInfo computeResource(final ResourceHandle computeResource) {
		this.computeResource = computeResource;
		return this;
	}

	/**
	 * Get computeResource
	 *
	 * @return computeResource
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public ResourceHandle getComputeResource() {
		return computeResource;
	}

	public void setComputeResource(final ResourceHandle computeResource) {
		this.computeResource = computeResource;
	}

	public VnfcResourceInfo storageResourceIds(final List<String> storageResourceIds) {
		this.storageResourceIds = storageResourceIds;
		return this;
	}

	public VnfcResourceInfo addStorageResourceIdsItem(final String storageResourceIdsItem) {
		if (this.storageResourceIds == null) {
			this.storageResourceIds = new ArrayList<>();
		}
		this.storageResourceIds.add(storageResourceIdsItem);
		return this;
	}

	/**
	 * References to the VirtualStorage resources or references to Storage MCIO(s).
	 * The value refers to a VirtualStorageResourceInfo item in the VnfInstance.
	 *
	 * @return storageResourceIds
	 **/
	@Schema(description = "References to the VirtualStorage resources or references to Storage MCIO(s).  The value refers to a VirtualStorageResourceInfo item in the VnfInstance. ")

	public List<String> getStorageResourceIds() {
		return storageResourceIds;
	}

	public void setStorageResourceIds(final List<String> storageResourceIds) {
		this.storageResourceIds = storageResourceIds;
	}

	public VnfcResourceInfo reservationId(final String reservationId) {
		this.reservationId = reservationId;
		return this;
	}

	/**
	 * Get reservationId
	 *
	 * @return reservationId
	 **/
	@Schema(description = "")

	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(final String reservationId) {
		this.reservationId = reservationId;
	}

	public VnfcResourceInfo vnfcCpInfo(final List<VnfcResourceInfoVnfcCpInfo> vnfcCpInfo) {
		this.vnfcCpInfo = vnfcCpInfo;
		return this;
	}

	public VnfcResourceInfo addVnfcCpInfoItem(final VnfcResourceInfoVnfcCpInfo vnfcCpInfoItem) {
		if (this.vnfcCpInfo == null) {
			this.vnfcCpInfo = new ArrayList<>();
		}
		this.vnfcCpInfo.add(vnfcCpInfoItem);
		return this;
	}

	/**
	 * All the CPs of the VNFC instance. See note 7.
	 *
	 * @return vnfcCpInfo
	 **/
	@Schema(description = "All the CPs of the VNFC instance. See note 7. ")
	@Valid
	public List<VnfcResourceInfoVnfcCpInfo> getVnfcCpInfo() {
		return vnfcCpInfo;
	}

	public void setVnfcCpInfo(final List<VnfcResourceInfoVnfcCpInfo> vnfcCpInfo) {
		this.vnfcCpInfo = vnfcCpInfo;
	}

	public VnfcResourceInfo metadata(final Map<String, String> metadata) {
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

	public VnfcResourceInfo certificateContentId(final String certificateContentId) {
		this.certificateContentId = certificateContentId;
		return this;
	}

	/**
	 * Get certificateContentId
	 *
	 * @return certificateContentId
	 **/
	@Schema(description = "")

	public String getCertificateContentId() {
		return certificateContentId;
	}

	public void setCertificateContentId(final String certificateContentId) {
		this.certificateContentId = certificateContentId;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final VnfcResourceInfo vnfcResourceInfo = (VnfcResourceInfo) o;
		return Objects.equals(this.id, vnfcResourceInfo.id) &&
				Objects.equals(this.vduId, vnfcResourceInfo.vduId) &&
				Objects.equals(this.vnfdId, vnfcResourceInfo.vnfdId) &&
				Objects.equals(this.computeResource, vnfcResourceInfo.computeResource) &&
				Objects.equals(this.storageResourceIds, vnfcResourceInfo.storageResourceIds) &&
				Objects.equals(this.reservationId, vnfcResourceInfo.reservationId) &&
				Objects.equals(this.vnfcCpInfo, vnfcResourceInfo.vnfcCpInfo) &&
				Objects.equals(this.metadata, vnfcResourceInfo.metadata) &&
				Objects.equals(this.certificateContentId, vnfcResourceInfo.certificateContentId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, vduId, vnfdId, computeResource, storageResourceIds, reservationId, vnfcCpInfo, metadata, certificateContentId);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class VnfcResourceInfo {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    vduId: ").append(toIndentedString(vduId)).append("\n");
		sb.append("    vnfdId: ").append(toIndentedString(vnfdId)).append("\n");
		sb.append("    computeResource: ").append(toIndentedString(computeResource)).append("\n");
		sb.append("    storageResourceIds: ").append(toIndentedString(storageResourceIds)).append("\n");
		sb.append("    reservationId: ").append(toIndentedString(reservationId)).append("\n");
		sb.append("    vnfcCpInfo: ").append(toIndentedString(vnfcCpInfo)).append("\n");
		sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
		sb.append("    certificateContentId: ").append(toIndentedString(certificateContentId)).append("\n");
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
