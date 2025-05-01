package com.platinumcoin.cache.application.gateway;

import com.platinumcoin.cache.application.domain.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderGateway {
    Order save(Order order);
    Optional<Order> findById(UUID id);
}
