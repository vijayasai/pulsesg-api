package com.pulsesg.platform.core.task.exception;

import com.netflix.hystrix.exception.HystrixRuntimeException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TaskException.class)
    public ResponseEntity<GlobalError> TaskExceptionHandler(HttpServletRequest req, TaskException TaskException) {
        ResponseEntity<GlobalError> responseEntity = null;
        // return the representation of the error
        TaskErrorProperty GlobalErrorProperty = TaskException.getTaskErrorProperty();
        String maskedAdditionalDetails = TaskException.getAdditionalInfo();
//        if(maskedAdditionalDetails!=null){
//            if(maskingErrorMap!=null && !maskingErrorMap.isEmpty())
//                maskedAdditionalDetails = CommonUtil.getCustomMaskValue(maskedAdditionalDetails, maskingErrorMap);
//        }
        responseEntity = new ResponseEntity<GlobalError>(new GlobalError(GlobalErrorProperty, maskedAdditionalDetails), getHeader(GlobalErrorProperty), GlobalErrorProperty.getHttpStatus());
        return responseEntity;
    }

    @ExceptionHandler(HystrixRuntimeException.class)
    public ResponseEntity<GlobalError> hystrixRuntimeExceptionHandler(HttpServletRequest req, Exception e) {
        // return the generic error if all other exception not matched
        TaskErrorInfo unknownException = TaskErrorInfo.SERVICE_NOT_AVAILABLE_EXCEPTION;
        return new ResponseEntity<GlobalError>(new GlobalError(unknownException), unknownException.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GlobalError> exceptionHandler(HttpServletRequest req, Exception e) {
        // return the generic error if all other exception not matched
        TaskErrorInfo unknownException = TaskErrorInfo.UNKNOWN_EXCEPTION;
        return new ResponseEntity<GlobalError>(new GlobalError(unknownException), unknownException.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(
            MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        TaskErrorInfo unknownException = TaskErrorInfo.UNKNOWN_EXCEPTION;
        return new ResponseEntity<Object>(unknownException, unknownException.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        TaskErrorInfo unknownException = TaskErrorInfo.INVALID_REQUEST_PARAMETER;
        return new ResponseEntity<Object>(unknownException, unknownException.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        List<String> errors = new ArrayList<String>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        TaskErrorInfo unknownException = TaskErrorInfo.INVALID_REQUEST_PARAMETER;
        return new ResponseEntity<Object>(unknownException, getHeader(unknownException), unknownException.getHttpStatus());
    }

    private static HttpHeaders getHeader(TaskErrorProperty errorProperty){
        HttpHeaders headers = new HttpHeaders();
        if(errorProperty != null ){
            //headers.set()
        }
        return headers;

    }

    private static HttpHeaders getHeader(TaskErrorInfo errorInfo){
        HttpHeaders headers = new HttpHeaders();
        if(errorInfo != null ){
            //headers.set()
        }
        return headers;

    }
}