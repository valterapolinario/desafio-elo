package com.br.poc.elo.application.core.services;

import com.br.poc.elo.application.ports.incoming.ConsultOrderUseCase;
import com.br.poc.elo.application.ports.incoming.CreateOrderUseCase;
import com.br.poc.elo.application.ports.outgoing.LoadOrderPort;
import com.br.poc.elo.application.ports.outgoing.SaveOrderPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class OrderService implements ConsultOrderUseCase, CreateOrderUseCase {

    @Autowired
    private LoadOrderPort loadPort;

    @Autowired
    private SaveOrderPort savePort;
    @Override
    public Object consultOrder(Long id) {
        return null;
    }

    @Override
    public Long createOrder(Object request) {
        return null;
    }
}
