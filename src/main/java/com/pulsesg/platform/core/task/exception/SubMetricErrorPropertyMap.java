package com.pulsesg.platform.core.task.exception;

import java.util.HashMap;

/**
 * @author Varalakshmi Sravanthi Kavi
 */
public class SubMetricErrorPropertyMap extends HashMap<String, SubMetricErrorProperty> {
    public  SubMetricErrorProperty get(String key){
        return new SubMetricErrorProperty(super.get(key));
    }
}
