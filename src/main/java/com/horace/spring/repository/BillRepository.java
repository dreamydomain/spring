package com.horace.spring.repository;

import com.horace.spring.model.mongo.Bill;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BillRepository extends MongoRepository<Bill, String> {
    Bill findOneByTitle(String title);
}
