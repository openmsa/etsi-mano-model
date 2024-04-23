package com.ubiqube.etsi.mano.v451.model.nfvmanocim;

import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * The enumeration PeerEntityEnumType defines the permitted values to represent peer functional entities. it shall complains with the provisions : - NFVO The peer functional entity is an NFVO. - VNFM The peer functional entity is a VNFM. - VIM   The peer functional entity is a VIM. - WIM   The peer functional entity is a WIM. - CISM  The peer functional entity is a CISM.  - CIR   The NFV-MANO functional entity is a CIR. - CCM   The NFV-MANO functional entity is a CCM. - MDAF  The peer functional entity is a MDAF. - CMF   The peer functional entity is a CMF. - EM   The peer functional entity is an EM. - OSS   The peer functional entity is an OSS/BSS. 
 */
public enum PeerEntityEnumType {
  NFVO("NFVO"),
    VNFM("VNFM"),
    VIM("VIM"),
    WIM("WIM"),
    CISM("CISM"),
    CIR("CIR"),
    CCM("CCM"),
    MDAF("MDAF"),
    CMF("CMF"),
    EM("EM"),
    OSS("OSS");

  private String value;

  PeerEntityEnumType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static PeerEntityEnumType fromValue(String text) {
    for (PeerEntityEnumType b : PeerEntityEnumType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
