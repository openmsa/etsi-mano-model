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
package com.ubiqube.etsi.mano.v451.model.nfvmanologm2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Information about the encryption of the compiled log files. Shall be present
 * if the log file is requested to be encrypted.
 */
@Schema(description = "Information about the encryption of the compiled log files. Shall be present if the log file is requested to be encrypted.")
@Validated

public class LoggingJobConfigSecurityConfLogFileEncryption {
	@JsonProperty("encryptionCertificate")
	private String encryptionCertificate = null;

	@JsonProperty("cipherAlgorithm")
	@Valid
	private List<String> cipherAlgorithm = new ArrayList<>();

	@JsonProperty("encryptAndSignOrder")
	private String encryptAndSignOrder = null;

	public LoggingJobConfigSecurityConfLogFileEncryption encryptionCertificate(final String encryptionCertificate) {
		this.encryptionCertificate = encryptionCertificate;
		return this;
	}

	/**
	 * X.509 certificate with the public key to use for the encryption of the
	 * compiled log file.
	 *
	 * @return encryptionCertificate
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "X.509 certificate with the public key to use for the encryption of the compiled log file.")
	@NotNull

	public String getEncryptionCertificate() {
		return encryptionCertificate;
	}

	public void setEncryptionCertificate(final String encryptionCertificate) {
		this.encryptionCertificate = encryptionCertificate;
	}

	public LoggingJobConfigSecurityConfLogFileEncryption cipherAlgorithm(final List<String> cipherAlgorithm) {
		this.cipherAlgorithm = cipherAlgorithm;
		return this;
	}

	public LoggingJobConfigSecurityConfLogFileEncryption addCipherAlgorithmItem(final String cipherAlgorithmItem) {
		this.cipherAlgorithm.add(cipherAlgorithmItem);
		return this;
	}

	/**
	 * Cryptographic algorithm to be used for the encryption of the compiled log
	 * file. More than one algorithm can be provided from higher (lower array index)
	 * to lower (higher array index) precedence. Valid values are: \"AES-CBC-128\",
	 * \"AES-GCM-128\", \"AES-CBC-256\", and \"AES-GCM-256\", as specified in clause
	 * 6.5 of ETSI GS NFV-SEC 012
	 *
	 * @return cipherAlgorithm
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Cryptographic algorithm to be used for the encryption of the compiled log file. More than one algorithm can be provided from higher (lower array index) to lower (higher array index) precedence. Valid values are: \"AES-CBC-128\", \"AES-GCM-128\", \"AES-CBC-256\", and \"AES-GCM-256\", as specified in clause 6.5 of ETSI GS NFV-SEC 012")
	@NotNull

	public List<String> getCipherAlgorithm() {
		return cipherAlgorithm;
	}

	public void setCipherAlgorithm(final List<String> cipherAlgorithm) {
		this.cipherAlgorithm = cipherAlgorithm;
	}

	public LoggingJobConfigSecurityConfLogFileEncryption encryptAndSignOrder(final String encryptAndSignOrder) {
		this.encryptAndSignOrder = encryptAndSignOrder;
		return this;
	}

	/**
	 * Indication about the order in signing and encrypting the compiled log file.
	 * Valid values are: \"encryptFirst\", to apply the order \"first encrypt, then
	 * sign\", and \"signFirst\" for the order \"first sign, then encrypt\". Default
	 * value is \"encryptFirst\".
	 *
	 * @return encryptAndSignOrder
	 **/
	@Schema(description = "Indication about the order in signing and encrypting the compiled log file. Valid values are: \"encryptFirst\", to apply the order \"first encrypt, then sign\", and \"signFirst\" for the order \"first sign, then encrypt\". Default value is \"encryptFirst\".")

	public String getEncryptAndSignOrder() {
		return encryptAndSignOrder;
	}

	public void setEncryptAndSignOrder(final String encryptAndSignOrder) {
		this.encryptAndSignOrder = encryptAndSignOrder;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final LoggingJobConfigSecurityConfLogFileEncryption loggingJobConfigSecurityConfLogFileEncryption = (LoggingJobConfigSecurityConfLogFileEncryption) o;
		return Objects.equals(this.encryptionCertificate, loggingJobConfigSecurityConfLogFileEncryption.encryptionCertificate) &&
				Objects.equals(this.cipherAlgorithm, loggingJobConfigSecurityConfLogFileEncryption.cipherAlgorithm) &&
				Objects.equals(this.encryptAndSignOrder, loggingJobConfigSecurityConfLogFileEncryption.encryptAndSignOrder);
	}

	@Override
	public int hashCode() {
		return Objects.hash(encryptionCertificate, cipherAlgorithm, encryptAndSignOrder);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class LoggingJobConfigSecurityConfLogFileEncryption {\n");

		sb.append("    encryptionCertificate: ").append(toIndentedString(encryptionCertificate)).append("\n");
		sb.append("    cipherAlgorithm: ").append(toIndentedString(cipherAlgorithm)).append("\n");
		sb.append("    encryptAndSignOrder: ").append(toIndentedString(encryptAndSignOrder)).append("\n");
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
