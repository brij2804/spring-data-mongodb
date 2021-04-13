package com.brijesh.mongodb.inventoryservice.repository;

import com.brijesh.mongodb.inventoryservice.entity.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory,Integer> {
}
