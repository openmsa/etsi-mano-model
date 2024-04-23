package com.ubiqube.etsi.mano.v451.model.nfvmanocim;

import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * The enumeration ManoEntityEnumType defines the permitted values to represent NFV-MANO functional entities. It shall comply with the provisions :   - NFVO The NFV-MANO functional entity is an NFVO.   - VNFM The NFV-MANO functional entity is a VNFM.   - VIM   The NFV-MANO functional entity is a VIM.   - WIM   The NFV-MANO functional entity is a WIM.   - CISM  The NFV-MANO functional entity is a CISM.    - CIR   The NFV-MANO functional entity is a CIR.   - CCM   The NFV-MANO functional entity is a CCM.   - MDAF  The NFV-MANO functional entity is a MDAF.   - CMF   The NFV-MANO functional entity is a CMF. 
 */
public enum ManoEntityEnumType {
  NFVO("NFVO"),
    VNFM("VNFM"),
    VIM("VIM"),
    WIM("WIM"),
    CISM("CISM"),
    CIR("CIR"),
    CCM("CCM"),
    MDAF("MDAF"),
    CMF("CMF");

  private String value;

  ManoEntityEnumType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ManoEntityEnumType fromValue(String text) {
    for (ManoEntityEnumType b : ManoEntityEnumType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
