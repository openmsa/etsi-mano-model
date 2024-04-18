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

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.ubiqube.etsi.mano.dao.mano.GrantResponse;
import com.ubiqube.etsi.mano.dao.mano.NsdInstance;
import com.ubiqube.etsi.mano.dao.mano.NsdPackage;
import com.ubiqube.etsi.mano.dao.mano.VnfInstance;
import com.ubiqube.etsi.mano.dao.mano.v2.nfvo.NsBlueprint;
import com.ubiqube.etsi.mano.test.TestHelper;
import com.ubiqube.etsi.mano.v281.model.nfvo.nsd.NsdInfo;
import com.ubiqube.etsi.mano.v281.model.nfvo.nslcm.NsInstance;
import com.ubiqube.etsi.mano.v281.model.nfvo.nslcm.NsLcmOpOcc;
import com.ubiqube.etsi.mano.v281.model.vnfm.grant.GrantRequest;
import com.ubiqube.etsi.mano.v281.nfvo.service.OrikaConfigurationNfvo281;

class MappingTest extends TestHelper {

	public MappingTest() {
		super(new OrikaConfigurationNfvo281());
	}

	@Test
	void testNsdInfo() throws Exception {
		final Set<String> ignore = new HashSet<>();
		ignore.add("getLinks");
		doTest(NsdInfo.class, NsdPackage.class, ignore);
	}

	@Test
	void testNsLcmOpOcc() throws Exception {
		final Set<String> ignore = new HashSet<>();
		ignore.add("getLinks");
		ignore.add("getResourceChanges");
		// ignore.add("getStatusEnteredTime");
		// ignore.add("getOperationParams");
		// ignore.add("getCancelMode");
		doTest(NsLcmOpOcc.class, NsBlueprint.class, ignore);
	}

	@Test
	void testGrant() throws Exception {
		final Set<String> ignore = new HashSet<>();
		ignore.add("getLinks");
		ignore.add("getResourceTemplateId");
		doTest(GrantRequest.class, GrantResponse.class, ignore);
	}

	@Test
	void testNsdInstance() throws Exception {
		final Set<String> ignore = new HashSet<>();
		ignore.add("getLinks");
		ignore.add("getVnfInstance");
		ignore.add("getVirtualLinkInfo");
		ignore.add("getPnfInfo");
		ignore.add("getSapInfo");
		ignore.add("getVnffgInfo");
		ignore.add("getAdditionalAffinityOrAntiAffinityRule");
		ignore.add("getMonitoringParameter");
		ignore.add("getNsScaleStatus");
		doTest(NsInstance.class, NsdInstance.class, ignore);
	}

	@Test
	void testVnfInstance() throws Exception {
		final Set<String> ignore = new HashSet<>();
		ignore.add("getLinks");
		doTest(com.ubiqube.etsi.mano.v281.model.em.vnflcm.VnfInstance.class, VnfInstance.class, ignore);
	}

}
