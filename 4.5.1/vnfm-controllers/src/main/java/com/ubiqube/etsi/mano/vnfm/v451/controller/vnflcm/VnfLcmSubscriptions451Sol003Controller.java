package com.ubiqube.etsi.mano.vnfm.v451.controller.vnflcm;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.subscription.ApiAndType;
import com.ubiqube.etsi.mano.dao.subscription.SubscriptionType;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.LccnSubscription;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.LccnSubscriptionLinks;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.LccnSubscriptionRequest;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.LifecycleChangeNotificationsFilter;
import com.ubiqube.etsi.mano.em.v451.model.vnflcm.Link;
import com.ubiqube.etsi.mano.service.auth.model.ApiTypesEnum;
import com.ubiqube.etsi.mano.service.event.model.Subscription;
import com.ubiqube.etsi.mano.service.mapping.subscription.LccnSubscription451Mapping;
import com.ubiqube.etsi.mano.service.mapping.subscription.LccnSubscriptionRequest451Mapping;
import com.ubiqube.etsi.mano.vnfm.fc.vnflcm.VnfLcmSubscriptionFrontController;
import com.ubiqube.etsi.mano.vnfm.v451.service.SubscriptionLinkable451Vnfm;

import jakarta.validation.Valid;

@RestController
public class VnfLcmSubscriptions451Sol003Controller implements VnfLcmSubscriptions451Sol003Api, SubscriptionLinkable451Vnfm {
	private final VnfLcmSubscriptionFrontController frontController;
	private final LccnSubscriptionRequest451Mapping requestMapper;
	private final LccnSubscription451Mapping lccnSubscriptionMapping;

	public VnfLcmSubscriptions451Sol003Controller(final VnfLcmSubscriptionFrontController frontController, final LccnSubscription451Mapping lccnSubscriptionMapping, final LccnSubscriptionRequest451Mapping requestMapper) {
		this.frontController = frontController;
		this.requestMapper = requestMapper;
		this.lccnSubscriptionMapping = lccnSubscriptionMapping;
	}

	@Override
	public ResponseEntity<List<LccnSubscription>> subscriptionsGet(final MultiValueMap<String, String> requestParams, @Valid final String nextpageOpaqueMarker) {
		return frontController.search(requestParams, nextpageOpaqueMarker, x -> lccnSubscriptionMapping.map(x, LccnSubscription.class), VnfLcmSubscriptions451Sol003Controller::makeLinks);
	}

	@Override
	public ResponseEntity<LccnSubscription> subscriptionsPost(@Valid final LccnSubscriptionRequest body) {
		final Subscription req = requestMapper.map(body);
		return frontController.create(req, x -> lccnSubscriptionMapping.map(x, LifecycleChangeNotificationsFilter.class), VnfLcmSubscriptions451Sol003Api.class, VnfLcmSubscriptions451Sol003Controller::makeLinks, VnfLcmSubscriptions451Sol003Controller::getSelfLink);
	}

	@Override
	public ResponseEntity<Void> subscriptionsSubscriptionIdDelete(final String subscriptionId) {
		return frontController.deleteById(subscriptionId);
	}

	@Override
	public ResponseEntity<LccnSubscription> subscriptionsSubscriptionIdGet(final String subscriptionId) {
		return frontController.findById(subscriptionId, x -> lccnSubscriptionMapping.map(x, LccnSubscription.class), VnfLcmSubscriptions451Sol003Controller::makeLinks);
	}

	private static String getSelfLink(final LccnSubscription subscription) {
		return linkTo(methodOn(VnfLcmSubscriptions451Sol003Api.class).subscriptionsSubscriptionIdGet(subscription.getId())).withSelfRel().getHref();
	}

	private static void makeLinks(final LccnSubscription subs) {
		final LccnSubscriptionLinks links = new LccnSubscriptionLinks();
		final Link self = new Link();
		self.setHref(linkTo(methodOn(VnfLcmSubscriptions451Sol003Api.class).subscriptionsSubscriptionIdGet(subs.getId())).withSelfRel().getHref());
		links.setSelf(self);
		subs.setLinks(links);
	}

	@Override
	public String makeSelfLink(final String id) {
		return linkTo(methodOn(VnfLcmSubscriptions451Sol003Api.class).subscriptionsSubscriptionIdGet(id)).withSelfRel().getHref();
	}

	@Override
	public ApiAndType getApiAndType() {
		return ApiAndType.of(ApiTypesEnum.SOL003, SubscriptionType.VNFLCM);
	}

}
