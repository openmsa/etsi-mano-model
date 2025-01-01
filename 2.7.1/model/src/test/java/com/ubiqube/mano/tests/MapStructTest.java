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
package com.ubiqube.mano.tests;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.ubiqube.etsi.mano.dao.mano.NsdPackage;
import com.ubiqube.etsi.mano.dao.mano.VnfIndicator;
import com.ubiqube.etsi.mano.dao.mano.VnfInstance;
import com.ubiqube.etsi.mano.dao.mano.dto.nsi.NsInstanceDto;
import com.ubiqube.etsi.mano.dao.mano.pm.PmJob;
import com.ubiqube.etsi.mano.test.MapstructTestHelper;
import com.ubiqube.etsi.mano.v271.model.em.vnffm.Alarm;
import com.ubiqube.etsi.mano.v271.model.em.vnffm.FmNotificationsFilter;
import com.ubiqube.etsi.mano.v271.model.em.vnffm.FmSubscription;
import com.ubiqube.etsi.mano.v271.model.em.vnfind.Threshold;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.LccnSubscription;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.LccnSubscriptionRequest;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.LifecycleChangeNotificationsFilter;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.VnfLcmOpOcc;
import com.ubiqube.etsi.mano.v271.model.sol003.lcmgrant.Grant;
import com.ubiqube.etsi.mano.v271.model.sol003.vnf.PkgmNotificationsFilter;
import com.ubiqube.etsi.mano.v271.model.sol003.vnf.PkgmSubscriptionRequest;
import com.ubiqube.etsi.mano.v271.model.sol005.nsd.PnfdInfo;
import com.ubiqube.etsi.mano.v271.model.sol005.nslcm.NsLcmOpOcc;
import com.ubiqube.etsi.mano.v271.service.mapping.Alarm271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.Grant271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.NsInstance271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.NsLcmOpOcc271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.Nsd271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.PmJob271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.Pnfd271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.Threshold271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.VnfIndicator271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.VnfInstance271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.VnfLcmOpOcc271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.subscription.FmSubscription271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.subscription.LccnSubscription271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.subscription.PkgmSubscriptionRequest271Mapping;
import com.ubiqube.etsi.mano.v271.service.mapping.vnflcm.VnfBlueprint271Mapping;

class MapStructTest extends MapstructTestHelper {

	@Test
	void testGrant() throws Exception {
		final Grant271Mapping mapper = Mappers.getMapper(Grant271Mapping.class);
		final Set<String> ignore = new LinkedHashSet<>();
		ignore.add("getLinks");
		ignore.add("getVimConnections");
		doTest(ignore, Grant.class, x -> mapper.map(x), x -> mapper.map(x));
	}

//	@Test
//	void testGrantRequest() {
//		final GrantRequestMapping mapper = Mappers.getMapper(GrantRequestMapping.class);
//		doTest(GrantRequest.class, x -> mapper.map(x), x -> mapper.map(x));
//	}
//
//	@Test
	void testVnfInstanceDb() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final VnfInstance271Mapping mapper = Mappers.getMapper(VnfInstance271Mapping.class);
		doTest(com.ubiqube.etsi.mano.dao.mano.VnfInstance.class, x -> mapper.map(x), x -> mapper.map(x));
	}

