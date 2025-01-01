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
package com.ubiqube.etsi.mano.v331.nfvo.controller.nsfm;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v331.model.em.vnffm.Alarm;
import com.ubiqube.etsi.mano.v331.model.em.vnffm.AlarmModifications;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
public class Alarms331Sol005Controller implements Alarms331Sol005Api {

	@Override
	public ResponseEntity<Alarm> alarmsAlarmIdGet(final String alarmId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<AlarmModifications> alarmsAlarmIdPatch(final String alarmId, @Valid final AlarmModifications body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<Alarm>> alarmsGet(@Valid final String filter, @Valid final String nextpageOpaqueMarker) {
		// TODO Auto-generated method stub
		return null;
	}
}
