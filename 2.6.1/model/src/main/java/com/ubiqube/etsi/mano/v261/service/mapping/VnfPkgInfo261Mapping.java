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
package com.ubiqube.etsi.mano.v261.service.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;

import com.ubiqube.etsi.mano.common.v261.model.vnf.Checksum;
import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfPackageArtifactInfo;
import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfPackageSoftwareImageInfo;
import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfPkgInfo;
import com.ubiqube.etsi.mano.dao.mano.AdditionalArtifact;
import com.ubiqube.etsi.mano.dao.mano.PkgChecksum;
import com.ubiqube.etsi.mano.dao.mano.VnfPackage;
import com.ubiqube.etsi.mano.dao.mano.pkg.UploadUriParameters;
import com.ubiqube.etsi.mano.dao.mano.vim.ContainerFormatType;
import com.ubiqube.etsi.mano.dao.mano.vim.DiskFormatType;
import com.ubiqube.etsi.mano.dao.mano.vim.SoftwareImage;
import com.ubiqube.etsi.mano.service.mapping.StringToUriMapping;
import com.ubiqube.etsi.mano.v261.model.nfvo.vnf.UploadVnfPkgFromUriRequest;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VnfPkgInfo261Mapping extends StringToUriMapping {

	@Mapping(target = "links", ignore = true)
	VnfPkgInfo map(VnfPackage vnfInst);

	@ValueMapping(source = "ARI", target = MappingConstants.THROW_EXCEPTION)
	VnfPackageSoftwareImageInfo.DiskFormatEnum map(DiskFormatType o);

	@Mapping(target = "compatibleSpecificationVersions", ignore = true)
	@Mapping(target = "onboardingFailureDetails", ignore = true)
	@Mapping(target = "packageSecurityOption", ignore = true)
	@Mapping(target = "signingCertificate", ignore = true)
	@Mapping(target = "vnfmInfo", ignore = true)
	@Mapping(target = "vnfmInfo281", ignore = true)
	@Mapping(target = "vnfdExtInvariantId", ignore = true)
	@Mapping(target = "affinityRules", ignore = true)
	@Mapping(target = "attributes", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "defaultInstantiationLevel", ignore = true)
	@Mapping(target = "defaultLocalizationLanguage", ignore = true)
	@Mapping(target = "descriptorVersion", ignore = true)
	@Mapping(target = "flavorId", ignore = true)
	@Mapping(target = "flavourDescription", ignore = true)
	@Mapping(target = "localizationLanguages", ignore = true)
	@Mapping(target = "mciopId", ignore = true)
	@Mapping(target = "mciops", ignore = true)
	@Mapping(target = "monitoringParameters", ignore = true)
	@Mapping(target = "nfvoId", ignore = true)
	@Mapping(target = "nonManoArtifactSetId", ignore = true)
	@Mapping(target = "nsInstance", ignore = true)
	@Mapping(target = "nsdPackages", ignore = true)
	@Mapping(target = "osContainer", ignore = true)
	@Mapping(target = "osContainerDeployableUnits", ignore = true)
	@Mapping(target = "osContainerDesc", ignore = true)
	@Mapping(target = "overloadedAttribute", ignore = true)
	@Mapping(target = "overwriteDescId", ignore = true)
	@Mapping(target = "packageProvider", ignore = true)
	@Mapping(target = "productInfoDescription", ignore = true)
	@Mapping(target = "repositories", ignore = true)
	@Mapping(target = "scaleStatus", ignore = true)
	@Mapping(target = "securityGroups", ignore = true)
	@Mapping(target = "server", ignore = true)
	@Mapping(target = "uploadUriParameters", ignore = true)
	@Mapping(target = "version", ignore = true)
	@Mapping(target = "vimCapabilities", ignore = true)
	@Mapping(target = "virtualCp", ignore = true)
	@Mapping(target = "virtualLinks", ignore = true)
	@Mapping(target = "vnfCompute", ignore = true)
	@Mapping(target = "vnfExtCp", ignore = true)
	@Mapping(target = "vnfIndicator", ignore = true)
	@Mapping(target = "vnfInstantiationLevels", ignore = true)
	@Mapping(target = "vnfLinkPort", ignore = true)
	@Mapping(target = "vnfProfile", ignore = true)
	@Mapping(target = "vnfStorage", ignore = true)
	@Mapping(target = "vnfVl", ignore = true)
	@Mapping(target = "vnfdContentType", ignore = true)
	VnfPackage map(VnfPkgInfo pkg);

	@Mapping(target = "md5", ignore = true)
	@Mapping(target = "sha256", ignore = true)
	@Mapping(target = "sha512", ignore = true)
	PkgChecksum map(Checksum o);

	@Mapping(target = "artifactClassification", ignore = true)
	@Mapping(target = "artifactURI", ignore = true)
	@Mapping(target = "isEncrypted", ignore = true)
	@Mapping(target = "nonManoArtifactSetId", ignore = true)
	@Mapping(target = "certificate", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "nonManoSetIndentifier", ignore = true)
	@Mapping(target = "repository", ignore = true)
	@Mapping(target = "signature", ignore = true)
	AdditionalArtifact map(VnfPackageArtifactInfo o);

	@Mapping(target = "md5", ignore = true)
	@Mapping(target = "sha256", ignore = true)
	@Mapping(target = "sha512", ignore = true)
	com.ubiqube.etsi.mano.dao.mano.vim.Checksum mapDbChecksum(Checksum o);

	@Mapping(target = "isEncrypted", ignore = true)
	@Mapping(target = "imageUri", ignore = true)
	@Mapping(target = "architecture", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "nfvoPath", ignore = true)
	@Mapping(target = "repository", ignore = true)
	@Mapping(target = "vimId", ignore = true)
	SoftwareImage map(VnfPackageSoftwareImageInfo o);

	@ValueMapping(source = MappingConstants.ANY_REMAINING, target = "DOCKER")
	ContainerFormatType map(VnfPackageSoftwareImageInfo.ContainerFormatEnum en);

	@ValueMapping(source = MappingConstants.ANY_REMAINING, target = "DOCKER")
	VnfPackageSoftwareImageInfo.ContainerFormatEnum map(ContainerFormatType en);

	@Mapping(target = "authType", ignore = true)
	@Mapping(target = "paramsOauth2ClientCredentials", ignore = true)
	@Mapping(target = "username", ignore = true)
	@Mapping(target = "id", ignore = true)
	UploadUriParameters map(UploadVnfPkgFromUriRequest body);
}
