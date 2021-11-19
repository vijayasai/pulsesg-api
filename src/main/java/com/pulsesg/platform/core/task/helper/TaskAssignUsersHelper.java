package com.pulsesg.platform.core.task.helper;

import com.pulsesg.platform.core.task.service.TaskService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Vijayasai Kesanupalli
 */

@Component
@AllArgsConstructor
public class TaskAssignUsersHelper {

    private static final Logger LOGGER =  LoggerFactory.getLogger(TaskAssignUsersHelper.class);

    private TaskService taskService;


}
