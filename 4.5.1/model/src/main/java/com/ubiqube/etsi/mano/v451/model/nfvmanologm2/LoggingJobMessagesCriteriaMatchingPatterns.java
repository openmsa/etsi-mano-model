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
package com.ubiqube.etsi.mano.v451.model.nfvmanologm2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.Valid;

/**
 * LoggingJobMessagesCriteriaMatchingPatterns
 */
@Validated

public class LoggingJobMessagesCriteriaMatchingPatterns {
	@JsonProperty("srcIpAddress")
	private String srcIpAddress = null;

	@JsonProperty("requestMethod")
	private String requestMethod = null;

	@JsonProperty("requestUriPattern")
	private String requestUriPattern = null;

	@JsonProperty("dstIpAddress")
	private String dstIpAddress = null;

	@JsonProperty("responseCodes")
	@Valid
	private List<String> responseCodes = null;

	@JsonProperty("headerField")
	private String headerField = null;

	@JsonProperty("headerValue")
	private String headerValue = null;

	@JsonProperty("bodyValues")
	private String bodyValues = null;

	public LoggingJobMessagesCriteriaMatchingPatterns srcIpAddress(final String srcIpAddress) {
		this.srcIpAddress = srcIpAddress;
		return this;
	}

	/**
	 * An IPV4 or IPV6 address. Representation: In case of an IPV4 address, string
	 * that consists of four decimal integers separated by dots, each integer
	 * ranging from 0 to 255. In case of an IPV6 address, string that consists of
	 * groups of zero to four hexadecimal digits, separated by colons.
	 *
	 * @return srcIpAddress
	 **/
	@Schema(description = "An IPV4 or IPV6 address. Representation: In case of an IPV4 address, string that consists of four decimal integers separated by dots, each integer ranging from 0 to 255. In case of an IPV6 address, string that consists of groups of zero to four hexadecimal digits, separated by colons. ")

	public String getSrcIpAddress() {
		return srcIpAddress;
	}

	public void setSrcIpAddress(final String srcIpAddress) {
		this.srcIpAddress = srcIpAddress;
	}

	public LoggingJobMessagesCriteriaMatchingPatterns requestMethod(final String requestMethod) {
		this.requestMethod = requestMethod;
		return this;
	}

