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
package com.ubiqube.etsi.mano.mapping;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.ubiqube.etsi.mano.dao.mano.NsdPackage;
import com.ubiqube.etsi.mano.dao.mano.VnfInstance;
import com.ubiqube.etsi.mano.dao.mano.dto.nsi.NsInstanceDto;
import com.ubiqube.etsi.mano.test.MapstructTestHelper;
import com.ubiqube.etsi.mano.v451.model.em.vnffm.Alarm;
import com.ubiqube.etsi.mano.v451.model.em.vnffm.FmNotificationsFilter;
import com.ubiqube.etsi.mano.v451.model.em.vnffm.FmSubscription;
import com.ubiqube.etsi.mano.v451.model.em.vnfind.VnfIndicator;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.LccnSubscription;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.LccnSubscriptionRequest;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.LifecycleChangeNotificationsFilter;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VnfLcmOpOcc;
import com.ubiqube.etsi.mano.v451.model.em.vnfpm.PmJob;
import com.ubiqube.etsi.mano.v451.model.em.vnfpm.Threshold;
import com.ubiqube.etsi.mano.v451.model.nfvo.nsd.PnfdInfo;
import com.ubiqube.etsi.mano.v451.model.nfvo.nslcm.NsLcmOpOcc;
import com.ubiqube.etsi.mano.v451.model.nfvo.vnf.PkgmNotificationsFilter;
import com.ubiqube.etsi.mano.v451.model.nfvo.vnf.PkgmSubscriptionRequest;
import com.ubiqube.etsi.mano.v451.model.vnfm.grant.Grant;
import com.ubiqube.etsi.mano.v451.service.mapping.Alarm451Mapping;
import com.ubiqube.etsi.mano.v451.service.mapping.Grant451Mapping;
import com.ubiqube.etsi.mano.v451.service.mapping.NsInstance451Mapping;
import com.ubiqube.etsi.mano.v451.service.mapping.NsLcmOpOcc451Mapping;
import com.ubiqube.etsi.mano.v451.service.mapping.Nsd451Mapping;
import com.ubiqube.etsi.mano.v451.service.mapping.PmJob451Mapping;
import com.ubiqube.etsi.mano.v451.service.mapping.Pnfd451Mapping;
import com.ubiqube.etsi.mano.v451.service.mapping.Threshold451Mapping;
import com.ubiqube.etsi.mano.v451.service.mapping.VnfIndicator451Mapping;
import com.ubiqube.etsi.mano.v451.service.mapping.VnfInstance451Mapping;
import com.ubiqube.etsi.mano.v451.service.mapping.VnfLcmOpOcc451Mapping;
import com.ubiqube.etsi.mano.v451.service.mapping.subscription.FmSubscription451Mapping;
import com.ubiqube.etsi.mano.v451.service.mapping.subscription.LccnSubscription451Mapping;
import com.ubiqube.etsi.mano.v451.service.mapping.subscription.PkgmSubscriptionRequest451Mapping;
import com.ubiqube.etsi.mano.v451.service.mapping.vnflcm.VnfBlueprint451Mapping;

class MapStructTest extends MapstructTestHelper {

	@Test
	void testGrant() throws Exception {
		final Grant451Mapping mapper = Mappers.getMapper(Grant451Mapping.class);
		doTest(Grant.class, x -> mapper.map(x), x -> mapper.map(x));
	}

//	@Test
//	void testGrantRequest() {
//		final GrantRequestMapping mapper = Mappers.getMapper(GrantRequestMapping.class);
//		doTest(GrantRequest.class, x -> mapper.map(x), x -> mapper.map(x));
//	}
//
//	@Test
	void testVnfInstanceDb() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final VnfInstance451Mapping mapper = Mappers.getMapper(VnfInstance451Mapping.class);
		doTest(com.ubiqube.etsi.mano.dao.mano.VnfInstance.class, x -> mapper.map(x), x -> mapper.map(x));
	}

