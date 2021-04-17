package com.brijesh.mongodb.customerservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "counter")
public class Counter {
    @Id
    private Long id;
}
