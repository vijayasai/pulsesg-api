package com.data5.pulsesgapi.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TaskExceptionUtil extends ExceptionUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskExceptionUtil.class);

    public static TaskErrorPropertyMap getObjectFromJsonString(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, TaskErrorPropertyMap.class);
        } catch (Exception e) {
            LOGGER.error("Exception while converting error json to map");
        }
        return null;
    }

    public static TaskErrorInfo generateHystrixRuntimeException(HystrixRuntimeException ex) {
        if (ex.getFallbackException() != null && ex.getFallbackException().getCause() != null && ex.getFallbackException().getCause() instanceof TaskException) {
            TaskException exception = (TaskException) ex.getFallbackException().getCause();
            return exception.getTaskErrorInfo();
        } else {
            LOGGER.error("Unable to transform Hystrix Runtime Exception to the corresponding TaskException {}", generateSummaryMessage(ex));
            return TaskErrorInfo.UNKNOWN_EXCEPTION;
        }
    }

    public static String generateSummaryMessage(Throwable e) {
        try {
            Throwable rootCause = getRootCause(e);
            String rc;
            if (rootCause != null) {
                StringBuilder rcBuf = new StringBuilder(128);
                rcBuf.append(getBriefDescription(e)).append("; root cause: ").append(rootCause.getClass().getName());
                rc = rcBuf.toString();
            } else {
                rc = getBriefDescription(e);
            }
            return rc;
        } catch (Exception var4) {
            return "" + e;
        }
    }

    public static String getBriefDescription(Throwable e){
        return e.toString();
    }

    public static TaskException hystrixBackendErrorMapping(TaskErrorInfo errorInfo, Throwable e, String module) {
        LOGGER.error("Exception occurred: {} with caller: {} Error: {}", errorInfo.getErrorMessage(), module, generateSummaryMessage(e));
        if (e instanceof TaskException) {
            return (TaskException) e;
        } else if (e.getCause() != null && e.getCause() instanceof IOException) {
            LOGGER.error("System not available exception occurred due to invalid HystrixRuntime/HystrixTimeout host not available {}", generateSummaryMessage(e));
            return new TaskException(errorInfo);
        } else if (e != null && (e instanceof HystrixRuntimeException || e instanceof HystrixTimeoutException)) {
            LOGGER.error("System not available exception occurred due to invalid host/backend host not available {}", generateSummaryMessage(e));
            return new TaskException(errorInfo);
        } else if (e instanceof RuntimeException && e.getMessage().equals("Hystrix circuit short-circuited and id OPEN")) {
            LOGGER.error("System not available exception occurred due to Circuit Breaker force open {}", generateSummaryMessage(e));
            return new TaskException(TaskErrorInfo.DEGRADED_MODE);
        } else {
            LOGGER.error("Error: {}", getStackTrace(e));
            return new TaskException(TaskErrorInfo.UNKNOWN_EXCEPTION);
        }
    }

    public static void throwAndLogTaskExceptions(Exception exception) throws TaskException {
        TaskException taskEx;
        if (exception instanceof TaskException) {
            taskEx = (TaskException) exception;
            LOGGER.error("Rethrow same exception {}", taskEx.getMessage());
        } else if (exception instanceof HystrixRuntimeException) {
            LOGGER.error("HystrixRuntimeException ");
            HystrixRuntimeException hex = (HystrixRuntimeException) exception;
            TaskErrorInfo taskErrorInfo = generateHystrixRuntimeException(hex);
            throw new TaskException(taskErrorInfo);
        } else {
            taskEx = new TaskException(TaskErrorInfo.UNKNOWN_EXCEPTION);
            LOGGER.error("Convert initial exception to unknown exception {}", taskEx.getMessage());
            if (exception.getCause() != null) {
                LOGGER.error("Cause Exception {}", exception.getCause());
            }
            taskEx.setBackendCause(exception);
            taskEx.setAdditionalInfo(exception.getMessage());
            throw taskEx;
        }

    }
}
