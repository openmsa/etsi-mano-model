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
package com.ubiqube.etsi.mano.v431.model.vnfm.grant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.ScaleInfo;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type represents a grant request. NOTE 1: The VNF LCM operations
 * CreateVnfIdentifier, DeleteVnfIdentifier, QueryVnf and ModifyVnfInformation
 * can be executed by the VNFM without requesting granting. NOTE 2: If the
 * granting request is for InstantiateVNF, only one of the three parameters
 * (instantiationLevel or targetScaleLevelInfo or addResources) shall be
 * present. NOTE 3: The NFVO will assume that the VNFM will be responsible to
 * both allocate and release the temporary resource during the runtime of the
 * LCM operation. This means, the resource can be allocated and consumed after
 * the \&quot;start\&quot; notification for the LCM operation is sent by the
 * VNFM, and the resource will be released before the \&quot;result\&quot;
 * notification of the VNF LCM operation is sent by the VNFM. NOTE 4: For the
 * affinity/anti-affinity rules defined in the VNFD and the placement
 * constraints in the GrantVnfLifecycleOperation as defined in this clause, the
 * following applies: Assuming unlimited capacity, the combination of all the
 * aforementioned rules shall be satisfiable by at least one possible placement
 * of the new resources, with the exception that some of the rules with
 * fallbackBestEffort may be unsatisfiable due to the actual placement of
 * existing resources. In this case, rules with fallbackBestEffort are allowed
 * to be violated only in relation to the placement of existing resources. NOTE
 * 5: Passing constraints allows the VNFM or the lifecycle management scripts to
 * influence resource placement decisions by the NFVO to ensure VNF properties
 * such as performance or fault tolerance. NOTE 6: If fallbackBestEffort is
 * present and set to \&quot;true\&quot; in one or more placement constraints
 * and the NFVO cannot find a resource placement that satisfies all of these due
 * to limited capacity, the NFVO shall process each such affinity/antiAffinity
 * constraint in a best effort manner, in which case, if specified resources
 * cannot be allocated based on the specified placement constraint, the NFVO
 * shal look for an alternate best effort placement for the specified resources
 * to be granted. In the best effort antiaffinity case, the resources are
 * expected to be spread optimally over all available instances of scope (e.g.
 * zones), and in the best effort affinity case, they are expected to be
 * distributed optimally over as few instances of scope as possible. Being able
 * to satisfy a \&quot;best-effort\&quot; constraint in a best effort manner
 * only, as defined above, shall not lead to rejecting the grant. NOTE 7: The
 * target size for VNF instantiation may be specified in either
 * instantiationLevelId or targetScaleLevelInfo, but not both. NOTE 8: If
 * targetScaleLevelInfo is specified, information provided in
 * targetScaleLevelInfo shall be used for scalable constituents of the VNF (e.g,
 * VDUs/VLs) in the granting process. For scaling aspects not specified in
 * targetScaleLevelInfo or for the VNF constituents (e.g.,VDUs/VLs) that are not
 * scalable, the default instantiation level as declared in the VNFD shall be
 * used in the granting process.
 */
@Schema(description = "This type represents a grant request. NOTE 1: The VNF LCM operations CreateVnfIdentifier, DeleteVnfIdentifier, QueryVnf and         ModifyVnfInformation can be executed by the VNFM without requesting granting. NOTE 2: If the granting request is for InstantiateVNF, only one of the three parameters (instantiationLevel or         targetScaleLevelInfo or addResources) shall be present. NOTE 3: The NFVO will assume that the VNFM will be responsible to both allocate and release the temporary         resource during the runtime of the LCM operation. This means, the resource can be allocated and         consumed after the \"start\" notification for the LCM operation is sent by the VNFM, and the resource         will be released before the \"result\" notification of the VNF LCM operation is sent by the VNFM. NOTE 4: For the affinity/anti-affinity rules defined in the VNFD and the placement constraints in the         GrantVnfLifecycleOperation as defined in this clause, the following applies: Assuming unlimited         capacity, the combination of all the aforementioned rules shall be satisfiable by at least one possible         placement of the new resources, with the exception that some of the rules with fallbackBestEffort         may be unsatisfiable due to the actual placement of existing resources. In this case, rules with         fallbackBestEffort are allowed to be violated only in relation to the placement of existing resources. NOTE 5: Passing constraints allows the VNFM or the lifecycle management scripts to influence resource         placement decisions by the NFVO to ensure VNF properties such as performance or fault tolerance. NOTE 6: If fallbackBestEffort is present and set to \"true\" in one or more placement constraints and the NFVO         cannot find a resource placement that satisfies all of these due to limited capacity, the NFVO shall         process each such affinity/antiAffinity constraint in a best effort manner, in which case, if specified         resources cannot be allocated based on the specified placement constraint, the NFVO shal look for         an alternate best effort placement for the specified resources to be granted. In the best effort antiaffinity case, the resources are expected to be spread optimally over all available instances of scope         (e.g. zones), and in the best effort affinity case, they are expected to be distributed optimally over as         few instances of scope as possible. Being able to satisfy a \"best-effort\" constraint in a best effort         manner only, as defined above, shall not lead to rejecting the grant. NOTE 7: The target size for VNF instantiation may be specified in either instantiationLevelId or         targetScaleLevelInfo, but not both. NOTE 8: If targetScaleLevelInfo is specified, information provided in targetScaleLevelInfo shall be used for         scalable constituents of the VNF (e.g, VDUs/VLs) in the granting process. For scaling aspects not         specified in targetScaleLevelInfo or for the VNF constituents (e.g.,VDUs/VLs) that are not scalable,         the default instantiation level as declared in the VNFD shall be used in the granting process. ")
@Validated

