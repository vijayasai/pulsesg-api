package com.pulsesg.platform.core.task.helper;

import com.pulsesg.platform.core.task.exception.TaskException;
import com.pulsesg.platform.core.task.model.SubmittedMetrics;
import com.pulsesg.platform.core.task.service.SubmittedMetricsService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Vijayasai Kesanupalli
 */

@Component
@AllArgsConstructor
public class SubmittedMetricsHelper {

    private static final Logger LOGGER =  LoggerFactory.getLogger(SubmittedMetricsHelper.class);
    private SubmittedMetricsService submittedMetricsService;


    /**
     * @param cycleId int
     * @param orgId String
     * @return List<SubmittedMetrics>
     * @throws TaskException exception
     *
     * below method to retrieve SubmittedMetrics List by cycleId & orgId from generateddata, masterdata buckets
     */
    public List<SubmittedMetrics> getTasksSubmittedMetricsByCycleIdOrgId(int cycleId, String orgId) throws TaskException {
        return submittedMetricsService.getTasksSubmittedMetricsByCycleIdOrgId(cycleId, orgId);
    }

    /**
     * @param orgId String
     * @return SubmittedMetrics
     * @throws TaskException exception
     *
     * below method to retrieve SubmittedMetrics by orgId from generateddata, masterdata buckets
     */
    public SubmittedMetrics getAggregateTasksByOrdId(String orgId) throws TaskException {
        return submittedMetricsService.getAggregateTasksByOrdId(orgId);
    }

    /**
     * @param cycleId int
     * @return List<SubmittedMetrics>
     * @throws TaskException exception
     *
     * below method to retrieve SubmittedMetrics List by cycleIdfrom generateddata, masterdata buckets
     */
    public List<SubmittedMetrics> getTasksSubmittedMetricsByCycleId(int cycleId) throws TaskException {
        return submittedMetricsService.getTasksSubmittedMetricsByCycleId(cycleId);
    }

    /**
     * @param orgId String
     * @return List<SubmittedMetrics>
     * @throws TaskException exception
     *
     * below method to retrieve SubmittedMetrics by orgId from generateddata, masterdata buckets
     */
    public List<SubmittedMetrics> getTasksSubmittedMetricsByCycleIdOrgId(String orgId) throws TaskException {
        return submittedMetricsService.getTasksSubmittedMetricsByOrgId(orgId);
    }
}
