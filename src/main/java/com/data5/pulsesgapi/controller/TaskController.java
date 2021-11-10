package com.data5.pulsesgapi.controller;

import com.data5.pulsesgapi.exception.TaskException;
import com.data5.pulsesgapi.model.Task;
import com.data5.pulsesgapi.model.TaskResponse;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Task", tags = {"Tasks"})
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
    @GetMapping("v1/tasks")
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
    @PostMapping("v1/createTask")
    ResponseEntity<Void>  createTask(@ApiParam("Auth") @RequestHeader("Authorization") String auth,
                           @ApiParam(value = "Task data", required = true) @RequestBody Task task) throws TaskException;

}
