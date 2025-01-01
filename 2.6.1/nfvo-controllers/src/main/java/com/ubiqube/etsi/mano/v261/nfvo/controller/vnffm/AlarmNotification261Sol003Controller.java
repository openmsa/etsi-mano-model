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
package com.ubiqube.etsi.mano.v261.nfvo.controller.vnffm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.vnffm.VnffmNotificationFrontController;
import com.ubiqube.etsi.mano.v261.model.vnfm.vnffm.AlarmNotification;
import com.ubiqube.etsi.mano.v261.service.mapping.Alarm261Mapping;

import jakarta.validation.Valid;

/**
 *
 * @author olivier
 *
 */
@RestController
public class AlarmNotification261Sol003Controller implements AlarmNotification261Sol003Api {
	private final VnffmNotificationFrontController fc;
	private final Alarm261Mapping mapper;

	public AlarmNotification261Sol003Controller(final VnffmNotificationFrontController fc, final Alarm261Mapping mapper) {
		this.fc = fc;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<Void> alarmCheck() {
		return fc.alarmCheck();
	}

	@Override
	public ResponseEntity<Void> alarmNotificationPost(@Valid final AlarmNotification body) {
		final com.ubiqube.etsi.mano.dao.mano.alarm.AlarmNotification req = mapper.map(body);
		return fc.alarmNotification(req, "2.6.1");
	}

}
