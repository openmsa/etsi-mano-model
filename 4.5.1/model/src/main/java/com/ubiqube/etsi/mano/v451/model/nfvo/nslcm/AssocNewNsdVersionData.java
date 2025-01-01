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
package com.ubiqube.etsi.mano.v451.model.nfvo.nslcm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * This type specifies a new NSD version that is associated to the NS instance.
 * After issuing the Update NS operation with updateType &#x3D;
 * \&quot;AssocNewNsdVersion\&quot;, the NFVO shall use the referred NSD as a
 * basis for the given NS instance. Different versions of the same NSD have same
 * nsdInvariantId, but different nsdId attributes, therefore if the
 * nsdInvariantId of the NSD version that is to be associated to this NS
 * instance is different from the one used before, the NFVO shall reject the
 * request. Only new versions of the same NSD can be associated to an existing
 * NS instance. This data type shall comply with the provisions defined in Table
 * 6.5.3.34-1. NOTE 1: The replacement of VNF instances, nested NS instances or
 * PNF instances by instances whose descriptor is referenced by the new NSD is
 * applicable even if the instance with a descriptor not referenced from the new
 * NSD has the same \&quot;vnfdExtInvariantId\&quot;,
 * \&quot;nsdExtInvariantId\&quot; or \&quot;pnfdExtInvariantId\&quot; as the
 * new one, i.e. the synchronization procedure is based on descriptor identities
 * of NSD constituents, and does not consider \&quot;vnfdExtInvariantId\&quot;,
 * \&quot;nsdExtInvariantId\&quot; or \&quot;pnfdExtInvariantId\&quot; values.
 * NOTE 2: The attributes \&quot;additionalParamsForNs\&quot;, \&quot;
 * additionalParamsForVnf\&quot;, \&quot;additionalParamsForNestedNs\&quot; and
 * \&quot;additionalParamsForSap\&quot; may be specified when the attribute sync
 * is set to true, and additional parameters at NS instance, VNF instance,
 * nested NS instance and SAP level are to be specified, respectively.
 */
@Schema(description = "This type specifies a new NSD version that is associated to the NS instance. After issuing the Update NS operation with updateType = \"AssocNewNsdVersion\", the NFVO shall use the referred NSD as a basis for the given NS instance. Different versions of the same NSD have same nsdInvariantId, but different nsdId attributes, therefore if the nsdInvariantId of the NSD version that is to be associated to this NS instance is different from the one used before, the NFVO shall reject the request. Only new versions of the same NSD can be associated to an existing NS instance. This data type shall comply with the provisions defined in Table 6.5.3.34-1. NOTE 1: The replacement of VNF instances, nested NS instances or PNF instances by instances whose descriptor is         referenced by the new NSD is applicable even if the instance with a descriptor not referenced from the new         NSD has the same \"vnfdExtInvariantId\", \"nsdExtInvariantId\" or \"pnfdExtInvariantId\" as the new one, i.e. the         synchronization procedure is based on descriptor identities of NSD constituents, and does not consider         \"vnfdExtInvariantId\", \"nsdExtInvariantId\" or \"pnfdExtInvariantId\" values. NOTE 2: The attributes \"additionalParamsForNs\", \" additionalParamsForVnf\", \"additionalParamsForNestedNs\" and         \"additionalParamsForSap\" may be specified when the attribute sync is set to true, and additional parameters         at NS instance, VNF instance, nested NS instance and SAP level are to be specified, respectively. ")
@Validated

public class AssocNewNsdVersionData {
	@JsonProperty("newNsdId")
	private String newNsdId = null;

	@JsonProperty("sync")
	private Boolean sync = null;

	@JsonProperty("additionalParamsForNs")
	private Map<String, String> additionalParamsForNs = null;

	@JsonProperty("additionalParamsForVNf")
	@Valid
	private List<ParamsForVnf> additionalParamsForVNf = null;

	@JsonProperty("additionalParamsForNestedNs")
	@Valid
	private List<ParamsForNestedNs> additionalParamsForNestedNs = null;

	@JsonProperty("additionalParamsForSAP")
	@Valid
	private List<SapData> additionalParamsForSAP = null;

	public AssocNewNsdVersionData newNsdId(final String newNsdId) {
		this.newNsdId = newNsdId;
		return this;
	}

