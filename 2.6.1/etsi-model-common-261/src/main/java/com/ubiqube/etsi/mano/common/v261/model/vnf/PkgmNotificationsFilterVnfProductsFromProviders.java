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
package com.ubiqube.etsi.mano.common.v261.model.vnf;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

/**
 * PkgmNotificationsFilterVnfProductsFromProviders
 */
@Validated
public class PkgmNotificationsFilterVnfProductsFromProviders {
	@JsonProperty("vnfProvider")
	private String vnfProvider = null;

	@JsonProperty("vnfProducts")
	@Valid
	private List<PkgmNotificationsFilterVnfProducts> vnfProducts = null;

	@JsonProperty("vnfdId")
	@Valid
	private List<String> vnfdId = null;

	@JsonProperty("vnfPkgId")
	@Valid
	private List<String> vnfPkgId = null;

	@JsonProperty("operationalState")
	@Valid
	private List<PackageOperationalStateType> operationalState = null;

	@JsonProperty("usageState")
	@Valid
	private List<PackageUsageStateType> usageState = null;

	public PkgmNotificationsFilterVnfProductsFromProviders vnfProvider(final String vnfProvider) {
		this.vnfProvider = vnfProvider;
		return this;
	}

	/**
	 * Name of the VNFprovider to match.
	 *
	 * @return vnfProvider
	 **/
	@Schema(requiredMode = RequiredMode.REQUIRED, description = "Name of the VNFprovider to match. ")
	@NotNull

	public String getVnfProvider() {
		return vnfProvider;
	}

	public void setVnfProvider(final String vnfProvider) {
		this.vnfProvider = vnfProvider;
	}

	public PkgmNotificationsFilterVnfProductsFromProviders vnfProducts(final List<PkgmNotificationsFilterVnfProducts> vnfProducts) {
		this.vnfProducts = vnfProducts;
		return this;
	}

	public PkgmNotificationsFilterVnfProductsFromProviders addVnfProductsItem(final PkgmNotificationsFilterVnfProducts vnfProductsItem) {
		if (this.vnfProducts == null) {
			this.vnfProducts = new ArrayList<>();
		}
		this.vnfProducts.add(vnfProductsItem);
		return this;
	}

	/**
	 * If present, match VNF packages that contain VNF products with certain product names, from one particular provider.
	 *
	 * @return vnfProducts
	 **/
	@Schema(description = "If present, match VNF packages that contain VNF products with certain product names, from one particular provider. ")

	@Valid

	public List<PkgmNotificationsFilterVnfProducts> getVnfProducts() {
		return vnfProducts;
	}

	public void setVnfProducts(final List<PkgmNotificationsFilterVnfProducts> vnfProducts) {
		this.vnfProducts = vnfProducts;
	}

	public PkgmNotificationsFilterVnfProductsFromProviders vnfdId(final List<String> vnfdId) {
		this.vnfdId = vnfdId;
		return this;
	}

	public PkgmNotificationsFilterVnfProductsFromProviders addVnfdIdItem(final String vnfdIdItem) {
		if (this.vnfdId == null) {
			this.vnfdId = new ArrayList<>();
		}
		this.vnfdId.add(vnfdIdItem);
		return this;
	}

	/**
	 * Match VNF packages with a VNFD identifier listed in the attribute.
	 *
	 * @return vnfdId
	 **/
	@Schema(description = "Match VNF packages with a VNFD identifier listed in the attribute. ")

	public List<String> getVnfdId() {
		return vnfdId;
	}

	public void setVnfdId(final List<String> vnfdId) {
		this.vnfdId = vnfdId;
	}

	public PkgmNotificationsFilterVnfProductsFromProviders vnfPkgId(final List<String> vnfPkgId) {
		this.vnfPkgId = vnfPkgId;
		return this;
	}

	public PkgmNotificationsFilterVnfProductsFromProviders addVnfPkgIdItem(final String vnfPkgIdItem) {
		if (this.vnfPkgId == null) {
			this.vnfPkgId = new ArrayList<>();
		}
		this.vnfPkgId.add(vnfPkgIdItem);
		return this;
	}

	/**
	 * Match VNF packages with a package identifier listed in the attribute. May be present if the \"notificationTypes\" attribute contains the value \"VnfPackageChangeNotification\", and shall be absent otherwise.
	 *
	 * @return vnfPkgId
	 **/
	@Schema(description = "Match VNF packages with a package identifier listed in the attribute. May be present if the \"notificationTypes\" attribute contains the value \"VnfPackageChangeNotification\", and shall be absent otherwise. ")

