package com.data5.pulsesgapi.service;

import com.data5.pulsesgapi.model.Task;
import com.data5.pulsesgapi.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskService.class);
    private TaskRepository taskRepository;
    @Autowired
    CouchbaseTemplate couchbaseTemplate;

    public List<Task> retrieveTasksByOrgId(String orgId) {
        return taskRepository.findAllByOrgIdsLike("%" + orgId);
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    public void saveMultipleTasks(List<Task> tasks) {
        taskRepository.saveAll(tasks);
    }

}