public class GrantRequest implements AnyOfGrantRequest {
	@JsonProperty("vnfInstanceId")
	private String vnfInstanceId = null;

	@JsonProperty("vnfLcmOpOccId")
	private String vnfLcmOpOccId = null;

	@JsonProperty("vnfdId")
	private String vnfdId = null;

	@JsonProperty("dstVnfdId")
	private String dstVnfdId = null;

	@JsonProperty("flavourId")
	private String flavourId = null;

	@JsonProperty("operation")
	private GrantedLcmOperationType operation = null;

	@JsonProperty("isAutomaticInvocation")
	private Boolean isAutomaticInvocation = null;

	@JsonProperty("instantiationLevelId")
	private String instantiationLevelId = null;

	@JsonProperty("targetScaleLevelInfo")
	@Valid
	private List<ScaleInfo> targetScaleLevelInfo = null;

	@JsonProperty("addResources")
	@Valid
	private List<ResourceDefinition> addResources = null;

	@JsonProperty("tempResources")
	@Valid
	private List<ResourceDefinition> tempResources = null;

	@JsonProperty("removeResources")
	@Valid
	private List<ResourceDefinition> removeResources = null;

	@JsonProperty("updateResources")
	@Valid
	private List<ResourceDefinition> updateResources = null;

	@JsonProperty("placementConstraints")
	@Valid
	private List<PlacementConstraint> placementConstraints = null;

	@JsonProperty("vimConstraints")
	@Valid
	private List<VimConstraint> vimConstraints = null;

	@JsonProperty("additionalParams")
	private Map<String, String> additionalParams = null;

	@JsonProperty("_links")
	private GrantRequestLinks links = null;

	public GrantRequest vnfInstanceId(final String vnfInstanceId) {
		this.vnfInstanceId = vnfInstanceId;
		return this;
	}

	/**
	 * Get vnfInstanceId
	 *
	 * @return vnfInstanceId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getVnfInstanceId() {
		return vnfInstanceId;
	}

	public void setVnfInstanceId(final String vnfInstanceId) {
		this.vnfInstanceId = vnfInstanceId;
	}

	public GrantRequest vnfLcmOpOccId(final String vnfLcmOpOccId) {
		this.vnfLcmOpOccId = vnfLcmOpOccId;
		return this;
	}

	/**
	 * Get vnfLcmOpOccId
	 *
	 * @return vnfLcmOpOccId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getVnfLcmOpOccId() {
		return vnfLcmOpOccId;
	}

	public void setVnfLcmOpOccId(final String vnfLcmOpOccId) {
		this.vnfLcmOpOccId = vnfLcmOpOccId;
	}

	public GrantRequest vnfdId(final String vnfdId) {
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

	public GrantRequest dstVnfdId(final String dstVnfdId) {
		this.dstVnfdId = dstVnfdId;
		return this;
	}

	/**
	 * Get dstVnfdId
	 *
	 * @return dstVnfdId
	 **/
	@Schema(description = "")

	public String getDstVnfdId() {
		return dstVnfdId;
	}

	public void setDstVnfdId(final String dstVnfdId) {
		this.dstVnfdId = dstVnfdId;
	}

	public GrantRequest flavourId(final String flavourId) {
		this.flavourId = flavourId;
		return this;
	}

