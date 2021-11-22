package com.pulsesg.platform.core.task.helper;

import com.pulsesg.platform.core.task.model.Task;
import com.pulsesg.platform.core.task.util.Util;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CommonHelper {
    private static final Logger LOGGER =  LoggerFactory.getLogger(CommonHelper.class);

    /**
     *
     * @param putTask Task
     * @param getTask Task
     * @return Task
     */
    public Task updateCommonTaskFields(Task putTask, Task inputTask){
        putTask.setStatus(inputTask.getStatus());
        putTask.setUpdatedBy(inputTask.getUpdatedBy());
        putTask.setUpdatedDate(Util.getCurrentDataTimeInstant());
        return putTask;
    }
}
