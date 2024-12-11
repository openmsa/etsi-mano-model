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
package com.ubiqube.etsi.mano.v361.model.vnfm.vnflcm;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ubiqube.etsi.mano.v361.model.em.vnfconfig.ProblemDetails;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.AffectedExtLinkPort;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.AffectedVipCp;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.AffectedVirtualLink;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.AffectedVirtualStorage;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.AffectedVnfc;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.ExtVirtualLinkInfo;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.LccnLinks;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.LcmOpOccNotificationVerbosityType;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.LcmOperationStateType;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.LcmOperationType;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.ModificationsTriggeredByVnfPkgChange;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.VnfInfoModifications;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

/**
 * This type represents a VNF lifecycle management operation occurrence
 * notification, which informs the receiver of changes in the VNF lifecycle
 * caused by a VNF LCM operation occurrence. It shall comply with the provisions
 * defined in table 5.5.2.17-1. The support of the notification is mandatory.
 * This notification shall be triggered by the VNFM when there is a change in
 * the state of a VNF LCM operation occurrence that changes the VNF lifecycle,
 * which represents an occurrence of one the following LCM operations: -
 * Instantiation of the VNF - Scaling of the VNF instance (including
 * auto-scaling) - Healing of the VNF instance (including auto-healing) - Change
 * of the state of the VNF instance (i.e. Operate VNF) - Change of the
 * deployment flavour of the VNF instance - Change of the external connectivity
 * of the VNF instance - Change of the current VNF package - Termination of the
 * VNF instance - Modification of VNF instance information and/or VNF
 * configurable properties through the \&quot;PATCH\&quot; method on the
 * \&quot;Individual VNF instance\&quot; resource - Creation of a VNF snapshot -
 * Reversion of the VNF instance to a VNF snapshot Clause 5.6.2 defines the
 * states and state transition of a VNF LCM operation occurrence, and also
 * specifies details of the notifications to be emitted at each state
 * transition. If this is the initial notification about the start of a VNF LCM
 * operation occurrence, it is assumed that the notification is sent by the VNFM
 * before any action (including sending the grant request) is taken as part of
 * the LCM operation. Due to possible race conditions, the \&quot;start\&quot;
 * notification, the grant request and the LCM operation acknowledgment (i.e.
 * the \&quot;202 Accepted\&quot; response) can arrive in any order at the NFVO,
 * and the NFVO shall be able to handle such a situation. If this is a
 * notification about a final or intermediate result state of a VNF LCM
 * operation occurrence, the notification shall be sent after all related
 * actions of the LCM operation that led to this state have been executed. The
 * new state shall be set in the \&quot;Individual VNF LCM operation
 * occurrence\&quot; resource before the notification about the state change is
 * sent. The amount of information provided in the LCM operation occurrence
 * notifications to be issued by the VNFM when a particular subscription matches
 * can be controlled by the API consumer using the \&quot;verbosity\&quot;
 * attribute in the subscription request (see clause 5.5.2.15). The
 * \&quot;verbosity\&quot; setting in a particular individual subscription shall
 * only apply to the LCM operation occurrence notifications triggered by that
 * subscription. However, it shall not affect the amount of information in the
 * \&quot;VnfLcmOpOcc\&quot; structure (see clause 5.5.2.13) which represents
 * the \&quot;Individual LCM operation occurrence\&quot; resource associated
 * with each of the notifications. See clause 5.6.2.2 for further provisions
 * regarding sending this notification, including in cases of handling LCM
 * operation errors. NOTE 1: Shall be present if the
 * \&quot;notificationStatus\&quot; is set to \&quot;RESULT\&quot;, the
 * \&quot;verbosity\&quot; attribute is set to \&quot;FULL\&quot; and the
 * operation has performed any resource modification. Shall be absent otherwise.
 * This attribute contains information about the cumulative changes to
 * virtualised resources that were performed so far by the VNF LCM operation
 * occurrence and by any of the error handling procedures for that operation
 * occurrence. NOTE 2: For a particular affected VL, there shall be as many
 * \&quot;AffectedVirtualLink\&quot; entries as needed for signalling the
 * different types of changes, i.e. one per virtual link and change type. For
 * instance, in the case of signaling affected VL instances involving the
 * addition of a particular VL instance with links ports, one
 * \&quot;AffectedVirtualLink\&quot; entry signals the addition of the VL by
 * using the \&quot;changeType\&quot; attribute of
 * \&quot;AffectedVirtualLink\&quot; structure equal to \&quot;ADDED\&quot;, and
 * another \&quot;AffectedVirtualLink\&quot; entry signals the addition of
 * externally visible VNF link ports of the VL by using the
 * \&quot;changeType\&quot; equal to \&quot;LINK_PORT_ADDED\&quot;. Note 3: Not
 * more than one of changedInfo and modificationsTriggeredByVnfPkgChange shall
 * be present.
 */
