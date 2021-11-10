package com.data5.pulsesgapi.service;

import com.data5.pulsesgapi.model.Task;
import com.data5.pulsesgapi.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;

    public List<Task> retrieveTasksListByField(String field){
        return taskRepository.findAllByOrgIdLike("%"+field);
    }

    public void createNewTask(Task task){
        taskRepository.save(task);
    }
}
