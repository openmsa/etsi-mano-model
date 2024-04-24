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
package com.ubiqube.etsi.mano.v261.service.mapping.subscription;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.common.v261.model.vnf.PkgmNotificationsFilter;
import com.ubiqube.etsi.mano.common.v261.model.vnf.PkgmSubscription;
import com.ubiqube.etsi.mano.common.v261.model.vnf.PkgmSubscriptionRequest;
import com.ubiqube.etsi.mano.service.event.model.Subscription;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PkgmSubscriptionRequest261Mapping extends BaseSubscription261Mapping {

	@Mapping(target = "filter", source = "filters", qualifiedByName = "toObject")
	PkgmSubscriptionRequest mapRequest(Subscription o, @Context final Class<PkgmNotificationsFilter> clazz);

	@Mapping(target = "verbosity", ignore = true)
	@Mapping(target = "api", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "filters", source = "filter", qualifiedByName = "fromObject")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "nodeFilter", ignore = true)
	@Mapping(target = "subscriptionType", constant = "VNF")
	@Mapping(target = "version", constant = "2.8.1")
	Subscription map(PkgmSubscriptionRequest o);

	@Mapping(target = "filter", source = "filters", qualifiedByName = "toObject")
	@Mapping(target = "links", ignore = true)
	PkgmSubscription map(Subscription o, @Context final Class<PkgmNotificationsFilter> clazz);

	@Mapping(target = "filter", source = "filters", qualifiedByName = "toObject")
	PkgmSubscriptionRequest mapToRequest(Subscription req, @Context Class<PkgmNotificationsFilter> clazz);

	@Mapping(target = "api", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "authentication", ignore = true)
	@Mapping(target = "filters", source = "filter", qualifiedByName = "fromObject")
	@Mapping(target = "nodeFilter", ignore = true)
	@Mapping(target = "subscriptionType", constant = "VNF")
	@Mapping(target = "verbosity", ignore = true)
	@Mapping(target = "version", constant = "2.8.1")
	Subscription map(PkgmSubscription o);
}
