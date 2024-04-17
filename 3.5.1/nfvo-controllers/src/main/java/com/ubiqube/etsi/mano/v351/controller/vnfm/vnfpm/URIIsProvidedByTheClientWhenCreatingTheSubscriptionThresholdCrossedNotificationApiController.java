package com.ubiqube.etsi.mano.vnfm.v451.controller.vnfpm;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
public class URIIsProvidedByTheClientWhenCreatingTheSubscriptionThresholdCrossedNotificationApiController implements URIIsProvidedByTheClientWhenCreatingTheSubscriptionThresholdCrossedNotificationApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public URIIsProvidedByTheClientWhenCreatingTheSubscriptionThresholdCrossedNotificationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.ofNullable(objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
