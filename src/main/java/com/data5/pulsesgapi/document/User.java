package com.data5.pulsesgapi.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
@Data
public class User {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String tagLine;
}
