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
package com.ubiqube.etsi.mano.v331.model.nfvem.nfvmanocim;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ubiqube.etsi.mano.v331.model.nfvem.nfvmanocim.ManoEntitySubscriptionFilter;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents a subscription filter related to notifications  about NFV-MANO configuration and information management.  
 */
@Schema (description= "This type represents a subscription filter related to notifications  about NFV-MANO configuration and information management.  " )
@Validated
public class CimNotificationsFilter   {
  @JsonProperty("manoEntitySubscriptionFilter")
  private ManoEntitySubscriptionFilter manoEntitySubscriptionFilter = null;

  /**
   * Gets or Sets notificationTypes
   */
  public enum NotificationTypesEnum {
    INFORMATIONCHANGEDNOTIFICATION("InformationChangedNotification"),
    
    CHANGESTATENOTIFICATION("ChangeStateNotification");

    private String value;

    NotificationTypesEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static NotificationTypesEnum fromValue(String text) {
      for (NotificationTypesEnum b : NotificationTypesEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("notificationTypes")
  @Valid
  private List<NotificationTypesEnum> notificationTypes = null;

  public CimNotificationsFilter manoEntitySubscriptionFilter(ManoEntitySubscriptionFilter manoEntitySubscriptionFilter) {
    this.manoEntitySubscriptionFilter = manoEntitySubscriptionFilter;
    return this;
  }

  /**
   * Get manoEntitySubscriptionFilter
   * @return manoEntitySubscriptionFilter
  **/
  @Schema(description= "" )
  
    @Valid
    public ManoEntitySubscriptionFilter getManoEntitySubscriptionFilter() {
    return manoEntitySubscriptionFilter;
  }

  public void setManoEntitySubscriptionFilter(ManoEntitySubscriptionFilter manoEntitySubscriptionFilter) {
    this.manoEntitySubscriptionFilter = manoEntitySubscriptionFilter;
  }

  public CimNotificationsFilter notificationTypes(List<NotificationTypesEnum> notificationTypes) {
    this.notificationTypes = notificationTypes;
    return this;
  }

  public CimNotificationsFilter addNotificationTypesItem(NotificationTypesEnum notificationTypesItem) {
    if (this.notificationTypes == null) {
      this.notificationTypes = new ArrayList<>();
    }
    this.notificationTypes.add(notificationTypesItem);
    return this;
  }

  /**
   * Match particular notification types.  Permitted values:   - InformationChangedNotification   - ChangeStateNotification  NOTE: The permitted values of the \"notificationTypes\" attribute are  spelled exactly as the names of the notification types to facilitate  automated code generation systems. 
   * @return notificationTypes
  **/
  @Schema(description= "Match particular notification types.  Permitted values:   - InformationChangedNotification   - ChangeStateNotification  NOTE: The permitted values of the \"notificationTypes\" attribute are  spelled exactly as the names of the notification types to facilitate  automated code generation systems. " )
  
    public List<NotificationTypesEnum> getNotificationTypes() {
    return notificationTypes;
  }

  public void setNotificationTypes(List<NotificationTypesEnum> notificationTypes) {
    this.notificationTypes = notificationTypes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CimNotificationsFilter cimNotificationsFilter = (CimNotificationsFilter) o;
    return Objects.equals(this.manoEntitySubscriptionFilter, cimNotificationsFilter.manoEntitySubscriptionFilter) &&
        Objects.equals(this.notificationTypes, cimNotificationsFilter.notificationTypes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(manoEntitySubscriptionFilter, notificationTypes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CimNotificationsFilter {\n");
    
    sb.append("    manoEntitySubscriptionFilter: ").append(toIndentedString(manoEntitySubscriptionFilter)).append("\n");
    sb.append("    notificationTypes: ").append(toIndentedString(notificationTypes)).append("\n");
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
