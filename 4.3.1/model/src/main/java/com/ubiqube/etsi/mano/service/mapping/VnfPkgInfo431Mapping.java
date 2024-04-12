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
package com.ubiqube.etsi.mano.service.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;

import com.ubiqube.etsi.mano.dao.mano.AdditionalArtifact;
import com.ubiqube.etsi.mano.dao.mano.PkgChecksum;
import com.ubiqube.etsi.mano.dao.mano.VnfPackage;
import com.ubiqube.etsi.mano.dao.mano.pkg.UploadUriParameters;
import com.ubiqube.etsi.mano.dao.mano.vim.Checksum;
import com.ubiqube.etsi.mano.dao.mano.vim.ContainerFormatType;
import com.ubiqube.etsi.mano.dao.mano.vim.SoftwareImage;
import com.ubiqube.etsi.mano.nfvo.v431.model.vnf.UploadVnfPkgFromUriRequest;
import com.ubiqube.etsi.mano.nfvo.v431.model.vnf.VnfPackageArtifactInfo;
import com.ubiqube.etsi.mano.nfvo.v431.model.vnf.VnfPackageSoftwareImageInfo;
import com.ubiqube.etsi.mano.nfvo.v431.model.vnf.VnfPkgInfo;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VnfPkgInfo431Mapping extends StringToUriMapping {

	@Mapping(target = "links", ignore = true)
	VnfPkgInfo map(VnfPackage vnfInst);

	@Mapping(target = "md5", ignore = true)
	@Mapping(target = "sha256", ignore = true)
	@Mapping(target = "sha512", ignore = true)
	Checksum map(com.ubiqube.etsi.mano.nfvo.v431.model.vnfsnapshotpkgm.Checksum o);

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
	@Mapping(target = "vnfmInfo281", ignore = true)
	VnfPackage map(VnfPkgInfo pkg);

	@Mapping(target = "certificate", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "nonManoSetIndentifier", ignore = true)
	@Mapping(target = "repository", ignore = true)
	@Mapping(target = "signature", ignore = true)
	AdditionalArtifact map(VnfPackageArtifactInfo o);

	@Mapping(target = "architecture", ignore = true)
	@Mapping(target = "audit", ignore = true)
	@Mapping(target = "nfvoPath", ignore = true)
	@Mapping(target = "repository", ignore = true)
	@Mapping(target = "vimId", ignore = true)
	SoftwareImage map(VnfPackageSoftwareImageInfo o);

	@Mapping(target = "md5", ignore = true)
	@Mapping(target = "sha256", ignore = true)
	@Mapping(target = "sha512", ignore = true)
	PkgChecksum mapToPkgChecksum(com.ubiqube.etsi.mano.nfvo.v431.model.vnfsnapshotpkgm.Checksum o);

	@ValueMapping(source = MappingConstants.ANY_REMAINING, target = "DOCKER")
	ContainerFormatType map(VnfPackageSoftwareImageInfo.ContainerFormatEnum en);

	@ValueMapping(source = MappingConstants.ANY_REMAINING, target = "DOCKER")
	VnfPackageSoftwareImageInfo.ContainerFormatEnum map(ContainerFormatType en);

	@Mapping(target = "id", ignore = true)
	UploadUriParameters map(UploadVnfPkgFromUriRequest body);
}
