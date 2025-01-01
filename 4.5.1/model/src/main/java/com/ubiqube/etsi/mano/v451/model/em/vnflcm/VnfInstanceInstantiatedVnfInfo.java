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
package com.ubiqube.etsi.mano.v451.model.em.vnflcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.ExtManagedVirtualLinkInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.ExtVirtualLinkInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.McioInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.MonitoringParameter;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.PaasServiceInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.ScaleInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VipCpInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VirtualCpInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VirtualStorageResourceInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VnfExtCpInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VnfOperationalStateType;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VnfVirtualLinkResourceInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VnfcInfo;
import com.ubiqube.etsi.mano.v451.model.em.vnflcm.VnfcResourceInfo;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Information specific to an instantiated VNF instance. This attribute shall be present if the instantiateState attribute value is INSTANTIATED. 
 */
@Schema(description = "Information specific to an instantiated VNF instance. This attribute shall be present if the instantiateState attribute value is INSTANTIATED. ")
@Validated


public class VnfInstanceInstantiatedVnfInfo   {
  @JsonProperty("flavourId")
  private String flavourId = null;

  @JsonProperty("vnfState")
  private VnfOperationalStateType vnfState = null;

  @JsonProperty("scaleStatus")
  @Valid
  private List<ScaleInfo> scaleStatus = null;

  @JsonProperty("maxScaleLevels")
  @Valid
  private List<ScaleInfo> maxScaleLevels = null;

  @JsonProperty("selectedDeployableModule")
  @Valid
  private List<String> selectedDeployableModule = null;

  @JsonProperty("extCpInfo")
  @Valid
  private List<VnfExtCpInfo> extCpInfo = new ArrayList<>();

  @JsonProperty("vipCpInfo")
  @Valid
  private List<VipCpInfo> vipCpInfo = null;

  @JsonProperty("virtualCpInfo")
  @Valid
  private List<VirtualCpInfo> virtualCpInfo = null;

  @JsonProperty("extVirtualLinkInfo")
  @Valid
  private List<ExtVirtualLinkInfo> extVirtualLinkInfo = null;

  @JsonProperty("extManagedVirtualLinkInfo")
  @Valid
  private List<ExtManagedVirtualLinkInfo> extManagedVirtualLinkInfo = null;

  @JsonProperty("monitoringParameters")
  @Valid
  private List<MonitoringParameter> monitoringParameters = null;

  @JsonProperty("localizationLanguage")
  private String localizationLanguage = null;

  @JsonProperty("vnfcResourceInfo")
  @Valid
  private List<VnfcResourceInfo> vnfcResourceInfo = null;

  @JsonProperty("vnfVirtualLinkResourceInfo")
  @Valid
  private List<VnfVirtualLinkResourceInfo> vnfVirtualLinkResourceInfo = null;

  @JsonProperty("virtualStorageResourceInfo")
  @Valid
  private List<VirtualStorageResourceInfo> virtualStorageResourceInfo = null;

  @JsonProperty("vnfcInfo")
  @Valid
  private List<VnfcInfo> vnfcInfo = null;

  @JsonProperty("mcioInfo")
  @Valid
  private List<McioInfo> mcioInfo = null;

  @JsonProperty("vnfPaasServiceInfo")
  @Valid
  private List<PaasServiceInfo> vnfPaasServiceInfo = null;

  public VnfInstanceInstantiatedVnfInfo flavourId(String flavourId) {
    this.flavourId = flavourId;
    return this;
  }

