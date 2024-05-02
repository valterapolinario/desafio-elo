package com.br.poc.elo.application.ports.outgoing;
import com.br.poc.elo.application.core.domain.OrderDB;

public interface UpdateOrderPort {
    OrderDB update(OrderDB orderDb);
}
