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
package com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanologm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanologm.LoggingJobMessagesCriteria;
import com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanologm.LoggingJobServicesCriteria;
import com.ubiqube.etsi.mano.v431.model.nfvem.nfvmanologm.LoggingJobSystemCriteria;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents collection criteria for logging jobs. * NOTE: The value of the loggingType has dependency on the object that is requested to be logged         (refer to the CreateLoggingJobRequest): a) the logging of messages is only applicable to         ManoServiceInterface and ConsumedManoInterface objects.
 */
@Schema(description = "This type represents collection criteria for logging jobs. * NOTE: The value of the loggingType has dependency on the object that is requested to be logged         (refer to the CreateLoggingJobRequest): a) the logging of messages is only applicable to         ManoServiceInterface and ConsumedManoInterface objects.")
@Validated



public class LoggingJobCriteria   {
  /**
   * Type of logging. This defines the types of logged information to collect. Permitted values: - MESSAGES: logged NFV-MANO service interface messages. - SERVICES: logged messages about processes pertaining to NFV-MANO services. - SYSTEM: logged messages about the NFV-MANO functional entity’s system enabled by the provider. See note.
   */
  public enum LoggingTypeEnum {
    MESSAGES("MESSAGES"),
    
    SERVICES("SERVICES"),
    
    SYSTEM("SYSTEM");

    private String value;

    LoggingTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static LoggingTypeEnum fromValue(String text) {
      for (LoggingTypeEnum b : LoggingTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("loggingType")
  private LoggingTypeEnum loggingType = null;

  @JsonProperty("messagesLogDetail")
  private LoggingJobMessagesCriteria messagesLogDetail = null;

  @JsonProperty("servicesLogDetail")
  private LoggingJobServicesCriteria servicesLogDetail = null;

  @JsonProperty("systemLogDetail")
  private LoggingJobSystemCriteria systemLogDetail = null;

  public LoggingJobCriteria loggingType(LoggingTypeEnum loggingType) {
    this.loggingType = loggingType;
    return this;
  }

  /**
   * Type of logging. This defines the types of logged information to collect. Permitted values: - MESSAGES: logged NFV-MANO service interface messages. - SERVICES: logged messages about processes pertaining to NFV-MANO services. - SYSTEM: logged messages about the NFV-MANO functional entity’s system enabled by the provider. See note.
   * @return loggingType
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Type of logging. This defines the types of logged information to collect. Permitted values: - MESSAGES: logged NFV-MANO service interface messages. - SERVICES: logged messages about processes pertaining to NFV-MANO services. - SYSTEM: logged messages about the NFV-MANO functional entity’s system enabled by the provider. See note.")
      @NotNull

    public LoggingTypeEnum getLoggingType() {
    return loggingType;
  }

  public void setLoggingType(LoggingTypeEnum loggingType) {
    this.loggingType = loggingType;
  }

  public LoggingJobCriteria messagesLogDetail(LoggingJobMessagesCriteria messagesLogDetail) {
    this.messagesLogDetail = messagesLogDetail;
    return this;
  }

  /**
   * Get messagesLogDetail
   * @return messagesLogDetail
   **/
  @Schema(description = "")
  
    @Valid
    public LoggingJobMessagesCriteria getMessagesLogDetail() {
    return messagesLogDetail;
  }

  public void setMessagesLogDetail(LoggingJobMessagesCriteria messagesLogDetail) {
    this.messagesLogDetail = messagesLogDetail;
  }

  public LoggingJobCriteria servicesLogDetail(LoggingJobServicesCriteria servicesLogDetail) {
    this.servicesLogDetail = servicesLogDetail;
    return this;
  }

  /**
   * Get servicesLogDetail
   * @return servicesLogDetail
   **/
  @Schema(description = "")
  
    @Valid
    public LoggingJobServicesCriteria getServicesLogDetail() {
    return servicesLogDetail;
  }

  public void setServicesLogDetail(LoggingJobServicesCriteria servicesLogDetail) {
    this.servicesLogDetail = servicesLogDetail;
  }

  public LoggingJobCriteria systemLogDetail(LoggingJobSystemCriteria systemLogDetail) {
    this.systemLogDetail = systemLogDetail;
    return this;
  }

  /**
   * Get systemLogDetail
   * @return systemLogDetail
   **/
  @Schema(description = "")
  
    @Valid
    public LoggingJobSystemCriteria getSystemLogDetail() {
    return systemLogDetail;
  }

  public void setSystemLogDetail(LoggingJobSystemCriteria systemLogDetail) {
    this.systemLogDetail = systemLogDetail;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoggingJobCriteria loggingJobCriteria = (LoggingJobCriteria) o;
    return Objects.equals(this.loggingType, loggingJobCriteria.loggingType) &&
        Objects.equals(this.messagesLogDetail, loggingJobCriteria.messagesLogDetail) &&
        Objects.equals(this.servicesLogDetail, loggingJobCriteria.servicesLogDetail) &&
        Objects.equals(this.systemLogDetail, loggingJobCriteria.systemLogDetail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(loggingType, messagesLogDetail, servicesLogDetail, systemLogDetail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoggingJobCriteria {\n");
    
    sb.append("    loggingType: ").append(toIndentedString(loggingType)).append("\n");
    sb.append("    messagesLogDetail: ").append(toIndentedString(messagesLogDetail)).append("\n");
    sb.append("    servicesLogDetail: ").append(toIndentedString(servicesLogDetail)).append("\n");
    sb.append("    systemLogDetail: ").append(toIndentedString(systemLogDetail)).append("\n");
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