@Schema(description = "This type represents a VNF lifecycle management operation occurrence notification, which  informs the receiver of changes in the VNF lifecycle caused by a VNF LCM operation occurrence.  It shall comply with the provisions defined in table 5.5.2.17-1.  The support of the notification is mandatory.  This notification shall be triggered by the VNFM when there is a change in the state of a VNF LCM  operation occurrence that changes the VNF lifecycle, which represents an occurrence of one the  following LCM operations: - Instantiation of the VNF - Scaling of the VNF instance (including auto-scaling) - Healing of the VNF instance (including auto-healing) - Change of the state of the VNF instance (i.e. Operate VNF) - Change of the deployment flavour of the VNF instance - Change of the external connectivity of the VNF instance - Change of the current VNF package - Termination of the VNF instance - Modification of VNF instance information and/or VNF configurable properties through the \"PATCH\"    method on the \"Individual VNF instance\" resource - Creation of a VNF snapshot - Reversion of the VNF instance to a VNF snapshot Clause 5.6.2 defines the states and state transition of a VNF LCM operation occurrence, and also  specifies details of the notifications to be emitted at each state transition. If this is the initial notification about the start of a VNF LCM operation occurrence, it is assumed  that the notification is sent by the VNFM before any action (including sending the grant request) is  taken as part of the LCM operation. Due to possible race conditions, the \"start\" notification, the grant  request and the LCM operation acknowledgment (i.e. the \"202 Accepted\" response) can arrive in any order  at the NFVO, and the NFVO shall be able to handle such a situation. If this is a notification about a final or intermediate result state of a VNF LCM operation occurrence,  the notification shall be sent after all related actions of the LCM operation that led to this state have  been executed.  The new state shall be set in the \"Individual VNF LCM operation occurrence\" resource before the notification  about the state change is sent. The amount of information provided in the LCM operation occurrence notifications to be issued by the VNFM when  a particular subscription matches can be controlled by the API consumer using the \"verbosity\" attribute in the  subscription request (see clause 5.5.2.15). The \"verbosity\" setting in a particular individual subscription shall  only apply to the LCM operation occurrence notifications triggered by that subscription. However, it shall not  affect the amount of information in the \"VnfLcmOpOcc\" structure (see clause 5.5.2.13) which represents the \"Individual  LCM operation occurrence\" resource associated with each of the notifications. See clause 5.6.2.2 for further provisions regarding sending this notification, including in cases of handling LCM  operation errors. NOTE 1: Shall be present if the \"notificationStatus\" is set to \"RESULT\", the \"verbosity\" attribute is set to \"FULL\"          and the operation has performed any resource modification. Shall be absent otherwise. This attribute contains          information about the cumulative changes to virtualised resources that were performed so far by the VNF LCM          operation occurrence and by any of the error handling procedures for that operation occurrence. NOTE 2: For a particular affected VL, there shall be as many \"AffectedVirtualLink\" entries as needed for signalling          the different types of changes, i.e. one per virtual link and change type. For instance, in the case of signaling          affected VL instances involving the addition of a particular VL instance with links ports, one \"AffectedVirtualLink\"          entry signals the addition of the VL by using the \"changeType\" attribute of \"AffectedVirtualLink\" structure equal to          \"ADDED\", and another \"AffectedVirtualLink\" entry signals the addition of externally visible VNF link ports of the VL          by using the \"changeType\" equal to \"LINK_PORT_ADDED\". Note 3: Not more than one of changedInfo and modificationsTriggeredByVnfPkgChange shall be present. ")
@Validated

