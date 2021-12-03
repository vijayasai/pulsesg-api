package com.pulsesg.platform.core.task.service;

import com.pulsesg.platform.core.task.exception.TaskException;
import com.pulsesg.platform.core.task.model.SubMetric;
import com.pulsesg.platform.core.task.repository.SubMetricRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Varalakshmi Sravanthi Kavi
 */
@Service
@AllArgsConstructor
public class SubMetricService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubMetricService.class);
    private SubMetricRepository subMetricRepository;

    /**
     * @param orgId String
     * @return List<SubMetric>
     */
    public List<SubMetric> retrieveSubMetricsByOrgId(String orgId) throws TaskException {
        return subMetricRepository.findAllByOrgIdLike("%" + orgId);
    }

    /**
     * @param subMetric SubMetric
     */
    public void saveSubMetric(SubMetric subMetric) throws TaskException {
        subMetricRepository.save(subMetric);
    }


}