	/**
	 * Get newNsdId
	 *
	 * @return newNsdId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	public String getNewNsdId() {
		return newNsdId;
	}

	public void setNewNsdId(final String newNsdId) {
		this.newNsdId = newNsdId;
	}

	public AssocNewNsdVersionData sync(final Boolean sync) {
		this.sync = sync;
		return this;
	}

	/**
	 * Specify whether the NS instance shall be automatically synchronized to the
	 * new NSD by the NFVO (in case of true value) or the NFVO shall not do any
	 * action (in case of a false value) and wait for further guidance from OSS/BSS
	 * (i.e. waiting for OSS/BSS to issue NS lifecycle management operation to
	 * explicitly add/remove VNFs and modify information of VNF instances according
	 * to the new NSD). The synchronization to the new NSD means -
	 * instantiating/adding those VNFs whose VNFD is referenced by the new NSD
	 * version but not referenced by the old one, - terminating/removing those VNFs
	 * whose VNFD is referenced by the old NSD version but not referenced by the new
	 * NSD version, - adding those VLs whose VLD is referenced by the new NSD
	 * version but not referenced by the old NSD version, - removing those VLs whose
	 * VLD is referenced by the old NSD version but not referenced by the new NSD
	 * version, - adding those nested NSs whose NSD is referenced by the new NSD
	 * version but not reference by the old NSD version, - removing those nested NSs
	 * whose NSD is referenced by the old NSD version, but not referenced by the new
	 * NSD version, - adding those SAPs whose SAPD is referenced by the new NSD
	 * version but not referenced by the old NSD version, - removing those SAPs
	 * whose SAPD is referenced by the old NSD version but not referenced by the new
	 * NSD version, - modifying information of VNF instances to the new applicable
	 * VNFD provided in the new NSD version. See note 1. - etc. A cardinality of 0
	 * indicates that synchronization shall not be done by the NFVO. See note 2.
	 *
	 * @return sync
	 **/
	@Schema(description = "Specify whether the NS instance shall be automatically synchronized to the new NSD by the NFVO (in case of true value) or the NFVO shall not do any action (in case of a false value) and wait for further guidance from OSS/BSS (i.e. waiting for OSS/BSS to issue NS lifecycle management operation to explicitly add/remove VNFs and modify information of VNF instances according to the new NSD). The synchronization to the new NSD means   - instantiating/adding those VNFs whose VNFD is   referenced by the new NSD version but not   referenced by the old one,   - terminating/removing those VNFs whose VNFD   is referenced by the old NSD version but not   referenced by the new NSD version,   - adding those VLs whose VLD is referenced by   the new NSD version but not referenced by the   old NSD version,   - removing those VLs whose VLD is referenced by   the old NSD version but not referenced by the   new NSD version,   - adding those nested NSs whose NSD is   referenced by the new NSD version but not   reference by the old NSD version,   - removing those nested NSs whose NSD is   referenced by the old NSD version, but not   referenced by the new NSD version,   - adding those SAPs whose SAPD is referenced   by the new NSD version but not referenced by   the old NSD version,   - removing those SAPs whose SAPD is referenced   by the old NSD version but not referenced by the   new NSD version,   - modifying information of VNF instances to the   new applicable VNFD provided in the new NSD   version. See note 1.   - etc. A cardinality of 0 indicates that synchronization shall not be done by the NFVO. See note 2. ")

	public Boolean isSync() {
		return sync;
	}

	public void setSync(final Boolean sync) {
		this.sync = sync;
	}

	public AssocNewNsdVersionData additionalParamsForNs(final Map<String, String> additionalParamsForNs) {
		this.additionalParamsForNs = additionalParamsForNs;
		return this;
	}

	/**
	 * Get additionalParamsForNs
	 *
	 * @return additionalParamsForNs
	 **/
	@Schema(description = "")

	@Valid
	public Map<String, String> getAdditionalParamsForNs() {
		return additionalParamsForNs;
	}

	public void setAdditionalParamsForNs(final Map<String, String> additionalParamsForNs) {
		this.additionalParamsForNs = additionalParamsForNs;
	}

	public AssocNewNsdVersionData additionalParamsForVNf(final List<ParamsForVnf> additionalParamsForVNf) {
		this.additionalParamsForVNf = additionalParamsForVNf;
		return this;
	}

	public AssocNewNsdVersionData addAdditionalParamsForVNfItem(final ParamsForVnf additionalParamsForVNfItem) {
		if (this.additionalParamsForVNf == null) {
			this.additionalParamsForVNf = new ArrayList<>();
		}
		this.additionalParamsForVNf.add(additionalParamsForVNfItem);
		return this;
	}

	/**
	 * Provides additional parameter(s) per VNF instance necessary to associate the
	 * new NSD version (as opposed to the composite NS level, which is covered in
	 * additionalParamsforNs, and as opposed to the nested NS level, which is
	 * covered in additionalParamsForNestedNs). See note 2.
	 *
	 * @return additionalParamsForVNf
	 **/
	@Schema(description = "Provides additional parameter(s) per VNF instance necessary to associate the new NSD version (as opposed to the composite NS level, which is covered in additionalParamsforNs, and as opposed to the nested NS level, which is covered in additionalParamsForNestedNs). See note 2. ")
	@Valid
	public List<ParamsForVnf> getAdditionalParamsForVNf() {
		return additionalParamsForVNf;
	}

