package com.br.poc.elo.application.core.domain;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {

    AGUARDANDO_ENVIO("AGUARDANDO_ENVIO"),
    ENVIADO_TRASNPORTADORA("ENVIADO_TRASNPORTADORA");

    private String description;
    
    private OrderStatusEnum(String description) {
        this.description = description;
    }
 
    
}
