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
package com.ubiqube.etsi.mano.v261.model.nfvo.nsd.sol005;

import java.util.Map;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.model.ProblemDetails;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.annotation.Nonnull;
import jakarta.validation.Valid;

/**
 * This type represents a response for the query PNFD operation.
 */
@Schema(description = "This type represents a response for the query PNFD operation. ")
@Validated

public class PnfdInfo {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("pnfdId")
	private String pnfdId = null;

	@JsonProperty("pnfdName")
	private String pnfdName = null;

	@JsonProperty("pnfdersion")
	private String pnfdVersion = null;

	@JsonProperty("pnfdProvider")
	private String pnfdProvider = null;

	@JsonProperty("pnfdInvariantId")
	private String pnfdInvariantId = null;

	@JsonProperty("pnfdOnboardingState")
	private PnfdOnboardingStateType pnfdOnboardingState = null;

	@JsonProperty("onboardingFailureDetails")
	private ProblemDetails onboardingFailureDetails = null;

	@JsonProperty("pnfdUsageState")
	private PnfdUsageStateType pnfdUsageState = null;

	@JsonProperty("userDefinedData")
	private Map<String, String> userDefinedData = null;

	@JsonProperty("_links")
	private PnfdInfoLinks links = null;

	public PnfdInfo id(final String id) {
		this.id = id;
		return this;
	}

	/**
	 * Identifier of the on-boarded individual PNF descriptor resource. This
	 * identifier is allocated by the NFVO.
	 *
	 * @return id
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifier of the on-boarded individual PNF descriptor resource. This identifier is allocated by the NFVO. ")
	@Nonnull

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public PnfdInfo pnfdId(final String pnfdId) {
		this.pnfdId = pnfdId;
		return this;
	}

	/**
	 * This identifier, which is managed by the PNFD designer, identifies the PNFD
	 * in a globally unique way. It is copied from the PNFD content and shall be
	 * present after the PNFD content is on-boarded.
	 *
	 * @return pnfdId
	 **/
	@Schema(description = "This identifier, which is managed by the PNFD designer, identifies the PNFD in a globally unique way. It is copied from the PNFD content and shall be present after the PNFD content is on-boarded. ")

	public String getPnfdId() {
		return pnfdId;
	}

	public void setPnfdId(final String pnfdId) {
		this.pnfdId = pnfdId;
	}

	public PnfdInfo pnfdName(final String pnfdName) {
		this.pnfdName = pnfdName;
		return this;
	}

	/**
	 * Name of the on-boarded PNFD. This information is copied from the PNFD content
	 * and shall be present after the PNFD content is on-boarded.
	 *
	 * @return pnfdName
	 **/
	@Schema(description = "Name of the on-boarded PNFD. This information is copied from the PNFD content and shall be present after the PNFD content is on-boarded. ")

	public String getPnfdName() {
		return pnfdName;
	}

	public void setPnfdName(final String pnfdName) {
		this.pnfdName = pnfdName;
	}

	public PnfdInfo pnfdVersion(final String pnfdersion) {
		this.pnfdVersion = pnfdersion;
		return this;
	}

	/**
	 * Get pnfdersion
	 *
	 * @return pnfdersion
	 **/
	@Schema(description = "")

	public String getPnfdVersion() {
		return pnfdVersion;
	}

	public void setPnfdVersion(final String pnfdersion) {
		this.pnfdVersion = pnfdersion;
	}

	public PnfdInfo pnfdProvider(final String pnfdProvider) {
		this.pnfdProvider = pnfdProvider;
		return this;
	}

	/**
	 * Provider of the on-boarded PNFD. This information is copied from the PNFD
	 * content and shall be present after the PNFD content is on-boarded.
	 *
	 * @return pnfdProvider
	 **/
	@Schema(description = "Provider of the on-boarded PNFD. This information is copied from the PNFD content and shall be present after the PNFD content is on-boarded. ")

	public String getPnfdProvider() {
		return pnfdProvider;
	}

	public void setPnfdProvider(final String pnfdProvider) {
		this.pnfdProvider = pnfdProvider;
	}

	public PnfdInfo pnfdInvariantId(final String pnfdInvariantId) {
		this.pnfdInvariantId = pnfdInvariantId;
		return this;
	}

	/**
	 * Identifies a PNFD in a version independent manner. This attribute is
	 * invariant across versions of PNFD.
	 *
	 * @return pnfdInvariantId
	 **/
	@Schema(description = "Identifies a PNFD in a version independent manner. This attribute is invariant across versions of PNFD. ")

	public String getPnfdInvariantId() {
		return pnfdInvariantId;
	}

	public void setPnfdInvariantId(final String pnfdInvariantId) {
		this.pnfdInvariantId = pnfdInvariantId;
	}

	public PnfdInfo pnfdOnboardingState(final PnfdOnboardingStateType pnfdOnboardingState) {
		this.pnfdOnboardingState = pnfdOnboardingState;
		return this;
	}