//	@Test
	void testVnfInstance() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final VnfInstance271Mapping mapper = Mappers.getMapper(VnfInstance271Mapping.class);
		doTest(VnfInstance.class, x -> mapper.map(x), x -> mapper.map(x));
	}

	/**
	 * CorrelatedAlarmIds Is an UUID.
	 *
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws IntrospectionException
	 */
	@Test
	@Disabled
	void testAlarm() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final Alarm271Mapping mapper = Mappers.getMapper(Alarm271Mapping.class);
		doTest(Alarm.class, x -> mapper.map(x), x -> mapper.map(x));
	}

	void testNsdPackage() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final Nsd271Mapping mapper = Mappers.getMapper(Nsd271Mapping.class);
		doTest(NsdPackage.class, x -> mapper.map(x), x -> mapper.map(x));
	}

	/**
	 * Nothing impossible.
	 *
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws IntrospectionException
	 */
	@Disabled
	@Test
	void testNsInstance() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final NsInstance271Mapping mapper = Mappers.getMapper(NsInstance271Mapping.class);
		final Set<String> ignore = new LinkedHashSet<>();
		ignore.add("getLinks");
		ignore.add("getVnfInstance.[0].getInstantiatedVnfInfo.getMonitoringParameters.[0].getAudit");
		// TODO
		ignore.add("getVnffgInfo");
		doTest(ignore, NsInstanceDto.class, x -> mapper.map(x), x -> mapper.map(x));
	}

	/**
	 * EndpointType instability.
	 *
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws IntrospectionException
	 */
	@Disabled
	@Test
	void testNsLcmOpOcc() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final NsLcmOpOcc271Mapping mapper = Mappers.getMapper(NsLcmOpOcc271Mapping.class);
		final Set<String> ignore = new LinkedHashSet<>();
		ignore.add("getResourceChanges");
		ignore.add("getLinks");
		ignore.add("getOperationParams");
		doTest(ignore, NsLcmOpOcc.class, x -> mapper.map(x), x -> mapper.map(x));
	}

	/**
	 * objectType is an Enum.
	 *
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws IntrospectionException
	 */
	@Test
	@Disabled
	void testPmJob() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final PmJob271Mapping mapper = Mappers.getMapper(PmJob271Mapping.class);
		doTest(PmJob.class, x -> mapper.map(x), x -> mapper.map(x));
	}

	@Test
	void testPnfd() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final Pnfd271Mapping mapper = Mappers.getMapper(Pnfd271Mapping.class);
		doTest(PnfdInfo.class, x -> mapper.map(x), x -> mapper.map(x));
	}

	@Test
	void testThreshold() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final Threshold271Mapping mapper = Mappers.getMapper(Threshold271Mapping.class);
		doTest(Threshold.class, x -> mapper.map(x), x -> mapper.map(x));
	}

	@Test
	void testVnfIndicator() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final VnfIndicator271Mapping mapper = Mappers.getMapper(VnfIndicator271Mapping.class);
		final Set<String> ignore = new LinkedHashSet<>();
		ignore.add("getLinks");
		ignore.add("getValue");
		ignore.add("getTargets");
		ignore.add("getAudit");
		ignore.add("getSource");
		ignore.add("getToscaId");
		ignore.add("getToscaName");
		ignore.add("getState");
		doTest(ignore, VnfIndicator.class, x -> mapper.map(x), x -> mapper.map(x));
	}

	@Test
	void testVnfLcmOpOcc() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final VnfBlueprint271Mapping mapper = Mappers.getMapper(VnfBlueprint271Mapping.class);
		final VnfLcmOpOcc271Mapping mapper2 = Mappers.getMapper(VnfLcmOpOcc271Mapping.class);
		final Set<String> ignore = new LinkedHashSet<>();
		ignore.add("getLinks");
		ignore.add("getChangedInfo.getVimConnectionInfo.[0].getId");
		// This one is a 2.4.1 field and can be removed from models.
		ignore.add("getChangedInfo.getVnfPkgId");
		doTest(ignore, VnfLcmOpOcc.class, x -> mapper2.map(x), x -> mapper.map(x));
	}

//	@Test
//	void testVnfPkgInfo() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
//		final VnfPkgInfoMapping mapper = Mappers.getMapper(VnfPkgInfoMapping.class);
//		doTest(VnfPkgInfo.class, x -> mapper.map(x), x -> mapper.map(x));
//	}
	@Test
	void testFmSubscription() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final FmSubscription271Mapping mapper = Mappers.getMapper(FmSubscription271Mapping.class);
		doTest(FmSubscription.class, x -> mapper.map(x), x -> mapper.map(x, FmNotificationsFilter.class));
	}

	@Test
	void testFmSubscriptionRequest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final FmSubscription271Mapping mapper = Mappers.getMapper(FmSubscription271Mapping.class);
//		doTest(FmSubscriptionRequest.class, x -> mapper.map(x), x -> mapper.map(x, FmNotificationsFilter.class));
	}

	@Test
	void testLccnSubscription() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final LccnSubscription271Mapping mapper = Mappers.getMapper(LccnSubscription271Mapping.class);
		doTest(LccnSubscription.class, x -> mapper.map(x), x -> mapper.map(x, LifecycleChangeNotificationsFilter.class));
	}

	@Test
	void testLccnSubscriptionRequest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final LccnSubscription271Mapping mapper = Mappers.getMapper(LccnSubscription271Mapping.class);
		doTest(LccnSubscriptionRequest.class, x -> mapper.map(x), x -> mapper.mapToLccnSubscriptionRequest(x, LifecycleChangeNotificationsFilter.class));
	}

	@Test
	void testPkgmSubscriptionRequest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final PkgmSubscriptionRequest271Mapping mapper = Mappers.getMapper(PkgmSubscriptionRequest271Mapping.class);
		doTest(PkgmSubscriptionRequest.class, x -> mapper.map(x), x -> mapper.mapRequest(x, PkgmNotificationsFilter.class));
	}

}
