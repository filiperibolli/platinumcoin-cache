package com.platinumcoin.cache.application.usecase;

import com.platinumcoin.cache.application.domain.Order;
import com.platinumcoin.cache.application.gateway.OrderGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateOrderUseCase {
    private final OrderGateway gateway;
    public Order execute(Order order) {
        if (order.getId() == null) {
            order.setId(UUID.randomUUID());
        }
        return gateway.save(order);
    }
}