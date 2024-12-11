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
package com.ubiqube.etsi.mano.v271.model.em.vnflcm;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ubiqube.etsi.mano.v271.model.em.vnfconfig.ProblemDetails2;
import com.ubiqube.etsi.mano.v271.service.VnfLcmOpOcc271Deserializer;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type represents a VNF lifecycle management operation occurrence.
 */
@Schema(description = "This type represents a VNF lifecycle management operation occurrence. ")
@Validated
@JsonDeserialize(using = VnfLcmOpOcc271Deserializer.class)
public class VnfLcmOpOcc {
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
	private ProblemDetails2 error = null;

	@JsonProperty("resourceChanges")
	private VnfLcmOpOccResourceChanges resourceChanges = null;

	@JsonProperty("changedInfo")
	private VnfInfoModifications changedInfo = null;

	@JsonProperty("changedExtConnectivity")
	@Valid
	private List<ExtVirtualLinkInfo> changedExtConnectivity = null;

	@JsonProperty("_links")
	private VnfLcmOpOccLinks links = null;

	public VnfLcmOpOcc id(final String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identifier of this VNF lifecycle management operation occurrence.
	 *
	 * @return id
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifier of this VNF lifecycle management operation occurrence. ")
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
	 * The state of the LCM operation.
	 *
	 * @return operationState
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "The state of the LCM operation. ")
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
	 * Date-time when the current state has been entered.
	 *
	 * @return stateEnteredTime
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Date-time when the current state has been entered. ")
	@NotNull

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
	 * Date-time of the start of the operation.
	 *
	 * @return startTime
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Date-time of the start of the operation. ")
	@NotNull

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
	 * Identifier of the VNF instance to which the operation applies
	 *
	 * @return vnfInstanceId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifier of the VNF instance to which the operation applies ")
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
	 * Identifier of the grant related to this VNF LCM operation occurrence, if such
	 * grant exists.
	 *
	 * @return grantId
	 **/
	@Schema(description = "Identifier of the grant related to this VNF LCM operation occurrence, if such grant exists. ")

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
	 * Type of the actual LCM operation represented by this VNF LCM operation
	 * occurrence.
	 *
	 * @return operation
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Type of the actual LCM operation represented by this VNF LCM operation occurrence. ")
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
	 * Set to true if this VNF LCM operation occurrence has been triggered by an
	 * automated procedure inside the VNFM (i.e. ScaleVnf / ScaleVnfToLevel
	 * triggered by auto-scale, or HealVnf triggered by auto-heal). Set to false
	 * otherwise.
	 *
	 * @return isAutomaticInvocation
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Set to true if this VNF LCM operation occurrence has been triggered by an automated procedure inside the VNFM (i.e. ScaleVnf / ScaleVnfToLevel triggered by auto-scale, or HealVnf triggered by auto-heal). Set to false otherwise. ")
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
	 * according to the request data type of the related LCM operation. The
	 * following mapping between operationType and the data type of this attribute
	 * shall apply: * INSTANTIATE: InstantiateVnfRequest * SCALE: ScaleVnfRequest *
	 * SCALE_TO_LEVEL: ScaleVnfToLevelRequest * CHANGE_FLAVOUR:
	 * ChangeVnfFlavourRequest * OPERATE: OperateVnfRequest * HEAL: HealVnfRequest *
	 * CHANGE_EXT_CONN: ChangeExtVnfConnectivityRequest * TERMINATE:
	 * TerminateVnfRequest * MODIFY_INFO: VnfInfoModifications
	 *
	 * @return operationParams
	 **/
	@Schema(description = "Input parameters of the LCM operation. This attribute shall be formatted according to the request data type of the related LCM operation. The following mapping between operationType and the data type of this attribute shall apply: * INSTANTIATE: InstantiateVnfRequest * SCALE: ScaleVnfRequest * SCALE_TO_LEVEL: ScaleVnfToLevelRequest * CHANGE_FLAVOUR: ChangeVnfFlavourRequest * OPERATE: OperateVnfRequest * HEAL: HealVnfRequest * CHANGE_EXT_CONN: ChangeExtVnfConnectivityRequest * TERMINATE: TerminateVnfRequest * MODIFY_INFO: VnfInfoModifications ")

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
	 * If the VNF LCM operation occurrence is in \"STARTING\", \"PROCESSING\" or
	 * \"ROLLING_BACK\" state and the operation is being cancelled, this attribute
	 * shall be set to true. Otherwise, it shall be set to false.
	 *
	 * @return isCancelPending
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "If the VNF LCM operation occurrence is in \"STARTING\", \"PROCESSING\" or \"ROLLING_BACK\" state and the operation is being cancelled, this attribute shall be set to true. Otherwise, it shall be set to false. ")
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
	 * The mode of an ongoing cancellation. Shall be present when
	 * isCancelPending=true, and shall be absent otherwise.
	 *
	 * @return cancelMode
	 **/
	@Schema(description = "The mode of an ongoing cancellation. Shall be present when isCancelPending=true, and shall be absent otherwise. ")

	@Valid

	public CancelModeType getCancelMode() {
		return cancelMode;
	}

	public void setCancelMode(final CancelModeType cancelMode) {
		this.cancelMode = cancelMode;
	}

	public VnfLcmOpOcc error(final ProblemDetails2 error) {
		this.error = error;
		return this;
	}

	/**
	 * If \"operationState\" is \"FAILED_TEMP\" or \"FAILED\" or \"operationState\"
	 * is \"PROCESSING\" or \"ROLLING_BACK\" and previous value of
	 * \"operationState\" was \"FAILED_TEMP\", this attribute shall be present and
	 * contain error information, unless it has been requested to be excluded via an
	 * attribute selector.
	 *
	 * @return error
	 **/
	@Schema(description = "If \"operationState\" is \"FAILED_TEMP\" or \"FAILED\" or \"operationState\" is \"PROCESSING\" or \"ROLLING_BACK\" and previous value of \"operationState\" was \"FAILED_TEMP\", this attribute shall be present and contain error information, unless it has been requested to be excluded via an attribute selector. ")

	@Valid

	public ProblemDetails2 getError() {
		return error;
	}

	public void setError(final ProblemDetails2 error) {
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
	 * Information about the changed VNF instance information, including VNF
	 * configurable properties, if applicable. This allows the NFVO to obtain the
	 * information contained in the latest \"result\" notification if it has not
	 * received it due to an error or a wrongly configured subscription filter.
	 *
	 * @return changedInfo
	 **/
	@Schema(description = "Information about the changed VNF instance information, including VNF configurable properties, if applicable. This allows the NFVO to obtain the information contained in the latest \"result\" notification if it has not received it due to an error or a wrongly configured subscription filter. ")

	@Valid

	public VnfInfoModifications getChangedInfo() {
		return changedInfo;
	}

	public void setChangedInfo(final VnfInfoModifications changedInfo) {
		this.changedInfo = changedInfo;
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
	 * Information about changed external connectivity, if applicable. This allows
	 * the NFVO to obtain the information contained in the latest \"result\"
	 * notification if it has not received it due to an error or a wrongly
	 * configured subscription filter.
	 *
	 * @return changedExtConnectivity
	 **/
	@Schema(description = "Information about changed external connectivity, if applicable. This allows the NFVO to obtain the information contained in the latest \"result\" notification if it has not received it due to an error or a wrongly configured subscription filter. ")

	@Valid

	public List<ExtVirtualLinkInfo> getChangedExtConnectivity() {
		return changedExtConnectivity;
	}

	public void setChangedExtConnectivity(final List<ExtVirtualLinkInfo> changedExtConnectivity) {
		this.changedExtConnectivity = changedExtConnectivity;
	}

	public VnfLcmOpOcc links(final VnfLcmOpOccLinks links) {
		this.links = links;
		return this;
	}

	/**
	 * Get links
	 *
	 * @return links
	 **/
	@Schema(description = "")

	@Valid

	public VnfLcmOpOccLinks getLinks() {
		return links;
	}

	public void setLinks(final VnfLcmOpOccLinks links) {
		this.links = links;
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
				Objects.equals(this.changedExtConnectivity, vnfLcmOpOcc.changedExtConnectivity) &&
				Objects.equals(this.links, vnfLcmOpOcc.links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, operationState, stateEnteredTime, startTime, vnfInstanceId, grantId, operation, isAutomaticInvocation, operationParams, isCancelPending, cancelMode, error, resourceChanges, changedInfo, changedExtConnectivity, links);
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
		sb.append("    changedExtConnectivity: ").append(toIndentedString(changedExtConnectivity)).append("\n");
		sb.append("    links: ").append(toIndentedString(links)).append("\n");
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
