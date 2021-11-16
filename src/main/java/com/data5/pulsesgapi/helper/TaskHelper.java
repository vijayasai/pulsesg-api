package com.data5.pulsesgapi.helper;

import com.data5.pulsesgapi.exception.TaskException;
import com.data5.pulsesgapi.model.MultiTask;
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
        taskService.saveTask(task);
    }

    /**
     *
     * @param multiTask
     * @throws TaskException
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
                tasks.add(task);
            }
        }
        taskService.saveMultipleTasks(tasks);
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
