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
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.ubiqube.etsi.mano.v261.model.nfvo.nslcm;

import java.util.Objects;
import java.util.UUID;

import jakarta.annotation.Nonnull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;


/**
 * This type provides information about added, deleted and modified VLs. It shall comply with the provisions in Table 6.5.3.4-1.
 */
@Schema(description = "This type provides information about added, deleted and modified VLs.  It shall comply with the provisions in Table 6.5.3.4-1. ")
@Validated

public class AffectedVl {
	@JsonProperty("nsVirtualLinkInstanceId")
	private String nsVirtualLinkInstanceId = null;

	@JsonProperty("nsVirtualLinkDescId")
	private String nsVirtualLinkDescId = null;

	@JsonProperty("vlProfileId")
	private UUID vlProfileId = null;

	/**
	 * Signals the type of change. Permitted values: - ADD - DELETE - MODIFY - ADD_LINK_PORT - REMOVE_LINK_PORT
	 */
	public enum ChangeTypeEnum {
		ADD("ADD"),

		DELETE("DELETE"),

		MODIFY("MODIFY"),

		ADD_LINK_PORT("ADD_LINK_PORT"),

		REMOVE_LINK_PORT("REMOVE_LINK_PORT");

		private final String value;

		ChangeTypeEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static ChangeTypeEnum fromValue(final String text) {
			for (final ChangeTypeEnum b : ChangeTypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("changeType")
	private ChangeTypeEnum changeType = null;

	/**
	 * Signals the result of change identified by the \"changeType\" attribute. Permitted values: - COMPLETED - ROLLED_BACK - FAILED
	 */
	public enum ChangeResultEnum {
		COMPLETED("COMPLETED"),

		ROLLED_BACK("ROLLED_BACK"),

		FAILED("FAILED");

		private final String value;

		ChangeResultEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static ChangeResultEnum fromValue(final String text) {
			for (final ChangeResultEnum b : ChangeResultEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("changeResult")
	private ChangeResultEnum changeResult = null;

	public AffectedVl nsVirtualLinkInstanceId(final String nsVirtualLinkInstanceId) {
		this.nsVirtualLinkInstanceId = nsVirtualLinkInstanceId;
		return this;
	}

	/**
	 * Identifier of the VL Instance.
	 *
	 * @return nsVirtualLinkInstanceId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifier of the VL Instance. ")
	@Nonnull

	public String getNsVirtualLinkInstanceId() {
		return nsVirtualLinkInstanceId;
	}

	public void setNsVirtualLinkInstanceId(final String nsVirtualLinkInstanceId) {
		this.nsVirtualLinkInstanceId = nsVirtualLinkInstanceId;
	}

	public AffectedVl nsVirtualLinkDescId(final String nsVirtualLinkDescId) {
		this.nsVirtualLinkDescId = nsVirtualLinkDescId;
		return this;
	}

	/**
	 * Identifier of the VLD in the NSD for this VL.
	 *
	 * @return nsVirtualLinkDescId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifier of the VLD in the NSD for this VL. ")
	@Nonnull

	public String getNsVirtualLinkDescId() {
		return nsVirtualLinkDescId;
	}

	public void setNsVirtualLinkDescId(final String nsVirtualLinkDescId) {
		this.nsVirtualLinkDescId = nsVirtualLinkDescId;
	}

	public AffectedVl vlProfileId(final UUID vlProfileId) {
		this.vlProfileId = vlProfileId;
		return this;
	}

	/**
	 * Identifier of the VLD in the NSD for this VL.
	 *
	 * @return vlProfileId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifier of the VLD in the NSD for this VL. ")
	@Nonnull

	public UUID getVlProfileId() {
		return vlProfileId;
	}

	public void setVlProfileId(final UUID vlProfileId) {
		this.vlProfileId = vlProfileId;
	}

	public AffectedVl changeType(final ChangeTypeEnum changeType) {
		this.changeType = changeType;
		return this;
	}

	/**
	 * Signals the type of change. Permitted values: - ADD - DELETE - MODIFY - ADD_LINK_PORT - REMOVE_LINK_PORT
	 *
	 * @return changeType
	 **/
	@Schema(description = "Signals the type of change. Permitted values: - ADD - DELETE - MODIFY - ADD_LINK_PORT - REMOVE_LINK_PORT ")

	public ChangeTypeEnum getChangeType() {
		return changeType;
	}

	public void setChangeType(final ChangeTypeEnum changeType) {
		this.changeType = changeType;
	}

	public AffectedVl changeResult(final ChangeResultEnum changeResult) {
		this.changeResult = changeResult;
		return this;
	}

	/**
	 * Signals the result of change identified by the \"changeType\" attribute. Permitted values: - COMPLETED - ROLLED_BACK - FAILED
	 *
	 * @return changeResult
	 **/
	@Schema(description = "Signals the result of change identified by the \"changeType\" attribute. Permitted values: - COMPLETED - ROLLED_BACK - FAILED ")

	public ChangeResultEnum getChangeResult() {
		return changeResult;
	}

	public void setChangeResult(final ChangeResultEnum changeResult) {
		this.changeResult = changeResult;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final AffectedVl affectedVl = (AffectedVl) o;
		return Objects.equals(this.nsVirtualLinkInstanceId, affectedVl.nsVirtualLinkInstanceId) &&
				Objects.equals(this.nsVirtualLinkDescId, affectedVl.nsVirtualLinkDescId) &&
				Objects.equals(this.vlProfileId, affectedVl.vlProfileId) &&
				Objects.equals(this.changeType, affectedVl.changeType) &&
				Objects.equals(this.changeResult, affectedVl.changeResult);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nsVirtualLinkInstanceId, nsVirtualLinkDescId, vlProfileId, changeType, changeResult);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class AffectedVl {\n");

		sb.append("    nsVirtualLinkInstanceId: ").append(toIndentedString(nsVirtualLinkInstanceId)).append("\n");
		sb.append("    nsVirtualLinkDescId: ").append(toIndentedString(nsVirtualLinkDescId)).append("\n");
		sb.append("    vlProfileId: ").append(toIndentedString(vlProfileId)).append("\n");
		sb.append("    changeType: ").append(toIndentedString(changeType)).append("\n");
		sb.append("    changeResult: ").append(toIndentedString(changeResult)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces (except the first line).
	 */
	private String toIndentedString(final java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
