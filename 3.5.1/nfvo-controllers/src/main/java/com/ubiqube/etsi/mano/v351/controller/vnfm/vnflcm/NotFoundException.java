package com.ubiqube.etsi.mano.nfvo.v451.controller.vnflcm;

public class NotFoundException extends ApiException {
    private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
