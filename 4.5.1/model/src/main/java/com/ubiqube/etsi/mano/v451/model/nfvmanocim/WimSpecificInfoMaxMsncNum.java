package com.ubiqube.etsi.mano.v451.model.nfvmanocim;

import java.util.Map;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Maximum number of MSNC that the WIM can manage
 */
@Schema(description = "Maximum number of MSNC that the WIM can manage ")
@Validated

public class WimSpecificInfoMaxMsncNum {
	@JsonProperty("numMsnc")
	private Integer numMsnc = null;

	@JsonProperty("criteriaNumMsnc")
	private Map<String, String> criteriaNumMsnc = null;

	public WimSpecificInfoMaxMsncNum numMsnc(final Integer numMsnc) {
		this.numMsnc = numMsnc;
		return this;
	}

	/**
	 * Maximum number of MSNC..
	 *
	 * @return numMsnc
	 **/
	@Schema(required = true, description = "Maximum number of MSNC.. ")
	@NotNull

	public Integer getNumMsnc() {
		return numMsnc;
	}

	public void setNumMsnc(final Integer numMsnc) {
		this.numMsnc = numMsnc;
	}

	public WimSpecificInfoMaxMsncNum criteriaNumMsnc(final Map<String, String> criteriaNumMsnc) {
		this.criteriaNumMsnc = criteriaNumMsnc;
		return this;
	}

	/**
	 * Get criteriaNumMsnc
	 *
	 * @return criteriaNumMsnc
	 **/
	@Schema(description = "")

	@Valid
	public Map<String, String> getCriteriaNumMsnc() {
		return criteriaNumMsnc;
	}

	public void setCriteriaNumMsnc(final Map<String, String> criteriaNumMsnc) {
		this.criteriaNumMsnc = criteriaNumMsnc;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final WimSpecificInfoMaxMsncNum wimSpecificInfoMaxMsncNum = (WimSpecificInfoMaxMsncNum) o;
		return Objects.equals(this.numMsnc, wimSpecificInfoMaxMsncNum.numMsnc) &&
				Objects.equals(this.criteriaNumMsnc, wimSpecificInfoMaxMsncNum.criteriaNumMsnc);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numMsnc, criteriaNumMsnc);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class WimSpecificInfoMaxMsncNum {\n");

		sb.append("    numMsnc: ").append(toIndentedString(numMsnc)).append("\n");
		sb.append("    criteriaNumMsnc: ").append(toIndentedString(criteriaNumMsnc)).append("\n");
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
