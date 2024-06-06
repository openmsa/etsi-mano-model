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
package com.ubiqube.etsi.mano.v451.model.nfvmanologm2;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

/**
 * Security and integrity information for the compilation of the log files.
 */
@Schema(description = "Security and integrity information for the compilation of the log files.")
@Validated

public class LogReportSecurityAndIntegrityInfo {
	@JsonProperty("algorithm")
	private String algorithm = null;

	@JsonProperty("hash")
	private String hash = null;

	@JsonProperty("encryptionPublicKey")
	private String encryptionPublicKey = null;

	@JsonProperty("cipherAlgorithm")
	private String cipherAlgorithm = null;

	@JsonProperty("logFileSignature")
	private String logFileSignature = null;

	@JsonProperty("signingCertificate")
	private String signingCertificate = null;

	public LogReportSecurityAndIntegrityInfo algorithm(final String algorithm) {
		this.algorithm = algorithm;
		return this;
	}

	/**
	 * Algorithm used to generate the hash of the compiled log file. Only SHA-256
	 * and SHA-512 shall be used
	 *
	 * @return algorithm
	 **/
	@Schema(required = true, description = "Algorithm used to generate the hash of the compiled log file. Only SHA-256 and SHA-512 shall be used")
	@NotNull

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(final String algorithm) {
		this.algorithm = algorithm;
	}

	public LogReportSecurityAndIntegrityInfo hash(final String hash) {
		this.hash = hash;
		return this;
	}

	/**
	 * The hexadecimal value of the hash of the compiled log file. The hash shall be
	 * computed from the encrypted compiled log file, in case the encryption
	 * applies.
	 *
	 * @return hash
	 **/
	@Schema(required = true, description = "The hexadecimal value of the hash of the compiled log file. The hash shall be computed from the encrypted compiled log file, in case the encryption applies.")
	@NotNull

	public String getHash() {
		return hash;
	}

	public void setHash(final String hash) {
		this.hash = hash;
	}

	public LogReportSecurityAndIntegrityInfo encryptionPublicKey(final String encryptionPublicKey) {
		this.encryptionPublicKey = encryptionPublicKey;
		return this;
	}

	/**
	 * Public key used for the encryption of the compiled log file. Shall be present
	 * if the compiled log file is encrypted.
	 *
	 * @return encryptionPublicKey
	 **/
	@Schema(description = "Public key used for the encryption of the compiled log file. Shall be present if the compiled log file is encrypted.")

	public String getEncryptionPublicKey() {
		return encryptionPublicKey;
	}

	public void setEncryptionPublicKey(final String encryptionPublicKey) {
		this.encryptionPublicKey = encryptionPublicKey;
	}

	public LogReportSecurityAndIntegrityInfo cipherAlgorithm(final String cipherAlgorithm) {
		this.cipherAlgorithm = cipherAlgorithm;
		return this;
	}

	/**
	 * The cryptographic algorithm used for the encryption. Shall be present if the
	 * compiled log file is encrypted. Valid values are: \"AES-CBC-128\",
	 * \"AES-GCM-128\", \"AES-CBC-256\", and \"AES-GCM-256\", as specified in clause
	 * 6.5 of ETSI GS NFV-SEC 012.
	 *
	 * @return cipherAlgorithm
	 **/
	@Schema(description = "The cryptographic algorithm used for the encryption. Shall be present if the compiled log file is encrypted. Valid values are: \"AES-CBC-128\", \"AES-GCM-128\", \"AES-CBC-256\", and \"AES-GCM-256\", as specified in clause 6.5 of ETSI GS NFV-SEC 012.")

	public String getCipherAlgorithm() {
		return cipherAlgorithm;
	}

	public void setCipherAlgorithm(final String cipherAlgorithm) {
		this.cipherAlgorithm = cipherAlgorithm;
	}

	public LogReportSecurityAndIntegrityInfo logFileSignature(final String logFileSignature) {
		this.logFileSignature = logFileSignature;
		return this;
	}

	/**
	 * Signature to the compiled log file generated with the NFV-MANO functional
	 * entity’s private key, which is used to ensure the authenticity of the
	 * compiled log file. The signature shall be applied according to the
	 * \"encryptAndSignOrder\" of the \"LoggingJobConfig\". See note.
	 *
	 * @return logFileSignature
	 **/
	@Schema(required = true, description = "Signature to the compiled log file generated with the NFV-MANO functional entity’s private key, which is used to ensure the authenticity of the compiled log file. The signature shall be applied according to the \"encryptAndSignOrder\" of the \"LoggingJobConfig\". See note.")
	@NotNull

	public String getLogFileSignature() {
		return logFileSignature;
	}

	public void setLogFileSignature(final String logFileSignature) {
		this.logFileSignature = logFileSignature;
	}

	public LogReportSecurityAndIntegrityInfo signingCertificate(final String signingCertificate) {
		this.signingCertificate = signingCertificate;
		return this;
	}

	/**
	 * X.509 certificate with the NFV-MANO functional entity’s public key used for
	 * verifying the log report and compiled log file signatures.
	 *
	 * @return signingCertificate
	 **/
	@Schema(required = true, description = "X.509 certificate with the NFV-MANO functional entity’s public key used for verifying the log report and compiled log file signatures.")
	@NotNull

	public String getSigningCertificate() {
		return signingCertificate;
	}

	public void setSigningCertificate(final String signingCertificate) {
		this.signingCertificate = signingCertificate;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final LogReportSecurityAndIntegrityInfo logReportSecurityAndIntegrityInfo = (LogReportSecurityAndIntegrityInfo) o;
		return Objects.equals(this.algorithm, logReportSecurityAndIntegrityInfo.algorithm) &&
				Objects.equals(this.hash, logReportSecurityAndIntegrityInfo.hash) &&
				Objects.equals(this.encryptionPublicKey, logReportSecurityAndIntegrityInfo.encryptionPublicKey) &&
				Objects.equals(this.cipherAlgorithm, logReportSecurityAndIntegrityInfo.cipherAlgorithm) &&
				Objects.equals(this.logFileSignature, logReportSecurityAndIntegrityInfo.logFileSignature) &&
				Objects.equals(this.signingCertificate, logReportSecurityAndIntegrityInfo.signingCertificate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(algorithm, hash, encryptionPublicKey, cipherAlgorithm, logFileSignature, signingCertificate);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class LogReportSecurityAndIntegrityInfo {\n");

		sb.append("    algorithm: ").append(toIndentedString(algorithm)).append("\n");
		sb.append("    hash: ").append(toIndentedString(hash)).append("\n");
		sb.append("    encryptionPublicKey: ").append(toIndentedString(encryptionPublicKey)).append("\n");
		sb.append("    cipherAlgorithm: ").append(toIndentedString(cipherAlgorithm)).append("\n");
		sb.append("    logFileSignature: ").append(toIndentedString(logFileSignature)).append("\n");
		sb.append("    signingCertificate: ").append(toIndentedString(signingCertificate)).append("\n");
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
