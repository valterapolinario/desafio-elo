package com.br.poc.elo.application.core.services;
import com.br.poc.elo.adapters.out.message.OrderProducer;
import com.br.poc.elo.application.ports.outgoing.OutMessageOrderPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService implements OutMessageOrderPort{
    @Autowired
    OrderProducer orderProducer;

    @Override
    public void sendMessage(Object message, String topic) {
        orderProducer.sendOrderMessage(topic,message);
    }
}
