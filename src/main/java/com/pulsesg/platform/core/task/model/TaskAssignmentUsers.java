package com.pulsesg.platform.core.task.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pulsesg.platform.core.task.util.Constants;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.IdPrefix;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.UNIQUE;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskAssignmentUsers {



}
