package com.pulsesg.platform.core.task.exception;

import org.springframework.http.HttpStatus;

import java.util.Objects;

/**
 * @author Varalakshmi Sravanthi Kavi
 */
public class SubMetricErrorProperty {

    private String code;
    private int status;
    private String message;

    public SubMetricErrorProperty(SubMetricErrorInfo subMetricErrorInfo){
        this.code = subMetricErrorInfo.getErrorCode();
        this.status = subMetricErrorInfo.getStatusCode();
        this.message = subMetricErrorInfo.getErrorMessage();
    }

    public SubMetricErrorProperty(SubMetricErrorProperty subMetricErrorProperty){
        this.code = subMetricErrorProperty.getCode();
        this.status = subMetricErrorProperty.getStatus();
        this.message = subMetricErrorProperty.getMessage();
    }

    public SubMetricErrorProperty(String code, int status, String message){
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public SubMetricErrorProperty(){
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus(){
        return  HttpStatus.resolve(status);
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof SubMetricErrorProperty)) return false;
        SubMetricErrorProperty that = (SubMetricErrorProperty)o;
        return getStatus() == that.getStatus() && Objects.equals(getCode(), that.getCode()) &&
                Objects.equals(getMessage().trim(), that.getMessage().trim());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getStatus(), getMessage());
    }

    @Override
    public String toString() {
        return "TaskErrorProperty{" +
                "code='" + code + '\'' +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }




}
