package com.br.poc.elo.adapters.in.api;

import java.math.BigDecimal;

public record OrderRequest(
    Long clientId,
    String description,
    BigDecimal ammount
) {
}
