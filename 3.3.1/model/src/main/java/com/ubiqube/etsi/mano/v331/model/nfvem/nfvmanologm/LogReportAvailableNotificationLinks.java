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
package com.ubiqube.etsi.mano.v331.model.nfvem.nfvmanologm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v331.model.nfvem.nfvmanologm.NotificationLink;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Links to resources related to this notification.
 */
@Schema(description = "Links to resources related to this notification.")
@Validated


public class LogReportAvailableNotificationLinks   {
  @JsonProperty("subscription")
  private NotificationLink subscription = null;

  @JsonProperty("objectInstance")
  private NotificationLink objectInstance = null;

  @JsonProperty("LoggingJob")
  private NotificationLink loggingJob = null;

  @JsonProperty("logReports")
  @Valid
  private List<NotificationLink> logReports = new ArrayList<>();

  public LogReportAvailableNotificationLinks subscription(NotificationLink subscription) {
    this.subscription = subscription;
    return this;
  }

  /**
   * Get subscription
   * @return subscription
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    @Valid
    public NotificationLink getSubscription() {
    return subscription;
  }

  public void setSubscription(NotificationLink subscription) {
    this.subscription = subscription;
  }

  public LogReportAvailableNotificationLinks objectInstance(NotificationLink objectInstance) {
    this.objectInstance = objectInstance;
    return this;
  }

  /**
   * Get objectInstance
   * @return objectInstance
   **/
  @Schema(description = "")
  
    @Valid
    public NotificationLink getObjectInstance() {
    return objectInstance;
  }

  public void setObjectInstance(NotificationLink objectInstance) {
    this.objectInstance = objectInstance;
  }

  public LogReportAvailableNotificationLinks loggingJob(NotificationLink loggingJob) {
    this.loggingJob = loggingJob;
    return this;
  }

  /**
   * Get loggingJob
   * @return loggingJob
   **/
  @Schema(description = "")
  
    @Valid
    public NotificationLink getLoggingJob() {
    return loggingJob;
  }

  public void setLoggingJob(NotificationLink loggingJob) {
    this.loggingJob = loggingJob;
  }

  public LogReportAvailableNotificationLinks logReports(List<NotificationLink> logReports) {
    this.logReports = logReports;
    return this;
  }

  public LogReportAvailableNotificationLinks addLogReportsItem(NotificationLink logReportsItem) {
    this.logReports.add(logReportsItem);
    return this;
  }

  /**
   * Link from which the available log report can be obtained. Due to the relationship of the logging job compilation and the logging information availability reporting, more than one logReport notification link can be provided.
   * @return logReports
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Link from which the available log report can be obtained. Due to the relationship of the logging job compilation and the logging information availability reporting, more than one logReport notification link can be provided.")
      @NotNull
    @Valid
    public List<NotificationLink> getLogReports() {
    return logReports;
  }

  public void setLogReports(List<NotificationLink> logReports) {
    this.logReports = logReports;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LogReportAvailableNotificationLinks logReportAvailableNotificationLinks = (LogReportAvailableNotificationLinks) o;
    return Objects.equals(this.subscription, logReportAvailableNotificationLinks.subscription) &&
        Objects.equals(this.objectInstance, logReportAvailableNotificationLinks.objectInstance) &&
        Objects.equals(this.loggingJob, logReportAvailableNotificationLinks.loggingJob) &&
        Objects.equals(this.logReports, logReportAvailableNotificationLinks.logReports);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subscription, objectInstance, loggingJob, logReports);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LogReportAvailableNotificationLinks {\n");
    
    sb.append("    subscription: ").append(toIndentedString(subscription)).append("\n");
    sb.append("    objectInstance: ").append(toIndentedString(objectInstance)).append("\n");
    sb.append("    loggingJob: ").append(toIndentedString(loggingJob)).append("\n");
    sb.append("    logReports: ").append(toIndentedString(logReports)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
