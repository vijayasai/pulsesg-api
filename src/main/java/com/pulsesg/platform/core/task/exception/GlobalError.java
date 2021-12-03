package com.pulsesg.platform.core.task.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GlobalError {

    private String errorCode;
    private String errorMessage;

    private String additionalDetails;
    private int statusCode;

    public String getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAdditionalDetails(String additionalDetails) {
        this.additionalDetails = additionalDetails;
    }

    public GlobalError(TaskErrorInfo ngpErrorInfo){
        this.errorCode = ngpErrorInfo.getErrorCode();
        this.errorMessage =  ngpErrorInfo.getErrorMessage();
        this.statusCode = ngpErrorInfo.getStatusCode();
        additionalDetails = null;
    }

    public GlobalError(TaskErrorProperty ngpErrorProperty){
        this.errorCode = ngpErrorProperty.getCode();
        this.errorMessage =  ngpErrorProperty.getMessage();
        this.statusCode = ngpErrorProperty.getStatus();
        additionalDetails = null;
    }

    public GlobalError(TaskErrorProperty ngpErrorProperty, String additionalDetails){
        this.errorCode = ngpErrorProperty.getCode();
        this.errorMessage =  ngpErrorProperty.getMessage();
        this.statusCode = ngpErrorProperty.getStatus();
        this.additionalDetails = additionalDetails;
    }

    public GlobalError(TaskErrorInfo ngpErrorInfo, String additionalDetails){
        this.errorCode = ngpErrorInfo.getErrorCode();
        this.errorMessage =  ngpErrorInfo.getErrorMessage();
        this.statusCode = ngpErrorInfo.getStatusCode();
        this.additionalDetails = additionalDetails;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }
}