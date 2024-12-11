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
package com.ubiqube.etsi.mano.v451.model.nfvmanologm2;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotNull;

/**
 * This type represents the identifier to reference a managed object of a
 * particular type.
 */
@Schema(description = "This type represents the identifier to reference a managed object of a  particular type.  ")
@Validated

public class ManoManagedObjectReference {
	/**
	 * Indicates the type of managed object. Permitted values: - MANO_ENTITY -
	 * MANO_SERVICE - MANO_SERVICE_IF - CONSUMED_MANO_IF - MANO_ENTITY_COMPONENT The
	 * \"MANO_ENTITY COMPONENT\" is only applicable if attribute
	 * \"manoEntityComponents\" in \"ManoEntity\" is supported by the API producer.
	 */
	public enum TypeEnum {
		MANO_ENTITY("MANO_ENTITY"),

		MANO_SERVICE("MANO_SERVICE"),

		MANO_SERVICE_IF("MANO_SERVICE_IF"),

		CONSUMED_MANO_IF("CONSUMED_MANO_IF"),

		MANO_ENTITY_COMPONENT("MANO_ENTITY_COMPONENT");

		private final String value;

		TypeEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static TypeEnum fromValue(final String text) {
			for (final TypeEnum b : TypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("type")
	private TypeEnum type = null;

	@JsonProperty("objectId")
	private String objectId = null;

	@JsonProperty("subObjectId")
	private String subObjectId = null;

	public ManoManagedObjectReference type(final TypeEnum type) {
		this.type = type;
		return this;
	}

	/**
	 * Indicates the type of managed object. Permitted values: - MANO_ENTITY -
	 * MANO_SERVICE - MANO_SERVICE_IF - CONSUMED_MANO_IF - MANO_ENTITY_COMPONENT The
	 * \"MANO_ENTITY COMPONENT\" is only applicable if attribute
	 * \"manoEntityComponents\" in \"ManoEntity\" is supported by the API producer.
	 *
	 * @return type
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Indicates the type of managed object. Permitted values:   - MANO_ENTITY   - MANO_SERVICE   - MANO_SERVICE_IF   - CONSUMED_MANO_IF   - MANO_ENTITY_COMPONENT  The \"MANO_ENTITY COMPONENT\" is only applicable if attribute \"manoEntityComponents\" in \"ManoEntity\" is supported by the API producer. ")
	@NotNull

	public TypeEnum getType() {
		return type;
	}

	public void setType(final TypeEnum type) {
		this.type = type;
	}

	public ManoManagedObjectReference objectId(final String objectId) {
		this.objectId = objectId;
		return this;
	}

	/**
	 * An identifier with the intention of being globally unique.
	 *
	 * @return objectId
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "An identifier with the intention of being globally unique. ")
	@NotNull

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(final String objectId) {
		this.objectId = objectId;
	}

	public ManoManagedObjectReference subObjectId(final String subObjectId) {
		this.subObjectId = subObjectId;
		return this;
	}

	/**
	 * An identifier that is unique for the respective type within a NFV-MANO
	 * functional entity, but that need not be globally unique. Representation:
	 * string of variable length..
	 *
	 * @return subObjectId
	 **/
	@Schema(description = "An identifier that is unique for the respective type within a NFV-MANO functional entity, but that need not be globally unique. Representation: string of variable length.. ")

	public String getSubObjectId() {
		return subObjectId;
	}

	public void setSubObjectId(final String subObjectId) {
		this.subObjectId = subObjectId;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final ManoManagedObjectReference manoManagedObjectReference = (ManoManagedObjectReference) o;
		return Objects.equals(this.type, manoManagedObjectReference.type) &&
				Objects.equals(this.objectId, manoManagedObjectReference.objectId) &&
				Objects.equals(this.subObjectId, manoManagedObjectReference.subObjectId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, objectId, subObjectId);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class ManoManagedObjectReference {\n");

		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    objectId: ").append(toIndentedString(objectId)).append("\n");
		sb.append("    subObjectId: ").append(toIndentedString(subObjectId)).append("\n");
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
