package com.br.poc.elo.application.core.domain;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Document(collection = "pedidos")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    private Long id;

    private String description;

    private String addres;

    private String client;

    private OrderStatusEnum status;


    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;


}
