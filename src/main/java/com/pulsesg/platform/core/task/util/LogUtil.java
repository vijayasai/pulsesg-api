package com.pulsesg.platform.core.task.util;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
public class LogUtil {

    public static void clearContext() {
        MDC.clear();
    }

    public static void setTraceId(String traceId) {
        MDC.put(Constants.LOG_TRACE_ID_KEY, traceId != null ? traceId : Constants.BLANK_STRING);
    }

    public static void getTraceId() {
        MDC.get(Constants.LOG_TRACE_ID_KEY);
    }

    public static void setUserId(String userId) {
        MDC.put(Constants.LOG_USER_ID_KEY, userId != null ? userId : Constants.BLANK_STRING);
    }

    public static void getUserId() {
        MDC.get(Constants.LOG_USER_ID_KEY);
    }
}
