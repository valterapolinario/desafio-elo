package com.br.poc.elo.application.core.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static com.br.poc.elo.application.core.domain.OrderStatusEnum.AGUARDANDO_ENVIO;
import static com.br.poc.elo.application.core.domain.OrderStatusEnum.ENVIADO_TRASNPORTADORA;

@Document(collection = "pedidos")
@Getter
@Setter
@ToString
public class OrderDB implements Serializable {
    @Id
    private String id;

    private String description;

    private Long clientId;

    private OrderStatusEnum status;

    private BigDecimal amount;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;

    public OrderDB(){
        this.status = AGUARDANDO_ENVIO;
        this.createdDate = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"))
                .truncatedTo(ChronoUnit.SECONDS);
    }

    public void updateToSent() {
        this.status = ENVIADO_TRASNPORTADORA;
        this.updatedDate = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"))
                .truncatedTo(ChronoUnit.SECONDS);
    }

}