  /**
   * Get flavourId
   * @return flavourId
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    public String getFlavourId() {
    return flavourId;
  }

  public void setFlavourId(String flavourId) {
    this.flavourId = flavourId;
  }

  public VnfInstanceInstantiatedVnfInfo vnfState(VnfOperationalStateType vnfState) {
    this.vnfState = vnfState;
    return this;
  }

  /**
   * Get vnfState
   * @return vnfState
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    @Valid
    public VnfOperationalStateType getVnfState() {
    return vnfState;
  }

  public void setVnfState(VnfOperationalStateType vnfState) {
    this.vnfState = vnfState;
  }

  public VnfInstanceInstantiatedVnfInfo scaleStatus(List<ScaleInfo> scaleStatus) {
    this.scaleStatus = scaleStatus;
    return this;
  }

  public VnfInstanceInstantiatedVnfInfo addScaleStatusItem(ScaleInfo scaleStatusItem) {
    if (this.scaleStatus == null) {
      this.scaleStatus = new ArrayList<>();
    }
    this.scaleStatus.add(scaleStatusItem);
    return this;
  }

  /**
   * Scale status of the VNF, one entry per aspect. Represents for every scaling aspect how \"big\" the VNF has been scaled w.r.t. that aspect. This attribute shall be present if the VNF supports scaling. See clause B.2 for an explanation of VNF scaling. For an aspect that has not been deployed because the related deployableModule has not been selected, it indicates the scale level that has been requested in the instantiation or in a scaling operation, or, if none has been requested in any of them, the scale level applicable to the aspect based on the default instantiation level. See note 8. 
   * @return scaleStatus
   **/
  @Schema(description = "Scale status of the VNF, one entry per aspect. Represents for every scaling aspect how \"big\" the VNF has been scaled w.r.t. that aspect. This attribute shall be present if the VNF supports scaling. See clause B.2 for an explanation of VNF scaling. For an aspect that has not been deployed because the related deployableModule has not been selected, it indicates the scale level that has been requested in the instantiation or in a scaling operation, or, if none has been requested in any of them, the scale level applicable to the aspect based on the default instantiation level. See note 8. ")
      @Valid
    public List<ScaleInfo> getScaleStatus() {
    return scaleStatus;
  }

  public void setScaleStatus(List<ScaleInfo> scaleStatus) {
    this.scaleStatus = scaleStatus;
  }

  public VnfInstanceInstantiatedVnfInfo maxScaleLevels(List<ScaleInfo> maxScaleLevels) {
    this.maxScaleLevels = maxScaleLevels;
    return this;
  }

  public VnfInstanceInstantiatedVnfInfo addMaxScaleLevelsItem(ScaleInfo maxScaleLevelsItem) {
    if (this.maxScaleLevels == null) {
      this.maxScaleLevels = new ArrayList<>();
    }
    this.maxScaleLevels.add(maxScaleLevelsItem);
    return this;
  }

  /**
   * Maximum allowed scale levels of the VNF, one entry per aspect. This attribute shall be present if the VNF supports scaling. 
   * @return maxScaleLevels
   **/
  @Schema(description = "Maximum allowed scale levels of the VNF, one entry per aspect. This attribute shall be present if the VNF supports scaling. ")
      @Valid
    public List<ScaleInfo> getMaxScaleLevels() {
    return maxScaleLevels;
  }

  public void setMaxScaleLevels(List<ScaleInfo> maxScaleLevels) {
    this.maxScaleLevels = maxScaleLevels;
  }

  public VnfInstanceInstantiatedVnfInfo selectedDeployableModule(List<String> selectedDeployableModule) {
    this.selectedDeployableModule = selectedDeployableModule;
    return this;
  }

  public VnfInstanceInstantiatedVnfInfo addSelectedDeployableModuleItem(String selectedDeployableModuleItem) {
    if (this.selectedDeployableModule == null) {
      this.selectedDeployableModule = new ArrayList<>();
    }
    this.selectedDeployableModule.add(selectedDeployableModuleItem);
    return this;
  }

  /**
   * References a currently selected deployable module, as defined in the VNFD, that has already completed the instantiation of its VNFCs 
   * @return selectedDeployableModule
   **/
  @Schema(description = "References a currently selected deployable module, as defined in the VNFD, that has already completed the instantiation of its VNFCs ")
  
    public List<String> getSelectedDeployableModule() {
    return selectedDeployableModule;
  }

  public void setSelectedDeployableModule(List<String> selectedDeployableModule) {
    this.selectedDeployableModule = selectedDeployableModule;
  }

  public VnfInstanceInstantiatedVnfInfo extCpInfo(List<VnfExtCpInfo> extCpInfo) {
    this.extCpInfo = extCpInfo;
    return this;
  }

  public VnfInstanceInstantiatedVnfInfo addExtCpInfoItem(VnfExtCpInfo extCpInfoItem) {
    this.extCpInfo.add(extCpInfoItem);
    return this;
  }

