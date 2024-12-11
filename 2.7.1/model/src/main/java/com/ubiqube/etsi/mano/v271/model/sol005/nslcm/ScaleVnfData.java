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
package com.ubiqube.etsi.mano.v271.model.sol005.nslcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ubiqube.etsi.mano.v271.model.sol005.nslcm.ScaleByStepData;
import com.ubiqube.etsi.mano.v271.model.sol005.nslcm.ScaleToLevelData;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents defines the information to scale a VNF instance  to a given level, or to scale a VNF instance by steps. 
 */
@Schema (description= "This type represents defines the information to scale a VNF instance  to a given level, or to scale a VNF instance by steps. " )
@Validated
public class ScaleVnfData   {
  @JsonProperty("vnfInstanceid")
  private String vnfInstanceid = null;

  /**
   * Type of the scale VNF operation requested. Allowed values are: - SCALE_OUT - SCALE_IN - SCALE_TO_INSTANTIATION_LEVEL - SCALE_TO_SCALE_LEVEL(S) The set of types actually supported depends on the capabilities of the VNF being managed. 
   */
  public enum ScaleVnfTypeEnum {
    OUT("SCALE_OUT"),
    
    IN("SCALE_IN"),
    
    TO_INSTANTIATION_LEVEL("SCALE_TO_INSTANTIATION_LEVEL"),
    
    TO_SCALE_LEVEL_S_("SCALE_TO_SCALE_LEVEL(S)");

    private String value;

		ScaleVnfTypeEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static ScaleVnfTypeEnum fromValue(String text) {
			for (ScaleVnfTypeEnum b : ScaleVnfTypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
  }
  @JsonProperty("scaleVnfType")
  private ScaleVnfTypeEnum scaleVnfType = null;

  @JsonProperty("scaleToLevelData")
  private ScaleToLevelData scaleToLevelData = null;

  @JsonProperty("scaleByStepData")
  private ScaleByStepData scaleByStepData = null;

	public ScaleVnfData vnfInstanceid(String vnfInstanceid) {
		this.vnfInstanceid = vnfInstanceid;
		return this;
	}

	/**
	* Get vnfInstanceid
	* @return vnfInstanceid
	*/
	@Schema(required = true , description = "")
	@NotNull

	public String getVnfInstanceid() {
		return vnfInstanceid;
	}

	public void setVnfInstanceid(String vnfInstanceid) {
		this.vnfInstanceid = vnfInstanceid;
	}

	public ScaleVnfData scaleVnfType(ScaleVnfTypeEnum scaleVnfType) {
		this.scaleVnfType = scaleVnfType;
		return this;
	}

	/**
	* Type of the scale VNF operation requested. Allowed values are: - SCALE_OUT - SCALE_IN - SCALE_TO_INSTANTIATION_LEVEL - SCALE_TO_SCALE_LEVEL(S) The set of types actually supported depends on the capabilities of the VNF being managed. 
	* @return scaleVnfType
	*/
	@Schema(required = true , description = "Type of the scale VNF operation requested. Allowed values are: - SCALE_OUT - SCALE_IN - SCALE_TO_INSTANTIATION_LEVEL - SCALE_TO_SCALE_LEVEL(S) The set of types actually supported depends on the capabilities of the VNF being managed. ")
	@NotNull

	public ScaleVnfTypeEnum getScaleVnfType() {
		return scaleVnfType;
	}

	public void setScaleVnfType(ScaleVnfTypeEnum scaleVnfType) {
		this.scaleVnfType = scaleVnfType;
	}

	public ScaleVnfData scaleToLevelData(ScaleToLevelData scaleToLevelData) {
		this.scaleToLevelData = scaleToLevelData;
		return this;
	}

	/**
	* Get scaleToLevelData
	* @return scaleToLevelData
	*/
	@Schema(description = "")
	@Valid
	public ScaleToLevelData getScaleToLevelData() {
		return scaleToLevelData;
	}

	public void setScaleToLevelData(ScaleToLevelData scaleToLevelData) {
		this.scaleToLevelData = scaleToLevelData;
	}

	public ScaleVnfData scaleByStepData(ScaleByStepData scaleByStepData) {
		this.scaleByStepData = scaleByStepData;
		return this;
	}

	/**
	* Get scaleByStepData
	* @return scaleByStepData
	*/
	@Schema(description = "")
	@Valid
	public ScaleByStepData getScaleByStepData() {
		return scaleByStepData;
	}

	public void setScaleByStepData(ScaleByStepData scaleByStepData) {
		this.scaleByStepData = scaleByStepData;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ScaleVnfData scaleVnfData = (ScaleVnfData) o;
		return Objects.equals(this.vnfInstanceid, scaleVnfData.vnfInstanceid) &&
		Objects.equals(this.scaleVnfType, scaleVnfData.scaleVnfType) &&
		Objects.equals(this.scaleToLevelData, scaleVnfData.scaleToLevelData) &&
		Objects.equals(this.scaleByStepData, scaleVnfData.scaleByStepData);
	}

	@Override
	public int hashCode() {
		return Objects.hash(vnfInstanceid, scaleVnfType, scaleToLevelData, scaleByStepData);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ScaleVnfData {\n");

		sb.append("    vnfInstanceid: ").append(toIndentedString(vnfInstanceid)).append("\n");
		sb.append("    scaleVnfType: ").append(toIndentedString(scaleVnfType)).append("\n");
		sb.append("    scaleToLevelData: ").append(toIndentedString(scaleToLevelData)).append("\n");
		sb.append("    scaleByStepData: ").append(toIndentedString(scaleByStepData)).append("\n");
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