	/**
	 * Get flavourId
	 *
	 * @return flavourId
	 **/
	@Schema(description = "")

	public String getFlavourId() {
		return flavourId;
	}

	public void setFlavourId(final String flavourId) {
		this.flavourId = flavourId;
	}

	public GrantRequest operation(final GrantedLcmOperationType operation) {
		this.operation = operation;
		return this;
	}

	/**
	 * Get operation
	 *
	 * @return operation
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public GrantedLcmOperationType getOperation() {
		return operation;
	}

	public void setOperation(final GrantedLcmOperationType operation) {
		this.operation = operation;
	}

	public GrantRequest isAutomaticInvocation(final Boolean isAutomaticInvocation) {
		this.isAutomaticInvocation = isAutomaticInvocation;
		return this;
	}

	/**
	 * Set to true if this VNF LCM operation occurrence has been triggered by an
	 * automated procedure inside the VNFM (i.e. ScaleVnf / ScaleVnfToLevel
	 * triggered by auto-scale, or HealVnf triggered by auto-heal). Set to false
	 * otherwise.
	 *
	 * @return isAutomaticInvocation
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Set to true if this VNF LCM operation occurrence has been triggered by an automated procedure inside the VNFM (i.e. ScaleVnf / ScaleVnfToLevel triggered by auto-scale, or HealVnf triggered by auto-heal). Set to false otherwise. ")
	@NotNull

	public Boolean isIsAutomaticInvocation() {
		return isAutomaticInvocation;
	}

	public void setIsAutomaticInvocation(final Boolean isAutomaticInvocation) {
		this.isAutomaticInvocation = isAutomaticInvocation;
	}

	public GrantRequest instantiationLevelId(final String instantiationLevelId) {
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

	public GrantRequest targetScaleLevelInfo(final List<ScaleInfo> targetScaleLevelInfo) {
		this.targetScaleLevelInfo = targetScaleLevelInfo;
		return this;
	}

	public GrantRequest addTargetScaleLevelInfoItem(final ScaleInfo targetScaleLevelInfoItem) {
		if (this.targetScaleLevelInfo == null) {
			this.targetScaleLevelInfo = new ArrayList<>();
		}
		this.targetScaleLevelInfo.add(targetScaleLevelInfoItem);
		return this;
	}

	/**
	 * This attribute shall only be used for Instantiate VNF requests. This is
	 * applicable if VNF supports target scale level instantiation. This attribute
	 * provides an alternative way to define the resources to be added for the VNFs.
	 * For each scaling aspect of the current deployment flavour, the attribute
	 * specifies the scale level of VNF constituents (e.g., VDU level) to be
	 * instantiated. See notes 2, 7 and 8.
	 *
	 * @return targetScaleLevelInfo
	 **/
	@Schema(description = "This attribute shall only be used for Instantiate VNF requests. This is applicable if VNF supports target scale level instantiation. This attribute provides an alternative way to define the resources to be added for the VNFs. For each scaling aspect of the current deployment flavour, the attribute specifies the scale level of VNF constituents (e.g., VDU level) to be instantiated. See notes 2, 7 and 8. ")
	@Valid
	public List<ScaleInfo> getTargetScaleLevelInfo() {
		return targetScaleLevelInfo;
	}

	public void setTargetScaleLevelInfo(final List<ScaleInfo> targetScaleLevelInfo) {
		this.targetScaleLevelInfo = targetScaleLevelInfo;
	}

	public GrantRequest addResources(final List<ResourceDefinition> addResources) {
		this.addResources = addResources;
		return this;
	}

	public GrantRequest addAddResourcesItem(final ResourceDefinition addResourcesItem) {
		if (this.addResources == null) {
			this.addResources = new ArrayList<>();
		}
		this.addResources.add(addResourcesItem);
		return this;
	}

	/**
	 * List of resource definitions in the VNFD for resources to be added by the LCM
	 * operation which is related to this grant request, with one entry per
	 * resource. See note 2.
	 *
	 * @return addResources
	 **/
	@Schema(description = "List of resource definitions in the VNFD for resources to be added by the LCM operation  which is related to this grant request, with one entry per resource. See note 2. ")
	@Valid
	public List<ResourceDefinition> getAddResources() {
		return addResources;
	}

	public void setAddResources(final List<ResourceDefinition> addResources) {
		this.addResources = addResources;
	}

	public GrantRequest tempResources(final List<ResourceDefinition> tempResources) {
		this.tempResources = tempResources;
		return this;
	}

