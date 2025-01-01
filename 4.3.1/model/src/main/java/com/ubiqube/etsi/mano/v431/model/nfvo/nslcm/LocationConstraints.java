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
package com.ubiqube.etsi.mano.v431.model.nfvo.nslcm;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.v431.model.nfvo.nslcm.LocationConstraintsCivicAddressElement;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type represents location constraints for a VNF to be instantiated. The location constraints can be represented as follows: • as a country code • as a civic address combined with a country code • as an area, conditionally combined with a country code NOTE: If both \&quot;countryCode\&quot; and \&quot;area\&quot; are present, no conflicts should exist between the values of these two attributes. In case of conflicts, the API producer (i.e. the NFVO) shall disregard parts of the geographic area signalled by \&quot;area\&quot; that are outside the boundaries of the country signalled by \&quot;countryCode\&quot;. If \&quot;countryCode\&quot; is absent, it is solely the \&quot;area\&quot; attribute that defines the location constraint. 
 */
@Schema(description = "This type represents location constraints for a VNF to be instantiated. The location constraints can be represented as follows: • as a country code • as a civic address combined with a country code • as an area, conditionally combined with a country code NOTE: If both \"countryCode\" and \"area\" are present, no conflicts should exist between the values of these two attributes. In case of conflicts, the API producer (i.e. the NFVO) shall disregard parts of the geographic area signalled by \"area\" that are outside the boundaries of the country signalled by \"countryCode\". If \"countryCode\" is absent, it is solely the \"area\" attribute that defines the location constraint. ")
@Validated


public class LocationConstraints   {
  @JsonProperty("countryCode")
  private String countryCode = null;

  @JsonProperty("civicAddressElement")
  @Valid
  private List<LocationConstraintsCivicAddressElement> civicAddressElement = null;

  @JsonProperty("area")
  private Object area = null;

  public LocationConstraints countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * The two-letter ISO 3166 country code in capital letters. Shall be present in case the \"area\" attribute is absent. May be absent if the \"area\" attribute is present (see note). 
   * @return countryCode
   **/
  @Schema(description = "The two-letter ISO 3166 country code in capital letters. Shall be present in case the \"area\" attribute is absent. May be absent if the \"area\" attribute is present (see note). ")
  
    public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public LocationConstraints civicAddressElement(List<LocationConstraintsCivicAddressElement> civicAddressElement) {
    this.civicAddressElement = civicAddressElement;
    return this;
  }

  public LocationConstraints addCivicAddressElementItem(LocationConstraintsCivicAddressElement civicAddressElementItem) {
    if (this.civicAddressElement == null) {
      this.civicAddressElement = new ArrayList<>();
    }
    this.civicAddressElement.add(civicAddressElementItem);
    return this;
  }

  /**
   * Zero or more elements comprising the civic address. Shall be absent if the \"area\" attribute is present. 
   * @return civicAddressElement
   **/
  @Schema(description = "Zero or more elements comprising the civic address. Shall be absent if the \"area\" attribute is present. ")
      @Valid
    public List<LocationConstraintsCivicAddressElement> getCivicAddressElement() {
    return civicAddressElement;
  }

  public void setCivicAddressElement(List<LocationConstraintsCivicAddressElement> civicAddressElement) {
    this.civicAddressElement = civicAddressElement;
  }

  public LocationConstraints area(Object area) {
    this.area = area;
    return this;
  }

  /**
   * Geographic area. Shall be absent if the \"civicAddressElement\" attribute is present. The content of this attribute shall follow the provisions for the \"Polygon\" geometry object as defined in IETF RFC 7946, for which the \"type\" member shall be set to the value \"Polygon\". See note. 
   * @return area
   **/
  @Schema(description = "Geographic area. Shall be absent if the \"civicAddressElement\" attribute is present. The content of this attribute shall follow the provisions for the \"Polygon\" geometry object as defined in IETF RFC 7946, for which the \"type\" member shall be set to the value \"Polygon\". See note. ")
  
    public Object getArea() {
    return area;
  }

  public void setArea(Object area) {
    this.area = area;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocationConstraints locationConstraints = (LocationConstraints) o;
    return Objects.equals(this.countryCode, locationConstraints.countryCode) &&
        Objects.equals(this.civicAddressElement, locationConstraints.civicAddressElement) &&
        Objects.equals(this.area, locationConstraints.area);
  }

  @Override
  public int hashCode() {
    return Objects.hash(countryCode, civicAddressElement, area);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocationConstraints {\n");
    
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    civicAddressElement: ").append(toIndentedString(civicAddressElement)).append("\n");
    sb.append("    area: ").append(toIndentedString(area)).append("\n");
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
