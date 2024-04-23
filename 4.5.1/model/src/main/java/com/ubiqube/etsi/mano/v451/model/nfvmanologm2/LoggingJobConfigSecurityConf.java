package com.ubiqube.etsi.mano.v451.model.nfvmanologm2;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

/**
 * Configuration about the security aspects of the logging job.
 */
@Schema(description = "Configuration about the security aspects of the logging job.")
@Validated

public class LoggingJobConfigSecurityConf {
	@JsonProperty("logFileEncryption")
	private LoggingJobConfigSecurityConfLogFileEncryption logFileEncryption = null;

	@JsonProperty("logTransferSecurity")
	private LoggingJobConfigSecurityConfLogTransferSecurity logTransferSecurity = null;

	public LoggingJobConfigSecurityConf logFileEncryption(final LoggingJobConfigSecurityConfLogFileEncryption logFileEncryption) {
		this.logFileEncryption = logFileEncryption;
		return this;
	}

	/**
	 * Get logFileEncryption
	 *
	 * @return logFileEncryption
	 **/
	@Schema(description = "")

	@Valid
	public LoggingJobConfigSecurityConfLogFileEncryption getLogFileEncryption() {
		return logFileEncryption;
	}

	public void setLogFileEncryption(final LoggingJobConfigSecurityConfLogFileEncryption logFileEncryption) {
		this.logFileEncryption = logFileEncryption;
	}

	public LoggingJobConfigSecurityConf logTransferSecurity(final LoggingJobConfigSecurityConfLogTransferSecurity logTransferSecurity) {
		this.logTransferSecurity = logTransferSecurity;
		return this;
	}

	/**
	 * Get logTransferSecurity
	 *
	 * @return logTransferSecurity
	 **/
	@Schema(description = "")

	@Valid
	public LoggingJobConfigSecurityConfLogTransferSecurity getLogTransferSecurity() {
		return logTransferSecurity;
	}

	public void setLogTransferSecurity(final LoggingJobConfigSecurityConfLogTransferSecurity logTransferSecurity) {
		this.logTransferSecurity = logTransferSecurity;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final LoggingJobConfigSecurityConf loggingJobConfigSecurityConf = (LoggingJobConfigSecurityConf) o;
		return Objects.equals(this.logFileEncryption, loggingJobConfigSecurityConf.logFileEncryption) &&
				Objects.equals(this.logTransferSecurity, loggingJobConfigSecurityConf.logTransferSecurity);
	}

	@Override
	public int hashCode() {
		return Objects.hash(logFileEncryption, logTransferSecurity);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class LoggingJobConfigSecurityConf {\n");

		sb.append("    logFileEncryption: ").append(toIndentedString(logFileEncryption)).append("\n");
		sb.append("    logTransferSecurity: ").append(toIndentedString(logTransferSecurity)).append("\n");
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
