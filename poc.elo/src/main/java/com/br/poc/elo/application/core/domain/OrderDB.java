package com.br.poc.elo.application.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import static com.br.poc.elo.application.core.domain.OrderStatusEnum.AGUARDANDO_ENVIO;

@Document(collection = "pedidos")
@Getter
@Setter
public class OrderDB {
    @Id
    private Long id;

    private String description;


    private Long clientId;

    private OrderStatusEnum status;

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;

    public OrderDB(){
        this.status = AGUARDANDO_ENVIO;
    }
}
