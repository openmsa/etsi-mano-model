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
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.ubiqube.etsi.mano.em.v351.controller.vnfind;

import java.util.List;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ubiqube.etsi.mano.em.v351.model.vnfconfig.ProblemDetails;
import com.ubiqube.etsi.mano.em.v351.model.vnfind.VnfIndicator;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RequestMapping(value = "/sol002/vnfind/v1", headers = { "Version=1.3.1" })
@RolesAllowed({ "ROLE_EM" })
@Validated
public interface Indicators351Sol002Api {

	@Operation(summary = "", description = "The GET method queries multiple VNF indicators. See clause 8.4.2.3.2. ", tags = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "200 OK Shall be returned when information about zero or more VNF indicators was  queried successfully. The response body shall contain in an array the  representations of all VNF indicators that match the attribute-based  filtering parameters, i.e. zero or more representations of VNF indicators  as defined in clause 8.5.2.2. If the \"filter\" URI parameter was supplied in the request, the data in  the response body shall have been transformed according to the rules  specified in clause 5.2.2 of ETSI GS NFV-SOL 013. If the EM/VNF supports alternative 2 (paging) according to clause 5.4.2.1  of ETSI GS NFV-SOL 013for this resource, inclusion of the Link HTTP header  in this response shall follow the provisions in clause 5.4.2.3 of  ETSI GS NFV-SOL 013. ", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = VnfIndicator.class)))),
			@ApiResponse(responseCode = "400", description = "400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \"ProblemDetails\" structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If there is an application error related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "401", description = "401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "403", description = "403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided. It should include in the \"detail\" attribute information about the source of the problem, and may indicate how to solve it. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "404", description = "404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \"ProblemDetails\" structure may be provided, including in the \"detail\" attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "405", description = "405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "406", description = "406 NOT ACCEPTABLE If the \"Accept\" HTTP header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "416", description = "416 Range Not Satisfiable ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "422", description = "422 UNPROCESSABLE ENTITY If the payload body of a request contains syntactically correct data (e.g. well-formed JSON) but the data cannot be processed (e.g. because it fails validation against a schema), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. This error response code is only applicable for methods that have a request body. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "429", description = "429 TOO MANY REQUESTS If the API consumer has sent too many requests in a defined period of time and the API producer is able to detect that condition (\"rate limiting\"), the API producer shall respond with this response code, following the provisions in IETF RFC 6585 [17] for the use of the \"Retry-After\" HTTP header. The \"ProblemDetails\" structure shall be provided and shall include in the \"detail\" attribute more information about the source of the problem. The period of time and allowed number of requests are configured within the API producer by means outside the scope of the present document. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "500", description = "500 INTERNAL SERVER ERROR If there is an application error not related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "503", description = "503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \"Retry-After\" HTTP header and for the alternative to refuse the connection. The \"ProblemDetails\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "504", description = "504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))) })
            @GetMapping(value = "/indicators", produces = {"application/json"})
	ResponseEntity<List<VnfIndicator>> indicatorsGet(
			@Parameter(in = ParameterIn.QUERY, description = "Attribute-based filtering expression according to clause 5.2 of ETSI GS NFV-SOL 013. The VNFM shall support receiving this parameter as part of the URI query string. The API consumer may supply this parameter. All attribute names that appear in the FmSubscription and in data types referenced from it shall be supported by the NFV-MANO functional entity in the filter expression. ", schema = @Schema()) @Valid @RequestParam(value = "filter", required = false) String filter,
			@Parameter(in = ParameterIn.QUERY, description = "Marker to obtain the next page of a paged response. Shall be supported by the VNFM if the entity supports alternative 2 (paging) according to clause 5.4.2.1 of ETSI GS NFV-SOL 013 for this resource. ", schema = @Schema()) @Valid @RequestParam(value = "nextpage_opaque_marker", required = false) String nextpageOpaqueMarker);

	@Operation(summary = "", description = "The GET method queries multiple VNF indicators related to a VNF instance. See clause 8.4.3.3.2. ", tags = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "200 OK Shall be returned when information about zero or more VNF indicators  was queried successfully. The response body shall contain in an array the representations of all VNF indicators that are related to the particular VNF instance and that match the attribute filter., i.e. zero or more representations of VNF indicators as defined in clause 8.5.2.2. If the \"filter\" URI parameter was supplied in the request, the data in  the response body shall have been transformed according to the rules  specified in clause 5.2.2 of ETSI GS NFV-SOL 013. If the EM/VMF supports alternative 2 (paging) according to clause 5.4.2.1 of ETSI GS NFV-SOL 013 for this resource, inclusion of the Link HTTP  header in this response shall follow the provisions in clause 5.4.2.3  of ETSI GS NFV-SOL 013. ", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = VnfIndicator.class)))),
			@ApiResponse(responseCode = "400", description = "400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \"ProblemDetails\" structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If there is an application error related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "401", description = "401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "403", description = "403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided. It should include in the \"detail\" attribute information about the source of the problem, and may indicate how to solve it. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "404", description = "404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \"ProblemDetails\" structure may be provided, including in the \"detail\" attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "405", description = "405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "406", description = "406 NOT ACCEPTABLE If the \"Accept\" HTTP header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "416", description = "416 Range Not Satisfiable ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "422", description = "422 UNPROCESSABLE ENTITY If the payload body of a request contains syntactically correct data (e.g. well-formed JSON) but the data cannot be processed (e.g. because it fails validation against a schema), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. This error response code is only applicable for methods that have a request body. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "429", description = "429 TOO MANY REQUESTS If the API consumer has sent too many requests in a defined period of time and the API producer is able to detect that condition (\"rate limiting\"), the API producer shall respond with this response code, following the provisions in IETF RFC 6585 [17] for the use of the \"Retry-After\" HTTP header. The \"ProblemDetails\" structure shall be provided and shall include in the \"detail\" attribute more information about the source of the problem. The period of time and allowed number of requests are configured within the API producer by means outside the scope of the present document. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "500", description = "500 INTERNAL SERVER ERROR If there is an application error not related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "503", description = "503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \"Retry-After\" HTTP header and for the alternative to refuse the connection. The \"ProblemDetails\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "504", description = "504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))) })
            @GetMapping(value = "/indicators/{vnfInstanceId}", produces = {"application/json"})
	ResponseEntity<List<VnfIndicator>> indicatorsVnfInstanceIdGet(
			@Parameter(in = ParameterIn.PATH, description = "Service Unavailable. Identifier of the VNF instance to which the VNF indicators applies. NOTE: This identifier can be retrieved from the resource referenced by the \"Location\" HTTP header in the response to a POST request creating a new VNF instance resource. It can also be retrieved from the \"id\" attribute in the payload body of that response. ", required = true, schema = @Schema()) @PathVariable("vnfInstanceId") String vnfInstanceId,
			@Parameter(in = ParameterIn.QUERY, description = "Attribute-based filtering expression according to clause 5.2 of ETSI GS NFV-SOL 013. The VNFM shall support receiving this parameter as part of the URI query string. The API consumer may supply this parameter. All attribute names that appear in the FmSubscription and in data types referenced from it shall be supported by the NFV-MANO functional entity in the filter expression. ", schema = @Schema()) @Valid @RequestParam(value = "filter", required = false) String filter,
			@Parameter(in = ParameterIn.QUERY, description = "Marker to obtain the next page of a paged response. Shall be supported by the VNFM if the entity supports alternative 2 (paging) according to clause 5.4.2.1 of ETSI GS NFV-SOL 013 for this resource. ", schema = @Schema()) @Valid @RequestParam(value = "nextpage_opaque_marker", required = false) String nextpageOpaqueMarker);

	@Operation(summary = "", description = "The GET method reads a VNF indicator. See clause 8.4.4.3.2. ", tags = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "200 OK Shall be returned when the VNF indicator has been read successfully. The response body shall contain the representation of the VNF indicator. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = VnfIndicator.class))),
			@ApiResponse(responseCode = "400", description = "400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \"ProblemDetails\" structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If there is an application error related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "401", description = "401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "403", description = "403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided. It should include in the \"detail\" attribute information about the source of the problem, and may indicate how to solve it. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "404", description = "404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \"ProblemDetails\" structure may be provided, including in the \"detail\" attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "405", description = "405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "406", description = "406 NOT ACCEPTABLE If the \"Accept\" HTTP header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "416", description = "416 Range Not Satisfiable ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "422", description = "422 UNPROCESSABLE ENTITY If the payload body of a request contains syntactically correct data (e.g. well-formed JSON) but the data cannot be processed (e.g. because it fails validation against a schema), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. This error response code is only applicable for methods that have a request body. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "429", description = "429 TOO MANY REQUESTS If the API consumer has sent too many requests in a defined period of time and the API producer is able to detect that condition (\"rate limiting\"), the API producer shall respond with this response code, following the provisions in IETF RFC 6585 [17] for the use of the \"Retry-After\" HTTP header. The \"ProblemDetails\" structure shall be provided and shall include in the \"detail\" attribute more information about the source of the problem. The period of time and allowed number of requests are configured within the API producer by means outside the scope of the present document. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "500", description = "500 INTERNAL SERVER ERROR If there is an application error not related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "503", description = "503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \"Retry-After\" HTTP header and for the alternative to refuse the connection. The \"ProblemDetails\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "504", description = "504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))) })
            @GetMapping(value = "/indicators/{vnfInstanceId}/{indicatorId}", produces = {"application/json"})
	ResponseEntity<VnfIndicator> indicatorsVnfInstanceIdIndicatorIdGet(
			@Parameter(in = ParameterIn.PATH, description = "Service Unavailable. Identifier of the VNF instance to which the VNF indicators applies. NOTE: This identifier can be retrieved from the resource referenced by the \"Location\" HTTP header in the response to a POST request creating a new VNF instance resource. It can also be retrieved from the \"id\" attribute in the payload body of that response. ", required = true, schema = @Schema()) @PathVariable("vnfInstanceId") String vnfInstanceId,
			@Parameter(in = ParameterIn.PATH, description = "Identifier of the VNF indicator. ", required = true, schema = @Schema()) @PathVariable("indicatorId") String indicatorId);

}
