package com.data5.pulsesgapi.controller;

import com.data5.pulsesgapi.helper.ResponseHelper;
import com.data5.pulsesgapi.model.Task;
import com.data5.pulsesgapi.model.TaskResponse;
import com.data5.pulsesgapi.service.TaskService;
import com.data5.pulsesgapi.util.Util;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class TaskControllerImpl implements TaskController {

    private TaskService taskService;
    private ResponseHelper responseHelper;

    /**
     * @param auth  AuthToken
     * @param orgId String
     * @return ResponseEntity<TaskResponse>
     * @throws Exception Exception
     */
    public ResponseEntity<TaskResponse> retrieveTasksListByOrgId(String auth, String orgId) throws Exception {
        TaskResponse resp;
        try {
            List<Task> taskList = taskService.retrieveTasksListByField(orgId);
            resp = responseHelper.getTaskResponse(taskList);
        } catch (Exception e) {
            System.err.println("retrieveTask error: " + e.getMessage());
            throw e;
        } finally {
            System.out.println("retrieveTask : ");
// future reference
        }
        return new ResponseEntity<>(resp, Util.getSuccessResponseHeaders(), HttpStatus.OK);
    }

    /**
     * @param auth AuthToken
     * @param task Task
     * @return void
     * @throws Exception Exception
     */
    public ResponseEntity<Void> createTask(String auth, Task task) throws Exception {
        try {
            taskService.createNewTask(task);
        } catch (Exception e) {
            System.err.println("createTask error: " + e.getMessage());
            throw e;
        } finally {
            System.out.println("createTask : ");
// future reference
        }
        return new ResponseEntity<>(Util.getSuccessResponseHeaders(), HttpStatus.OK);
    }

}