	/**
	 * HTTP request method to be matched. To match, the HTTP request method of the
	 * message shall be the same as the value of this attribute. Valid values are
	 * specified in IETF RFC 9110 and IETF RFC 5789. The API producer shall support
	 * this attribute.
	 *
	 * @return requestMethod
	 **/
	@Schema(description = "HTTP request method to be matched. To match, the HTTP request method of the message shall be the same as the value of this attribute. Valid values are specified in IETF RFC 9110 and IETF RFC 5789.  The API producer shall support this attribute.")

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(final String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public LoggingJobMessagesCriteriaMatchingPatterns requestUriPattern(final String requestUriPattern) {
		this.requestUriPattern = requestUriPattern;
		return this;
	}

	/**
	 * Substring to be matched in the request URI. To match, the request URI shall
	 * include the value of this attribute as a substring. This is typically used to
	 * match messages which associate to RESTful resources, or to a specific API
	 * (e.g., by using the \"apiName\" of the API). The API producer shall support
	 * this attribute.
	 *
	 * @return requestUriPattern
	 **/
	@Schema(description = "Substring to be matched in the request URI. To match, the request URI shall include the value of  this attribute as a substring. This is typically used to match messages which associate to RESTful  resources, or to a specific API (e.g., by using the \"apiName\" of the API). The API producer shall  support this attribute.")

	public String getRequestUriPattern() {
		return requestUriPattern;
	}

	public void setRequestUriPattern(final String requestUriPattern) {
		this.requestUriPattern = requestUriPattern;
	}

	public LoggingJobMessagesCriteriaMatchingPatterns dstIpAddress(final String dstIpAddress) {
		this.dstIpAddress = dstIpAddress;
		return this;
	}

	/**
	 * An IPV4 or IPV6 address. Representation: In case of an IPV4 address, string
	 * that consists of four decimal integers separated by dots, each integer
	 * ranging from 0 to 255. In case of an IPV6 address, string that consists of
	 * groups of zero to four hexadecimal digits, separated by colons.
	 *
	 * @return dstIpAddress
	 **/
	@Schema(description = "An IPV4 or IPV6 address. Representation: In case of an IPV4 address, string that consists of four decimal integers separated by dots, each integer ranging from 0 to 255. In case of an IPV6 address, string that consists of groups of zero to four hexadecimal digits, separated by colons. ")

	public String getDstIpAddress() {
		return dstIpAddress;
	}

	public void setDstIpAddress(final String dstIpAddress) {
		this.dstIpAddress = dstIpAddress;
	}

	public LoggingJobMessagesCriteriaMatchingPatterns responseCodes(final List<String> responseCodes) {
		this.responseCodes = responseCodes;
		return this;
	}

	public LoggingJobMessagesCriteriaMatchingPatterns addResponseCodesItem(final String responseCodesItem) {
		if (this.responseCodes == null) {
			this.responseCodes = new ArrayList<>();
		}
		this.responseCodes.add(responseCodesItem);
		return this;
	}

	/**
	 * HTTP response codes or patterns to match. A list of all valid HTTP response
	 * codes and their specification documents can be obtained from the HTTP status
	 * code registry. In addition, if supported, the following patterns may be used
	 * (case-insensitive): - \"1XX\": for matching any kind of informational
	 * response. - \"2XX\": for matching any kind of success response. - \"3XX\":
	 * for matching any kind redirection response. - \"4XX\": for matching any kind
	 * of client error response. - \"5XX\": for matching any kind of server error
	 * response. The API producer shall support this attribute
	 *
	 * @return responseCodes
	 **/
	@Schema(description = "HTTP response codes or patterns to match. A list of all valid HTTP response codes and their specification documents can be obtained from the HTTP status code registry. In addition, if supported, the following patterns may be used (case-insensitive): - \"1XX\": for matching any kind of informational response. - \"2XX\": for matching any kind of success response. - \"3XX\": for matching any kind redirection response. - \"4XX\": for matching any kind of client error response. - \"5XX\": for matching any kind of server error response. The API producer shall support this attribute")

	public List<String> getResponseCodes() {
		return responseCodes;
	}

	public void setResponseCodes(final List<String> responseCodes) {
		this.responseCodes = responseCodes;
	}

	public LoggingJobMessagesCriteriaMatchingPatterns headerField(final String headerField) {
		this.headerField = headerField;
		return this;
	}

	/**
	 * Name of the header field to be matched. The header field name shall be one of
	 * the supported fields in a request message as defined in clause 4.2.2 of ETSI
	 * GS NFV-SOL 013 or in a response message as defined in clause 4.2.3 of ETSI GS
	 * NFV-SOL 013, in accordance with the \"direction\" criteria input. The API
	 * producer may support this attribute.
	 *
	 * @return headerField
	 **/
	@Schema(description = "Name of the header field to be matched. The header field name shall be one of the supported fields in a request message as defined in clause 4.2.2 of ETSI GS NFV-SOL 013 or in a response message as defined in clause 4.2.3 of ETSI GS NFV-SOL 013, in accordance with the \"direction\" criteria input. The API producer may support this attribute.")

	public String getHeaderField() {
		return headerField;
	}

	public void setHeaderField(final String headerField) {
		this.headerField = headerField;
	}

	public LoggingJobMessagesCriteriaMatchingPatterns headerValue(final String headerValue) {
		this.headerValue = headerValue;
		return this;
	}

	/**
	 * Value in the header to be matched. To match, the value in the header field
	 * indicated by \"headerField\" shall be the same as in this attribute. Shall be
	 * provided if a \"headerField\" is provided. The API producer may support this
	 * attribute.
	 *
	 * @return headerValue
	 **/
	@Schema(description = "Value in the header to be matched. To match, the value in the header field indicated by \"headerField\" shall be the same as in this attribute. Shall be provided if a \"headerField\" is provided. The API producer may support this attribute.")

	public String getHeaderValue() {
		return headerValue;
	}

	public void setHeaderValue(final String headerValue) {
		this.headerValue = headerValue;
	}

	public LoggingJobMessagesCriteriaMatchingPatterns bodyValues(final String bodyValues) {
		this.bodyValues = bodyValues;
		return this;
	}

	/**
	 * A list of strings to be matched in the body part of the interface message
	 * (e.g., the body of an HTTP message). If provided, only messages with text in
	 * the body part containing all the values from the list shall match the filter.
	 * In addition to a matching filter for the body of the message, a corresponding
	 * \"headerField\" filter shall also be provided, with \"headerField\" set to
	 * \"Content-Type\", to restrict matching to appropriate textual payloads such
	 * as \"application/json\" or \"text/plain\". The API producer may support this
	 * attribute
	 *
	 * @return bodyValues
	 **/
	@Schema(description = "A list of strings to be matched in the body part of the interface message (e.g., the body of an HTTP message). If provided, only messages with text in the body part containing all the values from the list shall match the filter. In addition to a matching filter for the body of the message, a corresponding \"headerField\" filter shall also be provided, with \"headerField\" set to \"Content-Type\", to restrict matching to appropriate textual payloads such as \"application/json\" or \"text/plain\". The API producer may support this attribute")

	public String getBodyValues() {
		return bodyValues;
	}

	public void setBodyValues(final String bodyValues) {
		this.bodyValues = bodyValues;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (getClass() != o.getClass())) {
			return false;
		}
		final LoggingJobMessagesCriteriaMatchingPatterns loggingJobMessagesCriteriaMatchingPatterns = (LoggingJobMessagesCriteriaMatchingPatterns) o;
		return Objects.equals(this.srcIpAddress, loggingJobMessagesCriteriaMatchingPatterns.srcIpAddress) &&
				Objects.equals(this.requestMethod, loggingJobMessagesCriteriaMatchingPatterns.requestMethod) &&
				Objects.equals(this.requestUriPattern, loggingJobMessagesCriteriaMatchingPatterns.requestUriPattern) &&
				Objects.equals(this.dstIpAddress, loggingJobMessagesCriteriaMatchingPatterns.dstIpAddress) &&
				Objects.equals(this.responseCodes, loggingJobMessagesCriteriaMatchingPatterns.responseCodes) &&
				Objects.equals(this.headerField, loggingJobMessagesCriteriaMatchingPatterns.headerField) &&
				Objects.equals(this.headerValue, loggingJobMessagesCriteriaMatchingPatterns.headerValue) &&
				Objects.equals(this.bodyValues, loggingJobMessagesCriteriaMatchingPatterns.bodyValues);
	}

	@Override
	public int hashCode() {
		return Objects.hash(srcIpAddress, requestMethod, requestUriPattern, dstIpAddress, responseCodes, headerField, headerValue, bodyValues);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("class LoggingJobMessagesCriteriaMatchingPatterns {\n");

		sb.append("    srcIpAddress: ").append(toIndentedString(srcIpAddress)).append("\n");
		sb.append("    requestMethod: ").append(toIndentedString(requestMethod)).append("\n");
		sb.append("    requestUriPattern: ").append(toIndentedString(requestUriPattern)).append("\n");
		sb.append("    dstIpAddress: ").append(toIndentedString(dstIpAddress)).append("\n");
		sb.append("    responseCodes: ").append(toIndentedString(responseCodes)).append("\n");
		sb.append("    headerField: ").append(toIndentedString(headerField)).append("\n");
		sb.append("    headerValue: ").append(toIndentedString(headerValue)).append("\n");
		sb.append("    bodyValues: ").append(toIndentedString(bodyValues)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(final java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
