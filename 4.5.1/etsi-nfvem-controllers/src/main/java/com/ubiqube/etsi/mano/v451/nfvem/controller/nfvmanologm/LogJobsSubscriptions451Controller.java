package com.ubiqube.etsi.mano.v451.nfvem.controller.nfvmanologm;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ubiqube.etsi.mano.v451.nfvem.controller.nfvmanologm.LogJobsSubscriptions451Api;

import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Optional;


@RestController
public class LogJobsSubscriptions451Controller implements LogJobsSubscriptions451Api {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public LogJobsSubscriptions451Controller(ObjectMapper objectMapper, HttpServletRequest request) {
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
