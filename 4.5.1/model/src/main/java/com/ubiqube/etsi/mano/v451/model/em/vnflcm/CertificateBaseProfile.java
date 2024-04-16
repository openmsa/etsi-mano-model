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
package com.ubiqube.etsi.mano.v451.model.em.vnflcm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v451.model.em.vnfconfig.CertSubjectData;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type provides input information to override certificate base profile for
 * certificate management NOTE : At least one overriding attributes shall be
 * present, otherwise shall be absent.
 */
@Schema(description = "This type provides input information to override certificate base profile for certificate management NOTE : At least one overriding attributes shall be present, otherwise shall be absent. ")
@Validated

public class CertificateBaseProfile {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("issuer")
	private String issuer = null;

	@JsonProperty("issuerUniqueIdentifier")
	private String issuerUniqueIdentifier = null;

	@JsonProperty("subject")
	private CertSubjectData subject = null;

	@JsonProperty("subjectUniqueIdentifier")
	private String subjectUniqueIdentifier = null;

	@JsonProperty("basicConstraints")
	private String basicConstraints = null;

	@JsonProperty("issuerAltName")
	@Valid
	private List<String> issuerAltName = null;

	@JsonProperty("subjectAltName")
	@Valid
	private List<String> subjectAltName = null;

	@JsonProperty("nameConstraints")
	@Valid
	private List<String> nameConstraints = null;

