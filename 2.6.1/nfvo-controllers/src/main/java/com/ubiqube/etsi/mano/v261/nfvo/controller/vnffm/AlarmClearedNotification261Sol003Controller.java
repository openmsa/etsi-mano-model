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
package com.ubiqube.etsi.mano.v261.nfvo.controller.vnffm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.vnffm.VnffmNotificationFrontController;
import com.ubiqube.etsi.mano.v261.model.vnfm.vrqan.AlarmClearedNotification;
import com.ubiqube.etsi.mano.v261.service.mapping.AlarmNotification261Mapping;

import jakarta.validation.Valid;

/**
 *
 * @author olivier
 *
 */
@RestController
public class AlarmClearedNotification261Sol003Controller implements AlarmClearedNotification261Sol003Api {
	private final VnffmNotificationFrontController fc;
	private final AlarmNotification261Mapping mapper;

	public AlarmClearedNotification261Sol003Controller(final VnffmNotificationFrontController fc, final AlarmNotification261Mapping mapper) {
		this.fc = fc;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<Void> alarmClearedNotificationCheck() {
		return fc.alarmClearedCheck();
	}

	@Override
	public ResponseEntity<Void> AlarmClearedNotificationPost(@Valid final AlarmClearedNotification body) {
		final com.ubiqube.etsi.mano.dao.mano.alarm.AlarmNotification req = mapper.map(body);
		return fc.alarmClearedNotification(req, "2.6.1");
	}

}
