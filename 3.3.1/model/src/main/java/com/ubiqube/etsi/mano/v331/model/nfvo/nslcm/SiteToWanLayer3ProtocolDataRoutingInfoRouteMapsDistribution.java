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
package com.ubiqube.etsi.mano.v331.model.nfvo.nslcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Map;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Maps of routes that are permitted or denied for redistribution. 
 */
@Schema(description = "Maps of routes that are permitted or denied for redistribution. ")
@Validated


public class SiteToWanLayer3ProtocolDataRoutingInfoRouteMapsDistribution   {
  /**
   * The policy to apply to the route distribution. Permitted values: - PERMIT - DENY 
   */
  public enum PolicyEnum {
    PERMIT("PERMIT"),
    
    DENY("DENY");

    private String value;

    PolicyEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PolicyEnum fromValue(String text) {
      for (PolicyEnum b : PolicyEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("policy")
  private PolicyEnum policy = null;

  @JsonProperty("sequence")
  private BigDecimal sequence = null;

  @JsonProperty("matchAndSetRule")
  private Map<String, String> matchAndSetRule = null;

  public SiteToWanLayer3ProtocolDataRoutingInfoRouteMapsDistribution policy(PolicyEnum policy) {
    this.policy = policy;
    return this;
  }

  /**
   * The policy to apply to the route distribution. Permitted values: - PERMIT - DENY 
   * @return policy
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "The policy to apply to the route distribution. Permitted values: - PERMIT - DENY ")
      @NotNull

    public PolicyEnum getPolicy() {
    return policy;
  }

  public void setPolicy(PolicyEnum policy) {
    this.policy = policy;
  }

  public SiteToWanLayer3ProtocolDataRoutingInfoRouteMapsDistribution sequence(BigDecimal sequence) {
    this.sequence = sequence;
    return this;
  }

  /**
   * Sequence or index number assigned to the route-map. 
   * @return sequence
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "Sequence or index number assigned to the route-map. ")
      @NotNull

    @Valid
    public BigDecimal getSequence() {
    return sequence;
  }

  public void setSequence(BigDecimal sequence) {
    this.sequence = sequence;
  }

  public SiteToWanLayer3ProtocolDataRoutingInfoRouteMapsDistribution matchAndSetRule(Map<String, String> matchAndSetRule) {
    this.matchAndSetRule = matchAndSetRule;
    return this;
  }

  /**
   * Get matchAndSetRule
   * @return matchAndSetRule
   **/
  @Schema(requiredMode = RequiredMode.REQUIRED, description = "")
      @NotNull

    @Valid
    public Map<String, String> getMatchAndSetRule() {
    return matchAndSetRule;
  }

  public void setMatchAndSetRule(Map<String, String> matchAndSetRule) {
    this.matchAndSetRule = matchAndSetRule;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SiteToWanLayer3ProtocolDataRoutingInfoRouteMapsDistribution siteToWanLayer3ProtocolDataRoutingInfoRouteMapsDistribution = (SiteToWanLayer3ProtocolDataRoutingInfoRouteMapsDistribution) o;
    return Objects.equals(this.policy, siteToWanLayer3ProtocolDataRoutingInfoRouteMapsDistribution.policy) &&
        Objects.equals(this.sequence, siteToWanLayer3ProtocolDataRoutingInfoRouteMapsDistribution.sequence) &&
        Objects.equals(this.matchAndSetRule, siteToWanLayer3ProtocolDataRoutingInfoRouteMapsDistribution.matchAndSetRule);
  }

  @Override
  public int hashCode() {
    return Objects.hash(policy, sequence, matchAndSetRule);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SiteToWanLayer3ProtocolDataRoutingInfoRouteMapsDistribution {\n");
    
    sb.append("    policy: ").append(toIndentedString(policy)).append("\n");
    sb.append("    sequence: ").append(toIndentedString(sequence)).append("\n");
    sb.append("    matchAndSetRule: ").append(toIndentedString(matchAndSetRule)).append("\n");
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
