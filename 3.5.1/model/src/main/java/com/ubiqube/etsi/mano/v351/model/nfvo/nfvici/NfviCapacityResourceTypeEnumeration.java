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
package com.ubiqube.etsi.mano.v351.model.nfvo.nfvici;

import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * The enumeration NfviCapacityResourceTypeEnumeration shall comply with the provisions in table 10.5.4.3-1. * VR_COMPUTE: For virtualised compute resource. * VR_NETWORK: For virtualised network resource. * VR_STORAGE: For virtualised storage resource. * HOST_COMPUTE: For host compute resource. 
 */
public enum NfviCapacityResourceTypeEnumeration {
  VR_COMPUTE("VR_COMPUTE"),
    VR_NETWORK("VR_NETWORK"),
    VR_STORAGE("VR_STORAGE"),
    HOST_COMPUTE("HOST_COMPUTE");

  private String value;

  NfviCapacityResourceTypeEnumeration(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static NfviCapacityResourceTypeEnumeration fromValue(String text) {
    for (NfviCapacityResourceTypeEnumeration b : NfviCapacityResourceTypeEnumeration.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
