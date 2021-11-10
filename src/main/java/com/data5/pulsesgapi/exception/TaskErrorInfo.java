package com.data5.pulsesgapi.exception;

import java.util.Optional;
import java.util.stream.Stream;

public enum TaskErrorInfo {

    OK(200, "0", "Success"),
    UNKNOWN_EXCEPTION(500, "1000", "Unknown exception occurred.");

    private TaskErrorInfo(int statusCode, String errorCode, String errorMessage){
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

    public static TaskErrorInfo fromErrorCode(String errorCode){
        TaskErrorInfo result = UNKNOWN_EXCEPTION;

        Optional<TaskErrorInfo> resultOpt = Stream.of(TaskErrorInfo.values()).filter(x->x.getErrorCode().equals(errorCode)).findFirst();
        if(resultOpt.isPresent()){
            result = resultOpt.get();
        }
        return result;
    }

    @Override
    public String toString() {
//        return "TaskErrorInfo{" +
//                "errorCode='" + errorCode + '\'' +
//                ", errorMessage='" + errorMessage + '\'' +
//                ", statusCode=" + statusCode +
//                '}';

        return String.valueOf(statusCode) + "-" + String.valueOf(errorCode) + "-" + String.valueOf(errorMessage);
    }
}
