package com.platinumcoin.cache.application.usecase;

import com.platinumcoin.cache.application.domain.Order;
import com.platinumcoin.cache.application.domain.exception.DomainException;
import com.platinumcoin.cache.infrastructure.mapper.OrderMapper;
import com.platinumcoin.cache.infrastructure.persistence.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FindOrderNoCacheUseCase {
    private final OrderRepository repository;

    public Order execute(UUID id) {
        return repository.findById(id)
                .map(OrderMapper::toDomain)
                .orElseThrow(() -> new DomainException("Order not found", "not_found", null));
    }
}