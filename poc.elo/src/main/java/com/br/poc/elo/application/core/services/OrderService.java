package com.br.poc.elo.application.core.services;

import com.br.poc.elo.adapters.in.api.OrderRequest;
import com.br.poc.elo.adapters.in.api.OrderResponse;
import com.br.poc.elo.adapters.in.mapper.OrderMapper;
import com.br.poc.elo.application.ports.incoming.ConsultOrderUseCase;
import com.br.poc.elo.application.ports.incoming.CreateOrderUseCase;
import com.br.poc.elo.application.ports.outgoing.LoadOrderPort;
import com.br.poc.elo.application.ports.outgoing.SaveOrderPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService implements ConsultOrderUseCase, CreateOrderUseCase {

    @Autowired
    private LoadOrderPort loadPort;

    @Autowired
    private SaveOrderPort savePort;

    @Autowired
    private OrderMapper mapper;
    @Override
    public OrderResponse consultOrder(Long id) {
        return mapper.toResponse(loadPort.load(id));
    }

    @Override
    public Long createOrder(OrderRequest request) {
        return savePort.createOrder(mapper.toModel(request)).getId();
    }
}
