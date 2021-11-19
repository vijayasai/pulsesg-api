package com.pulsesg.platform.core.task.helper;

import com.pulsesg.platform.core.task.model.Task;
import com.pulsesg.platform.core.task.model.TaskResponse;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Vijayasai Kesanupalli
 */

@Component
@AllArgsConstructor
public class ResponseHelper {
    private static final Logger LOGGER =  LoggerFactory.getLogger(ResponseHelper.class);

    public TaskResponse getTaskResponse(List<Task> taskList){
        TaskResponse resp = new TaskResponse();
        resp.setTaskList(taskList);
        return resp;
    }
}
