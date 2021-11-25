package com.pulsesg.platform.core.task.exception;

import com.pulsesg.platform.core.task.util.Util;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * @author Varalakshmi Sravanthi Kavi
 */
@Component
@AllArgsConstructor
public class SubMetricExceptionFactory {
    private static SubMetricErrorPropertyMap stringSubMetricErrorPropertyMap;

    static {
        stringSubMetricErrorPropertyMap = null;
        try {
            InputStream inputStream = new ClassPathResource("error-code-list.json").getInputStream();
            String content = Util.readFromInputStream(inputStream);
            stringSubMetricErrorPropertyMap = SubMetricExceptionUtil.getObjectFromJsonString(content);
        } catch (Exception e) {
            System.err.println("error-code-list.json cannot be loaded!");
        }
    }

    public static SubMetricException getTaskException(){
        return new SubMetricException();
    }

    public static SubMetricException getSubMetricException(String errorCode){
        return new SubMetricException(stringSubMetricErrorPropertyMap.get(errorCode));
    }

    public static SubMetricErrorProperty getSubMetricErrorProperty(String errorCode){
        SubMetricErrorProperty subMetricErrorProperty = stringSubMetricErrorPropertyMap.get(errorCode);
        if(subMetricErrorProperty == null){
            subMetricErrorProperty = stringSubMetricErrorPropertyMap.get("1000");
        }
        return subMetricErrorProperty;
    }
}