  /**
   * Information about the external CPs exposed by the VNF instance. When trunking is enabled, the list of entries includes both, external CPs corresponding to parent ports of a trunk, and external CPs associated to sub-ports of a trunk. See note 7. 
   * @return extCpInfo
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Information about the external CPs exposed by the VNF instance. When trunking is enabled, the list of entries includes both, external CPs corresponding to parent ports of a trunk, and external CPs associated to sub-ports of a trunk. See note 7. ")
      @NotNull
    @Valid
  @Size(min=1)   public List<VnfExtCpInfo> getExtCpInfo() {
    return extCpInfo;
  }

  public void setExtCpInfo(List<VnfExtCpInfo> extCpInfo) {
    this.extCpInfo = extCpInfo;
  }

  public VnfInstanceInstantiatedVnfInfo vipCpInfo(List<VipCpInfo> vipCpInfo) {
    this.vipCpInfo = vipCpInfo;
    return this;
  }

  public VnfInstanceInstantiatedVnfInfo addVipCpInfoItem(VipCpInfo vipCpInfoItem) {
    if (this.vipCpInfo == null) {
      this.vipCpInfo = new ArrayList<>();
    }
    this.vipCpInfo.add(vipCpInfoItem);
    return this;
  }

  /**
   * VIP CPs that are part of the VNF instance. Shall be present when that particular VIP CP of the VNFC instance is associated to an external CP of the VNF instance. May be present otherwise. 
   * @return vipCpInfo
   **/
  @Schema(description = "VIP CPs that are part of the VNF instance. Shall be present when that particular VIP CP of the VNFC instance is associated to an external CP of the VNF instance. May be present otherwise. ")
      @Valid
    public List<VipCpInfo> getVipCpInfo() {
    return vipCpInfo;
  }

  public void setVipCpInfo(List<VipCpInfo> vipCpInfo) {
    this.vipCpInfo = vipCpInfo;
  }

  public VnfInstanceInstantiatedVnfInfo virtualCpInfo(List<VirtualCpInfo> virtualCpInfo) {
    this.virtualCpInfo = virtualCpInfo;
    return this;
  }

  public VnfInstanceInstantiatedVnfInfo addVirtualCpInfoItem(VirtualCpInfo virtualCpInfoItem) {
    if (this.virtualCpInfo == null) {
      this.virtualCpInfo = new ArrayList<>();
    }
    this.virtualCpInfo.add(virtualCpInfoItem);
    return this;
  }

  /**
   * Virtual CPs that are part of the VNF instance. Shall be present when a particular virtual CP is  associated to an external CP of the VNF instance. May be present otherwise. 
   * @return virtualCpInfo
   **/
  @Schema(description = "Virtual CPs that are part of the VNF instance. Shall be present when a particular virtual CP is  associated to an external CP of the VNF instance. May be present otherwise. ")
      @Valid
    public List<VirtualCpInfo> getVirtualCpInfo() {
    return virtualCpInfo;
  }

  public void setVirtualCpInfo(List<VirtualCpInfo> virtualCpInfo) {
    this.virtualCpInfo = virtualCpInfo;
  }

  public VnfInstanceInstantiatedVnfInfo extVirtualLinkInfo(List<ExtVirtualLinkInfo> extVirtualLinkInfo) {
    this.extVirtualLinkInfo = extVirtualLinkInfo;
    return this;
  }

  public VnfInstanceInstantiatedVnfInfo addExtVirtualLinkInfoItem(ExtVirtualLinkInfo extVirtualLinkInfoItem) {
    if (this.extVirtualLinkInfo == null) {
      this.extVirtualLinkInfo = new ArrayList<>();
    }
    this.extVirtualLinkInfo.add(extVirtualLinkInfoItem);
    return this;
  }

  /**
   * Information about the external VLs the VNF instance is connected to. 
   * @return extVirtualLinkInfo
   **/
  @Schema(description = "Information about the external VLs the VNF instance is connected to. ")
      @Valid
    public List<ExtVirtualLinkInfo> getExtVirtualLinkInfo() {
    return extVirtualLinkInfo;
  }

