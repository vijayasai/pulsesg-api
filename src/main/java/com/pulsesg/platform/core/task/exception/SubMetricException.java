package com.pulsesg.platform.core.task.exception;

import java.io.Serializable;

/**
 * @author Varalakshmi Sravanthi Kavi
 */
public class SubMetricException extends Exception implements Serializable {

    private SubMetricErrorProperty subMetricErrorProperty;
    private SubMetricErrorInfo subMetricErrorInfo;
    private Throwable backendCause;
    private String additionalInfo;
    private String backendHttpStatus;
    private String backendCode;
    private String backendMessage;

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

    public SubMetricErrorInfo getSubMetricErrorInfo() {
        if (subMetricErrorInfo == null && subMetricErrorProperty == null) {
            setSubMetricErrorInfo(SubMetricErrorInfo.UNKNOWN_EXCEPTION);
        }
        return subMetricErrorInfo;
    }

    public boolean isSuccessWithZeroStatus() {
        boolean zeroStatus = false;
        if (subMetricErrorProperty != null) {
            zeroStatus = "0".equals(subMetricErrorProperty.getCode());
        } else if (subMetricErrorInfo != null) {
            zeroStatus = "0".equals(subMetricErrorInfo.getErrorCode());
        }
        return zeroStatus;
    }

    public boolean isDegradeMode() {
        boolean degradeModeStatus = false;
        if (subMetricErrorProperty != null) {
            degradeModeStatus = "1002".equals(subMetricErrorProperty.getCode());
        } else if (subMetricErrorInfo != null) {
            degradeModeStatus = "1002".equals(subMetricErrorInfo.getErrorCode());
        }
        return degradeModeStatus;
    }

    public boolean is2xxStatus() {
        boolean is2xx = false;
        if (subMetricErrorInfo != null && subMetricErrorProperty != null) {
            subMetricErrorProperty = new SubMetricErrorProperty(subMetricErrorInfo);
        }
        int status = subMetricErrorProperty.getStatus();
        if (status >= 200 && status <= 299) {
            is2xx = true;
        }
        return is2xx;
    }

    public SubMetricErrorProperty getSubMetricErrorProperty() {
        if (subMetricErrorInfo == null && subMetricErrorProperty == null) {
            subMetricErrorProperty = SubMetricExceptionFactory.getSubMetricErrorProperty("1000");
        } else if (subMetricErrorInfo != null) {
            subMetricErrorProperty = new SubMetricErrorProperty(subMetricErrorInfo);
        }
        setSubMetricErrorProperty(subMetricErrorProperty);
        return subMetricErrorProperty;
    }

    public boolean isErrorException() {
        return subMetricErrorProperty.getHttpStatus().isError();
    }

    public void setSubMetricErrorInfo(SubMetricErrorInfo subMetricErrorInfo) {
        this.subMetricErrorProperty = null;
        this.subMetricErrorInfo = subMetricErrorInfo;
    }

    public void setSubMetricErrorProperty(SubMetricErrorProperty subMetricErrorProperty) {
        this.subMetricErrorProperty = subMetricErrorProperty;
        this.subMetricErrorInfo = null;
    }

    public void setTaskException(SubMetricException subMetricException) {
        SubMetricErrorProperty subMetricErrorProperty = subMetricException.subMetricErrorProperty;
        if (subMetricErrorProperty == null && subMetricException.getSubMetricErrorInfo() != null) {
            subMetricErrorProperty = new SubMetricErrorProperty(subMetricException.getSubMetricErrorProperty());
        }
        this.setSubMetricErrorProperty(subMetricErrorProperty);
        this.setAdditionalInfo(subMetricException.getAdditionalInfo());
        this.setBackendCause(subMetricException.getBackendCause());
        this.setBackendCode(subMetricException.getBackendCode());
        this.setBackendHttpStatus(subMetricException.getBackendHttpStatus());
        this.setBackendMessage(subMetricException.getBackendMessage());
        this.setStackTrace(subMetricException.getStackTrace());
    }

    public SubMetricException(SubMetricErrorInfo subMetricErrorInfo) {
        super(subMetricErrorInfo.getErrorCode() + "-" + subMetricErrorInfo.getErrorMessage());
        this.setSubMetricErrorInfo(subMetricErrorInfo);
        subMetricErrorProperty = new SubMetricErrorProperty(subMetricErrorInfo);
    }

    public SubMetricException(SubMetricErrorProperty subMetricErrorProperty) {
        super(subMetricErrorProperty.getCode() + "-" + subMetricErrorProperty.getMessage());
        this.setSubMetricErrorProperty(subMetricErrorProperty);
    }

    public SubMetricException(SubMetricErrorInfo subMetricErrorInfo, String additionalInfo) {
        super(subMetricErrorInfo.getErrorCode() + "-" + subMetricErrorInfo.getErrorMessage() + "-" + additionalInfo);
        this.setSubMetricErrorInfo(subMetricErrorInfo);
        this.setAdditionalInfo(additionalInfo);
    }

    public SubMetricException(SubMetricErrorProperty subMetricErrorProperty, String additionalInfo) {
        super(subMetricErrorProperty.getCode() + "-" + subMetricErrorProperty.getMessage() + "-" + additionalInfo);
        this.setSubMetricErrorProperty(subMetricErrorProperty);
        this.setAdditionalInfo(additionalInfo);
    }

    public SubMetricException() {
        super(TaskErrorInfo.UNKNOWN_EXCEPTION.getErrorCode() + "-" + TaskErrorInfo.UNKNOWN_EXCEPTION.getErrorMessage());
    }


    public SubMetricException(SubMetricErrorInfo subMetricErrorInfo, String additionalInfo, Throwable ex) {
        super(subMetricErrorInfo.getErrorCode() + "-" + subMetricErrorInfo.getErrorMessage() + "-" + additionalInfo);
        this.setSubMetricErrorInfo(subMetricErrorInfo);
        this.setAdditionalInfo(additionalInfo);
        this.setBackendCause(ex);
    }

    public SubMetricException(SubMetricErrorProperty subMetricErrorProperty, String additionalInfo, Throwable ex) {
        super(subMetricErrorProperty.getCode() + "-" + subMetricErrorProperty.getMessage() + "-" + additionalInfo);
        this.setSubMetricErrorProperty(subMetricErrorProperty);
        this.setAdditionalInfo(additionalInfo);
        this.setBackendCause(ex);
    }
}
