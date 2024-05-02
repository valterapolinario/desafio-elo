package com.br.poc.elo.adapters.in.api;

import com.br.poc.elo.application.ports.incoming.ConsultOrderUseCase;
import com.br.poc.elo.application.ports.incoming.CreateOrderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    @Autowired
    private CreateOrderUseCase createUseCase;

    @Autowired
    private ConsultOrderUseCase consultUseCase;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Long> createOrder(OrderRequest request) {
        return ResponseEntity.ok(createUseCase.createOrder(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> consultOrder(Long id) {
        return ResponseEntity.ok(consultUseCase.consultOrder(id));
    }
}