  public void setExtVirtualLinkInfo(List<ExtVirtualLinkInfo> extVirtualLinkInfo) {
    this.extVirtualLinkInfo = extVirtualLinkInfo;
  }

  public VnfInstanceInstantiatedVnfInfo extManagedVirtualLinkInfo(List<ExtManagedVirtualLinkInfo> extManagedVirtualLinkInfo) {
    this.extManagedVirtualLinkInfo = extManagedVirtualLinkInfo;
    return this;
  }

  public VnfInstanceInstantiatedVnfInfo addExtManagedVirtualLinkInfoItem(ExtManagedVirtualLinkInfo extManagedVirtualLinkInfoItem) {
    if (this.extManagedVirtualLinkInfo == null) {
      this.extManagedVirtualLinkInfo = new ArrayList<>();
    }
    this.extManagedVirtualLinkInfo.add(extManagedVirtualLinkInfoItem);
    return this;
  }

  /**
   * Information about the externally managed internal VLs of the VNF instance. See note 5 and note 6. It is possible to have several ExtManagedVirtualLinkInfo for the same VNF internal VL in case of a multi-site VNF spanning several VIMs. The set of ExtManagedVirtualLinkInfo corresponding to the same VNF internal VL shall indicate so by referencing to the same VnfVirtualLinkDesc and externally-managed multi-site VL instance (refer to clause 5.5.3.5). Even though externally-managed internal VLs are also used for VNF-internal connectivity, they shall not be listed in the \"vnfVirtualLinkResourceInfo\" attribute as this would be redundant. 
   * @return extManagedVirtualLinkInfo
   **/
  @Schema(description = "Information about the externally managed internal VLs of the VNF instance. See note 5 and note 6. It is possible to have several ExtManagedVirtualLinkInfo for the same VNF internal VL in case of a multi-site VNF spanning several VIMs. The set of ExtManagedVirtualLinkInfo corresponding to the same VNF internal VL shall indicate so by referencing to the same VnfVirtualLinkDesc and externally-managed multi-site VL instance (refer to clause 5.5.3.5). Even though externally-managed internal VLs are also used for VNF-internal connectivity, they shall not be listed in the \"vnfVirtualLinkResourceInfo\" attribute as this would be redundant. ")
      @Valid
    public List<ExtManagedVirtualLinkInfo> getExtManagedVirtualLinkInfo() {
    return extManagedVirtualLinkInfo;
  }

  public void setExtManagedVirtualLinkInfo(List<ExtManagedVirtualLinkInfo> extManagedVirtualLinkInfo) {
    this.extManagedVirtualLinkInfo = extManagedVirtualLinkInfo;
  }

  public VnfInstanceInstantiatedVnfInfo monitoringParameters(List<MonitoringParameter> monitoringParameters) {
    this.monitoringParameters = monitoringParameters;
    return this;
  }

  public VnfInstanceInstantiatedVnfInfo addMonitoringParametersItem(MonitoringParameter monitoringParametersItem) {
    if (this.monitoringParameters == null) {
      this.monitoringParameters = new ArrayList<>();
    }
    this.monitoringParameters.add(monitoringParametersItem);
    return this;
  }

  /**
   * Active monitoring parameters. 
   * @return monitoringParameters
   **/
  @Schema(description = "Active monitoring parameters. ")
      @Valid
    public List<MonitoringParameter> getMonitoringParameters() {
    return monitoringParameters;
  }

  public void setMonitoringParameters(List<MonitoringParameter> monitoringParameters) {
    this.monitoringParameters = monitoringParameters;
  }

  public VnfInstanceInstantiatedVnfInfo localizationLanguage(String localizationLanguage) {
    this.localizationLanguage = localizationLanguage;
    return this;
  }

  /**
   * Information about localization language of the VNF (includes e.g. strings in the VNFD). The localization languages supported by a VNF can be declared in the VNFD, and localization language selection can take place at instantiation time. The value shall comply with the format defined in IETF RFC 5646. 
   * @return localizationLanguage
   **/
  @Schema(description = "Information about localization language of the VNF (includes e.g. strings in the VNFD). The localization languages supported by a VNF can be declared in the VNFD, and localization language selection can take place at instantiation time. The value shall comply with the format defined in IETF RFC 5646. ")
  
