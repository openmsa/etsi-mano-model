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
package com.ubiqube.etsi.mano.nfvo.v451.model.nslcm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type specifies additional parameters on a per-nested NS instance basis.
 * It shall comply with the provisions defined in Table 6.5.3.21a-1. NOTE 1:
 * This attribute allows for a nested NS at instantiation of the composite NS
 * the use of an NSD different from the one specified in the NSD of the
 * composite NS with \&quot;nsProfileId\&quot;, provided they have the same
 * \&quot;nsdExtInvariantId\&quot;. NOTE 2: A VnfProfile, NsProfile or
 * PnfProfile may contain multiple VersionDependencies as it may describe the
 * version dependencies of the descriptor referenced in the profile or of other
 * descriptors with the same external invariant identifier. NOTE 3: The
 * \&quot;overridingVersionDependency\&quot; attribute may only be present if
 * the \&quot;overridingNsdId\&quot; attribute is present.
 */
@Schema(description = "This type specifies additional parameters on a per-nested NS instance basis.  It shall comply with the provisions defined in Table 6.5.3.21a-1. NOTE 1:  This attribute allows for a nested NS at instantiation of the composite NS the use of an NSD different from the one specified in the NSD of the composite NS with \"nsProfileId\", provided they have the same \"nsdExtInvariantId\". NOTE 2: A VnfProfile, NsProfile or PnfProfile may contain multiple VersionDependencies as it may describe the version dependencies of the descriptor referenced in the profile or of other descriptors with the same external invariant identifier. NOTE 3:  The \"overridingVersionDependency\" attribute may only be present if the \"overridingNsdId\" attribute is present. ")
@Validated

public class ParamsForNestedNs {
	@JsonProperty("nsProfileId")
	private String nsProfileId = null;

	@JsonProperty("additionalParams")
	@Valid
	private List<Map<String, String>> additionalParams = null;

	@JsonProperty("overridingNsdId")
	private String overridingNsdId = null;

	@JsonProperty("overridingVersionDependency")
	private OverridingVersionDependency overridingVersionDependency = null;

	@JsonProperty("deployableModulesInConstituentVnf")
	@Valid
	private List<DeployableModulesInConstituentVnf> deployableModulesInConstituentVnf = null;

	public ParamsForNestedNs nsProfileId(final String nsProfileId) {
		this.nsProfileId = nsProfileId;
		return this;
	}

	/**
	 * Get nsProfileId
	 *
	 * @return nsProfileId
	 **/
	@Schema(required = true, description = "")
	@NotNull

	public String getNsProfileId() {
		return nsProfileId;
	}

	public void setNsProfileId(final String nsProfileId) {
		this.nsProfileId = nsProfileId;
	}

	public ParamsForNestedNs additionalParams(final List<Map<String, String>> additionalParams) {
		this.additionalParams = additionalParams;
		return this;
	}

	public ParamsForNestedNs addAdditionalParamsItem(final Map<String, String> additionalParamsItem) {
		if (this.additionalParams == null) {
			this.additionalParams = new ArrayList<>();
		}
		this.additionalParams.add(additionalParamsItem);
		return this;
	}

	/**
	 * Additional parameters that are to be applied on a per nested NS instance.
	 *
	 * @return additionalParams
	 **/
	@Schema(description = "Additional parameters that are to be applied on a per nested NS instance. ")
	@Valid
	public List<Map<String, String>> getAdditionalParams() {
		return additionalParams;
	}

	public void setAdditionalParams(final List<Map<String, String>> additionalParams) {
		this.additionalParams = additionalParams;
	}

	public ParamsForNestedNs overridingNsdId(final String overridingNsdId) {
		this.overridingNsdId = overridingNsdId;
		return this;
	}

	/**
	 * Get overridingNsdId
	 *
	 * @return overridingNsdId
	 **/
	@Schema(description = "")

	public String getOverridingNsdId() {
		return overridingNsdId;
	}

	public void setOverridingNsdId(final String overridingNsdId) {
		this.overridingNsdId = overridingNsdId;
	}

	public ParamsForNestedNs overridingVersionDependency(final OverridingVersionDependency overridingVersionDependency) {
		this.overridingVersionDependency = overridingVersionDependency;
		return this;
	}

	/**
	 * Get overridingVersionDependency
	 *
	 * @return overridingVersionDependency
	 **/
	@Schema(description = "")

	@Valid
	public OverridingVersionDependency getOverridingVersionDependency() {
		return overridingVersionDependency;
	}

	public void setOverridingVersionDependency(final OverridingVersionDependency overridingVersionDependency) {
		this.overridingVersionDependency = overridingVersionDependency;
	}

	public ParamsForNestedNs deployableModulesInConstituentVnf(final List<DeployableModulesInConstituentVnf> deployableModulesInConstituentVnf) {
		this.deployableModulesInConstituentVnf = deployableModulesInConstituentVnf;
		return this;
	}

	public ParamsForNestedNs addDeployableModulesInConstituentVnfItem(final DeployableModulesInConstituentVnf deployableModulesInConstituentVnfItem) {
		if (this.deployableModulesInConstituentVnf == null) {
			this.deployableModulesInConstituentVnf = new ArrayList<>();
		}
		this.deployableModulesInConstituentVnf.add(deployableModulesInConstituentVnfItem);
		return this;
	}

	/**
	 * Indicates the selected deployable modules of a VNF instance which is a
	 * constituent of the NS instance
	 *
	 * @return deployableModulesInConstituentVnf
	 **/
	@Schema(description = "Indicates the selected deployable modules of a VNF instance which is a constituent of the NS instance ")
	@Valid
	public List<DeployableModulesInConstituentVnf> getDeployableModulesInConstituentVnf() {
		return deployableModulesInConstituentVnf;
	}

	public void setDeployableModulesInConstituentVnf(final List<DeployableModulesInConstituentVnf> deployableModulesInConstituentVnf) {
		this.deployableModulesInConstituentVnf = deployableModulesInConstituentVnf;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final ParamsForNestedNs paramsForNestedNs = (ParamsForNestedNs) o;
		return Objects.equals(this.nsProfileId, paramsForNestedNs.nsProfileId) &&
				Objects.equals(this.additionalParams, paramsForNestedNs.additionalParams) &&
				Objects.equals(this.overridingNsdId, paramsForNestedNs.overridingNsdId) &&
				Objects.equals(this.overridingVersionDependency, paramsForNestedNs.overridingVersionDependency) &&
				Objects.equals(this.deployableModulesInConstituentVnf, paramsForNestedNs.deployableModulesInConstituentVnf);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nsProfileId, additionalParams, overridingNsdId, overridingVersionDependency, deployableModulesInConstituentVnf);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class ParamsForNestedNs {\n");

		sb.append("    nsProfileId: ").append(toIndentedString(nsProfileId)).append("\n");
		sb.append("    additionalParams: ").append(toIndentedString(additionalParams)).append("\n");
		sb.append("    overridingNsdId: ").append(toIndentedString(overridingNsdId)).append("\n");
		sb.append("    overridingVersionDependency: ").append(toIndentedString(overridingVersionDependency)).append("\n");
		sb.append("    deployableModulesInConstituentVnf: ").append(toIndentedString(deployableModulesInConstituentVnf)).append("\n");
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
