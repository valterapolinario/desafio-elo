package com.br.poc.elo.application.core.domain;

public record OrderMessage(
        String message,

        String orderId
) {
}
