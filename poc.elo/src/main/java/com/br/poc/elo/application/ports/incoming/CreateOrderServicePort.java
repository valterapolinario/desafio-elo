package com.br.poc.elo.application.ports.incoming;

import com.br.poc.elo.application.core.domain.Order;

public interface CreateOrderServicePort {
    Order createOrder(Order order);
}
