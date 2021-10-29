package com.ubiqube.etsi.mano.em.v351.model.vnfpm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Details of a simple threshold. Shall be present if thresholdType&#x3D;\&quot;SIMPLE\&quot;. 
 */
@Schema(description = "Details of a simple threshold. Shall be present if thresholdType=\"SIMPLE\". ")
@Validated


public class ThresholdCriteriaSimpleThresholdDetails   {
  @JsonProperty("thresholdValue")
  private Float thresholdValue = null;

  @JsonProperty("hysteresis")
  private Float hysteresis = null;

  public ThresholdCriteriaSimpleThresholdDetails thresholdValue(Float thresholdValue) {
    this.thresholdValue = thresholdValue;
    return this;
  }

  /**
   * The threshold value. Shall be represented as a floating point number. 
   * @return thresholdValue
   **/
  @Schema(required = true, description = "The threshold value. Shall be represented as a floating point number. ")
      @NotNull

    public Float getThresholdValue() {
    return thresholdValue;
  }

  public void setThresholdValue(Float thresholdValue) {
    this.thresholdValue = thresholdValue;
  }

  public ThresholdCriteriaSimpleThresholdDetails hysteresis(Float hysteresis) {
    this.hysteresis = hysteresis;
    return this;
  }

  /**
   * The hysteresis of the threshold.  Shall be represented as a non-negative floating point number. A notification with crossing direction \"UP\" will be generated if the measured value reaches or exceeds  \"thresholdValue\" + \"hysteresis\". A notification with crossing direction \"DOWN\" will be generated if the  measured value reaches or undercuts \"thresholdValue\" - \"hysteresis\". See note 2. 
   * minimum: 0
   * maximum: 1024
   * @return hysteresis
   **/
  @Schema(required = true, description = "The hysteresis of the threshold.  Shall be represented as a non-negative floating point number. A notification with crossing direction \"UP\" will be generated if the measured value reaches or exceeds  \"thresholdValue\" + \"hysteresis\". A notification with crossing direction \"DOWN\" will be generated if the  measured value reaches or undercuts \"thresholdValue\" - \"hysteresis\". See note 2. ")
      @NotNull

  @DecimalMin("0") @DecimalMax("1024")   public Float getHysteresis() {
    return hysteresis;
  }

  public void setHysteresis(Float hysteresis) {
    this.hysteresis = hysteresis;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ThresholdCriteriaSimpleThresholdDetails thresholdCriteriaSimpleThresholdDetails = (ThresholdCriteriaSimpleThresholdDetails) o;
    return Objects.equals(this.thresholdValue, thresholdCriteriaSimpleThresholdDetails.thresholdValue) &&
        Objects.equals(this.hysteresis, thresholdCriteriaSimpleThresholdDetails.hysteresis);
  }

  @Override
  public int hashCode() {
    return Objects.hash(thresholdValue, hysteresis);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ThresholdCriteriaSimpleThresholdDetails {\n");
    
    sb.append("    thresholdValue: ").append(toIndentedString(thresholdValue)).append("\n");
    sb.append("    hysteresis: ").append(toIndentedString(hysteresis)).append("\n");
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
