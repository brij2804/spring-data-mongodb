package com.brijesh.mongodb.inventoryservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "inventory")
public class Inventory {

    @Id
    private Integer id;
    private Long itemNumber;
    private  Double stock;


}
