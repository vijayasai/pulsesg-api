package com.pulsesg.platform.core.task.helper;

import com.pulsesg.platform.core.task.exception.TaskException;
import com.pulsesg.platform.core.task.model.MultiTask;
import com.pulsesg.platform.core.task.model.Task;
import com.pulsesg.platform.core.task.service.TaskService;
import com.pulsesg.platform.core.task.util.Util;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vijayasai Kesanupalli
 */

@Component
@AllArgsConstructor
public class TaskHelper {

    private static final Logger LOGGER =  LoggerFactory.getLogger(TaskHelper.class);
    private CommonHelper commonHelper;
    private TaskService taskService;

    /**
     * @param task Task
     * @throws TaskException exception
     *
     * below method to create task
     */
    public void createNewTask(Task task) throws TaskException {
        task.setCreatedDate(Util.getCurrentDataTimeInstant());
        task.setUpdatedDate(Util.getCurrentDataTimeInstant());
        task.setUpdatedBy("Vaijay");
        if(task.getCycleId() == 0){
            task.setCycleId(Integer.parseInt(Util.getCurrentYYYYMMString()));
        }
        taskService.saveTask(task);
    }

    /**
     *
     * @param multiTask
     * @throws TaskException
     *
     * below method to create multiple tasks
     */
    public void createMultipleNewTasks(MultiTask multiTask) throws TaskException {
        List<String> tempMetricIds = multiTask.getMetricIds();
        List<String> tempOrgIds = multiTask.getOrgIds();
        List<Task> tasks = new ArrayList<>();
        for (String orgId : tempOrgIds) {
            for (String metricId : tempMetricIds) {
                Task task = new Task();
                task.setMetricIds(Arrays.asList(metricId));
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
     * @param task Task
     * @return Task
     * @throws TaskException Exception
     *
     * below method to update Approve status of Task
     */
    public Task updateApproveOrRejectTaskById(String id, Task task) throws TaskException {
        Task taskById = taskService.retrieveTaskBydId(id);
        if(taskById != null){
            taskById.setApproval_comment(task.getApproval_comment());
            taskById.setApproval_status(task.getApproval_status());
            taskById.setApprovedBy(task.getApprovedBy());
            taskById.setApprovalAssignedRoles(task.getApprovalAssignedRoles());
            taskById.setApprovalAssignedUsers(task.getApprovalAssignedUsers());
            taskById = commonHelper.updateCommonTaskFields(taskById, task);
            taskService.saveTask(taskById);
        }
        return taskById;
    }

    /**
     *
     * @param id String
     * @param task Task
     * @return Task
     * @throws TaskException Exception
     *
     * below method to update Lock or unlock status of Task
     */
    public Task updateLockOrUnLockStatusById(String id, Task task) throws TaskException {
        Task taskById = taskService.retrieveTaskBydId(id);
        if(taskById != null){
            taskById.setLockedBy(task.getLockedBy());
            taskById.setLockedDate(task.getLockedDate());
            taskById = commonHelper.updateCommonTaskFields(taskById, task);
            taskService.saveTask(taskById);
        }
        return taskById;
    }

    /**
     *
     * @param id String
     * @param task Task
     * @return Task
     * @throws TaskException Exception
     *
     * below method to update Assign or remove users of Task
     */
    public Task updateAssignOrRemoveUserById(String id, Task task) throws TaskException {
        Task taskById = taskService.retrieveTaskBydId(id);
        if(taskById != null){
            taskById.setAssignedUsers(task.getAssignedUsers());
            taskById.setAssignedRoles(task.getAssignedRoles());
            taskById = commonHelper.updateCommonTaskFields(taskById, task);
            taskService.saveTask(taskById);
        }
        return taskById;
    }

    /**
     *
     * @param id String
     * @param task Task
     * @return Task
     * @throws TaskException Exception
     *
     * below method to update Status of Task
     */
    public Task updateStatusById(String id, Task task) throws TaskException {
        Task taskById = taskService.retrieveTaskBydId(id);
        if(taskById != null){
            taskById = commonHelper.updateCommonTaskFields(taskById, task);
            taskService.saveTask(taskById);
        }
        return taskById;
    }

    /**
     *
     * @param id String
     * @param task Task
     * @return Task
     * @throws TaskException Exception
     *
     * below method to update ActiveStatus of Task
     */
    public Task updateActiveStatusById(String id, Task task) throws TaskException {
        Task taskById = taskService.retrieveTaskBydId(id);
        if(taskById != null){
            taskById.setActive(task.isActive());
            taskById = commonHelper.updateCommonTaskFields(taskById, task);
            taskService.saveTask(taskById);
        }
        return taskById;
    }
}
