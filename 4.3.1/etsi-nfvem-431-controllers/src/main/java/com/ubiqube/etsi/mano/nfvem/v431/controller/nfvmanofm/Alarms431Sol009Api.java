/**
 *     Copyright (C) 2019-2023 Ubiqube.
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
/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.46).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.ubiqube.etsi.mano.nfvem.v431.controller.nfvmanofm;

import java.util.List;

import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ubiqube.etsi.mano.nfvem.v431.model.nfvmanofm.Alarm;
import com.ubiqube.etsi.mano.nfvem.v431.model.nfvmanofm.AlarmModifications;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@Validated
@RequestMapping(value = { "/sol002/nfvmanofm/v2", "/sol003/nfvmanofm/v2", "/sol005/nfvmanofm/v2" }, headers = { "Version=2.0.1" })
public interface Alarms431Sol009Api {

	@Operation(summary = "", description = "The client can use this method to read an individual alarm. See clause 7.5.4.3.2. ", tags = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "200 OK Shall be returned when information about an individual alarm has been read successfully. The response body shall contain a representation of the individual alarm ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Alarm.class))),
			@ApiResponse(responseCode = "400", description = "400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \"ProblemDetail\" structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \"ProblemDetail\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \"ProblemDetail\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If there is an application error related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetail\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetail structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "401", description = "401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetail structure may be provided. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "403", description = "403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \"ProblemDetail\" structure shall be provided. It should include in the \"detail\" attribute information about the source of the problem, and may indicate how to solve it. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "404", description = "404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \"ProblemDetail\" structure may be provided, including in the \"detail\" attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "405", description = "405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \"ProblemDetail\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "406", description = "406 NOT ACCEPTABLE If the \"Accept\" HTTP header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \"ProblemDetail\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "422", description = "422 UNPROCESSABLE ENTITY If the payload body of a request contains syntactically correct data (e.g. well-formed JSON) but the data cannot be processed (e.g. because it fails validation against a schema), the API producer shall respond with this response code. The \"ProblemDetail\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. This error response code is only applicable for methods that have a request body. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "500", description = "500 INTERNAL SERVER ERROR If there is an application error not related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetail\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "503", description = "503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \"Retry-After\" HTTP header and for the alternative to refuse the connection. The \"ProblemDetail\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "504", description = "504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))) })
	@RequestMapping(value = "/alarms/{alarmId}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<Alarm> alarmsAlarmIdGet(
			@Parameter(in = ParameterIn.PATH, description = "Identifier of the alarm. This identifier can be retrieved from the \"id\" attribute of the \"alarm\" attribute in the AlarmNotification or AlarmClearedNotification. It can also be retrieved from the \"id\" attribute of the applicable array element in the payload body of the response to a GET request to the \"Alarms\" resource. ", required = true, schema = @Schema()) @PathVariable("alarmId") final String alarmId);

	@Operation(summary = "", description = "This method modifies an \"Individual alarm\" resource. See clause 7.5.4.3.4. ", tags = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "200 OK Shall be returned when the request has been accepted and completed. ì The response body shall contain attribute modifications for an \"Individual alarm\" resource (see clause 7.6.2.4). ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlarmModifications.class))),
			@ApiResponse(responseCode = "400", description = "400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \"ProblemDetail\" structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \"ProblemDetail\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \"ProblemDetail\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If there is an application error related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetail\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetail structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "401", description = "401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetail structure may be provided. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "403", description = "403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \"ProblemDetail\" structure shall be provided. It should include in the \"detail\" attribute information about the source of the problem, and may indicate how to solve it. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "404", description = "404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \"ProblemDetail\" structure may be provided, including in the \"detail\" attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "405", description = "405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \"ProblemDetail\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "406", description = "406 NOT ACCEPTABLE If the \"Accept\" HTTP header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \"ProblemDetail\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "409", description = "409 CONFLICT ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "412", description = "412 PRECONDITION FAILED Error: A precondition given in an HTTP request header is not fulfilled. Typically, this is due to an ETag mismatch, indicating that the resource was modified by another entity. The response body should contain a ProblemDetail structure, in which the \"detail\" attribute should convey more information about the error. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "422", description = "422 UNPROCESSABLE ENTITY If the payload body of a request contains syntactically correct data (e.g. well-formed JSON) but the data cannot be processed (e.g. because it fails validation against a schema), the API producer shall respond with this response code. The \"ProblemDetail\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. This error response code is only applicable for methods that have a request body. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "500", description = "500 INTERNAL SERVER ERROR If there is an application error not related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetail\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "503", description = "503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \"Retry-After\" HTTP header and for the alternative to refuse the connection. The \"ProblemDetail\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "504", description = "504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))) })
	@RequestMapping(value = "/alarms/{alarmId}", produces = { "application/json" }, consumes = { "application/json" }, method = RequestMethod.PATCH)
	ResponseEntity<AlarmModifications> alarmsAlarmIdPatch(
			@Parameter(in = ParameterIn.HEADER, description = "The MIME type of the body of the request. Reference: IETF RFC 7231 ", required = true, schema = @Schema()) @RequestHeader(value = "Content-Type", required = true) final String contentType,
			@Parameter(in = ParameterIn.PATH, description = "Identifier of the alarm. This identifier can be retrieved from the \"id\" attribute of the \"alarm\" attribute in the AlarmNotification or AlarmClearedNotification. It can also be retrieved from the \"id\" attribute of the applicable array element in the payload body of the response to a GET request to the \"Alarms\" resource. ", required = true, schema = @Schema()) @PathVariable("alarmId") final String alarmId,
			@Parameter(in = ParameterIn.DEFAULT, description = "The parameter for the alarm modification, as defined in clause 7.6.2.8. The Content-Type header shall be set to \"application/merge-patch+json\" according to IETF RFC 7396.", required = true, schema = @Schema()) @Valid @RequestBody AlarmModifications body);

	@Operation(summary = "", description = "The client can use this method to retrieve information about the alarm list. See clause 7.5.3.3.2. ", tags = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "200 OK Shall be returned when information about zero or more alarms has been queried successfully. The response body shall contain in an array the representations of zero or more alarms as defined in clause 7.6.2.4. If the \"filter\" URI parameter was supplied in the request, the data in the response body shall have been transformed according to the rules specified in clause 5.2.2 of ETSI GS NFV-SOL 013. If the NFV-MANO functional entity supports alternative 2 (paging) according to clause 5.4.2.1 of ETSI GS NFV-SOL 013 for this resource, inclusion of the Link HTTP header in this response shall follow the provisions in clause 5.4.2.3 of ETSI GS NFV-SOL 013. ", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Alarm.class)))),
			@ApiResponse(responseCode = "400", description = "400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \"ProblemDetail\" structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \"ProblemDetail\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \"ProblemDetail\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If there is an application error related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetail\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetail structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "401", description = "401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetail structure may be provided. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "403", description = "403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \"ProblemDetail\" structure shall be provided. It should include in the \"detail\" attribute information about the source of the problem, and may indicate how to solve it. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "404", description = "404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \"ProblemDetail\" structure may be provided, including in the \"detail\" attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "405", description = "405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \"ProblemDetail\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "406", description = "406 NOT ACCEPTABLE If the \"Accept\" HTTP header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \"ProblemDetail\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "422", description = "422 UNPROCESSABLE ENTITY If the payload body of a request contains syntactically correct data (e.g. well-formed JSON) but the data cannot be processed (e.g. because it fails validation against a schema), the API producer shall respond with this response code. The \"ProblemDetail\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. This error response code is only applicable for methods that have a request body. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "500", description = "500 INTERNAL SERVER ERROR If there is an application error not related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetail\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "503", description = "503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \"Retry-After\" HTTP header and for the alternative to refuse the connection. The \"ProblemDetail\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))),
			@ApiResponse(responseCode = "504", description = "504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class))) })
	@RequestMapping(value = "/alarms", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<Alarm>> alarmsGet(
			@Parameter(in = ParameterIn.QUERY, description = "Attribute-based filtering expression according to clause 5.2 of ETSI GS NFV SOL 013. The NFV-MANO functional entity shall support receiving this parameter as part of the URI query string. The API consumer may supply this parameter. The following attribute names shall be supported by the NFV-MANO functional entity in the attribute-based filtering expression: id, managedObjectId, eventType, perceivedSeverity, probableCause. ", schema = @Schema()) @Valid @RequestParam(value = "filter", required = false) final String filter,
			@Parameter(in = ParameterIn.QUERY, description = "Marker to obtain the next page of a paged response. Shall be supported by  the NFV-MANO functional entity if the entity supports alternative 2 (paging)  according to clause 5.4.2.1 of ETSI GS NFV-SOL 013 for this resource. ", schema = @Schema()) @Valid @RequestParam(value = "nextpage_opaque_marker", required = false) final String nextpageOpaqueMarker);
}