	public GrantRequest addTempResourcesItem(final ResourceDefinition tempResourcesItem) {
		if (this.tempResources == null) {
			this.tempResources = new ArrayList<>();
		}
		this.tempResources.add(tempResourcesItem);
		return this;
	}

	/**
	 * List of resource definitions in the VNFD for resources to be temporarily
	 * instantiated during the runtime of the LCM operation which is related to this
	 * grant request, with one entry per resource. See note 3.
	 *
	 * @return tempResources
	 **/
	@Schema(description = "List of resource definitions in the VNFD for resources to be temporarily instantiated during  the runtime of the LCM operation which is related to this grant request, with one entry per  resource. See note 3. ")
	@Valid
	public List<ResourceDefinition> getTempResources() {
		return tempResources;
	}

	public void setTempResources(final List<ResourceDefinition> tempResources) {
		this.tempResources = tempResources;
	}

	public GrantRequest removeResources(final List<ResourceDefinition> removeResources) {
		this.removeResources = removeResources;
		return this;
	}

	public GrantRequest addRemoveResourcesItem(final ResourceDefinition removeResourcesItem) {
		if (this.removeResources == null) {
			this.removeResources = new ArrayList<>();
		}
		this.removeResources.add(removeResourcesItem);
		return this;
	}

	/**
	 * Provides the definitions of resources to be removed by the LCM operation
	 * which is related to this grant request, with one entry per resource.
	 *
	 * @return removeResources
	 **/
	@Schema(description = "Provides the definitions of resources to be removed by the LCM operation which is related to this grant request, with one entry per resource. ")
	@Valid
	public List<ResourceDefinition> getRemoveResources() {
		return removeResources;
	}

	public void setRemoveResources(final List<ResourceDefinition> removeResources) {
		this.removeResources = removeResources;
	}

	public GrantRequest updateResources(final List<ResourceDefinition> updateResources) {
		this.updateResources = updateResources;
		return this;
	}

	public GrantRequest addUpdateResourcesItem(final ResourceDefinition updateResourcesItem) {
		if (this.updateResources == null) {
			this.updateResources = new ArrayList<>();
		}
		this.updateResources.add(updateResourcesItem);
		return this;
	}

	/**
	 * Provides the definitions of resources to be modified by the LCM operation
	 * which is related to this grant request, with one entry per resource.
	 *
	 * @return updateResources
	 **/
	@Schema(description = "Provides the definitions of resources to be modified by the LCM operation which is related to this grant request, with one entry per resource. ")
	@Valid
	public List<ResourceDefinition> getUpdateResources() {
		return updateResources;
	}

	public void setUpdateResources(final List<ResourceDefinition> updateResources) {
		this.updateResources = updateResources;
	}

	public GrantRequest placementConstraints(final List<PlacementConstraint> placementConstraints) {
		this.placementConstraints = placementConstraints;
		return this;
	}

	public GrantRequest addPlacementConstraintsItem(final PlacementConstraint placementConstraintsItem) {
		if (this.placementConstraints == null) {
			this.placementConstraints = new ArrayList<>();
		}
		this.placementConstraints.add(placementConstraintsItem);
		return this;
	}

	/**
	 * Placement constraints that the VNFM may send to the NFVO in order to
	 * influence the resource placement decision. If sent, the NFVO shall take the
	 * constraints into consideration when making resource placement decisions and
	 * shall reject the grant if they cannot be honoured. See notes 4, 5 and 6.
	 *
	 * @return placementConstraints
	 **/
	@Schema(description = "Placement constraints that the VNFM may send to the NFVO in order to influence the resource  placement decision. If sent, the NFVO shall take the constraints into consideration when making  resource placement decisions and shall reject the grant if they cannot be honoured. See notes 4,  5 and 6. ")
	@Valid
	public List<PlacementConstraint> getPlacementConstraints() {
		return placementConstraints;
	}

	public void setPlacementConstraints(final List<PlacementConstraint> placementConstraints) {
		this.placementConstraints = placementConstraints;
	}

	public GrantRequest vimConstraints(final List<VimConstraint> vimConstraints) {
		this.vimConstraints = vimConstraints;
		return this;
	}

	public GrantRequest addVimConstraintsItem(final VimConstraint vimConstraintsItem) {
		if (this.vimConstraints == null) {
			this.vimConstraints = new ArrayList<>();
		}
		this.vimConstraints.add(vimConstraintsItem);
		return this;
	}

