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
package com.ubiqube.etsi.mano.v451.service.mapping.subscription;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.service.event.model.Subscription;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.LccnSubscription;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.LccnSubscriptionRequest;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.LifecycleChangeNotificationsFilter;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LccnSubscription451Mapping extends BaseSubscription451Mapping {

	@Mapping(target = "filter", source = "filters", qualifiedByName = "toObject")
	@Mapping(target = "links", ignore = true)
	LccnSubscription map(Subscription o, @Context final Class<LifecycleChangeNotificationsFilter> clazz);

	@Mapping(target = "api", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "filters", source = "filter", qualifiedByName = "fromObject")
	@Mapping(target = "nodeFilter", ignore = true)
	@Mapping(target = "subscriptionType", constant = "VNFLCM")
	@Mapping(target = "version", ignore = true)
	Subscription map(LccnSubscription o);

	@Mapping(target = "filter", source = "filters", qualifiedByName = "toObject")
	LccnSubscriptionRequest mapToLccnSubscriptionRequest(Subscription o, @Context final Class<LifecycleChangeNotificationsFilter> clazz);

	@Mapping(target = "api", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "filters", source = "filter", qualifiedByName = "fromObject")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "nodeFilter", ignore = true)
	@Mapping(target = "subscriptionType", constant = "VNFLCM")
	@Mapping(target = "version", ignore = true)
	Subscription map(LccnSubscriptionRequest o);

}
