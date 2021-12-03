package com.pulsesg.platform.core.task.model.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class SubmittedMetricsGetByCycleId {
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT, pattern = "YYYYMM,d")
    public int cycleId;
}
