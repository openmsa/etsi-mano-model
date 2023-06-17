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
package com.ubiqube.etsi.mano.nfvo.v271.controller.vnf;

import java.util.List;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ubiqube.etsi.mano.em.v271.model.vnfconfig.ProblemDetails;
import com.ubiqube.etsi.mano.model.v271.sol003.vnf.PkgmSubscription;
import com.ubiqube.etsi.mano.model.v271.sol003.vnf.PkgmSubscriptionRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 *
 * @author Olivier Vignaud <ovi@ubiqube.com>
 *
 */
@Tag(name= "subscriptions")
@RequestMapping(value = "/sol005/vnfpkgm/v2/subscriptions", headers = { "Version=2.0.0" })
@RolesAllowed({ "ROLE_OSSBSS" })
public interface VnfSubscriptions271Sol005Api {

	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "200 OK Shall be returned when the list of subscriptions has been queried successfully. The response body shall contain in an array the representations of all active subscriptions of the functional block that invokes the method, i.e. zero or more representations of VNF package management subscriptions as defined in clause 10.5.2.4. If the \"filter\" URI parameter was supplied in the request, the data in the response body shall have been transformed according to the rules specified in clause 5.2.2 of ETSI GS NFV-SOL 013 If the VNFM supports alternative 2 (paging) according to clause 5.4.2.1 of ETSI GS NFV-SOL 013 for this resource, inclusion of the Link HTTP header in this response shall follow the provisions in clause 5.4.2.3 of ETSI GS NFV-SOL 013. ",content = @Content(schema = @Schema(implementation = PkgmSubscription.class))),@ApiResponse(responseCode = "400",description = "400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \"ProblemDetails\" structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If there is an application error related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "401",description = "401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "403",description = "403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided. It should include in the \"detail\" attribute information about the source of the problem, and may indicate how to solve it. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "404",description = "404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \"ProblemDetails\" structure may be provided, including in the \"detail\" attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "405",description = "405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "406",description = "406 NOT ACCEPTABLE If the \"Accept\" HTTP header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "422",description = "422 UNPROCESSABLE ENTITY If the payload body of a request contains syntactically correct data (e.g. well-formed JSON) but the data cannot be processed (e.g. because it fails validation against a schema), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. This error response code is only applicable for methods that have a request body. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "500",description = "500 INTERNAL SERVER ERROR If there is an application error not related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "503",description = "503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \"Retry-After\" HTTP header and for the alternative to refuse the connection. The \"ProblemDetails\" structure may be omitted. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "504",description = "504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class)))})
	@GetMapping(produces = {"application/json"})
	@Operation(description = "Query Subscription Information. The GET method queries the list of active subscriptions of the functional block that invokes the method. It can be used e.g. for resynchronization after error situations. This method shall follow the provisions specified in the tables 10.4.7.3.2-1 and 10.4.7.3.2-2 for URI query parameters, request and response data structures, and response codes. ")
	ResponseEntity<List<PkgmSubscription>> subscriptionsGet(@Parameter(in = ParameterIn.QUERY,description = "Marker to obtain the next page of a paged response. Shall be  supported by the NFVO if the NFVO supports alternative 2 (paging) according to clause 5.4.2.1 of ETSI GS NFV-SOL 013 for this resource. ") @Valid @RequestParam(value = "nextpage_opaque_marker",required = false) final String nextpageOpaqueMarker);

	@ApiResponses(value = {@ApiResponse(responseCode = "201",description = "201 CREATED Shall be returned when the subscription has been created successfully. The response body shall contain a representation of the created \"Individual subscription\" resource. The HTTP response shall include a \"Location\" HTTP header that points to the created resource. ",content = @Content(schema = @Schema(implementation = PkgmSubscription.class))),@ApiResponse(responseCode = "303",description = "303 See Other "),@ApiResponse(responseCode = "400",description = "400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \"ProblemDetails\" structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If there is an application error related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "401",description = "401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "403",description = "403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided. It should include in the \"detail\" attribute information about the source of the problem, and may indicate how to solve it. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "404",description = "404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \"ProblemDetails\" structure may be provided, including in the \"detail\" attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "405",description = "405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "406",description = "406 NOT ACCEPTABLE If the \"Accept\" HTTP header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "422",description = "422 UNPROCESSABLE ENTITY If the payload body of a request contains syntactically correct data (e.g. well-formed JSON) but the data cannot be processed (e.g. because it fails validation against a schema), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. This error response code is only applicable for methods that have a request body. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "500",description = "500 INTERNAL SERVER ERROR If there is an application error not related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "503",description = "503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \"Retry-After\" HTTP header and for the alternative to refuse the connection. The \"ProblemDetails\" structure may be omitted. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "504",description = "504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class)))})
	@Operation(description = "Subscribe. The POST method creates a new subscription. This method shall follow the provisions specified in the tables 10.4.7.3.1-1 and 10.4.7.3.1-2 for URI query parameters, request and response data structures, and response codes. As the result of successfully executing this method, a new \"Individual subscription\" resource as defined in clause 10.4.8 shall have been created. This method shall not trigger any notification. Creation of two \"Individual subscription\" resources with the same callbackURI and the same filter can result in performance degradation and will provide duplicates of notifications to the VNFM, and might make sense only in very rare use cases. Consequently, the NFVO may either allow creating a new \"Individual subscription\" resource if another \"Individual subscription\" resource with the same filter and callbackUri already exists (in which case it shall return the \"201 Created\" response code), or may decide to not create a duplicate \"Individual subscription\" resource (in which case it shall return a \"303 See Other\" response code referencing the existing \"Individual subscription\" resource with the same filter and callbackUri). ")
	@PostMapping(produces = {"application/json"},consumes = {"application/json"})
	ResponseEntity<PkgmSubscription> subscriptionsPost(@Parameter(in = ParameterIn.DEFAULT,description = "Representation of the created subscription resource. The HTTP response shall include a \"Location\" HTTP header that points to the created subscription resource. " ,required = true) @Valid @RequestBody final PkgmSubscriptionRequest pkgmSubscriptionRequest);

	@ApiResponses(value = {@ApiResponse(responseCode = "204",description = "204 NO CONTENT Shall be returned when the \"Individual subscription\" resource has been deleted successfully. "),@ApiResponse(responseCode = "400",description = "400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \"ProblemDetails\" structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If there is an application error related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "401",description = "401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "403",description = "403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided. It should include in the \"detail\" attribute information about the source of the problem, and may indicate how to solve it. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "404",description = "404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \"ProblemDetails\" structure may be provided, including in the \"detail\" attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "405",description = "405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "406",description = "406 NOT ACCEPTABLE If the \"Accept\" HTTP header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "422",description = "422 UNPROCESSABLE ENTITY If the payload body of a request contains syntactically correct data (e.g. well-formed JSON) but the data cannot be processed (e.g. because it fails validation against a schema), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. This error response code is only applicable for methods that have a request body. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "500",description = "500 INTERNAL SERVER ERROR If there is an application error not related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "503",description = "503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \"Retry-After\" HTTP header and for the alternative to refuse the connection. The \"ProblemDetails\" structure may be omitted. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "504",description = "504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class)))})
	@DeleteMapping(value = "/{subscriptionId}",produces = {"application/json"})
	@Operation(description = "Terminate subscription. The DELETE method terminates an individual subscription. This method shall follow the provisions specified in the tables 10.4.8.3.5-1 and 10.4.8.3.5-2 for URI query parameters, request and response data structures, and response codes. As the result of successfully executing this method, the \"Individual subscription\" resource shall not exist any longer. This means that no notifications for that subscription shall be sent to the formerly-subscribed API consumer.    NOTE: Due to race conditions, some notifications might still be received by the formerly-subscribed         API consumer for a certain time period after the deletion. ")
	ResponseEntity<Void> subscriptionsSubscriptionIdDelete(@Parameter(in = ParameterIn.PATH,description = "Identifier of this subscription. This identifier can be retrieved from the resource referenced by the \"Location\" HTTP header in the response to a POST request creating a new \"Individual subscription\" resource. It can also be retrieved from the \"id\" attribute in the payload body of that response. " ,required = true) @PathVariable("subscriptionId") final String subscriptionId);

	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "200 OK Shall be returned when information about an individual subscription has been read successfully. The response body shall contain a representation of the \"Individual subscription\" resource. ",content = @Content(schema = @Schema(implementation = PkgmSubscription.class))),@ApiResponse(responseCode = "400",description = "400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \"ProblemDetails\" structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If there is an application error related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "401",description = "401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "403",description = "403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided. It should include in the \"detail\" attribute information about the source of the problem, and may indicate how to solve it. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "404",description = "404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \"ProblemDetails\" structure may be provided, including in the \"detail\" attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "405",description = "405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "406",description = "406 NOT ACCEPTABLE If the \"Accept\" HTTP header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "422",description = "422 UNPROCESSABLE ENTITY If the payload body of a request contains syntactically correct data (e.g. well-formed JSON) but the data cannot be processed (e.g. because it fails validation against a schema), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. This error response code is only applicable for methods that have a request body. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "500",description = "500 INTERNAL SERVER ERROR If there is an application error not related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "503",description = "503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \"Retry-After\" HTTP header and for the alternative to refuse the connection. The \"ProblemDetails\" structure may be omitted. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class))),@ApiResponse(responseCode = "504",description = "504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. ",content = @Content(schema = @Schema(implementation = ProblemDetails.class)))})
	@GetMapping(value = "/{subscriptionId}",produces = {"application/json"})
	@Operation(description = "Query Subscription Information. The GET method reads an individual subscription. This method shall follow the provisions specified in the tables 10.4.8.3.2-1 and 10.4.8.3.2-2 for URI query parameters, request and response data structures, and response codes. ")
	ResponseEntity<PkgmSubscription> subscriptionsSubscriptionIdGet(@Parameter(in = ParameterIn.PATH,description = "Identifier of this subscription. This identifier can be retrieved from the resource referenced by the \"Location\" HTTP header in the response to a POST request creating a new \"Individual subscription\" resource. It can also be retrieved from the \"id\" attribute in the payload body of that response. " ,required = true) @PathVariable("subscriptionId") final String subscriptionId);

}
