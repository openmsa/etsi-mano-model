package com.ubiqube.etsi.mano.v281.model.vnfm.vnfpm;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This notification informs the receiver that performance information is
 * available. The notification shall be triggered by the VNFM when new
 * performance information collected by a PM job is available. The periodicity
 * of triggering this notification is influenced by the
 * \&quot;reportingPeriod\&quot; attribute in the \&quot;PmJobCriteria\&quot;
 * data structure.
 */
@Schema(description = "This notification informs the receiver that performance information is available. The notification shall be triggered by the VNFM when new performance information collected by a PM job is available. The periodicity of triggering this notification is influenced by the  \"reportingPeriod\" attribute in the \"PmJobCriteria\" data structure. ")
@Validated

public class PerformanceInformationAvailableNotification {
	@JsonProperty("id")
	private String id = null;

	/**
	 * Discriminator for the different notification types. Shall be set to
	 * \"PerformanceInformationAvailableNotification\" for this notification type.
	 */
	public enum NotificationTypeEnum {
		PERFORMANCEINFORMATIONAVAILABLENOTIFICATION("PerformanceInformationAvailableNotification");

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

	@JsonProperty("timeStamp")
	private OffsetDateTime timeStamp = null;

	@JsonProperty("pmJobId")
	private String pmJobId = null;

	@JsonProperty("objectType")
	private String objectType = null;

	@JsonProperty("objectInstanceId")
	private String objectInstanceId = null;

	@JsonProperty("subObjectInstanceIds")
	@Valid
	private List<String> subObjectInstanceIds = null;

	@JsonProperty("_links")
	private PerformanceInformationAvailableNotificationLinks _links = null;

