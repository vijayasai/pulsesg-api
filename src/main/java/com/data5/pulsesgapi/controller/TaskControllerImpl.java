package com.data5.pulsesgapi.controller;

import com.data5.pulsesgapi.exception.TaskException;
import com.data5.pulsesgapi.exception.TaskExceptionUtil;
import com.data5.pulsesgapi.helper.ResponseHelper;
import com.data5.pulsesgapi.helper.TaskHelper;
import com.data5.pulsesgapi.model.Task;
import com.data5.pulsesgapi.model.TaskResponse;
import com.data5.pulsesgapi.service.TaskService;
import com.data5.pulsesgapi.util.Util;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TaskControllerImpl implements TaskController {

    private static final Logger LOGGER =  LoggerFactory.getLogger(TaskControllerImpl.class);
    private TaskHelper taskHelper;
    private ResponseHelper responseHelper;

    /**
     * @param auth  AuthToken
     * @param orgId String
     * @return ResponseEntity<TaskResponse>
     * @throws TaskException Exception
     */
    //@HystrixCommand(commandKey = "taskService-addNewTask", threadPoolKey = "taskService-addNewTask", fallbackMethod = "handleRetrieveTasksListByOrgId")
    public ResponseEntity<TaskResponse> retrieveTasksListByOrgId(String auth, String orgId) throws TaskException {
        LOGGER.info(" ** Start of retrieveTasksListByOrgId orgId {}", orgId);

        TaskResponse resp = new TaskResponse();
        try {
            List<Task> taskList = taskHelper.retrieveTasksByOrgId(orgId);
            resp = responseHelper.getTaskResponse(taskList);
        } catch (Exception e) {
            LOGGER.error("retrieveTask error: {}", e.getMessage());
            TaskExceptionUtil.throwAndLogTaskExceptions(e);
        }
        return new ResponseEntity<>(resp, Util.getSuccessResponseHeaders(), HttpStatus.OK);
    }

    /**
     * @param auth AuthToken
     * @param task Task
     * @return void
     * @throws TaskException Exception
     */
    public ResponseEntity<Void> createTask(String auth, Task task) throws TaskException {
        LOGGER.info(" ** Start of createTask ");
        try {
            taskHelper.createNewTask(task);
        } catch (Exception e) {
            LOGGER.error("createTask error: {}", e.getMessage());
            TaskExceptionUtil.throwAndLogTaskExceptions(e);
        }
        return new ResponseEntity<>(Util.getSuccessResponseHeaders(), HttpStatus.OK);
    }

}
