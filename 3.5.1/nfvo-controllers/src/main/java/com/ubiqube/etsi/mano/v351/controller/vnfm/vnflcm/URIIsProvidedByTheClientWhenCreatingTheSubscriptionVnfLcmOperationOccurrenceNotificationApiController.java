package com.ubiqube.etsi.mano.nfvo.v451.controller.vnflcm;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
public class URIIsProvidedByTheClientWhenCreatingTheSubscriptionVnfLcmOperationOccurrenceNotificationApiController implements URIIsProvidedByTheClientWhenCreatingTheSubscriptionVnfLcmOperationOccurrenceNotificationApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public URIIsProvidedByTheClientWhenCreatingTheSubscriptionVnfLcmOperationOccurrenceNotificationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
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
