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
 *     along with this program.  If not, see https://www.gnu.org/licenses/.
 */
package com.ubiqube.etsi.mano.v431.model.nfvo.vnf;

import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * The enumeration PackageOnboardingStateType shall comply with the provisions defined in Table 9.5.4.3-1. Permitted values: - CREATED: The VNF package resource has been created. - UPLOADING: The associated VNF package content is being uploaded. - PROCESSING: The associated VNF package content is being processed, e.g. validation. - ONBOARDED: The associated VNF package content is successfully on-boarded. - ERROR: There was an error during upload of the VNF package content or external artifacts, or during VNF package processing. 
 */
public enum PackageOnboardingStateType {
  CREATED("CREATED"),
    UPLOADING("UPLOADING"),
    PROCESSING("PROCESSING"),
    ONBOARDED("ONBOARDED"),
    ERROR("ERROR");

  private String value;

  PackageOnboardingStateType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static PackageOnboardingStateType fromValue(String text) {
    for (PackageOnboardingStateType b : PackageOnboardingStateType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
