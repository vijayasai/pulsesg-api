package com.data5.pulsesgapi.helper;

import com.data5.pulsesgapi.exception.TaskException;
import com.data5.pulsesgapi.model.Task;
import com.data5.pulsesgapi.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class TaskHelper {

    private TaskService taskService;

    /**
     * @param task Task
     * @throws TaskException exception
     */
    public void createNewTask(Task task) throws TaskException {
        List<String> tempOrgIdList = task.getOrgIds();
        List<String> tempMetricIdList = task.getMetricIds();
        List<Task> tasks = new ArrayList<>();
        for (String orgId : tempOrgIdList) {
            for (String metricId : tempMetricIdList) {
                task.setMetricIds(Arrays.asList(metricId));
                task.setOrgIds(Arrays.asList(orgId));
                tasks.add(task);
            }
        }
        if (tasks.size() > 1) {
            taskService.saveMultipleTasks(tasks);
        } else {
            taskService.saveTask(task);
        }
    }

    /**
     * @param orgId String
     * @return List<Task>
     * @throws TaskException exception
     */
    public List<Task> retrieveTasksByOrgId(String orgId) throws TaskException {
        return taskService.retrieveTasksByOrgId(orgId);
    }
}
