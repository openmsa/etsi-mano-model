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
 *     along with this program.  If not, see https://www.gnu.org/licenses/.
 */
package com.ubiqube.etsi.mano.v451.model.nfvo.nslcm;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * Layer 2 protocol parameters of the connectivity service endpoint (CSE).
 */
@Schema(description = "Layer 2 protocol parameters of the connectivity service endpoint (CSE). ")
@Validated

public class SiteToWanLayer2ProtocolDataLayer2ConnectionInfo {
	/**
	 * The type of connection to be established on the connectivity service point.
	 * Permitted values: - CSE: defined by the characteristics of the existing
	 * referred connectivity service point. - AGGREGATE_CSE: create an aggregation
	 * of the connectivity service endpoints.
	 */
	public enum ConnectionTypeEnum {
		CSE("CSE"),

		AGGREGATE_CSE("AGGREGATE_CSE");

		private final String value;

		ConnectionTypeEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static ConnectionTypeEnum fromValue(final String text) {
			for (final ConnectionTypeEnum b : ConnectionTypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("connectionType")
	private ConnectionTypeEnum connectionType = null;

	/**
	 * To indicate whether to create logical interfaces on the referred connectivity
	 * service endpoint or new aggregated connectivity service endpoint. Permitted
	 * values: - PARENT: use the mapped interface to the connectivity service
	 * endpoint as is, i.e., do not create logical interfaces. - LOGICAL: create
	 * logical interfaces.
	 */
	public enum InterfaceTypeEnum {
		PARENT("PARENT"),

		LOGICAL("LOGICAL");

		private final String value;

		InterfaceTypeEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static InterfaceTypeEnum fromValue(final String text) {
			for (final InterfaceTypeEnum b : InterfaceTypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("interfaceType")
	private InterfaceTypeEnum interfaceType = null;

	/**
	 * The type of frames to forward on the connectivity service point. Permitted
	 * values: - UNTAGGED: an interface where frames are not tagged. - TAGGED: an
	 * interface configured to forward tagged frames (i.e., enabled for VLAN
	 * tagging).
	 */
	public enum InterfaceTaggingEnum {
		UNTAGGED("UNTAGGED"),

		TAGGED("TAGGED");

		private final String value;

		InterfaceTaggingEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static InterfaceTaggingEnum fromValue(final String text) {
			for (final InterfaceTaggingEnum b : InterfaceTaggingEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("interfaceTagging")
	private InterfaceTaggingEnum interfaceTagging = null;

	/**
	 * The type of encapsulation. If the interfaceTagging=\"TAGGED\", either
	 * \"VLAN\" or \"VXLAN\" shall be set. Permitted values: - ETH: generic Ethernet
	 * encapsulation. - VLAN: encapsulation based on VLAN. - VXLAN: encapsulation
	 * based on VXLAN.
	 */
	public enum EncapsulationTypeEnum {
		ETH("ETH"),

		VLAN("VLAN"),

		VXLAN("VXLAN");

		private final String value;

		EncapsulationTypeEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static EncapsulationTypeEnum fromValue(final String text) {
			for (final EncapsulationTypeEnum b : EncapsulationTypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("encapsulationType")
	private EncapsulationTypeEnum encapsulationType = null;

	/**
	 * Type of encapsulation method for VLAN tagging. Shall be present if
	 * interfaceTagging=\"TAGGED\" and encapsulationType=\"VLAN\". Permitted values:
	 * - DOT1Q: used when packets on the CSE are encapsulated with one or a set of
	 * customer VLAN identifiers. - QINQ: used when packets on the CSE are
	 * encapsulated with multiple customer VLAN identifiers and a single service
	 * VLAN identifier. - QINANY: used when packets on the CSE have no specific
	 * customer VLAN and a service VLAN identifier is used.
	 */
	public enum VlanTaggingTypeEnum {
		DOT1Q("DOT1Q"),

		QINQ("QINQ"),

		QINANY("QINANY");

		private final String value;

		VlanTaggingTypeEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static VlanTaggingTypeEnum fromValue(final String text) {
			for (final VlanTaggingTypeEnum b : VlanTaggingTypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("vlanTaggingType")
	private VlanTaggingTypeEnum vlanTaggingType = null;

	@JsonProperty("wanSegmentIds")
	private SiteToWanLayer2ProtocolDataLayer2ConnectionInfoWanSegmentIds wanSegmentIds = null;

	@JsonProperty("vxlanConfig")
	private SiteToWanLayer2ProtocolDataLayer2ConnectionInfoVxlanConfig vxlanConfig = null;

	@JsonProperty("lagInterfaceData")
	private SiteToWanLayer2ProtocolDataLayer2ConnectionInfoLagInterfaceData lagInterfaceData = null;

	@JsonProperty("layer2ControlProtocol")
	private Map<String, String> layer2ControlProtocol = null;

	public SiteToWanLayer2ProtocolDataLayer2ConnectionInfo connectionType(final ConnectionTypeEnum connectionType) {
		this.connectionType = connectionType;
		return this;
	}

	/**
	 * The type of connection to be established on the connectivity service point.
	 * Permitted values: - CSE: defined by the characteristics of the existing
	 * referred connectivity service point. - AGGREGATE_CSE: create an aggregation
	 * of the connectivity service endpoints.
	 *
	 * @return connectionType
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "The type of connection to be established on the connectivity service point. Permitted values: - CSE: defined by the characteristics of the existing referred connectivity service point. - AGGREGATE_CSE: create an aggregation of the connectivity service endpoints. ")
	@NotNull

	public ConnectionTypeEnum getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(final ConnectionTypeEnum connectionType) {
		this.connectionType = connectionType;
	}

	public SiteToWanLayer2ProtocolDataLayer2ConnectionInfo interfaceType(final InterfaceTypeEnum interfaceType) {
		this.interfaceType = interfaceType;
		return this;
	}

	/**
	 * To indicate whether to create logical interfaces on the referred connectivity
	 * service endpoint or new aggregated connectivity service endpoint. Permitted
	 * values: - PARENT: use the mapped interface to the connectivity service
	 * endpoint as is, i.e., do not create logical interfaces. - LOGICAL: create
	 * logical interfaces.
	 *
	 * @return interfaceType
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "To indicate whether to create logical interfaces on the referred connectivity service endpoint or new aggregated connectivity service endpoint. Permitted values: - PARENT: use the mapped interface to the connectivity service endpoint as is, i.e., do not create logical interfaces. - LOGICAL: create logical interfaces. ")
	@NotNull

	public InterfaceTypeEnum getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(final InterfaceTypeEnum interfaceType) {
		this.interfaceType = interfaceType;
	}

	public SiteToWanLayer2ProtocolDataLayer2ConnectionInfo interfaceTagging(final InterfaceTaggingEnum interfaceTagging) {
		this.interfaceTagging = interfaceTagging;
		return this;
	}

	/**
	 * The type of frames to forward on the connectivity service point. Permitted
	 * values: - UNTAGGED: an interface where frames are not tagged. - TAGGED: an
	 * interface configured to forward tagged frames (i.e., enabled for VLAN
	 * tagging).
	 *
	 * @return interfaceTagging
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "The type of frames to forward on the connectivity service point. Permitted values: - UNTAGGED: an interface where frames are not tagged. - TAGGED: an interface configured to forward tagged frames (i.e., enabled for VLAN tagging). ")
	@NotNull

	public InterfaceTaggingEnum getInterfaceTagging() {
		return interfaceTagging;
	}

	public void setInterfaceTagging(final InterfaceTaggingEnum interfaceTagging) {
		this.interfaceTagging = interfaceTagging;
	}

	public SiteToWanLayer2ProtocolDataLayer2ConnectionInfo encapsulationType(final EncapsulationTypeEnum encapsulationType) {
		this.encapsulationType = encapsulationType;
		return this;
	}

	/**
	 * The type of encapsulation. If the interfaceTagging=\"TAGGED\", either
	 * \"VLAN\" or \"VXLAN\" shall be set. Permitted values: - ETH: generic Ethernet
	 * encapsulation. - VLAN: encapsulation based on VLAN. - VXLAN: encapsulation
	 * based on VXLAN.
	 *
	 * @return encapsulationType
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "The type of encapsulation. If the interfaceTagging=\"TAGGED\", either \"VLAN\" or \"VXLAN\" shall be set. Permitted values: - ETH: generic Ethernet encapsulation. - VLAN: encapsulation based on VLAN. - VXLAN: encapsulation based on VXLAN. ")
	@NotNull

	public EncapsulationTypeEnum getEncapsulationType() {
		return encapsulationType;
	}

	public void setEncapsulationType(final EncapsulationTypeEnum encapsulationType) {
		this.encapsulationType = encapsulationType;
	}

	public SiteToWanLayer2ProtocolDataLayer2ConnectionInfo vlanTaggingType(final VlanTaggingTypeEnum vlanTaggingType) {
		this.vlanTaggingType = vlanTaggingType;
		return this;
	}

	/**
	 * Type of encapsulation method for VLAN tagging. Shall be present if
	 * interfaceTagging=\"TAGGED\" and encapsulationType=\"VLAN\". Permitted values:
	 * - DOT1Q: used when packets on the CSE are encapsulated with one or a set of
	 * customer VLAN identifiers. - QINQ: used when packets on the CSE are
	 * encapsulated with multiple customer VLAN identifiers and a single service
	 * VLAN identifier. - QINANY: used when packets on the CSE have no specific
	 * customer VLAN and a service VLAN identifier is used.
	 *
	 * @return vlanTaggingType
	 **/
	@Schema(description = "Type of encapsulation method for VLAN tagging. Shall be present if interfaceTagging=\"TAGGED\" and encapsulationType=\"VLAN\". Permitted values: - DOT1Q: used when packets on the CSE are encapsulated with one or a set of customer VLAN identifiers. - QINQ: used when packets on the CSE are encapsulated with multiple customer VLAN identifiers and a single   service VLAN identifier. - QINANY: used when packets on the CSE have no specific customer VLAN and a service VLAN identifier is used. ")

	public VlanTaggingTypeEnum getVlanTaggingType() {
		return vlanTaggingType;
	}

	public void setVlanTaggingType(final VlanTaggingTypeEnum vlanTaggingType) {
		this.vlanTaggingType = vlanTaggingType;
	}

	public SiteToWanLayer2ProtocolDataLayer2ConnectionInfo wanSegmentIds(final SiteToWanLayer2ProtocolDataLayer2ConnectionInfoWanSegmentIds wanSegmentIds) {
		this.wanSegmentIds = wanSegmentIds;
		return this;
	}

	/**
	 * Get wanSegmentIds
	 *
	 * @return wanSegmentIds
	 **/
	@Schema(description = "")

	@Valid
	public SiteToWanLayer2ProtocolDataLayer2ConnectionInfoWanSegmentIds getWanSegmentIds() {
		return wanSegmentIds;
	}

	public void setWanSegmentIds(final SiteToWanLayer2ProtocolDataLayer2ConnectionInfoWanSegmentIds wanSegmentIds) {
		this.wanSegmentIds = wanSegmentIds;
	}

	public SiteToWanLayer2ProtocolDataLayer2ConnectionInfo vxlanConfig(final SiteToWanLayer2ProtocolDataLayer2ConnectionInfoVxlanConfig vxlanConfig) {
		this.vxlanConfig = vxlanConfig;
		return this;
	}

	/**
	 * Get vxlanConfig
	 *
	 * @return vxlanConfig
	 **/
	@Schema(description = "")

	@Valid
	public SiteToWanLayer2ProtocolDataLayer2ConnectionInfoVxlanConfig getVxlanConfig() {
		return vxlanConfig;
	}

	public void setVxlanConfig(final SiteToWanLayer2ProtocolDataLayer2ConnectionInfoVxlanConfig vxlanConfig) {
		this.vxlanConfig = vxlanConfig;
	}

	public SiteToWanLayer2ProtocolDataLayer2ConnectionInfo lagInterfaceData(final SiteToWanLayer2ProtocolDataLayer2ConnectionInfoLagInterfaceData lagInterfaceData) {
		this.lagInterfaceData = lagInterfaceData;
		return this;
	}

	/**
	 * Get lagInterfaceData
	 *
	 * @return lagInterfaceData
	 **/
	@Schema(description = "")

	@Valid
	public SiteToWanLayer2ProtocolDataLayer2ConnectionInfoLagInterfaceData getLagInterfaceData() {
		return lagInterfaceData;
	}

	public void setLagInterfaceData(final SiteToWanLayer2ProtocolDataLayer2ConnectionInfoLagInterfaceData lagInterfaceData) {
		this.lagInterfaceData = lagInterfaceData;
	}

	public SiteToWanLayer2ProtocolDataLayer2ConnectionInfo layer2ControlProtocol(final Map<String, String> layer2ControlProtocol) {
		this.layer2ControlProtocol = layer2ControlProtocol;
		return this;
	}

	/**
	 * Get layer2ControlProtocol
	 *
	 * @return layer2ControlProtocol
	 **/
	@Schema(description = "")

	@Valid
	public Map<String, String> getLayer2ControlProtocol() {
		return layer2ControlProtocol;
	}

	public void setLayer2ControlProtocol(final Map<String, String> layer2ControlProtocol) {
		this.layer2ControlProtocol = layer2ControlProtocol;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final SiteToWanLayer2ProtocolDataLayer2ConnectionInfo siteToWanLayer2ProtocolDataLayer2ConnectionInfo = (SiteToWanLayer2ProtocolDataLayer2ConnectionInfo) o;
		return Objects.equals(this.connectionType, siteToWanLayer2ProtocolDataLayer2ConnectionInfo.connectionType) &&
				Objects.equals(this.interfaceType, siteToWanLayer2ProtocolDataLayer2ConnectionInfo.interfaceType) &&
				Objects.equals(this.interfaceTagging, siteToWanLayer2ProtocolDataLayer2ConnectionInfo.interfaceTagging) &&
				Objects.equals(this.encapsulationType, siteToWanLayer2ProtocolDataLayer2ConnectionInfo.encapsulationType) &&
				Objects.equals(this.vlanTaggingType, siteToWanLayer2ProtocolDataLayer2ConnectionInfo.vlanTaggingType) &&
				Objects.equals(this.wanSegmentIds, siteToWanLayer2ProtocolDataLayer2ConnectionInfo.wanSegmentIds) &&
				Objects.equals(this.vxlanConfig, siteToWanLayer2ProtocolDataLayer2ConnectionInfo.vxlanConfig) &&
				Objects.equals(this.lagInterfaceData, siteToWanLayer2ProtocolDataLayer2ConnectionInfo.lagInterfaceData) &&
				Objects.equals(this.layer2ControlProtocol, siteToWanLayer2ProtocolDataLayer2ConnectionInfo.layer2ControlProtocol);
	}

	@Override
	public int hashCode() {
		return Objects.hash(connectionType, interfaceType, interfaceTagging, encapsulationType, vlanTaggingType, wanSegmentIds, vxlanConfig, lagInterfaceData, layer2ControlProtocol);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class SiteToWanLayer2ProtocolDataLayer2ConnectionInfo {\n");

		sb.append("    connectionType: ").append(toIndentedString(connectionType)).append("\n");
		sb.append("    interfaceType: ").append(toIndentedString(interfaceType)).append("\n");
		sb.append("    interfaceTagging: ").append(toIndentedString(interfaceTagging)).append("\n");
		sb.append("    encapsulationType: ").append(toIndentedString(encapsulationType)).append("\n");
		sb.append("    vlanTaggingType: ").append(toIndentedString(vlanTaggingType)).append("\n");
		sb.append("    wanSegmentIds: ").append(toIndentedString(wanSegmentIds)).append("\n");
		sb.append("    vxlanConfig: ").append(toIndentedString(vxlanConfig)).append("\n");
		sb.append("    lagInterfaceData: ").append(toIndentedString(lagInterfaceData)).append("\n");
		sb.append("    layer2ControlProtocol: ").append(toIndentedString(layer2ControlProtocol)).append("\n");
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
