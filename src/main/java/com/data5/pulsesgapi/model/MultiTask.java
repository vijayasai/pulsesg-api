package com.data5.pulsesgapi.model;

import com.data5.pulsesgapi.model.enums.MetricTypeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.couchbase.core.mapping.Document;

import java.util.List;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MultiTask {

    public List<String> metricIds;
    public List<String> orgIds;
    public MetricTypeEnum metricType;
    public String tenantId;
}
