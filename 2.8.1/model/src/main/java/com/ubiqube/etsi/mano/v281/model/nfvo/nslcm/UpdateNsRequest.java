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
package com.ubiqube.etsi.mano.v281.model.nfvo.nslcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ubiqube.etsi.mano.v281.model.nfvo.nslcm.AddPnfData;
import com.ubiqube.etsi.mano.v281.model.nfvo.nslcm.AddVnffgData;
import com.ubiqube.etsi.mano.v281.model.nfvo.nslcm.AssocNewNsdVersionData;
import com.ubiqube.etsi.mano.v281.model.nfvo.nslcm.ChangeExtVnfConnectivityData;
import com.ubiqube.etsi.mano.v281.model.nfvo.nslcm.ChangeNsFlavourData;
import com.ubiqube.etsi.mano.v281.model.nfvo.nslcm.ChangeVnfFlavourData;
import com.ubiqube.etsi.mano.v281.model.nfvo.nslcm.InstantiateVnfData;
import com.ubiqube.etsi.mano.v281.model.nfvo.nslcm.ModifyPnfData;
import com.ubiqube.etsi.mano.v281.model.nfvo.nslcm.ModifyVnfInfoData;
import com.ubiqube.etsi.mano.v281.model.nfvo.nslcm.MoveVnfInstanceData;
import com.ubiqube.etsi.mano.v281.model.nfvo.nslcm.NestedNsInstanceData;
import com.ubiqube.etsi.mano.v281.model.nfvo.nslcm.OperateVnfData;
import com.ubiqube.etsi.mano.v281.model.nfvo.nslcm.SapData;
import com.ubiqube.etsi.mano.v281.model.nfvo.nslcm.UpdateVnffgData;
import com.ubiqube.etsi.mano.v281.model.nfvo.nslcm.VnfInstanceData;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This operation supports the update of a NS instance,  It shall comply with the provisions defined in Table 6.5.2.12-1. 
 */
@Schema (description= "This operation supports the update of a NS instance,  It shall comply with the provisions defined in Table 6.5.2.12-1. " )
@Validated

public class UpdateNsRequest   {
  /**
   * The type of update. It determines also which one of the following parameters is present in the operation. Possible values include: * ADD_VNF: Adding existing VNF instance(s) * REMOVE_VNF: Removing VNF instance(s) * INSTANTIATE_VNF: Instantiating new VNF(s) * CHANGE_VNF_DF: Changing VNF DF * OPERATE_VNF: Changing VNF state, * MODIFY_VNF_INFORMATION: Modifying VNF information and/or the configurable properties of VNF instance(s) * CHANGE_EXTERNAL_VNF_CONNECTIVITY: Changing the external connectivity of VNF instance(s) * ADD_SAP: Adding SAP(s) * REMOVE_SAP: Removing SAP(s) * ADD_NESTED_NS: Adding existing NS instance(s) as nested NS(s) * REMOVE_NESTED_NS: Removing existing nested NS instance(s) * ASSOC_NEW_NSD_VERSION: Associating a new NSD version to the NS instance * MOVE_VNF: Moving VNF instance(s) from one origin NS instance to another target NS instance * ADD_VNFFG: Adding VNFFG(s) * REMOVE_VNFFG: Removing VNFFG(s) * UPDATE_VNFFG: Updating VNFFG(s) * CHANGE_NS_DF: Changing NS DF * ADD_PNF: Adding PNF * MODIFY_PNF: Modifying PNF * REMOVE_PNF: Removing PNF 
   */
  public enum UpdateTypeEnum {
    ADD_VNF("ADD_VNF"),
    
    REMOVE_VNF("REMOVE_VNF"),
    
    INSTANTIATE_VNF("INSTANTIATE_VNF"),
    
    CHANGE_VNF_DF("CHANGE_VNF_DF"),
    
    OPERATE_VNF("OPERATE_VNF"),
    
    MODIFY_VNF_INFORMATION("MODIFY_VNF_INFORMATION"),
    
    CHANGE_EXTERNAL_VNF_CONNECTIVITY("CHANGE_EXTERNAL_VNF_CONNECTIVITY"),
    
    ADD_SAP("ADD SAP"),
    
    REMOVE_SAP("REMOVE_SAP"),
    
    ADD_NESTED_NS("ADD_NESTED_NS"),
    
    REMOVE_NESTED_NS("REMOVE_NESTED_NS"),
    
    ASSOC_NEW_NSD_VERSION("ASSOC_NEW_NSD_VERSION"),
    
    MOVE_VNF("MOVE_VNF"),
    
    ADD_VNFFG("ADD_VNFFG"),
    
    REMOVE_VNFFG("REMOVE_VNFFG"),
    
