/**
 * This copy of Woodstox XML processor is licensed under the
 * Apache (Software) License, version 2.0 ("the License").
 * See the License for details about distribution rights, and the
 * specific rights regarding derivate works.
 *
 * You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/
 *
 * A copy is also included in the downloadable source code package
 * containing Woodstox, in file "ASL2.0", under the same directory
 * as this file.
 */
package com.ubiqube.etsi.mano.vnfm.v261;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.ubiqube.etsi.mano.common.v261.model.nslcm.VnfVirtualLinkResourceInfo;
import com.ubiqube.etsi.mano.common.v261.model.nslcm.VnfcResourceInfo;
import com.ubiqube.etsi.mano.common.v261.model.vnf.Checksum;
import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfPackageSoftwareImageInfo;
import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfPackageSoftwareImageInfo.ContainerFormatEnum;
import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfPackageSoftwareImageInfo.DiskFormatEnum;
import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfPkgInfo;
import com.ubiqube.etsi.mano.dao.mano.SoftwareImage;
import com.ubiqube.etsi.mano.dao.mano.VnfCompute;
import com.ubiqube.etsi.mano.dao.mano.VnfInstance;
import com.ubiqube.etsi.mano.dao.mano.VnfLiveInstance;
import com.ubiqube.etsi.mano.dao.mano.VnfPackage;
import com.ubiqube.etsi.mano.dao.mano.VnfStorage;
import com.ubiqube.etsi.mano.dao.mano.dto.VnfLcmOpOccs;
import com.ubiqube.etsi.mano.dao.mano.v2.Blueprint;
import com.ubiqube.etsi.mano.dao.mano.v2.ComputeTask;
import com.ubiqube.etsi.mano.dao.mano.v2.Task;
import com.ubiqube.etsi.mano.vnfm.v261.model.nslcm.AffectedVirtualLink;
import com.ubiqube.etsi.mano.vnfm.v261.model.nslcm.AffectedVnfc;
import com.ubiqube.etsi.mano.vnfm.v261.model.nslcm.VnfLcmOpOcc;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;

@Component
public class OrikaMapperVnfm261 implements OrikaMapperFactoryConfigurer {

	@Override
	public void configure(final MapperFactory orikaMapperFactory) {
		orikaMapperFactory.classMap(com.ubiqube.etsi.mano.common.v261.model.nslcm.VnfInstance.class, VnfInstance.class)
				.field("vnfPkgId", "vnfPkg.id")
				.field("vnfConfigurableProperties{key}", "vnfConfigurableProperties{key}")
				.field("vnfConfigurableProperties{value}", "vnfConfigurableProperties{value}")

				.field("metadata{key}", "metadata{key}")
				.field("metadata{value}", "metadata{value}")

				.field("extensions{key}", "extensions{key}")
				.field("extensions{value}", "extensions{value}")
				.byDefault()
				.register();

		orikaMapperFactory.classMap(VnfPackage.class, VnfPkgInfo.class)
				.byDefault()
				.customize(new CustomMapper<VnfPackage, VnfPkgInfo>() {
					@Override
					public void mapAtoB(final VnfPackage a, final VnfPkgInfo b, final MappingContext context) {
						// Remap Images
						final Set<VnfCompute> vnfc = a.getVnfCompute();
						if (null != vnfc) {
							vnfc.forEach(x -> {
								final SoftwareImage img = x.getSoftwareImage();
								if (null != img) {
									b.addSoftwareImagesItem(mapSoftwareImage(img));
								}
							});
						}
						final Set<VnfStorage> storage = a.getVnfStorage();
						if (null != storage) {
							storage.forEach(x -> {
								final SoftwareImage img = x.getSoftwareImage();
								if (null != img) {
									b.addSoftwareImagesItem(mapSoftwareImage(img));
								}
							});
						}

					}

					private VnfPackageSoftwareImageInfo mapSoftwareImage(final SoftwareImage img) {
						final VnfPackageSoftwareImageInfo ret = new VnfPackageSoftwareImageInfo();
						ret.setChecksum(mapChecksum(img.getChecksum()));
						if (null != img.getContainerFormat()) {
							ret.setContainerFormat(ContainerFormatEnum.fromValue(img.getContainerFormat()));
						}
						// ret.setCreatedAt(img.get);
						if (null != img.getDiskFormat()) {
							ret.setDiskFormat(DiskFormatEnum.valueOf(img.getDiskFormat()));
						}
						if (null != img.getId()) {
							ret.setId(img.getId().toString());
						}
						ret.setImagePath(img.getImagePath());
						ret.setMinDisk(img.getMinDisk());
						ret.setMinRam(img.getMinRam());
						ret.setName(img.getName());
						ret.setProvider(img.getProvider());
						ret.setSize(img.getSize());
						// ret.setUserMetadata(img.get);
						ret.setVersion(img.getVersion());
						return ret;
					}

					private Checksum mapChecksum(final com.ubiqube.etsi.mano.dao.mano.common.Checksum checksum) {
						final Checksum ret = new Checksum();
						ret.setAlgorithm(checksum.getAlgorithm());
						ret.setHash(checksum.getHash());
						return ret;
					}
				})
				.register();
		orikaMapperFactory.classMap(AffectedVirtualLink.class, Task.class)
				.exclude("audit")
				// .field("virtualLinkDescId", "vnfVl.id")
				.field("networkResource.resourceId", "vimResourceId")
				.field("networkResource.resourceProviderId", "resourceProviderId")
				.field("networkResource.vimConnectionId", "vimConnectionId")
				.byDefault()
				.register();
		orikaMapperFactory.classMap(AffectedVnfc.class, ComputeTask.class)
				.exclude("audit")
				.field("computeResource.resourceId", "vimResourceId")
				.field("computeResource.resourceProviderId", "resourceProviderId")
				.field("computeResource.vimConnectionId", "vimConnectionId")
				.byDefault()
				.register();
		orikaMapperFactory.classMap(VnfLcmOpOcc.class, VnfLcmOpOccs.class)
				.field("vnfInstanceId", "vnfInstance.id")
				.byDefault()
				.register();

		orikaMapperFactory.classMap(VnfcResourceInfo.class, VnfLiveInstance.class)
				// .field("vduId", "task.vnfCompute.id")
				.field("computeResource.resourceId", "task.vimResourceId")
				.field("reservationId", "task.vimReservationId")
				.field("computeResource.resourceProviderId", "task.resourceProviderId")
				.field("computeResource.vimConnectionId", "task.vimConnectionId")
				.byDefault()
				.register();
		orikaMapperFactory.classMap(VnfVirtualLinkResourceInfo.class, VnfLiveInstance.class)
				// .field("vnfVirtualLinkDescId", "task.vnfVl.id")
				.field("networkResource.resourceId", "task.vimResourceId")
				.field("reservationId", "task.vimReservationId")
				.field("networkResource.resourceProviderId", "task.resourceProviderId")
				.field("networkResource.vimConnectionId", "task.vimConnectionId")
				.byDefault()
				.register();
		orikaMapperFactory.classMap(VnfLcmOpOcc.class, Blueprint.class)
				.field("vnfInstanceId", "vnfInstance.id")
				.field("grantId", "grantsRequestId")
				.byDefault()
				.register();
	}
}
