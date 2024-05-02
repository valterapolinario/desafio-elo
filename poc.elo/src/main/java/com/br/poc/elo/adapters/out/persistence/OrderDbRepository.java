package com.br.poc.elo.adapters.out.persistence;

import com.br.poc.elo.application.core.domain.OrderDB;
import com.br.poc.elo.application.ports.outgoing.SaveOrderPort;
import com.br.poc.elo.application.ports.outgoing.LoadOrderPort;
import com.br.poc.elo.application.ports.outgoing.UpdateOrderPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDbRepository implements LoadOrderPort, SaveOrderPort , UpdateOrderPort {

    @Autowired
    private SpringDataOrderRepository repository;

    @Override
    public OrderDB createOrder(OrderDB order) {
        return repository.save(order);
    }

    @Override
    public OrderDB load(String orderId) {
        return repository.findById(orderId).get();
    }

    @Override
    public OrderDB update(OrderDB orderDb) {
        return repository.save(orderDb);
    }
}
