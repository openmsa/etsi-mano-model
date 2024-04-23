package com.ubiqube.etsi.mano.v271.vnfm.controller.vrqan;

import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.linkTo;
import static com.ubiqube.etsi.mano.uri.ManoWebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import com.ubiqube.etsi.mano.controller.SubscriptionFrontController;
import com.ubiqube.etsi.mano.controller.subscription.ApiAndType;
import com.ubiqube.etsi.mano.dao.mano.version.ApiVersionType;
import com.ubiqube.etsi.mano.dao.subscription.SubscriptionType;
import com.ubiqube.etsi.mano.service.auth.model.ApiTypesEnum;
import com.ubiqube.etsi.mano.service.event.model.Subscription;
import com.ubiqube.etsi.mano.v271.model.em.vnflcm.Link;
import com.ubiqube.etsi.mano.v271.model.vnfm.vrqan.VrQuotaAvailSubscription;
import com.ubiqube.etsi.mano.v271.model.vnfm.vrqan.VrQuotaAvailSubscriptionLinks;
import com.ubiqube.etsi.mano.v271.model.vnfm.vrqan.VrQuotaAvailSubscriptionRequest;
import com.ubiqube.etsi.mano.v271.vnfm.service.SubscriptionLinkable271Vnfm;

import jakarta.validation.Valid;
import ma.glasnost.orika.MapperFacade;

@RestController
public class VrQanSubscriptions271Sol003Controller implements VrQanSubscriptions271Sol003Api, SubscriptionLinkable271Vnfm {
	private final SubscriptionFrontController subscriptionService;
	private final MapperFacade mapper;

	public VrQanSubscriptions271Sol003Controller(final SubscriptionFrontController subscriptionService, final MapperFacade mapper) {
		this.subscriptionService = subscriptionService;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<List<VrQuotaAvailSubscription>> subscriptionsGet(final MultiValueMap<String, String> requestParams, final String nextpageOpaqueMarker) {
		return subscriptionService.search(requestParams, x -> mapper.map(x, VrQuotaAvailSubscription.class), VrQanSubscriptions271Sol003Controller::makeLinks, ApiVersionType.SOL003_VRQAN);
	}

	@Override
	public ResponseEntity<VrQuotaAvailSubscription> subscriptionsPost(@Valid final VrQuotaAvailSubscriptionRequest body) {
		final Subscription req = mapper.map(body, Subscription.class);
		return subscriptionService.create(req, x -> mapper.map(x, VrQuotaAvailSubscription.class), VrQanSubscriptions271Sol003Api.class, VrQanSubscriptions271Sol003Controller::makeLinks, VrQanSubscriptions271Sol003Controller::makeSelf, ApiVersionType.SOL003_VRQAN);
	}

	@Override
	public ResponseEntity<Void> subscriptionsSubscriptionIdDelete(final String subscriptionId) {
		return subscriptionService.deleteById(subscriptionId, ApiVersionType.SOL003_VRQAN);
	}

	@Override
	public ResponseEntity<VrQuotaAvailSubscription> subscriptionsSubscriptionIdGet(final String subscriptionId) {
		return subscriptionService.findById(subscriptionId, x -> mapper.map(x, VrQuotaAvailSubscription.class), VrQanSubscriptions271Sol003Controller::makeLinks, ApiVersionType.SOL003_VRQAN);
	}

	private static String makeSelf(final VrQuotaAvailSubscription subscription) {
		return linkTo(methodOn(VrQanSubscriptions271Sol003Api.class).subscriptionsSubscriptionIdGet(subscription.getId())).withSelfRel().getHref();
	}

	private static void makeLinks(final VrQuotaAvailSubscription subscription) {
		final VrQuotaAvailSubscriptionLinks links = new VrQuotaAvailSubscriptionLinks();
		final Link link = new Link();
		link.setHref(linkTo(methodOn(VrQanSubscriptions271Sol003Api.class).subscriptionsSubscriptionIdGet(subscription.getId())).withSelfRel().getHref());
		links.setSelf(link);
		subscription.setLinks(links);
	}

	@Override
	public String makeSelfLink(final String id) {
		return linkTo(methodOn(VrQanSubscriptions271Sol003Api.class).subscriptionsSubscriptionIdGet(id)).withSelfRel().getHref();
	}

	@Override
	public ApiAndType getApiAndType() {
		return ApiAndType.of(ApiTypesEnum.SOL003, SubscriptionType.VRQAN);
	}
}
