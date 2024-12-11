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
package com.ubiqube.etsi.mano.v431.model.em.vnflcm;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v431.model.em.vnfconfig.ProblemDetails;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type represents a VNF lifecycle management operation occurrence. Shall
 * be set to the value of the \&quot;id\&quot; attribute in the
 * \&quot;Grant\&quot; representing the associated \&quot;Individual
 * Grant\&quot;, if such grant exists. * NOTE 1: This allows the API consumer to
 * obtain the information contained in the latest \&quot;result\&quot;
 * notification if it has not received it due to an error or a wrongly
 * configured subscription filter. * NOTE 2: Not more than one of changedInfo
 * and modificationsTriggeredByVnfPkgChange shall be present. * NOTE 3: For a
 * particular affected VL, there shall be as many
 * \&quot;AffectedVirtualLink\&quot; entries as needed for signalling the
 * different types of changes, i.e. one per virtual link and change type. For
 * instance, in the case of signaling affected VL instances involving the
 * addition of a particular VL instance with links ports, one
 * \&quot;AffectedVirtualLink\&quot; entry signals the addition of the VL by
 * using the \&quot;changeType\&quot; attribute of
 * \&quot;AffectedVirtualLink\&quot; structure equal to \&quot;ADDED\&quot;, and
 * another \&quot;AffectedVirtualLink\&quot; entry signals the addition of VNF
 * link ports of the VL by using the \&quot;changeType\&quot; equal to
 * \&quot;LINK_PORT_ADDED\&quot;. * NOTE 4: A coordination action has timed out
 * if the VNFM has not been able to read the \&quot;Individual coordination
 * action\&quot; resource within a timeout interval after requesting the
 * coordination to be started or to be cancelled. The length of the timeout
 * interval is defined by means outside the scope of the present document. *
 * NOTE 5: The list of rejected coordinations may be garbage collected if the
 * LCM operation occurrence has reached a terminal state, i.e. one of
 * \&quot;COMPLETED\&quot;, \&quot;FAILED\&quot; and \&quot;ROLLED_BACK\&quot;.
 */
@Schema(description = "This type represents a VNF lifecycle management operation occurrence. Shall be set to the value of the \"id\" attribute in the \"Grant\" representing the associated \"Individual Grant\", if such grant exists. * NOTE 1: This allows the API consumer to obtain the information contained in the latest \"result\"           notification if it has not received it due to an error or a wrongly configured subscription filter. * NOTE 2: Not more than one of changedInfo and modificationsTriggeredByVnfPkgChange shall be present. * NOTE 3: For a particular affected VL, there shall be as many \"AffectedVirtualLink\" entries as needed           for signalling the different types of changes, i.e. one per virtual link and change type.           For instance, in the case of signaling affected VL instances involving the addition of a           particular VL instance with links ports, one \"AffectedVirtualLink\" entry signals the addition           of the VL by using the \"changeType\" attribute of \"AffectedVirtualLink\" structure equal to \"ADDED\",           and another \"AffectedVirtualLink\" entry signals the addition of VNF link ports of the VL by using the           \"changeType\" equal to \"LINK_PORT_ADDED\". * NOTE 4: A coordination action has timed out if the VNFM has not been able to read the           \"Individual coordination action\" resource within a timeout interval after requesting the coordination           to be started or to be cancelled. The length of the timeout interval is defined by means outside           the scope of the present document. * NOTE 5: The list of rejected coordinations may be garbage collected if the LCM operation occurrence has           reached a terminal state, i.e. one of \"COMPLETED\", \"FAILED\" and \"ROLLED_BACK\". ")
@Validated

public class VnfLcmOpOcc implements OneOfVnfLcmOpOcc {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("operationState")
	private LcmOperationStateType operationState = null;

	@JsonProperty("stateEnteredTime")
	private OffsetDateTime stateEnteredTime = null;

	@JsonProperty("startTime")
	private OffsetDateTime startTime = null;

