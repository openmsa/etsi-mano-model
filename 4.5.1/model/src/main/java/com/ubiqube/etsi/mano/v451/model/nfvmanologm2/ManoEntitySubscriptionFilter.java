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

/**
 * This type represents subscription filter criteria to match NFV-MANO
 * functional entities and their associated managed objects. It shall comply
 * with the provisions defined in Table 4.3.2.2-1.
 */
@Schema(description = "This type represents subscription filter criteria to match NFV-MANO functional entities and their associated managed objects. It shall comply with the provisions defined in Table 4.3.2.2-1.")
@Validated

public class ManoEntitySubscriptionFilter implements AnyOfManoEntitySubscriptionFilter {
	@JsonProperty("manoEntityId")
	private String manoEntityId = null;

	@JsonProperty("manoServiceIds")
	@Valid
	private List<String> manoServiceIds = null;

	@JsonProperty("manoServiceNames")
	@Valid
	private List<String> manoServiceNames = null;

	@JsonProperty("manoServiceInterfaceIds")
	@Valid
	private List<String> manoServiceInterfaceIds = null;

	@JsonProperty("manoServiceInterfaceNames")
	@Valid
	private List<String> manoServiceInterfaceNames = null;

	@JsonProperty("consumedManoInterfaceIds")
	@Valid
	private List<String> consumedManoInterfaceIds = null;

	@JsonProperty("consumedManoInterfaceNames")
	@Valid
	private List<String> consumedManoInterfaceNames = null;

	public ManoEntitySubscriptionFilter manoEntityId(final String manoEntityId) {
		this.manoEntityId = manoEntityId;
		return this;
	}

	/**
	 * An identifier with the intention of being globally unique.
	 *
	 * @return manoEntityId
	 **/
	@Schema(description = "An identifier with the intention of being globally unique. ")

	public String getManoEntityId() {
		return manoEntityId;
	}

	public void setManoEntityId(final String manoEntityId) {
		this.manoEntityId = manoEntityId;
	}

	public ManoEntitySubscriptionFilter manoServiceIds(final List<String> manoServiceIds) {
		this.manoServiceIds = manoServiceIds;
		return this;
	}

	public ManoEntitySubscriptionFilter addManoServiceIdsItem(final String manoServiceIdsItem) {
		if (this.manoServiceIds == null) {
			this.manoServiceIds = new ArrayList<>();
		}
		this.manoServiceIds.add(manoServiceIdsItem);
		return this;
	}

	/**
	 * If present, match NFV-MANO services with an instance identifier listed in
	 * this attribute.
	 *
	 * @return manoServiceIds
	 **/
	@Schema(description = "If present, match NFV-MANO services with an instance identifier listed in this attribute.")

	public List<String> getManoServiceIds() {
		return manoServiceIds;
	}

	public void setManoServiceIds(final List<String> manoServiceIds) {
		this.manoServiceIds = manoServiceIds;
	}

	public ManoEntitySubscriptionFilter manoServiceNames(final List<String> manoServiceNames) {
		this.manoServiceNames = manoServiceNames;
		return this;
	}

	public ManoEntitySubscriptionFilter addManoServiceNamesItem(final String manoServiceNamesItem) {
		if (this.manoServiceNames == null) {
			this.manoServiceNames = new ArrayList<>();
		}
		this.manoServiceNames.add(manoServiceNamesItem);
		return this;
	}

	/**
	 * If present, match NFV-MANO services with an NFV-MANO service name listed in
	 * this attribute.
	 *
	 * @return manoServiceNames
	 **/
	@Schema(description = "If present, match NFV-MANO services with an NFV-MANO service name listed in this attribute.")

	public List<String> getManoServiceNames() {
		return manoServiceNames;
	}

	public void setManoServiceNames(final List<String> manoServiceNames) {
		this.manoServiceNames = manoServiceNames;
	}

	public ManoEntitySubscriptionFilter manoServiceInterfaceIds(final List<String> manoServiceInterfaceIds) {
		this.manoServiceInterfaceIds = manoServiceInterfaceIds;
		return this;
	}

	public ManoEntitySubscriptionFilter addManoServiceInterfaceIdsItem(final String manoServiceInterfaceIdsItem) {
		if (this.manoServiceInterfaceIds == null) {
			this.manoServiceInterfaceIds = new ArrayList<>();
		}
		this.manoServiceInterfaceIds.add(manoServiceInterfaceIdsItem);
		return this;
	}

	/**
	 * If present, match NFV-MANO functional entity produced interfaces with an
	 * instance identifier listed in this attribute.
	 *
	 * @return manoServiceInterfaceIds
	 **/
	@Schema(description = "If present, match NFV-MANO functional entity produced interfaces with an instance identifier listed in this attribute.")

	public List<String> getManoServiceInterfaceIds() {
		return manoServiceInterfaceIds;
	}

	public void setManoServiceInterfaceIds(final List<String> manoServiceInterfaceIds) {
		this.manoServiceInterfaceIds = manoServiceInterfaceIds;
	}

	public ManoEntitySubscriptionFilter manoServiceInterfaceNames(final List<String> manoServiceInterfaceNames) {
		this.manoServiceInterfaceNames = manoServiceInterfaceNames;
		return this;
	}

