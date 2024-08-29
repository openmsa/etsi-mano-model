package com.ubiqube.etsi.mano.v331.vnfm.controller.vnfm.vnf;

import org.springframework.context.annotation.Conditional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.SingleControllerCondition;
import com.ubiqube.etsi.mano.v331.model.nfvo.vnf.VnfPackageChangeNotification;
import com.ubiqube.etsi.mano.v331.model.nfvo.vnf.VnfPackageOnboardingNotification;
import com.ubiqube.etsi.mano.v331.service.mapping.pkg.VnfPackageOnboardingNotification331Mapping;
import com.ubiqube.etsi.mano.vnfm.fc.vnf.VnfNotificationFrontController;

import jakarta.validation.Valid;

@RestController
@Conditional(SingleControllerCondition.class)
public class VnfPkgNotification331Sol003Controller implements VnfPkgNotification331Sol003Api {
	private final VnfNotificationFrontController fc;
	private final VnfPackageOnboardingNotification331Mapping mapper;

	public VnfPkgNotification331Sol003Controller(final VnfNotificationFrontController fc, final VnfPackageOnboardingNotification331Mapping mapper) {
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
		return fc.onNotification(req, "3.3.1");
	}

	@Override
	public ResponseEntity<Void> changeCheck() {
		return fc.check();
	}

	@Override
	public ResponseEntity<Void> changeAction(@Valid final VnfPackageChangeNotification body) {
		final com.ubiqube.etsi.mano.dao.mano.VnfPackageChangeNotification req = mapper.map(body);
		return fc.onChange(req, "3.3.1");
	}

}
