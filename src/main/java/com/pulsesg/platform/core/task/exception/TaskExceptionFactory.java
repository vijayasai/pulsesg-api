package com.pulsesg.platform.core.task.exception;

import com.pulsesg.platform.core.task.util.Util;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * @author Vijayasai Kesanupalli
 */
@Component
@AllArgsConstructor
public class TaskExceptionFactory {
    private static TaskErrorPropertyMap stringTaskErrorPropertyMap;

    static {
        stringTaskErrorPropertyMap = null;
        try {
            InputStream inputStream = new ClassPathResource("error-code-list.json").getInputStream();
            String content = Util.readFromInputStream(inputStream);
            stringTaskErrorPropertyMap = TaskExceptionUtil.getObjectFromJsonString(content);
        } catch (Exception e) {
            System.err.println("error-code-list.json cannot be loaded!");
        }
    }

    public static TaskException getTaskException(){
        return new TaskException();
    }

    public static TaskException getTaskException(String errorCode){
        return new TaskException(stringTaskErrorPropertyMap.get(errorCode));
    }

    public static TaskErrorProperty getTaskErrorProperty(String errorCode){
        TaskErrorProperty taskErrorProperty = stringTaskErrorPropertyMap.get(errorCode);
        if(taskErrorProperty == null){
            taskErrorProperty = stringTaskErrorPropertyMap.get("1000");
        }
        return taskErrorProperty;
    }
}