	/**
	 * Used by the VNFM to require that multiple resources are managed through the
	 * same VIM connection. If sent, the NFVO shall take the constraints into
	 * consideration when making VIM selection decisions, and shall reject the grant
	 * if they cannot be honoured. This attribute shall be supported if VNF-related
	 * Resource Management in direct mode is applicable. The applicability and
	 * further details of this attribute for indirect mode are left for future
	 * specification.
	 *
	 * @return vimConstraints
	 **/
	@Schema(description = "Used by the VNFM to require that multiple resources are managed through the same VIM connection. If sent, the NFVO shall take the constraints into consideration when making VIM selection decisions, and shall reject the grant if they cannot be honoured. This attribute shall be supported if VNF-related Resource Management in direct mode is applicable. The applicability and further details of this attribute for indirect mode are left for future specification. ")
	@Valid
	public List<VimConstraint> getVimConstraints() {
		return vimConstraints;
	}

	public void setVimConstraints(final List<VimConstraint> vimConstraints) {
		this.vimConstraints = vimConstraints;
	}

	public GrantRequest additionalParams(final Map<String, String> additionalParams) {
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

	public GrantRequest links(final GrantRequestLinks _links) {
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
	public GrantRequestLinks getLinks() {
		return links;
	}

	public void setLinks(final GrantRequestLinks _links) {
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
		final GrantRequest grantRequest = (GrantRequest) o;
		return Objects.equals(this.vnfInstanceId, grantRequest.vnfInstanceId) &&
				Objects.equals(this.vnfLcmOpOccId, grantRequest.vnfLcmOpOccId) &&
				Objects.equals(this.vnfdId, grantRequest.vnfdId) &&
				Objects.equals(this.dstVnfdId, grantRequest.dstVnfdId) &&
				Objects.equals(this.flavourId, grantRequest.flavourId) &&
				Objects.equals(this.operation, grantRequest.operation) &&
				Objects.equals(this.isAutomaticInvocation, grantRequest.isAutomaticInvocation) &&
				Objects.equals(this.instantiationLevelId, grantRequest.instantiationLevelId) &&
				Objects.equals(this.targetScaleLevelInfo, grantRequest.targetScaleLevelInfo) &&
				Objects.equals(this.addResources, grantRequest.addResources) &&
				Objects.equals(this.tempResources, grantRequest.tempResources) &&
				Objects.equals(this.removeResources, grantRequest.removeResources) &&
				Objects.equals(this.updateResources, grantRequest.updateResources) &&
				Objects.equals(this.placementConstraints, grantRequest.placementConstraints) &&
				Objects.equals(this.vimConstraints, grantRequest.vimConstraints) &&
				Objects.equals(this.additionalParams, grantRequest.additionalParams) &&
				Objects.equals(this.links, grantRequest.links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(vnfInstanceId, vnfLcmOpOccId, vnfdId, dstVnfdId, flavourId, operation, isAutomaticInvocation, instantiationLevelId, targetScaleLevelInfo, addResources, tempResources, removeResources, updateResources, placementConstraints, vimConstraints, additionalParams, links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class GrantRequest {\n");

		sb.append("    vnfInstanceId: ").append(toIndentedString(vnfInstanceId)).append("\n");
		sb.append("    vnfLcmOpOccId: ").append(toIndentedString(vnfLcmOpOccId)).append("\n");
		sb.append("    vnfdId: ").append(toIndentedString(vnfdId)).append("\n");
		sb.append("    dstVnfdId: ").append(toIndentedString(dstVnfdId)).append("\n");
		sb.append("    flavourId: ").append(toIndentedString(flavourId)).append("\n");
		sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
		sb.append("    isAutomaticInvocation: ").append(toIndentedString(isAutomaticInvocation)).append("\n");
		sb.append("    instantiationLevelId: ").append(toIndentedString(instantiationLevelId)).append("\n");
		sb.append("    targetScaleLevelInfo: ").append(toIndentedString(targetScaleLevelInfo)).append("\n");
		sb.append("    addResources: ").append(toIndentedString(addResources)).append("\n");
		sb.append("    tempResources: ").append(toIndentedString(tempResources)).append("\n");
		sb.append("    removeResources: ").append(toIndentedString(removeResources)).append("\n");
		sb.append("    updateResources: ").append(toIndentedString(updateResources)).append("\n");
		sb.append("    placementConstraints: ").append(toIndentedString(placementConstraints)).append("\n");
		sb.append("    vimConstraints: ").append(toIndentedString(vimConstraints)).append("\n");
		sb.append("    additionalParams: ").append(toIndentedString(additionalParams)).append("\n");
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
