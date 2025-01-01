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
import jakarta.validation.constraints.NotNull;

/**
 * This type provides input information related to certificate management.
 */
@Schema(description = "This type provides input information related to certificate management. ")
@Validated

public class CertificateConfigurationInfo {
	@JsonProperty("certificateBaseProfile")
	private CertificateBaseProfile certificateBaseProfile = null;

	@JsonProperty("securityPolicy")
	@Valid
	private List<SecurityPolicy> securityPolicy = new ArrayList<>();

	@JsonProperty("delegationSupportedCertificateManagements")
	private Map<String, String> delegationSupportedCertificateManagements = null;

	@JsonProperty("cmfInfo")
	private CmfInfo cmfInfo = null;

	public CertificateConfigurationInfo certificateBaseProfile(final CertificateBaseProfile certificateBaseProfile) {
		this.certificateBaseProfile = certificateBaseProfile;
		return this;
	}

	/**
	 * Get certificateBaseProfile
	 *
	 * @return certificateBaseProfile
	 **/
	@Schema(description = "")

	@Valid
	public CertificateBaseProfile getCertificateBaseProfile() {
		return certificateBaseProfile;
	}

	public void setCertificateBaseProfile(final CertificateBaseProfile certificateBaseProfile) {
		this.certificateBaseProfile = certificateBaseProfile;
	}

	public CertificateConfigurationInfo securityPolicy(final List<SecurityPolicy> securityPolicy) {
		this.securityPolicy = securityPolicy;
		return this;
	}

	public CertificateConfigurationInfo addSecurityPolicyItem(final SecurityPolicy securityPolicyItem) {
		this.securityPolicy.add(securityPolicyItem);
		return this;
	}

	/**
	 * Information for security policy to be satisfied for certificate.
	 *
	 * @return securityPolicy
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Information for security policy to be satisfied for certificate. ")
	@NotNull
	@Valid
	public List<SecurityPolicy> getSecurityPolicy() {
		return securityPolicy;
	}

	public void setSecurityPolicy(final List<SecurityPolicy> securityPolicy) {
		this.securityPolicy = securityPolicy;
	}

	public CertificateConfigurationInfo delegationSupportedCertificateManagements(final Map<String, String> delegationSupportedCertificateManagements) {
		this.delegationSupportedCertificateManagements = delegationSupportedCertificateManagements;
		return this;
	}

	/**
	 * Get delegationSupportedCertificateManagements
	 *
	 * @return delegationSupportedCertificateManagements
	 **/
	@Schema(description = "")

	@Valid
	public Map<String, String> getDelegationSupportedCertificateManagements() {
		return delegationSupportedCertificateManagements;
	}

	public void setDelegationSupportedCertificateManagements(final Map<String, String> delegationSupportedCertificateManagements) {
		this.delegationSupportedCertificateManagements = delegationSupportedCertificateManagements;
	}

	public CertificateConfigurationInfo cmfInfo(final CmfInfo cmfInfo) {
		this.cmfInfo = cmfInfo;
		return this;
	}

	/**
	 * Get cmfInfo
	 *
	 * @return cmfInfo
	 **/
	@Schema(description = "")

	@Valid
	public CmfInfo getCmfInfo() {
		return cmfInfo;
	}

	public void setCmfInfo(final CmfInfo cmfInfo) {
		this.cmfInfo = cmfInfo;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final CertificateConfigurationInfo certificateConfigurationInfo = (CertificateConfigurationInfo) o;
		return Objects.equals(this.certificateBaseProfile, certificateConfigurationInfo.certificateBaseProfile) &&
				Objects.equals(this.securityPolicy, certificateConfigurationInfo.securityPolicy) &&
				Objects.equals(this.delegationSupportedCertificateManagements, certificateConfigurationInfo.delegationSupportedCertificateManagements) &&
				Objects.equals(this.cmfInfo, certificateConfigurationInfo.cmfInfo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(certificateBaseProfile, securityPolicy, delegationSupportedCertificateManagements, cmfInfo);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class CertificateConfigurationInfo {\n");

		sb.append("    certificateBaseProfile: ").append(toIndentedString(certificateBaseProfile)).append("\n");
		sb.append("    securityPolicy: ").append(toIndentedString(securityPolicy)).append("\n");
		sb.append("    delegationSupportedCertificateManagements: ").append(toIndentedString(delegationSupportedCertificateManagements)).append("\n");
		sb.append("    cmfInfo: ").append(toIndentedString(cmfInfo)).append("\n");
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
