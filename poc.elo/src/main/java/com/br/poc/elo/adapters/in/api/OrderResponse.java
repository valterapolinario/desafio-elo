package com.br.poc.elo.adapters.in.api;

public record OrderResponse(
    Long clientId,
    String status,
    String id
) {
    
}
