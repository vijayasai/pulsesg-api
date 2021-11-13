package com.data5.pulsesgapi.model;

import com.data5.pulsesgapi.model.enums.MetricTypeEnum;
import com.data5.pulsesgapi.model.enums.StatusEnum;
import com.data5.pulsesgapi.model.jsonpattern.InstantCustomDeserializer;
import com.data5.pulsesgapi.model.jsonpattern.InstantCustomSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.IdPrefix;

import java.time.Instant;
import java.util.List;

import static com.data5.pulsesgapi.util.Constants.ID_DELIMITER;
import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.UNIQUE;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Task {
    public static final String PREFIX = "standard";

    @SuppressWarnings("unused")
    @IdPrefix
    private String prefix = PREFIX;

    @Id
    @GeneratedValue(strategy = UNIQUE, delimiter = ID_DELIMITER)
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
    public String createdBy;
    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone = "UTC")
    //@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "UTC")
    @JsonDeserialize(using = InstantCustomDeserializer.class)
    @JsonSerialize(using = InstantCustomSerializer.class)
    public Instant createdDate;
    public String updatedBy;
    @JsonDeserialize(using = InstantCustomDeserializer.class)
    @JsonSerialize(using = InstantCustomSerializer.class)
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
