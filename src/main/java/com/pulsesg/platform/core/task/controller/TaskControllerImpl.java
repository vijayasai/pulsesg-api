package com.pulsesg.platform.core.task.controller;

import com.pulsesg.platform.core.task.exception.TaskException;
import com.pulsesg.platform.core.task.exception.TaskExceptionUtil;
import com.pulsesg.platform.core.task.helper.ResponseHelper;
import com.pulsesg.platform.core.task.helper.TaskHelper;
import com.pulsesg.platform.core.task.model.*;
import com.pulsesg.platform.core.task.util.Util;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Vijayasai Kesanupalli
 */
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

    /**
     * @param auth AuthToken
     * @param multiTask MultiTask
     * @return void
     * @throws TaskException Exception
     */
    public ResponseEntity<Void> createMultipleTasks(String auth, MultiTask multiTask) throws TaskException {
        LOGGER.info(" ** Start of createMultipleTasks ");
        try {
            taskHelper.createMultipleNewTasks(multiTask);
        } catch (Exception e) {
            LOGGER.error("createMultipleTasks error: {}", e.getMessage());
            TaskExceptionUtil.throwAndLogTaskExceptions(e);
        }
        return new ResponseEntity<>(Util.getSuccessResponseHeaders(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TaskDashboard> retrieveDashboard(String auth) throws TaskException {
        return null;
    }

    @Override
    public ResponseEntity<TaskInbox> retrieveTaskInbox(String auth) throws TaskException {
        return null;
    }

    @Override
    public ResponseEntity<TaskAudit> retrieveAudit(String auth) throws TaskException {
        return null;
    }

    @Override
    public ResponseEntity<TaskAssignUsers> retrieveAssignUsers(String auth) throws TaskException {
        return null;
    }

    @Override
    public ResponseEntity<TaskAssignmentUsers> retrieveAssignmentUsers(String auth) throws TaskException {
        return null;
    }

    @Override
    public ResponseEntity<Task> retrieveApproveTasks(String auth) throws TaskException {
        return null;
    }

    @Override
    public ResponseEntity<Task> retrieveRejectTasks(String auth) throws TaskException {
        return null;
    }

    @Override
    public ResponseEntity<Task> retrieveLockTasks(String auth) throws TaskException {
        return null;
    }

    @Override
    public ResponseEntity<Task> retrieveUnlockTasks(String auth) throws TaskException {
        return null;
    }

}