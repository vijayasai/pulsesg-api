package com.pulsesg.platform.core.task.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubmittedMetrics {

    public String topicId;
    public String topicName;
    public String metricId;
    public String description;
    public String metricType;
    public String instruction;
    public String orgId;
    public String tenantId;
    public String status;
    public List<String> metricValues;
    public String metricValue;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT, pattern = "YYYYMM,d")
    public int cycleId;
    public String categoryId;
    public String categoryName;
    public String fundId;
    public String fundName;
    public String orgName;
}
