package com.pulsesg.platform.core.task.service;

import com.pulsesg.platform.core.task.exception.TaskException;
import com.pulsesg.platform.core.task.model.SubmittedMetrics;
import com.pulsesg.platform.core.task.repository.SubmittedMetricsRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Vijayasai Kesanupalli
 */
@Service
@AllArgsConstructor
public class SubmittedMetricsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubmittedMetricsService.class);
    private SubmittedMetricsRepository repository;

    /**
     * @param cycleId int
     * @param orgId String
     * @return List<SubmittedMetrics>
     * @throws TaskException exception
     *
     * below method to retrieve SubmittedMetrics List by cycleId & orgId from generateddata, masterdata buckets
     */
    public List<SubmittedMetrics> getTasksSubmittedMetricsByCycleIdOrgId(int cycleId, String orgId) throws TaskException {
        return repository.listTaskSubmittedMetricsByCycleIdOrgId(cycleId, "%" + orgId);
    }

    /**
     * @param orgId String
     * @return List<SubmittedMetrics>
     * @throws TaskException exception
     *
     * below method to retrieve SubmittedMetrics List by cycleId & orgId from generateddata, masterdata buckets
     */
    public SubmittedMetrics getAggregateTasksByOrdId(String orgId) throws TaskException {
        return repository.aggregateTasksByOrdId("%" + orgId);
    }


    /**
     * @param cycleId int
     * @return List<SubmittedMetrics>
     * @throws TaskException exception
     *
     * below method to retrieve SubmittedMetrics List by cycleId & orgId from generateddata, masterdata buckets
     */
    public List<SubmittedMetrics> getTasksSubmittedMetricsByCycleId(int cycleId) throws TaskException {
        return repository.listTaskSubmittedMetricsByCycleId(cycleId);
    }

    /**
     * @param orgId String
     * @return List<SubmittedMetrics>
     * @throws TaskException exception
     *
     * below method to retrieve SubmittedMetrics List by cycleId & orgId from generateddata, masterdata buckets
     */
    public List<SubmittedMetrics> getTasksSubmittedMetricsByOrgId(String orgId) throws TaskException {
        return repository.listTaskSubmittedMetricsByOrgId("%" + orgId);
    }


}
