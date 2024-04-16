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

import java.time.OffsetDateTime;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type provides input information related to certificate content.
 */
@Schema(description = "This type provides input information related to certificate content. ")
@Validated

public class CertificateContent {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("certficateDescId")
	private String certficateDescId = null;

	/**
	 * Type of this certificate.
	 */
	public enum CertificateTypeEnum {
		VNFCI_CERT("VNFCI_CERT"),

		VNFOAM_CERT("VNFOAM_CERT");

		private final String value;

		CertificateTypeEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static CertificateTypeEnum fromValue(final String text) {
			for (final CertificateTypeEnum b : CertificateTypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("certificateType")
	private CertificateTypeEnum certificateType = null;

	@JsonProperty("supportedCertificateManagements")
	private Map<String, String> supportedCertificateManagements = null;

	@JsonProperty("version")
	private String version = null;

	@JsonProperty("serialNumber")
	private Integer serialNumber = null;

	@JsonProperty("signatureAlgorithm")
	private String signatureAlgorithm = null;

	@JsonProperty("issuer")
	private String issuer = null;

	@JsonProperty("notBefore")
	private OffsetDateTime notBefore = null;

	@JsonProperty("notAfter")
	private OffsetDateTime notAfter = null;

	@JsonProperty("subject")
	private String subject = null;

	@JsonProperty("publicKeyAlgorithm")
	private String publicKeyAlgorithm = null;

	@JsonProperty("publicKey")
	private String publicKey = null;

	@JsonProperty("certificateExtensions")
	private Map<String, String> certificateExtensions = null;

	public CertificateContent id(final String id) {
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

	public CertificateContent certficateDescId(final String certficateDescId) {
		this.certficateDescId = certficateDescId;
		return this;
	}

	/**
	 * Get certficateDescId
	 *
	 * @return certficateDescId
	 **/
	@Schema(description = "")

	public String getCertficateDescId() {
		return certficateDescId;
	}

	public void setCertficateDescId(final String certficateDescId) {
		this.certficateDescId = certficateDescId;
	}

	public CertificateContent certificateType(final CertificateTypeEnum certificateType) {
		this.certificateType = certificateType;
		return this;
	}

	/**
	 * Type of this certificate.
	 *
	 * @return certificateType
	 **/
	@Schema(required = true, description = "Type of this certificate.")
	@NotNull

	public CertificateTypeEnum getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(final CertificateTypeEnum certificateType) {
		this.certificateType = certificateType;
	}

	public CertificateContent supportedCertificateManagements(final Map<String, String> supportedCertificateManagements) {
		this.supportedCertificateManagements = supportedCertificateManagements;
		return this;
	}

	/**
	 * Get supportedCertificateManagements
	 *
	 * @return supportedCertificateManagements
	 **/
	@Schema(description = "")

	@Valid
	public Map<String, String> getSupportedCertificateManagements() {
		return supportedCertificateManagements;
	}

	public void setSupportedCertificateManagements(final Map<String, String> supportedCertificateManagements) {
		this.supportedCertificateManagements = supportedCertificateManagements;
	}

	public CertificateContent version(final String version) {
		this.version = version;
		return this;
	}

	/**
	 * Get version
	 *
	 * @return version
	 **/
	@Schema(description = "")

	public String getVersion() {
		return version;
	}

	public void setVersion(final String version) {
		this.version = version;
	}

	public CertificateContent serialNumber(final Integer serialNumber) {
		this.serialNumber = serialNumber;
		return this;
	}

	/**
	 * Serial number of this certificate.
	 *
	 * @return serialNumber
	 **/
	@Schema(description = "Serial number of this certificate.")

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(final Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	public CertificateContent signatureAlgorithm(final String signatureAlgorithm) {
		this.signatureAlgorithm = signatureAlgorithm;
		return this;
	}

	/**
	 * Algorithm of this certificate's signature.
	 *
	 * @return signatureAlgorithm
	 **/
	@Schema(description = "Algorithm of this certificate's signature.")

	public String getSignatureAlgorithm() {
		return signatureAlgorithm;
	}

	public void setSignatureAlgorithm(final String signatureAlgorithm) {
		this.signatureAlgorithm = signatureAlgorithm;
	}

	public CertificateContent issuer(final String issuer) {
		this.issuer = issuer;
		return this;
	}

	/**
	 * Issuer of this certificate.
	 *
	 * @return issuer
	 **/
	@Schema(description = "Issuer of this certificate.")

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(final String issuer) {
		this.issuer = issuer;
	}

	public CertificateContent notBefore(final OffsetDateTime notBefore) {
		this.notBefore = notBefore;
		return this;
	}

	/**
	 * Get notBefore
	 *
	 * @return notBefore
	 **/
	@Schema(description = "")

	@Valid
	public OffsetDateTime getNotBefore() {
		return notBefore;
	}

	public void setNotBefore(final OffsetDateTime notBefore) {
		this.notBefore = notBefore;
	}

	public CertificateContent notAfter(final OffsetDateTime notAfter) {
		this.notAfter = notAfter;
		return this;
	}

	/**
	 * Get notAfter
	 *
	 * @return notAfter
	 **/
	@Schema(description = "")

	@Valid
	public OffsetDateTime getNotAfter() {
		return notAfter;
	}

	public void setNotAfter(final OffsetDateTime notAfter) {
		this.notAfter = notAfter;
	}

	public CertificateContent subject(final String subject) {
		this.subject = subject;
		return this;
	}

	/**
	 * Subject of this certificate.
	 *
	 * @return subject
	 **/
	@Schema(description = "Subject of this certificate.")

	public String getSubject() {
		return subject;
	}

	public void setSubject(final String subject) {
		this.subject = subject;
	}

	public CertificateContent publicKeyAlgorithm(final String publicKeyAlgorithm) {
		this.publicKeyAlgorithm = publicKeyAlgorithm;
		return this;
	}

	/**
	 * Algorithm of this certificate's public key.
	 *
	 * @return publicKeyAlgorithm
	 **/
	@Schema(description = "Algorithm of this certificate's public key.")

	public String getPublicKeyAlgorithm() {
		return publicKeyAlgorithm;
	}

	public void setPublicKeyAlgorithm(final String publicKeyAlgorithm) {
		this.publicKeyAlgorithm = publicKeyAlgorithm;
	}

	public CertificateContent publicKey(final String publicKey) {
		this.publicKey = publicKey;
		return this;
	}

	/**
	 * Public key of this certificate.
	 *
	 * @return publicKey
	 **/
	@Schema(description = "Public key of this certificate.")

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(final String publicKey) {
		this.publicKey = publicKey;
	}

	public CertificateContent certificateExtensions(final Map<String, String> certificateExtensions) {
		this.certificateExtensions = certificateExtensions;
		return this;
	}

	/**
	 * Get certificateExtensions
	 *
	 * @return certificateExtensions
	 **/
	@Schema(description = "")

	@Valid
	public Map<String, String> getCertificateExtensions() {
		return certificateExtensions;
	}

	public void setCertificateExtensions(final Map<String, String> certificateExtensions) {
		this.certificateExtensions = certificateExtensions;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final CertificateContent certificateContent = (CertificateContent) o;
		return Objects.equals(this.id, certificateContent.id) &&
				Objects.equals(this.certficateDescId, certificateContent.certficateDescId) &&
				Objects.equals(this.certificateType, certificateContent.certificateType) &&
				Objects.equals(this.supportedCertificateManagements, certificateContent.supportedCertificateManagements) &&
				Objects.equals(this.version, certificateContent.version) &&
				Objects.equals(this.serialNumber, certificateContent.serialNumber) &&
				Objects.equals(this.signatureAlgorithm, certificateContent.signatureAlgorithm) &&
				Objects.equals(this.issuer, certificateContent.issuer) &&
				Objects.equals(this.notBefore, certificateContent.notBefore) &&
				Objects.equals(this.notAfter, certificateContent.notAfter) &&
				Objects.equals(this.subject, certificateContent.subject) &&
				Objects.equals(this.publicKeyAlgorithm, certificateContent.publicKeyAlgorithm) &&
				Objects.equals(this.publicKey, certificateContent.publicKey) &&
				Objects.equals(this.certificateExtensions, certificateContent.certificateExtensions);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, certficateDescId, certificateType, supportedCertificateManagements, version, serialNumber, signatureAlgorithm, issuer, notBefore, notAfter, subject, publicKeyAlgorithm, publicKey, certificateExtensions);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class CertificateContent {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    certficateDescId: ").append(toIndentedString(certficateDescId)).append("\n");
		sb.append("    certificateType: ").append(toIndentedString(certificateType)).append("\n");
		sb.append("    supportedCertificateManagements: ").append(toIndentedString(supportedCertificateManagements)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    serialNumber: ").append(toIndentedString(serialNumber)).append("\n");
		sb.append("    signatureAlgorithm: ").append(toIndentedString(signatureAlgorithm)).append("\n");
		sb.append("    issuer: ").append(toIndentedString(issuer)).append("\n");
		sb.append("    notBefore: ").append(toIndentedString(notBefore)).append("\n");
		sb.append("    notAfter: ").append(toIndentedString(notAfter)).append("\n");
		sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
		sb.append("    publicKeyAlgorithm: ").append(toIndentedString(publicKeyAlgorithm)).append("\n");
		sb.append("    publicKey: ").append(toIndentedString(publicKey)).append("\n");
		sb.append("    certificateExtensions: ").append(toIndentedString(certificateExtensions)).append("\n");
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
