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
package com.ubiqube.etsi.mano.v271.model.vnfm.vnflcm;

import java.util.Map;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

/**
 * This type represents parameters to connect to a VIM for managing the
 * resources of a VNF instance. This structure is used to convey VIM-related
 * parameters over the Or-Vnfm interface. Additional parameters for a VIM may be
 * configured into the VNFM by means outside the scope of the present document,
 * and bound to the identifier of that VIM.
 */
@Schema (description= "This type represents parameters to connect to a VIM for managing the resources of a VNF instance. This structure is used to convey VIM-related parameters over the Or-Vnfm interface. Additional parameters for a VIM may be configured into the VNFM by means outside the scope of the present document, and bound to the identifier of that VIM. " )
@Validated

public class VimConnectionInfo {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("vimId")
	private String vimId = null;

	@JsonProperty("vimType")
	private String vimType = null;

	@JsonProperty("interfaceInfo")
	private Map<String, String> interfaceInfo = null;

	@JsonProperty("accessInfo")
	private Map<String, String> accessInfo = null;

	@JsonProperty("extra")
	private Map<String, String> extra = null;

	public VimConnectionInfo id(final String id) {
		this.id = id;
		return this;
	}

	/**
	 * The identifier of the VIM Connection. This identifier is managed by the NFVO.
	 *
	 * @return id
	 **/
	@Schema(required = true , description = "The identifier of the VIM Connection. This identifier is managed by the NFVO. ")
	@NotNull

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public VimConnectionInfo vimId(final String vimId) {
		this.vimId = vimId;
		return this;
	}

	/**
	 * The identifier of the VIM instance. This identifier is managed by the NFVO.
	 * Shall be present to address additional information about the VIM if such
	 * information has been configured into the VNFM by means outside the scope of
	 * the present document, and should be absent otherwise.
	 *
	 * @return vimId
	 **/
	@Schema(description = "The identifier of the VIM instance. This identifier is managed by the NFVO. Shall be present to address additional information about the VIM if such information has been configured into the VNFM by means outside the scope of the present document, and should be absent otherwise. ")

	public String getVimId() {
		return vimId;
	}

	public void setVimId(final String vimId) {
		this.vimId = vimId;
	}

	public VimConnectionInfo vimType(final String vimType) {
		this.vimType = vimType;
		return this;
	}

	/**
	 * Discriminator for the different types of the VIM information. The value of
	 * this attribute determines the structure of the \"interfaceInfo\" and
	 * \"accessInfo\" attributes, based on the type of the VIM. The set of permitted
	 * values is expected to change over time as new types or versions of VIMs
	 * become available. The ETSI NFV registry of VIM-related information provides
	 * access to information about VimConnectionInfo definitions for various VIM
	 * types. The structure of the registry is defined in Annex C of SOL003.
	 *
	 * @return vimType
	 **/
	@Schema(required = true , description = "Discriminator for the different types of the VIM information. The value of this attribute determines the structure of the \"interfaceInfo\" and \"accessInfo\" attributes, based on the type of the VIM. The set of permitted values is expected to change over time as new types or versions of VIMs become available. The ETSI NFV registry of VIM-related information provides access to information about VimConnectionInfo definitions for various VIM types. The structure of the registry is defined in Annex C of SOL003. ")
	@NotNull

	public String getVimType() {
		return vimType;
	}

	public void setVimType(final String vimType) {
		this.vimType = vimType;
	}

	public VimConnectionInfo interfaceInfo(final Map<String, String> interfaceInfo) {
		this.interfaceInfo = interfaceInfo;
		return this;
	}

	/**
	 * Information about the interface or interfaces to the VIM, if applicable, such
	 * as the URI of an interface endpoint to communicate with the VIM. The
	 * applicable keys are dependent on the content of vimType. Alternatively, such
	 * information may have been configured into the VNFM and bound to the vimId.
	 *
	 * @return interfaceInfo
	 **/
	@Schema(description = "Information about the interface or interfaces to the VIM, if applicable, such as the URI of an interface endpoint to communicate with the VIM. The applicable keys are dependent on the content of vimType. Alternatively, such information may have been configured into the VNFM and bound to the vimId. ")

	@Valid

	public Map<String, String> getInterfaceInfo() {
		return interfaceInfo;
	}

	public void setInterfaceInfo(final Map<String, String> interfaceInfo) {
		this.interfaceInfo = interfaceInfo;
	}

	public VimConnectionInfo accessInfo(final Map<String, String> accessInfo) {
		this.accessInfo = accessInfo;
		return this;
	}

