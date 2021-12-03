package com.pulsesg.platform.core.task.controller;

import com.pulsesg.platform.core.task.exception.TaskException;
import com.pulsesg.platform.core.task.exception.TaskExceptionUtil;
import com.pulsesg.platform.core.task.helper.SubmittedMetricsHelper;
import com.pulsesg.platform.core.task.helper.TaskHelper;
import com.pulsesg.platform.core.task.model.SubmittedMetrics;
import com.pulsesg.platform.core.task.model.Task;
import com.pulsesg.platform.core.task.util.Util;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vijayasai Kesanupalli
 */
@RestController
@AllArgsConstructor
public class SubmittedMetricsControllerImpl implements SubmittedMetricsController {

    private static final Logger LOGGER =  LoggerFactory.getLogger(SubmittedMetricsControllerImpl.class);
    private SubmittedMetricsHelper submittedMetricsHelper;


    /**
     *
     * @param auth String
     * @param orgId String
     * @param cycleId int
     * @return ResponseEntity<List<SubmittedMetrics>>  List<SubmittedMetrics>
     * @throws TaskException Exception
     */
    @Override
    public ResponseEntity<List<SubmittedMetrics>> listTaskSubmittedMetricsByCycleIdOrgId(String auth, int cycleId, String orgId) throws TaskException {
        LOGGER.info(" ** Start of listTaskSubmittedMetricsByCycleIdOrgId ");
        List<SubmittedMetrics> resp = new ArrayList<>();
        try {
            resp = submittedMetricsHelper.getTasksSubmittedMetricsByCycleIdOrgId(cycleId, orgId);
        } catch (Exception e) {
            LOGGER.error("listTaskSubmittedMetricsByCycleIdOrgId error: {}", e.getMessage());
            TaskExceptionUtil.throwAndLogTaskExceptions(e);
        }
        return new ResponseEntity<>(resp, Util.getSuccessResponseHeaders(), HttpStatus.OK);
    }

    /**
     *
     * @param auth String
     * @param orgId String
     * return ResponseEntity<<SubmittedMetrics>  SubmittedMetrics
     * @throws TaskException Exception
     */
    @Override
    public ResponseEntity<SubmittedMetrics> aggregateTasksByOrdId(String auth, String orgId) throws TaskException {
        LOGGER.info(" ** Start of aggregateTasksByOrdId ");
        SubmittedMetrics resp = new SubmittedMetrics();
        try {
            resp = submittedMetricsHelper.getAggregateTasksByOrdId(orgId);
        } catch (Exception e) {
            LOGGER.error("aggregateTasksByOrdId error: {}", e.getMessage());
            TaskExceptionUtil.throwAndLogTaskExceptions(e);
        }
        return new ResponseEntity<>(resp, Util.getSuccessResponseHeaders(), HttpStatus.OK);
    }

    /**
     *
     * @param auth String
     * @param cycleId int
     * @return ResponseEntity<List<SubmittedMetrics>>  List<SubmittedMetrics>
     * @throws TaskException Exception
     */
    @Override
    public ResponseEntity<List<SubmittedMetrics>> listTaskSubmittedMetricsByCycleId(String auth, int cycleId) throws TaskException {
        LOGGER.info(" ** Start of listTaskSubmittedMetricsByCycleId ");
        List<SubmittedMetrics> resp = new ArrayList<>();
        try {
            resp = submittedMetricsHelper.getTasksSubmittedMetricsByCycleId(cycleId);
        } catch (Exception e) {
            LOGGER.error("listTaskSubmittedMetricsByCycleId error: {}", e.getMessage());
            TaskExceptionUtil.throwAndLogTaskExceptions(e);
        }
        return new ResponseEntity<>(resp, Util.getSuccessResponseHeaders(), HttpStatus.OK);
    }

    /**
     *
     * @param auth String
     * @param orgId String
     * return ResponseEntity<<SubmittedMetrics>  SubmittedMetrics
     * @throws TaskException Exception
     */
    @Override
    public ResponseEntity<List<SubmittedMetrics>> listTaskSubmittedMetricsByOrgId(String auth, String orgId) throws TaskException {
        LOGGER.info(" ** Start of listTaskSubmittedMetricsByOrgId ");
        List<SubmittedMetrics> resp = new ArrayList<>();
        try {
            resp = submittedMetricsHelper.getTasksSubmittedMetricsByCycleIdOrgId(orgId);
        } catch (Exception e) {
            LOGGER.error("listTaskSubmittedMetricsByOrgId error: {}", e.getMessage());
            TaskExceptionUtil.throwAndLogTaskExceptions(e);
        }
        return new ResponseEntity<>(resp, Util.getSuccessResponseHeaders(), HttpStatus.OK);
    }
}
