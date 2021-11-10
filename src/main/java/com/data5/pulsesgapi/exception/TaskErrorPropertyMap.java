package com.data5.pulsesgapi.exception;

import java.util.HashMap;

public class TaskErrorPropertyMap extends HashMap<String, TaskErrorProperty> {
    public  TaskErrorProperty get(String key){
        return new TaskErrorProperty(super.get(key));
    }
}
