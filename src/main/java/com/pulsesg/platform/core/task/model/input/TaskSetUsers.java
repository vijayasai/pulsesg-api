package com.pulsesg.platform.core.task.model.input;

import lombok.Data;
import org.springframework.data.annotation.LastModifiedBy;

import java.util.List;

@Data
public class TaskSetUsers {

    @LastModifiedBy
    public String updatedBy;
    public List<String> assignedUsers;
}
