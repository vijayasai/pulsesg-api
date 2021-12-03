package com.pulsesg.platform.core.task.controller;

import com.pulsesg.platform.core.task.exception.TaskException;
import com.pulsesg.platform.core.task.model.SubMetric;
import com.pulsesg.platform.core.task.model.SubMetricResponse;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Varalakshmi Sravanthi Kavi
 */
@Api(value = "SubMetric", tags = {"SubMetrics"})
@RequestMapping("${main.business.uri}")
public interface SubMetricController {

    // Get SubMertics By ORGID

    @ApiOperation(value = "getSubMetricsList")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "Authorization", required = true, dataType = "string", value = "descr",
                    paramType = "header"),
            @ApiImplicitParam(name = "orgId", required = true, dataType = "string", value = "orgId",
                    paramType = "query")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "-0: Success", response = SubMetricResponse.class)
    })
    @GetMapping("/submetric/search")
    ResponseEntity<SubMetricResponse> retrieveSubMetricsListByOrgId(@ApiParam("Auth") @RequestHeader("Authorization") String auth,
                                                          @ApiParam("orgId") @RequestParam(name = "orgId") String orgId) throws TaskException;

    // CreateSubMetric

    @ApiOperation(value="CreateSubMetric")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name="Authorization", required = true, dataType = "string", value="descr",
                    paramType = "header")
    })
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "-0: Success")
    })
    @PostMapping("/createSubMetric")
    ResponseEntity<Void>  createSubMetric(@ApiParam("Auth") @RequestHeader("Authorization") String auth,
                           @ApiParam(value = "SubMetric data", required = true) @RequestBody SubMetric subMetric) throws TaskException;



}