    public String getLocalizationLanguage() {
    return localizationLanguage;
  }

  public void setLocalizationLanguage(String localizationLanguage) {
    this.localizationLanguage = localizationLanguage;
  }

  public VnfInstanceInstantiatedVnfInfo vnfcResourceInfo(List<VnfcResourceInfo> vnfcResourceInfo) {
    this.vnfcResourceInfo = vnfcResourceInfo;
    return this;
  }

  public VnfInstanceInstantiatedVnfInfo addVnfcResourceInfoItem(VnfcResourceInfo vnfcResourceInfoItem) {
    if (this.vnfcResourceInfo == null) {
      this.vnfcResourceInfo = new ArrayList<>();
    }
    this.vnfcResourceInfo.add(vnfcResourceInfoItem);
    return this;
  }

  /**
   * Information about the virtualised compute and storage resources used by the VNFCs of the VNF instance. 
   * @return vnfcResourceInfo
   **/
  @Schema(description = "Information about the virtualised compute and storage resources used by the VNFCs of the VNF instance. ")
      @Valid
    public List<VnfcResourceInfo> getVnfcResourceInfo() {
    return vnfcResourceInfo;
  }

  public void setVnfcResourceInfo(List<VnfcResourceInfo> vnfcResourceInfo) {
    this.vnfcResourceInfo = vnfcResourceInfo;
  }

  public VnfInstanceInstantiatedVnfInfo vnfVirtualLinkResourceInfo(List<VnfVirtualLinkResourceInfo> vnfVirtualLinkResourceInfo) {
    this.vnfVirtualLinkResourceInfo = vnfVirtualLinkResourceInfo;
    return this;
  }

  public VnfInstanceInstantiatedVnfInfo addVnfVirtualLinkResourceInfoItem(VnfVirtualLinkResourceInfo vnfVirtualLinkResourceInfoItem) {
    if (this.vnfVirtualLinkResourceInfo == null) {
      this.vnfVirtualLinkResourceInfo = new ArrayList<>();
    }
    this.vnfVirtualLinkResourceInfo.add(vnfVirtualLinkResourceInfoItem);
    return this;
  }

  /**
   * Information about the virtualised network resources used by the VLs of the VNF instance. See note 6. Even though externally-managed internal VLs are also used for VNF-internal connectivity, they shall not be listed in the \"vnfVirtualLinkResourceInfo\" attribute as this would be redundant. 
   * @return vnfVirtualLinkResourceInfo
   **/
  @Schema(description = "Information about the virtualised network resources used by the VLs of the VNF instance. See note 6. Even though externally-managed internal VLs are also used for VNF-internal connectivity, they shall not be listed in the \"vnfVirtualLinkResourceInfo\" attribute as this would be redundant. ")
      @Valid
    public List<VnfVirtualLinkResourceInfo> getVnfVirtualLinkResourceInfo() {
    return vnfVirtualLinkResourceInfo;
  }

  public void setVnfVirtualLinkResourceInfo(List<VnfVirtualLinkResourceInfo> vnfVirtualLinkResourceInfo) {
    this.vnfVirtualLinkResourceInfo = vnfVirtualLinkResourceInfo;
  }

  public VnfInstanceInstantiatedVnfInfo virtualStorageResourceInfo(List<VirtualStorageResourceInfo> virtualStorageResourceInfo) {
    this.virtualStorageResourceInfo = virtualStorageResourceInfo;
    return this;
  }

  public VnfInstanceInstantiatedVnfInfo addVirtualStorageResourceInfoItem(VirtualStorageResourceInfo virtualStorageResourceInfoItem) {
    if (this.virtualStorageResourceInfo == null) {
      this.virtualStorageResourceInfo = new ArrayList<>();
    }
    this.virtualStorageResourceInfo.add(virtualStorageResourceInfoItem);
    return this;
  }

  /**
   * Information on the virtualised storage resource(s) used as storage for the VNF instance. 
   * @return virtualStorageResourceInfo
   **/
  @Schema(description = "Information on the virtualised storage resource(s) used as storage for the VNF instance. ")
      @Valid
    public List<VirtualStorageResourceInfo> getVirtualStorageResourceInfo() {
    return virtualStorageResourceInfo;
  }