	/**
	 * Authentication credentials for accessing the VIM, and other access-related
	 * information such as tenants or infrastructure resource groups (see note). The
	 * applicable keys are dependent on the content of vimType. If the
	 * VimConnectionInfo structure is part of an HTTP response payload body,
	 * sensitive attributes that are children of this attributes (such as passwords)
	 * shall not be included. If the VimConnectionInfo structure is part of an HTTP
	 * request payload body, sensitive attributes that are children of this
	 * attribute (such as passwords) shall be present if they have not been
	 * provisioned out of band. If applicable, this attribute also provides
	 * information about the resourceGroupIds that are accessible using a particular
	 * set of credentials. See definition of \"resourceGroupId\" in clause 9.5.3.3.
	 * Once the connectivity between VNFM and VIM is provided through a secure
	 * connection over HTTP Secure (HTTP over SSL/TLS), and the connection might
	 * also be established through a VPN (for example TLS-based VPN tunnelling) for
	 * site-to-site connection, the \"accessInfo\" JSON data structure, and the
	 * sensitive data related information (\"username\"/\"password\" as required
	 * properties for authentication purpose), will be transmitted as plain text
	 * through a TLS tunnel without additional encoding/encryption before
	 * transmitting it, making the sensitive data visible to the endpoint. The
	 * base64 encoded certificates are only used by the VNFM to verify the
	 * authenticity of the interface endpoint of the VIM.
	 *
	 * @return accessInfo
	 **/
	@Schema(description = "Authentication credentials for accessing the VIM, and other access-related information such as tenants or infrastructure resource groups (see note). The applicable keys are dependent on the content of vimType. If the VimConnectionInfo structure is part of an HTTP response payload body, sensitive attributes that are children of this attributes (such as passwords) shall not be included. If the VimConnectionInfo structure is part of an HTTP request payload body, sensitive attributes that are children of this attribute (such as passwords) shall be present if they have not been provisioned out of band. If applicable, this attribute also provides information about the resourceGroupIds that are accessible using a particular set of credentials. See definition of \"resourceGroupId\" in clause 9.5.3.3. Once the connectivity between VNFM and VIM is provided through a secure connection over HTTP Secure (HTTP over SSL/TLS), and the connection might also be established through a VPN (for example TLS-based VPN tunnelling) for site-to-site connection, the \"accessInfo\" JSON data structure, and the sensitive data related information (\"username\"/\"password\" as required properties for authentication purpose), will be transmitted as plain text through a TLS tunnel without additional encoding/encryption before transmitting it, making the sensitive data visible to the endpoint. The base64 encoded certificates are only used by the VNFM to verify the authenticity of the interface endpoint of the VIM. ")

	@Valid

	public Map<String, String> getAccessInfo() {
		return accessInfo;
	}

	public void setAccessInfo(final Map<String, String> accessInfo) {
		this.accessInfo = accessInfo;
	}

	public VimConnectionInfo extra(final Map<String, String> extra) {
		this.extra = extra;
		return this;
	}

	/**
	 * VIM type specific additional information. The applicable structure, and
	 * whether or not this attribute is available, is dependent on the content of
	 * vimType.
	 *
	 * @return extra
	 **/
	@Schema(description = "VIM type specific additional information. The applicable structure, and whether or not this attribute is available, is dependent on the content of vimType. ")

	@Valid

	public Map<String, String> getExtra() {
		return extra;
	}

	public void setExtra(final Map<String, String> extra) {
		this.extra = extra;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final VimConnectionInfo vimConnectionInfo = (VimConnectionInfo) o;
		return Objects.equals(this.id, vimConnectionInfo.id) &&
		Objects.equals(this.vimId, vimConnectionInfo.vimId) &&
		Objects.equals(this.vimType, vimConnectionInfo.vimType) &&
		Objects.equals(this.interfaceInfo, vimConnectionInfo.interfaceInfo) &&
		Objects.equals(this.accessInfo, vimConnectionInfo.accessInfo) &&
		Objects.equals(this.extra, vimConnectionInfo.extra);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, vimId, vimType, interfaceInfo, accessInfo, extra);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class VimConnectionInfo {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    vimId: ").append(toIndentedString(vimId)).append("\n");
		sb.append("    vimType: ").append(toIndentedString(vimType)).append("\n");
		sb.append("    interfaceInfo: ").append(toIndentedString(interfaceInfo)).append("\n");
		sb.append("    accessInfo: ").append(toIndentedString(accessInfo)).append("\n");
		sb.append("    extra: ").append(toIndentedString(extra)).append("\n");
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
