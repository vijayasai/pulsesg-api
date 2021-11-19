package com.pulsesg.platform.core.task.model;

import com.pulsesg.platform.core.task.model.enums.MetricTypeEnum;
import com.pulsesg.platform.core.task.model.enums.StatusEnum;
import com.pulsesg.platform.core.task.model.jsonpattern.InstantCustomDeserializer;
import com.pulsesg.platform.core.task.model.jsonpattern.InstantCustomSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pulsesg.platform.core.task.util.Constants;
import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.IdPrefix;

import java.time.Instant;
import java.util.List;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.UNIQUE;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Task {

    public static final String PREFIX = "Task";

    @SuppressWarnings("unused")
    @IdPrefix
    private String prefix = PREFIX;

    @Id
    @GeneratedValue(strategy = UNIQUE, delimiter = Constants.ID_DELIMITER)
    public String _id;
    public String _type;
    public StatusEnum status;
    public String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYYMM,d")
    public int cycleId;
    public String orgId;
    public String tenantId;
    public List<String> metricIds;
    public MetricTypeEnum metricType;
    public List<String> assignedUsers;
    public List<String> assignedRoles;
    public String lockedBy;
    @JsonDeserialize(using = InstantCustomDeserializer.class)
    @JsonSerialize(using = InstantCustomSerializer.class)
    public Instant lockedDate;
    @JsonDeserialize(using = InstantCustomDeserializer.class)
    @JsonSerialize(using = InstantCustomSerializer.class)
    public Instant expectedDate;
    @CreatedBy
    public String createdBy;
    @JsonDeserialize(using = InstantCustomDeserializer.class)
    @JsonSerialize(using = InstantCustomSerializer.class)
    @CreatedDate
    public Instant createdDate;
    @LastModifiedBy
    public String updatedBy;
    @JsonDeserialize(using = InstantCustomDeserializer.class)
    @JsonSerialize(using = InstantCustomSerializer.class)
    @LastModifiedDate
    public Instant updatedDate;
    public boolean isActive;
    public String approval_status;
    public String approvedBy;
    public List<String> approvalAssignedUsers;
    public List<String> approvalAssignedRoles;
    public String approval_comment;
    public List<String> notifyUsers;
    public String link;

}
