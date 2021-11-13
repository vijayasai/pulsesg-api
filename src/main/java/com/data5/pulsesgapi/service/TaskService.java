package com.data5.pulsesgapi.service;

import com.data5.pulsesgapi.model.Task;
import com.data5.pulsesgapi.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskService.class);
    private TaskRepository taskRepository;
//    @Autowired
//    private CouchbaseTemplate couchbaseTemplate;

//    public List<Task> retrieveTasksListByFieldUsingTemplate(String field) {
//        Predicate<Task> taskPredicate = p -> p.getOrgId().equalsIgnoreCase(field);
//        return couchbaseTemplate.findByQuery(Task.class).stream()
//                .filter(taskPredicate)
//                .collect(Collectors.toList());
//    }

    public List<Task> retrieveTasksListByOrgId(String orgId) {
        return taskRepository.findAllByOrgIdLike("%" + orgId);
    }

    public void createNewTask(Task task) {
        taskRepository.save(task);
    }
}
