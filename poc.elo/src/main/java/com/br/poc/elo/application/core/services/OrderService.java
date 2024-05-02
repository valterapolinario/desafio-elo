package com.br.poc.elo.application.core.services;

import com.br.poc.elo.adapters.in.api.OrderRequest;
import com.br.poc.elo.adapters.in.api.OrderResponse;
import com.br.poc.elo.application.core.domain.OrderDB;
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

//    @Autowired
//    private OrderMapper mapper;

    @Override
    public OrderResponse consultOrder(String id) {
        OrderDB result = loadPort.load(id);
        return new OrderResponse(
                result.getClientId(),
                result.getStatus().name(),
                result.getId()
        );
    }

    @Override
    public String createOrder(OrderRequest request) {
//        return savePort.createOrder(mapper.toModel(request));

        OrderDB orderDB = new OrderDB();
        orderDB.setAmount(request.ammount());
        orderDB.setDescription(request.description());
        orderDB.setClientId(request.clientId());
        return savePort.createOrder(orderDB).getId();
    }
}
