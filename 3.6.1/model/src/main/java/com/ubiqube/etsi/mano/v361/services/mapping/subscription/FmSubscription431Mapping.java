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
package com.ubiqube.etsi.mano.v361.services.mapping.subscription;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.service.event.model.Subscription;
import com.ubiqube.etsi.mano.v361.model.em.vnffm.FmNotificationsFilter;
import com.ubiqube.etsi.mano.v361.model.em.vnffm.FmSubscription;
import com.ubiqube.etsi.mano.v361.model.em.vnffm.FmSubscriptionRequest;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FmSubscription431Mapping extends BaseSubscription431Mapping {

	@Mapping(target = "filter", source = "filters", qualifiedByName = "toObject")
	@Mapping(target = "links", ignore = true)
	FmSubscription map(Subscription o, @Context final Class<FmNotificationsFilter> obj);

	@Mapping(target = "verbosity", ignore = true)
	@Mapping(target = "authentication", ignore = true)
	@Mapping(target = "api", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "filters", source = "filter", qualifiedByName = "fromObject")
	@Mapping(target = "nodeFilter", ignore = true)
	@Mapping(target = "subscriptionType", constant = "VNFFM")
	@Mapping(target = "version", ignore = true)
	Subscription map(FmSubscription o);

	@Mapping(target = "api", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "filters", source = "filter", qualifiedByName = "fromObject")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "nodeFilter", ignore = true)
	@Mapping(target = "subscriptionType", constant = "VNFFM")
	@Mapping(target = "verbosity", ignore = true)
	@Mapping(target = "version", ignore = true)
	Subscription map(FmSubscriptionRequest body);

}