    UPDATE_VNFFG("UPDATE_VNFFG"),
    
    CHANGE_NS_DF("CHANGE_NS_DF"),
    
    ADD_PNF("ADD_PNF"),
    
    MODIFY_PNF("MODIFY_PNF"),
    
    REMOVE_PNF("REMOVE_PNF");

    private String value;

    UpdateTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static UpdateTypeEnum fromValue(String text) {
      for (UpdateTypeEnum b : UpdateTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("updateType")
  private UpdateTypeEnum updateType = null;

  @JsonProperty("addVnfIstance")
  @Valid
  private List<VnfInstanceData> addVnfIstance = null;

  @JsonProperty("removeVnfInstanceId")
  @Valid
  private List<String> removeVnfInstanceId = null;

  @JsonProperty("instantiateVnfData")
  @Valid
  private List<InstantiateVnfData> instantiateVnfData = null;

  @JsonProperty("changeVnfFlavourData")
  @Valid
  private List<ChangeVnfFlavourData> changeVnfFlavourData = null;

  @JsonProperty("operateVnfData")
  @Valid
  private List<OperateVnfData> operateVnfData = null;

  @JsonProperty("modifyVnfInfoData")
  @Valid
  private List<ModifyVnfInfoData> modifyVnfInfoData = null;

  @JsonProperty("changeExtVnfConnectivityData")
  @Valid
  private List<ChangeExtVnfConnectivityData> changeExtVnfConnectivityData = null;

  @JsonProperty("addSap")
  @Valid
  private List<SapData> addSap = null;

  @JsonProperty("removeSapId")
  @Valid
  private List<String> removeSapId = null;

  @JsonProperty("addNestedNsData")
  @Valid
  private List<NestedNsInstanceData> addNestedNsData = null;

  @JsonProperty("removeNestedNsId")
  @Valid
  private List<String> removeNestedNsId = null;

  @JsonProperty("assocNewNsdVersionData")
  private AssocNewNsdVersionData assocNewNsdVersionData = null;

  @JsonProperty("moveVnfInstanceData")
  @Valid
  private List<MoveVnfInstanceData> moveVnfInstanceData = null;

  @JsonProperty("addVnffg")
  @Valid
  private List<AddVnffgData> addVnffg = null;

  @JsonProperty("removeVnffgId")
  @Valid
  private List<String> removeVnffgId = null;

  @JsonProperty("updateVnffg")
  @Valid
  private List<UpdateVnffgData> updateVnffg = null;

  @JsonProperty("changeNsFlavourData")
  private ChangeNsFlavourData changeNsFlavourData = null;

  @JsonProperty("addPnfData")
  @Valid
  private List<AddPnfData> addPnfData = null;

  @JsonProperty("modifyPnfData")
  @Valid
  private List<ModifyPnfData> modifyPnfData = null;

  @JsonProperty("removePnfId")
  @Valid
  private List<String> removePnfId = null;

  @JsonProperty("updateTime")
  private OffsetDateTime updateTime = null;

  public UpdateNsRequest updateType(UpdateTypeEnum updateType) {
    this.updateType = updateType;
    return this;
  }

  /**
   * The type of update. It determines also which one of the following parameters is present in the operation. Possible values include: * ADD_VNF: Adding existing VNF instance(s) * REMOVE_VNF: Removing VNF instance(s) * INSTANTIATE_VNF: Instantiating new VNF(s) * CHANGE_VNF_DF: Changing VNF DF * OPERATE_VNF: Changing VNF state, * MODIFY_VNF_INFORMATION: Modifying VNF information and/or the configurable properties of VNF instance(s) * CHANGE_EXTERNAL_VNF_CONNECTIVITY: Changing the external connectivity of VNF instance(s) * ADD_SAP: Adding SAP(s) * REMOVE_SAP: Removing SAP(s) * ADD_NESTED_NS: Adding existing NS instance(s) as nested NS(s) * REMOVE_NESTED_NS: Removing existing nested NS instance(s) * ASSOC_NEW_NSD_VERSION: Associating a new NSD version to the NS instance * MOVE_VNF: Moving VNF instance(s) from one origin NS instance to another target NS instance * ADD_VNFFG: Adding VNFFG(s) * REMOVE_VNFFG: Removing VNFFG(s) * UPDATE_VNFFG: Updating VNFFG(s) * CHANGE_NS_DF: Changing NS DF * ADD_PNF: Adding PNF * MODIFY_PNF: Modifying PNF * REMOVE_PNF: Removing PNF 
   * @return updateType
  **/
  @Schema(required = true , description = "The type of update. It determines also which one of the following parameters is present in the operation. Possible values include: * ADD_VNF: Adding existing VNF instance(s) * REMOVE_VNF: Removing VNF instance(s) * INSTANTIATE_VNF: Instantiating new VNF(s) * CHANGE_VNF_DF: Changing VNF DF * OPERATE_VNF: Changing VNF state, * MODIFY_VNF_INFORMATION: Modifying VNF information and/or the configurable properties of VNF instance(s) * CHANGE_EXTERNAL_VNF_CONNECTIVITY: Changing the external connectivity of VNF instance(s) * ADD_SAP: Adding SAP(s) * REMOVE_SAP: Removing SAP(s) * ADD_NESTED_NS: Adding existing NS instance(s) as nested NS(s) * REMOVE_NESTED_NS: Removing existing nested NS instance(s) * ASSOC_NEW_NSD_VERSION: Associating a new NSD version to the NS instance * MOVE_VNF: Moving VNF instance(s) from one origin NS instance to another target NS instance * ADD_VNFFG: Adding VNFFG(s) * REMOVE_VNFFG: Removing VNFFG(s) * UPDATE_VNFFG: Updating VNFFG(s) * CHANGE_NS_DF: Changing NS DF * ADD_PNF: Adding PNF * MODIFY_PNF: Modifying PNF * REMOVE_PNF: Removing PNF ")
  @NotNull


  public UpdateTypeEnum getUpdateType() {
    return updateType;
  }

  public void setUpdateType(UpdateTypeEnum updateType) {
    this.updateType = updateType;
  }

  public UpdateNsRequest addVnfIstance(List<VnfInstanceData> addVnfIstance) {
    this.addVnfIstance = addVnfIstance;
    return this;
  }

  public UpdateNsRequest addAddVnfIstanceItem(VnfInstanceData addVnfIstanceItem) {
    if (this.addVnfIstance == null) {
      this.addVnfIstance = new ArrayList<>();
    }
    this.addVnfIstance.add(addVnfIstanceItem);
    return this;
  }

  /**
   * Identifies an existing VNF instance to be added to the NS instance. It shall be present only if updateType = \"ADD_VNF\".          
   * @return addVnfIstance
  **/
  @Schema(description = "Identifies an existing VNF instance to be added to the NS instance. It shall be present only if updateType = \"ADD_VNF\".          ")

  @Valid

  public List<VnfInstanceData> getAddVnfIstance() {
    return addVnfIstance;
  }

  public void setAddVnfIstance(List<VnfInstanceData> addVnfIstance) {
    this.addVnfIstance = addVnfIstance;
  }

  public UpdateNsRequest removeVnfInstanceId(List<String> removeVnfInstanceId) {
    this.removeVnfInstanceId = removeVnfInstanceId;
    return this;
  }

  public UpdateNsRequest addRemoveVnfInstanceIdItem(String removeVnfInstanceIdItem) {
    if (this.removeVnfInstanceId == null) {
      this.removeVnfInstanceId = new ArrayList<>();
    }
    this.removeVnfInstanceId.add(removeVnfInstanceIdItem);
    return this;
  }

  /**
   * Identifies an existing VNF instance to be removed from the NS instance. It contains the identifier(s) of the VNF instances to be removed. It shall be present only if updateType = \"REMOVE_VNF.\" Note: If a VNF instance is removed from a NS and this NS was the last one for which this VNF instance was a part, the VNF instance is terminated by the NFVO. 
   * @return removeVnfInstanceId
  **/
  @Schema(description = "Identifies an existing VNF instance to be removed from the NS instance. It contains the identifier(s) of the VNF instances to be removed. It shall be present only if updateType = \"REMOVE_VNF.\" Note: If a VNF instance is removed from a NS and this NS was the last one for which this VNF instance was a part, the VNF instance is terminated by the NFVO. ")


  public List<String> getRemoveVnfInstanceId() {
    return removeVnfInstanceId;
  }

  public void setRemoveVnfInstanceId(List<String> removeVnfInstanceId) {
    this.removeVnfInstanceId = removeVnfInstanceId;
  }

  public UpdateNsRequest instantiateVnfData(List<InstantiateVnfData> instantiateVnfData) {
    this.instantiateVnfData = instantiateVnfData;
    return this;
  }

  public UpdateNsRequest addInstantiateVnfDataItem(InstantiateVnfData instantiateVnfDataItem) {
    if (this.instantiateVnfData == null) {
      this.instantiateVnfData = new ArrayList<>();
    }
    this.instantiateVnfData.add(instantiateVnfDataItem);
    return this;
  }

  /**
   * Identifies the new VNF to be instantiated. It can be used e.g. for the bottom-up NS creation. It shall be present only if updateType = \"INSTANTIATE_VNF\". 
   * @return instantiateVnfData
  **/
  @Schema(description = "Identifies the new VNF to be instantiated. It can be used e.g. for the bottom-up NS creation. It shall be present only if updateType = \"INSTANTIATE_VNF\". ")

  @Valid

  public List<InstantiateVnfData> getInstantiateVnfData() {
    return instantiateVnfData;
  }

  public void setInstantiateVnfData(List<InstantiateVnfData> instantiateVnfData) {
    this.instantiateVnfData = instantiateVnfData;
  }

  public UpdateNsRequest changeVnfFlavourData(List<ChangeVnfFlavourData> changeVnfFlavourData) {
    this.changeVnfFlavourData = changeVnfFlavourData;
    return this;
  }

  public UpdateNsRequest addChangeVnfFlavourDataItem(ChangeVnfFlavourData changeVnfFlavourDataItem) {
    if (this.changeVnfFlavourData == null) {
      this.changeVnfFlavourData = new ArrayList<>();
    }
    this.changeVnfFlavourData.add(changeVnfFlavourDataItem);
    return this;
  }

  /**
   * Identifies the new DF of the VNF instance to be changed to. It shall be present only if updateType = \"CHANGE_VNF_DF\". 
   * @return changeVnfFlavourData
  **/
  @Schema(description = "Identifies the new DF of the VNF instance to be changed to. It shall be present only if updateType = \"CHANGE_VNF_DF\". ")

  @Valid

  public List<ChangeVnfFlavourData> getChangeVnfFlavourData() {
    return changeVnfFlavourData;
  }

  public void setChangeVnfFlavourData(List<ChangeVnfFlavourData> changeVnfFlavourData) {
    this.changeVnfFlavourData = changeVnfFlavourData;
  }

  public UpdateNsRequest operateVnfData(List<OperateVnfData> operateVnfData) {
    this.operateVnfData = operateVnfData;
    return this;
  }

  public UpdateNsRequest addOperateVnfDataItem(OperateVnfData operateVnfDataItem) {
    if (this.operateVnfData == null) {
      this.operateVnfData = new ArrayList<>();
    }
    this.operateVnfData.add(operateVnfDataItem);
    return this;
  }

  /**
   * Identifies the state of the VNF instance to be changed.  It shall be present only if updateType = \"OPERATE_VNF\". 
   * @return operateVnfData
  **/
  @Schema(description = "Identifies the state of the VNF instance to be changed.  It shall be present only if updateType = \"OPERATE_VNF\". ")

  @Valid

  public List<OperateVnfData> getOperateVnfData() {
    return operateVnfData;
  }

  public void setOperateVnfData(List<OperateVnfData> operateVnfData) {
    this.operateVnfData = operateVnfData;
  }

  public UpdateNsRequest modifyVnfInfoData(List<ModifyVnfInfoData> modifyVnfInfoData) {
    this.modifyVnfInfoData = modifyVnfInfoData;
    return this;
  }

  public UpdateNsRequest addModifyVnfInfoDataItem(ModifyVnfInfoData modifyVnfInfoDataItem) {
    if (this.modifyVnfInfoData == null) {
      this.modifyVnfInfoData = new ArrayList<>();
    }
    this.modifyVnfInfoData.add(modifyVnfInfoDataItem);
    return this;
  }

  /**
   * Identifies the VNF information parameters and/or the configurable properties of VNF instance to be modified. It shall be present only if updateType = \"MODIFY_VNF_INFORMATION\". 
   * @return modifyVnfInfoData
  **/
  @Schema(description = "Identifies the VNF information parameters and/or the configurable properties of VNF instance to be modified. It shall be present only if updateType = \"MODIFY_VNF_INFORMATION\". ")

  @Valid

  public List<ModifyVnfInfoData> getModifyVnfInfoData() {
    return modifyVnfInfoData;
  }

  public void setModifyVnfInfoData(List<ModifyVnfInfoData> modifyVnfInfoData) {
    this.modifyVnfInfoData = modifyVnfInfoData;
  }

  public UpdateNsRequest changeExtVnfConnectivityData(List<ChangeExtVnfConnectivityData> changeExtVnfConnectivityData) {
    this.changeExtVnfConnectivityData = changeExtVnfConnectivityData;
    return this;
  }

  public UpdateNsRequest addChangeExtVnfConnectivityDataItem(ChangeExtVnfConnectivityData changeExtVnfConnectivityDataItem) {
    if (this.changeExtVnfConnectivityData == null) {
      this.changeExtVnfConnectivityData = new ArrayList<>();
    }
    this.changeExtVnfConnectivityData.add(changeExtVnfConnectivityDataItem);
    return this;
  }

  /**
   * Specifies the new external connectivity data of the VNF instance to be changed. It shall be present only if updateType = \"CHANGE_EXTERNAL_VNF_CONNECTIVITY\". 
   * @return changeExtVnfConnectivityData
  **/
  @Schema(description = "Specifies the new external connectivity data of the VNF instance to be changed. It shall be present only if updateType = \"CHANGE_EXTERNAL_VNF_CONNECTIVITY\". ")

  @Valid

  public List<ChangeExtVnfConnectivityData> getChangeExtVnfConnectivityData() {
    return changeExtVnfConnectivityData;
  }

  public void setChangeExtVnfConnectivityData(List<ChangeExtVnfConnectivityData> changeExtVnfConnectivityData) {
    this.changeExtVnfConnectivityData = changeExtVnfConnectivityData;
  }

  public UpdateNsRequest addSap(List<SapData> addSap) {
    this.addSap = addSap;
    return this;
  }

  public UpdateNsRequest addAddSapItem(SapData addSapItem) {
    if (this.addSap == null) {
      this.addSap = new ArrayList<>();
    }
    this.addSap.add(addSapItem);
    return this;
  }

  /**
   * Identifies a new SAP to be added to the NS instance. It shall be present only if updateType = \"ADD_SAP\". 
   * @return addSap
  **/
  @Schema(description = "Identifies a new SAP to be added to the NS instance. It shall be present only if updateType = \"ADD_SAP\". ")

  @Valid

  public List<SapData> getAddSap() {
    return addSap;
  }

  public void setAddSap(List<SapData> addSap) {
    this.addSap = addSap;
  }

  public UpdateNsRequest removeSapId(List<String> removeSapId) {
    this.removeSapId = removeSapId;
    return this;
  }

  public UpdateNsRequest addRemoveSapIdItem(String removeSapIdItem) {
    if (this.removeSapId == null) {
      this.removeSapId = new ArrayList<>();
    }
    this.removeSapId.add(removeSapIdItem);
    return this;
  }

  /**
   * The identifier an existing SAP to be removed from the NS instance. It shall be present only if updateType = \"REMOVE_SAP\". 
   * @return removeSapId
  **/
  @Schema(description = "The identifier an existing SAP to be removed from the NS instance. It shall be present only if updateType = \"REMOVE_SAP\". ")


  public List<String> getRemoveSapId() {
    return removeSapId;
  }

  public void setRemoveSapId(List<String> removeSapId) {
    this.removeSapId = removeSapId;
  }

  public UpdateNsRequest addNestedNsData(List<NestedNsInstanceData> addNestedNsData) {
    this.addNestedNsData = addNestedNsData;
    return this;
  }

  public UpdateNsRequest addAddNestedNsDataItem(NestedNsInstanceData addNestedNsDataItem) {
    if (this.addNestedNsData == null) {
      this.addNestedNsData = new ArrayList<>();
    }
    this.addNestedNsData.add(addNestedNsDataItem);
    return this;
  }

  /**
   * The identifier of an existing nested NS instance to be added to (nested within) the NS instance. It shall be present only if updateType = \"ADD_NESTED_NS\". 
   * @return addNestedNsData
  **/
  @Schema(description = "The identifier of an existing nested NS instance to be added to (nested within) the NS instance. It shall be present only if updateType = \"ADD_NESTED_NS\". ")

  @Valid

  public List<NestedNsInstanceData> getAddNestedNsData() {
    return addNestedNsData;
  }

  public void setAddNestedNsData(List<NestedNsInstanceData> addNestedNsData) {
    this.addNestedNsData = addNestedNsData;
  }

  public UpdateNsRequest removeNestedNsId(List<String> removeNestedNsId) {
    this.removeNestedNsId = removeNestedNsId;
    return this;
  }

  public UpdateNsRequest addRemoveNestedNsIdItem(String removeNestedNsIdItem) {
    if (this.removeNestedNsId == null) {
      this.removeNestedNsId = new ArrayList<>();
    }
    this.removeNestedNsId.add(removeNestedNsIdItem);
    return this;
  }

  /**
   * The identifier of an existing nested NS instance to be removed from the NS instance. It shall be present only if updateType = \"REMOVE_NESTED_NS\". 
   * @return removeNestedNsId
  **/
  @Schema(description = "The identifier of an existing nested NS instance to be removed from the NS instance. It shall be present only if updateType = \"REMOVE_NESTED_NS\". ")


  public List<String> getRemoveNestedNsId() {
    return removeNestedNsId;
  }

  public void setRemoveNestedNsId(List<String> removeNestedNsId) {
    this.removeNestedNsId = removeNestedNsId;
  }

  public UpdateNsRequest assocNewNsdVersionData(AssocNewNsdVersionData assocNewNsdVersionData) {
    this.assocNewNsdVersionData = assocNewNsdVersionData;
    return this;
  }

  /**
   * Specify the new NSD to be used for the NS instance. It shall be present only if updateType = ASSOC_NEW_NSD_VERSION\". 
   * @return assocNewNsdVersionData
  **/
  @Schema(description = "Specify the new NSD to be used for the NS instance. It shall be present only if updateType = ASSOC_NEW_NSD_VERSION\". ")

  @Valid

  public AssocNewNsdVersionData getAssocNewNsdVersionData() {
    return assocNewNsdVersionData;
  }

  public void setAssocNewNsdVersionData(AssocNewNsdVersionData assocNewNsdVersionData) {
    this.assocNewNsdVersionData = assocNewNsdVersionData;
  }

  public UpdateNsRequest moveVnfInstanceData(List<MoveVnfInstanceData> moveVnfInstanceData) {
    this.moveVnfInstanceData = moveVnfInstanceData;
    return this;
  }

  public UpdateNsRequest addMoveVnfInstanceDataItem(MoveVnfInstanceData moveVnfInstanceDataItem) {
    if (this.moveVnfInstanceData == null) {
      this.moveVnfInstanceData = new ArrayList<>();
    }
    this.moveVnfInstanceData.add(moveVnfInstanceDataItem);
    return this;
  }

  /**
   * Specify existing VNF instance to be moved from one NS instance to another NS instance. It shall be present only if updateType = MOVE_VNF\". 
   * @return moveVnfInstanceData
  **/
  @Schema(description = "Specify existing VNF instance to be moved from one NS instance to another NS instance. It shall be present only if updateType = MOVE_VNF\". ")

  @Valid

  public List<MoveVnfInstanceData> getMoveVnfInstanceData() {
    return moveVnfInstanceData;
  }

  public void setMoveVnfInstanceData(List<MoveVnfInstanceData> moveVnfInstanceData) {
    this.moveVnfInstanceData = moveVnfInstanceData;
  }

  public UpdateNsRequest addVnffg(List<AddVnffgData> addVnffg) {
    this.addVnffg = addVnffg;
    return this;
  }

  public UpdateNsRequest addAddVnffgItem(AddVnffgData addVnffgItem) {
    if (this.addVnffg == null) {
      this.addVnffg = new ArrayList<>();
    }
    this.addVnffg.add(addVnffgItem);
    return this;
  }

  /**
   * Specify the new VNFFG to be created to the NS Instance. It shall be present only if updateType = \"ADD_VNFFG\". 
   * @return addVnffg
  **/
  @Schema(description = "Specify the new VNFFG to be created to the NS Instance. It shall be present only if updateType = \"ADD_VNFFG\". ")

  @Valid

  public List<AddVnffgData> getAddVnffg() {
    return addVnffg;
  }

  public void setAddVnffg(List<AddVnffgData> addVnffg) {
    this.addVnffg = addVnffg;
  }

  public UpdateNsRequest removeVnffgId(List<String> removeVnffgId) {
    this.removeVnffgId = removeVnffgId;
    return this;
  }

  public UpdateNsRequest addRemoveVnffgIdItem(String removeVnffgIdItem) {
    if (this.removeVnffgId == null) {
      this.removeVnffgId = new ArrayList<>();
    }
    this.removeVnffgId.add(removeVnffgIdItem);
    return this;
  }

  /**
   * Identifier of an existing VNFFG to be removed from the NS Instance. It shall be present only if updateType = \"REMOVE_VNFFG\". 
   * @return removeVnffgId
  **/
  @Schema(description = "Identifier of an existing VNFFG to be removed from the NS Instance. It shall be present only if updateType = \"REMOVE_VNFFG\". ")


  public List<String> getRemoveVnffgId() {
    return removeVnffgId;
  }

  public void setRemoveVnffgId(List<String> removeVnffgId) {
    this.removeVnffgId = removeVnffgId;
  }

  public UpdateNsRequest updateVnffg(List<UpdateVnffgData> updateVnffg) {
    this.updateVnffg = updateVnffg;
    return this;
  }

  public UpdateNsRequest addUpdateVnffgItem(UpdateVnffgData updateVnffgItem) {
    if (this.updateVnffg == null) {
      this.updateVnffg = new ArrayList<>();
    }
    this.updateVnffg.add(updateVnffgItem);
    return this;
  }

  /**
   * Specify the new VNFFG Information data to be updated for a VNFFG of the NS Instance. It shall be present only if updateType = \"UPDATE_VNFFG\". 
   * @return updateVnffg
  **/
  @Schema(description = "Specify the new VNFFG Information data to be updated for a VNFFG of the NS Instance. It shall be present only if updateType = \"UPDATE_VNFFG\". ")

  @Valid

  public List<UpdateVnffgData> getUpdateVnffg() {
    return updateVnffg;
  }

  public void setUpdateVnffg(List<UpdateVnffgData> updateVnffg) {
    this.updateVnffg = updateVnffg;
  }

  public UpdateNsRequest changeNsFlavourData(ChangeNsFlavourData changeNsFlavourData) {
    this.changeNsFlavourData = changeNsFlavourData;
    return this;
  }

  /**
   * Specifies the new DF to be applied to the NS instance. It shall be present only if updateType = \"CHANGE_NS_DF\". 
   * @return changeNsFlavourData
  **/
  @Schema(description = "Specifies the new DF to be applied to the NS instance. It shall be present only if updateType = \"CHANGE_NS_DF\". ")

  @Valid

  public ChangeNsFlavourData getChangeNsFlavourData() {
    return changeNsFlavourData;
  }

  public void setChangeNsFlavourData(ChangeNsFlavourData changeNsFlavourData) {
    this.changeNsFlavourData = changeNsFlavourData;
  }

  public UpdateNsRequest addPnfData(List<AddPnfData> addPnfData) {
    this.addPnfData = addPnfData;
    return this;
  }

  public UpdateNsRequest addAddPnfDataItem(AddPnfData addPnfDataItem) {
    if (this.addPnfData == null) {
      this.addPnfData = new ArrayList<>();
    }
    this.addPnfData.add(addPnfDataItem);
    return this;
  }

  /**
   * specifies the PNF to be added into the NS instance.  It shall be present only if updateType = \"ADD_PNF\". 
   * @return addPnfData
  **/
  @Schema(description = "specifies the PNF to be added into the NS instance.  It shall be present only if updateType = \"ADD_PNF\". ")

  @Valid

  public List<AddPnfData> getAddPnfData() {
    return addPnfData;
  }

  public void setAddPnfData(List<AddPnfData> addPnfData) {
    this.addPnfData = addPnfData;
  }

  public UpdateNsRequest modifyPnfData(List<ModifyPnfData> modifyPnfData) {
    this.modifyPnfData = modifyPnfData;
    return this;
  }

  public UpdateNsRequest addModifyPnfDataItem(ModifyPnfData modifyPnfDataItem) {
    if (this.modifyPnfData == null) {
      this.modifyPnfData = new ArrayList<>();
    }
    this.modifyPnfData.add(modifyPnfDataItem);
    return this;
  }

  /**
   * Specifies the PNF to be modified in the NS instance.  It shall be present only if updateType = \"MODIFY_PNF\". 
   * @return modifyPnfData
  **/
  @Schema(description = "Specifies the PNF to be modified in the NS instance.  It shall be present only if updateType = \"MODIFY_PNF\". ")

  @Valid

  public List<ModifyPnfData> getModifyPnfData() {
    return modifyPnfData;
  }

  public void setModifyPnfData(List<ModifyPnfData> modifyPnfData) {
    this.modifyPnfData = modifyPnfData;
  }

  public UpdateNsRequest removePnfId(List<String> removePnfId) {
    this.removePnfId = removePnfId;
    return this;
  }

  public UpdateNsRequest addRemovePnfIdItem(String removePnfIdItem) {
    if (this.removePnfId == null) {
      this.removePnfId = new ArrayList<>();
    }
    this.removePnfId.add(removePnfIdItem);
    return this;
  }

  /**
   * Identifier of the PNF to be deleted from the NS instance. It shall be present only if updateType = \"REMOVE_PNF\". 
   * @return removePnfId
  **/
  @Schema(description = "Identifier of the PNF to be deleted from the NS instance. It shall be present only if updateType = \"REMOVE_PNF\". ")


  public List<String> getRemovePnfId() {
    return removePnfId;
  }

  public void setRemovePnfId(List<String> removePnfId) {
    this.removePnfId = removePnfId;
  }

  public UpdateNsRequest updateTime(OffsetDateTime updateTime) {
    this.updateTime = updateTime;
    return this;
  }

  /**
   * Timestamp indicating the update time of the NS, i.e. the NS will be updated at this timestamp. Cardinality \"0\" indicates the NS update takes place immediately. 
   * @return updateTime
  **/
  @Schema(description = "Timestamp indicating the update time of the NS, i.e. the NS will be updated at this timestamp. Cardinality \"0\" indicates the NS update takes place immediately. ")

  @Valid

  public OffsetDateTime getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(OffsetDateTime updateTime) {
    this.updateTime = updateTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateNsRequest updateNsRequest = (UpdateNsRequest) o;
    return Objects.equals(this.updateType, updateNsRequest.updateType) &&
    Objects.equals(this.addVnfIstance, updateNsRequest.addVnfIstance) &&
    Objects.equals(this.removeVnfInstanceId, updateNsRequest.removeVnfInstanceId) &&
    Objects.equals(this.instantiateVnfData, updateNsRequest.instantiateVnfData) &&
    Objects.equals(this.changeVnfFlavourData, updateNsRequest.changeVnfFlavourData) &&
    Objects.equals(this.operateVnfData, updateNsRequest.operateVnfData) &&
    Objects.equals(this.modifyVnfInfoData, updateNsRequest.modifyVnfInfoData) &&
    Objects.equals(this.changeExtVnfConnectivityData, updateNsRequest.changeExtVnfConnectivityData) &&
    Objects.equals(this.addSap, updateNsRequest.addSap) &&
    Objects.equals(this.removeSapId, updateNsRequest.removeSapId) &&
    Objects.equals(this.addNestedNsData, updateNsRequest.addNestedNsData) &&
    Objects.equals(this.removeNestedNsId, updateNsRequest.removeNestedNsId) &&
    Objects.equals(this.assocNewNsdVersionData, updateNsRequest.assocNewNsdVersionData) &&
    Objects.equals(this.moveVnfInstanceData, updateNsRequest.moveVnfInstanceData) &&
    Objects.equals(this.addVnffg, updateNsRequest.addVnffg) &&
    Objects.equals(this.removeVnffgId, updateNsRequest.removeVnffgId) &&
    Objects.equals(this.updateVnffg, updateNsRequest.updateVnffg) &&
    Objects.equals(this.changeNsFlavourData, updateNsRequest.changeNsFlavourData) &&
    Objects.equals(this.addPnfData, updateNsRequest.addPnfData) &&
    Objects.equals(this.modifyPnfData, updateNsRequest.modifyPnfData) &&
    Objects.equals(this.removePnfId, updateNsRequest.removePnfId) &&
    Objects.equals(this.updateTime, updateNsRequest.updateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(updateType, addVnfIstance, removeVnfInstanceId, instantiateVnfData, changeVnfFlavourData, operateVnfData, modifyVnfInfoData, changeExtVnfConnectivityData, addSap, removeSapId, addNestedNsData, removeNestedNsId, assocNewNsdVersionData, moveVnfInstanceData, addVnffg, removeVnffgId, updateVnffg, changeNsFlavourData, addPnfData, modifyPnfData, removePnfId, updateTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateNsRequest {\n");

    sb.append("    updateType: ").append(toIndentedString(updateType)).append("\n");
    sb.append("    addVnfIstance: ").append(toIndentedString(addVnfIstance)).append("\n");
    sb.append("    removeVnfInstanceId: ").append(toIndentedString(removeVnfInstanceId)).append("\n");
    sb.append("    instantiateVnfData: ").append(toIndentedString(instantiateVnfData)).append("\n");
    sb.append("    changeVnfFlavourData: ").append(toIndentedString(changeVnfFlavourData)).append("\n");
    sb.append("    operateVnfData: ").append(toIndentedString(operateVnfData)).append("\n");
    sb.append("    modifyVnfInfoData: ").append(toIndentedString(modifyVnfInfoData)).append("\n");
    sb.append("    changeExtVnfConnectivityData: ").append(toIndentedString(changeExtVnfConnectivityData)).append("\n");
    sb.append("    addSap: ").append(toIndentedString(addSap)).append("\n");
    sb.append("    removeSapId: ").append(toIndentedString(removeSapId)).append("\n");
    sb.append("    addNestedNsData: ").append(toIndentedString(addNestedNsData)).append("\n");
    sb.append("    removeNestedNsId: ").append(toIndentedString(removeNestedNsId)).append("\n");
    sb.append("    assocNewNsdVersionData: ").append(toIndentedString(assocNewNsdVersionData)).append("\n");
    sb.append("    moveVnfInstanceData: ").append(toIndentedString(moveVnfInstanceData)).append("\n");
    sb.append("    addVnffg: ").append(toIndentedString(addVnffg)).append("\n");
    sb.append("    removeVnffgId: ").append(toIndentedString(removeVnffgId)).append("\n");
    sb.append("    updateVnffg: ").append(toIndentedString(updateVnffg)).append("\n");
    sb.append("    changeNsFlavourData: ").append(toIndentedString(changeNsFlavourData)).append("\n");
    sb.append("    addPnfData: ").append(toIndentedString(addPnfData)).append("\n");
    sb.append("    modifyPnfData: ").append(toIndentedString(modifyPnfData)).append("\n");
    sb.append("    removePnfId: ").append(toIndentedString(removePnfId)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
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

