package com.br.poc.elo.application.core.services;

import com.br.poc.elo.adapters.in.api.OrderRequest;
import com.br.poc.elo.adapters.in.api.OrderResponse;
import com.br.poc.elo.application.core.domain.OrderDB;
import com.br.poc.elo.application.core.domain.OrderMessage;
import com.br.poc.elo.application.ports.incoming.ConsultOrderUseCase;
import com.br.poc.elo.application.ports.incoming.CreateOrderUseCase;
import com.br.poc.elo.application.ports.incoming.ProcessOrderMessageUseCase;
import com.br.poc.elo.application.ports.outgoing.LoadOrderPort;
import com.br.poc.elo.application.ports.outgoing.OutMessageOrderPort;
import com.br.poc.elo.application.ports.outgoing.SaveOrderPort;
import com.br.poc.elo.application.ports.outgoing.UpdateOrderPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService implements ConsultOrderUseCase, CreateOrderUseCase, ProcessOrderMessageUseCase {

    public static final String NEW_ORDER_MESSAGE = "novo pedido efetuado";
    @Autowired
    private LoadOrderPort loadPort;

    @Autowired
    private SaveOrderPort savePort;

    @Autowired
    private OutMessageOrderPort messageOrderPort;

    @Autowired
    private UpdateOrderPort updatePort;

    @Value("${app.kafka.topics.order.transportadora}")
    private String transferTopic;

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
    @Transactional
    public String createOrder(OrderRequest request) {
//        return savePort.createOrder(mapper.toModel(request));

        OrderDB orderDB = new OrderDB();
        orderDB.setAmount(request.ammount());
        orderDB.setDescription(request.description());
        orderDB.setClientId(request.clientId());
        orderDB = savePort.createOrder(orderDB);

        sendToQueue(transferTopic, new OrderMessage(NEW_ORDER_MESSAGE,orderDB.getId()));
        return orderDB.getId();
    }

    @Async
    private void sendToQueue(String topic, OrderMessage message) {
        messageOrderPort.sendMessage(message,topic);
    }

    @Override
    @Transactional
    public void processOrder(OrderMessage message) {
        OrderDB order = loadPort.load(message.orderId());
        order.updateToSent();
        updatePort.update(order);
    }
}
