package com.br.poc.elo.adapters.out.persistence;

import com.br.poc.elo.application.core.domain.OrderDB;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringDataOrderRepository extends MongoRepository<OrderDB,String> {
}
