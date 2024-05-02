package com.br.poc.elo.adapters.in.mapper;

import com.br.poc.elo.adapters.in.api.OrderRequest;
import com.br.poc.elo.adapters.in.api.OrderResponse;
import com.br.poc.elo.application.core.domain.OrderDB;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.FIELD)
public interface OrderMapper {

    OrderDB toModel(OrderRequest request);

    OrderResponse toResponse(OrderDB orderDB);
}
