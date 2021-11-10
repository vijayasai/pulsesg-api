package com.data5.pulsesgapi.helper;

import com.data5.pulsesgapi.model.Task;
import com.data5.pulsesgapi.model.TaskResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResponseHelper {

    public TaskResponse getTaskResponse(List<Task> taskList){
        TaskResponse resp = new TaskResponse();
        resp.setTaskList(taskList);
        return resp;
    }
}
