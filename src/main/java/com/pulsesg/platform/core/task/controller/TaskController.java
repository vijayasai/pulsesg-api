package com.pulsesg.platform.core.task.controller;

import com.pulsesg.platform.core.task.exception.TaskException;
import com.pulsesg.platform.core.task.model.*;
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


    // Dashboard

    @ApiOperation(value = "getDashboard")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", required = true, dataType = "string", value = "descr",
                    paramType = "header")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "-0: Success", response = TaskResponse.class)
    })
    @GetMapping("/dashboard")
    ResponseEntity<TaskDashboard> retrieveDashboard(@ApiParam("Auth") @RequestHeader("Authorization") String auth) throws TaskException;


    // Inbox

    @ApiOperation(value = "getTaskInbox")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", required = true, dataType = "string", value = "descr",
                    paramType = "header")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "-0: Success", response = TaskResponse.class)
    })
    @GetMapping("/inbox")
    ResponseEntity<TaskInbox> retrieveTaskInbox(@ApiParam("Auth") @RequestHeader("Authorization") String auth) throws TaskException;


    // Audit

    @ApiOperation(value = "getAudit")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", required = true, dataType = "string", value = "descr",
                    paramType = "header")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "-0: Success", response = TaskResponse.class)
    })
    @GetMapping("/audit")
    ResponseEntity<TaskAudit> retrieveAudit(@ApiParam("Auth") @RequestHeader("Authorization") String auth) throws TaskException;

    // Assign Users

    @ApiOperation(value = "getAssignUsers")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", required = true, dataType = "string", value = "descr",
                    paramType = "header")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "-0: Success", response = TaskResponse.class)
    })
    @GetMapping("/assignUsers")
    ResponseEntity<TaskAssignUsers> retrieveAssignUsers(@ApiParam("Auth") @RequestHeader("Authorization") String auth) throws TaskException;



    // Assignment Users

    @ApiOperation(value = "getAssignmentUsers")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", required = true, dataType = "string", value = "descr",
                    paramType = "header")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "-0: Success", response = TaskResponse.class)
    })
    @GetMapping("/assignmentUsers")
    ResponseEntity<TaskAssignmentUsers> retrieveAssignmentUsers(@ApiParam("Auth") @RequestHeader("Authorization") String auth) throws TaskException;


    // Approve Tasks

    @ApiOperation(value = "getApproveTasks")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", required = true, dataType = "string", value = "descr",
                    paramType = "header")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "-0: Success", response = TaskResponse.class)
    })
    @GetMapping("/approve")
    ResponseEntity<Task> retrieveApproveTasks(@ApiParam("Auth") @RequestHeader("Authorization") String auth) throws TaskException;


    // Reject Tasks

    @ApiOperation(value = "getRejectTasks")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", required = true, dataType = "string", value = "descr",
                    paramType = "header")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "-0: Success", response = TaskResponse.class)
    })
    @GetMapping("/reject")
    ResponseEntity<Task> retrieveRejectTasks(@ApiParam("Auth") @RequestHeader("Authorization") String auth) throws TaskException;


    // Lock Tasks

    @ApiOperation(value = "getLockTasks")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", required = true, dataType = "string", value = "descr",
                    paramType = "header")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "-0: Success", response = TaskResponse.class)
    })
    @GetMapping("/lock")
    ResponseEntity<Task> retrieveLockTasks(@ApiParam("Auth") @RequestHeader("Authorization") String auth) throws TaskException;


    // UnLock Tasks

    @ApiOperation(value = "getUnLockTasks")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", required = true, dataType = "string", value = "descr",
                    paramType = "header")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "-0: Success", response = TaskResponse.class)
    })
    @GetMapping("/unlock")
    ResponseEntity<Task> retrieveUnlockTasks(@ApiParam("Auth") @RequestHeader("Authorization") String auth) throws TaskException;


}
