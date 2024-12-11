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

import jakarta.validation.Valid;
import jakarta.annotation.Nonnull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;


/**
 * This type represents the information about a PNF that is part of an NS
 * instance. It shall comply with the provisions defined in Table 6.5.3.13-1.
 */
@Schema(description = "This type represents the information about a PNF that is part of an NS instance.  It shall comply with the provisions defined in Table 6.5.3.13-1. ")
@Validated


public class PnfInfo {
	@JsonProperty("pnfId")
	private String pnfId = null;

	@JsonProperty("pnfName")
	private String pnfName = null;

	@JsonProperty("pnfdId")
	private String pnfdId = null;

	@JsonProperty("pnfdInfoId")
	private String pnfdInfoId = null;

	@JsonProperty("pnfProfileId")
	private String pnfProfileId = null;

	@JsonProperty("cpInfo")
	private PnfExtCpInfo cpInfo = null;

	public PnfInfo pnfId(final String pnfId) {
		this.pnfId = pnfId;
		return this;
	}

	/**
	 * Identifier of the PNF. This identifier is allocated by the OSS/BSS.
	 * 
	 * @return pnfId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifier of the PNF. This identifier is allocated by the OSS/BSS. ")
	@Nonnull

	public String getPnfId() {
		return pnfId;
	}

	public void setPnfId(final String pnfId) {
		this.pnfId = pnfId;
	}

	public PnfInfo pnfName(final String pnfName) {
		this.pnfName = pnfName;
		return this;
	}

	/**
	 * Name of the PNF.
	 * 
	 * @return pnfName
	 **/
	@Schema(description = "Name of the PNF. ")

	public String getPnfName() {
		return pnfName;
	}

	public void setPnfName(final String pnfName) {
		this.pnfName = pnfName;
	}

	public PnfInfo pnfdId(final String pnfdId) {
		this.pnfdId = pnfdId;
		return this;
	}

	/**
	 * Identifier of the PNFD on which the PNF is based.
	 * 
	 * @return pnfdId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifier of the PNFD on which the PNF is based. ")
	@Nonnull

	public String getPnfdId() {
		return pnfdId;
	}

	public void setPnfdId(final String pnfdId) {
		this.pnfdId = pnfdId;
	}

	public PnfInfo pnfdInfoId(final String pnfdInfoId) {
		this.pnfdInfoId = pnfdInfoId;
		return this;
	}

	/**
	 * Identifier of the PNFD information onject related to this PNF. This
	 * identifier is allocated by the NFVO
	 * 
	 * @return pnfdInfoId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifier of the PNFD information onject related to this PNF. This identifier is allocated by the NFVO ")
	@Nonnull

	public String getPnfdInfoId() {
		return pnfdInfoId;
	}

	public void setPnfdInfoId(final String pnfdInfoId) {
		this.pnfdInfoId = pnfdInfoId;
	}

	public PnfInfo pnfProfileId(final String pnfProfileId) {
		this.pnfProfileId = pnfProfileId;
		return this;
	}

	/**
	 * Identifier of the related PnfProfile in the NSD on which the PNF is based.
	 * 
	 * @return pnfProfileId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Identifier of the related PnfProfile in the NSD on which the PNF is based. ")
	@Nonnull

	public String getPnfProfileId() {
		return pnfProfileId;
	}

	public void setPnfProfileId(final String pnfProfileId) {
		this.pnfProfileId = pnfProfileId;
	}

	public PnfInfo cpInfo(final PnfExtCpInfo cpInfo) {
		this.cpInfo = cpInfo;
		return this;
	}

	/**
	 * Information on the external CP of the PNF.
	 * 
	 * @return cpInfo
	 **/
	@Schema(description = "Information on the external CP of the PNF. ")

	@Valid

	public PnfExtCpInfo getCpInfo() {
		return cpInfo;
	}

	public void setCpInfo(final PnfExtCpInfo cpInfo) {
		this.cpInfo = cpInfo;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final PnfInfo pnfInfo = (PnfInfo) o;
		return Objects.equals(this.pnfId, pnfInfo.pnfId) &&
				Objects.equals(this.pnfName, pnfInfo.pnfName) &&
				Objects.equals(this.pnfdId, pnfInfo.pnfdId) &&
				Objects.equals(this.pnfdInfoId, pnfInfo.pnfdInfoId) &&
				Objects.equals(this.pnfProfileId, pnfInfo.pnfProfileId) &&
				Objects.equals(this.cpInfo, pnfInfo.cpInfo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pnfId, pnfName, pnfdId, pnfdInfoId, pnfProfileId, cpInfo);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class PnfInfo {\n");

		sb.append("    pnfId: ").append(toIndentedString(pnfId)).append("\n");
		sb.append("    pnfName: ").append(toIndentedString(pnfName)).append("\n");
		sb.append("    pnfdId: ").append(toIndentedString(pnfdId)).append("\n");
		sb.append("    pnfdInfoId: ").append(toIndentedString(pnfdInfoId)).append("\n");
		sb.append("    pnfProfileId: ").append(toIndentedString(pnfProfileId)).append("\n");
		sb.append("    cpInfo: ").append(toIndentedString(cpInfo)).append("\n");
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
