package com.pulsesg.platform.core.task.controller;

import com.pulsesg.platform.core.task.exception.TaskException;
import com.pulsesg.platform.core.task.exception.TaskExceptionUtil;
import com.pulsesg.platform.core.task.helper.ResponseHelper;
import com.pulsesg.platform.core.task.helper.TaskHelper;
import com.pulsesg.platform.core.task.model.MultiTask;
import com.pulsesg.platform.core.task.model.Task;
import com.pulsesg.platform.core.task.model.TaskResponse;
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

    /**
     *
     * @param auth AuthToken
     * @param id String
     * @param task Task
     * @return ResponseEntity<Task> Task
     * @throws TaskException Exception
     *
     * below method is to update approve status of Task
     */
    @Override
    public ResponseEntity<Task> updateApproveStatusById(String auth, String id, Task task) throws TaskException {
        LOGGER.info(" ** Start of updateApproveStatusById ");
        Task resp = new Task();
        try {
            resp = taskHelper.updateApproveOrRejectTaskById(id, task);
        } catch (Exception e) {
            LOGGER.error("updateApproveStatusById error: {}", e.getMessage());
            TaskExceptionUtil.throwAndLogTaskExceptions(e);
        }
        return new ResponseEntity<>(resp, Util.getSuccessResponseHeaders(), HttpStatus.OK);
    }

    /**
     *
     * @param auth AuthToken
     * @param id String
     * @param task Task
     * @return ResponseEntity<Task> Task
     * @throws TaskException Exception
     *
     * below method is to update reject status of Task
     */
    @Override
    public ResponseEntity<Task> updateRejectStatusById(String auth, String id, Task task) throws TaskException {
        LOGGER.info(" ** Start of updateRejectStatusById ");
        Task resp = new Task();
        try {
            resp = taskHelper.updateApproveOrRejectTaskById(id, task);
        } catch (Exception e) {
            LOGGER.error("updateRejectStatusById error: {}", e.getMessage());
            TaskExceptionUtil.throwAndLogTaskExceptions(e);
        }
        return new ResponseEntity<>(resp, Util.getSuccessResponseHeaders(), HttpStatus.OK);
    }

    /**
     *
     * @param auth AuthToken
     * @param id String
     * @param task Task
     * @return ResponseEntity<Task> Task
     * @throws TaskException Exception
     *
     * below method is to update Lock status of Task
     *
     */
    @Override
    public ResponseEntity<Task> updateLockStatusById(String auth, String id, Task task) throws TaskException {
        LOGGER.info(" ** Start of updateRejectStatusById ");
        Task resp = new Task();
        try {
            resp = taskHelper.updateLockOrUnLockStatusById(id, task);
        } catch (Exception e) {
            LOGGER.error("updateRejectStatusById error: {}", e.getMessage());
            TaskExceptionUtil.throwAndLogTaskExceptions(e);
        }
        return new ResponseEntity<>(resp, Util.getSuccessResponseHeaders(), HttpStatus.OK);
    }

    /**
     *
     * @param auth AuthToken
     * @param id String
     * @param task Task
     * @return ResponseEntity<Task> Task
     * @throws TaskException Exception
     *
     * below method is to update UnLock status of Task
     *
     */
    @Override
    public ResponseEntity<Task> updateUnLockStatusById(String auth, String id, Task task) throws TaskException {
        LOGGER.info(" ** Start of updateUnLockStatusById ");
        Task resp = new Task();
        try {
            resp = taskHelper.updateLockOrUnLockStatusById(id, task);
        } catch (Exception e) {
            LOGGER.error("updateUnLockStatusById error: {}", e.getMessage());
            TaskExceptionUtil.throwAndLogTaskExceptions(e);
        }
        return new ResponseEntity<>(resp, Util.getSuccessResponseHeaders(), HttpStatus.OK);
    }

    /**
     *
     * @param auth AuthToken
     * @param id String
     * @param task Task
     * @return ResponseEntity<Task> Task
     * @throws TaskException Exception
     *
     * below method is to update status of Task
     */
    @Override
    public ResponseEntity<Task> updateStatusById(String auth, String id, Task task) throws TaskException {
        LOGGER.info(" ** Start of updateStatusById ");
        Task resp = new Task();
        try {
            resp = taskHelper.updateStatusById(id, task);
        } catch (Exception e) {
            LOGGER.error("updateStatusById error: {}", e.getMessage());
            TaskExceptionUtil.throwAndLogTaskExceptions(e);
        }
        return new ResponseEntity<>(resp, Util.getSuccessResponseHeaders(), HttpStatus.OK);
    }

    /**
     *
     * @param auth AuthToken
     * @param id String
     * @param task Task
     * @return ResponseEntity<Task> Task
     * @throws TaskException Exception
     *
     * below method is to update Active status of Task
     */
    @Override
    public ResponseEntity<Task> updateActiveStatusById(String auth, String id, Task task) throws TaskException {
        LOGGER.info(" ** Start of updateActiveStatusById ");
        Task resp = new Task();
        try {
            resp = taskHelper.updateActiveStatusById(id, task);
        } catch (Exception e) {
            LOGGER.error("updateActiveStatusById error: {}", e.getMessage());
            TaskExceptionUtil.throwAndLogTaskExceptions(e);
        }
        return new ResponseEntity<>(resp, Util.getSuccessResponseHeaders(), HttpStatus.OK);
    }

    /**
     *
     * @param auth AuthToken
     * @param id String
     * @param task Task
     * @return ResponseEntity<Task> Task
     * @throws TaskException Exception
     *
     * below method is to update Assign users of Task
     */
    @Override
    public ResponseEntity<Task> updateAssignUsersById(String auth, String id, Task task) throws TaskException {
        LOGGER.info(" ** Start of updateAssignUsersById ");
        Task resp = new Task();
        try {
            resp = taskHelper.updateAssignOrRemoveUserById(id, task);
        } catch (Exception e) {
            LOGGER.error("updateAssignUsersById error: {}", e.getMessage());
            TaskExceptionUtil.throwAndLogTaskExceptions(e);
        }
        return new ResponseEntity<>(resp, Util.getSuccessResponseHeaders(), HttpStatus.OK);
    }

    /**
     *
     * @param auth AuthToken
     * @param id String
     * @param task Task
     * @return ResponseEntity<Task> Task
     * @throws TaskException Exception
     *
     * below method is to update Remove users of Task
     */
    @Override
    public ResponseEntity<Task> updateRemoveUsersById(String auth, String id, Task task) throws TaskException {
        LOGGER.info(" ** Start of updateRemoveUsersById ");
        Task resp = new Task();
        try {
            resp = taskHelper.updateAssignOrRemoveUserById(id, task);
        } catch (Exception e) {
            LOGGER.error("updateRemoveUsersById error: {}", e.getMessage());
            TaskExceptionUtil.throwAndLogTaskExceptions(e);
        }
        return new ResponseEntity<>(resp, Util.getSuccessResponseHeaders(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Task> retrieveDashboard(String auth) throws TaskException {
        return null;
    }

    @Override
    public ResponseEntity<Task> retrieveTaskInbox(String auth) throws TaskException {
        return null;
    }

    @Override
    public ResponseEntity<Task> retrieveAudit(String auth) throws TaskException {
        return null;
    }



}
