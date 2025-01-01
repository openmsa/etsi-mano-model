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
package com.ubiqube.etsi.mano.v271.model.sol005.nslcm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type represents the information used to heal a NS. It shall comply with
 * the provisions defined in Table 6.5.3.43-1.
 */
@Schema(description = "This type represents the information used to heal a NS.  It shall comply with the provisions defined in Table 6.5.3.43-1. ")
@Validated
public class HealNsData {
	/**
	 * Indicates the degree of healing. Possible values include: - HEAL_RESTORE:
	 * Complete the healing of the NS restoring the state of the NS before the
	 * failure occurred - HEAL_QOS: Complete the healing of the NS based on the
	 * newest QoS values - HEAL_RESET: Complete the healing of the NS resetting to
	 * the original instantiation state of the NS - PARTIAL_HEALING
	 */
	public enum DegreeHealingEnum {
		HEAL_RESTORE("HEAL_RESTORE"),

		HEAL_QOS("HEAL_QOS"),

		HEAL_RESET("HEAL_RESET"),

		PARTIAL_HEALING("PARTIAL_HEALING");

		private final String value;

		DegreeHealingEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static DegreeHealingEnum fromValue(final String text) {
			for (final DegreeHealingEnum b : DegreeHealingEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("degreeHealing")
	private DegreeHealingEnum degreeHealing = null;

	@JsonProperty("actionsHealing")
	@Valid
	private List<String> actionsHealing = null;

	@JsonProperty("healScript")
	private String healScript = null;

	@JsonProperty("additionalParamsforNs")
	private Map<String, String> additionalParamsforNs = null;

	public HealNsData degreeHealing(final DegreeHealingEnum degreeHealing) {
		this.degreeHealing = degreeHealing;
		return this;
	}

	/**
	 * Indicates the degree of healing. Possible values include: - HEAL_RESTORE:
	 * Complete the healing of the NS restoring the state of the NS before the
	 * failure occurred - HEAL_QOS: Complete the healing of the NS based on the
	 * newest QoS values - HEAL_RESET: Complete the healing of the NS resetting to
	 * the original instantiation state of the NS - PARTIAL_HEALING
	 *
	 * @return degreeHealing
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Indicates the degree of healing. Possible values include: - HEAL_RESTORE: Complete the healing of the NS restoring the state of the NS before the failure occurred - HEAL_QOS: Complete the healing of the NS based on the newest QoS values - HEAL_RESET: Complete the healing of the NS resetting to the original instantiation state of the NS - PARTIAL_HEALING ")
	@NotNull

	public DegreeHealingEnum getDegreeHealing() {
		return degreeHealing;
	}

	public void setDegreeHealing(final DegreeHealingEnum degreeHealing) {
		this.degreeHealing = degreeHealing;
	}

	public HealNsData actionsHealing(final List<String> actionsHealing) {
		this.actionsHealing = actionsHealing;
		return this;
	}

	public HealNsData addActionsHealingItem(final String actionsHealingItem) {
		if (this.actionsHealing == null) {
			this.actionsHealing = new ArrayList<>();
		}
		this.actionsHealing.add(actionsHealingItem);
		return this;
	}

	/**
	 * Used to specify dedicated healing actions in a particular order (e.g. as a
	 * script). The actionsHealing attribute can be used to provide a specific
	 * script whose content and actions might only be possible to be derived during
	 * runtime.
	 *
	 * @return actionsHealing
	 **/
	@Schema(description = "Used to specify dedicated healing actions in a particular order (e.g. as a script). The actionsHealing attribute can be used to provide a specific script whose content and actions might only be possible to be derived during runtime. ")

	public List<String> getActionsHealing() {
		return actionsHealing;
	}

	public void setActionsHealing(final List<String> actionsHealing) {
		this.actionsHealing = actionsHealing;
	}

	public HealNsData healScript(final String healScript) {
		this.healScript = healScript;
		return this;
	}

	/**
	 * Get healScript
	 *
	 * @return healScript
	 **/
	@Schema(description = "")

	public String getHealScript() {
		return healScript;
	}

	public void setHealScript(final String healScript) {
		this.healScript = healScript;
	}

	public HealNsData additionalParamsforNs(final Map<String, String> additionalParamsforNs) {
		this.additionalParamsforNs = additionalParamsforNs;
		return this;
	}

	/**
	 * Get additionalParamsforNs
	 *
	 * @return additionalParamsforNs
	 **/
	@Schema(description = "")

	@Valid
	public Map<String, String> getAdditionalParamsforNs() {
		return additionalParamsforNs;
	}

	public void setAdditionalParamsforNs(final Map<String, String> additionalParamsforNs) {
		this.additionalParamsforNs = additionalParamsforNs;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final HealNsData healNsData = (HealNsData) o;
		return Objects.equals(this.degreeHealing, healNsData.degreeHealing) &&
				Objects.equals(this.actionsHealing, healNsData.actionsHealing) &&
				Objects.equals(this.healScript, healNsData.healScript) &&
				Objects.equals(this.additionalParamsforNs, healNsData.additionalParamsforNs);
	}

	@Override
	public int hashCode() {
		return Objects.hash(degreeHealing, actionsHealing, healScript, additionalParamsforNs);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class HealNsData {\n");

		sb.append("    degreeHealing: ").append(toIndentedString(degreeHealing)).append("\n");
		sb.append("    actionsHealing: ").append(toIndentedString(actionsHealing)).append("\n");
		sb.append("    healScript: ").append(toIndentedString(healScript)).append("\n");
		sb.append("    additionalParamsforNs: ").append(toIndentedString(additionalParamsforNs)).append("\n");
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
