package com.pulsesg.platform.core.task.exception;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Varalakshmi Sravanthi Kavi
 */

public enum SubMetricErrorInfo {

    OK(200, "0", "Success"),
    UNKNOWN_EXCEPTION(500, "1000", "Unknown exception occurred."),
    DEGRADED_MODE(503, "1002", "In Degrade Mode");

    private SubMetricErrorInfo(int statusCode, String errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
    }

    private String errorCode;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getBackendHttpStatus() {
        return backendHttpStatus;
    }

    public void setBackendHttpStatus(String backendHttpStatus) {
        this.backendHttpStatus = backendHttpStatus;
    }

    public String getBackendCode() {
        return backendCode;
    }

    public void setBackendCode(String backendCode) {
        this.backendCode = backendCode;
    }

    public String getBackendMsg() {
        return backendMsg;
    }

    public void setBackendMsg(String backendMsg) {
        this.backendMsg = backendMsg;
    }

    private String errorMessage;
    private int statusCode;
    private String backendHttpStatus;
    private String backendCode;
    private String backendMsg;

    public static SubMetricErrorInfo fromErrorCode(String errorCode){
        SubMetricErrorInfo result = UNKNOWN_EXCEPTION;

        Optional<SubMetricErrorInfo> resultOpt = Stream.of(SubMetricErrorInfo.values()).filter(x->x.getErrorCode().equals(errorCode)).findFirst();
        if(resultOpt.isPresent()){
            result = resultOpt.get();
        }
        return result;
    }

    @Override
    public String toString() {
//        return "SubMetricErrorInfo{" +
//                "errorCode='" + errorCode + '\'' +
//                ", errorMessage='" + errorMessage + '\'' +
//                ", statusCode=" + statusCode +
//                '}';

        return String.valueOf(statusCode) + "-" + String.valueOf(errorCode) + "-" + String.valueOf(errorMessage);
    }
}
