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
package com.ubiqube.etsi.mano.v331.model.nfvem.nfvmanocim;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v331.model.nfvem.nfvmanocim.ClockSyncInfo;
import com.ubiqube.etsi.mano.v331.model.nfvem.nfvmanocim.ManoConfigModificationsManoServiceModifications;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents attribute modifications that were performed on the  \&quot;NFV-MANO entity\&quot; resource of the producer NFV-MANO functional entity.  The attributes that can be included consist of those requested to be  modified explicitly in the \&quot;ManoConfigModificationRequest\&quot; data structure.  
 */
@Schema (description= "This type represents attribute modifications that were performed on the  \"NFV-MANO entity\" resource of the producer NFV-MANO functional entity.  The attributes that can be included consist of those requested to be  modified explicitly in the \"ManoConfigModificationRequest\" data structure.  " )
@Validated
public class ManoConfigModifications   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("clockSyncs")
  @Valid
  private List<ClockSyncInfo> clockSyncs = null;

  @JsonProperty("clockSyncsDeleteIds")
  @Valid
  private List<String> clockSyncsDeleteIds = null;

  @JsonProperty("defaultLogCompileBySizeValue")
  private BigDecimal defaultLogCompileBySizeValue = null;

  @JsonProperty("defaultLogCompileByTimerValue")
  private BigDecimal defaultLogCompileByTimerValue = null;

  @JsonProperty("manoServiceModifications")
  @Valid
  private List<ManoConfigModificationsManoServiceModifications> manoServiceModifications = null;

  public ManoConfigModifications name(String name) {
    this.name = name;
    return this;
  }

  /**
   * If present, this attribute signals modifications of the \"name\"  attribute in \"ManoEntity\", as defined in clause 5.6.2.3 
   * @return name
  **/
  @Schema(description= "If present, this attribute signals modifications of the \"name\"  attribute in \"ManoEntity\", as defined in clause 5.6.2.3 " )
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ManoConfigModifications description(String description) {
    this.description = description;
    return this;
  }

  /**
   * If present, this attribute signals modifications of the \"description\"  attribute in \"ManoEntity\", as defined in clause 5.6.2.3. 
   * @return description
  **/
  @Schema(description= "If present, this attribute signals modifications of the \"description\"  attribute in \"ManoEntity\", as defined in clause 5.6.2.3. " )
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ManoConfigModifications clockSyncs(List<ClockSyncInfo> clockSyncs) {
    this.clockSyncs = clockSyncs;
    return this;
  }

  public ManoConfigModifications addClockSyncsItem(ClockSyncInfo clockSyncsItem) {
    if (this.clockSyncs == null) {
      this.clockSyncs = new ArrayList<>();
    }
    this.clockSyncs.add(clockSyncsItem);
    return this;
  }

  /**
   * If present, this attribute signals modifications of the \"clockSyncs\"  attribute in \"ManoEntityConfigurableParams\", as defined in  clause 5.6.2.3. 
   * @return clockSyncs
  **/
  @Schema(description= "If present, this attribute signals modifications of the \"clockSyncs\"  attribute in \"ManoEntityConfigurableParams\", as defined in  clause 5.6.2.3. " )
      @Valid
    public List<ClockSyncInfo> getClockSyncs() {
    return clockSyncs;
  }

  public void setClockSyncs(List<ClockSyncInfo> clockSyncs) {
    this.clockSyncs = clockSyncs;
  }

  public ManoConfigModifications clockSyncsDeleteIds(List<String> clockSyncsDeleteIds) {
    this.clockSyncsDeleteIds = clockSyncsDeleteIds;
    return this;
  }

  public ManoConfigModifications addClockSyncsDeleteIdsItem(String clockSyncsDeleteIdsItem) {
    if (this.clockSyncsDeleteIds == null) {
      this.clockSyncsDeleteIds = new ArrayList<>();
    }
    this.clockSyncsDeleteIds.add(clockSyncsDeleteIdsItem);
    return this;
  }

  /**
   * If present, this attribute signals modifications of certain entries in  \"clockSyncs\" attribute in \"ManoEntityConfigurableParams\", as defined  in clause 5.6.2.3. 
   * @return clockSyncsDeleteIds
  **/
  @Schema(description= "If present, this attribute signals modifications of certain entries in  \"clockSyncs\" attribute in \"ManoEntityConfigurableParams\", as defined  in clause 5.6.2.3. " )
  
    public List<String> getClockSyncsDeleteIds() {
    return clockSyncsDeleteIds;
  }

  public void setClockSyncsDeleteIds(List<String> clockSyncsDeleteIds) {
    this.clockSyncsDeleteIds = clockSyncsDeleteIds;
  }

  public ManoConfigModifications defaultLogCompileBySizeValue(BigDecimal defaultLogCompileBySizeValue) {
    this.defaultLogCompileBySizeValue = defaultLogCompileBySizeValue;
    return this;
  }

  /**
   * Get defaultLogCompileBySizeValue
   * @return defaultLogCompileBySizeValue
  **/
  @Schema(description= "" )
  
    @Valid
    public BigDecimal getDefaultLogCompileBySizeValue() {
    return defaultLogCompileBySizeValue;
  }

  public void setDefaultLogCompileBySizeValue(BigDecimal defaultLogCompileBySizeValue) {
    this.defaultLogCompileBySizeValue = defaultLogCompileBySizeValue;
  }

  public ManoConfigModifications defaultLogCompileByTimerValue(BigDecimal defaultLogCompileByTimerValue) {
    this.defaultLogCompileByTimerValue = defaultLogCompileByTimerValue;
    return this;
  }

  /**
   * Get defaultLogCompileByTimerValue
   * @return defaultLogCompileByTimerValue
  **/
  @Schema(description= "" )
  
    @Valid
    public BigDecimal getDefaultLogCompileByTimerValue() {
    return defaultLogCompileByTimerValue;
  }

  public void setDefaultLogCompileByTimerValue(BigDecimal defaultLogCompileByTimerValue) {
    this.defaultLogCompileByTimerValue = defaultLogCompileByTimerValue;
  }

  public ManoConfigModifications manoServiceModifications(List<ManoConfigModificationsManoServiceModifications> manoServiceModifications) {
    this.manoServiceModifications = manoServiceModifications;
    return this;
  }

  public ManoConfigModifications addManoServiceModificationsItem(ManoConfigModificationsManoServiceModifications manoServiceModificationsItem) {
    if (this.manoServiceModifications == null) {
      this.manoServiceModifications = new ArrayList<>();
    }
    this.manoServiceModifications.add(manoServiceModificationsItem);
    return this;
  }

  /**
   * If present, this attribute signals modifications of the \"manoServices\"  attribute array in the \"ManoEntity\", as defined in clause 5.6.2.3. 
   * @return manoServiceModifications
  **/
  @Schema(description= "If present, this attribute signals modifications of the \"manoServices\"  attribute array in the \"ManoEntity\", as defined in clause 5.6.2.3. " )
      @Valid
    public List<ManoConfigModificationsManoServiceModifications> getManoServiceModifications() {
    return manoServiceModifications;
  }

  public void setManoServiceModifications(List<ManoConfigModificationsManoServiceModifications> manoServiceModifications) {
    this.manoServiceModifications = manoServiceModifications;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ManoConfigModifications manoConfigModifications = (ManoConfigModifications) o;
    return Objects.equals(this.name, manoConfigModifications.name) &&
        Objects.equals(this.description, manoConfigModifications.description) &&
        Objects.equals(this.clockSyncs, manoConfigModifications.clockSyncs) &&
        Objects.equals(this.clockSyncsDeleteIds, manoConfigModifications.clockSyncsDeleteIds) &&
        Objects.equals(this.defaultLogCompileBySizeValue, manoConfigModifications.defaultLogCompileBySizeValue) &&
        Objects.equals(this.defaultLogCompileByTimerValue, manoConfigModifications.defaultLogCompileByTimerValue) &&
        Objects.equals(this.manoServiceModifications, manoConfigModifications.manoServiceModifications);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, clockSyncs, clockSyncsDeleteIds, defaultLogCompileBySizeValue, defaultLogCompileByTimerValue, manoServiceModifications);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ManoConfigModifications {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    clockSyncs: ").append(toIndentedString(clockSyncs)).append("\n");
    sb.append("    clockSyncsDeleteIds: ").append(toIndentedString(clockSyncsDeleteIds)).append("\n");
    sb.append("    defaultLogCompileBySizeValue: ").append(toIndentedString(defaultLogCompileBySizeValue)).append("\n");
    sb.append("    defaultLogCompileByTimerValue: ").append(toIndentedString(defaultLogCompileByTimerValue)).append("\n");
    sb.append("    manoServiceModifications: ").append(toIndentedString(manoServiceModifications)).append("\n");
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
