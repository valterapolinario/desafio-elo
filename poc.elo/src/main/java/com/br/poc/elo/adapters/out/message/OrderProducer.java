package com.br.poc.elo.adapters.out.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderProducer {

    @Autowired
    KafkaTemplate<String,Object> template;

    public void sendOrderMessage(String topic,Object messsage){
        template.send(topic,messsage);
    }
}
