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
/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.ubiqube.etsi.mano.v431.nfvo.controller.nfvo.nslcm;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ubiqube.etsi.mano.v431.model.em.vnfconfig.ProblemDetails;
import com.ubiqube.etsi.mano.v431.model.em.vnflcm.CancelMode;
import com.ubiqube.etsi.mano.v431.model.nfvo.nslcm.NsLcmOpOcc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;

@Validated
@RequestMapping(value = "/sol005/nslcm/v2", headers = { "Version=2.10.0" })
@RolesAllowed({ "ROLE_OSSBSS" })
public interface Nslcm431Sol005Api {

	@Operation(summary = "", description = "The POST method initiates cancelling an ongoing NS lifecycle management operation while it is being executed or rolled back, i.e. the related \"NS LCM operation occurrence\" is either in \"PROCESSING\" or \"ROLLING_BACK\" state. See clause 6.4.15.3.1. ", tags = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "202 ACCEPTED  Shall be returned when the request has been accepted for processing, but processing has not been completed. The response shall have an empty entity body. "),
			@ApiResponse(responseCode = "400", description = "400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \"ProblemDetails\" structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If there is an application error related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "401", description = "401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "403", description = "403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided. It should include in the \"detail\" attribute information about the source of the problem, and may indicate how to solve it. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "404", description = "404 NOT FOUND  Shall be returned upon the following error: The API producer did not find a current representation for the target resource or is not willing to disclose that one exists. The general cause for this error and its handling is specified in clause 6.4 of ETSI GS NFV-SOL 013 [16], including rules for the presence of the response body. Specifically, in case of this task resource, the response code 404 shall also be returned if the task is not supported for the NS LCM operation occurrence represented by the parent resource, which means that the task resource consequently does not exist. In this case, the response body shall be present, and shall contain a ProblemDetails structure, in which the \"detail\" attribute shall convey more information about the error. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "405", description = "405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "406", description = "406 NOT ACCEPTABLE If the \"Accept\" HTTP header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "409", description = "409 CONFLICT  Shall be returned upon the following error: The operation cannot be executed currently, due to a conflict with the state of the NS LCM operation occurrence resource. Typically, this is due to the fact that the operation occurrence is not in STARTING, PROCESSING or ROLLING_BACK state. The response body shall contain a ProblemDetails structure, in which the \"detail\" attribute shall convey more information about the error. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "416", description = "416 Range Not Satisfiable ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "500", description = "500 INTERNAL SERVER ERROR If there is an application error not related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "503", description = "503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \"Retry-After\" HTTP header and for the alternative to refuse the connection. The \"ProblemDetails\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "504", description = "504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))) })
	@PostMapping(value = "/nslcm/v1/ns_lcm_op_occs/{nsLcmOpOccId}/cancel", produces = { "application/json" }, consumes = { "application/json" })
	ResponseEntity<Void> nslcmV1NsLcmOpOccsNsLcmOpOccIdCancelPost(
			@Parameter(in = ParameterIn.PATH, description = "Identifier of a NS lifecycle management operation occurrence. ", required = true, schema = @Schema()) @PathVariable("nsLcmOpOccId") final String nsLcmOpOccId,
			@Parameter(in = ParameterIn.DEFAULT, description = "The POST request to this resource shall include a CancelMode structure in the payload body to choose between \"graceful\" and \"forceful\" cancellation.", required = true, schema = @Schema()) @Valid @RequestBody final CancelMode body);

	@Operation(summary = "", description = "The POST method marks an NS lifecycle management operation occurrence as \"finally failed\" if that operation occurrence is in \"FAILED_TEMP\" state. See clause 6.4.14.3.1. ", tags = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "200 OK Shall be returned when the state of the NS lifecycle management operation occurrence has been changed successfully. The response shall include a representation of the \"Individual NS lifecycle management operation occurrence\" resource. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = NsLcmOpOcc.class))),
			@ApiResponse(responseCode = "400", description = "400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \"ProblemDetails\" structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If there is an application error related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "401", description = "401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "403", description = "403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided. It should include in the \"detail\" attribute information about the source of the problem, and may indicate how to solve it. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "404", description = "404 NOT FOUND  Shall be returned upon the following error: The API producer did not find a current representation for the target resource or is not willing to disclose that one exists. The general cause for this error and its handling is specified in clause 6.4 of ETSI GS NFV-SOL 013 [16], including rules for the presence of the response body. Specifically in case of this task resource, the response code 404 shall also be returned if the task is not supported for the NS LCM operation occurrence represented by the parent resource, which means that the task resource consequently does not exist. In this case, the response body shall be present, and shall contain a ProblemDetails structure, in which the \"detail\" attribute shall convey more information about the error. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "405", description = "405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "406", description = "406 NOT ACCEPTABLE If the \"Accept\" HTTP header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "409", description = "409 CONFLICT  Shall be returned upon the following error: The operation cannot be executed currently, due to a conflict with the state of the NS LCM operation occurrence resource. Typically, this is due to the fact that the NS LCM operation occurrence is not in FAILED_TEMP state, or another error handling action is starting, such as retry or rollback. The response body shall contain a ProblemDetails structure, in which the \"detail\" attribute shall convey more information about the error. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "416", description = "416 Range Not Satisfiable ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "500", description = "500 INTERNAL SERVER ERROR If there is an application error not related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "503", description = "503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \"Retry-After\" HTTP header and for the alternative to refuse the connection. The \"ProblemDetails\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "504", description = "504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))) })
	@PostMapping(value = "/nslcm/v1/ns_lcm_op_occs/{nsLcmOpOccId}/fail", produces = { "application/json" })
	ResponseEntity<NsLcmOpOcc> nslcmV1NsLcmOpOccsNsLcmOpOccIdFailPost(
			@Parameter(in = ParameterIn.PATH, description = "Identifier of a NS lifecycle management operation occurrence. ", required = true, schema = @Schema()) @PathVariable("nsLcmOpOccId") final String nsLcmOpOccId);
}
