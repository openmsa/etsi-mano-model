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

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

/**
 * This type represents a subscription filter related to notifications related
 * to VNF package management. At a particular nesting level in the filter
 * structure, the following applies: All attributes shall match in order for the
 * filter to match (logical \&quot;and\&quot; between different filter
 * attributes). If an attribute is an array, the attribute shall match if at
 * least one of the values in the array matches (logical \&quot;or\&quot;
 * between the values of one filter attribute).
 */
@Schema(description = "This type represents a subscription filter related to notifications related to VNF package management. At a particular nesting level in the filter structure, the following applies: All attributes shall match in order for the filter to match (logical \"and\" between different filter attributes). If an attribute is an array, the attribute shall match if at least one of the values in the array matches (logical \"or\" between the values of one filter attribute). ")
@Validated
public class PkgmNotificationsFilter {
	/**
	 * Match particular notification types. Permitted values: -
	 * VnfPackageOnboardingNotification - VnfPackageChangeNotification
	 */
	public enum NotificationTypesEnum {
		VnfPackageOnboardingNotification("VnfPackageOnboardingNotification"),

		VnfPackageChangeNotification("VnfPackageChangeNotification");

		private final String value;

		NotificationTypesEnum(final String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static NotificationTypesEnum fromValue(final String text) {
			for (final NotificationTypesEnum b : NotificationTypesEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("notificationTypes")
	private List<NotificationTypesEnum> notificationTypes = null;

	@JsonProperty("vnfProductsFromProviders")
	@Valid
	private List<PkgmNotificationsFilterVnfProductsFromProviders> vnfProductsFromProviders = null;

	@JsonProperty("vnfdId")
	@Valid
	private List<String> vnfdId = null;

	@JsonProperty("vnfPkgId")
	@Valid
	private List<String> vnfPkgId = null;

	@JsonProperty("operationalState")
	private List<PackageOperationalStateType> operationalState;

	@JsonProperty("usageState")
	private List<PackageUsageStateType> usageState = null;

	public PkgmNotificationsFilter notificationTypes(final List<NotificationTypesEnum> notificationTypes) {
		this.notificationTypes = notificationTypes;
		return this;
	}

	/**
	 * Match particular notification types. Permitted values: -
	 * VnfPackageOnboardingNotification - VnfPackageChangeNotification
	 *
	 * @return notificationTypes
	 **/
	@Schema(description = "Match particular notification types. Permitted values: - VnfPackageOnboardingNotification - VnfPackageChangeNotification ")

	public List<NotificationTypesEnum> getNotificationTypes() {
		return notificationTypes;
	}

	public void setNotificationTypes(final List<NotificationTypesEnum> notificationTypes) {
		this.notificationTypes = notificationTypes;
	}

	public PkgmNotificationsFilter vnfProductsFromProviders(final List<PkgmNotificationsFilterVnfProductsFromProviders> vnfProductsFromProviders) {
		this.vnfProductsFromProviders = vnfProductsFromProviders;
		return this;
	}

	public PkgmNotificationsFilter addVnfProductsFromProvidersItem(final PkgmNotificationsFilterVnfProductsFromProviders vnfProductsFromProvidersItem) {
		if (this.vnfProductsFromProviders == null) {
			this.vnfProductsFromProviders = new ArrayList<>();
		}
		this.vnfProductsFromProviders.add(vnfProductsFromProvidersItem);
		return this;
	}

	/**
	 * If present, match VNF packages that contain VNF products from certain
	 * providers.
	 *
	 * @return vnfProductsFromProviders
	 **/
	@Schema(description = "If present, match VNF packages that contain VNF products from certain providers. ")

	@Valid

	public List<PkgmNotificationsFilterVnfProductsFromProviders> getVnfProductsFromProviders() {
		return vnfProductsFromProviders;
	}

	public void setVnfProductsFromProviders(final List<PkgmNotificationsFilterVnfProductsFromProviders> vnfProductsFromProviders) {
		this.vnfProductsFromProviders = vnfProductsFromProviders;
	}

	public PkgmNotificationsFilter vnfdId(final List<String> vnfdId) {
		this.vnfdId = vnfdId;
		return this;
	}

	public PkgmNotificationsFilter addVnfdIdItem(final String vnfdIdItem) {
		if (this.vnfdId == null) {
			this.vnfdId = new ArrayList<>();
		}
		this.vnfdId.add(vnfdIdItem);
		return this;
	}

	/**
	 * Match VNF packages with a VNFD identifier listed in the attribute. The
	 * attributes \"vnfProductsFromProviders\", \"vnfdId\" and \"vnfPkgId\" are
	 * alternatives to reference to particular VNF packages in a filter. They should
	 * not be used both in the same filter instance, but one alternative should be
	 * chosen.
	 *
	 * @return vnfdId
	 **/
	@Schema(description = "Match VNF packages with a VNFD identifier listed in the attribute. The attributes \"vnfProductsFromProviders\", \"vnfdId\" and \"vnfPkgId\" are alternatives to reference to particular VNF packages in a filter. They should not be used both in the same filter instance, but one alternative should be chosen. ")

	public List<String> getVnfdId() {
		return vnfdId;
	}

	public void setVnfdId(final List<String> vnfdId) {
		this.vnfdId = vnfdId;
	}

	public PkgmNotificationsFilter vnfPkgId(final List<String> vnfPkgId) {
		this.vnfPkgId = vnfPkgId;
		return this;
	}

	public PkgmNotificationsFilter addVnfPkgIdItem(final String vnfPkgIdItem) {
		if (this.vnfPkgId == null) {
			this.vnfPkgId = new ArrayList<>();
		}
		this.vnfPkgId.add(vnfPkgIdItem);
		return this;
	}

	/**
	 * Match VNF packages with a package identifier listed in the attribute. May be
	 * present if the \"notificationTypes\" attribute contains the value
	 * \"VnfPackageChangeNotification\", and shall be absent otherwise. The
	 * attributes \"vnfProductsFromProviders\", \"vnfdId\" and \"vnfPkgId\" are
	 * alternatives to reference to particular VNF packages in a filter. They should
	 * not be used both in the same filter instance, but one alternative should be
	 * chosen.
	 *
	 * @return vnfPkgId
	 **/
	@Schema(description = "Match VNF packages with a package identifier listed in the attribute. May be present if the \"notificationTypes\" attribute contains the value \"VnfPackageChangeNotification\", and shall be absent otherwise. The attributes \"vnfProductsFromProviders\", \"vnfdId\" and \"vnfPkgId\" are alternatives to reference to particular VNF packages in a filter. They should not be used both in the same filter instance, but one alternative should be chosen. ")

	public List<String> getVnfPkgId() {
		return vnfPkgId;
	}

	public void setVnfPkgId(final List<String> vnfPkgId) {
		this.vnfPkgId = vnfPkgId;
	}

	public PkgmNotificationsFilter operationalState(final List<PackageOperationalStateType> operationalState) {
		this.operationalState = operationalState;
		return this;
	}

	/**
	 * Match particular operational states of the VNF package. May be present if the
	 * \"notificationTypes\" attribute contains the value
	 * \"VnfPackageChangeNotification\", and shall be absent otherwise.
	 *
	 * @return operationalState
	 **/
	@Schema(description = "Match particular operational states of the VNF package. May be present if the \"notificationTypes\" attribute contains the value \"VnfPackageChangeNotification\", and shall be absent otherwise. ")

	@Valid

	public List<PackageOperationalStateType> getOperationalState() {
		return operationalState;
	}

	public void setOperationalState(final List<PackageOperationalStateType> operationalState) {
		this.operationalState = operationalState;
	}

	public PkgmNotificationsFilter usageState(final List<PackageUsageStateType> usageState) {
		this.usageState = usageState;
		return this;
	}

	/**
	 * Match particular usage states of the VNF package. May be present if the
	 * \"notificationTypes\" attribute contains the value
	 * \"VnfPackageChangeNotification\", and shall be absent otherwise.
	 *
	 * @return usageState
	 **/
	@Schema(description = "Match particular usage states of the VNF package. May be present if the \"notificationTypes\" attribute contains the value \"VnfPackageChangeNotification\", and shall be absent otherwise. ")

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
		final PkgmNotificationsFilter pkgmNotificationsFilter = (PkgmNotificationsFilter) o;
		return Objects.equals(this.notificationTypes, pkgmNotificationsFilter.notificationTypes) &&
				Objects.equals(this.vnfProductsFromProviders, pkgmNotificationsFilter.vnfProductsFromProviders) &&
				Objects.equals(this.vnfdId, pkgmNotificationsFilter.vnfdId) &&
				Objects.equals(this.vnfPkgId, pkgmNotificationsFilter.vnfPkgId) &&
				Objects.equals(this.operationalState, pkgmNotificationsFilter.operationalState) &&
				Objects.equals(this.usageState, pkgmNotificationsFilter.usageState);
	}

	@Override
	public int hashCode() {
		return Objects.hash(notificationTypes, vnfProductsFromProviders, vnfdId, vnfPkgId, operationalState, usageState);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class PkgmNotificationsFilter {\n");

		sb.append("    notificationTypes: ").append(toIndentedString(notificationTypes)).append("\n");
		sb.append("    vnfProductsFromProviders: ").append(toIndentedString(vnfProductsFromProviders)).append("\n");
		sb.append("    vnfdId: ").append(toIndentedString(vnfdId)).append("\n");
		sb.append("    vnfPkgId: ").append(toIndentedString(vnfPkgId)).append("\n");
		sb.append("    operationalState: ").append(toIndentedString(operationalState)).append("\n");
		sb.append("    usageState: ").append(toIndentedString(usageState)).append("\n");
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
