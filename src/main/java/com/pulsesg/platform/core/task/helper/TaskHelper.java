package com.pulsesg.platform.core.task.helper;

import com.pulsesg.platform.core.task.exception.TaskException;
import com.pulsesg.platform.core.task.model.MultiTask;
import com.pulsesg.platform.core.task.model.Task;
import com.pulsesg.platform.core.task.model.input.*;
import com.pulsesg.platform.core.task.service.TaskService;
import com.pulsesg.platform.core.task.util.Util;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vijayasai Kesanupalli
 */

@Component
@AllArgsConstructor
public class TaskHelper {

    private static final Logger LOGGER =  LoggerFactory.getLogger(TaskHelper.class);
    private TaskService taskService;

    /**
     * @param task Task
     *
     * below method to create task
     */
    public void createNewTask(Task task) {
        task.setCreatedDate(Util.getCurrentDataTimeInstant());
        task.setUpdatedDate(Util.getCurrentDataTimeInstant());
        task.setUpdatedBy("Vijay");
        if(task.getCycleId() == 0){
            task.setCycleId(Integer.parseInt(Util.getCurrentYYYYMMString()));
        }
        taskService.saveTask(task);
    }

    /**
     *
     * @param multiTask MultiTask
     *
     * below method to create multiple tasks
     */
    public void createMultipleNewTasks(MultiTask multiTask) {
        List<String> tempMetricIds = multiTask.getMetricIds();
        List<String> tempOrgIds = multiTask.getOrgIds();
        List<Task> tasks = new ArrayList<>();
        for (String orgId : tempOrgIds) {
            for (String metricId : tempMetricIds) {
                Task task = new Task();
                task.setMetricIds(List.of(metricId));
                task.setOrgId(orgId);
                task.setTenantId(multiTask.getTenantId());
                task.setMetricType(multiTask.getMetricType());
                task.set_type("OpenTask");
                task.setCreatedBy("Vijay");
                task.setCreatedDate(Util.getCurrentDataTimeInstant());
                task.setCycleId(Integer.parseInt(Util.getCurrentYYYYMMString()));
                tasks.add(task);
            }
        }
        taskService.saveMultipleTasks(tasks);
    }

    /**
     * @param orgId String
     * @return List<Task>
     * @throws TaskException exception
     *
     * below method to retrieve tasksList by orgId
     */
    public List<Task> retrieveTasksByOrgId(String orgId) throws TaskException {
        return taskService.retrieveTasksByOrgId(orgId);
    }

    /**
     *
     * @param id String
     * @param approvalComment TaskSetApprovalComment
     * @return Task
     * @throws TaskException Exception
     *
     * below method to update Approve status of Task
     */
    public Task updateApproveOrRejectTaskById(String id,  TaskSetApprovalComment approvalComment) throws TaskException {
        return taskService.updateApproveTaskById(id, approvalComment.getApproval_comment(), approvalComment.getUpdatedBy());
    }

    /**
     *
     * @param id String
     * @param lockedBy TaskSetLockedBy
     * @return Task
     * @throws TaskException Exception
     *
     * below method to update Lock or unlock status of Task
     */
    public Task updateLockOrUnLockStatusById(String id, TaskSetLockedBy lockedBy) throws TaskException {
        return taskService.updateLockTaskById(id, lockedBy.getLockedBy());
    }

    /**
     *
     * @param id String
     * @param users TaskSetUsers
     * @return Task
     * @throws TaskException Exception
     *
     * below method to update Assign or remove users of Task
     */
    public Task updateAssignOrRemoveUserById(String id, TaskSetUsers users) throws TaskException {
        return taskService.updateUsersTaskById(id, users.getAssignedUsers(), users.getUpdatedBy());
    }

    /**
     *
     * @param id String
     * @param status TaskSetStatus
     * @return Task
     * @throws TaskException Exception
     *
     * below method to update Status of Task
     */
    public Task updateStatusById(String id, TaskSetStatus status) throws TaskException {
        return taskService.updateStatusTaskById(id, status.getStatus().name(), status.getUpdatedBy());
    }

    /**
     *
     * @param id String
     * @param isActive TaskSetIsActive
     * @return Task
     * @throws TaskException Exception
     *
     * below method to update ActiveStatus of Task
     */
    public Task updateIsActiveById(String id, TaskSetIsActive isActive) throws TaskException {
        return taskService.updateIsActiveTaskById(id, isActive.isActive(), isActive.getUpdatedBy());
    }
}