	public List<String> getVnfPkgId() {
		return vnfPkgId;
	}

	public void setVnfPkgId(final List<String> vnfPkgId) {
		this.vnfPkgId = vnfPkgId;
	}

	public PkgmNotificationsFilterVnfProductsFromProviders operationalState(final List<PackageOperationalStateType> operationalState) {
		this.operationalState = operationalState;
		return this;
	}

	public PkgmNotificationsFilterVnfProductsFromProviders addOperationalStateItem(final PackageOperationalStateType operationalStateItem) {
		if (this.operationalState == null) {
			this.operationalState = new ArrayList<>();
		}
		this.operationalState.add(operationalStateItem);
		return this;
	}

	/**
	 * Match VNF packages with a package identifier listed in the attribute. May be present if the \"notificationTypes\" attribute contains the value \"VnfPackageChangeNotification\", and shall be absent otherwise.
	 *
	 * @return operationalState
	 **/
	@Schema(description = "Match VNF packages with a package identifier listed in the attribute. May be present if the \"notificationTypes\" attribute contains the value \"VnfPackageChangeNotification\", and shall be absent otherwise. ")

	@Valid

	public List<PackageOperationalStateType> getOperationalState() {
		return operationalState;
	}

	public void setOperationalState(final List<PackageOperationalStateType> operationalState) {
		this.operationalState = operationalState;
	}

	public PkgmNotificationsFilterVnfProductsFromProviders usageState(final List<PackageUsageStateType> usageState) {
		this.usageState = usageState;
		return this;
	}

	public PkgmNotificationsFilterVnfProductsFromProviders addUsageStateItem(final PackageUsageStateType usageStateItem) {
		if (this.usageState == null) {
			this.usageState = new ArrayList<>();
		}
		this.usageState.add(usageStateItem);
		return this;
	}

	/**
	 * Match particular usage state of the on-boarded VNF package. May be present if the \"notificationTypes\" attribute contains the value \"VnfPackageChangeNotification\", and shall be absent otherwise.
	 *
	 * @return usageState
	 **/
	@Schema(description = "Match particular usage state of the on-boarded VNF package. May be present if the \"notificationTypes\" attribute contains the value \"VnfPackageChangeNotification\", and shall be absent otherwise. ")

	@Valid

	public List<PackageUsageStateType> getUsageState() {
		return usageState;
	}

	public void setUsageState(final List<PackageUsageStateType> usageState) {
		this.usageState = usageState;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final PkgmNotificationsFilterVnfProductsFromProviders pkgmNotificationsFilterVnfProductsFromProviders = (PkgmNotificationsFilterVnfProductsFromProviders) o;
		return Objects.equals(this.vnfProvider, pkgmNotificationsFilterVnfProductsFromProviders.vnfProvider) &&
				Objects.equals(this.vnfProducts, pkgmNotificationsFilterVnfProductsFromProviders.vnfProducts) &&
				Objects.equals(this.vnfdId, pkgmNotificationsFilterVnfProductsFromProviders.vnfdId) &&
				Objects.equals(this.vnfPkgId, pkgmNotificationsFilterVnfProductsFromProviders.vnfPkgId) &&
				Objects.equals(this.operationalState, pkgmNotificationsFilterVnfProductsFromProviders.operationalState) &&
				Objects.equals(this.usageState, pkgmNotificationsFilterVnfProductsFromProviders.usageState);
	}

	@Override
	public int hashCode() {
		return Objects.hash(vnfProvider, vnfProducts, vnfdId, vnfPkgId, operationalState, usageState);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class PkgmNotificationsFilterVnfProductsFromProviders {\n");

		sb.append("    vnfProvider: ").append(toIndentedString(vnfProvider)).append("\n");
		sb.append("    vnfProducts: ").append(toIndentedString(vnfProducts)).append("\n");
		sb.append("    vnfdId: ").append(toIndentedString(vnfdId)).append("\n");
		sb.append("    vnfPkgId: ").append(toIndentedString(vnfPkgId)).append("\n");
		sb.append("    operationalState: ").append(toIndentedString(operationalState)).append("\n");
		sb.append("    usageState: ").append(toIndentedString(usageState)).append("\n");
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
