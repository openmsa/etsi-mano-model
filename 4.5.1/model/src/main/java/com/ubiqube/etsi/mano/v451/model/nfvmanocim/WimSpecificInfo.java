package com.ubiqube.etsi.mano.v451.model.nfvmanocim;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.WimSpecificInfoMaxMscsNums;
import com.ubiqube.etsi.mano.v451.model.nfvmanocim.WimSpecificInfoMaxMsncNum;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents information attributes specific to a WIM entity, and that can be relevant to more than one NFV MANO service offered by a WIM entity. 
 */
@Schema(description = "This type represents information attributes specific to a WIM entity, and that can be relevant to more than one NFV MANO service offered by a WIM entity. ")
@Validated



public class WimSpecificInfo   {
  @JsonProperty("maxMscsNums")
  private WimSpecificInfoMaxMscsNums maxMscsNums = null;

  @JsonProperty("maxMsncNum")
  private WimSpecificInfoMaxMsncNum maxMsncNum = null;

  /**
   * List of protocols of particular layers used to realize an MSCS that are supported by the WIM. Permitted values:   - EVPN_BGP_MPLS: L2 MSCS realized by BGP MPLS-based Ethernet VPN (EVPN) as specified in IETF RFC 7432.   - EVPN_VPWS: L2 MSCS realized by EVPN Virtual Private Wire Service (VPWS) as specified in IETF RFC 8214.   - VPLS_BGP: L2 MSCS realized by Virtual Private LAN Service (VPLS) using BGP as specified     in IETF RFC 4761 and IETF RFC.   - VPLS_LDP_L2TP: L2 MSCS realized by VPLS using Label Distribution Protocol (LDP) Layer 2     Tunnelling Protocol (L2TP) as specified in IETF RFC 4762 and IETF RFC 6074.   - VPWS_LDP_L2TP: L2 MSCS realized by VPWS using LDP L2TP as specified in IETF RFC 6074.   - BGP_IP_VPN: L3 MSCS realized by BGP/MPLS based IP VPN as specified in IETF RFC 4364. 
   */
  public enum MscsLayerProtocolSupportEnum {
    EVPN_BGP_MPLS("EVPN_BGP_MPLS"),
    
    EVPN_VPWS("EVPN_VPWS"),
    
    VPLS_BGP("VPLS_BGP"),
    
    VPLS_LDP_L2TP("VPLS_LDP_L2TP"),
    
    VPWS_LDP_L2TP("VPWS_LDP_L2TP"),
    
    BGP_IP_VPN("BGP_IP_VPN");

    private String value;

    MscsLayerProtocolSupportEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MscsLayerProtocolSupportEnum fromValue(String text) {
      for (MscsLayerProtocolSupportEnum b : MscsLayerProtocolSupportEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("mscsLayerProtocolSupport")
  private MscsLayerProtocolSupportEnum mscsLayerProtocolSupport = null;

  public WimSpecificInfo maxMscsNums(WimSpecificInfoMaxMscsNums maxMscsNums) {
    this.maxMscsNums = maxMscsNums;
    return this;
  }

  /**
   * Get maxMscsNums
   * @return maxMscsNums
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public WimSpecificInfoMaxMscsNums getMaxMscsNums() {
    return maxMscsNums;
  }

  public void setMaxMscsNums(WimSpecificInfoMaxMscsNums maxMscsNums) {
    this.maxMscsNums = maxMscsNums;
  }

  public WimSpecificInfo maxMsncNum(WimSpecificInfoMaxMsncNum maxMsncNum) {
    this.maxMsncNum = maxMsncNum;
    return this;
  }

  /**
   * Get maxMsncNum
   * @return maxMsncNum
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public WimSpecificInfoMaxMsncNum getMaxMsncNum() {
    return maxMsncNum;
  }

  public void setMaxMsncNum(WimSpecificInfoMaxMsncNum maxMsncNum) {
    this.maxMsncNum = maxMsncNum;
  }

  public WimSpecificInfo mscsLayerProtocolSupport(MscsLayerProtocolSupportEnum mscsLayerProtocolSupport) {
    this.mscsLayerProtocolSupport = mscsLayerProtocolSupport;
    return this;
  }

  /**
   * List of protocols of particular layers used to realize an MSCS that are supported by the WIM. Permitted values:   - EVPN_BGP_MPLS: L2 MSCS realized by BGP MPLS-based Ethernet VPN (EVPN) as specified in IETF RFC 7432.   - EVPN_VPWS: L2 MSCS realized by EVPN Virtual Private Wire Service (VPWS) as specified in IETF RFC 8214.   - VPLS_BGP: L2 MSCS realized by Virtual Private LAN Service (VPLS) using BGP as specified     in IETF RFC 4761 and IETF RFC.   - VPLS_LDP_L2TP: L2 MSCS realized by VPLS using Label Distribution Protocol (LDP) Layer 2     Tunnelling Protocol (L2TP) as specified in IETF RFC 4762 and IETF RFC 6074.   - VPWS_LDP_L2TP: L2 MSCS realized by VPWS using LDP L2TP as specified in IETF RFC 6074.   - BGP_IP_VPN: L3 MSCS realized by BGP/MPLS based IP VPN as specified in IETF RFC 4364. 
   * @return mscsLayerProtocolSupport
   **/
  @Schema(required = true, description = "List of protocols of particular layers used to realize an MSCS that are supported by the WIM. Permitted values:   - EVPN_BGP_MPLS: L2 MSCS realized by BGP MPLS-based Ethernet VPN (EVPN) as specified in IETF RFC 7432.   - EVPN_VPWS: L2 MSCS realized by EVPN Virtual Private Wire Service (VPWS) as specified in IETF RFC 8214.   - VPLS_BGP: L2 MSCS realized by Virtual Private LAN Service (VPLS) using BGP as specified     in IETF RFC 4761 and IETF RFC.   - VPLS_LDP_L2TP: L2 MSCS realized by VPLS using Label Distribution Protocol (LDP) Layer 2     Tunnelling Protocol (L2TP) as specified in IETF RFC 4762 and IETF RFC 6074.   - VPWS_LDP_L2TP: L2 MSCS realized by VPWS using LDP L2TP as specified in IETF RFC 6074.   - BGP_IP_VPN: L3 MSCS realized by BGP/MPLS based IP VPN as specified in IETF RFC 4364. ")
      @NotNull

    public MscsLayerProtocolSupportEnum getMscsLayerProtocolSupport() {
    return mscsLayerProtocolSupport;
  }

  public void setMscsLayerProtocolSupport(MscsLayerProtocolSupportEnum mscsLayerProtocolSupport) {
    this.mscsLayerProtocolSupport = mscsLayerProtocolSupport;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WimSpecificInfo wimSpecificInfo = (WimSpecificInfo) o;
    return Objects.equals(this.maxMscsNums, wimSpecificInfo.maxMscsNums) &&
        Objects.equals(this.maxMsncNum, wimSpecificInfo.maxMsncNum) &&
        Objects.equals(this.mscsLayerProtocolSupport, wimSpecificInfo.mscsLayerProtocolSupport);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxMscsNums, maxMsncNum, mscsLayerProtocolSupport);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WimSpecificInfo {\n");
    
    sb.append("    maxMscsNums: ").append(toIndentedString(maxMscsNums)).append("\n");
    sb.append("    maxMsncNum: ").append(toIndentedString(maxMsncNum)).append("\n");
    sb.append("    mscsLayerProtocolSupport: ").append(toIndentedString(mscsLayerProtocolSupport)).append("\n");
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
