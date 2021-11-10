package com.data5.pulsesgapi.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskExceptionUtil {

    public static TaskErrorPropertyMap getObjectFromJsonString(String json)  {
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, TaskErrorPropertyMap.class);
        } catch(Exception e){
            System.err.println("Exception while converting error json to map");
        }
        return null;
    }

    public static void throwAndLogTaskExceptions(Exception exception) throws TaskException{
        TaskException taskEx;
        if(exception instanceof  TaskException){
           taskEx = (TaskException) exception;
           System.err.println("Rethrow same exception"+taskEx.getMessage());
        } else {
            taskEx = new TaskException(TaskErrorInfo.UNKNOWN_EXCEPTION);
            System.err.println("Convert initial exception to unknown exception "+taskEx.getMessage());
            if(exception.getCause()!= null){
                System.err.println("Cause Exception"+exception.getCause());
            }
            taskEx.setBackendCause(exception);
            taskEx.setAdditionalInfo(exception.getMessage());
        }
        throw taskEx;
    }
}