	/**
	 * On-boarding state of the individual PNF descriptor resource.
	 *
	 * @return pnfdOnboardingState
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "On-boarding state of the individual PNF descriptor resource. ")
	@Nonnull

	@Valid

	public PnfdOnboardingStateType getPnfdOnboardingState() {
		return pnfdOnboardingState;
	}

	public void setPnfdOnboardingState(final PnfdOnboardingStateType pnfdOnboardingState) {
		this.pnfdOnboardingState = pnfdOnboardingState;
	}

	public PnfdInfo onboardingFailureDetails(final ProblemDetails onboardingFailureDetails) {
		this.onboardingFailureDetails = onboardingFailureDetails;
		return this;
	}

	/**
	 * Failure details of current on-boarding procedure. See clause 6.3 of ETSI GS
	 * NFV-SOL 013 for the details of \"ProblemDetails\" structure. It shall be
	 * present when the pnfdOnboardingState attribute is CREATED and the uploading
	 * or processing fails in the NFVO.
	 *
	 * @return onboardingFailureDetails
	 **/
	@Schema(description = "Failure details of current on-boarding procedure. See clause 6.3 of ETSI GS NFV-SOL 013 for the details of \"ProblemDetails\" structure. It shall be present when the pnfdOnboardingState attribute is CREATED and the uploading or processing fails in the NFVO. ")

	@Valid

	public ProblemDetails getOnboardingFailureDetails() {
		return onboardingFailureDetails;
	}

	public void setOnboardingFailureDetails(final ProblemDetails onboardingFailureDetails) {
		this.onboardingFailureDetails = onboardingFailureDetails;
	}

	public PnfdInfo pnfdUsageState(final PnfdUsageStateType pnfdUsageState) {
		this.pnfdUsageState = pnfdUsageState;
		return this;
	}

	/**
	 * Usage state of the individual PNF descriptor resource.
	 *
	 * @return pnfdUsageState
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Usage state of the individual PNF descriptor resource. ")
	@Nonnull

	@Valid

	public PnfdUsageStateType getPnfdUsageState() {
		return pnfdUsageState;
	}

	public void setPnfdUsageState(final PnfdUsageStateType pnfdUsageState) {
		this.pnfdUsageState = pnfdUsageState;
	}

	public PnfdInfo userDefinedData(final Map<String, String> userDefinedData) {
		this.userDefinedData = userDefinedData;
		return this;
	}

	/**
	 * User defined data for the individual PNF descriptor resource. This attribute
	 * can be modified with the PATCH method.
	 *
	 * @return userDefinedData
	 **/
	@Schema(description = "User defined data for the individual PNF descriptor resource. This attribute can be modified with the PATCH method. ")

	@Valid

	public Map<String, String> getUserDefinedData() {
		return userDefinedData;
	}

	public void setUserDefinedData(final Map<String, String> userDefinedData) {
		this.userDefinedData = userDefinedData;
	}

	public PnfdInfo links(final PnfdInfoLinks links) {
		this.links = links;
		return this;
	}

	/**
	 * Get links
	 *
	 * @return links
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@Nonnull

	@Valid

	public PnfdInfoLinks getLinks() {
		return links;
	}

	public void setLinks(final PnfdInfoLinks links) {
		this.links = links;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final PnfdInfo pnfdInfo = (PnfdInfo) o;
		return Objects.equals(this.id, pnfdInfo.id) &&
				Objects.equals(this.pnfdId, pnfdInfo.pnfdId) &&
				Objects.equals(this.pnfdName, pnfdInfo.pnfdName) &&
				Objects.equals(this.pnfdVersion, pnfdInfo.pnfdVersion) &&
				Objects.equals(this.pnfdProvider, pnfdInfo.pnfdProvider) &&
				Objects.equals(this.pnfdInvariantId, pnfdInfo.pnfdInvariantId) &&
				Objects.equals(this.pnfdOnboardingState, pnfdInfo.pnfdOnboardingState) &&
				Objects.equals(this.onboardingFailureDetails, pnfdInfo.onboardingFailureDetails) &&
				Objects.equals(this.pnfdUsageState, pnfdInfo.pnfdUsageState) &&
				Objects.equals(this.userDefinedData, pnfdInfo.userDefinedData) &&
				Objects.equals(this.links, pnfdInfo.links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, pnfdId, pnfdName, pnfdVersion, pnfdProvider, pnfdInvariantId, pnfdOnboardingState, onboardingFailureDetails, pnfdUsageState, userDefinedData, links);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class PnfdInfo {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    pnfdId: ").append(toIndentedString(pnfdId)).append("\n");
		sb.append("    pnfdName: ").append(toIndentedString(pnfdName)).append("\n");
		sb.append("    pnfdersion: ").append(toIndentedString(pnfdVersion)).append("\n");
		sb.append("    pnfdProvider: ").append(toIndentedString(pnfdProvider)).append("\n");
		sb.append("    pnfdInvariantId: ").append(toIndentedString(pnfdInvariantId)).append("\n");
		sb.append("    pnfdOnboardingState: ").append(toIndentedString(pnfdOnboardingState)).append("\n");
		sb.append("    onboardingFailureDetails: ").append(toIndentedString(onboardingFailureDetails)).append("\n");
		sb.append("    pnfdUsageState: ").append(toIndentedString(pnfdUsageState)).append("\n");
		sb.append("    userDefinedData: ").append(toIndentedString(userDefinedData)).append("\n");
		sb.append("    links: ").append(toIndentedString(links)).append("\n");
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