//	@Test
	void testVnfInstance() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final VnfInstance451Mapping mapper = Mappers.getMapper(VnfInstance451Mapping.class);
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
		final Alarm451Mapping mapper = Mappers.getMapper(Alarm451Mapping.class);
		doTest(Alarm.class, x -> mapper.map(x), x -> mapper.map(x));
	}

	void testNsdPackage() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final Nsd451Mapping mapper = Mappers.getMapper(Nsd451Mapping.class);
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
		final NsInstance451Mapping mapper = Mappers.getMapper(NsInstance451Mapping.class);
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
		final NsLcmOpOcc451Mapping mapper = Mappers.getMapper(NsLcmOpOcc451Mapping.class);
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
		final PmJob451Mapping mapper = Mappers.getMapper(PmJob451Mapping.class);
		doTest(PmJob.class, x -> mapper.map(x), x -> mapper.map(x));
	}

	@Test
	void testPnfd() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final Pnfd451Mapping mapper = Mappers.getMapper(Pnfd451Mapping.class);
		doTest(PnfdInfo.class, x -> mapper.map(x), x -> mapper.map(x));
	}

	@Test
	void testThreshold() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final Threshold451Mapping mapper = Mappers.getMapper(Threshold451Mapping.class);
		doTest(Threshold.class, x -> mapper.map(x), x -> mapper.map(x));
	}

	@Test
	void testVnfIndicator() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final VnfIndicator451Mapping mapper = Mappers.getMapper(VnfIndicator451Mapping.class);
		final Set<String> ignore = new LinkedHashSet<>();
		ignore.add("getValue");
		ignore.add("getLinks");
		doTest(ignore, VnfIndicator.class, x -> mapper.map(x), x -> mapper.map(x));
	}

	@Test
	void testVnfLcmOpOcc() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final VnfBlueprint451Mapping mapper = Mappers.getMapper(VnfBlueprint451Mapping.class);
		final VnfLcmOpOcc451Mapping mapper2 = Mappers.getMapper(VnfLcmOpOcc451Mapping.class);
		doTest(VnfLcmOpOcc.class, x -> mapper2.map(x), x -> mapper.map(x));
	}

//	@Test
//	void testVnfPkgInfo() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
//		final VnfPkgInfoMapping mapper = Mappers.getMapper(VnfPkgInfoMapping.class);
//		doTest(VnfPkgInfo.class, x -> mapper.map(x), x -> mapper.map(x));
//	}
	@Test
	void testFmSubscription() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final FmSubscription451Mapping mapper = Mappers.getMapper(FmSubscription451Mapping.class);
		doTest(FmSubscription.class, x -> mapper.map(x), x -> mapper.map(x, FmNotificationsFilter.class));
	}

	@Test
	void testFmSubscriptionRequest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final FmSubscription451Mapping mapper = Mappers.getMapper(FmSubscription451Mapping.class);
//		doTest(FmSubscriptionRequest.class, x -> mapper.map(x), x -> mapper.map(x, FmNotificationsFilter.class));
	}

	@Test
	void testLccnSubscription() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final LccnSubscription451Mapping mapper = Mappers.getMapper(LccnSubscription451Mapping.class);
		doTest(LccnSubscription.class, x -> mapper.map(x), x -> mapper.map(x, LifecycleChangeNotificationsFilter.class));
	}

	@Test
	void testLccnSubscriptionRequest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final LccnSubscription451Mapping mapper = Mappers.getMapper(LccnSubscription451Mapping.class);
		doTest(LccnSubscriptionRequest.class, x -> mapper.map(x), x -> mapper.mapToLccnSubscriptionRequest(x, LifecycleChangeNotificationsFilter.class));
	}

	@Test
	void testPkgmSubscriptionRequest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final PkgmSubscriptionRequest451Mapping mapper = Mappers.getMapper(PkgmSubscriptionRequest451Mapping.class);
		doTest(PkgmSubscriptionRequest.class, x -> mapper.map(x), x -> mapper.mapRequest(x, PkgmNotificationsFilter.class));
	}
}
