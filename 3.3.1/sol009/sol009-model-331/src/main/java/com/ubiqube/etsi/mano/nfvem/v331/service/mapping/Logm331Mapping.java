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
package com.ubiqube.etsi.mano.nfvem.v331.service.mapping;

import java.net.URI;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.ubiqube.etsi.mano.dao.mano.sol009.logm.CompileLogRequest;
import com.ubiqube.etsi.mano.dao.mano.sol009.logm.CreateLoggingJobRequest;
import com.ubiqube.etsi.mano.dao.mano.sol009.logm.LogFileEncryption;
import com.ubiqube.etsi.mano.dao.mano.sol009.logm.LoggingJobCriteria;
import com.ubiqube.etsi.mano.dao.mano.sol009.logm.LoggingJobMessagesCriteria;
import com.ubiqube.etsi.mano.dao.mano.sol009.logm.LoggingJobSystemCriteria;
import com.ubiqube.etsi.mano.dao.mano.sol009.logm.MatchingPatterns;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanologm.Link;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanologm.LogReport;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanologm.LoggingJob;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanologm.LoggingJobConfigSecurityConfLogFileEncryption;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanologm.LoggingJobMessagesCriteriaMatchingPatterns;
import com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanologm.ManoManagedObjectReference;
import com.ubiqube.etsi.mano.service.mapping.StringToUriMapping;

import jakarta.validation.Valid;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface Logm331Mapping extends StringToUriMapping {
	@Mapping(target = "links", ignore = true)
	LogReport map(com.ubiqube.etsi.mano.dao.mano.sol009.logm.LogReport o);

	CompileLogRequest map(com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanologm.@Valid CompileLogRequest body);

	@Mapping(target = "id", ignore = true)
	com.ubiqube.etsi.mano.dao.mano.sol009.logm.ManoManagedObjectReference map(ManoManagedObjectReference o);

	@Mapping(target = "links", ignore = true)
	LoggingJob map(com.ubiqube.etsi.mano.dao.mano.sol009.logm.LoggingJob o);

	default Link toLink(final URI uri) {
		if (null == uri) {
			return null;
		}
		final Link l = new Link();
		l.setHref(uri.toString());
		return l;
	}

	CreateLoggingJobRequest map(com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanologm.CreateLoggingJobRequest body);

	@Mapping(target = "id", ignore = true)
	LogFileEncryption map(LoggingJobConfigSecurityConfLogFileEncryption o);

	@Mapping(target = "id", ignore = true)
	LoggingJobCriteria map(com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanologm.LoggingJobCriteria o);

	@Mapping(target = "id", ignore = true)
	LoggingJobMessagesCriteria map(com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanologm.LoggingJobMessagesCriteria o);

	@Mapping(target = "id", ignore = true)
	MatchingPatterns map(LoggingJobMessagesCriteriaMatchingPatterns o);

	@Mapping(target = "id", ignore = true)
	LoggingJobSystemCriteria map(com.ubiqube.etsi.mano.nfvem.v331.model.nfvmanologm.LoggingJobSystemCriteria o);
}
