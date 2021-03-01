package com.ubiqube.etsi.mano.nfvo.v331.model.nslcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ubiqube.etsi.mano.nfvo.v331.model.nslcm.PnfExtCpData;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * This type specifies an PNF to be modified in the NS instance. It shall comply with the provisions defined in Table 6.5.3.15-1. 
 */
@Schema(description = "This type specifies an PNF to be modified in the NS instance. It shall comply with the provisions defined in Table 6.5.3.15-1. ")
@Validated


public class ModifyPnfData  implements AnyOfModifyPnfData {
  @JsonProperty("pnfId")
  private String pnfId = null;

  @JsonProperty("pnfName")
  private String pnfName = null;

  @JsonProperty("cpData")
  @Valid
  private List<PnfExtCpData> cpData = null;

  public ModifyPnfData pnfId(String pnfId) {
    this.pnfId = pnfId;
    return this;
  }

  /**
   * Get pnfId
   * @return pnfId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getPnfId() {
    return pnfId;
  }

  public void setPnfId(String pnfId) {
    this.pnfId = pnfId;
  }

  public ModifyPnfData pnfName(String pnfName) {
    this.pnfName = pnfName;
    return this;
  }

  /**
   * Name of the PNF. 
   * @return pnfName
   **/
  @Schema(description = "Name of the PNF. ")
  
    public String getPnfName() {
    return pnfName;
  }

  public void setPnfName(String pnfName) {
    this.pnfName = pnfName;
  }

  public ModifyPnfData cpData(List<PnfExtCpData> cpData) {
    this.cpData = cpData;
    return this;
  }

  public ModifyPnfData addCpDataItem(PnfExtCpData cpDataItem) {
    if (this.cpData == null) {
      this.cpData = new ArrayList<>();
    }
    this.cpData.add(cpDataItem);
    return this;
  }

  /**
   * Address assigned for the PNF external CP(s). 
   * @return cpData
   **/
  @Schema(description = "Address assigned for the PNF external CP(s). ")
      @Valid
    public List<PnfExtCpData> getCpData() {
    return cpData;
  }

  public void setCpData(List<PnfExtCpData> cpData) {
    this.cpData = cpData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModifyPnfData modifyPnfData = (ModifyPnfData) o;
    return Objects.equals(this.pnfId, modifyPnfData.pnfId) &&
        Objects.equals(this.pnfName, modifyPnfData.pnfName) &&
        Objects.equals(this.cpData, modifyPnfData.cpData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pnfId, pnfName, cpData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModifyPnfData {\n");
    
    sb.append("    pnfId: ").append(toIndentedString(pnfId)).append("\n");
    sb.append("    pnfName: ").append(toIndentedString(pnfName)).append("\n");
    sb.append("    cpData: ").append(toIndentedString(cpData)).append("\n");
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