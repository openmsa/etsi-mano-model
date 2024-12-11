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
package com.ubiqube.etsi.mano.v261.model.nfvo.nsperfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;


import jakarta.validation.Valid;
import jakarta.annotation.Nonnull;

/**
  * Links to resources related to this notification. 
 **/
@Schema(description="Links to resources related to this notification. ")
public class SubscriptionThresholdCrossedNotificationThresholdCrossedNotificationLinks  {
  
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
  @Valid
  private PmJobsPmJobReportsLinksSelf subscription = null;

  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
  @Valid
  private PmJobsPmJobReportsLinksSelf objectInstance = null;

  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
  @Valid
  private PmJobsPmJobReportsLinksSelf threshold = null;
 /**
   * Get subscription
   * @return subscription
  **/
  @JsonProperty("subscription")
  @Nonnull
  public PmJobsPmJobReportsLinksSelf getSubscription() {
    return subscription;
  }

  public void setSubscription(PmJobsPmJobReportsLinksSelf subscription) {
    this.subscription = subscription;
  }

  public SubscriptionThresholdCrossedNotificationThresholdCrossedNotificationLinks subscription(PmJobsPmJobReportsLinksSelf subscription) {
    this.subscription = subscription;
    return this;
  }

 /**
   * Get objectInstance
   * @return objectInstance
  **/
  @JsonProperty("objectInstance")
  @Nonnull
  public PmJobsPmJobReportsLinksSelf getObjectInstance() {
    return objectInstance;
  }

  public void setObjectInstance(PmJobsPmJobReportsLinksSelf objectInstance) {
    this.objectInstance = objectInstance;
  }

  public SubscriptionThresholdCrossedNotificationThresholdCrossedNotificationLinks objectInstance(PmJobsPmJobReportsLinksSelf objectInstance) {
    this.objectInstance = objectInstance;
    return this;
  }

 /**
   * Get threshold
   * @return threshold
  **/
  @JsonProperty("threshold")
  @Nonnull
  public PmJobsPmJobReportsLinksSelf getThreshold() {
    return threshold;
  }

  public void setThreshold(PmJobsPmJobReportsLinksSelf threshold) {
    this.threshold = threshold;
  }

  public SubscriptionThresholdCrossedNotificationThresholdCrossedNotificationLinks threshold(PmJobsPmJobReportsLinksSelf threshold) {
    this.threshold = threshold;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class URIIsProvidedByTheClientWhenCreatingTheSubscriptionThresholdCrossedNotificationThresholdCrossedNotificationLinks {\n");
    
    sb.append("    subscription: ").append(toIndentedString(subscription)).append("\n");
    sb.append("    objectInstance: ").append(toIndentedString(objectInstance)).append("\n");
    sb.append("    threshold: ").append(toIndentedString(threshold)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private static String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