	public void setAdditionalParamsForVNf(final List<ParamsForVnf> additionalParamsForVNf) {
		this.additionalParamsForVNf = additionalParamsForVNf;
	}

	public AssocNewNsdVersionData additionalParamsForNestedNs(final List<ParamsForNestedNs> additionalParamsForNestedNs) {
		this.additionalParamsForNestedNs = additionalParamsForNestedNs;
		return this;
	}

	public AssocNewNsdVersionData addAdditionalParamsForNestedNsItem(final ParamsForNestedNs additionalParamsForNestedNsItem) {
		if (this.additionalParamsForNestedNs == null) {
			this.additionalParamsForNestedNs = new ArrayList<>();
		}
		this.additionalParamsForNestedNs.add(additionalParamsForNestedNsItem);
		return this;
	}

	/**
	 * Provides additional parameter(s) per nested NS instance (as opposed to the
	 * composite NS level, which is covered in additionalParamsForNs, as opposed to
	 * the VNF level, which is covered in additionalParamsForVnf). See note 2
	 *
	 * @return additionalParamsForNestedNs
	 **/
	@Schema(description = "Provides additional parameter(s) per nested NS instance (as opposed to the composite NS level, which is covered in additionalParamsForNs, as opposed to the VNF level, which is covered in additionalParamsForVnf). See note 2 ")
	@Valid
	public List<ParamsForNestedNs> getAdditionalParamsForNestedNs() {
		return additionalParamsForNestedNs;
	}

	public void setAdditionalParamsForNestedNs(final List<ParamsForNestedNs> additionalParamsForNestedNs) {
		this.additionalParamsForNestedNs = additionalParamsForNestedNs;
	}

	public AssocNewNsdVersionData additionalParamsForSAP(final List<SapData> additionalParamsForSAP) {
		this.additionalParamsForSAP = additionalParamsForSAP;
		return this;
	}

	public AssocNewNsdVersionData addAdditionalParamsForSAPItem(final SapData additionalParamsForSAPItem) {
		if (this.additionalParamsForSAP == null) {
			this.additionalParamsForSAP = new ArrayList<>();
		}
		this.additionalParamsForSAP.add(additionalParamsForSAPItem);
		return this;
	}

	/**
	 * Provides additional parameter(s) for SAP(s). See note 2.
	 *
	 * @return additionalParamsForSAP
	 **/
	@Schema(description = "Provides additional parameter(s) for SAP(s). See note 2. ")
	@Valid
	public List<SapData> getAdditionalParamsForSAP() {
		return additionalParamsForSAP;
	}

	public void setAdditionalParamsForSAP(final List<SapData> additionalParamsForSAP) {
		this.additionalParamsForSAP = additionalParamsForSAP;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final AssocNewNsdVersionData assocNewNsdVersionData = (AssocNewNsdVersionData) o;
		return Objects.equals(this.newNsdId, assocNewNsdVersionData.newNsdId) &&
				Objects.equals(this.sync, assocNewNsdVersionData.sync) &&
				Objects.equals(this.additionalParamsForNs, assocNewNsdVersionData.additionalParamsForNs) &&
				Objects.equals(this.additionalParamsForVNf, assocNewNsdVersionData.additionalParamsForVNf) &&
				Objects.equals(this.additionalParamsForNestedNs, assocNewNsdVersionData.additionalParamsForNestedNs) &&
				Objects.equals(this.additionalParamsForSAP, assocNewNsdVersionData.additionalParamsForSAP);
	}

	@Override
	public int hashCode() {
		return Objects.hash(newNsdId, sync, additionalParamsForNs, additionalParamsForVNf, additionalParamsForNestedNs, additionalParamsForSAP);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class AssocNewNsdVersionData {\n");

		sb.append("    newNsdId: ").append(toIndentedString(newNsdId)).append("\n");
		sb.append("    sync: ").append(toIndentedString(sync)).append("\n");
		sb.append("    additionalParamsForNs: ").append(toIndentedString(additionalParamsForNs)).append("\n");
		sb.append("    additionalParamsForVNf: ").append(toIndentedString(additionalParamsForVNf)).append("\n");
		sb.append("    additionalParamsForNestedNs: ").append(toIndentedString(additionalParamsForNestedNs)).append("\n");
		sb.append("    additionalParamsForSAP: ").append(toIndentedString(additionalParamsForSAP)).append("\n");
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
