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
package com.ubiqube.etsi.mano.v361.vnfm.controller.vnffm;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.dao.mano.alarm.AckState;
import com.ubiqube.etsi.mano.dao.mano.alarm.PerceivedSeverityType;
import com.ubiqube.etsi.mano.v361.model.em.vnffm.Alarm;
import com.ubiqube.etsi.mano.v361.model.em.vnffm.AlarmLinks;
import com.ubiqube.etsi.mano.v361.model.em.vnffm.AlarmModifications;
import com.ubiqube.etsi.mano.v361.model.em.vnffm.PerceivedSeverityRequest;
import com.ubiqube.etsi.mano.v361.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.v361.service.mapping.Alarm361Mapping;
import com.ubiqube.etsi.mano.vnfm.fc.vnffm.AlarmFrontController;

import jakarta.validation.Valid;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@RestController
public class Alarms361Sol002Controller implements Alarms361Sol002Api {
	private final AlarmFrontController alarmFrontController;
	private final Alarm361Mapping mapper;

	public Alarms361Sol002Controller(final AlarmFrontController alarmFrontController, final Alarm361Mapping mapper) {
		this.alarmFrontController = alarmFrontController;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<Void> alarmsAlarmIdEscalatePost(final String alarmId, @Valid final PerceivedSeverityRequest perceivedSeverityRequest) {
		return alarmFrontController.escalate(alarmId, PerceivedSeverityType.valueOf(perceivedSeverityRequest.getProposedPerceivedSeverity().toString()));
	}

	@Override
	public ResponseEntity<Alarm> alarmsAlarmIdGet(final String alarmId) {
		return alarmFrontController.findById(alarmId, x -> mapper.map(x), Alarms361Sol002Controller::makeLinks);
	}

	@Override
	public ResponseEntity<AlarmModifications> alarmsAlarmIdPatch(final String alarmId, final AlarmModifications alarmModifications, final String ifMatch) {
		return alarmFrontController.patch(alarmId, AckState.valueOf(alarmModifications.getAckState().toString()), ifMatch, x -> mapper.mapAlarmModifications(x));
	}

	@Override
	public ResponseEntity<String> alarmsGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return alarmFrontController.search(requestParams, x -> mapper.map(x), Alarms361Sol002Controller::makeLinks, Alarm.class);
	}

	private static void makeLinks(final Alarm alarm) {
		final AlarmLinks links = new AlarmLinks();
		Link link = new Link();
		link.setHref(linkTo(methodOn(Alarms361Sol002Api.class).alarmsAlarmIdGet(alarm.getId())).withSelfRel().getHref());
		links.setSelf(link);

		link = new Link();
		link.setHref(linkTo(methodOn(Alarms361Sol002Api.class).alarmsAlarmIdGet(alarm.getId())).withSelfRel().getHref());
		links.setObjectInstance(link);

		alarm.setLinks(links);
	}

}
