package com.ubiqube.etsi.mano.v281.vnfm.controller.vnf.vnffm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.v281.model.nfvo.vnf.VnfPackageChangeNotification;
import com.ubiqube.etsi.mano.v281.model.nfvo.vnf.VnfPackageOnboardingNotification;
import com.ubiqube.etsi.mano.v281.service.mapping.pkg.VnfPackageOnboardingNotification281Mapping;
import com.ubiqube.etsi.mano.vnfm.fc.vnf.VnfNotificationFrontController;

import jakarta.validation.Valid;

@RestController
public class VnfPkgNotification281Sol003Controller implements VnfPkgNotification281Sol003Api {
	private final VnfNotificationFrontController fc;
	private final VnfPackageOnboardingNotification281Mapping mapper;

	public VnfPkgNotification281Sol003Controller(final VnfNotificationFrontController fc, final VnfPackageOnboardingNotification281Mapping mapper) {
		this.fc = fc;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<Void> onboardingCheck() {
		return fc.check();
	}

	@Override
	public ResponseEntity<Void> onboardingAction(final VnfPackageOnboardingNotification body) {
		final com.ubiqube.etsi.mano.dao.mano.VnfPackageOnboardingNotification req = mapper.map(body);
		return fc.onNotification(req, "2.8.1");
	}

	@Override
	public ResponseEntity<Void> changeCheck() {
		return fc.check();
	}

	@Override
	public ResponseEntity<Void> changeAction(@Valid final VnfPackageChangeNotification body) {
		final com.ubiqube.etsi.mano.dao.mano.VnfPackageChangeNotification req = mapper.map(body);
		return fc.onChange(req, "2.8.1");
	}

}
