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
package com.ubiqube.etsi.mano.v261.model.nfvo.lcmgrant;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.annotation.Nonnull;

/**
 * This type references a resource either by its VIM-level identifier for
 * existing resources, or by the identifier of a
 * \&quot;ResourceDefinition\&quot; structure in the \&quot;GrantRequest\&quot;
 * structure for new resources.
 */
@Schema(description = "This type references a resource either by its VIM-level identifier for existing resources, or by the identifier of a \"ResourceDefinition\" structure in the \"GrantRequest\" structure for new resources. ")
@Validated

public class ConstraintResourceRef {
	/**
	 * The type of the identifier. Permitted values: * RES_MGMT:
	 * Resource-management-level identifier; this identifier is managed by the VIM
	 * in the direct mode of VNF-related resource management, and is managed by the
	 * NFVO in the indirect mode) * GRANT: Reference to the identifier of a
	 * \"ResourceDefinition\" structure in the \"GrantRequest\" structure.
	 */
	public enum IdTypeEnum {
		RES_MGMT("RES_MGMT"),

		GRANT("GRANT");

		private final String value;

		IdTypeEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static IdTypeEnum fromValue(final String text) {
			for (final IdTypeEnum b : IdTypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("idType")
	private IdTypeEnum idType = null;

	@JsonProperty("resourceId")
	private String resourceId = null;

	@JsonProperty("vimConnectionId")
	private String vimConnectionId = null;

	@JsonProperty("resourceProviderId")
	private String resourceProviderId = null;

	public ConstraintResourceRef idType(final IdTypeEnum idType) {
		this.idType = idType;
		return this;
	}

	/**
	 * The type of the identifier. Permitted values: * RES_MGMT:
	 * Resource-management-level identifier; this identifier is managed by the VIM
	 * in the direct mode of VNF-related resource management, and is managed by the
	 * NFVO in the indirect mode) * GRANT: Reference to the identifier of a
	 * \"ResourceDefinition\" structure in the \"GrantRequest\" structure.
	 *
	 * @return idType
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "The type of the identifier. Permitted values: * RES_MGMT: Resource-management-level identifier; this identifier is   managed by the VIM in the direct mode of VNF-related resource   management, and is managed by the NFVO in the indirect mode) * GRANT: Reference to the identifier of a \"ResourceDefinition\" structure in the \"GrantRequest\" structure. ")
	@Nonnull

	public IdTypeEnum getIdType() {
		return idType;
	}

	public void setIdType(final IdTypeEnum idType) {
		this.idType = idType;
	}

	public ConstraintResourceRef resourceId(final String resourceId) {
		this.resourceId = resourceId;
		return this;
	}

	/**
	 * An actual resource-management-level identifier (idType=RES_MGMT), or an
	 * identifier that references a \"ResourceDefinition\" structure in the related
	 * \"GrantRequest\" structure (idType=GRANT).
	 *
	 * @return resourceId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "An actual resource-management-level identifier (idType=RES_MGMT), or an identifier that references a \"ResourceDefinition\" structure in the related \"GrantRequest\" structure (idType=GRANT). ")
	@Nonnull

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(final String resourceId) {
		this.resourceId = resourceId;
	}

	public ConstraintResourceRef vimConnectionId(final String vimConnectionId) {
		this.vimConnectionId = vimConnectionId;
		return this;
	}

	/**
	 * Identifier of the VIM connection for managing the resource. It shall only be
	 * present when idType = RES_MGMT. The applicable \"VimConnectionInfo\"
	 * structure, which is referenced by vimConnectionId, can be obtained from the
	 * \"vimConnectionInfo\" attribute of the \"VnfInstance\" structure. This
	 * attribute shall only be supported when VNF-related resource management in
	 * direct mode is applicable.
	 *
	 * @return vimConnectionId
	 **/
	@Schema(description = "Identifier of the VIM connection for managing the resource. It shall only be present when idType = RES_MGMT. The applicable \"VimConnectionInfo\" structure, which is referenced by vimConnectionId, can be obtained from the \"vimConnectionInfo\" attribute of the \"VnfInstance\" structure. This attribute shall only be supported when VNF-related resource management in direct mode is applicable. ")

	public String getVimConnectionId() {
		return vimConnectionId;
	}

	public void setVimConnectionId(final String vimConnectionId) {
		this.vimConnectionId = vimConnectionId;
	}

	public ConstraintResourceRef resourceProviderId(final String resourceProviderId) {
		this.resourceProviderId = resourceProviderId;
		return this;
	}

	/**
	 * Identifier of the resource provider. It shall only be present when idType =
	 * RES_MGMT. This attribute shall only be supported when VNF-related resource
	 * management in indirect mode is applicable. The identification scheme is
	 * outside the scope of the present document.
	 *
	 * @return resourceProviderId
	 **/
	@Schema(description = "Identifier of the resource provider. It shall only be present when idType = RES_MGMT. This attribute shall only be supported when VNF-related resource management in indirect mode is applicable. The identification scheme is outside the scope of the present document. ")

	public String getResourceProviderId() {
		return resourceProviderId;
	}

	public void setResourceProviderId(final String resourceProviderId) {
		this.resourceProviderId = resourceProviderId;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final ConstraintResourceRef constraintResourceRef = (ConstraintResourceRef) o;
		return Objects.equals(this.idType, constraintResourceRef.idType) &&
				Objects.equals(this.resourceId, constraintResourceRef.resourceId) &&
				Objects.equals(this.vimConnectionId, constraintResourceRef.vimConnectionId) &&
				Objects.equals(this.resourceProviderId, constraintResourceRef.resourceProviderId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idType, resourceId, vimConnectionId, resourceProviderId);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class ConstraintResourceRef {\n");

		sb.append("    idType: ").append(toIndentedString(idType)).append("\n");
		sb.append("    resourceId: ").append(toIndentedString(resourceId)).append("\n");
		sb.append("    vimConnectionId: ").append(toIndentedString(vimConnectionId)).append("\n");
		sb.append("    resourceProviderId: ").append(toIndentedString(resourceProviderId)).append("\n");
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