	public PerformanceInformationAvailableNotification id(final String id) {
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

	public PerformanceInformationAvailableNotification notificationType(final NotificationTypeEnum notificationType) {
		this.notificationType = notificationType;
		return this;
	}

	/**
	 * Discriminator for the different notification types. Shall be set to
	 * \"PerformanceInformationAvailableNotification\" for this notification type.
	 *
	 * @return notificationType
	 **/
	@Schema(required = true, description = "Discriminator for the different notification types. Shall be set to \"PerformanceInformationAvailableNotification\" for this notification type. ")
	@NotNull

	public NotificationTypeEnum getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(final NotificationTypeEnum notificationType) {
		this.notificationType = notificationType;
	}

	public PerformanceInformationAvailableNotification timeStamp(final OffsetDateTime timeStamp) {
		this.timeStamp = timeStamp;
		return this;
	}

	/**
	 * Get timeStamp
	 *
	 * @return timeStamp
	 **/
	@Schema(required = true, description = "")
	@NotNull

	@Valid
	public OffsetDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(final OffsetDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public PerformanceInformationAvailableNotification pmJobId(final String pmJobId) {
		this.pmJobId = pmJobId;
		return this;
	}

	/**
	 * Get pmJobId
	 *
	 * @return pmJobId
	 **/
	@Schema(required = true, description = "")
	@NotNull

	public String getPmJobId() {
		return pmJobId;
	}

	public void setPmJobId(final String pmJobId) {
		this.pmJobId = pmJobId;
	}

	public PerformanceInformationAvailableNotification objectType(final String objectType) {
		this.objectType = objectType;
		return this;
	}

	/**
	 * Type of the measured object. The applicable measured object type for a
	 * measurement is defined in clause 7.2 of ETSI GS NFV-IFA 027.
	 *
	 * @return objectType
	 **/
	@Schema(required = true, description = "Type of the measured object. The applicable measured object type for a measurement is defined in clause 7.2 of ETSI GS NFV-IFA 027. ")
	@NotNull

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(final String objectType) {
		this.objectType = objectType;
	}

	public PerformanceInformationAvailableNotification objectInstanceId(final String objectInstanceId) {
		this.objectInstanceId = objectInstanceId;
		return this;
	}

	/**
	 * Get objectInstanceId
	 *
	 * @return objectInstanceId
	 **/
	@Schema(required = true, description = "")
	@NotNull

	public String getObjectInstanceId() {
		return objectInstanceId;
	}

	public void setObjectInstanceId(final String objectInstanceId) {
		this.objectInstanceId = objectInstanceId;
	}

	public PerformanceInformationAvailableNotification subObjectInstanceIds(final List<String> subObjectInstanceIds) {
		this.subObjectInstanceIds = subObjectInstanceIds;
		return this;
	}

	public PerformanceInformationAvailableNotification addSubObjectInstanceIdsItem(final String subObjectInstanceIdsItem) {
		if (this.subObjectInstanceIds == null) {
			this.subObjectInstanceIds = new ArrayList<>();
		}
		this.subObjectInstanceIds.add(subObjectInstanceIdsItem);
		return this;
	}

	/**
	 * Identifiers of the sub-object instances of the measured object instance for
	 * which the measurements have been taken. Shall be present if the related PM
	 * job has been set up to measure only a subset of all sub-object instances of
	 * the measured object instance and a sub-object is defined in clause 6.2 of
	 * ETSI GS NFV-IFA 027 for the related measured object type. Shall be absent
	 * otherwise.
	 *
	 * @return subObjectInstanceIds
	 **/
	@Schema(description = "Identifiers of the sub-object instances of the measured object instance for which the measurements have been taken. Shall be present if the related PM job has been set up to measure only a subset of all sub-object instances of the measured object instance and a sub-object is defined in clause  6.2 of ETSI GS NFV-IFA 027 for the related measured object type. Shall be absent otherwise. ")

	public List<String> getSubObjectInstanceIds() {
		return subObjectInstanceIds;
	}

	public void setSubObjectInstanceIds(final List<String> subObjectInstanceIds) {
		this.subObjectInstanceIds = subObjectInstanceIds;
	}

	public PerformanceInformationAvailableNotification _links(final PerformanceInformationAvailableNotificationLinks _links) {
		this._links = _links;
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
	public PerformanceInformationAvailableNotificationLinks getLinks() {
		return _links;
	}

	public void setLinks(final PerformanceInformationAvailableNotificationLinks _links) {
		this._links = _links;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final PerformanceInformationAvailableNotification performanceInformationAvailableNotification = (PerformanceInformationAvailableNotification) o;
		return Objects.equals(this.id, performanceInformationAvailableNotification.id) &&
				Objects.equals(this.notificationType, performanceInformationAvailableNotification.notificationType) &&
				Objects.equals(this.timeStamp, performanceInformationAvailableNotification.timeStamp) &&
				Objects.equals(this.pmJobId, performanceInformationAvailableNotification.pmJobId) &&
				Objects.equals(this.objectType, performanceInformationAvailableNotification.objectType) &&
				Objects.equals(this.objectInstanceId, performanceInformationAvailableNotification.objectInstanceId) &&
				Objects.equals(this.subObjectInstanceIds, performanceInformationAvailableNotification.subObjectInstanceIds) &&
				Objects.equals(this._links, performanceInformationAvailableNotification._links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, notificationType, timeStamp, pmJobId, objectType, objectInstanceId, subObjectInstanceIds, _links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class PerformanceInformationAvailableNotification {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    notificationType: ").append(toIndentedString(notificationType)).append("\n");
		sb.append("    timeStamp: ").append(toIndentedString(timeStamp)).append("\n");
		sb.append("    pmJobId: ").append(toIndentedString(pmJobId)).append("\n");
		sb.append("    objectType: ").append(toIndentedString(objectType)).append("\n");
		sb.append("    objectInstanceId: ").append(toIndentedString(objectInstanceId)).append("\n");
		sb.append("    subObjectInstanceIds: ").append(toIndentedString(subObjectInstanceIds)).append("\n");
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
