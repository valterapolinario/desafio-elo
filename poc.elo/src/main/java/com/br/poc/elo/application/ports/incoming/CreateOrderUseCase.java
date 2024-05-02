package com.br.poc.elo.application.ports.incoming;

import com.br.poc.elo.adapters.in.api.OrderRequest;

public interface CreateOrderUseCase {

    Long createOrder(OrderRequest request);
}
