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
package com.ubiqube.etsi.mano.v331.vnfm.service;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VnfmSwaggerDocumentationConfig331 {
	@SuppressWarnings("static-method")
	@Bean
	GroupedOpenApi customImplementationVnfm331() {
		return GroupedOpenApi.builder()
				.group("vnfm-etsi-mano-3.3.1")
				.packagesToScan("com.ubiqube.etsi.mano.v331.vnfm")
				.build();
	}

}
