package com.pulsesg.platform.core.task.util;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Component
public class Util {

    private static final DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC);
    private static final DateTimeFormatter yearMonthFormat = DateTimeFormatter.ofPattern("YYYYMM").withZone(ZoneOffset.UTC);

    /**
     *
     * @return
     */
    public static HttpHeaders getSuccessResponseHeaders() {

        HttpHeaders headers = new HttpHeaders();
        //headers.set();
        return headers;
    }

    /**
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultString = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultString.append(line).append("\n");
            }
        }
        return resultString.toString();
    }

    /**
     *
     * @return
     */
    public static Instant getCurrentDataTimeInstant() {
        return Instant.from(dateTimeFormat.parse(getCurrentDateString(dateTimeFormat)));
    }

    /**
     *
     * @return
     */
    public static String getCurrentYYYYMMString() {
        return getCurrentDateString(yearMonthFormat);
    }

    /**
     *
     * @param dateFormat
     * @return
     */
    private static String getCurrentDateString(DateTimeFormatter dateFormat) {
        Instant now = Instant.now();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
        return dateFormat.format(localDateTime);
    }


}
