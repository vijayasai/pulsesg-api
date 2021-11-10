package com.data5.pulsesgapi.util;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
public class Util {

    public static HttpHeaders getSuccessResponseHeaders() {

        HttpHeaders headers = new HttpHeaders();
        //headers.set();
        return headers;
    }

    public static String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultString = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))){
            String line;
            while((line = br.readLine())!= null){
                resultString.append(line).append("\n");
            }
        }
        return resultString.toString();
    }

}
