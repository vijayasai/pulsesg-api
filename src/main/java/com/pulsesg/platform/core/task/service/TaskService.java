package com.pulsesg.platform.core.task.service;

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

    public List<Task> retrieveTasksByOrgId(String orgId) {
        return taskRepository.findAllByOrgIdLike("%" + orgId);
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    public void saveMultipleTasks(List<Task> tasks) {
        taskRepository.saveAll(tasks);
    }

}
