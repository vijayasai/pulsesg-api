package com.pulsesg.platform.core.task.service;

import com.pulsesg.platform.core.task.exception.TaskException;
import com.pulsesg.platform.core.task.model.Task;
import com.pulsesg.platform.core.task.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Vijayasai Kesanupalli
 */
@Service
@AllArgsConstructor
public class TaskService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskService.class);
    private TaskRepository taskRepository;
    @Autowired
    CouchbaseTemplate couchbaseTemplate;

    /**
     * @param orgId String
     * @return List<Task>
     */
    public List<Task> retrieveTasksByOrgId(String orgId) throws TaskException {
        return taskRepository.findAllByOrgIdLike("%" + orgId);
    }

    /**
     * @param task Task
     */
    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    /**
     * @param tasks List<Task>
     */
    public void saveMultipleTasks(List<Task> tasks) {
        taskRepository.saveAll(tasks);
    }

    /**
     *
     * @param id String
     * @param approvalComment String
     * @param updatedBy String
     * @return Task
     * @throws TaskException Exception
     */
    public Task updateApproveTaskById(String id, String approvalComment, String updatedBy) throws TaskException {
        return taskRepository.updateTaskSetApprovalCommentForId(id, approvalComment, updatedBy);
    }

    /**
     *
     * @param id String
     * @param users List
     * @param updatedBy String
     * @return Task
     * @throws TaskException  Exception
     */
    public Task updateUsersTaskById(String id, List<String> users, String updatedBy) throws TaskException {
        return taskRepository.updateTaskSetUsersForId(id, users, updatedBy);
    }

    /**
     *,
     * @param id String
     * @param status String
     * @param updatedBy String
     * @return Task
     * @throws TaskException Exception
     */
    public Task updateStatusTaskById(String id, String status, String updatedBy) throws TaskException {
        return taskRepository.updateTaskSetStatusForId(id, status, updatedBy);
    }

    /**
     *
     * @param id String
     * @param activeStatus String
     * @return Task
     * @param updatedBy String
     * @throws TaskException Exception
     */
    public Task updateIsActiveTaskById(String id, boolean activeStatus, String updatedBy) throws TaskException {
        return taskRepository.updateTaskSetIsActiveForId(id, activeStatus, updatedBy);
    }

    /**
     *
     * @param id String
     * @param lockedBy String
     * @return Task
     * @throws TaskException Exception
     */
    public Task updateLockTaskById(String id, String lockedBy) throws TaskException {
        return taskRepository.updateTaskSetLockForId(id, lockedBy);
    }
}
