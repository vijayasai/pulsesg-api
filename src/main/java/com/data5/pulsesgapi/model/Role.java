package com.data5.pulsesgapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Role {

    @Id
    private String id;
    private String name;
    private String description;

}
