package com.ubiqube.etsi.mano.vnfm.v451.controller.vnfpm;

public class NotFoundException extends ApiException {
    private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
