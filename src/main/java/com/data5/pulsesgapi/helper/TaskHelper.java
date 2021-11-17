
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

    private TaskService taskService;

    /**
     * @param task Task
     * @throws TaskException exception
     */
    public void createNewTask(Task task) throws TaskException {
        task.setCreatedDate(Util.getCurrentDataTimeInstant());
        if(task.getCycleId() == 0){
            task.setCycleId(Integer.parseInt(Util.getCurrentYYYYMMString()));
        }
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
     */
    public List<Task> retrieveTasksByOrgId(String orgId) throws TaskException {
        return taskService.retrieveTasksByOrgId(orgId);
    }


}
