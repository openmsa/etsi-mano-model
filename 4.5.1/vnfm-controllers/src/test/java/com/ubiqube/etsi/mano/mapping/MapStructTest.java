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
package com.ubiqube.etsi.mano.mapping;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.ubiqube.etsi.mano.dao.mano.NsdPackage;
import com.ubiqube.etsi.mano.dao.mano.VnfInstance;
import com.ubiqube.etsi.mano.dao.mano.dto.nsi.NsInstanceDto;
import com.ubiqube.etsi.mano.em.v451.model.vnffm.Alarm;
import com.ubiqube.etsi.mano.em.v451.model.vnffm.FmSubscription;
import com.ubiqube.etsi.mano.em.v451.model.vnffm.FmSubscriptionRequest;
import com.ubiqube.etsi.mano.em.v451.model.vnfind.VnfIndicator;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.LccnSubscription;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.LccnSubscriptionRequest;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.VnfLcmOpOcc;
import com.ubiqube.etsi.mano.em.v451.model.vnfpm.PmJob;
import com.ubiqube.etsi.mano.em.v451.model.vnfpm.Threshold;
import com.ubiqube.etsi.mano.nfvo.v451.model.nsd.PnfdInfo;
import com.ubiqube.etsi.mano.nfvo.v451.model.nslcm.NsLcmOpOcc;
import com.ubiqube.etsi.mano.nfvo.v451.model.vnf.PkgmSubscriptionRequest;
import com.ubiqube.etsi.mano.service.mapping.Alarm451Mapping;
import com.ubiqube.etsi.mano.service.mapping.Grant451Mapping;
import com.ubiqube.etsi.mano.service.mapping.NsInstance451Mapping;
import com.ubiqube.etsi.mano.service.mapping.NsLcmOpOcc451Mapping;
import com.ubiqube.etsi.mano.service.mapping.Nsd451Mapping;
import com.ubiqube.etsi.mano.service.mapping.PmJob451Mapping;
import com.ubiqube.etsi.mano.service.mapping.Pnfd451Mapping;
import com.ubiqube.etsi.mano.service.mapping.Threshold451Mapping;
import com.ubiqube.etsi.mano.service.mapping.VnfIndicator451Mapping;
import com.ubiqube.etsi.mano.service.mapping.VnfInstance451Mapping;
import com.ubiqube.etsi.mano.service.mapping.VnfLcmOpOcc451Mapping;
import com.ubiqube.etsi.mano.service.mapping.subscription.FmSubscription451Mapping;
import com.ubiqube.etsi.mano.service.mapping.subscription.FmSubscriptionRequest451Mapping;
import com.ubiqube.etsi.mano.service.mapping.subscription.LccnSubscription451Mapping;
import com.ubiqube.etsi.mano.service.mapping.subscription.LccnSubscriptionRequest451Mapping;
import com.ubiqube.etsi.mano.service.mapping.subscription.PkgmSubscriptionRequest451Mapping;
import com.ubiqube.etsi.mano.test.MapstructTestHelper;
import com.ubiqube.etsi.mano.vnfm.v451.model.grant.Grant;

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

	@Test
	void testAlarm() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final Alarm451Mapping mapper = Mappers.getMapper(Alarm451Mapping.class);
		doTest(Alarm.class, x -> mapper.map(x), x -> mapper.map(x));
	}

	void testNsdPackage() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final Nsd451Mapping mapper = Mappers.getMapper(Nsd451Mapping.class);
		doTest(NsdPackage.class, x -> mapper.map(x), x -> mapper.map(x));
	}

	@Test
	void testNsInstance() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final NsInstance451Mapping mapper = Mappers.getMapper(NsInstance451Mapping.class);
		doTest(NsInstanceDto.class, x -> mapper.map(x), x -> mapper.map(x));
	}

	@Test
	void testNsLcmOpOcc() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final NsLcmOpOcc451Mapping mapper = Mappers.getMapper(NsLcmOpOcc451Mapping.class);
		doTest(NsLcmOpOcc.class, x -> mapper.map(x), x -> mapper.map(x));
	}

	@Test
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
		doTest(VnfIndicator.class, x -> mapper.map(x), x -> mapper.map(x));
	}

	@Test
	void testVnfLcmOpOcc() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final VnfLcmOpOcc451Mapping mapper = Mappers.getMapper(VnfLcmOpOcc451Mapping.class);
		doTest(VnfLcmOpOcc.class, x -> mapper.map(x), x -> mapper.map(x));
	}

//	@Test
//	void testVnfPkgInfo() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
//		final VnfPkgInfoMapping mapper = Mappers.getMapper(VnfPkgInfoMapping.class);
//		doTest(VnfPkgInfo.class, x -> mapper.map(x), x -> mapper.map(x));
//	}
	@Test
	void testFmSubscription() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final FmSubscription451Mapping mapper = Mappers.getMapper(FmSubscription451Mapping.class);
		doTest(FmSubscription.class, x -> mapper.map(x), x -> mapper.map(x));
	}

	@Test
	void testFmSubscriptionRequest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final FmSubscriptionRequest451Mapping mapper = Mappers.getMapper(FmSubscriptionRequest451Mapping.class);
		doTest(FmSubscriptionRequest.class, x -> mapper.map(x), x -> mapper.map(x));
	}

	@Test
	void testLccnSubscription() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final LccnSubscription451Mapping mapper = Mappers.getMapper(LccnSubscription451Mapping.class);
		doTest(LccnSubscription.class, x -> mapper.map(x), x -> mapper.map(x));
	}

	@Test
	void testLccnSubscriptionRequest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final LccnSubscriptionRequest451Mapping mapper = Mappers.getMapper(LccnSubscriptionRequest451Mapping.class);
		doTest(LccnSubscriptionRequest.class, x -> mapper.map(x), x -> mapper.map(x));
	}

	@Test
	void testPkgmSubscriptionRequest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
		final PkgmSubscriptionRequest451Mapping mapper = Mappers.getMapper(PkgmSubscriptionRequest451Mapping.class);
		doTest(PkgmSubscriptionRequest.class, x -> mapper.map(x), x -> mapper.map(x));
	}
}
