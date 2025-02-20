package com.br.poc.elo.adapters.in.mapper;

import com.br.poc.elo.adapters.in.api.OrderRequest;
import com.br.poc.elo.adapters.in.api.OrderResponse;
import com.br.poc.elo.application.core.domain.OrderDB;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-05T17:16:26-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Azul Systems, Inc.)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDB toModel(OrderRequest request) {
        if ( request == null ) {
            return null;
        }

        OrderDB orderDB = new OrderDB();

        return orderDB;
    }

    @Override
    public OrderResponse toResponse(OrderDB orderDB) {
        if ( orderDB == null ) {
            return null;
        }

        String status = null;

        OrderResponse orderResponse = new OrderResponse( status );

        return orderResponse;
    }
}
