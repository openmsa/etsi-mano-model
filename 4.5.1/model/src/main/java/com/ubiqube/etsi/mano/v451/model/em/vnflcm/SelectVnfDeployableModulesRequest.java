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
 * This type represents request parameters for the \&quot;Select VNF deployable
 * modules\&quot; operation. * NOTE: Thus, the select VNF deployable modules
 * operation cannot be used as a scale VNF operation to scale VNFCs that were
 * already instantiated
 */
@Schema(description = "This type represents request parameters for the \"Select VNF deployable modules\" operation. * NOTE: Thus, the select VNF deployable modules operation cannot be used as a scale VNF operation to scale VNFCs          that were already instantiated ")
@Validated

public class SelectVnfDeployableModulesRequest {
	@JsonProperty("selectedDeployableModule")
	@Valid
	private List<String> selectedDeployableModule = null;

	@JsonProperty("targetScaleLevelInfo")
	@Valid
	private List<ScaleInfo> targetScaleLevelInfo = null;

	@JsonProperty("additionalParams")
	private Map<String, String> additionalParams = null;

	public SelectVnfDeployableModulesRequest selectedDeployableModule(final List<String> selectedDeployableModule) {
		this.selectedDeployableModule = selectedDeployableModule;
		return this;
	}

	public SelectVnfDeployableModulesRequest addSelectedDeployableModuleItem(final String selectedDeployableModuleItem) {
		if (this.selectedDeployableModule == null) {
			this.selectedDeployableModule = new ArrayList<>();
		}
		this.selectedDeployableModule.add(selectedDeployableModuleItem);
		return this;
	}

	/**
	 * Identifier of a selected deployable module, as defined in the VNFD. VNFCs
	 * based on VDUs that belong to deployable modules listed in this attribute will
	 * be instantiated if not already instantiated. VNFCs based on VDUs that belong
	 * to deployable modules not listed in this attribute and that were already
	 * instantiated will be terminated.
	 *
	 * @return selectedDeployableModule
	 **/
	@Schema(description = "Identifier of a selected deployable module, as defined in the VNFD. VNFCs based on VDUs that belong to  deployable modules listed in this attribute will be instantiated if not already instantiated. VNFCs based on  VDUs that belong to deployable modules not listed in this attribute and that were already instantiated will be  terminated. ")

	public List<String> getSelectedDeployableModule() {
		return selectedDeployableModule;
	}

	public void setSelectedDeployableModule(final List<String> selectedDeployableModule) {
		this.selectedDeployableModule = selectedDeployableModule;
	}

	public SelectVnfDeployableModulesRequest targetScaleLevelInfo(final List<ScaleInfo> targetScaleLevelInfo) {
		this.targetScaleLevelInfo = targetScaleLevelInfo;
		return this;
	}

	public SelectVnfDeployableModulesRequest addTargetScaleLevelInfoItem(final ScaleInfo targetScaleLevelInfoItem) {
		if (this.targetScaleLevelInfo == null) {
			this.targetScaleLevelInfo = new ArrayList<>();
		}
		this.targetScaleLevelInfo.add(targetScaleLevelInfoItem);
		return this;
	}

	/**
	 * Defines the target scale levels of scaling aspects of the VDUs that belong to
	 * selected deployable modules. If this attribute is not present or if there are
	 * VDUs that belong to selected deployable modules that take no part in any of
	 * the scaling aspects indicated in this attribute, the VNFCs based on those
	 * VDUs shall be instantiated according to the currently valid VNF scale level
	 * or instantiation level. This attribute should only contain scale level
	 * information of scaling aspects associated to VDUs that will be used to
	 * instantiate VNFCs as a result of this operation. If it contains other scale
	 * level information it shall be ignored. See note. The VNF Provider defines in
	 * the VNFD whether or not a particular VNF supports scaling according to this
	 * parameter. Such a property in the VNFD applies for all instances of a
	 * particular VNF.
	 *
	 * @return targetScaleLevelInfo
	 **/
	@Schema(description = "Defines the target scale levels of scaling aspects of the VDUs that belong to selected deployable modules. If this attribute is not present or if there are VDUs that belong to selected deployable modules that take no part  in any of the scaling aspects indicated in this attribute, the VNFCs based on those VDUs shall be instantiated  according to the currently valid VNF scale level or instantiation level.  This attribute should only contain scale level information of scaling aspects associated to VDUs that will be used  to instantiate VNFCs as a result of this operation. If it contains other scale level information it shall be ignored.  See note. The VNF Provider defines in the VNFD whether or not a particular VNF supports scaling according to this  parameter. Such a property in the VNFD applies for all instances of a particular VNF. ")
	@Valid
	public List<ScaleInfo> getTargetScaleLevelInfo() {
		return targetScaleLevelInfo;
	}

	public void setTargetScaleLevelInfo(final List<ScaleInfo> targetScaleLevelInfo) {
		this.targetScaleLevelInfo = targetScaleLevelInfo;
	}

	public SelectVnfDeployableModulesRequest additionalParams(final Map<String, String> additionalParams) {
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
		final SelectVnfDeployableModulesRequest selectVnfDeployableModulesRequest = (SelectVnfDeployableModulesRequest) o;
		return Objects.equals(this.selectedDeployableModule, selectVnfDeployableModulesRequest.selectedDeployableModule) &&
				Objects.equals(this.targetScaleLevelInfo, selectVnfDeployableModulesRequest.targetScaleLevelInfo) &&
				Objects.equals(this.additionalParams, selectVnfDeployableModulesRequest.additionalParams);
	}

	@Override
	public int hashCode() {
		return Objects.hash(selectedDeployableModule, targetScaleLevelInfo, additionalParams);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class SelectVnfDeployableModulesRequest {\n");

		sb.append("    selectedDeployableModule: ").append(toIndentedString(selectedDeployableModule)).append("\n");
		sb.append("    targetScaleLevelInfo: ").append(toIndentedString(targetScaleLevelInfo)).append("\n");
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