	public CertificateBaseProfile id(final String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 *
	 * @return id
	 **/
	@Schema(required = true, description = "")
	@NotNull

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public CertificateBaseProfile issuer(final String issuer) {
		this.issuer = issuer;
		return this;
	}

	/**
	 * Issuer of certificates. See note.
	 *
	 * @return issuer
	 **/
	@Schema(description = "Issuer of certificates. See note.")

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(final String issuer) {
		this.issuer = issuer;
	}

	public CertificateBaseProfile issuerUniqueIdentifier(final String issuerUniqueIdentifier) {
		this.issuerUniqueIdentifier = issuerUniqueIdentifier;
		return this;
	}

	/**
	 * Get issuerUniqueIdentifier
	 *
	 * @return issuerUniqueIdentifier
	 **/
	@Schema(description = "")

	public String getIssuerUniqueIdentifier() {
		return issuerUniqueIdentifier;
	}

	public void setIssuerUniqueIdentifier(final String issuerUniqueIdentifier) {
		this.issuerUniqueIdentifier = issuerUniqueIdentifier;
	}

	public CertificateBaseProfile subject(final CertSubjectData subject) {
		this.subject = subject;
		return this;
	}

	/**
	 * Get subject
	 *
	 * @return subject
	 **/
	@Schema(description = "")

	@Valid
	public CertSubjectData getSubject() {
		return subject;
	}

	public void setSubject(final CertSubjectData subject) {
		this.subject = subject;
	}

	public CertificateBaseProfile subjectUniqueIdentifier(final String subjectUniqueIdentifier) {
		this.subjectUniqueIdentifier = subjectUniqueIdentifier;
		return this;
	}

	/**
	 * Get subjectUniqueIdentifier
	 *
	 * @return subjectUniqueIdentifier
	 **/
	@Schema(description = "")

	public String getSubjectUniqueIdentifier() {
		return subjectUniqueIdentifier;
	}

	public void setSubjectUniqueIdentifier(final String subjectUniqueIdentifier) {
		this.subjectUniqueIdentifier = subjectUniqueIdentifier;
	}

	public CertificateBaseProfile basicConstraints(final String basicConstraints) {
		this.basicConstraints = basicConstraints;
		return this;
	}

	/**
	 * Basic constraints of certificates. See note.
	 *
	 * @return basicConstraints
	 **/
	@Schema(description = "Basic constraints of certificates. See note. ")

	public String getBasicConstraints() {
		return basicConstraints;
	}

	public void setBasicConstraints(final String basicConstraints) {
		this.basicConstraints = basicConstraints;
	}

	public CertificateBaseProfile issuerAltName(final List<String> issuerAltName) {
		this.issuerAltName = issuerAltName;
		return this;
	}

	public CertificateBaseProfile addIssuerAltNameItem(final String issuerAltNameItem) {
		if (this.issuerAltName == null) {
			this.issuerAltName = new ArrayList<>();
		}
		this.issuerAltName.add(issuerAltNameItem);
		return this;
	}

	/**
	 * Alternative name of issuer of certificates in this NS. See note.
	 *
	 * @return issuerAltName
	 **/
	@Schema(description = "Alternative name of issuer of certificates in this NS. See note.")

	public List<String> getIssuerAltName() {
		return issuerAltName;
	}

	public void setIssuerAltName(final List<String> issuerAltName) {
		this.issuerAltName = issuerAltName;
	}

	public CertificateBaseProfile subjectAltName(final List<String> subjectAltName) {
		this.subjectAltName = subjectAltName;
		return this;
	}

	public CertificateBaseProfile addSubjectAltNameItem(final String subjectAltNameItem) {
		if (this.subjectAltName == null) {
			this.subjectAltName = new ArrayList<>();
		}
		this.subjectAltName.add(subjectAltNameItem);
		return this;
	}

	/**
	 * Alternative name of subject of certificates. Shall be present when this
	 * certificate is used for encrypted communication using IP address and
	 * subjectAltName attribute of CertificateBaseProfile in CertificateDesc of VNFD
	 * is empty (see ETSI GS NFV-IFA 011 [7],clause 7.1.19.4). See note
	 *
	 * @return subjectAltName
	 **/
	@Schema(description = "Alternative name of subject of certificates. Shall be present when this certificate is used for encrypted communication using IP address and subjectAltName attribute of CertificateBaseProfile in CertificateDesc of VNFD is empty (see ETSI GS NFV-IFA 011 [7],clause 7.1.19.4). See note")

	public List<String> getSubjectAltName() {
		return subjectAltName;
	}

	public void setSubjectAltName(final List<String> subjectAltName) {
		this.subjectAltName = subjectAltName;
	}

	public CertificateBaseProfile nameConstraints(final List<String> nameConstraints) {
		this.nameConstraints = nameConstraints;
		return this;
	}

	public CertificateBaseProfile addNameConstraintsItem(final String nameConstraintsItem) {
		if (this.nameConstraints == null) {
			this.nameConstraints = new ArrayList<>();
		}
		this.nameConstraints.add(nameConstraintsItem);
		return this;
	}

	/**
	 * Name constraints of certificates. See note.
	 *
	 * @return nameConstraints
	 **/
	@Schema(description = "Name constraints of certificates. See note.")

	public List<String> getNameConstraints() {
		return nameConstraints;
	}

	public void setNameConstraints(final List<String> nameConstraints) {
		this.nameConstraints = nameConstraints;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final CertificateBaseProfile certificateBaseProfile = (CertificateBaseProfile) o;
		return Objects.equals(this.id, certificateBaseProfile.id) &&
				Objects.equals(this.issuer, certificateBaseProfile.issuer) &&
				Objects.equals(this.issuerUniqueIdentifier, certificateBaseProfile.issuerUniqueIdentifier) &&
				Objects.equals(this.subject, certificateBaseProfile.subject) &&
				Objects.equals(this.subjectUniqueIdentifier, certificateBaseProfile.subjectUniqueIdentifier) &&
				Objects.equals(this.basicConstraints, certificateBaseProfile.basicConstraints) &&
				Objects.equals(this.issuerAltName, certificateBaseProfile.issuerAltName) &&
				Objects.equals(this.subjectAltName, certificateBaseProfile.subjectAltName) &&
				Objects.equals(this.nameConstraints, certificateBaseProfile.nameConstraints);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, issuer, issuerUniqueIdentifier, subject, subjectUniqueIdentifier, basicConstraints, issuerAltName, subjectAltName, nameConstraints);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class CertificateBaseProfile {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    issuer: ").append(toIndentedString(issuer)).append("\n");
		sb.append("    issuerUniqueIdentifier: ").append(toIndentedString(issuerUniqueIdentifier)).append("\n");
		sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
		sb.append("    subjectUniqueIdentifier: ").append(toIndentedString(subjectUniqueIdentifier)).append("\n");
		sb.append("    basicConstraints: ").append(toIndentedString(basicConstraints)).append("\n");
		sb.append("    issuerAltName: ").append(toIndentedString(issuerAltName)).append("\n");
		sb.append("    subjectAltName: ").append(toIndentedString(subjectAltName)).append("\n");
		sb.append("    nameConstraints: ").append(toIndentedString(nameConstraints)).append("\n");
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
