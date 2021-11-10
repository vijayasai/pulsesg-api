package com.data5.pulsesgapi.exception;

import org.springframework.http.HttpStatus;

import java.util.Objects;

public class TaskErrorProperty {

    private String code;
    private int status;
    private String message;

    public TaskErrorProperty(TaskErrorInfo taskErrorInfo){
        this.code = taskErrorInfo.getErrorCode();
        this.status = taskErrorInfo.getStatusCode();
        this.message = taskErrorInfo.getErrorMessage();
    }

    public TaskErrorProperty(TaskErrorProperty taskErrorProperty){
        this.code = taskErrorProperty.getCode();
        this.status = taskErrorProperty.getStatus();
        this.message = taskErrorProperty.getMessage();
    }

    public TaskErrorProperty(String code, int status, String message){
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public TaskErrorProperty(){
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
        if(!(o instanceof TaskErrorProperty)) return false;
        TaskErrorProperty that = (TaskErrorProperty)o;
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
