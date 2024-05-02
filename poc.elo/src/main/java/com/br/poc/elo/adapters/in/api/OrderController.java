package com.br.poc.elo.adapters.in.api;

import com.br.poc.elo.application.ports.incoming.ConsultOrderUseCase;
import com.br.poc.elo.application.ports.incoming.CreateOrderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    @Autowired
    private CreateOrderUseCase createUseCase;

    @Autowired
    private ConsultOrderUseCase consultUseCase;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest request) {
        return ResponseEntity.ok(createUseCase.createOrder(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> consultOrder(@PathVariable String id) {
        return ResponseEntity.ok(consultUseCase.consultOrder(id));
    }
}
