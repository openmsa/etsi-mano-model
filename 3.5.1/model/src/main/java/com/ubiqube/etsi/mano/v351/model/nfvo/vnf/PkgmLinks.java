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
package com.ubiqube.etsi.mano.v351.model.nfvo.vnf;

import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

/**
 * This type represents the links to resources that a VNF package management
 * notification can contain.
 */
@Schema(description = "This type represents the links to resources that a VNF package management notification can contain.   ")
@Validated

public class PkgmLinks {
	@JsonProperty("vnfPackage")
	private NotificationLink vnfPackage = null;

	@JsonProperty("vnfPackageByVnfdId")
	private NotificationLink vnfPackageByVnfdId = null;

	@JsonProperty("subscription")
	private NotificationLink subscription = null;

	public PkgmLinks vnfPackage(final NotificationLink vnfPackage) {
		this.vnfPackage = vnfPackage;
		return this;
	}

	/**
	 * Get vnfPackage
	 *
	 * @return vnfPackage
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public NotificationLink getVnfPackage() {
		return vnfPackage;
	}

	public void setVnfPackage(final NotificationLink vnfPackage) {
		this.vnfPackage = vnfPackage;
	}

	public PkgmLinks vnfPackageByVnfdId(final NotificationLink vnfPackageByVnfdId) {
		this.vnfPackageByVnfdId = vnfPackageByVnfdId;
		return this;
	}

	/**
	 * Get vnfPackageByVnfdId
	 *
	 * @return vnfPackageByVnfdId
	 **/
	@Schema(description = "")

	@Valid
	public NotificationLink getVnfPackageByVnfdId() {
		return vnfPackageByVnfdId;
	}

	public void setVnfPackageByVnfdId(final NotificationLink vnfPackageByVnfdId) {
		this.vnfPackageByVnfdId = vnfPackageByVnfdId;
	}

	public PkgmLinks subscription(final NotificationLink subscription) {
		this.subscription = subscription;
		return this;
	}

	/**
	 * Get subscription
	 *
	 * @return subscription
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "")
	@NotNull

	@Valid
	public NotificationLink getSubscription() {
		return subscription;
	}

	public void setSubscription(final NotificationLink subscription) {
		this.subscription = subscription;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final PkgmLinks pkgmLinks = (PkgmLinks) o;
		return Objects.equals(this.vnfPackage, pkgmLinks.vnfPackage) &&
				Objects.equals(this.vnfPackageByVnfdId, pkgmLinks.vnfPackageByVnfdId) &&
				Objects.equals(this.subscription, pkgmLinks.subscription);
	}

	@Override
	public int hashCode() {
		return Objects.hash(vnfPackage, vnfPackageByVnfdId, subscription);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class PkgmLinks {\n");

		sb.append("    vnfPackage: ").append(toIndentedString(vnfPackage)).append("\n");
		sb.append("    vnfPackageByVnfdId: ").append(toIndentedString(vnfPackageByVnfdId)).append("\n");
		sb.append("    subscription: ").append(toIndentedString(subscription)).append("\n");
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
