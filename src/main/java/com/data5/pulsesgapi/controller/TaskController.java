package com.data5.pulsesgapi.controller;

import com.pulsesg.platform.core.task.exception.TaskException;
import com.pulsesg.platform.core.task.model.MultiTask;
import com.pulsesg.platform.core.task.model.Task;
import com.pulsesg.platform.core.task.model.TaskResponse;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Vijayasai Kesanupalli
 */
@Api(value = "Task", tags = {"Tasks"})
@RequestMapping("${main.business.uri}")
public interface TaskController {

    @ApiOperation(value = "getTasksList")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", required = true, dataType = "string", value = "descr",
                    paramType = "header"),
            @ApiImplicitParam(name = "orgId", required = true, dataType = "string", value = "orgId",
                    paramType = "query")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "-0: Success", response = TaskResponse.class)
    })
    @GetMapping("/search")
    ResponseEntity<TaskResponse> retrieveTasksListByOrgId(@ApiParam("Auth") @RequestHeader("Authorization") String auth,
                                                          @ApiParam("orgId") @RequestParam(name = "orgId") String orgId) throws TaskException;


    @ApiOperation(value="CreateTask")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name="Authorization", required = true, dataType = "string", value="descr",
                    paramType = "header")
    })
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "-0: Success")
    })
    @PostMapping("/createTask")
    ResponseEntity<Void>  createTask(@ApiParam("Auth") @RequestHeader("Authorization") String auth,
                           @ApiParam(value = "Task data", required = true) @RequestBody Task task) throws TaskException;

    @ApiOperation(value="CreateMultipleTasks")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name="Authorization", required = true, dataType = "string", value="descr",
                    paramType = "header")
    })
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "-0: Success")
    })
    @PostMapping("/createMultipleTasks")
    ResponseEntity<Void>  createMultipleTasks(@ApiParam("Auth") @RequestHeader("Authorization") String auth,
                                     @ApiParam(value = "Task data", required = true) @RequestBody MultiTask multiTask) throws TaskException;

}
