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
package com.ubiqube.etsi.mano.v261.model.nfvo.nslcm;

import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.annotation.Nonnull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

/**
 * This type provides information about added, deleted and modified VNFs. It
 * shall comply with the provisions in Table 6.5.3.2-1.
 */
@Schema(description = "This type provides information about added, deleted and modified VNFs.  It shall comply with the provisions in Table 6.5.3.2-1. ")
@Validated

public class AffectedVnf {
	@JsonProperty("vnfInstanceId")
	private String vnfInstanceId = null;

	@JsonProperty("vnfdId")
	private String vnfdId = null;

	@JsonProperty("vnfProfileId")
	private String vnfProfileId = null;

	@JsonProperty("vnfName")
	private String vnfName = null;

	/**
	 * Signals the type of change Permitted values: - ADD - REMOVE - INSTANTIATE -
	 * TERMINATE - SCALE - CHANGE_FLAVOUR - HEAL - OPERATE - MODIFY_INFORMATION -
	 * CHANGE_EXTERNAL_VNF_CONNECTIVITY
	 */
	public enum ChangeTypeEnum {
		ADD("ADD"),

		REMOVE("REMOVE"),

		INSTANTIATE("INSTANTIATE"),

		TERMINATE("TERMINATE"),

		SCALE("SCALE"),

		CHANGE_FLAVOUR("CHANGE_FLAVOUR"),

		HEAL("HEAL"),

		OPERATE("OPERATE"),

		MODIFY_INFORMATION("MODIFY_INFORMATION"),

		CHANGE_EXTERNAL_VNF_CONNECTIVITY("CHANGE_EXTERNAL_VNF_CONNECTIVITY");

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
	 * Signals the result of change identified by the \"changeType\" attribute.
	 * Permitted values: - COMPLETED - ROLLED_BACK - FAILED
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

	@JsonProperty("changedInfo")
	private AffectedVnfChangedInfo changedInfo = null;

	public AffectedVnf vnfInstanceId(final String vnfInstanceId) {
		this.vnfInstanceId = vnfInstanceId;
		return this;
	}

	/**
	 * Identifier of the VNF instance.
	 *
	 * @return vnfInstanceId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifier of the VNF instance.  ")
	@Nonnull

	public String getVnfInstanceId() {
		return vnfInstanceId;
	}

	public void setVnfInstanceId(final String vnfInstanceId) {
		this.vnfInstanceId = vnfInstanceId;
	}

	public AffectedVnf vnfdId(final String vnfdId) {
		this.vnfdId = vnfdId;
		return this;
	}

	/**
	 * Identifier of the VNFD of the VNF Instance.
	 *
	 * @return vnfdId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifier of the VNFD of the VNF Instance. ")
	@Nonnull

	public String getVnfdId() {
		return vnfdId;
	}

	public void setVnfdId(final String vnfdId) {
		this.vnfdId = vnfdId;
	}

	public AffectedVnf vnfProfileId(final String vnfProfileId) {
		this.vnfProfileId = vnfProfileId;
		return this;
	}

	/**
	 * Identifier of the VNF profile of the NSD.
	 *
	 * @return vnfProfileId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifier of the VNF profile of the NSD. ")
	@Nonnull

	public String getVnfProfileId() {
		return vnfProfileId;
	}

	public void setVnfProfileId(final String vnfProfileId) {
		this.vnfProfileId = vnfProfileId;
	}

	public AffectedVnf vnfName(final String vnfName) {
		this.vnfName = vnfName;
		return this;
	}

	/**
	 * Name of the VNF Instance.
	 *
	 * @return vnfName
	 **/
	@Schema(description = "Name of the VNF Instance. ")

	public String getVnfName() {
		return vnfName;
	}

	public void setVnfName(final String vnfName) {
		this.vnfName = vnfName;
	}

	public AffectedVnf changeType(final ChangeTypeEnum changeType) {
		this.changeType = changeType;
		return this;
	}

	/**
	 * Signals the type of change Permitted values: - ADD - REMOVE - INSTANTIATE -
	 * TERMINATE - SCALE - CHANGE_FLAVOUR - HEAL - OPERATE - MODIFY_INFORMATION -
	 * CHANGE_EXTERNAL_VNF_CONNECTIVITY
	 *
	 * @return changeType
	 **/
	@Schema(description = "Signals the type of change Permitted values: - ADD - REMOVE - INSTANTIATE - TERMINATE - SCALE - CHANGE_FLAVOUR - HEAL - OPERATE - MODIFY_INFORMATION - CHANGE_EXTERNAL_VNF_CONNECTIVITY ")

	public ChangeTypeEnum getChangeType() {
		return changeType;
	}

	public void setChangeType(final ChangeTypeEnum changeType) {
		this.changeType = changeType;
	}

	public AffectedVnf changeResult(final ChangeResultEnum changeResult) {
		this.changeResult = changeResult;
		return this;
	}

	/**
	 * Signals the result of change identified by the \"changeType\" attribute.
	 * Permitted values: - COMPLETED - ROLLED_BACK - FAILED
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

	public AffectedVnf changedInfo(final AffectedVnfChangedInfo changedInfo) {
		this.changedInfo = changedInfo;
		return this;
	}

	/**
	 * Get changedInfo
	 *
	 * @return changedInfo
	 **/
	@Schema(description = "")

	@Valid

	public AffectedVnfChangedInfo getChangedInfo() {
		return changedInfo;
	}

	public void setChangedInfo(final AffectedVnfChangedInfo changedInfo) {
		this.changedInfo = changedInfo;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final AffectedVnf affectedVnf = (AffectedVnf) o;
		return Objects.equals(this.vnfInstanceId, affectedVnf.vnfInstanceId) &&
				Objects.equals(this.vnfdId, affectedVnf.vnfdId) &&
				Objects.equals(this.vnfProfileId, affectedVnf.vnfProfileId) &&
				Objects.equals(this.vnfName, affectedVnf.vnfName) &&
				Objects.equals(this.changeType, affectedVnf.changeType) &&
				Objects.equals(this.changeResult, affectedVnf.changeResult) &&
				Objects.equals(this.changedInfo, affectedVnf.changedInfo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(vnfInstanceId, vnfdId, vnfProfileId, vnfName, changeType, changeResult, changedInfo);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class AffectedVnf {\n");

		sb.append("    vnfInstanceId: ").append(toIndentedString(vnfInstanceId)).append("\n");
		sb.append("    vnfdId: ").append(toIndentedString(vnfdId)).append("\n");
		sb.append("    vnfProfileId: ").append(toIndentedString(vnfProfileId)).append("\n");
		sb.append("    vnfName: ").append(toIndentedString(vnfName)).append("\n");
		sb.append("    changeType: ").append(toIndentedString(changeType)).append("\n");
		sb.append("    changeResult: ").append(toIndentedString(changeResult)).append("\n");
		sb.append("    changedInfo: ").append(toIndentedString(changedInfo)).append("\n");
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
