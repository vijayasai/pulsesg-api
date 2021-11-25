package com.pulsesg.platform.core.task.controller;

import com.pulsesg.platform.core.task.exception.SubMetricException;
import com.pulsesg.platform.core.task.exception.SubMetricExceptionUtil;
import com.pulsesg.platform.core.task.helper.ResponseHelper;
import com.pulsesg.platform.core.task.helper.SubMetricHelper;
import com.pulsesg.platform.core.task.model.SubMetric;
import com.pulsesg.platform.core.task.model.SubMetricResponse;
import com.pulsesg.platform.core.task.util.Util;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Varalakshmi Sravanthi Kavi
 */
@RestController
@AllArgsConstructor
public class SubMetricControllerImpl implements SubMetricController {

    private static final Logger LOGGER =  LoggerFactory.getLogger(SubMetricControllerImpl.class);
    private SubMetricHelper subMetricHelper;
    private ResponseHelper responseHelper;

    /**
     * @param auth  AuthToken
     * @param orgId String
     * @return ResponseEntity<SubMetricResponse>
     * @throws SubMetricException Exception
     */
    //@HystrixCommand(commandKey = "taskService-addNewTask", threadPoolKey = "taskService-addNewTask", fallbackMethod = "handleRetrieveTasksListByOrgId")
    public ResponseEntity<SubMetricResponse> retrieveSubMetricsListByOrgId(String auth, String orgId) throws SubMetricException {
        LOGGER.info(" ** Start of retrieveSubMetricsListByOrgId orgId {}", orgId);

        SubMetricResponse resp = new SubMetricResponse();
        try {
            List<SubMetric> subMetricList = subMetricHelper.retrieveSubMetricsByOrgId(orgId);
            resp = responseHelper.getSubMetricResponse(subMetricList);
        } catch (Exception e) {
            LOGGER.error("retrieveSubMetric error: {}", e.getMessage());
            SubMetricExceptionUtil.throwAndLogSubMetricExceptions(e);
        }
        return new ResponseEntity<>(resp, Util.getSuccessResponseHeaders(), HttpStatus.OK);
    }

    /**
     * @param auth AuthToken
     * @param subMetric SubMetric
     * @return void
     * @throws SubMetricException Exception
     */
    public ResponseEntity<Void> createSubMetric(String auth, SubMetric subMetric) throws SubMetricException {
        LOGGER.info(" ** Start of createSuMetric ");
        try {
            subMetricHelper.createNewSubMetric(subMetric);
        } catch (Exception e) {
            LOGGER.error("createSubMetric error: {}", e.getMessage());
            SubMetricExceptionUtil.throwAndLogSubMetricExceptions(e);
        }
        return new ResponseEntity<>(Util.getSuccessResponseHeaders(), HttpStatus.OK);
    }




}
