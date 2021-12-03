package com.pulsesg.platform.core.task.controller;

import com.pulsesg.platform.core.task.exception.TaskException;
import com.pulsesg.platform.core.task.model.SubmittedMetrics;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Vijayasai Kesanupalli
 */
@Api(value = "SubmittedMetrics", tags = {"SubmittedMetrics"})
@RequestMapping("${main.business.uri}")
public interface SubmittedMetricsController {


    @ApiOperation(value = "listTaskSubmittedMetricsByCycleIdOrgId")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", required = true, dataType = "string", value = "descr",
                    paramType = "header"),
            @ApiImplicitParam(name = "orgId", required = true, dataType = "string", value = "orgId",
                    paramType = "query"),
            @ApiImplicitParam(name = "cycleId", required = true, dataType = "int", value = "cycleId",
                    paramType = "query")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "-0: Success", response = SubmittedMetrics[].class)
    })
    @GetMapping("/submittedMetricsByCycleIdOrgId")
    ResponseEntity<List<SubmittedMetrics>> listTaskSubmittedMetricsByCycleIdOrgId(@ApiParam("Auth") @RequestHeader("Authorization") String auth,
                                                                                  @ApiParam("cycleId") @RequestParam(name = "cycleId") int cycleId,
                                                                                  @ApiParam("orgId") @RequestParam(name = "orgId") String orgId) throws TaskException;

////
    @ApiOperation(value = "aggregateTasksByOrdId")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", required = true, dataType = "string", value = "descr",
                    paramType = "header"),
            @ApiImplicitParam(name = "orgId", required = true, dataType = "string", value = "orgId",
                    paramType = "query")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "-0: Success", response = SubmittedMetrics.class)
    })
    @GetMapping("/aggregateTasksByOrdId")
    ResponseEntity<SubmittedMetrics> aggregateTasksByOrdId(@ApiParam("Auth") @RequestHeader("Authorization") String auth,
                                                                                  @ApiParam("orgId") @RequestParam(name = "orgId") String orgId) throws TaskException;

    ///

    @ApiOperation(value = "listTaskSubmittedMetricsByCycleId")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", required = true, dataType = "string", value = "descr",
                    paramType = "header"),
            @ApiImplicitParam(name = "cycleId", required = true, dataType = "int", value = "cycleId",
                    paramType = "query")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "-0: Success", response = SubmittedMetrics[].class)
    })
    @GetMapping("/listTaskSubmittedMetricsByCycleId")
    ResponseEntity<List<SubmittedMetrics>> listTaskSubmittedMetricsByCycleId(@ApiParam("Auth") @RequestHeader("Authorization") String auth,
                                                                                  @ApiParam("cycleId") @RequestParam(name = "cycleId") int cycleId) throws TaskException;


    ////
    @ApiOperation(value = "listTaskSubmittedMetricsByOrgId")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", required = true, dataType = "string", value = "descr",
                    paramType = "header"),
            @ApiImplicitParam(name = "orgId", required = true, dataType = "string", value = "orgId",
                    paramType = "query")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "-0: Success", response = SubmittedMetrics[].class)
    })
    @GetMapping("/listTaskSubmittedMetricsByOrgId")
    ResponseEntity<List<SubmittedMetrics>> listTaskSubmittedMetricsByOrgId(@ApiParam("Auth") @RequestHeader("Authorization") String auth,
                                                                                  @ApiParam("orgId") @RequestParam(name = "orgId") String orgId) throws TaskException;



}
