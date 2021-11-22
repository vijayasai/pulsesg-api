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
import java.util.Optional;


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
    public void saveTask(Task task) throws TaskException {
        taskRepository.save(task);
    }

    /**
     * @param tasks List<Task>
     */
    public void saveMultipleTasks(List<Task> tasks) throws TaskException {
        taskRepository.saveAll(tasks);
    }

    /**
     * @param id String
     * @return
     */
    public Task retrieveTaskBydId(String id) throws TaskException {
        Optional<Task> task = taskRepository.findById(id);
        return task.isPresent() ? task.get() : null;
    }


}
