package com.pulsesg.platform.core.task.exception;

import java.io.Serializable;

/**
 * @author Vijayasai Kesanupalli
 */
public class TaskException extends Exception implements Serializable {

    private TaskErrorProperty taskErrorProperty;
    private TaskErrorInfo taskErrorInfo;
    private Throwable backendCause;
    private String additionalInfo;
    private String backendHttpStatus;
    private String backendCode;
    private String backendMessage;

    public TaskException(TaskErrorProperty errorProperty, Throwable cause) {
        super(errorProperty.getCode() + "-" + errorProperty.getMessage() + "-" + cause);
        this.setTaskErrorProperty(taskErrorProperty);
        this.setBackendCause(cause);
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

    public String getBackendMessage() {
        return backendMessage;
    }

    public void setBackendMessage(String backendMessage) {
        this.backendMessage = backendMessage;
    }

    public Throwable getBackendCause() {
        return backendCause;
    }

    public void setBackendCause(Throwable backendCause) {
        this.backendCause = backendCause;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public TaskErrorInfo getTaskErrorInfo() {
        if (taskErrorInfo == null && taskErrorProperty == null) {
            setTaskErrorInfo(TaskErrorInfo.UNKNOWN_EXCEPTION);
        }
        return taskErrorInfo;
    }

    public boolean isSuccessWithZeroStatus() {
        boolean zeroStatus = false;
        if (taskErrorProperty != null) {
            zeroStatus = "0".equals(taskErrorProperty.getCode());
        } else if (taskErrorInfo != null) {
            zeroStatus = "0".equals(taskErrorInfo.getErrorCode());
        }
        return zeroStatus;
    }

    public boolean isDegradeMode() {
        boolean degradeModeStatus = false;
        if (taskErrorProperty != null) {
            degradeModeStatus = "1002".equals(taskErrorProperty.getCode());
        } else if (taskErrorInfo != null) {
            degradeModeStatus = "1002".equals(taskErrorInfo.getErrorCode());
        }
        return degradeModeStatus;
    }

    public boolean is2xxStatus() {
        boolean is2xx = false;
        if (taskErrorInfo != null && taskErrorProperty != null) {
            taskErrorProperty = new TaskErrorProperty(taskErrorInfo);
        }
        int status = taskErrorProperty.getStatus();
        if (status >= 200 && status <= 299) {
            is2xx = true;
        }
        return is2xx;
    }

    public TaskErrorProperty getTaskErrorProperty() {
        if (taskErrorInfo == null && taskErrorProperty == null) {
            taskErrorProperty = TaskExceptionFactory.getTaskErrorProperty("1000");
        } else if (taskErrorInfo != null) {
            taskErrorProperty = new TaskErrorProperty(taskErrorInfo);
        }
        setTaskErrorProperty(taskErrorProperty);
        return taskErrorProperty;
    }

    public boolean isErrorException() {
        return taskErrorProperty.getHttpStatus().isError();
    }

    public void setTaskErrorInfo(TaskErrorInfo taskErrorInfo) {
        this.taskErrorProperty = null;
        this.taskErrorInfo = taskErrorInfo;
    }

    public void setTaskErrorProperty(TaskErrorProperty taskErrorProperty) {
        this.taskErrorProperty = taskErrorProperty;
        this.taskErrorInfo = null;
    }

    public void setTaskException(TaskException taskException) {
        TaskErrorProperty taskErrorProperty = taskException.taskErrorProperty;
        if (taskErrorProperty == null && taskException.getTaskErrorInfo() != null) {
            taskErrorProperty = new TaskErrorProperty(taskException.getTaskErrorInfo());
        }
        this.setTaskErrorProperty(taskErrorProperty);
        this.setAdditionalInfo(taskException.getAdditionalInfo());
        this.setBackendCause(taskException.getBackendCause());
        this.setBackendCode(taskException.getBackendCode());
        this.setBackendHttpStatus(taskException.getBackendHttpStatus());
        this.setBackendMessage(taskException.getBackendMessage());
        this.setStackTrace(taskException.getStackTrace());
    }

    public TaskException(TaskErrorInfo taskErrorInfo) {
        super(taskErrorInfo.getErrorCode() + "-" + taskErrorInfo.getErrorMessage());
        this.setTaskErrorInfo(taskErrorInfo);
        taskErrorProperty = new TaskErrorProperty(taskErrorInfo);
    }

    public TaskException(TaskErrorProperty taskErrorProperty) {
        super(taskErrorProperty.getCode() + "-" + taskErrorProperty.getMessage());
        this.setTaskErrorProperty(taskErrorProperty);
    }

    public TaskException(TaskErrorInfo taskErrorInfo, String additionalInfo) {
        super(taskErrorInfo.getErrorCode() + "-" + taskErrorInfo.getErrorMessage() + "-" + additionalInfo);
        this.setTaskErrorInfo(taskErrorInfo);
        this.setAdditionalInfo(additionalInfo);
    }

    public TaskException(TaskErrorProperty taskErrorProperty, String additionalInfo) {
        super(taskErrorProperty.getCode() + "-" + taskErrorProperty.getMessage() + "-" + additionalInfo);
        this.setTaskErrorProperty(taskErrorProperty);
        this.setAdditionalInfo(additionalInfo);
    }

    public TaskException() {
        super(TaskErrorInfo.UNKNOWN_EXCEPTION.getErrorCode() + "-" + TaskErrorInfo.UNKNOWN_EXCEPTION.getErrorMessage());
    }


    public TaskException(TaskErrorInfo taskErrorInfo, String additionalInfo, Throwable ex) {
        super(taskErrorInfo.getErrorCode() + "-" + taskErrorInfo.getErrorMessage() + "-" + additionalInfo);
        this.setTaskErrorInfo(taskErrorInfo);
        this.setAdditionalInfo(additionalInfo);
        this.setBackendCause(ex);
    }

    public TaskException(TaskErrorProperty taskErrorProperty, String additionalInfo, Throwable ex) {
        super(taskErrorProperty.getCode() + "-" + taskErrorProperty.getMessage() + "-" + additionalInfo);
        this.setTaskErrorProperty(taskErrorProperty);
        this.setAdditionalInfo(additionalInfo);
        this.setBackendCause(ex);
    }
}
