package com.br.poc.elo.application.ports.outgoing;

import com.br.poc.elo.application.core.domain.OrderDB;

public interface SaveOrderPort {
    OrderDB createOrder(OrderDB order);
}