	public ManoEntitySubscriptionFilter addManoServiceInterfaceNamesItem(final String manoServiceInterfaceNamesItem) {
		if (this.manoServiceInterfaceNames == null) {
			this.manoServiceInterfaceNames = new ArrayList<>();
		}
		this.manoServiceInterfaceNames.add(manoServiceInterfaceNamesItem);
		return this;
	}

	/**
	 * If present, match NFV-MANO functional entity produced interfaces with an
	 * instance Name listed in this attribute.
	 *
	 * @return manoServiceInterfaceNames
	 **/
	@Schema(description = "If present, match NFV-MANO functional entity produced interfaces with an instance Name listed in this attribute.")

	public List<String> getManoServiceInterfaceNames() {
		return manoServiceInterfaceNames;
	}

	public void setManoServiceInterfaceNames(final List<String> manoServiceInterfaceNames) {
		this.manoServiceInterfaceNames = manoServiceInterfaceNames;
	}

	public ManoEntitySubscriptionFilter consumedManoInterfaceIds(final List<String> consumedManoInterfaceIds) {
		this.consumedManoInterfaceIds = consumedManoInterfaceIds;
		return this;
	}

	public ManoEntitySubscriptionFilter addConsumedManoInterfaceIdsItem(final String consumedManoInterfaceIdsItem) {
		if (this.consumedManoInterfaceIds == null) {
			this.consumedManoInterfaceIds = new ArrayList<>();
		}
		this.consumedManoInterfaceIds.add(consumedManoInterfaceIdsItem);
		return this;
	}

	/**
	 * If present, match NFV-MANO functional entity consumed interfaces with an
	 * instance identifier listed in this attribute.
	 *
	 * @return consumedManoInterfaceIds
	 **/
	@Schema(description = "If present, match NFV-MANO functional entity consumed interfaces with an instance identifier listed in this attribute.")

	public List<String> getConsumedManoInterfaceIds() {
		return consumedManoInterfaceIds;
	}

	public void setConsumedManoInterfaceIds(final List<String> consumedManoInterfaceIds) {
		this.consumedManoInterfaceIds = consumedManoInterfaceIds;
	}

	public ManoEntitySubscriptionFilter consumedManoInterfaceNames(final List<String> consumedManoInterfaceNames) {
		this.consumedManoInterfaceNames = consumedManoInterfaceNames;
		return this;
	}

	public ManoEntitySubscriptionFilter addConsumedManoInterfaceNamesItem(final String consumedManoInterfaceNamesItem) {
		if (this.consumedManoInterfaceNames == null) {
			this.consumedManoInterfaceNames = new ArrayList<>();
		}
		this.consumedManoInterfaceNames.add(consumedManoInterfaceNamesItem);
		return this;
	}

	/**
	 * If present, match NFV-MANO functional entity consumed interfaces with an
	 * instance Name listed in this attribute.
	 *
	 * @return consumedManoInterfaceNames
	 **/
	@Schema(description = "If present, match NFV-MANO functional entity consumed interfaces with an instance Name listed in this attribute.")

	public List<String> getConsumedManoInterfaceNames() {
		return consumedManoInterfaceNames;
	}

	public void setConsumedManoInterfaceNames(final List<String> consumedManoInterfaceNames) {
		this.consumedManoInterfaceNames = consumedManoInterfaceNames;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final ManoEntitySubscriptionFilter manoEntitySubscriptionFilter = (ManoEntitySubscriptionFilter) o;
		return Objects.equals(this.manoEntityId, manoEntitySubscriptionFilter.manoEntityId) &&
				Objects.equals(this.manoServiceIds, manoEntitySubscriptionFilter.manoServiceIds) &&
				Objects.equals(this.manoServiceNames, manoEntitySubscriptionFilter.manoServiceNames) &&
				Objects.equals(this.manoServiceInterfaceIds, manoEntitySubscriptionFilter.manoServiceInterfaceIds) &&
				Objects.equals(this.manoServiceInterfaceNames, manoEntitySubscriptionFilter.manoServiceInterfaceNames) &&
				Objects.equals(this.consumedManoInterfaceIds, manoEntitySubscriptionFilter.consumedManoInterfaceIds) &&
				Objects.equals(this.consumedManoInterfaceNames, manoEntitySubscriptionFilter.consumedManoInterfaceNames);
	}

	@Override
	public int hashCode() {
		return Objects.hash(manoEntityId, manoServiceIds, manoServiceNames, manoServiceInterfaceIds, manoServiceInterfaceNames, consumedManoInterfaceIds, consumedManoInterfaceNames);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class ManoEntitySubscriptionFilter {\n");

		sb.append("    manoEntityId: ").append(toIndentedString(manoEntityId)).append("\n");
		sb.append("    manoServiceIds: ").append(toIndentedString(manoServiceIds)).append("\n");
		sb.append("    manoServiceNames: ").append(toIndentedString(manoServiceNames)).append("\n");
		sb.append("    manoServiceInterfaceIds: ").append(toIndentedString(manoServiceInterfaceIds)).append("\n");
		sb.append("    manoServiceInterfaceNames: ").append(toIndentedString(manoServiceInterfaceNames)).append("\n");
		sb.append("    consumedManoInterfaceIds: ").append(toIndentedString(consumedManoInterfaceIds)).append("\n");
		sb.append("    consumedManoInterfaceNames: ").append(toIndentedString(consumedManoInterfaceNames)).append("\n");
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