  public void setVirtualStorageResourceInfo(List<VirtualStorageResourceInfo> virtualStorageResourceInfo) {
    this.virtualStorageResourceInfo = virtualStorageResourceInfo;
  }

  public VnfInstanceInstantiatedVnfInfo vnfcInfo(List<VnfcInfo> vnfcInfo) {
    this.vnfcInfo = vnfcInfo;
    return this;
  }

  public VnfInstanceInstantiatedVnfInfo addVnfcInfoItem(VnfcInfo vnfcInfoItem) {
    if (this.vnfcInfo == null) {
      this.vnfcInfo = new ArrayList<>();
    }
    this.vnfcInfo.add(vnfcInfoItem);
    return this;
  }

  /**
   * Information about the VNFC instances. 
   * @return vnfcInfo
   **/
  @Schema(description = "Information about the VNFC instances. ")
      @Valid
    public List<VnfcInfo> getVnfcInfo() {
    return vnfcInfo;
  }

  public void setVnfcInfo(List<VnfcInfo> vnfcInfo) {
    this.vnfcInfo = vnfcInfo;
  }

  public VnfInstanceInstantiatedVnfInfo mcioInfo(List<McioInfo> mcioInfo) {
    this.mcioInfo = mcioInfo;
    return this;
  }

  public VnfInstanceInstantiatedVnfInfo addMcioInfoItem(McioInfo mcioInfoItem) {
    if (this.mcioInfo == null) {
      this.mcioInfo = new ArrayList<>();
    }
    this.mcioInfo.add(mcioInfoItem);
    return this;
  }

  /**
   * Information on the MCIO(s) representing VNFC instance(s) realized by one or a set of OS containers  and created from the same VDU for the VNF instance. 
   * @return mcioInfo
   **/
  @Schema(description = "Information on the MCIO(s) representing VNFC instance(s) realized by one or a set of OS containers  and created from the same VDU for the VNF instance. ")
      @Valid
    public List<McioInfo> getMcioInfo() {
    return mcioInfo;
  }

  public void setMcioInfo(List<McioInfo> mcioInfo) {
    this.mcioInfo = mcioInfo;
  }

  public VnfInstanceInstantiatedVnfInfo vnfPaasServiceInfo(List<PaasServiceInfo> vnfPaasServiceInfo) {
    this.vnfPaasServiceInfo = vnfPaasServiceInfo;
    return this;
  }

  public VnfInstanceInstantiatedVnfInfo addVnfPaasServiceInfoItem(PaasServiceInfo vnfPaasServiceInfoItem) {
    if (this.vnfPaasServiceInfo == null) {
      this.vnfPaasServiceInfo = new ArrayList<>();
    }
    this.vnfPaasServiceInfo.add(vnfPaasServiceInfoItem);
    return this;
  }

  /**
   * Information on the PaaS Services assigned and used by the VNF instance. 
   * @return vnfPaasServiceInfo
   **/
  @Schema(description = "Information on the PaaS Services assigned and used by the VNF instance. ")
      @Valid
    public List<PaasServiceInfo> getVnfPaasServiceInfo() {
    return vnfPaasServiceInfo;
  }

