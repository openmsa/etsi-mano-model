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
package com.ubiqube.etsi.mano.v261.nfvo.controller.nspm;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ubiqube.etsi.mano.v261.model.nfvo.nsperfo.PerformanceInformationAvailableNotification;
import com.ubiqube.etsi.mano.v261.model.nfvo.nsperfo.ThresholdCrossedNotification;

/**
 * SOL005 - NS Performance Management Interface
 *
 * <p>
 * SOL005 - NS Performance Management Interface IMPORTANT: Please note that this
 * file might be not aligned to the current version of the ETSI Group
 * Specification it refers to and has not been approved by the ETSI NFV ISG. In
 * case of discrepancies the published ETSI Group Specification takes
 * precedence. Please report bugs to
 * https://forge.etsi.org/bugzilla/buglist.cgi?component=Nfv-Openapis
 *
 */
@RequestMapping("/sol005/nspm/v1/notification/")
@RolesAllowed({ "ROLE_OSSBSS" })
public interface NsPmNotification261Sol005Api {

	/**
	 * Notify about PM related events
	 *
	 * The POST method delivers a notification regarding a performance management
	 * event from the server to the client. This method shall follow the provisions
	 * specified in the Tables 7.4.9.3.1-1 and 7.4.9.3.1-2 for URI query parameters,
	 *
	 */
	@PostMapping(value = "/available", consumes = { "application/json" }, produces = { "application/json" })
	void availableNotificationPost(@Valid PerformanceInformationAvailableNotification performanceInformationAvailableNotification, @RequestHeader("Accept") String accept, @RequestHeader("Content-Type") String contentType);

	@GetMapping(value = "/available", consumes = { "application/json" }, produces = { "application/json" })
	void availableCheck();

	/**
	 * Test the notification endpoint
	 *
	 * The GET method allows the server to test the notification endpoint that is
	 * provided by the client, e.g. during subscription. This method shall follow
	 * the provisions specified in the Tables 7.4.9.3.2-1 and 7.4.9.3.2-2 for URI
	 * query parameters, request and response data structures, and response codes.
	 *
	 */
	@GetMapping(value = "/threshold-crossed", produces = { "application/json" })
	void thresholdCrossedCheck(@RequestHeader("Accept") String accept);

	/**
	 * Notify about PM related events
	 *
	 * The POST method delivers a notification regarding a performance management
	 * event from the server to the client. This method shall follow the provisions
	 * specified in the Tables 7.4.9.3.1-1 and 7.4.9.3.1-2 for URI query parameters,
	 *
	 */
	@PostMapping(value = "/threshold-crossed", consumes = { "application/json" }, produces = { "application/json" })
	void thresholdCrossedNotificationPost(@Valid ThresholdCrossedNotification thresholdCrossedNotification, @RequestHeader("Accept") String accept, @RequestHeader("Content-Type") String contentType);
}
