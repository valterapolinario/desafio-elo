package com.br.poc.elo.application.ports.incoming;

import org.springframework.messaging.handler.annotation.Payload;

public interface ReceiveMessageOrderUseCase {
    void processMessage(@Payload Object message);
}
