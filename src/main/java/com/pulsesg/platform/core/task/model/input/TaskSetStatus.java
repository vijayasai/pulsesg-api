package com.pulsesg.platform.core.task.model.input;

import com.pulsesg.platform.core.task.model.enums.StatusEnum;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedBy;

@Data
public class TaskSetStatus {

    @LastModifiedBy
    public String updatedBy;
    public StatusEnum status;
}
