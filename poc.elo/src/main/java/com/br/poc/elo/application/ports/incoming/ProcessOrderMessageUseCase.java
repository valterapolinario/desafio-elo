package com.br.poc.elo.application.ports.incoming;

import com.br.poc.elo.application.core.domain.OrderDB;
import com.br.poc.elo.application.core.domain.OrderMessage;

public interface ProcessOrderMessageUseCase {
    void processOrder(OrderMessage message);
}
