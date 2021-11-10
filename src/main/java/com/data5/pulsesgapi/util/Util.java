package com.data5.pulsesgapi.util;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class Util {

    public static HttpHeaders getSuccessResponseHeaders() {

        HttpHeaders headers = new HttpHeaders();
        //headers.set();
        return headers;
    }
}