	@JsonProperty("vnfInstanceId")
	private String vnfInstanceId = null;

	@JsonProperty("grantId")
	private String grantId = null;

	@JsonProperty("operation")
	private LcmOperationType operation = null;

	@JsonProperty("isAutomaticInvocation")
	private Boolean isAutomaticInvocation = null;

	@JsonProperty("operationParams")
	private Object operationParams = null;

	@JsonProperty("isCancelPending")
	private Boolean isCancelPending = null;

	@JsonProperty("cancelMode")
	private CancelModeType cancelMode = null;

	@JsonProperty("error")
	private ProblemDetails error = null;

	@JsonProperty("resourceChanges")
	private VnfLcmOpOccResourceChanges resourceChanges = null;

	@JsonProperty("changedInfo")
	private VnfInfoModifications changedInfo = null;

	@JsonProperty("affectedVipCps")
	@Valid
	private List<AffectedVipCp> affectedVipCps = null;

	@JsonProperty("changedExtConnectivity")
	@Valid
	private List<ExtVirtualLinkInfo> changedExtConnectivity = null;

	@JsonProperty("modificationsTriggeredByVnfPkgChange")
	private ModificationsTriggeredByVnfPkgChange modificationsTriggeredByVnfPkgChange = null;

	@JsonProperty("vnfSnapshotInfoId")
	private String vnfSnapshotInfoId = null;

	@JsonProperty("lcmCoordinations")
	private VnfLcmOpOccLcmCoordinations lcmCoordinations = null;

	@JsonProperty("rejectedLcmCoordinations")
	private VnfLcmOpOccRejectedLcmCoordinations rejectedLcmCoordinations = null;

	@JsonProperty("warnings")
	@Valid
	private List<String> warnings = null;

	@JsonProperty("_links")
	private VnfLcmOpOccLinks links = null;

