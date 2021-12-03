package com.pulsesg.platform.core.task.model.input;

import lombok.Data;
import org.springframework.data.annotation.LastModifiedBy;

@Data
public class TaskSetLockedBy {
    @LastModifiedBy
    public String updatedBy;
    public String lockedBy;
}
