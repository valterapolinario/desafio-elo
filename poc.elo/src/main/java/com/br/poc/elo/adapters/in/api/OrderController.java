package com.br.poc.elo.adapters.in.api;

import com.br.poc.elo.application.ports.incoming.ConsultOrderUseCase;
import com.br.poc.elo.application.ports.incoming.CreateOrderUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    @Autowired
    private CreateOrderUseCase createUseCase;

    @Autowired
    private ConsultOrderUseCase consultUseCase;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new order", description = "Create order", tags = {"Order"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
            })
    })
    public ResponseEntity<String> createOrder(
            @Parameter(description = " new order") @RequestBody OrderRequest request,
            @Parameter(description = "idempotency key", example = "ffc2a683-8f90-4571-98cb-de7e1bc21e2a",
                    required = true, schema = @Schema(implementation = UUID.class)) @RequestHeader(value = "idempotency-key") UUID idempotencyKey){
        return ResponseEntity.ok(createUseCase.createOrder(request));
    }


    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> consultOrder(@PathVariable String id) {
        return ResponseEntity.ok(consultUseCase.consultOrder(id));
    }
}
