package com.platinumcoin.cache.application.usecase;

import com.platinumcoin.cache.application.domain.Order;
import com.platinumcoin.cache.application.domain.exception.DomainException;
import com.platinumcoin.cache.application.gateway.OrderGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindOrderUseCase {
    private final OrderGateway gateway;

    public Order execute(UUID id) {
        return gateway.findById(id)
                .orElseThrow(() -> new DomainException("Order not found", "not_found", null));
    }
}