public class VnfLcmOperationOccurrenceNotification {
	@JsonProperty("id")
	private String id = null;

	/**
	 * Discriminator for the different notification types. Shall be set to
	 * \"VnfLcmOperationOccurrenceNotification\" for this notification type.
	 */
	public enum NotificationTypeEnum {
		VNFLCMOPERATIONOCCURRENCENOTIFICATION("VnfLcmOperationOccurrenceNotification");

		private final String value;

		NotificationTypeEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static NotificationTypeEnum fromValue(final String text) {
			for (final NotificationTypeEnum b : NotificationTypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("notificationType")
	private NotificationTypeEnum notificationType = null;

	@JsonProperty("subscriptionId")
	private String subscriptionId = null;

	@JsonProperty("timeStamp")
	private OffsetDateTime timeStamp = null;

	/**
	 * Indicates whether this notification reports about the start of a lifecycle
	 * operation or the result of a lifecycle operation. Permitted values: * START:
	 * Informs about the start of the VNF LCM operation occurrence. * RESULT:
	 * Informs about the final or intermediate result of the VNF LCM operation
	 * occurrence.
	 */
	public enum NotificationStatusEnum {
		START("START"),

		RESULT("RESULT");

		private final String value;

		NotificationStatusEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static NotificationStatusEnum fromValue(final String text) {
			for (final NotificationStatusEnum b : NotificationStatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("notificationStatus")
	private NotificationStatusEnum notificationStatus = null;

	@JsonProperty("operationState")
	private LcmOperationStateType operationState = null;

	@JsonProperty("vnfInstanceId")
	private String vnfInstanceId = null;

	@JsonProperty("operation")
	private LcmOperationType operation = null;

	@JsonProperty("isAutomaticInvocation")
	private Boolean isAutomaticInvocation = null;

	@JsonProperty("verbosity")
	private LcmOpOccNotificationVerbosityType verbosity = null;

	@JsonProperty("vnfLcmOpOccId")
	private String vnfLcmOpOccId = null;

	@JsonProperty("affectedVnfcs")
	@Valid
	private List<AffectedVnfc> affectedVnfcs = null;

	@JsonProperty("affectedVirtualLinks")
	@Valid
	private List<AffectedVirtualLink> affectedVirtualLinks = null;

	@JsonProperty("affectedExtLinkPorts")
	@Valid
	private List<AffectedExtLinkPort> affectedExtLinkPorts = null;

	@JsonProperty("affectedVirtualStorages")
	@Valid
	private List<AffectedVirtualStorage> affectedVirtualStorages = null;

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

	@JsonProperty("error")
	private ProblemDetails error = null;

	@JsonProperty("_links")
	private LccnLinks _links = null;

	public VnfLcmOperationOccurrenceNotification id(final String id) {
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

	public VnfLcmOperationOccurrenceNotification notificationType(final NotificationTypeEnum notificationType) {
		this.notificationType = notificationType;
		return this;
	}

	/**
	 * Discriminator for the different notification types. Shall be set to
	 * \"VnfLcmOperationOccurrenceNotification\" for this notification type.
	 *
	 * @return notificationType
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Discriminator for the different notification types. Shall be set to \"VnfLcmOperationOccurrenceNotification\" for this notification type. ")
	@NotNull

	public NotificationTypeEnum getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(final NotificationTypeEnum notificationType) {
		this.notificationType = notificationType;
	}

	public VnfLcmOperationOccurrenceNotification subscriptionId(final String subscriptionId) {
		this.subscriptionId = subscriptionId;
		return this;
	}

	/**
	 * Get subscriptionId
	 *
	 * @return subscriptionId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(final String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public VnfLcmOperationOccurrenceNotification timeStamp(final OffsetDateTime timeStamp) {
		this.timeStamp = timeStamp;
		return this;
	}

	/**
	 * Get timeStamp
	 *
	 * @return timeStamp
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public OffsetDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(final OffsetDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public VnfLcmOperationOccurrenceNotification notificationStatus(final NotificationStatusEnum notificationStatus) {
		this.notificationStatus = notificationStatus;
		return this;
	}

	/**
	 * Indicates whether this notification reports about the start of a lifecycle
	 * operation or the result of a lifecycle operation. Permitted values: * START:
	 * Informs about the start of the VNF LCM operation occurrence. * RESULT:
	 * Informs about the final or intermediate result of the VNF LCM operation
	 * occurrence.
	 *
	 * @return notificationStatus
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Indicates whether this notification reports about the start of a lifecycle operation or the result of a lifecycle operation. Permitted values: * START: Informs about the start of the VNF LCM operation   occurrence. * RESULT: Informs about the final or intermediate result of the VNF   LCM operation occurrence. ")
	@NotNull

	public NotificationStatusEnum getNotificationStatus() {
		return notificationStatus;
	}

	public void setNotificationStatus(final NotificationStatusEnum notificationStatus) {
		this.notificationStatus = notificationStatus;
	}

	public VnfLcmOperationOccurrenceNotification operationState(final LcmOperationStateType operationState) {
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

	public VnfLcmOperationOccurrenceNotification vnfInstanceId(final String vnfInstanceId) {
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

	public VnfLcmOperationOccurrenceNotification operation(final LcmOperationType operation) {
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

	public VnfLcmOperationOccurrenceNotification isAutomaticInvocation(final Boolean isAutomaticInvocation) {
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

	public VnfLcmOperationOccurrenceNotification verbosity(final LcmOpOccNotificationVerbosityType verbosity) {
		this.verbosity = verbosity;
		return this;
	}

	/**
	 * Get verbosity
	 *
	 * @return verbosity
	 **/
	@Schema(description = "")

	@Valid
	public LcmOpOccNotificationVerbosityType getVerbosity() {
		return verbosity;
	}

	public void setVerbosity(final LcmOpOccNotificationVerbosityType verbosity) {
		this.verbosity = verbosity;
	}

	public VnfLcmOperationOccurrenceNotification vnfLcmOpOccId(final String vnfLcmOpOccId) {
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

	public VnfLcmOperationOccurrenceNotification affectedVnfcs(final List<AffectedVnfc> affectedVnfcs) {
		this.affectedVnfcs = affectedVnfcs;
		return this;
	}

	public VnfLcmOperationOccurrenceNotification addAffectedVnfcsItem(final AffectedVnfc affectedVnfcsItem) {
		if (this.affectedVnfcs == null) {
			this.affectedVnfcs = new ArrayList<>();
		}
		this.affectedVnfcs.add(affectedVnfcsItem);
		return this;
	}

	/**
	 * Information about VNFC instances that were affected during the lifecycle
	 * operation. See note 1.
	 *
	 * @return affectedVnfcs
	 **/
	@Schema(description = "Information about VNFC instances that were affected during the lifecycle operation. See note 1. ")
	@Valid
	public List<AffectedVnfc> getAffectedVnfcs() {
		return affectedVnfcs;
	}

	public void setAffectedVnfcs(final List<AffectedVnfc> affectedVnfcs) {
		this.affectedVnfcs = affectedVnfcs;
	}

	public VnfLcmOperationOccurrenceNotification affectedVirtualLinks(final List<AffectedVirtualLink> affectedVirtualLinks) {
		this.affectedVirtualLinks = affectedVirtualLinks;
		return this;
	}

	public VnfLcmOperationOccurrenceNotification addAffectedVirtualLinksItem(final AffectedVirtualLink affectedVirtualLinksItem) {
		if (this.affectedVirtualLinks == null) {
			this.affectedVirtualLinks = new ArrayList<>();
		}
		this.affectedVirtualLinks.add(affectedVirtualLinksItem);
		return this;
	}

	/**
	 * Information about VL instances that were affected during the lifecycle
	 * operation. See note 1 and note 2.
	 *
	 * @return affectedVirtualLinks
	 **/
	@Schema(description = "Information about VL instances that were affected during the lifecycle operation. See note 1 and note 2. ")
	@Valid
	public List<AffectedVirtualLink> getAffectedVirtualLinks() {
		return affectedVirtualLinks;
	}

	public void setAffectedVirtualLinks(final List<AffectedVirtualLink> affectedVirtualLinks) {
		this.affectedVirtualLinks = affectedVirtualLinks;
	}

	public VnfLcmOperationOccurrenceNotification affectedExtLinkPorts(final List<AffectedExtLinkPort> affectedExtLinkPorts) {
		this.affectedExtLinkPorts = affectedExtLinkPorts;
		return this;
	}

	public VnfLcmOperationOccurrenceNotification addAffectedExtLinkPortsItem(final AffectedExtLinkPort affectedExtLinkPortsItem) {
		if (this.affectedExtLinkPorts == null) {
			this.affectedExtLinkPorts = new ArrayList<>();
		}
		this.affectedExtLinkPorts.add(affectedExtLinkPortsItem);
		return this;
	}

	/**
	 * Information about external VNF link ports that were affected during the
	 * lifecycle operation. See note 1.
	 *
	 * @return affectedExtLinkPorts
	 **/
	@Schema(description = "Information about external VNF link ports that were affected during the lifecycle operation. See note 1. ")
	@Valid
	public List<AffectedExtLinkPort> getAffectedExtLinkPorts() {
		return affectedExtLinkPorts;
	}

	public void setAffectedExtLinkPorts(final List<AffectedExtLinkPort> affectedExtLinkPorts) {
		this.affectedExtLinkPorts = affectedExtLinkPorts;
	}

	public VnfLcmOperationOccurrenceNotification affectedVirtualStorages(final List<AffectedVirtualStorage> affectedVirtualStorages) {
		this.affectedVirtualStorages = affectedVirtualStorages;
		return this;
	}

	public VnfLcmOperationOccurrenceNotification addAffectedVirtualStoragesItem(final AffectedVirtualStorage affectedVirtualStoragesItem) {
		if (this.affectedVirtualStorages == null) {
			this.affectedVirtualStorages = new ArrayList<>();
		}
		this.affectedVirtualStorages.add(affectedVirtualStoragesItem);
		return this;
	}

	/**
	 * Information about virtualised storage instances that were affected during the
	 * lifecycle operation. See note 1.
	 *
	 * @return affectedVirtualStorages
	 **/
	@Schema(description = "Information about virtualised storage instances that were affected during the lifecycle operation. See note 1. ")
	@Valid
	public List<AffectedVirtualStorage> getAffectedVirtualStorages() {
		return affectedVirtualStorages;
	}

	public void setAffectedVirtualStorages(final List<AffectedVirtualStorage> affectedVirtualStorages) {
		this.affectedVirtualStorages = affectedVirtualStorages;
	}

	public VnfLcmOperationOccurrenceNotification changedInfo(final VnfInfoModifications changedInfo) {
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

	public VnfLcmOperationOccurrenceNotification affectedVipCps(final List<AffectedVipCp> affectedVipCps) {
		this.affectedVipCps = affectedVipCps;
		return this;
	}

	public VnfLcmOperationOccurrenceNotification addAffectedVipCpsItem(final AffectedVipCp affectedVipCpsItem) {
		if (this.affectedVipCps == null) {
			this.affectedVipCps = new ArrayList<>();
		}
		this.affectedVipCps.add(affectedVipCpsItem);
		return this;
	}

	/**
	 * Information about virtual IP CP instances that were affected during the
	 * execution of the lifecycle management operation, if this notification
	 * represents the result of a lifecycle management operation occurrence. Shall
	 * be present if the \"notificationStatus\" is set to \"RESULT\", the
	 * \"verbosity\" attribute is set to \"FULL\" and the operation has made any
	 * changes to the VIP CP instances of the VNF instance. Shall be absent
	 * otherwise. Only information about VIP CP instances that have been added,
	 * deleted or modified shall be provided.
	 *
	 * @return affectedVipCps
	 **/
	@Schema(description = "Information about virtual IP CP instances that were affected during the execution of the lifecycle management operation, if this notification represents the result of a lifecycle management operation occurrence. Shall be present if the \"notificationStatus\" is set to \"RESULT\", the \"verbosity\" attribute is set to \"FULL\" and the operation has made any changes to the VIP CP instances of the VNF instance. Shall be absent otherwise. Only information about VIP CP instances that have been added, deleted or modified shall be provided. ")
	@Valid
	public List<AffectedVipCp> getAffectedVipCps() {
		return affectedVipCps;
	}

	public void setAffectedVipCps(final List<AffectedVipCp> affectedVipCps) {
		this.affectedVipCps = affectedVipCps;
	}

	public VnfLcmOperationOccurrenceNotification changedExtConnectivity(final List<ExtVirtualLinkInfo> changedExtConnectivity) {
		this.changedExtConnectivity = changedExtConnectivity;
		return this;
	}

	public VnfLcmOperationOccurrenceNotification addChangedExtConnectivityItem(final ExtVirtualLinkInfo changedExtConnectivityItem) {
		if (this.changedExtConnectivity == null) {
			this.changedExtConnectivity = new ArrayList<>();
		}
		this.changedExtConnectivity.add(changedExtConnectivityItem);
		return this;
	}

	/**
	 * Information about changed external connectivity, if this notification
	 * represents the result of a lifecycle operation occurrence. Shall be present
	 * if the \"notificationStatus\" is set to \"RESULT\", the \"verbosity\"
	 * attribute is set to \"FULL\" and the operation has made any changes to the
	 * external connectivity of the VNF instance. Shall be absent otherwise. Only
	 * information about external VL instances that have been added or modified
	 * shall be provided.
	 *
	 * @return changedExtConnectivity
	 **/
	@Schema(description = "Information about changed external connectivity, if this notification represents the result of a lifecycle operation occurrence. Shall be present if the \"notificationStatus\" is set to \"RESULT\", the \"verbosity\" attribute is set to \"FULL\" and the operation has made any changes to the external connectivity of the VNF instance. Shall be absent otherwise. Only information about external VL instances that have been added or modified shall be provided. ")
	@Valid
	public List<ExtVirtualLinkInfo> getChangedExtConnectivity() {
		return changedExtConnectivity;
	}

	public void setChangedExtConnectivity(final List<ExtVirtualLinkInfo> changedExtConnectivity) {
		this.changedExtConnectivity = changedExtConnectivity;
	}

	public VnfLcmOperationOccurrenceNotification modificationsTriggeredByVnfPkgChange(final ModificationsTriggeredByVnfPkgChange modificationsTriggeredByVnfPkgChange) {
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

	public VnfLcmOperationOccurrenceNotification error(final ProblemDetails error) {
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

	public VnfLcmOperationOccurrenceNotification _links(final LccnLinks _links) {
		this._links = _links;
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
	public LccnLinks getLinks() {
		return _links;
	}

	public void setLinks(final LccnLinks _links) {
		this._links = _links;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final VnfLcmOperationOccurrenceNotification vnfLcmOperationOccurrenceNotification = (VnfLcmOperationOccurrenceNotification) o;
		return Objects.equals(this.id, vnfLcmOperationOccurrenceNotification.id) &&
				Objects.equals(this.notificationType, vnfLcmOperationOccurrenceNotification.notificationType) &&
				Objects.equals(this.subscriptionId, vnfLcmOperationOccurrenceNotification.subscriptionId) &&
				Objects.equals(this.timeStamp, vnfLcmOperationOccurrenceNotification.timeStamp) &&
				Objects.equals(this.notificationStatus, vnfLcmOperationOccurrenceNotification.notificationStatus) &&
				Objects.equals(this.operationState, vnfLcmOperationOccurrenceNotification.operationState) &&
				Objects.equals(this.vnfInstanceId, vnfLcmOperationOccurrenceNotification.vnfInstanceId) &&
				Objects.equals(this.operation, vnfLcmOperationOccurrenceNotification.operation) &&
				Objects.equals(this.isAutomaticInvocation, vnfLcmOperationOccurrenceNotification.isAutomaticInvocation) &&
				Objects.equals(this.verbosity, vnfLcmOperationOccurrenceNotification.verbosity) &&
				Objects.equals(this.vnfLcmOpOccId, vnfLcmOperationOccurrenceNotification.vnfLcmOpOccId) &&
				Objects.equals(this.affectedVnfcs, vnfLcmOperationOccurrenceNotification.affectedVnfcs) &&
				Objects.equals(this.affectedVirtualLinks, vnfLcmOperationOccurrenceNotification.affectedVirtualLinks) &&
				Objects.equals(this.affectedExtLinkPorts, vnfLcmOperationOccurrenceNotification.affectedExtLinkPorts) &&
				Objects.equals(this.affectedVirtualStorages, vnfLcmOperationOccurrenceNotification.affectedVirtualStorages) &&
				Objects.equals(this.changedInfo, vnfLcmOperationOccurrenceNotification.changedInfo) &&
				Objects.equals(this.affectedVipCps, vnfLcmOperationOccurrenceNotification.affectedVipCps) &&
				Objects.equals(this.changedExtConnectivity, vnfLcmOperationOccurrenceNotification.changedExtConnectivity) &&
				Objects.equals(this.modificationsTriggeredByVnfPkgChange, vnfLcmOperationOccurrenceNotification.modificationsTriggeredByVnfPkgChange) &&
				Objects.equals(this.error, vnfLcmOperationOccurrenceNotification.error) &&
				Objects.equals(this._links, vnfLcmOperationOccurrenceNotification._links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, notificationType, subscriptionId, timeStamp, notificationStatus, operationState, vnfInstanceId, operation, isAutomaticInvocation, verbosity, vnfLcmOpOccId, affectedVnfcs, affectedVirtualLinks, affectedExtLinkPorts, affectedVirtualStorages, changedInfo, affectedVipCps, changedExtConnectivity, modificationsTriggeredByVnfPkgChange, error, _links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class VnfLcmOperationOccurrenceNotification {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    notificationType: ").append(toIndentedString(notificationType)).append("\n");
		sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
		sb.append("    timeStamp: ").append(toIndentedString(timeStamp)).append("\n");
		sb.append("    notificationStatus: ").append(toIndentedString(notificationStatus)).append("\n");
		sb.append("    operationState: ").append(toIndentedString(operationState)).append("\n");
		sb.append("    vnfInstanceId: ").append(toIndentedString(vnfInstanceId)).append("\n");
		sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
		sb.append("    isAutomaticInvocation: ").append(toIndentedString(isAutomaticInvocation)).append("\n");
		sb.append("    verbosity: ").append(toIndentedString(verbosity)).append("\n");
		sb.append("    vnfLcmOpOccId: ").append(toIndentedString(vnfLcmOpOccId)).append("\n");
		sb.append("    affectedVnfcs: ").append(toIndentedString(affectedVnfcs)).append("\n");
		sb.append("    affectedVirtualLinks: ").append(toIndentedString(affectedVirtualLinks)).append("\n");
		sb.append("    affectedExtLinkPorts: ").append(toIndentedString(affectedExtLinkPorts)).append("\n");
		sb.append("    affectedVirtualStorages: ").append(toIndentedString(affectedVirtualStorages)).append("\n");
		sb.append("    changedInfo: ").append(toIndentedString(changedInfo)).append("\n");
		sb.append("    affectedVipCps: ").append(toIndentedString(affectedVipCps)).append("\n");
		sb.append("    changedExtConnectivity: ").append(toIndentedString(changedExtConnectivity)).append("\n");
		sb.append("    modificationsTriggeredByVnfPkgChange: ").append(toIndentedString(modificationsTriggeredByVnfPkgChange)).append("\n");
		sb.append("    error: ").append(toIndentedString(error)).append("\n");
		sb.append("    _links: ").append(toIndentedString(_links)).append("\n");
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
