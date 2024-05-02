package com.br.poc.elo.application.ports.incoming;

import com.br.poc.elo.adapters.in.api.OrderResponse;

public interface ConsultOrderUseCase {
    OrderResponse consultOrder(Long id);
}
