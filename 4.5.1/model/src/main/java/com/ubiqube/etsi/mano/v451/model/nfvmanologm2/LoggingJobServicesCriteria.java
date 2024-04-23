package com.ubiqube.etsi.mano.v451.model.nfvmanologm2;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * This type represents criteria for logging jobs to collect logged messages
 * about processes pertaining to NFV-MANO services. * NOTE: In the present
 * version of the present document, only one attribute, i.e.
 * \&quot;logGarbageCollection\&quot;, is available.
 */
@Schema(description = "This type represents criteria for logging jobs to collect logged messages about processes pertaining to NFV-MANO services. * NOTE: In the present version of the present document, only one attribute, i.e.         \"logGarbageCollection\", is available.")
@Validated

public class LoggingJobServicesCriteria {
	@JsonProperty("logGarbageCollection")
	private Boolean logGarbageCollection = null;

	public LoggingJobServicesCriteria logGarbageCollection(final Boolean logGarbageCollection) {
		this.logGarbageCollection = logGarbageCollection;
		return this;
	}

	/**
	 * Indicates to collect logged information about garbage collection processes
	 * associated to NFV-MANO services. See note.
	 *
	 * @return logGarbageCollection
	 **/
	@Schema(description = "Indicates to collect logged information about garbage collection processes associated to NFV-MANO services. See note.")

	public Boolean isLogGarbageCollection() {
		return logGarbageCollection;
	}

	public void setLogGarbageCollection(final Boolean logGarbageCollection) {
		this.logGarbageCollection = logGarbageCollection;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final LoggingJobServicesCriteria loggingJobServicesCriteria = (LoggingJobServicesCriteria) o;
		return Objects.equals(this.logGarbageCollection, loggingJobServicesCriteria.logGarbageCollection);
	}

	@Override
	public int hashCode() {
		return Objects.hash(logGarbageCollection);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class LoggingJobServicesCriteria {\n");

		sb.append("    logGarbageCollection: ").append(toIndentedString(logGarbageCollection)).append("\n");
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
