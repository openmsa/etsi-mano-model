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
package com.ubiqube.etsi.mano.v451.model.em.vnfconfig;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * This type provides input information related to subject of certificate. * NOTE: At least one overriding attributes shall be present, otherwise shall be absent. 
 */
@Schema(description = "This type provides input information related to subject of certificate. * NOTE: At least one overriding attributes shall be present, otherwise shall be absent. ")
@Validated


public class CertSubjectData   {
  @JsonProperty("commonName")
  private String commonName = null;

  @JsonProperty("organization")
  private String organization = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("locality")
  private String locality = null;

  @JsonProperty("emailAddress")
  private String emailAddress = null;

  public CertSubjectData commonName(String commonName) {
    this.commonName = commonName;
    return this;
  }

  /**
   * Information of certification target subject FQDN. See note.
   * @return commonName
   **/
  @Schema(description = "Information of certification target subject FQDN. See note.")
  
    public String getCommonName() {
    return commonName;
  }

  public void setCommonName(String commonName) {
    this.commonName = commonName;
  }

  public CertSubjectData organization(String organization) {
    this.organization = organization;
    return this;
  }

  /**
   * Information of certification target subject Organization. See note.
   * @return organization
   **/
  @Schema(description = "Information of certification target subject Organization. See note.")
  
    public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public CertSubjectData country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Information of certification target subject Country. See note.
   * @return country
   **/
  @Schema(description = "Information of certification target subject Country. See note.")
  
    public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public CertSubjectData state(String state) {
    this.state = state;
    return this;
  }

  /**
   * Information of certification target subject State. See note.
   * @return state
   **/
  @Schema(description = "Information of certification target subject State. See note.")
  
    public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public CertSubjectData locality(String locality) {
    this.locality = locality;
    return this;
  }

  /**
   * Information of certification target subject Locality. See note.
   * @return locality
   **/
  @Schema(description = "Information of certification target subject Locality. See note.")
  
    public String getLocality() {
    return locality;
  }

  public void setLocality(String locality) {
    this.locality = locality;
  }

  public CertSubjectData emailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

  /**
   * Information of certification contact email address. See note.
   * @return emailAddress
   **/
  @Schema(description = "Information of certification contact email address. See note.")
  
    public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CertSubjectData certSubjectData = (CertSubjectData) o;
    return Objects.equals(this.commonName, certSubjectData.commonName) &&
        Objects.equals(this.organization, certSubjectData.organization) &&
        Objects.equals(this.country, certSubjectData.country) &&
        Objects.equals(this.state, certSubjectData.state) &&
        Objects.equals(this.locality, certSubjectData.locality) &&
        Objects.equals(this.emailAddress, certSubjectData.emailAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commonName, organization, country, state, locality, emailAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CertSubjectData {\n");
    
    sb.append("    commonName: ").append(toIndentedString(commonName)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    locality: ").append(toIndentedString(locality)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
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
