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


import jakarta.annotation.Nonnull;

/**
  * Details of a simple threshold. Shall be present if thresholdType=\"SIMPLE\". 
 **/
@Schema(description="Details of a simple threshold. Shall be present if thresholdType=\"SIMPLE\". ")
public class ThresholdsThresholdCriteriaSimpleThresholdDetails  {
  
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "The threshold value. Shall be represented as a floating point number.                ")
 /**
   * The threshold value. Shall be represented as a floating point number.                
  **/
  private Integer thresholdValue = null;

  @Schema(requiredMode = RequiredMode.REQUIRED, description = "The hysteresis of the threshold. Shall be represented as a non-negative floating point number. A notification with crossing direction \"UP\" will be generated if the measured value reaches or exceeds \"thresholdValue\" + \"hysteresis\". A notification with crossing direction \"DOWN\" will be generated if the measured value reaches or undercuts \"thresholdValue\" - \"hysteresis\". The hysteresis is defined to prevent storms of threshold crossing notifications. When processing a request to create a threshold, implementations should enforce a suitable minimum value for this attribute (e.g. override the value or reject the request). ")
 /**
   * The hysteresis of the threshold. Shall be represented as a non-negative floating point number. A notification with crossing direction \"UP\" will be generated if the measured value reaches or exceeds \"thresholdValue\" + \"hysteresis\". A notification with crossing direction \"DOWN\" will be generated if the measured value reaches or undercuts \"thresholdValue\" - \"hysteresis\". The hysteresis is defined to prevent storms of threshold crossing notifications. When processing a request to create a threshold, implementations should enforce a suitable minimum value for this attribute (e.g. override the value or reject the request). 
  **/
  private Integer hysteresis = null;
 /**
   * The threshold value. Shall be represented as a floating point number.                
   * @return thresholdValue
  **/
  @JsonProperty("thresholdValue")
  @Nonnull
  public Integer getThresholdValue() {
    return thresholdValue;
  }

  public void setThresholdValue(Integer thresholdValue) {
    this.thresholdValue = thresholdValue;
  }

  public ThresholdsThresholdCriteriaSimpleThresholdDetails thresholdValue(Integer thresholdValue) {
    this.thresholdValue = thresholdValue;
    return this;
  }

 /**
   * The hysteresis of the threshold. Shall be represented as a non-negative floating point number. A notification with crossing direction \&quot;UP\&quot; will be generated if the measured value reaches or exceeds \&quot;thresholdValue\&quot; + \&quot;hysteresis\&quot;. A notification with crossing direction \&quot;DOWN\&quot; will be generated if the measured value reaches or undercuts \&quot;thresholdValue\&quot; - \&quot;hysteresis\&quot;. The hysteresis is defined to prevent storms of threshold crossing notifications. When processing a request to create a threshold, implementations should enforce a suitable minimum value for this attribute (e.g. override the value or reject the request). 
   * @return hysteresis
  **/
  @JsonProperty("hysteresis")
  @Nonnull
  public Integer getHysteresis() {
    return hysteresis;
  }

  public void setHysteresis(Integer hysteresis) {
    this.hysteresis = hysteresis;
  }

  public ThresholdsThresholdCriteriaSimpleThresholdDetails hysteresis(Integer hysteresis) {
    this.hysteresis = hysteresis;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ThresholdsThresholdCriteriaSimpleThresholdDetails {\n");
    
    sb.append("    thresholdValue: ").append(toIndentedString(thresholdValue)).append("\n");
    sb.append("    hysteresis: ").append(toIndentedString(hysteresis)).append("\n");
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

