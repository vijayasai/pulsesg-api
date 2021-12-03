package com.pulsesg.platform.core.task.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pulsesg.platform.core.task.model.jsonpattern.InstantCustomDeserializer;
import com.pulsesg.platform.core.task.model.jsonpattern.InstantCustomSerializer;
import com.pulsesg.platform.core.task.util.Constants;
import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.IdPrefix;

import java.time.Instant;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.UNIQUE;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubMetric {

    public static final String PREFIX = "SubmittedMetric";

    @SuppressWarnings("unused")
    @IdPrefix
    private String prefix = PREFIX;

    @Id
    @GeneratedValue(strategy = UNIQUE, delimiter = Constants.ID_DELIMITER)
    public String _id;
    public String _type;
    public String metricid;
    public String description;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT, pattern = "YYYYMM,d")
    public int cycleId;
    public String orgId;
    public String tenantId;
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
    public String metricValue;

}
