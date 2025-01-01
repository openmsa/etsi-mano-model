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
package com.ubiqube.etsi.mano.test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import uk.co.jemos.podam.api.AttributeMetadata;
import uk.co.jemos.podam.api.DataProviderStrategy;
import uk.co.jemos.podam.common.ManufacturingContext;
import uk.co.jemos.podam.typeManufacturers.StringTypeManufacturerImpl;

public class UUIDManufacturer extends StringTypeManufacturerImpl {

	private final List<String> list;

	public UUIDManufacturer() {
		list = new ArrayList<>();
		list.add("id");
		list.add("vnfInstanceId");
		list.add("grantId");
		list.add("resourceId");
		list.add("vduId");
		list.add("vimConnectionId");
		list.add("vimId");
		list.add("virtualLinkDescId");
		list.add("virtualStorageDescId");
		list.add("cpdId");
		list.add("extManagedVirtualLinkId");
		list.add("vnfLcmOpOccId");
		list.add("extVirtualLinkId");
		// Added 2.7.1
		list.add("vnfPkgId");
		list.add("vnfVirtualLinkDescId");
		//
		list.add("nsInstanceId");
		// Not sure
		list.add("objectInstanceId");
		list.add("managedObjectId");
	}

	@Override
	public String getType(final DataProviderStrategy strategy, final AttributeMetadata attributeMetadata, final ManufacturingContext manufacturingCtx) {
		if (list.contains(attributeMetadata.getAttributeName())) {
			return UUID.randomUUID().toString();
		}
		if ("vimType".equals(attributeMetadata.getAttributeName())) {
			return "ETSINFV.OPENSTACK_KEYSTONE.V_3";
		}
		return super.getType(strategy, attributeMetadata, manufacturingCtx);
	}

}
