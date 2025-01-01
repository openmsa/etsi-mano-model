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
package com.ubiqube.etsi.mano.nfvo.v261.factory;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ubiqube.etsi.mano.dao.mano.NsdPackage;
import com.ubiqube.etsi.mano.dao.mano.OnboardingStateType;
import com.ubiqube.etsi.mano.dao.mano.PackageOperationalState;
import com.ubiqube.etsi.mano.dao.mano.UsageStateEnum;
import com.ubiqube.etsi.mano.dao.mano.vim.Checksum;
import com.ubiqube.etsi.mano.dao.mano.vim.ContainerFormatType;
import com.ubiqube.etsi.mano.dao.mano.vim.SoftwareImage;
import com.ubiqube.etsi.mano.model.ProblemDetails;
import com.ubiqube.etsi.mano.v261.model.nfvo.nsd.NsdOnboardingStateType;
import com.ubiqube.etsi.mano.v261.model.nfvo.nsd.sol005.NsdInfo;
import com.ubiqube.etsi.mano.v261.model.nfvo.nsd.sol005.NsdOperationalStateType;
import com.ubiqube.etsi.mano.v261.model.nfvo.nsd.sol005.NsdUsageStateType;
import com.ubiqube.etsi.mano.v261.nfvo.service.NsdFactories;

public class TestFactory {

	public static ProblemDetails createOnboardingFailureDetails() {
		final ProblemDetails fd = new ProblemDetails();
		fd.setDetail("detail");
		return fd;
	}

	public static SoftwareImage createVnfPackagesVnfPkgInfoSoftwareImages() {
		final SoftwareImage si = new SoftwareImage();
		final Checksum checksum = new Checksum();
		checksum.setAlgorithm("SHA-512");
		checksum.setHash("e7c22b994c59d9cf2b48e549b1e24666636045930d3da7c1acb299d1c3b7f931f94aae41edda2c2b207a36e10f8bcb8d45223e54878f5b316e7ce3b6bc019629");
		si.setChecksum(checksum);
		si.setContainerFormat(ContainerFormatType.BARE);
		// si.setCreatedAt(OffsetDateTime.now());
		si.setImagePath("/mnt/images/myimages.raw");
		si.setSize(12345L);
		return si;
	}

	public static ProblemDetails createProblemDetails() {
		final ProblemDetails pd = new ProblemDetails();
		pd.setDetail("detail");
		pd.setInstance(URI.create("http://instance"));
		pd.setStatus(123);
		pd.setTitle("title");
		pd.setType(URI.create("type"));
		return pd;
	}

	public static NsdPackage createNsdPackage() {
		final NsdPackage nsdPackage = new NsdPackage();
		nsdPackage.setNsdOnboardingState(OnboardingStateType.ONBOARDED);
		nsdPackage.setNsdOperationalState(PackageOperationalState.ENABLED);
		nsdPackage.setNsdUsageState(UsageStateEnum.IN_USE);
		return nsdPackage;
	}

	public static NsdInfo createNsDescriptorsNsdInfo() {
		final NsdInfo nsd = NsdFactories.createNsdInfo();
		final List<UUID> nestedNsdInfoIds = new ArrayList<>();
		nestedNsdInfoIds.add(UUID.fromString("25dca365-ff1b-4204-a9ca-c3745e6d3244"));
		nestedNsdInfoIds.add(UUID.fromString("52d993dc-7a50-46da-b30c-e8fb344ef140"));
		nsd.setNestedNsdInfoIds(nestedNsdInfoIds);
		nsd.setPnfdInfoIds(nestedNsdInfoIds);
		nsd.setVnfPkgIds(nestedNsdInfoIds);
		nsd.setNsdOnboardingState(NsdOnboardingStateType.ONBOARDED);
		nsd.setNsdOperationalState(NsdOperationalStateType.ENABLED);
		nsd.setNsdUsageState(NsdUsageStateType.IN_USE);
		final ProblemDetails onboardingFailureDetails = createOnboardingFailureDetails();
		nsd.setOnboardingFailureDetails(onboardingFailureDetails);
		return nsd;
	}

}
