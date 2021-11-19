package com.pulsesg.platform.core.task.exception;

import java.util.HashMap;

/**
 * @author Vijayasai Kesanupalli
 */
public class TaskErrorPropertyMap extends HashMap<String, TaskErrorProperty> {
    public  TaskErrorProperty get(String key){
        return new TaskErrorProperty(super.get(key));
    }
}
