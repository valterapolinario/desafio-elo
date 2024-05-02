package com.br.poc.elo.adapters.in.message;

import com.br.poc.elo.application.core.domain.OrderDB;
import com.br.poc.elo.application.core.domain.OrderMessage;
import com.br.poc.elo.application.ports.incoming.ProcessOrderMessageUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    @Value("${app.kafka.topics.order.transportadora}")
    private String transferTopic;

    @Autowired
    private ProcessOrderMessageUseCase processOrderUseCase;


    @KafkaListener(groupId = "${app.kafka.topics.order.groupId}",topics = "${app.kafka.topics.order.transportadora}")
    public void processOrder(@Payload OrderMessage message, Acknowledgment acknowledgment){
        process(message);
        acknowledgment.acknowledge();
    }

    private void process(OrderMessage message) {
        processOrderUseCase.processOrder(message);
    }
}
