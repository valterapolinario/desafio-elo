package com.br.poc.elo.adapters.out.persistence;

import com.br.poc.elo.application.core.domain.OrderDB;
import com.br.poc.elo.application.ports.outgoing.SaveOrderPort;
import com.br.poc.elo.application.ports.outgoing.LoadOrderPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDbRepository implements LoadOrderPort, SaveOrderPort {

    @Autowired
    private SpringDataOrderRepository repository;

    @Override
    public OrderDB createOrder(OrderDB order) {
        return null;
    }

    @Override
    public OrderDB load(Long orderId) {
        return null;
    }
}
