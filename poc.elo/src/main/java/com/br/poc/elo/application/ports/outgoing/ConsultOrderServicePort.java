package com.br.poc.elo.application.ports.outgoing;

import com.br.poc.elo.application.core.domain.Order;

public interface ConsultOrderServicePort {
    Order consultOrder(Long orderId);
}
