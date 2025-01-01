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
package com.ubiqube.etsi.mano.v451.model.em.vnflcm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;

/**
 * This type represents request parameters for the \&quot;Scale VNF to
 * Level\&quot; operation. NOTE 1: Either the instantiationLevelId attribute or
 * the scaleInfo attribute shall be included. NOTE 2: If the referenced
 * instantiationLevel or the scaleInfo attribute contain information related to
 * VNFCs that are not going to be instantiated due to the selection of
 * deployable modules, the information is stored in the VNFM for later use and
 * included in the instantiatedVnfInfo. If, during the lifecycle of the VNF, as
 * a result of a change of the selected deployable modules any of those VNFCs is
 * going to be instantiated, the stored information determines the number of
 * instances, unless the request that triggered the change also contains
 * information about the number of instances.
 */
@Schema(description = "This type represents request parameters for the \"Scale VNF to Level\" operation. NOTE 1: Either the instantiationLevelId attribute or the scaleInfo attribute shall        be included. NOTE 2: If the referenced instantiationLevel or the scaleInfo attribute contain information related to VNFCs that are not         going to be instantiated due to the selection of deployable modules, the information is stored in the VNFM for         later use and included in the instantiatedVnfInfo. If, during the lifecycle of the VNF, as a result of a change of         the selected deployable modules any of those VNFCs is going to be instantiated, the stored information         determines the number of instances, unless the request that triggered the change also contains information         about the number of instances. ")
@Validated

public class ScaleVnfToLevelRequest implements AnyOfScaleVnfToLevelRequest {
	@JsonProperty("instantiationLevelId")
	private String instantiationLevelId = null;

	@JsonProperty("scaleInfo")
	@Valid
	private List<ScaleInfo> scaleInfo = null;

	@JsonProperty("additionalParams")
	private Map<String, String> additionalParams = null;

	public ScaleVnfToLevelRequest instantiationLevelId(final String instantiationLevelId) {
		this.instantiationLevelId = instantiationLevelId;
		return this;
	}

	/**
	 * Get instantiationLevelId
	 *
	 * @return instantiationLevelId
	 **/
	@Schema(description = "")

	public String getInstantiationLevelId() {
		return instantiationLevelId;
	}

	public void setInstantiationLevelId(final String instantiationLevelId) {
		this.instantiationLevelId = instantiationLevelId;
	}

	public ScaleVnfToLevelRequest scaleInfo(final List<ScaleInfo> scaleInfo) {
		this.scaleInfo = scaleInfo;
		return this;
	}

	public ScaleVnfToLevelRequest addScaleInfoItem(final ScaleInfo scaleInfoItem) {
		if (this.scaleInfo == null) {
			this.scaleInfo = new ArrayList<>();
		}
		this.scaleInfo.add(scaleInfoItem);
		return this;
	}

	/**
	 * For each scaling aspect of the current deployment flavour, indicates the
	 * target scale level to which the VNF is to be scaled. See notes 1 and 2.
	 *
	 * @return scaleInfo
	 **/
	@Schema(description = "For each scaling aspect of the current deployment flavour, indicates the target scale level to which the VNF is to be scaled. See notes 1 and 2. ")
	@Valid
	public List<ScaleInfo> getScaleInfo() {
		return scaleInfo;
	}

	public void setScaleInfo(final List<ScaleInfo> scaleInfo) {
		this.scaleInfo = scaleInfo;
	}

	public ScaleVnfToLevelRequest additionalParams(final Map<String, String> additionalParams) {
		this.additionalParams = additionalParams;
		return this;
	}

	/**
	 * Get additionalParams
	 *
	 * @return additionalParams
	 **/
	@Schema(description = "")

	@Valid
	public Map<String, String> getAdditionalParams() {
		return additionalParams;
	}

	public void setAdditionalParams(final Map<String, String> additionalParams) {
		this.additionalParams = additionalParams;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final ScaleVnfToLevelRequest scaleVnfToLevelRequest = (ScaleVnfToLevelRequest) o;
		return Objects.equals(this.instantiationLevelId, scaleVnfToLevelRequest.instantiationLevelId) &&
				Objects.equals(this.scaleInfo, scaleVnfToLevelRequest.scaleInfo) &&
				Objects.equals(this.additionalParams, scaleVnfToLevelRequest.additionalParams);
	}

	@Override
	public int hashCode() {
		return Objects.hash(instantiationLevelId, scaleInfo, additionalParams);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class ScaleVnfToLevelRequest {\n");

		sb.append("    instantiationLevelId: ").append(toIndentedString(instantiationLevelId)).append("\n");
		sb.append("    scaleInfo: ").append(toIndentedString(scaleInfo)).append("\n");
		sb.append("    additionalParams: ").append(toIndentedString(additionalParams)).append("\n");
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
