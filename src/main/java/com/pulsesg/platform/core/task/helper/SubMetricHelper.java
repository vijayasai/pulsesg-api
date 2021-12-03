package com.pulsesg.platform.core.task.helper;

import com.pulsesg.platform.core.task.exception.TaskException;
import com.pulsesg.platform.core.task.model.SubMetric;
import com.pulsesg.platform.core.task.service.SubMetricService;
import com.pulsesg.platform.core.task.util.Util;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Varalakshmi Sravanthi Kavi
 */

@Component
@AllArgsConstructor
public class SubMetricHelper {

    private static final Logger LOGGER =  LoggerFactory.getLogger(SubMetricHelper.class);
    private CommonHelper commonHelper;
    private SubMetricService subMetricService;

    /**
     * @param subMetric SubMetric
     * @throws TaskException exception
     *
     * below method to create subMetric
     */
    public void createNewSubMetric(SubMetric subMetric) throws TaskException {
        subMetric.setCreatedDate(Util.getCurrentDataTimeInstant());
        subMetric.setUpdatedDate(Util.getCurrentDataTimeInstant());
        subMetric.setUpdatedBy("Vijay");
        if(subMetric.getCycleId() == 0){
            subMetric.setCycleId(Integer.parseInt(Util.getCurrentYYYYMMString()));
        }
        subMetricService.saveSubMetric(subMetric);
    }

    /**
     * @param orgId String
     * @return List<SubMetric>
     * @throws TaskException exception
     *
     * below method to retrieve subMetricsList by orgId
     */
    public List<SubMetric> retrieveSubMetricsByOrgId(String orgId) throws TaskException {
        return subMetricService.retrieveSubMetricsByOrgId(orgId);
    }


}
