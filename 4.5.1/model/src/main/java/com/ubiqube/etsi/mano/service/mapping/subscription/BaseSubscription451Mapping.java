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
package com.ubiqube.etsi.mano.service.mapping.subscription;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.mapstruct.ValueMapping;

import com.ubiqube.etsi.mano.em.v451.model.vnflcm.SubscriptionAuthentication;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.SubscriptionAuthenticationParamsOauth2ClientCredentials;
import com.ubiqube.etsi.mano.exception.GenericException;
import com.ubiqube.etsi.mano.mapper.DotMapper;
import com.ubiqube.etsi.mano.service.auth.model.AuthParamOauth2;
import com.ubiqube.etsi.mano.service.auth.model.AuthType;
import com.ubiqube.etsi.mano.service.auth.model.AuthentificationInformations;
import com.ubiqube.etsi.mano.service.event.model.FilterAttributes;
import com.ubiqube.etsi.mano.service.mapping.StringToUri451Mapping;

@Mapper
public interface BaseSubscription451Mapping extends StringToUri451Mapping {
	@ValueMapping(source = "BASIC", target = MappingConstants.THROW_EXCEPTION)
	@ValueMapping(source = "TLS_CERT", target = MappingConstants.THROW_EXCEPTION)
	SubscriptionAuthentication.AuthTypeEnum map(AuthType o);

	@Named("toObject")
	default <T> T toObject(final List<FilterAttributes> src, @Context final Class<?> clazz) {
		final DotMapper m = new DotMapper();
		return (T) m.AttrToObject(src, createClass(clazz));
	}

	default Object createClass(final Class<?> clazz) {
		try {
			return clazz.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new GenericException(e);
		}
	}

	@Named("fromObject")
	default <T> List<FilterAttributes> fromObject(final T src) {
		final DotMapper m = new DotMapper();
		return m.objectToAttr(src);
	}

	@Mapping(target = "paramsBasic", source = "authParamBasic")
	@Mapping(target = "paramsOauth2ClientCredentials", source = "authParamOauth2")
	SubscriptionAuthentication map(AuthentificationInformations o);

	@Mapping(target = "authTlsCert", ignore = true)
	@InheritInverseConfiguration
	AuthentificationInformations map(SubscriptionAuthentication o);

	@Mapping(target = "clientSecret", source = "clientPassword")
	@Mapping(target = "grantType", ignore = true)
	@Mapping(target = "o2AuthTlsCert", ignore = true)
	@Mapping(target = "o2IgnoreSsl", ignore = true)
	@Mapping(target = "o2Password", ignore = true)
	@Mapping(target = "o2Username", ignore = true)
	AuthParamOauth2 map(SubscriptionAuthenticationParamsOauth2ClientCredentials o);

	@Mapping(target = "clientPassword", source = "clientSecret")
	SubscriptionAuthenticationParamsOauth2ClientCredentials map(AuthParamOauth2 authParamOauth2);

	AuthType map(SubscriptionAuthentication.AuthTypeEnum o);
}
