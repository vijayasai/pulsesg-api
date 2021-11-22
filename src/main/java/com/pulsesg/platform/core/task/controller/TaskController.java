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

    // Get Tasks By ORGID

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

    // CreateTask

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

    // CreateMultipleTasks

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



    // Assign Users

    @ApiOperation(value = "updateAssignUserTask")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", required = true, dataType = "string", value = "descr",
                    paramType = "header")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "-0: Success", response = Task.class)
    })
    @PutMapping("/assignUser/{_id}")
    ResponseEntity<Task> updateAssignUsersById(@ApiParam("Auth") @RequestHeader("Authorization") String auth,
                                                 @ApiParam("_id") @PathVariable(value = "_id") String id,
                                                 @ApiParam(name="Task", required = true) @RequestBody Task task) throws TaskException;



    // remove Users

    @ApiOperation(value = "updateRemoveUserTask")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", required = true, dataType = "string", value = "descr",
                    paramType = "header")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "-0: Success", response = Task.class)
    })
    @PutMapping("/removeUser/{_id}")
    ResponseEntity<Task> updateRemoveUsersById(@ApiParam("Auth") @RequestHeader("Authorization") String auth,
                                               @ApiParam("_id") @PathVariable(value = "_id") String id,
                                               @ApiParam(name="Task", required = true) @RequestBody Task task) throws TaskException;


    // Approve Tasks

    @ApiOperation(value = "updateApproveTasks")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", required = true, dataType = "string", value = "descr",
                    paramType = "header")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "-0: Success", response = Task.class)
    })
    @PutMapping("/approve/{_id}")
    ResponseEntity<Task> updateApproveStatusById(@ApiParam("Auth") @RequestHeader("Authorization") String auth,
                                               @ApiParam("_id") @PathVariable(value = "_id") String id,
                                               @ApiParam(name="Task", required = true) @RequestBody Task task) throws TaskException;


    // Reject Tasks

    @ApiOperation(value = "updateRejectTasks")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", required = true, dataType = "string", value = "descr",
                    paramType = "header")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "-0: Success", response = Task.class)
    })
    @PutMapping("/reject/{_id}")
    ResponseEntity<Task> updateRejectStatusById(@ApiParam("Auth") @RequestHeader("Authorization") String auth,
                                                    @ApiParam("_id") @PathVariable(value = "_id") String id,
                                                    @ApiParam(name="Task", required = true) @RequestBody Task task) throws TaskException;


    // Lock Tasks

    @ApiOperation(value = "updateLockTasks")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", required = true, dataType = "string", value = "descr",
                    paramType = "header")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "-0: Success", response = Task.class)
    })
    @PutMapping("/lock/{_id}")
    ResponseEntity<Task> updateLockStatusById(@ApiParam("Auth") @RequestHeader("Authorization") String auth,
                                               @ApiParam("_id") @PathVariable(value = "_id") String id,
                                               @ApiParam(name="Task", required = true) @RequestBody Task task) throws TaskException;


    // UnLock Tasks

    @ApiOperation(value = "updateUnlockTasks")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", required = true, dataType = "string", value = "descr",
                    paramType = "header")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "-0: Success", response = Task.class)
    })
    @PutMapping("/unlock/{_id}")
    ResponseEntity<Task> updateUnLockStatusById(@ApiParam("Auth") @RequestHeader("Authorization") String auth,
                                              @ApiParam("_id") @PathVariable(value = "_id") String id,
                                              @ApiParam(name="Task", required = true) @RequestBody Task task) throws TaskException;


    // Update Status

    @ApiOperation(value = "updateStatusTasks")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", required = true, dataType = "string", value = "descr",
                    paramType = "header")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "-0: Success", response = Task.class)
    })
    @PutMapping("/status/{_id}")
    ResponseEntity<Task> updateStatusById(@ApiParam("Auth") @RequestHeader("Authorization") String auth,
                                                @ApiParam("_id") @PathVariable(value = "_id") String id,
                                                @ApiParam(name="Task", required = true) @RequestBody Task task) throws TaskException;


    // Update ActiveStatus Task

    @ApiOperation(value = "updateActiveStatusTask")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", required = true, dataType = "string", value = "descr",
                    paramType = "header")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "-0: Success", response = Task.class)
    })
    @PutMapping("/activeStatus/{_id}")
    ResponseEntity<Task> updateActiveStatusById(@ApiParam("Auth") @RequestHeader("Authorization") String auth,
                                          @ApiParam("_id") @PathVariable(value = "_id") String id,
                                          @ApiParam(name="Task", required = true) @RequestBody Task task) throws TaskException;

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
    ResponseEntity<Task> retrieveDashboard(@ApiParam("Auth") @RequestHeader("Authorization") String auth) throws TaskException;


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
    ResponseEntity<Task> retrieveTaskInbox(@ApiParam("Auth") @RequestHeader("Authorization") String auth) throws TaskException;


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
    ResponseEntity<Task> retrieveAudit(@ApiParam("Auth") @RequestHeader("Authorization") String auth) throws TaskException;


}