  public void setVnfPaasServiceInfo(List<PaasServiceInfo> vnfPaasServiceInfo) {
    this.vnfPaasServiceInfo = vnfPaasServiceInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VnfInstanceInstantiatedVnfInfo vnfInstanceInstantiatedVnfInfo = (VnfInstanceInstantiatedVnfInfo) o;
    return Objects.equals(this.flavourId, vnfInstanceInstantiatedVnfInfo.flavourId) &&
        Objects.equals(this.vnfState, vnfInstanceInstantiatedVnfInfo.vnfState) &&
        Objects.equals(this.scaleStatus, vnfInstanceInstantiatedVnfInfo.scaleStatus) &&
        Objects.equals(this.maxScaleLevels, vnfInstanceInstantiatedVnfInfo.maxScaleLevels) &&
        Objects.equals(this.selectedDeployableModule, vnfInstanceInstantiatedVnfInfo.selectedDeployableModule) &&
        Objects.equals(this.extCpInfo, vnfInstanceInstantiatedVnfInfo.extCpInfo) &&
        Objects.equals(this.vipCpInfo, vnfInstanceInstantiatedVnfInfo.vipCpInfo) &&
        Objects.equals(this.virtualCpInfo, vnfInstanceInstantiatedVnfInfo.virtualCpInfo) &&
        Objects.equals(this.extVirtualLinkInfo, vnfInstanceInstantiatedVnfInfo.extVirtualLinkInfo) &&
        Objects.equals(this.extManagedVirtualLinkInfo, vnfInstanceInstantiatedVnfInfo.extManagedVirtualLinkInfo) &&
        Objects.equals(this.monitoringParameters, vnfInstanceInstantiatedVnfInfo.monitoringParameters) &&
        Objects.equals(this.localizationLanguage, vnfInstanceInstantiatedVnfInfo.localizationLanguage) &&
        Objects.equals(this.vnfcResourceInfo, vnfInstanceInstantiatedVnfInfo.vnfcResourceInfo) &&
        Objects.equals(this.vnfVirtualLinkResourceInfo, vnfInstanceInstantiatedVnfInfo.vnfVirtualLinkResourceInfo) &&
        Objects.equals(this.virtualStorageResourceInfo, vnfInstanceInstantiatedVnfInfo.virtualStorageResourceInfo) &&
        Objects.equals(this.vnfcInfo, vnfInstanceInstantiatedVnfInfo.vnfcInfo) &&
        Objects.equals(this.mcioInfo, vnfInstanceInstantiatedVnfInfo.mcioInfo) &&
        Objects.equals(this.vnfPaasServiceInfo, vnfInstanceInstantiatedVnfInfo.vnfPaasServiceInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flavourId, vnfState, scaleStatus, maxScaleLevels, selectedDeployableModule, extCpInfo, vipCpInfo, virtualCpInfo, extVirtualLinkInfo, extManagedVirtualLinkInfo, monitoringParameters, localizationLanguage, vnfcResourceInfo, vnfVirtualLinkResourceInfo, virtualStorageResourceInfo, vnfcInfo, mcioInfo, vnfPaasServiceInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VnfInstanceInstantiatedVnfInfo {\n");
    
    sb.append("    flavourId: ").append(toIndentedString(flavourId)).append("\n");
    sb.append("    vnfState: ").append(toIndentedString(vnfState)).append("\n");
    sb.append("    scaleStatus: ").append(toIndentedString(scaleStatus)).append("\n");
    sb.append("    maxScaleLevels: ").append(toIndentedString(maxScaleLevels)).append("\n");
    sb.append("    selectedDeployableModule: ").append(toIndentedString(selectedDeployableModule)).append("\n");
    sb.append("    extCpInfo: ").append(toIndentedString(extCpInfo)).append("\n");
    sb.append("    vipCpInfo: ").append(toIndentedString(vipCpInfo)).append("\n");
    sb.append("    virtualCpInfo: ").append(toIndentedString(virtualCpInfo)).append("\n");
    sb.append("    extVirtualLinkInfo: ").append(toIndentedString(extVirtualLinkInfo)).append("\n");
    sb.append("    extManagedVirtualLinkInfo: ").append(toIndentedString(extManagedVirtualLinkInfo)).append("\n");
    sb.append("    monitoringParameters: ").append(toIndentedString(monitoringParameters)).append("\n");
    sb.append("    localizationLanguage: ").append(toIndentedString(localizationLanguage)).append("\n");
    sb.append("    vnfcResourceInfo: ").append(toIndentedString(vnfcResourceInfo)).append("\n");
    sb.append("    vnfVirtualLinkResourceInfo: ").append(toIndentedString(vnfVirtualLinkResourceInfo)).append("\n");
    sb.append("    virtualStorageResourceInfo: ").append(toIndentedString(virtualStorageResourceInfo)).append("\n");
    sb.append("    vnfcInfo: ").append(toIndentedString(vnfcInfo)).append("\n");
    sb.append("    mcioInfo: ").append(toIndentedString(mcioInfo)).append("\n");
    sb.append("    vnfPaasServiceInfo: ").append(toIndentedString(vnfPaasServiceInfo)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
