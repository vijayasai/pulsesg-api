package com.data5.pulsesgapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String tagLine;
}