	public VnfLcmOpOcc id(final String id) {
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

	public VnfLcmOpOcc operationState(final LcmOperationStateType operationState) {
		this.operationState = operationState;
		return this;
	}

	/**
	 * Get operationState
	 *
	 * @return operationState
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public LcmOperationStateType getOperationState() {
		return operationState;
	}

	public void setOperationState(final LcmOperationStateType operationState) {
		this.operationState = operationState;
	}

	public VnfLcmOpOcc stateEnteredTime(final OffsetDateTime stateEnteredTime) {
		this.stateEnteredTime = stateEnteredTime;
		return this;
	}

	/**
	 * Get stateEnteredTime
	 *
	 * @return stateEnteredTime
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public OffsetDateTime getStateEnteredTime() {
		return stateEnteredTime;
	}

	public void setStateEnteredTime(final OffsetDateTime stateEnteredTime) {
		this.stateEnteredTime = stateEnteredTime;
	}

	public VnfLcmOpOcc startTime(final OffsetDateTime startTime) {
		this.startTime = startTime;
		return this;
	}

	/**
	 * Get startTime
	 *
	 * @return startTime
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public OffsetDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(final OffsetDateTime startTime) {
		this.startTime = startTime;
	}

	public VnfLcmOpOcc vnfInstanceId(final String vnfInstanceId) {
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

	public VnfLcmOpOcc grantId(final String grantId) {
		this.grantId = grantId;
		return this;
	}

	/**
	 * Get grantId
	 *
	 * @return grantId
	 **/
	@Schema(description = "")

	public String getGrantId() {
		return grantId;
	}

	public void setGrantId(final String grantId) {
		this.grantId = grantId;
	}

	public VnfLcmOpOcc operation(final LcmOperationType operation) {
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
	public LcmOperationType getOperation() {
		return operation;
	}

	public void setOperation(final LcmOperationType operation) {
		this.operation = operation;
	}

	public VnfLcmOpOcc isAutomaticInvocation(final Boolean isAutomaticInvocation) {
		this.isAutomaticInvocation = isAutomaticInvocation;
		return this;
	}

	/**
	 * Get isAutomaticInvocation
	 *
	 * @return isAutomaticInvocation
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public Boolean getIsAutomaticInvocation() {
		return isAutomaticInvocation;
	}

	public void setIsAutomaticInvocation(final Boolean isAutomaticInvocation) {
		this.isAutomaticInvocation = isAutomaticInvocation;
	}

	public VnfLcmOpOcc operationParams(final Object operationParams) {
		this.operationParams = operationParams;
		return this;
	}

	/**
	 * Input parameters of the LCM operation. This attribute shall be formatted
	 * according to the request data type of the related LCM operation. In addition,
	 * the provisions in clause 5.7 shall apply. The following mapping between
	 * operationType and the data type of this attribute shall apply: * INSTANTIATE:
	 * InstantiateVnfRequest * SCALE: ScaleVnfRequest * SCALE_TO_LEVEL:
	 * ScaleVnfToLevelRequest * CHANGE_FLAVOUR: ChangeVnfFlavourRequest * OPERATE:
	 * OperateVnfRequest * HEAL: HealVnfRequest * CHANGE_EXT_CONN:
	 * ChangeExtVnfConnectivityRequest * TERMINATE: TerminateVnfRequest *
	 * MODIFY_INFO: VnfInfoModifications * CREATE_SNAPSHOT: CreateVnfSnapshotRequest
	 * * REVERT_TO_SNAPSHOT: RevertToVnfSnapshotRequest * CHANGE_VNFPKG:
	 * ChangeCurrentVnfPkgRequest
	 *
	 * @return operationParams
	 **/
	@Schema(description = "Input parameters of the LCM operation. This attribute shall be formatted according to the request data type of the related LCM operation. In addition, the provisions in clause 5.7 shall apply. The following mapping between operationType and the data type of this attribute shall apply: * INSTANTIATE: InstantiateVnfRequest * SCALE: ScaleVnfRequest * SCALE_TO_LEVEL: ScaleVnfToLevelRequest * CHANGE_FLAVOUR: ChangeVnfFlavourRequest * OPERATE: OperateVnfRequest * HEAL: HealVnfRequest * CHANGE_EXT_CONN: ChangeExtVnfConnectivityRequest * TERMINATE: TerminateVnfRequest * MODIFY_INFO: VnfInfoModifications * CREATE_SNAPSHOT: CreateVnfSnapshotRequest * REVERT_TO_SNAPSHOT: RevertToVnfSnapshotRequest * CHANGE_VNFPKG: ChangeCurrentVnfPkgRequest ")

	public Object getOperationParams() {
		return operationParams;
	}

	public void setOperationParams(final Object operationParams) {
		this.operationParams = operationParams;
	}

	public VnfLcmOpOcc isCancelPending(final Boolean isCancelPending) {
		this.isCancelPending = isCancelPending;
		return this;
	}

	/**
	 * Get isCancelPending
	 *
	 * @return isCancelPending
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public Boolean getIsCancelPending() {
		return isCancelPending;
	}

	public void setIsCancelPending(final Boolean isCancelPending) {
		this.isCancelPending = isCancelPending;
	}

	public VnfLcmOpOcc cancelMode(final CancelModeType cancelMode) {
		this.cancelMode = cancelMode;
		return this;
	}

	/**
	 * Get cancelMode
	 *
	 * @return cancelMode
	 **/
	@Schema(description = "")

	@Valid
	public CancelModeType getCancelMode() {
		return cancelMode;
	}

	public void setCancelMode(final CancelModeType cancelMode) {
		this.cancelMode = cancelMode;
	}

	public VnfLcmOpOcc error(final ProblemDetails error) {
		this.error = error;
		return this;
	}

	/**
	 * Get error
	 *
	 * @return error
	 **/
	@Schema(description = "")

	@Valid
	public ProblemDetails getError() {
		return error;
	}

	public void setError(final ProblemDetails error) {
		this.error = error;
	}

	public VnfLcmOpOcc resourceChanges(final VnfLcmOpOccResourceChanges resourceChanges) {
		this.resourceChanges = resourceChanges;
		return this;
	}

	/**
	 * Get resourceChanges
	 *
	 * @return resourceChanges
	 **/
	@Schema(description = "")

	@Valid
	public VnfLcmOpOccResourceChanges getResourceChanges() {
		return resourceChanges;
	}

	public void setResourceChanges(final VnfLcmOpOccResourceChanges resourceChanges) {
		this.resourceChanges = resourceChanges;
	}

	public VnfLcmOpOcc changedInfo(final VnfInfoModifications changedInfo) {
		this.changedInfo = changedInfo;
		return this;
	}

	/**
	 * Get changedInfo
	 *
	 * @return changedInfo
	 **/
	@Schema(description = "")

	@Valid
	public VnfInfoModifications getChangedInfo() {
		return changedInfo;
	}

	public void setChangedInfo(final VnfInfoModifications changedInfo) {
		this.changedInfo = changedInfo;
	}

	public VnfLcmOpOcc affectedVipCps(final List<AffectedVipCp> affectedVipCps) {
		this.affectedVipCps = affectedVipCps;
		return this;
	}

	public VnfLcmOpOcc addAffectedVipCpsItem(final AffectedVipCp affectedVipCpsItem) {
		if (this.affectedVipCps == null) {
			this.affectedVipCps = new ArrayList<>();
		}
		this.affectedVipCps.add(affectedVipCpsItem);
		return this;
	}

	/**
	 * Information about virtual IP CP instances that were affected during the
	 * execution of the lifecycle management operation.
	 *
	 * @return affectedVipCps
	 **/
	@Schema(description = "Information about virtual IP CP instances that were affected during the execution of the lifecycle management operation. ")
	@Valid
	public List<AffectedVipCp> getAffectedVipCps() {
		return affectedVipCps;
	}

	public void setAffectedVipCps(final List<AffectedVipCp> affectedVipCps) {
		this.affectedVipCps = affectedVipCps;
	}

	public VnfLcmOpOcc changedExtConnectivity(final List<ExtVirtualLinkInfo> changedExtConnectivity) {
		this.changedExtConnectivity = changedExtConnectivity;
		return this;
	}

	public VnfLcmOpOcc addChangedExtConnectivityItem(final ExtVirtualLinkInfo changedExtConnectivityItem) {
		if (this.changedExtConnectivity == null) {
			this.changedExtConnectivity = new ArrayList<>();
		}
		this.changedExtConnectivity.add(changedExtConnectivityItem);
		return this;
	}

	/**
	 * Information about changed external connectivity, if applicable. See note 1.
	 *
	 * @return changedExtConnectivity
	 **/
	@Schema(description = "Information about changed external connectivity, if applicable. See note 1. ")
	@Valid
	public List<ExtVirtualLinkInfo> getChangedExtConnectivity() {
		return changedExtConnectivity;
	}

	public void setChangedExtConnectivity(final List<ExtVirtualLinkInfo> changedExtConnectivity) {
		this.changedExtConnectivity = changedExtConnectivity;
	}

	public VnfLcmOpOcc modificationsTriggeredByVnfPkgChange(final ModificationsTriggeredByVnfPkgChange modificationsTriggeredByVnfPkgChange) {
		this.modificationsTriggeredByVnfPkgChange = modificationsTriggeredByVnfPkgChange;
		return this;
	}

	/**
	 * Get modificationsTriggeredByVnfPkgChange
	 *
	 * @return modificationsTriggeredByVnfPkgChange
	 **/
	@Schema(description = "")

	@Valid
	public ModificationsTriggeredByVnfPkgChange getModificationsTriggeredByVnfPkgChange() {
		return modificationsTriggeredByVnfPkgChange;
	}

	public void setModificationsTriggeredByVnfPkgChange(final ModificationsTriggeredByVnfPkgChange modificationsTriggeredByVnfPkgChange) {
		this.modificationsTriggeredByVnfPkgChange = modificationsTriggeredByVnfPkgChange;
	}

	public VnfLcmOpOcc vnfSnapshotInfoId(final String vnfSnapshotInfoId) {
		this.vnfSnapshotInfoId = vnfSnapshotInfoId;
		return this;
	}

	/**
	 * Get vnfSnapshotInfoId
	 *
	 * @return vnfSnapshotInfoId
	 **/
	@Schema(description = "")

	public String getVnfSnapshotInfoId() {
		return vnfSnapshotInfoId;
	}

	public void setVnfSnapshotInfoId(final String vnfSnapshotInfoId) {
		this.vnfSnapshotInfoId = vnfSnapshotInfoId;
	}

	public VnfLcmOpOcc lcmCoordinations(final VnfLcmOpOccLcmCoordinations lcmCoordinations) {
		this.lcmCoordinations = lcmCoordinations;
		return this;
	}

	/**
	 * Get lcmCoordinations
	 *
	 * @return lcmCoordinations
	 **/
	@Schema(description = "")

	@Valid
	public VnfLcmOpOccLcmCoordinations getLcmCoordinations() {
		return lcmCoordinations;
	}

	public void setLcmCoordinations(final VnfLcmOpOccLcmCoordinations lcmCoordinations) {
		this.lcmCoordinations = lcmCoordinations;
	}

	public VnfLcmOpOcc rejectedLcmCoordinations(final VnfLcmOpOccRejectedLcmCoordinations rejectedLcmCoordinations) {
		this.rejectedLcmCoordinations = rejectedLcmCoordinations;
		return this;
	}

	/**
	 * Get rejectedLcmCoordinations
	 *
	 * @return rejectedLcmCoordinations
	 **/
	@Schema(description = "")

	@Valid
	public VnfLcmOpOccRejectedLcmCoordinations getRejectedLcmCoordinations() {
		return rejectedLcmCoordinations;
	}

	public void setRejectedLcmCoordinations(final VnfLcmOpOccRejectedLcmCoordinations rejectedLcmCoordinations) {
		this.rejectedLcmCoordinations = rejectedLcmCoordinations;
	}

	public VnfLcmOpOcc warnings(final List<String> warnings) {
		this.warnings = warnings;
		return this;
	}

	public VnfLcmOpOcc addWarningsItem(final String warningsItem) {
		if (this.warnings == null) {
			this.warnings = new ArrayList<>();
		}
		this.warnings.add(warningsItem);
		return this;
	}

	/**
	 * Warning messages that were generated while the operation was executing. If
	 * the operation has included LCM coordination actions and these have resulted
	 * in warnings, such warnings should be added to this attribute.
	 *
	 * @return warnings
	 **/
	@Schema(description = "Warning messages that were generated while the operation was executing. If the operation has included LCM coordination actions and these have resulted in warnings, such warnings should be added to this attribute. ")

	public List<String> getWarnings() {
		return warnings;
	}

	public void setWarnings(final List<String> warnings) {
		this.warnings = warnings;
	}

	public VnfLcmOpOcc links(final VnfLcmOpOccLinks _links) {
		this.links = _links;
		return this;
	}

	/**
	 * Get _links
	 *
	 * @return _links
	 **/
	@Schema(description = "")

	@Valid
	public VnfLcmOpOccLinks getLinks() {
		return links;
	}

	public void setLinks(final VnfLcmOpOccLinks _links) {
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
		final VnfLcmOpOcc vnfLcmOpOcc = (VnfLcmOpOcc) o;
		return Objects.equals(this.id, vnfLcmOpOcc.id) &&
				Objects.equals(this.operationState, vnfLcmOpOcc.operationState) &&
				Objects.equals(this.stateEnteredTime, vnfLcmOpOcc.stateEnteredTime) &&
				Objects.equals(this.startTime, vnfLcmOpOcc.startTime) &&
				Objects.equals(this.vnfInstanceId, vnfLcmOpOcc.vnfInstanceId) &&
				Objects.equals(this.grantId, vnfLcmOpOcc.grantId) &&
				Objects.equals(this.operation, vnfLcmOpOcc.operation) &&
				Objects.equals(this.isAutomaticInvocation, vnfLcmOpOcc.isAutomaticInvocation) &&
				Objects.equals(this.operationParams, vnfLcmOpOcc.operationParams) &&
				Objects.equals(this.isCancelPending, vnfLcmOpOcc.isCancelPending) &&
				Objects.equals(this.cancelMode, vnfLcmOpOcc.cancelMode) &&
				Objects.equals(this.error, vnfLcmOpOcc.error) &&
				Objects.equals(this.resourceChanges, vnfLcmOpOcc.resourceChanges) &&
				Objects.equals(this.changedInfo, vnfLcmOpOcc.changedInfo) &&
				Objects.equals(this.affectedVipCps, vnfLcmOpOcc.affectedVipCps) &&
				Objects.equals(this.changedExtConnectivity, vnfLcmOpOcc.changedExtConnectivity) &&
				Objects.equals(this.modificationsTriggeredByVnfPkgChange, vnfLcmOpOcc.modificationsTriggeredByVnfPkgChange) &&
				Objects.equals(this.vnfSnapshotInfoId, vnfLcmOpOcc.vnfSnapshotInfoId) &&
				Objects.equals(this.lcmCoordinations, vnfLcmOpOcc.lcmCoordinations) &&
				Objects.equals(this.rejectedLcmCoordinations, vnfLcmOpOcc.rejectedLcmCoordinations) &&
				Objects.equals(this.warnings, vnfLcmOpOcc.warnings) &&
				Objects.equals(this.links, vnfLcmOpOcc.links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, operationState, stateEnteredTime, startTime, vnfInstanceId, grantId, operation, isAutomaticInvocation, operationParams, isCancelPending, cancelMode, error, resourceChanges, changedInfo, affectedVipCps, changedExtConnectivity, modificationsTriggeredByVnfPkgChange, vnfSnapshotInfoId, lcmCoordinations, rejectedLcmCoordinations, warnings, links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class VnfLcmOpOcc {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    operationState: ").append(toIndentedString(operationState)).append("\n");
		sb.append("    stateEnteredTime: ").append(toIndentedString(stateEnteredTime)).append("\n");
		sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
		sb.append("    vnfInstanceId: ").append(toIndentedString(vnfInstanceId)).append("\n");
		sb.append("    grantId: ").append(toIndentedString(grantId)).append("\n");
		sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
		sb.append("    isAutomaticInvocation: ").append(toIndentedString(isAutomaticInvocation)).append("\n");
		sb.append("    operationParams: ").append(toIndentedString(operationParams)).append("\n");
		sb.append("    isCancelPending: ").append(toIndentedString(isCancelPending)).append("\n");
		sb.append("    cancelMode: ").append(toIndentedString(cancelMode)).append("\n");
		sb.append("    error: ").append(toIndentedString(error)).append("\n");
		sb.append("    resourceChanges: ").append(toIndentedString(resourceChanges)).append("\n");
		sb.append("    changedInfo: ").append(toIndentedString(changedInfo)).append("\n");
		sb.append("    affectedVipCps: ").append(toIndentedString(affectedVipCps)).append("\n");
		sb.append("    changedExtConnectivity: ").append(toIndentedString(changedExtConnectivity)).append("\n");
		sb.append("    modificationsTriggeredByVnfPkgChange: ").append(toIndentedString(modificationsTriggeredByVnfPkgChange)).append("\n");
		sb.append("    vnfSnapshotInfoId: ").append(toIndentedString(vnfSnapshotInfoId)).append("\n");
		sb.append("    lcmCoordinations: ").append(toIndentedString(lcmCoordinations)).append("\n");
		sb.append("    rejectedLcmCoordinations: ").append(toIndentedString(rejectedLcmCoordinations)).append("\n");
		sb.append("    warnings: ").append(toIndentedString(warnings)).append("\n");
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
